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
public final class GetDocumentRequest extends GeneratedMessageLite<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
    private static final GetDocumentRequest DEFAULT_INSTANCE;
    public static final int MASK_FIELD_NUMBER = 2;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<GetDocumentRequest> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 5;
    public static final int TRANSACTION_FIELD_NUMBER = 3;
    private Object consistencySelector_;
    private DocumentMask mask_;
    private int consistencySelectorCase_ = 0;
    private String name_ = "";

    /* renamed from: com.google.firestore.v1.GetDocumentRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32478a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32478a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32478a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32478a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32478a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32478a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32478a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32478a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<GetDocumentRequest, Builder> implements GetDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearConsistencySelector() {
            f();
            ((GetDocumentRequest) this.f33398b).s0();
            return this;
        }

        public Builder clearMask() {
            f();
            ((GetDocumentRequest) this.f33398b).t0();
            return this;
        }

        public Builder clearName() {
            f();
            ((GetDocumentRequest) this.f33398b).u0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((GetDocumentRequest) this.f33398b).v0();
            return this;
        }

        public Builder clearTransaction() {
            f();
            ((GetDocumentRequest) this.f33398b).w0();
            return this;
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public ConsistencySelectorCase getConsistencySelectorCase() {
            return ((GetDocumentRequest) this.f33398b).getConsistencySelectorCase();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public DocumentMask getMask() {
            return ((GetDocumentRequest) this.f33398b).getMask();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public String getName() {
            return ((GetDocumentRequest) this.f33398b).getName();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public ByteString getNameBytes() {
            return ((GetDocumentRequest) this.f33398b).getNameBytes();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public Timestamp getReadTime() {
            return ((GetDocumentRequest) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public ByteString getTransaction() {
            return ((GetDocumentRequest) this.f33398b).getTransaction();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public boolean hasMask() {
            return ((GetDocumentRequest) this.f33398b).hasMask();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public boolean hasReadTime() {
            return ((GetDocumentRequest) this.f33398b).hasReadTime();
        }

        @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
        public boolean hasTransaction() {
            return ((GetDocumentRequest) this.f33398b).hasTransaction();
        }

        public Builder mergeMask(DocumentMask documentMask) {
            f();
            ((GetDocumentRequest) this.f33398b).x0(documentMask);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((GetDocumentRequest) this.f33398b).y0(timestamp);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            f();
            ((GetDocumentRequest) this.f33398b).z0(documentMask);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((GetDocumentRequest) this.f33398b).A0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((GetDocumentRequest) this.f33398b).B0(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((GetDocumentRequest) this.f33398b).C0(timestamp);
            return this;
        }

        public Builder setTransaction(ByteString byteString) {
            f();
            ((GetDocumentRequest) this.f33398b).D0(byteString);
            return this;
        }

        private Builder() {
            super(GetDocumentRequest.DEFAULT_INSTANCE);
        }

        public Builder setMask(DocumentMask.Builder builder) {
            f();
            ((GetDocumentRequest) this.f33398b).z0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((GetDocumentRequest) this.f33398b).C0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ConsistencySelectorCase {
        TRANSACTION(3),
        READ_TIME(5),
        CONSISTENCYSELECTOR_NOT_SET(0);
        
        private final int value;

        ConsistencySelectorCase(int i4) {
            this.value = i4;
        }

        public static ConsistencySelectorCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 3) {
                    if (i4 != 5) {
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
        GetDocumentRequest getDocumentRequest = new GetDocumentRequest();
        DEFAULT_INSTANCE = getDocumentRequest;
        GeneratedMessageLite.d0(GetDocumentRequest.class, getDocumentRequest);
    }

    private GetDocumentRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Timestamp timestamp) {
        timestamp.getClass();
        this.consistencySelector_ = timestamp;
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ByteString byteString) {
        byteString.getClass();
        this.consistencySelectorCase_ = 3;
        this.consistencySelector_ = byteString;
    }

    public static GetDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static GetDocumentRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static GetDocumentRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<GetDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.consistencySelectorCase_ = 0;
        this.consistencySelector_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        if (this.consistencySelectorCase_ == 5) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        if (this.consistencySelectorCase_ == 3) {
            this.consistencySelectorCase_ = 0;
            this.consistencySelector_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.mask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.mask_ = DocumentMask.newBuilder(this.mask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.mask_ = documentMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.consistencySelectorCase_ == 5 && this.consistencySelector_ != Timestamp.getDefaultInstance()) {
            this.consistencySelector_ = Timestamp.newBuilder((Timestamp) this.consistencySelector_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.consistencySelector_ = timestamp;
        }
        this.consistencySelectorCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(DocumentMask documentMask) {
        documentMask.getClass();
        this.mask_ = documentMask;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public ConsistencySelectorCase getConsistencySelectorCase() {
        return ConsistencySelectorCase.forNumber(this.consistencySelectorCase_);
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public Timestamp getReadTime() {
        if (this.consistencySelectorCase_ == 5) {
            return (Timestamp) this.consistencySelector_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public ByteString getTransaction() {
        if (this.consistencySelectorCase_ == 3) {
            return (ByteString) this.consistencySelector_;
        }
        return ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public boolean hasMask() {
        if (this.mask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public boolean hasReadTime() {
        if (this.consistencySelectorCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.GetDocumentRequestOrBuilder
    public boolean hasTransaction() {
        if (this.consistencySelectorCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32478a[methodToInvoke.ordinal()]) {
            case 1:
                return new GetDocumentRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0005\u0004\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003=\u0000\u0005<\u0000", new Object[]{"consistencySelector_", "consistencySelectorCase_", "name_", "mask_", Timestamp.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<GetDocumentRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (GetDocumentRequest.class) {
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

    public static Builder newBuilder(GetDocumentRequest getDocumentRequest) {
        return DEFAULT_INSTANCE.r(getDocumentRequest);
    }

    public static GetDocumentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static GetDocumentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static GetDocumentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (GetDocumentRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(InputStream inputStream) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static GetDocumentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static GetDocumentRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static GetDocumentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (GetDocumentRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
