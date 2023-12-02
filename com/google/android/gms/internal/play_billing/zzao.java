package com.google.android.gms.internal.play_billing;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public final class zzao {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zza(byte[] bArr, int i4, zzan zzanVar) throws zzci {
        int zzj = zzj(bArr, i4, zzanVar);
        int i5 = zzanVar.zza;
        if (i5 >= 0) {
            if (i5 <= bArr.length - zzj) {
                if (i5 == 0) {
                    zzanVar.zzc = zzba.zzb;
                    return zzj;
                }
                zzanVar.zzc = zzba.zzl(bArr, zzj, i5);
                return zzj + i5;
            }
            throw zzci.zzg();
        }
        throw zzci.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(byte[] bArr, int i4) {
        int i5 = (bArr[i4 + 1] & 255) << 8;
        return ((bArr[i4 + 3] & 255) << 24) | i5 | (bArr[i4] & 255) | ((bArr[i4 + 2] & 255) << 16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzc(zzdp zzdpVar, byte[] bArr, int i4, int i5, int i6, zzan zzanVar) throws IOException {
        Object zze = zzdpVar.zze();
        int zzn = zzn(zze, zzdpVar, bArr, i4, i5, i6, zzanVar);
        zzdpVar.zzf(zze);
        zzanVar.zzc = zze;
        return zzn;
    }

    static int zzd(zzdp zzdpVar, byte[] bArr, int i4, int i5, zzan zzanVar) throws IOException {
        Object zze = zzdpVar.zze();
        int zzo = zzo(zze, zzdpVar, bArr, i4, i5, zzanVar);
        zzdpVar.zzf(zze);
        zzanVar.zzc = zze;
        return zzo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zze(zzdp zzdpVar, int i4, byte[] bArr, int i5, int i6, zzcf zzcfVar, zzan zzanVar) throws IOException {
        int zzd = zzd(zzdpVar, bArr, i5, i6, zzanVar);
        zzcfVar.add(zzanVar.zzc);
        while (zzd < i6) {
            int zzj = zzj(bArr, zzd, zzanVar);
            if (i4 != zzanVar.zza) {
                break;
            }
            zzd = zzd(zzdpVar, bArr, zzj, i6, zzanVar);
            zzcfVar.add(zzanVar.zzc);
        }
        return zzd;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzf(byte[] bArr, int i4, zzcf zzcfVar, zzan zzanVar) throws IOException {
        zzcc zzccVar = (zzcc) zzcfVar;
        int zzj = zzj(bArr, i4, zzanVar);
        int i5 = zzanVar.zza + zzj;
        while (zzj < i5) {
            zzj = zzj(bArr, zzj, zzanVar);
            zzccVar.zzf(zzanVar.zza);
        }
        if (zzj == i5) {
            return zzj;
        }
        throw zzci.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzg(byte[] bArr, int i4, zzan zzanVar) throws zzci {
        int zzj = zzj(bArr, i4, zzanVar);
        int i5 = zzanVar.zza;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzanVar.zzc = "";
                return zzj;
            }
            zzanVar.zzc = new String(bArr, zzj, i5, zzcg.zzb);
            return zzj + i5;
        }
        throw zzci.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzh(byte[] bArr, int i4, zzan zzanVar) throws zzci {
        int zzj = zzj(bArr, i4, zzanVar);
        int i5 = zzanVar.zza;
        if (i5 >= 0) {
            if (i5 == 0) {
                zzanVar.zzc = "";
                return zzj;
            }
            int i6 = zzev.zza;
            int length = bArr.length;
            if ((((length - zzj) - i5) | zzj | i5) >= 0) {
                int i7 = zzj + i5;
                char[] cArr = new char[i5];
                int i8 = 0;
                while (zzj < i7) {
                    byte b4 = bArr[zzj];
                    if (!zzer.zzd(b4)) {
                        break;
                    }
                    zzj++;
                    cArr[i8] = (char) b4;
                    i8++;
                }
                while (zzj < i7) {
                    int i9 = zzj + 1;
                    byte b5 = bArr[zzj];
                    if (zzer.zzd(b5)) {
                        int i10 = i8 + 1;
                        cArr[i8] = (char) b5;
                        zzj = i9;
                        while (true) {
                            i8 = i10;
                            if (zzj < i7) {
                                byte b6 = bArr[zzj];
                                if (zzer.zzd(b6)) {
                                    zzj++;
                                    i10 = i8 + 1;
                                    cArr[i8] = (char) b6;
                                }
                            }
                        }
                    } else if (b5 < -32) {
                        if (i9 < i7) {
                            zzer.zzc(b5, bArr[i9], cArr, i8);
                            zzj = i9 + 1;
                            i8++;
                        } else {
                            throw zzci.zzc();
                        }
                    } else if (b5 < -16) {
                        if (i9 < i7 - 1) {
                            int i11 = i9 + 1;
                            zzer.zzb(b5, bArr[i9], bArr[i11], cArr, i8);
                            zzj = i11 + 1;
                            i8++;
                        } else {
                            throw zzci.zzc();
                        }
                    } else if (i9 < i7 - 2) {
                        int i12 = i9 + 1;
                        byte b7 = bArr[i9];
                        int i13 = i12 + 1;
                        zzer.zza(b5, b7, bArr[i12], bArr[i13], cArr, i8);
                        i8 += 2;
                        zzj = i13 + 1;
                    } else {
                        throw zzci.zzc();
                    }
                }
                zzanVar.zzc = new String(cArr, 0, i8);
                return i7;
            }
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", Integer.valueOf(length), Integer.valueOf(zzj), Integer.valueOf(i5)));
        }
        throw zzci.zzd();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzi(int i4, byte[] bArr, int i5, int i6, zzeh zzehVar, zzan zzanVar) throws zzci {
        if ((i4 >>> 3) != 0) {
            int i7 = i4 & 7;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != 2) {
                        if (i7 != 3) {
                            if (i7 == 5) {
                                zzehVar.zzj(i4, Integer.valueOf(zzb(bArr, i5)));
                                return i5 + 4;
                            }
                            throw zzci.zzb();
                        }
                        int i8 = (i4 & (-8)) | 4;
                        zzeh zzf = zzeh.zzf();
                        int i9 = 0;
                        while (true) {
                            if (i5 >= i6) {
                                break;
                            }
                            int zzj = zzj(bArr, i5, zzanVar);
                            int i10 = zzanVar.zza;
                            i9 = i10;
                            if (i10 != i8) {
                                int zzi = zzi(i9, bArr, zzj, i6, zzf, zzanVar);
                                i9 = i10;
                                i5 = zzi;
                            } else {
                                i5 = zzj;
                                break;
                            }
                        }
                        if (i5 <= i6 && i9 == i8) {
                            zzehVar.zzj(i4, zzf);
                            return i5;
                        }
                        throw zzci.zze();
                    }
                    int zzj2 = zzj(bArr, i5, zzanVar);
                    int i11 = zzanVar.zza;
                    if (i11 >= 0) {
                        if (i11 <= bArr.length - zzj2) {
                            if (i11 == 0) {
                                zzehVar.zzj(i4, zzba.zzb);
                            } else {
                                zzehVar.zzj(i4, zzba.zzl(bArr, zzj2, i11));
                            }
                            return zzj2 + i11;
                        }
                        throw zzci.zzg();
                    }
                    throw zzci.zzd();
                }
                zzehVar.zzj(i4, Long.valueOf(zzp(bArr, i5)));
                return i5 + 8;
            }
            int zzm = zzm(bArr, i5, zzanVar);
            zzehVar.zzj(i4, Long.valueOf(zzanVar.zzb));
            return zzm;
        }
        throw zzci.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzj(byte[] bArr, int i4, zzan zzanVar) {
        int i5 = i4 + 1;
        byte b4 = bArr[i4];
        if (b4 >= 0) {
            zzanVar.zza = b4;
            return i5;
        }
        return zzk(b4, bArr, i5, zzanVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzk(int i4, byte[] bArr, int i5, zzan zzanVar) {
        byte b4 = bArr[i5];
        int i6 = i5 + 1;
        int i7 = i4 & 127;
        if (b4 >= 0) {
            zzanVar.zza = i7 | (b4 << 7);
            return i6;
        }
        int i8 = i7 | ((b4 & Byte.MAX_VALUE) << 7);
        int i9 = i6 + 1;
        byte b5 = bArr[i6];
        if (b5 >= 0) {
            zzanVar.zza = i8 | (b5 << Ascii.SO);
            return i9;
        }
        int i10 = i8 | ((b5 & Byte.MAX_VALUE) << 14);
        int i11 = i9 + 1;
        byte b6 = bArr[i9];
        if (b6 >= 0) {
            zzanVar.zza = i10 | (b6 << Ascii.NAK);
            return i11;
        }
        int i12 = i10 | ((b6 & Byte.MAX_VALUE) << 21);
        int i13 = i11 + 1;
        byte b7 = bArr[i11];
        if (b7 >= 0) {
            zzanVar.zza = i12 | (b7 << Ascii.FS);
            return i13;
        }
        int i14 = i12 | ((b7 & Byte.MAX_VALUE) << 28);
        while (true) {
            int i15 = i13 + 1;
            if (bArr[i13] < 0) {
                i13 = i15;
            } else {
                zzanVar.zza = i14;
                return i15;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzl(int i4, byte[] bArr, int i5, int i6, zzcf zzcfVar, zzan zzanVar) {
        zzcc zzccVar = (zzcc) zzcfVar;
        int zzj = zzj(bArr, i5, zzanVar);
        zzccVar.zzf(zzanVar.zza);
        while (zzj < i6) {
            int zzj2 = zzj(bArr, zzj, zzanVar);
            if (i4 != zzanVar.zza) {
                break;
            }
            zzj = zzj(bArr, zzj2, zzanVar);
            zzccVar.zzf(zzanVar.zza);
        }
        return zzj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzm(byte[] bArr, int i4, zzan zzanVar) {
        long j4 = bArr[i4];
        int i5 = i4 + 1;
        if (j4 >= 0) {
            zzanVar.zzb = j4;
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
        zzanVar.zzb = j5;
        return i6;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzn(Object obj, zzdp zzdpVar, byte[] bArr, int i4, int i5, int i6, zzan zzanVar) throws IOException {
        int zzc = ((zzdi) zzdpVar).zzc(obj, bArr, i4, i5, i6, zzanVar);
        zzanVar.zzc = obj;
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzo(Object obj, zzdp zzdpVar, byte[] bArr, int i4, int i5, zzan zzanVar) throws IOException {
        int i6 = i4 + 1;
        int i7 = bArr[i4];
        if (i7 < 0) {
            i6 = zzk(i7, bArr, i6, zzanVar);
            i7 = zzanVar.zza;
        }
        int i8 = i6;
        if (i7 >= 0 && i7 <= i5 - i8) {
            int i9 = i7 + i8;
            zzdpVar.zzh(obj, bArr, i8, i9, zzanVar);
            zzanVar.zzc = obj;
            return i9;
        }
        throw zzci.zzg();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long zzp(byte[] bArr, int i4) {
        return (bArr[i4] & 255) | ((bArr[i4 + 1] & 255) << 8) | ((bArr[i4 + 2] & 255) << 16) | ((bArr[i4 + 3] & 255) << 24) | ((bArr[i4 + 4] & 255) << 32) | ((bArr[i4 + 5] & 255) << 40) | ((bArr[i4 + 6] & 255) << 48) | ((bArr[i4 + 7] & 255) << 56);
    }
}
