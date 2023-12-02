package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.ViewFlipper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class UpgradeSupportDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11397a;
    @NonNull
    public final Button aboutDialogAlreadyPurchased;
    @NonNull
    public final RelativeLayout loadingView;
    @NonNull
    public final ProgressBar progressBar;
    @NonNull
    public final TextView textView1;
    @NonNull
    public final Button updateSupportRequestSupportButton;
    @NonNull
    public final AppCompatEditText upgradeSupportEmail;
    @NonNull
    public final AppCompatEditText upgradeSupportSerial;
    @NonNull
    public final Button upgradeSupportUpgradeButton;
    @NonNull
    public final ViewFlipper viewFlipper;

    private UpgradeSupportDialogBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull RelativeLayout relativeLayout, @NonNull ProgressBar progressBar, @NonNull TextView textView, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button3, @NonNull ViewFlipper viewFlipper) {
        this.f11397a = scrollView;
        this.aboutDialogAlreadyPurchased = button;
        this.loadingView = relativeLayout;
        this.progressBar = progressBar;
        this.textView1 = textView;
        this.updateSupportRequestSupportButton = button2;
        this.upgradeSupportEmail = appCompatEditText;
        this.upgradeSupportSerial = appCompatEditText2;
        this.upgradeSupportUpgradeButton = button3;
        this.viewFlipper = viewFlipper;
    }

    @NonNull
    public static UpgradeSupportDialogBinding bind(@NonNull View view) {
        int i4 = R.id.about_dialog_already_purchased;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.about_dialog_already_purchased);
        if (button != null) {
            i4 = R.id.loading_view;
            RelativeLayout relativeLayout = (RelativeLayout) ViewBindings.findChildViewById(view, R.id.loading_view);
            if (relativeLayout != null) {
                i4 = R.id.progress_bar;
                ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progress_bar);
                if (progressBar != null) {
                    i4 = R.id.textView1;
                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView1);
                    if (textView != null) {
                        i4 = R.id.update_support_request_support_button;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.update_support_request_support_button);
                        if (button2 != null) {
                            i4 = R.id.upgrade_support_email;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.upgrade_support_email);
                            if (appCompatEditText != null) {
                                i4 = R.id.upgrade_support_serial;
                                AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.upgrade_support_serial);
                                if (appCompatEditText2 != null) {
                                    i4 = R.id.upgrade_support_upgrade_button;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.upgrade_support_upgrade_button);
                                    if (button3 != null) {
                                        i4 = R.id.view_flipper;
                                        ViewFlipper viewFlipper = (ViewFlipper) ViewBindings.findChildViewById(view, R.id.view_flipper);
                                        if (viewFlipper != null) {
                                            return new UpgradeSupportDialogBinding((ScrollView) view, button, relativeLayout, progressBar, textView, button2, appCompatEditText, appCompatEditText2, button3, viewFlipper);
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
    public static UpgradeSupportDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static UpgradeSupportDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.upgrade_support_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11397a;
    }
}
