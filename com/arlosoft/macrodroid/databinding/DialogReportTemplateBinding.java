package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
public final class DialogReportTemplateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11115a;
    @NonNull
    public final RadioButton exactCopy;
    @NonNull
    public final AppCompatEditText justificationText;
    @NonNull
    public final LottieAnimationView loadingView;
    @NonNull
    public final RadioButton radioButtonBadLanguage;
    @NonNull
    public final RadioButton radioButtonNonFunctional;
    @NonNull
    public final RadioButton radioButtonSpam;
    @NonNull
    public final RadioButton radioButtonTrivial;
    @NonNull
    public final RadioGroup radioGroup;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final ViewFlipper viewFlipper;

    private DialogReportTemplateBinding(@NonNull ScrollView scrollView, @NonNull RadioButton radioButton, @NonNull AppCompatEditText appCompatEditText, @NonNull LottieAnimationView lottieAnimationView, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull RadioButton radioButton5, @NonNull RadioGroup radioGroup, @NonNull ScrollView scrollView2, @NonNull ViewFlipper viewFlipper) {
        this.f11115a = scrollView;
        this.exactCopy = radioButton;
        this.justificationText = appCompatEditText;
        this.loadingView = lottieAnimationView;
        this.radioButtonBadLanguage = radioButton2;
        this.radioButtonNonFunctional = radioButton3;
        this.radioButtonSpam = radioButton4;
        this.radioButtonTrivial = radioButton5;
        this.radioGroup = radioGroup;
        this.scrollView = scrollView2;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static DialogReportTemplateBinding bind(@NonNull View view) {
        int i4 = R.id.exactCopy;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.exactCopy);
        if (radioButton != null) {
            i4 = R.id.justificationText;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.justificationText);
            if (appCompatEditText != null) {
                i4 = R.id.loadingView;
                LottieAnimationView lottieAnimationView = (LottieAnimationView) ViewBindings.findChildViewById(view, R.id.loadingView);
                if (lottieAnimationView != null) {
                    i4 = R.id.radioButtonBadLanguage;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonBadLanguage);
                    if (radioButton2 != null) {
                        i4 = R.id.radioButtonNonFunctional;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonNonFunctional);
                        if (radioButton3 != null) {
                            i4 = R.id.radioButtonSpam;
                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonSpam);
                            if (radioButton4 != null) {
                                i4 = R.id.radioButtonTrivial;
                                RadioButton radioButton5 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonTrivial);
                                if (radioButton5 != null) {
                                    i4 = R.id.radioGroup;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.radioGroup);
                                    if (radioGroup != null) {
                                        ScrollView scrollView = (ScrollView) view;
                                        i4 = R.id.viewFlipper;
                                        ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.viewFlipper);
                                        if (viewFlipper != null) {
                                            return new DialogReportTemplateBinding(scrollView, radioButton, appCompatEditText, lottieAnimationView, radioButton2, radioButton3, radioButton4, radioButton5, radioGroup, scrollView, viewFlipper);
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
    public static DialogReportTemplateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogReportTemplateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_report_template, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11115a;
    }
}
