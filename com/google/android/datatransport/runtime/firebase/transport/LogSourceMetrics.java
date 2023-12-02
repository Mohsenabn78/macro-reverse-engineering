package com.google.android.datatransport.runtime.firebase.transport;

import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class LogSourceMetrics {

    /* renamed from: c  reason: collision with root package name */
    private static final LogSourceMetrics f18760c = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final String f18761a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogEventDropped> f18762b;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f18763a = "";

        /* renamed from: b  reason: collision with root package name */
        private List<LogEventDropped> f18764b = new ArrayList();

        Builder() {
        }

        public Builder addLogEventDropped(LogEventDropped logEventDropped) {
            this.f18764b.add(logEventDropped);
            return this;
        }

        public LogSourceMetrics build() {
            return new LogSourceMetrics(this.f18763a, Collections.unmodifiableList(this.f18764b));
        }

        public Builder setLogEventDroppedList(List<LogEventDropped> list) {
            this.f18764b = list;
            return this;
        }

        public Builder setLogSource(String str) {
            this.f18763a = str;
            return this;
        }
    }

    LogSourceMetrics(String str, List<LogEventDropped> list) {
        this.f18761a = str;
        this.f18762b = list;
    }

    public static LogSourceMetrics getDefaultInstance() {
        return f18760c;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 2)
    @Encodable.Field(name = "logEventDropped")
    public List<LogEventDropped> getLogEventDroppedList() {
        return this.f18762b;
    }

    @Protobuf(tag = 1)
    public String getLogSource() {
        return this.f18761a;
    }
}
