package com.google.firebase.firestore.remote;

import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.util.Assert;
import com.google.protobuf.ByteString;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class TargetState {

    /* renamed from: a  reason: collision with root package name */
    private int f31167a = 0;

    /* renamed from: b  reason: collision with root package name */
    private final Map<DocumentKey, DocumentViewChange.Type> f31168b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private boolean f31169c = true;

    /* renamed from: d  reason: collision with root package name */
    private ByteString f31170d = ByteString.EMPTY;

    /* renamed from: e  reason: collision with root package name */
    private boolean f31171e = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.firebase.firestore.remote.TargetState$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f31172a;

        static {
            int[] iArr = new int[DocumentViewChange.Type.values().length];
            f31172a = iArr;
            try {
                iArr[DocumentViewChange.Type.ADDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f31172a[DocumentViewChange.Type.MODIFIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f31172a[DocumentViewChange.Type.REMOVED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(DocumentKey documentKey, DocumentViewChange.Type type) {
        this.f31169c = true;
        this.f31168b.put(documentKey, type);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f31169c = false;
        this.f31168b.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.f31169c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean d() {
        return this.f31171e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        if (this.f31167a != 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.f31169c = true;
        this.f31171e = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g() {
        this.f31167a++;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        this.f31167a--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(DocumentKey documentKey) {
        this.f31169c = true;
        this.f31168b.remove(documentKey);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TargetChange j() {
        ImmutableSortedSet<DocumentKey> emptyKeySet = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet2 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> emptyKeySet3 = DocumentKey.emptyKeySet();
        ImmutableSortedSet<DocumentKey> immutableSortedSet = emptyKeySet;
        ImmutableSortedSet<DocumentKey> immutableSortedSet2 = emptyKeySet2;
        ImmutableSortedSet<DocumentKey> immutableSortedSet3 = emptyKeySet3;
        for (Map.Entry<DocumentKey, DocumentViewChange.Type> entry : this.f31168b.entrySet()) {
            DocumentKey key = entry.getKey();
            DocumentViewChange.Type value = entry.getValue();
            int i4 = AnonymousClass1.f31172a[value.ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 == 3) {
                        immutableSortedSet3 = immutableSortedSet3.insert(key);
                    } else {
                        throw Assert.fail("Encountered invalid change type: %s", value);
                    }
                } else {
                    immutableSortedSet2 = immutableSortedSet2.insert(key);
                }
            } else {
                immutableSortedSet = immutableSortedSet.insert(key);
            }
        }
        return new TargetChange(this.f31170d, this.f31171e, immutableSortedSet, immutableSortedSet2, immutableSortedSet3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ByteString byteString) {
        if (!byteString.isEmpty()) {
            this.f31169c = true;
            this.f31170d = byteString;
        }
    }
}
