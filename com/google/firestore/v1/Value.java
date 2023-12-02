package com.google.firestore.v1;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.NullValue;
import com.google.protobuf.Parser;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes5.dex */
public final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
    public static final int ARRAY_VALUE_FIELD_NUMBER = 9;
    public static final int BOOLEAN_VALUE_FIELD_NUMBER = 1;
    public static final int BYTES_VALUE_FIELD_NUMBER = 18;
    private static final Value DEFAULT_INSTANCE;
    public static final int DOUBLE_VALUE_FIELD_NUMBER = 3;
    public static final int GEO_POINT_VALUE_FIELD_NUMBER = 8;
    public static final int INTEGER_VALUE_FIELD_NUMBER = 2;
    public static final int MAP_VALUE_FIELD_NUMBER = 6;
    public static final int NULL_VALUE_FIELD_NUMBER = 11;
    private static volatile Parser<Value> PARSER = null;
    public static final int REFERENCE_VALUE_FIELD_NUMBER = 5;
    public static final int STRING_VALUE_FIELD_NUMBER = 17;
    public static final int TIMESTAMP_VALUE_FIELD_NUMBER = 10;
    private int valueTypeCase_ = 0;
    private Object valueType_;

    /* renamed from: com.google.firestore.v1.Value$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f32533a;

        static {
            int[] iArr = new int[GeneratedMessageLite.MethodToInvoke.values().length];
            f32533a = iArr;
            try {
                iArr[GeneratedMessageLite.MethodToInvoke.NEW_MUTABLE_INSTANCE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f32533a[GeneratedMessageLite.MethodToInvoke.NEW_BUILDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f32533a[GeneratedMessageLite.MethodToInvoke.BUILD_MESSAGE_INFO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f32533a[GeneratedMessageLite.MethodToInvoke.GET_DEFAULT_INSTANCE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f32533a[GeneratedMessageLite.MethodToInvoke.GET_PARSER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f32533a[GeneratedMessageLite.MethodToInvoke.GET_MEMOIZED_IS_INITIALIZED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f32533a[GeneratedMessageLite.MethodToInvoke.SET_MEMOIZED_IS_INITIALIZED.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
        /* synthetic */ Builder(AnonymousClass1 anonymousClass1) {
            this();
        }

        public Builder clearArrayValue() {
            f();
            ((Value) this.f33398b).K0();
            return this;
        }

        public Builder clearBooleanValue() {
            f();
            ((Value) this.f33398b).L0();
            return this;
        }

        public Builder clearBytesValue() {
            f();
            ((Value) this.f33398b).M0();
            return this;
        }

        public Builder clearDoubleValue() {
            f();
            ((Value) this.f33398b).N0();
            return this;
        }

        public Builder clearGeoPointValue() {
            f();
            ((Value) this.f33398b).O0();
            return this;
        }

        public Builder clearIntegerValue() {
            f();
            ((Value) this.f33398b).P0();
            return this;
        }

        public Builder clearMapValue() {
            f();
            ((Value) this.f33398b).Q0();
            return this;
        }

        public Builder clearNullValue() {
            f();
            ((Value) this.f33398b).R0();
            return this;
        }

        public Builder clearReferenceValue() {
            f();
            ((Value) this.f33398b).S0();
            return this;
        }

        public Builder clearStringValue() {
            f();
            ((Value) this.f33398b).T0();
            return this;
        }

        public Builder clearTimestampValue() {
            f();
            ((Value) this.f33398b).U0();
            return this;
        }

        public Builder clearValueType() {
            f();
            ((Value) this.f33398b).V0();
            return this;
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ArrayValue getArrayValue() {
            return ((Value) this.f33398b).getArrayValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean getBooleanValue() {
            return ((Value) this.f33398b).getBooleanValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ByteString getBytesValue() {
            return ((Value) this.f33398b).getBytesValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public double getDoubleValue() {
            return ((Value) this.f33398b).getDoubleValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public LatLng getGeoPointValue() {
            return ((Value) this.f33398b).getGeoPointValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public long getIntegerValue() {
            return ((Value) this.f33398b).getIntegerValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public MapValue getMapValue() {
            return ((Value) this.f33398b).getMapValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public NullValue getNullValue() {
            return ((Value) this.f33398b).getNullValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public int getNullValueValue() {
            return ((Value) this.f33398b).getNullValueValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public String getReferenceValue() {
            return ((Value) this.f33398b).getReferenceValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ByteString getReferenceValueBytes() {
            return ((Value) this.f33398b).getReferenceValueBytes();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public String getStringValue() {
            return ((Value) this.f33398b).getStringValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ByteString getStringValueBytes() {
            return ((Value) this.f33398b).getStringValueBytes();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public Timestamp getTimestampValue() {
            return ((Value) this.f33398b).getTimestampValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public ValueTypeCase getValueTypeCase() {
            return ((Value) this.f33398b).getValueTypeCase();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasArrayValue() {
            return ((Value) this.f33398b).hasArrayValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasBooleanValue() {
            return ((Value) this.f33398b).hasBooleanValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasBytesValue() {
            return ((Value) this.f33398b).hasBytesValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasDoubleValue() {
            return ((Value) this.f33398b).hasDoubleValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasGeoPointValue() {
            return ((Value) this.f33398b).hasGeoPointValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasIntegerValue() {
            return ((Value) this.f33398b).hasIntegerValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasMapValue() {
            return ((Value) this.f33398b).hasMapValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasNullValue() {
            return ((Value) this.f33398b).hasNullValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasReferenceValue() {
            return ((Value) this.f33398b).hasReferenceValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasStringValue() {
            return ((Value) this.f33398b).hasStringValue();
        }

        @Override // com.google.firestore.v1.ValueOrBuilder
        public boolean hasTimestampValue() {
            return ((Value) this.f33398b).hasTimestampValue();
        }

        public Builder mergeArrayValue(ArrayValue arrayValue) {
            f();
            ((Value) this.f33398b).W0(arrayValue);
            return this;
        }

        public Builder mergeGeoPointValue(LatLng latLng) {
            f();
            ((Value) this.f33398b).X0(latLng);
            return this;
        }

        public Builder mergeMapValue(MapValue mapValue) {
            f();
            ((Value) this.f33398b).Y0(mapValue);
            return this;
        }

        public Builder mergeTimestampValue(Timestamp timestamp) {
            f();
            ((Value) this.f33398b).Z0(timestamp);
            return this;
        }

        public Builder setArrayValue(ArrayValue arrayValue) {
            f();
            ((Value) this.f33398b).a1(arrayValue);
            return this;
        }

        public Builder setBooleanValue(boolean z3) {
            f();
            ((Value) this.f33398b).b1(z3);
            return this;
        }

        public Builder setBytesValue(ByteString byteString) {
            f();
            ((Value) this.f33398b).c1(byteString);
            return this;
        }

        public Builder setDoubleValue(double d4) {
            f();
            ((Value) this.f33398b).d1(d4);
            return this;
        }

        public Builder setGeoPointValue(LatLng latLng) {
            f();
            ((Value) this.f33398b).e1(latLng);
            return this;
        }

        public Builder setIntegerValue(long j4) {
            f();
            ((Value) this.f33398b).f1(j4);
            return this;
        }

        public Builder setMapValue(MapValue mapValue) {
            f();
            ((Value) this.f33398b).g1(mapValue);
            return this;
        }

        public Builder setNullValue(NullValue nullValue) {
            f();
            ((Value) this.f33398b).h1(nullValue);
            return this;
        }

        public Builder setNullValueValue(int i4) {
            f();
            ((Value) this.f33398b).i1(i4);
            return this;
        }

        public Builder setReferenceValue(String str) {
            f();
            ((Value) this.f33398b).j1(str);
            return this;
        }

        public Builder setReferenceValueBytes(ByteString byteString) {
            f();
            ((Value) this.f33398b).k1(byteString);
            return this;
        }

        public Builder setStringValue(String str) {
            f();
            ((Value) this.f33398b).l1(str);
            return this;
        }

        public Builder setStringValueBytes(ByteString byteString) {
            f();
            ((Value) this.f33398b).m1(byteString);
            return this;
        }

        public Builder setTimestampValue(Timestamp timestamp) {
            f();
            ((Value) this.f33398b).n1(timestamp);
            return this;
        }

        private Builder() {
            super(Value.DEFAULT_INSTANCE);
        }

        public Builder setArrayValue(ArrayValue.Builder builder) {
            f();
            ((Value) this.f33398b).a1(builder.build());
            return this;
        }

        public Builder setGeoPointValue(LatLng.Builder builder) {
            f();
            ((Value) this.f33398b).e1(builder.build());
            return this;
        }

        public Builder setMapValue(MapValue.Builder builder) {
            f();
            ((Value) this.f33398b).g1(builder.build());
            return this;
        }

        public Builder setTimestampValue(Timestamp.Builder builder) {
            f();
            ((Value) this.f33398b).n1(builder.build());
            return this;
        }
    }

    /* loaded from: classes5.dex */
    public enum ValueTypeCase {
        NULL_VALUE(11),
        BOOLEAN_VALUE(1),
        INTEGER_VALUE(2),
        DOUBLE_VALUE(3),
        TIMESTAMP_VALUE(10),
        STRING_VALUE(17),
        BYTES_VALUE(18),
        REFERENCE_VALUE(5),
        GEO_POINT_VALUE(8),
        ARRAY_VALUE(9),
        MAP_VALUE(6),
        VALUETYPE_NOT_SET(0);
        
        private final int value;

        ValueTypeCase(int i4) {
            this.value = i4;
        }

        public static ValueTypeCase forNumber(int i4) {
            if (i4 != 0) {
                if (i4 != 1) {
                    if (i4 != 2) {
                        if (i4 != 3) {
                            if (i4 != 5) {
                                if (i4 != 6) {
                                    if (i4 != 17) {
                                        if (i4 != 18) {
                                            switch (i4) {
                                                case 8:
                                                    return GEO_POINT_VALUE;
                                                case 9:
                                                    return ARRAY_VALUE;
                                                case 10:
                                                    return TIMESTAMP_VALUE;
                                                case 11:
                                                    return NULL_VALUE;
                                                default:
                                                    return null;
                                            }
                                        }
                                        return BYTES_VALUE;
                                    }
                                    return STRING_VALUE;
                                }
                                return MAP_VALUE;
                            }
                            return REFERENCE_VALUE;
                        }
                        return DOUBLE_VALUE;
                    }
                    return INTEGER_VALUE;
                }
                return BOOLEAN_VALUE;
            }
            return VALUETYPE_NOT_SET;
        }

        public int getNumber() {
            return this.value;
        }

        @Deprecated
        public static ValueTypeCase valueOf(int i4) {
            return forNumber(i4);
        }
    }

    static {
        Value value = new Value();
        DEFAULT_INSTANCE = value;
        GeneratedMessageLite.d0(Value.class, value);
    }

    private Value() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        if (this.valueTypeCase_ == 9) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0() {
        if (this.valueTypeCase_ == 1) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M0() {
        if (this.valueTypeCase_ == 18) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        if (this.valueTypeCase_ == 3) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0() {
        if (this.valueTypeCase_ == 8) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        if (this.valueTypeCase_ == 2) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q0() {
        if (this.valueTypeCase_ == 6) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        if (this.valueTypeCase_ == 11) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S0() {
        if (this.valueTypeCase_ == 5) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T0() {
        if (this.valueTypeCase_ == 17) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        if (this.valueTypeCase_ == 10) {
            this.valueTypeCase_ = 0;
            this.valueType_ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void V0() {
        this.valueTypeCase_ = 0;
        this.valueType_ = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W0(ArrayValue arrayValue) {
        arrayValue.getClass();
        if (this.valueTypeCase_ == 9 && this.valueType_ != ArrayValue.getDefaultInstance()) {
            this.valueType_ = ArrayValue.newBuilder((ArrayValue) this.valueType_).mergeFrom((ArrayValue.Builder) arrayValue).buildPartial();
        } else {
            this.valueType_ = arrayValue;
        }
        this.valueTypeCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void X0(LatLng latLng) {
        latLng.getClass();
        if (this.valueTypeCase_ == 8 && this.valueType_ != LatLng.getDefaultInstance()) {
            this.valueType_ = LatLng.newBuilder((LatLng) this.valueType_).mergeFrom((LatLng.Builder) latLng).buildPartial();
        } else {
            this.valueType_ = latLng;
        }
        this.valueTypeCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(MapValue mapValue) {
        mapValue.getClass();
        if (this.valueTypeCase_ == 6 && this.valueType_ != MapValue.getDefaultInstance()) {
            this.valueType_ = MapValue.newBuilder((MapValue) this.valueType_).mergeFrom((MapValue.Builder) mapValue).buildPartial();
        } else {
            this.valueType_ = mapValue;
        }
        this.valueTypeCase_ = 6;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Z0(Timestamp timestamp) {
        timestamp.getClass();
        if (this.valueTypeCase_ == 10 && this.valueType_ != Timestamp.getDefaultInstance()) {
            this.valueType_ = Timestamp.newBuilder((Timestamp) this.valueType_).mergeFrom((Timestamp.Builder) timestamp).buildPartial();
        } else {
            this.valueType_ = timestamp;
        }
        this.valueTypeCase_ = 10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a1(ArrayValue arrayValue) {
        arrayValue.getClass();
        this.valueType_ = arrayValue;
        this.valueTypeCase_ = 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b1(boolean z3) {
        this.valueTypeCase_ = 1;
        this.valueType_ = Boolean.valueOf(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c1(ByteString byteString) {
        byteString.getClass();
        this.valueTypeCase_ = 18;
        this.valueType_ = byteString;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d1(double d4) {
        this.valueTypeCase_ = 3;
        this.valueType_ = Double.valueOf(d4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e1(LatLng latLng) {
        latLng.getClass();
        this.valueType_ = latLng;
        this.valueTypeCase_ = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f1(long j4) {
        this.valueTypeCase_ = 2;
        this.valueType_ = Long.valueOf(j4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g1(MapValue mapValue) {
        mapValue.getClass();
        this.valueType_ = mapValue;
        this.valueTypeCase_ = 6;
    }

    public static Value getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h1(NullValue nullValue) {
        this.valueType_ = Integer.valueOf(nullValue.getNumber());
        this.valueTypeCase_ = 11;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i1(int i4) {
        this.valueTypeCase_ = 11;
        this.valueType_ = Integer.valueOf(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j1(String str) {
        str.getClass();
        this.valueTypeCase_ = 5;
        this.valueType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.valueType_ = byteString.toStringUtf8();
        this.valueTypeCase_ = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l1(String str) {
        str.getClass();
        this.valueTypeCase_ = 17;
        this.valueType_ = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m1(ByteString byteString) {
        AbstractMessageLite.b(byteString);
        this.valueType_ = byteString.toStringUtf8();
        this.valueTypeCase_ = 17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n1(Timestamp timestamp) {
        timestamp.getClass();
        this.valueType_ = timestamp;
        this.valueTypeCase_ = 10;
    }

    public static Builder newBuilder() {
        return DEFAULT_INSTANCE.q();
    }

    public static Value parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageLite.N(DEFAULT_INSTANCE, inputStream);
    }

    public static Value parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.V(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Value> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ArrayValue getArrayValue() {
        if (this.valueTypeCase_ == 9) {
            return (ArrayValue) this.valueType_;
        }
        return ArrayValue.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean getBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            return ((Boolean) this.valueType_).booleanValue();
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ByteString getBytesValue() {
        if (this.valueTypeCase_ == 18) {
            return (ByteString) this.valueType_;
        }
        return ByteString.EMPTY;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public double getDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            return ((Double) this.valueType_).doubleValue();
        }
        return FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public LatLng getGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            return (LatLng) this.valueType_;
        }
        return LatLng.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public long getIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            return ((Long) this.valueType_).longValue();
        }
        return 0L;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public MapValue getMapValue() {
        if (this.valueTypeCase_ == 6) {
            return (MapValue) this.valueType_;
        }
        return MapValue.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public NullValue getNullValue() {
        if (this.valueTypeCase_ == 11) {
            NullValue forNumber = NullValue.forNumber(((Integer) this.valueType_).intValue());
            if (forNumber == null) {
                return NullValue.UNRECOGNIZED;
            }
            return forNumber;
        }
        return NullValue.NULL_VALUE;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public int getNullValueValue() {
        if (this.valueTypeCase_ == 11) {
            return ((Integer) this.valueType_).intValue();
        }
        return 0;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public String getReferenceValue() {
        if (this.valueTypeCase_ == 5) {
            return (String) this.valueType_;
        }
        return "";
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ByteString getReferenceValueBytes() {
        String str;
        if (this.valueTypeCase_ == 5) {
            str = (String) this.valueType_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public String getStringValue() {
        if (this.valueTypeCase_ == 17) {
            return (String) this.valueType_;
        }
        return "";
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ByteString getStringValueBytes() {
        String str;
        if (this.valueTypeCase_ == 17) {
            str = (String) this.valueType_;
        } else {
            str = "";
        }
        return ByteString.copyFromUtf8(str);
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public Timestamp getTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            return (Timestamp) this.valueType_;
        }
        return Timestamp.getDefaultInstance();
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public ValueTypeCase getValueTypeCase() {
        return ValueTypeCase.forNumber(this.valueTypeCase_);
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasArrayValue() {
        if (this.valueTypeCase_ == 9) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasBooleanValue() {
        if (this.valueTypeCase_ == 1) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasBytesValue() {
        if (this.valueTypeCase_ == 18) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasDoubleValue() {
        if (this.valueTypeCase_ == 3) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasGeoPointValue() {
        if (this.valueTypeCase_ == 8) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasIntegerValue() {
        if (this.valueTypeCase_ == 2) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasMapValue() {
        if (this.valueTypeCase_ == 6) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasNullValue() {
        if (this.valueTypeCase_ == 11) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasReferenceValue() {
        if (this.valueTypeCase_ == 5) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasStringValue() {
        if (this.valueTypeCase_ == 17) {
            return true;
        }
        return false;
    }

    @Override // com.google.firestore.v1.ValueOrBuilder
    public boolean hasTimestampValue() {
        if (this.valueTypeCase_ == 10) {
            return true;
        }
        return false;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    protected final Object u(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (AnonymousClass1.f32533a[methodToInvoke.ordinal()]) {
            case 1:
                return new Value();
            case 2:
                return new Builder(null);
            case 3:
                return GeneratedMessageLite.L(DEFAULT_INSTANCE, "\u0000\u000b\u0001\u0000\u0001\u0012\u000b\u0000\u0000\u0000\u0001:\u0000\u00025\u0000\u00033\u0000\u0005Ȼ\u0000\u0006<\u0000\b<\u0000\t<\u0000\n<\u0000\u000b?\u0000\u0011Ȼ\u0000\u0012=\u0000", new Object[]{"valueType_", "valueTypeCase_", MapValue.class, LatLng.class, ArrayValue.class, Timestamp.class});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Value> parser = PARSER;
                if (parser == null) {
                    synchronized (Value.class) {
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

    public static Builder newBuilder(Value value) {
        return DEFAULT_INSTANCE.r(value);
    }

    public static Value parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.O(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.W(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Value parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.P(DEFAULT_INSTANCE, byteString);
    }

    public static Value parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.Q(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Value parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.X(DEFAULT_INSTANCE, bArr);
    }

    public static Value parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Value) GeneratedMessageLite.Y(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Value parseFrom(InputStream inputStream) throws IOException {
        return (Value) GeneratedMessageLite.T(DEFAULT_INSTANCE, inputStream);
    }

    public static Value parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.U(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Value parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Value) GeneratedMessageLite.R(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Value parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Value) GeneratedMessageLite.S(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
