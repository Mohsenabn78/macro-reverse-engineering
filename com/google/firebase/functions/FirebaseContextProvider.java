package com.google.firebase.functions;

import android.util.Log;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.appcheck.AppCheckTokenResult;
import com.google.firebase.appcheck.interop.AppCheckTokenListener;
import com.google.firebase.appcheck.interop.InteropAppCheckTokenProvider;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: Access modifiers changed from: package-private */
@Singleton
/* loaded from: classes5.dex */
public class FirebaseContextProvider implements ContextProvider {

    /* renamed from: b  reason: collision with root package name */
    private final Provider<InternalAuthProvider> f31349b;

    /* renamed from: c  reason: collision with root package name */
    private final Provider<FirebaseInstanceIdInternal> f31350c;

    /* renamed from: e  reason: collision with root package name */
    private final Executor f31352e;

    /* renamed from: a  reason: collision with root package name */
    private final String f31348a = "FirebaseContextProvider";

    /* renamed from: d  reason: collision with root package name */
    private final AtomicReference<InteropAppCheckTokenProvider> f31351d = new AtomicReference<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    @Inject
    public FirebaseContextProvider(Provider<InternalAuthProvider> provider, Provider<FirebaseInstanceIdInternal> provider2, Deferred<InteropAppCheckTokenProvider> deferred, @Lightweight Executor executor) {
        this.f31349b = provider;
        this.f31350c = provider2;
        this.f31352e = executor;
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.functions.a
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider3) {
                FirebaseContextProvider.this.m(provider3);
            }
        });
    }

    private Task<String> g(boolean z3) {
        Task<AppCheckTokenResult> token;
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = this.f31351d.get();
        if (interopAppCheckTokenProvider == null) {
            return Tasks.forResult(null);
        }
        if (z3) {
            token = interopAppCheckTokenProvider.getLimitedUseToken();
        } else {
            token = interopAppCheckTokenProvider.getToken(false);
        }
        return token.onSuccessTask(this.f31352e, new SuccessContinuation() { // from class: com.google.firebase.functions.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task i4;
                i4 = FirebaseContextProvider.this.i((AppCheckTokenResult) obj);
                return i4;
            }
        });
    }

    private Task<String> h() {
        InternalAuthProvider internalAuthProvider = this.f31349b.get();
        if (internalAuthProvider == null) {
            return Tasks.forResult(null);
        }
        return internalAuthProvider.getAccessToken(false).continueWith(this.f31352e, new Continuation() { // from class: com.google.firebase.functions.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                String j4;
                j4 = FirebaseContextProvider.j(task);
                return j4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task i(AppCheckTokenResult appCheckTokenResult) throws Exception {
        if (appCheckTokenResult.getError() != null) {
            Log.w("FirebaseContextProvider", "Error getting App Check token. Error: " + appCheckTokenResult.getError());
            return Tasks.forResult(null);
        }
        return Tasks.forResult(appCheckTokenResult.getToken());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String j(Task task) throws Exception {
        if (!task.isSuccessful()) {
            Exception exception = task.getException();
            if (exception instanceof FirebaseNoSignedInUserException) {
                return null;
            }
            throw exception;
        }
        return ((GetTokenResult) task.getResult()).getToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task k(Task task, Task task2, Void r4) throws Exception {
        return Tasks.forResult(new HttpsCallableContext((String) task.getResult(), this.f31350c.get().getToken(), (String) task2.getResult()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m(Provider provider) {
        InteropAppCheckTokenProvider interopAppCheckTokenProvider = (InteropAppCheckTokenProvider) provider.get();
        this.f31351d.set(interopAppCheckTokenProvider);
        interopAppCheckTokenProvider.addAppCheckTokenListener(new AppCheckTokenListener() { // from class: com.google.firebase.functions.c
            @Override // com.google.firebase.appcheck.interop.AppCheckTokenListener
            public final void onAppCheckTokenChanged(AppCheckTokenResult appCheckTokenResult) {
                FirebaseContextProvider.l(appCheckTokenResult);
            }
        });
    }

    @Override // com.google.firebase.functions.ContextProvider
    public Task<HttpsCallableContext> a(boolean z3) {
        final Task<String> h4 = h();
        final Task<String> g4 = g(z3);
        return Tasks.whenAll(h4, g4).onSuccessTask(this.f31352e, new SuccessContinuation() { // from class: com.google.firebase.functions.b
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task k4;
                k4 = FirebaseContextProvider.this.k(h4, g4, (Void) obj);
                return k4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void l(AppCheckTokenResult appCheckTokenResult) {
    }
}
