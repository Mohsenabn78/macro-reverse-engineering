package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import net.cachapa.expandablelayout.ExpandableLayout;

/* loaded from: classes3.dex */
public final class ActivityActionBlockListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10932a;
    @NonNull
    public final RecyclerView actionBlocksList;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final ImageView dismissButton;
    @NonNull
    public final FrameLayout emptyView;
    @NonNull
    public final ImageView emptyView1;
    @NonNull
    public final FloatingActionButton fab;
    @NonNull
    public final ConstraintLayout infoBarBg;
    @NonNull
    public final InfoCardBinding infoCard;
    @NonNull
    public final TextView macrolistEmptyLabel;
    @NonNull
    public final ImageView nearbyImage;
    @NonNull
    public final ExpandableLayout nearbySharePanel;
    @NonNull
    public final ProgressBar scanningSpinner;
    @NonNull
    public final NestedScrollView scrollView;
    @NonNull
    public final TextView shareNearbyText;
    @NonNull
    public final Toolbar toolbar;

    private ActivityActionBlockListBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull RecyclerView recyclerView, @NonNull AppBarLayout appBarLayout, @NonNull CoordinatorLayout coordinatorLayout2, @NonNull ImageView imageView, @NonNull FrameLayout frameLayout, @NonNull ImageView imageView2, @NonNull FloatingActionButton floatingActionButton, @NonNull ConstraintLayout constraintLayout, @NonNull InfoCardBinding infoCardBinding, @NonNull TextView textView, @NonNull ImageView imageView3, @NonNull ExpandableLayout expandableLayout, @NonNull ProgressBar progressBar, @NonNull NestedScrollView nestedScrollView, @NonNull TextView textView2, @NonNull Toolbar toolbar) {
        this.f10932a = coordinatorLayout;
        this.actionBlocksList = recyclerView;
        this.appBarLayout = appBarLayout;
        this.coordinatorLayout = coordinatorLayout2;
        this.dismissButton = imageView;
        this.emptyView = frameLayout;
        this.emptyView1 = imageView2;
        this.fab = floatingActionButton;
        this.infoBarBg = constraintLayout;
        this.infoCard = infoCardBinding;
        this.macrolistEmptyLabel = textView;
        this.nearbyImage = imageView3;
        this.nearbySharePanel = expandableLayout;
        this.scanningSpinner = progressBar;
        this.scrollView = nestedScrollView;
        this.shareNearbyText = textView2;
        this.toolbar = toolbar;
    }

    @NonNull
    public static ActivityActionBlockListBinding bind(@NonNull View view) {
        int i4 = R.id.actionBlocksList;
        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.actionBlocksList);
        if (recyclerView != null) {
            i4 = R.id.appBarLayout;
            AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
            if (appBarLayout != null) {
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) view;
                i4 = R.id.dismissButton;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.dismissButton);
                if (imageView != null) {
                    i4 = R.id.emptyView;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
                    if (frameLayout != null) {
                        i4 = R.id.empty_view;
                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.empty_view);
                        if (imageView2 != null) {
                            i4 = R.id.fab;
                            FloatingActionButton floatingActionButton = (FloatingActionButton) ViewBindings.findChildViewById(view, R.id.fab);
                            if (floatingActionButton != null) {
                                i4 = R.id.infoBarBg;
                                ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view, R.id.infoBarBg);
                                if (constraintLayout != null) {
                                    i4 = R.id.infoCard;
                                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.infoCard);
                                    if (findChildViewById != null) {
                                        InfoCardBinding bind = InfoCardBinding.bind(findChildViewById);
                                        i4 = R.id.macrolist_emptyLabel;
                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macrolist_emptyLabel);
                                        if (textView != null) {
                                            i4 = R.id.nearbyImage;
                                            ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.nearbyImage);
                                            if (imageView3 != null) {
                                                i4 = R.id.nearbySharePanel;
                                                ExpandableLayout expandableLayout = (ExpandableLayout) ViewBindings.findChildViewById(view, R.id.nearbySharePanel);
                                                if (expandableLayout != null) {
                                                    i4 = R.id.scanningSpinner;
                                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.scanningSpinner);
                                                    if (progressBar != null) {
                                                        i4 = R.id.scrollView;
                                                        NestedScrollView nestedScrollView = (NestedScrollView) ViewBindings.findChildViewById(view, R.id.scrollView);
                                                        if (nestedScrollView != null) {
                                                            i4 = R.id.shareNearbyText;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.shareNearbyText);
                                                            if (textView2 != null) {
                                                                i4 = R.id.toolbar;
                                                                Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                                                if (toolbar != null) {
                                                                    return new ActivityActionBlockListBinding(coordinatorLayout, recyclerView, appBarLayout, coordinatorLayout, imageView, frameLayout, imageView2, floatingActionButton, constraintLayout, bind, textView, imageView3, expandableLayout, progressBar, nestedScrollView, textView2, toolbar);
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
    public static ActivityActionBlockListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityActionBlockListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_action_block_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10932a;
    }
}
