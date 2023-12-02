package com.google.firestore.v1;

import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.TransactionOptions;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class BatchGetDocumentsRequest extends GeneratedMessageLite<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
    public static final int DATABASE_FIELD_NUMBER = 1;
    private static final BatchGetDocumentsRequest DEFAULT_INSTANCE;
    public static final int DOCUMENTS_FIELD_NUMBER = 2;
    public static final int MASK_FIELD_NUMBER = 3;
    public static final int NEW_TRANSACTION_FIELD_NUMBER = 5;
    private static volatile Parser<BatchGetDocumentsRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 7;
    public static final int TRANSACTION_FIELD_NUMBER = 4;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private int consistencySelectorCase_ = 0;
    private String database_ = "";
    private Internal.ProtobufList<String> documents_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.BatchGetDocumentsRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32436a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32436a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32436a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32436a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32436a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32436a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32436a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32436a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BatchGetDocumentsRequest, Builder> implements BatchGetDocumentsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllDocuments(Iterable<String> iterable) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).A0(iterable);
            return this;
        }

        public Builder addDocuments(String str) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).B0(str);
            return this;
        }

        public Builder addDocumentsBytes(ByteString byteString) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).C0(byteString);
            return this;
        }

        public Builder clearConsistencySelector() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).D0();
            return this;
        }

        public Builder clearDatabase() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).E0();
            return this;
        }

        public Builder clearDocuments() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).F0();
            return this;
        }

        public Builder clearMask() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).G0();
            return this;
        }

        public Builder clearNewTransaction() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).H0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).I0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).J0();
            return this;
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((BatchGetDocumentsRequest) this.f33398b).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public String getDatabase() {
            return ((BatchGetDocumentsRequest) this.f33398b).getDatabase();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ByteString getDatabaseBytes() {
            return ((BatchGetDocumentsRequest) this.f33398b).getDatabaseBytes();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public String getDocuments(int i4) {
            return ((BatchGetDocumentsRequest) this.f33398b).getDocuments(i4);
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ByteString getDocumentsBytes(int i4) {
            return ((BatchGetDocumentsRequest) this.f33398b).getDocumentsBytes(i4);
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public int getDocumentsCount() {
            return ((BatchGetDocumentsRequest) this.f33398b).getDocumentsCount();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public List<String> getDocumentsList() {
            return Collections.unmodifiableList(((BatchGetDocumentsRequest) this.f33398b).getDocumentsList());
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public DocumentMask getMask() {
            return ((BatchGetDocumentsRequest) this.f33398b).getMask();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public TransactionOptions getNewTransaction() {
            return ((BatchGetDocumentsRequest) this.f33398b).getNewTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public Timestamp getReadTime() {
            return ((BatchGetDocumentsRequest) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public ByteString getTransaction() {
            return ((BatchGetDocumentsRequest) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public boolean hasMask() {
            return ((BatchGetDocumentsRequest) this.f33398b).hasMask();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public boolean hasNewTransaction() {
            return ((BatchGetDocumentsRequest) this.f33398b).hasNewTransaction();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public boolean hasReadTime() {
            return ((BatchGetDocumentsRequest) this.f33398b).hasReadTime();
        }

        @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
        public boolean hasTransaction() {
            return ((BatchGetDocumentsRequest) this.f33398b).hasTransaction();
        }

        public Builder mergeMask(DocumentMask documentMask) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).L0(documentMask);
            return this;
        }

        public Builder mergeNewTransaction(TransactionOptions transactionOptions) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).M0(transactionOptions);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).N0(timestamp);
            return this;
        }

        public Builder setDatabase(String str) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).O0(str);
            return this;
        }

        public Builder setDatabaseBytes(ByteString byteString) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).P0(byteString);
            return this;
        }

        public Builder setDocuments(int i4, String str) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).Q0(i4, str);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).R0(documentMask);
            return this;
        }

        public Builder setNewTransaction(TransactionOptions transactionOptions) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).S0(transactionOptions);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).T0(timestamp);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).U0(byteString);
            return this;
        }

        private Builder() {
            super(BatchGetDocumentsRequest.DEFAULT_INSTANCE);
        }

        public Builder setMask(DocumentMask.Builder builder) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).R0(builder.build());
            return this;
        }

        public Builder setNewTransaction(TransactionOptions.Builder builder) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).S0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((BatchGetDocumentsRequest) this.f33398b).T0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ConsistencySelectorCase {
        TRANSACTION(4),
        NEW_TRANSACTION(5),
        READ_TIME(7),
        CONSISTENCYSELECTOR_NOT_SET(0);
        
        private final int value;

        ConsistencySelectorCase(int i4) {
            this.value = i4;
        }

        public static ConsistencySelectorCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 7) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return null;
                        }
                        return NEW_TRANSACTION;
                    }
                    return TRANSACTION;
                }
                return READ_TIME;
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

    static {
        BatchGetDocumentsRequest batchGetDocumentsRequest = new BatchGetDocumentsRequest();
        DEFAULT_INSTANCE = batchGetDocumentsRequest;
        GeneratedMessageLite.d0(BatchGetDocumentsRequest.class, batchGetDocumentsRequest);
    }

    private BatchGetDocumentsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Iterable<String> iterable) {
        K0();
        AbstractMessageLite.a(iterable, this.documents_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(String str) {
        str.getClass();
        K0();
        this.documents_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        K0();
        this.documents_.add(byteString.toStringUtf8());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0() {
        this.database_ = getDefaultInstance().getDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.documents_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        if (this.consistencySelectorCase_ == 7) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        if (this.consistencySelectorCase_ == 4) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    private void K0() {
        Internal.ProtobufList<String> protobufList = this.documents_;
        if (!protobufList.isModifiable()) {
            this.documents_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.mask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.mask_ = DocumentMask.newBuilder(this.mask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.mask_ = documentMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(TransactionOptions transactionOptions) {
        transactionOptions.getClass();
        if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != TransactionOptions.getDefaultInstance()) {
            this.consistencySelector_ = TransactionOptions.newBuilder((TransactionOptions) this.consistencySelector_).mergeFrom((TransactionOptions.Builder) transactionOptions).buildPartial();
        } else {
            this.consistencySelector_ = transactionOptions;
        }
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.consistencySelectorCase_ == 7 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.consistencySelector_ = timestamp;
        }
        this.consistencySelectorCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(String str) {
        str.getClass();
        this.database_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.database_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(int i4, String str) {
        str.getClass();
        K0();
        this.documents_.set(i4, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(DocumentMask documentMask) {
        documentMask.getClass();
        this.mask_ = documentMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(TransactionOptions transactionOptions) {
        transactionOptions.getClass();
        this.consistencySelector_ = transactionOptions;
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(Timestamp timestamp) {
        timestamp.getClass();
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 7;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(ByteString byteString) {
        byteString.getClass();
        this.consistencySelectorCase_ = 4;
        this.consistencySelector_ = byteString;
    }

    public static BatchGetDocumentsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BatchGetDocumentsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public String getDatabase() {
        return this.database_;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ByteString getDatabaseBytes() {
        return ByteString.copyFromUtf8(this.database_);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public String getDocuments(int i4) {
        return this.documents_.get(i4);
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ByteString getDocumentsBytes(int i4) {
        return ByteString.copyFromUtf8(this.documents_.get(i4));
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public int getDocumentsCount() {
        return this.documents_.size();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public List<String> getDocumentsList() {
        return this.documents_;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public TransactionOptions getNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return (TransactionOptions) this.consistencySelector_;
        }
        return TransactionOptions.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 4) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public boolean hasMask() {
        if (this.mask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public boolean hasNewTransaction() {
        if (this.consistencySelectorCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public boolean hasReadTime() {
        if (this.consistencySelectorCase_ == 7) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.BatchGetDocumentsRequestOrBuilder
    public boolean hasTransaction() {
        if (this.consistencySelectorCase_ == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32436a[methodToInvoke.ordinal()]) {
            case 1:
                return new BatchGetDocumentsRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0006\u0001\u0000\u0001\u0007\u0006\u0000\u0001\u0000\u0001Ȉ\u0002Ț\u0003\t\u0004=\u0000\u0005<\u0000\u0007<\u0000", new Object[]{"consistencySelector_", "consistencySelectorCase_", "database_", "documents_", "mask_", TransactionOptions.class, Timestamp.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BatchGetDocumentsRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (BatchGetDocumentsRequest.class) {
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

    public static Builder newBuilder(BatchGetDocumentsRequest batchGetDocumentsRequest) {
        return DEFAULT_INSTANCE.r(batchGetDocumentsRequest);
    }

    public static BatchGetDocumentsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BatchGetDocumentsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BatchGetDocumentsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(InputStream inputStream) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BatchGetDocumentsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BatchGetDocumentsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BatchGetDocumentsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BatchGetDocumentsRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
