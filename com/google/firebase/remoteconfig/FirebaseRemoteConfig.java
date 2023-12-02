package com.google.firebase.remoteconfig;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.XmlRes;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.abt.AbtException;
import com.google.firebase.abt.FirebaseABTesting;
import com.google.firebase.concurrent.FirebaseExecutors;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.internal.ConfigCacheClient;
import com.google.firebase.remoteconfig.internal.ConfigContainer;
import com.google.firebase.remoteconfig.internal.ConfigFetchHandler;
import com.google.firebase.remoteconfig.internal.ConfigGetParameterHandler;
import com.google.firebase.remoteconfig.internal.ConfigMetadataClient;
import com.google.firebase.remoteconfig.internal.ConfigRealtimeHandler;
import com.google.firebase.remoteconfig.internal.DefaultsXmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class FirebaseRemoteConfig {
    public static final boolean DEFAULT_VALUE_FOR_BOOLEAN = false;
    public static final byte[] DEFAULT_VALUE_FOR_BYTE_ARRAY = new byte[0];
    public static final double DEFAULT_VALUE_FOR_DOUBLE = 0.0d;
    public static final long DEFAULT_VALUE_FOR_LONG = 0;
    public static final String DEFAULT_VALUE_FOR_STRING = "";
    public static final int LAST_FETCH_STATUS_FAILURE = 1;
    public static final int LAST_FETCH_STATUS_NO_FETCH_YET = 0;
    public static final int LAST_FETCH_STATUS_SUCCESS = -1;
    public static final int LAST_FETCH_STATUS_THROTTLED = 2;
    public static final String TAG = "FirebaseRemoteConfig";
    public static final int VALUE_SOURCE_DEFAULT = 1;
    public static final int VALUE_SOURCE_REMOTE = 2;
    public static final int VALUE_SOURCE_STATIC = 0;

    /* renamed from: a  reason: collision with root package name */
    private final Context f31874a;

    /* renamed from: b  reason: collision with root package name */
    private final FirebaseApp f31875b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseABTesting f31876c;

    /* renamed from: d  reason: collision with root package name */
    private final Executor f31877d;

    /* renamed from: e  reason: collision with root package name */
    private final ConfigCacheClient f31878e;

    /* renamed from: f  reason: collision with root package name */
    private final ConfigCacheClient f31879f;

    /* renamed from: g  reason: collision with root package name */
    private final ConfigCacheClient f31880g;

    /* renamed from: h  reason: collision with root package name */
    private final ConfigFetchHandler f31881h;

    /* renamed from: i  reason: collision with root package name */
    private final ConfigGetParameterHandler f31882i;

    /* renamed from: j  reason: collision with root package name */
    private final ConfigMetadataClient f31883j;

    /* renamed from: k  reason: collision with root package name */
    private final FirebaseInstallationsApi f31884k;

    /* renamed from: l  reason: collision with root package name */
    private final ConfigRealtimeHandler f31885l;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FirebaseRemoteConfig(Context context, FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, @Nullable FirebaseABTesting firebaseABTesting, Executor executor, ConfigCacheClient configCacheClient, ConfigCacheClient configCacheClient2, ConfigCacheClient configCacheClient3, ConfigFetchHandler configFetchHandler, ConfigGetParameterHandler configGetParameterHandler, ConfigMetadataClient configMetadataClient, ConfigRealtimeHandler configRealtimeHandler) {
        this.f31874a = context;
        this.f31875b = firebaseApp;
        this.f31884k = firebaseInstallationsApi;
        this.f31876c = firebaseABTesting;
        this.f31877d = executor;
        this.f31878e = configCacheClient;
        this.f31879f = configCacheClient2;
        this.f31880g = configCacheClient3;
        this.f31881h = configFetchHandler;
        this.f31882i = configGetParameterHandler;
        this.f31883j = configMetadataClient;
        this.f31885l = configRealtimeHandler;
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance() {
        return getInstance(FirebaseApp.getInstance());
    }

    private static boolean j(ConfigContainer configContainer, @Nullable ConfigContainer configContainer2) {
        if (configContainer2 != null && configContainer.getFetchTime().equals(configContainer2.getFetchTime())) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task k(Task task, Task task2, Task task3) throws Exception {
        if (task.isSuccessful() && task.getResult() != null) {
            ConfigContainer configContainer = (ConfigContainer) task.getResult();
            if (task2.isSuccessful() && !j(configContainer, (ConfigContainer) task2.getResult())) {
                return Tasks.forResult(Boolean.FALSE);
            }
            return this.f31879f.put(configContainer).continueWith(this.f31877d, new Continuation() { // from class: com.google.firebase.remoteconfig.j
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task4) {
                    boolean s3;
                    s3 = FirebaseRemoteConfig.this.s(task4);
                    return Boolean.valueOf(s3);
                }
            });
        }
        return Tasks.forResult(Boolean.FALSE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ FirebaseRemoteConfigInfo l(Task task, Task task2) throws Exception {
        return (FirebaseRemoteConfigInfo) task.getResult();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task m(ConfigFetchHandler.FetchResponse fetchResponse) throws Exception {
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task n(ConfigFetchHandler.FetchResponse fetchResponse) throws Exception {
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Task o(Void r12) throws Exception {
        return activate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void p() throws Exception {
        this.f31879f.clear();
        this.f31878e.clear();
        this.f31880g.clear();
        this.f31883j.clear();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Void q(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) throws Exception {
        this.f31883j.setConfigSettings(firebaseRemoteConfigSettings);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Task r(ConfigContainer configContainer) throws Exception {
        return Tasks.forResult(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(Task<ConfigContainer> task) {
        if (task.isSuccessful()) {
            this.f31878e.clear();
            if (task.getResult() != null) {
                x(task.getResult().getAbtExperiments());
                return true;
            }
            Log.e(TAG, "Activated configs written to disk are null.");
            return true;
        }
        return false;
    }

    private Task<Void> u(Map<String, String> map) {
        try {
            return this.f31880g.put(ConfigContainer.newBuilder().replaceConfigsWith(map).build()).onSuccessTask(FirebaseExecutors.directExecutor(), new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.a
                @Override // com.google.android.gms.tasks.SuccessContinuation
                public final Task then(Object obj) {
                    Task r4;
                    r4 = FirebaseRemoteConfig.r((ConfigContainer) obj);
                    return r4;
                }
            });
        } catch (JSONException e4) {
            Log.e(TAG, "The provided defaults map could not be processed.", e4);
            return Tasks.forResult(null);
        }
    }

    @VisibleForTesting
    static List<Map<String, String>> w(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i4 = 0; i4 < jSONArray.length(); i4++) {
            HashMap hashMap = new HashMap();
            JSONObject jSONObject = jSONArray.getJSONObject(i4);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            }
            arrayList.add(hashMap);
        }
        return arrayList;
    }

    @NonNull
    public Task<Boolean> activate() {
        final Task<ConfigContainer> task = this.f31878e.get();
        final Task<ConfigContainer> task2 = this.f31879f.get();
        return Tasks.whenAllComplete(task, task2).continueWithTask(this.f31877d, new Continuation() { // from class: com.google.firebase.remoteconfig.i
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task3) {
                Task k4;
                k4 = FirebaseRemoteConfig.this.k(task, task2, task3);
                return k4;
            }
        });
    }

    @NonNull
    public ConfigUpdateListenerRegistration addOnConfigUpdateListener(@NonNull ConfigUpdateListener configUpdateListener) {
        return this.f31885l.addRealtimeConfigUpdateListener(configUpdateListener);
    }

    @NonNull
    public Task<FirebaseRemoteConfigInfo> ensureInitialized() {
        Task<ConfigContainer> task = this.f31879f.get();
        Task<ConfigContainer> task2 = this.f31880g.get();
        Task<ConfigContainer> task3 = this.f31878e.get();
        final Task call = Tasks.call(this.f31877d, new Callable() { // from class: com.google.firebase.remoteconfig.e
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return FirebaseRemoteConfig.this.getInfo();
            }
        });
        return Tasks.whenAllComplete(task, task2, task3, call, this.f31884k.getId(), this.f31884k.getToken(false)).continueWith(this.f31877d, new Continuation() { // from class: com.google.firebase.remoteconfig.f
            @Override // com.google.android.gms.tasks.Continuation
            public final Object then(Task task4) {
                FirebaseRemoteConfigInfo l4;
                l4 = FirebaseRemoteConfig.l(Task.this, task4);
                return l4;
            }
        });
    }

    @NonNull
    public Task<Void> fetch() {
        return this.f31881h.fetch().onSuccessTask(FirebaseExecutors.directExecutor(), new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.d
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task m4;
                m4 = FirebaseRemoteConfig.m((ConfigFetchHandler.FetchResponse) obj);
                return m4;
            }
        });
    }

    @NonNull
    public Task<Boolean> fetchAndActivate() {
        return fetch().onSuccessTask(this.f31877d, new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.h
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task o4;
                o4 = FirebaseRemoteConfig.this.o((Void) obj);
                return o4;
            }
        });
    }

    @NonNull
    public Map<String, FirebaseRemoteConfigValue> getAll() {
        return this.f31882i.getAll();
    }

    public boolean getBoolean(@NonNull String str) {
        return this.f31882i.getBoolean(str);
    }

    public double getDouble(@NonNull String str) {
        return this.f31882i.getDouble(str);
    }

    @NonNull
    public FirebaseRemoteConfigInfo getInfo() {
        return this.f31883j.getInfo();
    }

    @NonNull
    public Set<String> getKeysByPrefix(@NonNull String str) {
        return this.f31882i.getKeysByPrefix(str);
    }

    public long getLong(@NonNull String str) {
        return this.f31882i.getLong(str);
    }

    @NonNull
    public String getString(@NonNull String str) {
        return this.f31882i.getString(str);
    }

    @NonNull
    public FirebaseRemoteConfigValue getValue(@NonNull String str) {
        return this.f31882i.getValue(str);
    }

    @NonNull
    public Task<Void> reset() {
        return Tasks.call(this.f31877d, new Callable() { // from class: com.google.firebase.remoteconfig.c
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void p4;
                p4 = FirebaseRemoteConfig.this.p();
                return p4;
            }
        });
    }

    public void schedule(Runnable runnable) {
        this.f31877d.execute(runnable);
    }

    @NonNull
    public Task<Void> setConfigSettingsAsync(@NonNull final FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        return Tasks.call(this.f31877d, new Callable() { // from class: com.google.firebase.remoteconfig.g
            @Override // java.util.concurrent.Callable
            public final Object call() {
                Void q4;
                q4 = FirebaseRemoteConfig.this.q(firebaseRemoteConfigSettings);
                return q4;
            }
        });
    }

    @NonNull
    public Task<Void> setDefaultsAsync(@NonNull Map<String, Object> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                hashMap.put(entry.getKey(), new String((byte[]) value));
            } else {
                hashMap.put(entry.getKey(), value.toString());
            }
        }
        return u(hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void t(boolean z3) {
        this.f31885l.setBackgroundState(z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v() {
        this.f31879f.get();
        this.f31880g.get();
        this.f31878e.get();
    }

    @VisibleForTesting
    void x(@NonNull JSONArray jSONArray) {
        if (this.f31876c == null) {
            return;
        }
        try {
            this.f31876c.replaceAllExperiments(w(jSONArray));
        } catch (AbtException e4) {
            Log.w(TAG, "Could not update ABT experiments.", e4);
        } catch (JSONException e5) {
            Log.e(TAG, "Could not parse ABT experiments from the JSON response.", e5);
        }
    }

    @NonNull
    public static FirebaseRemoteConfig getInstance(@NonNull FirebaseApp firebaseApp) {
        return ((RemoteConfigComponent) firebaseApp.get(RemoteConfigComponent.class)).e();
    }

    @NonNull
    public Task<Void> fetch(long j4) {
        return this.f31881h.fetch(j4).onSuccessTask(FirebaseExecutors.directExecutor(), new SuccessContinuation() { // from class: com.google.firebase.remoteconfig.b
            @Override // com.google.android.gms.tasks.SuccessContinuation
            public final Task then(Object obj) {
                Task n4;
                n4 = FirebaseRemoteConfig.n((ConfigFetchHandler.FetchResponse) obj);
                return n4;
            }
        });
    }

    @NonNull
    public Task<Void> setDefaultsAsync(@XmlRes int i4) {
        return u(DefaultsXmlParser.getDefaultsFromXml(this.f31874a, i4));
    }
}
