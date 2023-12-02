package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: TextViewTextObservable.java */
/* loaded from: classes6.dex */
final class m0 extends InitialValueObservable<CharSequence> {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34403a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m0(TextView textView) {
        this.f34403a = textView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super CharSequence> observer) {
        a aVar = new a(this.f34403a, observer);
        observer.onSubscribe(aVar);
        this.f34403a.addTextChangedListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public CharSequence d() {
        return this.f34403a.getText();
    }

    /* compiled from: TextViewTextObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f34404b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super CharSequence> f34405c;

        a(TextView textView, Observer<? super CharSequence> observer) {
            this.f34404b = textView;
            this.f34405c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34404b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            if (!isDisposed()) {
                this.f34405c.onNext(charSequence);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
