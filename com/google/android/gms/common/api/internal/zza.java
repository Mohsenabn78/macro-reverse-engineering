package com.google.android.gms.common.api.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
final class zza implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ LifecycleCallback f20338a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ String f20339b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ zzb f20340c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zza(zzb zzbVar, LifecycleCallback lifecycleCallback, String str) {
        this.f20340c = zzbVar;
        this.f20338a = lifecycleCallback;
        this.f20339b = str;
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
        zzb zzbVar = this.f20340c;
        i4 = zzbVar.f20343b;
        if (i4 > 0) {
            LifecycleCallback lifecycleCallback = this.f20338a;
            bundle = zzbVar.f20344c;
            if (bundle != null) {
                bundle3 = zzbVar.f20344c;
                bundle2 = bundle3.getBundle(this.f20339b);
            } else {
                bundle2 = null;
            }
            lifecycleCallback.onCreate(bundle2);
        }
        i5 = this.f20340c.f20343b;
        if (i5 >= 2) {
            this.f20338a.onStart();
        }
        i6 = this.f20340c.f20343b;
        if (i6 >= 3) {
            this.f20338a.onResume();
        }
        i7 = this.f20340c.f20343b;
        if (i7 >= 4) {
            this.f20338a.onStop();
        }
        i8 = this.f20340c.f20343b;
        if (i8 >= 5) {
            this.f20338a.onDestroy();
        }
    }
}
