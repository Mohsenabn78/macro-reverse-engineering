package com.google.api.client.util.store;

import com.google.api.client.util.IOUtils;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Maps;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
class AbstractMemoryDataStore<V extends Serializable> extends AbstractDataStore<V> {

    /* renamed from: c  reason: collision with root package name */
    private final Lock f26171c;

    /* renamed from: d  reason: collision with root package name */
    HashMap<String, byte[]> f26172d;

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractMemoryDataStore(DataStoreFactory dataStoreFactory, String str) {
        super(dataStoreFactory, str);
        this.f26171c = new ReentrantLock();
        this.f26172d = Maps.newHashMap();
    }

    @Override // com.google.api.client.util.store.DataStore
    public final DataStore<V> clear() throws IOException {
        this.f26171c.lock();
        try {
            this.f26172d.clear();
            a();
            return this;
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public boolean containsKey(String str) throws IOException {
        if (str == null) {
            return false;
        }
        this.f26171c.lock();
        try {
            return this.f26172d.containsKey(str);
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public boolean containsValue(V v3) throws IOException {
        if (v3 == null) {
            return false;
        }
        this.f26171c.lock();
        try {
            byte[] serialize = IOUtils.serialize(v3);
            for (byte[] bArr : this.f26172d.values()) {
                if (Arrays.equals(serialize, bArr)) {
                    this.f26171c.unlock();
                    return true;
                }
            }
            return false;
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public DataStore<V> delete(String str) throws IOException {
        if (str == null) {
            return this;
        }
        this.f26171c.lock();
        try {
            this.f26172d.remove(str);
            a();
            return this;
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final V get(String str) throws IOException {
        if (str == null) {
            return null;
        }
        this.f26171c.lock();
        try {
            return (V) IOUtils.deserialize(this.f26172d.get(str));
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public boolean isEmpty() throws IOException {
        this.f26171c.lock();
        try {
            return this.f26172d.isEmpty();
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Set<String> keySet() throws IOException {
        this.f26171c.lock();
        try {
            return Collections.unmodifiableSet(this.f26172d.keySet());
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.DataStore
    public final DataStore<V> set(String str, V v3) throws IOException {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(v3);
        this.f26171c.lock();
        try {
            this.f26172d.put(str, IOUtils.serialize(v3));
            a();
            return this;
        } finally {
            this.f26171c.unlock();
        }
    }

    @Override // com.google.api.client.util.store.AbstractDataStore, com.google.api.client.util.store.DataStore
    public int size() throws IOException {
        this.f26171c.lock();
        try {
            return this.f26172d.size();
        } finally {
            this.f26171c.unlock();
        }
    }

    public String toString() {
        return DataStoreUtils.toString(this);
    }

    @Override // com.google.api.client.util.store.DataStore
    public final Collection<V> values() throws IOException {
        this.f26171c.lock();
        try {
            ArrayList newArrayList = Lists.newArrayList();
            for (byte[] bArr : this.f26172d.values()) {
                newArrayList.add(IOUtils.deserialize(bArr));
            }
            return Collections.unmodifiableList(newArrayList);
        } finally {
            this.f26171c.unlock();
        }
    }

    void a() throws IOException {
    }
}
