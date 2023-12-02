package com.koushikdutta.async.util;

import java.util.ArrayList;

/* loaded from: classes6.dex */
public class TaggedList<T> extends ArrayList<T> {
    private Object tag;

    public synchronized <V> V tag() {
        return (V) this.tag;
    }

    public synchronized <V> void tagNull(V v3) {
        if (this.tag == null) {
            this.tag = v3;
        }
    }

    public synchronized <V> void tag(V v3) {
        this.tag = v3;
    }
}
