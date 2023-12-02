package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes5.dex */
public class MemoryDataStoreFactory extends AbstractDataStoreFactory {

    /* loaded from: classes5.dex */
    static class InstanceHolder {

        /* renamed from: a  reason: collision with root package name */
        static final MemoryDataStoreFactory f26176a = new MemoryDataStoreFactory();

        InstanceHolder() {
        }
    }

    /* loaded from: classes5.dex */
    static class MemoryDataStore<V extends Serializable> extends AbstractMemoryDataStore<V> {
        MemoryDataStore(MemoryDataStoreFactory memoryDataStoreFactory, String str) {
            super(memoryDataStoreFactory, str);
        }

        @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
        /* renamed from: b */
        public MemoryDataStoreFactory getDataStoreFactory() {
            return (MemoryDataStoreFactory) super.getDataStoreFactory();
        }
    }

    public static MemoryDataStoreFactory getDefaultInstance() {
        return InstanceHolder.f26176a;
    }

    @Override // com.google.api.client.util.store.AbstractDataStoreFactory
    protected <V extends Serializable> DataStore<V> a(String str) throws IOException {
        return new MemoryDataStore(this, str);
    }
}
