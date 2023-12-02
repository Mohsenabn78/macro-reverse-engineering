package com.google.firestore.v1;

import com.google.firestore.v1.Document;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class DocumentChange extends GeneratedMessageLite<DocumentChange, Builder> implements DocumentChangeOrBuilder {
    private static final DocumentChange DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentChange> PARSER = null;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    public static final int TARGET_IDS_FIELD_NUMBER = 5;
    private Document document_;
    private int targetIdsMemoizedSerializedSize = -1;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private Internal.IntList targetIds_ = GeneratedMessageLite.w();
    private Internal.IntList removedTargetIds_ = GeneratedMessageLite.w();

    /* renamed from: com.google.firestore.v1.DocumentChange$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32451a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32451a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32451a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32451a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32451a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32451a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32451a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32451a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentChange, Builder> implements DocumentChangeOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
            f();
            ((DocumentChange) this.f33398b).r0(iterable);
            return this;
        }

        public Builder addAllTargetIds(Iterable<? extends Integer> iterable) {
            f();
            ((DocumentChange) this.f33398b).s0(iterable);
            return this;
        }

        public Builder addRemovedTargetIds(int i4) {
            f();
            ((DocumentChange) this.f33398b).t0(i4);
            return this;
        }

        public Builder addTargetIds(int i4) {
            f();
            ((DocumentChange) this.f33398b).u0(i4);
            return this;
        }

        public Builder clearDocument() {
            f();
            ((DocumentChange) this.f33398b).v0();
            return this;
        }

        public Builder clearRemovedTargetIds() {
            f();
            ((DocumentChange) this.f33398b).w0();
            return this;
        }

        public Builder clearTargetIds() {
            f();
            ((DocumentChange) this.f33398b).x0();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public Document getDocument() {
            return ((DocumentChange) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getRemovedTargetIds(int i4) {
            return ((DocumentChange) this.f33398b).getRemovedTargetIds(i4);
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getRemovedTargetIdsCount() {
            return ((DocumentChange) this.f33398b).getRemovedTargetIdsCount();
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.f33398b).getRemovedTargetIdsList());
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getTargetIds(int i4) {
            return ((DocumentChange) this.f33398b).getTargetIds(i4);
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public int getTargetIdsCount() {
            return ((DocumentChange) this.f33398b).getTargetIdsCount();
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public List<Integer> getTargetIdsList() {
            return Collections.unmodifiableList(((DocumentChange) this.f33398b).getTargetIdsList());
        }

        @Override // com.google.firestore.v1.DocumentChangeOrBuilder
        public boolean hasDocument() {
            return ((DocumentChange) this.f33398b).hasDocument();
        }

        public Builder mergeDocument(Document document) {
            f();
            ((DocumentChange) this.f33398b).A0(document);
            return this;
        }

        public Builder setDocument(Document document) {
            f();
            ((DocumentChange) this.f33398b).B0(document);
            return this;
        }

        public Builder setRemovedTargetIds(int i4, int i5) {
            f();
            ((DocumentChange) this.f33398b).C0(i4, i5);
            return this;
        }

        public Builder setTargetIds(int i4, int i5) {
            f();
            ((DocumentChange) this.f33398b).D0(i4, i5);
            return this;
        }

        private Builder() {
            super(DocumentChange.DEFAULT_INSTANCE);
        }

        public Builder setDocument(Document.Builder builder) {
            f();
            ((DocumentChange) this.f33398b).B0(builder.build());
            return this;
        }
    }

    static {
        DocumentChange documentChange = new DocumentChange();
        DEFAULT_INSTANCE = documentChange;
        GeneratedMessageLite.d0(DocumentChange.class, documentChange);
    }

    private DocumentChange() {
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
    public void B0(Document document) {
        document.getClass();
        this.document_ = document;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C0(int i4, int i5) {
        y0();
        this.removedTargetIds_.setInt(i4, i5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4, int i5) {
        z0();
        this.targetIds_.setInt(i4, i5);
    }

    public static DocumentChange getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static DocumentChange parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DocumentChange) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentChange parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DocumentChange> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Iterable<? extends Integer> iterable) {
        y0();
        AbstractMessageLite.a(iterable, this.removedTargetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Iterable<? extends Integer> iterable) {
        z0();
        AbstractMessageLite.a(iterable, this.targetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(int i4) {
        y0();
        this.removedTargetIds_.addInt(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(int i4) {
        z0();
        this.targetIds_.addInt(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        this.document_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0() {
        this.removedTargetIds_ = GeneratedMessageLite.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0() {
        this.targetIds_ = GeneratedMessageLite.w();
    }

    private void y0() {
        Internal.IntList intList = this.removedTargetIds_;
        if (!intList.isModifiable()) {
            this.removedTargetIds_ = GeneratedMessageLite.I(intList);
        }
    }

    private void z0() {
        Internal.IntList intList = this.targetIds_;
        if (!intList.isModifiable()) {
            this.targetIds_ = GeneratedMessageLite.I(intList);
        }
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public Document getDocument() {
        Document document = this.document_;
        if (document == null) {
            return Document.getDefaultInstance();
        }
        return document;
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getRemovedTargetIds(int i4) {
        return this.removedTargetIds_.getInt(i4);
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getRemovedTargetIdsCount() {
        return this.removedTargetIds_.size();
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public List<Integer> getRemovedTargetIdsList() {
        return this.removedTargetIds_;
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getTargetIds(int i4) {
        return this.targetIds_.getInt(i4);
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public int getTargetIdsCount() {
        return this.targetIds_.size();
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public List<Integer> getTargetIdsList() {
        return this.targetIds_;
    }

    @Override // com.google.firestore.v1.DocumentChangeOrBuilder
    public boolean hasDocument() {
        if (this.document_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32451a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentChange();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0006\u0003\u0000\u0002\u0000\u0001\t\u0005'\u0006'", new Object[]{"document_", "targetIds_", "removedTargetIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DocumentChange> parser = PARSER;
                if (parser == null) {
                    synchronized (DocumentChange.class) {
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

    public static Builder newBuilder(DocumentChange documentChange) {
        return DEFAULT_INSTANCE.r(documentChange);
    }

    public static DocumentChange parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentChange) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentChange parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentChange parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentChange) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(InputStream inputStream) throws IOException {
        return (DocumentChange) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentChange parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentChange) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentChange parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DocumentChange) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentChange parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentChange) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
