package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzgm;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzgm f22875a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22876b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs(zzaa zzaaVar, zzgm zzgmVar) {
        this.f22876b = zzaaVar;
        this.f22875a = zzgmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22876b.f22866b.onPeerConnected(this.f22875a);
    }
}
