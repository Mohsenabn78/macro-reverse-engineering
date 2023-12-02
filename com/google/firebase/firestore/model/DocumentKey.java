package com.google.firebase.firestore.model;

import androidx.annotation.NonNull;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.util.Assert;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* loaded from: classes5.dex */
public final class DocumentKey implements Comparable<DocumentKey> {
    public static final String KEY_FIELD_NAME = "__name__";

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<DocumentKey> f30947b;

    /* renamed from: c  reason: collision with root package name */
    private static final ImmutableSortedSet<DocumentKey> f30948c;

    /* renamed from: a  reason: collision with root package name */
    private final ResourcePath f30949a;

    static {
        Comparator<DocumentKey> comparator = new Comparator() { // from class: com.google.firebase.firestore.model.c
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return ((DocumentKey) obj).compareTo((DocumentKey) obj2);
            }
        };
        f30947b = comparator;
        f30948c = new ImmutableSortedSet<>(Collections.emptyList(), comparator);
    }

    private DocumentKey(ResourcePath resourcePath) {
        Assert.hardAssert(isDocumentKey(resourcePath), "Not a document key path: %s", resourcePath);
        this.f30949a = resourcePath;
    }

    public static Comparator<DocumentKey> comparator() {
        return f30947b;
    }

    public static DocumentKey empty() {
        return fromSegments(Collections.emptyList());
    }

    public static ImmutableSortedSet<DocumentKey> emptyKeySet() {
        return f30948c;
    }

    public static DocumentKey fromName(String str) {
        boolean z3;
        ResourcePath fromString = ResourcePath.fromString(str);
        if (fromString.length() > 4 && fromString.getSegment(0).equals("projects") && fromString.getSegment(2).equals("databases") && fromString.getSegment(4).equals("documents")) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Tried to parse an invalid key: %s", fromString);
        return fromPath(fromString.popFirst(5));
    }

    public static DocumentKey fromPath(ResourcePath resourcePath) {
        return new DocumentKey(resourcePath);
    }

    public static DocumentKey fromPathString(String str) {
        return new DocumentKey(ResourcePath.fromString(str));
    }

    public static DocumentKey fromSegments(List<String> list) {
        return new DocumentKey(ResourcePath.fromSegments(list));
    }

    public static boolean isDocumentKey(ResourcePath resourcePath) {
        if (resourcePath.length() % 2 == 0) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DocumentKey.class == obj.getClass()) {
            return this.f30949a.equals(((DocumentKey) obj).f30949a);
        }
        return false;
    }

    public String getCollectionGroup() {
        ResourcePath resourcePath = this.f30949a;
        return resourcePath.getSegment(resourcePath.length() - 2);
    }

    public ResourcePath getCollectionPath() {
        return this.f30949a.popLast();
    }

    public String getDocumentId() {
        return this.f30949a.getLastSegment();
    }

    public ResourcePath getPath() {
        return this.f30949a;
    }

    public boolean hasCollectionId(String str) {
        if (this.f30949a.length() >= 2) {
            ResourcePath resourcePath = this.f30949a;
            if (resourcePath.f30943a.get(resourcePath.length() - 2).equals(str)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.f30949a.hashCode();
    }

    public String toString() {
        return this.f30949a.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull DocumentKey documentKey) {
        return this.f30949a.compareTo(documentKey.f30949a);
    }
}
