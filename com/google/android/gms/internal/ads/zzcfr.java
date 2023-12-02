package com.google.android.gms.internal.ads;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcfr implements Runnable {
    final /* synthetic */ zzcfs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzcfr(zzcfs zzcfsVar) {
        this.zza = zzcfsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        super/*android.webkit.WebView*/.destroy();
    }
}
