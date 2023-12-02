package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.LogRequest;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_LogRequest extends LogRequest {

    /* renamed from: a  reason: collision with root package name */
    private final long f18583a;

    /* renamed from: b  reason: collision with root package name */
    private final long f18584b;

    /* renamed from: c  reason: collision with root package name */
    private final ClientInfo f18585c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f18586d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18587e;

    /* renamed from: f  reason: collision with root package name */
    private final List<LogEvent> f18588f;

    /* renamed from: g  reason: collision with root package name */
    private final QosTier f18589g;

    /* loaded from: classes.dex */
    static final class Builder extends LogRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f18590a;

        /* renamed from: b  reason: collision with root package name */
        private Long f18591b;

        /* renamed from: c  reason: collision with root package name */
        private ClientInfo f18592c;

        /* renamed from: d  reason: collision with root package name */
        private Integer f18593d;

        /* renamed from: e  reason: collision with root package name */
        private String f18594e;

        /* renamed from: f  reason: collision with root package name */
        private List<LogEvent> f18595f;

        /* renamed from: g  reason: collision with root package name */
        private QosTier f18596g;

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder a(@Nullable Integer num) {
            this.f18593d = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        LogRequest.Builder b(@Nullable String str) {
            this.f18594e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest build() {
            String str = "";
            if (this.f18590a == null) {
                str = " requestTimeMs";
            }
            if (this.f18591b == null) {
                str = str + " requestUptimeMs";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogRequest(this.f18590a.longValue(), this.f18591b.longValue(), this.f18592c, this.f18593d, this.f18594e, this.f18595f, this.f18596g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setClientInfo(@Nullable ClientInfo clientInfo) {
            this.f18592c = clientInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setLogEvents(@Nullable List<LogEvent> list) {
            this.f18595f = list;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setQosTier(@Nullable QosTier qosTier) {
            this.f18596g = qosTier;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setRequestTimeMs(long j4) {
            this.f18590a = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogRequest.Builder
        public LogRequest.Builder setRequestUptimeMs(long j4) {
            this.f18591b = Long.valueOf(j4);
            return this;
        }
    }

    public boolean equals(Object obj) {
        ClientInfo clientInfo;
        Integer num;
        String str;
        List<LogEvent> list;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogRequest)) {
            return false;
        }
        LogRequest logRequest = (LogRequest) obj;
        if (this.f18583a == logRequest.getRequestTimeMs() && this.f18584b == logRequest.getRequestUptimeMs() && ((clientInfo = this.f18585c) != null ? clientInfo.equals(logRequest.getClientInfo()) : logRequest.getClientInfo() == null) && ((num = this.f18586d) != null ? num.equals(logRequest.getLogSource()) : logRequest.getLogSource() == null) && ((str = this.f18587e) != null ? str.equals(logRequest.getLogSourceName()) : logRequest.getLogSourceName() == null) && ((list = this.f18588f) != null ? list.equals(logRequest.getLogEvents()) : logRequest.getLogEvents() == null)) {
            QosTier qosTier = this.f18589g;
            if (qosTier == null) {
                if (logRequest.getQosTier() == null) {
                    return true;
                }
            } else if (qosTier.equals(logRequest.getQosTier())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public ClientInfo getClientInfo() {
        return this.f18585c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    @Encodable.Field(name = "logEvent")
    public List<LogEvent> getLogEvents() {
        return this.f18588f;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public Integer getLogSource() {
        return this.f18586d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public String getLogSourceName() {
        return this.f18587e;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    @Nullable
    public QosTier getQosTier() {
        return this.f18589g;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long getRequestTimeMs() {
        return this.f18583a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogRequest
    public long getRequestUptimeMs() {
        return this.f18584b;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3;
        int hashCode4;
        long j4 = this.f18583a;
        long j5 = this.f18584b;
        int i4 = (((((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003) ^ ((int) ((j5 >>> 32) ^ j5))) * 1000003;
        ClientInfo clientInfo = this.f18585c;
        int i5 = 0;
        if (clientInfo == null) {
            hashCode = 0;
        } else {
            hashCode = clientInfo.hashCode();
        }
        int i6 = (i4 ^ hashCode) * 1000003;
        Integer num = this.f18586d;
        if (num == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = num.hashCode();
        }
        int i7 = (i6 ^ hashCode2) * 1000003;
        String str = this.f18587e;
        if (str == null) {
            hashCode3 = 0;
        } else {
            hashCode3 = str.hashCode();
        }
        int i8 = (i7 ^ hashCode3) * 1000003;
        List<LogEvent> list = this.f18588f;
        if (list == null) {
            hashCode4 = 0;
        } else {
            hashCode4 = list.hashCode();
        }
        int i9 = (i8 ^ hashCode4) * 1000003;
        QosTier qosTier = this.f18589g;
        if (qosTier != null) {
            i5 = qosTier.hashCode();
        }
        return i9 ^ i5;
    }

    public String toString() {
        return "LogRequest{requestTimeMs=" + this.f18583a + ", requestUptimeMs=" + this.f18584b + ", clientInfo=" + this.f18585c + ", logSource=" + this.f18586d + ", logSourceName=" + this.f18587e + ", logEvents=" + this.f18588f + ", qosTier=" + this.f18589g + "}";
    }

    private AutoValue_LogRequest(long j4, long j5, @Nullable ClientInfo clientInfo, @Nullable Integer num, @Nullable String str, @Nullable List<LogEvent> list, @Nullable QosTier qosTier) {
        this.f18583a = j4;
        this.f18584b = j5;
        this.f18585c = clientInfo;
        this.f18586d = num;
        this.f18587e = str;
        this.f18588f = list;
        this.f18589g = qosTier;
    }
}
