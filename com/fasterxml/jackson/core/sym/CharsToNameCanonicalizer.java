package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.util.InternCache;
import java.util.Arrays;

/* loaded from: classes3.dex */
public final class CharsToNameCanonicalizer {
    public static final int HASH_MULT = 33;

    /* renamed from: l  reason: collision with root package name */
    static final CharsToNameCanonicalizer f17851l = new CharsToNameCanonicalizer();

    /* renamed from: a  reason: collision with root package name */
    protected CharsToNameCanonicalizer f17852a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17853b;

    /* renamed from: c  reason: collision with root package name */
    protected final boolean f17854c;

    /* renamed from: d  reason: collision with root package name */
    protected final boolean f17855d;

    /* renamed from: e  reason: collision with root package name */
    protected String[] f17856e;

    /* renamed from: f  reason: collision with root package name */
    protected a[] f17857f;

    /* renamed from: g  reason: collision with root package name */
    protected int f17858g;

    /* renamed from: h  reason: collision with root package name */
    protected int f17859h;

    /* renamed from: i  reason: collision with root package name */
    protected int f17860i;

    /* renamed from: j  reason: collision with root package name */
    protected int f17861j;

    /* renamed from: k  reason: collision with root package name */
    protected boolean f17862k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        private final String f17863a;

        /* renamed from: b  reason: collision with root package name */
        private final a f17864b;

        /* renamed from: c  reason: collision with root package name */
        private final int f17865c;

        public a(String str, a aVar) {
            this.f17863a = str;
            this.f17864b = aVar;
            this.f17865c = aVar != null ? 1 + aVar.f17865c : 1;
        }

        public String a(char[] cArr, int i4, int i5) {
            String str = this.f17863a;
            a aVar = this.f17864b;
            while (true) {
                if (str.length() == i5) {
                    int i6 = 0;
                    while (str.charAt(i6) == cArr[i4 + i6] && (i6 = i6 + 1) < i5) {
                    }
                    if (i6 == i5) {
                        return str;
                    }
                }
                if (aVar == null) {
                    return null;
                }
                str = aVar.c();
                aVar = aVar.b();
            }
        }

        public a b() {
            return this.f17864b;
        }

        public String c() {
            return this.f17863a;
        }

