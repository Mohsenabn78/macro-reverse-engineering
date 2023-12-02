package com.google.firestore.v1;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.Parser;
import com.google.protobuf.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.Map;

/* loaded from: classes5.dex */
public final class AggregationResult extends GeneratedMessageLite<AggregationResult, Builder> implements AggregationResultOrBuilder {
    public static final int AGGREGATE_FIELDS_FIELD_NUMBER = 2;
    private static final AggregationResult DEFAULT_INSTANCE;
    private static volatile Parser<AggregationResult> PARSER;
    private MapFieldLite<String, Value> aggregateFields_ = MapFieldLite.emptyMapField();

    /* renamed from: com.google.firestore.v1.AggregationResult$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32433a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32433a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32433a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32433a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32433a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32433a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32433a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32433a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    private static final class AggregateFieldsDefaultEntryHolder {

        /* renamed from: a  reason: collision with root package name */
        static final MapEntryLite<String, Value> f32434a = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

        private AggregateFieldsDefaultEntryHolder() {
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<AggregationResult, Builder> implements AggregationResultOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearAggregateFields() {
            f();
            ((AggregationResult) this.f33398b).h0().clear();
            return this;
        }

        @Override // com.google.firestore.v1.AggregationResultOrBuilder
        public boolean containsAggregateFields(String str) {
            str.getClass();
            return ((AggregationResult) this.f33398b).getAggregateFieldsMap().containsKey(str);
        }

        @Override // com.google.firestore.v1.AggregationResultOrBuilder
        @Deprecated
        public Map<String, Value> getAggregateFields() {
            return getAggregateFieldsMap();
        }

        @Override // com.google.firestore.v1.AggregationResultOrBuilder
        public int getAggregateFieldsCount() {
            return ((AggregationResult) this.f33398b).getAggregateFieldsMap().size();
        }

        @Override // com.google.firestore.v1.AggregationResultOrBuilder
        public Map<String, Value> getAggregateFieldsMap() {
            return Collections.unmodifiableMap(((AggregationResult) this.f33398b).getAggregateFieldsMap());
        }

        @Override // com.google.firestore.v1.AggregationResultOrBuilder
        public Value getAggregateFieldsOrDefault(String str, Value value) {
            str.getClass();
            Map<String, Value> aggregateFieldsMap = ((AggregationResult) this.f33398b).getAggregateFieldsMap();
            if (aggregateFieldsMap.containsKey(str)) {
                return aggregateFieldsMap.get(str);
            }
            return value;
        }

        @Override // com.google.firestore.v1.AggregationResultOrBuilder
        public Value getAggregateFieldsOrThrow(String str) {
            str.getClass();
            Map<String, Value> aggregateFieldsMap = ((AggregationResult) this.f33398b).getAggregateFieldsMap();
            if (aggregateFieldsMap.containsKey(str)) {
                return aggregateFieldsMap.get(str);
            }
            throw new IllegalArgumentException();
        }

        public Builder putAggregateFields(String str, Value value) {
            str.getClass();
            value.getClass();
            f();
            ((AggregationResult) this.f33398b).h0().put(str, value);
            return this;
        }

        public Builder putAllAggregateFields(Map<String, Value> map) {
            f();
            ((AggregationResult) this.f33398b).h0().putAll(map);
            return this;
        }

        public Builder removeAggregateFields(String str) {
            str.getClass();
            f();
            ((AggregationResult) this.f33398b).h0().remove(str);
            return this;
        }

        private Builder() {
            super(AggregationResult.DEFAULT_INSTANCE);
        }
    }

    static {
        AggregationResult aggregationResult = new AggregationResult();
        DEFAULT_INSTANCE = aggregationResult;
        GeneratedMessageLite.d0(AggregationResult.class, aggregationResult);
    }

    private AggregationResult() {
    }

    public static AggregationResult getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map<String, Value> h0() {
        return j0();
    }

    private MapFieldLite<String, Value> i0() {
        return this.aggregateFields_;
    }

    private MapFieldLite<String, Value> j0() {
        if (!this.aggregateFields_.isMutable()) {
            this.aggregateFields_ = this.aggregateFields_.mutableCopy();
        }
        return this.aggregateFields_;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static AggregationResult parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (AggregationResult) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static AggregationResult parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (AggregationResult) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<AggregationResult> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.AggregationResultOrBuilder
    public boolean containsAggregateFields(String str) {
        str.getClass();
        return i0().containsKey(str);
    }

    @Override // com.google.firestore.v1.AggregationResultOrBuilder
    @Deprecated
    public Map<String, Value> getAggregateFields() {
        return getAggregateFieldsMap();
    }

    @Override // com.google.firestore.v1.AggregationResultOrBuilder
    public int getAggregateFieldsCount() {
        return i0().size();
    }

    @Override // com.google.firestore.v1.AggregationResultOrBuilder
    public Map<String, Value> getAggregateFieldsMap() {
        return Collections.unmodifiableMap(i0());
    }

    @Override // com.google.firestore.v1.AggregationResultOrBuilder
    public Value getAggregateFieldsOrDefault(String str, Value value) {
        str.getClass();
        MapFieldLite<String, Value> i02 = i0();
        if (i02.containsKey(str)) {
            return i02.get(str);
        }
        return value;
    }

    @Override // com.google.firestore.v1.AggregationResultOrBuilder
    public Value getAggregateFieldsOrThrow(String str) {
        str.getClass();
        MapFieldLite<String, Value> i02 = i0();
        if (i02.containsKey(str)) {
            return i02.get(str);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32433a[methodToInvoke.ordinal()]) {
            case 1:
                return new AggregationResult();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0001\u0000\u0000\u00022", new Object[]{"aggregateFields_", AggregateFieldsDefaultEntryHolder.f32434a});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<AggregationResult> parser = PARSER;
                if (parser == null) {
                    synchronized (AggregationResult.class) {
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

    public static Builder newBuilder(AggregationResult aggregationResult) {
        return DEFAULT_INSTANCE.r(aggregationResult);
    }

    public static AggregationResult parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AggregationResult) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AggregationResult parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AggregationResult) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static AggregationResult parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (AggregationResult) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static AggregationResult parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AggregationResult) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static AggregationResult parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (AggregationResult) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static AggregationResult parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (AggregationResult) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static AggregationResult parseFrom(InputStream inputStream) throws IOException {
        return (AggregationResult) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static AggregationResult parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AggregationResult) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static AggregationResult parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (AggregationResult) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static AggregationResult parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (AggregationResult) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
