package com.google.firebase.firestore;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.firestore.Filter;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.ActivityScope;
import com.google.firebase.firestore.core.AsyncEventListener;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.ListenerRegistrationImpl;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.ServerTimestamps;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Executors;
import com.google.firebase.firestore.util.Preconditions;
import com.google.firebase.firestore.util.Util;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.firestore.v1.ArrayValue;
import com.google.firestore.v1.Value;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* loaded from: classes5.dex */
public class Query {

    /* renamed from: a  reason: collision with root package name */
    final com.google.firebase.firestore.core.Query f30217a;

    /* renamed from: b  reason: collision with root package name */
    final FirebaseFirestore f30218b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.Query$2  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30219a;

        static {
            int[] iArr = new int[FieldFilter.Operator.values().length];
            f30219a = iArr;
            try {
                iArr[FieldFilter.Operator.NOT_EQUAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30219a[FieldFilter.Operator.ARRAY_CONTAINS_ANY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f30219a[FieldFilter.Operator.IN.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f30219a[FieldFilter.Operator.NOT_IN.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* loaded from: classes5.dex */
    public enum Direction {
        ASCENDING,
        DESCENDING
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Query(com.google.firebase.firestore.core.Query query, FirebaseFirestore firebaseFirestore) {
        this.f30217a = (com.google.firebase.firestore.core.Query) Preconditions.checkNotNull(query);
        this.f30218b = (FirebaseFirestore) Preconditions.checkNotNull(firebaseFirestore);
    }

    private ListenerRegistration d(Executor executor, EventManager.ListenOptions listenOptions, @Nullable Activity activity, final EventListener<QuerySnapshot> eventListener) {
        t();
        AsyncEventListener asyncEventListener = new AsyncEventListener(executor, new EventListener() { // from class: com.google.firebase.firestore.p
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                Query.this.k(eventListener, (ViewSnapshot) obj, firebaseFirestoreException);
            }
        });
        return ActivityScope.bind(activity, new ListenerRegistrationImpl(this.f30218b.i(), this.f30218b.i().listen(this.f30217a, listenOptions, asyncEventListener), asyncEventListener));
    }

    private Bound e(String str, DocumentSnapshot documentSnapshot, boolean z3) {
        Preconditions.checkNotNull(documentSnapshot, "Provided snapshot must not be null.");
        if (documentSnapshot.exists()) {
            Document d4 = documentSnapshot.d();
            ArrayList arrayList = new ArrayList();
            for (OrderBy orderBy : this.f30217a.getOrderBy()) {
                if (orderBy.getField().equals(com.google.firebase.firestore.model.FieldPath.KEY_PATH)) {
                    arrayList.add(Values.refValue(this.f30218b.j(), d4.getKey()));
                } else {
                    Value field = d4.getField(orderBy.getField());
                    if (!ServerTimestamps.isServerTimestamp(field)) {
                        if (field != null) {
                            arrayList.add(field);
                        } else {
                            throw new IllegalArgumentException("Invalid query. You are trying to start or end a query using a document for which the field '" + orderBy.getField() + "' (used as the orderBy) does not exist.");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid query. You are trying to start or end a query using a document for which the field '" + orderBy.getField() + "' is an uncommitted server timestamp. (Since the value of this field is unknown, you cannot start/end a query with it.)");
                    }
                }
            }
            return new Bound(arrayList, z3);
        }
        throw new IllegalArgumentException("Can't use a DocumentSnapshot for a document that doesn't exist for " + str + "().");
    }

    private Bound f(String str, Object[] objArr, boolean z3) {
        List<OrderBy> explicitOrderBy = this.f30217a.getExplicitOrderBy();
        if (objArr.length <= explicitOrderBy.size()) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < objArr.length; i4++) {
                Object obj = objArr[i4];
                if (explicitOrderBy.get(i4).getField().equals(com.google.firebase.firestore.model.FieldPath.KEY_PATH)) {
                    if (obj instanceof String) {
                        String str2 = (String) obj;
                        if (!this.f30217a.isCollectionGroupQuery() && str2.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                            throw new IllegalArgumentException("Invalid query. When querying a collection and ordering by FieldPath.documentId(), the value passed to " + str + "() must be a plain document ID, but '" + str2 + "' contains a slash.");
                        }
                        ResourcePath append = this.f30217a.getPath().append(ResourcePath.fromString(str2));
                        if (DocumentKey.isDocumentKey(append)) {
                            arrayList.add(Values.refValue(this.f30218b.j(), DocumentKey.fromPath(append)));
                        } else {
                            throw new IllegalArgumentException("Invalid query. When querying a collection group and ordering by FieldPath.documentId(), the value passed to " + str + "() must result in a valid document path, but '" + append + "' is not because it contains an odd number of segments.");
                        }
                    } else {
                        throw new IllegalArgumentException("Invalid query. Expected a string for document ID in " + str + "(), but got " + obj + ".");
                    }
                } else {
                    arrayList.add(this.f30218b.l().parseQueryValue(obj));
                }
            }
            return new Bound(arrayList, z3);
        }
        throw new IllegalArgumentException("Too many arguments provided to " + str + "(). The number of arguments must be less than or equal to the number of orderBy() clauses.");
    }

    private List<FieldFilter.Operator> g(FieldFilter.Operator operator) {
        int i4 = AnonymousClass2.f30219a[operator.ordinal()];
        if (i4 != 1) {
            if (i4 != 2 && i4 != 3) {
                if (i4 != 4) {
                    return new ArrayList();
                }
                return Arrays.asList(FieldFilter.Operator.ARRAY_CONTAINS_ANY, FieldFilter.Operator.IN, FieldFilter.Operator.NOT_IN, FieldFilter.Operator.NOT_EQUAL);
            }
            return Arrays.asList(FieldFilter.Operator.NOT_IN);
        }
        return Arrays.asList(FieldFilter.Operator.NOT_EQUAL, FieldFilter.Operator.NOT_IN);
    }

    @Nullable
    private FieldFilter.Operator h(List<com.google.firebase.firestore.core.Filter> list, List<FieldFilter.Operator> list2) {
        for (com.google.firebase.firestore.core.Filter filter : list) {
            for (FieldFilter fieldFilter : filter.getFlattenedFilters()) {
                if (list2.contains(fieldFilter.getOperator())) {
                    return fieldFilter.getOperator();
                }
            }
        }
        return null;
    }

    private Task<QuerySnapshot> i(final Source source) {
        final TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        final TaskCompletionSource taskCompletionSource2 = new TaskCompletionSource();
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        listenOptions.includeDocumentMetadataChanges = true;
        listenOptions.includeQueryMetadataChanges = true;
        listenOptions.waitForSyncWhenOnline = true;
        taskCompletionSource2.setResult(d(Executors.DIRECT_EXECUTOR, listenOptions, null, new EventListener() { // from class: com.google.firebase.firestore.q
            @Override // com.google.firebase.firestore.EventListener
            public final void onEvent(Object obj, FirebaseFirestoreException firebaseFirestoreException) {
                Query.m(TaskCompletionSource.this, taskCompletionSource2, source, (QuerySnapshot) obj, firebaseFirestoreException);
            }
        }));
        return taskCompletionSource.getTask();
    }

    private static EventManager.ListenOptions j(MetadataChanges metadataChanges) {
        boolean z3;
        EventManager.ListenOptions listenOptions = new EventManager.ListenOptions();
        MetadataChanges metadataChanges2 = MetadataChanges.INCLUDE;
        boolean z4 = true;
        if (metadataChanges == metadataChanges2) {
            z3 = true;
        } else {
            z3 = false;
        }
        listenOptions.includeDocumentMetadataChanges = z3;
        if (metadataChanges != metadataChanges2) {
            z4 = false;
        }
        listenOptions.includeQueryMetadataChanges = z4;
        listenOptions.waitForSyncWhenOnline = false;
        return listenOptions;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k(EventListener eventListener, ViewSnapshot viewSnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        boolean z3;
        if (firebaseFirestoreException != null) {
            eventListener.onEvent(null, firebaseFirestoreException);
            return;
        }
        if (viewSnapshot != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Got event without value or error set", new Object[0]);
        eventListener.onEvent(new QuerySnapshot(this, viewSnapshot, this.f30218b), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ QuerySnapshot l(Task task) throws Exception {
        return new QuerySnapshot(new Query(this.f30217a, this.f30218b), (ViewSnapshot) task.getResult(), this.f30218b);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void m(TaskCompletionSource taskCompletionSource, TaskCompletionSource taskCompletionSource2, Source source, QuerySnapshot querySnapshot, FirebaseFirestoreException firebaseFirestoreException) {
        if (firebaseFirestoreException != null) {
            taskCompletionSource.setException(firebaseFirestoreException);
            return;
        }
        try {
            ((ListenerRegistration) Tasks.await(taskCompletionSource2.getTask())).remove();
            if (querySnapshot.getMetadata().isFromCache() && source == Source.SERVER) {
                taskCompletionSource.setException(new FirebaseFirestoreException("Failed to get documents from server. (However, these documents may exist in the local cache. Run again without setting source to SERVER to retrieve the cached documents.)", FirebaseFirestoreException.Code.UNAVAILABLE));
            } else {
                taskCompletionSource.setResult(querySnapshot);
            }
        } catch (InterruptedException e4) {
            Thread.currentThread().interrupt();
            throw Assert.fail(e4, "Failed to register a listener for a query result", new Object[0]);
        } catch (ExecutionException e5) {
            throw Assert.fail(e5, "Failed to register a listener for a query result", new Object[0]);
        }
    }

    private Query n(@NonNull com.google.firebase.firestore.model.FieldPath fieldPath, @NonNull Direction direction) {
        OrderBy.Direction direction2;
        Preconditions.checkNotNull(direction, "Provided direction must not be null.");
        if (this.f30217a.getStartAt() == null) {
            if (this.f30217a.getEndAt() == null) {
                w(fieldPath);
                if (direction == Direction.ASCENDING) {
                    direction2 = OrderBy.Direction.ASCENDING;
                } else {
                    direction2 = OrderBy.Direction.DESCENDING;
                }
                return new Query(this.f30217a.orderBy(OrderBy.getInstance(direction2, fieldPath)), this.f30218b);
            }
            throw new IllegalArgumentException("Invalid query. You must not call Query.endAt() or Query.endBefore() before calling Query.orderBy().");
        }
        throw new IllegalArgumentException("Invalid query. You must not call Query.startAt() or Query.startAfter() before calling Query.orderBy().");
    }

    private com.google.firebase.firestore.core.Filter o(Filter.CompositeFilter compositeFilter) {
        ArrayList arrayList = new ArrayList();
        for (Filter filter : compositeFilter.a()) {
            com.google.firebase.firestore.core.Filter r4 = r(filter);
            if (!r4.getFilters().isEmpty()) {
                arrayList.add(r4);
            }
        }
        if (arrayList.size() == 1) {
            return (com.google.firebase.firestore.core.Filter) arrayList.get(0);
        }
        return new CompositeFilter(arrayList, compositeFilter.b());
    }

    private Value p(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (!str.isEmpty()) {
                if (!this.f30217a.isCollectionGroupQuery() && str.contains(RemoteSettings.FORWARD_SLASH_STRING)) {
                    throw new IllegalArgumentException("Invalid query. When querying a collection by FieldPath.documentId() you must provide a plain document ID, but '" + str + "' contains a '/' character.");
                }
                ResourcePath append = this.f30217a.getPath().append(ResourcePath.fromString(str));
                if (DocumentKey.isDocumentKey(append)) {
                    return Values.refValue(getFirestore().j(), DocumentKey.fromPath(append));
                }
                throw new IllegalArgumentException("Invalid query. When querying a collection group by FieldPath.documentId(), the value provided must result in a valid document path, but '" + append + "' is not because it has an odd number of segments (" + append.length() + ").");
            }
            throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid document ID, but it was an empty string.");
        } else if (obj instanceof DocumentReference) {
            return Values.refValue(getFirestore().j(), ((DocumentReference) obj).g());
        } else {
            throw new IllegalArgumentException("Invalid query. When querying with FieldPath.documentId() you must provide a valid String or DocumentReference, but it was of type: " + Util.typeName(obj));
        }
    }

    private FieldFilter q(Filter.UnaryFilter unaryFilter) {
        boolean z3;
        Value parseQueryValue;
        FieldPath a4 = unaryFilter.a();
        FieldFilter.Operator b4 = unaryFilter.b();
        Object c4 = unaryFilter.c();
        Preconditions.checkNotNull(a4, "Provided field path must not be null.");
        Preconditions.checkNotNull(b4, "Provided op must not be null.");
        if (a4.b().isKeyField()) {
            if (b4 != FieldFilter.Operator.ARRAY_CONTAINS && b4 != FieldFilter.Operator.ARRAY_CONTAINS_ANY) {
                if (b4 != FieldFilter.Operator.IN && b4 != FieldFilter.Operator.NOT_IN) {
                    parseQueryValue = p(c4);
                } else {
                    s(c4, b4);
                    ArrayValue.Builder newBuilder = ArrayValue.newBuilder();
                    for (Object obj : (List) c4) {
                        newBuilder.addValues(p(obj));
                    }
                    parseQueryValue = Value.newBuilder().setArrayValue(newBuilder).build();
                }
            } else {
                throw new IllegalArgumentException("Invalid query. You can't perform '" + b4.toString() + "' queries on FieldPath.documentId().");
            }
        } else {
            FieldFilter.Operator operator = FieldFilter.Operator.IN;
            if (b4 == operator || b4 == FieldFilter.Operator.NOT_IN || b4 == FieldFilter.Operator.ARRAY_CONTAINS_ANY) {
                s(c4, b4);
            }
            UserDataReader l4 = this.f30218b.l();
            if (b4 != operator && b4 != FieldFilter.Operator.NOT_IN) {
                z3 = false;
            } else {
                z3 = true;
            }
            parseQueryValue = l4.parseQueryValue(c4, z3);
        }
        return FieldFilter.create(a4.b(), b4, parseQueryValue);
    }

    private com.google.firebase.firestore.core.Filter r(Filter filter) {
        boolean z3;
        boolean z4 = filter instanceof Filter.UnaryFilter;
        if (!z4 && !(filter instanceof Filter.CompositeFilter)) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "Parsing is only supported for Filter.UnaryFilter and Filter.CompositeFilter.", new Object[0]);
        if (z4) {
            return q((Filter.UnaryFilter) filter);
        }
        return o((Filter.CompositeFilter) filter);
    }

    private void s(Object obj, FieldFilter.Operator operator) {
        if ((obj instanceof List) && ((List) obj).size() != 0) {
            return;
        }
        throw new IllegalArgumentException("Invalid Query. A non-empty array is required for '" + operator.toString() + "' filters.");
    }

    private void t() {
        if (this.f30217a.getLimitType().equals(Query.LimitType.LIMIT_TO_LAST) && this.f30217a.getExplicitOrderBy().isEmpty()) {
            throw new IllegalStateException("limitToLast() queries require specifying at least one orderBy() clause");
        }
    }

    private void u(com.google.firebase.firestore.core.Query query, FieldFilter fieldFilter) {
        FieldFilter.Operator operator = fieldFilter.getOperator();
        if (fieldFilter.isInequality()) {
            com.google.firebase.firestore.model.FieldPath inequalityField = query.inequalityField();
            com.google.firebase.firestore.model.FieldPath field = fieldFilter.getField();
            if (inequalityField != null && !inequalityField.equals(field)) {
                throw new IllegalArgumentException(String.format("All where filters with an inequality (notEqualTo, notIn, lessThan, lessThanOrEqualTo, greaterThan, or greaterThanOrEqualTo) must be on the same field. But you have filters on '%s' and '%s'", inequalityField.canonicalString(), field.canonicalString()));
            }
            com.google.firebase.firestore.model.FieldPath firstOrderByField = query.getFirstOrderByField();
            if (firstOrderByField != null) {
                x(firstOrderByField, field);
            }
        }
        FieldFilter.Operator h4 = h(query.getFilters(), g(operator));
        if (h4 != null) {
            if (h4 == operator) {
                throw new IllegalArgumentException("Invalid Query. You cannot use more than one '" + operator.toString() + "' filter.");
            }
            throw new IllegalArgumentException("Invalid Query. You cannot use '" + operator.toString() + "' filters with '" + h4.toString() + "' filters.");
        }
    }

    private void v(com.google.firebase.firestore.core.Filter filter) {
        com.google.firebase.firestore.core.Query query = this.f30217a;
        for (FieldFilter fieldFilter : filter.getFlattenedFilters()) {
            u(query, fieldFilter);
            query = query.filter(fieldFilter);
        }
    }

    private void w(com.google.firebase.firestore.model.FieldPath fieldPath) {
        com.google.firebase.firestore.model.FieldPath inequalityField = this.f30217a.inequalityField();
        if (this.f30217a.getFirstOrderByField() == null && inequalityField != null) {
            x(fieldPath, inequalityField);
        }
    }

    private void x(com.google.firebase.firestore.model.FieldPath fieldPath, com.google.firebase.firestore.model.FieldPath fieldPath2) {
        if (fieldPath.equals(fieldPath2)) {
            return;
        }
        String canonicalString = fieldPath2.canonicalString();
        throw new IllegalArgumentException(String.format("Invalid query. You have an inequality where filter (whereLessThan(), whereGreaterThan(), etc.) on field '%s' and so you must also have '%s' as your first orderBy() field, but your first orderBy() is currently on field '%s' instead.", canonicalString, canonicalString, fieldPath.canonicalString()));
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public AggregateQuery aggregate(@NonNull AggregateField aggregateField, @NonNull AggregateField... aggregateFieldArr) {
        ArrayList<AggregateField> arrayList = new ArrayList<AggregateField>(aggregateField) { // from class: com.google.firebase.firestore.Query.1
            final /* synthetic */ AggregateField val$aggregateField;

            {
                this.val$aggregateField = aggregateField;
                add(aggregateField);
            }
        };
        arrayList.addAll(Arrays.asList(aggregateFieldArr));
        return new AggregateQuery(this, arrayList);
    }

    @NonNull
    public AggregateQuery count() {
        return new AggregateQuery(this, Collections.singletonList(AggregateField.count()));
    }

    @NonNull
    public Query endAt(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.f30217a.endAt(e("endAt", documentSnapshot, true)), this.f30218b);
    }

    @NonNull
    public Query endBefore(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.f30217a.endAt(e("endBefore", documentSnapshot, false)), this.f30218b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Query)) {
            return false;
        }
        Query query = (Query) obj;
        if (this.f30217a.equals(query.f30217a) && this.f30218b.equals(query.f30218b)) {
            return true;
        }
        return false;
    }

    @NonNull
    public Task<QuerySnapshot> get() {
        return get(Source.DEFAULT);
    }

    @NonNull
    public FirebaseFirestore getFirestore() {
        return this.f30218b;
    }

    public int hashCode() {
        return (this.f30217a.hashCode() * 31) + this.f30218b.hashCode();
    }

    @NonNull
    public Query limit(long j4) {
        if (j4 > 0) {
            return new Query(this.f30217a.limitToFirst(j4), this.f30218b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limit (" + j4 + ") is invalid. Limit must be positive.");
    }

    @NonNull
    public Query limitToLast(long j4) {
        if (j4 > 0) {
            return new Query(this.f30217a.limitToLast(j4), this.f30218b);
        }
        throw new IllegalArgumentException("Invalid Query. Query limitToLast (" + j4 + ") is invalid. Limit must be positive.");
    }

    @NonNull
    public Query orderBy(@NonNull String str) {
        return orderBy(FieldPath.a(str), Direction.ASCENDING);
    }

    @NonNull
    public Query startAfter(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.f30217a.startAt(e("startAfter", documentSnapshot, false)), this.f30218b);
    }

    @NonNull
    public Query startAt(@NonNull DocumentSnapshot documentSnapshot) {
        return new Query(this.f30217a.startAt(e("startAt", documentSnapshot, true)), this.f30218b);
    }

    @NonNull
    public Query where(@NonNull Filter filter) {
        com.google.firebase.firestore.core.Filter r4 = r(filter);
        if (r4.getFilters().isEmpty()) {
            return this;
        }
        v(r4);
        return new Query(this.f30217a.filter(r4), this.f30218b);
    }

    @NonNull
    public Query whereArrayContains(@NonNull String str, @NonNull Object obj) {
        return where(Filter.arrayContains(str, obj));
    }

    @NonNull
    public Query whereArrayContainsAny(@NonNull String str, @NonNull List<? extends Object> list) {
        return where(Filter.arrayContainsAny(str, list));
    }

    @NonNull
    public Query whereEqualTo(@NonNull String str, @Nullable Object obj) {
        return where(Filter.equalTo(str, obj));
    }

    @NonNull
    public Query whereGreaterThan(@NonNull String str, @NonNull Object obj) {
        return where(Filter.greaterThan(str, obj));
    }

    @NonNull
    public Query whereGreaterThanOrEqualTo(@NonNull String str, @NonNull Object obj) {
        return where(Filter.greaterThanOrEqualTo(str, obj));
    }

    @NonNull
    public Query whereIn(@NonNull String str, @NonNull List<? extends Object> list) {
        return where(Filter.inArray(str, list));
    }

    @NonNull
    public Query whereLessThan(@NonNull String str, @NonNull Object obj) {
        return where(Filter.lessThan(str, obj));
    }

    @NonNull
    public Query whereLessThanOrEqualTo(@NonNull String str, @NonNull Object obj) {
        return where(Filter.lessThanOrEqualTo(str, obj));
    }

    @NonNull
    public Query whereNotEqualTo(@NonNull String str, @Nullable Object obj) {
        return where(Filter.notEqualTo(str, obj));
    }

    @NonNull
    public Query whereNotIn(@NonNull String str, @NonNull List<? extends Object> list) {
        return where(Filter.notInArray(str, list));
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(executor, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public Task<QuerySnapshot> get(@NonNull Source source) {
        t();
        if (source == Source.CACHE) {
            return this.f30218b.i().getDocumentsFromLocalCache(this.f30217a).continueWith(Executors.DIRECT_EXECUTOR, new Continuation() { // from class: com.google.firebase.firestore.o
                @Override // com.google.android.gms.tasks.Continuation
                public final Object then(Task task) {
                    QuerySnapshot l4;
                    l4 = Query.this.l(task);
                    return l4;
                }
            });
        }
        return i(source);
    }

    @NonNull
    public Query orderBy(@NonNull FieldPath fieldPath) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return n(fieldPath.b(), Direction.ASCENDING);
    }

    @NonNull
    public Query whereArrayContains(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return where(Filter.arrayContains(fieldPath, obj));
    }

    @NonNull
    public Query whereArrayContainsAny(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return where(Filter.arrayContainsAny(fieldPath, list));
    }

    @NonNull
    public Query whereEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return where(Filter.equalTo(fieldPath, obj));
    }

    @NonNull
    public Query whereGreaterThan(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return where(Filter.greaterThan(fieldPath, obj));
    }

    @NonNull
    public Query whereGreaterThanOrEqualTo(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return where(Filter.greaterThanOrEqualTo(fieldPath, obj));
    }

    @NonNull
    public Query whereIn(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return where(Filter.inArray(fieldPath, list));
    }

    @NonNull
    public Query whereLessThan(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return where(Filter.lessThan(fieldPath, obj));
    }

    @NonNull
    public Query whereLessThanOrEqualTo(@NonNull FieldPath fieldPath, @NonNull Object obj) {
        return where(Filter.lessThanOrEqualTo(fieldPath, obj));
    }

    @NonNull
    public Query whereNotEqualTo(@NonNull FieldPath fieldPath, @Nullable Object obj) {
        return where(Filter.notEqualTo(fieldPath, obj));
    }

    @NonNull
    public Query whereNotIn(@NonNull FieldPath fieldPath, @NonNull List<? extends Object> list) {
        return where(Filter.notInArray(fieldPath, list));
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(activity, MetadataChanges.EXCLUDE, eventListener);
    }

    @NonNull
    public Query endAt(Object... objArr) {
        return new Query(this.f30217a.endAt(f("endAt", objArr, true)), this.f30218b);
    }

    @NonNull
    public Query endBefore(Object... objArr) {
        return new Query(this.f30217a.endAt(f("endBefore", objArr, false)), this.f30218b);
    }

    @NonNull
    public Query startAfter(Object... objArr) {
        return new Query(this.f30217a.startAt(f("startAfter", objArr, false)), this.f30218b);
    }

    @NonNull
    public Query startAt(Object... objArr) {
        return new Query(this.f30217a.startAt(f("startAt", objArr, true)), this.f30218b);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        return addSnapshotListener(Executors.DEFAULT_CALLBACK_EXECUTOR, metadataChanges, eventListener);
    }

    @NonNull
    public Query orderBy(@NonNull String str, @NonNull Direction direction) {
        return orderBy(FieldPath.a(str), direction);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Executor executor, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        Preconditions.checkNotNull(executor, "Provided executor must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return d(executor, j(metadataChanges), null, eventListener);
    }

    @NonNull
    public Query orderBy(@NonNull FieldPath fieldPath, @NonNull Direction direction) {
        Preconditions.checkNotNull(fieldPath, "Provided field path must not be null.");
        return n(fieldPath.b(), direction);
    }

    @NonNull
    public ListenerRegistration addSnapshotListener(@NonNull Activity activity, @NonNull MetadataChanges metadataChanges, @NonNull EventListener<QuerySnapshot> eventListener) {
        Preconditions.checkNotNull(activity, "Provided activity must not be null.");
        Preconditions.checkNotNull(metadataChanges, "Provided MetadataChanges value must not be null.");
        Preconditions.checkNotNull(eventListener, "Provided EventListener must not be null.");
        return d(Executors.DEFAULT_CALLBACK_EXECUTOR, j(metadataChanges), activity, eventListener);
    }
}
