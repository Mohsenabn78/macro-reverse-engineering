package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

/* loaded from: classes3.dex */
public final class ActivityUserBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f10976a;
    @NonNull
    public final AppBarLayout appBarLayout;
    @NonNull
    public final ImageButton backButton;
    @NonNull
    public final FrameLayout blockedContainer;
    @NonNull
    public final CollapsingToolbarLayout collapsingToolbar;
    @NonNull
    public final ImageView menuButton;
    @NonNull
    public final View spaceFiller;
    @NonNull
    public final ImageView subscribeButton;
    @NonNull
    public final ProgressBar subscribingProgress;
    @NonNull
    public final FrameLayout templateListContainer;
    @NonNull
    public final Toolbar toolbar;
    @NonNull
    public final Button unblockUserButton;
    @NonNull
    public final IncludeUserHeaderBinding userHeader;
    @NonNull
    public final TextView usernameText;

    private ActivityUserBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ImageButton imageButton, @NonNull FrameLayout frameLayout, @NonNull CollapsingToolbarLayout collapsingToolbarLayout, @NonNull ImageView imageView, @NonNull View view, @NonNull ImageView imageView2, @NonNull ProgressBar progressBar, @NonNull FrameLayout frameLayout2, @NonNull Toolbar toolbar, @NonNull Button button, @NonNull IncludeUserHeaderBinding includeUserHeaderBinding, @NonNull TextView textView) {
        this.f10976a = coordinatorLayout;
        this.appBarLayout = appBarLayout;
        this.backButton = imageButton;
        this.blockedContainer = frameLayout;
        this.collapsingToolbar = collapsingToolbarLayout;
        this.menuButton = imageView;
        this.spaceFiller = view;
        this.subscribeButton = imageView2;
        this.subscribingProgress = progressBar;
        this.templateListContainer = frameLayout2;
        this.toolbar = toolbar;
        this.unblockUserButton = button;
        this.userHeader = includeUserHeaderBinding;
        this.usernameText = textView;
    }

    @NonNull
    public static ActivityUserBinding bind(@NonNull View view) {
        int i4 = R.id.appBarLayout;
        AppBarLayout appBarLayout = (AppBarLayout) ViewBindings.findChildViewById(view, R.id.appBarLayout);
        if (appBarLayout != null) {
            i4 = R.id.backButton;
            ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.backButton);
            if (imageButton != null) {
                i4 = R.id.blockedContainer;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.blockedContainer);
                if (frameLayout != null) {
                    i4 = R.id.collapsing_toolbar;
                    CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) ViewBindings.findChildViewById(view, R.id.collapsing_toolbar);
                    if (collapsingToolbarLayout != null) {
                        i4 = R.id.menuButton;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.menuButton);
                        if (imageView != null) {
                            i4 = R.id.spaceFiller;
                            View findChildViewById = ViewBindings.findChildViewById(view, R.id.spaceFiller);
                            if (findChildViewById != null) {
                                i4 = R.id.subscribeButton;
                                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.subscribeButton);
                                if (imageView2 != null) {
                                    i4 = R.id.subscribingProgress;
                                    ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.subscribingProgress);
                                    if (progressBar != null) {
                                        i4 = R.id.templateListContainer;
                                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.templateListContainer);
                                        if (frameLayout2 != null) {
                                            i4 = R.id.toolbar;
                                            Toolbar toolbar = (Toolbar) ViewBindings.findChildViewById(view, R.id.toolbar);
                                            if (toolbar != null) {
                                                i4 = R.id.unblockUserButton;
                                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.unblockUserButton);
                                                if (button != null) {
                                                    i4 = R.id.userHeader;
                                                    View findChildViewById2 = ViewBindings.findChildViewById(view, R.id.userHeader);
                                                    if (findChildViewById2 != null) {
                                                        IncludeUserHeaderBinding bind = IncludeUserHeaderBinding.bind(findChildViewById2);
                                                        i4 = R.id.usernameText;
                                                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.usernameText);
                                                        if (textView != null) {
                                                            return new ActivityUserBinding((CoordinatorLayout) view, appBarLayout, imageButton, frameLayout, collapsingToolbarLayout, imageView, findChildViewById, imageView2, progressBar, frameLayout2, toolbar, button, bind, textView);
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
    public static ActivityUserBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUserBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_user, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f10976a;
    }
}
