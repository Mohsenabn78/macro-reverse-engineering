package com.google.firestore.v1;

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
public final class BitSequence extends GeneratedMessageLite<BitSequence, Builder> implements BitSequenceOrBuilder {
    public static final int BITMAP_FIELD_NUMBER = 1;
    private static final BitSequence DEFAULT_INSTANCE;
    public static final int PADDING_FIELD_NUMBER = 2;
    private static volatile Parser<BitSequence> PARSER;
    private ByteString bitmap_ = ByteString.EMPTY;
    private int padding_;

    /* renamed from: com.google.firestore.v1.BitSequence$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32442a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32442a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32442a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32442a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32442a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32442a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32442a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32442a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BitSequence, Builder> implements BitSequenceOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBitmap() {
            f();
            ((BitSequence) this.f33398b).k0();
            return this;
        }

        public Builder clearPadding() {
            f();
            ((BitSequence) this.f33398b).l0();
            return this;
        }

        @Override // com.google.firestore.v1.BitSequenceOrBuilder
        public ByteString getBitmap() {
            return ((BitSequence) this.f33398b).getBitmap();
        }

        @Override // com.google.firestore.v1.BitSequenceOrBuilder
        public int getPadding() {
            return ((BitSequence) this.f33398b).getPadding();
        }

        public Builder setBitmap(ByteString byteString) {
            f();
            ((BitSequence) this.f33398b).m0(byteString);
            return this;
        }

        public Builder setPadding(int i4) {
            f();
            ((BitSequence) this.f33398b).n0(i4);
            return this;
        }

        private Builder() {
            super(BitSequence.DEFAULT_INSTANCE);
        }
    }

    static {
        BitSequence bitSequence = new BitSequence();
        DEFAULT_INSTANCE = bitSequence;
        GeneratedMessageLite.d0(BitSequence.class, bitSequence);
    }

    private BitSequence() {
    }

    public static BitSequence getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k0() {
        this.bitmap_ = getDefaultInstance().getBitmap();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.padding_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0(ByteString byteString) {
        byteString.getClass();
        this.bitmap_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(int i4) {
        this.padding_ = i4;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BitSequence parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BitSequence) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BitSequence parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BitSequence) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BitSequence> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.BitSequenceOrBuilder
    public ByteString getBitmap() {
        return this.bitmap_;
    }

    @Override // com.google.firestore.v1.BitSequenceOrBuilder
    public int getPadding() {
        return this.padding_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32442a[methodToInvoke.ordinal()]) {
            case 1:
                return new BitSequence();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\n\u0002\u0004", new Object[]{"bitmap_", "padding_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BitSequence> parser = PARSER;
                if (parser == null) {
                    synchronized (BitSequence.class) {
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

    public static Builder newBuilder(BitSequence bitSequence) {
        return DEFAULT_INSTANCE.r(bitSequence);
    }

    public static BitSequence parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BitSequence) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BitSequence parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BitSequence) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BitSequence parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BitSequence) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BitSequence parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BitSequence) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BitSequence parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BitSequence) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BitSequence parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BitSequence) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BitSequence parseFrom(InputStream inputStream) throws IOException {
        return (BitSequence) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BitSequence parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BitSequence) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BitSequence parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BitSequence) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BitSequence parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BitSequence) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
