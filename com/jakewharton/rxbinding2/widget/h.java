package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AdapterViewSelectionObservable.java */
/* loaded from: classes6.dex */
final class h extends InitialValueObservable<AdapterViewSelectionEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34361a;

    /* compiled from: AdapterViewSelectionObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        private final AdapterView<?> f34362b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super AdapterViewSelectionEvent> f34363c;

        a(AdapterView<?> adapterView, Observer<? super AdapterViewSelectionEvent> observer) {
            this.f34362b = adapterView;
            this.f34363c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34362b.setOnItemSelectedListener(null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                this.f34363c.onNext(AdapterViewItemSelectionEvent.create(adapterView, view, i4, j4));
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (!isDisposed()) {
                this.f34363c.onNext(AdapterViewNothingSelectionEvent.create(adapterView));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(AdapterView<?> adapterView) {
        this.f34361a = adapterView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super AdapterViewSelectionEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34361a, observer);
        this.f34361a.setOnItemSelectedListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public AdapterViewSelectionEvent d() {
        int selectedItemPosition = this.f34361a.getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return AdapterViewNothingSelectionEvent.create(this.f34361a);
        }
        return AdapterViewItemSelectionEvent.create(this.f34361a, this.f34361a.getSelectedView(), selectedItemPosition, this.f34361a.getSelectedItemId());
    }
}
