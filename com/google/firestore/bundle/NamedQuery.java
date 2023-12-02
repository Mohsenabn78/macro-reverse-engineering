package com.google.firestore.bundle;

import com.google.firestore.bundle.BundledQuery;
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
public final class NamedQuery extends GeneratedMessageLite<NamedQuery, Builder> implements NamedQueryOrBuilder {
    public static final int BUNDLED_QUERY_FIELD_NUMBER = 2;
    private static final NamedQuery DEFAULT_INSTANCE;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<NamedQuery> PARSER = null;
    public static final int READ_TIME_FIELD_NUMBER = 3;
    private BundledQuery bundledQuery_;
    private String name_ = "";
    private Timestamp readTime_;

    /* renamed from: com.google.firestore.bundle.NamedQuery$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32432a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32432a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32432a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32432a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32432a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32432a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32432a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32432a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<NamedQuery, Builder> implements NamedQueryOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearBundledQuery() {
            f();
            ((NamedQuery) this.f33398b).p0();
            return this;
        }

        public Builder clearName() {
            f();
            ((NamedQuery) this.f33398b).q0();
            return this;
        }

        public Builder clearReadTime() {
            f();
            ((NamedQuery) this.f33398b).r0();
            return this;
        }

        @Override // com.google.firestore.bundle.NamedQueryOrBuilder
        public BundledQuery getBundledQuery() {
            return ((NamedQuery) this.f33398b).getBundledQuery();
        }

        @Override // com.google.firestore.bundle.NamedQueryOrBuilder
        public String getName() {
            return ((NamedQuery) this.f33398b).getName();
        }

        @Override // com.google.firestore.bundle.NamedQueryOrBuilder
        public ByteString getNameBytes() {
            return ((NamedQuery) this.f33398b).getNameBytes();
        }

        @Override // com.google.firestore.bundle.NamedQueryOrBuilder
        public Timestamp getReadTime() {
            return ((NamedQuery) this.f33398b).getReadTime();
        }

        @Override // com.google.firestore.bundle.NamedQueryOrBuilder
        public boolean hasBundledQuery() {
            return ((NamedQuery) this.f33398b).hasBundledQuery();
        }

        @Override // com.google.firestore.bundle.NamedQueryOrBuilder
        public boolean hasReadTime() {
            return ((NamedQuery) this.f33398b).hasReadTime();
        }

        public Builder mergeBundledQuery(BundledQuery bundledQuery) {
            f();
            ((NamedQuery) this.f33398b).s0(bundledQuery);
            return this;
        }

        public Builder mergeReadTime(Timestamp timestamp) {
            f();
            ((NamedQuery) this.f33398b).t0(timestamp);
            return this;
        }

        public Builder setBundledQuery(BundledQuery bundledQuery) {
            f();
            ((NamedQuery) this.f33398b).u0(bundledQuery);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((NamedQuery) this.f33398b).v0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((NamedQuery) this.f33398b).w0(byteString);
            return this;
        }

        public Builder setReadTime(Timestamp timestamp) {
            f();
            ((NamedQuery) this.f33398b).x0(timestamp);
            return this;
        }

        private Builder() {
            super(NamedQuery.DEFAULT_INSTANCE);
        }

        public Builder setBundledQuery(BundledQuery.Builder builder) {
            f();
            ((NamedQuery) this.f33398b).u0(builder.build());
            return this;
        }

        public Builder setReadTime(Timestamp.Builder builder) {
            f();
            ((NamedQuery) this.f33398b).x0(builder.build());
            return this;
        }
    }

    static {
        NamedQuery namedQuery = new NamedQuery();
        DEFAULT_INSTANCE = namedQuery;
        GeneratedMessageLite.d0(NamedQuery.class, namedQuery);
    }

    private NamedQuery() {
    }

    public static NamedQuery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0() {
        this.bundledQuery_ = null;
    }

    public static NamedQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (NamedQuery) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static NamedQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (NamedQuery) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<NamedQuery> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        this.name_ = getDefaultInstance().getName();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.readTime_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(BundledQuery bundledQuery) {
        bundledQuery.getClass();
        BundledQuery bundledQuery2 = this.bundledQuery_;
        if (bundledQuery2 != null && bundledQuery2 != BundledQuery.getDefaultInstance()) {
            this.bundledQuery_ = BundledQuery.newBuilder(this.bundledQuery_).mergeFrom((BundledQuery.Builder) bundledQuery).buildPartial();
        } else {
            this.bundledQuery_ = bundledQuery;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0(Timestamp timestamp) {
        timestamp.getClass();
        Timestamp timestamp2 = this.readTime_;
        if (timestamp2 != null && timestamp2 != Timestamp.getDefaultInstance()) {
            this.readTime_ = Timestamp.newBuilder(this.readTime_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.readTime_ = timestamp;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(BundledQuery bundledQuery) {
        bundledQuery.getClass();
        this.bundledQuery_ = bundledQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(Timestamp timestamp) {
        timestamp.getClass();
        this.readTime_ = timestamp;
    }

    @Override // com.google.firestore.bundle.NamedQueryOrBuilder
    public BundledQuery getBundledQuery() {
        BundledQuery bundledQuery = this.bundledQuery_;
        if (bundledQuery == null) {
            return BundledQuery.getDefaultInstance();
        }
        return bundledQuery;
    }

    @Override // com.google.firestore.bundle.NamedQueryOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.bundle.NamedQueryOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.firestore.bundle.NamedQueryOrBuilder
    public Timestamp getReadTime() {
        Timestamp timestamp = this.readTime_;
        if (timestamp == null) {
            return Timestamp.getDefaultInstance();
        }
        return timestamp;
    }

    @Override // com.google.firestore.bundle.NamedQueryOrBuilder
    public boolean hasBundledQuery() {
        if (this.bundledQuery_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.bundle.NamedQueryOrBuilder
    public boolean hasReadTime() {
        if (this.readTime_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32432a[methodToInvoke.ordinal()]) {
            case 1:
                return new NamedQuery();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\t\u0003\t", new Object[]{"name_", "bundledQuery_", "readTime_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<NamedQuery> parser = PARSER;
                if (parser == null) {
                    synchronized (NamedQuery.class) {
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

    public static Builder newBuilder(NamedQuery namedQuery) {
        return DEFAULT_INSTANCE.r(namedQuery);
    }

    public static NamedQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NamedQuery) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NamedQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NamedQuery) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static NamedQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (NamedQuery) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static NamedQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NamedQuery) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static NamedQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (NamedQuery) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static NamedQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (NamedQuery) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static NamedQuery parseFrom(InputStream inputStream) throws IOException {
        return (NamedQuery) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static NamedQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NamedQuery) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static NamedQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (NamedQuery) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static NamedQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (NamedQuery) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
