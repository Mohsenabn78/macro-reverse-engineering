package com.google.firebase.firestore.auth;

import android.annotation.SuppressLint;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;

/* loaded from: classes5.dex */
public final class FirebaseAppCheckTokenProvider extends CredentialsProvider<String> {
    @Nullable
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private Listener<String> f30250a;
    @Nullable
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private InteropAppCheckTokenProvider f30251b;
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private boolean f30252c;

    /* renamed from: d  reason: collision with root package name */
    private final AppCheckTokenListener f30253d = new AppCheckTokenListener() { // from class: com.google.firebase.firestore.auth.a
        @Override // com.google.firebase.appcheck.interop.AppCheckTokenListener
        public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
            FirebaseAppCheckTokenProvider.this.e(appCheckTokenResult);
        }
    };

    @SuppressLint({"ProviderAssignment"})
    public FirebaseAppCheckTokenProvider(Deferred<InteropAppCheckTokenProvider> deferred) {
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.firestore.auth.b
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                FirebaseAppCheckTokenProvider.this.f(provider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task d(Task task) throws Exception {
        if (task.isSuccessful()) {
            return Tasks.forResult(((AppCheckTokenResult) task.getResult()).getToken());
        }
        return Tasks.forException(task.getException());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(Provider provider) {
        synchronized (this) {
            InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
            this.f30251b = interopAppCheckTokenProvider;
            if (interopAppCheckTokenProvider != null) {
                interopAppCheckTokenProvider.addAppCheckTokenListener(this.f30253d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public synchronized void e(@NonNull AppCheckTokenResult appCheckTokenResult) {
        if (appCheckTokenResult.getError() != null) {
            Logger.warn("FirebaseAppCheckTokenProvider", "Error getting App Check token; using placeholder token instead. Error: " + appCheckTokenResult.getError(), new Object[0]);
        }
        Listener<String> listener = this.f30250a;
        if (listener != null) {
            listener.onValue(appCheckTokenResult.getToken());
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized Task<String> getToken() {
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = this.f30251b;
        if (interopAppCheckTokenProvider == null) {
            return Tasks.forException(new FirebaseApiNotAvailableException("AppCheck is not available"));
        }
        Task<AppCheckTokenResult> token = interopAppCheckTokenProvider.getToken(this.f30252c);
        this.f30252c = false;
        return token.continueWithTask(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.auth.c
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task d4;
                d4 = FirebaseAppCheckTokenProvider.d(task);
                return d4;
            }
        });
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void invalidateToken() {
        this.f30252c = true;
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void removeChangeListener() {
        this.f30250a = null;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = this.f30251b;
        if (interopAppCheckTokenProvider != null) {
            interopAppCheckTokenProvider.removeAppCheckTokenListener(this.f30253d);
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void setChangeListener(@NonNull Listener<String> listener) {
        this.f30250a = listener;
    }
}
