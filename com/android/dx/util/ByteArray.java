package com.android.dx.util;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.mail.UIDFolder;

/* loaded from: classes2.dex */
public final class ByteArray {
    private final byte[] bytes;
    private final int size;
    private final int start;

    /* loaded from: classes2.dex */
    public interface GetCursor {
        int getCursor();
    }

    /* loaded from: classes2.dex */
    public static class MyDataInputStream extends DataInputStream {
        private final MyInputStream wrapped;

        public MyDataInputStream(MyInputStream myInputStream) {
            super(myInputStream);
            this.wrapped = myInputStream;
        }
    }

    public ByteArray(byte[] bArr, int i4, int i5) {
        if (bArr == null) {
            throw new NullPointerException("bytes == null");
        }
        if (i4 < 0) {
            throw new IllegalArgumentException("start < 0");
        }
        if (i5 >= i4) {
            if (i5 <= bArr.length) {
                this.bytes = bArr;
                this.start = i4;
                this.size = i5 - i4;
                return;
            }
            throw new IllegalArgumentException("end > bytes.length");
        }
        throw new IllegalArgumentException("end < start");
    }

    private void checkOffsets(int i4, int i5) {
        if (i4 >= 0 && i5 >= i4 && i5 <= this.size) {
            return;
        }
        throw new IllegalArgumentException("bad range: " + i4 + ".." + i5 + "; actual size " + this.size);
    }

    private int getByte0(int i4) {
        return this.bytes[this.start + i4];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getUnsignedByte0(int i4) {
        return this.bytes[this.start + i4] & 255;
    }

    public int getByte(int i4) {
        checkOffsets(i4, i4 + 1);
        return getByte0(i4);
    }

    public void getBytes(byte[] bArr, int i4) {
        int length = bArr.length - i4;
        int i5 = this.size;
        if (length >= i5) {
            System.arraycopy(this.bytes, this.start, bArr, i4, i5);
            return;
        }
        throw new IndexOutOfBoundsException("(out.length - offset) < size()");
    }

    public int getInt(int i4) {
        checkOffsets(i4, i4 + 4);
        return getUnsignedByte0(i4 + 3) | (getByte0(i4) << 24) | (getUnsignedByte0(i4 + 1) << 16) | (getUnsignedByte0(i4 + 2) << 8);
    }

    public long getLong(int i4) {
        checkOffsets(i4, i4 + 8);
        int byte0 = (getByte0(i4) << 24) | (getUnsignedByte0(i4 + 1) << 16) | (getUnsignedByte0(i4 + 2) << 8) | getUnsignedByte0(i4 + 3);
        return ((getUnsignedByte0(i4 + 7) | (getByte0(i4 + 4) << 24) | (getUnsignedByte0(i4 + 5) << 16) | (getUnsignedByte0(i4 + 6) << 8)) & UIDFolder.MAXUID) | (byte0 << 32);
    }

    public int getShort(int i4) {
        checkOffsets(i4, i4 + 2);
        return getUnsignedByte0(i4 + 1) | (getByte0(i4) << 8);
    }

    public int getUnsignedByte(int i4) {
        checkOffsets(i4, i4 + 1);
        return getUnsignedByte0(i4);
    }

    public int getUnsignedShort(int i4) {
        checkOffsets(i4, i4 + 2);
        return getUnsignedByte0(i4 + 1) | (getUnsignedByte0(i4) << 8);
    }

    public MyDataInputStream makeDataInputStream() {
        return new MyDataInputStream(makeInputStream());
    }

    public MyInputStream makeInputStream() {
        return new MyInputStream();
    }

    public int size() {
        return this.size;
    }

    public ByteArray slice(int i4, int i5) {
        checkOffsets(i4, i5);
        byte[] bArr = this.bytes;
        int i6 = this.start;
        return new ByteArray(bArr, i4 + i6, i5 + i6);
    }

    public int underlyingOffset(int i4, byte[] bArr) {
        if (bArr == this.bytes) {
            return this.start + i4;
        }
        throw new IllegalArgumentException("wrong bytes");
    }

    /* loaded from: classes2.dex */
    public class MyInputStream extends InputStream {
        private int cursor = 0;
        private int mark = 0;

        public MyInputStream() {
        }

        @Override // java.io.InputStream
        public int available() {
            return ByteArray.this.size - this.cursor;
        }

        @Override // java.io.InputStream
        public void mark(int i4) {
            this.mark = this.cursor;
        }

        @Override // java.io.InputStream
        public boolean markSupported() {
            return true;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.cursor >= ByteArray.this.size) {
                return -1;
            }
            int unsignedByte0 = ByteArray.this.getUnsignedByte0(this.cursor);
            this.cursor++;
            return unsignedByte0;
        }

        @Override // java.io.InputStream
        public void reset() {
            this.cursor = this.mark;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i4, int i5) {
            if (i4 + i5 > bArr.length) {
                i5 = bArr.length - i4;
            }
            int i6 = ByteArray.this.size - this.cursor;
            if (i5 > i6) {
                i5 = i6;
            }
            System.arraycopy(ByteArray.this.bytes, this.cursor + ByteArray.this.start, bArr, i4, i5);
            this.cursor += i5;
            return i5;
        }
    }

    public ByteArray(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }
}
