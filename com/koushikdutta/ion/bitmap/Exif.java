package com.koushikdutta.ion.bitmap;

import android.util.Log;

/* loaded from: classes6.dex */
public class Exif {
    private static int a(byte[] bArr, int i4, int i5, boolean z3) {
        int i6;
        if (z3) {
            i4 += i5 - 1;
            i6 = -1;
        } else {
            i6 = 1;
        }
        int i7 = 0;
        while (true) {
            int i8 = i5 - 1;
            if (i5 > 0) {
                i7 = (bArr[i4] & 255) | (i7 << 8);
                i4 += i6;
                i5 = i8;
            } else {
                return i7;
            }
        }
    }

    public static int getOrientation(byte[] bArr, int i4, int i5) {
        int i6;
        boolean z3;
        int i7;
        if (bArr == null) {
            return 0;
        }
        int i8 = i5 + i4;
        while (i4 + 3 < i8) {
            int i9 = i4 + 1;
            if ((bArr[i4] & 255) == 255) {
                int i10 = bArr[i9] & 255;
                if (i10 != 255) {
                    i9++;
                    if (i10 != 216 && i10 != 1) {
                        if (i10 != 217 && i10 != 218) {
                            int a4 = a(bArr, i9, 2, false);
                            if (a4 >= 2 && (i7 = i9 + a4) <= i8) {
                                if (i10 == 225 && a4 >= 8 && a(bArr, i9 + 2, 4, false) == 1165519206 && a(bArr, i9 + 6, 2, false) == 0) {
                                    i4 = i9 + 8;
                                    i6 = a4 - 8;
                                    break;
                                }
                                i4 = i7;
                            } else {
                                Log.e("CameraExif", "Invalid length");
                                return 0;
                            }
                        }
                    }
                }
                i4 = i9;
            }
            i4 = i9;
        }
        i6 = 0;
        if (i6 > 8) {
            int a5 = a(bArr, i4, 4, false);
            if (a5 != 1229531648 && a5 != 1296891946) {
                Log.e("CameraExif", "Invalid byte order");
                return 0;
            }
            if (a5 == 1229531648) {
                z3 = true;
            } else {
                z3 = false;
            }
            int a6 = a(bArr, i4 + 4, 4, z3) + 2;
            if (a6 >= 10 && a6 <= i6) {
                int i11 = i4 + a6;
                int i12 = i6 - a6;
                int a7 = a(bArr, i11 - 2, 2, z3);
                while (true) {
                    int i13 = a7 - 1;
                    if (a7 <= 0 || i12 < 12) {
                        break;
                    } else if (a(bArr, i11, 2, z3) == 274) {
                        int a8 = a(bArr, i11 + 8, 2, z3);
                        if (a8 == 1) {
                            return 0;
                        }
                        if (a8 != 3) {
                            if (a8 != 6) {
                                if (a8 != 8) {
                                    Log.i("CameraExif", "Unsupported orientation");
                                    return 0;
                                }
                                return 270;
                            }
                            return 90;
                        }
                        return 180;
                    } else {
                        i11 += 12;
                        i12 -= 12;
                        a7 = i13;
                    }
                }
            } else {
                Log.e("CameraExif", "Invalid offset");
            }
        }
        return 0;
    }
}
