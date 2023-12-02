package com.google.android.gms.dynamic;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zab implements zah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Activity f20815a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Bundle f20816b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Bundle f20817c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20818d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zab(DeferredLifecycleHelper deferredLifecycleHelper, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f20818d = deferredLifecycleHelper;
        this.f20815a = activity;
        this.f20816b = bundle;
        this.f20817c = bundle2;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        lifecycleDelegate2 = this.f20818d.f20807a;
        lifecycleDelegate2.onInflate(this.f20815a, this.f20816b, this.f20817c);
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 0;
    }
}
