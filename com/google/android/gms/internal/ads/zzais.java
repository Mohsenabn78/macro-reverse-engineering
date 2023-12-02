package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzais implements zzaij {
    private final zzajk zza;
    private long zze;
    private String zzg;
    private zzabz zzh;
    private zzair zzi;
    private boolean zzj;
    private boolean zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzaiy zzb = new zzaiy(7, 128);
    private final zzaiy zzc = new zzaiy(8, 128);
    private final zzaiy zzd = new zzaiy(6, 128);
    private long zzk = -9223372036854775807L;
    private final zzfa zzm = new zzfa();

    public zzais(zzajk zzajkVar, boolean z3, boolean z4) {
        this.zza = zzajkVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i4, int i5) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i4, i5);
            this.zzc.zza(bArr, i4, i5);
        }
        this.zzd.zza(bArr, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0181 A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzaij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzfa r20) {
        /*
            Method dump skipped, instructions count: 405
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzais.zza(com.google.android.gms.internal.ads.zzfa):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzg = zzajvVar.zzb();
        zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 2);
        this.zzh = zzv;
        this.zzi = new zzair(zzv, false, false);
        this.zza.zzb(zzaazVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        boolean z3;
        if (j4 != -9223372036854775807L) {
            this.zzk = j4;
        }
        boolean z4 = this.zzl;
        if ((i4 & 2) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        this.zzl = z4 | z3;
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zze = 0L;
        this.zzl = false;
        this.zzk = -9223372036854775807L;
        zzfu.zzf(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzair zzairVar = this.zzi;
        if (zzairVar != null) {
            zzairVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
