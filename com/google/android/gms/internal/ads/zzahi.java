package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzahi implements zzahp {
    private final zzaho zza;
    private final long zzb;
    private final long zzc;
    private final zzahu zzd;
    private int zze;
    private long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzahi(zzahu zzahuVar, long j4, long j5, long j6, long j7, boolean z3) {
        boolean z4;
        if (j4 >= 0 && j5 > j4) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzdy.zzd(z4);
        this.zzd = zzahuVar;
        this.zzb = j4;
        this.zzc = j5;
        if (j6 != j5 - j4 && !z3) {
            this.zze = 0;
        } else {
            this.zzf = j7;
            this.zze = 4;
        }
        this.zza = new zzaho();
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00ae A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00af  */
    @Override // com.google.android.gms.internal.ads.zzahp
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzd(com.google.android.gms.internal.ads.zzaax r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 364
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzahi.zzd(com.google.android.gms.internal.ads.zzaax):long");
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    @Nullable
    public final /* bridge */ /* synthetic */ zzabv zze() {
        if (this.zzf == 0) {
            return null;
        }
        return new zzahh(this, null);
    }

    @Override // com.google.android.gms.internal.ads.zzahp
    public final void zzg(long j4) {
        this.zzh = Math.max(0L, Math.min(j4, this.zzf - 1));
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0L;
        this.zzl = this.zzf;
    }
}
