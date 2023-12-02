package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class CreateDocumentRequest extends GeneratedMessageLite<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
    public static final int COLLECTION_ID_FIELD_NUMBER = 2;
    private static final CreateDocumentRequest DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 4;
    public static final int DOCUMENT_ID_FIELD_NUMBER = 3;
    public static final int MASK_FIELD_NUMBER = 5;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<CreateDocumentRequest> PARSER;
    private Document document_;
    private DocumentMask mask_;
    private String parent_ = "";
    private String collectionId_ = "";
    private String documentId_ = "";

    /* renamed from: com.google.firestore.v1.CreateDocumentRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32446a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32446a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32446a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32446a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32446a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32446a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32446a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32446a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<CreateDocumentRequest, Builder> implements CreateDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCollectionId() {
            f();
            ((CreateDocumentRequest) this.f33398b).v0();
            return this;
        }

        public Builder clearDocument() {
            f();
            ((CreateDocumentRequest) this.f33398b).w0();
            return this;
        }

        public Builder clearDocumentId() {
            f();
            ((CreateDocumentRequest) this.f33398b).x0();
            return this;
        }

        public Builder clearMask() {
            f();
            ((CreateDocumentRequest) this.f33398b).y0();
            return this;
        }

        public Builder clearParent() {
            f();
            ((CreateDocumentRequest) this.f33398b).z0();
            return this;
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public String getCollectionId() {
            return ((CreateDocumentRequest) this.f33398b).getCollectionId();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public ByteString getCollectionIdBytes() {
            return ((CreateDocumentRequest) this.f33398b).getCollectionIdBytes();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public Document getDocument() {
            return ((CreateDocumentRequest) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public String getDocumentId() {
            return ((CreateDocumentRequest) this.f33398b).getDocumentId();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public ByteString getDocumentIdBytes() {
            return ((CreateDocumentRequest) this.f33398b).getDocumentIdBytes();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public DocumentMask getMask() {
            return ((CreateDocumentRequest) this.f33398b).getMask();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public String getParent() {
            return ((CreateDocumentRequest) this.f33398b).getParent();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public ByteString getParentBytes() {
            return ((CreateDocumentRequest) this.f33398b).getParentBytes();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public boolean hasDocument() {
            return ((CreateDocumentRequest) this.f33398b).hasDocument();
        }

        @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
        public boolean hasMask() {
            return ((CreateDocumentRequest) this.f33398b).hasMask();
        }

        public Builder mergeDocument(Document document) {
            f();
            ((CreateDocumentRequest) this.f33398b).A0(document);
            return this;
        }

        public Builder mergeMask(DocumentMask documentMask) {
            f();
            ((CreateDocumentRequest) this.f33398b).B0(documentMask);
            return this;
        }

        public Builder setCollectionId(String str) {
            f();
            ((CreateDocumentRequest) this.f33398b).C0(str);
            return this;
        }

        public Builder setCollectionIdBytes(ByteString byteString) {
            f();
            ((CreateDocumentRequest) this.f33398b).D0(byteString);
            return this;
        }

        public Builder setDocument(Document document) {
            f();
            ((CreateDocumentRequest) this.f33398b).E0(document);
            return this;
        }

        public Builder setDocumentId(String str) {
            f();
            ((CreateDocumentRequest) this.f33398b).F0(str);
            return this;
        }

        public Builder setDocumentIdBytes(ByteString byteString) {
            f();
            ((CreateDocumentRequest) this.f33398b).G0(byteString);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            f();
            ((CreateDocumentRequest) this.f33398b).H0(documentMask);
            return this;
        }

        public Builder setParent(String str) {
            f();
            ((CreateDocumentRequest) this.f33398b).I0(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            f();
            ((CreateDocumentRequest) this.f33398b).J0(byteString);
            return this;
        }

        private Builder() {
            super(CreateDocumentRequest.DEFAULT_INSTANCE);
        }

        public Builder setDocument(Document.Builder builder) {
            f();
            ((CreateDocumentRequest) this.f33398b).E0(builder.build());
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            f();
            ((CreateDocumentRequest) this.f33398b).H0(builder.build());
            return this;
        }
    }

    static {
        CreateDocumentRequest createDocumentRequest = new CreateDocumentRequest();
        DEFAULT_INSTANCE = createDocumentRequest;
        GeneratedMessageLite.d0(CreateDocumentRequest.class, createDocumentRequest);
    }

    private CreateDocumentRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Document document) {
        document.getClass();
        Document document2 = this.document_;
        if (document2 != null && document2 != Document.getDefaultInstance()) {
            this.document_ = Document.newBuilder(this.document_).mergeFrom((Document.Builder) document).buildPartial();
        } else {
            this.document_ = document;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.mask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.mask_ = DocumentMask.newBuilder(this.mask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.mask_ = documentMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(String str) {
        str.getClass();
        this.collectionId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.collectionId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(Document document) {
        document.getClass();
        this.document_ = document;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(String str) {
        str.getClass();
        this.documentId_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.documentId_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(DocumentMask documentMask) {
        documentMask.getClass();
        this.mask_ = documentMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.parent_ = byteString.toStringUtf8();
    }

    public static CreateDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static CreateDocumentRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static CreateDocumentRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<CreateDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.collectionId_ = getDefaultInstance().getCollectionId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.documentId_ = getDefaultInstance().getDocumentId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.parent_ = getDefaultInstance().getParent();
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public String getCollectionId() {
        return this.collectionId_;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public ByteString getCollectionIdBytes() {
        return ByteString.copyFromUtf8(this.collectionId_);
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        if (document == null) {
            return Document.getDefaultInstance();
        }
        return document;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public String getDocumentId() {
        return this.documentId_;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public ByteString getDocumentIdBytes() {
        return ByteString.copyFromUtf8(this.documentId_);
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public boolean hasDocument() {
        if (this.document_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.CreateDocumentRequestOrBuilder
    public boolean hasMask() {
        if (this.mask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32446a[methodToInvoke.ordinal()]) {
            case 1:
                return new CreateDocumentRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ\u0004\t\u0005\t", new Object[]{"parent_", "collectionId_", "documentId_", "document_", "mask_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<CreateDocumentRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (CreateDocumentRequest.class) {
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

    public static Builder newBuilder(CreateDocumentRequest createDocumentRequest) {
        return DEFAULT_INSTANCE.r(createDocumentRequest);
    }

    public static CreateDocumentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static CreateDocumentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static CreateDocumentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (CreateDocumentRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(InputStream inputStream) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static CreateDocumentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static CreateDocumentRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static CreateDocumentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (CreateDocumentRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
