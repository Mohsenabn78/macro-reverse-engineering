package com.google.android.gms.dynamic;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zag implements zah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zag(DeferredLifecycleHelper deferredLifecycleHelper) {
        this.f20829a = deferredLifecycleHelper;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f20829a.f20807a;
        lifecycleDelegate2.onResume();
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 5;
    }
}
