package com.fasterxml.jackson.core.sym;

/* loaded from: classes3.dex */
public abstract class Name {

    /* renamed from: a  reason: collision with root package name */
    protected final String f17866a;

    /* renamed from: b  reason: collision with root package name */
    protected final int f17867b;

    /* JADX INFO: Access modifiers changed from: protected */
    public Name(String str, int i4) {
        this.f17866a = str;
        this.f17867b = i4;
    }

    public abstract boolean equals(int i4);

    public abstract boolean equals(int i4, int i5);

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return false;
    }

    public abstract boolean equals(int[] iArr, int i4);

    public String getName() {
        return this.f17866a;
    }

    public final int hashCode() {
        return this.f17867b;
    }

    public String toString() {
        return this.f17866a;
    }
}
