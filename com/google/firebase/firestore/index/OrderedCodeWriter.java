package com.google.firebase.firestore.index;

import com.google.protobuf.ByteString;
import java.math.RoundingMode;
import java.util.Arrays;
import org.jetbrains.anko.DimensionsKt;

/* loaded from: classes5.dex */
public class OrderedCodeWriter {
    public static final long DOUBLE_ALL_BITS = -1;
    public static final long DOUBLE_SIGN_MASK = Long.MIN_VALUE;
    public static final byte ESCAPE1 = 0;
    public static final byte ESCAPE2 = -1;
    public static final byte FF_BYTE = 0;
    public static final byte INFINITY = -1;
    public static final byte NULL_BYTE = -1;
    public static final byte SEPARATOR = 1;

    /* renamed from: c  reason: collision with root package name */
    private static final byte[][] f30568c = {new byte[]{0, 0}, new byte[]{Byte.MIN_VALUE, 0}, new byte[]{-64, 0}, new byte[]{-32, 0}, new byte[]{-16, 0}, new byte[]{-8, 0}, new byte[]{-4, 0}, new byte[]{-2, 0}, new byte[]{-1, 0}, new byte[]{-1, Byte.MIN_VALUE}, new byte[]{-1, -64}};

    /* renamed from: b  reason: collision with root package name */
    private int f30570b = 0;

    /* renamed from: a  reason: collision with root package name */
    private byte[] f30569a = new byte[1024];

    private void a(int i4) {
        int i5 = i4 + this.f30570b;
        byte[] bArr = this.f30569a;
        if (i5 <= bArr.length) {
            return;
        }
        int length = bArr.length * 2;
        if (length >= i5) {
            i5 = length;
        }
        this.f30569a = Arrays.copyOf(bArr, i5);
    }

    private int b(long j4) {
        if (j4 < 0) {
            j4 = ~j4;
        }
        return IntMath.divide((64 - Long.numberOfLeadingZeros(j4)) + 1, 7, RoundingMode.UP);
    }

    private int c(long j4) {
        return IntMath.divide(64 - Long.numberOfLeadingZeros(j4), 8, RoundingMode.UP);
    }

    private void d(byte b4) {
        if (b4 == 0) {
            f((byte) 0);
            f((byte) -1);
        } else if (b4 == -1) {
            f((byte) -1);
            f((byte) 0);
        } else {
            f(b4);
        }
    }

    private void e(byte b4) {
        if (b4 == 0) {
            g((byte) 0);
            g((byte) -1);
        } else if (b4 == -1) {
            g((byte) -1);
            g((byte) 0);
        } else {
            g(b4);
        }
    }

    private void f(byte b4) {
        a(1);
        byte[] bArr = this.f30569a;
        int i4 = this.f30570b;
        this.f30570b = i4 + 1;
        bArr[i4] = b4;
    }

    private void g(byte b4) {
        a(1);
        byte[] bArr = this.f30569a;
        int i4 = this.f30570b;
        this.f30570b = i4 + 1;
        bArr[i4] = (byte) (~b4);
    }

    private void h() {
        f((byte) 0);
        f((byte) 1);
    }

    private void i() {
        g((byte) 0);
        g((byte) 1);
    }

    public byte[] encodedBytes() {
        return Arrays.copyOf(this.f30569a, this.f30570b);
    }

    public void reset() {
        this.f30570b = 0;
    }

    public void seed(byte[] bArr) {
        a(bArr.length);
        for (byte b4 : bArr) {
            byte[] bArr2 = this.f30569a;
            int i4 = this.f30570b;
            this.f30570b = i4 + 1;
            bArr2[i4] = b4;
        }
    }

    public void writeBytesAscending(ByteString byteString) {
        for (int i4 = 0; i4 < byteString.size(); i4++) {
            d(byteString.byteAt(i4));
        }
        h();
    }

    public void writeBytesDescending(ByteString byteString) {
        for (int i4 = 0; i4 < byteString.size(); i4++) {
            e(byteString.byteAt(i4));
        }
        i();
    }

    public void writeDoubleAscending(double d4) {
        long j4;
        long doubleToLongBits = Double.doubleToLongBits(d4);
        if (doubleToLongBits < 0) {
            j4 = -1;
        } else {
            j4 = Long.MIN_VALUE;
        }
        writeUnsignedLongAscending(doubleToLongBits ^ j4);
    }

    public void writeDoubleDescending(double d4) {
        long j4;
        long doubleToLongBits = Double.doubleToLongBits(d4);
        if (doubleToLongBits < 0) {
            j4 = -1;
        } else {
            j4 = Long.MIN_VALUE;
        }
        writeUnsignedLongDescending(doubleToLongBits ^ j4);
    }

    public void writeInfinityAscending() {
        f((byte) -1);
        f((byte) -1);
    }

    public void writeInfinityDescending() {
        g((byte) -1);
        g((byte) -1);
    }

