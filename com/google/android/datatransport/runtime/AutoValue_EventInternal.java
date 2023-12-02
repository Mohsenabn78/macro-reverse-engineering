package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.EventInternal;
import java.util.Map;

/* loaded from: classes.dex */
final class AutoValue_EventInternal extends EventInternal {

    /* renamed from: a  reason: collision with root package name */
    private final String f18630a;

    /* renamed from: b  reason: collision with root package name */
    private final Integer f18631b;

    /* renamed from: c  reason: collision with root package name */
    private final EncodedPayload f18632c;

    /* renamed from: d  reason: collision with root package name */
    private final long f18633d;

    /* renamed from: e  reason: collision with root package name */
    private final long f18634e;

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, String> f18635f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static final class Builder extends EventInternal.Builder {

        /* renamed from: a  reason: collision with root package name */
        private String f18636a;

        /* renamed from: b  reason: collision with root package name */
        private Integer f18637b;

        /* renamed from: c  reason: collision with root package name */
        private EncodedPayload f18638c;

        /* renamed from: d  reason: collision with root package name */
        private Long f18639d;

        /* renamed from: e  reason: collision with root package name */
        private Long f18640e;

        /* renamed from: f  reason: collision with root package name */
        private Map<String, String> f18641f;

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        protected Map<String, String> a() {
            Map<String, String> map = this.f18641f;
            if (map != null) {
                return map;
            }
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder b(Map<String, String> map) {
            if (map != null) {
                this.f18641f = map;
                return this;
            }
            throw new NullPointerException("Null autoMetadata");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal build() {
            String str = "";
            if (this.f18636a == null) {
                str = " transportName";
            }
            if (this.f18638c == null) {
                str = str + " encodedPayload";
            }
            if (this.f18639d == null) {
                str = str + " eventMillis";
            }
            if (this.f18640e == null) {
                str = str + " uptimeMillis";
            }
            if (this.f18641f == null) {
                str = str + " autoMetadata";
            }
            if (str.isEmpty()) {
                return new AutoValue_EventInternal(this.f18636a, this.f18637b, this.f18638c, this.f18639d.longValue(), this.f18640e.longValue(), this.f18641f);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setCode(Integer num) {
            this.f18637b = num;
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setEncodedPayload(EncodedPayload encodedPayload) {
            if (encodedPayload != null) {
                this.f18638c = encodedPayload;
                return this;
            }
            throw new NullPointerException("Null encodedPayload");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setEventMillis(long j4) {
            this.f18639d = Long.valueOf(j4);
            return this;
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setTransportName(String str) {
            if (str != null) {
                this.f18636a = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }

        @Override // com.google.android.datatransport.runtime.EventInternal.Builder
        public EventInternal.Builder setUptimeMillis(long j4) {
            this.f18640e = Long.valueOf(j4);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.datatransport.runtime.EventInternal
    public Map<String, String> a() {
        return this.f18635f;
    }

    public boolean equals(Object obj) {
        Integer num;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof EventInternal)) {
            return false;
        }
        EventInternal eventInternal = (EventInternal) obj;
        if (this.f18630a.equals(eventInternal.getTransportName()) && ((num = this.f18631b) != null ? num.equals(eventInternal.getCode()) : eventInternal.getCode() == null) && this.f18632c.equals(eventInternal.getEncodedPayload()) && this.f18633d == eventInternal.getEventMillis() && this.f18634e == eventInternal.getUptimeMillis() && this.f18635f.equals(eventInternal.a())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    @Nullable
    public Integer getCode() {
        return this.f18631b;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public EncodedPayload getEncodedPayload() {
        return this.f18632c;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long getEventMillis() {
        return this.f18633d;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public String getTransportName() {
        return this.f18630a;
    }

    @Override // com.google.android.datatransport.runtime.EventInternal
    public long getUptimeMillis() {
        return this.f18634e;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (this.f18630a.hashCode() ^ 1000003) * 1000003;
        Integer num = this.f18631b;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        long j4 = this.f18633d;
        long j5 = this.f18634e;
        return ((((((((hashCode2 ^ hashCode) * 1000003) ^ this.f18632c.hashCode()) * 1000003) ^ ((int) (j4 ^ (j4 >>> 32)))) * 1000003) ^ ((int) (j5 ^ (j5 >>> 32)))) * 1000003) ^ this.f18635f.hashCode();
    }

    public String toString() {
        return "EventInternal{transportName=" + this.f18630a + ", code=" + this.f18631b + ", encodedPayload=" + this.f18632c + ", eventMillis=" + this.f18633d + ", uptimeMillis=" + this.f18634e + ", autoMetadata=" + this.f18635f + "}";
    }

    private AutoValue_EventInternal(String str, @Nullable Integer num, EncodedPayload encodedPayload, long j4, long j5, Map<String, String> map) {
        this.f18630a = str;
        this.f18631b = num;
        this.f18632c = encodedPayload;
        this.f18633d = j4;
        this.f18634e = j5;
        this.f18635f = map;
    }
}
