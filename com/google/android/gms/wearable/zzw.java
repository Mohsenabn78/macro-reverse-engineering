package com.google.android.gms.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzw implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.wearable.internal.zzl f22883a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22884b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzw(zzaa zzaaVar, com.google.android.gms.wearable.internal.zzl zzlVar) {
        this.f22884b = zzaaVar;
        this.f22883a = zzlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22884b.f22866b.onNotificationReceived(this.f22883a);
    }
}
