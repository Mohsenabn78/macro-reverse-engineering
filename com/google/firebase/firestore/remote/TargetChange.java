package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.protobuf.ByteString;

/* loaded from: classes5.dex */
public final class TargetChange {

    /* renamed from: a  reason: collision with root package name */
    private final ByteString f31162a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f31163b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f31164c;

    /* renamed from: d  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f31165d;

    /* renamed from: e  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f31166e;

    public TargetChange(ByteString byteString, boolean z3, ImmutableSortedSet<DocumentKey> immutableSortedSet, ImmutableSortedSet<DocumentKey> immutableSortedSet2, ImmutableSortedSet<DocumentKey> immutableSortedSet3) {
        this.f31162a = byteString;
        this.f31163b = z3;
        this.f31164c = immutableSortedSet;
        this.f31165d = immutableSortedSet2;
        this.f31166e = immutableSortedSet3;
    }

    public static TargetChange createSynthesizedTargetChangeForCurrentChange(boolean z3, ByteString byteString) {
        return new TargetChange(byteString, z3, DocumentKey.emptyKeySet(), DocumentKey.emptyKeySet(), DocumentKey.emptyKeySet());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TargetChange.class != obj.getClass()) {
            return false;
        }
        TargetChange targetChange = (TargetChange) obj;
        if (this.f31163b != targetChange.f31163b || !this.f31162a.equals(targetChange.f31162a) || !this.f31164c.equals(targetChange.f31164c) || !this.f31165d.equals(targetChange.f31165d)) {
            return false;
        }
        return this.f31166e.equals(targetChange.f31166e);
    }

    public ImmutableSortedSet<DocumentKey> getAddedDocuments() {
        return this.f31164c;
    }

    public ImmutableSortedSet<DocumentKey> getModifiedDocuments() {
        return this.f31165d;
    }

    public ImmutableSortedSet<DocumentKey> getRemovedDocuments() {
        return this.f31166e;
    }

    public ByteString getResumeToken() {
        return this.f31162a;
    }

    public int hashCode() {
        return (((((((this.f31162a.hashCode() * 31) + (this.f31163b ? 1 : 0)) * 31) + this.f31164c.hashCode()) * 31) + this.f31165d.hashCode()) * 31) + this.f31166e.hashCode();
    }

    public boolean isCurrent() {
        return this.f31163b;
    }
}
