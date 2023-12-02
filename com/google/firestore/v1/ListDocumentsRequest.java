package com.google.firestore.v1;

import com.google.firestore.v1.DocumentMask;
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
public final class ListDocumentsRequest extends GeneratedMessageLite<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    private static final ListDocumentsRequest DEFAULT_INSTANCE;
    public static final int MASK_FIELD_NUMBER = 7;
    public static final int ORDER_BY_FIELD_NUMBER = 6;
    public static final int PAGE_SIZE_FIELD_NUMBER = 3;
    public static final int PAGE_TOKEN_FIELD_NUMBER = 4;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<ListDocumentsRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 10;
    public static final int SHOW_MISSING_FIELD_NUMBER = 12;
    public static final int TRANSACTION_FIELD_NUMBER = 8;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private int pageSize_;
    private boolean showMissing_;
    private int consistencySelectorCase_ = 0;
    private String parent_ = "";
    private String collectionId_ = "";
    private String pageToken_ = "";
    private String orderBy_ = "";

    /* renamed from: com.google.firestore.v1.ListDocumentsRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32482a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32482a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32482a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32482a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32482a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32482a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32482a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32482a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ListDocumentsRequest, Builder> implements ListDocumentsRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCollectionId() {
            f();
            ((ListDocumentsRequest) this.f33398b).F0();
            return this;
        }

        public Builder clearConsistencySelector() {
            f();
            ((ListDocumentsRequest) this.f33398b).G0();
            return this;
        }

        public Builder clearMask() {
            f();
            ((ListDocumentsRequest) this.f33398b).H0();
            return this;
        }

        public Builder clearOrderBy() {
            f();
            ((ListDocumentsRequest) this.f33398b).I0();
            return this;
        }

        public Builder clearPageSize() {
            f();
            ((ListDocumentsRequest) this.f33398b).J0();
            return this;
        }

        public Builder clearPageToken() {
            f();
            ((ListDocumentsRequest) this.f33398b).K0();
            return this;
        }

        public Builder clearParent() {
            f();
            ((ListDocumentsRequest) this.f33398b).L0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((ListDocumentsRequest) this.f33398b).M0();
            return this;
        }

        public Builder clearShowMissing() {
            f();
            ((ListDocumentsRequest) this.f33398b).N0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((ListDocumentsRequest) this.f33398b).O0();
            return this;
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getCollectionId() {
            return ((ListDocumentsRequest) this.f33398b).getCollectionId();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getCollectionIdBytes() {
            return ((ListDocumentsRequest) this.f33398b).getCollectionIdBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((ListDocumentsRequest) this.f33398b).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public DocumentMask getMask() {
            return ((ListDocumentsRequest) this.f33398b).getMask();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getOrderBy() {
            return ((ListDocumentsRequest) this.f33398b).getOrderBy();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getOrderByBytes() {
            return ((ListDocumentsRequest) this.f33398b).getOrderByBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public int getPageSize() {
            return ((ListDocumentsRequest) this.f33398b).getPageSize();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getPageToken() {
            return ((ListDocumentsRequest) this.f33398b).getPageToken();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getPageTokenBytes() {
            return ((ListDocumentsRequest) this.f33398b).getPageTokenBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public String getParent() {
            return ((ListDocumentsRequest) this.f33398b).getParent();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getParentBytes() {
            return ((ListDocumentsRequest) this.f33398b).getParentBytes();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public Timestamp getReadTime() {
            return ((ListDocumentsRequest) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public boolean getShowMissing() {
            return ((ListDocumentsRequest) this.f33398b).getShowMissing();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public ByteString getTransaction() {
            return ((ListDocumentsRequest) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public boolean hasMask() {
            return ((ListDocumentsRequest) this.f33398b).hasMask();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public boolean hasReadTime() {
            return ((ListDocumentsRequest) this.f33398b).hasReadTime();
        }

        @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
        public boolean hasTransaction() {
            return ((ListDocumentsRequest) this.f33398b).hasTransaction();
        }

        public Builder mergeMask(DocumentMask documentMask) {
            f();
            ((ListDocumentsRequest) this.f33398b).P0(documentMask);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((ListDocumentsRequest) this.f33398b).Q0(timestamp);
            return this;
        }

        public Builder setCollectionId(String str) {
            f();
            ((ListDocumentsRequest) this.f33398b).R0(str);
            return this;
        }

        public Builder setCollectionIdBytes(ByteString byteString) {
            f();
            ((ListDocumentsRequest) this.f33398b).S0(byteString);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            f();
            ((ListDocumentsRequest) this.f33398b).T0(documentMask);
            return this;
        }

        public Builder setOrderBy(String str) {
            f();
            ((ListDocumentsRequest) this.f33398b).U0(str);
            return this;
        }

        public Builder setOrderByBytes(ByteString byteString) {
            f();
            ((ListDocumentsRequest) this.f33398b).V0(byteString);
            return this;
        }

        public Builder setPageSize(int i4) {
            f();
            ((ListDocumentsRequest) this.f33398b).W0(i4);
            return this;
        }

        public Builder setPageToken(String str) {
            f();
            ((ListDocumentsRequest) this.f33398b).X0(str);
            return this;
        }

        public Builder setPageTokenBytes(ByteString byteString) {
            f();
            ((ListDocumentsRequest) this.f33398b).Y0(byteString);
            return this;
        }

        public Builder setParent(String str) {
            f();
            ((ListDocumentsRequest) this.f33398b).Z0(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            f();
            ((ListDocumentsRequest) this.f33398b).a1(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((ListDocumentsRequest) this.f33398b).b1(timestamp);
            return this;
        }

        public Builder setShowMissing(boolean z3) {
            f();
            ((ListDocumentsRequest) this.f33398b).c1(z3);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((ListDocumentsRequest) this.f33398b).d1(byteString);
            return this;
        }

        private Builder() {
            super(ListDocumentsRequest.DEFAULT_INSTANCE);
        }

        public Builder setMask(DocumentMask.Builder builder) {
            f();
            ((ListDocumentsRequest) this.f33398b).T0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((ListDocumentsRequest) this.f33398b).b1(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ConsistencySelectorCase {
        TRANSACTION(8),
        READ_TIME(10),
        CONSISTENCYSELECTOR_NOT_SET(0);
        
        private final int value;

        ConsistencySelectorCase(int i4) {
            this.value = i4;
        }

        public static ConsistencySelectorCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 8) {
                    if (i4 != 10) {
                        return null;
                    }
                    return READ_TIME;
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

    static {
        ListDocumentsRequest listDocumentsRequest = new ListDocumentsRequest();
        DEFAULT_INSTANCE = listDocumentsRequest;
        GeneratedMessageLite.d0(ListDocumentsRequest.class, listDocumentsRequest);
    }

    private ListDocumentsRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        this.collectionId_ = getDefaultInstance().getCollectionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.orderBy_ = getDefaultInstance().getOrderBy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        this.pageSize_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        this.pageToken_ = getDefaultInstance().getPageToken();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        if (this.consistencySelectorCase_ == 10) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        this.showMissing_ = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        if (this.consistencySelectorCase_ == 8) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.mask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.mask_ = DocumentMask.newBuilder(this.mask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.mask_ = documentMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.consistencySelectorCase_ == 10 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.consistencySelector_ = timestamp;
        }
        this.consistencySelectorCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0(String str) {
        str.getClass();
        this.collectionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.collectionId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0(DocumentMask documentMask) {
        documentMask.getClass();
        this.mask_ = documentMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0(String str) {
        str.getClass();
        this.orderBy_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.orderBy_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(int i4) {
        this.pageSize_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(String str) {
        str.getClass();
        this.pageToken_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.pageToken_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.parent_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(Timestamp timestamp) {
        timestamp.getClass();
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(boolean z3) {
        this.showMissing_ = z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(ByteString byteString) {
        byteString.getClass();
        this.consistencySelectorCase_ = 8;
        this.consistencySelector_ = byteString;
    }

    public static ListDocumentsRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static ListDocumentsRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ListDocumentsRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getCollectionId() {
        return this.collectionId_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getCollectionIdBytes() {
        return ByteString.copyFromUtf8(this.collectionId_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getOrderBy() {
        return this.orderBy_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getOrderByBytes() {
        return ByteString.copyFromUtf8(this.orderBy_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public int getPageSize() {
        return this.pageSize_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getPageToken() {
        return this.pageToken_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getPageTokenBytes() {
        return ByteString.copyFromUtf8(this.pageToken_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 10) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public boolean getShowMissing() {
        return this.showMissing_;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 8) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public boolean hasMask() {
        if (this.mask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public boolean hasReadTime() {
        if (this.consistencySelectorCase_ == 10) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ListDocumentsRequestOrBuilder
    public boolean hasTransaction() {
        if (this.consistencySelectorCase_ == 8) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32482a[methodToInvoke.ordinal()]) {
            case 1:
                return new ListDocumentsRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\t\u0001\u0000\u0001\f\t\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003\u0004\u0004Ȉ\u0006Ȉ\u0007\t\b=\u0000\n<\u0000\f\u0007", new Object[]{"consistencySelector_", "consistencySelectorCase_", "parent_", "collectionId_", "pageSize_", "pageToken_", "orderBy_", "mask_", Timestamp.class, "showMissing_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ListDocumentsRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (ListDocumentsRequest.class) {
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

    public static Builder newBuilder(ListDocumentsRequest listDocumentsRequest) {
        return DEFAULT_INSTANCE.r(listDocumentsRequest);
    }

    public static ListDocumentsRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ListDocumentsRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ListDocumentsRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ListDocumentsRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(InputStream inputStream) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ListDocumentsRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ListDocumentsRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ListDocumentsRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ListDocumentsRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
