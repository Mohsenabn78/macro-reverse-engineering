package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes5.dex */
public final class Query {

    /* renamed from: k  reason: collision with root package name */
    private static final OrderBy f30376k;

    /* renamed from: l  reason: collision with root package name */
    private static final OrderBy f30377l;

    /* renamed from: a  reason: collision with root package name */
    private final List<OrderBy> f30378a;

    /* renamed from: b  reason: collision with root package name */
    private List<OrderBy> f30379b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Target f30380c;

    /* renamed from: d  reason: collision with root package name */
    private final List<Filter> f30381d;

    /* renamed from: e  reason: collision with root package name */
    private final ResourcePath f30382e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f30383f;

    /* renamed from: g  reason: collision with root package name */
    private final long f30384g;

    /* renamed from: h  reason: collision with root package name */
    private final LimitType f30385h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private final Bound f30386i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private final Bound f30387j;

    /* loaded from: classes5.dex */
    public enum LimitType {
        LIMIT_TO_FIRST,
        LIMIT_TO_LAST
    }

    /* loaded from: classes5.dex */
    private static class QueryComparator implements Comparator<Document> {

        /* renamed from: a  reason: collision with root package name */
        private final List<OrderBy> f30389a;

        QueryComparator(List<OrderBy> list) {
            boolean z3;
            loop0: while (true) {
                for (OrderBy orderBy : list) {
                    z3 = z3 || orderBy.getField().equals(FieldPath.KEY_PATH);
                }
            }
            if (z3) {
                this.f30389a = list;
                return;
            }
            throw new IllegalArgumentException("QueryComparator needs to have a key ordering");
        }

        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(Document document, Document document2) {
            for (OrderBy orderBy : this.f30389a) {
                int a4 = orderBy.a(document, document2);
                if (a4 != 0) {
                    return a4;
                }
            }
            return 0;
        }
    }

    static {
        OrderBy.Direction direction = OrderBy.Direction.ASCENDING;
        FieldPath fieldPath = FieldPath.KEY_PATH;
        f30376k = OrderBy.getInstance(direction, fieldPath);
        f30377l = OrderBy.getInstance(OrderBy.Direction.DESCENDING, fieldPath);
    }

    public Query(ResourcePath resourcePath, @Nullable String str, List<Filter> list, List<OrderBy> list2, long j4, LimitType limitType, @Nullable Bound bound, @Nullable Bound bound2) {
        this.f30382e = resourcePath;
        this.f30383f = str;
        this.f30378a = list2;
        this.f30381d = list;
        this.f30384g = j4;
        this.f30385h = limitType;
        this.f30386i = bound;
        this.f30387j = bound2;
    }

    private boolean a(Document document) {
        Bound bound = this.f30386i;
        if (bound != null && !bound.sortsBeforeDocument(getOrderBy(), document)) {
            return false;
        }
        Bound bound2 = this.f30387j;
        if (bound2 != null && !bound2.sortsAfterDocument(getOrderBy(), document)) {
            return false;
        }
        return true;
    }

    public static Query atPath(ResourcePath resourcePath) {
        return new Query(resourcePath, null);
    }

    private boolean b(Document document) {
        for (Filter filter : this.f30381d) {
            if (!filter.matches(document)) {
                return false;
            }
        }
        return true;
    }

    private boolean c(Document document) {
        for (OrderBy orderBy : getOrderBy()) {
            if (!orderBy.getField().equals(FieldPath.KEY_PATH) && document.getField(orderBy.f30374b) == null) {
                return false;
            }
        }
        return true;
    }

    private boolean d(Document document) {
        ResourcePath path = document.getKey().getPath();
        if (this.f30383f != null) {
            if (!document.getKey().hasCollectionId(this.f30383f) || !this.f30382e.isPrefixOf(path)) {
                return false;
            }
            return true;
        } else if (DocumentKey.isDocumentKey(this.f30382e)) {
            return this.f30382e.equals(path);
        } else {
            if (!this.f30382e.isPrefixOf(path) || this.f30382e.length() != path.length() - 1) {
                return false;
            }
            return true;
        }
    }

