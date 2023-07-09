package jdos.util;

public class ShortPtr  extends Ptr {
    // :TODO: maybe change Ptr so that ShortPtr can use short[] directly?
    public ShortPtr(int size) {
        super(size);
    }
    public ShortPtr(byte[] p, int off) {
        super(p, off);
    }
    public int dataWidth() {
        return 2;
    }
    public int get(int off) {
        return readw(off);
    }
    public void set(int off, int val) {
        writew(off, val);
    }
}

