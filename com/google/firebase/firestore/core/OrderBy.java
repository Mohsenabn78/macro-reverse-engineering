package com.google.firebase.firestore.core;

import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;

/* loaded from: classes5.dex */
public class OrderBy {

    /* renamed from: a  reason: collision with root package name */
    private final Direction f30373a;

    /* renamed from: b  reason: collision with root package name */
    final FieldPath f30374b;

    /* loaded from: classes5.dex */
    public enum Direction {
        ASCENDING(1),
        DESCENDING(-1);
        
        private final int comparisonModifier;

        Direction(int i4) {
            this.comparisonModifier = i4;
        }

        int a() {
            return this.comparisonModifier;
        }
    }

    private OrderBy(Direction direction, FieldPath fieldPath) {
        this.f30373a = direction;
        this.f30374b = fieldPath;
    }

    public static OrderBy getInstance(Direction direction, FieldPath fieldPath) {
        return new OrderBy(direction, fieldPath);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Document document, Document document2) {
        boolean z3;
        int a4;
        int compare;
        if (this.f30374b.equals(FieldPath.KEY_PATH)) {
            a4 = this.f30373a.a();
            compare = document.getKey().compareTo(document2.getKey());
        } else {
            Value field = document.getField(this.f30374b);
            Value field2 = document2.getField(this.f30374b);
            if (field != null && field2 != null) {
                z3 = true;
            } else {
                z3 = false;
            }
            Assert.hardAssert(z3, "Trying to compare documents on fields that don't exist.", new Object[0]);
            a4 = this.f30373a.a();
            compare = Values.compare(field, field2);
        }
        return a4 * compare;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OrderBy)) {
            return false;
        }
        OrderBy orderBy = (OrderBy) obj;
        if (this.f30373a != orderBy.f30373a || !this.f30374b.equals(orderBy.f30374b)) {
            return false;
        }
        return true;
    }

    public Direction getDirection() {
        return this.f30373a;
    }

    public FieldPath getField() {
        return this.f30374b;
    }

    public int hashCode() {
        return ((899 + this.f30373a.hashCode()) * 31) + this.f30374b.hashCode();
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.f30373a == Direction.ASCENDING) {
            str = "";
        } else {
            str = "-";
        }
        sb.append(str);
        sb.append(this.f30374b.canonicalString());
        return sb.toString();
    }
}
