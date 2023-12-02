package com.google.firestore.v1;

import com.google.firestore.v1.BloomFilter;
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
public final class ExistenceFilter extends GeneratedMessageLite<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
    public static final int COUNT_FIELD_NUMBER = 2;
    private static final ExistenceFilter DEFAULT_INSTANCE;
    private static volatile Parser<ExistenceFilter> PARSER = null;
    public static final int TARGET_ID_FIELD_NUMBER = 1;
    public static final int UNCHANGED_NAMES_FIELD_NUMBER = 3;
    private int count_;
    private int targetId_;
    private BloomFilter unchangedNames_;

    /* renamed from: com.google.firestore.v1.ExistenceFilter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32460a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32460a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32460a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32460a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32460a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32460a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32460a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32460a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<ExistenceFilter, Builder> implements ExistenceFilterOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearCount() {
            f();
            ((ExistenceFilter) this.f33398b).n0();
            return this;
        }

        public Builder clearTargetId() {
            f();
            ((ExistenceFilter) this.f33398b).o0();
            return this;
        }

        public Builder clearUnchangedNames() {
            f();
            ((ExistenceFilter) this.f33398b).p0();
            return this;
        }

        @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
        public int getCount() {
            return ((ExistenceFilter) this.f33398b).getCount();
        }

        @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
        public int getTargetId() {
            return ((ExistenceFilter) this.f33398b).getTargetId();
        }

        @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
        public BloomFilter getUnchangedNames() {
            return ((ExistenceFilter) this.f33398b).getUnchangedNames();
        }

        @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
        public boolean hasUnchangedNames() {
            return ((ExistenceFilter) this.f33398b).hasUnchangedNames();
        }

        public Builder mergeUnchangedNames(BloomFilter bloomFilter) {
            f();
            ((ExistenceFilter) this.f33398b).q0(bloomFilter);
            return this;
        }

        public Builder setCount(int i4) {
            f();
            ((ExistenceFilter) this.f33398b).r0(i4);
            return this;
        }

        public Builder setTargetId(int i4) {
            f();
            ((ExistenceFilter) this.f33398b).s0(i4);
            return this;
        }

        public Builder setUnchangedNames(BloomFilter bloomFilter) {
            f();
            ((ExistenceFilter) this.f33398b).t0(bloomFilter);
            return this;
        }

        private Builder() {
            super(ExistenceFilter.DEFAULT_INSTANCE);
        }

        public Builder setUnchangedNames(BloomFilter.Builder builder) {
            f();
            ((ExistenceFilter) this.f33398b).t0(builder.build());
            return this;
        }
    }

    static {
        ExistenceFilter existenceFilter = new ExistenceFilter();
        DEFAULT_INSTANCE = existenceFilter;
        GeneratedMessageLite.d0(ExistenceFilter.class, existenceFilter);
    }

    private ExistenceFilter() {
    }

    public static ExistenceFilter getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0() {
        this.count_ = 0;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o0() {
        this.targetId_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.unchangedNames_ = null;
    }

    public static ExistenceFilter parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static ExistenceFilter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ExistenceFilter> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(BloomFilter bloomFilter) {
        bloomFilter.getClass();
        BloomFilter bloomFilter2 = this.unchangedNames_;
        if (bloomFilter2 != null && bloomFilter2 != BloomFilter.getDefaultInstance()) {
            this.unchangedNames_ = BloomFilter.newBuilder(this.unchangedNames_).mergeFrom((BloomFilter.Builder) bloomFilter).buildPartial();
        } else {
            this.unchangedNames_ = bloomFilter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(int i4) {
        this.count_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(int i4) {
        this.targetId_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(BloomFilter bloomFilter) {
        bloomFilter.getClass();
        this.unchangedNames_ = bloomFilter;
    }

    @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
    public int getCount() {
        return this.count_;
    }

    @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
    public int getTargetId() {
        return this.targetId_;
    }

    @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
    public BloomFilter getUnchangedNames() {
        BloomFilter bloomFilter = this.unchangedNames_;
        if (bloomFilter == null) {
            return BloomFilter.getDefaultInstance();
        }
        return bloomFilter;
    }

    @Override // com.google.firestore.v1.ExistenceFilterOrBuilder
    public boolean hasUnchangedNames() {
        if (this.unchangedNames_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32460a[methodToInvoke.ordinal()]) {
            case 1:
                return new ExistenceFilter();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u0004\u0002\u0004\u0003\t", new Object[]{"targetId_", "count_", "unchangedNames_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ExistenceFilter> parser = PARSER;
                if (parser == null) {
                    synchronized (ExistenceFilter.class) {
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

    public static Builder newBuilder(ExistenceFilter existenceFilter) {
        return DEFAULT_INSTANCE.r(existenceFilter);
    }

    public static ExistenceFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static ExistenceFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static ExistenceFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ExistenceFilter) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(InputStream inputStream) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static ExistenceFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ExistenceFilter parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ExistenceFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ExistenceFilter) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
