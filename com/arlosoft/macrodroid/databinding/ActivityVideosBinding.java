package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;

/* loaded from: classes3.dex */
public final class ActivityVideosBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10979a;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final FrameLayout errorView;
    @NonNull
    public final FrameLayout loadingView;
    @NonNull
    public final AppCompatButton retryButton;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final RecyclerView videoEntries;

    private ActivityVideosBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull AppCompatButton appCompatButton, @NonNull Toolbar toolbar, @NonNull RecyclerView recyclerView) {
        this.f10979a = coordinatorLayout;
        this.appBarLayout = appBarLayout;
        this.errorView = frameLayout;
        this.loadingView = frameLayout2;
        this.retryButton = appCompatButton;
        this.toolbar = toolbar;
        this.videoEntries = recyclerView;
    }

    @NonNull
    public static ActivityVideosBinding bind(@NonNull View view) {
        int i4 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
        if (appBarLayout != null) {
            i4 = R.id.errorView;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.errorView);
            if (frameLayout != null) {
                i4 = R.id.loadingView;
                FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
                if (frameLayout2 != null) {
                    i4 = R.id.retryButton;
                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.retryButton);
                    if (appCompatButton != null) {
                        i4 = R.id.toolbar;
                        Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                        if (toolbar != null) {
                            i4 = R.id.videoEntries;
                            RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.videoEntries);
                            if (recyclerView != null) {
                                return new ActivityVideosBinding((CoordinatorLayout) view, appBarLayout, frameLayout, frameLayout2, appCompatButton, toolbar, recyclerView);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ActivityVideosBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityVideosBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_videos, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10979a;
    }
}
