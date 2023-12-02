package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
class MemoryBundleCache implements BundleCache {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, BundleMetadata> f30647a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, NamedQuery> f30648b = new HashMap();

    @Override // com.google.firebase.firestore.local.BundleCache
    @Nullable
    public BundleMetadata getBundleMetadata(String str) {
        return this.f30647a.get(str);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    @Nullable
    public NamedQuery getNamedQuery(String str) {
        return this.f30648b.get(str);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveBundleMetadata(BundleMetadata bundleMetadata) {
        this.f30647a.put(bundleMetadata.getBundleId(), bundleMetadata);
    }

    @Override // com.google.firebase.firestore.local.BundleCache
    public void saveNamedQuery(NamedQuery namedQuery) {
        this.f30648b.put(namedQuery.getName(), namedQuery);
    }
}
