package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class AsyncEventListener<T> implements EventListener<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Executor f30304a;

    /* renamed from: b  reason: collision with root package name */
    private final EventListener<T> f30305b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f30306c = false;

    public AsyncEventListener(Executor executor, EventListener<T> eventListener) {
        this.f30304a = executor;
        this.f30305b = eventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
        if (!this.f30306c) {
            this.f30305b.onEvent(obj, firebaseFirestoreException);
        }
    }

    public void mute() {
        this.f30306c = true;
    }

    @Override // com.google.firebase.firestore.EventListener
    public void onEvent(@Nullable final T t3, @Nullable final FirebaseFirestoreException firebaseFirestoreException) {
        this.f30304a.execute(new Runnable() { // from class: com.google.firebase.firestore.core.d
            @Override // java.lang.Runnable
            public final void run() {
                AsyncEventListener.this.b(t3, firebaseFirestoreException);
            }
        });
    }
}
