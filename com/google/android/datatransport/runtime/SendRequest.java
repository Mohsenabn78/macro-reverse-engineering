package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.AutoValue_SendRequest;
import com.google.auto.value.AutoValue;

/* JADX INFO: Access modifiers changed from: package-private */
@AutoValue
/* loaded from: classes.dex */
public abstract class SendRequest {

    @AutoValue.Builder
    /* loaded from: classes.dex */
    public static abstract class Builder {
        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Builder a(Encoding encoding);

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Builder b(Event<?> event);

        public abstract SendRequest build();

        /* JADX INFO: Access modifiers changed from: package-private */
        public abstract Builder c(Transformer<?, byte[]> transformer);

        public <T> Builder setEvent(Event<T> event, Encoding encoding, Transformer<T, byte[]> transformer) {
            b(event);
            a(encoding);
            c(transformer);
            return this;
        }

        public abstract Builder setTransportContext(TransportContext transportContext);

        public abstract Builder setTransportName(String str);
    }

    public static Builder a() {
        return new AutoValue_SendRequest.Builder();
    }

    public abstract Encoding b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Event<?> c();

    public byte[] d() {
        return e().apply(c().getPayload());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Transformer<?, byte[]> e();

    public abstract TransportContext f();

    public abstract String g();
}
