package jdos.hardware.qemu;

public class Scsi {
    /* Event notification classes for GET EVENT STATUS NOTIFICATION */
    public static final int  GESN_MEDIA =                   4;
    /* Event codes for MEDIA event status notification */
    public static final int  MEC_NO_CHANGE =                0;
    public static final int  MEC_EJECT_REQUESTED =          1;
    public static final int  MEC_NEW_MEDIA =                2;
    public static final int  MS_TRAY_OPEN =                 1;
    public static final int  MS_MEDIA_PRESENT=              2;
    
    /*
    *  SENSE KEYS
    */
    static public final int NO_SENSE =            0x00;
    static public final int NOT_READY =           0x02;
    static public final int ILLEGAL_REQUEST =     0x05;
    static public final int UNIT_ATTENTION =      0x06;

    /* Some generally useful CD-ROM information */
    public static final int CD_MINS =                      80; /* max. minutes per CD */
    public static final int CD_SECS =                      60; /* seconds per minute */
    public static final int CD_FRAMES =                    75; /* frames per second */
    public static final int CD_FRAMESIZE =               2048; /* bytes per frame, "cooked" mode */
    public static final int CD_MAX_BYTES =      (CD_MINS * CD_SECS * CD_FRAMES * CD_FRAMESIZE);
    public static final int CD_MAX_SECTORS =    (CD_MAX_BYTES / 512);
    
    /* Mode page codes for mode sense/set */
    public static final int  MODE_PAGE_R_W_ERROR =                  0x01;
 public static final int  MODE_PAGE_AUDIO_CTL =                  0x0e;
 public static final int  MODE_PAGE_CAPABILITIES =               0x2a;
  //  public static final int  MODE_PAGE_ALLS =                       0x3f;
    /* Not in Mt. Fuji, but in ATAPI 2.6 -- depricated now in favor
     * of MODE_PAGE_SENSE_POWER */
   // public static final int  MODE_PAGE_CDROM =                      0x0d;
    
    /* Profile list from MMC-6 revision 1 table 91 */
  //  public static final int  MMC_PROFILE_NONE =               0x0000;
    public static final int  MMC_PROFILE_CD_ROM =             0x0008;
   public static final int  MMC_PROFILE_DVD_ROM =            0x0010;
}
