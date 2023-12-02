package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogUpdateMacroTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11157a;
    @NonNull
    public final AppCompatEditText commentText;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final ViewFlipper viewFlipper;

    private DialogUpdateMacroTextBinding(@NonNull ScrollView scrollView, @NonNull AppCompatEditText appCompatEditText, @NonNull LottieAnimationView lottieAnimationView, @NonNull ScrollView scrollView2, @NonNull ViewFlipper viewFlipper) {
        this.f11157a = scrollView;
        this.commentText = appCompatEditText;
        this.loadingView = lottieAnimationView;
        this.scrollView = scrollView2;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static DialogUpdateMacroTextBinding bind(@NonNull View view) {
        int i4 = R.id.commentText;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.commentText);
        if (appCompatEditText != null) {
            i4 = R.id.loadingView;
            LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
            if (lottieAnimationView != null) {
                ScrollView scrollView = (ScrollView) view;
                i4 = R.id.viewFlipper;
                ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                if (viewFlipper != null) {
                    return new DialogUpdateMacroTextBinding(scrollView, appCompatEditText, lottieAnimationView, scrollView, viewFlipper);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogUpdateMacroTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUpdateMacroTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_update_macro_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11157a;
    }
}
