package com.google.api.client.util.store;

import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.regex.Pattern;

/* loaded from: classes5.dex */
public abstract class AbstractDataStoreFactory implements DataStoreFactory {

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f26168c = Pattern.compile("\\w{1,30}");

    /* renamed from: a  reason: collision with root package name */
    private final Lock f26169a = new ReentrantLock();

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, DataStore<? extends Serializable>> f26170b = Maps.newHashMap();

    protected abstract <V extends Serializable> DataStore<V> a(String str) throws IOException;

    @Override // com.google.api.client.util.store.DataStoreFactory
    public final <V extends Serializable> DataStore<V> getDataStore(String str) throws IOException {
        Pattern pattern = f26168c;
        Preconditions.checkArgument(pattern.matcher(str).matches(), "%s does not match pattern %s", str, pattern);
        this.f26169a.lock();
        try {
            DataStore<? extends Serializable> dataStore = this.f26170b.get(str);
            if (dataStore == null) {
                dataStore = a(str);
                this.f26170b.put(str, dataStore);
            }
            return dataStore;
        } finally {
            this.f26169a.unlock();
        }
    }
}
