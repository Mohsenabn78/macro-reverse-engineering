package com.google.firestore.v1;

import com.google.firestore.v1.AggregationResult;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class RunAggregationQueryResponse extends GeneratedMessageLite<RunAggregationQueryResponse, Builder> implements RunAggregationQueryResponseOrBuilder {
    private static final RunAggregationQueryResponse DEFAULT_INSTANCE;
    private static volatile Parser<RunAggregationQueryResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 3;
    public static final int RESULT_FIELD_NUMBER = 1;
    public static final int TRANSACTION_FIELD_NUMBER = 2;
    private Timestamp readTime_;
    private AggregationResult result_;
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.RunAggregationQueryResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32498a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32498a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32498a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32498a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32498a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32498a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32498a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32498a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RunAggregationQueryResponse, Builder> implements RunAggregationQueryResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearReadTime() {
            f();
            ((RunAggregationQueryResponse) this.f33398b).o0();
            return this;
        }

        public Builder clearResult() {
            f();
            ((RunAggregationQueryResponse) this.f33398b).p0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((RunAggregationQueryResponse) this.f33398b).q0();
            return this;
        }

        @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
        public Timestamp getReadTime() {
            return ((RunAggregationQueryResponse) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
        public AggregationResult getResult() {
            return ((RunAggregationQueryResponse) this.f33398b).getResult();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
        public ByteString getTransaction() {
            return ((RunAggregationQueryResponse) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
        public boolean hasReadTime() {
            return ((RunAggregationQueryResponse) this.f33398b).hasReadTime();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
        public boolean hasResult() {
            return ((RunAggregationQueryResponse) this.f33398b).hasResult();
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).r0(timestamp);
            return this;
        }

        public Builder mergeResult(AggregationResult aggregationResult) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).s0(aggregationResult);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).t0(timestamp);
            return this;
        }

        public Builder setResult(AggregationResult aggregationResult) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).u0(aggregationResult);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).v0(byteString);
            return this;
        }

        private Builder() {
            super(RunAggregationQueryResponse.DEFAULT_INSTANCE);
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).t0(builder.build());
            return this;
        }

        public Builder setResult(AggregationResult.Builder builder) {
            f();
            ((RunAggregationQueryResponse) this.f33398b).u0(builder.build());
            return this;
        }
    }

    static {
        RunAggregationQueryResponse runAggregationQueryResponse = new RunAggregationQueryResponse();
        DEFAULT_INSTANCE = runAggregationQueryResponse;
        GeneratedMessageLite.d0(RunAggregationQueryResponse.class, runAggregationQueryResponse);
    }

    private RunAggregationQueryResponse() {
    }

    public static RunAggregationQueryResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.result_ = null;
    }

    public static RunAggregationQueryResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static RunAggregationQueryResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RunAggregationQueryResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(AggregationResult aggregationResult) {
        aggregationResult.getClass();
        AggregationResult aggregationResult2 = this.result_;
        if (aggregationResult2 != null && aggregationResult2 != AggregationResult.getDefaultInstance()) {
            this.result_ = AggregationResult.newBuilder(this.result_).mergeFrom((AggregationResult.Builder) aggregationResult).buildPartial();
        } else {
            this.result_ = aggregationResult;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(AggregationResult aggregationResult) {
        aggregationResult.getClass();
        this.result_ = aggregationResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(ByteString byteString) {
        byteString.getClass();
        this.transaction_ = byteString;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
    public AggregationResult getResult() {
        AggregationResult aggregationResult = this.result_;
        if (aggregationResult == null) {
            return AggregationResult.getDefaultInstance();
        }
        return aggregationResult;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryResponseOrBuilder
    public boolean hasResult() {
        if (this.result_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32498a[methodToInvoke.ordinal()]) {
            case 1:
                return new RunAggregationQueryResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\n\u0003\t", new Object[]{"result_", "transaction_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RunAggregationQueryResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (RunAggregationQueryResponse.class) {
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

    public static Builder newBuilder(RunAggregationQueryResponse runAggregationQueryResponse) {
        return DEFAULT_INSTANCE.r(runAggregationQueryResponse);
    }

    public static RunAggregationQueryResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunAggregationQueryResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RunAggregationQueryResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static RunAggregationQueryResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RunAggregationQueryResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static RunAggregationQueryResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RunAggregationQueryResponse parseFrom(InputStream inputStream) throws IOException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static RunAggregationQueryResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunAggregationQueryResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RunAggregationQueryResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunAggregationQueryResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