        public int d() {
            return this.f17865c;
        }
    }

    private CharsToNameCanonicalizer() {
        this.f17855d = true;
        this.f17854c = true;
        this.f17862k = true;
        this.f17853b = 0;
        this.f17861j = 0;
        d(64);
    }

    private static int a(int i4) {
        return i4 - (i4 >> 2);
    }

    private void b() {
        String[] strArr = this.f17856e;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        this.f17856e = strArr2;
        System.arraycopy(strArr, 0, strArr2, 0, length);
        a[] aVarArr = this.f17857f;
        int length2 = aVarArr.length;
        a[] aVarArr2 = new a[length2];
        this.f17857f = aVarArr2;
        System.arraycopy(aVarArr, 0, aVarArr2, 0, length2);
    }

    protected static CharsToNameCanonicalizer c(int i4) {
        return f17851l.e(i4);
    }

    public static CharsToNameCanonicalizer createRoot() {
        long currentTimeMillis = System.currentTimeMillis();
        return c((((int) currentTimeMillis) + ((int) (currentTimeMillis >>> 32))) | 1);
    }

    private void d(int i4) {
        this.f17856e = new String[i4];
        this.f17857f = new a[i4 >> 1];
        this.f17860i = i4 - 1;
        this.f17858g = 0;
        this.f17861j = 0;
        this.f17859h = a(i4);
    }

    private CharsToNameCanonicalizer e(int i4) {
        return new CharsToNameCanonicalizer(null, true, true, this.f17856e, this.f17857f, this.f17858g, i4, this.f17861j);
    }

    private void f(CharsToNameCanonicalizer charsToNameCanonicalizer) {
        if (charsToNameCanonicalizer.size() <= 12000 && charsToNameCanonicalizer.f17861j <= 63) {
            if (charsToNameCanonicalizer.size() <= size()) {
                return;
            }
            synchronized (this) {
                this.f17856e = charsToNameCanonicalizer.f17856e;
                this.f17857f = charsToNameCanonicalizer.f17857f;
                this.f17858g = charsToNameCanonicalizer.f17858g;
                this.f17859h = charsToNameCanonicalizer.f17859h;
                this.f17860i = charsToNameCanonicalizer.f17860i;
                this.f17861j = charsToNameCanonicalizer.f17861j;
                this.f17862k = false;
            }
            return;
        }
        synchronized (this) {
            d(64);
            this.f17862k = false;
        }
    }

    private void g() {
        String[] strArr = this.f17856e;
        int length = strArr.length;
        int i4 = length + length;
        if (i4 > 65536) {
            this.f17858g = 0;
            Arrays.fill(strArr, (Object) null);
            Arrays.fill(this.f17857f, (Object) null);
            this.f17862k = true;
            return;
        }
        a[] aVarArr = this.f17857f;
        this.f17856e = new String[i4];
        this.f17857f = new a[i4 >> 1];
        this.f17860i = i4 - 1;
        this.f17859h = a(i4);
        int i5 = 0;
        int i6 = 0;
        for (String str : strArr) {
            if (str != null) {
                i5++;
                int _hashToIndex = _hashToIndex(calcHash(str));
                String[] strArr2 = this.f17856e;
                if (strArr2[_hashToIndex] == null) {
                    strArr2[_hashToIndex] = str;
                } else {
                    int i7 = _hashToIndex >> 1;
                    a aVar = new a(str, this.f17857f[i7]);
                    this.f17857f[i7] = aVar;
                    i6 = Math.max(i6, aVar.d());
                }
            }
        }
        int i8 = length >> 1;
        for (int i9 = 0; i9 < i8; i9++) {
            for (a aVar2 = aVarArr[i9]; aVar2 != null; aVar2 = aVar2.b()) {
                i5++;
                String c4 = aVar2.c();
                int _hashToIndex2 = _hashToIndex(calcHash(c4));
                String[] strArr3 = this.f17856e;
                if (strArr3[_hashToIndex2] == null) {
                    strArr3[_hashToIndex2] = c4;
                } else {
                    int i10 = _hashToIndex2 >> 1;
                    a aVar3 = new a(c4, this.f17857f[i10]);
                    this.f17857f[i10] = aVar3;
                    i6 = Math.max(i6, aVar3.d());
                }
            }
        }
        this.f17861j = i6;
        if (i5 == this.f17858g) {
            return;
        }
        throw new Error("Internal error on SymbolTable.rehash(): had " + this.f17858g + " entries; now have " + i5 + ".");
    }

    public int _hashToIndex(int i4) {
        return (i4 + (i4 >>> 15)) & this.f17860i;
    }

    public int bucketCount() {
        return this.f17856e.length;
    }

    public int calcHash(char[] cArr, int i4, int i5) {
        int i6 = this.f17853b;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 * 33) + cArr[i7];
        }
        if (i6 == 0) {
            return 1;
        }
        return i6;
    }

    public int collisionCount() {
        a[] aVarArr;
        int i4 = 0;
        for (a aVar : this.f17857f) {
            if (aVar != null) {
                i4 += aVar.d();
            }
        }
        return i4;
    }

    public String findSymbol(char[] cArr, int i4, int i5, int i6) {
        String a4;
        if (i5 < 1) {
            return "";
        }
        if (!this.f17855d) {
            return new String(cArr, i4, i5);
        }
        int _hashToIndex = _hashToIndex(i6);
        String str = this.f17856e[_hashToIndex];
        if (str != null) {
            if (str.length() == i5) {
                int i7 = 0;
                while (str.charAt(i7) == cArr[i4 + i7] && (i7 = i7 + 1) < i5) {
                }
                if (i7 == i5) {
                    return str;
                }
            }
            a aVar = this.f17857f[_hashToIndex >> 1];
            if (aVar != null && (a4 = aVar.a(cArr, i4, i5)) != null) {
                return a4;
            }
        }
        if (!this.f17862k) {
            b();
            this.f17862k = true;
        } else if (this.f17858g >= this.f17859h) {
            g();
            _hashToIndex = _hashToIndex(calcHash(cArr, i4, i5));
        }
        String str2 = new String(cArr, i4, i5);
        if (this.f17854c) {
            str2 = InternCache.instance.intern(str2);
        }
        this.f17858g++;
        String[] strArr = this.f17856e;
        if (strArr[_hashToIndex] == null) {
            strArr[_hashToIndex] = str2;
        } else {
            int i8 = _hashToIndex >> 1;
            a aVar2 = new a(str2, this.f17857f[i8]);
            this.f17857f[i8] = aVar2;
            int max = Math.max(aVar2.d(), this.f17861j);
            this.f17861j = max;
            if (max > 255) {
                h(255);
            }
        }
        return str2;
    }

    protected void h(int i4) {
        throw new IllegalStateException("Longest collision chain in symbol table (of size " + this.f17858g + ") now exceeds maximum, " + i4 + " -- suspect a DoS attack based on hash collisions");
    }

    public int hashSeed() {
        return this.f17853b;
    }

    public CharsToNameCanonicalizer makeChild(boolean z3, boolean z4) {
        String[] strArr;
        a[] aVarArr;
        int i4;
        int i5;
        int i6;
        synchronized (this) {
            strArr = this.f17856e;
            aVarArr = this.f17857f;
            i4 = this.f17858g;
            i5 = this.f17853b;
            i6 = this.f17861j;
        }
        return new CharsToNameCanonicalizer(this, z3, z4, strArr, aVarArr, i4, i5, i6);
    }

    public int maxCollisionLength() {
        return this.f17861j;
    }

    public boolean maybeDirty() {
        return this.f17862k;
    }

    public void release() {
        CharsToNameCanonicalizer charsToNameCanonicalizer;
        if (maybeDirty() && (charsToNameCanonicalizer = this.f17852a) != null) {
            charsToNameCanonicalizer.f(this);
            this.f17862k = false;
        }
    }

    public int size() {
        return this.f17858g;
    }

    public int calcHash(String str) {
        int length = str.length();
        int i4 = this.f17853b;
        for (int i5 = 0; i5 < length; i5++) {
            i4 = (i4 * 33) + str.charAt(i5);
        }
        if (i4 == 0) {
            return 1;
        }
        return i4;
    }

    private CharsToNameCanonicalizer(CharsToNameCanonicalizer charsToNameCanonicalizer, boolean z3, boolean z4, String[] strArr, a[] aVarArr, int i4, int i5, int i6) {
        this.f17852a = charsToNameCanonicalizer;
        this.f17855d = z3;
        this.f17854c = z4;
        this.f17856e = strArr;
        this.f17857f = aVarArr;
        this.f17858g = i4;
        this.f17853b = i5;
        int length = strArr.length;
        this.f17859h = a(length);
        this.f17860i = length - 1;
        this.f17861j = i6;
        this.f17862k = false;
    }
}
