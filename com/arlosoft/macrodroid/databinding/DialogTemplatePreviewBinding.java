package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogTemplatePreviewBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11144a;
    @NonNull
    public final ViewFlipper bottomViewFlipper;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final LinearLayout container;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final Button uploadButton;
    @NonNull
    public final LinearLayout uploadingBar;

    private DialogTemplatePreviewBinding(@NonNull LinearLayout linearLayout, @NonNull ViewFlipper viewFlipper, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull LinearLayout linearLayout3, @NonNull LottieAnimationView lottieAnimationView, @NonNull Button button2, @NonNull LinearLayout linearLayout4) {
        this.f11144a = linearLayout;
        this.bottomViewFlipper = viewFlipper;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.container = linearLayout3;
        this.loadingView = lottieAnimationView;
        this.uploadButton = button2;
        this.uploadingBar = linearLayout4;
    }

    @NonNull
    public static DialogTemplatePreviewBinding bind(@NonNull View view) {
        int i4 = R.id.bottomViewFlipper;
        ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.bottomViewFlipper);
        if (viewFlipper != null) {
            i4 = R.id.buttonBar;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.buttonBar);
            if (linearLayout != null) {
                i4 = R.id.cancelButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                if (button != null) {
                    LinearLayout linearLayout2 = (LinearLayout) view;
                    i4 = R.id.loadingView;
                    LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
                    if (lottieAnimationView != null) {
                        i4 = R.id.uploadButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.uploadButton);
                        if (button2 != null) {
                            i4 = R.id.uploadingBar;
                            LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.uploadingBar);
                            if (linearLayout3 != null) {
                                return new DialogTemplatePreviewBinding(linearLayout2, viewFlipper, linearLayout, button, linearLayout2, lottieAnimationView, button2, linearLayout3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogTemplatePreviewBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTemplatePreviewBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_template_preview, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11144a;
    }
}
