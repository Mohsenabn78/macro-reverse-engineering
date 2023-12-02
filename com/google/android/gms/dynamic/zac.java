package com.google.android.gms.dynamic;

import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zac implements zah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bundle f20819a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20820b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zac(DeferredLifecycleHelper deferredLifecycleHelper, Bundle bundle) {
        this.f20820b = deferredLifecycleHelper;
        this.f20819a = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f20820b.f20807a;
        lifecycleDelegate2.onCreate(this.f20819a);
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 1;
    }
}
