package com.google.android.gms.wearable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
final class zzx implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.google.android.gms.wearable.internal.zzi f22885a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ zzaa f22886b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzx(zzaa zzaaVar, com.google.android.gms.wearable.internal.zzi zziVar) {
        this.f22886b = zzaaVar;
        this.f22885a = zziVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f22886b.f22866b.onEntityUpdate(this.f22885a);
    }
}
