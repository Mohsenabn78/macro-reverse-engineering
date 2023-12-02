package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zznv {
    final /* synthetic */ zznw zza;
    private final String zzb;
    private int zzc;
    private long zzd;
    private zzto zze;
    private boolean zzf;
    private boolean zzg;

    public zznv(zznw zznwVar, String str, @Nullable int i4, zzto zztoVar) {
        long j4;
        this.zza = zznwVar;
        this.zzb = str;
        this.zzc = i4;
        if (zztoVar == null) {
            j4 = -1;
        } else {
            j4 = zztoVar.zzd;
        }
        this.zzd = j4;
        if (zztoVar != null && zztoVar.zzb()) {
            this.zze = zztoVar;
        }
    }

    public final void zzg(int i4, @Nullable zzto zztoVar) {
        if (this.zzd == -1 && i4 == this.zzc && zztoVar != null) {
            this.zzd = zztoVar.zzd;
        }
    }

    public final boolean zzj(int i4, @Nullable zzto zztoVar) {
        if (zztoVar == null) {
            if (i4 == this.zzc) {
                return true;
            }
            return false;
        }
        zzto zztoVar2 = this.zze;
        if (zztoVar2 == null) {
            if (!zztoVar.zzb() && zztoVar.zzd == this.zzd) {
                return true;
            }
            return false;
        } else if (zztoVar.zzd == zztoVar2.zzd && zztoVar.zzb == zztoVar2.zzb && zztoVar.zzc == zztoVar2.zzc) {
            return true;
        } else {
            return false;
        }
    }

    public final boolean zzk(zzlt zzltVar) {
        zzto zztoVar = zzltVar.zzd;
        if (zztoVar == null) {
            if (this.zzc != zzltVar.zzc) {
                return true;
            }
            return false;
        }
        long j4 = this.zzd;
        if (j4 == -1) {
            return false;
        }
        if (zztoVar.zzd > j4) {
            return true;
        }
        if (this.zze == null) {
            return false;
        }
        int zza = zzltVar.zzb.zza(zztoVar.zza);
        int zza2 = zzltVar.zzb.zza(this.zze.zza);
        zzto zztoVar2 = zzltVar.zzd;
        if (zztoVar2.zzd < this.zze.zzd || zza < zza2) {
            return false;
        }
        if (zza > zza2) {
            return true;
        }
        if (zztoVar2.zzb()) {
            zzto zztoVar3 = zzltVar.zzd;
            int i4 = zztoVar3.zzb;
            int i5 = zztoVar3.zzc;
            zzto zztoVar4 = this.zze;
            int i6 = zztoVar4.zzb;
            if (i4 > i6) {
                return true;
            }
            if (i4 == i6 && i5 > zztoVar4.zzc) {
                return true;
            }
            return false;
        }
        int i7 = zzltVar.zzd.zze;
        if (i7 == -1 || i7 > this.zze.zzb) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000e, code lost:
        if (r0 < r8.zzc()) goto L6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzl(com.google.android.gms.internal.ads.zzcw r7, com.google.android.gms.internal.ads.zzcw r8) {
        /*
            r6 = this;
            int r0 = r6.zzc
            int r1 = r7.zzc()
            r2 = 0
            r3 = -1
            if (r0 < r1) goto L13
            int r7 = r8.zzc()
            if (r0 >= r7) goto L11
            goto L4a
        L11:
            r0 = -1
            goto L4a
        L13:
            com.google.android.gms.internal.ads.zznw r1 = r6.zza
            com.google.android.gms.internal.ads.zzcv r1 = com.google.android.gms.internal.ads.zznw.zzb(r1)
            r4 = 0
            r7.zze(r0, r1, r4)
            com.google.android.gms.internal.ads.zznw r0 = r6.zza
            com.google.android.gms.internal.ads.zzcv r0 = com.google.android.gms.internal.ads.zznw.zzb(r0)
            int r0 = r0.zzo
        L26:
            com.google.android.gms.internal.ads.zznw r1 = r6.zza
            com.google.android.gms.internal.ads.zzcv r1 = com.google.android.gms.internal.ads.zznw.zzb(r1)
            int r1 = r1.zzp
            if (r0 > r1) goto L11
            java.lang.Object r1 = r7.zzf(r0)
            int r1 = r8.zza(r1)
            if (r1 == r3) goto L47
            com.google.android.gms.internal.ads.zznw r7 = r6.zza
            com.google.android.gms.internal.ads.zzct r7 = com.google.android.gms.internal.ads.zznw.zza(r7)
            com.google.android.gms.internal.ads.zzct r7 = r8.zzd(r1, r7, r2)
            int r0 = r7.zzd
            goto L4a
        L47:
            int r0 = r0 + 1
            goto L26
        L4a:
            r6.zzc = r0
            if (r0 != r3) goto L4f
            return r2
        L4f:
            com.google.android.gms.internal.ads.zzto r7 = r6.zze
            r0 = 1
            if (r7 != 0) goto L55
            return r0
        L55:
            java.lang.Object r7 = r7.zza
            int r7 = r8.zza(r7)
            if (r7 == r3) goto L5e
            return r0
        L5e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznv.zzl(com.google.android.gms.internal.ads.zzcw, com.google.android.gms.internal.ads.zzcw):boolean");
    }
}
