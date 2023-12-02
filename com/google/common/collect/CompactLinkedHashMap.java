package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.J2ktIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.CheckForNull;
import javax.mail.UIDFolder;

/* JADX INFO: Access modifiers changed from: package-private */
@J2ktIncompatible
@GwtIncompatible
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
public class CompactLinkedHashMap<K, V> extends CompactHashMap<K, V> {
    private final boolean accessOrder;
    @VisibleForTesting
    @CheckForNull

    /* renamed from: k  reason: collision with root package name */
    transient long[] f26760k;

    /* renamed from: l  reason: collision with root package name */
    private transient int f26761l;

    /* renamed from: m  reason: collision with root package name */
    private transient int f26762m;

    CompactLinkedHashMap() {
        this(3);
    }

    public static <K, V> CompactLinkedHashMap<K, V> c0() {
        return new CompactLinkedHashMap<>();
    }

    public static <K, V> CompactLinkedHashMap<K, V> d0(int i4) {
        return new CompactLinkedHashMap<>(i4);
    }

    private int e0(int i4) {
        return ((int) (f0(i4) >>> 32)) - 1;
    }

    private long f0(int i4) {
        return g0()[i4];
    }

    private long[] g0() {
        long[] jArr = this.f26760k;
        Objects.requireNonNull(jArr);
        return jArr;
    }

    private void h0(int i4, long j4) {
        g0()[i4] = j4;
    }

    private void i0(int i4, int i5) {
        h0(i4, (f0(i4) & UIDFolder.MAXUID) | ((i5 + 1) << 32));
    }

    private void j0(int i4, int i5) {
        if (i4 == -2) {
            this.f26761l = i5;
        } else {
            k0(i4, i5);
        }
        if (i5 == -2) {
            this.f26762m = i4;
        } else {
            i0(i5, i4);
        }
    }

    private void k0(int i4, int i5) {
        h0(i4, (f0(i4) & (-4294967296L)) | ((i5 + 1) & UIDFolder.MAXUID));
    }

    @Override // com.google.common.collect.CompactHashMap
    int D() {
        return this.f26761l;
    }

    @Override // com.google.common.collect.CompactHashMap
    int E(int i4) {
        return ((int) f0(i4)) - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void I(int i4) {
        super.I(i4);
        this.f26761l = -2;
        this.f26762m = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void J(int i4, @ParametricNullness K k4, @ParametricNullness V v3, int i5, int i6) {
        super.J(i4, k4, v3, i5, i6);
        j0(this.f26762m, i4);
        j0(i4, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void M(int i4, int i5) {
        int size = size() - 1;
        super.M(i4, i5);
        j0(e0(i4), E(i4));
        if (i4 < size) {
            j0(e0(size), i4);
            j0(i4, E(size));
        }
        h0(size, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public void T(int i4) {
        super.T(i4);
        this.f26760k = Arrays.copyOf(g0(), i4);
    }

    @Override // com.google.common.collect.CompactHashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        if (N()) {
            return;
        }
        this.f26761l = -2;
        this.f26762m = -2;
        long[] jArr = this.f26760k;
        if (jArr != null) {
            Arrays.fill(jArr, 0, size(), 0L);
        }
        super.clear();
    }

    @Override // com.google.common.collect.CompactHashMap
    void q(int i4) {
        if (this.accessOrder) {
            j0(e0(i4), E(i4));
            j0(this.f26762m, i4);
            j0(i4, -2);
            G();
        }
    }

    @Override // com.google.common.collect.CompactHashMap
    int r(int i4, int i5) {
        if (i4 >= size()) {
            return i5;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    public int s() {
        int s3 = super.s();
        this.f26760k = new long[s3];
        return s3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.CompactHashMap
    @CanIgnoreReturnValue
    public Map<K, V> t() {
        Map<K, V> t3 = super.t();
        this.f26760k = null;
        return t3;
    }

    @Override // com.google.common.collect.CompactHashMap
    Map<K, V> w(int i4) {
        return new LinkedHashMap(i4, 1.0f, this.accessOrder);
    }

    CompactLinkedHashMap(int i4) {
        this(i4, false);
    }

    CompactLinkedHashMap(int i4, boolean z3) {
        super(i4);
        this.accessOrder = z3;
    }
}
