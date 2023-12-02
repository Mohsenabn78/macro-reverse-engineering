package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentCloudBackupBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11222a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final LottieAnimationView animationView2;
    @NonNull
    public final View emptyState;
    @NonNull
    public final FrameLayout emptyView;
    @NonNull
    public final FrameLayout failedDownloadView;
    @NonNull
    public final FrameLayout loadingView;
    @NonNull
    public final LinearLayout nonProInfoScreen;
    @NonNull
    public final RecyclerView recyclerView;
    @NonNull
    public final Button retryButton;
    @NonNull
    public final Button upgradeSignInButton;
    @NonNull
    public final TextView upgradeSignInText;
    @NonNull
    public final ViewFlipper viewFlipper;

    private FragmentCloudBackupBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull LottieAnimationView lottieAnimationView2, @NonNull View view, @NonNull FrameLayout frameLayout, @NonNull FrameLayout frameLayout2, @NonNull FrameLayout frameLayout3, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView, @NonNull ViewFlipper viewFlipper) {
        this.f11222a = coordinatorLayout;
        this.animationView = lottieAnimationView;
        this.animationView2 = lottieAnimationView2;
        this.emptyState = view;
        this.emptyView = frameLayout;
        this.failedDownloadView = frameLayout2;
        this.loadingView = frameLayout3;
        this.nonProInfoScreen = linearLayout;
        this.recyclerView = recyclerView;
        this.retryButton = button;
        this.upgradeSignInButton = button2;
        this.upgradeSignInText = textView;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static FragmentCloudBackupBinding bind(@NonNull View view) {
        int i4 = R.id.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animationView);
        if (lottieAnimationView != null) {
            i4 = R.id.animationView2;
            LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animationView2);
            if (lottieAnimationView2 != null) {
                i4 = R.id.emptyState;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.emptyState);
                if (findChildViewById != null) {
                    i4 = R.id.emptyView;
                    FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
                    if (frameLayout != null) {
                        i4 = R.id.failedDownloadView;
                        FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.failedDownloadView);
                        if (frameLayout2 != null) {
                            i4 = R.id.loadingView;
                            FrameLayout frameLayout3 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
                            if (frameLayout3 != null) {
                                i4 = R.id.nonProInfoScreen;
                                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.nonProInfoScreen);
                                if (linearLayout != null) {
                                    i4 = R.id.recyclerView;
                                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                                    if (recyclerView != null) {
                                        i4 = R.id.retryButton;
                                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.retryButton);
                                        if (button != null) {
                                            i4 = R.id.upgradeSignInButton;
                                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.upgradeSignInButton);
                                            if (button2 != null) {
                                                i4 = R.id.upgradeSignInText;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.upgradeSignInText);
                                                if (textView != null) {
                                                    i4 = R.id.viewFlipper;
                                                    ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                                                    if (viewFlipper != null) {
                                                        return new FragmentCloudBackupBinding((CoordinatorLayout) view, lottieAnimationView, lottieAnimationView2, findChildViewById, frameLayout, frameLayout2, frameLayout3, linearLayout, recyclerView, button, button2, textView, viewFlipper);
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
    public static FragmentCloudBackupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentCloudBackupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_cloud_backup, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11222a;
    }
}
