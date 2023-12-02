package com.google.firestore.v1;

import com.google.firestore.v1.BitSequence;
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
public final class BloomFilter extends GeneratedMessageLite<BloomFilter, Builder> implements BloomFilterOrBuilder {
    public static final int BITS_FIELD_NUMBER = 1;
    private static final BloomFilter DEFAULT_INSTANCE;
    public static final int HASH_COUNT_FIELD_NUMBER = 2;
    private static volatile Parser<BloomFilter> PARSER;
    private BitSequence bits_;
    private int hashCount_;

    /* renamed from: com.google.firestore.v1.BloomFilter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32443a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32443a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32443a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32443a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32443a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32443a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32443a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32443a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BloomFilter, Builder> implements BloomFilterOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBits() {
            f();
            ((BloomFilter) this.f33398b).l0();
            return this;
        }

        public Builder clearHashCount() {
            f();
            ((BloomFilter) this.f33398b).m0();
            return this;
        }

        @Override // com.google.firestore.v1.BloomFilterOrBuilder
        public BitSequence getBits() {
            return ((BloomFilter) this.f33398b).getBits();
        }

        @Override // com.google.firestore.v1.BloomFilterOrBuilder
        public int getHashCount() {
            return ((BloomFilter) this.f33398b).getHashCount();
        }

        @Override // com.google.firestore.v1.BloomFilterOrBuilder
        public boolean hasBits() {
            return ((BloomFilter) this.f33398b).hasBits();
        }

        public Builder mergeBits(BitSequence bitSequence) {
            f();
            ((BloomFilter) this.f33398b).n0(bitSequence);
            return this;
        }

        public Builder setBits(BitSequence bitSequence) {
            f();
            ((BloomFilter) this.f33398b).o0(bitSequence);
            return this;
        }

        public Builder setHashCount(int i4) {
            f();
            ((BloomFilter) this.f33398b).p0(i4);
            return this;
        }

        private Builder() {
            super(BloomFilter.DEFAULT_INSTANCE);
        }

        public Builder setBits(BitSequence.Builder builder) {
            f();
            ((BloomFilter) this.f33398b).o0(builder.build());
            return this;
        }
    }

    static {
        BloomFilter bloomFilter = new BloomFilter();
        DEFAULT_INSTANCE = bloomFilter;
        GeneratedMessageLite.d0(BloomFilter.class, bloomFilter);
    }

    private BloomFilter() {
    }

    public static BloomFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l0() {
        this.bits_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m0() {
        this.hashCount_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(BitSequence bitSequence) {
        bitSequence.getClass();
        BitSequence bitSequence2 = this.bits_;
        if (bitSequence2 != null && bitSequence2 != BitSequence.getDefaultInstance()) {
            this.bits_ = BitSequence.newBuilder(this.bits_).mergeFrom((BitSequence.Builder) bitSequence).buildPartial();
        } else {
            this.bits_ = bitSequence;
        }
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0(BitSequence bitSequence) {
        bitSequence.getClass();
        this.bits_ = bitSequence;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(int i4) {
        this.hashCount_ = i4;
    }

    public static BloomFilter parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BloomFilter) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BloomFilter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BloomFilter) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BloomFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.BloomFilterOrBuilder
    public BitSequence getBits() {
        BitSequence bitSequence = this.bits_;
        if (bitSequence == null) {
            return BitSequence.getDefaultInstance();
        }
        return bitSequence;
    }

    @Override // com.google.firestore.v1.BloomFilterOrBuilder
    public int getHashCount() {
        return this.hashCount_;
    }

    @Override // com.google.firestore.v1.BloomFilterOrBuilder
    public boolean hasBits() {
        if (this.bits_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32443a[methodToInvoke.ordinal()]) {
            case 1:
                return new BloomFilter();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u0004", new Object[]{"bits_", "hashCount_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BloomFilter> parser = PARSER;
                if (parser == null) {
                    synchronized (BloomFilter.class) {
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

    public static Builder newBuilder(BloomFilter bloomFilter) {
        return DEFAULT_INSTANCE.r(bloomFilter);
    }

    public static BloomFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BloomFilter) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BloomFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BloomFilter) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BloomFilter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BloomFilter) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BloomFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BloomFilter) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BloomFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BloomFilter) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BloomFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BloomFilter) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BloomFilter parseFrom(InputStream inputStream) throws IOException {
        return (BloomFilter) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BloomFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BloomFilter) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BloomFilter parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BloomFilter) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BloomFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BloomFilter) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
