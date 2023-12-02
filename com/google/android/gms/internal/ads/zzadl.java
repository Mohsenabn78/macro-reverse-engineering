package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzadl implements zzaaz {
    private final long zzb;
    private final zzaaz zzc;

    public zzadl(long j4, zzaaz zzaazVar) {
        this.zzb = j4;
        this.zzc = zzaazVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final void zzC() {
        this.zzc.zzC();
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final void zzN(zzabv zzabvVar) {
        this.zzc.zzN(new zzadk(this, zzabvVar));
    }

    @Override // com.google.android.gms.internal.ads.zzaaz
    public final zzabz zzv(int i4, int i5) {
        return this.zzc.zzv(i4, i5);
    }
}
