package com.google.android.datatransport.runtime.firebase.transport;

import com.google.android.datatransport.runtime.ProtoEncoderDoNotUse;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.proto.Protobuf;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class ClientMetrics {

    /* renamed from: e  reason: collision with root package name */
    private static final ClientMetrics f18742e = new Builder().build();

    /* renamed from: a  reason: collision with root package name */
    private final TimeWindow f18743a;

    /* renamed from: b  reason: collision with root package name */
    private final List<LogSourceMetrics> f18744b;

    /* renamed from: c  reason: collision with root package name */
    private final GlobalMetrics f18745c;

    /* renamed from: d  reason: collision with root package name */
    private final String f18746d;

    /* loaded from: classes.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private TimeWindow f18747a = null;

        /* renamed from: b  reason: collision with root package name */
        private List<LogSourceMetrics> f18748b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private GlobalMetrics f18749c = null;

        /* renamed from: d  reason: collision with root package name */
        private String f18750d = "";

        Builder() {
        }

        public Builder addLogSourceMetrics(LogSourceMetrics logSourceMetrics) {
            this.f18748b.add(logSourceMetrics);
            return this;
        }

        public ClientMetrics build() {
            return new ClientMetrics(this.f18747a, Collections.unmodifiableList(this.f18748b), this.f18749c, this.f18750d);
        }

        public Builder setAppNamespace(String str) {
            this.f18750d = str;
            return this;
        }

        public Builder setGlobalMetrics(GlobalMetrics globalMetrics) {
            this.f18749c = globalMetrics;
            return this;
        }

        public Builder setLogSourceMetricsList(List<LogSourceMetrics> list) {
            this.f18748b = list;
            return this;
        }

        public Builder setWindow(TimeWindow timeWindow) {
            this.f18747a = timeWindow;
            return this;
        }
    }

    ClientMetrics(TimeWindow timeWindow, List<LogSourceMetrics> list, GlobalMetrics globalMetrics, String str) {
        this.f18743a = timeWindow;
        this.f18744b = list;
        this.f18745c = globalMetrics;
        this.f18746d = str;
    }

    public static ClientMetrics getDefaultInstance() {
        return f18742e;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    @Protobuf(tag = 4)
    public String getAppNamespace() {
        return this.f18746d;
    }

    @Encodable.Ignore
    public GlobalMetrics getGlobalMetrics() {
        GlobalMetrics globalMetrics = this.f18745c;
        if (globalMetrics == null) {
            return GlobalMetrics.getDefaultInstance();
        }
        return globalMetrics;
    }

    @Protobuf(tag = 3)
    @Encodable.Field(name = "globalMetrics")
    public GlobalMetrics getGlobalMetricsInternal() {
        return this.f18745c;
    }

    @Protobuf(tag = 2)
    @Encodable.Field(name = "logSourceMetrics")
    public List<LogSourceMetrics> getLogSourceMetricsList() {
        return this.f18744b;
    }

    @Encodable.Ignore
    public TimeWindow getWindow() {
        TimeWindow timeWindow = this.f18743a;
        if (timeWindow == null) {
            return TimeWindow.getDefaultInstance();
        }
        return timeWindow;
    }

    @Protobuf(tag = 1)
    @Encodable.Field(name = "window")
    public TimeWindow getWindowInternal() {
        return this.f18743a;
    }

    public byte[] toByteArray() {
        return ProtoEncoderDoNotUse.encode(this);
    }

    public void writeTo(OutputStream outputStream) throws IOException {
        ProtoEncoderDoNotUse.encode(this, outputStream);
    }
}
