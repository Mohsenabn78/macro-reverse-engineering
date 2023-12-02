package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.BetterCheckBox;

/* loaded from: classes3.dex */
public final class ActivitySystemLogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10968a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final LinearLayout emptyView;
    @NonNull
    public final LinearLayout filterPanel;
    @NonNull
    public final InfoCardBinding infoCard;
    @NonNull
    public final Spinner logLevelSpinner;
    @NonNull
    public final Button macroFilterButton;
    @NonNull
    public final TextView macroName;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final LinearLayout rootContent;
    @NonNull
    public final BetterCheckBox showActions;
    @NonNull
    public final BetterCheckBox showConstraints;
    @NonNull
    public final BetterCheckBox showTriggers;
    @NonNull
    public final TextView title;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final Button variablesFilterButton;
    @NonNull
    public final ViewFlipper viewFlipper;

    private ActivitySystemLogBinding(@NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull InfoCardBinding infoCardBinding, @NonNull Spinner spinner, @NonNull Button button, @NonNull TextView textView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout4, @NonNull BetterCheckBox betterCheckBox, @NonNull BetterCheckBox betterCheckBox2, @NonNull BetterCheckBox betterCheckBox3, @NonNull TextView textView2, @NonNull Toolbar toolbar, @NonNull Button button2, @NonNull ViewFlipper viewFlipper) {
        this.f10968a = linearLayout;
        this.animationView = lottieAnimationView;
        this.emptyView = linearLayout2;
        this.filterPanel = linearLayout3;
        this.infoCard = infoCardBinding;
        this.logLevelSpinner = spinner;
        this.macroFilterButton = button;
        this.macroName = textView;
        this.recyclerView = recyclerView;
        this.rootContent = linearLayout4;
        this.showActions = betterCheckBox;
        this.showConstraints = betterCheckBox2;
        this.showTriggers = betterCheckBox3;
        this.title = textView2;
        this.toolbar = toolbar;
        this.variablesFilterButton = button2;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static ActivitySystemLogBinding bind(@NonNull View view) {
        int i4 = R.id.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animationView);
        if (lottieAnimationView != null) {
            i4 = R.id.emptyView;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
            if (linearLayout != null) {
                i4 = R.id.filterPanel;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.filterPanel);
                if (linearLayout2 != null) {
                    i4 = R.id.infoCard;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.infoCard);
                    if (findChildViewById != null) {
                        InfoCardBinding bind = InfoCardBinding.bind(findChildViewById);
                        i4 = R.id.logLevelSpinner;
                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.logLevelSpinner);
                        if (spinner != null) {
                            i4 = R.id.macroFilterButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.macroFilterButton);
                            if (button != null) {
                                i4 = R.id.macroName;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macroName);
                                if (textView != null) {
                                    i4 = R.id.recyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                                    if (recyclerView != null) {
                                        LinearLayout linearLayout3 = (LinearLayout) view;
                                        i4 = R.id.showActions;
                                        BetterCheckBox betterCheckBox = (BetterCheckBox) ViewBindings.findChildViewById(view, R.id.showActions);
                                        if (betterCheckBox != null) {
                                            i4 = R.id.showConstraints;
                                            BetterCheckBox betterCheckBox2 = (BetterCheckBox) ViewBindings.findChildViewById(view, R.id.showConstraints);
                                            if (betterCheckBox2 != null) {
                                                i4 = R.id.showTriggers;
                                                BetterCheckBox betterCheckBox3 = (BetterCheckBox) ViewBindings.findChildViewById(view, R.id.showTriggers);
                                                if (betterCheckBox3 != null) {
                                                    i4 = R.id.title;
                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                                                    if (textView2 != null) {
                                                        i4 = R.id.toolbar;
                                                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                        if (toolbar != null) {
                                                            i4 = R.id.variablesFilterButton;
                                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.variablesFilterButton);
                                                            if (button2 != null) {
                                                                i4 = R.id.viewFlipper;
                                                                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                                                                if (viewFlipper != null) {
                                                                    return new ActivitySystemLogBinding(linearLayout3, lottieAnimationView, linearLayout, linearLayout2, bind, spinner, button, textView, recyclerView, linearLayout3, betterCheckBox, betterCheckBox2, betterCheckBox3, textView2, toolbar, button2, viewFlipper);
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
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivitySystemLogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivitySystemLogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_system_log, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10968a;
    }
}
