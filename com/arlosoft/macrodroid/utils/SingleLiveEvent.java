package com.arlosoft.macrodroid.utils;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SingleLiveEvent.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class SingleLiveEvent<T> extends MutableLiveData<T> {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f16074a = new AtomicBoolean(false);
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SingleLiveEvent.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: SingleLiveEvent.kt */
    /* loaded from: classes3.dex */
    static final class a implements Observer<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SingleLiveEvent<T> f16075a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Observer<? super T> f16076b;

        a(SingleLiveEvent<T> singleLiveEvent, Observer<? super T> observer) {
            this.f16075a = singleLiveEvent;
            this.f16076b = observer;
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(@Nullable T t3) {
            if (((SingleLiveEvent) this.f16075a).f16074a.compareAndSet(true, false)) {
                this.f16076b.onChanged(t3);
            }
        }
    }

    @MainThread
    public final void call() {
        setValue(null);
    }

    @Override // androidx.lifecycle.LiveData
    @MainThread
    public void observe(@NotNull LifecycleOwner owner, @NotNull Observer<? super T> observer) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        if (hasActiveObservers()) {
            Log.w("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.");
        }
        super.observe(owner, new a(this, observer));
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    @MainThread
    public void setValue(@Nullable T t3) {
        this.f16074a.set(true);
        super.setValue(t3);
    }
}
