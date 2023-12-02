package com.google.firebase.remoteconfig;

import android.app.Application;
import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.common.util.BiConsumer;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.annotations.concurrent.Blocking;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.ConfigStorageClient;
import com.google.firebase.remoteconfig.internal.Personalization;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
/* loaded from: classes5.dex */
public class RemoteConfigComponent {
    public static final String ACTIVATE_FILE_NAME = "activate";
    public static final long CONNECTION_TIMEOUT_IN_SECONDS = 60;
    public static final String DEFAULTS_FILE_NAME = "defaults";
    @VisibleForTesting
    public static final String DEFAULT_NAMESPACE = "firebase";
    public static final String FETCH_FILE_NAME = "fetch";

    /* renamed from: j  reason: collision with root package name */
    private static final Clock f31891j = DefaultClock.getInstance();

    /* renamed from: k  reason: collision with root package name */
    private static final Random f31892k = new Random();

    /* renamed from: l  reason: collision with root package name */
    private static final Map<String, FirebaseRemoteConfig> f31893l = new HashMap();
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, FirebaseRemoteConfig> f31894a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f31895b;

    /* renamed from: c  reason: collision with root package name */
    private final ScheduledExecutorService f31896c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseApp f31897d;

    /* renamed from: e  reason: collision with root package name */
    private final FirebaseInstallationsApi f31898e;

    /* renamed from: f  reason: collision with root package name */
    private final FirebaseABTesting f31899f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Provider<AnalyticsConnector> f31900g;

    /* renamed from: h  reason: collision with root package name */
    private final String f31901h;
    @GuardedBy("this")

    /* renamed from: i  reason: collision with root package name */
    private Map<String, String> f31902i;

    /* loaded from: classes5.dex */
    private static class GlobalBackgroundListener implements BackgroundDetector.BackgroundStateChangeListener {

        /* renamed from: a  reason: collision with root package name */
        private static final AtomicReference<GlobalBackgroundListener> f31903a = new AtomicReference<>();

        private GlobalBackgroundListener() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(Context context) {
            Application application = (Application) context.getApplicationContext();
            AtomicReference<GlobalBackgroundListener> atomicReference = f31903a;
            if (atomicReference.get() == null) {
                GlobalBackgroundListener globalBackgroundListener = new GlobalBackgroundListener();
                if (androidx.compose.animation.core.d.a(atomicReference, null, globalBackgroundListener)) {
                    BackgroundDetector.initialize(application);
                    BackgroundDetector.getInstance().addListener(globalBackgroundListener);
                }
            }
        }

