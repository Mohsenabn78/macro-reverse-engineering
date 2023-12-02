package com.koushikdutta.async.future;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes6.dex */
public class MultiFuture<T> extends SimpleFuture<T> {

    /* renamed from: i  reason: collision with root package name */
    ArrayList<FutureCallback<T>> f34881i;

    /* renamed from: j  reason: collision with root package name */
    final FutureCallback<T> f34882j = new a();

    /* loaded from: classes6.dex */
    class a implements FutureCallback<T> {
        a() {
        }

        @Override // com.koushikdutta.async.future.FutureCallback
        public void onCompleted(Exception exc, T t3) {
            ArrayList<FutureCallback<T>> arrayList;
            synchronized (MultiFuture.this) {
                MultiFuture multiFuture = MultiFuture.this;
                arrayList = multiFuture.f34881i;
                multiFuture.f34881i = null;
            }
            if (arrayList == null) {
                return;
            }
            Iterator<FutureCallback<T>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onCompleted(exc, t3);
            }
        }
    }

    @Override // com.koushikdutta.async.future.SimpleFuture, com.koushikdutta.async.future.Future
    public MultiFuture<T> setCallback(FutureCallback<T> futureCallback) {
        synchronized (this) {
            if (this.f34881i == null) {
                this.f34881i = new ArrayList<>();
            }
            this.f34881i.add(futureCallback);
        }
        super.setCallback((FutureCallback) this.f34882j);
        return this;
    }
}
