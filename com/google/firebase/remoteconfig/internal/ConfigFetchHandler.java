package com.google.firebase.remoteconfig.internal;

import android.text.format.DateUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.installations.InstallationTokenResult;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigClientException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigFetchThrottledException;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigServerException;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes5.dex */
public class ConfigFetchHandler {
    public static final long DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS = TimeUnit.HOURS.toSeconds(12);
    @VisibleForTesting

    /* renamed from: j  reason: collision with root package name */
    static final int[] f31941j = {2, 4, 8, 16, 32, 64, 128, 256};

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseInstallationsApi f31942a;

    /* renamed from: b  reason: collision with root package name */
    private final Provider<AnalyticsConnector> f31943b;

    /* renamed from: c  reason: collision with root package name */
    private final Executor f31944c;

    /* renamed from: d  reason: collision with root package name */
    private final Clock f31945d;

    /* renamed from: e  reason: collision with root package name */
    private final Random f31946e;

    /* renamed from: f  reason: collision with root package name */
    private final ConfigCacheClient f31947f;

    /* renamed from: g  reason: collision with root package name */
    private final ConfigFetchHttpClient f31948g;

    /* renamed from: h  reason: collision with root package name */
    private final ConfigMetadataClient f31949h;

    /* renamed from: i  reason: collision with root package name */
    private final Map<String, String> f31950i;

    /* loaded from: classes5.dex */
    public static class FetchResponse {

        /* renamed from: a  reason: collision with root package name */
        private final Date f31951a;

        /* renamed from: b  reason: collision with root package name */
        private final int f31952b;

        /* renamed from: c  reason: collision with root package name */
        private final ConfigContainer f31953c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private final String f31954d;

        @Retention(RetentionPolicy.SOURCE)
        /* loaded from: classes5.dex */
        public @interface Status {
            public static final int BACKEND_HAS_NO_UPDATES = 1;
            public static final int BACKEND_UPDATES_FETCHED = 0;
            public static final int LOCAL_STORAGE_USED = 2;
        }

        private FetchResponse(Date date, int i4, ConfigContainer configContainer, @Nullable String str) {
            this.f31951a = date;
            this.f31952b = i4;
            this.f31953c = configContainer;
            this.f31954d = str;
        }

        public static FetchResponse forBackendHasNoUpdates(Date date, ConfigContainer configContainer) {
            return new FetchResponse(date, 1, configContainer, null);
        }

        public static FetchResponse forBackendUpdatesFetched(ConfigContainer configContainer, String str) {
            return new FetchResponse(configContainer.getFetchTime(), 0, configContainer, str);
        }

        public static FetchResponse forLocalStorageUsed(Date date) {
            return new FetchResponse(date, 2, null, null);
        }

        @Nullable
        String a() {
            return this.f31954d;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f31952b;
        }

        public ConfigContainer getFetchedConfigs() {
            return this.f31953c;
        }
    }

    /* loaded from: classes5.dex */
    public enum FetchType {
        BASE("BASE"),
        REALTIME("REALTIME");
        
        private final String value;

        FetchType(String str) {
            this.value = str;
        }

        String a() {
            return this.value;
        }
    }

    public ConfigFetchHandler(FirebaseInstallationsApi firebaseInstallationsApi, Provider<AnalyticsConnector> provider, Executor executor, Clock clock, Random random, ConfigCacheClient configCacheClient, ConfigFetchHttpClient configFetchHttpClient, ConfigMetadataClient configMetadataClient, Map<String, String> map) {
        this.f31942a = firebaseInstallationsApi;
        this.f31943b = provider;
        this.f31944c = executor;
        this.f31945d = clock;
        this.f31946e = random;
        this.f31947f = configCacheClient;
        this.f31948g = configFetchHttpClient;
        this.f31949h = configMetadataClient;
        this.f31950i = map;
    }

    private boolean f(long j4, Date date) {
        Date c4 = this.f31949h.c();
        if (c4.equals(ConfigMetadataClient.f31970e)) {
            return false;
        }
        return date.before(new Date(c4.getTime() + TimeUnit.SECONDS.toMillis(j4)));
    }

