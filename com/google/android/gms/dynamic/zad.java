package com.google.android.gms.dynamic;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zad implements zah {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FrameLayout f20821a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ LayoutInflater f20822b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ ViewGroup f20823c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Bundle f20824d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ DeferredLifecycleHelper f20825e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zad(DeferredLifecycleHelper deferredLifecycleHelper, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f20825e = deferredLifecycleHelper;
        this.f20821a = frameLayout;
        this.f20822b = layoutInflater;
        this.f20823c = viewGroup;
        this.f20824d = bundle;
    }

    @Override // com.google.android.gms.dynamic.zah
    public final void a(LifecycleDelegate lifecycleDelegate) {
        LifecycleDelegate lifecycleDelegate2;
        this.f20821a.removeAllViews();
        FrameLayout frameLayout = this.f20821a;
        lifecycleDelegate2 = this.f20825e.f20807a;
        frameLayout.addView(lifecycleDelegate2.onCreateView(this.f20822b, this.f20823c, this.f20824d));
    }

    @Override // com.google.android.gms.dynamic.zah
    public final int zaa() {
        return 2;
    }
}
