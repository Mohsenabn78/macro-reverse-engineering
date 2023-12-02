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
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentPluginListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11229a;
    @NonNull
    public final LinearLayout errorView;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final RecyclerView pluginList;
    @NonNull
    public final AppCompatButton retryButton;

    private FragmentPluginListBinding(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull RecyclerView recyclerView, @NonNull AppCompatButton appCompatButton) {
        this.f11229a = frameLayout;
        this.errorView = linearLayout;
        this.loadingView = lottieAnimationView;
        this.pluginList = recyclerView;
        this.retryButton = appCompatButton;
    }

    @NonNull
    public static FragmentPluginListBinding bind(@NonNull View view) {
        int i4 = R.id.errorView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.errorView);
        if (linearLayout != null) {
            i4 = R.id.loadingView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
            if (lottieAnimationView != null) {
                i4 = R.id.pluginList;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.pluginList);
                if (recyclerView != null) {
                    i4 = R.id.retryButton;
                    AppCompatButton appCompatButton = (AppCompatButton) ViewBindings.findChildViewById(view, R.id.retryButton);
                    if (appCompatButton != null) {
                        return new FragmentPluginListBinding((FrameLayout) view, linearLayout, lottieAnimationView, recyclerView, appCompatButton);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentPluginListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentPluginListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_plugin_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11229a;
    }
}
