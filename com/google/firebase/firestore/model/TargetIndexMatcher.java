package com.google.firebase.firestore.model;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes5.dex */
public class TargetIndexMatcher {

    /* renamed from: a  reason: collision with root package name */
    private final String f30971a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private FieldFilter f30972b;

    /* renamed from: c  reason: collision with root package name */
    private final List<FieldFilter> f30973c;

    /* renamed from: d  reason: collision with root package name */
    private final List<OrderBy> f30974d;

    public TargetIndexMatcher(Target target) {
        String lastSegment;
        boolean z3;
        if (target.getCollectionGroup() != null) {
            lastSegment = target.getCollectionGroup();
        } else {
            lastSegment = target.getPath().getLastSegment();
        }
        this.f30971a = lastSegment;
        this.f30974d = target.getOrderBy();
        this.f30972b = null;
        this.f30973c = new ArrayList();
        Iterator<Filter> it = target.getFilters().iterator();
        while (it.hasNext()) {
            FieldFilter fieldFilter = (FieldFilter) it.next();
            if (fieldFilter.isInequality()) {
                FieldFilter fieldFilter2 = this.f30972b;
                if (fieldFilter2 != null && !fieldFilter2.getField().equals(fieldFilter.getField())) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                Assert.hardAssert(z3, "Only a single inequality is supported", new Object[0]);
                this.f30972b = fieldFilter;
            } else {
                this.f30973c.add(fieldFilter);
            }
        }
    }

    private boolean a(FieldIndex.Segment segment) {
        for (FieldFilter fieldFilter : this.f30973c) {
            if (b(fieldFilter, segment)) {
                return true;
            }
        }
        return false;
    }

    private boolean b(@Nullable FieldFilter fieldFilter, FieldIndex.Segment segment) {
        boolean z3;
        if (fieldFilter == null || !fieldFilter.getField().equals(segment.getFieldPath())) {
            return false;
        }
        if (!fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS) && !fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS_ANY)) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (segment.getKind().equals(FieldIndex.Segment.Kind.CONTAINS) != z3) {
            return false;
        }
        return true;
    }

    private boolean c(OrderBy orderBy, FieldIndex.Segment segment) {
        if (!orderBy.getField().equals(segment.getFieldPath())) {
            return false;
        }
        if ((!segment.getKind().equals(FieldIndex.Segment.Kind.ASCENDING) || !orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) && (!segment.getKind().equals(FieldIndex.Segment.Kind.DESCENDING) || !orderBy.getDirection().equals(OrderBy.Direction.DESCENDING))) {
            return false;
        }
        return true;
    }

    public FieldIndex buildTargetIndex() {
        FieldIndex.Segment.Kind kind;
        boolean z3;
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        for (FieldFilter fieldFilter : this.f30973c) {
            if (!fieldFilter.getField().isKeyField()) {
                if (!fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS) && !fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS_ANY)) {
                    z3 = false;
                } else {
                    z3 = true;
                }
                if (z3) {
                    arrayList.add(FieldIndex.Segment.create(fieldFilter.getField(), FieldIndex.Segment.Kind.CONTAINS));
                } else if (!hashSet.contains(fieldFilter.getField())) {
                    hashSet.add(fieldFilter.getField());
                    arrayList.add(FieldIndex.Segment.create(fieldFilter.getField(), FieldIndex.Segment.Kind.ASCENDING));
                }
            }
        }
        for (OrderBy orderBy : this.f30974d) {
            if (!orderBy.getField().isKeyField() && !hashSet.contains(orderBy.getField())) {
                hashSet.add(orderBy.getField());
                FieldPath field = orderBy.getField();
                if (orderBy.getDirection() == OrderBy.Direction.ASCENDING) {
                    kind = FieldIndex.Segment.Kind.ASCENDING;
                } else {
                    kind = FieldIndex.Segment.Kind.DESCENDING;
                }
                arrayList.add(FieldIndex.Segment.create(field, kind));
            }
        }
        return FieldIndex.create(-1, this.f30971a, arrayList, FieldIndex.INITIAL_STATE);
    }

    public boolean servedByIndex(FieldIndex fieldIndex) {
        Assert.hardAssert(fieldIndex.getCollectionGroup().equals(this.f30971a), "Collection IDs do not match", new Object[0]);
        FieldIndex.Segment arraySegment = fieldIndex.getArraySegment();
        if (arraySegment != null && !a(arraySegment)) {
            return false;
        }
        Iterator<OrderBy> it = this.f30974d.iterator();
        List<FieldIndex.Segment> directionalSegments = fieldIndex.getDirectionalSegments();
        HashSet hashSet = new HashSet();
        int i4 = 0;
        while (i4 < directionalSegments.size() && a(directionalSegments.get(i4))) {
            hashSet.add(directionalSegments.get(i4).getFieldPath().canonicalString());
            i4++;
        }
        if (i4 == directionalSegments.size()) {
            return true;
        }
        FieldFilter fieldFilter = this.f30972b;
        if (fieldFilter != null) {
            if (!hashSet.contains(fieldFilter.getField().canonicalString())) {
                FieldIndex.Segment segment = directionalSegments.get(i4);
                if (!b(this.f30972b, segment) || !c(it.next(), segment)) {
                    return false;
                }
            }
            i4++;
        }
        while (i4 < directionalSegments.size()) {
            FieldIndex.Segment segment2 = directionalSegments.get(i4);
            if (!it.hasNext() || !c(it.next(), segment2)) {
                return false;
            }
            i4++;
        }
        return true;
    }
}
