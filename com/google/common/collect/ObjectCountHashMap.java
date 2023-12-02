package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import javax.annotation.CheckForNull;
import javax.mail.UIDFolder;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class ObjectCountHashMap<K> {

    /* renamed from: a  reason: collision with root package name */
    transient Object[] f27308a;

    /* renamed from: b  reason: collision with root package name */
    transient int[] f27309b;

    /* renamed from: c  reason: collision with root package name */
    transient int f27310c;

    /* renamed from: d  reason: collision with root package name */
    transient int f27311d;

    /* renamed from: e  reason: collision with root package name */
    private transient int[] f27312e;
    @VisibleForTesting

    /* renamed from: f  reason: collision with root package name */
    transient long[] f27313f;

    /* renamed from: g  reason: collision with root package name */
    private transient float f27314g;

    /* renamed from: h  reason: collision with root package name */
    private transient int f27315h;

    /* loaded from: classes5.dex */
    class MapEntry extends Multisets.AbstractEntry<K> {
        @ParametricNullness

        /* renamed from: a  reason: collision with root package name */
        final K f27316a;

        /* renamed from: b  reason: collision with root package name */
        int f27317b;

        MapEntry(int i4) {
            this.f27316a = (K) ObjectCountHashMap.this.f27308a[i4];
            this.f27317b = i4;
        }

        void a() {
            int i4 = this.f27317b;
            if (i4 == -1 || i4 >= ObjectCountHashMap.this.C() || !Objects.equal(this.f27316a, ObjectCountHashMap.this.f27308a[this.f27317b])) {
                this.f27317b = ObjectCountHashMap.this.m(this.f27316a);
            }
        }

        @Override // com.google.common.collect.Multiset.Entry
        public int getCount() {
            a();
            int i4 = this.f27317b;
            if (i4 == -1) {
                return 0;
            }
            return ObjectCountHashMap.this.f27309b[i4];
        }

        @Override // com.google.common.collect.Multiset.Entry
        @ParametricNullness
        public K getElement() {
            return this.f27316a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap() {
        n(3, 1.0f);
    }

    private void A(int i4) {
        if (this.f27312e.length >= 1073741824) {
            this.f27315h = Integer.MAX_VALUE;
            return;
        }
        int i5 = ((int) (i4 * this.f27314g)) + 1;
        int[] r4 = r(i4);
        long[] jArr = this.f27313f;
        int length = r4.length - 1;
        for (int i6 = 0; i6 < this.f27310c; i6++) {
            int h4 = h(jArr[i6]);
            int i7 = h4 & length;
            int i8 = r4[i7];
            r4[i7] = i6;
            jArr[i6] = (h4 << 32) | (i8 & UIDFolder.MAXUID);
        }
        this.f27315h = i5;
        this.f27312e = r4;
    }

    private static long D(long j4, int i4) {
        return (j4 & (-4294967296L)) | (UIDFolder.MAXUID & i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> ObjectCountHashMap<K> b() {
        return new ObjectCountHashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K> ObjectCountHashMap<K> c(int i4) {
        return new ObjectCountHashMap<>(i4);
    }

    private static int h(long j4) {
        return (int) (j4 >>> 32);
    }

    private static int j(long j4) {
        return (int) j4;
    }

    private int l() {
        return this.f27312e.length - 1;
    }

    private static long[] q(int i4) {
        long[] jArr = new long[i4];
        Arrays.fill(jArr, -1L);
        return jArr;
    }

    private static int[] r(int i4) {
        int[] iArr = new int[i4];
        Arrays.fill(iArr, -1);
        return iArr;
    }

    private int w(@CheckForNull Object obj, int i4) {
        int l4 = l() & i4;
        int i5 = this.f27312e[l4];
        if (i5 == -1) {
            return 0;
        }
        int i6 = -1;
        while (true) {
            if (h(this.f27313f[i5]) == i4 && Objects.equal(obj, this.f27308a[i5])) {
                int i7 = this.f27309b[i5];
                if (i6 == -1) {
                    this.f27312e[l4] = j(this.f27313f[i5]);
                } else {
                    long[] jArr = this.f27313f;
                    jArr[i6] = D(jArr[i6], j(jArr[i5]));
                }
                p(i5);
                this.f27310c--;
                this.f27311d++;
                return i7;
            }
            int j4 = j(this.f27313f[i5]);
            if (j4 == -1) {
                return 0;
            }
            i6 = i5;
            i5 = j4;
        }
    }

    private void z(int i4) {
        int length = this.f27313f.length;
        if (i4 > length) {
            int max = Math.max(1, length >>> 1) + length;
            if (max < 0) {
                max = Integer.MAX_VALUE;
            }
            if (max != length) {
                y(max);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B(int i4, int i5) {
        Preconditions.checkElementIndex(i4, this.f27310c);
        this.f27309b[i4] = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int C() {
        return this.f27310c;
    }

    public void a() {
        this.f27311d++;
        Arrays.fill(this.f27308a, 0, this.f27310c, (Object) null);
        Arrays.fill(this.f27309b, 0, this.f27310c, 0);
        Arrays.fill(this.f27312e, -1);
        Arrays.fill(this.f27313f, -1L);
        this.f27310c = 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(int i4) {
        if (i4 > this.f27313f.length) {
            y(i4);
        }
        if (i4 >= this.f27315h) {
            A(Math.max(2, Integer.highestOneBit(i4 - 1) << 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        if (this.f27310c == 0) {
            return -1;
        }
        return 0;
    }

    public int f(@CheckForNull Object obj) {
        int m4 = m(obj);
        if (m4 == -1) {
            return 0;
        }
        return this.f27309b[m4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Multiset.Entry<K> g(int i4) {
        Preconditions.checkElementIndex(i4, this.f27310c);
        return new MapEntry(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @ParametricNullness
    public K i(int i4) {
        Preconditions.checkElementIndex(i4, this.f27310c);
        return (K) this.f27308a[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k(int i4) {
        Preconditions.checkElementIndex(i4, this.f27310c);
        return this.f27309b[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int m(@CheckForNull Object obj) {
        int d4 = Hashing.d(obj);
        int i4 = this.f27312e[l() & d4];
        while (i4 != -1) {
            long j4 = this.f27313f[i4];
            if (h(j4) == d4 && Objects.equal(obj, this.f27308a[i4])) {
                return i4;
            }
            i4 = j(j4);
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void n(int i4, float f4) {
        boolean z3;
        boolean z4 = false;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Initial capacity must be non-negative");
        if (f4 > 0.0f) {
            z4 = true;
        }
        Preconditions.checkArgument(z4, "Illegal load factor");
        int a4 = Hashing.a(i4, f4);
        this.f27312e = r(a4);
        this.f27314g = f4;
        this.f27308a = new Object[i4];
        this.f27309b = new int[i4];
        this.f27313f = q(i4);
        this.f27315h = Math.max(1, (int) (a4 * f4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void o(int i4, @ParametricNullness K k4, int i5, int i6) {
        this.f27313f[i4] = (i6 << 32) | UIDFolder.MAXUID;
        this.f27308a[i4] = k4;
        this.f27309b[i4] = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(int i4) {
        int C = C() - 1;
        if (i4 < C) {
            Object[] objArr = this.f27308a;
            objArr[i4] = objArr[C];
            int[] iArr = this.f27309b;
            iArr[i4] = iArr[C];
            objArr[C] = null;
            iArr[C] = 0;
            long[] jArr = this.f27313f;
            long j4 = jArr[C];
            jArr[i4] = j4;
            jArr[C] = -1;
            int h4 = h(j4) & l();
            int[] iArr2 = this.f27312e;
            int i5 = iArr2[h4];
            if (i5 == C) {
                iArr2[h4] = i4;
                return;
            }
            while (true) {
                long j5 = this.f27313f[i5];
                int j6 = j(j5);
                if (j6 == C) {
                    this.f27313f[i5] = D(j5, i4);
                    return;
                }
                i5 = j6;
            }
        } else {
            this.f27308a[i4] = null;
            this.f27309b[i4] = 0;
            this.f27313f[i4] = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int s(int i4) {
        int i5 = i4 + 1;
        if (i5 >= this.f27310c) {
            return -1;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(int i4, int i5) {
        return i4 - 1;
    }

    @CanIgnoreReturnValue
    public int u(@ParametricNullness K k4, int i4) {
        CollectPreconditions.d(i4, "count");
        long[] jArr = this.f27313f;
        Object[] objArr = this.f27308a;
        int[] iArr = this.f27309b;
        int d4 = Hashing.d(k4);
        int l4 = l() & d4;
        int i5 = this.f27310c;
        int[] iArr2 = this.f27312e;
        int i6 = iArr2[l4];
        if (i6 == -1) {
            iArr2[l4] = i5;
        } else {
            while (true) {
                long j4 = jArr[i6];
                if (h(j4) == d4 && Objects.equal(k4, objArr[i6])) {
                    int i7 = iArr[i6];
                    iArr[i6] = i4;
                    return i7;
                }
                int j5 = j(j4);
                if (j5 == -1) {
                    jArr[i6] = D(j4, i5);
                    break;
                }
                i6 = j5;
            }
        }
        if (i5 != Integer.MAX_VALUE) {
            int i8 = i5 + 1;
            z(i8);
            o(i5, k4, i4, d4);
            this.f27310c = i8;
            if (i5 >= this.f27315h) {
                A(this.f27312e.length * 2);
            }
            this.f27311d++;
            return 0;
        }
        throw new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
    }

    @CanIgnoreReturnValue
    public int v(@CheckForNull Object obj) {
        return w(obj, Hashing.d(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public int x(int i4) {
        return w(this.f27308a[i4], h(this.f27313f[i4]));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y(int i4) {
        this.f27308a = Arrays.copyOf(this.f27308a, i4);
        this.f27309b = Arrays.copyOf(this.f27309b, i4);
        long[] jArr = this.f27313f;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i4);
        if (i4 > length) {
            Arrays.fill(copyOf, length, i4, -1L);
        }
        this.f27313f = copyOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(ObjectCountHashMap<? extends K> objectCountHashMap) {
        n(objectCountHashMap.C(), 1.0f);
        int e4 = objectCountHashMap.e();
        while (e4 != -1) {
            u(objectCountHashMap.i(e4), objectCountHashMap.k(e4));
            e4 = objectCountHashMap.s(e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(int i4) {
        this(i4, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountHashMap(int i4, float f4) {
        n(i4, f4);
    }
}
