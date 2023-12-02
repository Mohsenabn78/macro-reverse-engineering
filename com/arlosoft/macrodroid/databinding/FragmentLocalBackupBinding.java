package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentLocalBackupBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final CoordinatorLayout f11228a;
    @NonNull
    public final LottieAnimationView animationView;
    @NonNull
    public final FrameLayout emptyView;
    @NonNull
    public final InfoCardBinding infoCard;
    @NonNull
    public final FrameLayout loadingView;
    @NonNull
    public final RecyclerView recyclerView;

    private FragmentLocalBackupBinding(@NonNull CoordinatorLayout coordinatorLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull FrameLayout frameLayout, @NonNull InfoCardBinding infoCardBinding, @NonNull FrameLayout frameLayout2, @NonNull RecyclerView recyclerView) {
        this.f11228a = coordinatorLayout;
        this.animationView = lottieAnimationView;
        this.emptyView = frameLayout;
        this.infoCard = infoCardBinding;
        this.loadingView = frameLayout2;
        this.recyclerView = recyclerView;
    }

    @NonNull
    public static FragmentLocalBackupBinding bind(@NonNull View view) {
        int i4 = R.id.animationView;
        LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.animationView);
        if (lottieAnimationView != null) {
            i4 = R.id.emptyView;
            FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
            if (frameLayout != null) {
                i4 = R.id.infoCard;
                View findChildViewById = ViewBindings.findChildViewById(view, R.id.infoCard);
                if (findChildViewById != null) {
                    InfoCardBinding bind = InfoCardBinding.bind(findChildViewById);
                    i4 = R.id.loadingView;
                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
                    if (frameLayout2 != null) {
                        i4 = R.id.recyclerView;
                        RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.recyclerView);
                        if (recyclerView != null) {
                            return new FragmentLocalBackupBinding((CoordinatorLayout) view, lottieAnimationView, frameLayout, bind, frameLayout2, recyclerView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentLocalBackupBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentLocalBackupBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_local_backup, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public CoordinatorLayout getRoot() {
        return this.f11228a;
    }
}
