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
public final class ListItemHttpRequestParamBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialCardView f11294a;
    @NonNull
    public final LinearLayout container;
    @NonNull
    public final TextView paramName;
    @NonNull
    public final TextView paramValue;

    private ListItemHttpRequestParamBinding(@NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11294a = materialCardView;
        this.container = linearLayout;
        this.paramName = textView;
        this.paramValue = textView2;
    }

    @NonNull
    public static ListItemHttpRequestParamBinding bind(@NonNull View view) {
        int i4 = R.id.container;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.container);
        if (linearLayout != null) {
            i4 = R.id.paramName;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.paramName);
            if (textView != null) {
                i4 = R.id.paramValue;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.paramValue);
                if (textView2 != null) {
                    return new ListItemHttpRequestParamBinding((MaterialCardView) view, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemHttpRequestParamBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemHttpRequestParamBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_http_request_param, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialCardView getRoot() {
        return this.f11294a;
    }
}
