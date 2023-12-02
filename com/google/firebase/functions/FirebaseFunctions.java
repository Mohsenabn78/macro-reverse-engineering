package com.google.firebase.functions;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.security.ProviderInstaller;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Lightweight;
import com.google.firebase.annotations.concurrent.UiThread;
import com.google.firebase.emulators.EmulatedServiceSettings;
import com.google.firebase.functions.FirebaseFunctionsException;
import com.google.firebase.functions.dagger.assisted.Assisted;
import com.google.firebase.functions.dagger.assisted.AssistedInject;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.Executor;
import javax.inject.Named;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class FirebaseFunctions {

    /* renamed from: j  reason: collision with root package name */
    private static final TaskCompletionSource<Void> f31357j = new TaskCompletionSource<>();

    /* renamed from: k  reason: collision with root package name */
    private static boolean f31358k = false;

    /* renamed from: c  reason: collision with root package name */
    private final ContextProvider f31361c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f31362d;

    /* renamed from: e  reason: collision with root package name */
    private final String f31363e;

    /* renamed from: f  reason: collision with root package name */
    private final String f31364f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final String f31365g;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private EmulatedServiceSettings f31367i;

    /* renamed from: h  reason: collision with root package name */
    private String f31366h = "https://%1$s-%2$s.cloudfunctions.net/%3$s";

    /* renamed from: a  reason: collision with root package name */
    private final OkHttpClient f31359a = new OkHttpClient();

    /* renamed from: b  reason: collision with root package name */
    private final Serializer f31360b = new Serializer();

    /* JADX INFO: Access modifiers changed from: package-private */
    @AssistedInject
    public FirebaseFunctions(Context context, @Named("projectId") String str, @Assisted String str2, ContextProvider contextProvider, @Lightweight Executor executor, @UiThread Executor executor2) {
        boolean z3;
        this.f31362d = executor;
        this.f31361c = (ContextProvider) Preconditions.checkNotNull(contextProvider);
        this.f31363e = (String) Preconditions.checkNotNull(str);
        try {
            new URL(str2);
            z3 = false;
        } catch (MalformedURLException unused) {
            z3 = true;
        }
        if (z3) {
            this.f31364f = str2;
            this.f31365g = null;
        } else {
            this.f31364f = "us-central1";
            this.f31365g = str2;
        }
        q(context, executor2);
    }

    @NonNull
    public static FirebaseFunctions getInstance(@NonNull FirebaseApp firebaseApp, @NonNull String str) {
        Preconditions.checkNotNull(firebaseApp, "You must call FirebaseApp.initializeApp first.");
        Preconditions.checkNotNull(str);
        FunctionsMultiResourceComponent functionsMultiResourceComponent = (FunctionsMultiResourceComponent) firebaseApp.get(FunctionsMultiResourceComponent.class);
        Preconditions.checkNotNull(functionsMultiResourceComponent, "Functions component does not exist.");
        return functionsMultiResourceComponent.a(str);
    }

    private Task<HttpsCallableResult> j(@NonNull URL url, @Nullable Object obj, HttpsCallableContext httpsCallableContext, HttpsCallOptions httpsCallOptions) {
        Preconditions.checkNotNull(url, "url cannot be null");
        HashMap hashMap = new HashMap();
        hashMap.put("data", this.f31360b.b(obj));
        Request.Builder post = new Request.Builder().url(url).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject(hashMap).toString()));
        if (httpsCallableContext.b() != null) {
            post = post.header("Authorization", "Bearer " + httpsCallableContext.b());
        }
        if (httpsCallableContext.c() != null) {
            post = post.header("Firebase-Instance-ID-Token", httpsCallableContext.c());
        }
        if (httpsCallableContext.a() != null) {
            post = post.header("X-Firebase-AppCheck", httpsCallableContext.a());
        }
        Call newCall = httpsCallOptions.a(this.f31359a).newCall(post.build());
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        newCall.enqueue(new Callback() { // from class: com.google.firebase.functions.FirebaseFunctions.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (iOException instanceof InterruptedIOException) {
                    FirebaseFunctionsException.Code code = FirebaseFunctionsException.Code.DEADLINE_EXCEEDED;
                    taskCompletionSource.setException(new FirebaseFunctionsException(code.name(), code, null, iOException));
                    return;
                }
                FirebaseFunctionsException.Code code2 = FirebaseFunctionsException.Code.INTERNAL;
                taskCompletionSource.setException(new FirebaseFunctionsException(code2.name(), code2, null, iOException));
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                FirebaseFunctionsException.Code b4 = FirebaseFunctionsException.Code.b(response.code());
                String string = response.body().string();
                FirebaseFunctionsException a4 = FirebaseFunctionsException.a(b4, string, FirebaseFunctions.this.f31360b);
                if (a4 != null) {
                    taskCompletionSource.setException(a4);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(string);
                    Object opt = jSONObject.opt("data");
                    if (opt == null) {
                        opt = jSONObject.opt("result");
                    }
                    if (opt == null) {
                        taskCompletionSource.setException(new FirebaseFunctionsException("Response is missing data field.", FirebaseFunctionsException.Code.INTERNAL, null));
                        return;
                    }
                    taskCompletionSource.setResult(new HttpsCallableResult(FirebaseFunctions.this.f31360b.a(opt)));
                } catch (JSONException e4) {
                    taskCompletionSource.setException(new FirebaseFunctionsException("Response is not valid JSON object.", FirebaseFunctionsException.Code.INTERNAL, null, e4));
                }
            }
        });
        return taskCompletionSource.getTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task l(HttpsCallOptions httpsCallOptions, Task task) throws Exception {
        return this.f31361c.a(httpsCallOptions.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task m(String str, Object obj, HttpsCallOptions httpsCallOptions, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(task.getException());
        }
        return j(k(str), obj, (HttpsCallableContext) task.getResult(), httpsCallOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task n(HttpsCallOptions httpsCallOptions, Task task) throws Exception {
        return this.f31361c.a(httpsCallOptions.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task o(URL url, Object obj, HttpsCallOptions httpsCallOptions, Task task) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(task.getException());
        }
        return j(url, obj, (HttpsCallableContext) task.getResult(), httpsCallOptions);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p(Context context) {
        ProviderInstaller.installIfNeededAsync(context, new ProviderInstaller.ProviderInstallListener() { // from class: com.google.firebase.functions.FirebaseFunctions.1
            @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
            public void onProviderInstallFailed(int i4, Intent intent) {
                FirebaseFunctions.f31357j.setResult(null);
            }

            @Override // com.google.android.gms.security.ProviderInstaller.ProviderInstallListener
            public void onProviderInstalled() {
                FirebaseFunctions.f31357j.setResult(null);
            }
        });
    }

    private static void q(final Context context, Executor executor) {
        synchronized (f31357j) {
            if (f31358k) {
                return;
            }
            f31358k = true;
            executor.execute(new Runnable() { // from class: com.google.firebase.functions.j
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseFunctions.p(context);
                }
            });
        }
    }

    @NonNull
    public HttpsCallableReference getHttpsCallable(@NonNull String str) {
        return new HttpsCallableReference(this, str, new HttpsCallOptions());
    }

    @NonNull
    public HttpsCallableReference getHttpsCallableFromUrl(@NonNull URL url) {
        return new HttpsCallableReference(this, url, new HttpsCallOptions());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<HttpsCallableResult> h(final String str, @Nullable final Object obj, final HttpsCallOptions httpsCallOptions) {
        return f31357j.getTask().continueWithTask(this.f31362d, new Continuation() { // from class: com.google.firebase.functions.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task l4;
                l4 = FirebaseFunctions.this.l(httpsCallOptions, task);
                return l4;
            }
        }).continueWithTask(this.f31362d, new Continuation() { // from class: com.google.firebase.functions.g
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task m4;
                m4 = FirebaseFunctions.this.m(str, obj, httpsCallOptions, task);
                return m4;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Task<HttpsCallableResult> i(final URL url, @Nullable final Object obj, final HttpsCallOptions httpsCallOptions) {
        return f31357j.getTask().continueWithTask(this.f31362d, new Continuation() { // from class: com.google.firebase.functions.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task n4;
                n4 = FirebaseFunctions.this.n(httpsCallOptions, task);
                return n4;
            }
        }).continueWithTask(this.f31362d, new Continuation() { // from class: com.google.firebase.functions.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task o4;
                o4 = FirebaseFunctions.this.o(url, obj, httpsCallOptions, task);
                return o4;
            }
        });
    }

    @VisibleForTesting
    URL k(String str) {
        EmulatedServiceSettings emulatedServiceSettings = this.f31367i;
        if (emulatedServiceSettings != null) {
            this.f31366h = "http://" + emulatedServiceSettings.getHost() + ":" + emulatedServiceSettings.getPort() + "/%2$s/%1$s/%3$s";
        }
        String format = String.format(this.f31366h, this.f31364f, this.f31363e, str);
        if (this.f31365g != null && emulatedServiceSettings == null) {
            format = this.f31365g + RemoteSettings.FORWARD_SLASH_STRING + str;
        }
        try {
            return new URL(format);
        } catch (MalformedURLException e4) {
            throw new IllegalStateException(e4);
        }
    }

    public void useEmulator(@NonNull String str, int i4) {
        this.f31367i = new EmulatedServiceSettings(str, i4);
    }

    public void useFunctionsEmulator(@NonNull String str) {
        Preconditions.checkNotNull(str, "origin cannot be null");
        this.f31366h = str + "/%2$s/%1$s/%3$s";
    }

    @NonNull
    public HttpsCallableReference getHttpsCallable(@NonNull String str, @NonNull HttpsCallableOptions httpsCallableOptions) {
        return new HttpsCallableReference(this, str, new HttpsCallOptions(httpsCallableOptions));
    }

    @NonNull
    public HttpsCallableReference getHttpsCallableFromUrl(@NonNull URL url, @NonNull HttpsCallableOptions httpsCallableOptions) {
        return new HttpsCallableReference(this, url, new HttpsCallOptions(httpsCallableOptions));
    }

    @NonNull
    public static FirebaseFunctions getInstance(@NonNull FirebaseApp firebaseApp) {
        return getInstance(firebaseApp, "us-central1");
    }

    @NonNull
    public static FirebaseFunctions getInstance(@NonNull String str) {
        return getInstance(FirebaseApp.getInstance(), str);
    }

    @NonNull
    public static FirebaseFunctions getInstance() {
        return getInstance(FirebaseApp.getInstance(), "us-central1");
    }
}
