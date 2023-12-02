package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemFavouritesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11292a;
    @NonNull
    public final MaterialCardView container;
    @NonNull
    public final TextView macroName;

    private ListItemFavouritesBinding(@NonNull MaterialCardView materialCardView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView) {
        this.f11292a = materialCardView;
        this.container = materialCardView2;
        this.macroName = textView;
    }

    @NonNull
    public static ListItemFavouritesBinding bind(@NonNull View view) {
        MaterialCardView materialCardView = (MaterialCardView) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macroName);
        if (textView != null) {
            return new ListItemFavouritesBinding(materialCardView, materialCardView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.macroName)));
    }

    @NonNull
    public static ListItemFavouritesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemFavouritesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_favourites, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11292a;
    }
}
