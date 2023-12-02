package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentProblemListBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11230a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final LinearLayout emptyView;
    @NonNull
    public final RecyclerView recyclerView;

    private FragmentProblemListBinding(@NonNull FrameLayout frameLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull LinearLayout linearLayout, @NonNull RecyclerView recyclerView) {
        this.f11230a = frameLayout;
        this.animationView = lottieAnimationView;
        this.emptyView = linearLayout;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static FragmentProblemListBinding bind(@NonNull View view) {
        int i4 = R.id.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animationView);
        if (lottieAnimationView != null) {
            i4 = R.id.emptyView;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
            if (linearLayout != null) {
                i4 = R.id.recyclerView;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                if (recyclerView != null) {
                    return new FragmentProblemListBinding((FrameLayout) view, lottieAnimationView, linearLayout, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentProblemListBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentProblemListBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_problem_list, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11230a;
    }
}
