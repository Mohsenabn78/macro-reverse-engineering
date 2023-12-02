package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import android.app.job.JobInfo;
import androidx.annotation.RequiresApi;
import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AutoValue_SchedulerConfig_ConfigValue;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.auto.value.AutoValue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@AutoValue
/* loaded from: classes.dex */
public abstract class SchedulerConfig {

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Clock f18807a;

        /* renamed from: b  reason: collision with root package name */
        private Map<Priority, ConfigValue> f18808b = new HashMap();

        public Builder addConfig(Priority priority, ConfigValue configValue) {
            this.f18808b.put(priority, configValue);
            return this;
        }

        public SchedulerConfig build() {
            if (this.f18807a != null) {
                if (this.f18808b.keySet().size() >= Priority.values().length) {
                    Map<Priority, ConfigValue> map = this.f18808b;
                    this.f18808b = new HashMap();
                    return SchedulerConfig.b(this.f18807a, map);
                }
                throw new IllegalStateException("Not all priorities have been configured");
            }
            throw new NullPointerException("missing required property: clock");
        }

        public Builder setClock(Clock clock) {
            this.f18807a = clock;
            return this;
        }
    }

    @AutoValue
    /* loaded from: classes.dex */
    public static abstract class ConfigValue {

        @AutoValue.Builder
        /* loaded from: classes.dex */
        public static abstract class Builder {
            public abstract ConfigValue build();

            public abstract Builder setDelta(long j4);

            public abstract Builder setFlags(Set<Flag> set);

            public abstract Builder setMaxAllowedDelay(long j4);
        }

        public static Builder builder() {
            return new AutoValue_SchedulerConfig_ConfigValue.Builder().setFlags(Collections.emptySet());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long a();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Set<Flag> b();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract long c();
    }

    /* loaded from: classes.dex */
    public enum Flag {
        NETWORK_UNMETERED,
        DEVICE_IDLE,
        DEVICE_CHARGING
    }

    private long a(int i4, long j4) {
        long j5;
        int i5 = i4 - 1;
        if (j4 > 1) {
            j5 = j4;
        } else {
            j5 = 2;
        }
        return (long) (Math.pow(3.0d, i5) * j4 * Math.max(1.0d, Math.log(10000.0d) / Math.log(j5 * i5)));
    }

    static SchedulerConfig b(Clock clock, Map<Priority, ConfigValue> map) {
        return new AutoValue_SchedulerConfig(clock, map);
    }

    public static Builder builder() {
        return new Builder();
    }

    private static <T> Set<T> e(T... tArr) {
        return Collections.unmodifiableSet(new HashSet(Arrays.asList(tArr)));
    }

    @RequiresApi(api = 21)
    private void f(JobInfo.Builder builder, Set<Flag> set) {
        if (set.contains(Flag.NETWORK_UNMETERED)) {
            builder.setRequiredNetworkType(2);
        } else {
            builder.setRequiredNetworkType(1);
        }
        if (set.contains(Flag.DEVICE_CHARGING)) {
            builder.setRequiresCharging(true);
        }
        if (set.contains(Flag.DEVICE_IDLE)) {
            builder.setRequiresDeviceIdle(true);
        }
    }

    public static SchedulerConfig getDefault(Clock clock) {
        return builder().addConfig(Priority.DEFAULT, ConfigValue.builder().setDelta(30000L).setMaxAllowedDelay(86400000L).build()).addConfig(Priority.HIGHEST, ConfigValue.builder().setDelta(1000L).setMaxAllowedDelay(86400000L).build()).addConfig(Priority.VERY_LOW, ConfigValue.builder().setDelta(86400000L).setMaxAllowedDelay(86400000L).setFlags(e(Flag.DEVICE_IDLE)).build()).setClock(clock).build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Clock c();

    @RequiresApi(api = 21)
    public JobInfo.Builder configureJob(JobInfo.Builder builder, Priority priority, long j4, int i4) {
        builder.setMinimumLatency(getScheduleDelay(priority, j4, i4));
        f(builder, d().get(priority).b());
        return builder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Map<Priority, ConfigValue> d();

    public Set<Flag> getFlags(Priority priority) {
        return d().get(priority).b();
    }

    public long getScheduleDelay(Priority priority, long j4, int i4) {
        long time = j4 - c().getTime();
        ConfigValue configValue = d().get(priority);
        return Math.min(Math.max(a(i4, configValue.a()), time), configValue.c());
    }
}
