package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzaqi implements zzfke {
    final /* synthetic */ zzfjb zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaqi(zzfjb zzfjbVar) {
        this.zza = zzfjbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfke
    public final void zza(int i4, long j4) {
        this.zza.zzd(i4, System.currentTimeMillis() - j4);
    }

    @Override // com.google.android.gms.internal.ads.zzfke
    public final void zzb(int i4, long j4, String str) {
        this.zza.zze(i4, System.currentTimeMillis() - j4, str);
    }
}
