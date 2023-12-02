package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;

/* loaded from: classes5.dex */
public final class ExistenceFilter {

    /* renamed from: a  reason: collision with root package name */
    private final int f31081a;

    /* renamed from: b  reason: collision with root package name */
    private com.google.firestore.v1.BloomFilter f31082b;

    public ExistenceFilter(int i4) {
        this.f31081a = i4;
    }

    public int getCount() {
        return this.f31081a;
    }

    @Nullable
    public com.google.firestore.v1.BloomFilter getUnchangedNames() {
        return this.f31082b;
    }

    public String toString() {
        return "ExistenceFilter{count=" + this.f31081a + ", unchangedNames=" + this.f31082b + '}';
    }

    public ExistenceFilter(int i4, @Nullable com.google.firestore.v1.BloomFilter bloomFilter) {
        this.f31081a = i4;
        this.f31082b = bloomFilter;
    }
}
