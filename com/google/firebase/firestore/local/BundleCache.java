package com.google.firebase.firestore.local;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.bundle.BundleMetadata;
import com.google.firebase.firestore.bundle.NamedQuery;

/* loaded from: classes5.dex */
public interface BundleCache {
    @Nullable
    BundleMetadata getBundleMetadata(String str);

    @Nullable
    NamedQuery getNamedQuery(String str);

    void saveBundleMetadata(BundleMetadata bundleMetadata);

    void saveNamedQuery(NamedQuery namedQuery);
}
