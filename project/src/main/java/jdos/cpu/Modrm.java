package jdos.cpu;

public class Modrm {
    public interface Getrb_interface {
        int get();
        void set(int value);
    }

    static final private Getrb_interface al = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_eax.low(value);
        }
        public int get() {
            return CPU_Regs.reg_eax.low();
        }
    };

    static final private Getrb_interface cl = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_ecx.low(value);
        }
        public int get() {
            return CPU_Regs.reg_ecx.low();
        }
    };

    static final private Getrb_interface dl = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_edx.low(value);
        }
        public int get() {
            return CPU_Regs.reg_edx.low();
        }
    };

    static final private Getrb_interface bl = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_ebx.low(value);
        }
        public int get() {
            return CPU_Regs.reg_ebx.low();
        }
    };

    static final private Getrb_interface ah = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_eax.high(value);
        }
        public int get() {
            return CPU_Regs.reg_eax.high();
        }
    };

    static final private Getrb_interface ch = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_ecx.high(value);
        }
        public int get() {
            return CPU_Regs.reg_ecx.high();
        }
    };

    static final private Getrb_interface dh = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_edx.high(value);
        }
        public int get() {
            return CPU_Regs.reg_edx.high();
        }
    };

    static final private Getrb_interface bh = new Getrb_interface() {
        public void set(int value) {
            CPU_Regs.reg_ebx.high(value);
        }
        public int get() {
            return CPU_Regs.reg_ebx.high();
        }
    };
    final static public Getrb_interface[] Getrb = new Getrb_interface[] {
            al, al, al, al, al, al, al, al,
            cl, cl, cl, cl, cl, cl, cl, cl,
            dl, dl, dl, dl, dl, dl, dl, dl,
            bl, bl, bl, bl, bl, bl, bl, bl,
            ah, ah, ah, ah, ah, ah, ah, ah,
            ch, ch, ch, ch, ch, ch, ch, ch,
            dh, dh, dh, dh, dh, dh, dh, dh,
            bh, bh, bh, bh, bh, bh, bh, bh,

            al, al, al, al, al, al, al, al,
            cl, cl, cl, cl, cl, cl, cl, cl,
            dl, dl, dl, dl, dl, dl, dl, dl,
            bl, bl, bl, bl, bl, bl, bl, bl,
            ah, ah, ah, ah, ah, ah, ah, ah,
            ch, ch, ch, ch, ch, ch, ch, ch,
            dh, dh, dh, dh, dh, dh, dh, dh,
            bh, bh, bh, bh, bh, bh, bh, bh,

            al, al, al, al, al, al, al, al,
            cl, cl, cl, cl, cl, cl, cl, cl,
            dl, dl, dl, dl, dl, dl, dl, dl,
            bl, bl, bl, bl, bl, bl, bl, bl,
            ah, ah, ah, ah, ah, ah, ah, ah,
            ch, ch, ch, ch, ch, ch, ch, ch,
            dh, dh, dh, dh, dh, dh, dh, dh,
            bh, bh, bh, bh, bh, bh, bh, bh,

            al, al, al, al, al, al, al, al,
            cl, cl, cl, cl, cl, cl, cl, cl,
            dl, dl, dl, dl, dl, dl, dl, dl,
            bl, bl, bl, bl, bl, bl, bl, bl,
            ah, ah, ah, ah, ah, ah, ah, ah,
            ch, ch, ch, ch, ch, ch, ch, ch,
            dh, dh, dh, dh, dh, dh, dh, dh,
            bh, bh, bh, bh, bh, bh, bh, bh
    };
    static final public CPU_Regs.Reg[] Getrw = new CPU_Regs.Reg[] {
            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,

            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,

            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,

            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,
    };
    static final public CPU_Regs.Reg[] Getrd = new CPU_Regs.Reg[] {
            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,

            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,

            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi,

            CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax, CPU_Regs.reg_eax,
            CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx, CPU_Regs.reg_ecx,
            CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx, CPU_Regs.reg_edx,
            CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx, CPU_Regs.reg_ebx,
            CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp, CPU_Regs.reg_esp,
            CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp, CPU_Regs.reg_ebp,
            CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi, CPU_Regs.reg_esi,
            CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi, CPU_Regs.reg_edi
    };
    static final public Getrb_interface[] GetEArb = new Getrb_interface[] {
            /* 12 lines of 16*0 should give nice errors when used */
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh,
            al, cl, dl, bl, ah, ch, dh, bh
    };
    static final public CPU_Regs.Reg[] GetEArw = new CPU_Regs.Reg[] {
            /* 12 lines of 16*0 should give nice errors when used */
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi
    };
    static final public CPU_Regs.Reg[] GetEArd = new CPU_Regs.Reg[] {
            /* 12 lines of 16*0 should give nice errors when used */
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,	null,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi,
            CPU_Regs.reg_eax, CPU_Regs.reg_ecx, CPU_Regs.reg_edx, CPU_Regs.reg_ebx, CPU_Regs.reg_esp, CPU_Regs.reg_ebp, CPU_Regs.reg_esi, CPU_Regs.reg_edi
    };

    public interface Move {
        void call();
    }
}
