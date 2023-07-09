package jdos.cpu;

import jdos.cpu.core_normal.Prefix_helpers;
import jdos.hardware.IO;
import jdos.hardware.Memory;
import jdos.misc.Log;
import jdos.types.LogSeverities;
import jdos.types.LogTypes;

public class StringOp extends Prefix_helpers {
    static public final int R_OUTSB=1;
    static public final int R_OUTSW=2;
    static public final int R_OUTSD=3;
    static public final int R_INSB=4;
    static public final int R_INSW=5;
    static public final int R_INSD=6;
    static public final int R_MOVSB=7;
    static public final int R_MOVSW=8;
    static public final int R_MOVSD=9;
    static public final int R_LODSB=10;
    static public final int R_LODSW=11;
    static public final int R_LODSD=12;
    static public final int R_STOSB=13;
    static public final int R_STOSW=14;
    static public final int R_STOSD=15;
    static public final int R_SCASB=16;
    static public final int R_SCASW=17;
    static public final int R_SCASD=18;
    static public final int R_CMPSB=19;
    static public final int R_CMPSW=20;
    static public final int R_CMPSD=21;

    //#define LoadD(_BLAH) _BLAH

    static protected void DoString(int type) {
        DoString(prefixes, type);
    }

    static public int inString = 0;

    static public void DoString(int prefixes, int type) {
        try {
            inString++;
            if ((prefixes & PREFIX_ADDR)==0)
                DoString16(prefixes, type);
             else
                DoString32(prefixes, type);
        } finally {
            inString--;
        }
    }

