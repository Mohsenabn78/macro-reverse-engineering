package com.google.logging.type;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.Duration;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class HttpRequest extends GeneratedMessageLite<HttpRequest, Builder> implements HttpRequestOrBuilder {
    public static final int CACHE_FILL_BYTES_FIELD_NUMBER = 12;
    public static final int CACHE_HIT_FIELD_NUMBER = 9;
    public static final int CACHE_LOOKUP_FIELD_NUMBER = 11;
    public static final int CACHE_VALIDATED_WITH_ORIGIN_SERVER_FIELD_NUMBER = 10;
    private static final HttpRequest DEFAULT_INSTANCE;
    public static final int LATENCY_FIELD_NUMBER = 14;
    private static volatile Parser<HttpRequest> PARSER = null;
    public static final int PROTOCOL_FIELD_NUMBER = 15;
    public static final int REFERER_FIELD_NUMBER = 8;
    public static final int REMOTE_IP_FIELD_NUMBER = 7;
    public static final int REQUEST_METHOD_FIELD_NUMBER = 1;
    public static final int REQUEST_SIZE_FIELD_NUMBER = 3;
    public static final int REQUEST_URL_FIELD_NUMBER = 2;
    public static final int RESPONSE_SIZE_FIELD_NUMBER = 5;
    public static final int SERVER_IP_FIELD_NUMBER = 13;
    public static final int STATUS_FIELD_NUMBER = 4;
    public static final int USER_AGENT_FIELD_NUMBER = 6;
    private long cacheFillBytes_;
    private boolean cacheHit_;
    private boolean cacheLookup_;
    private boolean cacheValidatedWithOriginServer_;
    private Duration latency_;
    private long requestSize_;
    private long responseSize_;
    private int status_;
    private String requestMethod_ = "";
    private String requestUrl_ = "";
    private String userAgent_ = "";
    private String remoteIp_ = "";
    private String serverIp_ = "";
    private String referer_ = "";
    private String protocol_ = "";

    /* renamed from: com.google.logging.type.HttpRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32904a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32904a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32904a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32904a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32904a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32904a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32904a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32904a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<HttpRequest, Builder> implements HttpRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCacheFillBytes() {
            f();
            ((HttpRequest) this.f33398b).S0();
            return this;
        }

        public Builder clearCacheHit() {
            f();
            ((HttpRequest) this.f33398b).T0();
            return this;
        }

        public Builder clearCacheLookup() {
            f();
            ((HttpRequest) this.f33398b).U0();
            return this;
        }

        public Builder clearCacheValidatedWithOriginServer() {
            f();
            ((HttpRequest) this.f33398b).V0();
            return this;
        }

        public Builder clearLatency() {
            f();
            ((HttpRequest) this.f33398b).W0();
            return this;
        }

        public Builder clearProtocol() {
            f();
            ((HttpRequest) this.f33398b).X0();
            return this;
        }

        public Builder clearReferer() {
            f();
            ((HttpRequest) this.f33398b).Y0();
            return this;
        }

        public Builder clearRemoteIp() {
            f();
            ((HttpRequest) this.f33398b).Z0();
            return this;
        }

        public Builder clearRequestMethod() {
            f();
            ((HttpRequest) this.f33398b).a1();
            return this;
        }

        public Builder clearRequestSize() {
            f();
            ((HttpRequest) this.f33398b).b1();
            return this;
        }

        public Builder clearRequestUrl() {
            f();
            ((HttpRequest) this.f33398b).c1();
            return this;
        }

        public Builder clearResponseSize() {
            f();
            ((HttpRequest) this.f33398b).d1();
            return this;
        }

        public Builder clearServerIp() {
            f();
            ((HttpRequest) this.f33398b).e1();
            return this;
        }

        public Builder clearStatus() {
            f();
            ((HttpRequest) this.f33398b).f1();
            return this;
        }

        public Builder clearUserAgent() {
            f();
            ((HttpRequest) this.f33398b).g1();
            return this;
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getCacheFillBytes() {
            return ((HttpRequest) this.f33398b).getCacheFillBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheHit() {
            return ((HttpRequest) this.f33398b).getCacheHit();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheLookup() {
            return ((HttpRequest) this.f33398b).getCacheLookup();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean getCacheValidatedWithOriginServer() {
            return ((HttpRequest) this.f33398b).getCacheValidatedWithOriginServer();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public Duration getLatency() {
            return ((HttpRequest) this.f33398b).getLatency();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getProtocol() {
            return ((HttpRequest) this.f33398b).getProtocol();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getProtocolBytes() {
            return ((HttpRequest) this.f33398b).getProtocolBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getReferer() {
            return ((HttpRequest) this.f33398b).getReferer();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRefererBytes() {
            return ((HttpRequest) this.f33398b).getRefererBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRemoteIp() {
            return ((HttpRequest) this.f33398b).getRemoteIp();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRemoteIpBytes() {
            return ((HttpRequest) this.f33398b).getRemoteIpBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRequestMethod() {
            return ((HttpRequest) this.f33398b).getRequestMethod();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRequestMethodBytes() {
            return ((HttpRequest) this.f33398b).getRequestMethodBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getRequestSize() {
            return ((HttpRequest) this.f33398b).getRequestSize();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getRequestUrl() {
            return ((HttpRequest) this.f33398b).getRequestUrl();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getRequestUrlBytes() {
            return ((HttpRequest) this.f33398b).getRequestUrlBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public long getResponseSize() {
            return ((HttpRequest) this.f33398b).getResponseSize();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getServerIp() {
            return ((HttpRequest) this.f33398b).getServerIp();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getServerIpBytes() {
            return ((HttpRequest) this.f33398b).getServerIpBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public int getStatus() {
            return ((HttpRequest) this.f33398b).getStatus();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public String getUserAgent() {
            return ((HttpRequest) this.f33398b).getUserAgent();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public ByteString getUserAgentBytes() {
            return ((HttpRequest) this.f33398b).getUserAgentBytes();
        }

        @Override // com.google.logging.type.HttpRequestOrBuilder
        public boolean hasLatency() {
            return ((HttpRequest) this.f33398b).hasLatency();
        }

        public Builder mergeLatency(Duration duration) {
            f();
            ((HttpRequest) this.f33398b).h1(duration);
            return this;
        }

        public Builder setCacheFillBytes(long j4) {
            f();
            ((HttpRequest) this.f33398b).i1(j4);
            return this;
        }

        public Builder setCacheHit(boolean z3) {
            f();
            ((HttpRequest) this.f33398b).j1(z3);
            return this;
        }

        public Builder setCacheLookup(boolean z3) {
            f();
            ((HttpRequest) this.f33398b).k1(z3);
            return this;
        }

        public Builder setCacheValidatedWithOriginServer(boolean z3) {
            f();
            ((HttpRequest) this.f33398b).l1(z3);
            return this;
        }

        public Builder setLatency(Duration duration) {
            f();
            ((HttpRequest) this.f33398b).m1(duration);
            return this;
        }

        public Builder setProtocol(String str) {
            f();
            ((HttpRequest) this.f33398b).n1(str);
            return this;
        }

        public Builder setProtocolBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).o1(byteString);
            return this;
        }

        public Builder setReferer(String str) {
            f();
            ((HttpRequest) this.f33398b).p1(str);
            return this;
        }

        public Builder setRefererBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).q1(byteString);
            return this;
        }

        public Builder setRemoteIp(String str) {
            f();
            ((HttpRequest) this.f33398b).r1(str);
            return this;
        }

        public Builder setRemoteIpBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).s1(byteString);
            return this;
        }

        public Builder setRequestMethod(String str) {
            f();
            ((HttpRequest) this.f33398b).t1(str);
            return this;
        }

        public Builder setRequestMethodBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).u1(byteString);
            return this;
        }

        public Builder setRequestSize(long j4) {
            f();
            ((HttpRequest) this.f33398b).v1(j4);
            return this;
        }

        public Builder setRequestUrl(String str) {
            f();
            ((HttpRequest) this.f33398b).w1(str);
            return this;
        }

        public Builder setRequestUrlBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).x1(byteString);
            return this;
        }

        public Builder setResponseSize(long j4) {
            f();
            ((HttpRequest) this.f33398b).y1(j4);
            return this;
        }

        public Builder setServerIp(String str) {
            f();
            ((HttpRequest) this.f33398b).z1(str);
            return this;
        }

        public Builder setServerIpBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).A1(byteString);
            return this;
        }

        public Builder setStatus(int i4) {
            f();
            ((HttpRequest) this.f33398b).B1(i4);
            return this;
        }

        public Builder setUserAgent(String str) {
            f();
            ((HttpRequest) this.f33398b).C1(str);
            return this;
        }

        public Builder setUserAgentBytes(ByteString byteString) {
            f();
            ((HttpRequest) this.f33398b).D1(byteString);
            return this;
        }

        private Builder() {
            super(HttpRequest.DEFAULT_INSTANCE);
        }

        public Builder setLatency(Duration.Builder builder) {
            f();
            ((HttpRequest) this.f33398b).m1(builder.build());
            return this;
        }
    }

    static {
        HttpRequest httpRequest = new HttpRequest();
        DEFAULT_INSTANCE = httpRequest;
        GeneratedMessageLite.d0(HttpRequest.class, httpRequest);
    }

    private HttpRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.serverIp_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B1(int i4) {
        this.status_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C1(String str) {
        str.getClass();
        this.userAgent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.userAgent_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.cacheFillBytes_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        this.cacheHit_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        this.cacheLookup_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        this.cacheValidatedWithOriginServer_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.latency_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        this.protocol_ = getDefaultInstance().getProtocol();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        this.referer_ = getDefaultInstance().getReferer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        this.remoteIp_ = getDefaultInstance().getRemoteIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        this.requestMethod_ = getDefaultInstance().getRequestMethod();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        this.requestSize_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        this.requestUrl_ = getDefaultInstance().getRequestUrl();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1() {
        this.responseSize_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1() {
        this.serverIp_ = getDefaultInstance().getServerIp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1() {
        this.status_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1() {
        this.userAgent_ = getDefaultInstance().getUserAgent();
    }

    public static HttpRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(Duration duration) {
        duration.getClass();
        Duration duration2 = this.latency_;
        if (duration2 != null && duration2 != Duration.getDefaultInstance()) {
            this.latency_ = Duration.newBuilder(this.latency_).mergeFrom((Duration.Builder) duration).buildPartial();
        } else {
            this.latency_ = duration;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(long j4) {
        this.cacheFillBytes_ = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(boolean z3) {
        this.cacheHit_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(boolean z3) {
        this.cacheLookup_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(boolean z3) {
        this.cacheValidatedWithOriginServer_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(Duration duration) {
        duration.getClass();
        this.latency_ = duration;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(String str) {
        str.getClass();
        this.protocol_ = str;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.protocol_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(String str) {
        str.getClass();
        this.referer_ = str;
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (HttpRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<HttpRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.referer_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(String str) {
        str.getClass();
        this.remoteIp_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.remoteIp_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(String str) {
        str.getClass();
        this.requestMethod_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.requestMethod_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(long j4) {
        this.requestSize_ = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(String str) {
        str.getClass();
        this.requestUrl_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.requestUrl_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(long j4) {
        this.responseSize_ = j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z1(String str) {
        str.getClass();
        this.serverIp_ = str;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getCacheFillBytes() {
        return this.cacheFillBytes_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheHit() {
        return this.cacheHit_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheLookup() {
        return this.cacheLookup_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean getCacheValidatedWithOriginServer() {
        return this.cacheValidatedWithOriginServer_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public Duration getLatency() {
        Duration duration = this.latency_;
        if (duration == null) {
            return Duration.getDefaultInstance();
        }
        return duration;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getProtocol() {
        return this.protocol_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getProtocolBytes() {
        return ByteString.copyFromUtf8(this.protocol_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getReferer() {
        return this.referer_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRefererBytes() {
        return ByteString.copyFromUtf8(this.referer_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRemoteIp() {
        return this.remoteIp_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRemoteIpBytes() {
        return ByteString.copyFromUtf8(this.remoteIp_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRequestMethod() {
        return this.requestMethod_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRequestMethodBytes() {
        return ByteString.copyFromUtf8(this.requestMethod_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getRequestSize() {
        return this.requestSize_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getRequestUrl() {
        return this.requestUrl_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getRequestUrlBytes() {
        return ByteString.copyFromUtf8(this.requestUrl_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public long getResponseSize() {
        return this.responseSize_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getServerIp() {
        return this.serverIp_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getServerIpBytes() {
        return ByteString.copyFromUtf8(this.serverIp_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public int getStatus() {
        return this.status_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public String getUserAgent() {
        return this.userAgent_;
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public ByteString getUserAgentBytes() {
        return ByteString.copyFromUtf8(this.userAgent_);
    }

    @Override // com.google.logging.type.HttpRequestOrBuilder
    public boolean hasLatency() {
        if (this.latency_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32904a[methodToInvoke.ordinal()]) {
            case 1:
                return new HttpRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u000f\u0000\u0000\u0001\u000f\u000f\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0002\u0004\u0004\u0005\u0002\u0006Ȉ\u0007Ȉ\bȈ\t\u0007\n\u0007\u000b\u0007\f\u0002\rȈ\u000e\t\u000fȈ", new Object[]{"requestMethod_", "requestUrl_", "requestSize_", "status_", "responseSize_", "userAgent_", "remoteIp_", "referer_", "cacheHit_", "cacheValidatedWithOriginServer_", "cacheLookup_", "cacheFillBytes_", "serverIp_", "latency_", "protocol_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<HttpRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (HttpRequest.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public static Builder newBuilder(HttpRequest httpRequest) {
        return DEFAULT_INSTANCE.r(httpRequest);
    }

    public static HttpRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static HttpRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static HttpRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (HttpRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(InputStream inputStream) throws IOException {
        return (HttpRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static HttpRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (HttpRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static HttpRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (HttpRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
