package com.android.dx.util;

import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes2.dex */
public final class Hex {
    private Hex() {
    }

    public static String dump(byte[] bArr, int i4, int i5, int i6, int i7, int i8) {
        String u12;
        int i9 = i4 + i5;
        if ((i4 | i5 | i9) >= 0 && i9 <= bArr.length) {
            if (i6 >= 0) {
                if (i5 == 0) {
                    return "";
                }
                StringBuffer stringBuffer = new StringBuffer((i5 * 4) + 6);
                int i10 = 0;
                while (i5 > 0) {
                    if (i10 == 0) {
                        if (i8 != 2) {
                            if (i8 != 4) {
                                if (i8 != 6) {
                                    u12 = u4(i6);
                                } else {
                                    u12 = u3(i6);
                                }
                            } else {
                                u12 = u2(i6);
                            }
                        } else {
                            u12 = u1(i6);
                        }
                        stringBuffer.append(u12);
                        stringBuffer.append(": ");
                    } else if ((i10 & 1) == 0) {
                        stringBuffer.append(' ');
                    }
                    stringBuffer.append(u1(bArr[i4]));
                    i6++;
                    i4++;
                    i10++;
                    if (i10 == i7) {
                        stringBuffer.append('\n');
                        i10 = 0;
                    }
                    i5--;
                }
                if (i10 != 0) {
                    stringBuffer.append('\n');
                }
                return stringBuffer.toString();
            }
            throw new IllegalArgumentException("outOffset < 0");
        }
        throw new IndexOutOfBoundsException("arr.length " + bArr.length + "; " + i4 + "..!" + i9);
    }

    public static String s1(int i4) {
        char[] cArr = new char[3];
        if (i4 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i4 = -i4;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i5 = 0; i5 < 2; i5++) {
            cArr[2 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String s2(int i4) {
        char[] cArr = new char[5];
        if (i4 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i4 = -i4;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i5 = 0; i5 < 4; i5++) {
            cArr[4 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String s4(int i4) {
        char[] cArr = new char[9];
        if (i4 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            i4 = -i4;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i5 = 0; i5 < 8; i5++) {
            cArr[8 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String s8(long j4) {
        char[] cArr = new char[17];
        if (j4 < 0) {
            cArr[0] = SignatureVisitor.SUPER;
            j4 = -j4;
        } else {
            cArr[0] = SignatureVisitor.EXTENDS;
        }
        for (int i4 = 0; i4 < 16; i4++) {
            cArr[16 - i4] = Character.forDigit(((int) j4) & 15, 16);
            j4 >>= 4;
        }
        return new String(cArr);
    }

    public static String u1(int i4) {
        char[] cArr = new char[2];
        for (int i5 = 0; i5 < 2; i5++) {
            cArr[1 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String u2(int i4) {
        char[] cArr = new char[4];
        for (int i5 = 0; i5 < 4; i5++) {
            cArr[3 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String u2or4(int i4) {
        if (i4 == ((char) i4)) {
            return u2(i4);
        }
        return u4(i4);
    }

    public static String u3(int i4) {
        char[] cArr = new char[6];
        for (int i5 = 0; i5 < 6; i5++) {
            cArr[5 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String u4(int i4) {
        char[] cArr = new char[8];
        for (int i5 = 0; i5 < 8; i5++) {
            cArr[7 - i5] = Character.forDigit(i4 & 15, 16);
            i4 >>= 4;
        }
        return new String(cArr);
    }

    public static String u8(long j4) {
        char[] cArr = new char[16];
        for (int i4 = 0; i4 < 16; i4++) {
            cArr[15 - i4] = Character.forDigit(((int) j4) & 15, 16);
            j4 >>= 4;
        }
        return new String(cArr);
    }

    public static String uNibble(int i4) {
        return new String(new char[]{Character.forDigit(i4 & 15, 16)});
    }
}
