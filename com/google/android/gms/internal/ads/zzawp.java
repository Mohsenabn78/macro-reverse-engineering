package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawp extends zzcaj {
    final /* synthetic */ zzawv zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawp(zzawv zzawvVar) {
        this.zza = zzawvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcaj, java.util.concurrent.Future
    public final boolean cancel(boolean z3) {
        zzawv.zze(this.zza);
        return super.cancel(z3);
    }
}
