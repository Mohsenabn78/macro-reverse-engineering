package com.google.android.gms.wearable;

import com.google.android.gms.wearable.internal.zzfx;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzr implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ zzfx f22873a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22874b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzr(zzaa zzaaVar, zzfx zzfxVar) {
        this.f22874b = zzaaVar;
        this.f22873a = zzfxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22874b.f22866b.onMessageReceived(this.f22873a);
    }
}
