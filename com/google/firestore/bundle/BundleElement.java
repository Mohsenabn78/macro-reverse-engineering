package com.google.firestore.bundle;

import com.google.firestore.bundle.BundleMetadata;
import com.google.firestore.bundle.BundledDocumentMetadata;
import com.google.firestore.bundle.NamedQuery;
import com.google.firestore.v1.Document;
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
public final class BundleElement extends GeneratedMessageLite<BundleElement, Builder> implements BundleElementOrBuilder {
    private static final BundleElement DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 4;
    public static final int DOCUMENT_METADATA_FIELD_NUMBER = 3;
    public static final int METADATA_FIELD_NUMBER = 1;
    public static final int NAMED_QUERY_FIELD_NUMBER = 2;
    private static volatile Parser<BundleElement> PARSER;
    private int elementTypeCase_ = 0;
    private Object elementType_;

    /* renamed from: com.google.firestore.bundle.BundleElement$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32423a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32423a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32423a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32423a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32423a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32423a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32423a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32423a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BundleElement, Builder> implements BundleElementOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearDocument() {
            f();
            ((BundleElement) this.f33398b).t0();
            return this;
        }

        public Builder clearDocumentMetadata() {
            f();
            ((BundleElement) this.f33398b).u0();
            return this;
        }

        public Builder clearElementType() {
            f();
            ((BundleElement) this.f33398b).v0();
            return this;
        }

        public Builder clearMetadata() {
            f();
            ((BundleElement) this.f33398b).w0();
            return this;
        }

        public Builder clearNamedQuery() {
            f();
            ((BundleElement) this.f33398b).x0();
            return this;
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public Document getDocument() {
            return ((BundleElement) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public BundledDocumentMetadata getDocumentMetadata() {
            return ((BundleElement) this.f33398b).getDocumentMetadata();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public ElementTypeCase getElementTypeCase() {
            return ((BundleElement) this.f33398b).getElementTypeCase();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public BundleMetadata getMetadata() {
            return ((BundleElement) this.f33398b).getMetadata();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public NamedQuery getNamedQuery() {
            return ((BundleElement) this.f33398b).getNamedQuery();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public boolean hasDocument() {
            return ((BundleElement) this.f33398b).hasDocument();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public boolean hasDocumentMetadata() {
            return ((BundleElement) this.f33398b).hasDocumentMetadata();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public boolean hasMetadata() {
            return ((BundleElement) this.f33398b).hasMetadata();
        }

        @Override // com.google.firestore.bundle.BundleElementOrBuilder
        public boolean hasNamedQuery() {
            return ((BundleElement) this.f33398b).hasNamedQuery();
        }

        public Builder mergeDocument(Document document) {
            f();
            ((BundleElement) this.f33398b).y0(document);
            return this;
        }

        public Builder mergeDocumentMetadata(BundledDocumentMetadata bundledDocumentMetadata) {
            f();
            ((BundleElement) this.f33398b).z0(bundledDocumentMetadata);
            return this;
        }

        public Builder mergeMetadata(BundleMetadata bundleMetadata) {
            f();
            ((BundleElement) this.f33398b).A0(bundleMetadata);
            return this;
        }

        public Builder mergeNamedQuery(NamedQuery namedQuery) {
            f();
            ((BundleElement) this.f33398b).B0(namedQuery);
            return this;
        }

        public Builder setDocument(Document document) {
            f();
            ((BundleElement) this.f33398b).C0(document);
            return this;
        }

        public Builder setDocumentMetadata(BundledDocumentMetadata bundledDocumentMetadata) {
            f();
            ((BundleElement) this.f33398b).D0(bundledDocumentMetadata);
            return this;
        }

        public Builder setMetadata(BundleMetadata bundleMetadata) {
            f();
            ((BundleElement) this.f33398b).E0(bundleMetadata);
            return this;
        }

        public Builder setNamedQuery(NamedQuery namedQuery) {
            f();
            ((BundleElement) this.f33398b).F0(namedQuery);
            return this;
        }

        private Builder() {
            super(BundleElement.DEFAULT_INSTANCE);
        }

        public Builder setDocument(Document.Builder builder) {
            f();
            ((BundleElement) this.f33398b).C0(builder.build());
            return this;
        }

        public Builder setDocumentMetadata(BundledDocumentMetadata.Builder builder) {
            f();
            ((BundleElement) this.f33398b).D0(builder.build());
            return this;
        }

        public Builder setMetadata(BundleMetadata.Builder builder) {
            f();
            ((BundleElement) this.f33398b).E0(builder.build());
            return this;
        }

        public Builder setNamedQuery(NamedQuery.Builder builder) {
            f();
            ((BundleElement) this.f33398b).F0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ElementTypeCase {
        METADATA(1),
        NAMED_QUERY(2),
        DOCUMENT_METADATA(3),
        DOCUMENT(4),
        ELEMENTTYPE_NOT_SET(0);
        
        private final int value;

        ElementTypeCase(int i4) {
            this.value = i4;
        }

        public static ElementTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                return null;
                            }
                            return DOCUMENT;
                        }
                        return DOCUMENT_METADATA;
                    }
                    return NAMED_QUERY;
                }
                return METADATA;
            }
            return ELEMENTTYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ElementTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        BundleElement bundleElement = new BundleElement();
        DEFAULT_INSTANCE = bundleElement;
        GeneratedMessageLite.d0(BundleElement.class, bundleElement);
    }

    private BundleElement() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(BundleMetadata bundleMetadata) {
        bundleMetadata.getClass();
        if (this.elementTypeCase_ == 1 && this.elementType_ != BundleMetadata.getDefaultInstance()) {
            this.elementType_ = BundleMetadata.newBuilder((BundleMetadata) this.elementType_).mergeFrom((BundleMetadata.Builder) bundleMetadata).buildPartial();
        } else {
            this.elementType_ = bundleMetadata;
        }
        this.elementTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0(NamedQuery namedQuery) {
        namedQuery.getClass();
        if (this.elementTypeCase_ == 2 && this.elementType_ != NamedQuery.getDefaultInstance()) {
            this.elementType_ = NamedQuery.newBuilder((NamedQuery) this.elementType_).mergeFrom((NamedQuery.Builder) namedQuery).buildPartial();
        } else {
            this.elementType_ = namedQuery;
        }
        this.elementTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(Document document) {
        document.getClass();
        this.elementType_ = document;
        this.elementTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(BundledDocumentMetadata bundledDocumentMetadata) {
        bundledDocumentMetadata.getClass();
        this.elementType_ = bundledDocumentMetadata;
        this.elementTypeCase_ = 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(BundleMetadata bundleMetadata) {
        bundleMetadata.getClass();
        this.elementType_ = bundleMetadata;
        this.elementTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(NamedQuery namedQuery) {
        namedQuery.getClass();
        this.elementType_ = namedQuery;
        this.elementTypeCase_ = 2;
    }

    public static BundleElement getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BundleElement parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BundleElement) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BundleElement parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BundleElement) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BundleElement> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (this.elementTypeCase_ == 4) {
            this.elementTypeCase_ = 0;
            this.elementType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        if (this.elementTypeCase_ == 3) {
            this.elementTypeCase_ = 0;
            this.elementType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.elementTypeCase_ = 0;
        this.elementType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        if (this.elementTypeCase_ == 1) {
            this.elementTypeCase_ = 0;
            this.elementType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        if (this.elementTypeCase_ == 2) {
            this.elementTypeCase_ = 0;
            this.elementType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(Document document) {
        document.getClass();
        if (this.elementTypeCase_ == 4 && this.elementType_ != Document.getDefaultInstance()) {
            this.elementType_ = Document.newBuilder((Document) this.elementType_).mergeFrom((Document.Builder) document).buildPartial();
        } else {
            this.elementType_ = document;
        }
        this.elementTypeCase_ = 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(BundledDocumentMetadata bundledDocumentMetadata) {
        bundledDocumentMetadata.getClass();
        if (this.elementTypeCase_ == 3 && this.elementType_ != BundledDocumentMetadata.getDefaultInstance()) {
            this.elementType_ = BundledDocumentMetadata.newBuilder((BundledDocumentMetadata) this.elementType_).mergeFrom((BundledDocumentMetadata.Builder) bundledDocumentMetadata).buildPartial();
        } else {
            this.elementType_ = bundledDocumentMetadata;
        }
        this.elementTypeCase_ = 3;
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public Document getDocument() {
        if (this.elementTypeCase_ == 4) {
            return (Document) this.elementType_;
        }
        return Document.getDefaultInstance();
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public BundledDocumentMetadata getDocumentMetadata() {
        if (this.elementTypeCase_ == 3) {
            return (BundledDocumentMetadata) this.elementType_;
        }
        return BundledDocumentMetadata.getDefaultInstance();
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public ElementTypeCase getElementTypeCase() {
        return ElementTypeCase.forNumber(this.elementTypeCase_);
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public BundleMetadata getMetadata() {
        if (this.elementTypeCase_ == 1) {
            return (BundleMetadata) this.elementType_;
        }
        return BundleMetadata.getDefaultInstance();
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public NamedQuery getNamedQuery() {
        if (this.elementTypeCase_ == 2) {
            return (NamedQuery) this.elementType_;
        }
        return NamedQuery.getDefaultInstance();
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public boolean hasDocument() {
        if (this.elementTypeCase_ == 4) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public boolean hasDocumentMetadata() {
        if (this.elementTypeCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public boolean hasMetadata() {
        if (this.elementTypeCase_ == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.bundle.BundleElementOrBuilder
    public boolean hasNamedQuery() {
        if (this.elementTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32423a[methodToInvoke.ordinal()]) {
            case 1:
                return new BundleElement();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000", new Object[]{"elementType_", "elementTypeCase_", BundleMetadata.class, NamedQuery.class, BundledDocumentMetadata.class, Document.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BundleElement> parser = PARSER;
                if (parser == null) {
                    synchronized (BundleElement.class) {
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

    public static Builder newBuilder(BundleElement bundleElement) {
        return DEFAULT_INSTANCE.r(bundleElement);
    }

    public static BundleElement parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundleElement) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundleElement parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundleElement) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BundleElement parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BundleElement) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BundleElement parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundleElement) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BundleElement parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BundleElement) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BundleElement parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundleElement) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BundleElement parseFrom(InputStream inputStream) throws IOException {
        return (BundleElement) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BundleElement parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundleElement) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundleElement parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BundleElement) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BundleElement parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundleElement) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
