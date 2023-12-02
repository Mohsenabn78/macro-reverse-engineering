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
public final class FragmentTemplateStoreListUpdatesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11235a;
    @NonNull
    public final LinearLayout emptyView;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final RecyclerView updatesList;

    private FragmentTemplateStoreListUpdatesBinding(@NonNull FrameLayout frameLayout, @NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull RecyclerView recyclerView) {
        this.f11235a = frameLayout;
        this.emptyView = linearLayout;
        this.loadingView = lottieAnimationView;
        this.updatesList = recyclerView;
    }

    @NonNull
    public static FragmentTemplateStoreListUpdatesBinding bind(@NonNull View view) {
        int i4 = R.id.emptyView;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
        if (linearLayout != null) {
            i4 = R.id.loadingView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
            if (lottieAnimationView != null) {
                i4 = R.id.updatesList;
                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.updatesList);
                if (recyclerView != null) {
                    return new FragmentTemplateStoreListUpdatesBinding((FrameLayout) view, linearLayout, lottieAnimationView, recyclerView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentTemplateStoreListUpdatesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentTemplateStoreListUpdatesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_template_store_list_updates, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11235a;
    }
}
