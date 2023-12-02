package com.jakewharton.rxbinding2.widget;

import android.widget.RadioGroup;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: RadioGroupCheckedChangeObservable.java */
/* loaded from: classes6.dex */
final class a0 extends InitialValueObservable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final RadioGroup f34312a;

    /* compiled from: RadioGroupCheckedChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements RadioGroup.OnCheckedChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final RadioGroup f34313b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super Integer> f34314c;

        /* renamed from: d  reason: collision with root package name */
        private int f34315d = -1;

        a(RadioGroup radioGroup, Observer<? super Integer> observer) {
            this.f34313b = radioGroup;
            this.f34314c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34313b.setOnCheckedChangeListener(null);
        }

        @Override // android.widget.RadioGroup.OnCheckedChangeListener
        public void onCheckedChanged(RadioGroup radioGroup, int i4) {
            if (!isDisposed() && i4 != this.f34315d) {
                this.f34315d = i4;
                this.f34314c.onNext(Integer.valueOf(i4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a0(RadioGroup radioGroup) {
        this.f34312a = radioGroup;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34312a, observer);
        this.f34312a.setOnCheckedChangeListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public Integer d() {
        return Integer.valueOf(this.f34312a.getCheckedRadioButtonId());
    }
}
