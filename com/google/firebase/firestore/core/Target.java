package com.google.firebase.firestore.core;

import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.Values;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes5.dex */
public final class Target {
    public static final long NO_LIMIT = -1;
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f30417a;

    /* renamed from: b  reason: collision with root package name */
    private final List<OrderBy> f30418b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Filter> f30419c;

    /* renamed from: d  reason: collision with root package name */
    private final ResourcePath f30420d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f30421e;

    /* renamed from: f  reason: collision with root package name */
    private final long f30422f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private final Bound f30423g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private final Bound f30424h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.core.Target$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30425a;

        static {
            int[] iArr = new int[FieldFilter.Operator.values().length];
            f30425a = iArr;
            try {
                iArr[FieldFilter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30425a[FieldFilter.Operator.ARRAY_CONTAINS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30425a[FieldFilter.Operator.EQUAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30425a[FieldFilter.Operator.IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f30425a[FieldFilter.Operator.NOT_IN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f30425a[FieldFilter.Operator.NOT_EQUAL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f30425a[FieldFilter.Operator.LESS_THAN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f30425a[FieldFilter.Operator.LESS_THAN_OR_EQUAL.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f30425a[FieldFilter.Operator.GREATER_THAN_OR_EQUAL.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f30425a[FieldFilter.Operator.GREATER_THAN.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
        }
    }

    public Target(ResourcePath resourcePath, @Nullable String str, List<Filter> list, List<OrderBy> list2, long j4, @Nullable Bound bound, @Nullable Bound bound2) {
        this.f30420d = resourcePath;
        this.f30421e = str;
        this.f30418b = list2;
        this.f30419c = list;
        this.f30422f = j4;
        this.f30423g = bound;
        this.f30424h = bound2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private Pair<Value, Boolean> a(FieldIndex.Segment segment, @Nullable Bound bound) {
        Value value = Values.MIN_VALUE;
        Iterator<FieldFilter> it = c(segment.getFieldPath()).iterator();
        boolean z3 = true;
        while (true) {
            int i4 = 0;
            boolean z4 = false;
            if (it.hasNext()) {
                FieldFilter next = it.next();
                Value value2 = Values.MIN_VALUE;
                switch (AnonymousClass1.f30425a[next.getOperator().ordinal()]) {
                    case 3:
                    case 4:
                    case 9:
                        value2 = next.getValue();
                        z4 = true;
                        break;
                    case 5:
                    case 6:
                    default:
                        z4 = true;
                        break;
                    case 7:
                    case 8:
                        value2 = Values.getLowerBound(next.getValue().getValueTypeCase());
                        z4 = true;
                        break;
                    case 10:
                        value2 = next.getValue();
                        break;
                }
                if (Values.lowerBoundCompare(value, z3, value2, z4) < 0) {
                    z3 = z4;
                    value = value2;
                }
            } else {
                if (bound != null) {
                    while (true) {
                        if (i4 < this.f30418b.size()) {
                            if (this.f30418b.get(i4).getField().equals(segment.getFieldPath())) {
                                Value value3 = bound.getPosition().get(i4);
                                if (Values.lowerBoundCompare(value, z3, value3, bound.isInclusive()) < 0) {
                                    z3 = bound.isInclusive();
                                    value = value3;
                                }
                            } else {
                                i4++;
                            }
                        }
                    }
                }
                return new Pair<>(value, Boolean.valueOf(z3));
            }
        }
    }

    private Pair<Value, Boolean> b(FieldIndex.Segment segment, @Nullable Bound bound) {
        Value value = Values.MAX_VALUE;
        Iterator<FieldFilter> it = c(segment.getFieldPath()).iterator();
        boolean z3 = true;
        while (true) {
            int i4 = 0;
            r5 = false;
            boolean z4 = false;
            if (it.hasNext()) {
                FieldFilter next = it.next();
                Value value2 = Values.MAX_VALUE;
                switch (AnonymousClass1.f30425a[next.getOperator().ordinal()]) {
                    case 3:
                    case 4:
                    case 8:
                        value2 = next.getValue();
                    case 5:
                    case 6:
                    default:
                        z4 = true;
                        break;
                    case 7:
                        value2 = next.getValue();
                        break;
                    case 9:
                    case 10:
                        value2 = Values.getUpperBound(next.getValue().getValueTypeCase());
                        break;
                }
                if (Values.upperBoundCompare(value, z3, value2, z4) > 0) {
                    z3 = z4;
                    value = value2;
                }
            } else {
                if (bound != null) {
                    while (true) {
                        if (i4 < this.f30418b.size()) {
                            if (this.f30418b.get(i4).getField().equals(segment.getFieldPath())) {
                                Value value3 = bound.getPosition().get(i4);
                                if (Values.upperBoundCompare(value, z3, value3, bound.isInclusive()) > 0) {
                                    z3 = bound.isInclusive();
                                    value = value3;
                                }
                            } else {
                                i4++;
                            }
                        }
                    }
                }
                return new Pair<>(value, Boolean.valueOf(z3));
            }
        }
    }

    private List<FieldFilter> c(FieldPath fieldPath) {
        ArrayList arrayList = new ArrayList();
        for (Filter filter : this.f30419c) {
            if (filter instanceof FieldFilter) {
                FieldFilter fieldFilter = (FieldFilter) filter;
                if (fieldFilter.getField().equals(fieldPath)) {
                    arrayList.add(fieldFilter);
                }
            }
        }
        return arrayList;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Target.class != obj.getClass()) {
            return false;
        }
        Target target = (Target) obj;
        String str = this.f30421e;
        if (str == null ? target.f30421e != null : !str.equals(target.f30421e)) {
            return false;
        }
        if (this.f30422f != target.f30422f || !this.f30418b.equals(target.f30418b) || !this.f30419c.equals(target.f30419c) || !this.f30420d.equals(target.f30420d)) {
            return false;
        }
        Bound bound = this.f30423g;
        if (bound == null ? target.f30423g != null : !bound.equals(target.f30423g)) {
            return false;
        }
        Bound bound2 = this.f30424h;
        Bound bound3 = target.f30424h;
        if (bound2 != null) {
            return bound2.equals(bound3);
        }
        if (bound3 == null) {
            return true;
        }
        return false;
    }

    @Nullable
    public List<Value> getArrayValues(FieldIndex fieldIndex) {
        FieldIndex.Segment arraySegment = fieldIndex.getArraySegment();
        if (arraySegment == null) {
            return null;
        }
        for (FieldFilter fieldFilter : c(arraySegment.getFieldPath())) {
            int i4 = AnonymousClass1.f30425a[fieldFilter.getOperator().ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return Collections.singletonList(fieldFilter.getValue());
                }
            } else {
                return fieldFilter.getValue().getArrayValue().getValuesList();
            }
        }
        return null;
    }

    public String getCanonicalId() {
        String str;
        String str2;
        String str3 = this.f30417a;
        if (str3 != null) {
            return str3;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getPath().canonicalString());
        if (this.f30421e != null) {
            sb.append("|cg:");
            sb.append(this.f30421e);
        }
        sb.append("|f:");
        for (Filter filter : getFilters()) {
            sb.append(filter.getCanonicalId());
        }
        sb.append("|ob:");
        for (OrderBy orderBy : getOrderBy()) {
            sb.append(orderBy.getField().canonicalString());
            if (orderBy.getDirection().equals(OrderBy.Direction.ASCENDING)) {
                str2 = "asc";
            } else {
                str2 = "desc";
            }
            sb.append(str2);
        }
        if (hasLimit()) {
            sb.append("|l:");
            sb.append(getLimit());
        }
        String str4 = "b:";
        if (this.f30423g != null) {
            sb.append("|lb:");
            if (this.f30423g.isInclusive()) {
                str = "b:";
            } else {
                str = "a:";
            }
            sb.append(str);
            sb.append(this.f30423g.positionString());
        }
        if (this.f30424h != null) {
            sb.append("|ub:");
            if (this.f30424h.isInclusive()) {
                str4 = "a:";
            }
            sb.append(str4);
            sb.append(this.f30424h.positionString());
        }
        String sb2 = sb.toString();
        this.f30417a = sb2;
        return sb2;
    }

    @Nullable
    public String getCollectionGroup() {
        return this.f30421e;
    }

    @Nullable
    public Bound getEndAt() {
        return this.f30424h;
    }

    public List<Filter> getFilters() {
        return this.f30419c;
    }

    public OrderBy.Direction getKeyOrder() {
        List<OrderBy> list = this.f30418b;
        return list.get(list.size() - 1).getDirection();
    }

    public long getLimit() {
        return this.f30422f;
    }

    public Bound getLowerBound(FieldIndex fieldIndex) {
        Pair<Value, Boolean> b4;
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            if (segment.getKind().equals(FieldIndex.Segment.Kind.ASCENDING)) {
                b4 = a(segment, this.f30423g);
            } else {
                b4 = b(segment, this.f30423g);
            }
            arrayList.add((Value) b4.first);
            z3 &= ((Boolean) b4.second).booleanValue();
        }
        return new Bound(arrayList, z3);
    }

    @Nullable
    public Collection<Value> getNotInValues(FieldIndex fieldIndex) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            for (FieldFilter fieldFilter : c(segment.getFieldPath())) {
                int i4 = AnonymousClass1.f30425a[fieldFilter.getOperator().ordinal()];
                if (i4 != 3 && i4 != 4) {
                    if (i4 == 5 || i4 == 6) {
                        linkedHashMap.put(segment.getFieldPath(), fieldFilter.getValue());
                        return linkedHashMap.values();
                    }
                } else {
                    linkedHashMap.put(segment.getFieldPath(), fieldFilter.getValue());
                }
            }
        }
        return null;
    }

    public List<OrderBy> getOrderBy() {
        return this.f30418b;
    }

    public ResourcePath getPath() {
        return this.f30420d;
    }

    public int getSegmentCount() {
        HashSet hashSet = new HashSet();
        int i4 = 0;
        for (Filter filter : this.f30419c) {
            for (FieldFilter fieldFilter : filter.getFlattenedFilters()) {
                if (!fieldFilter.getField().isKeyField()) {
                    if (!fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS) && !fieldFilter.getOperator().equals(FieldFilter.Operator.ARRAY_CONTAINS_ANY)) {
                        hashSet.add(fieldFilter.getField());
                    } else {
                        i4 = 1;
                    }
                }
            }
        }
        for (OrderBy orderBy : this.f30418b) {
            if (!orderBy.getField().isKeyField()) {
                hashSet.add(orderBy.getField());
            }
        }
        return hashSet.size() + i4;
    }

    @Nullable
    public Bound getStartAt() {
        return this.f30423g;
    }

    public Bound getUpperBound(FieldIndex fieldIndex) {
        Pair<Value, Boolean> a4;
        ArrayList arrayList = new ArrayList();
        boolean z3 = true;
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            if (segment.getKind().equals(FieldIndex.Segment.Kind.ASCENDING)) {
                a4 = b(segment, this.f30424h);
            } else {
                a4 = a(segment, this.f30424h);
            }
            arrayList.add((Value) a4.first);
            z3 &= ((Boolean) a4.second).booleanValue();
        }
        return new Bound(arrayList, z3);
    }

    public boolean hasLimit() {
        if (this.f30422f != -1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int i5;
        int hashCode = this.f30418b.hashCode() * 31;
        String str = this.f30421e;
        int i6 = 0;
        if (str != null) {
            i4 = str.hashCode();
        } else {
            i4 = 0;
        }
        long j4 = this.f30422f;
        int hashCode2 = (((((((hashCode + i4) * 31) + this.f30419c.hashCode()) * 31) + this.f30420d.hashCode()) * 31) + ((int) (j4 ^ (j4 >>> 32)))) * 31;
        Bound bound = this.f30423g;
        if (bound != null) {
            i5 = bound.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = (hashCode2 + i5) * 31;
        Bound bound2 = this.f30424h;
        if (bound2 != null) {
            i6 = bound2.hashCode();
        }
        return i7 + i6;
    }

    public boolean isDocumentQuery() {
        if (DocumentKey.isDocumentKey(this.f30420d) && this.f30421e == null && this.f30419c.isEmpty()) {
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Query(");
        sb.append(this.f30420d.canonicalString());
        if (this.f30421e != null) {
            sb.append(" collectionGroup=");
            sb.append(this.f30421e);
        }
        if (!this.f30419c.isEmpty()) {
            sb.append(" where ");
            for (int i4 = 0; i4 < this.f30419c.size(); i4++) {
                if (i4 > 0) {
                    sb.append(" and ");
                }
                sb.append(this.f30419c.get(i4));
            }
        }
        if (!this.f30418b.isEmpty()) {
            sb.append(" order by ");
            for (int i5 = 0; i5 < this.f30418b.size(); i5++) {
                if (i5 > 0) {
                    sb.append(", ");
                }
                sb.append(this.f30418b.get(i5));
            }
        }
        sb.append(")");
        return sb.toString();
    }
}
