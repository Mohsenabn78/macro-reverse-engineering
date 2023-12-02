package com.google.firebase.messaging;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.GuardedBy;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.datatransport.TransportFactory;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.DataCollectionDefaultChange;
import com.google.firebase.FirebaseApp;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Subscriber;
import com.google.firebase.heartbeatinfo.HeartBeatInfo;
import com.google.firebase.iid.internal.FirebaseInstanceIdInternal;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RequestDeduplicator;
import com.google.firebase.messaging.Store;
import com.google.firebase.platforminfo.UserAgentPublisher;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class FirebaseMessaging {
    @Deprecated
    public static final String INSTANCE_ID_SCOPE = "FCM";

    /* renamed from: o  reason: collision with root package name */
    private static final long f31641o = TimeUnit.HOURS.toSeconds(8);
    @GuardedBy("FirebaseMessaging.class")

    /* renamed from: p  reason: collision with root package name */
    private static Store f31642p;
    @Nullable
    @SuppressLint({"FirebaseUnknownNullness"})
    @VisibleForTesting

    /* renamed from: q  reason: collision with root package name */
    static TransportFactory f31643q;
    @GuardedBy("FirebaseMessaging.class")
    @VisibleForTesting

    /* renamed from: r  reason: collision with root package name */
    static ScheduledExecutorService f31644r;

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseApp f31645a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseInstanceIdInternal f31646b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstallationsApi f31647c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f31648d;

    /* renamed from: e  reason: collision with root package name */
    private final GmsRpc f31649e;

    /* renamed from: f  reason: collision with root package name */
    private final RequestDeduplicator f31650f;

    /* renamed from: g  reason: collision with root package name */
    private final AutoInit f31651g;

    /* renamed from: h  reason: collision with root package name */
    private final Executor f31652h;

    /* renamed from: i  reason: collision with root package name */
    private final Executor f31653i;

    /* renamed from: j  reason: collision with root package name */
    private final Executor f31654j;

    /* renamed from: k  reason: collision with root package name */
    private final Task<TopicsSubscriber> f31655k;

    /* renamed from: l  reason: collision with root package name */
    private final Metadata f31656l;
    @GuardedBy("this")

    /* renamed from: m  reason: collision with root package name */
    private boolean f31657m;

    /* renamed from: n  reason: collision with root package name */
    private final Application.ActivityLifecycleCallbacks f31658n;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class AutoInit {

        /* renamed from: a  reason: collision with root package name */
        private final Subscriber f31659a;
        @GuardedBy("this")

        /* renamed from: b  reason: collision with root package name */
        private boolean f31660b;
        @Nullable
        @GuardedBy("this")

        /* renamed from: c  reason: collision with root package name */
        private EventHandler<DataCollectionDefaultChange> f31661c;
        @Nullable
        @GuardedBy("this")

        /* renamed from: d  reason: collision with root package name */
        private Boolean f31662d;

        AutoInit(Subscriber subscriber) {
            this.f31659a = subscriber;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(Event event) {
            if (c()) {
                FirebaseMessaging.this.I();
            }
        }

        @Nullable
        private Boolean e() {
            ApplicationInfo applicationInfo;
            Bundle bundle;
            Context applicationContext = FirebaseMessaging.this.f31645a.getApplicationContext();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
            if (sharedPreferences.contains("auto_init")) {
                return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
            }
            try {
                PackageManager packageManager = applicationContext.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(applicationContext.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                    return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
                }
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                return null;
            }
        }

        synchronized void b() {
            if (this.f31660b) {
                return;
            }
            Boolean e4 = e();
            this.f31662d = e4;
            if (e4 == null) {
                EventHandler<DataCollectionDefaultChange> eventHandler = new EventHandler() { // from class: com.google.firebase.messaging.t
                    @Override // com.google.firebase.events.EventHandler
                    public final void handle(Event event) {
                        FirebaseMessaging.AutoInit.this.d(event);
                    }
                };
                this.f31661c = eventHandler;
                this.f31659a.subscribe(DataCollectionDefaultChange.class, eventHandler);
            }
            this.f31660b = true;
        }

        synchronized boolean c() {
            boolean isDataCollectionDefaultEnabled;
            b();
            Boolean bool = this.f31662d;
            if (bool != null) {
                isDataCollectionDefaultEnabled = bool.booleanValue();
            } else {
                isDataCollectionDefaultEnabled = FirebaseMessaging.this.f31645a.isDataCollectionDefaultEnabled();
            }
            return isDataCollectionDefaultEnabled;
        }

        synchronized void f(boolean z3) {
            b();
            EventHandler<DataCollectionDefaultChange> eventHandler = this.f31661c;
            if (eventHandler != null) {
                this.f31659a.unsubscribe(DataCollectionDefaultChange.class, eventHandler);
                this.f31661c = null;
            }
            SharedPreferences.Editor edit = FirebaseMessaging.this.f31645a.getApplicationContext().getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0).edit();
            edit.putBoolean("auto_init", z3);
            edit.apply();
            if (z3) {
                FirebaseMessaging.this.I();
            }
            this.f31662d = Boolean.valueOf(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory, Subscriber subscriber) {
        this(firebaseApp, firebaseInstanceIdInternal, provider, provider2, firebaseInstallationsApi, transportFactory, subscriber, new Metadata(firebaseApp.getApplicationContext()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B() {
        if (isAutoInitEnabled()) {
            I();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(TopicsSubscriber topicsSubscriber) {
        if (isAutoInitEnabled()) {
            topicsSubscriber.q();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        ProxyNotificationInitializer.c(this.f31648d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task E(String str, TopicsSubscriber topicsSubscriber) throws Exception {
        return topicsSubscriber.r(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task F(String str, TopicsSubscriber topicsSubscriber) throws Exception {
        return topicsSubscriber.u(str);
    }

    private synchronized void H() {
        if (!this.f31657m) {
            J(0L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f31646b;
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.getToken();
        } else if (K(s())) {
            H();
        }
    }

    @NonNull
    public static synchronized FirebaseMessaging getInstance() {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = getInstance(FirebaseApp.getInstance());
        }
        return firebaseMessaging;
    }

    @Nullable
    public static TransportFactory getTransportFactory() {
        return f31643q;
    }

    @NonNull
    private static synchronized Store q(Context context) {
        Store store;
        synchronized (FirebaseMessaging.class) {
            if (f31642p == null) {
                f31642p = new Store(context);
            }
            store = f31642p;
        }
        return store;
    }

    private String r() {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.f31645a.getName())) {
            return "";
        }
        return this.f31645a.getPersistenceKey();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public void A(String str) {
        if (FirebaseApp.DEFAULT_APP_NAME.equals(this.f31645a.getName())) {
            if (Log.isLoggable(Constants.TAG, 3)) {
                StringBuilder sb = new StringBuilder();
                sb.append("Invoking onNewToken for app: ");
                sb.append(this.f31645a.getName());
            }
            Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
            intent.putExtra("token", str);
            new FcmBroadcastProcessor(this.f31648d).process(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task v(final String str, final Store.Token token) {
        return this.f31649e.f().onSuccessTask(this.f31654j, new SuccessContinuation() { // from class: com.google.firebase.messaging.i
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task w3;
                w3 = FirebaseMessaging.this.w(str, token, (String) obj);
                return w3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task w(String str, Store.Token token, String str2) throws Exception {
        q(this.f31648d).g(r(), str, str2, this.f31656l.a());
        if (token == null || !str2.equals(token.f31727a)) {
            A(str2);
        }
        return Tasks.forResult(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x(TaskCompletionSource taskCompletionSource) {
        try {
            this.f31646b.deleteToken(Metadata.c(this.f31645a), INSTANCE_ID_SCOPE);
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(TaskCompletionSource taskCompletionSource) {
        try {
            Tasks.await(this.f31649e.c());
            q(this.f31648d).d(r(), Metadata.c(this.f31645a));
            taskCompletionSource.setResult(null);
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(TaskCompletionSource taskCompletionSource) {
        try {
            taskCompletionSource.setResult(n());
        } catch (Exception e4) {
            taskCompletionSource.setException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void G(boolean z3) {
        this.f31657m = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void J(long j4) {
        o(new SyncTask(this, Math.min(Math.max(30L, 2 * j4), f31641o)), j4);
        this.f31657m = true;
    }

    @VisibleForTesting
    boolean K(@Nullable Store.Token token) {
        if (token != null && !token.b(this.f31656l.a())) {
            return false;
        }
        return true;
    }

    @NonNull
    public Task<Void> deleteToken() {
        if (this.f31646b != null) {
            final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            this.f31652h.execute(new Runnable() { // from class: com.google.firebase.messaging.p
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseMessaging.this.x(taskCompletionSource);
                }
            });
            return taskCompletionSource.getTask();
        } else if (s() == null) {
            return Tasks.forResult(null);
        } else {
            final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
            FcmExecutors.e().execute(new Runnable() { // from class: com.google.firebase.messaging.q
                @Override // java.lang.Runnable
                public final void run() {
                    FirebaseMessaging.this.y(taskCompletionSource2);
                }
            });
            return taskCompletionSource2.getTask();
        }
    }

    @NonNull
    public boolean deliveryMetricsExportToBigQueryEnabled() {
        return MessagingAnalytics.a();
    }

    @NonNull
    public Task<String> getToken() {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f31646b;
        if (firebaseInstanceIdInternal != null) {
            return firebaseInstanceIdInternal.getTokenTask();
        }
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f31652h.execute(new Runnable() { // from class: com.google.firebase.messaging.s
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.z(taskCompletionSource);
            }
        });
        return taskCompletionSource.getTask();
    }

    public boolean isAutoInitEnabled() {
        return this.f31651g.c();
    }

    public boolean isNotificationDelegationEnabled() {
        return ProxyNotificationInitializer.d(this.f31648d);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String n() throws IOException {
        FirebaseInstanceIdInternal firebaseInstanceIdInternal = this.f31646b;
        if (firebaseInstanceIdInternal != null) {
            try {
                return (String) Tasks.await(firebaseInstanceIdInternal.getTokenTask());
            } catch (InterruptedException | ExecutionException e4) {
                throw new IOException(e4);
            }
        }
        final Store.Token s3 = s();
        if (!K(s3)) {
            return s3.f31727a;
        }
        final String c4 = Metadata.c(this.f31645a);
        try {
            return (String) Tasks.await(this.f31650f.b(c4, new RequestDeduplicator.GetTokenRequest() { // from class: com.google.firebase.messaging.o
                @Override // com.google.firebase.messaging.RequestDeduplicator.GetTokenRequest
                public final Task start() {
                    Task v3;
                    v3 = FirebaseMessaging.this.v(c4, s3);
                    return v3;
                }
            }));
        } catch (InterruptedException | ExecutionException e5) {
            throw new IOException(e5);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SuppressLint({"ThreadPoolCreation"})
    public void o(Runnable runnable, long j4) {
        synchronized (FirebaseMessaging.class) {
            if (f31644r == null) {
                f31644r = new ScheduledThreadPoolExecutor(1, new NamedThreadFactory("TAG"));
            }
            f31644r.schedule(runnable, j4, TimeUnit.SECONDS);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Context p() {
        return this.f31648d;
    }

    @Nullable
    @VisibleForTesting
    Store.Token s() {
        return q(this.f31648d).e(r(), Metadata.c(this.f31645a));
    }

    @Deprecated
    public void send(@NonNull RemoteMessage remoteMessage) {
        int i4;
        if (!TextUtils.isEmpty(remoteMessage.getTo())) {
            Intent intent = new Intent("com.google.android.gcm.intent.SEND");
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            Context context = this.f31648d;
            if (Build.VERSION.SDK_INT >= 23) {
                i4 = 67108864;
            } else {
                i4 = 0;
            }
            intent.putExtra("app", PendingIntent.getBroadcast(context, 0, intent2, i4));
            intent.setPackage("com.google.android.gms");
            remoteMessage.c(intent);
            this.f31648d.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
            return;
        }
        throw new IllegalArgumentException("Missing 'to'");
    }

    public void setAutoInitEnabled(boolean z3) {
        this.f31651g.f(z3);
    }

    public void setDeliveryMetricsExportToBigQuery(boolean z3) {
        MessagingAnalytics.u(z3);
    }

    @NonNull
    public Task<Void> setNotificationDelegationEnabled(boolean z3) {
        return ProxyNotificationInitializer.f(this.f31652h, this.f31648d, z3);
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    public Task<Void> subscribeToTopic(@NonNull final String str) {
        return this.f31655k.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.n
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task E;
                E = FirebaseMessaging.E(str, (TopicsSubscriber) obj);
                return E;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public boolean u() {
        return this.f31656l.g();
    }

    @NonNull
    @SuppressLint({"TaskMainThread"})
    public Task<Void> unsubscribeFromTopic(@NonNull final String str) {
        return this.f31655k.onSuccessTask(new SuccessContinuation() { // from class: com.google.firebase.messaging.h
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task F;
                F = FirebaseMessaging.F(str, (TopicsSubscriber) obj);
                return F;
            }
        });
    }

    @NonNull
    @Keep
    static synchronized FirebaseMessaging getInstance(@NonNull FirebaseApp firebaseApp) {
        FirebaseMessaging firebaseMessaging;
        synchronized (FirebaseMessaging.class) {
            firebaseMessaging = (FirebaseMessaging) firebaseApp.get(FirebaseMessaging.class);
            Preconditions.checkNotNull(firebaseMessaging, "Firebase Messaging component is not present");
        }
        return firebaseMessaging;
    }

    FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, Provider<UserAgentPublisher> provider, Provider<HeartBeatInfo> provider2, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory, Subscriber subscriber, Metadata metadata) {
        this(firebaseApp, firebaseInstanceIdInternal, firebaseInstallationsApi, transportFactory, subscriber, metadata, new GmsRpc(firebaseApp, metadata, provider, provider2, firebaseInstallationsApi), FcmExecutors.f(), FcmExecutors.c(), FcmExecutors.b());
    }

    FirebaseMessaging(FirebaseApp firebaseApp, @Nullable FirebaseInstanceIdInternal firebaseInstanceIdInternal, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable TransportFactory transportFactory, Subscriber subscriber, Metadata metadata, GmsRpc gmsRpc, Executor executor, Executor executor2, Executor executor3) {
        this.f31657m = false;
        f31643q = transportFactory;
        this.f31645a = firebaseApp;
        this.f31646b = firebaseInstanceIdInternal;
        this.f31647c = firebaseInstallationsApi;
        this.f31651g = new AutoInit(subscriber);
        Context applicationContext = firebaseApp.getApplicationContext();
        this.f31648d = applicationContext;
        FcmLifecycleCallbacks fcmLifecycleCallbacks = new FcmLifecycleCallbacks();
        this.f31658n = fcmLifecycleCallbacks;
        this.f31656l = metadata;
        this.f31653i = executor;
        this.f31649e = gmsRpc;
        this.f31650f = new RequestDeduplicator(executor);
        this.f31652h = executor2;
        this.f31654j = executor3;
        Context applicationContext2 = firebaseApp.getApplicationContext();
        if (applicationContext2 instanceof Application) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(fcmLifecycleCallbacks);
        } else {
            Log.w(Constants.TAG, "Context " + applicationContext2 + " was not an application, can't register for lifecycle callbacks. Some notification events may be dropped as a result.");
        }
        if (firebaseInstanceIdInternal != null) {
            firebaseInstanceIdInternal.addNewTokenListener(new FirebaseInstanceIdInternal.NewTokenListener() { // from class: com.google.firebase.messaging.j
                @Override // com.google.firebase.iid.internal.FirebaseInstanceIdInternal.NewTokenListener
                public final void onNewToken(String str) {
                    FirebaseMessaging.this.A(str);
                }
            });
        }
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.k
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.B();
            }
        });
        Task<TopicsSubscriber> f4 = TopicsSubscriber.f(this, metadata, gmsRpc, applicationContext, FcmExecutors.g());
        this.f31655k = f4;
        f4.addOnSuccessListener(executor2, new OnSuccessListener() { // from class: com.google.firebase.messaging.l
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                FirebaseMessaging.this.C((TopicsSubscriber) obj);
            }
        });
        executor2.execute(new Runnable() { // from class: com.google.firebase.messaging.m
            @Override // java.lang.Runnable
            public final void run() {
                FirebaseMessaging.this.D();
            }
        });
    }
}
