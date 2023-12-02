package com.google.android.datatransport.cct.internal;

import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.internal.LogEvent;
import java.util.Arrays;

/* loaded from: classes.dex */
final class AutoValue_LogEvent extends LogEvent {

    /* renamed from: a  reason: collision with root package name */
    private final long f18569a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f18570b;

    /* renamed from: c  reason: collision with root package name */
    private final long f18571c;

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f18572d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18573e;

    /* renamed from: f  reason: collision with root package name */
    private final long f18574f;

    /* renamed from: g  reason: collision with root package name */
    private final NetworkConnectionInfo f18575g;

    /* loaded from: classes.dex */
    static final class Builder extends LogEvent.Builder {

        /* renamed from: a  reason: collision with root package name */
        private Long f18576a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f18577b;

        /* renamed from: c  reason: collision with root package name */
        private Long f18578c;

        /* renamed from: d  reason: collision with root package name */
        private byte[] f18579d;

        /* renamed from: e  reason: collision with root package name */
        private String f18580e;

        /* renamed from: f  reason: collision with root package name */
        private Long f18581f;

        /* renamed from: g  reason: collision with root package name */
        private NetworkConnectionInfo f18582g;

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder a(@Nullable byte[] bArr) {
            this.f18579d = bArr;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        LogEvent.Builder b(@Nullable String str) {
            this.f18580e = str;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent build() {
            String str = "";
            if (this.f18576a == null) {
                str = " eventTimeMs";
            }
            if (this.f18578c == null) {
                str = str + " eventUptimeMs";
            }
            if (this.f18581f == null) {
                str = str + " timezoneOffsetSeconds";
            }
            if (str.isEmpty()) {
                return new AutoValue_LogEvent(this.f18576a.longValue(), this.f18577b, this.f18578c.longValue(), this.f18579d, this.f18580e, this.f18581f.longValue(), this.f18582g);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventCode(@Nullable Integer num) {
            this.f18577b = num;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventTimeMs(long j4) {
            this.f18576a = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setEventUptimeMs(long j4) {
            this.f18578c = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setNetworkConnectionInfo(@Nullable NetworkConnectionInfo networkConnectionInfo) {
            this.f18582g = networkConnectionInfo;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.LogEvent.Builder
        public LogEvent.Builder setTimezoneOffsetSeconds(long j4) {
            this.f18581f = Long.valueOf(j4);
            return this;
        }
    }

    public boolean equals(Object obj) {
        Integer num;
        byte[] sourceExtension;
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof LogEvent)) {
            return false;
        }
        LogEvent logEvent = (LogEvent) obj;
        if (this.f18569a == logEvent.getEventTimeMs() && ((num = this.f18570b) != null ? num.equals(logEvent.getEventCode()) : logEvent.getEventCode() == null) && this.f18571c == logEvent.getEventUptimeMs()) {
            byte[] bArr = this.f18572d;
            if (logEvent instanceof AutoValue_LogEvent) {
                sourceExtension = ((AutoValue_LogEvent) logEvent).f18572d;
            } else {
                sourceExtension = logEvent.getSourceExtension();
            }
            if (Arrays.equals(bArr, sourceExtension) && ((str = this.f18573e) != null ? str.equals(logEvent.getSourceExtensionJsonProto3()) : logEvent.getSourceExtensionJsonProto3() == null) && this.f18574f == logEvent.getTimezoneOffsetSeconds()) {
                NetworkConnectionInfo networkConnectionInfo = this.f18575g;
                if (networkConnectionInfo == null) {
                    if (logEvent.getNetworkConnectionInfo() == null) {
                        return true;
                    }
                } else if (networkConnectionInfo.equals(logEvent.getNetworkConnectionInfo())) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public Integer getEventCode() {
        return this.f18570b;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getEventTimeMs() {
        return this.f18569a;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getEventUptimeMs() {
        return this.f18571c;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public NetworkConnectionInfo getNetworkConnectionInfo() {
        return this.f18575g;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public byte[] getSourceExtension() {
        return this.f18572d;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    @Nullable
    public String getSourceExtensionJsonProto3() {
        return this.f18573e;
    }

    @Override // com.google.android.datatransport.cct.internal.LogEvent
    public long getTimezoneOffsetSeconds() {
        return this.f18574f;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2;
        long j4 = this.f18569a;
        int i4 = (((int) (j4 ^ (j4 >>> 32))) ^ 1000003) * 1000003;
        Integer num = this.f18570b;
        int i5 = 0;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        long j5 = this.f18571c;
        int hashCode3 = (((((i4 ^ hashCode) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ Arrays.hashCode(this.f18572d)) * 1000003;
        String str = this.f18573e;
        if (str == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = str.hashCode();
        }
        long j6 = this.f18574f;
        int i6 = (((hashCode3 ^ hashCode2) * 1000003) ^ ((int) ((j6 >>> 32) ^ j6))) * 1000003;
        NetworkConnectionInfo networkConnectionInfo = this.f18575g;
        if (networkConnectionInfo != null) {
            i5 = networkConnectionInfo.hashCode();
        }
        return i6 ^ i5;
    }

    public String toString() {
        return "LogEvent{eventTimeMs=" + this.f18569a + ", eventCode=" + this.f18570b + ", eventUptimeMs=" + this.f18571c + ", sourceExtension=" + Arrays.toString(this.f18572d) + ", sourceExtensionJsonProto3=" + this.f18573e + ", timezoneOffsetSeconds=" + this.f18574f + ", networkConnectionInfo=" + this.f18575g + "}";
    }

    private AutoValue_LogEvent(long j4, @Nullable Integer num, long j5, @Nullable byte[] bArr, @Nullable String str, long j6, @Nullable NetworkConnectionInfo networkConnectionInfo) {
        this.f18569a = j4;
        this.f18570b = num;
        this.f18571c = j5;
        this.f18572d = bArr;
        this.f18573e = str;
        this.f18574f = j6;
        this.f18575g = networkConnectionInfo;
    }
}
