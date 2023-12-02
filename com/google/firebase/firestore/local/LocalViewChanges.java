package com.google.firebase.firestore.local;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.ViewSnapshot;
import com.google.firebase.firestore.model.DocumentKey;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public final class LocalViewChanges {

    /* renamed from: a  reason: collision with root package name */
    private final int f30623a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f30624b;

    /* renamed from: c  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f30625c;

    /* renamed from: d  reason: collision with root package name */
    private final ImmutableSortedSet<DocumentKey> f30626d;

    /* renamed from: com.google.firebase.firestore.local.LocalViewChanges$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f30627a;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            f30627a = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f30627a[DocumentViewChange.Type.REMOVED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public LocalViewChanges(int i4, boolean z3, ImmutableSortedSet<DocumentKey> immutableSortedSet, ImmutableSortedSet<DocumentKey> immutableSortedSet2) {
        this.f30623a = i4;
        this.f30624b = z3;
        this.f30625c = immutableSortedSet;
        this.f30626d = immutableSortedSet2;
    }

    public static LocalViewChanges fromViewSnapshot(int i4, ViewSnapshot viewSnapshot) {
        ImmutableSortedSet immutableSortedSet = new ImmutableSortedSet(new ArrayList(), DocumentKey.comparator());
        ImmutableSortedSet immutableSortedSet2 = new ImmutableSortedSet(new ArrayList(), DocumentKey.comparator());
        for (DocumentViewChange documentViewChange : viewSnapshot.getChanges()) {
            int i5 = AnonymousClass1.f30627a[documentViewChange.getType().ordinal()];
            if (i5 != 1) {
                if (i5 == 2) {
                    immutableSortedSet2 = immutableSortedSet2.insert(documentViewChange.getDocument().getKey());
                }
            } else {
                immutableSortedSet = immutableSortedSet.insert(documentViewChange.getDocument().getKey());
            }
        }
        return new LocalViewChanges(i4, viewSnapshot.isFromCache(), immutableSortedSet, immutableSortedSet2);
    }

    public ImmutableSortedSet<DocumentKey> getAdded() {
        return this.f30625c;
    }

    public ImmutableSortedSet<DocumentKey> getRemoved() {
        return this.f30626d;
    }

    public int getTargetId() {
        return this.f30623a;
    }

    public boolean isFromCache() {
        return this.f30624b;
    }
}
