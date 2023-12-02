package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.NoSuchElementException;
import javax.annotation.CheckForNull;
import net.bytebuddy.pool.TypePool;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public abstract class Cut<C extends Comparable> implements Comparable<Cut<C>>, Serializable {
    private static final long serialVersionUID = 0;
    final C endpoint;

    /* renamed from: com.google.common.collect.Cut$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f26781a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f26781a = iArr;
            try {
                iArr[BoundType.CLOSED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f26781a[BoundType.OPEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AboveAll extends Cut<Comparable<?>> {

        /* renamed from: a  reason: collision with root package name */
        private static final AboveAll f26782a = new AboveAll();
        private static final long serialVersionUID = 0;

        private AboveAll() {
            super("");
        }

        private Object readResolve() {
            return f26782a;
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        /* renamed from: g */
        public int compareTo(Cut<Comparable<?>> cut) {
            if (cut == this) {
                return 0;
            }
            return 1;
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        void i(StringBuilder sb) {
            sb.append("+∞)");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> j() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> l(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.maxValue();
        }

        @Override // com.google.common.collect.Cut
        boolean m(Comparable<?> comparable) {
            return false;
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> n(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        BoundType o() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        BoundType p() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> q(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> r(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        public String toString() {
            return "+∞";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class AboveValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        AboveValue(C c4) {
            super((Comparable) Preconditions.checkNotNull(c4));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        Cut<C> f(DiscreteDomain<C> discreteDomain) {
            C n4 = n(discreteDomain);
            if (n4 != null) {
                return Cut.e(n4);
            }
            return Cut.a();
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            sb.append('(');
            sb.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return ~this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        void i(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(']');
        }

        @Override // com.google.common.collect.Cut
        C l(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        boolean m(C c4) {
            if (Range.a(this.endpoint, c4) < 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.Cut
        @CheckForNull
        C n(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.next(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        BoundType o() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        BoundType p() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> q(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i4 = AnonymousClass1.f26781a[boundType.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return this;
                }
                throw new AssertionError();
            }
            C next = discreteDomain.next(this.endpoint);
            if (next == null) {
                return Cut.c();
            }
            return Cut.e(next);
        }

        @Override // com.google.common.collect.Cut
        Cut<C> r(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i4 = AnonymousClass1.f26781a[boundType.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    C next = discreteDomain.next(this.endpoint);
                    if (next == null) {
                        return Cut.a();
                    }
                    return Cut.e(next);
                }
                throw new AssertionError();
            }
            return this;
        }

        public String toString() {
            return RemoteSettings.FORWARD_SLASH_STRING + this.endpoint + "\\";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class BelowAll extends Cut<Comparable<?>> {

        /* renamed from: a  reason: collision with root package name */
        private static final BelowAll f26783a = new BelowAll();
        private static final long serialVersionUID = 0;

        private BelowAll() {
            super("");
        }

        private Object readResolve() {
            return f26783a;
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> f(DiscreteDomain<Comparable<?>> discreteDomain) {
            try {
                return Cut.e(discreteDomain.minValue());
            } catch (NoSuchElementException unused) {
                return this;
            }
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        /* renamed from: g */
        public int compareTo(Cut<Comparable<?>> cut) {
            if (cut == this) {
                return 0;
            }
            return -1;
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            sb.append("(-∞");
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return System.identityHashCode(this);
        }

        @Override // com.google.common.collect.Cut
        void i(StringBuilder sb) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> j() {
            throw new IllegalStateException("range unbounded on this side");
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> l(DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.Cut
        boolean m(Comparable<?> comparable) {
            return true;
        }

        @Override // com.google.common.collect.Cut
        Comparable<?> n(DiscreteDomain<Comparable<?>> discreteDomain) {
            return discreteDomain.minValue();
        }

        @Override // com.google.common.collect.Cut
        BoundType o() {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        BoundType p() {
            throw new AssertionError("this statement should be unreachable");
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> q(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new IllegalStateException();
        }

        @Override // com.google.common.collect.Cut
        Cut<Comparable<?>> r(BoundType boundType, DiscreteDomain<Comparable<?>> discreteDomain) {
            throw new AssertionError("this statement should be unreachable");
        }

        public String toString() {
            return "-∞";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public static final class BelowValue<C extends Comparable> extends Cut<C> {
        private static final long serialVersionUID = 0;

        BelowValue(C c4) {
            super((Comparable) Preconditions.checkNotNull(c4));
        }

        @Override // com.google.common.collect.Cut, java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return super.compareTo((Cut) obj);
        }

        @Override // com.google.common.collect.Cut
        void h(StringBuilder sb) {
            sb.append(TypePool.Default.LazyTypeDescription.GenericTypeToken.COMPONENT_TYPE_PATH);
            sb.append(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        public int hashCode() {
            return this.endpoint.hashCode();
        }

        @Override // com.google.common.collect.Cut
        void i(StringBuilder sb) {
            sb.append(this.endpoint);
            sb.append(')');
        }

        @Override // com.google.common.collect.Cut
        @CheckForNull
        C l(DiscreteDomain<C> discreteDomain) {
            return discreteDomain.previous(this.endpoint);
        }

        @Override // com.google.common.collect.Cut
        boolean m(C c4) {
            if (Range.a(this.endpoint, c4) <= 0) {
                return true;
            }
            return false;
        }

        @Override // com.google.common.collect.Cut
        C n(DiscreteDomain<C> discreteDomain) {
            return this.endpoint;
        }

        @Override // com.google.common.collect.Cut
        BoundType o() {
            return BoundType.CLOSED;
        }

        @Override // com.google.common.collect.Cut
        BoundType p() {
            return BoundType.OPEN;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> q(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i4 = AnonymousClass1.f26781a[boundType.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    C previous = discreteDomain.previous(this.endpoint);
                    if (previous == null) {
                        return Cut.c();
                    }
                    return new AboveValue(previous);
                }
                throw new AssertionError();
            }
            return this;
        }

        @Override // com.google.common.collect.Cut
        Cut<C> r(BoundType boundType, DiscreteDomain<C> discreteDomain) {
            int i4 = AnonymousClass1.f26781a[boundType.ordinal()];
            if (i4 != 1) {
                if (i4 == 2) {
                    return this;
                }
                throw new AssertionError();
            }
            C previous = discreteDomain.previous(this.endpoint);
            if (previous == null) {
                return Cut.a();
            }
            return new AboveValue(previous);
        }

        public String toString() {
            return "\\" + this.endpoint + RemoteSettings.FORWARD_SLASH_STRING;
        }
    }

    Cut(C c4) {
        this.endpoint = c4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> a() {
        return AboveAll.f26782a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> b(C c4) {
        return new AboveValue(c4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> c() {
        return BelowAll.f26783a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <C extends Comparable> Cut<C> e(C c4) {
        return new BelowValue(c4);
    }

    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Cut)) {
            return false;
        }
        try {
            if (compareTo((Cut) obj) != 0) {
                return false;
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    @Override // java.lang.Comparable
    /* renamed from: g */
    public int compareTo(Cut<C> cut) {
        if (cut == c()) {
            return 1;
        }
        if (cut == a()) {
            return -1;
        }
        int a4 = Range.a(this.endpoint, cut.endpoint);
        if (a4 != 0) {
            return a4;
        }
        return Booleans.compare(this instanceof AboveValue, cut instanceof AboveValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void h(StringBuilder sb);

    public abstract int hashCode();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void i(StringBuilder sb);

    /* JADX INFO: Access modifiers changed from: package-private */
    public C j() {
        return this.endpoint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public abstract C l(DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean m(C c4);

    /* JADX INFO: Access modifiers changed from: package-private */
    @CheckForNull
    public abstract C n(DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType o();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract BoundType p();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Cut<C> q(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract Cut<C> r(BoundType boundType, DiscreteDomain<C> discreteDomain);

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cut<C> f(DiscreteDomain<C> discreteDomain) {
        return this;
    }
}
