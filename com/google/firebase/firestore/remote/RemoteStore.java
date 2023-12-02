package com.google.firebase.firestore.remote;

import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.AggregateField;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.core.OnlineState;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.core.Transaction;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.QueryPurpose;
import com.google.firebase.firestore.local.TargetData;
import com.google.firebase.firestore.model.DatabaseId;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.model.mutation.MutationBatch;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.model.mutation.MutationResult;
import com.google.firebase.firestore.remote.ConnectivityMonitor;
import com.google.firebase.firestore.remote.OnlineStateTracker;
import com.google.firebase.firestore.remote.RemoteStore;
import com.google.firebase.firestore.remote.WatchChange;
import com.google.firebase.firestore.remote.WatchChangeAggregator;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.firebase.firestore.remote.WriteStream;
import com.google.firebase.firestore.util.Assert;
import com.google.firebase.firestore.util.AsyncQueue;
import com.google.firebase.firestore.util.Consumer;
import com.google.firebase.firestore.util.Logger;
import com.google.firebase.firestore.util.Util;
import com.google.firestore.v1.Value;
import com.google.protobuf.ByteString;
import io.grpc.Status;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes5.dex */
public final class RemoteStore implements WatchChangeAggregator.TargetMetadataProvider {

    /* renamed from: a  reason: collision with root package name */
    private final RemoteStoreCallback f31148a;

    /* renamed from: b  reason: collision with root package name */
    private final LocalStore f31149b;

    /* renamed from: c  reason: collision with root package name */
    private final Datastore f31150c;

    /* renamed from: d  reason: collision with root package name */
    private final ConnectivityMonitor f31151d;

    /* renamed from: f  reason: collision with root package name */
    private final OnlineStateTracker f31153f;

    /* renamed from: h  reason: collision with root package name */
    private final WatchStream f31155h;

    /* renamed from: i  reason: collision with root package name */
    private final WriteStream f31156i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private WatchChangeAggregator f31157j;

    /* renamed from: g  reason: collision with root package name */
    private boolean f31154g = false;

    /* renamed from: e  reason: collision with root package name */
    private final Map<Integer, TargetData> f31152e = new HashMap();

    /* renamed from: k  reason: collision with root package name */
    private final Deque<MutationBatch> f31158k = new ArrayDeque();

    /* loaded from: classes5.dex */
    public interface RemoteStoreCallback {
        ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4);

        void handleOnlineStateChange(OnlineState onlineState);

        void handleRejectedListen(int i4, Status status);

        void handleRejectedWrite(int i4, Status status);

        void handleRemoteEvent(RemoteEvent remoteEvent);

