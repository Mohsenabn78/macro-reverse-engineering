package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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
public final class BatchGetDocumentsResponse extends GeneratedMessageLite<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
    private static final BatchGetDocumentsResponse DEFAULT_INSTANCE;
    public static final int FOUND_FIELD_NUMBER = 1;
    public static final int MISSING_FIELD_NUMBER = 2;
    private static volatile Parser<BatchGetDocumentsResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private Timestamp readTime_;
    private Object result_;
    private int resultCase_ = 0;
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32438a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32438a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32438a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32438a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32438a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32438a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32438a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32438a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsResponse, Builder> implements BatchGetDocumentsResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearFound() {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).s0();
            return this;
        }

        public Builder clearMissing() {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).t0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).u0();
            return this;
        }

        public Builder clearResult() {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).v0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).w0();
            return this;
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public Document getFound() {
            return ((BatchGetDocumentsResponse) this.f33398b).getFound();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public String getMissing() {
            return ((BatchGetDocumentsResponse) this.f33398b).getMissing();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public ByteString getMissingBytes() {
            return ((BatchGetDocumentsResponse) this.f33398b).getMissingBytes();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public Timestamp getReadTime() {
            return ((BatchGetDocumentsResponse) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public ResultCase getResultCase() {
            return ((BatchGetDocumentsResponse) this.f33398b).getResultCase();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public ByteString getTransaction() {
            return ((BatchGetDocumentsResponse) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public boolean hasFound() {
            return ((BatchGetDocumentsResponse) this.f33398b).hasFound();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public boolean hasMissing() {
            return ((BatchGetDocumentsResponse) this.f33398b).hasMissing();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
        public boolean hasReadTime() {
            return ((BatchGetDocumentsResponse) this.f33398b).hasReadTime();
        }

        public Builder mergeFound(Document document) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).x0(document);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).y0(timestamp);
            return this;
        }

        public Builder setFound(Document document) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).z0(document);
            return this;
        }

        public Builder setMissing(String str) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).A0(str);
            return this;
        }

        public Builder setMissingBytes(ByteString byteString) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).B0(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).C0(timestamp);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).D0(byteString);
            return this;
        }

        private Builder() {
            super(BatchGetDocumentsResponse.DEFAULT_INSTANCE);
        }

        public Builder setFound(Document.Builder builder) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).z0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((BatchGetDocumentsResponse) this.f33398b).C0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ResultCase {
        FOUND(1),
        MISSING(2),
        RESULT_NOT_SET(0);
        
        private final int value;

        ResultCase(int i4) {
            this.value = i4;
        }

        public static ResultCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return MISSING;
                }
                return FOUND;
            }
            return RESULT_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ResultCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        BatchGetDocumentsResponse batchGetDocumentsResponse = new BatchGetDocumentsResponse();
        DEFAULT_INSTANCE = batchGetDocumentsResponse;
        GeneratedMessageLite.d0(BatchGetDocumentsResponse.class, batchGetDocumentsResponse);
    }

    private BatchGetDocumentsResponse() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String str) {
        str.getClass();
        this.resultCase_ = 2;
        this.result_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.result_ = byteString.toStringUtf8();
        this.resultCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ByteString byteString) {
        byteString.getClass();
        this.transaction_ = byteString;
    }

    public static BatchGetDocumentsResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BatchGetDocumentsResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        if (this.resultCase_ == 1) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (this.resultCase_ == 2) {
            this.resultCase_ = 0;
            this.result_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.resultCase_ = 0;
        this.result_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Document document) {
        document.getClass();
        if (this.resultCase_ == 1 && this.result_ != Document.getDefaultInstance()) {
            this.result_ = Document.newBuilder((Document) this.result_).mergeFrom((Document.Builder) document).buildPartial();
        } else {
            this.result_ = document;
        }
        this.resultCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(Document document) {
        document.getClass();
        this.result_ = document;
        this.resultCase_ = 1;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public Document getFound() {
        if (this.resultCase_ == 1) {
            return (Document) this.result_;
        }
        return Document.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public String getMissing() {
        if (this.resultCase_ == 2) {
            return (String) this.result_;
        }
        return "";
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public ByteString getMissingBytes() {
        String str;
        if (this.resultCase_ == 2) {
            str = (String) this.result_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public ResultCase getResultCase() {
        return ResultCase.forNumber(this.resultCase_);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public boolean hasFound() {
        if (this.resultCase_ == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public boolean hasMissing() {
        if (this.resultCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsResponseOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32438a[methodToInvoke.ordinal()]) {
            case 1:
                return new BatchGetDocumentsResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002Ȼ\u0000\u0003\n\u0004\t", new Object[]{"result_", "resultCase_", Document.class, "transaction_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BatchGetDocumentsResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (BatchGetDocumentsResponse.class) {
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

    public static Builder newBuilder(BatchGetDocumentsResponse batchGetDocumentsResponse) {
        return DEFAULT_INSTANCE.r(batchGetDocumentsResponse);
    }

    public static BatchGetDocumentsResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BatchGetDocumentsResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BatchGetDocumentsResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream inputStream) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BatchGetDocumentsResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