        @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
        public void onBackgroundStateChanged(boolean z3) {
            RemoteConfigComponent.o(z3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RemoteConfigComponent(Context context, @Blocking ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider) {
        this(context, scheduledExecutorService, firebaseApp, firebaseInstallationsApi, firebaseABTesting, provider, true);
    }

    private ConfigCacheClient d(String str, String str2) {
        return ConfigCacheClient.getInstance(this.f31896c, ConfigStorageClient.getInstance(this.f31895b, String.format("%s_%s_%s_%s.json", FirebaseABTesting.OriginService.REMOTE_CONFIG, this.f31901h, str, str2)));
    }

    private ConfigGetParameterHandler h(ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2) {
        return new ConfigGetParameterHandler(this.f31896c, configCacheClient, configCacheClient2);
    }

    @VisibleForTesting
    static ConfigMetadataClient i(Context context, String str, String str2) {
        return new ConfigMetadataClient(context.getSharedPreferences(String.format("%s_%s_%s_%s", FirebaseABTesting.OriginService.REMOTE_CONFIG, str, str2, "settings"), 0));
    }

    @Nullable
    private static Personalization j(FirebaseApp firebaseApp, String str, Provider<AnalyticsConnector> provider) {
        if (m(firebaseApp) && str.equals("firebase")) {
            return new Personalization(provider);
        }
        return null;
    }

    private static boolean l(FirebaseApp firebaseApp, String str) {
        if (str.equals("firebase") && m(firebaseApp)) {
            return true;
        }
        return false;
    }

    private static boolean m(FirebaseApp firebaseApp) {
        return firebaseApp.getName().equals(FirebaseApp.DEFAULT_APP_NAME);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ AnalyticsConnector n() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void o(boolean z3) {
        synchronized (RemoteConfigComponent.class) {
            for (FirebaseRemoteConfig firebaseRemoteConfig : f31893l.values()) {
                firebaseRemoteConfig.t(z3);
            }
        }
    }

    @VisibleForTesting
    synchronized FirebaseRemoteConfig c(FirebaseApp firebaseApp, String str, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient) {
        if (!this.f31894a.containsKey(str)) {
            FirebaseRemoteConfig firebaseRemoteConfig = new FirebaseRemoteConfig(this.f31895b, firebaseApp, firebaseInstallationsApi, l(firebaseApp, str) ? firebaseABTesting : null, executor, configCacheClient, configCacheClient2, configCacheClient3, configFetchHandler, configGetParameterHandler, configMetadataClient, k(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient2, this.f31895b, str, configMetadataClient));
            firebaseRemoteConfig.v();
            this.f31894a.put(str, firebaseRemoteConfig);
            f31893l.put(str, firebaseRemoteConfig);
        }
        return this.f31894a.get(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig e() {
        return get("firebase");
    }

    @VisibleForTesting
    synchronized ConfigFetchHandler f(String str, ConfigCacheClient configCacheClient, ConfigMetadataClient configMetadataClient) {
        FirebaseInstallationsApi firebaseInstallationsApi;
        Provider<AnalyticsConnector> provider;
        firebaseInstallationsApi = this.f31898e;
        if (m(this.f31897d)) {
            provider = this.f31900g;
        } else {
            provider = new Provider() { // from class: com.google.firebase.remoteconfig.m
                @Override // com.google.firebase.inject.Provider
                public final Object get() {
                    AnalyticsConnector n4;
                    n4 = RemoteConfigComponent.n();
                    return n4;
                }
            };
        }
        return new ConfigFetchHandler(firebaseInstallationsApi, provider, this.f31896c, f31891j, f31892k, configCacheClient, g(this.f31897d.getOptions().getApiKey(), str, configMetadataClient), configMetadataClient, this.f31902i);
    }

    @VisibleForTesting
    ConfigFetchHttpClient g(String str, String str2, ConfigMetadataClient configMetadataClient) {
        return new ConfigFetchHttpClient(this.f31895b, this.f31897d.getOptions().getApplicationId(), str, str2, configMetadataClient.getFetchTimeoutInSeconds(), configMetadataClient.getFetchTimeoutInSeconds());
    }

    @KeepForSdk
    @VisibleForTesting
    public synchronized FirebaseRemoteConfig get(String str) {
        ConfigCacheClient d4;
        ConfigCacheClient d5;
        ConfigCacheClient d6;
        ConfigMetadataClient i4;
        ConfigGetParameterHandler h4;
        d4 = d(str, FETCH_FILE_NAME);
        d5 = d(str, ACTIVATE_FILE_NAME);
        d6 = d(str, DEFAULTS_FILE_NAME);
        i4 = i(this.f31895b, this.f31901h, str);
        h4 = h(d5, d6);
        final Personalization j4 = j(this.f31897d, str, this.f31900g);
        if (j4 != null) {
            h4.addListener(new BiConsumer() { // from class: com.google.firebase.remoteconfig.k
                @Override // com.google.android.gms.common.util.BiConsumer
                public final void accept(Object obj, Object obj2) {
                    Personalization.this.logArmActive((String) obj, (ConfigContainer) obj2);
                }
            });
        }
        return c(this.f31897d, str, this.f31898e, this.f31899f, this.f31896c, d4, d5, d6, f(str, d4, i4), h4, i4);
    }

    synchronized ConfigRealtimeHandler k(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigMetadataClient configMetadataClient) {
        return new ConfigRealtimeHandler(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, configMetadataClient, this.f31896c);
    }

    @VisibleForTesting
    public synchronized void setCustomHeaders(Map<String, String> map) {
        this.f31902i = map;
    }

    @VisibleForTesting
    protected RemoteConfigComponent(Context context, ScheduledExecutorService scheduledExecutorService, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, FirebaseABTesting firebaseABTesting, Provider<AnalyticsConnector> provider, boolean z3) {
        this.f31894a = new HashMap();
        this.f31902i = new HashMap();
        this.f31895b = context;
        this.f31896c = scheduledExecutorService;
        this.f31897d = firebaseApp;
        this.f31898e = firebaseInstallationsApi;
        this.f31899f = firebaseABTesting;
        this.f31900g = provider;
        this.f31901h = firebaseApp.getOptions().getApplicationId();
        GlobalBackgroundListener.b(context);
        if (z3) {
            Tasks.call(scheduledExecutorService, new Callable() { // from class: com.google.firebase.remoteconfig.l
                @Override // java.util.concurrent.Callable
                public final Object call() {
                    return RemoteConfigComponent.this.e();
                }
            });
        }
    }
}
