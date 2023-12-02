package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafm  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzafm {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i4, zzafl zzaflVar) throws zzahl {
        int zzh = zzh(bArr, i4, zzaflVar);
        int i5 = zzaflVar.zza;
        if (i5 >= 0) {
            if (i5 <= bArr.length - zzh) {
                if (i5 == 0) {
                    zzaflVar.zzc = zzafy.zzb;
                    return zzh;
                }
                zzaflVar.zzc = zzafy.zzn(bArr, zzh, i5);
                return zzh + i5;
            }
            throw zzahl.zzj();
        }
        throw zzahl.zzf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4) {
        int i5 = (bArr[i4 + 1] & 255) << 8;
        return ((bArr[i4 + 3] & 255) << 24) | i5 | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzaiu zzaiuVar, byte[] bArr, int i4, int i5, int i6, zzafl zzaflVar) throws IOException {
        Object zze = zzaiuVar.zze();
        int zzl = zzl(zze, zzaiuVar, bArr, i4, i5, i6, zzaflVar);
        zzaiuVar.zzf(zze);
        zzaflVar.zzc = zze;
        return zzl;
    }

    static int zzd(zzaiu zzaiuVar, byte[] bArr, int i4, int i5, zzafl zzaflVar) throws IOException {
        Object zze = zzaiuVar.zze();
        int zzm = zzm(zze, zzaiuVar, bArr, i4, i5, zzaflVar);
        zzaiuVar.zzf(zze);
        zzaflVar.zzc = zze;
        return zzm;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzaiu zzaiuVar, int i4, byte[] bArr, int i5, int i6, zzahi zzahiVar, zzafl zzaflVar) throws IOException {
        int zzd = zzd(zzaiuVar, bArr, i5, i6, zzaflVar);
        zzahiVar.add(zzaflVar.zzc);
        while (zzd < i6) {
            int zzh = zzh(bArr, zzd, zzaflVar);
            if (i4 != zzaflVar.zza) {
                break;
            }
            zzd = zzd(zzaiuVar, bArr, zzh, i6, zzaflVar);
            zzahiVar.add(zzaflVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i4, zzahi zzahiVar, zzafl zzaflVar) throws IOException {
        zzahe zzaheVar = (zzahe) zzahiVar;
        int zzh = zzh(bArr, i4, zzaflVar);
        int i5 = zzaflVar.zza + zzh;
        while (zzh < i5) {
            zzh = zzh(bArr, zzh, zzaflVar);
            zzaheVar.zzf(zzaflVar.zza);
        }
        if (zzh == i5) {
            return zzh;
        }
        throw zzahl.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(int i4, byte[] bArr, int i5, int i6, zzajp zzajpVar, zzafl zzaflVar) throws zzahl {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                zzajpVar.zzj(i4, Integer.valueOf(zzb(bArr, i5)));
                                return i5 + 4;
                            }
                            throw zzahl.zzc();
                        }
                        int i8 = (i4 & (-8)) | 4;
                        zzajp zzf = zzajp.zzf();
                        int i9 = 0;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            int zzh = zzh(bArr, i5, zzaflVar);
                            int i10 = zzaflVar.zza;
                            i9 = i10;
                            if (i10 != i8) {
                                int zzg = zzg(i9, bArr, zzh, i6, zzf, zzaflVar);
                                i9 = i10;
                                i5 = zzg;
                            } else {
                                i5 = zzh;
                                break;
                            }
                        }
                        if (i5 <= i6 && i9 == i8) {
                            zzajpVar.zzj(i4, zzf);
                            return i5;
                        }
                        throw zzahl.zzg();
                    }
                    int zzh2 = zzh(bArr, i5, zzaflVar);
                    int i11 = zzaflVar.zza;
                    if (i11 >= 0) {
                        if (i11 <= bArr.length - zzh2) {
                            if (i11 == 0) {
                                zzajpVar.zzj(i4, zzafy.zzb);
                            } else {
                                zzajpVar.zzj(i4, zzafy.zzn(bArr, zzh2, i11));
                            }
                            return zzh2 + i11;
                        }
                        throw zzahl.zzj();
                    }
                    throw zzahl.zzf();
                }
                zzajpVar.zzj(i4, Long.valueOf(zzn(bArr, i5)));
                return i5 + 8;
            }
            int zzk = zzk(bArr, i5, zzaflVar);
            zzajpVar.zzj(i4, Long.valueOf(zzaflVar.zzb));
            return zzk;
        }
        throw zzahl.zzc();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i4, zzafl zzaflVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 >= 0) {
            zzaflVar.zza = b4;
            return i5;
        }
        return zzi(b4, bArr, i5, zzaflVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, byte[] bArr, int i5, zzafl zzaflVar) {
        byte b4 = bArr[i5];
        int i6 = i5 + 1;
        int i7 = i4 & 127;
        if (b4 >= 0) {
            zzaflVar.zza = i7 | (b4 << 7);
            return i6;
        }
        int i8 = i7 | ((b4 & Byte.MAX_VALUE) << 7);
        int i9 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            zzaflVar.zza = i8 | (b5 << Ascii.SO);
            return i9;
        }
        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 14);
        int i11 = i9 + 1;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzaflVar.zza = i10 | (b6 << Ascii.NAK);
            return i11;
        }
        int i12 = i10 | ((b6 & Byte.MAX_VALUE) << 21);
        int i13 = i11 + 1;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzaflVar.zza = i12 | (b7 << Ascii.FS);
            return i13;
        }
        int i14 = i12 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] < 0) {
                i13 = i15;
            } else {
                zzaflVar.zza = i14;
                return i15;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(int i4, byte[] bArr, int i5, int i6, zzahi zzahiVar, zzafl zzaflVar) {
        zzahe zzaheVar = (zzahe) zzahiVar;
        int zzh = zzh(bArr, i5, zzaflVar);
        zzaheVar.zzf(zzaflVar.zza);
        while (zzh < i6) {
            int zzh2 = zzh(bArr, zzh, zzaflVar);
            if (i4 != zzaflVar.zza) {
                break;
            }
            zzh = zzh(bArr, zzh2, zzaflVar);
            zzaheVar.zzf(zzaflVar.zza);
        }
        return zzh;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(byte[] bArr, int i4, zzafl zzaflVar) {
        long j4 = bArr[i4];
        int i5 = i4 + 1;
        if (j4 >= 0) {
            zzaflVar.zzb = j4;
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
        zzaflVar.zzb = j5;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(Object obj, zzaiu zzaiuVar, byte[] bArr, int i4, int i5, int i6, zzafl zzaflVar) throws IOException {
        int zzc = ((zzail) zzaiuVar).zzc(obj, bArr, i4, i5, i6, zzaflVar);
        zzaflVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(Object obj, zzaiu zzaiuVar, byte[] bArr, int i4, int i5, zzafl zzaflVar) throws IOException {
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        if (i7 < 0) {
            i6 = zzi(i7, bArr, i6, zzaflVar);
            i7 = zzaflVar.zza;
        }
        int i8 = i6;
        if (i7 >= 0 && i7 <= i5 - i8) {
            int i9 = i7 + i8;
            zzaiuVar.zzi(obj, bArr, i8, i9, zzaflVar);
            zzaflVar.zzc = obj;
            return i9;
        }
        throw zzahl.zzj();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzn(byte[] bArr, int i4) {
        return (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48) | ((bArr[i4 + 7] & 255) << 56);
    }
}
