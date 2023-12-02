package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.List;

/* loaded from: classes5.dex */
public class KeyFieldNotInFilter extends FieldFilter {

    /* renamed from: d  reason: collision with root package name */
    private final List<DocumentKey> f30363d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public KeyFieldNotInFilter(com.google.firebase.firestore.model.FieldPath r2, com.google.firestore.v1.Value r3) {
        /*
            r1 = this;
            com.google.firebase.firestore.core.FieldFilter$Operator r0 = com.google.firebase.firestore.core.FieldFilter.Operator.NOT_IN
            r1.<init>(r2, r0, r3)
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.f30363d = r2
            java.util.List r3 = com.google.firebase.firestore.core.KeyFieldInFilter.b(r0, r3)
            r2.addAll(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.firestore.core.KeyFieldNotInFilter.<init>(com.google.firebase.firestore.model.FieldPath, com.google.firestore.v1.Value):void");
    }

    @Override // com.google.firebase.firestore.core.FieldFilter, com.google.firebase.firestore.core.Filter
    public boolean matches(Document document) {
        return !this.f30363d.contains(document.getKey());
    }
}
