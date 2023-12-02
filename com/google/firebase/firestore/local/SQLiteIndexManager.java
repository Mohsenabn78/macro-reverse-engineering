package com.google.firebase.firestore.local;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.firebase.Timestamp;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.firestore.auth.User;
import com.google.firebase.firestore.core.Bound;
import com.google.firebase.firestore.core.CompositeFilter;
import com.google.firebase.firestore.core.FieldFilter;
import com.google.firebase.firestore.core.Filter;
import com.google.firebase.firestore.core.OrderBy;
import com.google.firebase.firestore.core.Target;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.firebase.firestore.index.IndexByteEncoder;
import com.google.firebase.firestore.index.IndexEntry;
import com.google.firebase.firestore.local.IndexManager;
import com.google.firebase.firestore.local.MemoryIndexManager;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.FieldIndex;
import com.google.firebase.firestore.model.FieldPath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.TargetIndexMatcher;
import com.google.firebase.firestore.model.Values;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.LogicUtils;
import com.google.firebase.firestore.util.Util;
import com.google.firestore.admin.v1.Index;
import com.google.firestore.v1.Value;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;
import net.bytebuddy.description.type.TypeDescription;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class SQLiteIndexManager implements IndexManager {

    /* renamed from: k  reason: collision with root package name */
    private static final String f30708k = "SQLiteIndexManager";

    /* renamed from: l  reason: collision with root package name */
    private static final byte[] f30709l = new byte[0];

    /* renamed from: a  reason: collision with root package name */
    private final SQLitePersistence f30710a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalSerializer f30711b;

    /* renamed from: c  reason: collision with root package name */
    private final String f30712c;

    /* renamed from: d  reason: collision with root package name */
    private final Map<Target, List<Target>> f30713d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    private final MemoryIndexManager.MemoryCollectionParentIndex f30714e = new MemoryIndexManager.MemoryCollectionParentIndex();

    /* renamed from: f  reason: collision with root package name */
    private final Map<String, Map<Integer, FieldIndex>> f30715f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    private final Queue<FieldIndex> f30716g = new PriorityQueue(10, new Comparator() { // from class: com.google.firebase.firestore.local.q0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int C;
            C = SQLiteIndexManager.C((FieldIndex) obj, (FieldIndex) obj2);
            return C;
        }
    });

    /* renamed from: h  reason: collision with root package name */
    private boolean f30717h = false;

    /* renamed from: i  reason: collision with root package name */
    private int f30718i = -1;

    /* renamed from: j  reason: collision with root package name */
    private long f30719j = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteIndexManager(SQLitePersistence sQLitePersistence, LocalSerializer localSerializer, User user) {
        String str;
        this.f30710a = sQLitePersistence;
        this.f30711b = localSerializer;
        if (user.isAuthenticated()) {
            str = user.getUid();
        } else {
            str = "";
        }
        this.f30712c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void A(List list, Cursor cursor) {
        list.add(DocumentKey.fromPath(ResourcePath.fromString(cursor.getString(0))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B(SortedSet sortedSet, FieldIndex fieldIndex, DocumentKey documentKey, Cursor cursor) {
        sortedSet.add(IndexEntry.create(fieldIndex.getIndexId(), documentKey, cursor.getBlob(0), cursor.getBlob(1)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int C(FieldIndex fieldIndex, FieldIndex fieldIndex2) {
        int compare = Long.compare(fieldIndex.getIndexState().getSequenceNumber(), fieldIndex2.getIndexState().getSequenceNumber());
        if (compare == 0) {
            return fieldIndex.getCollectionGroup().compareTo(fieldIndex2.getCollectionGroup());
        }
        return compare;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void D(Map map, Cursor cursor) {
        map.put(Integer.valueOf(cursor.getInt(0)), FieldIndex.IndexState.create(cursor.getLong(1), new SnapshotVersion(new Timestamp(cursor.getLong(2), cursor.getInt(3))), DocumentKey.fromPath(EncodedPath.b(cursor.getString(4))), cursor.getInt(5)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(Map map, Cursor cursor) {
        FieldIndex.IndexState indexState;
        try {
            int i4 = cursor.getInt(0);
            String string = cursor.getString(1);
            List<FieldIndex.Segment> decodeFieldIndexSegments = this.f30711b.decodeFieldIndexSegments(Index.parseFrom(cursor.getBlob(2)));
            if (map.containsKey(Integer.valueOf(i4))) {
                indexState = (FieldIndex.IndexState) map.get(Integer.valueOf(i4));
            } else {
                indexState = FieldIndex.INITIAL_STATE;
            }
            H(FieldIndex.create(i4, string, decodeFieldIndexSegments, indexState));
        } catch (InvalidProtocolBufferException e4) {
            throw Assert.fail("Failed to decode index: " + e4, new Object[0]);
        }
    }

    private void H(FieldIndex fieldIndex) {
        Map<Integer, FieldIndex> map = this.f30715f.get(fieldIndex.getCollectionGroup());
        if (map == null) {
            map = new HashMap<>();
            this.f30715f.put(fieldIndex.getCollectionGroup(), map);
        }
        FieldIndex fieldIndex2 = map.get(Integer.valueOf(fieldIndex.getIndexId()));
        if (fieldIndex2 != null) {
            this.f30716g.remove(fieldIndex2);
        }
        map.put(Integer.valueOf(fieldIndex.getIndexId()), fieldIndex);
        this.f30716g.add(fieldIndex);
        this.f30718i = Math.max(this.f30718i, fieldIndex.getIndexId());
        this.f30719j = Math.max(this.f30719j, fieldIndex.getIndexState().getSequenceNumber());
    }

    private void I(final Document document, SortedSet<IndexEntry> sortedSet, SortedSet<IndexEntry> sortedSet2) {
        Logger.debug(f30708k, "Updating index entries for document '%s'", document.getKey());
        Util.diffCollections(sortedSet, sortedSet2, new Consumer() { // from class: com.google.firebase.firestore.local.o0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.this.F(document, (IndexEntry) obj);
            }
        }, new Consumer() { // from class: com.google.firebase.firestore.local.p0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.this.G(document, (IndexEntry) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void F(Document document, IndexEntry indexEntry) {
        this.f30710a.p("INSERT INTO index_entries (index_id, uid, array_value, directional_value, document_key) VALUES(?, ?, ?, ?, ?)", Integer.valueOf(indexEntry.getIndexId()), this.f30712c, indexEntry.getArrayValue(), indexEntry.getDirectionalValue(), document.getKey().toString());
    }

    private SortedSet<IndexEntry> j(Document document, FieldIndex fieldIndex) {
        TreeSet treeSet = new TreeSet();
        byte[] m4 = m(fieldIndex, document);
        if (m4 == null) {
            return treeSet;
        }
        FieldIndex.Segment arraySegment = fieldIndex.getArraySegment();
        if (arraySegment != null) {
            Value field = document.getField(arraySegment.getFieldPath());
            if (Values.isArray(field)) {
                for (Value value : field.getArrayValue().getValuesList()) {
                    treeSet.add(IndexEntry.create(fieldIndex.getIndexId(), document.getKey(), o(value), m4));
                }
            }
        } else {
            treeSet.add(IndexEntry.create(fieldIndex.getIndexId(), document.getKey(), new byte[0], m4));
        }
        return treeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void G(Document document, IndexEntry indexEntry) {
        this.f30710a.p("DELETE FROM index_entries WHERE index_id = ? AND uid = ? AND array_value = ? AND directional_value = ? AND document_key = ?", Integer.valueOf(indexEntry.getIndexId()), this.f30712c, indexEntry.getArrayValue(), indexEntry.getDirectionalValue(), document.getKey().toString());
    }

    private Object[] l(FieldIndex fieldIndex, Target target, Bound bound) {
        return p(fieldIndex, target, bound.getPosition());
    }

    @Nullable
    private byte[] m(FieldIndex fieldIndex, Document document) {
        IndexByteEncoder indexByteEncoder = new IndexByteEncoder();
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            Value field = document.getField(segment.getFieldPath());
            if (field == null) {
                return null;
            }
            FirestoreIndexValueWriter.INSTANCE.writeIndexValue(field, indexByteEncoder.forKind(segment.getKind()));
        }
        return indexByteEncoder.getEncodedBytes();
    }

    private byte[] n(FieldIndex fieldIndex) {
        return this.f30711b.encodeFieldIndexSegments(fieldIndex.getSegments()).toByteArray();
    }

    private byte[] o(Value value) {
        IndexByteEncoder indexByteEncoder = new IndexByteEncoder();
        FirestoreIndexValueWriter.INSTANCE.writeIndexValue(value, indexByteEncoder.forKind(FieldIndex.Segment.Kind.ASCENDING));
        return indexByteEncoder.getEncodedBytes();
    }

    @Nullable
    private Object[] p(FieldIndex fieldIndex, Target target, @Nullable Collection<Value> collection) {
        if (collection == null) {
            return null;
        }
        List<IndexByteEncoder> arrayList = new ArrayList<>();
        arrayList.add(new IndexByteEncoder());
        Iterator<Value> it = collection.iterator();
        for (FieldIndex.Segment segment : fieldIndex.getDirectionalSegments()) {
            Value next = it.next();
            for (IndexByteEncoder indexByteEncoder : arrayList) {
                if (y(target, segment.getFieldPath()) && Values.isArray(next)) {
                    arrayList = q(arrayList, segment, next);
                } else {
                    FirestoreIndexValueWriter.INSTANCE.writeIndexValue(next, indexByteEncoder.forKind(segment.getKind()));
                }
            }
        }
        return t(arrayList);
    }

    private List<IndexByteEncoder> q(List<IndexByteEncoder> list, FieldIndex.Segment segment, Value value) {
        ArrayList<IndexByteEncoder> arrayList = new ArrayList(list);
        ArrayList arrayList2 = new ArrayList();
        for (Value value2 : value.getArrayValue().getValuesList()) {
            for (IndexByteEncoder indexByteEncoder : arrayList) {
                IndexByteEncoder indexByteEncoder2 = new IndexByteEncoder();
                indexByteEncoder2.seed(indexByteEncoder.getEncodedBytes());
                FirestoreIndexValueWriter.INSTANCE.writeIndexValue(value2, indexByteEncoder2.forKind(segment.getKind()));
                arrayList2.add(indexByteEncoder2);
            }
        }
        return arrayList2;
    }

    private Object[] r(int i4, int i5, @Nullable List<Value> list, Object[] objArr, Object[] objArr2, @Nullable Object[] objArr3) {
        int i6;
        int i7;
        byte[] bArr;
        if (list != null) {
            i6 = list.size();
        } else {
            i6 = 1;
        }
        int i8 = i4 / i6;
        int i9 = i4 * 5;
        int i10 = 0;
        if (objArr3 != null) {
            i7 = objArr3.length;
        } else {
            i7 = 0;
        }
        Object[] objArr4 = new Object[i9 + i7];
        int i11 = 0;
        int i12 = 0;
        while (i11 < i4) {
            int i13 = i12 + 1;
            objArr4[i12] = Integer.valueOf(i5);
            int i14 = i13 + 1;
            objArr4[i13] = this.f30712c;
            int i15 = i14 + 1;
            if (list != null) {
                bArr = o(list.get(i11 / i8));
            } else {
                bArr = f30709l;
            }
            objArr4[i14] = bArr;
            int i16 = i15 + 1;
            int i17 = i11 % i8;
            objArr4[i15] = objArr[i17];
            objArr4[i16] = objArr2[i17];
            i11++;
            i12 = i16 + 1;
        }
        if (objArr3 != null) {
            int length = objArr3.length;
            while (i10 < length) {
                objArr4[i12] = objArr3[i10];
                i10++;
                i12++;
            }
        }
        return objArr4;
    }

    private Object[] s(Target target, int i4, @Nullable List<Value> list, Object[] objArr, String str, Object[] objArr2, String str2, @Nullable Object[] objArr3) {
        int i5;
        StringBuilder sb;
        if (list != null) {
            i5 = list.size();
        } else {
            i5 = 1;
        }
        int max = Math.max(objArr.length, objArr2.length) * i5;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("SELECT document_key, directional_value FROM index_entries ");
        sb2.append("WHERE index_id = ? AND uid = ? ");
        sb2.append("AND array_value = ? ");
        sb2.append("AND directional_value ");
        sb2.append(str);
        sb2.append(" ? ");
        sb2.append("AND directional_value ");
        sb2.append(str2);
        sb2.append(" ? ");
        StringBuilder repeatSequence = Util.repeatSequence(sb2, max, " UNION ");
        if (objArr3 != null) {
            StringBuilder sb3 = new StringBuilder("SELECT document_key, directional_value FROM (");
            sb3.append((CharSequence) repeatSequence);
            sb3.append(") WHERE directional_value NOT IN (");
            sb3.append((CharSequence) Util.repeatSequence(TypeDescription.Generic.OfWildcardType.SYMBOL, objArr3.length, ", "));
            sb3.append(")");
            sb = sb3;
        } else {
            sb = repeatSequence;
        }
        Object[] r4 = r(max, i4, list, objArr, objArr2, objArr3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(sb.toString());
        arrayList.addAll(Arrays.asList(r4));
        return arrayList.toArray();
    }

    private Object[] t(List<IndexByteEncoder> list) {
        Object[] objArr = new Object[list.size()];
        for (int i4 = 0; i4 < list.size(); i4++) {
            objArr[i4] = list.get(i4).getEncodedBytes();
        }
        return objArr;
    }

    private SortedSet<IndexEntry> u(final DocumentKey documentKey, final FieldIndex fieldIndex) {
        final TreeSet treeSet = new TreeSet();
        this.f30710a.x("SELECT array_value, directional_value FROM index_entries WHERE index_id = ? AND document_key = ? AND uid = ?").b(Integer.valueOf(fieldIndex.getIndexId()), documentKey.toString(), this.f30712c).e(new Consumer() { // from class: com.google.firebase.firestore.local.s0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.B(treeSet, fieldIndex, documentKey, (Cursor) obj);
            }
        });
        return treeSet;
    }

    @Nullable
    private FieldIndex v(Target target) {
        String lastSegment;
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        TargetIndexMatcher targetIndexMatcher = new TargetIndexMatcher(target);
        if (target.getCollectionGroup() != null) {
            lastSegment = target.getCollectionGroup();
        } else {
            lastSegment = target.getPath().getLastSegment();
        }
        Collection<FieldIndex> fieldIndexes = getFieldIndexes(lastSegment);
        FieldIndex fieldIndex = null;
        if (fieldIndexes.isEmpty()) {
            return null;
        }
        for (FieldIndex fieldIndex2 : fieldIndexes) {
            if (targetIndexMatcher.servedByIndex(fieldIndex2) && (fieldIndex == null || fieldIndex2.getSegments().size() > fieldIndex.getSegments().size())) {
                fieldIndex = fieldIndex2;
            }
        }
        return fieldIndex;
    }

    private FieldIndex.IndexOffset w(Collection<FieldIndex> collection) {
        Assert.hardAssert(!collection.isEmpty(), "Found empty index group when looking for least recent index offset.", new Object[0]);
        Iterator<FieldIndex> it = collection.iterator();
        FieldIndex.IndexOffset offset = it.next().getIndexState().getOffset();
        int largestBatchId = offset.getLargestBatchId();
        while (it.hasNext()) {
            FieldIndex.IndexOffset offset2 = it.next().getIndexState().getOffset();
            if (offset2.compareTo(offset) < 0) {
                offset = offset2;
            }
            largestBatchId = Math.max(offset2.getLargestBatchId(), largestBatchId);
        }
        return FieldIndex.IndexOffset.create(offset.getReadTime(), offset.getDocumentKey(), largestBatchId);
    }

    private List<Target> x(Target target) {
        if (this.f30713d.containsKey(target)) {
            return this.f30713d.get(target);
        }
        ArrayList arrayList = new ArrayList();
        if (target.getFilters().isEmpty()) {
            arrayList.add(target);
        } else {
            for (Filter filter : LogicUtils.getDnfTerms(new CompositeFilter(target.getFilters(), CompositeFilter.Operator.AND))) {
                arrayList.add(new Target(target.getPath(), target.getCollectionGroup(), filter.getFilters(), target.getOrderBy(), target.getLimit(), target.getStartAt(), target.getEndAt()));
            }
        }
        this.f30713d.put(target, arrayList);
        return arrayList;
    }

    private boolean y(Target target, FieldPath fieldPath) {
        for (Filter filter : target.getFilters()) {
            if (filter instanceof FieldFilter) {
                FieldFilter fieldFilter = (FieldFilter) filter;
                if (fieldFilter.getField().equals(fieldPath)) {
                    FieldFilter.Operator operator = fieldFilter.getOperator();
                    if (operator.equals(FieldFilter.Operator.IN) || operator.equals(FieldFilter.Operator.NOT_IN)) {
                        return true;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void z(ArrayList arrayList, Cursor cursor) {
        arrayList.add(EncodedPath.b(cursor.getString(0)));
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addFieldIndex(FieldIndex fieldIndex) {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        int i4 = this.f30718i + 1;
        FieldIndex create = FieldIndex.create(i4, fieldIndex.getCollectionGroup(), fieldIndex.getSegments(), fieldIndex.getIndexState());
        this.f30710a.p("INSERT INTO index_configuration (index_id, collection_group, index_proto) VALUES(?, ?, ?)", Integer.valueOf(i4), create.getCollectionGroup(), n(create));
        H(create);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void addToCollectionParentIndex(ResourcePath resourcePath) {
        boolean z3;
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        if (resourcePath.length() % 2 == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Expected a collection path.", new Object[0]);
        if (this.f30714e.a(resourcePath)) {
            this.f30710a.p("INSERT OR REPLACE INTO collection_parents (collection_id, parent) VALUES (?, ?)", resourcePath.getLastSegment(), EncodedPath.c(resourcePath.popLast()));
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void createTargetIndexes(Target target) {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        for (Target target2 : x(target)) {
            IndexManager.IndexType indexType = getIndexType(target2);
            if (indexType == IndexManager.IndexType.NONE || indexType == IndexManager.IndexType.PARTIAL) {
                addFieldIndex(new TargetIndexMatcher(target2).buildTargetIndex());
            }
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void deleteAllFieldIndexes() {
        this.f30710a.p("DELETE FROM index_configuration", new Object[0]);
        this.f30710a.p("DELETE FROM index_entries", new Object[0]);
        this.f30710a.p("DELETE FROM index_state", new Object[0]);
        this.f30716g.clear();
        this.f30715f.clear();
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void deleteFieldIndex(FieldIndex fieldIndex) {
        this.f30710a.p("DELETE FROM index_configuration WHERE index_id = ?", Integer.valueOf(fieldIndex.getIndexId()));
        this.f30710a.p("DELETE FROM index_entries WHERE index_id = ?", Integer.valueOf(fieldIndex.getIndexId()));
        this.f30710a.p("DELETE FROM index_state WHERE index_id = ?", Integer.valueOf(fieldIndex.getIndexId()));
        this.f30716g.remove(fieldIndex);
        Map<Integer, FieldIndex> map = this.f30715f.get(fieldIndex.getCollectionGroup());
        if (map != null) {
            map.remove(Integer.valueOf(fieldIndex.getIndexId()));
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public List<ResourcePath> getCollectionParents(String str) {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        final ArrayList arrayList = new ArrayList();
        this.f30710a.x("SELECT parent FROM collection_parents WHERE collection_id = ?").b(str).e(new Consumer() { // from class: com.google.firebase.firestore.local.r0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.z(arrayList, (Cursor) obj);
            }
        });
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public List<DocumentKey> getDocumentsMatchingTarget(Target target) {
        String str;
        boolean z3;
        String str2;
        String str3;
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList<Pair> arrayList3 = new ArrayList();
        for (Target target2 : x(target)) {
            FieldIndex v3 = v(target2);
            if (v3 == null) {
                return null;
            }
            arrayList3.add(Pair.create(target2, v3));
        }
        for (Pair pair : arrayList3) {
            Target target3 = (Target) pair.first;
            FieldIndex fieldIndex = (FieldIndex) pair.second;
            List<Value> arrayValues = target3.getArrayValues(fieldIndex);
            Collection<Value> notInValues = target3.getNotInValues(fieldIndex);
            Bound lowerBound = target3.getLowerBound(fieldIndex);
            Bound upperBound = target3.getUpperBound(fieldIndex);
            if (Logger.isDebugEnabled()) {
                Logger.debug(f30708k, "Using index '%s' to execute '%s' (Arrays: %s, Lower bound: %s, Upper bound: %s)", fieldIndex, target3, arrayValues, lowerBound, upperBound);
            }
            Object[] l4 = l(fieldIndex, target3, lowerBound);
            if (lowerBound.isInclusive()) {
                str2 = ">=";
            } else {
                str2 = ">";
            }
            String str4 = str2;
            Object[] l5 = l(fieldIndex, target3, upperBound);
            if (upperBound.isInclusive()) {
                str3 = "<=";
            } else {
                str3 = "<";
            }
            Object[] s3 = s(target3, fieldIndex.getIndexId(), arrayValues, l4, str4, l5, str3, p(fieldIndex, target3, notInValues));
            arrayList.add(String.valueOf(s3[0]));
            arrayList2.addAll(Arrays.asList(s3).subList(1, s3.length));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(TextUtils.join(" UNION ", arrayList));
        sb.append("ORDER BY directional_value, document_key ");
        if (target.getKeyOrder().equals(OrderBy.Direction.ASCENDING)) {
            str = "asc ";
        } else {
            str = "desc ";
        }
        sb.append(str);
        String str5 = "SELECT DISTINCT document_key FROM (" + sb.toString() + ")";
        if (target.hasLimit()) {
            str5 = str5 + " LIMIT " + target.getLimit();
        }
        if (arrayList2.size() < 1000) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Cannot perform query with more than 999 bind elements", new Object[0]);
        SQLitePersistence.Query b4 = this.f30710a.x(str5).b(arrayList2.toArray());
        final ArrayList arrayList4 = new ArrayList();
        b4.e(new Consumer() { // from class: com.google.firebase.firestore.local.n0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.A(arrayList4, (Cursor) obj);
            }
        });
        Logger.debug(f30708k, "Index scan returned %s documents", Integer.valueOf(arrayList4.size()));
        return arrayList4;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public Collection<FieldIndex> getFieldIndexes(String str) {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        Map<Integer, FieldIndex> map = this.f30715f.get(str);
        return map == null ? Collections.emptyList() : map.values();
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public IndexManager.IndexType getIndexType(Target target) {
        IndexManager.IndexType indexType = IndexManager.IndexType.FULL;
        List<Target> x3 = x(target);
        Iterator<Target> it = x3.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Target next = it.next();
            FieldIndex v3 = v(next);
            if (v3 == null) {
                indexType = IndexManager.IndexType.NONE;
                break;
            } else if (v3.getSegments().size() < next.getSegmentCount()) {
                indexType = IndexManager.IndexType.PARTIAL;
            }
        }
        if (target.hasLimit() && x3.size() > 1 && indexType == IndexManager.IndexType.FULL) {
            return IndexManager.IndexType.PARTIAL;
        }
        return indexType;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public FieldIndex.IndexOffset getMinOffset(String str) {
        Collection<FieldIndex> fieldIndexes = getFieldIndexes(str);
        Assert.hardAssert(!fieldIndexes.isEmpty(), "minOffset was called for collection without indexes", new Object[0]);
        return w(fieldIndexes);
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    @Nullable
    public String getNextCollectionGroupToUpdate() {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        FieldIndex peek = this.f30716g.peek();
        if (peek != null) {
            return peek.getCollectionGroup();
        }
        return null;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void start() {
        final HashMap hashMap = new HashMap();
        this.f30710a.x("SELECT index_id, sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id FROM index_state WHERE uid = ?").b(this.f30712c).e(new Consumer() { // from class: com.google.firebase.firestore.local.t0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.D(hashMap, (Cursor) obj);
            }
        });
        this.f30710a.x("SELECT index_id, collection_group, index_proto FROM index_configuration").e(new Consumer() { // from class: com.google.firebase.firestore.local.u0
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                SQLiteIndexManager.this.E(hashMap, (Cursor) obj);
            }
        });
        this.f30717h = true;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void updateCollectionGroup(String str, FieldIndex.IndexOffset indexOffset) {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        this.f30719j++;
        for (FieldIndex fieldIndex : getFieldIndexes(str)) {
            FieldIndex create = FieldIndex.create(fieldIndex.getIndexId(), fieldIndex.getCollectionGroup(), fieldIndex.getSegments(), FieldIndex.IndexState.create(this.f30719j, indexOffset));
            this.f30710a.p("REPLACE INTO index_state (index_id, uid,  sequence_number, read_time_seconds, read_time_nanos, document_key, largest_batch_id) VALUES(?, ?, ?, ?, ?, ?, ?)", Integer.valueOf(fieldIndex.getIndexId()), this.f30712c, Long.valueOf(this.f30719j), Long.valueOf(indexOffset.getReadTime().getTimestamp().getSeconds()), Integer.valueOf(indexOffset.getReadTime().getTimestamp().getNanoseconds()), EncodedPath.c(indexOffset.getDocumentKey().getPath()), Integer.valueOf(indexOffset.getLargestBatchId()));
            H(create);
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public void updateIndexEntries(ImmutableSortedMap<DocumentKey, Document> immutableSortedMap) {
        Assert.hardAssert(this.f30717h, "IndexManager not started", new Object[0]);
        Iterator<Map.Entry<DocumentKey, Document>> it = immutableSortedMap.iterator();
        while (it.hasNext()) {
            Map.Entry<DocumentKey, Document> next = it.next();
            for (FieldIndex fieldIndex : getFieldIndexes(next.getKey().getCollectionGroup())) {
                SortedSet<IndexEntry> u3 = u(next.getKey(), fieldIndex);
                SortedSet<IndexEntry> j4 = j(next.getValue(), fieldIndex);
                if (!u3.equals(j4)) {
                    I(next.getValue(), u3, j4);
                }
            }
        }
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public Collection<FieldIndex> getFieldIndexes() {
        ArrayList arrayList = new ArrayList();
        for (Map<Integer, FieldIndex> map : this.f30715f.values()) {
            arrayList.addAll(map.values());
        }
        return arrayList;
    }

    @Override // com.google.firebase.firestore.local.IndexManager
    public FieldIndex.IndexOffset getMinOffset(Target target) {
        ArrayList arrayList = new ArrayList();
        for (Target target2 : x(target)) {
            FieldIndex v3 = v(target2);
            if (v3 != null) {
                arrayList.add(v3);
            }
        }
        return w(arrayList);
    }
}
