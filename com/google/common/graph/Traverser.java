package com.google.common.graph;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.google.errorprone.annotations.DoNotMock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import javax.annotation.CheckForNull;

@Beta
@ElementTypesAreNonnullByDefault
@DoNotMock("Call forGraph or forTree, passing a lambda or a Graph with the desired edges (built with GraphBuilder)")
/* loaded from: classes5.dex */
public abstract class Traverser<N> {

    /* renamed from: a  reason: collision with root package name */
    private final SuccessorsFunction<N> f27766a;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum InsertionOrder {
        FRONT { // from class: com.google.common.graph.Traverser.InsertionOrder.1
            @Override // com.google.common.graph.Traverser.InsertionOrder
            <T> void b(Deque<T> deque, T t3) {
                deque.addFirst(t3);
            }
        },
        BACK { // from class: com.google.common.graph.Traverser.InsertionOrder.2
            @Override // com.google.common.graph.Traverser.InsertionOrder
            <T> void b(Deque<T> deque, T t3) {
                deque.addLast(t3);
            }
        };

        abstract <T> void b(Deque<T> deque, T t3);
    }

    /* loaded from: classes5.dex */
    private static abstract class Traversal<N> {

        /* renamed from: a  reason: collision with root package name */
        final SuccessorsFunction<N> f27778a;

        Traversal(SuccessorsFunction<N> successorsFunction) {
            this.f27778a = successorsFunction;
        }

        static <N> Traversal<N> b(SuccessorsFunction<N> successorsFunction) {
            final HashSet hashSet = new HashSet();
            return new Traversal<N>(successorsFunction) { // from class: com.google.common.graph.Traverser.Traversal.1
                @Override // com.google.common.graph.Traverser.Traversal
                @CheckForNull
                N g(Deque<Iterator<? extends N>> deque) {
                    Iterator<? extends N> first = deque.getFirst();
                    while (first.hasNext()) {
                        N next = first.next();
                        Objects.requireNonNull(next);
                        if (hashSet.add(next)) {
                            return next;
                        }
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        static <N> Traversal<N> c(SuccessorsFunction<N> successorsFunction) {
            return new Traversal<N>(successorsFunction) { // from class: com.google.common.graph.Traverser.Traversal.2
                @Override // com.google.common.graph.Traverser.Traversal
                @CheckForNull
                N g(Deque<Iterator<? extends N>> deque) {
                    Iterator<? extends N> first = deque.getFirst();
                    if (first.hasNext()) {
                        return (N) Preconditions.checkNotNull(first.next());
                    }
                    deque.removeFirst();
                    return null;
                }
            };
        }

        private Iterator<N> f(Iterator<? extends N> it, final InsertionOrder insertionOrder) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            arrayDeque.add(it);
            return new AbstractIterator<N>() { // from class: com.google.common.graph.Traverser.Traversal.3
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                protected N a() {
                    do {
                        N n4 = (N) Traversal.this.g(arrayDeque);
                        if (n4 != null) {
                            Iterator<? extends N> it2 = Traversal.this.f27778a.successors(n4).iterator();
                            if (it2.hasNext()) {
                                insertionOrder.b(arrayDeque, it2);
                            }
                            return n4;
                        }
                    } while (!arrayDeque.isEmpty());
                    return b();
                }
            };
        }

        final Iterator<N> a(Iterator<? extends N> it) {
            return f(it, InsertionOrder.BACK);
        }

        final Iterator<N> d(Iterator<? extends N> it) {
            final ArrayDeque arrayDeque = new ArrayDeque();
            final ArrayDeque arrayDeque2 = new ArrayDeque();
            arrayDeque2.add(it);
            return new AbstractIterator<N>() { // from class: com.google.common.graph.Traverser.Traversal.4
                @Override // com.google.common.collect.AbstractIterator
                @CheckForNull
                protected N a() {
                    while (true) {
                        N n4 = (N) Traversal.this.g(arrayDeque2);
                        if (n4 != null) {
                            Iterator<? extends N> it2 = Traversal.this.f27778a.successors(n4).iterator();
                            if (!it2.hasNext()) {
                                return n4;
                            }
                            arrayDeque2.addFirst(it2);
                            arrayDeque.push(n4);
                        } else if (!arrayDeque.isEmpty()) {
                            return (N) arrayDeque.pop();
                        } else {
                            return b();
                        }
                    }
                }
            };
        }

        final Iterator<N> e(Iterator<? extends N> it) {
            return f(it, InsertionOrder.FRONT);
        }

        @CheckForNull
        abstract N g(Deque<Iterator<? extends N>> deque);
    }

    private ImmutableSet<N> b(Iterable<? extends N> iterable) {
        ImmutableSet<N> copyOf = ImmutableSet.copyOf(iterable);
        UnmodifiableIterator<N> it = copyOf.iterator();
        while (it.hasNext()) {
            this.f27766a.successors(it.next());
        }
        return copyOf;
    }

    public static <N> Traverser<N> forGraph(final SuccessorsFunction<N> successorsFunction) {
        return new Traverser<N>(successorsFunction) { // from class: com.google.common.graph.Traverser.1
            @Override // com.google.common.graph.Traverser
            Traversal<N> a() {
                return Traversal.b(successorsFunction);
            }
        };
    }

    public static <N> Traverser<N> forTree(final SuccessorsFunction<N> successorsFunction) {
        if (successorsFunction instanceof BaseGraph) {
            Preconditions.checkArgument(((BaseGraph) successorsFunction).isDirected(), "Undirected graphs can never be trees.");
        }
        if (successorsFunction instanceof Network) {
            Preconditions.checkArgument(((Network) successorsFunction).isDirected(), "Undirected networks can never be trees.");
        }
        return new Traverser<N>(successorsFunction) { // from class: com.google.common.graph.Traverser.2
            @Override // com.google.common.graph.Traverser
            Traversal<N> a() {
                return Traversal.c(successorsFunction);
            }
        };
    }

    abstract Traversal<N> a();

    public final Iterable<N> breadthFirst(N n4) {
        return breadthFirst((Iterable) ImmutableSet.of(n4));
    }

    public final Iterable<N> depthFirstPostOrder(N n4) {
        return depthFirstPostOrder((Iterable) ImmutableSet.of(n4));
    }

    public final Iterable<N> depthFirstPreOrder(N n4) {
        return depthFirstPreOrder((Iterable) ImmutableSet.of(n4));
    }

    private Traverser(SuccessorsFunction<N> successorsFunction) {
        this.f27766a = (SuccessorsFunction) Preconditions.checkNotNull(successorsFunction);
    }

    public final Iterable<N> breadthFirst(Iterable<? extends N> iterable) {
        final ImmutableSet<N> b4 = b(iterable);
        return new Iterable<N>() { // from class: com.google.common.graph.Traverser.3
            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return Traverser.this.a().a(b4.iterator());
            }
        };
    }

    public final Iterable<N> depthFirstPostOrder(Iterable<? extends N> iterable) {
        final ImmutableSet<N> b4 = b(iterable);
        return new Iterable<N>() { // from class: com.google.common.graph.Traverser.5
            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return Traverser.this.a().d(b4.iterator());
            }
        };
    }

    public final Iterable<N> depthFirstPreOrder(Iterable<? extends N> iterable) {
        final ImmutableSet<N> b4 = b(iterable);
        return new Iterable<N>() { // from class: com.google.common.graph.Traverser.4
            @Override // java.lang.Iterable
            public Iterator<N> iterator() {
                return Traverser.this.a().e(b4.iterator());
            }
        };
    }
}
