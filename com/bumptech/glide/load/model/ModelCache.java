package com.bumptech.glide.load.model;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.LruCache;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: classes3.dex */
public class ModelCache<A, B> {

    /* renamed from: a  reason: collision with root package name */
    private final LruCache<b<A>, B> f17158a;

    /* loaded from: classes3.dex */
    class a extends LruCache<b<A>, B> {
        a(long j4) {
            super(j4);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.bumptech.glide.util.LruCache
        /* renamed from: e */
        public void c(@NonNull b<A> bVar, @Nullable B b4) {
            bVar.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    /* loaded from: classes3.dex */
    public static final class b<A> {

        /* renamed from: d  reason: collision with root package name */
        private static final Queue<b<?>> f17160d = Util.createQueue(0);

        /* renamed from: a  reason: collision with root package name */
        private int f17161a;

        /* renamed from: b  reason: collision with root package name */
        private int f17162b;

        /* renamed from: c  reason: collision with root package name */
        private A f17163c;

        private b() {
        }

        static <A> b<A> a(A a4, int i4, int i5) {
            b<A> bVar;
            Queue<b<?>> queue = f17160d;
            synchronized (queue) {
                bVar = (b<A>) queue.poll();
            }
            if (bVar == null) {
                bVar = new b<>();
            }
            bVar.b(a4, i4, i5);
            return bVar;
        }

        private void b(A a4, int i4, int i5) {
            this.f17163c = a4;
            this.f17162b = i4;
            this.f17161a = i5;
        }

        public void c() {
            Queue<b<?>> queue = f17160d;
            synchronized (queue) {
                queue.offer(this);
            }
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f17162b != bVar.f17162b || this.f17161a != bVar.f17161a || !this.f17163c.equals(bVar.f17163c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f17161a * 31) + this.f17162b) * 31) + this.f17163c.hashCode();
        }
    }

    public ModelCache() {
        this(250L);
    }

    public void clear() {
        this.f17158a.clearMemory();
    }

    @Nullable
    public B get(A a4, int i4, int i5) {
        b<A> a5 = b.a(a4, i4, i5);
        B b4 = this.f17158a.get(a5);
        a5.c();
        return b4;
    }

    public void put(A a4, int i4, int i5, B b4) {
        this.f17158a.put(b.a(a4, i4, i5), b4);
    }

    public ModelCache(long j4) {
        this.f17158a = new a(j4);
    }
}
