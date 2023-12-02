package com.google.firebase.firestore.auth;

import android.annotation.SuppressLint;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.IdTokenListener;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Listener;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.InternalTokenResult;

/* loaded from: classes5.dex */
public final class FirebaseAuthCredentialsProvider extends CredentialsProvider<User> {

    /* renamed from: a  reason: collision with root package name */
    private final IdTokenListener f30254a = new IdTokenListener() { // from class: com.google.firebase.firestore.auth.d
        @Override // com.google.firebase.auth.internal.IdTokenListener
        public final void onIdTokenChanged(InternalTokenResult internalTokenResult) {
            FirebaseAuthCredentialsProvider.this.f(internalTokenResult);
        }
    };
    @Nullable
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private InternalAuthProvider f30255b;
    @Nullable
    @GuardedBy("this")

    /* renamed from: c  reason: collision with root package name */
    private Listener<User> f30256c;
    @GuardedBy("this")

    /* renamed from: d  reason: collision with root package name */
    private int f30257d;
    @GuardedBy("this")

    /* renamed from: e  reason: collision with root package name */
    private boolean f30258e;

    @SuppressLint({"ProviderAssignment"})
    public FirebaseAuthCredentialsProvider(Deferred<InternalAuthProvider> deferred) {
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.firestore.auth.e
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                FirebaseAuthCredentialsProvider.this.g(provider);
            }
        });
    }

    private synchronized User d() {
        String uid;
        User user;
        InternalAuthProvider internalAuthProvider = this.f30255b;
        if (internalAuthProvider == null) {
            uid = null;
        } else {
            uid = internalAuthProvider.getUid();
        }
        if (uid != null) {
            user = new User(uid);
        } else {
            user = User.UNAUTHENTICATED;
        }
        return user;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task e(int i4, Task task) throws Exception {
        synchronized (this) {
            if (i4 != this.f30257d) {
                Logger.debug("FirebaseAuthCredentialsProvider", "getToken aborted due to token change", new Object[0]);
                return getToken();
            } else if (task.isSuccessful()) {
                return Tasks.forResult(((GetTokenResult) task.getResult()).getToken());
            } else {
                return Tasks.forException(task.getException());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f(InternalTokenResult internalTokenResult) {
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g(Provider provider) {
        synchronized (this) {
            this.f30255b = (InternalAuthProvider) provider.get();
            h();
            this.f30255b.addIdTokenListener(this.f30254a);
        }
    }

    private synchronized void h() {
        this.f30257d++;
        Listener<User> listener = this.f30256c;
        if (listener != null) {
            listener.onValue(d());
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized Task<String> getToken() {
        InternalAuthProvider internalAuthProvider = this.f30255b;
        if (internalAuthProvider == null) {
            return Tasks.forException(new FirebaseApiNotAvailableException("auth is not available"));
        }
        Task<GetTokenResult> accessToken = internalAuthProvider.getAccessToken(this.f30258e);
        this.f30258e = false;
        final int i4 = this.f30257d;
        return accessToken.continueWithTask(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.auth.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task e4;
                e4 = FirebaseAuthCredentialsProvider.this.e(i4, task);
                return e4;
            }
        });
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void invalidateToken() {
        this.f30258e = true;
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void removeChangeListener() {
        this.f30256c = null;
        InternalAuthProvider internalAuthProvider = this.f30255b;
        if (internalAuthProvider != null) {
            internalAuthProvider.removeIdTokenListener(this.f30254a);
        }
    }

    @Override // com.google.firebase.firestore.auth.CredentialsProvider
    public synchronized void setChangeListener(@NonNull Listener<User> listener) {
        this.f30256c = listener;
        listener.onValue(d());
    }
}
