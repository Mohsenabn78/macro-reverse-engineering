package com.fasterxml.jackson.core.sym;

/* loaded from: classes3.dex */
public final class Name1 extends Name {

    /* renamed from: d  reason: collision with root package name */
    static final Name1 f17868d = new Name1("", 0, 0);

    /* renamed from: c  reason: collision with root package name */
    final int f17869c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Name1(String str, int i4, int i5) {
        super(str, i4);
        this.f17869c = i5;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Name1 a() {
        return f17868d;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i4) {
        return i4 == this.f17869c;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int i4, int i5) {
        return i4 == this.f17869c && i5 == 0;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] iArr, int i4) {
        return i4 == 1 && iArr[0] == this.f17869c;
    }
}