    public Query asCollectionQueryAtPath(ResourcePath resourcePath) {
        return new Query(resourcePath, null, this.f30381d, this.f30378a, this.f30384g, this.f30385h, this.f30386i, this.f30387j);
    }

    public Comparator<Document> comparator() {
        return new QueryComparator(getOrderBy());
    }

    public Query endAt(Bound bound) {
        return new Query(this.f30382e, this.f30383f, this.f30381d, this.f30378a, this.f30384g, this.f30385h, this.f30386i, bound);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Query.class != obj.getClass()) {
            return false;
        }
        Query query = (Query) obj;
        if (this.f30385h != query.f30385h) {
            return false;
        }
        return toTarget().equals(query.toTarget());
    }

    public Query filter(Filter filter) {
        boolean z3;
        boolean z4 = true;
        Assert.hardAssert(!isDocumentQuery(), "No filter is allowed for document query", new Object[0]);
        FieldPath firstInequalityField = filter.getFirstInequalityField();
        FieldPath inequalityField = inequalityField();
        if (inequalityField != null && firstInequalityField != null && !inequalityField.equals(firstInequalityField)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "Query must only have one inequality field", new Object[0]);
        if (!this.f30378a.isEmpty() && firstInequalityField != null && !this.f30378a.get(0).f30374b.equals(firstInequalityField)) {
            z4 = false;
        }
        Assert.hardAssert(z4, "First orderBy must match inequality field", new Object[0]);
        ArrayList arrayList = new ArrayList(this.f30381d);
        arrayList.add(filter);
        return new Query(this.f30382e, this.f30383f, arrayList, this.f30378a, this.f30384g, this.f30385h, this.f30386i, this.f30387j);
    }

    public String getCanonicalId() {
        return toTarget().getCanonicalId() + "|lt:" + this.f30385h;
    }

    @Nullable
    public String getCollectionGroup() {
        return this.f30383f;
    }

    @Nullable
    public Bound getEndAt() {
        return this.f30387j;
    }

    public List<OrderBy> getExplicitOrderBy() {
        return this.f30378a;
    }

    public List<Filter> getFilters() {
        return this.f30381d;
    }

    public FieldPath getFirstOrderByField() {
        if (this.f30378a.isEmpty()) {
            return null;
        }
        return this.f30378a.get(0).getField();
    }

    public long getLimit() {
        return this.f30384g;
    }

    public LimitType getLimitType() {
        return this.f30385h;
    }

    public synchronized List<OrderBy> getOrderBy() {
        OrderBy.Direction direction;
        OrderBy orderBy;
        if (this.f30379b == null) {
            FieldPath inequalityField = inequalityField();
            FieldPath firstOrderByField = getFirstOrderByField();
            boolean z3 = false;
            if (inequalityField != null && firstOrderByField == null) {
                if (inequalityField.isKeyField()) {
                    this.f30379b = Collections.singletonList(f30376k);
                } else {
                    this.f30379b = Collections.unmodifiableList(Arrays.asList(OrderBy.getInstance(OrderBy.Direction.ASCENDING, inequalityField), f30376k));
                }
            } else {
                ArrayList arrayList = new ArrayList();
                for (OrderBy orderBy2 : this.f30378a) {
                    arrayList.add(orderBy2);
                    if (orderBy2.getField().equals(FieldPath.KEY_PATH)) {
                        z3 = true;
                    }
                }
                if (!z3) {
                    if (this.f30378a.size() > 0) {
                        List<OrderBy> list = this.f30378a;
                        direction = list.get(list.size() - 1).getDirection();
                    } else {
                        direction = OrderBy.Direction.ASCENDING;
                    }
                    if (direction.equals(OrderBy.Direction.ASCENDING)) {
                        orderBy = f30376k;
                    } else {
                        orderBy = f30377l;
                    }
                    arrayList.add(orderBy);
                }
                this.f30379b = Collections.unmodifiableList(arrayList);
            }
        }
        return this.f30379b;
    }

    public ResourcePath getPath() {
        return this.f30382e;
    }

    @Nullable
    public Bound getStartAt() {
        return this.f30386i;
    }

    public boolean hasLimit() {
        if (this.f30384g != -1) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (toTarget().hashCode() * 31) + this.f30385h.hashCode();
    }

    @Nullable
    public FieldPath inequalityField() {
        for (Filter filter : this.f30381d) {
            FieldPath firstInequalityField = filter.getFirstInequalityField();
            if (firstInequalityField != null) {
                return firstInequalityField;
            }
        }
        return null;
    }

    public boolean isCollectionGroupQuery() {
        if (this.f30383f != null) {
            return true;
        }
        return false;
    }

    public boolean isDocumentQuery() {
        if (DocumentKey.isDocumentKey(this.f30382e) && this.f30383f == null && this.f30381d.isEmpty()) {
            return true;
        }
        return false;
    }

    public Query limitToFirst(long j4) {
        return new Query(this.f30382e, this.f30383f, this.f30381d, this.f30378a, j4, LimitType.LIMIT_TO_FIRST, this.f30386i, this.f30387j);
    }

    public Query limitToLast(long j4) {
        return new Query(this.f30382e, this.f30383f, this.f30381d, this.f30378a, j4, LimitType.LIMIT_TO_LAST, this.f30386i, this.f30387j);
    }

    public boolean matches(Document document) {
        if (document.isFoundDocument() && d(document) && c(document) && b(document) && a(document)) {
            return true;
        }
        return false;
    }

    public boolean matchesAllDocuments() {
        if (this.f30381d.isEmpty() && this.f30384g == -1 && this.f30386i == null && this.f30387j == null) {
            if (getExplicitOrderBy().isEmpty()) {
                return true;
            }
            if (getExplicitOrderBy().size() == 1 && getFirstOrderByField().isKeyField()) {
                return true;
            }
        }
        return false;
    }

    public Query orderBy(OrderBy orderBy) {
        FieldPath inequalityField;
        Assert.hardAssert(!isDocumentQuery(), "No ordering is allowed for document query", new Object[0]);
        if (this.f30378a.isEmpty() && (inequalityField = inequalityField()) != null && !inequalityField.equals(orderBy.f30374b)) {
            throw Assert.fail("First orderBy must match inequality field", new Object[0]);
        }
        ArrayList arrayList = new ArrayList(this.f30378a);
        arrayList.add(orderBy);
        return new Query(this.f30382e, this.f30383f, this.f30381d, arrayList, this.f30384g, this.f30385h, this.f30386i, this.f30387j);
    }

    public Query startAt(Bound bound) {
        return new Query(this.f30382e, this.f30383f, this.f30381d, this.f30378a, this.f30384g, this.f30385h, bound, this.f30387j);
    }

    public String toString() {
        return "Query(target=" + toTarget().toString() + ";limitType=" + this.f30385h.toString() + ")";
    }

    public synchronized Target toTarget() {
        Bound bound;
        if (this.f30380c == null) {
            if (this.f30385h == LimitType.LIMIT_TO_FIRST) {
                this.f30380c = new Target(getPath(), getCollectionGroup(), getFilters(), getOrderBy(), this.f30384g, getStartAt(), getEndAt());
            } else {
                ArrayList arrayList = new ArrayList();
                for (OrderBy orderBy : getOrderBy()) {
                    OrderBy.Direction direction = orderBy.getDirection();
                    OrderBy.Direction direction2 = OrderBy.Direction.DESCENDING;
                    if (direction == direction2) {
                        direction2 = OrderBy.Direction.ASCENDING;
                    }
                    arrayList.add(OrderBy.getInstance(direction2, orderBy.getField()));
                }
                Bound bound2 = this.f30387j;
                Bound bound3 = null;
                if (bound2 != null) {
                    bound = new Bound(bound2.getPosition(), this.f30387j.isInclusive());
                } else {
                    bound = null;
                }
                Bound bound4 = this.f30386i;
                if (bound4 != null) {
                    bound3 = new Bound(bound4.getPosition(), this.f30386i.isInclusive());
                }
                this.f30380c = new Target(getPath(), getCollectionGroup(), getFilters(), arrayList, this.f30384g, bound, bound3);
            }
        }
        return this.f30380c;
    }

    public Query(ResourcePath resourcePath, @Nullable String str) {
        this(resourcePath, str, Collections.emptyList(), Collections.emptyList(), -1L, LimitType.LIMIT_TO_FIRST, null, null);
    }
}
