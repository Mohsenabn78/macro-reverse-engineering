package com.google.android.gms.internal.ads;

import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzuy {
    private final zzfa zza = new zzfa(32);
    private zzux zzb;
    private zzux zzc;
    private zzux zzd;
    private long zze;
    private final zzxp zzf;

    public zzuy(zzxp zzxpVar) {
        this.zzf = zzxpVar;
        zzux zzuxVar = new zzux(0L, 65536);
        this.zzb = zzuxVar;
        this.zzc = zzuxVar;
        this.zzd = zzuxVar;
    }

    private final int zzi(int i4) {
        zzux zzuxVar = this.zzd;
        if (zzuxVar.zzc == null) {
            zzxi zzb = this.zzf.zzb();
            zzux zzuxVar2 = new zzux(this.zzd.zzb, 65536);
            zzuxVar.zzc = zzb;
            zzuxVar.zzd = zzuxVar2;
        }
        return Math.min(i4, (int) (this.zzd.zzb - this.zze));
    }

    private static zzux zzj(zzux zzuxVar, long j4) {
        while (j4 >= zzuxVar.zzb) {
            zzuxVar = zzuxVar.zzd;
        }
        return zzuxVar;
    }

    private static zzux zzk(zzux zzuxVar, long j4, ByteBuffer byteBuffer, int i4) {
        zzux zzj = zzj(zzuxVar, j4);
        while (i4 > 0) {
            int min = Math.min(i4, (int) (zzj.zzb - j4));
            byteBuffer.put(zzj.zzc.zza, zzj.zza(j4), min);
            i4 -= min;
            j4 += min;
            if (j4 == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzux zzl(zzux zzuxVar, long j4, byte[] bArr, int i4) {
        zzux zzj = zzj(zzuxVar, j4);
        int i5 = i4;
        while (i5 > 0) {
            int min = Math.min(i5, (int) (zzj.zzb - j4));
            System.arraycopy(zzj.zzc.zza, zzj.zza(j4), bArr, i4 - i5, min);
            i5 -= min;
            j4 += min;
            if (j4 == zzj.zzb) {
                zzj = zzj.zzd;
            }
        }
        return zzj;
    }

    private static zzux zzm(zzux zzuxVar, zzhp zzhpVar, zzva zzvaVar, zzfa zzfaVar) {
        zzux zzuxVar2;
        boolean z3;
        int i4;
        if (zzhpVar.zzl()) {
            long j4 = zzvaVar.zzb;
            zzfaVar.zzC(1);
            zzux zzl = zzl(zzuxVar, j4, zzfaVar.zzH(), 1);
            long j5 = j4 + 1;
            byte b4 = zzfaVar.zzH()[0];
            int i5 = b4 & 128;
            int i6 = b4 & Byte.MAX_VALUE;
            zzhm zzhmVar = zzhpVar.zza;
            byte[] bArr = zzhmVar.zza;
            if (bArr == null) {
                zzhmVar.zza = new byte[16];
            } else {
                Arrays.fill(bArr, (byte) 0);
            }
            if (i5 != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            zzuxVar2 = zzl(zzl, j5, zzhmVar.zza, i6);
            long j6 = j5 + i6;
            if (z3) {
                zzfaVar.zzC(2);
                zzuxVar2 = zzl(zzuxVar2, j6, zzfaVar.zzH(), 2);
                j6 += 2;
                i4 = zzfaVar.zzo();
            } else {
                i4 = 1;
            }
            int[] iArr = zzhmVar.zzd;
            if (iArr == null || iArr.length < i4) {
                iArr = new int[i4];
            }
            int[] iArr2 = iArr;
            int[] iArr3 = zzhmVar.zze;
            if (iArr3 == null || iArr3.length < i4) {
                iArr3 = new int[i4];
            }
            int[] iArr4 = iArr3;
            if (z3) {
                int i7 = i4 * 6;
                zzfaVar.zzC(i7);
                zzuxVar2 = zzl(zzuxVar2, j6, zzfaVar.zzH(), i7);
                j6 += i7;
                zzfaVar.zzF(0);
                for (int i8 = 0; i8 < i4; i8++) {
                    iArr2[i8] = zzfaVar.zzo();
                    iArr4[i8] = zzfaVar.zzn();
                }
            } else {
                iArr2[0] = 0;
                iArr4[0] = zzvaVar.zza - ((int) (j6 - zzvaVar.zzb));
            }
            zzaby zzabyVar = zzvaVar.zzc;
            int i9 = zzfj.zza;
            zzhmVar.zzc(i4, iArr2, iArr4, zzabyVar.zzb, zzhmVar.zza, zzabyVar.zza, zzabyVar.zzc, zzabyVar.zzd);
            long j7 = zzvaVar.zzb;
            int i10 = (int) (j6 - j7);
            zzvaVar.zzb = j7 + i10;
            zzvaVar.zza -= i10;
        } else {
            zzuxVar2 = zzuxVar;
        }
        if (zzhpVar.zze()) {
            zzfaVar.zzC(4);
            zzux zzl2 = zzl(zzuxVar2, zzvaVar.zzb, zzfaVar.zzH(), 4);
            int zzn = zzfaVar.zzn();
            zzvaVar.zzb += 4;
            zzvaVar.zza -= 4;
            zzhpVar.zzj(zzn);
            zzux zzk = zzk(zzl2, zzvaVar.zzb, zzhpVar.zzb, zzn);
            zzvaVar.zzb += zzn;
            int i11 = zzvaVar.zza - zzn;
            zzvaVar.zza = i11;
            ByteBuffer byteBuffer = zzhpVar.zze;
            if (byteBuffer != null && byteBuffer.capacity() >= i11) {
                zzhpVar.zze.clear();
            } else {
                zzhpVar.zze = ByteBuffer.allocate(i11);
            }
            return zzk(zzk, zzvaVar.zzb, zzhpVar.zze, zzvaVar.zza);
        }
        zzhpVar.zzj(zzvaVar.zza);
        return zzk(zzuxVar2, zzvaVar.zzb, zzhpVar.zzb, zzvaVar.zza);
    }

    private final void zzn(int i4) {
        long j4 = this.zze + i4;
        this.zze = j4;
        zzux zzuxVar = this.zzd;
        if (j4 == zzuxVar.zzb) {
            this.zzd = zzuxVar.zzd;
        }
    }

    public final int zza(zzt zztVar, int i4, boolean z3) throws IOException {
        int zzi = zzi(i4);
        zzux zzuxVar = this.zzd;
        int zza = zztVar.zza(zzuxVar.zzc.zza, zzuxVar.zza(this.zze), zzi);
        if (zza == -1) {
            if (z3) {
                return -1;
            }
            throw new EOFException();
        }
        zzn(zza);
        return zza;
    }

    public final long zzb() {
        return this.zze;
    }

    public final void zzc(long j4) {
        zzux zzuxVar;
        if (j4 != -1) {
            while (true) {
                zzuxVar = this.zzb;
                if (j4 < zzuxVar.zzb) {
                    break;
                }
                this.zzf.zzc(zzuxVar.zzc);
                this.zzb = this.zzb.zzb();
            }
            if (this.zzc.zza < zzuxVar.zza) {
                this.zzc = zzuxVar;
            }
        }
    }

    public final void zzd(zzhp zzhpVar, zzva zzvaVar) {
        zzm(this.zzc, zzhpVar, zzvaVar, this.zza);
    }

    public final void zze(zzhp zzhpVar, zzva zzvaVar) {
        this.zzc = zzm(this.zzc, zzhpVar, zzvaVar, this.zza);
    }

    public final void zzf() {
        zzux zzuxVar = this.zzb;
        if (zzuxVar.zzc != null) {
            this.zzf.zzd(zzuxVar);
            zzuxVar.zzb();
        }
        this.zzb.zze(0L, 65536);
        zzux zzuxVar2 = this.zzb;
        this.zzc = zzuxVar2;
        this.zzd = zzuxVar2;
        this.zze = 0L;
        this.zzf.zzg();
    }

    public final void zzg() {
        this.zzc = this.zzb;
    }

    public final void zzh(zzfa zzfaVar, int i4) {
        while (i4 > 0) {
            int zzi = zzi(i4);
            zzux zzuxVar = this.zzd;
            zzfaVar.zzB(zzuxVar.zzc.zza, zzuxVar.zza(this.zze), zzi);
            i4 -= zzi;
            zzn(zzi);
        }
    }
}
