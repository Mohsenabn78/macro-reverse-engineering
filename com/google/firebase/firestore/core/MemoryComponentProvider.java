package com.google.firebase.firestore.core;

import androidx.annotation.Nullable;
import com.google.firebase.database.collection.ImmutableSortedSet;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.MemoryCacheSettings;
import com.google.firebase.firestore.MemoryLruGcSettings;
import com.google.firebase.firestore.core.ComponentProvider;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LocalStore;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.MemoryPersistence;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.QueryEngine;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.model.DocumentKey;
import com.google.firebase.firestore.model.mutation.MutationBatchResult;
import com.google.firebase.firestore.remote.AndroidConnectivityMonitor;
import com.google.firebase.firestore.remote.RemoteEvent;
import com.google.firebase.firestore.remote.RemoteSerializer;
import com.google.firebase.firestore.remote.RemoteStore;
import io.grpc.Status;

/* loaded from: classes5.dex */
public class MemoryComponentProvider extends ComponentProvider {

    /* loaded from: classes5.dex */
    private class RemoteStoreCallback implements RemoteStore.RemoteStoreCallback {
        private RemoteStoreCallback() {
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public ImmutableSortedSet<DocumentKey> getRemoteKeysForTarget(int i4) {
            return MemoryComponentProvider.this.getSyncEngine().getRemoteKeysForTarget(i4);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleOnlineStateChange(OnlineState onlineState) {
            MemoryComponentProvider.this.getSyncEngine().handleOnlineStateChange(onlineState);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleRejectedListen(int i4, Status status) {
            MemoryComponentProvider.this.getSyncEngine().handleRejectedListen(i4, status);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleRejectedWrite(int i4, Status status) {
            MemoryComponentProvider.this.getSyncEngine().handleRejectedWrite(i4, status);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleRemoteEvent(RemoteEvent remoteEvent) {
            MemoryComponentProvider.this.getSyncEngine().handleRemoteEvent(remoteEvent);
        }

        @Override // com.google.firebase.firestore.remote.RemoteStore.RemoteStoreCallback
        public void handleSuccessfulWrite(MutationBatchResult mutationBatchResult) {
            MemoryComponentProvider.this.getSyncEngine().handleSuccessfulWrite(mutationBatchResult);
        }
    }

    private boolean k(FirebaseFirestoreSettings firebaseFirestoreSettings) {
        if (firebaseFirestoreSettings.getCacheSettings() != null && (firebaseFirestoreSettings.getCacheSettings() instanceof MemoryCacheSettings)) {
            return ((MemoryCacheSettings) firebaseFirestoreSettings.getCacheSettings()).getGarbageCollectorSettings() instanceof MemoryLruGcSettings;
        }
        return false;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected EventManager b(ComponentProvider.Configuration configuration) {
        return new EventManager(getSyncEngine());
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    @Nullable
    protected Scheduler c(ComponentProvider.Configuration configuration) {
        return null;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    @Nullable
    protected IndexBackfiller d(ComponentProvider.Configuration configuration) {
        return null;
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected LocalStore e(ComponentProvider.Configuration configuration) {
        return new LocalStore(getPersistence(), new QueryEngine(), configuration.e());
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected Persistence f(ComponentProvider.Configuration configuration) {
        if (k(configuration.g())) {
            return MemoryPersistence.createLruGcMemoryPersistence(LruGarbageCollector.Params.WithCacheSizeBytes(configuration.g().getCacheSizeBytes()), new LocalSerializer(new RemoteSerializer(configuration.c().getDatabaseId())));
        }
        return MemoryPersistence.createEagerGcMemoryPersistence();
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected RemoteStore g(ComponentProvider.Configuration configuration) {
        return new RemoteStore(new RemoteStoreCallback(), getLocalStore(), configuration.d(), configuration.a(), i());
    }

    @Override // com.google.firebase.firestore.core.ComponentProvider
    protected SyncEngine h(ComponentProvider.Configuration configuration) {
        return new SyncEngine(getLocalStore(), getRemoteStore(), configuration.e(), configuration.f());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.firebase.firestore.core.ComponentProvider
    /* renamed from: j */
    public AndroidConnectivityMonitor a(ComponentProvider.Configuration configuration) {
        return new AndroidConnectivityMonitor(configuration.b());
    }
}
