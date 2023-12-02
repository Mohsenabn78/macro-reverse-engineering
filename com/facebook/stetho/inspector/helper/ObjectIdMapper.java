package com.facebook.stetho.inspector.helper;

import android.util.SparseArray;
import java.util.IdentityHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes3.dex */
public class ObjectIdMapper {
    protected final Object mSync = new Object();
    @GuardedBy("mSync")
    private int mNextId = 1;
    @GuardedBy("mSync")
    private final Map<Object, Integer> mObjectToIdMap = new IdentityHashMap();
    @GuardedBy("mSync")
    private SparseArray<Object> mIdToObjectMap = new SparseArray<>();

    public void clear() {
        SparseArray<Object> sparseArray;
        synchronized (this.mSync) {
            sparseArray = this.mIdToObjectMap;
            this.mObjectToIdMap.clear();
            this.mIdToObjectMap = new SparseArray<>();
        }
        int size = sparseArray.size();
        for (int i4 = 0; i4 < size; i4++) {
            onUnmapped(sparseArray.valueAt(i4), sparseArray.keyAt(i4));
        }
    }

    public boolean containsId(int i4) {
        boolean z3;
        synchronized (this.mSync) {
            if (this.mIdToObjectMap.get(i4) != null) {
                z3 = true;
            } else {
                z3 = false;
            }
        }
        return z3;
    }

    public boolean containsObject(Object obj) {
        boolean containsKey;
        synchronized (this.mSync) {
            containsKey = this.mObjectToIdMap.containsKey(obj);
        }
        return containsKey;
    }

    @Nullable
    public Integer getIdForObject(Object obj) {
        Integer num;
        synchronized (this.mSync) {
            num = this.mObjectToIdMap.get(obj);
        }
        return num;
    }

    @Nullable
    public Object getObjectForId(int i4) {
        Object obj;
        synchronized (this.mSync) {
            obj = this.mIdToObjectMap.get(i4);
        }
        return obj;
    }

    public int putObject(Object obj) {
        synchronized (this.mSync) {
            Integer num = this.mObjectToIdMap.get(obj);
            if (num != null) {
                return num.intValue();
            }
            int i4 = this.mNextId;
            this.mNextId = i4 + 1;
            Integer valueOf = Integer.valueOf(i4);
            this.mObjectToIdMap.put(obj, valueOf);
            this.mIdToObjectMap.put(valueOf.intValue(), obj);
            onMapped(obj, valueOf.intValue());
            return valueOf.intValue();
        }
    }

    @Nullable
    public Integer removeObject(Object obj) {
        synchronized (this.mSync) {
            Integer remove = this.mObjectToIdMap.remove(obj);
            if (remove == null) {
                return null;
            }
            this.mIdToObjectMap.remove(remove.intValue());
            onUnmapped(obj, remove.intValue());
            return remove;
        }
    }

    @Nullable
    public Object removeObjectById(int i4) {
        synchronized (this.mSync) {
            Object obj = this.mIdToObjectMap.get(i4);
            if (obj == null) {
                return null;
            }
            this.mIdToObjectMap.remove(i4);
            this.mObjectToIdMap.remove(obj);
            onUnmapped(obj, i4);
            return obj;
        }
    }

    public int size() {
        int size;
        synchronized (this.mSync) {
            size = this.mObjectToIdMap.size();
        }
        return size;
    }

    protected void onMapped(Object obj, int i4) {
    }

    protected void onUnmapped(Object obj, int i4) {
    }
}
