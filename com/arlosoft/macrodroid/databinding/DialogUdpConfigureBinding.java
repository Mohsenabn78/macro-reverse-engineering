package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogUdpConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11149a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText dialogUdpDestination;
    @NonNull
    public final Button dialogUdpMagicTextButton;
    @NonNull
    public final Button dialogUdpMagicTextDestination;
    @NonNull
    public final AppCompatEditText dialogUdpMessage;
    @NonNull
    public final AppCompatEditText dialogUdpPort;
    @NonNull
    public final Button okButton;
    @NonNull
    public final NDSpinner variablesSpinner;

    private DialogUdpConfigureBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button2, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatEditText appCompatEditText3, @NonNull Button button4, @NonNull NDSpinner nDSpinner) {
        this.f11149a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.dialogUdpDestination = appCompatEditText;
        this.dialogUdpMagicTextButton = button2;
        this.dialogUdpMagicTextDestination = button3;
        this.dialogUdpMessage = appCompatEditText2;
        this.dialogUdpPort = appCompatEditText3;
        this.okButton = button4;
        this.variablesSpinner = nDSpinner;
    }

    @NonNull
    public static DialogUdpConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.dialog_udp_destination;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_udp_destination);
                if (appCompatEditText != null) {
                    i4 = R.id.dialog_udp_magic_text_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.dialog_udp_magic_text_button);
                    if (button2 != null) {
                        i4 = R.id.dialog_udp_magic_text_destination;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.dialog_udp_magic_text_destination);
                        if (button3 != null) {
                            i4 = R.id.dialog_udp_message;
                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_udp_message);
                            if (appCompatEditText2 != null) {
                                i4 = R.id.dialog_udp_port;
                                AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_udp_port);
                                if (appCompatEditText3 != null) {
                                    i4 = R.id.okButton;
                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                    if (button4 != null) {
                                        i4 = R.id.variablesSpinner;
                                        NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.variablesSpinner);
                                        if (nDSpinner != null) {
                                            return new DialogUdpConfigureBinding((LinearLayout) view, linearLayout, button, appCompatEditText, button2, button3, appCompatEditText2, appCompatEditText3, button4, nDSpinner);
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
    public static DialogUdpConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUdpConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_udp_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11149a;
    }
}
