package com.google.api.client.util.store;

import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;

/* loaded from: classes5.dex */
public abstract class AbstractDataStore<V extends Serializable> implements DataStore<V> {

    /* renamed from: a  reason: collision with root package name */
    private final DataStoreFactory f26166a;

    /* renamed from: b  reason: collision with root package name */
    private final String f26167b;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractDataStore(DataStoreFactory dataStoreFactory, String str) {
        this.f26166a = (DataStoreFactory) Preconditions.checkNotNull(dataStoreFactory);
        this.f26167b = (String) Preconditions.checkNotNull(str);
    }

    @Override // com.google.api.client.util.store.DataStore
    public boolean containsKey(String str) throws IOException {
        if (get(str) != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.client.util.store.DataStore
    public boolean containsValue(V v3) throws IOException {
        return values().contains(v3);
    }

    @Override // com.google.api.client.util.store.DataStore
    public DataStoreFactory getDataStoreFactory() {
        return this.f26166a;
    }

    @Override // com.google.api.client.util.store.DataStore
    public final String getId() {
        return this.f26167b;
    }

    @Override // com.google.api.client.util.store.DataStore
    public boolean isEmpty() throws IOException {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.api.client.util.store.DataStore
    public int size() throws IOException {
        return keySet().size();
    }
}
