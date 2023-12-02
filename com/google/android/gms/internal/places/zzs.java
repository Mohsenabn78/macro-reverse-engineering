package com.google.android.gms.internal.places;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzs {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4, zzr zzrVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 >= 0) {
            zzrVar.zzdz = b4;
            return i5;
        }
        return zzb(b4, bArr, i5, zzrVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(byte[] bArr, int i4, zzr zzrVar) {
        byte b4;
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        if (j4 >= 0) {
            zzrVar.zzea = j4;
            return i5;
        }
        int i6 = i5 + 1;
        byte b5 = bArr[i5];
        long j5 = (j4 & 127) | ((b5 & Byte.MAX_VALUE) << 7);
        int i7 = 7;
        while (b5 < 0) {
            int i8 = i6 + 1;
            i7 += 7;
            j5 |= (b4 & Byte.MAX_VALUE) << i7;
            b5 = bArr[i6];
            i6 = i8;
        }
        zzrVar.zzea = j5;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static double zzd(byte[] bArr, int i4) {
        return Double.longBitsToDouble(zzc(bArr, i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static float zze(byte[] bArr, int i4) {
        return Float.intBitsToFloat(zzb(bArr, i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i4, zzr zzrVar) throws zzbk {
        int zzb = zzb(bArr, i4, zzrVar);
        int i5 = zzrVar.zzdz;
        if (i5 >= 0) {
            if (i5 <= bArr.length - zzb) {
                if (i5 == 0) {
                    zzrVar.zzeb = zzw.zzeg;
                    return zzb;
                }
                zzrVar.zzeb = zzw.zzc(bArr, zzb, i5);
                return zzb + i5;
            }
            throw zzbk.zzbp();
        }
        throw zzbk.zzbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(byte[] bArr, int i4, zzr zzrVar) throws zzbk {
        int zzb = zzb(bArr, i4, zzrVar);
        int i5 = zzrVar.zzdz;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzrVar.zzeb = "";
                return zzb;
            }
            zzrVar.zzeb = new String(bArr, zzb, i5, zzbd.UTF_8);
            return zzb + i5;
        }
        throw zzbk.zzbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(byte[] bArr, int i4, zzr zzrVar) throws zzbk {
        int zzb = zzb(bArr, i4, zzrVar);
        int i5 = zzrVar.zzdz;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzrVar.zzeb = "";
                return zzb;
            }
            zzrVar.zzeb = zzea.zzh(bArr, zzb, i5);
            return zzb + i5;
        }
        throw zzbk.zzbq();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, byte[] bArr, int i5, zzr zzrVar) {
        int i6 = i4 & 127;
        int i7 = i5 + 1;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzrVar.zzdz = i6 | (b4 << 7);
            return i7;
        }
        int i8 = i6 | ((b4 & Byte.MAX_VALUE) << 7);
        int i9 = i7 + 1;
        byte b5 = bArr[i7];
        if (b5 >= 0) {
            zzrVar.zzdz = i8 | (b5 << Ascii.SO);
            return i9;
        }
        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 14);
        int i11 = i9 + 1;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzrVar.zzdz = i10 | (b6 << Ascii.NAK);
            return i11;
        }
        int i12 = i10 | ((b6 & Byte.MAX_VALUE) << 21);
        int i13 = i11 + 1;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzrVar.zzdz = i12 | (b7 << Ascii.FS);
            return i13;
        }
        int i14 = i12 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] >= 0) {
                zzrVar.zzdz = i14;
                return i15;
            }
            i13 = i15;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzc(byte[] bArr, int i4) {
        return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzda zzdaVar, byte[] bArr, int i4, int i5, zzr zzrVar) throws IOException {
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        if (i7 < 0) {
            i6 = zzb(i7, bArr, i6, zzrVar);
            i7 = zzrVar.zzdz;
        }
        int i8 = i6;
        if (i7 >= 0 && i7 <= i5 - i8) {
            Object newInstance = zzdaVar.newInstance();
            int i9 = i7 + i8;
            zzdaVar.zzb(newInstance, bArr, i8, i9, zzrVar);
            zzdaVar.zzd(newInstance);
            zzrVar.zzeb = newInstance;
            return i9;
        }
        throw zzbk.zzbp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzda zzdaVar, byte[] bArr, int i4, int i5, int i6, zzr zzrVar) throws IOException {
        zzco zzcoVar = (zzco) zzdaVar;
        Object newInstance = zzcoVar.newInstance();
        int zzb = zzcoVar.zzb((zzco) newInstance, bArr, i4, i5, i6, zzrVar);
        zzcoVar.zzd(newInstance);
        zzrVar.zzeb = newInstance;
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, byte[] bArr, int i5, int i6, zzbh<?> zzbhVar, zzr zzrVar) {
        zzbe zzbeVar = (zzbe) zzbhVar;
        int zzb = zzb(bArr, i5, zzrVar);
        zzbeVar.zzac(zzrVar.zzdz);
        while (zzb < i6) {
            int zzb2 = zzb(bArr, zzb, zzrVar);
            if (i4 != zzrVar.zzdz) {
                break;
            }
            zzb = zzb(bArr, zzb2, zzrVar);
            zzbeVar.zzac(zzrVar.zzdz);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4, zzbh<?> zzbhVar, zzr zzrVar) throws IOException {
        zzbe zzbeVar = (zzbe) zzbhVar;
        int zzb = zzb(bArr, i4, zzrVar);
        int i5 = zzrVar.zzdz + zzb;
        while (zzb < i5) {
            zzb = zzb(bArr, zzb, zzrVar);
            zzbeVar.zzac(zzrVar.zzdz);
        }
        if (zzb == i5) {
            return zzb;
        }
        throw zzbk.zzbp();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzda<?> zzdaVar, int i4, byte[] bArr, int i5, int i6, zzbh<?> zzbhVar, zzr zzrVar) throws IOException {
        int zzb = zzb(zzdaVar, bArr, i5, i6, zzrVar);
        zzbhVar.add(zzrVar.zzeb);
        while (zzb < i6) {
            int zzb2 = zzb(bArr, zzb, zzrVar);
            if (i4 != zzrVar.zzdz) {
                break;
            }
            zzb = zzb(zzdaVar, bArr, zzb2, i6, zzrVar);
            zzbhVar.add(zzrVar.zzeb);
        }
        return zzb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, byte[] bArr, int i5, int i6, zzdr zzdrVar, zzr zzrVar) throws zzbk {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 == 0) {
                int zzc = zzc(bArr, i5, zzrVar);
                zzdrVar.zzc(i4, Long.valueOf(zzrVar.zzea));
                return zzc;
            } else if (i7 == 1) {
                zzdrVar.zzc(i4, Long.valueOf(zzc(bArr, i5)));
                return i5 + 8;
            } else if (i7 == 2) {
                int zzb = zzb(bArr, i5, zzrVar);
                int i8 = zzrVar.zzdz;
                if (i8 >= 0) {
                    if (i8 <= bArr.length - zzb) {
                        if (i8 == 0) {
                            zzdrVar.zzc(i4, zzw.zzeg);
                        } else {
                            zzdrVar.zzc(i4, zzw.zzc(bArr, zzb, i8));
                        }
                        return zzb + i8;
                    }
                    throw zzbk.zzbp();
                }
                throw zzbk.zzbq();
            } else if (i7 != 3) {
                if (i7 == 5) {
                    zzdrVar.zzc(i4, Integer.valueOf(zzb(bArr, i5)));
                    return i5 + 4;
                }
                throw zzbk.zzbr();
            } else {
                zzdr zzdi = zzdr.zzdi();
                int i9 = (i4 & (-8)) | 4;
                int i10 = 0;
                while (true) {
                    if (i5 >= i6) {
                        break;
                    }
                    int zzb2 = zzb(bArr, i5, zzrVar);
                    int i11 = zzrVar.zzdz;
                    i10 = i11;
                    if (i11 == i9) {
                        i5 = zzb2;
                        break;
                    }
                    int zzb3 = zzb(i10, bArr, zzb2, i6, zzdi, zzrVar);
                    i10 = i11;
                    i5 = zzb3;
                }
                if (i5 <= i6 && i10 == i9) {
                    zzdrVar.zzc(i4, zzdi);
                    return i5;
                }
                throw zzbk.zzbt();
            }
        }
        throw zzbk.zzbr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(int i4, byte[] bArr, int i5, int i6, zzr zzrVar) throws zzbk {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                return i5 + 4;
                            }
                            throw zzbk.zzbr();
                        }
                        int i8 = (i4 & (-8)) | 4;
                        int i9 = 0;
                        while (i5 < i6) {
                            i5 = zzb(bArr, i5, zzrVar);
                            i9 = zzrVar.zzdz;
                            if (i9 == i8) {
                                break;
                            }
                            i5 = zzb(i9, bArr, i5, i6, zzrVar);
                        }
                        if (i5 > i6 || i9 != i8) {
                            throw zzbk.zzbt();
                        }
                        return i5;
                    }
                    return zzb(bArr, i5, zzrVar) + zzrVar.zzdz;
                }
                return i5 + 8;
            }
            return zzc(bArr, i5, zzrVar);
        }
        throw zzbk.zzbr();
    }
}
