package com.koushikdutta.async.util;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

/* loaded from: classes6.dex */
public class HashList<T> {

    /* renamed from: a  reason: collision with root package name */
    Hashtable<String, TaggedList<T>> f35686a = new Hashtable<>();

    /* JADX WARN: Multi-variable type inference failed */
    public synchronized void add(String str, T t3) {
        ArrayList<T> arrayList = get(str);
        if (arrayList == null) {
            arrayList = new TaggedList<>();
            this.f35686a.put(str, arrayList);
        }
        arrayList.add(t3);
    }

    public synchronized boolean contains(String str) {
        boolean z3;
        ArrayList<T> arrayList = get(str);
        if (arrayList != null) {
            if (arrayList.size() > 0) {
                z3 = true;
            }
        }
        z3 = false;
        return z3;
    }

    public synchronized ArrayList<T> get(String str) {
        return this.f35686a.get(str);
    }

    public Set<String> keySet() {
        return this.f35686a.keySet();
    }

    public synchronized T pop(String str) {
        TaggedList<T> taggedList = this.f35686a.get(str);
        if (taggedList == null) {
            return null;
        }
        if (taggedList.size() == 0) {
            return null;
        }
        return taggedList.remove(taggedList.size() - 1);
    }

    public synchronized ArrayList<T> remove(String str) {
        return this.f35686a.remove(str);
    }

    public synchronized boolean removeItem(String str, T t3) {
        TaggedList<T> taggedList = this.f35686a.get(str);
        boolean z3 = false;
        if (taggedList == null) {
            return false;
        }
        taggedList.remove(t3);
        if (taggedList.size() == 0) {
            z3 = true;
        }
        return z3;
    }

    public synchronized int size() {
        return this.f35686a.size();
    }

    public synchronized <V> V tag(String str) {
        TaggedList<T> taggedList = this.f35686a.get(str);
        if (taggedList == null) {
            return null;
        }
        return (V) taggedList.tag();
    }

    public synchronized <V> void tag(String str, V v3) {
        TaggedList<T> taggedList = this.f35686a.get(str);
        if (taggedList == null) {
            taggedList = new TaggedList<>();
            this.f35686a.put(str, taggedList);
        }
        taggedList.tag(v3);
    }
}
