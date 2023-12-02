package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: TextViewTextChangeEventObservable.java */
/* loaded from: classes6.dex */
final class l0 extends InitialValueObservable<TextViewTextChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34396a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l0(TextView textView) {
        this.f34396a = textView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super TextViewTextChangeEvent> observer) {
        a aVar = new a(this.f34396a, observer);
        observer.onSubscribe(aVar);
        this.f34396a.addTextChangedListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public TextViewTextChangeEvent d() {
        TextView textView = this.f34396a;
        return TextViewTextChangeEvent.create(textView, textView.getText(), 0, 0, 0);
    }

    /* compiled from: TextViewTextChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f34397b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super TextViewTextChangeEvent> f34398c;

        a(TextView textView, Observer<? super TextViewTextChangeEvent> observer) {
            this.f34397b = textView;
            this.f34398c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34397b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            if (!isDisposed()) {
                this.f34398c.onNext(TextViewTextChangeEvent.create(this.f34397b, charSequence, i4, i5, i6));
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
