package com.google.firebase.storage;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.storage.StorageTask;
import com.google.firebase.storage.StorageTask.ProvideError;
import com.google.firebase.storage.internal.ActivityLifecycleListener;
import com.google.firebase.storage.internal.SmartHandler;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class TaskListenerImpl<ListenerTypeT, ResultT extends StorageTask.ProvideError> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<ListenerTypeT> f32301a = new ConcurrentLinkedQueue();

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<ListenerTypeT, SmartHandler> f32302b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private StorageTask<ResultT> f32303c;

    /* renamed from: d  reason: collision with root package name */
    private int f32304d;

    /* renamed from: e  reason: collision with root package name */
    private OnRaise<ListenerTypeT, ResultT> f32305e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public interface OnRaise<ListenerTypeT, ResultT> {
        void a(@NonNull ListenerTypeT listenertypet, @NonNull ResultT resultt);
    }

    public TaskListenerImpl(@NonNull StorageTask<ResultT> storageTask, int i4, @NonNull OnRaise<ListenerTypeT, ResultT> onRaise) {
        this.f32303c = storageTask;
        this.f32304d = i4;
        this.f32305e = onRaise;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Object obj, StorageTask.ProvideError provideError) {
        this.f32305e.a(obj, provideError);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Object obj, StorageTask.ProvideError provideError) {
        this.f32305e.a(obj, provideError);
    }

    public void d(@Nullable Activity activity, @Nullable Executor executor, @NonNull final ListenerTypeT listenertypet) {
        boolean z3;
        SmartHandler smartHandler;
        Preconditions.checkNotNull(listenertypet);
        synchronized (this.f32303c.r()) {
            boolean z4 = true;
            if ((this.f32303c.m() & this.f32304d) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            this.f32301a.add(listenertypet);
            smartHandler = new SmartHandler(executor);
            this.f32302b.put(listenertypet, smartHandler);
            if (activity != null) {
                if (activity.isDestroyed()) {
                    z4 = false;
                }
                Preconditions.checkArgument(z4, "Activity is already destroyed!");
                ActivityLifecycleListener.getInstance().runOnActivityStopped(activity, listenertypet, new Runnable() { // from class: com.google.firebase.storage.p
                    @Override // java.lang.Runnable
                    public final void run() {
                        TaskListenerImpl.this.e(listenertypet);
                    }
                });
            }
        }
        if (z3) {
            final ResultT K = this.f32303c.K();
            smartHandler.callBack(new Runnable() { // from class: com.google.firebase.storage.q
                @Override // java.lang.Runnable
                public final void run() {
                    TaskListenerImpl.this.f(listenertypet, K);
                }
            });
        }
    }

    public void h() {
        if ((this.f32303c.m() & this.f32304d) != 0) {
            final ResultT K = this.f32303c.K();
            for (final ListenerTypeT listenertypet : this.f32301a) {
                SmartHandler smartHandler = this.f32302b.get(listenertypet);
                if (smartHandler != null) {
                    smartHandler.callBack(new Runnable() { // from class: com.google.firebase.storage.o
                        @Override // java.lang.Runnable
                        public final void run() {
                            TaskListenerImpl.this.g(listenertypet, K);
                        }
                    });
                }
            }
        }
    }

    /* renamed from: i */
    public void e(@NonNull ListenerTypeT listenertypet) {
        Preconditions.checkNotNull(listenertypet);
        synchronized (this.f32303c.r()) {
            this.f32302b.remove(listenertypet);
            this.f32301a.remove(listenertypet);
            ActivityLifecycleListener.getInstance().removeCookie(listenertypet);
        }
    }
}
