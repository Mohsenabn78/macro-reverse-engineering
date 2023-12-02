package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.remote.TestingHooks;

/* loaded from: classes5.dex */
final class AutoValue_TestingHooks_ExistenceFilterMismatchInfo extends TestingHooks.ExistenceFilterMismatchInfo {

    /* renamed from: a  reason: collision with root package name */
    private final int f31061a;

    /* renamed from: b  reason: collision with root package name */
    private final int f31062b;

    /* renamed from: c  reason: collision with root package name */
    private final String f31063c;

    /* renamed from: d  reason: collision with root package name */
    private final String f31064d;

    /* renamed from: e  reason: collision with root package name */
    private final TestingHooks.ExistenceFilterBloomFilterInfo f31065e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AutoValue_TestingHooks_ExistenceFilterMismatchInfo(int i4, int i5, String str, String str2, @Nullable TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo) {
        this.f31061a = i4;
        this.f31062b = i5;
        if (str != null) {
            this.f31063c = str;
            if (str2 != null) {
                this.f31064d = str2;
                this.f31065e = existenceFilterBloomFilterInfo;
                return;
            }
            throw new NullPointerException("Null databaseId");
        }
        throw new NullPointerException("Null projectId");
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo
    @Nullable
    TestingHooks.ExistenceFilterBloomFilterInfo a() {
        return this.f31065e;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo
    String c() {
        return this.f31064d;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo
    int d() {
        return this.f31062b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof TestingHooks.ExistenceFilterMismatchInfo)) {
            return false;
        }
        TestingHooks.ExistenceFilterMismatchInfo existenceFilterMismatchInfo = (TestingHooks.ExistenceFilterMismatchInfo) obj;
        if (this.f31061a == existenceFilterMismatchInfo.f() && this.f31062b == existenceFilterMismatchInfo.d() && this.f31063c.equals(existenceFilterMismatchInfo.g()) && this.f31064d.equals(existenceFilterMismatchInfo.c())) {
            TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo = this.f31065e;
            if (existenceFilterBloomFilterInfo == null) {
                if (existenceFilterMismatchInfo.a() == null) {
                    return true;
                }
            } else if (existenceFilterBloomFilterInfo.equals(existenceFilterMismatchInfo.a())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo
    int f() {
        return this.f31061a;
    }

    @Override // com.google.firebase.firestore.remote.TestingHooks.ExistenceFilterMismatchInfo
    String g() {
        return this.f31063c;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = (((((((this.f31061a ^ 1000003) * 1000003) ^ this.f31062b) * 1000003) ^ this.f31063c.hashCode()) * 1000003) ^ this.f31064d.hashCode()) * 1000003;
        TestingHooks.ExistenceFilterBloomFilterInfo existenceFilterBloomFilterInfo = this.f31065e;
        if (existenceFilterBloomFilterInfo == null) {
            hashCode = 0;
        } else {
            hashCode = existenceFilterBloomFilterInfo.hashCode();
        }
        return hashCode2 ^ hashCode;
    }

    public String toString() {
        return "ExistenceFilterMismatchInfo{localCacheCount=" + this.f31061a + ", existenceFilterCount=" + this.f31062b + ", projectId=" + this.f31063c + ", databaseId=" + this.f31064d + ", bloomFilter=" + this.f31065e + "}";
    }
}
