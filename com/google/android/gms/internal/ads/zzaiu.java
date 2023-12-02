package com.google.android.gms.internal.ads;

import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaiu implements zzaij {
    private final zzajk zza;
    private String zzb;
    private zzabz zzc;
    private zzait zzd;
    private boolean zze;
    private long zzl;
    private final boolean[] zzf = new boolean[3];
    private final zzaiy zzg = new zzaiy(32, 128);
    private final zzaiy zzh = new zzaiy(33, 128);
    private final zzaiy zzi = new zzaiy(34, 128);
    private final zzaiy zzj = new zzaiy(39, 128);
    private final zzaiy zzk = new zzaiy(40, 128);
    private long zzm = -9223372036854775807L;
    private final zzfa zzn = new zzfa();

    public zzaiu(zzajk zzajkVar) {
        this.zza = zzajkVar;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i4, int i5) {
        this.zzd.zzb(bArr, i4, i5);
        if (!this.zze) {
            this.zzg.zza(bArr, i4, i5);
            this.zzh.zza(bArr, i4, i5);
            this.zzi.zza(bArr, i4, i5);
        }
        this.zzj.zza(bArr, i4, i5);
        this.zzk.zza(bArr, i4, i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0181  */
    @Override // com.google.android.gms.internal.ads.zzaij
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(com.google.android.gms.internal.ads.zzfa r32) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaiu.zza(com.google.android.gms.internal.ads.zzfa):void");
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzb(zzaaz zzaazVar, zzajv zzajvVar) {
        zzajvVar.zzc();
        this.zzb = zzajvVar.zzb();
        zzabz zzv = zzaazVar.zzv(zzajvVar.zza(), 2);
        this.zzc = zzv;
        this.zzd = new zzait(zzv);
        this.zza.zzb(zzaazVar, zzajvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzd(long j4, int i4) {
        if (j4 != -9223372036854775807L) {
            this.zzm = j4;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zze() {
        this.zzl = 0L;
        this.zzm = -9223372036854775807L;
        zzfu.zzf(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzait zzaitVar = this.zzd;
        if (zzaitVar != null) {
            zzaitVar.zzc();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaij
    public final void zzc() {
    }
}
