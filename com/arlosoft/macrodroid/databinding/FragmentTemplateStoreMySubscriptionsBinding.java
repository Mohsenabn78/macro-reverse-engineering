package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentTemplateStoreMySubscriptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11236a;
    @NonNull
    public final TextView emptyMessageText;
    @NonNull
    public final LinearLayout emptyView;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final RecyclerView updatesList;

    private FragmentTemplateStoreMySubscriptionsBinding(@NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull LottieAnimationView lottieAnimationView, @NonNull RecyclerView recyclerView) {
        this.f11236a = frameLayout;
        this.emptyMessageText = textView;
        this.emptyView = linearLayout;
        this.loadingView = lottieAnimationView;
        this.updatesList = recyclerView;
    }

    @NonNull
    public static FragmentTemplateStoreMySubscriptionsBinding bind(@NonNull View view) {
        int i4 = R.id.emptyMessageText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.emptyMessageText);
        if (textView != null) {
            i4 = R.id.emptyView;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.emptyView);
            if (linearLayout != null) {
                i4 = R.id.loadingView;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
                if (lottieAnimationView != null) {
                    i4 = R.id.updatesList;
                    RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.updatesList);
                    if (recyclerView != null) {
                        return new FragmentTemplateStoreMySubscriptionsBinding((FrameLayout) view, textView, linearLayout, lottieAnimationView, recyclerView);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentTemplateStoreMySubscriptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentTemplateStoreMySubscriptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_template_store_my_subscriptions, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11236a;
    }
}
