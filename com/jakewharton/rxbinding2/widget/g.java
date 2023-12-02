package com.jakewharton.rxbinding2.widget;

import android.view.View;
import android.widget.AdapterView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: AdapterViewItemSelectionObservable.java */
/* loaded from: classes6.dex */
final class g extends InitialValueObservable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final AdapterView<?> f34353a;

    /* compiled from: AdapterViewItemSelectionObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements AdapterView.OnItemSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        private final AdapterView<?> f34354b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Integer> f34355c;

        a(AdapterView<?> adapterView, Observer<? super Integer> observer) {
            this.f34354b = adapterView;
            this.f34355c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34354b.setOnItemSelectedListener(null);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView<?> adapterView, View view, int i4, long j4) {
            if (!isDisposed()) {
                this.f34355c.onNext(Integer.valueOf(i4));
            }
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView<?> adapterView) {
            if (!isDisposed()) {
                this.f34355c.onNext(-1);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(AdapterView<?> adapterView) {
        this.f34353a = adapterView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34353a, observer);
        this.f34353a.setOnItemSelectedListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public Integer d() {
        return Integer.valueOf(this.f34353a.getSelectedItemPosition());
    }
}
