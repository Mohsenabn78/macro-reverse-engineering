package com.fasterxml.jackson.core.sym;

/* loaded from: classes3.dex */
public final class NameN extends Name {

    /* renamed from: c  reason: collision with root package name */
    final int[] f17875c;

    /* renamed from: d  reason: collision with root package name */
    final int f17876d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public NameN(String str, int i4, int[] iArr, int i5) {
        super(str, i4);
        if (i5 >= 3) {
            this.f17875c = iArr;
            this.f17876d = i5;
            return;
        }
        throw new IllegalArgumentException("Qlen must >= 3");
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i4) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i4, int i5) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i4) {
        if (i4 != this.f17876d) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (iArr[i5] != this.f17875c[i5]) {
                return false;
            }
        }
        return true;
    }
}
