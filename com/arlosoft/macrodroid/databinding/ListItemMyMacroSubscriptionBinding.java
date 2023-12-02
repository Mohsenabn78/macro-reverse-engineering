package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ListItemMyMacroSubscriptionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11300a;
    @NonNull
    public final CardView cardView;
    @NonNull
    public final TextView maroName;

    private ListItemMyMacroSubscriptionBinding(@NonNull CardView cardView, @NonNull CardView cardView2, @NonNull TextView textView) {
        this.f11300a = cardView;
        this.cardView = cardView2;
        this.maroName = textView;
    }

    @NonNull
    public static ListItemMyMacroSubscriptionBinding bind(@NonNull View view) {
        CardView cardView = (CardView) view;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.maroName);
        if (textView != null) {
            return new ListItemMyMacroSubscriptionBinding(cardView, cardView, textView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.maroName)));
    }

    @NonNull
    public static ListItemMyMacroSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemMyMacroSubscriptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_my_macro_subscription, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11300a;
    }
}
