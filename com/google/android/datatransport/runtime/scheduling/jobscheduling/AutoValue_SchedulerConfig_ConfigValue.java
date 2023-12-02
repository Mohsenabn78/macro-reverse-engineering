package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import java.util.Set;

/* loaded from: classes.dex */
final class AutoValue_SchedulerConfig_ConfigValue extends SchedulerConfig.ConfigValue {

    /* renamed from: a  reason: collision with root package name */
    private final long f18798a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18799b;

    /* renamed from: c  reason: collision with root package name */
    private final Set<SchedulerConfig.Flag> f18800c;

    /* loaded from: classes.dex */
    static final class Builder extends SchedulerConfig.ConfigValue.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f18801a;

        /* renamed from: b  reason: collision with root package name */
        private Long f18802b;

        /* renamed from: c  reason: collision with root package name */
        private Set<SchedulerConfig.Flag> f18803c;

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue build() {
            String str = "";
            if (this.f18801a == null) {
                str = " delta";
            }
            if (this.f18802b == null) {
                str = str + " maxAllowedDelay";
            }
            if (this.f18803c == null) {
                str = str + " flags";
            }
            if (str.isEmpty()) {
                return new AutoValue_SchedulerConfig_ConfigValue(this.f18801a.longValue(), this.f18802b.longValue(), this.f18803c);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder setDelta(long j4) {
            this.f18801a = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder setFlags(Set<SchedulerConfig.Flag> set) {
            if (set != null) {
                this.f18803c = set;
                return this;
            }
            throw new NullPointerException("Null flags");
        }

        @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue.Builder
        public SchedulerConfig.ConfigValue.Builder setMaxAllowedDelay(long j4) {
            this.f18802b = Long.valueOf(j4);
            return this;
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    long a() {
        return this.f18798a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    Set<SchedulerConfig.Flag> b() {
        return this.f18800c;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig.ConfigValue
    long c() {
        return this.f18799b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig.ConfigValue)) {
            return false;
        }
        SchedulerConfig.ConfigValue configValue = (SchedulerConfig.ConfigValue) obj;
        if (this.f18798a == configValue.a() && this.f18799b == configValue.c() && this.f18800c.equals(configValue.b())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j4 = this.f18798a;
        long j5 = this.f18799b;
        return this.f18800c.hashCode() ^ ((((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003);
    }

    public String toString() {
        return "ConfigValue{delta=" + this.f18798a + ", maxAllowedDelay=" + this.f18799b + ", flags=" + this.f18800c + "}";
    }

    private AutoValue_SchedulerConfig_ConfigValue(long j4, long j5, Set<SchedulerConfig.Flag> set) {
        this.f18798a = j4;
        this.f18799b = j5;
        this.f18800c = set;
    }
}
