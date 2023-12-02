package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.remote.TestingHooks;

/* loaded from: classes5.dex */
final class AutoValue_TestingHooks_ExistenceFilterBloomFilterInfo extends TestingHooks.ExistenceFilterBloomFilterInfo {

    /* renamed from: a  reason: collision with root package name */
    private final BloomFilter f31056a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31057b;

    /* renamed from: c  reason: collision with root package name */
    private final int f31058c;

    /* renamed from: d  reason: collision with root package name */
    private final int f31059d;

    /* renamed from: e  reason: collision with root package name */
    private final int f31060e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TestingHooks_ExistenceFilterBloomFilterInfo(@Nullable BloomFilter bloomFilter, boolean z3, int i4, int i5, int i6) {
        this.f31056a = bloomFilter;
        this.f31057b = z3;
        this.f31058c = i4;
        this.f31059d = i5;
        this.f31060e = i6;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    boolean a() {
        return this.f31057b;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    int b() {
        return this.f31059d;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    @Nullable
    BloomFilter c() {
        return this.f31056a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TestingHooks.ExistenceFilterBloomFilterInfo)) {
            return false;
        }
        TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo = (TestingHooks.ExistenceFilterBloomFilterInfo) obj;
        BloomFilter bloomFilter = this.f31056a;
        if (bloomFilter != null ? bloomFilter.equals(existenceFilterBloomFilterInfo.c()) : existenceFilterBloomFilterInfo.c() == null) {
            if (this.f31057b == existenceFilterBloomFilterInfo.a() && this.f31058c == existenceFilterBloomFilterInfo.f() && this.f31059d == existenceFilterBloomFilterInfo.b() && this.f31060e == existenceFilterBloomFilterInfo.g()) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    int f() {
        return this.f31058c;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterBloomFilterInfo
    int g() {
        return this.f31060e;
    }

    public int hashCode() {
        int hashCode;
        int i4;
        BloomFilter bloomFilter = this.f31056a;
        if (bloomFilter == null) {
            hashCode = 0;
        } else {
            hashCode = bloomFilter.hashCode();
        }
        int i5 = (hashCode ^ 1000003) * 1000003;
        if (this.f31057b) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return ((((((i5 ^ i4) * 1000003) ^ this.f31058c) * 1000003) ^ this.f31059d) * 1000003) ^ this.f31060e;
    }

    public String toString() {
        return "ExistenceFilterBloomFilterInfo{bloomFilter=" + this.f31056a + ", applied=" + this.f31057b + ", hashCount=" + this.f31058c + ", bitmapLength=" + this.f31059d + ", padding=" + this.f31060e + "}";
    }
}
