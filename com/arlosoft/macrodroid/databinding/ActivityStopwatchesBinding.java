package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityStopwatchesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final View f10967a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final ViewFlipper viewFlipper;

    private ActivityStopwatchesBinding(@NonNull View view, @NonNull LottieAnimationView lottieAnimationView, @NonNull FloatingActionButton floatingActionButton, @NonNull RecyclerView recyclerView, @NonNull ViewFlipper viewFlipper) {
        this.f10967a = view;
        this.animationView = lottieAnimationView;
        this.fab = floatingActionButton;
        this.recyclerView = recyclerView;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static ActivityStopwatchesBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
        if (lottieAnimationView != null) {
            i4 = R.id.fab;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
            if (floatingActionButton != null) {
                i4 = R.id.recycler_view;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                if (recyclerView != null) {
                    i4 = R.id.view_flipper;
                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                    if (viewFlipper != null) {
                        return new ActivityStopwatchesBinding(view, lottieAnimationView, floatingActionButton, recyclerView, viewFlipper);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityStopwatchesBinding inflate(@NonNull LayoutInflater layoutInflater, @NonNull ViewGroup viewGroup) {
        if (viewGroup != null) {
            layoutInflater.inflate(R.layout.activity_stopwatches, viewGroup);
            return bind(viewGroup);
        }
        throw new NullPointerException("parent");
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public View getRoot() {
        return this.f10967a;
    }
}
