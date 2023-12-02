package com.google.firebase.messaging;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class TopicsStore {
    @GuardedBy("TopicsStore.class")

    /* renamed from: d  reason: collision with root package name */
    private static WeakReference<TopicsStore> f31739d;

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f31740a;

    /* renamed from: b  reason: collision with root package name */
    private SharedPreferencesQueue f31741b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f31742c;

    private TopicsStore(SharedPreferences sharedPreferences, Executor executor) {
        this.f31742c = executor;
        this.f31740a = sharedPreferences;
    }

    @WorkerThread
    public static synchronized TopicsStore b(Context context, Executor executor) {
        TopicsStore topicsStore;
        synchronized (TopicsStore.class) {
            WeakReference<TopicsStore> weakReference = f31739d;
            if (weakReference != null) {
                topicsStore = weakReference.get();
            } else {
                topicsStore = null;
            }
            if (topicsStore == null) {
                topicsStore = new TopicsStore(context.getSharedPreferences("com.google.android.gms.appid", 0), executor);
                topicsStore.d();
                f31739d = new WeakReference<>(topicsStore);
            }
        }
        return topicsStore;
    }

    @WorkerThread
    private synchronized void d() {
        this.f31741b = SharedPreferencesQueue.d(this.f31740a, "topic_operation_queue", ",", this.f31742c);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean a(TopicOperation topicOperation) {
        return this.f31741b.b(topicOperation.e());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public synchronized TopicOperation c() {
        return TopicOperation.a(this.f31741b.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized boolean e(TopicOperation topicOperation) {
        return this.f31741b.g(topicOperation.e());
    }
}
