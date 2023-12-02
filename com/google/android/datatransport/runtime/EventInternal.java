package com.google.android.datatransport.runtime;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@AutoValue
/* loaded from: classes.dex */
public abstract class EventInternal {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        protected abstract Map<String, String> a();

        public final Builder addMetadata(String str, String str2) {
            a().put(str, str2);
            return this;
        }

        protected abstract Builder b(Map<String, String> map);

        public abstract EventInternal build();

        public abstract Builder setCode(Integer num);

        public abstract Builder setEncodedPayload(EncodedPayload encodedPayload);

        public abstract Builder setEventMillis(long j4);

        public abstract Builder setTransportName(String str);

        public abstract Builder setUptimeMillis(long j4);

        public final Builder addMetadata(String str, long j4) {
            a().put(str, String.valueOf(j4));
            return this;
        }

        public final Builder addMetadata(String str, int i4) {
            a().put(str, String.valueOf(i4));
            return this;
        }
    }

    public static Builder builder() {
        return new AutoValue_EventInternal.Builder().b(new HashMap());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Map<String, String> a();

    public final String get(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return "";
        }
        return str2;
    }

    @Nullable
    public abstract Integer getCode();

    public abstract EncodedPayload getEncodedPayload();

    public abstract long getEventMillis();

    public final int getInteger(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public final long getLong(String str) {
        String str2 = a().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    public final Map<String, String> getMetadata() {
        return Collections.unmodifiableMap(a());
    }

    public final String getOrDefault(String str, String str2) {
        String str3 = a().get(str);
        if (str3 != null) {
            return str3;
        }
        return str2;
    }

    @Deprecated
    public byte[] getPayload() {
        return getEncodedPayload().getBytes();
    }

    public abstract String getTransportName();

    public abstract long getUptimeMillis();

    public Builder toBuilder() {
        return new AutoValue_EventInternal.Builder().setTransportName(getTransportName()).setCode(getCode()).setEncodedPayload(getEncodedPayload()).setEventMillis(getEventMillis()).setUptimeMillis(getUptimeMillis()).b(new HashMap(a()));
    }
}
