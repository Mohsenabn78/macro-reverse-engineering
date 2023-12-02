package com.google.firestore.v1;

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
public final class DocumentDelete extends GeneratedMessageLite<DocumentDelete, Builder> implements DocumentDeleteOrBuilder {
    private static final DocumentDelete DEFAULT_INSTANCE;
    public static final int DOCUMENT_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentDelete> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 4;
    public static final int REMOVED_TARGET_IDS_FIELD_NUMBER = 6;
    private Timestamp readTime_;
    private int removedTargetIdsMemoizedSerializedSize = -1;
    private String document_ = "";
    private Internal.IntList removedTargetIds_ = GeneratedMessageLite.w();

    /* renamed from: com.google.firestore.v1.DocumentDelete$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32452a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32452a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32452a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32452a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32452a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32452a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32452a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32452a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentDelete, Builder> implements DocumentDeleteOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllRemovedTargetIds(Iterable<? extends Integer> iterable) {
            f();
            ((DocumentDelete) this.f33398b).q0(iterable);
            return this;
        }

        public Builder addRemovedTargetIds(int i4) {
            f();
            ((DocumentDelete) this.f33398b).r0(i4);
            return this;
        }

        public Builder clearDocument() {
            f();
            ((DocumentDelete) this.f33398b).s0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((DocumentDelete) this.f33398b).t0();
            return this;
        }

        public Builder clearRemovedTargetIds() {
            f();
            ((DocumentDelete) this.f33398b).u0();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public String getDocument() {
            return ((DocumentDelete) this.f33398b).getDocument();
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public ByteString getDocumentBytes() {
            return ((DocumentDelete) this.f33398b).getDocumentBytes();
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public Timestamp getReadTime() {
            return ((DocumentDelete) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public int getRemovedTargetIds(int i4) {
            return ((DocumentDelete) this.f33398b).getRemovedTargetIds(i4);
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public int getRemovedTargetIdsCount() {
            return ((DocumentDelete) this.f33398b).getRemovedTargetIdsCount();
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public List<Integer> getRemovedTargetIdsList() {
            return Collections.unmodifiableList(((DocumentDelete) this.f33398b).getRemovedTargetIdsList());
        }

        @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
        public boolean hasReadTime() {
            return ((DocumentDelete) this.f33398b).hasReadTime();
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((DocumentDelete) this.f33398b).w0(timestamp);
            return this;
        }

        public Builder setDocument(String str) {
            f();
            ((DocumentDelete) this.f33398b).x0(str);
            return this;
        }

        public Builder setDocumentBytes(ByteString byteString) {
            f();
            ((DocumentDelete) this.f33398b).y0(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((DocumentDelete) this.f33398b).z0(timestamp);
            return this;
        }

        public Builder setRemovedTargetIds(int i4, int i5) {
            f();
            ((DocumentDelete) this.f33398b).A0(i4, i5);
            return this;
        }

        private Builder() {
            super(DocumentDelete.DEFAULT_INSTANCE);
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((DocumentDelete) this.f33398b).z0(builder.build());
            return this;
        }
    }

    static {
        DocumentDelete documentDelete = new DocumentDelete();
        DEFAULT_INSTANCE = documentDelete;
        GeneratedMessageLite.d0(DocumentDelete.class, documentDelete);
    }

    private DocumentDelete() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(int i4, int i5) {
        v0();
        this.removedTargetIds_.setInt(i4, i5);
    }

    public static DocumentDelete getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static DocumentDelete parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DocumentDelete) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentDelete parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DocumentDelete) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DocumentDelete> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(Iterable<? extends Integer> iterable) {
        v0();
        AbstractMessageLite.a(iterable, this.removedTargetIds_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(int i4) {
        v0();
        this.removedTargetIds_.addInt(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.document_ = getDefaultInstance().getDocument();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.removedTargetIds_ = GeneratedMessageLite.w();
    }

    private void v0() {
        Internal.IntList intList = this.removedTargetIds_;
        if (!intList.isModifiable()) {
            this.removedTargetIds_ = GeneratedMessageLite.I(intList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str) {
        str.getClass();
        this.document_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.document_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public String getDocument() {
        return this.document_;
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public ByteString getDocumentBytes() {
        return ByteString.copyFromUtf8(this.document_);
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public int getRemovedTargetIds(int i4) {
        return this.removedTargetIds_.getInt(i4);
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public int getRemovedTargetIdsCount() {
        return this.removedTargetIds_.size();
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public List<Integer> getRemovedTargetIdsList() {
        return this.removedTargetIds_;
    }

    @Override // com.google.firestore.v1.DocumentDeleteOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32452a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentDelete();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0006\u0003\u0000\u0001\u0000\u0001Ȉ\u0004\t\u0006'", new Object[]{"document_", "readTime_", "removedTargetIds_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DocumentDelete> parser = PARSER;
                if (parser == null) {
                    synchronized (DocumentDelete.class) {
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

    public static Builder newBuilder(DocumentDelete documentDelete) {
        return DEFAULT_INSTANCE.r(documentDelete);
    }

    public static DocumentDelete parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentDelete) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentDelete parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentDelete) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DocumentDelete parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DocumentDelete) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentDelete parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentDelete) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentDelete parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DocumentDelete) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentDelete parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentDelete) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DocumentDelete parseFrom(InputStream inputStream) throws IOException {
        return (DocumentDelete) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentDelete parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentDelete) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentDelete parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DocumentDelete) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentDelete parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentDelete) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
