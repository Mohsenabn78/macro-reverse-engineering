package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.jakewharton.rxbinding2.InitialValueObservable;
import com.jakewharton.rxbinding2.internal.Preconditions;
import io.reactivex.functions.Consumer;

/* loaded from: classes6.dex */
public final class RxSearchView {

    /* loaded from: classes6.dex */
    static class a implements Consumer<CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchView f34293a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ boolean f34294b;

        a(SearchView searchView, boolean z3) {
            this.f34293a = searchView;
            this.f34294b = z3;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(CharSequence charSequence) {
            this.f34293a.setQuery(charSequence, this.f34294b);
        }
    }

    private RxSearchView() {
        throw new AssertionError("No instances.");
    }

    @NonNull
    @CheckResult
    public static Consumer<? super CharSequence> query(@NonNull SearchView searchView, boolean z3) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new a(searchView, z3);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<SearchViewQueryTextEvent> queryTextChangeEvents(@NonNull SearchView searchView) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new d0(searchView);
    }

    @NonNull
    @CheckResult
    public static InitialValueObservable<CharSequence> queryTextChanges(@NonNull SearchView searchView) {
        Preconditions.checkNotNull(searchView, "view == null");
        return new e0(searchView);
    }
}