        void handleSuccessfulWrite(MutationBatchResult mutationBatchResult);
    }

    public RemoteStore(final RemoteStoreCallback remoteStoreCallback, LocalStore localStore, Datastore datastore, final AsyncQueue asyncQueue, ConnectivityMonitor connectivityMonitor) {
        this.f31148a = remoteStoreCallback;
        this.f31149b = localStore;
        this.f31150c = datastore;
        this.f31151d = connectivityMonitor;
        Objects.requireNonNull(remoteStoreCallback);
        this.f31153f = new OnlineStateTracker(asyncQueue, new OnlineStateTracker.OnlineStateCallback() { // from class: com.google.firebase.firestore.remote.x
            @Override // com.google.firebase.firestore.remote.OnlineStateTracker.OnlineStateCallback
            public final void handleOnlineStateChange(OnlineState onlineState) {
                RemoteStore.RemoteStoreCallback.this.handleOnlineStateChange(onlineState);
            }
        });
        this.f31155h = datastore.e(new WatchStream.Callback() { // from class: com.google.firebase.firestore.remote.RemoteStore.1
            @Override // com.google.firebase.firestore.remote.WatchStream.Callback
            public void a(SnapshotVersion snapshotVersion, WatchChange watchChange) {
                RemoteStore.this.n(snapshotVersion, watchChange);
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onClose(Status status) {
                RemoteStore.this.o(status);
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onOpen() {
                RemoteStore.this.p();
            }
        });
        this.f31156i = datastore.f(new WriteStream.Callback() { // from class: com.google.firebase.firestore.remote.RemoteStore.2
            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onClose(Status status) {
                RemoteStore.this.s(status);
            }

            @Override // com.google.firebase.firestore.remote.WriteStream.Callback
            public void onHandshakeComplete() {
                RemoteStore.this.t();
            }

            @Override // com.google.firebase.firestore.remote.Stream.StreamCallback
            public void onOpen() {
                RemoteStore.this.f31156i.v();
            }

            @Override // com.google.firebase.firestore.remote.WriteStream.Callback
            public void onWriteResponse(SnapshotVersion snapshotVersion, List<MutationResult> list) {
                RemoteStore.this.u(snapshotVersion, list);
            }
        });
        connectivityMonitor.addCallback(new Consumer() { // from class: com.google.firebase.firestore.remote.y
            @Override // com.google.firebase.firestore.util.Consumer
            public final void accept(Object obj) {
                RemoteStore.this.w(asyncQueue, (ConnectivityMonitor.NetworkStatus) obj);
            }
        });
    }

    private void A(int i4) {
        this.f31157j.k(i4);
        this.f31155h.unwatchTarget(i4);
    }

    private void B(TargetData targetData) {
        this.f31157j.k(targetData.getTargetId());
        if (!targetData.getResumeToken().isEmpty() || targetData.getSnapshotVersion().compareTo(SnapshotVersion.NONE) > 0) {
            targetData = targetData.withExpectedCount(Integer.valueOf(getRemoteKeysForTarget(targetData.getTargetId()).size()));
        }
        this.f31155h.watchQuery(targetData);
    }

    private boolean C() {
        if (canUseNetwork() && !this.f31155h.isStarted() && !this.f31152e.isEmpty()) {
            return true;
        }
        return false;
    }

    private boolean D() {
        if (canUseNetwork() && !this.f31156i.isStarted() && !this.f31158k.isEmpty()) {
            return true;
        }
        return false;
    }

    private void E() {
        Assert.hardAssert(C(), "startWatchStream() called when shouldStartWatchStream() is false.", new Object[0]);
        this.f31157j = new WatchChangeAggregator(this);
        this.f31155h.start();
        this.f31153f.e();
    }

    private void F() {
        Assert.hardAssert(D(), "startWriteStream() called when shouldStartWriteStream() is false.", new Object[0]);
        this.f31156i.start();
    }

    private void j(MutationBatch mutationBatch) {
        Assert.hardAssert(k(), "addToWritePipeline called when pipeline is full", new Object[0]);
        this.f31158k.add(mutationBatch);
        if (this.f31156i.isOpen() && this.f31156i.t()) {
            this.f31156i.w(mutationBatch.getMutations());
        }
    }

    private boolean k() {
        if (canUseNetwork() && this.f31158k.size() < 10) {
            return true;
        }
        return false;
    }

    private void l() {
        this.f31157j = null;
    }

    private void m() {
        this.f31155h.stop();
        this.f31156i.stop();
        if (!this.f31158k.isEmpty()) {
            Logger.debug("RemoteStore", "Stopping write stream with %d pending writes", Integer.valueOf(this.f31158k.size()));
            this.f31158k.clear();
        }
        l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(SnapshotVersion snapshotVersion, WatchChange watchChange) {
        boolean z3;
        WatchChange.WatchTargetChange watchTargetChange;
        this.f31153f.i(OnlineState.ONLINE);
        if (this.f31155h != null && this.f31157j != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "WatchStream and WatchStreamAggregator should both be non-null", new Object[0]);
        boolean z4 = watchChange instanceof WatchChange.WatchTargetChange;
        if (z4) {
            watchTargetChange = (WatchChange.WatchTargetChange) watchChange;
        } else {
            watchTargetChange = null;
        }
        if (watchTargetChange != null && watchTargetChange.getChangeType().equals(WatchChange.WatchTargetChangeType.Removed) && watchTargetChange.getCause() != null) {
            x(watchTargetChange);
            return;
        }
        if (watchChange instanceof WatchChange.DocumentChange) {
            this.f31157j.handleDocumentChange((WatchChange.DocumentChange) watchChange);
        } else if (watchChange instanceof WatchChange.ExistenceFilterWatchChange) {
            this.f31157j.handleExistenceFilter((WatchChange.ExistenceFilterWatchChange) watchChange);
        } else {
            Assert.hardAssert(z4, "Expected watchChange to be an instance of WatchTargetChange", new Object[0]);
            this.f31157j.handleTargetChange((WatchChange.WatchTargetChange) watchChange);
        }
        if (!snapshotVersion.equals(SnapshotVersion.NONE) && snapshotVersion.compareTo(this.f31149b.getLastRemoteSnapshotVersion()) >= 0) {
            y(snapshotVersion);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(Status status) {
        if (status.isOk()) {
            Assert.hardAssert(!C(), "Watch stream was stopped gracefully while still needed.", new Object[0]);
        }
        l();
        if (C()) {
            this.f31153f.d(status);
            E();
            return;
        }
        this.f31153f.i(OnlineState.UNKNOWN);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        for (TargetData targetData : this.f31152e.values()) {
            B(targetData);
        }
    }

    private void q(Status status) {
        Assert.hardAssert(!status.isOk(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentWriteError(status)) {
            this.f31156i.inhibitBackoff();
            this.f31148a.handleRejectedWrite(this.f31158k.poll().getBatchId(), status);
            fillWritePipeline();
        }
    }

    private void r(Status status) {
        Assert.hardAssert(!status.isOk(), "Handling write error with status OK.", new Object[0]);
        if (Datastore.isPermanentError(status)) {
            Logger.debug("RemoteStore", "RemoteStore error before completed handshake; resetting stream token %s: %s", Util.toDebugString(this.f31156i.s()), status);
            WriteStream writeStream = this.f31156i;
            ByteString byteString = WriteStream.EMPTY_STREAM_TOKEN;
            writeStream.u(byteString);
            this.f31149b.setLastStreamToken(byteString);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void s(Status status) {
        if (status.isOk()) {
            Assert.hardAssert(!D(), "Write stream was stopped gracefully while still needed.", new Object[0]);
        }
        if (!status.isOk() && !this.f31158k.isEmpty()) {
            if (this.f31156i.t()) {
                q(status);
            } else {
                r(status);
            }
        }
        if (D()) {
            F();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        this.f31149b.setLastStreamToken(this.f31156i.s());
        for (MutationBatch mutationBatch : this.f31158k) {
            this.f31156i.w(mutationBatch.getMutations());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(SnapshotVersion snapshotVersion, List<MutationResult> list) {
        this.f31148a.handleSuccessfulWrite(MutationBatchResult.create(this.f31158k.poll(), snapshotVersion, list, this.f31156i.s()));
        fillWritePipeline();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v(ConnectivityMonitor.NetworkStatus networkStatus) {
        if (networkStatus.equals(ConnectivityMonitor.NetworkStatus.REACHABLE) && this.f31153f.c().equals(OnlineState.ONLINE)) {
            return;
        }
        if ((networkStatus.equals(ConnectivityMonitor.NetworkStatus.UNREACHABLE) && this.f31153f.c().equals(OnlineState.OFFLINE)) || !canUseNetwork()) {
            return;
        }
        Logger.debug("RemoteStore", "Restarting streams for network reachability change.", new Object[0]);
        z();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(AsyncQueue asyncQueue, final ConnectivityMonitor.NetworkStatus networkStatus) {
        asyncQueue.enqueueAndForget(new Runnable() { // from class: com.google.firebase.firestore.remote.z
            @Override // java.lang.Runnable
            public final void run() {
                RemoteStore.this.v(networkStatus);
            }
        });
    }

    private void x(WatchChange.WatchTargetChange watchTargetChange) {
        boolean z3;
        if (watchTargetChange.getCause() != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Processing target error without a cause", new Object[0]);
        for (Integer num : watchTargetChange.getTargetIds()) {
            if (this.f31152e.containsKey(num)) {
                this.f31152e.remove(num);
                this.f31157j.m(num.intValue());
                this.f31148a.handleRejectedListen(num.intValue(), watchTargetChange.getCause());
            }
        }
    }

    private void y(SnapshotVersion snapshotVersion) {
        Assert.hardAssert(!snapshotVersion.equals(SnapshotVersion.NONE), "Can't raise event for unknown SnapshotVersion", new Object[0]);
        RemoteEvent createRemoteEvent = this.f31157j.createRemoteEvent(snapshotVersion);
        for (Map.Entry<Integer, TargetChange> entry : createRemoteEvent.getTargetChanges().entrySet()) {
            TargetChange value = entry.getValue();
            if (!value.getResumeToken().isEmpty()) {
                int intValue = entry.getKey().intValue();
                TargetData targetData = this.f31152e.get(Integer.valueOf(intValue));
                if (targetData != null) {
                    this.f31152e.put(Integer.valueOf(intValue), targetData.withResumeToken(value.getResumeToken(), snapshotVersion));
                }
            }
        }
        for (Map.Entry<Integer, QueryPurpose> entry2 : createRemoteEvent.getTargetMismatches().entrySet()) {
            int intValue2 = entry2.getKey().intValue();
            TargetData targetData2 = this.f31152e.get(Integer.valueOf(intValue2));
            if (targetData2 != null) {
                this.f31152e.put(Integer.valueOf(intValue2), targetData2.withResumeToken(ByteString.EMPTY, targetData2.getSnapshotVersion()));
                A(intValue2);
                B(new TargetData(targetData2.getTarget(), intValue2, targetData2.getSequenceNumber(), entry2.getValue()));
            }
        }
        this.f31148a.handleRemoteEvent(createRemoteEvent);
    }

    private void z() {
        this.f31154g = false;
        m();
        this.f31153f.i(OnlineState.UNKNOWN);
        this.f31156i.inhibitBackoff();
        this.f31155h.inhibitBackoff();
        enableNetwork();
    }

    public boolean canUseNetwork() {
        return this.f31154g;
    }

    public Transaction createTransaction() {
        return new Transaction(this.f31150c);
    }

    public void disableNetwork() {
        this.f31154g = false;
        m();
        this.f31153f.i(OnlineState.OFFLINE);
    }

    public void enableNetwork() {
        this.f31154g = true;
        if (canUseNetwork()) {
            this.f31156i.u(this.f31149b.getLastStreamToken());
            if (C()) {
                E();
            } else {
                this.f31153f.i(OnlineState.UNKNOWN);
            }
            fillWritePipeline();
        }
    }

    public void fillWritePipeline() {
        int batchId;
        if (this.f31158k.isEmpty()) {
            batchId = -1;
        } else {
            batchId = this.f31158k.getLast().getBatchId();
        }
        while (true) {
            if (!k()) {
                break;
            }
            MutationBatch nextMutationBatch = this.f31149b.getNextMutationBatch(batchId);
            if (nextMutationBatch == null) {
                if (this.f31158k.size() == 0) {
                    this.f31156i.n();
                }
            } else {
                j(nextMutationBatch);
                batchId = nextMutationBatch.getBatchId();
            }
        }
        if (D()) {
            F();
        }
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    public DatabaseId getDatabaseId() {
        return this.f31150c.g().getDatabaseId();
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4) {
        return this.f31148a.getRemoteKeysForTarget(i4);
    }

    @Override // com.google.firebase.firestore.remote.WatchChangeAggregator.TargetMetadataProvider
    @Nullable
    public TargetData getTargetDataForTarget(int i4) {
        return this.f31152e.get(Integer.valueOf(i4));
    }

    public void handleCredentialChange() {
        if (canUseNetwork()) {
            Logger.debug("RemoteStore", "Restarting streams for new credential.", new Object[0]);
            z();
        }
    }

    public void listen(TargetData targetData) {
        Integer valueOf = Integer.valueOf(targetData.getTargetId());
        if (this.f31152e.containsKey(valueOf)) {
            return;
        }
        this.f31152e.put(valueOf, targetData);
        if (C()) {
            E();
        } else if (this.f31155h.isOpen()) {
            B(targetData);
        }
    }

    public Task<Map<String, Value>> runAggregateQuery(Query query, List<AggregateField> list) {
        if (canUseNetwork()) {
            return this.f31150c.runAggregateQuery(query, list);
        }
        return Tasks.forException(new FirebaseFirestoreException("Failed to get result from server.", FirebaseFirestoreException.Code.UNAVAILABLE));
    }

    public void shutdown() {
        Logger.debug("RemoteStore", "Shutting down", new Object[0]);
        this.f31151d.shutdown();
        this.f31154g = false;
        m();
        this.f31150c.k();
        this.f31153f.i(OnlineState.UNKNOWN);
    }

    public void start() {
        enableNetwork();
    }

    public void stopListening(int i4) {
        boolean z3;
        if (this.f31152e.remove(Integer.valueOf(i4)) != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "stopListening called on target no currently watched: %d", Integer.valueOf(i4));
        if (this.f31155h.isOpen()) {
            A(i4);
        }
        if (this.f31152e.isEmpty()) {
            if (this.f31155h.isOpen()) {
                this.f31155h.n();
            } else if (canUseNetwork()) {
                this.f31153f.i(OnlineState.UNKNOWN);
            }
        }
    }
}
