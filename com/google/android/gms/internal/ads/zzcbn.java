package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcbn implements Runnable {
    final /* synthetic */ boolean zza;
    final /* synthetic */ zzcbo zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbn(zzcbo zzcboVar, boolean z3) {
        this.zzb = zzcboVar;
        this.zza = z3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzK("windowVisibilityChanged", "isVisible", String.valueOf(this.zza));
    }
}
