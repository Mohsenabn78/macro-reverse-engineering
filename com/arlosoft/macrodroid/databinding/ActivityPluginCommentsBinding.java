package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityPluginCommentsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10960a;
    @NonNull
    public final LinearLayout addCommentLayout;
    @NonNull
    public final AppCompatEditText commentText;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final TextView developerName;
    @NonNull
    public final LinearLayout errorView;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final TextView macroNameText;
    @NonNull
    public final TextView noCommentsLabel;
    @NonNull
    public final ImageView pluginIcon;
    @NonNull
    public final TextView proVersionText;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final AppCompatButton retryButton;
    @NonNull
    public final ImageView sendCommentButton;
    @NonNull
    public final LinearLayout uploadingLayout;
    @NonNull
    public final ProgressBar uploadingSpinner;

    private ActivityPluginCommentsBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull AppCompatEditText appCompatEditText, @NonNull CoordinatorLayout coordinatorLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout3, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull ImageView imageView, @NonNull TextView textView4, @NonNull RecyclerView recyclerView, @NonNull AppCompatButton appCompatButton, @NonNull ImageView imageView2, @NonNull LinearLayout linearLayout4, @NonNull ProgressBar progressBar) {
        this.f10960a = linearLayout;
        this.addCommentLayout = linearLayout2;
        this.commentText = appCompatEditText;
        this.coordinatorLayout = coordinatorLayout;
        this.developerName = textView;
        this.errorView = linearLayout3;
        this.loadingView = lottieAnimationView;
        this.macroNameText = textView2;
        this.noCommentsLabel = textView3;
        this.pluginIcon = imageView;
        this.proVersionText = textView4;
        this.recyclerView = recyclerView;
        this.retryButton = appCompatButton;
        this.sendCommentButton = imageView2;
        this.uploadingLayout = linearLayout4;
        this.uploadingSpinner = progressBar;
    }

    @NonNull
    public static ActivityPluginCommentsBinding bind(@NonNull View view) {
        int i4 = R.id.addCommentLayout;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.addCommentLayout);
        if (linearLayout != null) {
            i4 = R.id.commentText;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.commentText);
            if (appCompatEditText != null) {
                i4 = R.id.coordinatorLayout;
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.coordinatorLayout);
                if (coordinatorLayout != null) {
                    i4 = R.id.developerName;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.developerName);
                    if (textView != null) {
                        i4 = R.id.errorView;
                        LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.errorView);
                        if (linearLayout2 != null) {
                            i4 = R.id.loadingView;
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
                            if (lottieAnimationView != null) {
                                i4 = R.id.macroNameText;
                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.macroNameText);
                                if (textView2 != null) {
                                    i4 = R.id.noCommentsLabel;
                                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.noCommentsLabel);
                                    if (textView3 != null) {
                                        i4 = R.id.pluginIcon;
                                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pluginIcon);
                                        if (imageView != null) {
                                            i4 = R.id.proVersionText;
                                            TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.proVersionText);
                                            if (textView4 != null) {
                                                i4 = R.id.recyclerView;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                                                if (recyclerView != null) {
                                                    i4 = R.id.retryButton;
                                                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.retryButton);
                                                    if (appCompatButton != null) {
                                                        i4 = R.id.sendCommentButton;
                                                        ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.sendCommentButton);
                                                        if (imageView2 != null) {
                                                            i4 = R.id.uploadingLayout;
                                                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.uploadingLayout);
                                                            if (linearLayout3 != null) {
                                                                i4 = R.id.uploadingSpinner;
                                                                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.uploadingSpinner);
                                                                if (progressBar != null) {
                                                                    return new ActivityPluginCommentsBinding((LinearLayout) view, linearLayout, appCompatEditText, coordinatorLayout, textView, linearLayout2, lottieAnimationView, textView2, textView3, imageView, textView4, recyclerView, appCompatButton, imageView2, linearLayout3, progressBar);
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
    public static ActivityPluginCommentsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityPluginCommentsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_plugin_comments, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10960a;
    }
}
