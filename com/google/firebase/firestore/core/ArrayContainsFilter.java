package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class ArrayContainsFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ArrayContainsFilter(FieldPath fieldPath, Value value) {
        super(fieldPath, FieldFilter.Operator.ARRAY_CONTAINS, value);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        Value field = document.getField(getField());
        if (Values.isArray(field) && Values.contains(field.getArrayValue(), getValue())) {
            return true;
        }
        return false;
    }
}
