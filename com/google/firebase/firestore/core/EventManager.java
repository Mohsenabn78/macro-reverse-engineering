package com.google.firebase.firestore.core;

import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.core.SyncEngine;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.Util;
import io.grpc.Status;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes5.dex */
public final class EventManager implements SyncEngine.SyncEngineCallback {

    /* renamed from: a  reason: collision with root package name */
    private final SyncEngine f30336a;

    /* renamed from: c  reason: collision with root package name */
    private final Set<EventListener<Void>> f30338c = new HashSet();

    /* renamed from: d  reason: collision with root package name */
    private OnlineState f30339d = OnlineState.UNKNOWN;

    /* renamed from: b  reason: collision with root package name */
    private final Map<Query, QueryListenersInfo> f30337b = new HashMap();

    /* loaded from: classes5.dex */
    public static class ListenOptions {
        public boolean includeDocumentMetadataChanges;
        public boolean includeQueryMetadataChanges;
        public boolean waitForSyncWhenOnline;
    }

    /* loaded from: classes5.dex */
    private static class QueryListenersInfo {

        /* renamed from: a  reason: collision with root package name */
        private final List<QueryListener> f30340a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        private ViewSnapshot f30341b;

        /* renamed from: c  reason: collision with root package name */
        private int f30342c;

        QueryListenersInfo() {
        }
    }

    public EventManager(SyncEngine syncEngine) {
        this.f30336a = syncEngine;
        syncEngine.setCallback(this);
    }

    private void a() {
        for (EventListener<Void> eventListener : this.f30338c) {
            eventListener.onEvent(null, null);
        }
    }

    public int addQueryListener(QueryListener queryListener) {
        boolean z3;
        Query query = queryListener.getQuery();
        QueryListenersInfo queryListenersInfo = this.f30337b.get(query);
        if (queryListenersInfo == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (z3) {
            queryListenersInfo = new QueryListenersInfo();
            this.f30337b.put(query, queryListenersInfo);
        }
        queryListenersInfo.f30340a.add(queryListener);
        Assert.hardAssert(true ^ queryListener.onOnlineStateChanged(this.f30339d), "onOnlineStateChanged() shouldn't raise an event for brand-new listeners.", new Object[0]);
        if (queryListenersInfo.f30341b != null && queryListener.onViewSnapshot(queryListenersInfo.f30341b)) {
            a();
        }
        if (z3) {
            queryListenersInfo.f30342c = this.f30336a.listen(query);
        }
        return queryListenersInfo.f30342c;
    }

    public void addSnapshotsInSyncListener(EventListener<Void> eventListener) {
        this.f30338c.add(eventListener);
        eventListener.onEvent(null, null);
    }

    @Override // com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback
    public void handleOnlineStateChange(OnlineState onlineState) {
        this.f30339d = onlineState;
        boolean z3 = false;
        for (QueryListenersInfo queryListenersInfo : this.f30337b.values()) {
            for (QueryListener queryListener : queryListenersInfo.f30340a) {
                if (queryListener.onOnlineStateChanged(onlineState)) {
                    z3 = true;
                }
            }
        }
        if (z3) {
            a();
        }
    }

    @Override // com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback
    public void onError(Query query, Status status) {
        QueryListenersInfo queryListenersInfo = this.f30337b.get(query);
        if (queryListenersInfo != null) {
            for (QueryListener queryListener : queryListenersInfo.f30340a) {
                queryListener.onError(Util.exceptionFromStatus(status));
            }
        }
        this.f30337b.remove(query);
    }

    @Override // com.google.firebase.firestore.core.SyncEngine.SyncEngineCallback
    public void onViewSnapshots(List<ViewSnapshot> list) {
        boolean z3 = false;
        for (ViewSnapshot viewSnapshot : list) {
            QueryListenersInfo queryListenersInfo = this.f30337b.get(viewSnapshot.getQuery());
            if (queryListenersInfo != null) {
                for (QueryListener queryListener : queryListenersInfo.f30340a) {
                    if (queryListener.onViewSnapshot(viewSnapshot)) {
                        z3 = true;
                    }
                }
                queryListenersInfo.f30341b = viewSnapshot;
            }
        }
        if (z3) {
            a();
        }
    }

    public void removeQueryListener(QueryListener queryListener) {
        boolean z3;
        Query query = queryListener.getQuery();
        QueryListenersInfo queryListenersInfo = this.f30337b.get(query);
        if (queryListenersInfo != null) {
            queryListenersInfo.f30340a.remove(queryListener);
            z3 = queryListenersInfo.f30340a.isEmpty();
        } else {
            z3 = false;
        }
        if (z3) {
            this.f30337b.remove(query);
            this.f30336a.m(query);
        }
    }

    public void removeSnapshotsInSyncListener(EventListener<Void> eventListener) {
        this.f30338c.remove(eventListener);
    }
}
