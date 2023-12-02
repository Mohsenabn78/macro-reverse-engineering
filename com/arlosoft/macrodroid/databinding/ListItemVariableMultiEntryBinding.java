package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ListItemVariableMultiEntryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11316a;
    @NonNull
    public final LinearLayout container;
    @NonNull
    public final TextView key;
    @NonNull
    public final TextView typeLabel;
    @NonNull
    public final TextView value;

    private ListItemVariableMultiEntryBinding(@NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11316a = materialCardView;
        this.container = linearLayout;
        this.key = textView;
        this.typeLabel = textView2;
        this.value = textView3;
    }

    @NonNull
    public static ListItemVariableMultiEntryBinding bind(@NonNull View view) {
        int i4 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.container);
        if (linearLayout != null) {
            i4 = R.id.key;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.key);
            if (textView != null) {
                i4 = R.id.typeLabel;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.typeLabel);
                if (textView2 != null) {
                    i4 = R.id.value;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.value);
                    if (textView3 != null) {
                        return new ListItemVariableMultiEntryBinding((MaterialCardView) view, linearLayout, textView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemVariableMultiEntryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemVariableMultiEntryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_variable_multi_entry, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11316a;
    }
}
