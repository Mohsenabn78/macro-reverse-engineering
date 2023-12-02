package com.google.firestore.v1;

import com.google.firestore.v1.StructuredAggregationQuery;
import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.AbstractMessageLite;
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
public final class RunAggregationQueryRequest extends GeneratedMessageLite<RunAggregationQueryRequest, Builder> implements RunAggregationQueryRequestOrBuilder {
    private static final RunAggregationQueryRequest DEFAULT_INSTANCE;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunAggregationQueryRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 6;
    public static final int STRUCTURED_AGGREGATION_QUERY_FIELD_NUMBER = 2;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private Object consistencySelector_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private int consistencySelectorCase_ = 0;
    private String parent_ = "";

    /* renamed from: com.google.firestore.v1.RunAggregationQueryRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32495a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32495a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32495a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32495a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32495a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32495a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32495a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32495a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RunAggregationQueryRequest, Builder> implements RunAggregationQueryRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConsistencySelector() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).w0();
            return this;
        }

        public Builder clearNewTransaction() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).x0();
            return this;
        }

        public Builder clearParent() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).y0();
            return this;
        }

        public Builder clearQueryType() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).z0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).A0();
            return this;
        }

        public Builder clearStructuredAggregationQuery() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).B0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((RunAggregationQueryRequest) this.f33398b).C0();
            return this;
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((RunAggregationQueryRequest) this.f33398b).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public TransactionOptions getNewTransaction() {
            return ((RunAggregationQueryRequest) this.f33398b).getNewTransaction();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public String getParent() {
            return ((RunAggregationQueryRequest) this.f33398b).getParent();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public ByteString getParentBytes() {
            return ((RunAggregationQueryRequest) this.f33398b).getParentBytes();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public QueryTypeCase getQueryTypeCase() {
            return ((RunAggregationQueryRequest) this.f33398b).getQueryTypeCase();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public Timestamp getReadTime() {
            return ((RunAggregationQueryRequest) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public StructuredAggregationQuery getStructuredAggregationQuery() {
            return ((RunAggregationQueryRequest) this.f33398b).getStructuredAggregationQuery();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public ByteString getTransaction() {
            return ((RunAggregationQueryRequest) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public boolean hasNewTransaction() {
            return ((RunAggregationQueryRequest) this.f33398b).hasNewTransaction();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public boolean hasReadTime() {
            return ((RunAggregationQueryRequest) this.f33398b).hasReadTime();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public boolean hasStructuredAggregationQuery() {
            return ((RunAggregationQueryRequest) this.f33398b).hasStructuredAggregationQuery();
        }

        @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
        public boolean hasTransaction() {
            return ((RunAggregationQueryRequest) this.f33398b).hasTransaction();
        }

        public Builder mergeNewTransaction(TransactionOptions transactionOptions) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).D0(transactionOptions);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).E0(timestamp);
            return this;
        }

        public Builder mergeStructuredAggregationQuery(StructuredAggregationQuery structuredAggregationQuery) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).F0(structuredAggregationQuery);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions transactionOptions) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).G0(transactionOptions);
            return this;
        }

        public Builder setParent(String str) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).H0(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).I0(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).J0(timestamp);
            return this;
        }

        public Builder setStructuredAggregationQuery(StructuredAggregationQuery structuredAggregationQuery) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).K0(structuredAggregationQuery);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).L0(byteString);
            return this;
        }

        private Builder() {
            super(RunAggregationQueryRequest.DEFAULT_INSTANCE);
        }

        public Builder setNewTransaction(TransactionOptions.Builder builder) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).G0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).J0(builder.build());
            return this;
        }

        public Builder setStructuredAggregationQuery(StructuredAggregationQuery.Builder builder) {
            f();
            ((RunAggregationQueryRequest) this.f33398b).K0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ConsistencySelectorCase {
        TRANSACTION(4),
        NEW_TRANSACTION(5),
        READ_TIME(6),
        CONSISTENCYSELECTOR_NOT_SET(0);
        
        private final int value;

        ConsistencySelectorCase(int i4) {
            this.value = i4;
        }

        public static ConsistencySelectorCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 4) {
                    if (i4 != 5) {
                        if (i4 != 6) {
                            return null;
                        }
                        return READ_TIME;
                    }
                    return NEW_TRANSACTION;
                }
                return TRANSACTION;
            }
            return CONSISTENCYSELECTOR_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ConsistencySelectorCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public enum QueryTypeCase {
        STRUCTURED_AGGREGATION_QUERY(2),
        QUERYTYPE_NOT_SET(0);
        
        private final int value;

        QueryTypeCase(int i4) {
            this.value = i4;
        }

        public static QueryTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 2) {
                    return null;
                }
                return STRUCTURED_AGGREGATION_QUERY;
            }
            return QUERYTYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static QueryTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        RunAggregationQueryRequest runAggregationQueryRequest = new RunAggregationQueryRequest();
        DEFAULT_INSTANCE = runAggregationQueryRequest;
        GeneratedMessageLite.d0(RunAggregationQueryRequest.class, runAggregationQueryRequest);
    }

    private RunAggregationQueryRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        if (this.consistencySelectorCase_ == 6) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        if (this.queryTypeCase_ == 2) {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0() {
        if (this.consistencySelectorCase_ == 4) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(TransactionOptions transactionOptions) {
        transactionOptions.getClass();
        if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != TransactionOptions.getDefaultInstance()) {
            this.consistencySelector_ = TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom((TransactionOptions.Builder) transactionOptions).buildPartial();
        } else {
            this.consistencySelector_ = transactionOptions;
        }
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.consistencySelectorCase_ == 6 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.consistencySelector_ = timestamp;
        }
        this.consistencySelectorCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(StructuredAggregationQuery structuredAggregationQuery) {
        structuredAggregationQuery.getClass();
        if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredAggregationQuery.getDefaultInstance()) {
            this.queryType_ = StructuredAggregationQuery.newBuilder((StructuredAggregationQuery) this.queryType_).mergeFrom((StructuredAggregationQuery.Builder) structuredAggregationQuery).buildPartial();
        } else {
            this.queryType_ = structuredAggregationQuery;
        }
        this.queryTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(TransactionOptions transactionOptions) {
        transactionOptions.getClass();
        this.consistencySelector_ = transactionOptions;
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.parent_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(Timestamp timestamp) {
        timestamp.getClass();
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(StructuredAggregationQuery structuredAggregationQuery) {
        structuredAggregationQuery.getClass();
        this.queryType_ = structuredAggregationQuery;
        this.queryTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(ByteString byteString) {
        byteString.getClass();
        this.consistencySelectorCase_ = 4;
        this.consistencySelector_ = byteString;
    }

    public static RunAggregationQueryRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static RunAggregationQueryRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static RunAggregationQueryRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RunAggregationQueryRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public TransactionOptions getNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return (TransactionOptions) this.consistencySelector_;
        }
        return TransactionOptions.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public QueryTypeCase getQueryTypeCase() {
        return QueryTypeCase.forNumber(this.queryTypeCase_);
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 6) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public StructuredAggregationQuery getStructuredAggregationQuery() {
        if (this.queryTypeCase_ == 2) {
            return (StructuredAggregationQuery) this.queryType_;
        }
        return StructuredAggregationQuery.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 4) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public boolean hasNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public boolean hasReadTime() {
        if (this.consistencySelectorCase_ == 6) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public boolean hasStructuredAggregationQuery() {
        if (this.queryTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.RunAggregationQueryRequestOrBuilder
    public boolean hasTransaction() {
        if (this.consistencySelectorCase_ == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32495a[methodToInvoke.ordinal()]) {
            case 1:
                return new RunAggregationQueryRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0002\u0000\u0001\u0006\u0005\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0004=\u0001\u0005<\u0001\u0006<\u0001", new Object[]{"queryType_", "queryTypeCase_", "consistencySelector_", "consistencySelectorCase_", "parent_", StructuredAggregationQuery.class, TransactionOptions.class, Timestamp.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RunAggregationQueryRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (RunAggregationQueryRequest.class) {
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

    public static Builder newBuilder(RunAggregationQueryRequest runAggregationQueryRequest) {
        return DEFAULT_INSTANCE.r(runAggregationQueryRequest);
    }

    public static RunAggregationQueryRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunAggregationQueryRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RunAggregationQueryRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static RunAggregationQueryRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RunAggregationQueryRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static RunAggregationQueryRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RunAggregationQueryRequest parseFrom(InputStream inputStream) throws IOException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static RunAggregationQueryRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunAggregationQueryRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RunAggregationQueryRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunAggregationQueryRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
