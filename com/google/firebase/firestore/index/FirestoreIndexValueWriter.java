package com.google.firebase.firestore.index;

import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.Timestamp;
import com.google.type.LatLng;
import java.util.Map;

/* loaded from: classes5.dex */
public class FirestoreIndexValueWriter {
    public static final int DOCUMENT_NAME_OFFSET = 5;
    public static final int INDEX_TYPE_ARRAY = 50;
    public static final int INDEX_TYPE_BLOB = 30;
    public static final int INDEX_TYPE_BOOLEAN = 10;
    public static final int INDEX_TYPE_GEOPOINT = 45;
    public static final int INDEX_TYPE_MAP = 55;
    public static final int INDEX_TYPE_NAN = 13;
    public static final int INDEX_TYPE_NULL = 5;
    public static final int INDEX_TYPE_NUMBER = 15;
    public static final int INDEX_TYPE_REFERENCE = 37;
    public static final int INDEX_TYPE_REFERENCE_SEGMENT = 60;
    public static final int INDEX_TYPE_STRING = 25;
    public static final int INDEX_TYPE_TIMESTAMP = 20;
    public static final FirestoreIndexValueWriter INSTANCE = new FirestoreIndexValueWriter();
    public static final int NOT_TRUNCATED = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.index.FirestoreIndexValueWriter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30561a;

        static {
            int[] iArr = new int[Value.ValueTypeCase.values().length];
            f30561a = iArr;
            try {
                iArr[Value.ValueTypeCase.NULL_VALUE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30561a[Value.ValueTypeCase.BOOLEAN_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30561a[Value.ValueTypeCase.DOUBLE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30561a[Value.ValueTypeCase.INTEGER_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30561a[Value.ValueTypeCase.TIMESTAMP_VALUE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30561a[Value.ValueTypeCase.STRING_VALUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30561a[Value.ValueTypeCase.BYTES_VALUE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30561a[Value.ValueTypeCase.REFERENCE_VALUE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30561a[Value.ValueTypeCase.GEO_POINT_VALUE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30561a[Value.ValueTypeCase.MAP_VALUE.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f30561a[Value.ValueTypeCase.ARRAY_VALUE.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private FirestoreIndexValueWriter() {
    }

    private void a(ArrayValue arrayValue, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        h(directionalIndexByteEncoder, 50);
        for (Value value : arrayValue.getValuesList()) {
            e(value, directionalIndexByteEncoder);
        }
    }

    private void b(String str, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        h(directionalIndexByteEncoder, 37);
        ResourcePath fromString = ResourcePath.fromString(str);
        int length = fromString.length();
        for (int i4 = 5; i4 < length; i4++) {
            String segment = fromString.getSegment(i4);
            h(directionalIndexByteEncoder, 60);
            g(segment, directionalIndexByteEncoder);
        }
    }

    private void c(MapValue mapValue, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        h(directionalIndexByteEncoder, 55);
        for (Map.Entry<String, Value> entry : mapValue.getFieldsMap().entrySet()) {
            d(entry.getKey(), directionalIndexByteEncoder);
            e(entry.getValue(), directionalIndexByteEncoder);
        }
    }

    private void d(String str, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        h(directionalIndexByteEncoder, 25);
        g(str, directionalIndexByteEncoder);
    }

    private void e(Value value, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        long j4;
        switch (AnonymousClass1.f30561a[value.getValueTypeCase().ordinal()]) {
            case 1:
                h(directionalIndexByteEncoder, 5);
                return;
            case 2:
                h(directionalIndexByteEncoder, 10);
                if (value.getBooleanValue()) {
                    j4 = 1;
                } else {
                    j4 = 0;
                }
                directionalIndexByteEncoder.writeLong(j4);
                return;
            case 3:
                double doubleValue = value.getDoubleValue();
                if (Double.isNaN(doubleValue)) {
                    h(directionalIndexByteEncoder, 13);
                    return;
                }
                h(directionalIndexByteEncoder, 15);
                if (doubleValue == -0.0d) {
                    directionalIndexByteEncoder.writeDouble(FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE);
                    return;
                } else {
                    directionalIndexByteEncoder.writeDouble(doubleValue);
                    return;
                }
            case 4:
                h(directionalIndexByteEncoder, 15);
                directionalIndexByteEncoder.writeDouble(value.getIntegerValue());
                return;
            case 5:
                Timestamp timestampValue = value.getTimestampValue();
                h(directionalIndexByteEncoder, 20);
                directionalIndexByteEncoder.writeLong(timestampValue.getSeconds());
                directionalIndexByteEncoder.writeLong(timestampValue.getNanos());
                return;
            case 6:
                d(value.getStringValue(), directionalIndexByteEncoder);
                f(directionalIndexByteEncoder);
                return;
            case 7:
                h(directionalIndexByteEncoder, 30);
                directionalIndexByteEncoder.writeBytes(value.getBytesValue());
                f(directionalIndexByteEncoder);
                return;
            case 8:
                b(value.getReferenceValue(), directionalIndexByteEncoder);
                return;
            case 9:
                LatLng geoPointValue = value.getGeoPointValue();
                h(directionalIndexByteEncoder, 45);
                directionalIndexByteEncoder.writeDouble(geoPointValue.getLatitude());
                directionalIndexByteEncoder.writeDouble(geoPointValue.getLongitude());
                return;
            case 10:
                if (Values.isMaxValue(value)) {
                    h(directionalIndexByteEncoder, Integer.MAX_VALUE);
                    return;
                }
                c(value.getMapValue(), directionalIndexByteEncoder);
                f(directionalIndexByteEncoder);
                return;
            case 11:
                a(value.getArrayValue(), directionalIndexByteEncoder);
                f(directionalIndexByteEncoder);
                return;
            default:
                throw new IllegalArgumentException("unknown index value type " + value.getValueTypeCase());
        }
    }

    private void f(DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        directionalIndexByteEncoder.writeLong(2L);
    }

    private void g(String str, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        directionalIndexByteEncoder.writeString(str);
    }

    private void h(DirectionalIndexByteEncoder directionalIndexByteEncoder, int i4) {
        directionalIndexByteEncoder.writeLong(i4);
    }

    public void writeIndexValue(Value value, DirectionalIndexByteEncoder directionalIndexByteEncoder) {
        e(value, directionalIndexByteEncoder);
        directionalIndexByteEncoder.writeInfinity();
    }
}
