package com.h6ah4i.android.widget.advrecyclerview.composedadapter;

import java.util.Arrays;

/* compiled from: SegmentedPositionTranslator.java */
/* loaded from: classes6.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private a f33712a;

    /* renamed from: c  reason: collision with root package name */
    private int[] f33714c;

    /* renamed from: b  reason: collision with root package name */
    private int f33713b = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f33716e = -1;

    /* renamed from: d  reason: collision with root package name */
    private int[] f33715d = new int[128];

    public c(a aVar) {
        this.f33712a = aVar;
        int[] iArr = new int[128];
        this.f33714c = iArr;
        Arrays.fill(iArr, -1);
    }

    private int a() {
        int g4 = this.f33712a.g();
        if (g4 == 0) {
            return 0;
        }
        int i4 = g4 - 1;
        return d(i4) + c(i4);
    }

    public int b(int i4, int i5) {
        return d(i4) + i5;
    }

    public int c(int i4) {
        int i5 = this.f33714c[i4];
        if (i5 != -1) {
            return i5;
        }
        int itemCount = this.f33712a.e(i4).getItemCount();
        this.f33714c[i4] = itemCount;
        if (i4 == this.f33713b) {
            int[] iArr = this.f33715d;
            int i6 = i4 + 1;
            iArr[i6] = iArr[i4] + itemCount;
            this.f33713b = i6;
        }
        return itemCount;
    }

    public int d(int i4) {
        if (i4 <= this.f33713b) {
            return this.f33715d[i4];
        }
        this.f33712a.g();
        int i5 = this.f33713b;
        int i6 = this.f33715d[i5];
        while (i5 < i4) {
            i6 += c(i5);
            i5++;
        }
        return i6;
    }

    public long e(int i4) {
        int i5 = -1;
        if (i4 == -1) {
            return -1L;
        }
        int i6 = 0;
        int binarySearch = Arrays.binarySearch(this.f33715d, 0, this.f33713b, i4);
        if (binarySearch >= 0) {
            i5 = binarySearch;
        } else {
            binarySearch = Math.max(0, (~binarySearch) - 1);
            i6 = -1;
        }
        int g4 = this.f33712a.g();
        int i7 = this.f33715d[binarySearch];
        while (true) {
            if (binarySearch >= g4) {
                break;
            }
            int c4 = c(binarySearch) + i7;
            if (c4 > i4) {
                i6 = i4 - i7;
                i5 = binarySearch;
                break;
            }
            binarySearch++;
            i7 = c4;
        }
        if (i5 >= 0) {
            return a.b(i5, i6);
        }
        return a.f33706f;
    }

    public int f() {
        if (this.f33716e == -1) {
            this.f33716e = a();
        }
        return this.f33716e;
    }

    public void g() {
        this.f33716e = -1;
        this.f33713b = 0;
        Arrays.fill(this.f33714c, -1);
    }

    public void h(int i4) {
        this.f33716e = -1;
        this.f33713b = Math.min(this.f33713b, i4);
        this.f33714c[i4] = -1;
    }

    public void i() {
        this.f33712a = null;
        this.f33714c = null;
        this.f33715d = null;
    }
}
