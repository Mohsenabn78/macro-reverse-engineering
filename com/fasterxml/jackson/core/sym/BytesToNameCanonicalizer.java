package com.fasterxml.jackson.core.sym;

import androidx.compose.animation.core.d;
import androidx.core.view.InputDeviceCompat;
import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class BytesToNameCanonicalizer {

    /* renamed from: a  reason: collision with root package name */
    protected final BytesToNameCanonicalizer f17824a;

    /* renamed from: b  reason: collision with root package name */
    protected final AtomicReference<b> f17825b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17826c;

    /* renamed from: d  reason: collision with root package name */
    protected final boolean f17827d;

    /* renamed from: e  reason: collision with root package name */
    protected int f17828e;

    /* renamed from: f  reason: collision with root package name */
    protected int f17829f;

    /* renamed from: g  reason: collision with root package name */
    protected int f17830g;

    /* renamed from: h  reason: collision with root package name */
    protected int[] f17831h;

    /* renamed from: i  reason: collision with root package name */
    protected Name[] f17832i;

    /* renamed from: j  reason: collision with root package name */
    protected a[] f17833j;

    /* renamed from: k  reason: collision with root package name */
    protected int f17834k;

    /* renamed from: l  reason: collision with root package name */
    protected int f17835l;

    /* renamed from: m  reason: collision with root package name */
    private transient boolean f17836m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f17837n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f17838o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f17839p;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        protected final Name f17840a;

        /* renamed from: b  reason: collision with root package name */
        protected final a f17841b;

        /* renamed from: c  reason: collision with root package name */
        private final int f17842c;

        a(Name name, a aVar) {
            this.f17840a = name;
            this.f17841b = aVar;
            this.f17842c = aVar != null ? 1 + aVar.f17842c : 1;
        }

        public Name a(int i4, int i5, int i6) {
            if (this.f17840a.hashCode() == i4 && this.f17840a.equals(i5, i6)) {
                return this.f17840a;
            }
            for (a aVar = this.f17841b; aVar != null; aVar = aVar.f17841b) {
                Name name = aVar.f17840a;
                if (name.hashCode() == i4 && name.equals(i5, i6)) {
                    return name;
                }
            }
            return null;
        }

        public Name b(int i4, int[] iArr, int i5) {
            if (this.f17840a.hashCode() == i4 && this.f17840a.equals(iArr, i5)) {
                return this.f17840a;
            }
            for (a aVar = this.f17841b; aVar != null; aVar = aVar.f17841b) {
                Name name = aVar.f17840a;
                if (name.hashCode() == i4 && name.equals(iArr, i5)) {
                    return name;
                }
            }
            return null;
        }

        public int c() {
            return this.f17842c;
        }
    }

    private BytesToNameCanonicalizer(int i4, boolean z3, int i5) {
        this.f17824a = null;
        this.f17826c = i5;
        this.f17827d = z3;
        int i6 = 16;
        if (i4 < 16) {
            i4 = 16;
        } else if (((i4 - 1) & i4) != 0) {
            while (i6 < i4) {
                i6 += i6;
            }
            i4 = i6;
        }
        this.f17825b = new AtomicReference<>(g(i4));
    }

    private void a(int i4, Name name) {
        int i5;
        if (this.f17837n) {
            m();
        }
        if (this.f17836m) {
            j();
        }
        this.f17828e++;
        int i6 = this.f17830g & i4;
        if (this.f17832i[i6] == null) {
            this.f17831h[i6] = i4 << 8;
            if (this.f17838o) {
                n();
            }
            this.f17832i[i6] = name;
        } else {
            if (this.f17839p) {
                l();
            }
            this.f17834k++;
            int i7 = this.f17831h[i6];
            int i8 = i7 & 255;
            if (i8 == 0) {
                i5 = this.f17835l;
                if (i5 <= 254) {
                    this.f17835l = i5 + 1;
                    if (i5 >= this.f17833j.length) {
                        e();
                    }
                } else {
                    i5 = f();
                }
                this.f17831h[i6] = (i7 & InputDeviceCompat.SOURCE_ANY) | (i5 + 1);
            } else {
                i5 = i8 - 1;
            }
            a aVar = new a(name, this.f17833j[i5]);
            this.f17833j[i5] = aVar;
            int max = Math.max(aVar.c(), this.f17829f);
            this.f17829f = max;
            if (max > 255) {
                k(255);
            }
        }
        int length = this.f17831h.length;
        int i9 = this.f17828e;
        if (i9 > (length >> 1)) {
            int i10 = length >> 2;
            if (i9 > length - i10) {
                this.f17836m = true;
            } else if (this.f17834k >= i10) {
                this.f17836m = true;
            }
        }
    }

    private static Name b(int i4, String str, int i5, int i6) {
        if (i6 == 0) {
            return new Name1(str, i4, i5);
        }
        return new Name2(str, i4, i5, i6);
    }

    private static Name c(int i4, String str, int[] iArr, int i5) {
        if (i5 < 4) {
            if (i5 != 1) {
                if (i5 != 2) {
                    if (i5 == 3) {
                        return new Name3(str, i4, iArr[0], iArr[1], iArr[2]);
                    }
                } else {
                    return new Name2(str, i4, iArr[0], iArr[1]);
                }
            } else {
                return new Name1(str, i4, iArr[0]);
            }
        }
        int[] iArr2 = new int[i5];
        for (int i6 = 0; i6 < i5; i6++) {
            iArr2[i6] = iArr[i6];
        }
        return new NameN(str, i4, iArr2, i5);
    }

    public static BytesToNameCanonicalizer createRoot() {
        long currentTimeMillis = System.currentTimeMillis();
        return d((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    protected static BytesToNameCanonicalizer d(int i4) {
        return new BytesToNameCanonicalizer(64, true, i4);
    }

    private void e() {
        a[] aVarArr = this.f17833j;
        int length = aVarArr.length;
        a[] aVarArr2 = new a[length + length];
        this.f17833j = aVarArr2;
        System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
    }

    private int f() {
        a[] aVarArr = this.f17833j;
        int i4 = this.f17835l;
        int i5 = Integer.MAX_VALUE;
        int i6 = -1;
        for (int i7 = 0; i7 < i4; i7++) {
            int c4 = aVarArr[i7].c();
            if (c4 < i5) {
                if (c4 == 1) {
                    return i7;
                }
                i6 = i7;
                i5 = c4;
            }
        }
        return i6;
    }

    private b g(int i4) {
        return new b(0, i4 - 1, new int[i4], new Name[i4], null, 0, 0, 0);
    }

    public static Name getEmptyName() {
        return Name1.a();
    }

    private void h(b bVar) {
        int i4 = bVar.f17843a;
        b bVar2 = this.f17825b.get();
        if (i4 <= bVar2.f17843a) {
            return;
        }
        if (i4 > 6000 || bVar.f17850h > 63) {
            bVar = g(64);
        }
        d.a(this.f17825b, bVar2, bVar);
    }

    private void i() {
        this.f17828e = 0;
        this.f17829f = 0;
        Arrays.fill(this.f17831h, 0);
        Arrays.fill(this.f17832i, (Object) null);
        Arrays.fill(this.f17833j, (Object) null);
        this.f17834k = 0;
        this.f17835l = 0;
    }

    private void j() {
        int i4;
        this.f17836m = false;
        this.f17838o = false;
        int length = this.f17831h.length;
        int i5 = length + length;
        if (i5 > 65536) {
            i();
            return;
        }
        this.f17831h = new int[i5];
        this.f17830g = i5 - 1;
        Name[] nameArr = this.f17832i;
        this.f17832i = new Name[i5];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            Name name = nameArr[i7];
            if (name != null) {
                i6++;
                int hashCode = name.hashCode();
                int i8 = this.f17830g & hashCode;
                this.f17832i[i8] = name;
                this.f17831h[i8] = hashCode << 8;
            }
        }
        int i9 = this.f17835l;
        if (i9 == 0) {
            this.f17829f = 0;
            return;
        }
        this.f17834k = 0;
        this.f17835l = 0;
        this.f17839p = false;
        a[] aVarArr = this.f17833j;
        this.f17833j = new a[aVarArr.length];
        int i10 = 0;
        for (int i11 = 0; i11 < i9; i11++) {
            for (a aVar = aVarArr[i11]; aVar != null; aVar = aVar.f17841b) {
                i6++;
                Name name2 = aVar.f17840a;
                int hashCode2 = name2.hashCode();
                int i12 = this.f17830g & hashCode2;
                int[] iArr = this.f17831h;
                int i13 = iArr[i12];
                Name[] nameArr2 = this.f17832i;
                if (nameArr2[i12] == null) {
                    iArr[i12] = hashCode2 << 8;
                    nameArr2[i12] = name2;
                } else {
                    this.f17834k++;
                    int i14 = i13 & 255;
                    if (i14 == 0) {
                        i4 = this.f17835l;
                        if (i4 <= 254) {
                            this.f17835l = i4 + 1;
                            if (i4 >= this.f17833j.length) {
                                e();
                            }
                        } else {
                            i4 = f();
                        }
                        this.f17831h[i12] = (i13 & InputDeviceCompat.SOURCE_ANY) | (i4 + 1);
                    } else {
                        i4 = i14 - 1;
                    }
                    a aVar2 = new a(name2, this.f17833j[i4]);
                    this.f17833j[i4] = aVar2;
                    i10 = Math.max(i10, aVar2.c());
                }
            }
        }
        this.f17829f = i10;
        if (i6 == this.f17828e) {
            return;
        }
        throw new RuntimeException("Internal error: count after rehash " + i6 + "; should be " + this.f17828e);
    }

    private void l() {
        a[] aVarArr = this.f17833j;
        if (aVarArr == null) {
            this.f17833j = new a[32];
        } else {
            int length = aVarArr.length;
            a[] aVarArr2 = new a[length];
            this.f17833j = aVarArr2;
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
        }
        this.f17839p = false;
    }

    private void m() {
        int[] iArr = this.f17831h;
        int length = iArr.length;
        int[] iArr2 = new int[length];
        this.f17831h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, length);
        this.f17837n = false;
    }

    private void n() {
        Name[] nameArr = this.f17832i;
        int length = nameArr.length;
        Name[] nameArr2 = new Name[length];
        this.f17832i = nameArr2;
        System.arraycopy(nameArr, 0, nameArr2, 0, length);
        this.f17838o = false;
    }

    public Name addName(String str, int i4, int i5) {
        if (this.f17827d) {
            str = InternCache.instance.intern(str);
        }
        int calcHash = i5 == 0 ? calcHash(i4) : calcHash(i4, i5);
        Name b4 = b(calcHash, str, i4, i5);
        a(calcHash, b4);
        return b4;
    }

    public int bucketCount() {
        return this.f17831h.length;
    }

    public int calcHash(int i4) {
        int i5 = i4 ^ this.f17826c;
        int i6 = i5 + (i5 >>> 15);
        return i6 ^ (i6 >>> 9);
    }

    public int collisionCount() {
        return this.f17834k;
    }

    public Name findName(int i4) {
        int calcHash = calcHash(i4);
        int i5 = this.f17830g & calcHash;
        int i6 = this.f17831h[i5];
        if ((((i6 >> 8) ^ calcHash) << 8) == 0) {
            Name name = this.f17832i[i5];
            if (name == null) {
                return null;
            }
            if (name.equals(i4)) {
                return name;
            }
        } else if (i6 == 0) {
            return null;
        }
        int i7 = i6 & 255;
        if (i7 > 0) {
            a aVar = this.f17833j[i7 - 1];
            if (aVar != null) {
                return aVar.a(calcHash, i4, 0);
            }
        }
        return null;
    }

    public int hashSeed() {
        return this.f17826c;
    }

    protected void k(int i4) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f17828e + ") now exceeds maximum, " + i4 + " -- suspect a DoS attack based on hash collisions");
    }

    public BytesToNameCanonicalizer makeChild(boolean z3, boolean z4) {
        return new BytesToNameCanonicalizer(this, z4, this.f17826c, this.f17825b.get());
    }

    public int maxCollisionLength() {
        return this.f17829f;
    }

    public boolean maybeDirty() {
        return !this.f17837n;
    }

    public void release() {
        if (this.f17824a != null && maybeDirty()) {
            this.f17824a.h(new b(this));
            this.f17837n = true;
            this.f17838o = true;
            this.f17839p = true;
        }
    }

    public int size() {
        AtomicReference<b> atomicReference = this.f17825b;
        if (atomicReference != null) {
            return atomicReference.get().f17843a;
        }
        return this.f17828e;
    }

    public int calcHash(int i4, int i5) {
        int i6 = ((i4 ^ (i4 >>> 15)) + (i5 * 33)) ^ this.f17826c;
        return i6 + (i6 >>> 7);
    }

    public int calcHash(int[] iArr, int i4) {
        if (i4 >= 3) {
            int i5 = iArr[0] ^ this.f17826c;
            int i6 = (((i5 + (i5 >>> 9)) * 33) + iArr[1]) * 65599;
            int i7 = (i6 + (i6 >>> 15)) ^ iArr[2];
            int i8 = i7 + (i7 >>> 17);
            for (int i9 = 3; i9 < i4; i9++) {
                int i10 = (i8 * 31) ^ iArr[i9];
                int i11 = i10 + (i10 >>> 3);
                i8 = i11 ^ (i11 << 7);
            }
            int i12 = i8 + (i8 >>> 15);
            return (i12 << 9) ^ i12;
        }
        throw new IllegalArgumentException();
    }

    private BytesToNameCanonicalizer(BytesToNameCanonicalizer bytesToNameCanonicalizer, boolean z3, int i4, b bVar) {
        this.f17824a = bytesToNameCanonicalizer;
        this.f17826c = i4;
        this.f17827d = z3;
        this.f17825b = null;
        this.f17828e = bVar.f17843a;
        this.f17830g = bVar.f17844b;
        this.f17831h = bVar.f17845c;
        this.f17832i = bVar.f17846d;
        this.f17833j = bVar.f17847e;
        this.f17834k = bVar.f17848f;
        this.f17835l = bVar.f17849g;
        this.f17829f = bVar.f17850h;
        this.f17836m = false;
        this.f17837n = true;
        this.f17838o = true;
        this.f17839p = true;
    }

    public Name addName(String str, int[] iArr, int i4) {
        int calcHash;
        if (this.f17827d) {
            str = InternCache.instance.intern(str);
        }
        if (i4 < 3) {
            calcHash = i4 == 1 ? calcHash(iArr[0]) : calcHash(iArr[0], iArr[1]);
        } else {
            calcHash = calcHash(iArr, i4);
        }
        Name c4 = c(calcHash, str, iArr, i4);
        a(calcHash, c4);
        return c4;
    }

    public Name findName(int i4, int i5) {
        int calcHash = i5 == 0 ? calcHash(i4) : calcHash(i4, i5);
        int i6 = this.f17830g & calcHash;
        int i7 = this.f17831h[i6];
        if ((((i7 >> 8) ^ calcHash) << 8) == 0) {
            Name name = this.f17832i[i6];
            if (name == null) {
                return null;
            }
            if (name.equals(i4, i5)) {
                return name;
            }
        } else if (i7 == 0) {
            return null;
        }
        int i8 = i7 & 255;
        if (i8 > 0) {
            a aVar = this.f17833j[i8 - 1];
            if (aVar != null) {
                return aVar.a(calcHash, i4, i5);
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final int f17843a;

        /* renamed from: b  reason: collision with root package name */
        public final int f17844b;

        /* renamed from: c  reason: collision with root package name */
        public final int[] f17845c;

        /* renamed from: d  reason: collision with root package name */
        public final Name[] f17846d;

        /* renamed from: e  reason: collision with root package name */
        public final a[] f17847e;

        /* renamed from: f  reason: collision with root package name */
        public final int f17848f;

        /* renamed from: g  reason: collision with root package name */
        public final int f17849g;

        /* renamed from: h  reason: collision with root package name */
        public final int f17850h;

        public b(int i4, int i5, int[] iArr, Name[] nameArr, a[] aVarArr, int i6, int i7, int i8) {
            this.f17843a = i4;
            this.f17844b = i5;
            this.f17845c = iArr;
            this.f17846d = nameArr;
            this.f17847e = aVarArr;
            this.f17848f = i6;
            this.f17849g = i7;
            this.f17850h = i8;
        }

        public b(BytesToNameCanonicalizer bytesToNameCanonicalizer) {
            this.f17843a = bytesToNameCanonicalizer.f17828e;
            this.f17844b = bytesToNameCanonicalizer.f17830g;
            this.f17845c = bytesToNameCanonicalizer.f17831h;
            this.f17846d = bytesToNameCanonicalizer.f17832i;
            this.f17847e = bytesToNameCanonicalizer.f17833j;
            this.f17848f = bytesToNameCanonicalizer.f17834k;
            this.f17849g = bytesToNameCanonicalizer.f17835l;
            this.f17850h = bytesToNameCanonicalizer.f17829f;
        }
    }

    public Name findName(int[] iArr, int i4) {
        if (i4 < 3) {
            return findName(iArr[0], i4 >= 2 ? iArr[1] : 0);
        }
        int calcHash = calcHash(iArr, i4);
        int i5 = this.f17830g & calcHash;
        int i6 = this.f17831h[i5];
        if ((((i6 >> 8) ^ calcHash) << 8) == 0) {
            Name name = this.f17832i[i5];
            if (name == null || name.equals(iArr, i4)) {
                return name;
            }
        } else if (i6 == 0) {
            return null;
        }
        int i7 = i6 & 255;
        if (i7 > 0) {
            a aVar = this.f17833j[i7 - 1];
            if (aVar != null) {
                return aVar.b(calcHash, iArr, i4);
            }
        }
        return null;
    }
}
