package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firestore.v1.Value;
import java.util.List;

/* loaded from: classes5.dex */
public final class Bound {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f30307a;

    /* renamed from: b  reason: collision with root package name */
    private final List<Value> f30308b;

    public Bound(List<Value> list, boolean z3) {
        this.f30308b = list;
        this.f30307a = z3;
    }

    private int a(List<OrderBy> list, Document document) {
        boolean z3;
        boolean z4;
        int compare;
        if (this.f30308b.size() <= list.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Bound has more components than query's orderBy", new Object[0]);
        int i4 = 0;
        for (int i5 = 0; i5 < this.f30308b.size(); i5++) {
            OrderBy orderBy = list.get(i5);
            Value value = this.f30308b.get(i5);
            if (orderBy.f30374b.equals(FieldPath.KEY_PATH)) {
                Assert.hardAssert(Values.isReferenceValue(value), "Bound has a non-key value where the key path is being used %s", value);
                compare = DocumentKey.fromName(value.getReferenceValue()).compareTo(document.getKey());
            } else {
                Value field = document.getField(orderBy.getField());
                if (field != null) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                Assert.hardAssert(z4, "Field should exist since document matched the orderBy already.", new Object[0]);
                compare = Values.compare(value, field);
            }
            if (orderBy.getDirection().equals(OrderBy.Direction.DESCENDING)) {
                compare *= -1;
            }
            i4 = compare;
            if (i4 != 0) {
                break;
            }
        }
        return i4;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Bound.class != obj.getClass()) {
            return false;
        }
        Bound bound = (Bound) obj;
        if (this.f30307a == bound.f30307a && this.f30308b.equals(bound.f30308b)) {
            return true;
        }
        return false;
    }

    public List<Value> getPosition() {
        return this.f30308b;
    }

    public int hashCode() {
        return ((this.f30307a ? 1 : 0) * 31) + this.f30308b.hashCode();
    }

    public boolean isInclusive() {
        return this.f30307a;
    }

    public String positionString() {
        StringBuilder sb = new StringBuilder();
        boolean z3 = true;
        for (Value value : this.f30308b) {
            if (!z3) {
                sb.append(",");
            }
            sb.append(Values.canonicalId(value));
            z3 = false;
        }
        return sb.toString();
    }

    public boolean sortsAfterDocument(List<OrderBy> list, Document document) {
        int a4 = a(list, document);
        if (this.f30307a) {
            if (a4 >= 0) {
                return true;
            }
        } else if (a4 > 0) {
            return true;
        }
        return false;
    }

    public boolean sortsBeforeDocument(List<OrderBy> list, Document document) {
        int a4 = a(list, document);
        if (this.f30307a) {
            if (a4 <= 0) {
                return true;
            }
        } else if (a4 < 0) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bound(inclusive=");
        sb.append(this.f30307a);
        sb.append(", position=");
        for (int i4 = 0; i4 < this.f30308b.size(); i4++) {
            if (i4 > 0) {
                sb.append(" and ");
            }
            sb.append(Values.canonicalId(this.f30308b.get(i4)));
        }
        sb.append(")");
        return sb.toString();
    }
}
