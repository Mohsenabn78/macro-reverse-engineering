package com.google.android.gms.common.api.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@VisibleForTesting(otherwise = 2)
/* loaded from: classes4.dex */
final class zaa extends LifecycleCallback {

    /* renamed from: a  reason: collision with root package name */
    private List f20112a;

    private zaa(LifecycleFragment lifecycleFragment) {
        super(lifecycleFragment);
        this.f20112a = new ArrayList();
        this.mLifecycleFragment.addCallback("LifecycleObserverOnStop", this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ zaa a(Activity activity) {
        zaa zaaVar;
        synchronized (activity) {
            LifecycleFragment fragment = LifecycleCallback.getFragment(activity);
            zaaVar = (zaa) fragment.getCallbackOrNull("LifecycleObserverOnStop", zaa.class);
            if (zaaVar == null) {
                zaaVar = new zaa(fragment);
            }
        }
        return zaaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized void c(Runnable runnable) {
        this.f20112a.add(runnable);
    }

    @Override // com.google.android.gms.common.api.internal.LifecycleCallback
    @MainThread
    public final void onStop() {
        List<Runnable> list;
        synchronized (this) {
            list = this.f20112a;
            this.f20112a = new ArrayList();
        }
        for (Runnable runnable : list) {
            runnable.run();
        }
    }
}
