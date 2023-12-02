package com.google.android.gms.common.api.internal;

import androidx.annotation.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public final class zab extends ActivityLifecycleObserver {

    /* renamed from: a  reason: collision with root package name */
    private final WeakReference f20184a;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting(otherwise = 2)
    public zab(zaa zaaVar) {
        this.f20184a = new WeakReference(zaaVar);
    }

    @Override // com.google.android.gms.common.api.internal.ActivityLifecycleObserver
    @CanIgnoreReturnValue
    public final ActivityLifecycleObserver onStopCallOnce(Runnable runnable) {
        zaa zaaVar = (zaa) this.f20184a.get();
        if (zaaVar != null) {
            zaaVar.c(runnable);
            return this;
        }
        throw new IllegalStateException("The target activity has already been GC'd");
    }
}
