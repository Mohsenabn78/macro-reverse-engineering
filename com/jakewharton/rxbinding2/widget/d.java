package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AdapterViewItemClickObservable.java */
/* loaded from: classes6.dex */
final class d extends Observable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34331a;

    /* compiled from: AdapterViewItemClickObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final AdapterView<?> f34332b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Integer> f34333c;

        a(AdapterView<?> adapterView, Observer<? super Integer> observer) {
            this.f34332b = adapterView;
            this.f34333c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34332b.setOnItemClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                this.f34333c.onNext(Integer.valueOf(i4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(AdapterView<?> adapterView) {
        this.f34331a = adapterView;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34331a, observer);
        observer.onSubscribe(aVar);
        this.f34331a.setOnItemClickListener(aVar);
    }
}
