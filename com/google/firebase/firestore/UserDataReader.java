package com.google.firebase.firestore;

import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.core.UserData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.ObjectValue;
import com.google.firebase.firestore.model.mutation.ArrayTransformOperation;
import com.google.firebase.firestore.model.mutation.FieldMask;
import com.google.firebase.firestore.model.mutation.NumericIncrementTransformOperation;
import com.google.firebase.firestore.model.mutation.ServerTimestampOperation;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.CustomClassMapper;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.MapValue;
import com.google.firestore.v1.Value;
import com.google.protobuf.NullValue;
import com.google.type.LatLng;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes5.dex */
public final class UserDataReader {

    /* renamed from: a  reason: collision with root package name */
    private final DatabaseId f30241a;

    public UserDataReader(DatabaseId databaseId) {
        this.f30241a = databaseId;
    }

    private ObjectValue a(Object obj, UserData.ParseContext parseContext) {
        if (!obj.getClass().isArray()) {
            Value c4 = c(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
            if (c4.getValueTypeCase() == Value.ValueTypeCase.MAP_VALUE) {
                return new ObjectValue(c4);
            }
            throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was of type: " + Util.typeName(obj));
        }
        throw new IllegalArgumentException("Invalid data. Data must be a Map<String, Object> or a suitable POJO object, but it was an array");
    }

    private List<Value> b(List<Object> list) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Argument);
        ArrayList arrayList = new ArrayList(list.size());
        for (int i4 = 0; i4 < list.size(); i4++) {
            arrayList.add(convertAndParseFieldData(list.get(i4), parseAccumulator.rootContext().childContext(i4)));
        }
        return arrayList;
    }

    @Nullable
    private Value c(Object obj, UserData.ParseContext parseContext) {
        if (obj instanceof Map) {
            return e((Map) obj, parseContext);
        }
        if (obj instanceof FieldValue) {
            g((FieldValue) obj, parseContext);
            return null;
        }
        if (parseContext.getPath() != null) {
            parseContext.addToFieldMask(parseContext.getPath());
        }
        if (obj instanceof List) {
            if (parseContext.isArrayElement() && parseContext.getDataSource() != UserData.Source.ArrayArgument) {
                throw parseContext.createError("Nested arrays are not supported");
            }
            return d((List) obj, parseContext);
        }
        return f(obj, parseContext);
    }

    private <T> Value d(List<T> list, UserData.ParseContext parseContext) {
        ArrayValue.Builder newBuilder = ArrayValue.newBuilder();
        int i4 = 0;
        for (T t3 : list) {
            Value c4 = c(t3, parseContext.childContext(i4));
            if (c4 == null) {
                c4 = Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
            }
            newBuilder.addValues(c4);
            i4++;
        }
        return Value.newBuilder().setArrayValue(newBuilder).build();
    }

    private <K, V> Value e(Map<K, V> map, UserData.ParseContext parseContext) {
        if (map.isEmpty()) {
            if (parseContext.getPath() != null && !parseContext.getPath().isEmpty()) {
                parseContext.addToFieldMask(parseContext.getPath());
            }
            return Value.newBuilder().setMapValue(MapValue.getDefaultInstance()).build();
        }
        MapValue.Builder newBuilder = MapValue.newBuilder();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (entry.getKey() instanceof String) {
                String str = (String) entry.getKey();
                Value c4 = c(entry.getValue(), parseContext.childContext(str));
                if (c4 != null) {
                    newBuilder.putFields(str, c4);
                }
            } else {
                throw parseContext.createError(String.format("Non-String Map key (%s) is not allowed", entry.getValue()));
            }
        }
        return Value.newBuilder().setMapValue(newBuilder).build();
    }

    private Value f(Object obj, UserData.ParseContext parseContext) {
        if (obj == null) {
            return Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
        }
        if (obj instanceof Integer) {
            return Value.newBuilder().setIntegerValue(((Integer) obj).intValue()).build();
        }
        if (obj instanceof Long) {
            return Value.newBuilder().setIntegerValue(((Long) obj).longValue()).build();
        }
        if (obj instanceof Float) {
            return Value.newBuilder().setDoubleValue(((Float) obj).doubleValue()).build();
        }
        if (obj instanceof Double) {
            return Value.newBuilder().setDoubleValue(((Double) obj).doubleValue()).build();
        }
        if (obj instanceof Boolean) {
            return Value.newBuilder().setBooleanValue(((Boolean) obj).booleanValue()).build();
        }
        if (obj instanceof String) {
            return Value.newBuilder().setStringValue((String) obj).build();
        }
        if (obj instanceof Date) {
            return h(new Timestamp((Date) obj));
        }
        if (obj instanceof Timestamp) {
            return h((Timestamp) obj);
        }
        if (obj instanceof GeoPoint) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return Value.newBuilder().setGeoPointValue(LatLng.newBuilder().setLatitude(geoPoint.getLatitude()).setLongitude(geoPoint.getLongitude())).build();
        } else if (obj instanceof Blob) {
            return Value.newBuilder().setBytesValue(((Blob) obj).toByteString()).build();
        } else {
            if (obj instanceof DocumentReference) {
                DocumentReference documentReference = (DocumentReference) obj;
                if (documentReference.getFirestore() != null) {
                    DatabaseId j4 = documentReference.getFirestore().j();
                    if (!j4.equals(this.f30241a)) {
                        throw parseContext.createError(String.format("Document reference is for database %s/%s but should be for database %s/%s", j4.getProjectId(), j4.getDatabaseId(), this.f30241a.getProjectId(), this.f30241a.getDatabaseId()));
                    }
                }
                return Value.newBuilder().setReferenceValue(String.format("projects/%s/databases/%s/documents/%s", this.f30241a.getProjectId(), this.f30241a.getDatabaseId(), documentReference.getPath())).build();
            } else if (obj.getClass().isArray()) {
                throw parseContext.createError("Arrays are not supported; use a List instead");
            } else {
                throw parseContext.createError("Unsupported type: " + Util.typeName(obj));
            }
        }
    }

    private void g(FieldValue fieldValue, UserData.ParseContext parseContext) {
        boolean z3 = true;
        if (parseContext.isWrite()) {
            if (parseContext.getPath() != null) {
                if (fieldValue instanceof FieldValue.DeleteFieldValue) {
                    if (parseContext.getDataSource() == UserData.Source.MergeSet) {
                        parseContext.addToFieldMask(parseContext.getPath());
                        return;
                    } else if (parseContext.getDataSource() == UserData.Source.Update) {
                        if (parseContext.getPath().length() <= 0) {
                            z3 = false;
                        }
                        Assert.hardAssert(z3, "FieldValue.delete() at the top level should have already been handled.", new Object[0]);
                        throw parseContext.createError("FieldValue.delete() can only appear at the top level of your update data");
                    } else {
                        throw parseContext.createError("FieldValue.delete() can only be used with update() and set() with SetOptions.merge()");
                    }
                } else if (fieldValue instanceof FieldValue.ServerTimestampFieldValue) {
                    parseContext.addToFieldTransforms(parseContext.getPath(), ServerTimestampOperation.getInstance());
                    return;
                } else if (fieldValue instanceof FieldValue.ArrayUnionFieldValue) {
                    parseContext.addToFieldTransforms(parseContext.getPath(), new ArrayTransformOperation.Union(b(((FieldValue.ArrayUnionFieldValue) fieldValue).b())));
                    return;
                } else if (fieldValue instanceof FieldValue.ArrayRemoveFieldValue) {
                    parseContext.addToFieldTransforms(parseContext.getPath(), new ArrayTransformOperation.Remove(b(((FieldValue.ArrayRemoveFieldValue) fieldValue).b())));
                    return;
                } else if (fieldValue instanceof FieldValue.NumericIncrementFieldValue) {
                    parseContext.addToFieldTransforms(parseContext.getPath(), new NumericIncrementTransformOperation(parseQueryValue(((FieldValue.NumericIncrementFieldValue) fieldValue).b())));
                    return;
                } else {
                    throw Assert.fail("Unknown FieldValue type: %s", Util.typeName(fieldValue));
                }
            }
            throw parseContext.createError(String.format("%s() is not currently supported inside arrays", fieldValue.a()));
        }
        throw parseContext.createError(String.format("%s() can only be used with set() and update()", fieldValue.a()));
    }

    private Value h(Timestamp timestamp) {
        return Value.newBuilder().setTimestampValue(com.google.protobuf.Timestamp.newBuilder().setSeconds(timestamp.getSeconds()).setNanos((timestamp.getNanoseconds() / 1000) * 1000)).build();
    }

    public Value convertAndParseFieldData(Object obj, UserData.ParseContext parseContext) {
        return c(CustomClassMapper.convertToPlainJavaTypes(obj), parseContext);
    }

    public UserData.ParsedSetData parseMergeData(Object obj, @Nullable FieldMask fieldMask) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.MergeSet);
        ObjectValue a4 = a(obj, parseAccumulator.rootContext());
        if (fieldMask != null) {
            for (com.google.firebase.firestore.model.FieldPath fieldPath : fieldMask.getMask()) {
                if (!parseAccumulator.contains(fieldPath)) {
                    throw new IllegalArgumentException("Field '" + fieldPath.toString() + "' is specified in your field mask but not in your input data.");
                }
            }
            return parseAccumulator.toMergeData(a4, fieldMask);
        }
        return parseAccumulator.toMergeData(a4);
    }

    public Value parseQueryValue(Object obj) {
        return parseQueryValue(obj, false);
    }

    public UserData.ParsedSetData parseSetData(Object obj) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Set);
        return parseAccumulator.toSetData(a(obj, parseAccumulator.rootContext()));
    }

    public UserData.ParsedUpdateData parseUpdateData(Map<String, Object> map) {
        Preconditions.checkNotNull(map, "Provided update data must not be null.");
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue objectValue = new ObjectValue();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            com.google.firebase.firestore.model.FieldPath b4 = FieldPath.a(entry.getKey()).b();
            Object value = entry.getValue();
            if (value instanceof FieldValue.DeleteFieldValue) {
                rootContext.addToFieldMask(b4);
            } else {
                Value convertAndParseFieldData = convertAndParseFieldData(value, rootContext.childContext(b4));
                if (convertAndParseFieldData != null) {
                    rootContext.addToFieldMask(b4);
                    objectValue.set(b4, convertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(objectValue);
    }

    public Value parseQueryValue(Object obj, boolean z3) {
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(z3 ? UserData.Source.ArrayArgument : UserData.Source.Argument);
        Value convertAndParseFieldData = convertAndParseFieldData(obj, parseAccumulator.rootContext());
        Assert.hardAssert(convertAndParseFieldData != null, "Parsed data should not be null.", new Object[0]);
        Assert.hardAssert(parseAccumulator.getFieldTransforms().isEmpty(), "Field transforms should have been disallowed.", new Object[0]);
        return convertAndParseFieldData;
    }

    public UserData.ParsedUpdateData parseUpdateData(List<Object> list) {
        com.google.firebase.firestore.model.FieldPath b4;
        Assert.hardAssert(list.size() % 2 == 0, "Expected fieldAndValues to contain an even number of elements", new Object[0]);
        UserData.ParseAccumulator parseAccumulator = new UserData.ParseAccumulator(UserData.Source.Update);
        UserData.ParseContext rootContext = parseAccumulator.rootContext();
        ObjectValue objectValue = new ObjectValue();
        Iterator<Object> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            Object next2 = it.next();
            boolean z3 = next instanceof String;
            Assert.hardAssert(z3 || (next instanceof FieldPath), "Expected argument to be String or FieldPath.", new Object[0]);
            if (z3) {
                b4 = FieldPath.a((String) next).b();
            } else {
                b4 = ((FieldPath) next).b();
            }
            if (next2 instanceof FieldValue.DeleteFieldValue) {
                rootContext.addToFieldMask(b4);
            } else {
                Value convertAndParseFieldData = convertAndParseFieldData(next2, rootContext.childContext(b4));
                if (convertAndParseFieldData != null) {
                    rootContext.addToFieldMask(b4);
                    objectValue.set(b4, convertAndParseFieldData);
                }
            }
        }
        return parseAccumulator.toUpdateData(objectValue);
    }
}
