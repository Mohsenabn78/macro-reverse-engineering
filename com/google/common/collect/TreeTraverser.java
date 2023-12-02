package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Queue;
import javax.annotation.CheckForNull;

@Beta
@GwtCompatible
@Deprecated
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class TreeTraverser<T> {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class BreadthFirstIterator extends UnmodifiableIterator<T> implements PeekingIterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Queue<T> f27590a;

        BreadthFirstIterator(T t3) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f27590a = arrayDeque;
            arrayDeque.add(t3);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f27590a.isEmpty();
        }

        @Override // java.util.Iterator, com.google.common.collect.PeekingIterator
        public T next() {
            T remove = this.f27590a.remove();
            Iterables.addAll(this.f27590a, TreeTraverser.this.children(remove));
            return remove;
        }

        @Override // com.google.common.collect.PeekingIterator
        public T peek() {
            return this.f27590a.element();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class PostOrderIterator extends AbstractIterator<T> {

        /* renamed from: c  reason: collision with root package name */
        private final ArrayDeque<PostOrderNode<T>> f27592c;

        PostOrderIterator(T t3) {
            ArrayDeque<PostOrderNode<T>> arrayDeque = new ArrayDeque<>();
            this.f27592c = arrayDeque;
            arrayDeque.addLast(d(t3));
        }

        private PostOrderNode<T> d(T t3) {
            return new PostOrderNode<>(t3, TreeTraverser.this.children(t3).iterator());
        }

        @Override // com.google.common.collect.AbstractIterator
        @CheckForNull
        protected T a() {
            while (!this.f27592c.isEmpty()) {
                PostOrderNode<T> last = this.f27592c.getLast();
                if (last.f27595b.hasNext()) {
                    this.f27592c.addLast(d(last.f27595b.next()));
                } else {
                    this.f27592c.removeLast();
                    return last.f27594a;
                }
            }
            return b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class PostOrderNode<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f27594a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<T> f27595b;

        PostOrderNode(T t3, Iterator<T> it) {
            this.f27594a = (T) Preconditions.checkNotNull(t3);
            this.f27595b = (Iterator) Preconditions.checkNotNull(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public final class PreOrderIterator extends UnmodifiableIterator<T> {

        /* renamed from: a  reason: collision with root package name */
        private final Deque<Iterator<T>> f27596a;

        PreOrderIterator(T t3) {
            ArrayDeque arrayDeque = new ArrayDeque();
            this.f27596a = arrayDeque;
            arrayDeque.addLast(Iterators.singletonIterator(Preconditions.checkNotNull(t3)));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f27596a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            Iterator<T> last = this.f27596a.getLast();
            T t3 = (T) Preconditions.checkNotNull(last.next());
            if (!last.hasNext()) {
                this.f27596a.removeLast();
            }
            Iterator<T> it = TreeTraverser.this.children(t3).iterator();
            if (it.hasNext()) {
                this.f27596a.addLast(it);
            }
            return t3;
        }
    }

    @Deprecated
    public static <T> TreeTraverser<T> using(final Function<T, ? extends Iterable<T>> function) {
        Preconditions.checkNotNull(function);
        return new TreeTraverser<T>() { // from class: com.google.common.collect.TreeTraverser.1
            @Override // com.google.common.collect.TreeTraverser
            public Iterable<T> children(T t3) {
                return (Iterable) Function.this.apply(t3);
            }
        };
    }

    UnmodifiableIterator<T> a(T t3) {
        return new PostOrderIterator(t3);
    }

    UnmodifiableIterator<T> b(T t3) {
        return new PreOrderIterator(t3);
    }

    @Deprecated
    public final FluentIterable<T> breadthFirstTraversal(final T t3) {
        Preconditions.checkNotNull(t3);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.4
            @Override // java.lang.Iterable
            /* renamed from: c */
            public UnmodifiableIterator<T> iterator() {
                return new BreadthFirstIterator(t3);
            }
        };
    }

    public abstract Iterable<T> children(T t3);

    @Deprecated
    public final FluentIterable<T> postOrderTraversal(final T t3) {
        Preconditions.checkNotNull(t3);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.3
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Iterable
            /* renamed from: c */
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.a(t3);
            }
        };
    }

    @Deprecated
    public final FluentIterable<T> preOrderTraversal(final T t3) {
        Preconditions.checkNotNull(t3);
        return new FluentIterable<T>() { // from class: com.google.common.collect.TreeTraverser.2
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Iterable
            /* renamed from: c */
            public UnmodifiableIterator<T> iterator() {
                return TreeTraverser.this.b(t3);
            }
        };
    }
}
