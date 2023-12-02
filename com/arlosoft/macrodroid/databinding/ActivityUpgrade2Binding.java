package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityUpgrade2Binding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10973a;
    @NonNull
    public final LinearLayout flashSaleContainer;
    @NonNull
    public final TextView flashSaleTimeRemaining;
    @NonNull
    public final TextView flashSaleTitle;
    @NonNull
    public final TextView helpButton;
    @NonNull
    public final FrameLayout priceContainer;
    @NonNull
    public final TextView priceText;
    @NonNull
    public final ViewFlipper priceViewFlipper;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final Button upgradeNowButton;
    @NonNull
    public final TextView wasPrice;

    private ActivityUpgrade2Binding(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull FrameLayout frameLayout2, @NonNull TextView textView4, @NonNull ViewFlipper viewFlipper, @NonNull RecyclerView recyclerView, @NonNull Toolbar toolbar, @NonNull Button button, @NonNull TextView textView5) {
        this.f10973a = frameLayout;
        this.flashSaleContainer = linearLayout;
        this.flashSaleTimeRemaining = textView;
        this.flashSaleTitle = textView2;
        this.helpButton = textView3;
        this.priceContainer = frameLayout2;
        this.priceText = textView4;
        this.priceViewFlipper = viewFlipper;
        this.recyclerView = recyclerView;
        this.toolbar = toolbar;
        this.upgradeNowButton = button;
        this.wasPrice = textView5;
    }

    @NonNull
    public static ActivityUpgrade2Binding bind(@NonNull View view) {
        int i4 = R.id.flashSaleContainer;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.flashSaleContainer);
        if (linearLayout != null) {
            i4 = R.id.flashSaleTimeRemaining;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.flashSaleTimeRemaining);
            if (textView != null) {
                i4 = R.id.flashSaleTitle;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.flashSaleTitle);
                if (textView2 != null) {
                    i4 = R.id.helpButton;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.helpButton);
                    if (textView3 != null) {
                        i4 = R.id.priceContainer;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.priceContainer);
                        if (frameLayout != null) {
                            i4 = R.id.priceText;
                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.priceText);
                            if (textView4 != null) {
                                i4 = R.id.priceViewFlipper;
                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.priceViewFlipper);
                                if (viewFlipper != null) {
                                    i4 = R.id.recyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                                    if (recyclerView != null) {
                                        i4 = R.id.toolbar;
                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                        if (toolbar != null) {
                                            i4 = R.id.upgradeNowButton;
                                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.upgradeNowButton);
                                            if (button != null) {
                                                i4 = R.id.wasPrice;
                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.wasPrice);
                                                if (textView5 != null) {
                                                    return new ActivityUpgrade2Binding((FrameLayout) view, linearLayout, textView, textView2, textView3, frameLayout, textView4, viewFlipper, recyclerView, toolbar, button, textView5);
                                                }
                                            }
                                        }
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
    public static ActivityUpgrade2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUpgrade2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_upgrade_2, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10973a;
    }
}
