package com.koushikdutta.async.http.spdy;

import java.util.Arrays;

/* compiled from: Settings.java */
/* loaded from: classes6.dex */
final class j {

    /* renamed from: a  reason: collision with root package name */
    private int f35596a;

    /* renamed from: b  reason: collision with root package name */
    private int f35597b;

    /* renamed from: c  reason: collision with root package name */
    private int f35598c;

    /* renamed from: d  reason: collision with root package name */
    private final int[] f35599d = new int[10];

    public void a() {
        this.f35598c = 0;
        this.f35597b = 0;
        this.f35596a = 0;
        Arrays.fill(this.f35599d, 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(int i4) {
        int i5;
        if (f(i4)) {
            i5 = 2;
        } else {
            i5 = 0;
        }
        if (i(i4)) {
            return i5 | 1;
        }
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(int i4) {
        return this.f35599d[i4];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        if ((this.f35596a & 2) != 0) {
            return this.f35599d[1];
        }
        return -1;
    }

    public int e(int i4) {
        if ((this.f35596a & 128) != 0) {
            return this.f35599d[7];
        }
        return i4;
    }

    boolean f(int i4) {
        if (((1 << i4) & this.f35598c) != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean g(int i4) {
        if (((1 << i4) & this.f35596a) != 0) {
            return true;
        }
        return false;
    }

    public void h(j jVar) {
        for (int i4 = 0; i4 < 10; i4++) {
            if (jVar.g(i4)) {
                j(i4, jVar.b(i4), jVar.c(i4));
            }
        }
    }

    boolean i(int i4) {
        if (((1 << i4) & this.f35597b) != 0) {
            return true;
        }
        return false;
    }

    public j j(int i4, int i5, int i6) {
        int[] iArr = this.f35599d;
        if (i4 >= iArr.length) {
            return this;
        }
        int i7 = 1 << i4;
        this.f35596a |= i7;
        if ((i5 & 1) != 0) {
            this.f35597b |= i7;
        } else {
            this.f35597b &= ~i7;
        }
        if ((i5 & 2) != 0) {
            this.f35598c |= i7;
        } else {
            this.f35598c &= ~i7;
        }
        iArr[i4] = i6;
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return Integer.bitCount(this.f35596a);
    }
}
