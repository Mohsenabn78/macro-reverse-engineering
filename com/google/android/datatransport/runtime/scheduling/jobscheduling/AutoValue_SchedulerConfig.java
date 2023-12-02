package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import com.google.android.datatransport.Priority;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig;
import com.google.android.datatransport.runtime.time.Clock;
import java.util.Map;

/* loaded from: classes.dex */
final class AutoValue_SchedulerConfig extends SchedulerConfig {

    /* renamed from: a  reason: collision with root package name */
    private final Clock f18796a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Priority, SchedulerConfig.ConfigValue> f18797b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_SchedulerConfig(Clock clock, Map<Priority, SchedulerConfig.ConfigValue> map) {
        if (clock != null) {
            this.f18796a = clock;
            if (map != null) {
                this.f18797b = map;
                return;
            }
            throw new NullPointerException("Null values");
        }
        throw new NullPointerException("Null clock");
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Clock c() {
        return this.f18796a;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.SchedulerConfig
    Map<Priority, SchedulerConfig.ConfigValue> d() {
        return this.f18797b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SchedulerConfig)) {
            return false;
        }
        SchedulerConfig schedulerConfig = (SchedulerConfig) obj;
        if (this.f18796a.equals(schedulerConfig.c()) && this.f18797b.equals(schedulerConfig.d())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.f18796a.hashCode() ^ 1000003) * 1000003) ^ this.f18797b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.f18796a + ", values=" + this.f18797b + "}";
    }
}
