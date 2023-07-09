package jdos.hardware;

import jdos.misc.Log;
import jdos.types.LogSeverities;
import jdos.types.LogTypes;

public class IoHandler {
    public static final int IO_MAX = (64*1024+3);

    public static final int IO_MB = 0x1;
    public static final int IO_MW = 0x2;
    public static final int IO_MD = 0x4;
    public static final int IO_MA = (IO_MB | IO_MW | IO_MD );

    public interface IO_ReadHandler {
        /*Bitu*/int call(/*Bitu*/int port, /*Bitu*/int iolen);
    }
    public interface IO_WriteHandler {
        void call(/*Bitu*/int port, /*Bitu*/int val, /*Bitu*/int iolen);
    }

    /* Classes to manage the IO objects created by the various devices.
    * The io objects will remove itself on destruction.*/
    private static class IO_Base{
        protected boolean installed = false;
        protected /*Bitu*/int m_port, m_mask,m_range;
    }

    public static class IO_ReadHandleObject extends IO_Base {
        public void Install(/*Bitu*/int port, IO_ReadHandler handler,/*Bitu*/int mask) {
            Install(port, handler, mask, 1);
        }
        public void Install(/*Bitu*/int port, IO_ReadHandler handler,/*Bitu*/int mask,/*Bitu*/int range/*=1*/) {
            if(!installed) {
                installed=true;
                m_port=port;
                m_mask=mask;
                m_range=range;
                IO_RegisterReadHandler(port,handler,mask,range);
            } else Log.exit("IO_readHandler already installed port "+Integer.toString(port,16));
        }
    }
    public static class IO_WriteHandleObject extends IO_Base {
        public void Install(/*Bitu*/int port,IO_WriteHandler handler,/*Bitu*/int mask) {
            Install(port, handler, mask, 1);
        }
        public void Install(/*Bitu*/int port,IO_WriteHandler handler,/*Bitu*/int mask,/*Bitu*/int range/*=1*/) {
            if(!installed) {
                installed=true;
                m_port=port;
                m_mask=mask;
                m_range=range;
                IO_RegisterWriteHandler(port,handler,mask,range);
            } else Log.exit("IO_writeHandler already installed port "+Integer.toString(port,16));
        }
    }

    public static void IO_Write(/*Bitu*/int port,/*Bit8u*/int val) {
        IO.IO_WriteB(port,val & 0xFF);
    }
    public static /*Bit8u*/short IO_Read(/*Bitu*/int port){
        return (/*Bit8u*/short) (IO.IO_ReadB(port) & 0xFF);
    }

    static public final IO_WriteHandler[][] io_writehandlers = new IO_WriteHandler[3][IO_MAX];
    static public final IO_ReadHandler[][] io_readhandlers = new IO_ReadHandler[3][IO_MAX];

    /*Bitu*//*Bitu*//*Bitu*/
    static private final IO_ReadHandler IO_ReadBlocked = (port, iolen) -> ~0;

    /*Bitu*//*Bitu*//*Bitu*/
    static private final IO_WriteHandler IO_WriteBlocked = (port, val, iolen) -> {
    };

    /*Bitu*//*Bitu*//*Bitu*/
    static private final IO_ReadHandler IO_ReadDefault = (port, iolen) -> {
        switch (iolen) {
        case 1:
            Log.log(LogTypes.LOG_IO, LogSeverities.LOG_WARN, "Read from port "+Integer.toString(port,16));
            io_readhandlers[0][port]=IO_ReadBlocked;
            return 0xff;
        case 2:
            return
                (io_readhandlers[0][port].call(port,1)) |
                (io_readhandlers[0][port+1].call(port+1,1) << 8);
        case 4:
            return
                (io_readhandlers[1][port].call(port,2)) |
                (io_readhandlers[1][port+2].call(port+2,2) << 16);
        }
        return 0;
    };

    /*Bitu*//*Bitu*//*Bitu*/
    static private final IO_WriteHandler IO_WriteDefault = (port, val, iolen) -> {
        switch (iolen) {
        case 1:
            Log.log(LogTypes.LOG_IO,LogSeverities.LOG_WARN,"Writing "+Integer.toString(val, 16)+" to port "+Integer.toString(port,16));
            io_writehandlers[0][port]=IO_WriteBlocked;
            break;
        case 2:
            io_writehandlers[0][port].call(port,(val) & 0xff,1);
            io_writehandlers[0][port+1].call(port+1,(val >> 8) & 0xff,1);
            break;
        case 4:
            io_writehandlers[1][port].call(port,(val) & 0xffff,2);
            io_writehandlers[1][port+2].call(port+2,(val >> 16) & 0xffff,2);
            break;
        }
    };

    public static void IO_RegisterReadHandler(/*Bitu*/int port,IO_ReadHandler handler,/*Bitu*/int mask) {
        IO_RegisterReadHandler(port, handler, mask, 1);
    }
    
    public static void IO_RegisterReadHandler(/*Bitu*/int port,IO_ReadHandler handler,/*Bitu*/int mask,/*Bitu*/int range) {
        while (range-- !=0) {
            if ((mask&IO_MB)!=0) io_readhandlers[0][port]=handler;
            if ((mask&IO_MW)!=0) io_readhandlers[1][port]=handler;
            if ((mask&IO_MD)!=0) io_readhandlers[2][port]=handler;
            port++;
        }
    }

    public static void IO_RegisterWriteHandler(/*Bitu*/int port,IO_WriteHandler handler,/*Bitu*/int mask) {
        IO_RegisterWriteHandler(port, handler, mask, 1);
    }

    public static void IO_RegisterWriteHandler(/*Bitu*/int port,IO_WriteHandler handler,/*Bitu*/int mask,/*Bitu*/int range) {
        while (range-- !=0) {
            if ((mask&IO_MB)!=0) io_writehandlers[0][port]=handler;
            if ((mask&IO_MW)!=0) io_writehandlers[1][port]=handler;
            if ((mask&IO_MD)!=0) io_writehandlers[2][port]=handler;
            port++;
        }
    }

    public static void IO_FreeReadHandler(/*Bitu*/int port,/*Bitu*/int mask) {
        IO_FreeReadHandler(port, mask, 1);
    }
    public static void IO_FreeReadHandler(/*Bitu*/int port,/*Bitu*/int mask,/*Bitu*/int range) {
        while (range-- != 0) {
            if ((mask&IO_MB)!=0) io_readhandlers[0][port]=IO_ReadDefault;
            if ((mask&IO_MW)!=0) io_readhandlers[1][port]=IO_ReadDefault;
            if ((mask&IO_MD)!=0) io_readhandlers[2][port]=IO_ReadDefault;
            port++;
        }
    }

    public static void IO_FreeWriteHandler(/*Bitu*/int port,/*Bitu*/int mask) {
        IO_FreeWriteHandler(port, mask, 1);
    }
    public static void IO_FreeWriteHandler(/*Bitu*/int port,/*Bitu*/int mask,/*Bitu*/int range) {
        while (range-- != 0) {
            if ((mask&IO_MB)!=0) io_writehandlers[0][port]=IO_WriteDefault;
            if ((mask&IO_MW)!=0) io_writehandlers[1][port]=IO_WriteDefault;
            if ((mask&IO_MD)!=0) io_writehandlers[2][port]=IO_WriteDefault;
            port++;
        }
    }
}
