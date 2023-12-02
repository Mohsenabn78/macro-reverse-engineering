package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class ArrayContainsAnyFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayContainsAnyFilter(FieldPath fieldPath, Value value) {
        super(fieldPath, FieldFilter.Operator.ARRAY_CONTAINS_ANY, value);
        Assert.hardAssert(Values.isArray(value), "ArrayContainsAnyFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        Value field = document.getField(getField());
        if (!Values.isArray(field)) {
            return false;
        }
        for (Value value : field.getArrayValue().getValuesList()) {
            if (Values.contains(getValue().getArrayValue(), value)) {
                return true;
            }
        }
        return false;
    }
}
