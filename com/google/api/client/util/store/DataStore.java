package com.google.api.client.util.store;

import java.io.IOException;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/* loaded from: classes5.dex */
public interface DataStore<V extends Serializable> {
    DataStore<V> clear() throws IOException;

    boolean containsKey(String str) throws IOException;

    boolean containsValue(V v3) throws IOException;

    DataStore<V> delete(String str) throws IOException;

    V get(String str) throws IOException;

    DataStoreFactory getDataStoreFactory();

    String getId();

    boolean isEmpty() throws IOException;

    Set<String> keySet() throws IOException;

    DataStore<V> set(String str, V v3) throws IOException;

    int size() throws IOException;

    Collection<V> values() throws IOException;
}
