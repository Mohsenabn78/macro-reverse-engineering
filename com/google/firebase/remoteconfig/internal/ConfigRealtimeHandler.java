package com.google.firebase.remoteconfig.internal;

import android.content.Context;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import com.google.firebase.FirebaseApp;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.remoteconfig.ConfigUpdateListener;
import com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes5.dex */
public class ConfigRealtimeHandler {
    @GuardedBy("this")

    /* renamed from: a  reason: collision with root package name */
    private final Set<ConfigUpdateListener> f31980a;
    @GuardedBy("this")

    /* renamed from: b  reason: collision with root package name */
    private final ConfigRealtimeHttpClient f31981b;

    /* renamed from: c  reason: collision with root package name */
    private final ConfigFetchHandler f31982c;

    /* renamed from: d  reason: collision with root package name */
    private final FirebaseApp f31983d;

    /* renamed from: e  reason: collision with root package name */
    private final FirebaseInstallationsApi f31984e;

    /* renamed from: f  reason: collision with root package name */
    private final ConfigCacheClient f31985f;

    /* renamed from: g  reason: collision with root package name */
    private final Context f31986g;

    /* renamed from: h  reason: collision with root package name */
    private final String f31987h;

    /* renamed from: i  reason: collision with root package name */
    private final ConfigMetadataClient f31988i;

    /* renamed from: j  reason: collision with root package name */
    private final ScheduledExecutorService f31989j;

    /* loaded from: classes5.dex */
    public class ConfigUpdateListenerRegistrationInternal implements ConfigUpdateListenerRegistration {

        /* renamed from: a  reason: collision with root package name */
        private final ConfigUpdateListener f31990a;

        public ConfigUpdateListenerRegistrationInternal(ConfigUpdateListener configUpdateListener) {
            this.f31990a = configUpdateListener;
        }

        @Override // com.google.firebase.remoteconfig.ConfigUpdateListenerRegistration
        public void remove() {
            ConfigRealtimeHandler.this.c(this.f31990a);
        }
    }

    public ConfigRealtimeHandler(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, ConfigFetchHandler configFetchHandler, ConfigCacheClient configCacheClient, Context context, String str, ConfigMetadataClient configMetadataClient, ScheduledExecutorService scheduledExecutorService) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        this.f31980a = linkedHashSet;
        this.f31981b = new ConfigRealtimeHttpClient(firebaseApp, firebaseInstallationsApi, configFetchHandler, configCacheClient, context, str, linkedHashSet, configMetadataClient, scheduledExecutorService);
        this.f31983d = firebaseApp;
        this.f31982c = configFetchHandler;
        this.f31984e = firebaseInstallationsApi;
        this.f31985f = configCacheClient;
        this.f31986g = context;
        this.f31987h = str;
        this.f31988i = configMetadataClient;
        this.f31989j = scheduledExecutorService;
    }

    private synchronized void b() {
        if (!this.f31980a.isEmpty()) {
            this.f31981b.startHttpConnection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void c(ConfigUpdateListener configUpdateListener) {
        this.f31980a.remove(configUpdateListener);
    }

    @NonNull
    public synchronized ConfigUpdateListenerRegistration addRealtimeConfigUpdateListener(@NonNull ConfigUpdateListener configUpdateListener) {
        this.f31980a.add(configUpdateListener);
        b();
        return new ConfigUpdateListenerRegistrationInternal(configUpdateListener);
    }

    public synchronized void setBackgroundState(boolean z3) {
        this.f31981b.v(z3);
        if (!z3) {
            b();
        }
    }
}
