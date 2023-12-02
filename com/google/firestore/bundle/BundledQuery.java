package com.google.firestore.bundle;

import com.google.firestore.v1.StructuredQuery;
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

/* loaded from: classes5.dex */
public final class BundledQuery extends GeneratedMessageLite<BundledQuery, Builder> implements BundledQueryOrBuilder {
    private static final BundledQuery DEFAULT_INSTANCE;
    public static final int LIMIT_TYPE_FIELD_NUMBER = 3;
    public static final int PARENT_FIELD_NUMBER = 1;
    private static volatile Parser<BundledQuery> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 2;
    private int limitType_;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private String parent_ = "";

    /* renamed from: com.google.firestore.bundle.BundledQuery$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32427a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32427a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32427a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32427a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32427a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32427a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32427a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32427a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<BundledQuery, Builder> implements BundledQueryOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearLimitType() {
            f();
            ((BundledQuery) this.f33398b).q0();
            return this;
        }

        public Builder clearParent() {
            f();
            ((BundledQuery) this.f33398b).r0();
            return this;
        }

        public Builder clearQueryType() {
            f();
            ((BundledQuery) this.f33398b).s0();
            return this;
        }

        public Builder clearStructuredQuery() {
            f();
            ((BundledQuery) this.f33398b).t0();
            return this;
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public LimitType getLimitType() {
            return ((BundledQuery) this.f33398b).getLimitType();
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public int getLimitTypeValue() {
            return ((BundledQuery) this.f33398b).getLimitTypeValue();
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public String getParent() {
            return ((BundledQuery) this.f33398b).getParent();
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public ByteString getParentBytes() {
            return ((BundledQuery) this.f33398b).getParentBytes();
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public QueryTypeCase getQueryTypeCase() {
            return ((BundledQuery) this.f33398b).getQueryTypeCase();
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public StructuredQuery getStructuredQuery() {
            return ((BundledQuery) this.f33398b).getStructuredQuery();
        }

        @Override // com.google.firestore.bundle.BundledQueryOrBuilder
        public boolean hasStructuredQuery() {
            return ((BundledQuery) this.f33398b).hasStructuredQuery();
        }

        public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
            f();
            ((BundledQuery) this.f33398b).u0(structuredQuery);
            return this;
        }

        public Builder setLimitType(LimitType limitType) {
            f();
            ((BundledQuery) this.f33398b).v0(limitType);
            return this;
        }

        public Builder setLimitTypeValue(int i4) {
            f();
            ((BundledQuery) this.f33398b).w0(i4);
            return this;
        }

        public Builder setParent(String str) {
            f();
            ((BundledQuery) this.f33398b).x0(str);
            return this;
        }

        public Builder setParentBytes(ByteString byteString) {
            f();
            ((BundledQuery) this.f33398b).y0(byteString);
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery structuredQuery) {
            f();
            ((BundledQuery) this.f33398b).z0(structuredQuery);
            return this;
        }

        private Builder() {
            super(BundledQuery.DEFAULT_INSTANCE);
        }

        public Builder setStructuredQuery(StructuredQuery.Builder builder) {
            f();
            ((BundledQuery) this.f33398b).z0(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum LimitType implements Internal.EnumLite {
        FIRST(0),
        LAST(1),
        UNRECOGNIZED(-1);
        
        public static final int FIRST_VALUE = 0;
        public static final int LAST_VALUE = 1;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<LimitType> f32428a = new Internal.EnumLiteMap<LimitType>() { // from class: com.google.firestore.bundle.BundledQuery.LimitType.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public LimitType findValueByNumber(int i4) {
                return LimitType.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class LimitTypeVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f32430a = new LimitTypeVerifier();

            private LimitTypeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (LimitType.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        LimitType(int i4) {
            this.value = i4;
        }

        public static LimitType forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    return null;
                }
                return LAST;
            }
            return FIRST;
        }

        public static Internal.EnumLiteMap<LimitType> internalGetValueMap() {
            return f32428a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return LimitTypeVerifier.f32430a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static LimitType valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public enum QueryTypeCase {
        STRUCTURED_QUERY(2),
        QUERYTYPE_NOT_SET(0);
        
        private final int value;

        QueryTypeCase(int i4) {
            this.value = i4;
        }

        public static QueryTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 2) {
                    return null;
                }
                return STRUCTURED_QUERY;
            }
            return QUERYTYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static QueryTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        BundledQuery bundledQuery = new BundledQuery();
        DEFAULT_INSTANCE = bundledQuery;
        GeneratedMessageLite.d0(BundledQuery.class, bundledQuery);
    }

    private BundledQuery() {
    }

    public static BundledQuery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static BundledQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (BundledQuery) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static BundledQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (BundledQuery) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<BundledQuery> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0() {
        this.limitType_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0() {
        this.parent_ = getDefaultInstance().getParent();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0() {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        if (this.queryTypeCase_ == 2) {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0(StructuredQuery structuredQuery) {
        structuredQuery.getClass();
        if (this.queryTypeCase_ == 2 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
            this.queryType_ = StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom((StructuredQuery.Builder) structuredQuery).buildPartial();
        } else {
            this.queryType_ = structuredQuery;
        }
        this.queryTypeCase_ = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(LimitType limitType) {
        this.limitType_ = limitType.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4) {
        this.limitType_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str) {
        str.getClass();
        this.parent_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.parent_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(StructuredQuery structuredQuery) {
        structuredQuery.getClass();
        this.queryType_ = structuredQuery;
        this.queryTypeCase_ = 2;
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public LimitType getLimitType() {
        LimitType forNumber = LimitType.forNumber(this.limitType_);
        if (forNumber == null) {
            return LimitType.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public int getLimitTypeValue() {
        return this.limitType_;
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public String getParent() {
        return this.parent_;
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public ByteString getParentBytes() {
        return ByteString.copyFromUtf8(this.parent_);
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public QueryTypeCase getQueryTypeCase() {
        return QueryTypeCase.forNumber(this.queryTypeCase_);
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public StructuredQuery getStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            return (StructuredQuery) this.queryType_;
        }
        return StructuredQuery.getDefaultInstance();
    }

    @Override // com.google.firestore.bundle.BundledQueryOrBuilder
    public boolean hasStructuredQuery() {
        if (this.queryTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32427a[methodToInvoke.ordinal()]) {
            case 1:
                return new BundledQuery();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002<\u0000\u0003\f", new Object[]{"queryType_", "queryTypeCase_", "parent_", StructuredQuery.class, "limitType_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<BundledQuery> parser = PARSER;
                if (parser == null) {
                    synchronized (BundledQuery.class) {
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

    public static Builder newBuilder(BundledQuery bundledQuery) {
        return DEFAULT_INSTANCE.r(bundledQuery);
    }

    public static BundledQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundledQuery) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundledQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundledQuery) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static BundledQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (BundledQuery) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static BundledQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundledQuery) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static BundledQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (BundledQuery) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static BundledQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (BundledQuery) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static BundledQuery parseFrom(InputStream inputStream) throws IOException {
        return (BundledQuery) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static BundledQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundledQuery) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static BundledQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (BundledQuery) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static BundledQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (BundledQuery) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
