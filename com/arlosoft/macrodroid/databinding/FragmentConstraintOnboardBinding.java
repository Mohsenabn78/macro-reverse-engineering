package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentConstraintOnboardBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f11223a;
    @NonNull
    public final FrameLayout animContainer;
    @NonNull
    public final TextView captionText;
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final LottieAnimationView lottieAnimationView;
    @NonNull
    public final TextView mainText;
    @NonNull
    public final TextView titleText;

    private FragmentConstraintOnboardBinding(@NonNull ConstraintLayout constraintLayout, @NonNull FrameLayout frameLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LottieAnimationView lottieAnimationView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11223a = constraintLayout;
        this.animContainer = frameLayout;
        this.captionText = textView;
        this.imageView = imageView;
        this.lottieAnimationView = lottieAnimationView;
        this.mainText = textView2;
        this.titleText = textView3;
    }

    @NonNull
    public static FragmentConstraintOnboardBinding bind(@NonNull View view) {
        int i4 = R.id.animContainer;
        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.animContainer);
        if (frameLayout != null) {
            i4 = R.id.captionText;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.captionText);
            if (textView != null) {
                i4 = R.id.imageView;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
                if (imageView != null) {
                    i4 = R.id.lottieAnimationView;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.lottieAnimationView);
                    if (lottieAnimationView != null) {
                        i4 = R.id.mainText;
                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.mainText);
                        if (textView2 != null) {
                            i4 = R.id.titleText;
                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                            if (textView3 != null) {
                                return new FragmentConstraintOnboardBinding((ConstraintLayout) view, frameLayout, textView, imageView, lottieAnimationView, textView2, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentConstraintOnboardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentConstraintOnboardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_constraint_onboard, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f11223a;
    }
}
