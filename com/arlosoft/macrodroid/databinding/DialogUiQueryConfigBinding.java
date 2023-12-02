package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogUiQueryConfigBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11156a;
    @NonNull
    public final TextView allAppsWarning;
    @NonNull
    public final EditText applicationsText;
    @NonNull
    public final CheckBox enableRegexCheckbox;
    @NonNull
    public final CheckBox ignoreCaseCheckbox;
    @NonNull
    public final CheckBox includeOverlaysCheckbox;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final RadioButton radioButtonMatchText;
    @NonNull
    public final RadioButton radioButtonMatchViewId;
    @NonNull
    public final RadioButton radioButtonOffScreen;
    @NonNull
    public final RadioButton radioButtonOnScreen;
    @NonNull
    public final ImageButton selectAppsButton;
    @NonNull
    public final AppCompatEditText textToMatch;
    @NonNull
    public final TextInputLayout textToMatchLayout;
    @NonNull
    public final TextView updateRateLink;

    private DialogUiQueryConfigBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull EditText editText, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RadioButton radioButton4, @NonNull ImageButton imageButton, @NonNull AppCompatEditText appCompatEditText, @NonNull TextInputLayout textInputLayout, @NonNull TextView textView2) {
        this.f11156a = scrollView;
        this.allAppsWarning = textView;
        this.applicationsText = editText;
        this.enableRegexCheckbox = checkBox;
        this.ignoreCaseCheckbox = checkBox2;
        this.includeOverlaysCheckbox = checkBox3;
        this.magicTextButton = button;
        this.radioButtonMatchText = radioButton;
        this.radioButtonMatchViewId = radioButton2;
        this.radioButtonOffScreen = radioButton3;
        this.radioButtonOnScreen = radioButton4;
        this.selectAppsButton = imageButton;
        this.textToMatch = appCompatEditText;
        this.textToMatchLayout = textInputLayout;
        this.updateRateLink = textView2;
    }

    @NonNull
    public static DialogUiQueryConfigBinding bind(@NonNull View view) {
        int i4 = R.id.allAppsWarning;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.allAppsWarning);
        if (textView != null) {
            i4 = R.id.applicationsText;
            EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.applicationsText);
            if (editText != null) {
                i4 = R.id.enableRegexCheckbox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.enableRegexCheckbox);
                if (checkBox != null) {
                    i4 = R.id.ignoreCaseCheckbox;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignoreCaseCheckbox);
                    if (checkBox2 != null) {
                        i4 = R.id.include_overlays_checkbox;
                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.include_overlays_checkbox);
                        if (checkBox3 != null) {
                            i4 = R.id.magicTextButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                            if (button != null) {
                                i4 = R.id.radio_button_match_text;
                                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_match_text);
                                if (radioButton != null) {
                                    i4 = R.id.radio_button_match_view_id;
                                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_match_view_id);
                                    if (radioButton2 != null) {
                                        i4 = R.id.radio_button_off_screen;
                                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_off_screen);
                                        if (radioButton3 != null) {
                                            i4 = R.id.radio_button_on_screen;
                                            RadioButton radioButton4 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radio_button_on_screen);
                                            if (radioButton4 != null) {
                                                i4 = R.id.selectAppsButton;
                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.selectAppsButton);
                                                if (imageButton != null) {
                                                    i4 = R.id.textToMatch;
                                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.textToMatch);
                                                    if (appCompatEditText != null) {
                                                        i4 = R.id.textToMatchLayout;
                                                        TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.textToMatchLayout);
                                                        if (textInputLayout != null) {
                                                            i4 = R.id.updateRateLink;
                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.updateRateLink);
                                                            if (textView2 != null) {
                                                                return new DialogUiQueryConfigBinding((ScrollView) view, textView, editText, checkBox, checkBox2, checkBox3, button, radioButton, radioButton2, radioButton3, radioButton4, imageButton, appCompatEditText, textInputLayout, textView2);
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
    public static DialogUiQueryConfigBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogUiQueryConfigBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_ui_query_config, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11156a;
    }
}
