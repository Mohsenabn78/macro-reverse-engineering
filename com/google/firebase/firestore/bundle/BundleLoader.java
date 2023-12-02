package com.google.firebase.firestore.bundle;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedMap;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.LoadBundleTaskProgress;
import com.google.firebase.firestore.model.Document;
import com.google.firebase.firestore.model.DocumentCollections;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.MutableDocument;
import com.google.firebase.firestore.util.Preconditions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class BundleLoader {

    /* renamed from: a  reason: collision with root package name */
    private final BundleCallback f30270a;

    /* renamed from: b  reason: collision with root package name */
    private final BundleMetadata f30271b;

    /* renamed from: f  reason: collision with root package name */
    private long f30275f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private BundledDocumentMetadata f30276g;

    /* renamed from: c  reason: collision with root package name */
    private final List<NamedQuery> f30272c = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ImmutableSortedMap<DocumentKey, MutableDocument> f30274e = DocumentCollections.emptyMutableDocumentMap();

    /* renamed from: d  reason: collision with root package name */
    private final Map<DocumentKey, BundledDocumentMetadata> f30273d = new HashMap();

    public BundleLoader(BundleCallback bundleCallback, BundleMetadata bundleMetadata) {
        this.f30270a = bundleCallback;
        this.f30271b = bundleMetadata;
    }

    private Map<String, ImmutableSortedSet<DocumentKey>> a() {
        HashMap hashMap = new HashMap();
        for (NamedQuery namedQuery : this.f30272c) {
            hashMap.put(namedQuery.getName(), DocumentKey.emptyKeySet());
        }
        for (BundledDocumentMetadata bundledDocumentMetadata : this.f30273d.values()) {
            for (String str : bundledDocumentMetadata.getQueries()) {
                hashMap.put(str, ((ImmutableSortedSet) hashMap.get(str)).insert(bundledDocumentMetadata.getKey()));
            }
        }
        return hashMap;
    }

    @Nullable
    public LoadBundleTaskProgress addElement(BundleElement bundleElement, long j4) {
        Preconditions.checkArgument(!(bundleElement instanceof BundleMetadata), "Unexpected bundle metadata element.", new Object[0]);
        int size = this.f30274e.size();
        if (bundleElement instanceof NamedQuery) {
            this.f30272c.add((NamedQuery) bundleElement);
        } else if (bundleElement instanceof BundledDocumentMetadata) {
            BundledDocumentMetadata bundledDocumentMetadata = (BundledDocumentMetadata) bundleElement;
            this.f30273d.put(bundledDocumentMetadata.getKey(), bundledDocumentMetadata);
            this.f30276g = bundledDocumentMetadata;
            if (!bundledDocumentMetadata.exists()) {
                this.f30274e = this.f30274e.insert(bundledDocumentMetadata.getKey(), MutableDocument.newNoDocument(bundledDocumentMetadata.getKey(), bundledDocumentMetadata.getReadTime()).setReadTime(bundledDocumentMetadata.getReadTime()));
                this.f30276g = null;
            }
        } else if (bundleElement instanceof BundleDocument) {
            BundleDocument bundleDocument = (BundleDocument) bundleElement;
            if (this.f30276g != null && bundleDocument.getKey().equals(this.f30276g.getKey())) {
                this.f30274e = this.f30274e.insert(bundleDocument.getKey(), bundleDocument.getDocument().setReadTime(this.f30276g.getReadTime()));
                this.f30276g = null;
            } else {
                throw new IllegalArgumentException("The document being added does not match the stored metadata.");
            }
        }
        this.f30275f += j4;
        if (size == this.f30274e.size()) {
            return null;
        }
        return new LoadBundleTaskProgress(this.f30274e.size(), this.f30271b.getTotalDocuments(), this.f30275f, this.f30271b.getTotalBytes(), null, LoadBundleTaskProgress.TaskState.RUNNING);
    }

    public ImmutableSortedMap<DocumentKey, Document> applyChanges() {
        boolean z3;
        boolean z4;
        boolean z5;
        if (this.f30276g == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "Bundled documents end with a document metadata element instead of a document.", new Object[0]);
        if (this.f30271b.getBundleId() != null) {
            z4 = true;
        } else {
            z4 = false;
        }
        Preconditions.checkArgument(z4, "Bundle ID must be set", new Object[0]);
        if (this.f30274e.size() == this.f30271b.getTotalDocuments()) {
            z5 = true;
        } else {
            z5 = false;
        }
        Preconditions.checkArgument(z5, "Expected %s documents, but loaded %s.", Integer.valueOf(this.f30271b.getTotalDocuments()), Integer.valueOf(this.f30274e.size()));
        ImmutableSortedMap<DocumentKey, Document> applyBundledDocuments = this.f30270a.applyBundledDocuments(this.f30274e, this.f30271b.getBundleId());
        Map<String, ImmutableSortedSet<DocumentKey>> a4 = a();
        for (NamedQuery namedQuery : this.f30272c) {
            this.f30270a.saveNamedQuery(namedQuery, a4.get(namedQuery.getName()));
        }
        this.f30270a.saveBundle(this.f30271b);
        return applyBundledDocuments;
    }
}
