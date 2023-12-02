package com.google.android.datatransport.runtime;

import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.runtime.SendRequest;

/* loaded from: classes.dex */
final class AutoValue_SendRequest extends SendRequest {

    /* renamed from: a  reason: collision with root package name */
    private final TransportContext f18642a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18643b;

    /* renamed from: c  reason: collision with root package name */
    private final Event<?> f18644c;

    /* renamed from: d  reason: collision with root package name */
    private final Transformer<?, byte[]> f18645d;

    /* renamed from: e  reason: collision with root package name */
    private final Encoding f18646e;

    /* loaded from: classes.dex */
    static final class Builder extends SendRequest.Builder {

        /* renamed from: a  reason: collision with root package name */
        private TransportContext f18647a;

        /* renamed from: b  reason: collision with root package name */
        private String f18648b;

        /* renamed from: c  reason: collision with root package name */
        private Event<?> f18649c;

        /* renamed from: d  reason: collision with root package name */
        private Transformer<?, byte[]> f18650d;

        /* renamed from: e  reason: collision with root package name */
        private Encoding f18651e;

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder a(Encoding encoding) {
            if (encoding != null) {
                this.f18651e = encoding;
                return this;
            }
            throw new NullPointerException("Null encoding");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder b(Event<?> event) {
            if (event != null) {
                this.f18649c = event;
                return this;
            }
            throw new NullPointerException("Null event");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest build() {
            String str = "";
            if (this.f18647a == null) {
                str = " transportContext";
            }
            if (this.f18648b == null) {
                str = str + " transportName";
            }
            if (this.f18649c == null) {
                str = str + " event";
            }
            if (this.f18650d == null) {
                str = str + " transformer";
            }
            if (this.f18651e == null) {
                str = str + " encoding";
            }
            if (str.isEmpty()) {
                return new AutoValue_SendRequest(this.f18647a, this.f18648b, this.f18649c, this.f18650d, this.f18651e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        SendRequest.Builder c(Transformer<?, byte[]> transformer) {
            if (transformer != null) {
                this.f18650d = transformer;
                return this;
            }
            throw new NullPointerException("Null transformer");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder setTransportContext(TransportContext transportContext) {
            if (transportContext != null) {
                this.f18647a = transportContext;
                return this;
            }
            throw new NullPointerException("Null transportContext");
        }

        @Override // com.google.android.datatransport.runtime.SendRequest.Builder
        public SendRequest.Builder setTransportName(String str) {
            if (str != null) {
                this.f18648b = str;
                return this;
            }
            throw new NullPointerException("Null transportName");
        }
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public Encoding b() {
        return this.f18646e;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    Event<?> c() {
        return this.f18644c;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    Transformer<?, byte[]> e() {
        return this.f18645d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SendRequest)) {
            return false;
        }
        SendRequest sendRequest = (SendRequest) obj;
        if (this.f18642a.equals(sendRequest.f()) && this.f18643b.equals(sendRequest.g()) && this.f18644c.equals(sendRequest.c()) && this.f18645d.equals(sendRequest.e()) && this.f18646e.equals(sendRequest.b())) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public TransportContext f() {
        return this.f18642a;
    }

    @Override // com.google.android.datatransport.runtime.SendRequest
    public String g() {
        return this.f18643b;
    }

    public int hashCode() {
        return ((((((((this.f18642a.hashCode() ^ 1000003) * 1000003) ^ this.f18643b.hashCode()) * 1000003) ^ this.f18644c.hashCode()) * 1000003) ^ this.f18645d.hashCode()) * 1000003) ^ this.f18646e.hashCode();
    }

    public String toString() {
        return "SendRequest{transportContext=" + this.f18642a + ", transportName=" + this.f18643b + ", event=" + this.f18644c + ", transformer=" + this.f18645d + ", encoding=" + this.f18646e + "}";
    }

    private AutoValue_SendRequest(TransportContext transportContext, String str, Event<?> event, Transformer<?, byte[]> transformer, Encoding encoding) {
        this.f18642a = transportContext;
        this.f18643b = str;
        this.f18644c = event;
        this.f18645d = transformer;
        this.f18646e = encoding;
    }
}
