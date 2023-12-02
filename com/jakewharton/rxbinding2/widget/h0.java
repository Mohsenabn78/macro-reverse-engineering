package com.jakewharton.rxbinding2.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.jakewharton.rxbinding2.InitialValueObservable;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: TextViewAfterTextChangeEventObservable.java */
/* loaded from: classes6.dex */
final class h0 extends InitialValueObservable<TextViewAfterTextChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f34364a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h0(TextView textView) {
        this.f34364a = textView;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super TextViewAfterTextChangeEvent> observer) {
        a aVar = new a(this.f34364a, observer);
        observer.onSubscribe(aVar);
        this.f34364a.addTextChangedListener(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public TextViewAfterTextChangeEvent d() {
        TextView textView = this.f34364a;
        return TextViewAfterTextChangeEvent.create(textView, textView.getEditableText());
    }

    /* compiled from: TextViewAfterTextChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        private final TextView f34365b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super TextViewAfterTextChangeEvent> f34366c;

        a(TextView textView, Observer<? super TextViewAfterTextChangeEvent> observer) {
            this.f34365b = textView;
            this.f34366c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34365b.removeTextChangedListener(this);
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            this.f34366c.onNext(TextViewAfterTextChangeEvent.create(this.f34365b, editable));
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }
}
