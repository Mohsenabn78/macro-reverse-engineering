package com.google.firestore.admin.v1;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Internal;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class Index extends GeneratedMessageLite<Index, Builder> implements IndexOrBuilder {
    private static final Index DEFAULT_INSTANCE;
    public static final int FIELDS_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 1;
    private static volatile Parser<Index> PARSER = null;
    public static final int QUERY_SCOPE_FIELD_NUMBER = 2;
    public static final int STATE_FIELD_NUMBER = 4;
    private int queryScope_;
    private int state_;
    private String name_ = "";
    private Internal.ProtobufList<IndexField> fields_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.admin.v1.Index$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32409a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32409a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32409a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32409a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32409a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32409a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32409a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32409a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Index, Builder> implements IndexOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFields(Iterable<? extends IndexField> iterable) {
            f();
            ((Index) this.f33398b).v0(iterable);
            return this;
        }

        public Builder addFields(IndexField indexField) {
            f();
            ((Index) this.f33398b).x0(indexField);
            return this;
        }

        public Builder clearFields() {
            f();
            ((Index) this.f33398b).y0();
            return this;
        }

        public Builder clearName() {
            f();
            ((Index) this.f33398b).z0();
            return this;
        }

        public Builder clearQueryScope() {
            f();
            ((Index) this.f33398b).A0();
            return this;
        }

        public Builder clearState() {
            f();
            ((Index) this.f33398b).B0();
            return this;
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public IndexField getFields(int i4) {
            return ((Index) this.f33398b).getFields(i4);
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public int getFieldsCount() {
            return ((Index) this.f33398b).getFieldsCount();
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public List<IndexField> getFieldsList() {
            return Collections.unmodifiableList(((Index) this.f33398b).getFieldsList());
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public String getName() {
            return ((Index) this.f33398b).getName();
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public ByteString getNameBytes() {
            return ((Index) this.f33398b).getNameBytes();
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public QueryScope getQueryScope() {
            return ((Index) this.f33398b).getQueryScope();
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public int getQueryScopeValue() {
            return ((Index) this.f33398b).getQueryScopeValue();
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public State getState() {
            return ((Index) this.f33398b).getState();
        }

        @Override // com.google.firestore.admin.v1.IndexOrBuilder
        public int getStateValue() {
            return ((Index) this.f33398b).getStateValue();
        }

        public Builder removeFields(int i4) {
            f();
            ((Index) this.f33398b).D0(i4);
            return this;
        }

        public Builder setFields(int i4, IndexField indexField) {
            f();
            ((Index) this.f33398b).E0(i4, indexField);
            return this;
        }

        public Builder setName(String str) {
            f();
            ((Index) this.f33398b).F0(str);
            return this;
        }

        public Builder setNameBytes(ByteString byteString) {
            f();
            ((Index) this.f33398b).G0(byteString);
            return this;
        }

        public Builder setQueryScope(QueryScope queryScope) {
            f();
            ((Index) this.f33398b).H0(queryScope);
            return this;
        }

        public Builder setQueryScopeValue(int i4) {
            f();
            ((Index) this.f33398b).I0(i4);
            return this;
        }

        public Builder setState(State state) {
            f();
            ((Index) this.f33398b).J0(state);
            return this;
        }

        public Builder setStateValue(int i4) {
            f();
            ((Index) this.f33398b).K0(i4);
            return this;
        }

        private Builder() {
            super(Index.DEFAULT_INSTANCE);
        }

        public Builder addFields(int i4, IndexField indexField) {
            f();
            ((Index) this.f33398b).w0(i4, indexField);
            return this;
        }

        public Builder setFields(int i4, IndexField.Builder builder) {
            f();
            ((Index) this.f33398b).E0(i4, builder.build());
            return this;
        }

        public Builder addFields(IndexField.Builder builder) {
            f();
            ((Index) this.f33398b).x0(builder.build());
            return this;
        }

        public Builder addFields(int i4, IndexField.Builder builder) {
            f();
            ((Index) this.f33398b).w0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class IndexField extends GeneratedMessageLite<IndexField, Builder> implements IndexFieldOrBuilder {
        public static final int ARRAY_CONFIG_FIELD_NUMBER = 3;
        private static final IndexField DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 1;
        public static final int ORDER_FIELD_NUMBER = 2;
        private static volatile Parser<IndexField> PARSER;
        private Object valueMode_;
        private int valueModeCase_ = 0;
        private String fieldPath_ = "";

        /* loaded from: classes5.dex */
        public enum ArrayConfig implements Internal.EnumLite {
            ARRAY_CONFIG_UNSPECIFIED(0),
            CONTAINS(1),
            UNRECOGNIZED(-1);
            
            public static final int ARRAY_CONFIG_UNSPECIFIED_VALUE = 0;
            public static final int CONTAINS_VALUE = 1;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<ArrayConfig> f32410a = new Internal.EnumLiteMap<ArrayConfig>() { // from class: com.google.firestore.admin.v1.Index.IndexField.ArrayConfig.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public ArrayConfig findValueByNumber(int i4) {
                    return ArrayConfig.forNumber(i4);
                }
            };
            private final int value;

            /* loaded from: classes5.dex */
            private static final class ArrayConfigVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f32412a = new ArrayConfigVerifier();

                private ArrayConfigVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (ArrayConfig.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            ArrayConfig(int i4) {
                this.value = i4;
            }

            public static ArrayConfig forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        return null;
                    }
                    return CONTAINS;
                }
                return ARRAY_CONFIG_UNSPECIFIED;
            }

            public static Internal.EnumLiteMap<ArrayConfig> internalGetValueMap() {
                return f32410a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return ArrayConfigVerifier.f32412a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static ArrayConfig valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<IndexField, Builder> implements IndexFieldOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearArrayConfig() {
                f();
                ((IndexField) this.f33398b).q0();
                return this;
            }

            public Builder clearFieldPath() {
                f();
                ((IndexField) this.f33398b).r0();
                return this;
            }

            public Builder clearOrder() {
                f();
                ((IndexField) this.f33398b).s0();
                return this;
            }

            public Builder clearValueMode() {
                f();
                ((IndexField) this.f33398b).t0();
                return this;
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public ArrayConfig getArrayConfig() {
                return ((IndexField) this.f33398b).getArrayConfig();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public int getArrayConfigValue() {
                return ((IndexField) this.f33398b).getArrayConfigValue();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public String getFieldPath() {
                return ((IndexField) this.f33398b).getFieldPath();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public ByteString getFieldPathBytes() {
                return ((IndexField) this.f33398b).getFieldPathBytes();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public Order getOrder() {
                return ((IndexField) this.f33398b).getOrder();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public int getOrderValue() {
                return ((IndexField) this.f33398b).getOrderValue();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public ValueModeCase getValueModeCase() {
                return ((IndexField) this.f33398b).getValueModeCase();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public boolean hasArrayConfig() {
                return ((IndexField) this.f33398b).hasArrayConfig();
            }

            @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
            public boolean hasOrder() {
                return ((IndexField) this.f33398b).hasOrder();
            }

            public Builder setArrayConfig(ArrayConfig arrayConfig) {
                f();
                ((IndexField) this.f33398b).u0(arrayConfig);
                return this;
            }

            public Builder setArrayConfigValue(int i4) {
                f();
                ((IndexField) this.f33398b).v0(i4);
                return this;
            }

            public Builder setFieldPath(String str) {
                f();
                ((IndexField) this.f33398b).w0(str);
                return this;
            }

            public Builder setFieldPathBytes(ByteString byteString) {
                f();
                ((IndexField) this.f33398b).x0(byteString);
                return this;
            }

            public Builder setOrder(Order order) {
                f();
                ((IndexField) this.f33398b).y0(order);
                return this;
            }

            public Builder setOrderValue(int i4) {
                f();
                ((IndexField) this.f33398b).z0(i4);
                return this;
            }

            private Builder() {
                super(IndexField.DEFAULT_INSTANCE);
            }
        }

        /* loaded from: classes5.dex */
        public enum Order implements Internal.EnumLite {
            ORDER_UNSPECIFIED(0),
            ASCENDING(1),
            DESCENDING(2),
            UNRECOGNIZED(-1);
            
            public static final int ASCENDING_VALUE = 1;
            public static final int DESCENDING_VALUE = 2;
            public static final int ORDER_UNSPECIFIED_VALUE = 0;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<Order> f32413a = new Internal.EnumLiteMap<Order>() { // from class: com.google.firestore.admin.v1.Index.IndexField.Order.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public Order findValueByNumber(int i4) {
                    return Order.forNumber(i4);
                }
            };
            private final int value;

            /* loaded from: classes5.dex */
            private static final class OrderVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f32415a = new OrderVerifier();

                private OrderVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (Order.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            Order(int i4) {
                this.value = i4;
            }

            public static Order forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return DESCENDING;
                    }
                    return ASCENDING;
                }
                return ORDER_UNSPECIFIED;
            }

            public static Internal.EnumLiteMap<Order> internalGetValueMap() {
                return f32413a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return OrderVerifier.f32415a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static Order valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public enum ValueModeCase {
            ORDER(2),
            ARRAY_CONFIG(3),
            VALUEMODE_NOT_SET(0);
            
            private final int value;

            ValueModeCase(int i4) {
                this.value = i4;
            }

            public static ValueModeCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return ARRAY_CONFIG;
                    }
                    return ORDER;
                }
                return VALUEMODE_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static ValueModeCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            IndexField indexField = new IndexField();
            DEFAULT_INSTANCE = indexField;
            GeneratedMessageLite.d0(IndexField.class, indexField);
        }

        private IndexField() {
        }

        public static IndexField getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static IndexField parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (IndexField) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static IndexField parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (IndexField) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<IndexField> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            if (this.valueModeCase_ == 3) {
                this.valueModeCase_ = 0;
                this.valueMode_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            if (this.valueModeCase_ == 2) {
                this.valueModeCase_ = 0;
                this.valueMode_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            this.valueModeCase_ = 0;
            this.valueMode_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(ArrayConfig arrayConfig) {
            this.valueMode_ = Integer.valueOf(arrayConfig.getNumber());
            this.valueModeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(int i4) {
            this.valueModeCase_ = 3;
            this.valueMode_ = Integer.valueOf(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.fieldPath_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(Order order) {
            this.valueMode_ = Integer.valueOf(order.getNumber());
            this.valueModeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(int i4) {
            this.valueModeCase_ = 2;
            this.valueMode_ = Integer.valueOf(i4);
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public ArrayConfig getArrayConfig() {
            if (this.valueModeCase_ == 3) {
                ArrayConfig forNumber = ArrayConfig.forNumber(((Integer) this.valueMode_).intValue());
                if (forNumber == null) {
                    return ArrayConfig.UNRECOGNIZED;
                }
                return forNumber;
            }
            return ArrayConfig.ARRAY_CONFIG_UNSPECIFIED;
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public int getArrayConfigValue() {
            if (this.valueModeCase_ == 3) {
                return ((Integer) this.valueMode_).intValue();
            }
            return 0;
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public String getFieldPath() {
            return this.fieldPath_;
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public Order getOrder() {
            if (this.valueModeCase_ == 2) {
                Order forNumber = Order.forNumber(((Integer) this.valueMode_).intValue());
                if (forNumber == null) {
                    return Order.UNRECOGNIZED;
                }
                return forNumber;
            }
            return Order.ORDER_UNSPECIFIED;
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public int getOrderValue() {
            if (this.valueModeCase_ == 2) {
                return ((Integer) this.valueMode_).intValue();
            }
            return 0;
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public ValueModeCase getValueModeCase() {
            return ValueModeCase.forNumber(this.valueModeCase_);
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public boolean hasArrayConfig() {
            if (this.valueModeCase_ == 3) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.admin.v1.Index.IndexFieldOrBuilder
        public boolean hasOrder() {
            if (this.valueModeCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32409a[methodToInvoke.ordinal()]) {
                case 1:
                    return new IndexField();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002?\u0000\u0003?\u0000", new Object[]{"valueMode_", "valueModeCase_", "fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<IndexField> parser = PARSER;
                    if (parser == null) {
                        synchronized (IndexField.class) {
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

        public static Builder newBuilder(IndexField indexField) {
            return DEFAULT_INSTANCE.r(indexField);
        }

        public static IndexField parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IndexField) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static IndexField parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (IndexField) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static IndexField parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (IndexField) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static IndexField parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (IndexField) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static IndexField parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (IndexField) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static IndexField parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (IndexField) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static IndexField parseFrom(InputStream inputStream) throws IOException {
            return (IndexField) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static IndexField parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IndexField) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static IndexField parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (IndexField) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static IndexField parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (IndexField) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface IndexFieldOrBuilder extends MessageLiteOrBuilder {
        IndexField.ArrayConfig getArrayConfig();

        int getArrayConfigValue();

        String getFieldPath();

        ByteString getFieldPathBytes();

        IndexField.Order getOrder();

        int getOrderValue();

        IndexField.ValueModeCase getValueModeCase();

        boolean hasArrayConfig();

        boolean hasOrder();
    }

    /* loaded from: classes5.dex */
    public enum QueryScope implements Internal.EnumLite {
        QUERY_SCOPE_UNSPECIFIED(0),
        COLLECTION(1),
        COLLECTION_GROUP(2),
        UNRECOGNIZED(-1);
        
        public static final int COLLECTION_GROUP_VALUE = 2;
        public static final int COLLECTION_VALUE = 1;
        public static final int QUERY_SCOPE_UNSPECIFIED_VALUE = 0;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<QueryScope> f32417a = new Internal.EnumLiteMap<QueryScope>() { // from class: com.google.firestore.admin.v1.Index.QueryScope.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public QueryScope findValueByNumber(int i4) {
                return QueryScope.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class QueryScopeVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f32419a = new QueryScopeVerifier();

            private QueryScopeVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (QueryScope.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        QueryScope(int i4) {
            this.value = i4;
        }

        public static QueryScope forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return COLLECTION_GROUP;
                }
                return COLLECTION;
            }
            return QUERY_SCOPE_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<QueryScope> internalGetValueMap() {
            return f32417a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return QueryScopeVerifier.f32419a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static QueryScope valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public enum State implements Internal.EnumLite {
        STATE_UNSPECIFIED(0),
        CREATING(1),
        READY(2),
        NEEDS_REPAIR(3),
        UNRECOGNIZED(-1);
        
        public static final int CREATING_VALUE = 1;
        public static final int NEEDS_REPAIR_VALUE = 3;
        public static final int READY_VALUE = 2;
        public static final int STATE_UNSPECIFIED_VALUE = 0;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<State> f32420a = new Internal.EnumLiteMap<State>() { // from class: com.google.firestore.admin.v1.Index.State.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public State findValueByNumber(int i4) {
                return State.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class StateVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f32422a = new StateVerifier();

            private StateVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (State.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        State(int i4) {
            this.value = i4;
        }

        public static State forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            return null;
                        }
                        return NEEDS_REPAIR;
                    }
                    return READY;
                }
                return CREATING;
            }
            return STATE_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<State> internalGetValueMap() {
            return f32420a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return StateVerifier.f32422a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static State valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Index index = new Index();
        DEFAULT_INSTANCE = index;
        GeneratedMessageLite.d0(Index.class, index);
    }

    private Index() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0() {
        this.queryScope_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void B0() {
        this.state_ = 0;
    }

    private void C0() {
        Internal.ProtobufList<IndexField> protobufList = this.fields_;
        if (!protobufList.isModifiable()) {
            this.fields_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D0(int i4) {
        C0();
        this.fields_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E0(int i4, IndexField indexField) {
        indexField.getClass();
        C0();
        this.fields_.set(i4, indexField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(String str) {
        str.getClass();
        this.name_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G0(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.name_ = byteString.toStringUtf8();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(QueryScope queryScope) {
        this.queryScope_ = queryScope.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0(int i4) {
        this.queryScope_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(State state) {
        this.state_ = state.getNumber();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(int i4) {
        this.state_ = i4;
    }

    public static Index getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Index parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Index) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Index parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Index) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Index> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0(Iterable<? extends IndexField> iterable) {
        C0();
        AbstractMessageLite.a(iterable, this.fields_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(int i4, IndexField indexField) {
        indexField.getClass();
        C0();
        this.fields_.add(i4, indexField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(IndexField indexField) {
        indexField.getClass();
        C0();
        this.fields_.add(indexField);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        this.fields_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        this.name_ = getDefaultInstance().getName();
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public IndexField getFields(int i4) {
        return this.fields_.get(i4);
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public int getFieldsCount() {
        return this.fields_.size();
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public List<IndexField> getFieldsList() {
        return this.fields_;
    }

    public IndexFieldOrBuilder getFieldsOrBuilder(int i4) {
        return this.fields_.get(i4);
    }

    public List<? extends IndexFieldOrBuilder> getFieldsOrBuilderList() {
        return this.fields_;
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public String getName() {
        return this.name_;
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public ByteString getNameBytes() {
        return ByteString.copyFromUtf8(this.name_);
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public QueryScope getQueryScope() {
        QueryScope forNumber = QueryScope.forNumber(this.queryScope_);
        if (forNumber == null) {
            return QueryScope.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public int getQueryScopeValue() {
        return this.queryScope_;
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public State getState() {
        State forNumber = State.forNumber(this.state_);
        if (forNumber == null) {
            return State.UNRECOGNIZED;
        }
        return forNumber;
    }

    @Override // com.google.firestore.admin.v1.IndexOrBuilder
    public int getStateValue() {
        return this.state_;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32409a[methodToInvoke.ordinal()]) {
            case 1:
                return new Index();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0001\u0000\u0001Ȉ\u0002\f\u0003\u001b\u0004\f", new Object[]{"name_", "queryScope_", "fields_", IndexField.class, "state_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Index> parser = PARSER;
                if (parser == null) {
                    synchronized (Index.class) {
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

    public static Builder newBuilder(Index index) {
        return DEFAULT_INSTANCE.r(index);
    }

    public static Index parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Index) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Index parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Index) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Index parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Index) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Index parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Index) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Index parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Index) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Index parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Index) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Index parseFrom(InputStream inputStream) throws IOException {
        return (Index) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Index parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Index) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Index parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Index) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Index parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Index) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
