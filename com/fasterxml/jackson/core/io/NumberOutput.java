package com.fasterxml.jackson.core.io;

import androidx.exifinterface.media.ExifInterface;
import com.arlosoft.macrodroid.common.Util;
import com.facebook.stetho.dumpapp.Framer;
import com.google.android.gms.wearable.WearableStatusCodes;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes3.dex */
public final class NumberOutput {

    /* renamed from: a  reason: collision with root package name */
    private static int f17747a = 1000000;

    /* renamed from: b  reason: collision with root package name */
    private static int f17748b = 1000000000;

    /* renamed from: c  reason: collision with root package name */
    private static long f17749c = 10000000000L;

    /* renamed from: d  reason: collision with root package name */
    private static long f17750d = 1000;

    /* renamed from: e  reason: collision with root package name */
    private static long f17751e = -2147483648L;

    /* renamed from: f  reason: collision with root package name */
    private static long f17752f = 2147483647L;

    /* renamed from: g  reason: collision with root package name */
    static final String f17753g = String.valueOf(Long.MIN_VALUE);

    /* renamed from: h  reason: collision with root package name */
    static final char[] f17754h = new char[WearableStatusCodes.TARGET_NODE_NOT_CONNECTED];

    /* renamed from: i  reason: collision with root package name */
    static final char[] f17755i = new char[WearableStatusCodes.TARGET_NODE_NOT_CONNECTED];

    /* renamed from: j  reason: collision with root package name */
    static final byte[] f17756j;

    /* renamed from: k  reason: collision with root package name */
    static final String[] f17757k;

    /* renamed from: l  reason: collision with root package name */
    static final String[] f17758l;

