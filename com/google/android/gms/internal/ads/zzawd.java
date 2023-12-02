package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzawd implements Runnable {
    final /* synthetic */ zzawh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzawd(zzawh zzawhVar) {
        this.zza = zzawhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzawh.zzh(this.zza);
    }
}
