package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzen {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i4, zzem zzemVar) throws zzgy {
        int zzj = zzj(bArr, i4, zzemVar);
        int i5 = zzemVar.zza;
        if (i5 >= 0) {
            if (i5 <= bArr.length - zzj) {
                if (i5 == 0) {
                    zzemVar.zzc = zzez.zzb;
                    return zzj;
                }
                zzemVar.zzc = zzez.zzm(bArr, zzj, i5);
                return zzj + i5;
            }
            throw zzgy.zzj();
        }
        throw zzgy.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4) {
        int i5 = (bArr[i4 + 1] & 255) << 8;
        return ((bArr[i4 + 3] & 255) << 24) | i5 | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzil zzilVar, byte[] bArr, int i4, int i5, int i6, zzem zzemVar) throws IOException {
        Object zze = zzilVar.zze();
        int zzn = zzn(zze, zzilVar, bArr, i4, i5, i6, zzemVar);
        zzilVar.zzf(zze);
        zzemVar.zzc = zze;
        return zzn;
    }

    static int zzd(zzil zzilVar, byte[] bArr, int i4, int i5, zzem zzemVar) throws IOException {
        Object zze = zzilVar.zze();
        int zzo = zzo(zze, zzilVar, bArr, i4, i5, zzemVar);
        zzilVar.zzf(zze);
        zzemVar.zzc = zze;
        return zzo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzil zzilVar, int i4, byte[] bArr, int i5, int i6, zzgv zzgvVar, zzem zzemVar) throws IOException {
        int zzd = zzd(zzilVar, bArr, i5, i6, zzemVar);
        zzgvVar.add(zzemVar.zzc);
        while (zzd < i6) {
            int zzj = zzj(bArr, zzd, zzemVar);
            if (i4 != zzemVar.zza) {
                break;
            }
            zzd = zzd(zzilVar, bArr, zzj, i6, zzemVar);
            zzgvVar.add(zzemVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i4, zzgv zzgvVar, zzem zzemVar) throws IOException {
        zzgp zzgpVar = (zzgp) zzgvVar;
        int zzj = zzj(bArr, i4, zzemVar);
        int i5 = zzemVar.zza + zzj;
        while (zzj < i5) {
            zzj = zzj(bArr, zzj, zzemVar);
            zzgpVar.zzg(zzemVar.zza);
        }
        if (zzj == i5) {
            return zzj;
        }
        throw zzgy.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i4, zzem zzemVar) throws zzgy {
        int zzj = zzj(bArr, i4, zzemVar);
        int i5 = zzemVar.zza;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzemVar.zzc = "";
                return zzj;
            }
            zzemVar.zzc = new String(bArr, zzj, i5, zzgw.zzb);
            return zzj + i5;
        }
        throw zzgy.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i4, zzem zzemVar) throws zzgy {
        int zzj = zzj(bArr, i4, zzemVar);
        int i5 = zzemVar.zza;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzemVar.zzc = "";
                return zzj;
            }
            zzemVar.zzc = zzju.zzd(bArr, zzj, i5);
            return zzj + i5;
        }
        throw zzgy.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, byte[] bArr, int i5, int i6, zzjg zzjgVar, zzem zzemVar) throws zzgy {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                zzjgVar.zzj(i4, Integer.valueOf(zzb(bArr, i5)));
                                return i5 + 4;
                            }
                            throw zzgy.zzc();
                        }
                        int i8 = (i4 & (-8)) | 4;
                        zzjg zzf = zzjg.zzf();
                        int i9 = 0;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            int zzj = zzj(bArr, i5, zzemVar);
                            int i10 = zzemVar.zza;
                            i9 = i10;
                            if (i10 != i8) {
                                int zzi = zzi(i9, bArr, zzj, i6, zzf, zzemVar);
                                i9 = i10;
                                i5 = zzi;
                            } else {
                                i5 = zzj;
                                break;
                            }
                        }
                        if (i5 <= i6 && i9 == i8) {
                            zzjgVar.zzj(i4, zzf);
                            return i5;
                        }
                        throw zzgy.zzg();
                    }
                    int zzj2 = zzj(bArr, i5, zzemVar);
                    int i11 = zzemVar.zza;
                    if (i11 >= 0) {
                        if (i11 <= bArr.length - zzj2) {
                            if (i11 == 0) {
                                zzjgVar.zzj(i4, zzez.zzb);
                            } else {
                                zzjgVar.zzj(i4, zzez.zzm(bArr, zzj2, i11));
                            }
                            return zzj2 + i11;
                        }
                        throw zzgy.zzj();
                    }
                    throw zzgy.zzf();
                }
                zzjgVar.zzj(i4, Long.valueOf(zzq(bArr, i5)));
                return i5 + 8;
            }
            int zzm = zzm(bArr, i5, zzemVar);
            zzjgVar.zzj(i4, Long.valueOf(zzemVar.zzb));
            return zzm;
        }
        throw zzgy.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i4, zzem zzemVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 >= 0) {
            zzemVar.zza = b4;
            return i5;
        }
        return zzk(b4, bArr, i5, zzemVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i4, byte[] bArr, int i5, zzem zzemVar) {
        byte b4 = bArr[i5];
        int i6 = i5 + 1;
        int i7 = i4 & 127;
        if (b4 >= 0) {
            zzemVar.zza = i7 | (b4 << 7);
            return i6;
        }
        int i8 = i7 | ((b4 & Byte.MAX_VALUE) << 7);
        int i9 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            zzemVar.zza = i8 | (b5 << Ascii.SO);
            return i9;
        }
        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 14);
        int i11 = i9 + 1;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzemVar.zza = i10 | (b6 << Ascii.NAK);
            return i11;
        }
        int i12 = i10 | ((b6 & Byte.MAX_VALUE) << 21);
        int i13 = i11 + 1;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzemVar.zza = i12 | (b7 << Ascii.FS);
            return i13;
        }
        int i14 = i12 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] < 0) {
                i13 = i15;
            } else {
                zzemVar.zza = i14;
                return i15;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i4, byte[] bArr, int i5, int i6, zzgv zzgvVar, zzem zzemVar) {
        zzgp zzgpVar = (zzgp) zzgvVar;
        int zzj = zzj(bArr, i5, zzemVar);
        zzgpVar.zzg(zzemVar.zza);
        while (zzj < i6) {
            int zzj2 = zzj(bArr, zzj, zzemVar);
            if (i4 != zzemVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzemVar);
            zzgpVar.zzg(zzemVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i4, zzem zzemVar) {
        long j4 = bArr[i4];
        int i5 = i4 + 1;
        if (j4 >= 0) {
            zzemVar.zzb = j4;
            return i5;
        }
        int i6 = i5 + 1;
        byte b4 = bArr[i5];
        long j5 = (j4 & 127) | ((b4 & Byte.MAX_VALUE) << 7);
        int i7 = 7;
        while (b4 < 0) {
            int i8 = i6 + 1;
            byte b5 = bArr[i6];
            i7 += 7;
            j5 |= (b5 & Byte.MAX_VALUE) << i7;
            i6 = i8;
            b4 = b5;
        }
        zzemVar.zzb = j5;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(Object obj, zzil zzilVar, byte[] bArr, int i4, int i5, int i6, zzem zzemVar) throws IOException {
        int zzc = ((zzib) zzilVar).zzc(obj, bArr, i4, i5, i6, zzemVar);
        zzemVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(Object obj, zzil zzilVar, byte[] bArr, int i4, int i5, zzem zzemVar) throws IOException {
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        if (i7 < 0) {
            i6 = zzk(i7, bArr, i6, zzemVar);
            i7 = zzemVar.zza;
        }
        int i8 = i6;
        if (i7 >= 0 && i7 <= i5 - i8) {
            int i9 = i7 + i8;
            zzilVar.zzi(obj, bArr, i8, i9, zzemVar);
            zzemVar.zzc = obj;
            return i9;
        }
        throw zzgy.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzp(int i4, byte[] bArr, int i5, int i6, zzem zzemVar) throws zzgy {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                return i5 + 4;
                            }
                            throw zzgy.zzc();
                        }
                        int i8 = (i4 & (-8)) | 4;
                        int i9 = 0;
                        while (i5 < i6) {
                            i5 = zzj(bArr, i5, zzemVar);
                            i9 = zzemVar.zza;
                            if (i9 == i8) {
                                break;
                            }
                            i5 = zzp(i9, bArr, i5, i6, zzemVar);
                        }
                        if (i5 <= i6 && i9 == i8) {
                            return i5;
                        }
                        throw zzgy.zzg();
                    }
                    return zzj(bArr, i5, zzemVar) + zzemVar.zza;
                }
                return i5 + 8;
            }
            return zzm(bArr, i5, zzemVar);
        }
        throw zzgy.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzq(byte[] bArr, int i4) {
        return (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48) | ((bArr[i4 + 7] & 255) << 56);
    }
}
