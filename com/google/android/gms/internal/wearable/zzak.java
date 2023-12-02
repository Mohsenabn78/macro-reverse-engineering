package com.google.android.gms.internal.wearable;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzak {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i4, zzaj zzajVar) throws zzcf {
        int zzj = zzj(bArr, i4, zzajVar);
        int i5 = zzajVar.zza;
        if (i5 >= 0) {
            if (i5 <= bArr.length - zzj) {
                if (i5 == 0) {
                    zzajVar.zzc = zzaw.zzb;
                    return zzj;
                }
                zzajVar.zzc = zzaw.zzn(bArr, zzj, i5);
                return zzj + i5;
            }
            throw zzcf.zzg();
        }
        throw zzcf.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4) {
        return ((bArr[i4 + 3] & 255) << 24) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzdn zzdnVar, byte[] bArr, int i4, int i5, int i6, zzaj zzajVar) throws IOException {
        zzdf zzdfVar = (zzdf) zzdnVar;
        Object zze = zzdfVar.zze();
        int zzc = zzdfVar.zzc(zze, bArr, i4, i5, i6, zzajVar);
        zzdfVar.zzf(zze);
        zzajVar.zzc = zze;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzd(zzdn zzdnVar, byte[] bArr, int i4, int i5, zzaj zzajVar) throws IOException {
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        if (i7 < 0) {
            i6 = zzk(i7, bArr, i6, zzajVar);
            i7 = zzajVar.zza;
        }
        int i8 = i6;
        if (i7 >= 0 && i7 <= i5 - i8) {
            Object zze = zzdnVar.zze();
            int i9 = i7 + i8;
            zzdnVar.zzh(zze, bArr, i8, i9, zzajVar);
            zzdnVar.zzf(zze);
            zzajVar.zzc = zze;
            return i9;
        }
        throw zzcf.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzdn zzdnVar, int i4, byte[] bArr, int i5, int i6, zzcc zzccVar, zzaj zzajVar) throws IOException {
        int zzd = zzd(zzdnVar, bArr, i5, i6, zzajVar);
        zzccVar.add(zzajVar.zzc);
        while (zzd < i6) {
            int zzj = zzj(bArr, zzd, zzajVar);
            if (i4 != zzajVar.zza) {
                break;
            }
            zzd = zzd(zzdnVar, bArr, zzj, i6, zzajVar);
            zzccVar.add(zzajVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i4, zzcc zzccVar, zzaj zzajVar) throws IOException {
        zzbw zzbwVar = (zzbw) zzccVar;
        int zzj = zzj(bArr, i4, zzajVar);
        int i5 = zzajVar.zza + zzj;
        while (zzj < i5) {
            zzj = zzj(bArr, zzj, zzajVar);
            zzbwVar.zzf(zzajVar.zza);
        }
        if (zzj == i5) {
            return zzj;
        }
        throw zzcf.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i4, zzaj zzajVar) throws zzcf {
        int zzj = zzj(bArr, i4, zzajVar);
        int i5 = zzajVar.zza;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzajVar.zzc = "";
                return zzj;
            }
            zzajVar.zzc = new String(bArr, zzj, i5, zzcd.zzb);
            return zzj + i5;
        }
        throw zzcf.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i4, zzaj zzajVar) throws zzcf {
        int zzj = zzj(bArr, i4, zzajVar);
        int i5 = zzajVar.zza;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzajVar.zzc = "";
                return zzj;
            }
            zzajVar.zzc = zzet.zzd(bArr, zzj, i5);
            return zzj + i5;
        }
        throw zzcf.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, byte[] bArr, int i5, int i6, zzef zzefVar, zzaj zzajVar) throws zzcf {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                zzefVar.zzh(i4, Integer.valueOf(zzb(bArr, i5)));
                                return i5 + 4;
                            }
                            throw zzcf.zzb();
                        }
                        int i8 = (i4 & (-8)) | 4;
                        zzef zze = zzef.zze();
                        int i9 = 0;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            int zzj = zzj(bArr, i5, zzajVar);
                            int i10 = zzajVar.zza;
                            if (i10 == i8) {
                                i9 = i10;
                                i5 = zzj;
                                break;
                            }
                            i9 = i10;
                            i5 = zzi(i10, bArr, zzj, i6, zze, zzajVar);
                        }
                        if (i5 <= i6 && i9 == i8) {
                            zzefVar.zzh(i4, zze);
                            return i5;
                        }
                        throw zzcf.zze();
                    }
                    int zzj2 = zzj(bArr, i5, zzajVar);
                    int i11 = zzajVar.zza;
                    if (i11 >= 0) {
                        if (i11 <= bArr.length - zzj2) {
                            if (i11 == 0) {
                                zzefVar.zzh(i4, zzaw.zzb);
                            } else {
                                zzefVar.zzh(i4, zzaw.zzn(bArr, zzj2, i11));
                            }
                            return zzj2 + i11;
                        }
                        throw zzcf.zzg();
                    }
                    throw zzcf.zzd();
                }
                zzefVar.zzh(i4, Long.valueOf(zzn(bArr, i5)));
                return i5 + 8;
            }
            int zzm = zzm(bArr, i5, zzajVar);
            zzefVar.zzh(i4, Long.valueOf(zzajVar.zzb));
            return zzm;
        }
        throw zzcf.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i4, zzaj zzajVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 >= 0) {
            zzajVar.zza = b4;
            return i5;
        }
        return zzk(b4, bArr, i5, zzajVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i4, byte[] bArr, int i5, zzaj zzajVar) {
        int i6 = i4 & 127;
        int i7 = i5 + 1;
        byte b4 = bArr[i5];
        if (b4 >= 0) {
            zzajVar.zza = i6 | (b4 << 7);
            return i7;
        }
        int i8 = i6 | ((b4 & Byte.MAX_VALUE) << 7);
        int i9 = i7 + 1;
        byte b5 = bArr[i7];
        if (b5 >= 0) {
            zzajVar.zza = i8 | (b5 << Ascii.SO);
            return i9;
        }
        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 14);
        int i11 = i9 + 1;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzajVar.zza = i10 | (b6 << Ascii.NAK);
            return i11;
        }
        int i12 = i10 | ((b6 & Byte.MAX_VALUE) << 21);
        int i13 = i11 + 1;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzajVar.zza = i12 | (b7 << Ascii.FS);
            return i13;
        }
        int i14 = i12 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] < 0) {
                i13 = i15;
            } else {
                zzajVar.zza = i14;
                return i15;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i4, byte[] bArr, int i5, int i6, zzcc zzccVar, zzaj zzajVar) {
        zzbw zzbwVar = (zzbw) zzccVar;
        int zzj = zzj(bArr, i5, zzajVar);
        zzbwVar.zzf(zzajVar.zza);
        while (zzj < i6) {
            int zzj2 = zzj(bArr, zzj, zzajVar);
            if (i4 != zzajVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzajVar);
            zzbwVar.zzf(zzajVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i4, zzaj zzajVar) {
        byte b4;
        int i5 = i4 + 1;
        long j4 = bArr[i4];
        if (j4 >= 0) {
            zzajVar.zzb = j4;
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
        zzajVar.zzb = j5;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i4) {
        return ((bArr[i4 + 7] & 255) << 56) | (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48);
    }
}
