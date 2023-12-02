package com.google.firestore.v1;

import com.google.firestore.v1.StructuredQuery;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.Int64Value;
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
public final class StructuredAggregationQuery extends GeneratedMessageLite<StructuredAggregationQuery, Builder> implements StructuredAggregationQueryOrBuilder {
    public static final int AGGREGATIONS_FIELD_NUMBER = 3;
    private static final StructuredAggregationQuery DEFAULT_INSTANCE;
    private static volatile Parser<StructuredAggregationQuery> PARSER = null;
    public static final int STRUCTURED_QUERY_FIELD_NUMBER = 1;
    private Object queryType_;
    private int queryTypeCase_ = 0;
    private Internal.ProtobufList<Aggregation> aggregations_ = GeneratedMessageLite.y();

    /* renamed from: com.google.firestore.v1.StructuredAggregationQuery$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32503a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32503a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32503a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32503a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32503a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32503a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32503a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32503a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Aggregation extends GeneratedMessageLite<Aggregation, Builder> implements AggregationOrBuilder {
        public static final int ALIAS_FIELD_NUMBER = 7;
        public static final int AVG_FIELD_NUMBER = 3;
        public static final int COUNT_FIELD_NUMBER = 1;
        private static final Aggregation DEFAULT_INSTANCE;
        private static volatile Parser<Aggregation> PARSER = null;
        public static final int SUM_FIELD_NUMBER = 2;
        private Object operator_;
        private int operatorCase_ = 0;
        private String alias_ = "";

        /* loaded from: classes5.dex */
        public static final class Avg extends GeneratedMessageLite<Avg, Builder> implements AvgOrBuilder {
            private static final Avg DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile Parser<Avg> PARSER;
            private StructuredQuery.FieldReference field_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Avg, Builder> implements AvgOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearField() {
                    f();
                    ((Avg) this.f33398b).j0();
                    return this;
                }

                @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.AvgOrBuilder
                public StructuredQuery.FieldReference getField() {
                    return ((Avg) this.f33398b).getField();
                }

                @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.AvgOrBuilder
                public boolean hasField() {
                    return ((Avg) this.f33398b).hasField();
                }

                public Builder mergeField(StructuredQuery.FieldReference fieldReference) {
                    f();
                    ((Avg) this.f33398b).k0(fieldReference);
                    return this;
                }

                public Builder setField(StructuredQuery.FieldReference fieldReference) {
                    f();
                    ((Avg) this.f33398b).l0(fieldReference);
                    return this;
                }

                private Builder() {
                    super(Avg.DEFAULT_INSTANCE);
                }

                public Builder setField(StructuredQuery.FieldReference.Builder builder) {
                    f();
                    ((Avg) this.f33398b).l0(builder.build());
                    return this;
                }
            }

            static {
                Avg avg = new Avg();
                DEFAULT_INSTANCE = avg;
                GeneratedMessageLite.d0(Avg.class, avg);
            }

            private Avg() {
            }

