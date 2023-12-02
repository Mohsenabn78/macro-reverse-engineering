package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogUiInteractionTouchScreenConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11154a;
    @NonNull
    public final RadioButton radioButtonPercent;
    @NonNull
    public final RadioButton radioButtonPixels;
    @NonNull
    public final Button showTouchOverlayButton;
    @NonNull
    public final AppCompatEditText touchScreenConfigXLocation;
    @NonNull
    public final AppCompatEditText touchScreenConfigYLocation;
    @NonNull
    public final TextView touchScreenResolutionLabel;
    @NonNull
    public final Button xMagicTextButton;
    @NonNull
    public final Button yMagicTextButton;

    private DialogUiInteractionTouchScreenConfigBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull TextView textView, @NonNull Button button2, @NonNull Button button3) {
        this.f11154a = linearLayout;
        this.radioButtonPercent = radioButton;
        this.radioButtonPixels = radioButton2;
        this.showTouchOverlayButton = button;
        this.touchScreenConfigXLocation = appCompatEditText;
        this.touchScreenConfigYLocation = appCompatEditText2;
        this.touchScreenResolutionLabel = textView;
        this.xMagicTextButton = button2;
        this.yMagicTextButton = button3;
    }

    @NonNull
    public static DialogUiInteractionTouchScreenConfigBinding bind(@NonNull View view) {
        int i4 = R.id.radioButtonPercent;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPercent);
        if (radioButton != null) {
            i4 = R.id.radioButtonPixels;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPixels);
            if (radioButton2 != null) {
                i4 = R.id.showTouchOverlayButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.showTouchOverlayButton);
                if (button != null) {
                    i4 = R.id.touch_screen_config_x_location;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.touch_screen_config_x_location);
                    if (appCompatEditText != null) {
                        i4 = R.id.touch_screen_config_y_location;
                        AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.touch_screen_config_y_location);
                        if (appCompatEditText2 != null) {
                            i4 = R.id.touch_screen_resolution_label;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.touch_screen_resolution_label);
                            if (textView != null) {
                                i4 = R.id.x_magic_text_button;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.x_magic_text_button);
                                if (button2 != null) {
                                    i4 = R.id.y_magic_text_button;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.y_magic_text_button);
                                    if (button3 != null) {
                                        return new DialogUiInteractionTouchScreenConfigBinding((LinearLayout) view, radioButton, radioButton2, button, appCompatEditText, appCompatEditText2, textView, button2, button3);
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
    public static DialogUiInteractionTouchScreenConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUiInteractionTouchScreenConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ui_interaction_touch_screen_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11154a;
    }
}
