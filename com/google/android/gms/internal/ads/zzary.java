package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzary implements Runnable {
    final /* synthetic */ zzasa zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzary(zzasa zzasaVar) {
        this.zza = zzasaVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzf();
    }
}
