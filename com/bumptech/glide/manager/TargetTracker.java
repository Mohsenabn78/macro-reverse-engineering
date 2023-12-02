package com.bumptech.glide.manager;

import androidx.annotation.NonNull;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.Util;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class TargetTracker implements LifecycleListener {

    /* renamed from: a  reason: collision with root package name */
    private final Set<Target<?>> f17372a = Collections.newSetFromMap(new WeakHashMap());

    public void clear() {
        this.f17372a.clear();
    }

    @NonNull
    public List<Target<?>> getAll() {
        return Util.getSnapshot(this.f17372a);
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
        for (Target target : Util.getSnapshot(this.f17372a)) {
            target.onDestroy();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        for (Target target : Util.getSnapshot(this.f17372a)) {
            target.onStart();
        }
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        for (Target target : Util.getSnapshot(this.f17372a)) {
            target.onStop();
        }
    }

    public void track(@NonNull Target<?> target) {
        this.f17372a.add(target);
    }

    public void untrack(@NonNull Target<?> target) {
        this.f17372a.remove(target);
    }
}
