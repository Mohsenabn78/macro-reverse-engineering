package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ViewSubscriptionOptionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11415a;
    @NonNull
    public final TextView bubbleText;
    @NonNull
    public final ImageView checkImage;
    @NonNull
    public final TextView crossThroughPrice;
    @NonNull
    public final TextView freeTrialLabel;
    @NonNull
    public final TextView periodText;
    @NonNull
    public final TextView price;
    @NonNull
    public final ProgressBar priceProgressBar;
    @NonNull
    public final LinearLayout purchaseContainer;

    private ViewSubscriptionOptionBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull TextView textView5, @NonNull ProgressBar progressBar, @NonNull LinearLayout linearLayout) {
        this.f11415a = frameLayout;
        this.bubbleText = textView;
        this.checkImage = imageView;
        this.crossThroughPrice = textView2;
        this.freeTrialLabel = textView3;
        this.periodText = textView4;
        this.price = textView5;
        this.priceProgressBar = progressBar;
        this.purchaseContainer = linearLayout;
    }

    @NonNull
    public static ViewSubscriptionOptionBinding bind(@NonNull View view) {
        int i4 = R.id.bubble_text;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.bubble_text);
        if (textView != null) {
            i4 = R.id.check_image;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.check_image);
            if (imageView != null) {
                i4 = R.id.cross_through_price;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.cross_through_price);
                if (textView2 != null) {
                    i4 = R.id.free_trial_label;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.free_trial_label);
                    if (textView3 != null) {
                        i4 = R.id.period_text;
                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.period_text);
                        if (textView4 != null) {
                            i4 = R.id.price;
                            TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.price);
                            if (textView5 != null) {
                                i4 = R.id.price_progress_bar;
                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.price_progress_bar);
                                if (progressBar != null) {
                                    i4 = R.id.purchase_container;
                                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.purchase_container);
                                    if (linearLayout != null) {
                                        return new ViewSubscriptionOptionBinding((FrameLayout) view, textView, imageView, textView2, textView3, textView4, textView5, progressBar, linearLayout);
                                    }
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
    public static ViewSubscriptionOptionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ViewSubscriptionOptionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.view_subscription_option, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11415a;
    }
}
