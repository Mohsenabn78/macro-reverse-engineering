package com.jakewharton.rxbinding2.view;

import android.view.View;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: ViewFocusChangeObservable.java */
/* loaded from: classes6.dex */
final class o extends InitialValueObservable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final View f34234a;

    /* compiled from: ViewFocusChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements View.OnFocusChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final View f34235b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Boolean> f34236c;

        a(View view, Observer<? super Boolean> observer) {
            this.f34235b = view;
            this.f34236c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34235b.setOnFocusChangeListener(null);
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z3) {
            if (!isDisposed()) {
                this.f34236c.onNext(Boolean.valueOf(z3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(View view) {
        this.f34234a = view;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super Boolean> observer) {
        a aVar = new a(this.f34234a, observer);
        observer.onSubscribe(aVar);
        this.f34234a.setOnFocusChangeListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public Boolean d() {
        return Boolean.valueOf(this.f34234a.hasFocus());
    }
}
