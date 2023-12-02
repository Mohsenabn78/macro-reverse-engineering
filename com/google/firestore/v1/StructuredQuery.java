package com.google.firestore.v1;

import com.google.firestore.v1.Cursor;
import com.google.firestore.v1.Value;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int32Value;
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
public final class StructuredQuery extends GeneratedMessageLite<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
    private static final StructuredQuery DEFAULT_INSTANCE;
    public static final int END_AT_FIELD_NUMBER = 8;
    public static final int FROM_FIELD_NUMBER = 2;
    public static final int LIMIT_FIELD_NUMBER = 5;
    public static final int OFFSET_FIELD_NUMBER = 6;
    public static final int ORDER_BY_FIELD_NUMBER = 4;
    private static volatile Parser<StructuredQuery> PARSER = null;
    public static final int SELECT_FIELD_NUMBER = 1;
    public static final int START_AT_FIELD_NUMBER = 7;
    public static final int WHERE_FIELD_NUMBER = 3;
    private Cursor endAt_;
    private Int32Value limit_;
    private int offset_;
    private Projection select_;
    private Cursor startAt_;
    private Filter where_;
    private Internal.ProtobufList<CollectionSelector> from_ = GeneratedMessageLite.y();
    private Internal.ProtobufList<Order> orderBy_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.StructuredQuery$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32506a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32506a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32506a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32506a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32506a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32506a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32506a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32506a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<StructuredQuery, Builder> implements StructuredQueryOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAllFrom(Iterable<? extends CollectionSelector> iterable) {
            f();
            ((StructuredQuery) this.f33398b).J0(iterable);
            return this;
        }

        public Builder addAllOrderBy(Iterable<? extends Order> iterable) {
            f();
            ((StructuredQuery) this.f33398b).K0(iterable);
            return this;
        }

        public Builder addFrom(CollectionSelector collectionSelector) {
            f();
            ((StructuredQuery) this.f33398b).M0(collectionSelector);
            return this;
        }

        public Builder addOrderBy(Order order) {
            f();
            ((StructuredQuery) this.f33398b).O0(order);
            return this;
        }

        public Builder clearEndAt() {
            f();
            ((StructuredQuery) this.f33398b).P0();
            return this;
        }

        public Builder clearFrom() {
            f();
            ((StructuredQuery) this.f33398b).Q0();
            return this;
        }

        public Builder clearLimit() {
            f();
            ((StructuredQuery) this.f33398b).R0();
            return this;
        }

        public Builder clearOffset() {
            f();
            ((StructuredQuery) this.f33398b).S0();
            return this;
        }

        public Builder clearOrderBy() {
            f();
            ((StructuredQuery) this.f33398b).T0();
            return this;
        }

        public Builder clearSelect() {
            f();
            ((StructuredQuery) this.f33398b).U0();
            return this;
        }

        public Builder clearStartAt() {
            f();
            ((StructuredQuery) this.f33398b).V0();
            return this;
        }

        public Builder clearWhere() {
            f();
            ((StructuredQuery) this.f33398b).W0();
            return this;
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Cursor getEndAt() {
            return ((StructuredQuery) this.f33398b).getEndAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public CollectionSelector getFrom(int i4) {
            return ((StructuredQuery) this.f33398b).getFrom(i4);
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public int getFromCount() {
            return ((StructuredQuery) this.f33398b).getFromCount();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public List<CollectionSelector> getFromList() {
            return Collections.unmodifiableList(((StructuredQuery) this.f33398b).getFromList());
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Int32Value getLimit() {
            return ((StructuredQuery) this.f33398b).getLimit();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public int getOffset() {
            return ((StructuredQuery) this.f33398b).getOffset();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Order getOrderBy(int i4) {
            return ((StructuredQuery) this.f33398b).getOrderBy(i4);
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public int getOrderByCount() {
            return ((StructuredQuery) this.f33398b).getOrderByCount();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public List<Order> getOrderByList() {
            return Collections.unmodifiableList(((StructuredQuery) this.f33398b).getOrderByList());
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Projection getSelect() {
            return ((StructuredQuery) this.f33398b).getSelect();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Cursor getStartAt() {
            return ((StructuredQuery) this.f33398b).getStartAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public Filter getWhere() {
            return ((StructuredQuery) this.f33398b).getWhere();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasEndAt() {
            return ((StructuredQuery) this.f33398b).hasEndAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasLimit() {
            return ((StructuredQuery) this.f33398b).hasLimit();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasSelect() {
            return ((StructuredQuery) this.f33398b).hasSelect();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasStartAt() {
            return ((StructuredQuery) this.f33398b).hasStartAt();
        }

        @Override // com.google.firestore.v1.StructuredQueryOrBuilder
        public boolean hasWhere() {
            return ((StructuredQuery) this.f33398b).hasWhere();
        }

        public Builder mergeEndAt(Cursor cursor) {
            f();
            ((StructuredQuery) this.f33398b).Z0(cursor);
            return this;
        }

        public Builder mergeLimit(Int32Value int32Value) {
            f();
            ((StructuredQuery) this.f33398b).a1(int32Value);
            return this;
        }

        public Builder mergeSelect(Projection projection) {
            f();
            ((StructuredQuery) this.f33398b).b1(projection);
            return this;
        }

        public Builder mergeStartAt(Cursor cursor) {
            f();
            ((StructuredQuery) this.f33398b).c1(cursor);
            return this;
        }

        public Builder mergeWhere(Filter filter) {
            f();
            ((StructuredQuery) this.f33398b).d1(filter);
            return this;
        }

        public Builder removeFrom(int i4) {
            f();
            ((StructuredQuery) this.f33398b).e1(i4);
            return this;
        }

        public Builder removeOrderBy(int i4) {
            f();
            ((StructuredQuery) this.f33398b).f1(i4);
            return this;
        }

        public Builder setEndAt(Cursor cursor) {
            f();
            ((StructuredQuery) this.f33398b).g1(cursor);
            return this;
        }

        public Builder setFrom(int i4, CollectionSelector collectionSelector) {
            f();
            ((StructuredQuery) this.f33398b).h1(i4, collectionSelector);
            return this;
        }

        public Builder setLimit(Int32Value int32Value) {
            f();
            ((StructuredQuery) this.f33398b).i1(int32Value);
            return this;
        }

        public Builder setOffset(int i4) {
            f();
            ((StructuredQuery) this.f33398b).j1(i4);
            return this;
        }

        public Builder setOrderBy(int i4, Order order) {
            f();
            ((StructuredQuery) this.f33398b).k1(i4, order);
            return this;
        }

        public Builder setSelect(Projection projection) {
            f();
            ((StructuredQuery) this.f33398b).l1(projection);
            return this;
        }

        public Builder setStartAt(Cursor cursor) {
            f();
            ((StructuredQuery) this.f33398b).m1(cursor);
            return this;
        }

        public Builder setWhere(Filter filter) {
            f();
            ((StructuredQuery) this.f33398b).n1(filter);
            return this;
        }

        private Builder() {
            super(StructuredQuery.DEFAULT_INSTANCE);
        }

        public Builder addFrom(int i4, CollectionSelector collectionSelector) {
            f();
            ((StructuredQuery) this.f33398b).L0(i4, collectionSelector);
            return this;
        }

        public Builder addOrderBy(int i4, Order order) {
            f();
            ((StructuredQuery) this.f33398b).N0(i4, order);
            return this;
        }

        public Builder setEndAt(Cursor.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).g1(builder.build());
            return this;
        }

        public Builder setFrom(int i4, CollectionSelector.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).h1(i4, builder.build());
            return this;
        }

        public Builder setLimit(Int32Value.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).i1(builder.build());
            return this;
        }

        public Builder setOrderBy(int i4, Order.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).k1(i4, builder.build());
            return this;
        }

        public Builder setSelect(Projection.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).l1(builder.build());
            return this;
        }

        public Builder setStartAt(Cursor.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).m1(builder.build());
            return this;
        }

        public Builder setWhere(Filter.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).n1(builder.build());
            return this;
        }

        public Builder addFrom(CollectionSelector.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).M0(builder.build());
            return this;
        }

        public Builder addOrderBy(Order.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).O0(builder.build());
            return this;
        }

        public Builder addFrom(int i4, CollectionSelector.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).L0(i4, builder.build());
            return this;
        }

        public Builder addOrderBy(int i4, Order.Builder builder) {
            f();
            ((StructuredQuery) this.f33398b).N0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public static final class CollectionSelector extends GeneratedMessageLite<CollectionSelector, Builder> implements CollectionSelectorOrBuilder {
        public static final int ALL_DESCENDANTS_FIELD_NUMBER = 3;
        public static final int COLLECTION_ID_FIELD_NUMBER = 2;
        private static final CollectionSelector DEFAULT_INSTANCE;
        private static volatile Parser<CollectionSelector> PARSER;
        private boolean allDescendants_;
        private String collectionId_ = "";

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CollectionSelector, Builder> implements CollectionSelectorOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAllDescendants() {
                f();
                ((CollectionSelector) this.f33398b).l0();
                return this;
            }

            public Builder clearCollectionId() {
                f();
                ((CollectionSelector) this.f33398b).m0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
            public boolean getAllDescendants() {
                return ((CollectionSelector) this.f33398b).getAllDescendants();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
            public String getCollectionId() {
                return ((CollectionSelector) this.f33398b).getCollectionId();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
            public ByteString getCollectionIdBytes() {
                return ((CollectionSelector) this.f33398b).getCollectionIdBytes();
            }

            public Builder setAllDescendants(boolean z3) {
                f();
                ((CollectionSelector) this.f33398b).n0(z3);
                return this;
            }

            public Builder setCollectionId(String str) {
                f();
                ((CollectionSelector) this.f33398b).o0(str);
                return this;
            }

            public Builder setCollectionIdBytes(ByteString byteString) {
                f();
                ((CollectionSelector) this.f33398b).p0(byteString);
                return this;
            }

            private Builder() {
                super(CollectionSelector.DEFAULT_INSTANCE);
            }
        }

        static {
            CollectionSelector collectionSelector = new CollectionSelector();
            DEFAULT_INSTANCE = collectionSelector;
            GeneratedMessageLite.d0(CollectionSelector.class, collectionSelector);
        }

        private CollectionSelector() {
        }

        public static CollectionSelector getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0() {
            this.allDescendants_ = false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0() {
            this.collectionId_ = getDefaultInstance().getCollectionId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(boolean z3) {
            this.allDescendants_ = z3;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(String str) {
            str.getClass();
            this.collectionId_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.collectionId_ = byteString.toStringUtf8();
        }

        public static CollectionSelector parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static CollectionSelector parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CollectionSelector> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
        public boolean getAllDescendants() {
            return this.allDescendants_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
        public String getCollectionId() {
            return this.collectionId_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CollectionSelectorOrBuilder
        public ByteString getCollectionIdBytes() {
            return ByteString.copyFromUtf8(this.collectionId_);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CollectionSelector();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002Ȉ\u0003\u0007", new Object[]{"collectionId_", "allDescendants_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CollectionSelector> parser = PARSER;
                    if (parser == null) {
                        synchronized (CollectionSelector.class) {
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

        public static Builder newBuilder(CollectionSelector collectionSelector) {
            return DEFAULT_INSTANCE.r(collectionSelector);
        }

        public static CollectionSelector parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static CollectionSelector parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static CollectionSelector parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CollectionSelector) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(InputStream inputStream) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static CollectionSelector parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CollectionSelector parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CollectionSelector parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CollectionSelector) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface CollectionSelectorOrBuilder extends MessageLiteOrBuilder {
        boolean getAllDescendants();

        String getCollectionId();

        ByteString getCollectionIdBytes();
    }

    /* loaded from: classes5.dex */
    public static final class CompositeFilter extends GeneratedMessageLite<CompositeFilter, Builder> implements CompositeFilterOrBuilder {
        private static final CompositeFilter DEFAULT_INSTANCE;
        public static final int FILTERS_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<CompositeFilter> PARSER;
        private Internal.ProtobufList<Filter> filters_ = GeneratedMessageLite.y();
        private int op_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<CompositeFilter, Builder> implements CompositeFilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFilters(Iterable<? extends Filter> iterable) {
                f();
                ((CompositeFilter) this.f33398b).p0(iterable);
                return this;
            }

            public Builder addFilters(Filter filter) {
                f();
                ((CompositeFilter) this.f33398b).r0(filter);
                return this;
            }

            public Builder clearFilters() {
                f();
                ((CompositeFilter) this.f33398b).s0();
                return this;
            }

            public Builder clearOp() {
                f();
                ((CompositeFilter) this.f33398b).t0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public Filter getFilters(int i4) {
                return ((CompositeFilter) this.f33398b).getFilters(i4);
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public int getFiltersCount() {
                return ((CompositeFilter) this.f33398b).getFiltersCount();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public List<Filter> getFiltersList() {
                return Collections.unmodifiableList(((CompositeFilter) this.f33398b).getFiltersList());
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public Operator getOp() {
                return ((CompositeFilter) this.f33398b).getOp();
            }

            @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
            public int getOpValue() {
                return ((CompositeFilter) this.f33398b).getOpValue();
            }

            public Builder removeFilters(int i4) {
                f();
                ((CompositeFilter) this.f33398b).v0(i4);
                return this;
            }

            public Builder setFilters(int i4, Filter filter) {
                f();
                ((CompositeFilter) this.f33398b).w0(i4, filter);
                return this;
            }

            public Builder setOp(Operator operator) {
                f();
                ((CompositeFilter) this.f33398b).x0(operator);
                return this;
            }

            public Builder setOpValue(int i4) {
                f();
                ((CompositeFilter) this.f33398b).y0(i4);
                return this;
            }

            private Builder() {
                super(CompositeFilter.DEFAULT_INSTANCE);
            }

            public Builder addFilters(int i4, Filter filter) {
                f();
                ((CompositeFilter) this.f33398b).q0(i4, filter);
                return this;
            }

            public Builder setFilters(int i4, Filter.Builder builder) {
                f();
                ((CompositeFilter) this.f33398b).w0(i4, builder.build());
                return this;
            }

            public Builder addFilters(Filter.Builder builder) {
                f();
                ((CompositeFilter) this.f33398b).r0(builder.build());
                return this;
            }

            public Builder addFilters(int i4, Filter.Builder builder) {
                f();
                ((CompositeFilter) this.f33398b).q0(i4, builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            AND(1),
            OR(2),
            UNRECOGNIZED(-1);
            
            public static final int AND_VALUE = 1;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;
            public static final int OR_VALUE = 2;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<Operator> f32507a = new Internal.EnumLiteMap<Operator>() { // from class: com.google.firestore.v1.StructuredQuery.CompositeFilter.Operator.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public Operator findValueByNumber(int i4) {
                    return Operator.forNumber(i4);
                }
            };
            private final int value;

            /* loaded from: classes5.dex */
            private static final class OperatorVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f32509a = new OperatorVerifier();

                private OperatorVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (Operator.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            Operator(int i4) {
                this.value = i4;
            }

            public static Operator forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            return null;
                        }
                        return OR;
                    }
                    return AND;
                }
                return OPERATOR_UNSPECIFIED;
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return f32507a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return OperatorVerifier.f32509a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static Operator valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            CompositeFilter compositeFilter = new CompositeFilter();
            DEFAULT_INSTANCE = compositeFilter;
            GeneratedMessageLite.d0(CompositeFilter.class, compositeFilter);
        }

        private CompositeFilter() {
        }

        public static CompositeFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(Iterable<? extends Filter> iterable) {
            u0();
            AbstractMessageLite.a(iterable, this.filters_);
        }

        public static CompositeFilter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static CompositeFilter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<CompositeFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i4, Filter filter) {
            filter.getClass();
            u0();
            this.filters_.add(i4, filter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(Filter filter) {
            filter.getClass();
            u0();
            this.filters_.add(filter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            this.filters_ = GeneratedMessageLite.y();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            this.op_ = 0;
        }

        private void u0() {
            Internal.ProtobufList<Filter> protobufList = this.filters_;
            if (!protobufList.isModifiable()) {
                this.filters_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(int i4) {
            u0();
            this.filters_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(int i4, Filter filter) {
            filter.getClass();
            u0();
            this.filters_.set(i4, filter);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(Operator operator) {
            this.op_ = operator.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(int i4) {
            this.op_ = i4;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public Filter getFilters(int i4) {
            return this.filters_.get(i4);
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public int getFiltersCount() {
            return this.filters_.size();
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public List<Filter> getFiltersList() {
            return this.filters_;
        }

        public FilterOrBuilder getFiltersOrBuilder(int i4) {
            return this.filters_.get(i4);
        }

        public List<? extends FilterOrBuilder> getFiltersOrBuilderList() {
            return this.filters_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public Operator getOp() {
            Operator forNumber = Operator.forNumber(this.op_);
            if (forNumber == null) {
                return Operator.UNRECOGNIZED;
            }
            return forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.CompositeFilterOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new CompositeFilter();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\f\u0002\u001b", new Object[]{"op_", "filters_", Filter.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<CompositeFilter> parser = PARSER;
                    if (parser == null) {
                        synchronized (CompositeFilter.class) {
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

        public static Builder newBuilder(CompositeFilter compositeFilter) {
            return DEFAULT_INSTANCE.r(compositeFilter);
        }

        public static CompositeFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static CompositeFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static CompositeFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (CompositeFilter) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(InputStream inputStream) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static CompositeFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static CompositeFilter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static CompositeFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (CompositeFilter) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface CompositeFilterOrBuilder extends MessageLiteOrBuilder {
        Filter getFilters(int i4);

        int getFiltersCount();

        List<Filter> getFiltersList();

        CompositeFilter.Operator getOp();

        int getOpValue();
    }

    /* loaded from: classes5.dex */
    public enum Direction implements Internal.EnumLite {
        DIRECTION_UNSPECIFIED(0),
        ASCENDING(1),
        DESCENDING(2),
        UNRECOGNIZED(-1);
        
        public static final int ASCENDING_VALUE = 1;
        public static final int DESCENDING_VALUE = 2;
        public static final int DIRECTION_UNSPECIFIED_VALUE = 0;

        /* renamed from: a  reason: collision with root package name */
        private static final Internal.EnumLiteMap<Direction> f32510a = new Internal.EnumLiteMap<Direction>() { // from class: com.google.firestore.v1.StructuredQuery.Direction.1
            @Override // com.google.protobuf.Internal.EnumLiteMap
            /* renamed from: a */
            public Direction findValueByNumber(int i4) {
                return Direction.forNumber(i4);
            }
        };
        private final int value;

        /* loaded from: classes5.dex */
        private static final class DirectionVerifier implements Internal.EnumVerifier {

            /* renamed from: a  reason: collision with root package name */
            static final Internal.EnumVerifier f32512a = new DirectionVerifier();

            private DirectionVerifier() {
            }

            @Override // com.google.protobuf.Internal.EnumVerifier
            public boolean isInRange(int i4) {
                if (Direction.forNumber(i4) != null) {
                    return true;
                }
                return false;
            }
        }

        Direction(int i4) {
            this.value = i4;
        }

        public static Direction forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        return null;
                    }
                    return DESCENDING;
                }
                return ASCENDING;
            }
            return DIRECTION_UNSPECIFIED;
        }

        public static Internal.EnumLiteMap<Direction> internalGetValueMap() {
            return f32510a;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return DirectionVerifier.f32512a;
        }

        @Override // com.google.protobuf.Internal.EnumLite
        public final int getNumber() {
            if (this != UNRECOGNIZED) {
                return this.value;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }

        @Deprecated
        public static Direction valueOf(int i4) {
            return forNumber(i4);
        }
    }

    /* loaded from: classes5.dex */
    public static final class FieldFilter extends GeneratedMessageLite<FieldFilter, Builder> implements FieldFilterOrBuilder {
        private static final FieldFilter DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 1;
        public static final int OP_FIELD_NUMBER = 2;
        private static volatile Parser<FieldFilter> PARSER = null;
        public static final int VALUE_FIELD_NUMBER = 3;
        private FieldReference field_;
        private int op_;
        private Value value_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldFilter, Builder> implements FieldFilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearField() {
                f();
                ((FieldFilter) this.f33398b).p0();
                return this;
            }

            public Builder clearOp() {
                f();
                ((FieldFilter) this.f33398b).q0();
                return this;
            }

            public Builder clearValue() {
                f();
                ((FieldFilter) this.f33398b).r0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public FieldReference getField() {
                return ((FieldFilter) this.f33398b).getField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public Operator getOp() {
                return ((FieldFilter) this.f33398b).getOp();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public int getOpValue() {
                return ((FieldFilter) this.f33398b).getOpValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public Value getValue() {
                return ((FieldFilter) this.f33398b).getValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public boolean hasField() {
                return ((FieldFilter) this.f33398b).hasField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
            public boolean hasValue() {
                return ((FieldFilter) this.f33398b).hasValue();
            }

            public Builder mergeField(FieldReference fieldReference) {
                f();
                ((FieldFilter) this.f33398b).s0(fieldReference);
                return this;
            }

            public Builder mergeValue(Value value) {
                f();
                ((FieldFilter) this.f33398b).t0(value);
                return this;
            }

            public Builder setField(FieldReference fieldReference) {
                f();
                ((FieldFilter) this.f33398b).u0(fieldReference);
                return this;
            }

            public Builder setOp(Operator operator) {
                f();
                ((FieldFilter) this.f33398b).v0(operator);
                return this;
            }

            public Builder setOpValue(int i4) {
                f();
                ((FieldFilter) this.f33398b).w0(i4);
                return this;
            }

            public Builder setValue(Value value) {
                f();
                ((FieldFilter) this.f33398b).x0(value);
                return this;
            }

            private Builder() {
                super(FieldFilter.DEFAULT_INSTANCE);
            }

            public Builder setField(FieldReference.Builder builder) {
                f();
                ((FieldFilter) this.f33398b).u0(builder.build());
                return this;
            }

            public Builder setValue(Value.Builder builder) {
                f();
                ((FieldFilter) this.f33398b).x0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            LESS_THAN(1),
            LESS_THAN_OR_EQUAL(2),
            GREATER_THAN(3),
            GREATER_THAN_OR_EQUAL(4),
            EQUAL(5),
            NOT_EQUAL(6),
            ARRAY_CONTAINS(7),
            IN(8),
            ARRAY_CONTAINS_ANY(9),
            NOT_IN(10),
            UNRECOGNIZED(-1);
            
            public static final int ARRAY_CONTAINS_ANY_VALUE = 9;
            public static final int ARRAY_CONTAINS_VALUE = 7;
            public static final int EQUAL_VALUE = 5;
            public static final int GREATER_THAN_OR_EQUAL_VALUE = 4;
            public static final int GREATER_THAN_VALUE = 3;
            public static final int IN_VALUE = 8;
            public static final int LESS_THAN_OR_EQUAL_VALUE = 2;
            public static final int LESS_THAN_VALUE = 1;
            public static final int NOT_EQUAL_VALUE = 6;
            public static final int NOT_IN_VALUE = 10;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<Operator> f32513a = new Internal.EnumLiteMap<Operator>() { // from class: com.google.firestore.v1.StructuredQuery.FieldFilter.Operator.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public Operator findValueByNumber(int i4) {
                    return Operator.forNumber(i4);
                }
            };
            private final int value;

            /* loaded from: classes5.dex */
            private static final class OperatorVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f32515a = new OperatorVerifier();

                private OperatorVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (Operator.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            Operator(int i4) {
                this.value = i4;
            }

            public static Operator forNumber(int i4) {
                switch (i4) {
                    case 0:
                        return OPERATOR_UNSPECIFIED;
                    case 1:
                        return LESS_THAN;
                    case 2:
                        return LESS_THAN_OR_EQUAL;
                    case 3:
                        return GREATER_THAN;
                    case 4:
                        return GREATER_THAN_OR_EQUAL;
                    case 5:
                        return EQUAL;
                    case 6:
                        return NOT_EQUAL;
                    case 7:
                        return ARRAY_CONTAINS;
                    case 8:
                        return IN;
                    case 9:
                        return ARRAY_CONTAINS_ANY;
                    case 10:
                        return NOT_IN;
                    default:
                        return null;
                }
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return f32513a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return OperatorVerifier.f32515a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static Operator valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            FieldFilter fieldFilter = new FieldFilter();
            DEFAULT_INSTANCE = fieldFilter;
            GeneratedMessageLite.d0(FieldFilter.class, fieldFilter);
        }

        private FieldFilter() {
        }

        public static FieldFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.field_ = null;
        }

        public static FieldFilter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldFilter) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldFilter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FieldFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            this.op_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            this.value_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(FieldReference fieldReference) {
            fieldReference.getClass();
            FieldReference fieldReference2 = this.field_;
            if (fieldReference2 != null && fieldReference2 != FieldReference.getDefaultInstance()) {
                this.field_ = FieldReference.newBuilder(this.field_).mergeFrom((FieldReference.Builder) fieldReference).buildPartial();
            } else {
                this.field_ = fieldReference;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(Value value) {
            value.getClass();
            Value value2 = this.value_;
            if (value2 != null && value2 != Value.getDefaultInstance()) {
                this.value_ = Value.newBuilder(this.value_).mergeFrom((Value.Builder) value).buildPartial();
            } else {
                this.value_ = value;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(FieldReference fieldReference) {
            fieldReference.getClass();
            this.field_ = fieldReference;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(Operator operator) {
            this.op_ = operator.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(int i4) {
            this.op_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(Value value) {
            value.getClass();
            this.value_ = value;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public FieldReference getField() {
            FieldReference fieldReference = this.field_;
            if (fieldReference == null) {
                return FieldReference.getDefaultInstance();
            }
            return fieldReference;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public Operator getOp() {
            Operator forNumber = Operator.forNumber(this.op_);
            if (forNumber == null) {
                return Operator.UNRECOGNIZED;
            }
            return forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public Value getValue() {
            Value value = this.value_;
            if (value == null) {
                return Value.getDefaultInstance();
            }
            return value;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public boolean hasField() {
            if (this.field_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldFilterOrBuilder
        public boolean hasValue() {
            if (this.value_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldFilter();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\f\u0003\t", new Object[]{"field_", "op_", "value_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldFilter> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldFilter.class) {
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

        public static Builder newBuilder(FieldFilter fieldFilter) {
            return DEFAULT_INSTANCE.r(fieldFilter);
        }

        public static FieldFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldFilter) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FieldFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FieldFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldFilter) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(InputStream inputStream) throws IOException {
            return (FieldFilter) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldFilter) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldFilter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldFilter) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldFilter) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface FieldFilterOrBuilder extends MessageLiteOrBuilder {
        FieldReference getField();

        FieldFilter.Operator getOp();

        int getOpValue();

        Value getValue();

        boolean hasField();

        boolean hasValue();
    }

    /* loaded from: classes5.dex */
    public static final class FieldReference extends GeneratedMessageLite<FieldReference, Builder> implements FieldReferenceOrBuilder {
        private static final FieldReference DEFAULT_INSTANCE;
        public static final int FIELD_PATH_FIELD_NUMBER = 2;
        private static volatile Parser<FieldReference> PARSER;
        private String fieldPath_ = "";

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<FieldReference, Builder> implements FieldReferenceOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearFieldPath() {
                f();
                ((FieldReference) this.f33398b).j0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
            public String getFieldPath() {
                return ((FieldReference) this.f33398b).getFieldPath();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
            public ByteString getFieldPathBytes() {
                return ((FieldReference) this.f33398b).getFieldPathBytes();
            }

            public Builder setFieldPath(String str) {
                f();
                ((FieldReference) this.f33398b).k0(str);
                return this;
            }

            public Builder setFieldPathBytes(ByteString byteString) {
                f();
                ((FieldReference) this.f33398b).l0(byteString);
                return this;
            }

            private Builder() {
                super(FieldReference.DEFAULT_INSTANCE);
            }
        }

        static {
            FieldReference fieldReference = new FieldReference();
            DEFAULT_INSTANCE = fieldReference;
            GeneratedMessageLite.d0(FieldReference.class, fieldReference);
        }

        private FieldReference() {
        }

        public static FieldReference getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void j0() {
            this.fieldPath_ = getDefaultInstance().getFieldPath();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void k0(String str) {
            str.getClass();
            this.fieldPath_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void l0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.fieldPath_ = byteString.toStringUtf8();
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static FieldReference parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (FieldReference) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldReference parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<FieldReference> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
        public String getFieldPath() {
            return this.fieldPath_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FieldReferenceOrBuilder
        public ByteString getFieldPathBytes() {
            return ByteString.copyFromUtf8(this.fieldPath_);
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new FieldReference();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0000\u0000\u0002Ȉ", new Object[]{"fieldPath_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<FieldReference> parser = PARSER;
                    if (parser == null) {
                        synchronized (FieldReference.class) {
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

        public static Builder newBuilder(FieldReference fieldReference) {
            return DEFAULT_INSTANCE.r(fieldReference);
        }

        public static FieldReference parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldReference) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldReference parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static FieldReference parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static FieldReference parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static FieldReference parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static FieldReference parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (FieldReference) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static FieldReference parseFrom(InputStream inputStream) throws IOException {
            return (FieldReference) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static FieldReference parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldReference) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static FieldReference parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (FieldReference) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static FieldReference parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (FieldReference) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface FieldReferenceOrBuilder extends MessageLiteOrBuilder {
        String getFieldPath();

        ByteString getFieldPathBytes();
    }

    /* loaded from: classes5.dex */
    public static final class Filter extends GeneratedMessageLite<Filter, Builder> implements FilterOrBuilder {
        public static final int COMPOSITE_FILTER_FIELD_NUMBER = 1;
        private static final Filter DEFAULT_INSTANCE;
        public static final int FIELD_FILTER_FIELD_NUMBER = 2;
        private static volatile Parser<Filter> PARSER = null;
        public static final int UNARY_FILTER_FIELD_NUMBER = 3;
        private int filterTypeCase_ = 0;
        private Object filterType_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Filter, Builder> implements FilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearCompositeFilter() {
                f();
                ((Filter) this.f33398b).q0();
                return this;
            }

            public Builder clearFieldFilter() {
                f();
                ((Filter) this.f33398b).r0();
                return this;
            }

            public Builder clearFilterType() {
                f();
                ((Filter) this.f33398b).s0();
                return this;
            }

            public Builder clearUnaryFilter() {
                f();
                ((Filter) this.f33398b).t0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public CompositeFilter getCompositeFilter() {
                return ((Filter) this.f33398b).getCompositeFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public FieldFilter getFieldFilter() {
                return ((Filter) this.f33398b).getFieldFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public FilterTypeCase getFilterTypeCase() {
                return ((Filter) this.f33398b).getFilterTypeCase();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public UnaryFilter getUnaryFilter() {
                return ((Filter) this.f33398b).getUnaryFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public boolean hasCompositeFilter() {
                return ((Filter) this.f33398b).hasCompositeFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public boolean hasFieldFilter() {
                return ((Filter) this.f33398b).hasFieldFilter();
            }

            @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
            public boolean hasUnaryFilter() {
                return ((Filter) this.f33398b).hasUnaryFilter();
            }

            public Builder mergeCompositeFilter(CompositeFilter compositeFilter) {
                f();
                ((Filter) this.f33398b).u0(compositeFilter);
                return this;
            }

            public Builder mergeFieldFilter(FieldFilter fieldFilter) {
                f();
                ((Filter) this.f33398b).v0(fieldFilter);
                return this;
            }

            public Builder mergeUnaryFilter(UnaryFilter unaryFilter) {
                f();
                ((Filter) this.f33398b).w0(unaryFilter);
                return this;
            }

            public Builder setCompositeFilter(CompositeFilter compositeFilter) {
                f();
                ((Filter) this.f33398b).x0(compositeFilter);
                return this;
            }

            public Builder setFieldFilter(FieldFilter fieldFilter) {
                f();
                ((Filter) this.f33398b).y0(fieldFilter);
                return this;
            }

            public Builder setUnaryFilter(UnaryFilter unaryFilter) {
                f();
                ((Filter) this.f33398b).z0(unaryFilter);
                return this;
            }

            private Builder() {
                super(Filter.DEFAULT_INSTANCE);
            }

            public Builder setCompositeFilter(CompositeFilter.Builder builder) {
                f();
                ((Filter) this.f33398b).x0(builder.build());
                return this;
            }

            public Builder setFieldFilter(FieldFilter.Builder builder) {
                f();
                ((Filter) this.f33398b).y0(builder.build());
                return this;
            }

            public Builder setUnaryFilter(UnaryFilter.Builder builder) {
                f();
                ((Filter) this.f33398b).z0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum FilterTypeCase {
            COMPOSITE_FILTER(1),
            FIELD_FILTER(2),
            UNARY_FILTER(3),
            FILTERTYPE_NOT_SET(0);
            
            private final int value;

            FilterTypeCase(int i4) {
                this.value = i4;
            }

            public static FilterTypeCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                return null;
                            }
                            return UNARY_FILTER;
                        }
                        return FIELD_FILTER;
                    }
                    return COMPOSITE_FILTER;
                }
                return FILTERTYPE_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static FilterTypeCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            Filter filter = new Filter();
            DEFAULT_INSTANCE = filter;
            GeneratedMessageLite.d0(Filter.class, filter);
        }

        private Filter() {
        }

        public static Filter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static Filter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Filter) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static Filter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Filter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0() {
            if (this.filterTypeCase_ == 1) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0() {
            if (this.filterTypeCase_ == 2) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0() {
            this.filterTypeCase_ = 0;
            this.filterType_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            if (this.filterTypeCase_ == 3) {
                this.filterTypeCase_ = 0;
                this.filterType_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0(CompositeFilter compositeFilter) {
            compositeFilter.getClass();
            if (this.filterTypeCase_ == 1 && this.filterType_ != CompositeFilter.getDefaultInstance()) {
                this.filterType_ = CompositeFilter.newBuilder((CompositeFilter) this.filterType_).mergeFrom((CompositeFilter.Builder) compositeFilter).buildPartial();
            } else {
                this.filterType_ = compositeFilter;
            }
            this.filterTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0(FieldFilter fieldFilter) {
            fieldFilter.getClass();
            if (this.filterTypeCase_ == 2 && this.filterType_ != FieldFilter.getDefaultInstance()) {
                this.filterType_ = FieldFilter.newBuilder((FieldFilter) this.filterType_).mergeFrom((FieldFilter.Builder) fieldFilter).buildPartial();
            } else {
                this.filterType_ = fieldFilter;
            }
            this.filterTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0(UnaryFilter unaryFilter) {
            unaryFilter.getClass();
            if (this.filterTypeCase_ == 3 && this.filterType_ != UnaryFilter.getDefaultInstance()) {
                this.filterType_ = UnaryFilter.newBuilder((UnaryFilter) this.filterType_).mergeFrom((UnaryFilter.Builder) unaryFilter).buildPartial();
            } else {
                this.filterType_ = unaryFilter;
            }
            this.filterTypeCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0(CompositeFilter compositeFilter) {
            compositeFilter.getClass();
            this.filterType_ = compositeFilter;
            this.filterTypeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(FieldFilter fieldFilter) {
            fieldFilter.getClass();
            this.filterType_ = fieldFilter;
            this.filterTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(UnaryFilter unaryFilter) {
            unaryFilter.getClass();
            this.filterType_ = unaryFilter;
            this.filterTypeCase_ = 3;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public CompositeFilter getCompositeFilter() {
            if (this.filterTypeCase_ == 1) {
                return (CompositeFilter) this.filterType_;
            }
            return CompositeFilter.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public FieldFilter getFieldFilter() {
            if (this.filterTypeCase_ == 2) {
                return (FieldFilter) this.filterType_;
            }
            return FieldFilter.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public FilterTypeCase getFilterTypeCase() {
            return FilterTypeCase.forNumber(this.filterTypeCase_);
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public UnaryFilter getUnaryFilter() {
            if (this.filterTypeCase_ == 3) {
                return (UnaryFilter) this.filterType_;
            }
            return UnaryFilter.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public boolean hasCompositeFilter() {
            if (this.filterTypeCase_ == 1) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public boolean hasFieldFilter() {
            if (this.filterTypeCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.StructuredQuery.FilterOrBuilder
        public boolean hasUnaryFilter() {
            if (this.filterTypeCase_ == 3) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Filter();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0003\u0001\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"filterType_", "filterTypeCase_", CompositeFilter.class, FieldFilter.class, UnaryFilter.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Filter> parser = PARSER;
                    if (parser == null) {
                        synchronized (Filter.class) {
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

        public static Builder newBuilder(Filter filter) {
            return DEFAULT_INSTANCE.r(filter);
        }

        public static Filter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Filter) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Filter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Filter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static Filter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Filter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static Filter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Filter) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Filter parseFrom(InputStream inputStream) throws IOException {
            return (Filter) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static Filter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Filter) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Filter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Filter) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Filter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Filter) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface FilterOrBuilder extends MessageLiteOrBuilder {
        CompositeFilter getCompositeFilter();

        FieldFilter getFieldFilter();

        Filter.FilterTypeCase getFilterTypeCase();

        UnaryFilter getUnaryFilter();

        boolean hasCompositeFilter();

        boolean hasFieldFilter();

        boolean hasUnaryFilter();
    }

    /* loaded from: classes5.dex */
    public static final class Order extends GeneratedMessageLite<Order, Builder> implements OrderOrBuilder {
        private static final Order DEFAULT_INSTANCE;
        public static final int DIRECTION_FIELD_NUMBER = 2;
        public static final int FIELD_FIELD_NUMBER = 1;
        private static volatile Parser<Order> PARSER;
        private int direction_;
        private FieldReference field_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Order, Builder> implements OrderOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearDirection() {
                f();
                ((Order) this.f33398b).m0();
                return this;
            }

            public Builder clearField() {
                f();
                ((Order) this.f33398b).n0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public Direction getDirection() {
                return ((Order) this.f33398b).getDirection();
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public int getDirectionValue() {
                return ((Order) this.f33398b).getDirectionValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public FieldReference getField() {
                return ((Order) this.f33398b).getField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
            public boolean hasField() {
                return ((Order) this.f33398b).hasField();
            }

            public Builder mergeField(FieldReference fieldReference) {
                f();
                ((Order) this.f33398b).o0(fieldReference);
                return this;
            }

            public Builder setDirection(Direction direction) {
                f();
                ((Order) this.f33398b).p0(direction);
                return this;
            }

            public Builder setDirectionValue(int i4) {
                f();
                ((Order) this.f33398b).q0(i4);
                return this;
            }

            public Builder setField(FieldReference fieldReference) {
                f();
                ((Order) this.f33398b).r0(fieldReference);
                return this;
            }

            private Builder() {
                super(Order.DEFAULT_INSTANCE);
            }

            public Builder setField(FieldReference.Builder builder) {
                f();
                ((Order) this.f33398b).r0(builder.build());
                return this;
            }
        }

        static {
            Order order = new Order();
            DEFAULT_INSTANCE = order;
            GeneratedMessageLite.d0(Order.class, order);
        }

        private Order() {
        }

        public static Order getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0() {
            this.direction_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0() {
            this.field_ = null;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(FieldReference fieldReference) {
            fieldReference.getClass();
            FieldReference fieldReference2 = this.field_;
            if (fieldReference2 != null && fieldReference2 != FieldReference.getDefaultInstance()) {
                this.field_ = FieldReference.newBuilder(this.field_).mergeFrom((FieldReference.Builder) fieldReference).buildPartial();
            } else {
                this.field_ = fieldReference;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0(Direction direction) {
            this.direction_ = direction.getNumber();
        }

        public static Order parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Order) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static Order parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Order> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(int i4) {
            this.direction_ = i4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(FieldReference fieldReference) {
            fieldReference.getClass();
            this.field_ = fieldReference;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public Direction getDirection() {
            Direction forNumber = Direction.forNumber(this.direction_);
            if (forNumber == null) {
                return Direction.UNRECOGNIZED;
            }
            return forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public int getDirectionValue() {
            return this.direction_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public FieldReference getField() {
            FieldReference fieldReference = this.field_;
            if (fieldReference == null) {
                return FieldReference.getDefaultInstance();
            }
            return fieldReference;
        }

        @Override // com.google.firestore.v1.StructuredQuery.OrderOrBuilder
        public boolean hasField() {
            if (this.field_ != null) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Order();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\f", new Object[]{"field_", "direction_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Order> parser = PARSER;
                    if (parser == null) {
                        synchronized (Order.class) {
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

        public static Builder newBuilder(Order order) {
            return DEFAULT_INSTANCE.r(order);
        }

        public static Order parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Order) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Order parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Order parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static Order parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Order parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static Order parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Order) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Order parseFrom(InputStream inputStream) throws IOException {
            return (Order) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static Order parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Order) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Order parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Order) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Order parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Order) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface OrderOrBuilder extends MessageLiteOrBuilder {
        Direction getDirection();

        int getDirectionValue();

        FieldReference getField();

        boolean hasField();
    }

    /* loaded from: classes5.dex */
    public static final class Projection extends GeneratedMessageLite<Projection, Builder> implements ProjectionOrBuilder {
        private static final Projection DEFAULT_INSTANCE;
        public static final int FIELDS_FIELD_NUMBER = 2;
        private static volatile Parser<Projection> PARSER;
        private Internal.ProtobufList<FieldReference> fields_ = GeneratedMessageLite.y();

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Projection, Builder> implements ProjectionOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder addAllFields(Iterable<? extends FieldReference> iterable) {
                f();
                ((Projection) this.f33398b).m0(iterable);
                return this;
            }

            public Builder addFields(FieldReference fieldReference) {
                f();
                ((Projection) this.f33398b).o0(fieldReference);
                return this;
            }

            public Builder clearFields() {
                f();
                ((Projection) this.f33398b).p0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
            public FieldReference getFields(int i4) {
                return ((Projection) this.f33398b).getFields(i4);
            }

            @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
            public int getFieldsCount() {
                return ((Projection) this.f33398b).getFieldsCount();
            }

            @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
            public List<FieldReference> getFieldsList() {
                return Collections.unmodifiableList(((Projection) this.f33398b).getFieldsList());
            }

            public Builder removeFields(int i4) {
                f();
                ((Projection) this.f33398b).r0(i4);
                return this;
            }

            public Builder setFields(int i4, FieldReference fieldReference) {
                f();
                ((Projection) this.f33398b).s0(i4, fieldReference);
                return this;
            }

            private Builder() {
                super(Projection.DEFAULT_INSTANCE);
            }

            public Builder addFields(int i4, FieldReference fieldReference) {
                f();
                ((Projection) this.f33398b).n0(i4, fieldReference);
                return this;
            }

            public Builder setFields(int i4, FieldReference.Builder builder) {
                f();
                ((Projection) this.f33398b).s0(i4, builder.build());
                return this;
            }

            public Builder addFields(FieldReference.Builder builder) {
                f();
                ((Projection) this.f33398b).o0(builder.build());
                return this;
            }

            public Builder addFields(int i4, FieldReference.Builder builder) {
                f();
                ((Projection) this.f33398b).n0(i4, builder.build());
                return this;
            }
        }

        static {
            Projection projection = new Projection();
            DEFAULT_INSTANCE = projection;
            GeneratedMessageLite.d0(Projection.class, projection);
        }

        private Projection() {
        }

        public static Projection getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void m0(Iterable<? extends FieldReference> iterable) {
            q0();
            AbstractMessageLite.a(iterable, this.fields_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0(int i4, FieldReference fieldReference) {
            fieldReference.getClass();
            q0();
            this.fields_.add(i4, fieldReference);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0(FieldReference fieldReference) {
            fieldReference.getClass();
            q0();
            this.fields_.add(fieldReference);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.fields_ = GeneratedMessageLite.y();
        }

        public static Projection parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Projection) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static Projection parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Projection> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        private void q0() {
            Internal.ProtobufList<FieldReference> protobufList = this.fields_;
            if (!protobufList.isModifiable()) {
                this.fields_ = GeneratedMessageLite.K(protobufList);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(int i4) {
            q0();
            this.fields_.remove(i4);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(int i4, FieldReference fieldReference) {
            fieldReference.getClass();
            q0();
            this.fields_.set(i4, fieldReference);
        }

        @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
        public FieldReference getFields(int i4) {
            return this.fields_.get(i4);
        }

        @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
        public int getFieldsCount() {
            return this.fields_.size();
        }

        @Override // com.google.firestore.v1.StructuredQuery.ProjectionOrBuilder
        public List<FieldReference> getFieldsList() {
            return this.fields_;
        }

        public FieldReferenceOrBuilder getFieldsOrBuilder(int i4) {
            return this.fields_.get(i4);
        }

        public List<? extends FieldReferenceOrBuilder> getFieldsOrBuilderList() {
            return this.fields_;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Projection();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0002\u0002\u0001\u0000\u0001\u0000\u0002\u001b", new Object[]{"fields_", FieldReference.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Projection> parser = PARSER;
                    if (parser == null) {
                        synchronized (Projection.class) {
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

        public static Builder newBuilder(Projection projection) {
            return DEFAULT_INSTANCE.r(projection);
        }

        public static Projection parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Projection) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Projection parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Projection parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static Projection parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Projection parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static Projection parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Projection) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Projection parseFrom(InputStream inputStream) throws IOException {
            return (Projection) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static Projection parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Projection) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Projection parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Projection) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Projection parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Projection) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface ProjectionOrBuilder extends MessageLiteOrBuilder {
        FieldReference getFields(int i4);

        int getFieldsCount();

        List<FieldReference> getFieldsList();
    }

    /* loaded from: classes5.dex */
    public static final class UnaryFilter extends GeneratedMessageLite<UnaryFilter, Builder> implements UnaryFilterOrBuilder {
        private static final UnaryFilter DEFAULT_INSTANCE;
        public static final int FIELD_FIELD_NUMBER = 2;
        public static final int OP_FIELD_NUMBER = 1;
        private static volatile Parser<UnaryFilter> PARSER;
        private int op_;
        private int operandTypeCase_ = 0;
        private Object operandType_;

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<UnaryFilter, Builder> implements UnaryFilterOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearField() {
                f();
                ((UnaryFilter) this.f33398b).n0();
                return this;
            }

            public Builder clearOp() {
                f();
                ((UnaryFilter) this.f33398b).o0();
                return this;
            }

            public Builder clearOperandType() {
                f();
                ((UnaryFilter) this.f33398b).p0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public FieldReference getField() {
                return ((UnaryFilter) this.f33398b).getField();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public Operator getOp() {
                return ((UnaryFilter) this.f33398b).getOp();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public int getOpValue() {
                return ((UnaryFilter) this.f33398b).getOpValue();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public OperandTypeCase getOperandTypeCase() {
                return ((UnaryFilter) this.f33398b).getOperandTypeCase();
            }

            @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
            public boolean hasField() {
                return ((UnaryFilter) this.f33398b).hasField();
            }

            public Builder mergeField(FieldReference fieldReference) {
                f();
                ((UnaryFilter) this.f33398b).q0(fieldReference);
                return this;
            }

            public Builder setField(FieldReference fieldReference) {
                f();
                ((UnaryFilter) this.f33398b).r0(fieldReference);
                return this;
            }

            public Builder setOp(Operator operator) {
                f();
                ((UnaryFilter) this.f33398b).s0(operator);
                return this;
            }

            public Builder setOpValue(int i4) {
                f();
                ((UnaryFilter) this.f33398b).t0(i4);
                return this;
            }

            private Builder() {
                super(UnaryFilter.DEFAULT_INSTANCE);
            }

            public Builder setField(FieldReference.Builder builder) {
                f();
                ((UnaryFilter) this.f33398b).r0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public enum OperandTypeCase {
            FIELD(2),
            OPERANDTYPE_NOT_SET(0);
            
            private final int value;

            OperandTypeCase(int i4) {
                this.value = i4;
            }

            public static OperandTypeCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 2) {
                        return null;
                    }
                    return FIELD;
                }
                return OPERANDTYPE_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OperandTypeCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public enum Operator implements Internal.EnumLite {
            OPERATOR_UNSPECIFIED(0),
            IS_NAN(2),
            IS_NULL(3),
            IS_NOT_NAN(4),
            IS_NOT_NULL(5),
            UNRECOGNIZED(-1);
            
            public static final int IS_NAN_VALUE = 2;
            public static final int IS_NOT_NAN_VALUE = 4;
            public static final int IS_NOT_NULL_VALUE = 5;
            public static final int IS_NULL_VALUE = 3;
            public static final int OPERATOR_UNSPECIFIED_VALUE = 0;

            /* renamed from: a  reason: collision with root package name */
            private static final Internal.EnumLiteMap<Operator> f32518a = new Internal.EnumLiteMap<Operator>() { // from class: com.google.firestore.v1.StructuredQuery.UnaryFilter.Operator.1
                @Override // com.google.protobuf.Internal.EnumLiteMap
                /* renamed from: a */
                public Operator findValueByNumber(int i4) {
                    return Operator.forNumber(i4);
                }
            };
            private final int value;

            /* loaded from: classes5.dex */
            private static final class OperatorVerifier implements Internal.EnumVerifier {

                /* renamed from: a  reason: collision with root package name */
                static final Internal.EnumVerifier f32520a = new OperatorVerifier();

                private OperatorVerifier() {
                }

                @Override // com.google.protobuf.Internal.EnumVerifier
                public boolean isInRange(int i4) {
                    if (Operator.forNumber(i4) != null) {
                        return true;
                    }
                    return false;
                }
            }

            Operator(int i4) {
                this.value = i4;
            }

            public static Operator forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 4) {
                                if (i4 != 5) {
                                    return null;
                                }
                                return IS_NOT_NULL;
                            }
                            return IS_NOT_NAN;
                        }
                        return IS_NULL;
                    }
                    return IS_NAN;
                }
                return OPERATOR_UNSPECIFIED;
            }

            public static Internal.EnumLiteMap<Operator> internalGetValueMap() {
                return f32518a;
            }

            public static Internal.EnumVerifier internalGetVerifier() {
                return OperatorVerifier.f32520a;
            }

            @Override // com.google.protobuf.Internal.EnumLite
            public final int getNumber() {
                if (this != UNRECOGNIZED) {
                    return this.value;
                }
                throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
            }

            @Deprecated
            public static Operator valueOf(int i4) {
                return forNumber(i4);
            }
        }

        static {
            UnaryFilter unaryFilter = new UnaryFilter();
            DEFAULT_INSTANCE = unaryFilter;
            GeneratedMessageLite.d0(UnaryFilter.class, unaryFilter);
        }

        private UnaryFilter() {
        }

        public static UnaryFilter getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void n0() {
            if (this.operandTypeCase_ == 2) {
                this.operandTypeCase_ = 0;
                this.operandType_ = null;
            }
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o0() {
            this.op_ = 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void p0() {
            this.operandTypeCase_ = 0;
            this.operandType_ = null;
        }

        public static UnaryFilter parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static UnaryFilter parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<UnaryFilter> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void q0(FieldReference fieldReference) {
            fieldReference.getClass();
            if (this.operandTypeCase_ == 2 && this.operandType_ != FieldReference.getDefaultInstance()) {
                this.operandType_ = FieldReference.newBuilder((FieldReference) this.operandType_).mergeFrom((FieldReference.Builder) fieldReference).buildPartial();
            } else {
                this.operandType_ = fieldReference;
            }
            this.operandTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void r0(FieldReference fieldReference) {
            fieldReference.getClass();
            this.operandType_ = fieldReference;
            this.operandTypeCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void s0(Operator operator) {
            this.op_ = operator.getNumber();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0(int i4) {
            this.op_ = i4;
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public FieldReference getField() {
            if (this.operandTypeCase_ == 2) {
                return (FieldReference) this.operandType_;
            }
            return FieldReference.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public Operator getOp() {
            Operator forNumber = Operator.forNumber(this.op_);
            if (forNumber == null) {
                return Operator.UNRECOGNIZED;
            }
            return forNumber;
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public int getOpValue() {
            return this.op_;
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public OperandTypeCase getOperandTypeCase() {
            return OperandTypeCase.forNumber(this.operandTypeCase_);
        }

        @Override // com.google.firestore.v1.StructuredQuery.UnaryFilterOrBuilder
        public boolean hasField() {
            if (this.operandTypeCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
                case 1:
                    return new UnaryFilter();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002<\u0000", new Object[]{"operandType_", "operandTypeCase_", "op_", FieldReference.class});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<UnaryFilter> parser = PARSER;
                    if (parser == null) {
                        synchronized (UnaryFilter.class) {
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

        public static Builder newBuilder(UnaryFilter unaryFilter) {
            return DEFAULT_INSTANCE.r(unaryFilter);
        }

        public static UnaryFilter parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static UnaryFilter parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static UnaryFilter parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (UnaryFilter) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(InputStream inputStream) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static UnaryFilter parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static UnaryFilter parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static UnaryFilter parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (UnaryFilter) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface UnaryFilterOrBuilder extends MessageLiteOrBuilder {
        FieldReference getField();

        UnaryFilter.Operator getOp();

        int getOpValue();

        UnaryFilter.OperandTypeCase getOperandTypeCase();

        boolean hasField();
    }

    static {
        StructuredQuery structuredQuery = new StructuredQuery();
        DEFAULT_INSTANCE = structuredQuery;
        GeneratedMessageLite.d0(StructuredQuery.class, structuredQuery);
    }

    private StructuredQuery() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0(Iterable<? extends CollectionSelector> iterable) {
        X0();
        AbstractMessageLite.a(iterable, this.from_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0(Iterable<? extends Order> iterable) {
        Y0();
        AbstractMessageLite.a(iterable, this.orderBy_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(int i4, CollectionSelector collectionSelector) {
        collectionSelector.getClass();
        X0();
        this.from_.add(i4, collectionSelector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0(CollectionSelector collectionSelector) {
        collectionSelector.getClass();
        X0();
        this.from_.add(collectionSelector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0(int i4, Order order) {
        order.getClass();
        Y0();
        this.orderBy_.add(i4, order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(Order order) {
        order.getClass();
        Y0();
        this.orderBy_.add(order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        this.endAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        this.from_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        this.limit_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        this.offset_ = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        this.orderBy_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        this.select_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        this.startAt_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0() {
        this.where_ = null;
    }

    private void X0() {
        Internal.ProtobufList<CollectionSelector> protobufList = this.from_;
        if (!protobufList.isModifiable()) {
            this.from_ = GeneratedMessageLite.K(protobufList);
        }
    }

    private void Y0() {
        Internal.ProtobufList<Order> protobufList = this.orderBy_;
        if (!protobufList.isModifiable()) {
            this.orderBy_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(Cursor cursor) {
        cursor.getClass();
        Cursor cursor2 = this.endAt_;
        if (cursor2 != null && cursor2 != Cursor.getDefaultInstance()) {
            this.endAt_ = Cursor.newBuilder(this.endAt_).mergeFrom((Cursor.Builder) cursor).buildPartial();
        } else {
            this.endAt_ = cursor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(Int32Value int32Value) {
        int32Value.getClass();
        Int32Value int32Value2 = this.limit_;
        if (int32Value2 != null && int32Value2 != Int32Value.getDefaultInstance()) {
            this.limit_ = Int32Value.newBuilder(this.limit_).mergeFrom((Int32Value.Builder) int32Value).buildPartial();
        } else {
            this.limit_ = int32Value;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(Projection projection) {
        projection.getClass();
        Projection projection2 = this.select_;
        if (projection2 != null && projection2 != Projection.getDefaultInstance()) {
            this.select_ = Projection.newBuilder(this.select_).mergeFrom((Projection.Builder) projection).buildPartial();
        } else {
            this.select_ = projection;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(Cursor cursor) {
        cursor.getClass();
        Cursor cursor2 = this.startAt_;
        if (cursor2 != null && cursor2 != Cursor.getDefaultInstance()) {
            this.startAt_ = Cursor.newBuilder(this.startAt_).mergeFrom((Cursor.Builder) cursor).buildPartial();
        } else {
            this.startAt_ = cursor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(Filter filter) {
        filter.getClass();
        Filter filter2 = this.where_;
        if (filter2 != null && filter2 != Filter.getDefaultInstance()) {
            this.where_ = Filter.newBuilder(this.where_).mergeFrom((Filter.Builder) filter).buildPartial();
        } else {
            this.where_ = filter;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(int i4) {
        X0();
        this.from_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(int i4) {
        Y0();
        this.orderBy_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(Cursor cursor) {
        cursor.getClass();
        this.endAt_ = cursor;
    }

    public static StructuredQuery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(int i4, CollectionSelector collectionSelector) {
        collectionSelector.getClass();
        X0();
        this.from_.set(i4, collectionSelector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(Int32Value int32Value) {
        int32Value.getClass();
        this.limit_ = int32Value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(int i4) {
        this.offset_ = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(int i4, Order order) {
        order.getClass();
        Y0();
        this.orderBy_.set(i4, order);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(Projection projection) {
        projection.getClass();
        this.select_ = projection;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(Cursor cursor) {
        cursor.getClass();
        this.startAt_ = cursor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(Filter filter) {
        filter.getClass();
        this.where_ = filter;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static StructuredQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static StructuredQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StructuredQuery> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Cursor getEndAt() {
        Cursor cursor = this.endAt_;
        if (cursor == null) {
            return Cursor.getDefaultInstance();
        }
        return cursor;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public CollectionSelector getFrom(int i4) {
        return this.from_.get(i4);
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public int getFromCount() {
        return this.from_.size();
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public List<CollectionSelector> getFromList() {
        return this.from_;
    }

    public CollectionSelectorOrBuilder getFromOrBuilder(int i4) {
        return this.from_.get(i4);
    }

    public List<? extends CollectionSelectorOrBuilder> getFromOrBuilderList() {
        return this.from_;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Int32Value getLimit() {
        Int32Value int32Value = this.limit_;
        if (int32Value == null) {
            return Int32Value.getDefaultInstance();
        }
        return int32Value;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public int getOffset() {
        return this.offset_;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Order getOrderBy(int i4) {
        return this.orderBy_.get(i4);
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public int getOrderByCount() {
        return this.orderBy_.size();
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public List<Order> getOrderByList() {
        return this.orderBy_;
    }

    public OrderOrBuilder getOrderByOrBuilder(int i4) {
        return this.orderBy_.get(i4);
    }

    public List<? extends OrderOrBuilder> getOrderByOrBuilderList() {
        return this.orderBy_;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Projection getSelect() {
        Projection projection = this.select_;
        if (projection == null) {
            return Projection.getDefaultInstance();
        }
        return projection;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Cursor getStartAt() {
        Cursor cursor = this.startAt_;
        if (cursor == null) {
            return Cursor.getDefaultInstance();
        }
        return cursor;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public Filter getWhere() {
        Filter filter = this.where_;
        if (filter == null) {
            return Filter.getDefaultInstance();
        }
        return filter;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasEndAt() {
        if (this.endAt_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasLimit() {
        if (this.limit_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasSelect() {
        if (this.select_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasStartAt() {
        if (this.startAt_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.StructuredQueryOrBuilder
    public boolean hasWhere() {
        if (this.where_ != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32506a[methodToInvoke.ordinal()]) {
            case 1:
                return new StructuredQuery();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0002\u0000\u0001\t\u0002\u001b\u0003\t\u0004\u001b\u0005\t\u0006\u0004\u0007\t\b\t", new Object[]{"select_", "from_", CollectionSelector.class, "where_", "orderBy_", Order.class, "limit_", "offset_", "startAt_", "endAt_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StructuredQuery> parser = PARSER;
                if (parser == null) {
                    synchronized (StructuredQuery.class) {
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

    public static Builder newBuilder(StructuredQuery structuredQuery) {
        return DEFAULT_INSTANCE.r(structuredQuery);
    }

    public static StructuredQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static StructuredQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static StructuredQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StructuredQuery) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(InputStream inputStream) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static StructuredQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StructuredQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StructuredQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StructuredQuery) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
