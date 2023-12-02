package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class NotInFilter extends FieldFilter {
    /* JADX INFO: Access modifiers changed from: package-private */
    public NotInFilter(FieldPath fieldPath, Value value) {
        super(fieldPath, FieldFilter.Operator.NOT_IN, value);
        Assert.hardAssert(Values.isArray(value), "NotInFilter expects an ArrayValue", new Object[0]);
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        Value field;
        if (Values.contains(getValue().getArrayValue(), Values.NULL_VALUE) || (field = document.getField(getField())) == null || Values.contains(getValue().getArrayValue(), field)) {
            return false;
        }
        return true;
    }
}
