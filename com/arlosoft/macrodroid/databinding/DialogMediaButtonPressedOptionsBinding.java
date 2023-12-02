package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogMediaButtonPressedOptionsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11096a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final RadioButton doublePress;
    @NonNull
    public final RadioButton longPress;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton singlePress;
    @NonNull
    public final RadioButton treblePress;

    private DialogMediaButtonPressedOptionsBinding(@NonNull ScrollView scrollView, @NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull Button button2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4) {
        this.f11096a = scrollView;
        this.buttonBar = linearLayout;
        this.cancelButton = button;
        this.doublePress = radioButton;
        this.longPress = radioButton2;
        this.okButton = button2;
        this.singlePress = radioButton3;
        this.treblePress = radioButton4;
    }

    @NonNull
    public static DialogMediaButtonPressedOptionsBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.double_press;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.double_press);
                if (radioButton != null) {
                    i4 = R.id.long_press;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.long_press);
                    if (radioButton2 != null) {
                        i4 = R.id.okButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                        if (button2 != null) {
                            i4 = R.id.single_press;
                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.single_press);
                            if (radioButton3 != null) {
                                i4 = R.id.treble_press;
                                RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.treble_press);
                                if (radioButton4 != null) {
                                    return new DialogMediaButtonPressedOptionsBinding((ScrollView) view, linearLayout, button, radioButton, radioButton2, button2, radioButton3, radioButton4);
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
    public static DialogMediaButtonPressedOptionsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogMediaButtonPressedOptionsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_media_button_pressed_options, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11096a;
    }
}
