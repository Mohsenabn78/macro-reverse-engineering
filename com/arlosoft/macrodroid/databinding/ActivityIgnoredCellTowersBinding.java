package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes3.dex */
public final class ActivityIgnoredCellTowersBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10945a;
    @NonNull
    public final FloatingActionButton addTowerButton;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final TextView celltowersEmptyText;
    @NonNull
    public final FrameLayout emptyView;
    @NonNull
    public final InfoCardBinding infoCard;
    @NonNull
    public final RecyclerView recyclerView;

    private ActivityIgnoredCellTowersBinding(@NonNull FrameLayout frameLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView, @NonNull FrameLayout frameLayout2, @NonNull InfoCardBinding infoCardBinding, @NonNull RecyclerView recyclerView) {
        this.f10945a = frameLayout;
        this.addTowerButton = floatingActionButton;
        this.animationView = lottieAnimationView;
        this.celltowersEmptyText = textView;
        this.emptyView = frameLayout2;
        this.infoCard = infoCardBinding;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static ActivityIgnoredCellTowersBinding bind(@NonNull View view) {
        int i4 = R.id.addTowerButton;
        FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.addTowerButton);
        if (floatingActionButton != null) {
            i4 = R.id.animation_view;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animation_view);
            if (lottieAnimationView != null) {
                i4 = R.id.celltowers_empty_text;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.celltowers_empty_text);
                if (textView != null) {
                    i4 = R.id.emptyView;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
                    if (frameLayout != null) {
                        i4 = R.id.infoCard;
                        View findChildViewById = ViewBindings.findChildViewById(view, R.id.infoCard);
                        if (findChildViewById != null) {
                            InfoCardBinding bind = InfoCardBinding.bind(findChildViewById);
                            i4 = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                            if (recyclerView != null) {
                                return new ActivityIgnoredCellTowersBinding((FrameLayout) view, floatingActionButton, lottieAnimationView, textView, frameLayout, bind, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityIgnoredCellTowersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityIgnoredCellTowersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_ignored_cell_towers, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10945a;
    }
}
