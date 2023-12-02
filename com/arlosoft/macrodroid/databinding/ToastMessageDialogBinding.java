package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ToastMessageDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11392a;
    @NonNull
    public final TextView backgroundColorButton;
    @NonNull
    public final MaterialCardView backgroundColorCircle;
    @NonNull
    public final CheckBox cancelPreviousCheckbox;
    @NonNull
    public final RadioButton customizableRadioButton;
    @NonNull
    public final LinearLayout customizationsContainer;
    @NonNull
    public final CheckBox displayIconCheckbox;
    @NonNull
    public final Spinner durationSpinner;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final MaterialCardView iconContainer;
    @NonNull
    public final CheckBox maintainSpacesCheckbox;
    @NonNull
    public final LinearLayout positionContainer;
    @NonNull
    public final Spinner positionSpinner;
    @NonNull
    public final Spinner positionSpinnerHorizontal;
    @NonNull
    public final RadioButton standardRadioButton;
    @NonNull
    public final Button testButton;
    @NonNull
    public final TextView textColorButton;
    @NonNull
    public final MaterialCardView textColorCircle;
    @NonNull
    public final CheckBox tintIconCheckbox;
    @NonNull
    public final Button toastMessageDialogMagicTextButton;
    @NonNull
    public final AppCompatEditText toastMessageDialogTextContent;
    @NonNull
    public final TextView twoLineWarning;

    private ToastMessageDialogBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull MaterialCardView materialCardView, @NonNull CheckBox checkBox, @NonNull RadioButton radioButton, @NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox2, @NonNull Spinner spinner, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView2, @NonNull CheckBox checkBox3, @NonNull LinearLayout linearLayout2, @NonNull Spinner spinner2, @NonNull Spinner spinner3, @NonNull RadioButton radioButton2, @NonNull Button button, @NonNull TextView textView2, @NonNull MaterialCardView materialCardView3, @NonNull CheckBox checkBox4, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView3) {
        this.f11392a = scrollView;
        this.backgroundColorButton = textView;
        this.backgroundColorCircle = materialCardView;
        this.cancelPreviousCheckbox = checkBox;
        this.customizableRadioButton = radioButton;
        this.customizationsContainer = linearLayout;
        this.displayIconCheckbox = checkBox2;
        this.durationSpinner = spinner;
        this.icon = imageView;
        this.iconContainer = materialCardView2;
        this.maintainSpacesCheckbox = checkBox3;
        this.positionContainer = linearLayout2;
        this.positionSpinner = spinner2;
        this.positionSpinnerHorizontal = spinner3;
        this.standardRadioButton = radioButton2;
        this.testButton = button;
        this.textColorButton = textView2;
        this.textColorCircle = materialCardView3;
        this.tintIconCheckbox = checkBox4;
        this.toastMessageDialogMagicTextButton = button2;
        this.toastMessageDialogTextContent = appCompatEditText;
        this.twoLineWarning = textView3;
    }

    @NonNull
    public static ToastMessageDialogBinding bind(@NonNull View view) {
        int i4 = R.id.background_color_button;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.background_color_button);
        if (textView != null) {
            i4 = R.id.backgroundColorCircle;
            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.backgroundColorCircle);
            if (materialCardView != null) {
                i4 = R.id.cancelPreviousCheckbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.cancelPreviousCheckbox);
                if (checkBox != null) {
                    i4 = R.id.customizableRadioButton;
                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.customizableRadioButton);
                    if (radioButton != null) {
                        i4 = R.id.customizationsContainer;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.customizationsContainer);
                        if (linearLayout != null) {
                            i4 = R.id.display_icon_checkbox;
                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.display_icon_checkbox);
                            if (checkBox2 != null) {
                                i4 = R.id.duration_spinner;
                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.duration_spinner);
                                if (spinner != null) {
                                    i4 = R.id.icon;
                                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
                                    if (imageView != null) {
                                        i4 = R.id.icon_container;
                                        MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.icon_container);
                                        if (materialCardView2 != null) {
                                            i4 = R.id.maintain_spaces_checkbox;
                                            CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.maintain_spaces_checkbox);
                                            if (checkBox3 != null) {
                                                i4 = R.id.positionContainer;
                                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.positionContainer);
                                                if (linearLayout2 != null) {
                                                    i4 = R.id.position_spinner;
                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.position_spinner);
                                                    if (spinner2 != null) {
                                                        i4 = R.id.position_spinner_horizontal;
                                                        Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.position_spinner_horizontal);
                                                        if (spinner3 != null) {
                                                            i4 = R.id.standardRadioButton;
                                                            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.standardRadioButton);
                                                            if (radioButton2 != null) {
                                                                i4 = R.id.testButton;
                                                                Button button = (Button) ViewBindings.findChildViewById(view, R.id.testButton);
                                                                if (button != null) {
                                                                    i4 = R.id.text_color_button;
                                                                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.text_color_button);
                                                                    if (textView2 != null) {
                                                                        i4 = R.id.textColorCircle;
                                                                        MaterialCardView materialCardView3 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.textColorCircle);
                                                                        if (materialCardView3 != null) {
                                                                            i4 = R.id.tint_icon_checkbox;
                                                                            CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.tint_icon_checkbox);
                                                                            if (checkBox4 != null) {
                                                                                i4 = R.id.toast_message_dialog_magic_text_button;
                                                                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.toast_message_dialog_magic_text_button);
                                                                                if (button2 != null) {
                                                                                    i4 = R.id.toast_message_dialog_text_content;
                                                                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.toast_message_dialog_text_content);
                                                                                    if (appCompatEditText != null) {
                                                                                        i4 = R.id.two_line_warning;
                                                                                        TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.two_line_warning);
                                                                                        if (textView3 != null) {
                                                                                            return new ToastMessageDialogBinding((ScrollView) view, textView, materialCardView, checkBox, radioButton, linearLayout, checkBox2, spinner, imageView, materialCardView2, checkBox3, linearLayout2, spinner2, spinner3, radioButton2, button, textView2, materialCardView3, checkBox4, button2, appCompatEditText, textView3);
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
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ToastMessageDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ToastMessageDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.toast_message_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11392a;
    }
}
