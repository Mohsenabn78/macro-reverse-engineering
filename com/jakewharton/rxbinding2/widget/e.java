package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;
import io.reactivex.functions.Predicate;

/* compiled from: AdapterViewItemLongClickEventObservable.java */
/* loaded from: classes6.dex */
final class e extends Observable<AdapterViewItemLongClickEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34337a;

    /* renamed from: b  reason: collision with root package name */
    private final Predicate<? super AdapterViewItemLongClickEvent> f34338b;

    /* compiled from: AdapterViewItemLongClickEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemLongClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final AdapterView<?> f34339b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super AdapterViewItemLongClickEvent> f34340c;

        /* renamed from: d  reason: collision with root package name */
        private final Predicate<? super AdapterViewItemLongClickEvent> f34341d;

        a(AdapterView<?> adapterView, Observer<? super AdapterViewItemLongClickEvent> observer, Predicate<? super AdapterViewItemLongClickEvent> predicate) {
            this.f34339b = adapterView;
            this.f34340c = observer;
            this.f34341d = predicate;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34339b.setOnItemLongClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemLongClickListener
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                AdapterViewItemLongClickEvent create = AdapterViewItemLongClickEvent.create(adapterView, view, i4, j4);
                try {
                    if (this.f34341d.test(create)) {
                        this.f34340c.onNext(create);
                        return true;
                    }
                    return false;
                } catch (Exception e4) {
                    this.f34340c.onError(e4);
                    dispose();
                    return false;
                }
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(AdapterView<?> adapterView, Predicate<? super AdapterViewItemLongClickEvent> predicate) {
        this.f34337a = adapterView;
        this.f34338b = predicate;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super AdapterViewItemLongClickEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34337a, observer, this.f34338b);
        observer.onSubscribe(aVar);
        this.f34337a.setOnItemLongClickListener(aVar);
    }
}
