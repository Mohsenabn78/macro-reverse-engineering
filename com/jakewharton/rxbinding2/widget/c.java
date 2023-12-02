package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AdapterViewItemClickEventObservable.java */
/* loaded from: classes6.dex */
final class c extends Observable<AdapterViewItemClickEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34325a;

    /* compiled from: AdapterViewItemClickEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final AdapterView<?> f34326b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super AdapterViewItemClickEvent> f34327c;

        a(AdapterView<?> adapterView, Observer<? super AdapterViewItemClickEvent> observer) {
            this.f34326b = adapterView;
            this.f34327c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34326b.setOnItemClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                this.f34327c.onNext(AdapterViewItemClickEvent.create(adapterView, view, i4, j4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(AdapterView<?> adapterView) {
        this.f34325a = adapterView;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super AdapterViewItemClickEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34325a, observer);
        observer.onSubscribe(aVar);
        this.f34325a.setOnItemClickListener(aVar);
    }
}
