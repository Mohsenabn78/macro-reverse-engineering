package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityDonateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10937a;
    @NonNull
    public final TextView donate1Price;
    @NonNull
    public final TextView donate2Price;
    @NonNull
    public final TextView donate3Price;
    @NonNull
    public final FloatingActionButton donateButton1;
    @NonNull
    public final FloatingActionButton donateButton2;
    @NonNull
    public final FloatingActionButton donateButton3;
    @NonNull
    public final Toolbar toolbar;

    private ActivityDonateBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull FloatingActionButton floatingActionButton, @NonNull FloatingActionButton floatingActionButton2, @NonNull FloatingActionButton floatingActionButton3, @NonNull Toolbar toolbar) {
        this.f10937a = linearLayout;
        this.donate1Price = textView;
        this.donate2Price = textView2;
        this.donate3Price = textView3;
        this.donateButton1 = floatingActionButton;
        this.donateButton2 = floatingActionButton2;
        this.donateButton3 = floatingActionButton3;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityDonateBinding bind(@NonNull View view) {
        int i4 = R.id.donate_1_price;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.donate_1_price);
        if (textView != null) {
            i4 = R.id.donate_2_price;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.donate_2_price);
            if (textView2 != null) {
                i4 = R.id.donate_3_price;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.donate_3_price);
                if (textView3 != null) {
                    i4 = R.id.donate_button_1;
                    FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.donate_button_1);
                    if (floatingActionButton != null) {
                        i4 = R.id.donate_button_2;
                        FloatingActionButton floatingActionButton2 = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.donate_button_2);
                        if (floatingActionButton2 != null) {
                            i4 = R.id.donate_button_3;
                            FloatingActionButton floatingActionButton3 = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.donate_button_3);
                            if (floatingActionButton3 != null) {
                                i4 = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                if (toolbar != null) {
                                    return new ActivityDonateBinding((LinearLayout) view, textView, textView2, textView3, floatingActionButton, floatingActionButton2, floatingActionButton3, toolbar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityDonateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityDonateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_donate, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10937a;
    }
}