            public static Avg getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void j0() {
                this.field_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void k0(StructuredQuery.FieldReference fieldReference) {
                fieldReference.getClass();
                StructuredQuery.FieldReference fieldReference2 = this.field_;
                if (fieldReference2 != null && fieldReference2 != StructuredQuery.FieldReference.getDefaultInstance()) {
                    this.field_ = StructuredQuery.FieldReference.newBuilder(this.field_).mergeFrom((StructuredQuery.FieldReference.Builder) fieldReference).buildPartial();
                } else {
                    this.field_ = fieldReference;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l0(StructuredQuery.FieldReference fieldReference) {
                fieldReference.getClass();
                this.field_ = fieldReference;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static Avg parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Avg) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Avg parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Avg) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Avg> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.AvgOrBuilder
            public StructuredQuery.FieldReference getField() {
                StructuredQuery.FieldReference fieldReference = this.field_;
                if (fieldReference == null) {
                    return StructuredQuery.FieldReference.getDefaultInstance();
                }
                return fieldReference;
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.AvgOrBuilder
            public boolean hasField() {
                if (this.field_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f32503a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Avg();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Avg> parser = PARSER;
                        if (parser == null) {
                            synchronized (Avg.class) {
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

            public static Builder newBuilder(Avg avg) {
                return DEFAULT_INSTANCE.r(avg);
            }

            public static Avg parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Avg) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Avg parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Avg) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Avg parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Avg) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Avg parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Avg) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Avg parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Avg) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Avg parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Avg) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Avg parseFrom(InputStream inputStream) throws IOException {
                return (Avg) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Avg parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Avg) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Avg parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Avg) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Avg parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Avg) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface AvgOrBuilder extends MessageLiteOrBuilder {
            StructuredQuery.FieldReference getField();

            boolean hasField();
        }

        /* loaded from: classes5.dex */
        public static final class Builder extends GeneratedMessageLite.Builder<Aggregation, Builder> implements AggregationOrBuilder {
            /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                this();
            }

            public Builder clearAlias() {
                f();
                ((Aggregation) this.f33398b).t0();
                return this;
            }

            public Builder clearAvg() {
                f();
                ((Aggregation) this.f33398b).u0();
                return this;
            }

            public Builder clearCount() {
                f();
                ((Aggregation) this.f33398b).v0();
                return this;
            }

            public Builder clearOperator() {
                f();
                ((Aggregation) this.f33398b).w0();
                return this;
            }

            public Builder clearSum() {
                f();
                ((Aggregation) this.f33398b).x0();
                return this;
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public String getAlias() {
                return ((Aggregation) this.f33398b).getAlias();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public ByteString getAliasBytes() {
                return ((Aggregation) this.f33398b).getAliasBytes();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public Avg getAvg() {
                return ((Aggregation) this.f33398b).getAvg();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public Count getCount() {
                return ((Aggregation) this.f33398b).getCount();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public OperatorCase getOperatorCase() {
                return ((Aggregation) this.f33398b).getOperatorCase();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public Sum getSum() {
                return ((Aggregation) this.f33398b).getSum();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public boolean hasAvg() {
                return ((Aggregation) this.f33398b).hasAvg();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public boolean hasCount() {
                return ((Aggregation) this.f33398b).hasCount();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
            public boolean hasSum() {
                return ((Aggregation) this.f33398b).hasSum();
            }

            public Builder mergeAvg(Avg avg) {
                f();
                ((Aggregation) this.f33398b).y0(avg);
                return this;
            }

            public Builder mergeCount(Count count) {
                f();
                ((Aggregation) this.f33398b).z0(count);
                return this;
            }

            public Builder mergeSum(Sum sum) {
                f();
                ((Aggregation) this.f33398b).A0(sum);
                return this;
            }

            public Builder setAlias(String str) {
                f();
                ((Aggregation) this.f33398b).B0(str);
                return this;
            }

            public Builder setAliasBytes(ByteString byteString) {
                f();
                ((Aggregation) this.f33398b).C0(byteString);
                return this;
            }

            public Builder setAvg(Avg avg) {
                f();
                ((Aggregation) this.f33398b).D0(avg);
                return this;
            }

            public Builder setCount(Count count) {
                f();
                ((Aggregation) this.f33398b).E0(count);
                return this;
            }

            public Builder setSum(Sum sum) {
                f();
                ((Aggregation) this.f33398b).F0(sum);
                return this;
            }

            private Builder() {
                super(Aggregation.DEFAULT_INSTANCE);
            }

            public Builder setAvg(Avg.Builder builder) {
                f();
                ((Aggregation) this.f33398b).D0(builder.build());
                return this;
            }

            public Builder setCount(Count.Builder builder) {
                f();
                ((Aggregation) this.f33398b).E0(builder.build());
                return this;
            }

            public Builder setSum(Sum.Builder builder) {
                f();
                ((Aggregation) this.f33398b).F0(builder.build());
                return this;
            }
        }

        /* loaded from: classes5.dex */
        public static final class Count extends GeneratedMessageLite<Count, Builder> implements CountOrBuilder {
            private static final Count DEFAULT_INSTANCE;
            private static volatile Parser<Count> PARSER = null;
            public static final int UP_TO_FIELD_NUMBER = 1;
            private Int64Value upTo_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Count, Builder> implements CountOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearUpTo() {
                    f();
                    ((Count) this.f33398b).j0();
                    return this;
                }

                @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.CountOrBuilder
                public Int64Value getUpTo() {
                    return ((Count) this.f33398b).getUpTo();
                }

                @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.CountOrBuilder
                public boolean hasUpTo() {
                    return ((Count) this.f33398b).hasUpTo();
                }

                public Builder mergeUpTo(Int64Value int64Value) {
                    f();
                    ((Count) this.f33398b).k0(int64Value);
                    return this;
                }

                public Builder setUpTo(Int64Value int64Value) {
                    f();
                    ((Count) this.f33398b).l0(int64Value);
                    return this;
                }

                private Builder() {
                    super(Count.DEFAULT_INSTANCE);
                }

                public Builder setUpTo(Int64Value.Builder builder) {
                    f();
                    ((Count) this.f33398b).l0(builder.build());
                    return this;
                }
            }

            static {
                Count count = new Count();
                DEFAULT_INSTANCE = count;
                GeneratedMessageLite.d0(Count.class, count);
            }

            private Count() {
            }

            public static Count getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void j0() {
                this.upTo_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void k0(Int64Value int64Value) {
                int64Value.getClass();
                Int64Value int64Value2 = this.upTo_;
                if (int64Value2 != null && int64Value2 != Int64Value.getDefaultInstance()) {
                    this.upTo_ = Int64Value.newBuilder(this.upTo_).mergeFrom((Int64Value.Builder) int64Value).buildPartial();
                } else {
                    this.upTo_ = int64Value;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l0(Int64Value int64Value) {
                int64Value.getClass();
                this.upTo_ = int64Value;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static Count parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Count) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Count parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Count) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Count> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.CountOrBuilder
            public Int64Value getUpTo() {
                Int64Value int64Value = this.upTo_;
                if (int64Value == null) {
                    return Int64Value.getDefaultInstance();
                }
                return int64Value;
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.CountOrBuilder
            public boolean hasUpTo() {
                if (this.upTo_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f32503a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Count();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"upTo_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Count> parser = PARSER;
                        if (parser == null) {
                            synchronized (Count.class) {
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

            public static Builder newBuilder(Count count) {
                return DEFAULT_INSTANCE.r(count);
            }

            public static Count parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Count) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Count parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Count) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Count parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Count) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Count parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Count) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Count parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Count) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Count parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Count) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Count parseFrom(InputStream inputStream) throws IOException {
                return (Count) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Count parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Count) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Count parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Count) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Count parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Count) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface CountOrBuilder extends MessageLiteOrBuilder {
            Int64Value getUpTo();

            boolean hasUpTo();
        }

        /* loaded from: classes5.dex */
        public enum OperatorCase {
            COUNT(1),
            SUM(2),
            AVG(3),
            OPERATOR_NOT_SET(0);
            
            private final int value;

            OperatorCase(int i4) {
                this.value = i4;
            }

            public static OperatorCase forNumber(int i4) {
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (i4 != 2) {
                            if (i4 != 3) {
                                return null;
                            }
                            return AVG;
                        }
                        return SUM;
                    }
                    return COUNT;
                }
                return OPERATOR_NOT_SET;
            }

            public int getNumber() {
                return this.value;
            }

            @Deprecated
            public static OperatorCase valueOf(int i4) {
                return forNumber(i4);
            }
        }

        /* loaded from: classes5.dex */
        public static final class Sum extends GeneratedMessageLite<Sum, Builder> implements SumOrBuilder {
            private static final Sum DEFAULT_INSTANCE;
            public static final int FIELD_FIELD_NUMBER = 1;
            private static volatile Parser<Sum> PARSER;
            private StructuredQuery.FieldReference field_;

            /* loaded from: classes5.dex */
            public static final class Builder extends GeneratedMessageLite.Builder<Sum, Builder> implements SumOrBuilder {
                /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
                    this();
                }

                public Builder clearField() {
                    f();
                    ((Sum) this.f33398b).j0();
                    return this;
                }

                @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.SumOrBuilder
                public StructuredQuery.FieldReference getField() {
                    return ((Sum) this.f33398b).getField();
                }

                @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.SumOrBuilder
                public boolean hasField() {
                    return ((Sum) this.f33398b).hasField();
                }

                public Builder mergeField(StructuredQuery.FieldReference fieldReference) {
                    f();
                    ((Sum) this.f33398b).k0(fieldReference);
                    return this;
                }

                public Builder setField(StructuredQuery.FieldReference fieldReference) {
                    f();
                    ((Sum) this.f33398b).l0(fieldReference);
                    return this;
                }

                private Builder() {
                    super(Sum.DEFAULT_INSTANCE);
                }

                public Builder setField(StructuredQuery.FieldReference.Builder builder) {
                    f();
                    ((Sum) this.f33398b).l0(builder.build());
                    return this;
                }
            }

            static {
                Sum sum = new Sum();
                DEFAULT_INSTANCE = sum;
                GeneratedMessageLite.d0(Sum.class, sum);
            }

            private Sum() {
            }

            public static Sum getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void j0() {
                this.field_ = null;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void k0(StructuredQuery.FieldReference fieldReference) {
                fieldReference.getClass();
                StructuredQuery.FieldReference fieldReference2 = this.field_;
                if (fieldReference2 != null && fieldReference2 != StructuredQuery.FieldReference.getDefaultInstance()) {
                    this.field_ = StructuredQuery.FieldReference.newBuilder(this.field_).mergeFrom((StructuredQuery.FieldReference.Builder) fieldReference).buildPartial();
                } else {
                    this.field_ = fieldReference;
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void l0(StructuredQuery.FieldReference fieldReference) {
                fieldReference.getClass();
                this.field_ = fieldReference;
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.q();
            }

            public static Sum parseDelimitedFrom(InputStream inputStream) throws IOException {
                return (Sum) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
            }

            public static Sum parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
                return (Sum) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
            }

            public static Parser<Sum> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.SumOrBuilder
            public StructuredQuery.FieldReference getField() {
                StructuredQuery.FieldReference fieldReference = this.field_;
                if (fieldReference == null) {
                    return StructuredQuery.FieldReference.getDefaultInstance();
                }
                return fieldReference;
            }

            @Override // com.google.firestore.v1.StructuredAggregationQuery.Aggregation.SumOrBuilder
            public boolean hasField() {
                if (this.field_ != null) {
                    return true;
                }
                return false;
            }

            @Override // com.google.protobuf.GeneratedMessageLite
            protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
                switch (AnonymousClass1.f32503a[methodToInvoke.ordinal()]) {
                    case 1:
                        return new Sum();
                    case 2:
                        return new Builder(null);
                    case 3:
                        return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"field_"});
                    case 4:
                        return DEFAULT_INSTANCE;
                    case 5:
                        Parser<Sum> parser = PARSER;
                        if (parser == null) {
                            synchronized (Sum.class) {
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

            public static Builder newBuilder(Sum sum) {
                return DEFAULT_INSTANCE.r(sum);
            }

            public static Sum parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Sum) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Sum parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Sum) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
            }

            public static Sum parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return (Sum) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
            }

            public static Sum parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Sum) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
            }

            public static Sum parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
                return (Sum) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
            }

            public static Sum parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return (Sum) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
            }

            public static Sum parseFrom(InputStream inputStream) throws IOException {
                return (Sum) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
            }

            public static Sum parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Sum) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
            }

            public static Sum parseFrom(CodedInputStream codedInputStream) throws IOException {
                return (Sum) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
            }

            public static Sum parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return (Sum) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes5.dex */
        public interface SumOrBuilder extends MessageLiteOrBuilder {
            StructuredQuery.FieldReference getField();

            boolean hasField();
        }

        static {
            Aggregation aggregation = new Aggregation();
            DEFAULT_INSTANCE = aggregation;
            GeneratedMessageLite.d0(Aggregation.class, aggregation);
        }

        private Aggregation() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void A0(Sum sum) {
            sum.getClass();
            if (this.operatorCase_ == 2 && this.operator_ != Sum.getDefaultInstance()) {
                this.operator_ = Sum.newBuilder((Sum) this.operator_).mergeFrom((Sum.Builder) sum).buildPartial();
            } else {
                this.operator_ = sum;
            }
            this.operatorCase_ = 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void B0(String str) {
            str.getClass();
            this.alias_ = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void C0(ByteString byteString) {
            AbstractMessageLite.b(byteString);
            this.alias_ = byteString.toStringUtf8();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void D0(Avg avg) {
            avg.getClass();
            this.operator_ = avg;
            this.operatorCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void E0(Count count) {
            count.getClass();
            this.operator_ = count;
            this.operatorCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void F0(Sum sum) {
            sum.getClass();
            this.operator_ = sum;
            this.operatorCase_ = 2;
        }

        public static Aggregation getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.q();
        }

        public static Aggregation parseDelimitedFrom(InputStream inputStream) throws IOException {
            return (Aggregation) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
        }

        public static Aggregation parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
            return (Aggregation) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
        }

        public static Parser<Aggregation> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void t0() {
            this.alias_ = getDefaultInstance().getAlias();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void u0() {
            if (this.operatorCase_ == 3) {
                this.operatorCase_ = 0;
                this.operator_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void v0() {
            if (this.operatorCase_ == 1) {
                this.operatorCase_ = 0;
                this.operator_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void w0() {
            this.operatorCase_ = 0;
            this.operator_ = null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void x0() {
            if (this.operatorCase_ == 2) {
                this.operatorCase_ = 0;
                this.operator_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void y0(Avg avg) {
            avg.getClass();
            if (this.operatorCase_ == 3 && this.operator_ != Avg.getDefaultInstance()) {
                this.operator_ = Avg.newBuilder((Avg) this.operator_).mergeFrom((Avg.Builder) avg).buildPartial();
            } else {
                this.operator_ = avg;
            }
            this.operatorCase_ = 3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void z0(Count count) {
            count.getClass();
            if (this.operatorCase_ == 1 && this.operator_ != Count.getDefaultInstance()) {
                this.operator_ = Count.newBuilder((Count) this.operator_).mergeFrom((Count.Builder) count).buildPartial();
            } else {
                this.operator_ = count;
            }
            this.operatorCase_ = 1;
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public String getAlias() {
            return this.alias_;
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public ByteString getAliasBytes() {
            return ByteString.copyFromUtf8(this.alias_);
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public Avg getAvg() {
            if (this.operatorCase_ == 3) {
                return (Avg) this.operator_;
            }
            return Avg.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public Count getCount() {
            if (this.operatorCase_ == 1) {
                return (Count) this.operator_;
            }
            return Count.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public OperatorCase getOperatorCase() {
            return OperatorCase.forNumber(this.operatorCase_);
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public Sum getSum() {
            if (this.operatorCase_ == 2) {
                return (Sum) this.operator_;
            }
            return Sum.getDefaultInstance();
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public boolean hasAvg() {
            if (this.operatorCase_ == 3) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public boolean hasCount() {
            if (this.operatorCase_ == 1) {
                return true;
            }
            return false;
        }

        @Override // com.google.firestore.v1.StructuredAggregationQuery.AggregationOrBuilder
        public boolean hasSum() {
            if (this.operatorCase_ == 2) {
                return true;
            }
            return false;
        }

        @Override // com.google.protobuf.GeneratedMessageLite
        protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
            switch (AnonymousClass1.f32503a[methodToInvoke.ordinal()]) {
                case 1:
                    return new Aggregation();
                case 2:
                    return new Builder(null);
                case 3:
                    return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0004\u0001\u0000\u0001\u0007\u0004\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0007Ȉ", new Object[]{"operator_", "operatorCase_", Count.class, Sum.class, Avg.class, "alias_"});
                case 4:
                    return DEFAULT_INSTANCE;
                case 5:
                    Parser<Aggregation> parser = PARSER;
                    if (parser == null) {
                        synchronized (Aggregation.class) {
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

        public static Builder newBuilder(Aggregation aggregation) {
            return DEFAULT_INSTANCE.r(aggregation);
        }

        public static Aggregation parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aggregation) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Aggregation parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Aggregation) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
        }

        public static Aggregation parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return (Aggregation) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
        }

        public static Aggregation parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Aggregation) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
        }

        public static Aggregation parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return (Aggregation) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
        }

        public static Aggregation parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return (Aggregation) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
        }

        public static Aggregation parseFrom(InputStream inputStream) throws IOException {
            return (Aggregation) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
        }

        public static Aggregation parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aggregation) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
        }

        public static Aggregation parseFrom(CodedInputStream codedInputStream) throws IOException {
            return (Aggregation) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
        }

        public static Aggregation parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return (Aggregation) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes5.dex */
    public interface AggregationOrBuilder extends MessageLiteOrBuilder {
        String getAlias();

        ByteString getAliasBytes();

        Aggregation.Avg getAvg();

        Aggregation.Count getCount();

        Aggregation.OperatorCase getOperatorCase();

        Aggregation.Sum getSum();

        boolean hasAvg();

        boolean hasCount();

        boolean hasSum();
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<StructuredAggregationQuery, Builder> implements StructuredAggregationQueryOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder addAggregations(Aggregation aggregation) {
            f();
            ((StructuredAggregationQuery) this.f33398b).r0(aggregation);
            return this;
        }

        public Builder addAllAggregations(Iterable<? extends Aggregation> iterable) {
            f();
            ((StructuredAggregationQuery) this.f33398b).s0(iterable);
            return this;
        }

        public Builder clearAggregations() {
            f();
            ((StructuredAggregationQuery) this.f33398b).t0();
            return this;
        }

        public Builder clearQueryType() {
            f();
            ((StructuredAggregationQuery) this.f33398b).u0();
            return this;
        }

        public Builder clearStructuredQuery() {
            f();
            ((StructuredAggregationQuery) this.f33398b).v0();
            return this;
        }

        @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
        public Aggregation getAggregations(int i4) {
            return ((StructuredAggregationQuery) this.f33398b).getAggregations(i4);
        }

        @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
        public int getAggregationsCount() {
            return ((StructuredAggregationQuery) this.f33398b).getAggregationsCount();
        }

        @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
        public List<Aggregation> getAggregationsList() {
            return Collections.unmodifiableList(((StructuredAggregationQuery) this.f33398b).getAggregationsList());
        }

        @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
        public QueryTypeCase getQueryTypeCase() {
            return ((StructuredAggregationQuery) this.f33398b).getQueryTypeCase();
        }

        @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
        public StructuredQuery getStructuredQuery() {
            return ((StructuredAggregationQuery) this.f33398b).getStructuredQuery();
        }

        @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
        public boolean hasStructuredQuery() {
            return ((StructuredAggregationQuery) this.f33398b).hasStructuredQuery();
        }

        public Builder mergeStructuredQuery(StructuredQuery structuredQuery) {
            f();
            ((StructuredAggregationQuery) this.f33398b).x0(structuredQuery);
            return this;
        }

        public Builder removeAggregations(int i4) {
            f();
            ((StructuredAggregationQuery) this.f33398b).y0(i4);
            return this;
        }

        public Builder setAggregations(int i4, Aggregation aggregation) {
            f();
            ((StructuredAggregationQuery) this.f33398b).z0(i4, aggregation);
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery structuredQuery) {
            f();
            ((StructuredAggregationQuery) this.f33398b).A0(structuredQuery);
            return this;
        }

        private Builder() {
            super(StructuredAggregationQuery.DEFAULT_INSTANCE);
        }

        public Builder addAggregations(int i4, Aggregation aggregation) {
            f();
            ((StructuredAggregationQuery) this.f33398b).q0(i4, aggregation);
            return this;
        }

        public Builder setAggregations(int i4, Aggregation.Builder builder) {
            f();
            ((StructuredAggregationQuery) this.f33398b).z0(i4, builder.build());
            return this;
        }

        public Builder setStructuredQuery(StructuredQuery.Builder builder) {
            f();
            ((StructuredAggregationQuery) this.f33398b).A0(builder.build());
            return this;
        }

        public Builder addAggregations(Aggregation.Builder builder) {
            f();
            ((StructuredAggregationQuery) this.f33398b).r0(builder.build());
            return this;
        }

        public Builder addAggregations(int i4, Aggregation.Builder builder) {
            f();
            ((StructuredAggregationQuery) this.f33398b).q0(i4, builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum QueryTypeCase {
        STRUCTURED_QUERY(1),
        QUERYTYPE_NOT_SET(0);
        
        private final int value;

        QueryTypeCase(int i4) {
            this.value = i4;
        }

        public static QueryTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
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
        StructuredAggregationQuery structuredAggregationQuery = new StructuredAggregationQuery();
        DEFAULT_INSTANCE = structuredAggregationQuery;
        GeneratedMessageLite.d0(StructuredAggregationQuery.class, structuredAggregationQuery);
    }

    private StructuredAggregationQuery() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0(StructuredQuery structuredQuery) {
        structuredQuery.getClass();
        this.queryType_ = structuredQuery;
        this.queryTypeCase_ = 1;
    }

    public static StructuredAggregationQuery getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static StructuredAggregationQuery parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (StructuredAggregationQuery) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static StructuredAggregationQuery parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (StructuredAggregationQuery) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<StructuredAggregationQuery> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q0(int i4, Aggregation aggregation) {
        aggregation.getClass();
        w0();
        this.aggregations_.add(i4, aggregation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r0(Aggregation aggregation) {
        aggregation.getClass();
        w0();
        this.aggregations_.add(aggregation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s0(Iterable<? extends Aggregation> iterable) {
        w0();
        AbstractMessageLite.a(iterable, this.aggregations_);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t0() {
        this.aggregations_ = GeneratedMessageLite.y();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u0() {
        this.queryTypeCase_ = 0;
        this.queryType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v0() {
        if (this.queryTypeCase_ == 1) {
            this.queryTypeCase_ = 0;
            this.queryType_ = null;
        }
    }

    private void w0() {
        Internal.ProtobufList<Aggregation> protobufList = this.aggregations_;
        if (!protobufList.isModifiable()) {
            this.aggregations_ = GeneratedMessageLite.K(protobufList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(StructuredQuery structuredQuery) {
        structuredQuery.getClass();
        if (this.queryTypeCase_ == 1 && this.queryType_ != StructuredQuery.getDefaultInstance()) {
            this.queryType_ = StructuredQuery.newBuilder((StructuredQuery) this.queryType_).mergeFrom((StructuredQuery.Builder) structuredQuery).buildPartial();
        } else {
            this.queryType_ = structuredQuery;
        }
        this.queryTypeCase_ = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0(int i4) {
        w0();
        this.aggregations_.remove(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0(int i4, Aggregation aggregation) {
        aggregation.getClass();
        w0();
        this.aggregations_.set(i4, aggregation);
    }

    @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
    public Aggregation getAggregations(int i4) {
        return this.aggregations_.get(i4);
    }

    @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
    public int getAggregationsCount() {
        return this.aggregations_.size();
    }

    @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
    public List<Aggregation> getAggregationsList() {
        return this.aggregations_;
    }

    public AggregationOrBuilder getAggregationsOrBuilder(int i4) {
        return this.aggregations_.get(i4);
    }

    public List<? extends AggregationOrBuilder> getAggregationsOrBuilderList() {
        return this.aggregations_;
    }

    @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
    public QueryTypeCase getQueryTypeCase() {
        return QueryTypeCase.forNumber(this.queryTypeCase_);
    }

    @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
    public StructuredQuery getStructuredQuery() {
        if (this.queryTypeCase_ == 1) {
            return (StructuredQuery) this.queryType_;
        }
        return StructuredQuery.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.StructuredAggregationQueryOrBuilder
    public boolean hasStructuredQuery() {
        if (this.queryTypeCase_ == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32503a[methodToInvoke.ordinal()]) {
            case 1:
                return new StructuredAggregationQuery();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u0002\u0001\u0000\u0001\u0003\u0002\u0000\u0001\u0000\u0001<\u0000\u0003\u001b", new Object[]{"queryType_", "queryTypeCase_", StructuredQuery.class, "aggregations_", Aggregation.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<StructuredAggregationQuery> parser = PARSER;
                if (parser == null) {
                    synchronized (StructuredAggregationQuery.class) {
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

    public static Builder newBuilder(StructuredAggregationQuery structuredAggregationQuery) {
        return DEFAULT_INSTANCE.r(structuredAggregationQuery);
    }

    public static StructuredAggregationQuery parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StructuredAggregationQuery) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StructuredAggregationQuery parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StructuredAggregationQuery) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static StructuredAggregationQuery parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (StructuredAggregationQuery) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static StructuredAggregationQuery parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StructuredAggregationQuery) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static StructuredAggregationQuery parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (StructuredAggregationQuery) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static StructuredAggregationQuery parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (StructuredAggregationQuery) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static StructuredAggregationQuery parseFrom(InputStream inputStream) throws IOException {
        return (StructuredAggregationQuery) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static StructuredAggregationQuery parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StructuredAggregationQuery) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static StructuredAggregationQuery parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (StructuredAggregationQuery) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static StructuredAggregationQuery parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (StructuredAggregationQuery) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
