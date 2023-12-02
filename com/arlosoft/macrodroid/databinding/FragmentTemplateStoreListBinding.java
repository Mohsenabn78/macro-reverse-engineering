package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentTemplateStoreListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11233a;
    @NonNull
    public final LottieAnimationView cryingAnimation;
    @NonNull
    public final LinearLayout emptyView;
    @NonNull
    public final LinearLayout errorView;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final LinearLayout pirateView;
    @NonNull
    public final AppCompatButton retryButton;
    @NonNull
    public final LottieAnimationView sadFaceAnimation;
    @NonNull
    public final SwipeRefreshLayout swipeRefresh;
    @NonNull
    public final RecyclerView updatesList;

    private FragmentTemplateStoreListBinding(@NonNull FrameLayout frameLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull LottieAnimationView lottieAnimationView2, @NonNull LinearLayout linearLayout3, @NonNull AppCompatButton appCompatButton, @NonNull LottieAnimationView lottieAnimationView3, @NonNull SwipeRefreshLayout swipeRefreshLayout, @NonNull RecyclerView recyclerView) {
        this.f11233a = frameLayout;
        this.cryingAnimation = lottieAnimationView;
        this.emptyView = linearLayout;
        this.errorView = linearLayout2;
        this.loadingView = lottieAnimationView2;
        this.pirateView = linearLayout3;
        this.retryButton = appCompatButton;
        this.sadFaceAnimation = lottieAnimationView3;
        this.swipeRefresh = swipeRefreshLayout;
        this.updatesList = recyclerView;
    }

    @NonNull
    public static FragmentTemplateStoreListBinding bind(@NonNull View view) {
        int i4 = R.id.cryingAnimation;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.cryingAnimation);
        if (lottieAnimationView != null) {
            i4 = R.id.emptyView;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
            if (linearLayout != null) {
                i4 = R.id.errorView;
                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.errorView);
                if (linearLayout2 != null) {
                    i4 = R.id.loadingView;
                    LottieAnimationView lottieAnimationView2 = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
                    if (lottieAnimationView2 != null) {
                        i4 = R.id.pirateView;
                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.pirateView);
                        if (linearLayout3 != null) {
                            i4 = R.id.retryButton;
                            AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.retryButton);
                            if (appCompatButton != null) {
                                i4 = R.id.sadFaceAnimation;
                                LottieAnimationView lottieAnimationView3 = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.sadFaceAnimation);
                                if (lottieAnimationView3 != null) {
                                    i4 = R.id.swipeRefresh;
                                    SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) ViewBindings.findChildViewById(view, R.id.swipeRefresh);
                                    if (swipeRefreshLayout != null) {
                                        i4 = R.id.updatesList;
                                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.updatesList);
                                        if (recyclerView != null) {
                                            return new FragmentTemplateStoreListBinding((FrameLayout) view, lottieAnimationView, linearLayout, linearLayout2, lottieAnimationView2, linearLayout3, appCompatButton, lottieAnimationView3, swipeRefreshLayout, recyclerView);
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
    public static FragmentTemplateStoreListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentTemplateStoreListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_template_store_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11233a;
    }
}
