package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class KeyFieldFilter extends FieldFilter {

    /* renamed from: d  reason: collision with root package name */
    private final DocumentKey f30361d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyFieldFilter(FieldPath fieldPath, FieldFilter.Operator operator, Value value) {
        super(fieldPath, operator, value);
        Assert.hardAssert(Values.isReferenceValue(value), "KeyFieldFilter expects a ReferenceValue", new Object[0]);
        this.f30361d = DocumentKey.fromName(getValue().getReferenceValue());
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        return a(document.getKey().compareTo(this.f30361d));
    }
}
