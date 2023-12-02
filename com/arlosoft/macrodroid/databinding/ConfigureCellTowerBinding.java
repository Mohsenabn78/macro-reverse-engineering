package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ConfigureCellTowerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10996a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final FloatingActionButton cellTowerAddButton;
    @NonNull
    public final ListView cellTowerGroupList;
    @NonNull
    public final TextView celltowersEmptyText;
    @NonNull
    public final FrameLayout celltowersEmptyView;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;

    private ConfigureCellTowerBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull FloatingActionButton floatingActionButton, @NonNull ListView listView, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull CoordinatorLayout coordinatorLayout2) {
        this.f10996a = coordinatorLayout;
        this.animationView = lottieAnimationView;
        this.cellTowerAddButton = floatingActionButton;
        this.cellTowerGroupList = listView;
        this.celltowersEmptyText = textView;
        this.celltowersEmptyView = frameLayout;
        this.coordinatorLayout = coordinatorLayout2;
    }

    @NonNull
    public static ConfigureCellTowerBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
        if (lottieAnimationView != null) {
            i4 = R.id.cell_tower_add_button;
            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.cell_tower_add_button);
            if (floatingActionButton != null) {
                i4 = R.id.cell_tower_group_list;
                ListView listView = (ListView) ViewBindings.findChildViewById(view, R.id.cell_tower_group_list);
                if (listView != null) {
                    i4 = R.id.celltowers_empty_text;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.celltowers_empty_text);
                    if (textView != null) {
                        i4 = R.id.celltowers_emptyView;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.celltowers_emptyView);
                        if (frameLayout != null) {
                            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                            return new ConfigureCellTowerBinding(coordinatorLayout, lottieAnimationView, floatingActionButton, listView, textView, frameLayout, coordinatorLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ConfigureCellTowerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureCellTowerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_cell_tower, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10996a;
    }
}
