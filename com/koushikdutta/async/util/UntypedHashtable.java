package com.koushikdutta.async.util;

import java.util.Hashtable;

/* loaded from: classes6.dex */
public class UntypedHashtable {

    /* renamed from: a  reason: collision with root package name */
    private Hashtable<String, Object> f35695a = new Hashtable<>();

    public <T> T get(String str, T t3) {
        T t4 = (T) get(str);
        return t4 == null ? t3 : t4;
    }

    public void put(String str, Object obj) {
        this.f35695a.put(str, obj);
    }

    public void remove(String str) {
        this.f35695a.remove(str);
    }

    public <T> T get(String str) {
        return (T) this.f35695a.get(str);
    }
}
