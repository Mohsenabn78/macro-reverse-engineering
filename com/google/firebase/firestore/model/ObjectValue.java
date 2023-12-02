package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class ObjectValue implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private Value f30968a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f30969b;

    public ObjectValue(Value value) {
        this.f30969b = new HashMap();
        Assert.hardAssert(value.getValueTypeCase() == Value.ValueTypeCase.MAP_VALUE, "ObjectValues should be backed by a MapValue", new Object[0]);
        Assert.hardAssert(!ServerTimestamps.isServerTimestamp(value), "ServerTimestamps should not be used as an ObjectValue", new Object[0]);
        this.f30968a = value;
    }

    @Nullable
    private MapValue a(FieldPath fieldPath, Map<String, Object> map) {
        MapValue.Builder newBuilder;
        boolean z3;
        Value d4 = d(this.f30968a, fieldPath);
        if (Values.isMapValue(d4)) {
            newBuilder = d4.getMapValue().toBuilder();
        } else {
            newBuilder = MapValue.newBuilder();
        }
        boolean z4 = false;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Map) {
                MapValue a4 = a(fieldPath.append(key), (Map) value);
                if (a4 != null) {
                    newBuilder.putFields(key, Value.newBuilder().setMapValue(a4).build());
                    z4 = true;
                }
            } else {
                if (value instanceof Value) {
                    newBuilder.putFields(key, (Value) value);
                } else if (newBuilder.containsFields(key)) {
                    if (value == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Assert.hardAssert(z3, "Expected entry to be a Map, a Value or null", new Object[0]);
                    newBuilder.removeFields(key);
                }
                z4 = true;
            }
        }
        if (z4) {
            return newBuilder.build();
        }
        return null;
    }

    private Value b() {
        synchronized (this.f30969b) {
            MapValue a4 = a(FieldPath.EMPTY_PATH, this.f30969b);
            if (a4 != null) {
                this.f30968a = Value.newBuilder().setMapValue(a4).build();
                this.f30969b.clear();
            }
        }
        return this.f30968a;
    }

    private FieldMask c(MapValue mapValue) {
        HashSet hashSet = new HashSet();
        for (Map.Entry<String, Value> entry : mapValue.getFieldsMap().entrySet()) {
            FieldPath fromSingleSegment = FieldPath.fromSingleSegment(entry.getKey());
            if (Values.isMapValue(entry.getValue())) {
                Set<FieldPath> mask = c(entry.getValue().getMapValue()).getMask();
                if (mask.isEmpty()) {
                    hashSet.add(fromSingleSegment);
                } else {
                    for (FieldPath fieldPath : mask) {
                        hashSet.add(fromSingleSegment.append(fieldPath));
                    }
                }
            } else {
                hashSet.add(fromSingleSegment);
            }
        }
        return FieldMask.fromSet(hashSet);
    }

    @Nullable
    private Value d(Value value, FieldPath fieldPath) {
        if (fieldPath.isEmpty()) {
            return value;
        }
        for (int i4 = 0; i4 < fieldPath.length() - 1; i4++) {
            value = value.getMapValue().getFieldsOrDefault(fieldPath.getSegment(i4), null);
            if (!Values.isMapValue(value)) {
                return null;
            }
        }
        return value.getMapValue().getFieldsOrDefault(fieldPath.getLastSegment(), null);
    }

    private void e(FieldPath fieldPath, @Nullable Value value) {
        Object hashMap;
        HashMap hashMap2 = this.f30969b;
        for (int i4 = 0; i4 < fieldPath.length() - 1; i4++) {
            String segment = fieldPath.getSegment(i4);
            Object obj = hashMap2.get(segment);
            if (obj instanceof Map) {
                hashMap = (Map) obj;
            } else {
                if (obj instanceof Value) {
                    Value value2 = (Value) obj;
                    if (value2.getValueTypeCase() == Value.ValueTypeCase.MAP_VALUE) {
                        HashMap hashMap3 = new HashMap(value2.getMapValue().getFieldsMap());
                        hashMap2.put(segment, hashMap3);
                        hashMap2 = hashMap3;
                    }
                }
                hashMap = new HashMap();
                hashMap2.put(segment, hashMap);
            }
            hashMap2 = hashMap;
        }
        hashMap2.put(fieldPath.getLastSegment(), value);
    }

    public static ObjectValue fromMap(Map<String, Value> map) {
        return new ObjectValue(Value.newBuilder().setMapValue(MapValue.newBuilder().putAllFields(map)).build());
    }

    public void delete(FieldPath fieldPath) {
        Assert.hardAssert(!fieldPath.isEmpty(), "Cannot delete field for empty path on ObjectValue", new Object[0]);
        e(fieldPath, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ObjectValue) {
            return Values.equals(b(), ((ObjectValue) obj).b());
        }
        return false;
    }

    @Nullable
    public Value get(FieldPath fieldPath) {
        return d(b(), fieldPath);
    }

    public FieldMask getFieldMask() {
        return c(b().getMapValue());
    }

    public Map<String, Value> getFieldsMap() {
        return b().getMapValue().getFieldsMap();
    }

    public int hashCode() {
        return b().hashCode();
    }

    public void set(FieldPath fieldPath, Value value) {
        Assert.hardAssert(!fieldPath.isEmpty(), "Cannot set field for empty path on ObjectValue", new Object[0]);
        e(fieldPath, value);
    }

    public void setAll(Map<FieldPath, Value> map) {
        for (Map.Entry<FieldPath, Value> entry : map.entrySet()) {
            FieldPath key = entry.getKey();
            if (entry.getValue() == null) {
                delete(key);
            } else {
                set(key, entry.getValue());
            }
        }
    }

    @NonNull
    public String toString() {
        return "ObjectValue{internalValue=" + Values.canonicalId(b()) + '}';
    }

    @NonNull
    /* renamed from: clone */
    public ObjectValue m4168clone() {
        return new ObjectValue(b());
    }

    public ObjectValue() {
        this(Value.newBuilder().setMapValue(MapValue.getDefaultInstance()).build());
    }
}
