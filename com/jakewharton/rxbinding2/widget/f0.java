package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: SeekBarChangeEventObservable.java */
/* loaded from: classes6.dex */
final class f0 extends InitialValueObservable<SeekBarChangeEvent> {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f34350a;

    /* compiled from: SeekBarChangeEventObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final SeekBar f34351b;

        /* renamed from: c  reason: collision with root package name */
        private final Observer<? super SeekBarChangeEvent> f34352c;

        a(SeekBar seekBar, Observer<? super SeekBarChangeEvent> observer) {
            this.f34351b = seekBar;
            this.f34352c = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34351b.setOnSeekBarChangeListener(null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            if (!isDisposed()) {
                this.f34352c.onNext(SeekBarProgressChangeEvent.create(seekBar, i4, z3));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            if (!isDisposed()) {
                this.f34352c.onNext(SeekBarStartChangeEvent.create(seekBar));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            if (!isDisposed()) {
                this.f34352c.onNext(SeekBarStopChangeEvent.create(seekBar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public f0(SeekBar seekBar) {
        this.f34350a = seekBar;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super SeekBarChangeEvent> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34350a, observer);
        this.f34350a.setOnSeekBarChangeListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public SeekBarChangeEvent d() {
        SeekBar seekBar = this.f34350a;
        return SeekBarProgressChangeEvent.create(seekBar, seekBar.getProgress(), false);
    }
}
