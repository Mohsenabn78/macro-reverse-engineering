package com.jakewharton.rxbinding2.widget;

import android.view.MenuItem;
import android.widget.Toolbar;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

@RequiresApi(21)
/* loaded from: classes6.dex */
public final class RxToolbar {

    /* loaded from: classes6.dex */
    static class a implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Toolbar f34304a;

        a(Toolbar toolbar) {
            this.f34304a = toolbar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34304a.setTitle(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Toolbar f34305a;

        b(Toolbar toolbar) {
            this.f34305a = toolbar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34305a.setTitle(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class c implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Toolbar f34306a;

        c(Toolbar toolbar) {
            this.f34306a = toolbar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34306a.setSubtitle(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class d implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Toolbar f34307a;

        d(Toolbar toolbar) {
            this.f34307a = toolbar;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34307a.setSubtitle(num.intValue());
        }
    }

    private RxToolbar() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItem> itemClicks(@NonNull Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new n0(toolbar);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> navigationClicks(@NonNull Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new o0(toolbar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> subtitle(@NonNull Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new c(toolbar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> subtitleRes(@NonNull Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new d(toolbar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> title(@NonNull Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new a(toolbar);
    }

    @NonNull
    @CheckResult
    public static Consumer<? super Integer> titleRes(@NonNull Toolbar toolbar) {
        Preconditions.checkNotNull(toolbar, "view == null");
        return new b(toolbar);
    }
}
