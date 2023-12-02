package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActivityUpgradeHelp2Binding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f10974a;
    @NonNull
    public final RelativeLayout loadingView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final Button requestUpgradeSupportButton;
    @NonNull
    public final Button restorePurchaseButton;
    @NonNull
    public final Button upgradeButton;
    @NonNull
    public final AppCompatEditText upgradeEmail;
    @NonNull
    public final AppCompatEditText upgradeSerial;

    private ActivityUpgradeHelp2Binding(@NonNull ScrollView scrollView, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2) {
        this.f10974a = scrollView;
        this.loadingView = relativeLayout;
        this.progressBar = progressBar;
        this.requestUpgradeSupportButton = button;
        this.restorePurchaseButton = button2;
        this.upgradeButton = button3;
        this.upgradeEmail = appCompatEditText;
        this.upgradeSerial = appCompatEditText2;
    }

    @NonNull
    public static ActivityUpgradeHelp2Binding bind(@NonNull View view) {
        int i4 = R.id.loadingView;
        RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.loadingView);
        if (relativeLayout != null) {
            i4 = R.id.progressBar;
            ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressBar);
            if (progressBar != null) {
                i4 = R.id.requestUpgradeSupportButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.requestUpgradeSupportButton);
                if (button != null) {
                    i4 = R.id.restorePurchaseButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.restorePurchaseButton);
                    if (button2 != null) {
                        i4 = R.id.upgradeButton;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.upgradeButton);
                        if (button3 != null) {
                            i4 = R.id.upgradeEmail;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.upgradeEmail);
                            if (appCompatEditText != null) {
                                i4 = R.id.upgradeSerial;
                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.upgradeSerial);
                                if (appCompatEditText2 != null) {
                                    return new ActivityUpgradeHelp2Binding((ScrollView) view, relativeLayout, progressBar, button, button2, button3, appCompatEditText, appCompatEditText2);
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
    public static ActivityUpgradeHelp2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActivityUpgradeHelp2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.activity_upgrade_help_2, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f10974a;
    }
}
