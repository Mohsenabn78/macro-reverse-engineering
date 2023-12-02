package com.jakewharton.rxbinding2.widget;

import android.widget.Adapter;
import android.widget.AdapterView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class RxAdapterView {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AdapterView f34278a;

        a(AdapterView adapterView) {
            this.f34278a = adapterView;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34278a.setSelection(num.intValue());
        }
    }

    private RxAdapterView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<AdapterViewItemClickEvent> itemClickEvents(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return new c(adapterView);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> itemClicks(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return new d(adapterView);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return itemLongClickEvents(adapterView, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> itemLongClicks(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return itemLongClicks(adapterView, Functions.CALLABLE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> InitialValueObservable<Integer> itemSelections(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return new g(adapterView);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Consumer<? super Integer> selection(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return new a(adapterView);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> InitialValueObservable<AdapterViewSelectionEvent> selectionEvents(@NonNull AdapterView<T> adapterView) {
        Preconditions.checkNotNull(adapterView, "view == null");
        return new h(adapterView);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<AdapterViewItemLongClickEvent> itemLongClickEvents(@NonNull AdapterView<T> adapterView, @NonNull Predicate<? super AdapterViewItemLongClickEvent> predicate) {
        Preconditions.checkNotNull(adapterView, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new e(adapterView, predicate);
    }

    @NonNull
    @CheckResult
    public static <T extends Adapter> Observable<Integer> itemLongClicks(@NonNull AdapterView<T> adapterView, @NonNull Callable<Boolean> callable) {
        Preconditions.checkNotNull(adapterView, "view == null");
        Preconditions.checkNotNull(callable, "handled == null");
        return new f(adapterView, callable);
    }
}
