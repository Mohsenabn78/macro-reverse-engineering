package com.jakewharton.rxbinding2.widget;

import android.widget.SeekBar;
import androidx.annotation.Nullable;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observer;
import io.reactivex.android.MainThreadDisposable;

/* compiled from: SeekBarChangeObservable.java */
/* loaded from: classes6.dex */
final class g0 extends InitialValueObservable<Integer> {

    /* renamed from: a  reason: collision with root package name */
    private final SeekBar f34356a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final Boolean f34357b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g0(SeekBar seekBar, @Nullable Boolean bool) {
        this.f34356a = seekBar;
        this.f34357b = bool;
    }

    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    protected void e(Observer<? super Integer> observer) {
        if (!Preconditions.checkMainThread(observer)) {
            return;
        }
        a aVar = new a(this.f34356a, this.f34357b, observer);
        this.f34356a.setOnSeekBarChangeListener(aVar);
        observer.onSubscribe(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.jakewharton.rxbinding2.InitialValueObservable
    /* renamed from: f */
    public Integer d() {
        return Integer.valueOf(this.f34356a.getProgress());
    }

    /* compiled from: SeekBarChangeObservable.java */
    /* loaded from: classes6.dex */
    static final class a extends MainThreadDisposable implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: b  reason: collision with root package name */
        private final SeekBar f34358b;

        /* renamed from: c  reason: collision with root package name */
        private final Boolean f34359c;

        /* renamed from: d  reason: collision with root package name */
        private final Observer<? super Integer> f34360d;

        a(SeekBar seekBar, Boolean bool, Observer<? super Integer> observer) {
            this.f34358b = seekBar;
            this.f34359c = bool;
            this.f34360d = observer;
        }

        @Override // io.reactivex.android.MainThreadDisposable
        protected void a() {
            this.f34358b.setOnSeekBarChangeListener(null);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i4, boolean z3) {
            if (!isDisposed()) {
                Boolean bool = this.f34359c;
                if (bool == null || bool.booleanValue() == z3) {
                    this.f34360d.onNext(Integer.valueOf(i4));
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
