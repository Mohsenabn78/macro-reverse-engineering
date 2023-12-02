package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzcbl implements Runnable {
    final /* synthetic */ zzcbo zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcbl(zzcbo zzcboVar) {
        this.zza = zzcboVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzK("surfaceCreated", new String[0]);
    }
}
