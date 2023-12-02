package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zzc implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f20345a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f20346b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzd f20347c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzc(zzd zzdVar, LifecycleCallback lifecycleCallback, String str) {
        this.f20347c = zzdVar;
        this.f20345a = lifecycleCallback;
        this.f20346b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        Bundle bundle;
        Bundle bundle2;
        Bundle bundle3;
        zzd zzdVar = this.f20347c;
        i4 = zzdVar.f20350c;
        if (i4 > 0) {
            LifecycleCallback lifecycleCallback = this.f20345a;
            bundle = zzdVar.f20351d;
            if (bundle != null) {
                bundle3 = zzdVar.f20351d;
                bundle2 = bundle3.getBundle(this.f20346b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i5 = this.f20347c.f20350c;
        if (i5 >= 2) {
            this.f20345a.onStart();
        }
        i6 = this.f20347c.f20350c;
        if (i6 >= 3) {
            this.f20345a.onResume();
        }
        i7 = this.f20347c.f20350c;
        if (i7 >= 4) {
            this.f20345a.onStop();
        }
        i8 = this.f20347c.f20350c;
        if (i8 >= 5) {
            this.f20345a.onDestroy();
        }
    }
}
