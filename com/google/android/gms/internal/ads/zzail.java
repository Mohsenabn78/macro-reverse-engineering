package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzail implements zzaij {
    private static final double[] zza = {23.976023976023978d, 24.0d, 25.0d, 29.97002997002997d, 30.0d, 50.0d, 59.94005994005994d, 60.0d};
    private String zzb;
    private zzabz zzc;
    @Nullable
    private final zzajy zzd;
    @Nullable
    private final zzfa zze;
    @Nullable
    private final zzaiy zzf;
    private final boolean[] zzg;
    private final zzaik zzh;
    private long zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;

    public zzail() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e2  */
    @Override // com.google.android.gms.internal.ads.zzaij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzfa r21) {
        /*
            Method dump skipped, instructions count: 492
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzail.zza(com.google.android.gms.internal.ads.zzfa):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzb = zzajvVar.zzb();
        this.zzc = zzaazVar.zzv(zzajvVar.zza(), 2);
        zzajy zzajyVar = this.zzd;
        if (zzajyVar != null) {
            zzajyVar.zzb(zzaazVar, zzajvVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        this.zzm = j4;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        zzfu.zzf(this.zzg);
        this.zzh.zzb();
        zzaiy zzaiyVar = this.zzf;
        if (zzaiyVar != null) {
            zzaiyVar.zzb();
        }
        this.zzi = 0L;
        this.zzj = false;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzail(@Nullable zzajy zzajyVar) {
        zzfa zzfaVar;
        this.zzd = zzajyVar;
        this.zzg = new boolean[4];
        this.zzh = new zzaik(128);
        if (zzajyVar != null) {
            this.zzf = new zzaiy(178, 128);
            zzfaVar = new zzfa();
        } else {
            zzfaVar = null;
            this.zzf = null;
        }
        this.zze = zzfaVar;
        this.zzm = -9223372036854775807L;
        this.zzo = -9223372036854775807L;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
