package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class CustomWidgetSelectionBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11012a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final ListView customWidgetSelectionList;
    @NonNull
    public final ViewFlipper viewFlipper;

    private CustomWidgetSelectionBinding(@NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull ListView listView, @NonNull ViewFlipper viewFlipper) {
        this.f11012a = linearLayout;
        this.animationView = lottieAnimationView;
        this.customWidgetSelectionList = listView;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static CustomWidgetSelectionBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
        if (lottieAnimationView != null) {
            i4 = R.id.custom_widget_selection_list;
            ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.custom_widget_selection_list);
            if (listView != null) {
                i4 = R.id.view_flipper;
                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                if (viewFlipper != null) {
                    return new CustomWidgetSelectionBinding((LinearLayout) view, lottieAnimationView, listView, viewFlipper);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CustomWidgetSelectionBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CustomWidgetSelectionBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.custom_widget_selection, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11012a;
    }
}
