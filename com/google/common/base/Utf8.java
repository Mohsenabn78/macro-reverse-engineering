package com.google.common.base;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible(emulated = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class Utf8 {
    private Utf8() {
    }

    private static int a(CharSequence charSequence, int i4) {
        int length = charSequence.length();
        int i5 = 0;
        while (i4 < length) {
            char charAt = charSequence.charAt(i4);
            if (charAt < 2048) {
                i5 += (127 - charAt) >>> 31;
            } else {
                i5 += 2;
                if (55296 <= charAt && charAt <= 57343) {
                    if (Character.codePointAt(charSequence, i4) != charAt) {
                        i4++;
                    } else {
                        throw new IllegalArgumentException(c(i4));
                    }
                }
            }
            i4++;
        }
        return i5;
    }

    private static boolean b(byte[] bArr, int i4, int i5) {
        byte b4;
        while (i4 < i5) {
            int i6 = i4 + 1;
            byte b5 = bArr[i4];
            if (b5 < 0) {
                if (b5 < -32) {
                    if (i6 != i5 && b5 >= -62) {
                        i4 = i6 + 1;
                        if (bArr[i6] > -65) {
                        }
                    }
                    return false;
                } else if (b5 < -16) {
                    int i7 = i6 + 1;
                    if (i7 < i5 && (b4 = bArr[i6]) <= -65 && ((b5 != -32 || b4 >= -96) && (b5 != -19 || -96 > b4))) {
                        i4 = i7 + 1;
                        if (bArr[i7] > -65) {
                        }
                    }
                    return false;
                } else if (i6 + 2 >= i5) {
                    return false;
                } else {
                    int i8 = i6 + 1;
                    byte b6 = bArr[i6];
                    if (b6 <= -65 && (((b5 << Ascii.FS) + (b6 + 112)) >> 30) == 0) {
                        int i9 = i8 + 1;
                        if (bArr[i8] <= -65) {
                            i6 = i9 + 1;
                            if (bArr[i9] > -65) {
                            }
                        }
                    }
                    return false;
                }
            }
            i4 = i6;
        }
        return true;
    }

    private static String c(int i4) {
        return "Unpaired surrogate at index " + i4;
    }

    public static int encodedLength(CharSequence charSequence) {
        int length = charSequence.length();
        int i4 = 0;
        while (i4 < length && charSequence.charAt(i4) < 128) {
            i4++;
        }
        int i5 = length;
        while (true) {
            if (i4 < length) {
                char charAt = charSequence.charAt(i4);
                if (charAt < 2048) {
                    i5 += (127 - charAt) >>> 31;
                    i4++;
                } else {
                    i5 += a(charSequence, i4);
                    break;
                }
            } else {
                break;
            }
        }
        if (i5 >= length) {
            return i5;
        }
        throw new IllegalArgumentException("UTF-8 length does not fit in int: " + (i5 + 4294967296L));
    }

    public static boolean isWellFormed(byte[] bArr) {
        return isWellFormed(bArr, 0, bArr.length);
    }

    public static boolean isWellFormed(byte[] bArr, int i4, int i5) {
        int i6 = i5 + i4;
        Preconditions.checkPositionIndexes(i4, i6, bArr.length);
        while (i4 < i6) {
            if (bArr[i4] < 0) {
                return b(bArr, i4, i6);
            }
            i4++;
        }
        return true;
    }
}
