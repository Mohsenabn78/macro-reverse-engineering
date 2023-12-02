package com.fasterxml.jackson.core.sym;

/* loaded from: classes3.dex */
public final class Name2 extends Name {

    /* renamed from: c  reason: collision with root package name */
    final int f17870c;

    /* renamed from: d  reason: collision with root package name */
    final int f17871d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Name2(String str, int i4, int i5, int i6) {
        super(str, i4);
        this.f17870c = i5;
        this.f17871d = i6;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i4) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i4, int i5) {
        return i4 == this.f17870c && i5 == this.f17871d;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i4) {
        return i4 == 2 && iArr[0] == this.f17870c && iArr[1] == this.f17871d;
    }
}
