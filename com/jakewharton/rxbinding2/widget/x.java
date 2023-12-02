package com.jakewharton.rxbinding2.widget;

import android.widget.CompoundButton;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: CompoundButtonCheckedChangeObservable.java */
/* loaded from: classes6.dex */
final class x extends InitialValueObservable<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final CompoundButton f34439a;

    /* compiled from: CompoundButtonCheckedChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements CompoundButton.OnCheckedChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final CompoundButton f34440b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Boolean> f34441c;

        a(CompoundButton compoundButton, Observer<? super Boolean> observer) {
            this.f34440b = compoundButton;
            this.f34441c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34440b.setOnCheckedChangeListener(null);
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z3) {
            if (!isDisposed()) {
                this.f34441c.onNext(Boolean.valueOf(z3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(CompoundButton compoundButton) {
        this.f34439a = compoundButton;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super Boolean> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34439a, observer);
        observer.onSubscribe(aVar);
        this.f34439a.setOnCheckedChangeListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public Boolean d() {
        return Boolean.valueOf(this.f34439a.isChecked());
    }
}
