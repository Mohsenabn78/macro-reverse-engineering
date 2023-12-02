package com.google.common.graph;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.graph.DirectedGraphConnections;
import com.google.common.graph.ElementOrder;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class DirectedGraphConnections<N, V> implements GraphConnections<N, V> {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f27684e = new Object();

    /* renamed from: a  reason: collision with root package name */
    private final Map<N, Object> f27685a;
    @CheckForNull

    /* renamed from: b  reason: collision with root package name */
    private final List<NodeConnection<N>> f27686b;

    /* renamed from: c  reason: collision with root package name */
    private int f27687c;

    /* renamed from: d  reason: collision with root package name */
    private int f27688d;

    /* renamed from: com.google.common.graph.DirectedGraphConnections$5  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f27700a;

        static {
            int[] iArr = new int[ElementOrder.Type.values().length];
            f27700a = iArr;
            try {
                iArr[ElementOrder.Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f27700a[ElementOrder.Type.STABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static abstract class NodeConnection<N> {

        /* renamed from: a  reason: collision with root package name */
        final N f27701a;

        /* loaded from: classes5.dex */
        static final class Pred<N> extends NodeConnection<N> {
            Pred(N n4) {
                super(n4);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof Pred) {
                    return this.f27701a.equals(((Pred) obj).f27701a);
                }
                return false;
            }

            public int hashCode() {
                return Pred.class.hashCode() + this.f27701a.hashCode();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes5.dex */
        public static final class Succ<N> extends NodeConnection<N> {
            Succ(N n4) {
                super(n4);
            }

            public boolean equals(@CheckForNull Object obj) {
                if (obj instanceof Succ) {
                    return this.f27701a.equals(((Succ) obj).f27701a);
                }
                return false;
            }

            public int hashCode() {
                return Succ.class.hashCode() + this.f27701a.hashCode();
            }
        }

        NodeConnection(N n4) {
            this.f27701a = (N) Preconditions.checkNotNull(n4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class PredAndSucc {

        /* renamed from: a  reason: collision with root package name */
        private final Object f27702a;

        PredAndSucc(Object obj) {
            this.f27702a = obj;
        }
    }

    private DirectedGraphConnections(Map<N, Object> map, @CheckForNull List<NodeConnection<N>> list, int i4, int i5) {
        boolean z3;
        this.f27685a = (Map) Preconditions.checkNotNull(map);
        this.f27686b = list;
        this.f27687c = Graphs.b(i4);
        this.f27688d = Graphs.b(i5);
        if (i4 <= map.size() && i5 <= map.size()) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean s(@CheckForNull Object obj) {
        if (obj != f27684e && !(obj instanceof PredAndSucc)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean t(@CheckForNull Object obj) {
        if (obj != f27684e && obj != null) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EndpointPair u(Object obj, Object obj2) {
        return EndpointPair.ordered(obj2, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ EndpointPair w(Object obj, NodeConnection nodeConnection) {
        if (nodeConnection instanceof NodeConnection.Succ) {
            return EndpointPair.ordered(obj, nodeConnection.f27701a);
        }
        return EndpointPair.ordered(nodeConnection.f27701a, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <N, V> DirectedGraphConnections<N, V> x(ElementOrder<N> elementOrder) {
        ArrayList arrayList;
        int i4 = AnonymousClass5.f27700a[elementOrder.type().ordinal()];
        if (i4 != 1) {
            if (i4 == 2) {
                arrayList = new ArrayList();
            } else {
                throw new AssertionError(elementOrder.type());
            }
        } else {
            arrayList = null;
        }
        return new DirectedGraphConnections<>(new HashMap(4, 1.0f), arrayList, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static <N, V> DirectedGraphConnections<N, V> y(N n4, Iterable<EndpointPair<N>> iterable, Function<N, V> function) {
        boolean z3;
        Preconditions.checkNotNull(n4);
        Preconditions.checkNotNull(function);
        HashMap hashMap = new HashMap();
        ImmutableList.Builder builder = ImmutableList.builder();
        int i4 = 0;
        int i5 = 0;
        for (EndpointPair<N> endpointPair : iterable) {
            if (endpointPair.nodeU().equals(n4) && endpointPair.nodeV().equals(n4)) {
                hashMap.put(n4, new PredAndSucc(function.apply(n4)));
                builder.add((ImmutableList.Builder) new NodeConnection.Pred(n4));
                builder.add((ImmutableList.Builder) new NodeConnection.Succ(n4));
                i4++;
            } else if (endpointPair.nodeV().equals(n4)) {
                N nodeU = endpointPair.nodeU();
                Object put = hashMap.put(nodeU, f27684e);
                if (put != null) {
                    hashMap.put(nodeU, new PredAndSucc(put));
                }
                builder.add((ImmutableList.Builder) new NodeConnection.Pred(nodeU));
                i4++;
            } else {
                Preconditions.checkArgument(endpointPair.nodeU().equals(n4));
                N nodeV = endpointPair.nodeV();
                V apply = function.apply(nodeV);
                Object put2 = hashMap.put(nodeV, apply);
                if (put2 != null) {
                    if (put2 == f27684e) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkArgument(z3);
                    hashMap.put(nodeV, new PredAndSucc(apply));
                }
                builder.add((ImmutableList.Builder) new NodeConnection.Succ(nodeV));
            }
            i5++;
        }
        return new DirectedGraphConnections<>(hashMap, builder.build(), i4, i5);
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> a() {
        if (this.f27686b == null) {
            return Collections.unmodifiableSet(this.f27685a.keySet());
        }
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.1
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: a */
            public UnmodifiableIterator<N> iterator() {
                final Iterator it = DirectedGraphConnections.this.f27686b.iterator();
                final HashSet hashSet = new HashSet();
                return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.1.1
                    @Override // com.google.common.collect.AbstractIterator
                    @CheckForNull
                    protected N a() {
                        while (it.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it.next();
                            if (hashSet.add(nodeConnection.f27701a)) {
                                return nodeConnection.f27701a;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.this.f27685a.containsKey(obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.f27685a.size();
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> b() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.3
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: a */
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.f27686b == null) {
                    final Iterator it = DirectedGraphConnections.this.f27685a.entrySet().iterator();
                    return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.3.1
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        protected N a() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.t(entry.getValue())) {
                                    return (N) entry.getKey();
                                }
                            }
                            return b();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.f27686b.iterator();
                return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.3.2
                    @Override // com.google.common.collect.AbstractIterator
                    @CheckForNull
                    protected N a() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Succ) {
                                return nodeConnection.f27701a;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.t(DirectedGraphConnections.this.f27685a.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.f27688d;
            }
        };
    }

    @Override // com.google.common.graph.GraphConnections
    public Set<N> c() {
        return new AbstractSet<N>() { // from class: com.google.common.graph.DirectedGraphConnections.2
            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            /* renamed from: a */
            public UnmodifiableIterator<N> iterator() {
                if (DirectedGraphConnections.this.f27686b == null) {
                    final Iterator it = DirectedGraphConnections.this.f27685a.entrySet().iterator();
                    return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.2.1
                        @Override // com.google.common.collect.AbstractIterator
                        @CheckForNull
                        protected N a() {
                            while (it.hasNext()) {
                                Map.Entry entry = (Map.Entry) it.next();
                                if (DirectedGraphConnections.s(entry.getValue())) {
                                    return (N) entry.getKey();
                                }
                            }
                            return b();
                        }
                    };
                }
                final Iterator it2 = DirectedGraphConnections.this.f27686b.iterator();
                return new AbstractIterator<N>(this) { // from class: com.google.common.graph.DirectedGraphConnections.2.2
                    @Override // com.google.common.collect.AbstractIterator
                    @CheckForNull
                    protected N a() {
                        while (it2.hasNext()) {
                            NodeConnection nodeConnection = (NodeConnection) it2.next();
                            if (nodeConnection instanceof NodeConnection.Pred) {
                                return nodeConnection.f27701a;
                            }
                        }
                        return b();
                    }
                };
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(@CheckForNull Object obj) {
                return DirectedGraphConnections.s(DirectedGraphConnections.this.f27685a.get(obj));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return DirectedGraphConnections.this.f27687c;
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.graph.GraphConnections
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void d(N r5, V r6) {
        /*
            r4 = this;
            java.util.Map<N, java.lang.Object> r6 = r4.f27685a
            java.lang.Object r0 = com.google.common.graph.DirectedGraphConnections.f27684e
            java.lang.Object r6 = r6.put(r5, r0)
            r1 = 1
            if (r6 != 0) goto Ld
        Lb:
            r3 = 1
            goto L25
        Ld:
            boolean r2 = r6 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            r3 = 0
            if (r2 == 0) goto L18
            java.util.Map<N, java.lang.Object> r0 = r4.f27685a
            r0.put(r5, r6)
            goto L25
        L18:
            if (r6 == r0) goto L25
            java.util.Map<N, java.lang.Object> r0 = r4.f27685a
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r2.<init>(r6)
            r0.put(r5, r2)
            goto Lb
        L25:
            if (r3 == 0) goto L3b
            int r6 = r4.f27687c
            int r6 = r6 + r1
            r4.f27687c = r6
            com.google.common.graph.Graphs.d(r6)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r6 = r4.f27686b
            if (r6 == 0) goto L3b
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred r0 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred
            r0.<init>(r5)
            r6.add(r0)
        L3b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.d(java.lang.Object, java.lang.Object):void");
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V e(N n4) {
        Preconditions.checkNotNull(n4);
        V v3 = (V) this.f27685a.get(n4);
        if (v3 == f27684e) {
            return null;
        }
        if (v3 instanceof PredAndSucc) {
            return (V) ((PredAndSucc) v3).f27702a;
        }
        return v3;
    }

    @Override // com.google.common.graph.GraphConnections
    @CheckForNull
    public V f(Object obj) {
        Object obj2;
        Preconditions.checkNotNull(obj);
        Object obj3 = this.f27685a.get(obj);
        if (obj3 != null && obj3 != (obj2 = f27684e)) {
            if (obj3 instanceof PredAndSucc) {
                this.f27685a.put(obj, obj2);
                obj3 = ((PredAndSucc) obj3).f27702a;
            } else {
                this.f27685a.remove(obj);
            }
        } else {
            obj3 = null;
        }
        if (obj3 != null) {
            int i4 = this.f27688d - 1;
            this.f27688d = i4;
            Graphs.b(i4);
            List<NodeConnection<N>> list = this.f27686b;
            if (list != null) {
                list.remove(new NodeConnection.Succ(obj));
            }
        }
        if (obj3 == null) {
            return null;
        }
        return (V) obj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.graph.GraphConnections
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void g(N r4) {
        /*
            r3 = this;
            com.google.common.base.Preconditions.checkNotNull(r4)
            java.util.Map<N, java.lang.Object> r0 = r3.f27685a
            java.lang.Object r0 = r0.get(r4)
            java.lang.Object r1 = com.google.common.graph.DirectedGraphConnections.f27684e
            r2 = 1
            if (r0 != r1) goto L15
            java.util.Map<N, java.lang.Object> r0 = r3.f27685a
            r0.remove(r4)
        L13:
            r0 = 1
            goto L26
        L15:
            boolean r1 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r1 == 0) goto L25
            java.util.Map<N, java.lang.Object> r1 = r3.f27685a
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r0 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r0
            java.lang.Object r0 = com.google.common.graph.DirectedGraphConnections.PredAndSucc.a(r0)
            r1.put(r4, r0)
            goto L13
        L25:
            r0 = 0
        L26:
            if (r0 == 0) goto L3c
            int r0 = r3.f27687c
            int r0 = r0 - r2
            r3.f27687c = r0
            com.google.common.graph.Graphs.b(r0)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r0 = r3.f27686b
            if (r0 == 0) goto L3c
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred r1 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Pred
            r1.<init>(r4)
            r0.remove(r1)
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.g(java.lang.Object):void");
    }

    @Override // com.google.common.graph.GraphConnections
    public Iterator<EndpointPair<N>> h(final N n4) {
        final Iterator transform;
        Preconditions.checkNotNull(n4);
        List<NodeConnection<N>> list = this.f27686b;
        if (list == null) {
            transform = Iterators.concat(Iterators.transform(c().iterator(), new Function() { // from class: com.google.common.graph.h
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair u3;
                    u3 = DirectedGraphConnections.u(n4, obj);
                    return u3;
                }
            }), Iterators.transform(b().iterator(), new Function() { // from class: com.google.common.graph.i
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair ordered;
                    ordered = EndpointPair.ordered(n4, obj);
                    return ordered;
                }
            }));
        } else {
            transform = Iterators.transform(list.iterator(), new Function() { // from class: com.google.common.graph.j
                @Override // com.google.common.base.Function
                public final Object apply(Object obj) {
                    EndpointPair w3;
                    w3 = DirectedGraphConnections.w(n4, (DirectedGraphConnections.NodeConnection) obj);
                    return w3;
                }
            });
        }
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        return new AbstractIterator<EndpointPair<N>>(this) { // from class: com.google.common.graph.DirectedGraphConnections.4
            /* JADX INFO: Access modifiers changed from: protected */
            /* JADX WARN: Removed duplicated region for block: B:4:0x0008  */
            @Override // com.google.common.collect.AbstractIterator
            @javax.annotation.CheckForNull
            /* renamed from: d */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public com.google.common.graph.EndpointPair<N> a() {
                /*
                    r3 = this;
                L0:
                    java.util.Iterator r0 = r2
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L28
                    java.util.Iterator r0 = r2
                    java.lang.Object r0 = r0.next()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    java.lang.Object r1 = r0.nodeU()
                    java.lang.Object r2 = r0.nodeV()
                    boolean r1 = r1.equals(r2)
                    if (r1 == 0) goto L27
                    java.util.concurrent.atomic.AtomicBoolean r1 = r3
                    r2 = 1
                    boolean r1 = r1.getAndSet(r2)
                    if (r1 != 0) goto L0
                L27:
                    return r0
                L28:
                    java.lang.Object r0 = r3.b()
                    com.google.common.graph.EndpointPair r0 = (com.google.common.graph.EndpointPair) r0
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.AnonymousClass4.a():com.google.common.graph.EndpointPair");
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    @Override // com.google.common.graph.GraphConnections
    @javax.annotation.CheckForNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public V i(N r5, V r6) {
        /*
            r4 = this;
            java.util.Map<N, java.lang.Object> r0 = r4.f27685a
            java.lang.Object r0 = r0.put(r5, r6)
            r1 = 0
            if (r0 != 0) goto Lb
        L9:
            r0 = r1
            goto L2f
        Lb:
            boolean r2 = r0 instanceof com.google.common.graph.DirectedGraphConnections.PredAndSucc
            if (r2 == 0) goto L20
            java.util.Map<N, java.lang.Object> r2 = r4.f27685a
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r3 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r3.<init>(r6)
            r2.put(r5, r3)
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r0 = (com.google.common.graph.DirectedGraphConnections.PredAndSucc) r0
            java.lang.Object r0 = com.google.common.graph.DirectedGraphConnections.PredAndSucc.a(r0)
            goto L2f
        L20:
            java.lang.Object r2 = com.google.common.graph.DirectedGraphConnections.f27684e
            if (r0 != r2) goto L2f
            java.util.Map<N, java.lang.Object> r0 = r4.f27685a
            com.google.common.graph.DirectedGraphConnections$PredAndSucc r2 = new com.google.common.graph.DirectedGraphConnections$PredAndSucc
            r2.<init>(r6)
            r0.put(r5, r2)
            goto L9
        L2f:
            if (r0 != 0) goto L46
            int r6 = r4.f27688d
            int r6 = r6 + 1
            r4.f27688d = r6
            com.google.common.graph.Graphs.d(r6)
            java.util.List<com.google.common.graph.DirectedGraphConnections$NodeConnection<N>> r6 = r4.f27686b
            if (r6 == 0) goto L46
            com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ r2 = new com.google.common.graph.DirectedGraphConnections$NodeConnection$Succ
            r2.<init>(r5)
            r6.add(r2)
        L46:
            if (r0 != 0) goto L49
            goto L4a
        L49:
            r1 = r0
        L4a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.graph.DirectedGraphConnections.i(java.lang.Object, java.lang.Object):java.lang.Object");
    }
}
