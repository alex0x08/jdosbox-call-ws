package jdos.util;

public class IntPtr extends Ptr {
    public IntPtr(byte[] p, int off) {
        super(p, off);
    }
    public IntPtr(Ptr p, int off) {
        super(p, off);
    }
    public int dataWidth() {
        return 4;
    }
    public void set(int off, int val) {
        writed(off, val);
    }
    public int get(int off) {
        return readd(off);
    }
    public void set(int off, long val) {
        writed(off, val);
    }
}
