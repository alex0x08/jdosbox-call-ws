package jdos.dos;

public class Dos_system {
    public interface MultiplexHandler {
        boolean call();
    }
    
   static public final int DOS_PATHLENGTH =80;
   // static public final int DOS_TEMPSIZE =1024;

	static public final int DOS_ATTR_READ_ONLY=	0x01;
	static public final int DOS_ATTR_HIDDEN=	0x02;
	static public final int DOS_ATTR_SYSTEM=	0x04;
	static public final int DOS_ATTR_VOLUME=	0x08;
	static public final int DOS_ATTR_DIRECTORY=	0x10;
	static public final int DOS_ATTR_ARCHIVE=	0x20;
	static public final int DOS_ATTR_DEVICE=	0x40;    
}
