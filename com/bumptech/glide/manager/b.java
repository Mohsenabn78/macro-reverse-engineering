package com.bumptech.glide.manager;

import androidx.annotation.NonNull;

/* compiled from: ApplicationLifecycle.java */
/* loaded from: classes3.dex */
class b implements Lifecycle {
    @Override // com.bumptech.glide.manager.Lifecycle
    public void addListener(@NonNull LifecycleListener lifecycleListener) {
        lifecycleListener.onStart();
    }

    @Override // com.bumptech.glide.manager.Lifecycle
    public void removeListener(@NonNull LifecycleListener lifecycleListener) {
    }
}
