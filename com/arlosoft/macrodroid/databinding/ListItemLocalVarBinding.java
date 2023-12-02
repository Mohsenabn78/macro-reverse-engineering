package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ListItemLocalVarBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CardView f11297a;
    @NonNull
    public final TextView badge;
    @NonNull
    public final LinearLayout mainContainer;
    @NonNull
    public final TextView variableName;
    @NonNull
    public final TextView variableValue;

    private ListItemLocalVarBinding(@NonNull CardView cardView, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11297a = cardView;
        this.badge = textView;
        this.mainContainer = linearLayout;
        this.variableName = textView2;
        this.variableValue = textView3;
    }

    @NonNull
    public static ListItemLocalVarBinding bind(@NonNull View view) {
        int i4 = R.id.badge;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.badge);
        if (textView != null) {
            i4 = R.id.mainContainer;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.mainContainer);
            if (linearLayout != null) {
                i4 = R.id.variableName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.variableName);
                if (textView2 != null) {
                    i4 = R.id.variableValue;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.variableValue);
                    if (textView3 != null) {
                        return new ListItemLocalVarBinding((CardView) view, textView, linearLayout, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemLocalVarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemLocalVarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_local_var, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CardView getRoot() {
        return this.f11297a;
    }
}
