package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzatf implements Runnable {
    final /* synthetic */ zzatg zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzatf(zzatg zzatgVar) {
        this.zza = zzatgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzatg.zzb(this.zza);
    }
}
