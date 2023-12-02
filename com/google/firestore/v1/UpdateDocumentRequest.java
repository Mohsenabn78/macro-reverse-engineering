package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.firestore.v1.DocumentMask;
import com.google.firestore.v1.Precondition;
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
public final class UpdateDocumentRequest extends GeneratedMessageLite<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
    public static final int CURRENT_DOCUMENT_FIELD_NUMBER = 4;
    private static final UpdateDocumentRequest DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    public static final int MASK_FIELD_NUMBER = 3;
    private static volatile Parser<UpdateDocumentRequest> PARSER = null;
    public static final int UPDATE_MASK_FIELD_NUMBER = 2;
    private Precondition currentDocument_;
    private Document document_;
    private DocumentMask mask_;
    private DocumentMask updateMask_;

    /* renamed from: com.google.firestore.v1.UpdateDocumentRequest$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32532a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32532a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32532a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32532a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32532a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32532a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32532a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32532a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<UpdateDocumentRequest, Builder> implements UpdateDocumentRequestOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCurrentDocument() {
            f();
            ((UpdateDocumentRequest) this.f33398b).s0();
            return this;
        }

        public Builder clearDocument() {
            f();
            ((UpdateDocumentRequest) this.f33398b).t0();
            return this;
        }

        public Builder clearMask() {
            f();
            ((UpdateDocumentRequest) this.f33398b).u0();
            return this;
        }

        public Builder clearUpdateMask() {
            f();
            ((UpdateDocumentRequest) this.f33398b).v0();
            return this;
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public Precondition getCurrentDocument() {
            return ((UpdateDocumentRequest) this.f33398b).getCurrentDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public Document getDocument() {
            return ((UpdateDocumentRequest) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public DocumentMask getMask() {
            return ((UpdateDocumentRequest) this.f33398b).getMask();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public DocumentMask getUpdateMask() {
            return ((UpdateDocumentRequest) this.f33398b).getUpdateMask();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasCurrentDocument() {
            return ((UpdateDocumentRequest) this.f33398b).hasCurrentDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasDocument() {
            return ((UpdateDocumentRequest) this.f33398b).hasDocument();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasMask() {
            return ((UpdateDocumentRequest) this.f33398b).hasMask();
        }

        @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
        public boolean hasUpdateMask() {
            return ((UpdateDocumentRequest) this.f33398b).hasUpdateMask();
        }

        public Builder mergeCurrentDocument(Precondition precondition) {
            f();
            ((UpdateDocumentRequest) this.f33398b).w0(precondition);
            return this;
        }

        public Builder mergeDocument(Document document) {
            f();
            ((UpdateDocumentRequest) this.f33398b).x0(document);
            return this;
        }

        public Builder mergeMask(DocumentMask documentMask) {
            f();
            ((UpdateDocumentRequest) this.f33398b).y0(documentMask);
            return this;
        }

        public Builder mergeUpdateMask(DocumentMask documentMask) {
            f();
            ((UpdateDocumentRequest) this.f33398b).z0(documentMask);
            return this;
        }

        public Builder setCurrentDocument(Precondition precondition) {
            f();
            ((UpdateDocumentRequest) this.f33398b).A0(precondition);
            return this;
        }

        public Builder setDocument(Document document) {
            f();
            ((UpdateDocumentRequest) this.f33398b).B0(document);
            return this;
        }

        public Builder setMask(DocumentMask documentMask) {
            f();
            ((UpdateDocumentRequest) this.f33398b).C0(documentMask);
            return this;
        }

        public Builder setUpdateMask(DocumentMask documentMask) {
            f();
            ((UpdateDocumentRequest) this.f33398b).D0(documentMask);
            return this;
        }

        private Builder() {
            super(UpdateDocumentRequest.DEFAULT_INSTANCE);
        }

        public Builder setCurrentDocument(Precondition.Builder builder) {
            f();
            ((UpdateDocumentRequest) this.f33398b).A0(builder.build());
            return this;
        }

        public Builder setDocument(Document.Builder builder) {
            f();
            ((UpdateDocumentRequest) this.f33398b).B0(builder.build());
            return this;
        }

        public Builder setMask(DocumentMask.Builder builder) {
            f();
            ((UpdateDocumentRequest) this.f33398b).C0(builder.build());
            return this;
        }

        public Builder setUpdateMask(DocumentMask.Builder builder) {
            f();
            ((UpdateDocumentRequest) this.f33398b).D0(builder.build());
            return this;
        }
    }

    static {
        UpdateDocumentRequest updateDocumentRequest = new UpdateDocumentRequest();
        DEFAULT_INSTANCE = updateDocumentRequest;
        GeneratedMessageLite.d0(UpdateDocumentRequest.class, updateDocumentRequest);
    }

    private UpdateDocumentRequest() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(Precondition precondition) {
        precondition.getClass();
        this.currentDocument_ = precondition;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(Document document) {
        document.getClass();
        this.document_ = document;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(DocumentMask documentMask) {
        documentMask.getClass();
        this.mask_ = documentMask;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(DocumentMask documentMask) {
        documentMask.getClass();
        this.updateMask_ = documentMask;
    }

    public static UpdateDocumentRequest getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static UpdateDocumentRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateDocumentRequest parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<UpdateDocumentRequest> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.currentDocument_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.mask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.updateMask_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Precondition precondition) {
        precondition.getClass();
        Precondition precondition2 = this.currentDocument_;
        if (precondition2 != null && precondition2 != Precondition.getDefaultInstance()) {
            this.currentDocument_ = Precondition.newBuilder(this.currentDocument_).mergeFrom((Precondition.Builder) precondition).buildPartial();
        } else {
            this.currentDocument_ = precondition;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Document document) {
        document.getClass();
        Document document2 = this.document_;
        if (document2 != null && document2 != Document.getDefaultInstance()) {
            this.document_ = Document.newBuilder(this.document_).mergeFrom((Document.Builder) document).buildPartial();
        } else {
            this.document_ = document;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.mask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.mask_ = DocumentMask.newBuilder(this.mask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.mask_ = documentMask;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(DocumentMask documentMask) {
        documentMask.getClass();
        DocumentMask documentMask2 = this.updateMask_;
        if (documentMask2 != null && documentMask2 != DocumentMask.getDefaultInstance()) {
            this.updateMask_ = DocumentMask.newBuilder(this.updateMask_).mergeFrom((DocumentMask.Builder) documentMask).buildPartial();
        } else {
            this.updateMask_ = documentMask;
        }
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public Precondition getCurrentDocument() {
        Precondition precondition = this.currentDocument_;
        if (precondition == null) {
            return Precondition.getDefaultInstance();
        }
        return precondition;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        if (document == null) {
            return Document.getDefaultInstance();
        }
        return document;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public DocumentMask getMask() {
        DocumentMask documentMask = this.mask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public DocumentMask getUpdateMask() {
        DocumentMask documentMask = this.updateMask_;
        if (documentMask == null) {
            return DocumentMask.getDefaultInstance();
        }
        return documentMask;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasCurrentDocument() {
        if (this.currentDocument_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasDocument() {
        if (this.document_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasMask() {
        if (this.mask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.UpdateDocumentRequestOrBuilder
    public boolean hasUpdateMask() {
        if (this.updateMask_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32532a[methodToInvoke.ordinal()]) {
            case 1:
                return new UpdateDocumentRequest();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004\t", new Object[]{"document_", "updateMask_", "mask_", "currentDocument_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<UpdateDocumentRequest> parser = PARSER;
                if (parser == null) {
                    synchronized (UpdateDocumentRequest.class) {
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

    public static Builder newBuilder(UpdateDocumentRequest updateDocumentRequest) {
        return DEFAULT_INSTANCE.r(updateDocumentRequest);
    }

    public static UpdateDocumentRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static UpdateDocumentRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static UpdateDocumentRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (UpdateDocumentRequest) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(InputStream inputStream) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static UpdateDocumentRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static UpdateDocumentRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static UpdateDocumentRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (UpdateDocumentRequest) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
