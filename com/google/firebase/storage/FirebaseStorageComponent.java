package com.google.firebase.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.inject.Provider;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class FirebaseStorageComponent {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseStorage> f32206a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f32207b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final Provider<InternalAuthProvider> f32208c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final Provider<InteropAppCheckTokenProvider> f32209d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseStorageComponent(@NonNull FirebaseApp firebaseApp, @Nullable Provider<InternalAuthProvider> provider, @Nullable Provider<InteropAppCheckTokenProvider> provider2, @NonNull @Blocking Executor executor, @NonNull @UiThread Executor executor2) {
        this.f32207b = firebaseApp;
        this.f32208c = provider;
        this.f32209d = provider2;
        StorageTaskScheduler.initializeExecutors(executor, executor2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public synchronized FirebaseStorage a(@Nullable String str) {
        FirebaseStorage firebaseStorage;
        firebaseStorage = this.f32206a.get(str);
        if (firebaseStorage == null) {
            firebaseStorage = new FirebaseStorage(str, this.f32207b, this.f32208c, this.f32209d);
            this.f32206a.put(str, firebaseStorage);
        }
        return firebaseStorage;
    }
}
