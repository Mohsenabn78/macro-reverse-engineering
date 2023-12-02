package com.bumptech.glide.load.engine;

import com.bumptech.glide.load.Key;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Jobs.java */
/* loaded from: classes3.dex */
final class m {

    /* renamed from: a  reason: collision with root package name */
    private final Map<Key, h<?>> f17053a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private final Map<Key, h<?>> f17054b = new HashMap();

    private Map<Key, h<?>> b(boolean z3) {
        if (z3) {
            return this.f17054b;
        }
        return this.f17053a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h<?> a(Key key, boolean z3) {
        return b(z3).get(key);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Key key, h<?> hVar) {
        b(hVar.m()).put(key, hVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(Key key, h<?> hVar) {
        Map<Key, h<?>> b4 = b(hVar.m());
        if (hVar.equals(b4.get(key))) {
            b4.remove(key);
        }
    }
}
