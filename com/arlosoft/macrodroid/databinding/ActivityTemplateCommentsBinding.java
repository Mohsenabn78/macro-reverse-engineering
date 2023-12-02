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
import com.arlosoft.macrodroid.avatar.views.AvatarView;

/* loaded from: classes3.dex */
public final class ActivityTemplateCommentsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10969a;
    @NonNull
    public final ImageView addCommentButton;
    @NonNull
    public final LinearLayout addCommentLayout;
    @NonNull
    public final AvatarView avatarImage;
    @NonNull
    public final AppCompatEditText commentText;
    @NonNull
    public final CoordinatorLayout coordinatorLayout;
    @NonNull
    public final LinearLayout errorView;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final TextView macroNameText;
    @NonNull
    public final TextView noCommentsLabel;
    @NonNull
    public final TextView proVersionText;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final AppCompatButton retryButton;
    @NonNull
    public final LinearLayout topContainer;
    @NonNull
    public final LinearLayout uploadingLayout;
    @NonNull
    public final ProgressBar uploadingSpinner;
    @NonNull
    public final TextView userName;

    private ActivityTemplateCommentsBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull AvatarView avatarView, @NonNull AppCompatEditText appCompatEditText, @NonNull CoordinatorLayout coordinatorLayout, @NonNull LinearLayout linearLayout3, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull RecyclerView recyclerView, @NonNull AppCompatButton appCompatButton, @NonNull LinearLayout linearLayout4, @NonNull LinearLayout linearLayout5, @NonNull ProgressBar progressBar, @NonNull TextView textView4) {
        this.f10969a = linearLayout;
        this.addCommentButton = imageView;
        this.addCommentLayout = linearLayout2;
        this.avatarImage = avatarView;
        this.commentText = appCompatEditText;
        this.coordinatorLayout = coordinatorLayout;
        this.errorView = linearLayout3;
        this.loadingView = lottieAnimationView;
        this.macroNameText = textView;
        this.noCommentsLabel = textView2;
        this.proVersionText = textView3;
        this.recyclerView = recyclerView;
        this.retryButton = appCompatButton;
        this.topContainer = linearLayout4;
        this.uploadingLayout = linearLayout5;
        this.uploadingSpinner = progressBar;
        this.userName = textView4;
    }

    @NonNull
    public static ActivityTemplateCommentsBinding bind(@NonNull View view) {
        int i4 = R.id.addCommentButton;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.addCommentButton);
        if (imageView != null) {
            i4 = R.id.addCommentLayout;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.addCommentLayout);
            if (linearLayout != null) {
                i4 = R.id.avatarImage;
                AvatarView avatarView = (AvatarView) ViewBindings.findChildViewById(view, R.id.avatarImage);
                if (avatarView != null) {
                    i4 = R.id.commentText;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.commentText);
                    if (appCompatEditText != null) {
                        i4 = R.id.coordinatorLayout;
                        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) ViewBindings.findChildViewById(view, R.id.coordinatorLayout);
                        if (coordinatorLayout != null) {
                            i4 = R.id.errorView;
                            LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.errorView);
                            if (linearLayout2 != null) {
                                i4 = R.id.loadingView;
                                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
                                if (lottieAnimationView != null) {
                                    i4 = R.id.macroNameText;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macroNameText);
                                    if (textView != null) {
                                        i4 = R.id.noCommentsLabel;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.noCommentsLabel);
                                        if (textView2 != null) {
                                            i4 = R.id.proVersionText;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.proVersionText);
                                            if (textView3 != null) {
                                                i4 = R.id.recyclerView;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                                                if (recyclerView != null) {
                                                    i4 = R.id.retryButton;
                                                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.retryButton);
                                                    if (appCompatButton != null) {
                                                        LinearLayout linearLayout3 = (LinearLayout) view;
                                                        i4 = R.id.uploadingLayout;
                                                        LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.uploadingLayout);
                                                        if (linearLayout4 != null) {
                                                            i4 = R.id.uploadingSpinner;
                                                            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.uploadingSpinner);
                                                            if (progressBar != null) {
                                                                i4 = R.id.userName;
                                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.userName);
                                                                if (textView4 != null) {
                                                                    return new ActivityTemplateCommentsBinding(linearLayout3, imageView, linearLayout, avatarView, appCompatEditText, coordinatorLayout, linearLayout2, lottieAnimationView, textView, textView2, textView3, recyclerView, appCompatButton, linearLayout3, linearLayout4, progressBar, textView4);
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
    public static ActivityTemplateCommentsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityTemplateCommentsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_template_comments, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10969a;
    }
}
