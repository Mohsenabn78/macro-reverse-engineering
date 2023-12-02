package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaiw implements zzaij {
    @Nullable
    private final String zza;
    private final zzfa zzb;
    private final zzez zzc;
    private zzabz zzd;
    private String zze;
    private zzam zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private long zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private long zzq;
    private int zzr;
    private long zzs;
    private int zzt;
    @Nullable
    private String zzu;

    public zzaiw(@Nullable String str) {
        this.zza = str;
        zzfa zzfaVar = new zzfa(1024);
        this.zzb = zzfaVar;
        byte[] zzH = zzfaVar.zzH();
        this.zzc = new zzez(zzH, zzH.length);
        this.zzk = -9223372036854775807L;
    }

    private final int zzf(zzez zzezVar) throws zzcd {
        int zza = zzezVar.zza();
        zzzt zzb = zzzu.zzb(zzezVar, true);
        this.zzu = zzb.zzc;
        this.zzr = zzb.zza;
        this.zzt = zzb.zzb;
        return zza - zzezVar.zza();
    }

    private static long zzg(zzez zzezVar) {
        return zzezVar.zzd((zzezVar.zzd(2) + 1) * 8);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x0154, code lost:
        if (r14.zzl == false) goto L105;
     */
    @Override // com.google.android.gms.internal.ads.zzaij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzfa r15) throws com.google.android.gms.internal.ads.zzcd {
        /*
            Method dump skipped, instructions count: 537
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiw.zza(com.google.android.gms.internal.ads.zzfa):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzd = zzaazVar.zzv(zzajvVar.zza(), 1);
        this.zze = zzajvVar.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        if (j4 != -9223372036854775807L) {
            this.zzk = j4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zzg = 0;
        this.zzk = -9223372036854775807L;
        this.zzl = false;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
