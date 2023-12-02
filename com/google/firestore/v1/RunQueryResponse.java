package com.google.firestore.v1;

import com.google.firestore.v1.Document;
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
public final class RunQueryResponse extends GeneratedMessageLite<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
    private static final RunQueryResponse DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<RunQueryResponse> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 3;
    public static final int SKIPPED_RESULTS_FIELD_NUMBER = 4;
    public static final int TRANSACTION_FIELD_NUMBER = 2;
    private Document document_;
    private Timestamp readTime_;
    private int skippedResults_;
    private ByteString transaction_ = ByteString.EMPTY;

    /* renamed from: com.google.firestore.v1.RunQueryResponse$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32502a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32502a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32502a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32502a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32502a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32502a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32502a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32502a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<RunQueryResponse, Builder> implements RunQueryResponseOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocument() {
            f();
            ((RunQueryResponse) this.f33398b).q0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((RunQueryResponse) this.f33398b).r0();
            return this;
        }

        public Builder clearSkippedResults() {
            f();
            ((RunQueryResponse) this.f33398b).s0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((RunQueryResponse) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public Document getDocument() {
            return ((RunQueryResponse) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public Timestamp getReadTime() {
            return ((RunQueryResponse) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public int getSkippedResults() {
            return ((RunQueryResponse) this.f33398b).getSkippedResults();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public ByteString getTransaction() {
            return ((RunQueryResponse) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public boolean hasDocument() {
            return ((RunQueryResponse) this.f33398b).hasDocument();
        }

        @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
        public boolean hasReadTime() {
            return ((RunQueryResponse) this.f33398b).hasReadTime();
        }

        public Builder mergeDocument(Document document) {
            f();
            ((RunQueryResponse) this.f33398b).u0(document);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((RunQueryResponse) this.f33398b).v0(timestamp);
            return this;
        }

        public Builder setDocument(Document document) {
            f();
            ((RunQueryResponse) this.f33398b).w0(document);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((RunQueryResponse) this.f33398b).x0(timestamp);
            return this;
        }

        public Builder setSkippedResults(int i4) {
            f();
            ((RunQueryResponse) this.f33398b).y0(i4);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((RunQueryResponse) this.f33398b).z0(byteString);
            return this;
        }

        private Builder() {
            super(RunQueryResponse.DEFAULT_INSTANCE);
        }

        public Builder setDocument(Document.Builder builder) {
            f();
            ((RunQueryResponse) this.f33398b).w0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((RunQueryResponse) this.f33398b).x0(builder.build());
            return this;
        }
    }

    static {
        RunQueryResponse runQueryResponse = new RunQueryResponse();
        DEFAULT_INSTANCE = runQueryResponse;
        GeneratedMessageLite.d0(RunQueryResponse.class, runQueryResponse);
    }

    private RunQueryResponse() {
    }

    public static RunQueryResponse getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static RunQueryResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryResponse parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<RunQueryResponse> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.skippedResults_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.transaction_ = getDefaultInstance().getTransaction();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(Document document) {
        document.getClass();
        Document document2 = this.document_;
        if (document2 != null && document2 != Document.getDefaultInstance()) {
            this.document_ = Document.newBuilder(this.document_).mergeFrom((Document.Builder) document).buildPartial();
        } else {
            this.document_ = document;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Document document) {
        document.getClass();
        this.document_ = document;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i4) {
        this.skippedResults_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(ByteString byteString) {
        byteString.getClass();
        this.transaction_ = byteString;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        if (document == null) {
            return Document.getDefaultInstance();
        }
        return document;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public int getSkippedResults() {
        return this.skippedResults_;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public ByteString getTransaction() {
        return this.transaction_;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public boolean hasDocument() {
        if (this.document_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.RunQueryResponseOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32502a[methodToInvoke.ordinal()]) {
            case 1:
                return new RunQueryResponse();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\n\u0003\t\u0004\u0004", new Object[]{"document_", "transaction_", "readTime_", "skippedResults_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<RunQueryResponse> parser = PARSER;
                if (parser == null) {
                    synchronized (RunQueryResponse.class) {
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

    public static Builder newBuilder(RunQueryResponse runQueryResponse) {
        return DEFAULT_INSTANCE.r(runQueryResponse);
    }

    public static RunQueryResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static RunQueryResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static RunQueryResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (RunQueryResponse) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(InputStream inputStream) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static RunQueryResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static RunQueryResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static RunQueryResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (RunQueryResponse) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
