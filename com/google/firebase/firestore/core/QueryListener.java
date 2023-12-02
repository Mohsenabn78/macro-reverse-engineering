package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.DocumentViewChange;
import com.google.firebase.firestore.core.EventManager;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public class QueryListener {

    /* renamed from: a  reason: collision with root package name */
    private final Query f30390a;

    /* renamed from: b  reason: collision with root package name */
    private final EventManager.ListenOptions f30391b;

    /* renamed from: c  reason: collision with root package name */
    private final EventListener<ViewSnapshot> f30392c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f30393d = false;

    /* renamed from: e  reason: collision with root package name */
    private OnlineState f30394e = OnlineState.UNKNOWN;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private ViewSnapshot f30395f;

    public QueryListener(Query query, EventManager.ListenOptions listenOptions, EventListener<ViewSnapshot> eventListener) {
        this.f30390a = query;
        this.f30392c = eventListener;
        this.f30391b = listenOptions;
    }

    private void a(ViewSnapshot viewSnapshot) {
        Assert.hardAssert(!this.f30393d, "Trying to raise initial event for second time", new Object[0]);
        ViewSnapshot fromInitialDocuments = ViewSnapshot.fromInitialDocuments(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getMutatedKeys(), viewSnapshot.isFromCache(), viewSnapshot.excludesMetadataChanges(), viewSnapshot.hasCachedResults());
        this.f30393d = true;
        this.f30392c.onEvent(fromInitialDocuments, null);
    }

    private boolean b(ViewSnapshot viewSnapshot) {
        boolean z3 = true;
        if (!viewSnapshot.getChanges().isEmpty()) {
            return true;
        }
        ViewSnapshot viewSnapshot2 = this.f30395f;
        z3 = (viewSnapshot2 == null || viewSnapshot2.hasPendingWrites() == viewSnapshot.hasPendingWrites()) ? false : false;
        if (!viewSnapshot.didSyncStateChange() && !z3) {
            return false;
        }
        return this.f30391b.includeQueryMetadataChanges;
    }

    private boolean c(ViewSnapshot viewSnapshot, OnlineState onlineState) {
        Assert.hardAssert(!this.f30393d, "Determining whether to raise first event but already had first event.", new Object[0]);
        if (!viewSnapshot.isFromCache()) {
            return true;
        }
        OnlineState onlineState2 = OnlineState.OFFLINE;
        boolean z3 = !onlineState.equals(onlineState2);
        if (this.f30391b.waitForSyncWhenOnline && z3) {
            Assert.hardAssert(viewSnapshot.isFromCache(), "Waiting for sync, but snapshot is not from cache", new Object[0]);
            return false;
        } else if (!viewSnapshot.getDocuments().isEmpty() || viewSnapshot.hasCachedResults() || onlineState.equals(onlineState2)) {
            return true;
        } else {
            return false;
        }
    }

    public Query getQuery() {
        return this.f30390a;
    }

    public void onError(FirebaseFirestoreException firebaseFirestoreException) {
        this.f30392c.onEvent(null, firebaseFirestoreException);
    }

    public boolean onOnlineStateChanged(OnlineState onlineState) {
        this.f30394e = onlineState;
        ViewSnapshot viewSnapshot = this.f30395f;
        if (viewSnapshot != null && !this.f30393d && c(viewSnapshot, onlineState)) {
            a(this.f30395f);
            return true;
        }
        return false;
    }

    public boolean onViewSnapshot(ViewSnapshot viewSnapshot) {
        boolean z3;
        boolean z4 = false;
        if (viewSnapshot.getChanges().isEmpty() && !viewSnapshot.didSyncStateChange()) {
            z3 = false;
        } else {
            z3 = true;
        }
        Assert.hardAssert(z3, "We got a new snapshot with no changes?", new Object[0]);
        if (!this.f30391b.includeDocumentMetadataChanges) {
            ArrayList arrayList = new ArrayList();
            for (DocumentViewChange documentViewChange : viewSnapshot.getChanges()) {
                if (documentViewChange.getType() != DocumentViewChange.Type.METADATA) {
                    arrayList.add(documentViewChange);
                }
            }
            viewSnapshot = new ViewSnapshot(viewSnapshot.getQuery(), viewSnapshot.getDocuments(), viewSnapshot.getOldDocuments(), arrayList, viewSnapshot.isFromCache(), viewSnapshot.getMutatedKeys(), viewSnapshot.didSyncStateChange(), true, viewSnapshot.hasCachedResults());
        }
        if (!this.f30393d) {
            if (c(viewSnapshot, this.f30394e)) {
                a(viewSnapshot);
                z4 = true;
            }
        } else if (b(viewSnapshot)) {
            this.f30392c.onEvent(viewSnapshot, null);
            z4 = true;
        }
        this.f30395f = viewSnapshot;
        return z4;
    }
}
