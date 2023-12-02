package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AutoCompleteTextViewItemClickEventObservable.java */
/* loaded from: classes6.dex */
final class i extends Observable<AdapterViewItemClickEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final AutoCompleteTextView f34367a;

    /* compiled from: AutoCompleteTextViewItemClickEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemClickListener {

        /* renamed from: b  reason: collision with root package name */
        private final AutoCompleteTextView f34368b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super AdapterViewItemClickEvent> f34369c;

        a(AutoCompleteTextView autoCompleteTextView, Observer<? super AdapterViewItemClickEvent> observer) {
            this.f34368b = autoCompleteTextView;
            this.f34369c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34368b.setOnItemClickListener(null);
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                this.f34369c.onNext(AdapterViewItemClickEvent.create(adapterView, view, i4, j4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(AutoCompleteTextView autoCompleteTextView) {
        this.f34367a = autoCompleteTextView;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super AdapterViewItemClickEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34367a, observer);
        observer.onSubscribe(aVar);
        this.f34367a.setOnItemClickListener(aVar);
    }
}
