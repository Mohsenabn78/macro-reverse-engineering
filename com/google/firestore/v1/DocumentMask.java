package com.google.firestore.v1;

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
public final class DocumentMask extends GeneratedMessageLite<DocumentMask, Builder> implements DocumentMaskOrBuilder {
    private static final DocumentMask DEFAULT_INSTANCE;
    public static final int FIELD_PATHS_FIELD_NUMBER = 1;
    private static volatile Parser<DocumentMask> PARSER;
    private Internal.ProtobufList<String> fieldPaths_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.DocumentMask$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32453a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32453a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32453a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32453a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32453a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32453a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32453a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32453a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<DocumentMask, Builder> implements DocumentMaskOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFieldPaths(Iterable<String> iterable) {
            f();
            ((DocumentMask) this.f33398b).l0(iterable);
            return this;
        }

        public Builder addFieldPaths(String str) {
            f();
            ((DocumentMask) this.f33398b).m0(str);
            return this;
        }

        public Builder addFieldPathsBytes(ByteString byteString) {
            f();
            ((DocumentMask) this.f33398b).n0(byteString);
            return this;
        }

        public Builder clearFieldPaths() {
            f();
            ((DocumentMask) this.f33398b).o0();
            return this;
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public String getFieldPaths(int i4) {
            return ((DocumentMask) this.f33398b).getFieldPaths(i4);
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public ByteString getFieldPathsBytes(int i4) {
            return ((DocumentMask) this.f33398b).getFieldPathsBytes(i4);
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public int getFieldPathsCount() {
            return ((DocumentMask) this.f33398b).getFieldPathsCount();
        }

        @Override // com.google.firestore.v1.DocumentMaskOrBuilder
        public List<String> getFieldPathsList() {
            return Collections.unmodifiableList(((DocumentMask) this.f33398b).getFieldPathsList());
        }

        public Builder setFieldPaths(int i4, String str) {
            f();
            ((DocumentMask) this.f33398b).q0(i4, str);
            return this;
        }

        private Builder() {
            super(DocumentMask.DEFAULT_INSTANCE);
        }
    }

    static {
        DocumentMask documentMask = new DocumentMask();
        DEFAULT_INSTANCE = documentMask;
        GeneratedMessageLite.d0(DocumentMask.class, documentMask);
    }

    private DocumentMask() {
    }

    public static DocumentMask getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0(Iterable<String> iterable) {
        p0();
        AbstractMessageLite.a(iterable, this.fieldPaths_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(String str) {
        str.getClass();
        p0();
        this.fieldPaths_.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        p0();
        this.fieldPaths_.add(byteString.toStringUtf8());
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.fieldPaths_ = GeneratedMessageLite.y();
    }

    private void p0() {
        Internal.ProtobufList<String> protobufList = this.fieldPaths_;
        if (!protobufList.isModifiable()) {
            this.fieldPaths_ = GeneratedMessageLite.K(protobufList);
        }
    }

    public static DocumentMask parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (DocumentMask) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentMask parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<DocumentMask> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i4, String str) {
        str.getClass();
        p0();
        this.fieldPaths_.set(i4, str);
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public String getFieldPaths(int i4) {
        return this.fieldPaths_.get(i4);
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public ByteString getFieldPathsBytes(int i4) {
        return ByteString.copyFromUtf8(this.fieldPaths_.get(i4));
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public int getFieldPathsCount() {
        return this.fieldPaths_.size();
    }

    @Override // com.google.firestore.v1.DocumentMaskOrBuilder
    public List<String> getFieldPathsList() {
        return this.fieldPaths_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32453a[methodToInvoke.ordinal()]) {
            case 1:
                return new DocumentMask();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"fieldPaths_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<DocumentMask> parser = PARSER;
                if (parser == null) {
                    synchronized (DocumentMask.class) {
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

    public static Builder newBuilder(DocumentMask documentMask) {
        return DEFAULT_INSTANCE.r(documentMask);
    }

    public static DocumentMask parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentMask) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static DocumentMask parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static DocumentMask parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (DocumentMask) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(InputStream inputStream) throws IOException {
        return (DocumentMask) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static DocumentMask parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentMask) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static DocumentMask parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (DocumentMask) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static DocumentMask parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (DocumentMask) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
