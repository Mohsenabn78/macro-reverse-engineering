package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogUiInteractionGestureConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11151a;
    @NonNull
    public final AppCompatEditText duration;
    @NonNull
    public final AppCompatEditText endXLocation;
    @NonNull
    public final Button endXMagicTextButton;
    @NonNull
    public final AppCompatEditText endYLocation;
    @NonNull
    public final Button endYMagicTextButton;
    @NonNull
    public final TextView msLabel;
    @NonNull
    public final Button msMagicTextButton;
    @NonNull
    public final RadioButton radioButtonPercent;
    @NonNull
    public final RadioButton radioButtonPixels;
    @NonNull
    public final TextView resolutionLabel;
    @NonNull
    public final Button showTouchOverlayButton;
    @NonNull
    public final AppCompatEditText startXLocation;
    @NonNull
    public final Button startXMagicTextButton;
    @NonNull
    public final AppCompatEditText startYLocation;
    @NonNull
    public final Button startYMagicTextButton;
    @NonNull
    public final CheckBox waitCheckbox;

    private DialogUiInteractionGestureConfigBinding(@NonNull ScrollView scrollView, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText3, @NonNull Button button2, @NonNull TextView textView, @NonNull Button button3, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull TextView textView2, @NonNull Button button4, @NonNull AppCompatEditText appCompatEditText4, @NonNull Button button5, @NonNull AppCompatEditText appCompatEditText5, @NonNull Button button6, @NonNull CheckBox checkBox) {
        this.f11151a = scrollView;
        this.duration = appCompatEditText;
        this.endXLocation = appCompatEditText2;
        this.endXMagicTextButton = button;
        this.endYLocation = appCompatEditText3;
        this.endYMagicTextButton = button2;
        this.msLabel = textView;
        this.msMagicTextButton = button3;
        this.radioButtonPercent = radioButton;
        this.radioButtonPixels = radioButton2;
        this.resolutionLabel = textView2;
        this.showTouchOverlayButton = button4;
        this.startXLocation = appCompatEditText4;
        this.startXMagicTextButton = button5;
        this.startYLocation = appCompatEditText5;
        this.startYMagicTextButton = button6;
        this.waitCheckbox = checkBox;
    }

    @NonNull
    public static DialogUiInteractionGestureConfigBinding bind(@NonNull View view) {
        int i4 = R.id.duration;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.duration);
        if (appCompatEditText != null) {
            i4 = R.id.end_x_location;
            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.end_x_location);
            if (appCompatEditText2 != null) {
                i4 = R.id.endXMagicTextButton;
                Button button = (Button) ViewBindings.findChildViewById(view, R.id.endXMagicTextButton);
                if (button != null) {
                    i4 = R.id.end_y_location;
                    AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.end_y_location);
                    if (appCompatEditText3 != null) {
                        i4 = R.id.endYMagicTextButton;
                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.endYMagicTextButton);
                        if (button2 != null) {
                            i4 = R.id.msLabel;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.msLabel);
                            if (textView != null) {
                                i4 = R.id.msMagicTextButton;
                                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.msMagicTextButton);
                                if (button3 != null) {
                                    i4 = R.id.radioButtonPercent;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPercent);
                                    if (radioButton != null) {
                                        i4 = R.id.radioButtonPixels;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonPixels);
                                        if (radioButton2 != null) {
                                            i4 = R.id.resolution_label;
                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.resolution_label);
                                            if (textView2 != null) {
                                                i4 = R.id.showTouchOverlayButton;
                                                Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.showTouchOverlayButton);
                                                if (button4 != null) {
                                                    i4 = R.id.start_x_location;
                                                    AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.start_x_location);
                                                    if (appCompatEditText4 != null) {
                                                        i4 = R.id.startXMagicTextButton;
                                                        Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.startXMagicTextButton);
                                                        if (button5 != null) {
                                                            i4 = R.id.start_y_location;
                                                            AppCompatEditText appCompatEditText5 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.start_y_location);
                                                            if (appCompatEditText5 != null) {
                                                                i4 = R.id.startYMagicTextButton;
                                                                Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.startYMagicTextButton);
                                                                if (button6 != null) {
                                                                    i4 = R.id.waitCheckbox;
                                                                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.waitCheckbox);
                                                                    if (checkBox != null) {
                                                                        return new DialogUiInteractionGestureConfigBinding((ScrollView) view, appCompatEditText, appCompatEditText2, button, appCompatEditText3, button2, textView, button3, radioButton, radioButton2, textView2, button4, appCompatEditText4, button5, appCompatEditText5, button6, checkBox);
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
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
    public static DialogUiInteractionGestureConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUiInteractionGestureConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ui_interaction_gesture_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11151a;
    }
}