    static {
        char c4;
        char c5;
        int i4 = 0;
        for (int i5 = 0; i5 < 10; i5++) {
            char c6 = (char) (i5 + 48);
            if (i5 == 0) {
                c4 = 0;
            } else {
                c4 = c6;
            }
            for (int i6 = 0; i6 < 10; i6++) {
                char c7 = (char) (i6 + 48);
                if (i5 == 0 && i6 == 0) {
                    c5 = 0;
                } else {
                    c5 = c7;
                }
                for (int i7 = 0; i7 < 10; i7++) {
                    char c8 = (char) (i7 + 48);
                    char[] cArr = f17754h;
                    cArr[i4] = c4;
                    int i8 = i4 + 1;
                    cArr[i8] = c5;
                    int i9 = i4 + 2;
                    cArr[i9] = c8;
                    char[] cArr2 = f17755i;
                    cArr2[i4] = c6;
                    cArr2[i8] = c7;
                    cArr2[i9] = c8;
                    i4 += 4;
                }
            }
        }
        f17756j = new byte[WearableStatusCodes.TARGET_NODE_NOT_CONNECTED];
        for (int i10 = 0; i10 < 4000; i10++) {
            f17756j[i10] = (byte) f17755i[i10];
        }
        f17757k = new String[]{"0", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10"};
        f17758l = new String[]{Util.ANY_CONTACT_ID, Util.ANY_NUMBER_ID, Util.NON_CONTACT_ID, Util.UNKNOWN_CALLER_ID, "-5", "-6", "-7", "-8", "-9", "-10"};
    }

    private static int a(long j4) {
        int i4 = 10;
        for (long j5 = f17749c; j4 >= j5 && i4 != 19; j5 = (j5 << 1) + (j5 << 3)) {
            i4++;
        }
        return i4;
    }

    private static int b(int i4, byte[] bArr, int i5) {
        int i6 = i4 << 2;
        int i7 = i5 + 1;
        byte[] bArr2 = f17756j;
        int i8 = i6 + 1;
        bArr[i5] = bArr2[i6];
        int i9 = i7 + 1;
        bArr[i7] = bArr2[i8];
        int i10 = i9 + 1;
        bArr[i9] = bArr2[i8 + 1];
        return i10;
    }

    private static int c(int i4, char[] cArr, int i5) {
        int i6 = i4 << 2;
        int i7 = i5 + 1;
        char[] cArr2 = f17755i;
        int i8 = i6 + 1;
        cArr[i5] = cArr2[i6];
        int i9 = i7 + 1;
        cArr[i7] = cArr2[i8];
        int i10 = i9 + 1;
        cArr[i9] = cArr2[i8 + 1];
        return i10;
    }

    private static int d(int i4, byte[] bArr, int i5) {
        int i6 = i4 << 2;
        char[] cArr = f17754h;
        int i7 = i6 + 1;
        char c4 = cArr[i6];
        if (c4 != 0) {
            bArr[i5] = (byte) c4;
            i5++;
        }
        int i8 = i7 + 1;
        char c5 = cArr[i7];
        if (c5 != 0) {
            bArr[i5] = (byte) c5;
            i5++;
        }
        int i9 = i5 + 1;
        bArr[i5] = (byte) cArr[i8];
        return i9;
    }

    private static int e(int i4, char[] cArr, int i5) {
        int i6 = i4 << 2;
        char[] cArr2 = f17754h;
        int i7 = i6 + 1;
        char c4 = cArr2[i6];
        if (c4 != 0) {
            cArr[i5] = c4;
            i5++;
        }
        int i8 = i7 + 1;
        char c5 = cArr2[i7];
        if (c5 != 0) {
            cArr[i5] = c5;
            i5++;
        }
        int i9 = i5 + 1;
        cArr[i5] = cArr2[i8];
        return i9;
    }

    public static int outputInt(int i4, char[] cArr, int i5) {
        int e4;
        int i6;
        if (i4 < 0) {
            if (i4 == Integer.MIN_VALUE) {
                return outputLong(i4, cArr, i5);
            }
            cArr[i5] = SignatureVisitor.SUPER;
            i4 = -i4;
            i5++;
        }
        if (i4 < f17747a) {
            if (i4 >= 1000) {
                int i7 = i4 / 1000;
                return c(i4 - (i7 * 1000), cArr, e(i7, cArr, i5));
            } else if (i4 < 10) {
                int i8 = i5 + 1;
                cArr[i5] = (char) (i4 + 48);
                return i8;
            } else {
                return e(i4, cArr, i5);
            }
        }
        int i9 = f17748b;
        boolean z3 = i4 >= i9;
        if (z3) {
            i4 -= i9;
            if (i4 >= i9) {
                i4 -= i9;
                i6 = i5 + 1;
                cArr[i5] = '2';
            } else {
                i6 = i5 + 1;
                cArr[i5] = '1';
            }
            i5 = i6;
        }
        int i10 = i4 / 1000;
        int i11 = i4 - (i10 * 1000);
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        if (z3) {
            e4 = c(i12, cArr, i5);
        } else {
            e4 = e(i12, cArr, i5);
        }
        return c(i11, cArr, c(i13, cArr, e4));
    }

    public static int outputLong(long j4, char[] cArr, int i4) {
        if (j4 < 0) {
            if (j4 > f17751e) {
                return outputInt((int) j4, cArr, i4);
            }
            if (j4 == Long.MIN_VALUE) {
                String str = f17753g;
                int length = str.length();
                str.getChars(0, length, cArr, i4);
                return i4 + length;
            }
            cArr[i4] = SignatureVisitor.SUPER;
            j4 = -j4;
            i4++;
        } else if (j4 <= f17752f) {
            return outputInt((int) j4, cArr, i4);
        }
        int a4 = a(j4) + i4;
        int i5 = a4;
        while (j4 > f17752f) {
            i5 -= 3;
            long j5 = f17750d;
            long j6 = j4 / j5;
            c((int) (j4 - (j5 * j6)), cArr, i5);
            j4 = j6;
        }
        int i6 = (int) j4;
        while (i6 >= 1000) {
            i5 -= 3;
            int i7 = i6 / 1000;
            c(i6 - (i7 * 1000), cArr, i5);
            i6 = i7;
        }
        e(i6, cArr, i4);
        return a4;
    }

    public static String toString(int i4) {
        String[] strArr = f17757k;
        if (i4 < strArr.length) {
            if (i4 >= 0) {
                return strArr[i4];
            }
            int i5 = (-i4) - 1;
            String[] strArr2 = f17758l;
            if (i5 < strArr2.length) {
                return strArr2[i5];
            }
        }
        return Integer.toString(i4);
    }

    public static String toString(long j4) {
        if (j4 <= 2147483647L && j4 >= -2147483648L) {
            return toString((int) j4);
        }
        return Long.toString(j4);
    }

    public static String toString(double d4) {
        return Double.toString(d4);
    }

    public static int outputLong(long j4, byte[] bArr, int i4) {
        if (j4 < 0) {
            if (j4 > f17751e) {
                return outputInt((int) j4, bArr, i4);
            }
            if (j4 == Long.MIN_VALUE) {
                int length = f17753g.length();
                int i5 = 0;
                while (i5 < length) {
                    bArr[i4] = (byte) f17753g.charAt(i5);
                    i5++;
                    i4++;
                }
                return i4;
            }
            bArr[i4] = Framer.STDIN_FRAME_PREFIX;
            j4 = -j4;
            i4++;
        } else if (j4 <= f17752f) {
            return outputInt((int) j4, bArr, i4);
        }
        int a4 = a(j4) + i4;
        int i6 = a4;
        while (j4 > f17752f) {
            i6 -= 3;
            long j5 = f17750d;
            long j6 = j4 / j5;
            b((int) (j4 - (j5 * j6)), bArr, i6);
            j4 = j6;
        }
        int i7 = (int) j4;
        while (i7 >= 1000) {
            i6 -= 3;
            int i8 = i7 / 1000;
            b(i7 - (i8 * 1000), bArr, i6);
            i7 = i8;
        }
        d(i7, bArr, i4);
        return a4;
    }

    public static int outputInt(int i4, byte[] bArr, int i5) {
        int d4;
        int i6;
        if (i4 < 0) {
            if (i4 == Integer.MIN_VALUE) {
                return outputLong(i4, bArr, i5);
            }
            bArr[i5] = Framer.STDIN_FRAME_PREFIX;
            i4 = -i4;
            i5++;
        }
        if (i4 < f17747a) {
            if (i4 >= 1000) {
                int i7 = i4 / 1000;
                return b(i4 - (i7 * 1000), bArr, d(i7, bArr, i5));
            } else if (i4 < 10) {
                int i8 = i5 + 1;
                bArr[i5] = (byte) (i4 + 48);
                return i8;
            } else {
                return d(i4, bArr, i5);
            }
        }
        int i9 = f17748b;
        boolean z3 = i4 >= i9;
        if (z3) {
            i4 -= i9;
            if (i4 >= i9) {
                i4 -= i9;
                i6 = i5 + 1;
                bArr[i5] = Framer.STDERR_FRAME_PREFIX;
            } else {
                i6 = i5 + 1;
                bArr[i5] = Framer.STDOUT_FRAME_PREFIX;
            }
            i5 = i6;
        }
        int i10 = i4 / 1000;
        int i11 = i4 - (i10 * 1000);
        int i12 = i10 / 1000;
        int i13 = i10 - (i12 * 1000);
        if (z3) {
            d4 = b(i12, bArr, i5);
        } else {
            d4 = d(i12, bArr, i5);
        }
        return b(i11, bArr, b(i13, bArr, d4));
    }
}
