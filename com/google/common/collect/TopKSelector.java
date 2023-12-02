package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public final class TopKSelector<T> {

    /* renamed from: a  reason: collision with root package name */
    private final int f27496a;

    /* renamed from: b  reason: collision with root package name */
    private final Comparator<? super T> f27497b;

    /* renamed from: c  reason: collision with root package name */
    private final T[] f27498c;

    /* renamed from: d  reason: collision with root package name */
    private int f27499d;
    @CheckForNull

    /* renamed from: e  reason: collision with root package name */
    private T f27500e;

    private TopKSelector(Comparator<? super T> comparator, int i4) {
        boolean z3;
        this.f27497b = (Comparator) Preconditions.checkNotNull(comparator, "comparator");
        this.f27496a = i4;
        if (i4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "k (%s) must be >= 0", i4);
        Preconditions.checkArgument(i4 <= 1073741823, "k (%s) must be <= Integer.MAX_VALUE / 2", i4);
        this.f27498c = (T[]) new Object[IntMath.checkedMultiply(i4, 2)];
        this.f27499d = 0;
        this.f27500e = null;
    }

    public static <T> TopKSelector<T> a(int i4, Comparator<? super T> comparator) {
        return new TopKSelector<>(comparator, i4);
    }

    private int d(int i4, int i5, int i6) {
        Object a4 = NullnessCasts.a(this.f27498c[i6]);
        T[] tArr = this.f27498c;
        tArr[i6] = tArr[i5];
        int i7 = i4;
        while (i4 < i5) {
            if (this.f27497b.compare((Object) NullnessCasts.a(this.f27498c[i4]), a4) < 0) {
                e(i7, i4);
                i7++;
            }
            i4++;
        }
        T[] tArr2 = this.f27498c;
        tArr2[i5] = tArr2[i7];
        tArr2[i7] = a4;
        return i7;
    }

    private void e(int i4, int i5) {
        T[] tArr = this.f27498c;
        T t3 = tArr[i4];
        tArr[i4] = tArr[i5];
        tArr[i5] = t3;
    }

    private void g() {
        int i4 = (this.f27496a * 2) - 1;
        int log2 = IntMath.log2(i4 + 0, RoundingMode.CEILING) * 3;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i5 < i4) {
                int d4 = d(i5, i4, ((i5 + i4) + 1) >>> 1);
                int i8 = this.f27496a;
                if (d4 > i8) {
                    i4 = d4 - 1;
                } else if (d4 >= i8) {
                    break;
                } else {
                    i5 = Math.max(d4, i5 + 1);
                    i7 = d4;
                }
                i6++;
                if (i6 >= log2) {
                    Arrays.sort(this.f27498c, i5, i4 + 1, this.f27497b);
                    break;
                }
            } else {
                break;
            }
        }
        this.f27499d = this.f27496a;
        this.f27500e = (T) NullnessCasts.a(this.f27498c[i7]);
        while (true) {
            i7++;
            if (i7 < this.f27496a) {
                if (this.f27497b.compare((Object) NullnessCasts.a(this.f27498c[i7]), (Object) NullnessCasts.a(this.f27500e)) > 0) {
                    this.f27500e = this.f27498c[i7];
                }
            } else {
                return;
            }
        }
    }

    public void b(@ParametricNullness T t3) {
        int i4 = this.f27496a;
        if (i4 == 0) {
            return;
        }
        int i5 = this.f27499d;
        if (i5 == 0) {
            this.f27498c[0] = t3;
            this.f27500e = t3;
            this.f27499d = 1;
        } else if (i5 < i4) {
            T[] tArr = this.f27498c;
            this.f27499d = i5 + 1;
            tArr[i5] = t3;
            if (this.f27497b.compare(t3, (Object) NullnessCasts.a(this.f27500e)) > 0) {
                this.f27500e = t3;
            }
        } else if (this.f27497b.compare(t3, (Object) NullnessCasts.a(this.f27500e)) < 0) {
            T[] tArr2 = this.f27498c;
            int i6 = this.f27499d;
            int i7 = i6 + 1;
            this.f27499d = i7;
            tArr2[i6] = t3;
            if (i7 == this.f27496a * 2) {
                g();
            }
        }
    }

    public void c(Iterator<? extends T> it) {
        while (it.hasNext()) {
            b(it.next());
        }
    }

    public List<T> f() {
        T[] tArr = this.f27498c;
        Arrays.sort(tArr, 0, this.f27499d, this.f27497b);
        int i4 = this.f27499d;
        int i5 = this.f27496a;
        if (i4 > i5) {
            T[] tArr2 = this.f27498c;
            Arrays.fill(tArr2, i5, tArr2.length, (Object) null);
            int i6 = this.f27496a;
            this.f27499d = i6;
            this.f27500e = this.f27498c[i6 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(tArr, this.f27499d)));
    }
}
