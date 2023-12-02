package com.google.firebase.firestore.model;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.ArrayValueOrBuilder;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes5.dex */
public class Values {
    public static final Value MAX_VALUE;
    public static final Value MIN_VALUE;
    public static final Value NAN_VALUE = Value.newBuilder().setDoubleValue(Double.NaN).build();
    public static final Value NULL_VALUE;
    public static final int TYPE_ORDER_ARRAY = 9;
    public static final int TYPE_ORDER_BLOB = 6;
    public static final int TYPE_ORDER_BOOLEAN = 1;
    public static final int TYPE_ORDER_GEOPOINT = 8;
    public static final int TYPE_ORDER_MAP = 10;
    public static final int TYPE_ORDER_MAX_VALUE = Integer.MAX_VALUE;
    public static final int TYPE_ORDER_NULL = 0;
    public static final int TYPE_ORDER_NUMBER = 2;
    public static final int TYPE_ORDER_REFERENCE = 7;
    public static final int TYPE_ORDER_SERVER_TIMESTAMP = 4;
    public static final int TYPE_ORDER_STRING = 5;
    public static final int TYPE_ORDER_TIMESTAMP = 3;

    /* renamed from: a  reason: collision with root package name */
    private static final Value f30975a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.model.Values$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30976a;

        static {
            int[] iArr = new int[Value.ValueTypeCase.values().length];
            f30976a = iArr;
            try {
                iArr[Value.ValueTypeCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30976a[Value.ValueTypeCase.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30976a[Value.ValueTypeCase.INTEGER_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30976a[Value.ValueTypeCase.DOUBLE_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30976a[Value.ValueTypeCase.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30976a[Value.ValueTypeCase.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30976a[Value.ValueTypeCase.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30976a[Value.ValueTypeCase.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30976a[Value.ValueTypeCase.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30976a[Value.ValueTypeCase.ARRAY_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30976a[Value.ValueTypeCase.MAP_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    static {
        Value build = Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
        NULL_VALUE = build;
        MIN_VALUE = build;
        Value build2 = Value.newBuilder().setStringValue("__max__").build();
        f30975a = build2;
        MAX_VALUE = Value.newBuilder().setMapValue(MapValue.newBuilder().putFields("__type__", build2)).build();
    }

    private static boolean a(Value value, Value value2) {
        ArrayValue arrayValue = value.getArrayValue();
        ArrayValue arrayValue2 = value2.getArrayValue();
        if (arrayValue.getValuesCount() != arrayValue2.getValuesCount()) {
            return false;
        }
        for (int i4 = 0; i4 < arrayValue.getValuesCount(); i4++) {
            if (!equals(arrayValue.getValues(i4), arrayValue2.getValues(i4))) {
                return false;
            }
        }
        return true;
    }

    private static void b(StringBuilder sb, ArrayValue arrayValue) {
        sb.append("[");
        for (int i4 = 0; i4 < arrayValue.getValuesCount(); i4++) {
            g(sb, arrayValue.getValues(i4));
            if (i4 != arrayValue.getValuesCount() - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
    }

    private static void c(StringBuilder sb, LatLng latLng) {
        sb.append(String.format("geo(%s,%s)", Double.valueOf(latLng.getLatitude()), Double.valueOf(latLng.getLongitude())));
    }

    public static String canonicalId(Value value) {
        StringBuilder sb = new StringBuilder();
        g(sb, value);
        return sb.toString();
    }

    public static int compare(Value value, Value value2) {
        int typeOrder = typeOrder(value);
        int typeOrder2 = typeOrder(value2);
        if (typeOrder != typeOrder2) {
            return Util.compareIntegers(typeOrder, typeOrder2);
        }
        if (typeOrder != Integer.MAX_VALUE) {
            switch (typeOrder) {
                case 0:
                    break;
                case 1:
                    return Util.compareBooleans(value.getBooleanValue(), value2.getBooleanValue());
                case 2:
                    return k(value, value2);
                case 3:
                    return m(value.getTimestampValue(), value2.getTimestampValue());
                case 4:
                    return m(ServerTimestamps.getLocalWriteTime(value), ServerTimestamps.getLocalWriteTime(value2));
                case 5:
                    return value.getStringValue().compareTo(value2.getStringValue());
                case 6:
                    return Util.compareByteStrings(value.getBytesValue(), value2.getBytesValue());
                case 7:
                    return l(value.getReferenceValue(), value2.getReferenceValue());
                case 8:
                    return i(value.getGeoPointValue(), value2.getGeoPointValue());
                case 9:
                    return h(value.getArrayValue(), value2.getArrayValue());
                case 10:
                    return j(value.getMapValue(), value2.getMapValue());
                default:
                    throw Assert.fail("Invalid value type: " + typeOrder, new Object[0]);
            }
        }
        return 0;
    }

    public static boolean contains(ArrayValueOrBuilder arrayValueOrBuilder, Value value) {
        for (Value value2 : arrayValueOrBuilder.getValuesList()) {
            if (equals(value2, value)) {
                return true;
            }
        }
        return false;
    }

    private static void d(StringBuilder sb, MapValue mapValue) {
        ArrayList<String> arrayList = new ArrayList(mapValue.getFieldsMap().keySet());
        Collections.sort(arrayList);
        sb.append("{");
        boolean z3 = true;
        for (String str : arrayList) {
            if (!z3) {
                sb.append(",");
            } else {
                z3 = false;
            }
            sb.append(str);
            sb.append(":");
            g(sb, mapValue.getFieldsOrThrow(str));
        }
        sb.append("}");
    }

    private static void e(StringBuilder sb, Value value) {
        Assert.hardAssert(isReferenceValue(value), "Value should be a ReferenceValue", new Object[0]);
        sb.append(DocumentKey.fromName(value.getReferenceValue()));
    }

    public static boolean equals(Value value, Value value2) {
        int typeOrder;
        if (value == value2) {
            return true;
        }
        if (value == null || value2 == null || (typeOrder = typeOrder(value)) != typeOrder(value2)) {
            return false;
        }
        if (typeOrder != 2) {
            if (typeOrder != 4) {
                if (typeOrder == Integer.MAX_VALUE) {
                    return true;
                }
                if (typeOrder != 9) {
                    if (typeOrder != 10) {
                        return value.equals(value2);
                    }
                    return o(value, value2);
                }
                return a(value, value2);
            }
            return ServerTimestamps.getLocalWriteTime(value).equals(ServerTimestamps.getLocalWriteTime(value2));
        }
        return n(value, value2);
    }

    private static void f(StringBuilder sb, Timestamp timestamp) {
        sb.append(String.format("time(%s,%s)", Long.valueOf(timestamp.getSeconds()), Integer.valueOf(timestamp.getNanos())));
    }

    private static void g(StringBuilder sb, Value value) {
        switch (AnonymousClass1.f30976a[value.getValueTypeCase().ordinal()]) {
            case 1:
                sb.append("null");
                return;
            case 2:
                sb.append(value.getBooleanValue());
                return;
            case 3:
                sb.append(value.getIntegerValue());
                return;
            case 4:
                sb.append(value.getDoubleValue());
                return;
            case 5:
                f(sb, value.getTimestampValue());
                return;
            case 6:
                sb.append(value.getStringValue());
                return;
            case 7:
                sb.append(Util.toDebugString(value.getBytesValue()));
                return;
            case 8:
                e(sb, value);
                return;
            case 9:
                c(sb, value.getGeoPointValue());
                return;
            case 10:
                b(sb, value.getArrayValue());
                return;
            case 11:
                d(sb, value.getMapValue());
                return;
            default:
                throw Assert.fail("Invalid value type: " + value.getValueTypeCase(), new Object[0]);
        }
    }

    public static Value getLowerBound(Value.ValueTypeCase valueTypeCase) {
        switch (AnonymousClass1.f30976a[valueTypeCase.ordinal()]) {
            case 1:
                return NULL_VALUE;
            case 2:
                return Value.newBuilder().setBooleanValue(false).build();
            case 3:
            case 4:
                return Value.newBuilder().setDoubleValue(Double.NaN).build();
            case 5:
                return Value.newBuilder().setTimestampValue(Timestamp.newBuilder().setSeconds(Long.MIN_VALUE)).build();
            case 6:
                return Value.newBuilder().setStringValue("").build();
            case 7:
                return Value.newBuilder().setBytesValue(ByteString.EMPTY).build();
            case 8:
                return refValue(DatabaseId.EMPTY, DocumentKey.empty());
            case 9:
                return Value.newBuilder().setGeoPointValue(LatLng.newBuilder().setLatitude(-90.0d).setLongitude(-180.0d)).build();
            case 10:
                return Value.newBuilder().setArrayValue(ArrayValue.getDefaultInstance()).build();
            case 11:
                return Value.newBuilder().setMapValue(MapValue.getDefaultInstance()).build();
            default:
                throw new IllegalArgumentException("Unknown value type: " + valueTypeCase);
        }
    }

    public static Value getUpperBound(Value.ValueTypeCase valueTypeCase) {
        switch (AnonymousClass1.f30976a[valueTypeCase.ordinal()]) {
            case 1:
                return getLowerBound(Value.ValueTypeCase.BOOLEAN_VALUE);
            case 2:
                return getLowerBound(Value.ValueTypeCase.INTEGER_VALUE);
            case 3:
            case 4:
                return getLowerBound(Value.ValueTypeCase.TIMESTAMP_VALUE);
            case 5:
                return getLowerBound(Value.ValueTypeCase.STRING_VALUE);
            case 6:
                return getLowerBound(Value.ValueTypeCase.BYTES_VALUE);
            case 7:
                return getLowerBound(Value.ValueTypeCase.REFERENCE_VALUE);
            case 8:
                return getLowerBound(Value.ValueTypeCase.GEO_POINT_VALUE);
            case 9:
                return getLowerBound(Value.ValueTypeCase.ARRAY_VALUE);
            case 10:
                return getLowerBound(Value.ValueTypeCase.MAP_VALUE);
            case 11:
                return MAX_VALUE;
            default:
                throw new IllegalArgumentException("Unknown value type: " + valueTypeCase);
        }
    }

    private static int h(ArrayValue arrayValue, ArrayValue arrayValue2) {
        int min = Math.min(arrayValue.getValuesCount(), arrayValue2.getValuesCount());
        for (int i4 = 0; i4 < min; i4++) {
            int compare = compare(arrayValue.getValues(i4), arrayValue2.getValues(i4));
            if (compare != 0) {
                return compare;
            }
        }
        return Util.compareIntegers(arrayValue.getValuesCount(), arrayValue2.getValuesCount());
    }

    private static int i(LatLng latLng, LatLng latLng2) {
        int compareDoubles = Util.compareDoubles(latLng.getLatitude(), latLng2.getLatitude());
        if (compareDoubles == 0) {
            return Util.compareDoubles(latLng.getLongitude(), latLng2.getLongitude());
        }
        return compareDoubles;
    }

    public static boolean isArray(@Nullable Value value) {
        if (value != null && value.getValueTypeCase() == Value.ValueTypeCase.ARRAY_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean isDouble(@Nullable Value value) {
        if (value != null && value.getValueTypeCase() == Value.ValueTypeCase.DOUBLE_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(@Nullable Value value) {
        if (value != null && value.getValueTypeCase() == Value.ValueTypeCase.INTEGER_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean isMapValue(@Nullable Value value) {
        if (value != null && value.getValueTypeCase() == Value.ValueTypeCase.MAP_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean isMaxValue(Value value) {
        return f30975a.equals(value.getMapValue().getFieldsMap().get("__type__"));
    }

    public static boolean isNanValue(@Nullable Value value) {
        if (value != null && Double.isNaN(value.getDoubleValue())) {
            return true;
        }
        return false;
    }

    public static boolean isNullValue(@Nullable Value value) {
        if (value != null && value.getValueTypeCase() == Value.ValueTypeCase.NULL_VALUE) {
            return true;
        }
        return false;
    }

    public static boolean isNumber(@Nullable Value value) {
        if (!isInteger(value) && !isDouble(value)) {
            return false;
        }
        return true;
    }

    public static boolean isReferenceValue(@Nullable Value value) {
        if (value != null && value.getValueTypeCase() == Value.ValueTypeCase.REFERENCE_VALUE) {
            return true;
        }
        return false;
    }

    private static int j(MapValue mapValue, MapValue mapValue2) {
        Iterator it = new TreeMap(mapValue.getFieldsMap()).entrySet().iterator();
        Iterator it2 = new TreeMap(mapValue2.getFieldsMap()).entrySet().iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            int compareTo = ((String) entry.getKey()).compareTo((String) entry2.getKey());
            if (compareTo != 0) {
                return compareTo;
            }
            int compare = compare((Value) entry.getValue(), (Value) entry2.getValue());
            if (compare != 0) {
                return compare;
            }
        }
        return Util.compareBooleans(it.hasNext(), it2.hasNext());
    }

    private static int k(Value value, Value value2) {
        Value.ValueTypeCase valueTypeCase = value.getValueTypeCase();
        Value.ValueTypeCase valueTypeCase2 = Value.ValueTypeCase.DOUBLE_VALUE;
        if (valueTypeCase == valueTypeCase2) {
            double doubleValue = value.getDoubleValue();
            if (value2.getValueTypeCase() == valueTypeCase2) {
                return Util.compareDoubles(doubleValue, value2.getDoubleValue());
            }
            if (value2.getValueTypeCase() == Value.ValueTypeCase.INTEGER_VALUE) {
                return Util.compareMixed(doubleValue, value2.getIntegerValue());
            }
        } else {
            Value.ValueTypeCase valueTypeCase3 = value.getValueTypeCase();
            Value.ValueTypeCase valueTypeCase4 = Value.ValueTypeCase.INTEGER_VALUE;
            if (valueTypeCase3 == valueTypeCase4) {
                long integerValue = value.getIntegerValue();
                if (value2.getValueTypeCase() == valueTypeCase4) {
                    return Util.compareLongs(integerValue, value2.getIntegerValue());
                }
                if (value2.getValueTypeCase() == valueTypeCase2) {
                    return Util.compareMixed(value2.getDoubleValue(), integerValue) * (-1);
                }
            }
        }
        throw Assert.fail("Unexpected values: %s vs %s", value, value2);
    }

    private static int l(String str, String str2) {
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        String[] split2 = str2.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        int min = Math.min(split.length, split2.length);
        for (int i4 = 0; i4 < min; i4++) {
            int compareTo = split[i4].compareTo(split2[i4]);
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Util.compareIntegers(split.length, split2.length);
    }

    public static int lowerBoundCompare(Value value, boolean z3, Value value2, boolean z4) {
        int compare = compare(value, value2);
        if (compare != 0) {
            return compare;
        }
        if (z3 && !z4) {
            return -1;
        }
        if (!z3 && z4) {
            return 1;
        }
        return 0;
    }

    private static int m(Timestamp timestamp, Timestamp timestamp2) {
        int compareLongs = Util.compareLongs(timestamp.getSeconds(), timestamp2.getSeconds());
        if (compareLongs != 0) {
            return compareLongs;
        }
        return Util.compareIntegers(timestamp.getNanos(), timestamp2.getNanos());
    }

    private static boolean n(Value value, Value value2) {
        Value.ValueTypeCase valueTypeCase = value.getValueTypeCase();
        Value.ValueTypeCase valueTypeCase2 = Value.ValueTypeCase.INTEGER_VALUE;
        if (valueTypeCase == valueTypeCase2 && value2.getValueTypeCase() == valueTypeCase2) {
            if (value.getIntegerValue() == value2.getIntegerValue()) {
                return true;
            }
            return false;
        }
        Value.ValueTypeCase valueTypeCase3 = value.getValueTypeCase();
        Value.ValueTypeCase valueTypeCase4 = Value.ValueTypeCase.DOUBLE_VALUE;
        if (valueTypeCase3 == valueTypeCase4 && value2.getValueTypeCase() == valueTypeCase4 && Double.doubleToLongBits(value.getDoubleValue()) == Double.doubleToLongBits(value2.getDoubleValue())) {
            return true;
        }
        return false;
    }

    private static boolean o(Value value, Value value2) {
        MapValue mapValue = value.getMapValue();
        MapValue mapValue2 = value2.getMapValue();
        if (mapValue.getFieldsCount() != mapValue2.getFieldsCount()) {
            return false;
        }
        for (Map.Entry<String, Value> entry : mapValue.getFieldsMap().entrySet()) {
            if (!equals(entry.getValue(), mapValue2.getFieldsMap().get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    public static Value refValue(DatabaseId databaseId, DocumentKey documentKey) {
        return Value.newBuilder().setReferenceValue(String.format("projects/%s/databases/%s/documents/%s", databaseId.getProjectId(), databaseId.getDatabaseId(), documentKey.toString())).build();
    }

    public static int typeOrder(Value value) {
        switch (AnonymousClass1.f30976a[value.getValueTypeCase().ordinal()]) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
            case 4:
                return 2;
            case 5:
                return 3;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 9;
            case 11:
                if (ServerTimestamps.isServerTimestamp(value)) {
                    return 4;
                }
                if (isMaxValue(value)) {
                    return Integer.MAX_VALUE;
                }
                return 10;
            default:
                throw Assert.fail("Invalid value type: " + value.getValueTypeCase(), new Object[0]);
        }
    }

    public static int upperBoundCompare(Value value, boolean z3, Value value2, boolean z4) {
        int compare = compare(value, value2);
        if (compare != 0) {
            return compare;
        }
        if (z3 && !z4) {
            return 1;
        }
        if (!z3 && z4) {
            return -1;
        }
        return 0;
    }
}
