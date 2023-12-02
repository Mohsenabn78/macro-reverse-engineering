package com.fasterxml.jackson.core.sym;

/* loaded from: classes3.dex */
public final class Name3 extends Name {

    /* renamed from: c  reason: collision with root package name */
    final int f17872c;

    /* renamed from: d  reason: collision with root package name */
    final int f17873d;

    /* renamed from: e  reason: collision with root package name */
    final int f17874e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Name3(String str, int i4, int i5, int i6, int i7) {
        super(str, i4);
        this.f17872c = i5;
        this.f17873d = i6;
        this.f17874e = i7;
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
        return i4 == 3 && iArr[0] == this.f17872c && iArr[1] == this.f17873d && iArr[2] == this.f17874e;
    }
}
