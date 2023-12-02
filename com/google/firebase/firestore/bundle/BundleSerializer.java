package com.google.firebase.firestore.bundle;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import com.google.protobuf.NullValue;
import com.google.type.LatLng;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class BundleSerializer {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f30289a;

    /* renamed from: b  reason: collision with root package name */
    private final RemoteSerializer f30290b;

    public BundleSerializer(RemoteSerializer remoteSerializer) {
        this.f30290b = remoteSerializer;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
        this.f30289a = simpleDateFormat;
        GregorianCalendar gregorianCalendar = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        gregorianCalendar.setGregorianChange(new Date(Long.MIN_VALUE));
        simpleDateFormat.setCalendar(gregorianCalendar);
    }

    private static int A(String str) {
        int i4 = 0;
        for (int i5 = 0; i5 < 9; i5++) {
            i4 *= 10;
            if (i5 < str.length()) {
                if (str.charAt(i5) >= '0' && str.charAt(i5) <= '9') {
                    i4 += str.charAt(i5) - '0';
                } else {
                    throw new IllegalArgumentException("Invalid nanoseconds: " + str);
                }
            }
        }
        return i4;
    }

    private void B(JSONArray jSONArray) {
        if (jSONArray.length() == 1) {
            return;
        }
        throw new IllegalArgumentException("Only queries with a single 'from' clause are supported by the Android SDK");
    }

    private void C(JSONObject jSONObject) {
        if (!jSONObject.has(TypedValues.CycleType.S_WAVE_OFFSET)) {
            return;
        }
        throw new IllegalArgumentException("Queries with offsets are not supported by the Android SDK");
    }

    private void D(JSONObject jSONObject) {
        if (!jSONObject.has("select")) {
            return;
        }
        throw new IllegalArgumentException("Queries with 'select' statements are not supported by the Android SDK");
    }

    private void a(Value.Builder builder, @Nullable JSONArray jSONArray) throws JSONException {
        ArrayValue.Builder newBuilder = ArrayValue.newBuilder();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                newBuilder.addValues(y(jSONArray.getJSONObject(i4)));
            }
        }
        builder.setArrayValue(newBuilder);
    }

    private BundledQuery b(JSONObject jSONObject) throws JSONException {
        String str;
        JSONObject jSONObject2 = jSONObject.getJSONObject("structuredQuery");
        D(jSONObject2);
        ResourcePath n4 = n(jSONObject.getString("parent"));
        JSONArray jSONArray = jSONObject2.getJSONArray("from");
        B(jSONArray);
        JSONObject jSONObject3 = jSONArray.getJSONObject(0);
        if (jSONObject3.optBoolean("allDescendants", false)) {
            str = jSONObject3.getString("collectionId");
        } else {
            n4 = n4.append(jSONObject3.getString("collectionId"));
            str = null;
        }
        List<Filter> z3 = z(jSONObject2.optJSONObject("where"));
        List<OrderBy> o4 = o(jSONObject2.optJSONArray("orderBy"));
        Bound r4 = r(jSONObject2.optJSONObject("startAt"));
        Bound e4 = e(jSONObject2.optJSONObject("endAt"));
        C(jSONObject2);
        int k4 = k(jSONObject2);
        return new BundledQuery(new Query(n4, str, z3, o4, k4, Query.LimitType.LIMIT_TO_FIRST, r4, e4).toTarget(), l(jSONObject));
    }

    private void c(List<Filter> list, JSONObject jSONObject) throws JSONException {
        if (jSONObject.getString("op").equals("AND")) {
            JSONArray optJSONArray = jSONObject.optJSONArray("filters");
            if (optJSONArray != null) {
                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                    i(list, optJSONArray.getJSONObject(i4));
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The Android SDK only supports composite filters of type 'AND'");
    }

    private Bound e(@Nullable JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            return new Bound(p(jSONObject), !jSONObject.optBoolean("before", false));
        }
        return null;
    }

    private void f(List<Filter> list, JSONObject jSONObject) throws JSONException {
        list.add(FieldFilter.create(h(jSONObject.getJSONObject("field")), g(jSONObject.getString("op")), y(jSONObject.getJSONObject("value"))));
    }

    private FieldFilter.Operator g(String str) {
        return FieldFilter.Operator.valueOf(str);
    }

    private FieldPath h(JSONObject jSONObject) throws JSONException {
        return FieldPath.fromServerFormat(jSONObject.getString("fieldPath"));
    }

    private void i(List<Filter> list, JSONObject jSONObject) throws JSONException {
        if (jSONObject.has("compositeFilter")) {
            c(list, jSONObject.getJSONObject("compositeFilter"));
        } else if (jSONObject.has("fieldFilter")) {
            f(list, jSONObject.getJSONObject("fieldFilter"));
        } else if (jSONObject.has("unaryFilter")) {
            x(list, jSONObject.getJSONObject("unaryFilter"));
        }
    }

    private void j(Value.Builder builder, JSONObject jSONObject) {
        builder.setGeoPointValue(LatLng.newBuilder().setLatitude(jSONObject.optDouble("latitude")).setLongitude(jSONObject.optDouble("longitude")));
    }

    private int k(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("limit");
        if (optJSONObject != null) {
            return optJSONObject.optInt("value", -1);
        }
        return jSONObject.optInt("limit", -1);
    }

    private Query.LimitType l(JSONObject jSONObject) {
        String optString = jSONObject.optString("limitType", "FIRST");
        if (optString.equals("FIRST")) {
            return Query.LimitType.LIMIT_TO_FIRST;
        }
        if (optString.equals("LAST")) {
            return Query.LimitType.LIMIT_TO_LAST;
        }
        throw new IllegalArgumentException("Invalid limit type for bundle query: " + optString);
    }

    private void m(Value.Builder builder, @Nullable JSONObject jSONObject) throws JSONException {
        MapValue.Builder newBuilder = MapValue.newBuilder();
        if (jSONObject != null) {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                newBuilder.putFields(next, y(jSONObject.getJSONObject(next)));
            }
        }
        builder.setMapValue(newBuilder);
    }

    private ResourcePath n(String str) {
        ResourcePath fromString = ResourcePath.fromString(str);
        if (this.f30290b.isLocalResourceName(fromString)) {
            return fromString.popFirst(5);
        }
        throw new IllegalArgumentException("Resource name is not valid for current instance: " + str);
    }

    private List<OrderBy> o(@Nullable JSONArray jSONArray) throws JSONException {
        OrderBy.Direction direction;
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i4);
                FieldPath h4 = h(jSONObject.getJSONObject("field"));
                if (jSONObject.optString("direction", "ASCENDING").equals("ASCENDING")) {
                    direction = OrderBy.Direction.ASCENDING;
                } else {
                    direction = OrderBy.Direction.DESCENDING;
                }
                arrayList.add(OrderBy.getInstance(direction, h4));
            }
        }
        return arrayList;
    }

    private List<Value> p(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("values");
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                arrayList.add(y(optJSONArray.getJSONObject(i4)));
            }
        }
        return arrayList;
    }

    private SnapshotVersion q(Object obj) throws JSONException {
        return new SnapshotVersion(s(obj));
    }

    private Bound r(@Nullable JSONObject jSONObject) throws JSONException {
        if (jSONObject != null) {
            return new Bound(p(jSONObject), jSONObject.optBoolean("before", false));
        }
        return null;
    }

    private Timestamp s(Object obj) throws JSONException {
        if (obj instanceof String) {
            return t((String) obj);
        }
        if (obj instanceof JSONObject) {
            return u((JSONObject) obj);
        }
        throw new IllegalArgumentException("Timestamps must be either ISO 8601-formatted strings or JSON objects");
    }

    private Timestamp t(String str) {
        try {
            int indexOf = str.indexOf(84);
            if (indexOf != -1) {
                int indexOf2 = str.indexOf(90, indexOf);
                if (indexOf2 == -1) {
                    indexOf2 = str.indexOf(43, indexOf);
                }
                if (indexOf2 == -1) {
                    indexOf2 = str.indexOf(45, indexOf);
                }
                if (indexOf2 != -1) {
                    int i4 = 0;
                    String substring = str.substring(0, indexOf2);
                    String str2 = "";
                    int indexOf3 = substring.indexOf(46);
                    if (indexOf3 != -1) {
                        String substring2 = substring.substring(0, indexOf3);
                        str2 = substring.substring(indexOf3 + 1);
                        substring = substring2;
                    }
                    long time = this.f30289a.parse(substring).getTime() / 1000;
                    if (!str2.isEmpty()) {
                        i4 = A(str2);
                    }
                    if (str.charAt(indexOf2) == 'Z') {
                        if (str.length() != indexOf2 + 1) {
                            throw new IllegalArgumentException("Invalid timestamp: Invalid trailing data \"" + str.substring(indexOf2) + "\"");
                        }
                    } else {
                        long w3 = w(str.substring(indexOf2 + 1));
                        if (str.charAt(indexOf2) == '+') {
                            time -= w3;
                        } else {
                            time += w3;
                        }
                    }
                    return new Timestamp(time, i4);
                }
                throw new IllegalArgumentException("Invalid timestamp: Missing valid timezone offset: " + str);
            }
            throw new IllegalArgumentException("Invalid timestamp: " + str);
        } catch (ParseException e4) {
            throw new IllegalArgumentException("Failed to parse timestamp", e4);
        }
    }

    private Timestamp u(JSONObject jSONObject) {
        return new Timestamp(jSONObject.optLong("seconds"), jSONObject.optInt("nanos"));
    }

    private void v(Value.Builder builder, Object obj) throws JSONException {
        Timestamp s3 = s(obj);
        builder.setTimestampValue(com.google.protobuf.Timestamp.newBuilder().setSeconds(s3.getSeconds()).setNanos(s3.getNanoseconds()));
    }

    private static long w(String str) {
        int indexOf = str.indexOf(58);
        if (indexOf != -1) {
            return ((Long.parseLong(str.substring(0, indexOf)) * 60) + Long.parseLong(str.substring(indexOf + 1))) * 60;
        }
        throw new IllegalArgumentException("Invalid offset value: " + str);
    }

    private void x(List<Filter> list, JSONObject jSONObject) throws JSONException {
        FieldPath h4 = h(jSONObject.getJSONObject("field"));
        String string = jSONObject.getString("op");
        string.hashCode();
        char c4 = 65535;
        switch (string.hashCode()) {
            case -2125479834:
                if (string.equals("IS_NAN")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1465346180:
                if (string.equals("IS_NULL")) {
                    c4 = 1;
                    break;
                }
                break;
            case -244195494:
                if (string.equals("IS_NOT_NAN")) {
                    c4 = 2;
                    break;
                }
                break;
            case 1019893512:
                if (string.equals("IS_NOT_NULL")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                list.add(FieldFilter.create(h4, FieldFilter.Operator.EQUAL, Values.NAN_VALUE));
                return;
            case 1:
                list.add(FieldFilter.create(h4, FieldFilter.Operator.EQUAL, Values.NULL_VALUE));
                return;
            case 2:
                list.add(FieldFilter.create(h4, FieldFilter.Operator.NOT_EQUAL, Values.NAN_VALUE));
                return;
            case 3:
                list.add(FieldFilter.create(h4, FieldFilter.Operator.NOT_EQUAL, Values.NULL_VALUE));
                return;
            default:
                throw new IllegalArgumentException("Unexpected unary filter: " + string);
        }
    }

    private Value y(JSONObject jSONObject) throws JSONException {
        Value.Builder newBuilder = Value.newBuilder();
        if (jSONObject.has("nullValue")) {
            newBuilder.setNullValue(NullValue.NULL_VALUE);
        } else if (jSONObject.has("booleanValue")) {
            newBuilder.setBooleanValue(jSONObject.optBoolean("booleanValue", false));
        } else if (jSONObject.has("integerValue")) {
            newBuilder.setIntegerValue(jSONObject.optLong("integerValue"));
        } else if (jSONObject.has("doubleValue")) {
            newBuilder.setDoubleValue(jSONObject.optDouble("doubleValue"));
        } else if (jSONObject.has("timestampValue")) {
            v(newBuilder, jSONObject.get("timestampValue"));
        } else if (jSONObject.has("stringValue")) {
            newBuilder.setStringValue(jSONObject.optString("stringValue", ""));
        } else if (jSONObject.has("bytesValue")) {
            newBuilder.setBytesValue(ByteString.copyFrom(Base64.decode(jSONObject.getString("bytesValue"), 0)));
        } else if (jSONObject.has("referenceValue")) {
            newBuilder.setReferenceValue(jSONObject.getString("referenceValue"));
        } else if (jSONObject.has("geoPointValue")) {
            j(newBuilder, jSONObject.getJSONObject("geoPointValue"));
        } else if (jSONObject.has("arrayValue")) {
            a(newBuilder, jSONObject.getJSONObject("arrayValue").optJSONArray("values"));
        } else if (jSONObject.has("mapValue")) {
            m(newBuilder, jSONObject.getJSONObject("mapValue").optJSONObject("fields"));
        } else {
            throw new IllegalArgumentException("Unexpected value type: " + jSONObject);
        }
        return newBuilder.build();
    }

    private List<Filter> z(@Nullable JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (jSONObject != null) {
            i(arrayList, jSONObject);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BundleDocument d(JSONObject jSONObject) throws JSONException {
        DocumentKey fromPath = DocumentKey.fromPath(n(jSONObject.getString("name")));
        SnapshotVersion q4 = q(jSONObject.get("updateTime"));
        Value.Builder newBuilder = Value.newBuilder();
        m(newBuilder, jSONObject.getJSONObject("fields"));
        return new BundleDocument(MutableDocument.newFoundDocument(fromPath, q4, ObjectValue.fromMap(newBuilder.getMapValue().getFieldsMap())));
    }

    public BundleMetadata decodeBundleMetadata(JSONObject jSONObject) throws JSONException {
        return new BundleMetadata(jSONObject.getString("id"), jSONObject.getInt("version"), q(jSONObject.get("createTime")), jSONObject.getInt("totalDocuments"), jSONObject.getLong("totalBytes"));
    }

    public BundledDocumentMetadata decodeBundledDocumentMetadata(JSONObject jSONObject) throws JSONException {
        DocumentKey fromPath = DocumentKey.fromPath(n(jSONObject.getString("name")));
        SnapshotVersion q4 = q(jSONObject.get("readTime"));
        boolean optBoolean = jSONObject.optBoolean("exists", false);
        JSONArray optJSONArray = jSONObject.optJSONArray("queries");
        ArrayList arrayList = new ArrayList();
        if (optJSONArray != null) {
            for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                arrayList.add(optJSONArray.getString(i4));
            }
        }
        return new BundledDocumentMetadata(fromPath, q4, optBoolean, arrayList);
    }

    public NamedQuery decodeNamedQuery(JSONObject jSONObject) throws JSONException {
        return new NamedQuery(jSONObject.getString("name"), b(jSONObject.getJSONObject("bundledQuery")), q(jSONObject.get("readTime")));
    }
}
