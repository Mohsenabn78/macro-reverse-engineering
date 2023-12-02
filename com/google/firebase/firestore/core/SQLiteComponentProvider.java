package com.google.firebase.firestore.core;

import com.google.firebase.firestore.core.ComponentProvider;
import com.google.firebase.firestore.local.IndexBackfiller;
import com.google.firebase.firestore.local.LocalSerializer;
import com.google.firebase.firestore.local.LruGarbageCollector;
import com.google.firebase.firestore.local.Persistence;
import com.google.firebase.firestore.local.SQLitePersistence;
import com.google.firebase.firestore.local.Scheduler;
import com.google.firebase.firestore.remote.RemoteSerializer;

/* loaded from: classes5.dex */
public class SQLiteComponentProvider extends MemoryComponentProvider {
    @Override // com.google.firebase.firestore.core.MemoryComponentProvider, com.google.firebase.firestore.core.ComponentProvider
    protected Scheduler c(ComponentProvider.Configuration configuration) {
        return ((SQLitePersistence) getPersistence()).getReferenceDelegate().getGarbageCollector().newScheduler(configuration.a(), getLocalStore());
    }

    @Override // com.google.firebase.firestore.core.MemoryComponentProvider, com.google.firebase.firestore.core.ComponentProvider
    protected IndexBackfiller d(ComponentProvider.Configuration configuration) {
        return new IndexBackfiller(getPersistence(), configuration.a(), getLocalStore());
    }

    @Override // com.google.firebase.firestore.core.MemoryComponentProvider, com.google.firebase.firestore.core.ComponentProvider
    protected Persistence f(ComponentProvider.Configuration configuration) {
        return new SQLitePersistence(configuration.b(), configuration.c().getPersistenceKey(), configuration.c().getDatabaseId(), new LocalSerializer(new RemoteSerializer(configuration.c().getDatabaseId())), LruGarbageCollector.Params.WithCacheSizeBytes(configuration.g().getCacheSizeBytes()));
    }
}
