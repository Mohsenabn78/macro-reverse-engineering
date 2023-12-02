package com.google.firebase.analytics.connector;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.annotations.DeferredApi;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
/* loaded from: classes5.dex */
public interface AnalyticsConnector {

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public interface AnalyticsConnectorHandle {
        @KeepForSdk
        void registerEventNames(@NonNull Set<String> set);

        @KeepForSdk
        void unregister();

        @KeepForSdk
        void unregisterEventNames();
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public interface AnalyticsConnectorListener {
        @KeepForSdk
        void onMessageTriggered(int i4, @Nullable Bundle bundle);
    }

    /* compiled from: com.google.firebase:firebase-measurement-connector@@19.0.0 */
    @KeepForSdk
    /* loaded from: classes5.dex */
    public static class ConditionalUserProperty {
        @KeepForSdk
        public boolean active;
        @KeepForSdk
        public long creationTimestamp;
        @Nullable
        @KeepForSdk
        public String expiredEventName;
        @Nullable
        @KeepForSdk
        public Bundle expiredEventParams;
        @NonNull
        @KeepForSdk
        public String name;
        @NonNull
        @KeepForSdk
        public String origin;
        @KeepForSdk
        public long timeToLive;
        @Nullable
        @KeepForSdk
        public String timedOutEventName;
        @Nullable
        @KeepForSdk
        public Bundle timedOutEventParams;
        @Nullable
        @KeepForSdk
        public String triggerEventName;
        @KeepForSdk
        public long triggerTimeout;
        @Nullable
        @KeepForSdk
        public String triggeredEventName;
        @Nullable
        @KeepForSdk
        public Bundle triggeredEventParams;
        @KeepForSdk
        public long triggeredTimestamp;
        @Nullable
        @KeepForSdk
        public Object value;
    }

    @KeepForSdk
    void clearConditionalUserProperty(@NonNull @Size(max = 24, min = 1) String str, @Nullable String str2, @Nullable Bundle bundle);

    @NonNull
    @KeepForSdk
    @WorkerThread
    List<ConditionalUserProperty> getConditionalUserProperties(@NonNull String str, @Nullable @Size(max = 23, min = 1) String str2);

    @KeepForSdk
    @WorkerThread
    int getMaxUserProperties(@NonNull @Size(min = 1) String str);

    @NonNull
    @KeepForSdk
    @WorkerThread
    Map<String, Object> getUserProperties(boolean z3);

    @KeepForSdk
    void logEvent(@NonNull String str, @NonNull String str2, @Nullable Bundle bundle);

    @Nullable
    @KeepForSdk
    @DeferredApi
    AnalyticsConnectorHandle registerAnalyticsConnectorListener(@NonNull String str, @NonNull AnalyticsConnectorListener analyticsConnectorListener);

    @KeepForSdk
    void setConditionalUserProperty(@NonNull ConditionalUserProperty conditionalUserProperty);

    @KeepForSdk
    void setUserProperty(@NonNull String str, @NonNull String str2, @NonNull Object obj);
}
