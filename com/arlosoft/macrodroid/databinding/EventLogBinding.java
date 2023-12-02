package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EventLogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11208a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final LinearLayout variablesEmptyView;
    @NonNull
    public final ViewFlipper viewFlipper;

    private EventLogBinding(@NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull RecyclerView recyclerView, @NonNull LinearLayout linearLayout2, @NonNull ViewFlipper viewFlipper) {
        this.f11208a = linearLayout;
        this.animationView = lottieAnimationView;
        this.recyclerView = recyclerView;
        this.variablesEmptyView = linearLayout2;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static EventLogBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
        if (lottieAnimationView != null) {
            i4 = R.id.recycler_view;
            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
            if (recyclerView != null) {
                i4 = R.id.variables_emptyView;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variables_emptyView);
                if (linearLayout != null) {
                    i4 = R.id.view_flipper;
                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                    if (viewFlipper != null) {
                        return new EventLogBinding((LinearLayout) view, lottieAnimationView, recyclerView, linearLayout, viewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EventLogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EventLogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.event_log, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11208a;
    }
}
