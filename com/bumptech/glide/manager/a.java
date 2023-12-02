package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.Set;
import java.util.WeakHashMap;

/* compiled from: ActivityFragmentLifecycle.java */
/* loaded from: classes3.dex */
class a implements Lifecycle {

    /* renamed from: a  reason: collision with root package name */
    private final Set<LifecycleListener> f17373a = Collections.newSetFromMap(new WeakHashMap());

    /* renamed from: b  reason: collision with root package name */
    private boolean f17374b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17375c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        this.f17375c = true;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.f17373a)) {
            lifecycleListener.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        this.f17373a.add(lifecycleListener);
        if (this.f17375c) {
            lifecycleListener.onDestroy();
        } else if (this.f17374b) {
            lifecycleListener.onStart();
        } else {
            lifecycleListener.onStop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f17374b = true;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.f17373a)) {
            lifecycleListener.onStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        this.f17374b = false;
        for (LifecycleListener lifecycleListener : Util.getSnapshot(this.f17373a)) {
            lifecycleListener.onStop();
        }
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
        this.f17373a.remove(lifecycleListener);
    }
}
