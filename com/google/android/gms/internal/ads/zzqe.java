package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzqe implements zzow {
    final /* synthetic */ zzqf zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzqe(zzqf zzqfVar, zzqd zzqdVar) {
        this.zza = zzqfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final void zza(Exception exc) {
        zzer.zzd("MediaCodecAudioRenderer", "Audio sink error", exc);
        zzqf.zzX(this.zza).zzb(exc);
    }

    @Override // com.google.android.gms.internal.ads.zzow
    public final void zzb() {
        zzqf zzqfVar = this.zza;
        if (zzqf.zzW(zzqfVar) != null) {
            zzqf.zzW(zzqfVar).zzb();
        }
    }
}