    static public void DoString16(int prefixes, int type) {
        /*PhysPt*/int  si_base;
        int di_base;
        /*Bitu*/long	count;
        /*Bits*/int	add_index;

        si_base=base_ds;
        di_base=CPU_Regs.reg_esPhys.dword;
        count=reg_ecx.word();
        if ((prefixes & PREFIX_REP)==0) {
            count=1;
        } else {
            CPU.CPU_Cycles++;
            /* Calculate amount of ops to do before cycles run out */
        }
        add_index=CPU.cpu.direction;
        if (count!=0) switch (type) {
        case R_OUTSB:
            for (;count>0;count--) {
                IO.IO_WriteB(reg_edx.word(), Memory.mem_readb(si_base+reg_esi.word()));
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_OUTSW:
            add_index<<=1;
            for (;count>0;count--) {
                IO.IO_WriteW(reg_edx.word(),Memory.mem_readw(si_base+reg_esi.word()));
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_OUTSD:
            add_index<<=2;
            for (;count>0;count--) {
                IO.IO_WriteD(reg_edx.word(),Memory.mem_readd(si_base + reg_esi.word()));
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_INSB:
            for (;count>0;count--) {
                Memory.mem_writeb(di_base+reg_edi.word(),IO.IO_ReadB(reg_edx.word()));
                reg_edi.word(reg_edi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_INSW:
            add_index<<=1;
            for (;count>0;count--) {
                Memory.mem_writew(di_base+reg_edi.word(),IO.IO_ReadW(reg_edx.word()));
                reg_edi.word(reg_edi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_INSD:
            add_index<<=2;
            for (;count>0;count--) {
                Memory.mem_writed(di_base+reg_edi.word(),IO.IO_ReadD(reg_edx.word()));
                reg_edi.word(reg_edi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_STOSB:
            for (;count>0;count--) {
                Memory.mem_writeb(di_base+reg_edi.word(),reg_eax.low());
                reg_edi.word(reg_edi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_STOSW:
            add_index<<=1;
            for (;count>0;count--) {
                Memory.mem_writew(di_base+reg_edi.word(),reg_eax.word());
                reg_edi.word(reg_edi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_STOSD:
            add_index<<=2;
            for (;count>0;count--) {
                Memory.mem_writed(di_base+reg_edi.word(),reg_eax.dword);
                reg_edi.word(reg_edi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_MOVSB:
            for (;count>0;count--) {
                Memory.mem_writeb(di_base+reg_edi.word(),Memory.mem_readb(si_base+reg_esi.word()));
                reg_edi.word(reg_edi.word()+add_index);
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_MOVSW:
            add_index<<=1;
            for (;count>0;count--) {
                Memory.mem_writew(di_base+reg_edi.word(),Memory.mem_readw(si_base+reg_esi.word()));
                reg_edi.word(reg_edi.word()+add_index);
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_MOVSD:
            add_index<<=2;
            for (;count>0;count--) {
                Memory.mem_writed(di_base+reg_edi.word(),Memory.mem_readd(si_base + reg_esi.word()));
                reg_edi.word(reg_edi.word()+add_index);
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_LODSB:
            for (;count>0;count--) {
                reg_eax.low(Memory.mem_readb(si_base+reg_esi.word()));
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_LODSW:
            add_index<<=1;
            for (;count>0;count--) {
                reg_eax.word(Memory.mem_readw(si_base+reg_esi.word()));
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_LODSD:
            add_index<<=2;
            for (;count>0;count--) {
                reg_eax.dword=Memory.mem_readd(si_base + reg_esi.word());
                reg_esi.word(reg_esi.word()+add_index);
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
            }
            break;
        case R_SCASB:
            {
                /*Bit8u*/int val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val2=Memory.mem_readb(di_base+reg_edi.word());
                    reg_edi.word(reg_edi.word()+add_index);
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
                    if ((reg_eax.low()==val2)!=rep_zero) break;
                }
                CMPB(val2,reg_eax.low());
            }
            break;
        case R_SCASW:
            {
                add_index<<=1;/*Bit16u*/int val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val2=Memory.mem_readw(di_base+reg_edi.word());
                    reg_edi.word(reg_edi.word()+add_index);
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
                    if ((reg_eax.word()==val2)!=rep_zero) break;
                }
                CMPW(val2,reg_eax.word());
            }
            break;
        case R_SCASD:
            {
                add_index<<=2;/*Bit32u*/int val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val2=Memory.mem_readd(di_base + reg_edi.word());
                    reg_edi.word(reg_edi.word()+add_index);
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
                    if ((reg_eax.dword==val2)!=rep_zero) break;
                }
                CMPD(val2,reg_eax.dword);
            }
            break;
        case R_CMPSB:
            {
                /*Bit8u*/int val1=0,val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val1=Memory.mem_readb(si_base+reg_esi.word());
                    val2=Memory.mem_readb(di_base+reg_edi.word());
                    reg_esi.word(reg_esi.word()+add_index);
                    reg_edi.word(reg_edi.word()+add_index);
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
                    if ((val1==val2)!=rep_zero) break;
                }
                CMPB(val2,val1);
            }
            break;
        case R_CMPSW:
            {
                add_index<<=1;/*Bit16u*/int val1=0,val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val1=Memory.mem_readw(si_base+reg_esi.word());
                    val2=Memory.mem_readw(di_base+reg_edi.word());
                    reg_esi.word(reg_esi.word()+add_index);
                    reg_edi.word(reg_edi.word()+add_index);
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
                    if ((val1==val2)!=rep_zero) break;
                }
                CMPW(val2,val1);
            }
            break;
        case R_CMPSD:
            {
                add_index<<=2;/*Bit32u*/int val1=0,val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val1=Memory.mem_readd(si_base + reg_esi.word());
                    val2=Memory.mem_readd(di_base + reg_edi.word());
                    reg_esi.word(reg_esi.word()+add_index);
                    reg_edi.word(reg_edi.word()+add_index);
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.word_dec();
                    if ((val1==val2)!=rep_zero) break;
                }
                CMPD(val2,val1);
            }
            break;
        default:
            Log.log(LogTypes.LOG_CPU, LogSeverities.LOG_ERROR,"Unhandled string op "+type);
            Log.exit("Unhandled string op "+type);
        }
    }

    static public void DoString32(int prefixes, int type) {
        /*PhysPt*/int  si_base;
        int di_base;
        /*Bitu*/long	count;
        /*Bits*/int	add_index;

        si_base=base_ds;
        di_base=CPU_Regs.reg_esPhys.dword;
        count=reg_ecx.dword & 0xFFFFFFFFL;
        if ((prefixes & PREFIX_REP)==0) {
            count=1;
        } else {
            CPU.CPU_Cycles++;
            /* Calculate amount of ops to do before cycles run out */
        }
        add_index=CPU.cpu.direction;
        if (count!=0) switch (type) {
        case R_OUTSB:
            for (;count>0;count--) {
                IO.IO_WriteB(reg_edx.word(), Memory.mem_readb(si_base+reg_esi.dword));
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_OUTSW:
            add_index<<=1;
            for (;count>0;count--) {
                IO.IO_WriteW(reg_edx.word(),Memory.mem_readw(si_base+reg_esi.dword));
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_OUTSD:
            add_index<<=2;
            for (;count>0;count--) {
                IO.IO_WriteD(reg_edx.word(),Memory.mem_readd(si_base + reg_esi.dword));
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_INSB:
            for (;count>0;count--) {
                Memory.mem_writeb(di_base+reg_edi.dword,IO.IO_ReadB(reg_edx.word()));
                reg_edi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_INSW:
            add_index<<=1;
            for (;count>0;count--) {
                Memory.mem_writew(di_base+reg_edi.dword,IO.IO_ReadW(reg_edx.word()));
                reg_edi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_INSD:
            add_index<<=2;
            for (;count>0;count--) {
                Memory.mem_writed(di_base+reg_edi.dword,IO.IO_ReadD(reg_edx.word()));
                reg_edi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_STOSB:
            for (;count>0;count--) {
                Memory.mem_writeb(di_base+reg_edi.dword,reg_eax.low());
                reg_edi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_STOSW:
            add_index<<=1;
            for (;count>0;count--) {
                Memory.mem_writew(di_base+reg_edi.dword,reg_eax.word());
                reg_edi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_STOSD:
            add_index<<=2;
            for (;count>0;count--) {
                Memory.mem_writed(di_base+reg_edi.dword,reg_eax.dword);
                reg_edi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_MOVSB:
            for (;count>0;count--) {
                Memory.mem_writeb(di_base+reg_edi.dword,Memory.mem_readb(si_base+reg_esi.dword));
                reg_edi.dword+=add_index;
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_MOVSW:
            add_index<<=1;
            for (;count>0;count--) {
                Memory.mem_writew(di_base+reg_edi.dword,Memory.mem_readw(si_base+reg_esi.dword));
                reg_edi.dword+=add_index;
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_MOVSD:
            add_index<<=2;
            for (;count>0;count--) {
                Memory.mem_writed(di_base+reg_edi.dword,Memory.mem_readd(si_base + reg_esi.dword));
                reg_edi.dword+=add_index;
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_LODSB:
            for (;count>0;count--) {
                reg_eax.low(Memory.mem_readb(si_base+reg_esi.dword));
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_LODSW:
            add_index<<=1;
            for (;count>0;count--) {
                reg_eax.word(Memory.mem_readw(si_base+reg_esi.dword));
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_LODSD:
            add_index<<=2;
            for (;count>0;count--) {
                reg_eax.dword=Memory.mem_readd(si_base + reg_esi.dword);
                reg_esi.dword+=add_index;
                if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
            }
            break;
        case R_SCASB:
            {
                /*Bit8u*/int val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val2=Memory.mem_readb(di_base+reg_edi.dword);
                    reg_edi.dword+=add_index;
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
                    if ((reg_eax.low()==val2)!=rep_zero) break;
                }
                CMPB(val2,reg_eax.low());
            }
            break;
        case R_SCASW:
            {
                add_index<<=1;/*Bit16u*/int val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val2=Memory.mem_readw(di_base+reg_edi.dword);
                    reg_edi.dword+=add_index;
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
                    if ((reg_eax.word()==val2)!=rep_zero) break;
                }
                CMPW(val2,reg_eax.word());
            }
            break;
        case R_SCASD:
            {
                add_index<<=2;/*Bit32u*/int val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val2=Memory.mem_readd(di_base + reg_edi.dword);
                    reg_edi.dword+=add_index;
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
                    if ((reg_eax.dword==val2)!=rep_zero) break;
                }
                CMPD(val2,reg_eax.dword);
            }
            break;
        case R_CMPSB:
            {
                /*Bit8u*/int val1=0,val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val1=Memory.mem_readb(si_base+reg_esi.dword);
                    val2=Memory.mem_readb(di_base+reg_edi.dword);
                    reg_esi.dword+=add_index;
                    reg_edi.dword+=add_index;
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
                    if ((val1==val2)!=rep_zero) break;
                }
                CMPB(val2,val1);
            }
            break;
        case R_CMPSW:
            {
                add_index<<=1;/*Bit16u*/int val1=0,val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val1=Memory.mem_readw(si_base+reg_esi.dword);
                    val2=Memory.mem_readw(di_base+reg_edi.dword);
                    reg_esi.dword+=add_index;
                    reg_edi.dword+=add_index;
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
                    if ((val1==val2)!=rep_zero) break;
                }
                CMPW(val2,val1);
            }
            break;
        case R_CMPSD:
            {
                add_index<<=2;/*Bit32u*/int val1=0,val2=0;
                while (count>0) {
                    count--;CPU.CPU_Cycles--;
                    val1=Memory.mem_readd(si_base + reg_esi.dword);
                    val2=Memory.mem_readd(di_base + reg_edi.dword);
                    reg_esi.dword+=add_index;
                    reg_edi.dword+=add_index;
                    if ((prefixes & PREFIX_REP)!=0) reg_ecx.dword--;
                    if ((val1==val2)!=rep_zero) break;
                }
                CMPD(val2,val1);
            }
            break;
        default:
            Log.log(LogTypes.LOG_CPU, LogSeverities.LOG_ERROR,"Unhandled string op "+type);
            Log.exit("Unhandled string op "+type);
        }
    }
    
    static public String description(int type) {
        switch (type) {
        case R_OUTSB: return "OUTSB";
        case R_OUTSW: return "OUTSW";
        case R_OUTSD: return "OUTSD";
        case R_INSB: return "INSB";
        case R_INSW: return "INSW";
        case R_INSD: return "INSD";
        case R_MOVSB: return "MOVSB";
        case R_MOVSW: return "MOVSW";
        case R_MOVSD: return "MOVSD";
        case R_LODSB: return "LODSB";
        case R_LODSW: return "LODSW";
        case R_LODSD: return "LODSD";
        case R_STOSB: return "STOSB";
        case R_STOSW: return "STOSW";
        case R_STOSD: return "STOSD";
        case R_SCASB: return "SCASB";
        case R_SCASW: return "SCASW";
        case R_SCASD: return "SCASD";
        case R_CMPSB: return "CMPSB";
        case R_CMPSW: return "CMPSW";
        case R_CMPSD: return "CMPSD";
        }
        return "";
    }
}