    public void writeSignedLongAscending(long j4) {
        long j5;
        byte b4;
        int i4;
        int i5 = (j4 > 0L ? 1 : (j4 == 0L ? 0 : -1));
        if (i5 < 0) {
            j5 = ~j4;
        } else {
            j5 = j4;
        }
        if (j5 < 64) {
            a(1);
            byte[] bArr = this.f30569a;
            int i6 = this.f30570b;
            this.f30570b = i6 + 1;
            bArr[i6] = (byte) (j4 ^ f30568c[1][0]);
            return;
        }
        int b5 = b(j5);
        a(b5);
        if (b5 >= 2) {
            if (i5 < 0) {
                b4 = -1;
            } else {
                b4 = 0;
            }
            int i7 = this.f30570b;
            if (b5 == 10) {
                i4 = i7 + 2;
                byte[] bArr2 = this.f30569a;
                bArr2[i7] = b4;
                bArr2[i7 + 1] = b4;
            } else if (b5 == 9) {
                i4 = i7 + 1;
                this.f30569a[i7] = b4;
            } else {
                i4 = i7;
            }
            for (int i8 = (b5 - 1) + i7; i8 >= i4; i8--) {
                this.f30569a[i8] = (byte) (255 & j4);
                j4 >>= 8;
            }
            byte[] bArr3 = this.f30569a;
            int i9 = this.f30570b;
            byte b6 = bArr3[i9];
            byte[] bArr4 = f30568c[b5];
            bArr3[i9] = (byte) (b6 ^ bArr4[0]);
            int i10 = i9 + 1;
            bArr3[i10] = (byte) (bArr4[1] ^ bArr3[i10]);
            this.f30570b = i9 + b5;
            return;
        }
        throw new AssertionError(String.format("Invalid length (%d) returned by signedNumLength", Integer.valueOf(b5)));
    }

    public void writeSignedLongDescending(long j4) {
        writeSignedLongAscending(~j4);
    }

    public void writeUnsignedLongAscending(long j4) {
        int c4 = c(j4);
        a(c4 + 1);
        byte[] bArr = this.f30569a;
        int i4 = this.f30570b;
        int i5 = i4 + 1;
        this.f30570b = i5;
        bArr[i4] = (byte) c4;
        int i6 = i5 + c4;
        while (true) {
            i6--;
            int i7 = this.f30570b;
            if (i6 >= i7) {
                this.f30569a[i6] = (byte) (255 & j4);
                j4 >>>= 8;
            } else {
                this.f30570b = i7 + c4;
                return;
            }
        }
    }

    public void writeUnsignedLongDescending(long j4) {
        int c4 = c(j4);
        a(c4 + 1);
        byte[] bArr = this.f30569a;
        int i4 = this.f30570b;
        int i5 = i4 + 1;
        this.f30570b = i5;
        bArr[i4] = (byte) (~c4);
        int i6 = i5 + c4;
        while (true) {
            i6--;
            int i7 = this.f30570b;
            if (i6 >= i7) {
                this.f30569a[i6] = (byte) (~(255 & j4));
                j4 >>>= 8;
            } else {
                this.f30570b = i7 + c4;
                return;
            }
        }
    }

    public void writeUtf8Ascending(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt = charSequence.charAt(i4);
            if (charAt < 128) {
                d((byte) charAt);
            } else if (charAt < 2048) {
                d((byte) ((charAt >>> 6) | 960));
                d((byte) ((charAt & '?') | 128));
            } else if (charAt >= 55296 && 57343 >= charAt) {
                int codePointAt = Character.codePointAt(charSequence, i4);
                i4++;
                d((byte) ((codePointAt >>> 18) | 240));
                d((byte) (((codePointAt >>> 12) & 63) | 128));
                d((byte) (((codePointAt >>> 6) & 63) | 128));
                d((byte) ((codePointAt & 63) | 128));
            } else {
                d((byte) ((charAt >>> '\f') | DimensionsKt.XXHDPI));
                d((byte) (((charAt >>> 6) & 63) | 128));
                d((byte) ((charAt & '?') | 128));
            }
            i4++;
        }
        h();
    }

    public void writeUtf8Descending(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length) {
            char charAt = charSequence.charAt(i4);
            if (charAt < 128) {
                e((byte) charAt);
            } else if (charAt < 2048) {
                e((byte) ((charAt >>> 6) | 960));
                e((byte) ((charAt & '?') | 128));
            } else if (charAt >= 55296 && 57343 >= charAt) {
                int codePointAt = Character.codePointAt(charSequence, i4);
                i4++;
                e((byte) ((codePointAt >>> 18) | 240));
                e((byte) (((codePointAt >>> 12) & 63) | 128));
                e((byte) (((codePointAt >>> 6) & 63) | 128));
                e((byte) ((codePointAt & 63) | 128));
            } else {
                e((byte) ((charAt >>> '\f') | DimensionsKt.XXHDPI));
                e((byte) (((charAt >>> 6) & 63) | 128));
                e((byte) ((charAt & '?') | 128));
            }
            i4++;
        }
        i();
    }
}
