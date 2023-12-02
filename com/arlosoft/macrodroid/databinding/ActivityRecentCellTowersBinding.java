package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityRecentCellTowersBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final NestedScrollView f10963a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final TextView celltowersEmptyText;
    @NonNull
    public final FrameLayout emptyView;
    @NonNull
    public final InfoCardBinding infoCard;
    @NonNull
    public final FrameLayout loadingView;
    @NonNull
    public final RecyclerView recyclerView;

    private ActivityRecentCellTowersBinding(@NonNull NestedScrollView nestedScrollView, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView, @NonNull FrameLayout frameLayout, @NonNull InfoCardBinding infoCardBinding, @NonNull FrameLayout frameLayout2, @NonNull RecyclerView recyclerView) {
        this.f10963a = nestedScrollView;
        this.animationView = lottieAnimationView;
        this.celltowersEmptyText = textView;
        this.emptyView = frameLayout;
        this.infoCard = infoCardBinding;
        this.loadingView = frameLayout2;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static ActivityRecentCellTowersBinding bind(@NonNull View view) {
        int i4 = R.id.animation_view;
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
                        i4 = R.id.loadingView;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
                        if (frameLayout2 != null) {
                            i4 = R.id.recycler_view;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recycler_view);
                            if (recyclerView != null) {
                                return new ActivityRecentCellTowersBinding((NestedScrollView) view, lottieAnimationView, textView, frameLayout, bind, frameLayout2, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityRecentCellTowersBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityRecentCellTowersBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_recent_cell_towers, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public NestedScrollView getRoot() {
        return this.f10963a;
    }
}