    private FirebaseRemoteConfigServerException g(FirebaseRemoteConfigServerException firebaseRemoteConfigServerException) throws FirebaseRemoteConfigClientException {
        String str;
        int httpStatusCode = firebaseRemoteConfigServerException.getHttpStatusCode();
        if (httpStatusCode != 401) {
            if (httpStatusCode != 403) {
                if (httpStatusCode != 429) {
                    if (httpStatusCode != 500) {
                        switch (httpStatusCode) {
                            case 502:
                            case 503:
                            case 504:
                                str = "The server is unavailable. Please try again later.";
                                break;
                            default:
                                str = "The server returned an unexpected error.";
                                break;
                        }
                    } else {
                        str = "There was an internal server error.";
                    }
                } else {
                    throw new FirebaseRemoteConfigClientException("The throttled response from the server was not handled correctly by the FRC SDK.");
                }
            } else {
                str = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
            }
        } else {
            str = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
        }
        int httpStatusCode2 = firebaseRemoteConfigServerException.getHttpStatusCode();
        return new FirebaseRemoteConfigServerException(httpStatusCode2, "Fetch failed: " + str, firebaseRemoteConfigServerException);
    }

    private String h(long j4) {
        return String.format("Fetch is throttled. Please wait before calling fetch again: %s", DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(j4)));
    }

    @WorkerThread
    private FetchResponse i(String str, String str2, Date date, Map<String, String> map) throws FirebaseRemoteConfigException {
        try {
            FetchResponse fetch = this.f31948g.fetch(this.f31948g.d(), str, str2, o(), this.f31949h.b(), map, m(), date);
            if (fetch.getFetchedConfigs() != null) {
                this.f31949h.j(fetch.getFetchedConfigs().getTemplateVersionNumber());
            }
            if (fetch.a() != null) {
                this.f31949h.i(fetch.a());
            }
            this.f31949h.f();
            return fetch;
        } catch (FirebaseRemoteConfigServerException e4) {
            ConfigMetadataClient.BackoffMetadata w3 = w(e4.getHttpStatusCode(), date);
            if (v(w3, e4.getHttpStatusCode())) {
                throw new FirebaseRemoteConfigFetchThrottledException(w3.a().getTime());
            }
            throw g(e4);
        }
    }

    private Task<FetchResponse> j(String str, String str2, Date date, Map<String, String> map) {
        try {
            final FetchResponse i4 = i(str, str2, date, map);
            if (i4.b() != 0) {
                return Tasks.forResult(i4);
            }
            return this.f31947f.put(i4.getFetchedConfigs()).onSuccessTask(this.f31944c, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.internal.i
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Task forResult;
                    ConfigContainer configContainer = (ConfigContainer) obj;
                    forResult = Tasks.forResult(ConfigFetchHandler.FetchResponse.this);
                    return forResult;
                }
            });
        } catch (FirebaseRemoteConfigException e4) {
            return Tasks.forException(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public Task<FetchResponse> q(Task<ConfigContainer> task, long j4, final Map<String, String> map) {
        Task continueWithTask;
        final Date date = new Date(this.f31945d.currentTimeMillis());
        if (task.isSuccessful() && f(j4, date)) {
            return Tasks.forResult(FetchResponse.forLocalStorageUsed(date));
        }
        Date l4 = l(date);
        if (l4 != null) {
            continueWithTask = Tasks.forException(new FirebaseRemoteConfigFetchThrottledException(h(l4.getTime() - date.getTime()), l4.getTime()));
        } else {
            final Task<String> id = this.f31942a.getId();
            final Task<InstallationTokenResult> token = this.f31942a.getToken(false);
            continueWithTask = Tasks.whenAllComplete(id, token).continueWithTask(this.f31944c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.g
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task2) {
                    Task s3;
                    s3 = ConfigFetchHandler.this.s(id, token, date, map, task2);
                    return s3;
                }
            });
        }
        return continueWithTask.continueWithTask(this.f31944c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.h
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task2) {
                Task t3;
                t3 = ConfigFetchHandler.this.t(date, task2);
                return t3;
            }
        });
    }

    @Nullable
    private Date l(Date date) {
        Date a4 = this.f31949h.a().a();
        if (date.before(a4)) {
            return a4;
        }
        return null;
    }

    @WorkerThread
    private Long m() {
        AnalyticsConnector analyticsConnector = this.f31943b.get();
        if (analyticsConnector == null) {
            return null;
        }
        return (Long) analyticsConnector.getUserProperties(true).get("_fot");
    }

    private long n(int i4) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        int[] iArr = f31941j;
        long millis = timeUnit.toMillis(iArr[Math.min(i4, iArr.length) - 1]);
        return (millis / 2) + this.f31946e.nextInt((int) millis);
    }

    @WorkerThread
    private Map<String, String> o() {
        HashMap hashMap = new HashMap();
        AnalyticsConnector analyticsConnector = this.f31943b.get();
        if (analyticsConnector == null) {
            return hashMap;
        }
        for (Map.Entry<String, Object> entry : analyticsConnector.getUserProperties(false).entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue().toString());
        }
        return hashMap;
    }

    private boolean p(int i4) {
        if (i4 != 429 && i4 != 502 && i4 != 503 && i4 != 504) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task s(Task task, Task task2, Date date, Map map, Task task3) throws Exception {
        if (!task.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation ID for fetch.", task.getException()));
        }
        if (!task2.isSuccessful()) {
            return Tasks.forException(new FirebaseRemoteConfigClientException("Firebase Installations failed to get installation auth token for fetch.", task2.getException()));
        }
        return j((String) task.getResult(), ((InstallationTokenResult) task2.getResult()).getToken(), date, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task t(Date date, Task task) throws Exception {
        y(task, date);
        return task;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task u(Map map, Task task) throws Exception {
        return q(task, 0L, map);
    }

    private boolean v(ConfigMetadataClient.BackoffMetadata backoffMetadata, int i4) {
        if (backoffMetadata.b() > 1 || i4 == 429) {
            return true;
        }
        return false;
    }

    private ConfigMetadataClient.BackoffMetadata w(int i4, Date date) {
        if (p(i4)) {
            x(date);
        }
        return this.f31949h.a();
    }

    private void x(Date date) {
        int b4 = this.f31949h.a().b() + 1;
        this.f31949h.h(b4, new Date(date.getTime() + n(b4)));
    }

    private void y(Task<FetchResponse> task, Date date) {
        if (task.isSuccessful()) {
            this.f31949h.m(date);
            return;
        }
        Exception exception = task.getException();
        if (exception == null) {
            return;
        }
        if (exception instanceof FirebaseRemoteConfigFetchThrottledException) {
            this.f31949h.n();
        } else {
            this.f31949h.l();
        }
    }

    public Task<FetchResponse> fetch() {
        return fetch(this.f31949h.getMinimumFetchIntervalInSeconds());
    }

    public Task<FetchResponse> fetchNowWithTypeAndAttemptNumber(FetchType fetchType, int i4) {
        final HashMap hashMap = new HashMap(this.f31950i);
        hashMap.put("X-Firebase-RC-Fetch-Type", fetchType.a() + RemoteSettings.FORWARD_SLASH_STRING + i4);
        return this.f31947f.get().continueWithTask(this.f31944c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task u3;
                u3 = ConfigFetchHandler.this.u(hashMap, task);
                return u3;
            }
        });
    }

    @VisibleForTesting
    public Provider<AnalyticsConnector> getAnalyticsConnector() {
        return this.f31943b;
    }

    public long getTemplateVersionNumber() {
        return this.f31949h.d();
    }

    public Task<FetchResponse> fetch(final long j4) {
        final HashMap hashMap = new HashMap(this.f31950i);
        hashMap.put("X-Firebase-RC-Fetch-Type", FetchType.BASE.a() + RemoteSettings.FORWARD_SLASH_STRING + 1);
        return this.f31947f.get().continueWithTask(this.f31944c, new Continuation() { // from class: com.google.firebase.remoteconfig.internal.e
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task) {
                Task q4;
                q4 = ConfigFetchHandler.this.q(j4, hashMap, task);
                return q4;
            }
        });
    }
}
