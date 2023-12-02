package com.jakewharton.rxbinding2.view;

import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import java.util.concurrent.Callable;

/* loaded from: classes6.dex */
public final class RxView {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f34174a;

        a(View view) {
            this.f34174a = view;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34174a.setActivated(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f34175a;

        b(View view) {
            this.f34175a = view;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34175a.setClickable(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class c implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f34176a;

        c(View view) {
            this.f34176a = view;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34176a.setEnabled(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class d implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f34177a;

        d(View view) {
            this.f34177a = view;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34177a.setPressed(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class e implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f34178a;

        e(View view) {
            this.f34178a = view;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34178a.setSelected(bool.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class f implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f34179a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f34180b;

        f(View view, int i4) {
            this.f34179a = view;
            this.f34180b = i4;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            int i4;
            View view = this.f34179a;
            if (bool.booleanValue()) {
                i4 = 0;
            } else {
                i4 = this.f34180b;
            }
            view.setVisibility(i4);
        }
    }

    private RxView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> activated(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new a(view);
    }

    @NonNull
    @CheckResult
    public static Observable<ViewAttachEvent> attachEvents(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new k(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> attaches(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new l(view, true);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> clickable(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new b(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> clicks(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new m(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> detaches(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new l(view, false);
    }

    @NonNull
    @CheckResult
    public static Observable<DragEvent> drags(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new n(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    @RequiresApi(16)
    public static Observable<Object> draws(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new y(view);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> enabled(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new c(view);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<Boolean> focusChanges(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new o(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> globalLayouts(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new z(view);
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> hovers(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new q(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable<KeyEvent> keys(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new r(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable<ViewLayoutChangeEvent> layoutChangeEvents(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new s(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> layoutChanges(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new t(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> longClicks(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new u(view, Functions.CALLABLE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> preDraws(@NonNull View view, @NonNull Callable<Boolean> callable) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(callable, "proceedDrawingPass == null");
        return new a0(view, callable);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> pressed(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new d(view);
    }

    @NonNull
    @CheckResult
    @RequiresApi(23)
    public static Observable<ViewScrollChangeEvent> scrollChangeEvents(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new v(view);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> selected(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new e(view);
    }

    @NonNull
    @CheckResult
    public static Observable<Integer> systemUiVisibilityChanges(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new w(view);
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> touches(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return new x(view, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Boolean> visibility(@NonNull View view) {
        Preconditions.checkNotNull(view, "view == null");
        return visibility(view, 8);
    }

    @NonNull
    @CheckResult
    public static Observable<DragEvent> drags(@NonNull View view, @NonNull Predicate<? super DragEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new n(view, predicate);
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> hovers(@NonNull View view, @NonNull Predicate<? super MotionEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new q(view, predicate);
    }

    @NonNull
    @CheckResult
    public static Observable<KeyEvent> keys(@NonNull View view, @NonNull Predicate<? super KeyEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new r(view, predicate);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> longClicks(@NonNull View view, @NonNull Callable<Boolean> callable) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(callable, "handled == null");
        return new u(view, callable);
    }

    @NonNull
    @CheckResult
    public static Observable<MotionEvent> touches(@NonNull View view, @NonNull Predicate<? super MotionEvent> predicate) {
        Preconditions.checkNotNull(view, "view == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new x(view, predicate);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Boolean> visibility(@NonNull View view, int i4) {
        Preconditions.checkNotNull(view, "view == null");
        if (i4 != 0) {
            if (i4 != 4 && i4 != 8) {
                throw new IllegalArgumentException("Must set visibility to INVISIBLE or GONE when false.");
            }
            return new f(view, i4);
        }
        throw new IllegalArgumentException("Setting visibility to VISIBLE when false would have no effect.");
    }
}
