package com.google.cloud.audit;

import com.google.cloud.audit.AuthenticationInfo;
import com.google.cloud.audit.AuthorizationInfo;
import com.google.cloud.audit.RequestMetadata;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.Any;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import com.google.rpc.Status;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class AuditLog extends GeneratedMessageLite<AuditLog, Builder> implements AuditLogOrBuilder {
    public static final int AUTHENTICATION_INFO_FIELD_NUMBER = 3;
    public static final int AUTHORIZATION_INFO_FIELD_NUMBER = 9;
    private static final AuditLog DEFAULT_INSTANCE;
    public static final int METHOD_NAME_FIELD_NUMBER = 8;
    public static final int NUM_RESPONSE_ITEMS_FIELD_NUMBER = 12;
    private static volatile Parser<AuditLog> PARSER = null;
    public static final int REQUEST_FIELD_NUMBER = 16;
    public static final int REQUEST_METADATA_FIELD_NUMBER = 4;
    public static final int RESOURCE_NAME_FIELD_NUMBER = 11;
    public static final int RESPONSE_FIELD_NUMBER = 17;
    public static final int SERVICE_DATA_FIELD_NUMBER = 15;
    public static final int SERVICE_NAME_FIELD_NUMBER = 7;
    public static final int STATUS_FIELD_NUMBER = 2;
    private AuthenticationInfo authenticationInfo_;
    private long numResponseItems_;
    private RequestMetadata requestMetadata_;
    private Struct request_;
    private Struct response_;
    private Any serviceData_;
    private Status status_;
    private String serviceName_ = "";
    private String methodName_ = "";
    private String resourceName_ = "";
    private Internal.ProtobufList<AuthorizationInfo> authorizationInfo_ = GeneratedMessageLite.y();

    /* renamed from: com.google.cloud.audit.AuditLog$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26257a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f26257a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26257a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f26257a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f26257a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f26257a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f26257a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f26257a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AuditLog, Builder> implements AuditLogOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllAuthorizationInfo(Iterable<? extends AuthorizationInfo> iterable) {
            f();
            ((AuditLog) this.f33398b).P0(iterable);
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo authorizationInfo) {
            f();
            ((AuditLog) this.f33398b).R0(authorizationInfo);
            return this;
        }

        public Builder clearAuthenticationInfo() {
            f();
            ((AuditLog) this.f33398b).S0();
            return this;
        }

        public Builder clearAuthorizationInfo() {
            f();
            ((AuditLog) this.f33398b).T0();
            return this;
        }

        public Builder clearMethodName() {
            f();
            ((AuditLog) this.f33398b).U0();
            return this;
        }

        public Builder clearNumResponseItems() {
            f();
            ((AuditLog) this.f33398b).V0();
            return this;
        }

        public Builder clearRequest() {
            f();
            ((AuditLog) this.f33398b).W0();
            return this;
        }

        public Builder clearRequestMetadata() {
            f();
            ((AuditLog) this.f33398b).X0();
            return this;
        }

        public Builder clearResourceName() {
            f();
            ((AuditLog) this.f33398b).Y0();
            return this;
        }

        public Builder clearResponse() {
            f();
            ((AuditLog) this.f33398b).Z0();
            return this;
        }

        public Builder clearServiceData() {
            f();
            ((AuditLog) this.f33398b).a1();
            return this;
        }

        public Builder clearServiceName() {
            f();
            ((AuditLog) this.f33398b).b1();
            return this;
        }

        public Builder clearStatus() {
            f();
            ((AuditLog) this.f33398b).c1();
            return this;
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthenticationInfo getAuthenticationInfo() {
            return ((AuditLog) this.f33398b).getAuthenticationInfo();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public AuthorizationInfo getAuthorizationInfo(int i4) {
            return ((AuditLog) this.f33398b).getAuthorizationInfo(i4);
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public int getAuthorizationInfoCount() {
            return ((AuditLog) this.f33398b).getAuthorizationInfoCount();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public List<AuthorizationInfo> getAuthorizationInfoList() {
            return Collections.unmodifiableList(((AuditLog) this.f33398b).getAuthorizationInfoList());
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getMethodName() {
            return ((AuditLog) this.f33398b).getMethodName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getMethodNameBytes() {
            return ((AuditLog) this.f33398b).getMethodNameBytes();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public long getNumResponseItems() {
            return ((AuditLog) this.f33398b).getNumResponseItems();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getRequest() {
            return ((AuditLog) this.f33398b).getRequest();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public RequestMetadata getRequestMetadata() {
            return ((AuditLog) this.f33398b).getRequestMetadata();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getResourceName() {
            return ((AuditLog) this.f33398b).getResourceName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getResourceNameBytes() {
            return ((AuditLog) this.f33398b).getResourceNameBytes();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Struct getResponse() {
            return ((AuditLog) this.f33398b).getResponse();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Any getServiceData() {
            return ((AuditLog) this.f33398b).getServiceData();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public String getServiceName() {
            return ((AuditLog) this.f33398b).getServiceName();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public ByteString getServiceNameBytes() {
            return ((AuditLog) this.f33398b).getServiceNameBytes();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public Status getStatus() {
            return ((AuditLog) this.f33398b).getStatus();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasAuthenticationInfo() {
            return ((AuditLog) this.f33398b).hasAuthenticationInfo();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequest() {
            return ((AuditLog) this.f33398b).hasRequest();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasRequestMetadata() {
            return ((AuditLog) this.f33398b).hasRequestMetadata();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasResponse() {
            return ((AuditLog) this.f33398b).hasResponse();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasServiceData() {
            return ((AuditLog) this.f33398b).hasServiceData();
        }

        @Override // com.google.cloud.audit.AuditLogOrBuilder
        public boolean hasStatus() {
            return ((AuditLog) this.f33398b).hasStatus();
        }

        public Builder mergeAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            f();
            ((AuditLog) this.f33398b).e1(authenticationInfo);
            return this;
        }

        public Builder mergeRequest(Struct struct) {
            f();
            ((AuditLog) this.f33398b).f1(struct);
            return this;
        }

        public Builder mergeRequestMetadata(RequestMetadata requestMetadata) {
            f();
            ((AuditLog) this.f33398b).g1(requestMetadata);
            return this;
        }

        public Builder mergeResponse(Struct struct) {
            f();
            ((AuditLog) this.f33398b).h1(struct);
            return this;
        }

        public Builder mergeServiceData(Any any) {
            f();
            ((AuditLog) this.f33398b).i1(any);
            return this;
        }

        public Builder mergeStatus(Status status) {
            f();
            ((AuditLog) this.f33398b).j1(status);
            return this;
        }

        public Builder removeAuthorizationInfo(int i4) {
            f();
            ((AuditLog) this.f33398b).k1(i4);
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo authenticationInfo) {
            f();
            ((AuditLog) this.f33398b).l1(authenticationInfo);
            return this;
        }

        public Builder setAuthorizationInfo(int i4, AuthorizationInfo authorizationInfo) {
            f();
            ((AuditLog) this.f33398b).m1(i4, authorizationInfo);
            return this;
        }

        public Builder setMethodName(String str) {
            f();
            ((AuditLog) this.f33398b).n1(str);
            return this;
        }

        public Builder setMethodNameBytes(ByteString byteString) {
            f();
            ((AuditLog) this.f33398b).o1(byteString);
            return this;
        }

        public Builder setNumResponseItems(long j4) {
            f();
            ((AuditLog) this.f33398b).p1(j4);
            return this;
        }

        public Builder setRequest(Struct struct) {
            f();
            ((AuditLog) this.f33398b).q1(struct);
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata requestMetadata) {
            f();
            ((AuditLog) this.f33398b).r1(requestMetadata);
            return this;
        }

        public Builder setResourceName(String str) {
            f();
            ((AuditLog) this.f33398b).s1(str);
            return this;
        }

        public Builder setResourceNameBytes(ByteString byteString) {
            f();
            ((AuditLog) this.f33398b).t1(byteString);
            return this;
        }

        public Builder setResponse(Struct struct) {
            f();
            ((AuditLog) this.f33398b).u1(struct);
            return this;
        }

        public Builder setServiceData(Any any) {
            f();
            ((AuditLog) this.f33398b).v1(any);
            return this;
        }

        public Builder setServiceName(String str) {
            f();
            ((AuditLog) this.f33398b).w1(str);
            return this;
        }

        public Builder setServiceNameBytes(ByteString byteString) {
            f();
            ((AuditLog) this.f33398b).x1(byteString);
            return this;
        }

        public Builder setStatus(Status status) {
            f();
            ((AuditLog) this.f33398b).y1(status);
            return this;
        }

        private Builder() {
            super(AuditLog.DEFAULT_INSTANCE);
        }

        public Builder addAuthorizationInfo(int i4, AuthorizationInfo authorizationInfo) {
            f();
            ((AuditLog) this.f33398b).Q0(i4, authorizationInfo);
            return this;
        }

        public Builder setAuthenticationInfo(AuthenticationInfo.Builder builder) {
            f();
            ((AuditLog) this.f33398b).l1(builder.build());
            return this;
        }

        public Builder setAuthorizationInfo(int i4, AuthorizationInfo.Builder builder) {
            f();
            ((AuditLog) this.f33398b).m1(i4, builder.build());
            return this;
        }

        public Builder setRequest(Struct.Builder builder) {
            f();
            ((AuditLog) this.f33398b).q1(builder.build());
            return this;
        }

        public Builder setRequestMetadata(RequestMetadata.Builder builder) {
            f();
            ((AuditLog) this.f33398b).r1(builder.build());
            return this;
        }

        public Builder setResponse(Struct.Builder builder) {
            f();
            ((AuditLog) this.f33398b).u1(builder.build());
            return this;
        }

        public Builder setServiceData(Any.Builder builder) {
            f();
            ((AuditLog) this.f33398b).v1(builder.build());
            return this;
        }

        public Builder setStatus(Status.Builder builder) {
            f();
            ((AuditLog) this.f33398b).y1(builder.build());
            return this;
        }

        public Builder addAuthorizationInfo(AuthorizationInfo.Builder builder) {
            f();
            ((AuditLog) this.f33398b).R0(builder.build());
            return this;
        }

        public Builder addAuthorizationInfo(int i4, AuthorizationInfo.Builder builder) {
            f();
            ((AuditLog) this.f33398b).Q0(i4, builder.build());
            return this;
        }
    }

    static {
        AuditLog auditLog = new AuditLog();
        DEFAULT_INSTANCE = auditLog;
        GeneratedMessageLite.d0(AuditLog.class, auditLog);
    }

    private AuditLog() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(Iterable<? extends AuthorizationInfo> iterable) {
        d1();
        AbstractMessageLite.a(iterable, this.authorizationInfo_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i4, AuthorizationInfo authorizationInfo) {
        authorizationInfo.getClass();
        d1();
        this.authorizationInfo_.add(i4, authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(AuthorizationInfo authorizationInfo) {
        authorizationInfo.getClass();
        d1();
        this.authorizationInfo_.add(authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.authenticationInfo_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        this.authorizationInfo_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        this.methodName_ = getDefaultInstance().getMethodName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        this.numResponseItems_ = 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.request_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0() {
        this.requestMetadata_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0() {
        this.resourceName_ = getDefaultInstance().getResourceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0() {
        this.response_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1() {
        this.serviceData_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1() {
        this.serviceName_ = getDefaultInstance().getServiceName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1() {
        this.status_ = null;
    }

    private void d1() {
        Internal.ProtobufList<AuthorizationInfo> protobufList = this.authorizationInfo_;
        if (!protobufList.isModifiable()) {
            this.authorizationInfo_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(AuthenticationInfo authenticationInfo) {
        authenticationInfo.getClass();
        AuthenticationInfo authenticationInfo2 = this.authenticationInfo_;
        if (authenticationInfo2 != null && authenticationInfo2 != AuthenticationInfo.getDefaultInstance()) {
            this.authenticationInfo_ = AuthenticationInfo.newBuilder(this.authenticationInfo_).mergeFrom((AuthenticationInfo.Builder) authenticationInfo).buildPartial();
        } else {
            this.authenticationInfo_ = authenticationInfo;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(Struct struct) {
        struct.getClass();
        Struct struct2 = this.request_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            this.request_ = Struct.newBuilder(this.request_).mergeFrom((Struct.Builder) struct).buildPartial();
        } else {
            this.request_ = struct;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(RequestMetadata requestMetadata) {
        requestMetadata.getClass();
        RequestMetadata requestMetadata2 = this.requestMetadata_;
        if (requestMetadata2 != null && requestMetadata2 != RequestMetadata.getDefaultInstance()) {
            this.requestMetadata_ = RequestMetadata.newBuilder(this.requestMetadata_).mergeFrom((RequestMetadata.Builder) requestMetadata).buildPartial();
        } else {
            this.requestMetadata_ = requestMetadata;
        }
    }

    public static AuditLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(Struct struct) {
        struct.getClass();
        Struct struct2 = this.response_;
        if (struct2 != null && struct2 != Struct.getDefaultInstance()) {
            this.response_ = Struct.newBuilder(this.response_).mergeFrom((Struct.Builder) struct).buildPartial();
        } else {
            this.response_ = struct;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(Any any) {
        any.getClass();
        Any any2 = this.serviceData_;
        if (any2 != null && any2 != Any.getDefaultInstance()) {
            this.serviceData_ = Any.newBuilder(this.serviceData_).mergeFrom((Any.Builder) any).buildPartial();
        } else {
            this.serviceData_ = any;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(Status status) {
        status.getClass();
        Status status2 = this.status_;
        if (status2 != null && status2 != Status.getDefaultInstance()) {
            this.status_ = Status.newBuilder(this.status_).mergeFrom((Status.Builder) status).buildPartial();
        } else {
            this.status_ = status;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(int i4) {
        d1();
        this.authorizationInfo_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(AuthenticationInfo authenticationInfo) {
        authenticationInfo.getClass();
        this.authenticationInfo_ = authenticationInfo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(int i4, AuthorizationInfo authorizationInfo) {
        authorizationInfo.getClass();
        d1();
        this.authorizationInfo_.set(i4, authorizationInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(String str) {
        str.getClass();
        this.methodName_ = str;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.methodName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p1(long j4) {
        this.numResponseItems_ = j4;
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AuditLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(Struct struct) {
        struct.getClass();
        this.request_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(RequestMetadata requestMetadata) {
        requestMetadata.getClass();
        this.requestMetadata_ = requestMetadata;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s1(String str) {
        str.getClass();
        this.resourceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.resourceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u1(Struct struct) {
        struct.getClass();
        this.response_ = struct;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v1(Any any) {
        any.getClass();
        this.serviceData_ = any;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w1(String str) {
        str.getClass();
        this.serviceName_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.serviceName_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y1(Status status) {
        status.getClass();
        this.status_ = status;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthenticationInfo getAuthenticationInfo() {
        AuthenticationInfo authenticationInfo = this.authenticationInfo_;
        if (authenticationInfo == null) {
            return AuthenticationInfo.getDefaultInstance();
        }
        return authenticationInfo;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public AuthorizationInfo getAuthorizationInfo(int i4) {
        return this.authorizationInfo_.get(i4);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public int getAuthorizationInfoCount() {
        return this.authorizationInfo_.size();
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public List<AuthorizationInfo> getAuthorizationInfoList() {
        return this.authorizationInfo_;
    }

    public AuthorizationInfoOrBuilder getAuthorizationInfoOrBuilder(int i4) {
        return this.authorizationInfo_.get(i4);
    }

    public List<? extends AuthorizationInfoOrBuilder> getAuthorizationInfoOrBuilderList() {
        return this.authorizationInfo_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getMethodName() {
        return this.methodName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getMethodNameBytes() {
        return ByteString.copyFromUtf8(this.methodName_);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public long getNumResponseItems() {
        return this.numResponseItems_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getRequest() {
        Struct struct = this.request_;
        if (struct == null) {
            return Struct.getDefaultInstance();
        }
        return struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public RequestMetadata getRequestMetadata() {
        RequestMetadata requestMetadata = this.requestMetadata_;
        if (requestMetadata == null) {
            return RequestMetadata.getDefaultInstance();
        }
        return requestMetadata;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getResourceName() {
        return this.resourceName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getResourceNameBytes() {
        return ByteString.copyFromUtf8(this.resourceName_);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Struct getResponse() {
        Struct struct = this.response_;
        if (struct == null) {
            return Struct.getDefaultInstance();
        }
        return struct;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Any getServiceData() {
        Any any = this.serviceData_;
        if (any == null) {
            return Any.getDefaultInstance();
        }
        return any;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public String getServiceName() {
        return this.serviceName_;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public ByteString getServiceNameBytes() {
        return ByteString.copyFromUtf8(this.serviceName_);
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public Status getStatus() {
        Status status = this.status_;
        if (status == null) {
            return Status.getDefaultInstance();
        }
        return status;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasAuthenticationInfo() {
        if (this.authenticationInfo_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequest() {
        if (this.request_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasRequestMetadata() {
        if (this.requestMetadata_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasResponse() {
        if (this.response_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasServiceData() {
        if (this.serviceData_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.cloud.audit.AuditLogOrBuilder
    public boolean hasStatus() {
        if (this.status_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f26257a[methodToInvoke.ordinal()]) {
            case 1:
                return new AuditLog();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u000b\u0000\u0000\u0002\u0011\u000b\u0000\u0001\u0000\u0002\t\u0003\t\u0004\t\u0007Ȉ\bȈ\t\u001b\u000bȈ\f\u0002\u000f\t\u0010\t\u0011\t", new Object[]{"status_", "authenticationInfo_", "requestMetadata_", "serviceName_", "methodName_", "authorizationInfo_", AuthorizationInfo.class, "resourceName_", "numResponseItems_", "serviceData_", "request_", "response_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AuditLog> parser = PARSER;
                if (parser == null) {
                    synchronized (AuditLog.class) {
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

    public static Builder newBuilder(AuditLog auditLog) {
        return DEFAULT_INSTANCE.r(auditLog);
    }

    public static AuditLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AuditLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static AuditLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AuditLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static AuditLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AuditLog) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AuditLog parseFrom(InputStream inputStream) throws IOException {
        return (AuditLog) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static AuditLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AuditLog) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AuditLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AuditLog) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
