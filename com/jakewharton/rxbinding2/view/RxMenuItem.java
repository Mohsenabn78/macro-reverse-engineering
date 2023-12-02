package com.jakewharton.rxbinding2.view;

import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.internal.Functions;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;

/* loaded from: classes6.dex */
public final class RxMenuItem {

    /* loaded from: classes6.dex */
    static class a implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34167a;

        a(MenuItem menuItem) {
            this.f34167a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34167a.setChecked(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class b implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34168a;

        b(MenuItem menuItem) {
            this.f34168a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34168a.setEnabled(bool.booleanValue());
        }
    }

    /* loaded from: classes6.dex */
    static class c implements Consumer<Drawable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34169a;

        c(MenuItem menuItem) {
            this.f34169a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Drawable drawable) {
            this.f34169a.setIcon(drawable);
        }
    }

    /* loaded from: classes6.dex */
    static class d implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34170a;

        d(MenuItem menuItem) {
            this.f34170a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34170a.setIcon(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class e implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34171a;

        e(MenuItem menuItem) {
            this.f34171a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34171a.setTitle(charSequence);
        }
    }

    /* loaded from: classes6.dex */
    static class f implements Consumer<Integer> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34172a;

        f(MenuItem menuItem) {
            this.f34172a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Integer num) {
            this.f34172a.setTitle(num.intValue());
        }
    }

    /* loaded from: classes6.dex */
    static class g implements Consumer<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MenuItem f34173a;

        g(MenuItem menuItem) {
            this.f34173a = menuItem;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Boolean bool) {
            this.f34173a.setVisible(bool.booleanValue());
        }
    }

    private RxMenuItem() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItemActionViewEvent> actionViewEvents(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new i(menuItem, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> checked(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new a(menuItem);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> clicks(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new j(menuItem, Functions.PREDICATE_ALWAYS_TRUE);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> enabled(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new b(menuItem);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Drawable> icon(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new c(menuItem);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Integer> iconRes(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new d(menuItem);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super CharSequence> title(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new e(menuItem);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Integer> titleRes(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new f(menuItem);
    }

    @NonNull
    @CheckResult
    @Deprecated
    public static Consumer<? super Boolean> visible(@NonNull MenuItem menuItem) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        return new g(menuItem);
    }

    @NonNull
    @CheckResult
    public static Observable<MenuItemActionViewEvent> actionViewEvents(@NonNull MenuItem menuItem, @NonNull Predicate<? super MenuItemActionViewEvent> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new i(menuItem, predicate);
    }

    @NonNull
    @CheckResult
    public static Observable<Object> clicks(@NonNull MenuItem menuItem, @NonNull Predicate<? super MenuItem> predicate) {
        Preconditions.checkNotNull(menuItem, "menuItem == null");
        Preconditions.checkNotNull(predicate, "handled == null");
        return new j(menuItem, predicate);
    }
}
