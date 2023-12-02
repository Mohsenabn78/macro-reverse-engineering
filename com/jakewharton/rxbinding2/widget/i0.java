package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: TextViewBeforeTextChangeEventObservable.java */
/* loaded from: classes6.dex */
final class i0 extends InitialValueObservable<TextViewBeforeTextChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34370a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i0(TextView textView) {
        this.f34370a = textView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super TextViewBeforeTextChangeEvent> observer) {
        a aVar = new a(this.f34370a, observer);
        observer.onSubscribe(aVar);
        this.f34370a.addTextChangedListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public TextViewBeforeTextChangeEvent d() {
        TextView textView = this.f34370a;
        return TextViewBeforeTextChangeEvent.create(textView, textView.getText(), 0, 0, 0);
    }

    /* compiled from: TextViewBeforeTextChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f34371b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super TextViewBeforeTextChangeEvent> f34372c;

        a(TextView textView, Observer<? super TextViewBeforeTextChangeEvent> observer) {
            this.f34371b = textView;
            this.f34372c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34371b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
            if (!isDisposed()) {
                this.f34372c.onNext(TextViewBeforeTextChangeEvent.create(this.f34371b, charSequence, i4, i5, i6));
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
