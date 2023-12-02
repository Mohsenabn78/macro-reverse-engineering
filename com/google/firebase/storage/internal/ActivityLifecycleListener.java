package com.google.firebase.storage.internal;

import android.app.Activity;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.internal.LifecycleActivity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class ActivityLifecycleListener {

    /* renamed from: c  reason: collision with root package name */
    private static final ActivityLifecycleListener f32346c = new ActivityLifecycleListener();

    /* renamed from: a  reason: collision with root package name */
    private final Map<Object, LifecycleEntry> f32347a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Object f32348b = new Object();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class LifecycleEntry {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final Activity f32349a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        private final Runnable f32350b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        private final Object f32351c;

        public LifecycleEntry(@NonNull Activity activity, @NonNull Runnable runnable, @NonNull Object obj) {
            this.f32349a = activity;
            this.f32350b = runnable;
            this.f32351c = obj;
        }

        @NonNull
        public Activity a() {
            return this.f32349a;
        }

        @NonNull
        public Object b() {
            return this.f32351c;
        }

        @NonNull
        public Runnable c() {
            return this.f32350b;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof LifecycleEntry)) {
                return false;
            }
            LifecycleEntry lifecycleEntry = (LifecycleEntry) obj;
            if (!lifecycleEntry.f32351c.equals(this.f32351c) || lifecycleEntry.f32350b != this.f32350b || lifecycleEntry.f32349a != this.f32349a) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f32351c.hashCode();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static class OnStopCallback extends LifecycleCallback {

        /* renamed from: a  reason: collision with root package name */
        private final List<LifecycleEntry> f32352a;

        private OnStopCallback(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.f32352a = new ArrayList();
            this.mLifecycleFragment.addCallback("StorageOnStopCallback", this);
        }

        public static OnStopCallback b(Activity activity) {
            LifecycleFragment fragment = LifecycleCallback.getFragment(new LifecycleActivity(activity));
            OnStopCallback onStopCallback = (OnStopCallback) fragment.getCallbackOrNull("StorageOnStopCallback", OnStopCallback.class);
            if (onStopCallback == null) {
                return new OnStopCallback(fragment);
            }
            return onStopCallback;
        }

        public void a(LifecycleEntry lifecycleEntry) {
            synchronized (this.f32352a) {
                this.f32352a.add(lifecycleEntry);
            }
        }

        public void c(LifecycleEntry lifecycleEntry) {
            synchronized (this.f32352a) {
                this.f32352a.remove(lifecycleEntry);
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        @MainThread
        public void onStop() {
            ArrayList arrayList;
            synchronized (this.f32352a) {
                arrayList = new ArrayList(this.f32352a);
                this.f32352a.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                LifecycleEntry lifecycleEntry = (LifecycleEntry) it.next();
                if (lifecycleEntry != null) {
                    lifecycleEntry.c().run();
                    ActivityLifecycleListener.getInstance().removeCookie(lifecycleEntry.b());
                }
            }
        }
    }

    private ActivityLifecycleListener() {
    }

    @NonNull
    public static ActivityLifecycleListener getInstance() {
        return f32346c;
    }

    public void removeCookie(@NonNull Object obj) {
        synchronized (this.f32348b) {
            LifecycleEntry lifecycleEntry = this.f32347a.get(obj);
            if (lifecycleEntry != null) {
                OnStopCallback.b(lifecycleEntry.a()).c(lifecycleEntry);
            }
        }
    }

    public void runOnActivityStopped(@NonNull Activity activity, @NonNull Object obj, @NonNull Runnable runnable) {
        synchronized (this.f32348b) {
            LifecycleEntry lifecycleEntry = new LifecycleEntry(activity, runnable, obj);
            OnStopCallback.b(activity).a(lifecycleEntry);
            this.f32347a.put(obj, lifecycleEntry);
        }
    }
}
