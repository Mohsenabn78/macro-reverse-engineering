package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import javax.mail.UIDFolder;

@GwtCompatible(emulated = true, serializable = true)
@ElementTypesAreNonnullByDefault
/* loaded from: classes5.dex */
class ObjectCountLinkedHashMap<K> extends ObjectCountHashMap<K> {
    @VisibleForTesting

    /* renamed from: i  reason: collision with root package name */
    transient long[] f27319i;

    /* renamed from: j  reason: collision with root package name */
    private transient int f27320j;

    /* renamed from: k  reason: collision with root package name */
    private transient int f27321k;

    ObjectCountLinkedHashMap() {
        this(3);
    }

    private int E(int i4) {
        return (int) (this.f27319i[i4] >>> 32);
    }

    private int F(int i4) {
        return (int) this.f27319i[i4];
    }

    private void G(int i4, int i5) {
        long[] jArr = this.f27319i;
        jArr[i4] = (jArr[i4] & UIDFolder.MAXUID) | (i5 << 32);
    }

    private void H(int i4, int i5) {
        if (i4 == -2) {
            this.f27320j = i5;
        } else {
            I(i4, i5);
        }
        if (i5 == -2) {
            this.f27321k = i4;
        } else {
            G(i5, i4);
        }
    }

    private void I(int i4, int i5) {
        long[] jArr = this.f27319i;
        jArr[i4] = (jArr[i4] & (-4294967296L)) | (i5 & UIDFolder.MAXUID);
    }

    @Override // com.google.common.collect.ObjectCountHashMap
    public void a() {
        super.a();
        this.f27320j = -2;
        this.f27321k = -2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public int e() {
        int i4 = this.f27320j;
        if (i4 == -2) {
            return -1;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void n(int i4, float f4) {
        super.n(i4, f4);
        this.f27320j = -2;
        this.f27321k = -2;
        long[] jArr = new long[i4];
        this.f27319i = jArr;
        Arrays.fill(jArr, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void o(int i4, @ParametricNullness K k4, int i5, int i6) {
        super.o(i4, k4, i5, i6);
        H(this.f27321k, i4);
        H(i4, -2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void p(int i4) {
        int C = C() - 1;
        H(E(i4), F(i4));
        if (i4 < C) {
            H(E(C), i4);
            H(i4, F(C));
        }
        super.p(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public int s(int i4) {
        int F = F(i4);
        if (F == -2) {
            return -1;
        }
        return F;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public int t(int i4, int i5) {
        if (i4 == C()) {
            return i5;
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ObjectCountHashMap
    public void y(int i4) {
        super.y(i4);
        long[] jArr = this.f27319i;
        int length = jArr.length;
        long[] copyOf = Arrays.copyOf(jArr, i4);
        this.f27319i = copyOf;
        Arrays.fill(copyOf, length, i4, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountLinkedHashMap(int i4) {
        this(i4, 1.0f);
    }

    ObjectCountLinkedHashMap(int i4, float f4) {
        super(i4, f4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ObjectCountLinkedHashMap(ObjectCountHashMap<K> objectCountHashMap) {
        n(objectCountHashMap.C(), 1.0f);
        int e4 = objectCountHashMap.e();
        while (e4 != -1) {
            u(objectCountHashMap.i(e4), objectCountHashMap.k(e4));
            e4 = objectCountHashMap.s(e4);
        }
    }
}
