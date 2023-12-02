package com.jakewharton.rxbinding2.widget;

import android.widget.SearchView;
import androidx.annotation.NonNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AutoValue_SearchViewQueryTextEvent.java */
/* loaded from: classes6.dex */
public final class p extends SearchViewQueryTextEvent {

    /* renamed from: a  reason: collision with root package name */
    private final SearchView f34416a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f34417b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f34418c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(SearchView searchView, CharSequence charSequence, boolean z3) {
        if (searchView != null) {
            this.f34416a = searchView;
            if (charSequence != null) {
                this.f34417b = charSequence;
                this.f34418c = z3;
                return;
            }
            throw new NullPointerException("Null queryText");
        }
        throw new NullPointerException("Null view");
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SearchViewQueryTextEvent)) {
            return false;
        }
        SearchViewQueryTextEvent searchViewQueryTextEvent = (SearchViewQueryTextEvent) obj;
        if (this.f34416a.equals(searchViewQueryTextEvent.view()) && this.f34417b.equals(searchViewQueryTextEvent.queryText()) && this.f34418c == searchViewQueryTextEvent.isSubmitted()) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i4;
        int hashCode = (((this.f34416a.hashCode() ^ 1000003) * 1000003) ^ this.f34417b.hashCode()) * 1000003;
        if (this.f34418c) {
            i4 = 1231;
        } else {
            i4 = 1237;
        }
        return hashCode ^ i4;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    public boolean isSubmitted() {
        return this.f34418c;
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    @NonNull
    public CharSequence queryText() {
        return this.f34417b;
    }

    public String toString() {
        return "SearchViewQueryTextEvent{view=" + this.f34416a + ", queryText=" + ((Object) this.f34417b) + ", isSubmitted=" + this.f34418c + "}";
    }

    @Override // com.jakewharton.rxbinding2.widget.SearchViewQueryTextEvent
    @NonNull
    public SearchView view() {
        return this.f34416a;
    }
}
