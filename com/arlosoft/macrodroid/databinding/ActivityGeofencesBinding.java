package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityGeofencesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10942a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final TextView celltowersEmptyText;
    @NonNull
    public final FloatingActionButton geofenceAddButton;
    @NonNull
    public final LinearLayout geofencesEmptyView;
    @NonNull
    public final RecyclerView recyclerView;

    private ActivityGeofencesBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView, @NonNull FloatingActionButton floatingActionButton, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.f10942a = coordinatorLayout;
        this.animationView = lottieAnimationView;
        this.celltowersEmptyText = textView;
        this.geofenceAddButton = floatingActionButton;
        this.geofencesEmptyView = linearLayout;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static ActivityGeofencesBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
        if (lottieAnimationView != null) {
            i4 = R.id.celltowers_empty_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.celltowers_empty_text);
            if (textView != null) {
                i4 = R.id.geofence_add_button;
                FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.geofence_add_button);
                if (floatingActionButton != null) {
                    i4 = R.id.geofences_emptyView;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.geofences_emptyView);
                    if (linearLayout != null) {
                        i4 = R.id.recycler_view;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                        if (recyclerView != null) {
                            return new ActivityGeofencesBinding((CoordinatorLayout) view, lottieAnimationView, textView, floatingActionButton, linearLayout, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityGeofencesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityGeofencesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_geofences, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10942a;
    }
}
