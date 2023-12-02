package com.google.firebase.firestore.model.mutation;

import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.firestore.model.Values;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Value;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public abstract class ArrayTransformOperation implements TransformOperation {

    /* renamed from: a  reason: collision with root package name */
    private final List<Value> f30978a;

    /* loaded from: classes5.dex */
    public static class Remove extends ArrayTransformOperation {
        public Remove(List<Value> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        protected Value a(@Nullable Value value) {
            ArrayValue.Builder b4 = ArrayTransformOperation.b(value);
            for (Value value2 : getElements()) {
                int i4 = 0;
                while (i4 < b4.getValuesCount()) {
                    if (Values.equals(b4.getValues(i4), value2)) {
                        b4.removeValues(i4);
                    } else {
                        i4++;
                    }
                }
            }
            return Value.newBuilder().setArrayValue(b4).build();
        }
    }

    /* loaded from: classes5.dex */
    public static class Union extends ArrayTransformOperation {
        public Union(List<Value> list) {
            super(list);
        }

        @Override // com.google.firebase.firestore.model.mutation.ArrayTransformOperation
        protected Value a(@Nullable Value value) {
            ArrayValue.Builder b4 = ArrayTransformOperation.b(value);
            for (Value value2 : getElements()) {
                if (!Values.contains(b4, value2)) {
                    b4.addValues(value2);
                }
            }
            return Value.newBuilder().setArrayValue(b4).build();
        }
    }

    ArrayTransformOperation(List<Value> list) {
        this.f30978a = Collections.unmodifiableList(list);
    }

    static ArrayValue.Builder b(@Nullable Value value) {
        if (Values.isArray(value)) {
            return value.getArrayValue().toBuilder();
        }
        return ArrayValue.newBuilder();
    }

    protected abstract Value a(@Nullable Value value);

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value applyToLocalView(@Nullable Value value, Timestamp timestamp) {
        return a(value);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    public Value applyToRemoteDocument(@Nullable Value value, Value value2) {
        return a(value);
    }

    @Override // com.google.firebase.firestore.model.mutation.TransformOperation
    @Nullable
    public Value computeBaseValue(@Nullable Value value) {
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return this.f30978a.equals(((ArrayTransformOperation) obj).f30978a);
        }
        return false;
    }

    public List<Value> getElements() {
        return this.f30978a;
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.f30978a.hashCode();
    }
}
