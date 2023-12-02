package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.e;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* compiled from: BaseKeyPool.java */
/* loaded from: classes3.dex */
abstract class b<T extends e> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f16868a = Util.createQueue(20);

    abstract T a();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T b() {
        T poll = this.f16868a.poll();
        if (poll == null) {
            return a();
        }
        return poll;
    }

    public void c(T t3) {
        if (this.f16868a.size() < 20) {
            this.f16868a.offer(t3);
        }
    }
}
