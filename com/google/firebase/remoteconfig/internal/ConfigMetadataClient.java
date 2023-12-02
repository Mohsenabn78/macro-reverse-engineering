package com.google.firebase.remoteconfig.internal;

import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigInfo;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import java.util.Date;

/* loaded from: classes5.dex */
public class ConfigMetadataClient {
    @VisibleForTesting
    public static final long LAST_FETCH_TIME_IN_MILLIS_NO_FETCH_YET = -1;

    /* renamed from: e  reason: collision with root package name */
    static final Date f31970e = new Date(-1);
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    static final Date f31971f = new Date(-1);

    /* renamed from: a  reason: collision with root package name */
    private final SharedPreferences f31972a;

    /* renamed from: b  reason: collision with root package name */
    private final Object f31973b = new Object();

    /* renamed from: c  reason: collision with root package name */
    private final Object f31974c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private final Object f31975d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class BackoffMetadata {

        /* renamed from: a  reason: collision with root package name */
        private int f31976a;

        /* renamed from: b  reason: collision with root package name */
        private Date f31977b;

        BackoffMetadata(int i4, Date date) {
            this.f31976a = i4;
            this.f31977b = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date a() {
            return this.f31977b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f31976a;
        }
    }

    /* loaded from: classes5.dex */
    static class RealtimeBackoffMetadata {

        /* renamed from: a  reason: collision with root package name */
        private int f31978a;

        /* renamed from: b  reason: collision with root package name */
        private Date f31979b;

        RealtimeBackoffMetadata(int i4, Date date) {
            this.f31978a = i4;
            this.f31979b = date;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Date a() {
            return this.f31979b;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int b() {
            return this.f31978a;
        }
    }

    public ConfigMetadataClient(SharedPreferences sharedPreferences) {
        this.f31972a = sharedPreferences;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BackoffMetadata a() {
        BackoffMetadata backoffMetadata;
        synchronized (this.f31974c) {
            backoffMetadata = new BackoffMetadata(this.f31972a.getInt("num_failed_fetches", 0), new Date(this.f31972a.getLong("backoff_end_time_in_millis", -1L)));
        }
        return backoffMetadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public String b() {
        return this.f31972a.getString("last_fetch_etag", null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Date c() {
        return new Date(this.f31972a.getLong("last_fetch_time_in_millis", -1L));
    }

    @WorkerThread
    public void clear() {
        synchronized (this.f31973b) {
            this.f31972a.edit().clear().commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long d() {
        return this.f31972a.getLong("last_template_version", 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RealtimeBackoffMetadata e() {
        RealtimeBackoffMetadata realtimeBackoffMetadata;
        synchronized (this.f31975d) {
            realtimeBackoffMetadata = new RealtimeBackoffMetadata(this.f31972a.getInt("num_failed_realtime_streams", 0), new Date(this.f31972a.getLong("realtime_backoff_end_time_in_millis", -1L)));
        }
        return realtimeBackoffMetadata;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        h(0, f31971f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        k(0, f31971f);
    }

    public long getFetchTimeoutInSeconds() {
        return this.f31972a.getLong("fetch_timeout_in_seconds", 60L);
    }

    public FirebaseRemoteConfigInfo getInfo() {
        FirebaseRemoteConfigInfoImpl build;
        synchronized (this.f31973b) {
            long j4 = this.f31972a.getLong("last_fetch_time_in_millis", -1L);
            int i4 = this.f31972a.getInt("last_fetch_status", 0);
            build = FirebaseRemoteConfigInfoImpl.a().b(i4).withLastSuccessfulFetchTimeInMillis(j4).a(new FirebaseRemoteConfigSettings.Builder().setFetchTimeoutInSeconds(this.f31972a.getLong("fetch_timeout_in_seconds", 60L)).setMinimumFetchIntervalInSeconds(this.f31972a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS)).build()).build();
        }
        return build;
    }

    public long getMinimumFetchIntervalInSeconds() {
        return this.f31972a.getLong("minimum_fetch_interval_in_seconds", ConfigFetchHandler.DEFAULT_MINIMUM_FETCH_INTERVAL_IN_SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(int i4, Date date) {
        synchronized (this.f31974c) {
            this.f31972a.edit().putInt("num_failed_fetches", i4).putLong("backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(String str) {
        synchronized (this.f31973b) {
            this.f31972a.edit().putString("last_fetch_etag", str).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void j(long j4) {
        synchronized (this.f31973b) {
            this.f31972a.edit().putLong("last_template_version", j4).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(int i4, Date date) {
        synchronized (this.f31975d) {
            this.f31972a.edit().putInt("num_failed_realtime_streams", i4).putLong("realtime_backoff_end_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        synchronized (this.f31973b) {
            this.f31972a.edit().putInt("last_fetch_status", 1).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(Date date) {
        synchronized (this.f31973b) {
            this.f31972a.edit().putInt("last_fetch_status", -1).putLong("last_fetch_time_in_millis", date.getTime()).apply();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n() {
        synchronized (this.f31973b) {
            this.f31972a.edit().putInt("last_fetch_status", 2).apply();
        }
    }

    @WorkerThread
    public void setConfigSettings(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.f31973b) {
            this.f31972a.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).commit();
        }
    }

    public void setConfigSettingsWithoutWaitingOnDiskWrite(FirebaseRemoteConfigSettings firebaseRemoteConfigSettings) {
        synchronized (this.f31973b) {
            this.f31972a.edit().putLong("fetch_timeout_in_seconds", firebaseRemoteConfigSettings.getFetchTimeoutInSeconds()).putLong("minimum_fetch_interval_in_seconds", firebaseRemoteConfigSettings.getMinimumFetchIntervalInSeconds()).apply();
        }
    }
}
