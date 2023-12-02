package com.google.firebase.firestore;

import androidx.annotation.RestrictTo;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ServerTimestamps;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Logger;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public class UserDataWriter {

    /* renamed from: a  reason: collision with root package name */
    private final FirebaseFirestore f30242a;

    /* renamed from: b  reason: collision with root package name */
    private final DocumentSnapshot.ServerTimestampBehavior f30243b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.UserDataWriter$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30244a;

        static {
            int[] iArr = new int[DocumentSnapshot.ServerTimestampBehavior.values().length];
            f30244a = iArr;
            try {
                iArr[DocumentSnapshot.ServerTimestampBehavior.PREVIOUS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30244a[DocumentSnapshot.ServerTimestampBehavior.ESTIMATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public UserDataWriter(FirebaseFirestore firebaseFirestore, DocumentSnapshot.ServerTimestampBehavior serverTimestampBehavior) {
        this.f30242a = firebaseFirestore;
        this.f30243b = serverTimestampBehavior;
    }

    private List<Object> a(ArrayValue arrayValue) {
        ArrayList arrayList = new ArrayList(arrayValue.getValuesCount());
        for (Value value : arrayValue.getValuesList()) {
            arrayList.add(convertValue(value));
        }
        return arrayList;
    }

    private Object c(Value value) {
        DatabaseId fromName = DatabaseId.fromName(value.getReferenceValue());
        DocumentKey fromName2 = DocumentKey.fromName(value.getReferenceValue());
        DatabaseId j4 = this.f30242a.j();
        if (!fromName.equals(j4)) {
            Logger.warn("DocumentSnapshot", "Document %s contains a document reference within a different database (%s/%s) which is not supported. It will be treated as a reference in the current database (%s/%s) instead.", fromName2.getPath(), fromName.getProjectId(), fromName.getDatabaseId(), j4.getProjectId(), j4.getDatabaseId());
        }
        return new DocumentReference(fromName2, this.f30242a);
    }

    private Object d(Value value) {
        int i4 = AnonymousClass1.f30244a[this.f30243b.ordinal()];
        if (i4 != 1) {
            if (i4 != 2) {
                return null;
            }
            return e(ServerTimestamps.getLocalWriteTime(value));
        }
        Value previousValue = ServerTimestamps.getPreviousValue(value);
        if (previousValue == null) {
            return null;
        }
        return convertValue(previousValue);
    }

    private Object e(Timestamp timestamp) {
        return new com.google.firebase.Timestamp(timestamp.getSeconds(), timestamp.getNanos());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Map<String, Object> b(Map<String, Value> map) {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Value> entry : map.entrySet()) {
            hashMap.put(entry.getKey(), convertValue(entry.getValue()));
        }
        return hashMap;
    }

    public Object convertValue(Value value) {
        switch (Values.typeOrder(value)) {
            case 0:
                return null;
            case 1:
                return Boolean.valueOf(value.getBooleanValue());
            case 2:
                if (value.getValueTypeCase().equals(Value.ValueTypeCase.INTEGER_VALUE)) {
                    return Long.valueOf(value.getIntegerValue());
                }
                return Double.valueOf(value.getDoubleValue());
            case 3:
                return e(value.getTimestampValue());
            case 4:
                return d(value);
            case 5:
                return value.getStringValue();
            case 6:
                return Blob.fromByteString(value.getBytesValue());
            case 7:
                return c(value);
            case 8:
                return new GeoPoint(value.getGeoPointValue().getLatitude(), value.getGeoPointValue().getLongitude());
            case 9:
                return a(value.getArrayValue());
            case 10:
                return b(value.getMapValue().getFieldsMap());
            default:
                throw Assert.fail("Unknown value type: " + value.getValueTypeCase(), new Object[0]);
        }
    }
}
