package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EnterUrlDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11204a;
    @NonNull
    public final Button addBooleanVariableButton;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final CheckBox allowAnyCertificate;
    @NonNull
    public final CheckBox blockNextActionCheckbox;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Spinner enterUrlDialogBooleanSpinner;
    @NonNull
    public final CheckBox enterUrlDialogHttpGetCheckbox;
    @NonNull
    public final Button enterUrlDialogMagicTextButton;
    @NonNull
    public final CheckBox enterUrlDialogSaveHttpResponse;
    @NonNull
    public final CheckBox enterUrlDialogSaveSuccessState;
    @NonNull
    public final AppCompatEditText enterUrlDialogUrl;
    @NonNull
    public final CheckBox enterUrlDialogUrlEncodeCheckbox;
    @NonNull
    public final Spinner enterUrlDialogVariableSpinner;
    @NonNull
    public final Button okButton;

    private EnterUrlDialogBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull Button button2, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull LinearLayout linearLayout, @NonNull Button button3, @NonNull Spinner spinner, @NonNull CheckBox checkBox3, @NonNull Button button4, @NonNull CheckBox checkBox4, @NonNull CheckBox checkBox5, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox6, @NonNull Spinner spinner2, @NonNull Button button5) {
        this.f11204a = scrollView;
        this.addBooleanVariableButton = button;
        this.addStringVariableButton = button2;
        this.allowAnyCertificate = checkBox;
        this.blockNextActionCheckbox = checkBox2;
        this.buttonBar = linearLayout;
        this.cancelButton = button3;
        this.enterUrlDialogBooleanSpinner = spinner;
        this.enterUrlDialogHttpGetCheckbox = checkBox3;
        this.enterUrlDialogMagicTextButton = button4;
        this.enterUrlDialogSaveHttpResponse = checkBox4;
        this.enterUrlDialogSaveSuccessState = checkBox5;
        this.enterUrlDialogUrl = appCompatEditText;
        this.enterUrlDialogUrlEncodeCheckbox = checkBox6;
        this.enterUrlDialogVariableSpinner = spinner2;
        this.okButton = button5;
    }

    @NonNull
    public static EnterUrlDialogBinding bind(@NonNull View view) {
        int i4 = R.id.addBooleanVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addBooleanVariableButton);
        if (button != null) {
            i4 = R.id.addStringVariableButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
            if (button2 != null) {
                i4 = R.id.allow_any_certificate;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.allow_any_certificate);
                if (checkBox != null) {
                    i4 = R.id.block_next_action_checkbox;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.block_next_action_checkbox);
                    if (checkBox2 != null) {
                        i4 = R.id.button_bar;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                        if (linearLayout != null) {
                            i4 = R.id.cancelButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                            if (button3 != null) {
                                i4 = R.id.enter_url_dialog_boolean_spinner;
                                Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_boolean_spinner);
                                if (spinner != null) {
                                    i4 = R.id.enter_url_dialog_http_get_checkbox;
                                    CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_http_get_checkbox);
                                    if (checkBox3 != null) {
                                        i4 = R.id.enter_url_dialog_magic_text_button;
                                        Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_magic_text_button);
                                        if (button4 != null) {
                                            i4 = R.id.enter_url_dialog_save_http_response;
                                            CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_save_http_response);
                                            if (checkBox4 != null) {
                                                i4 = R.id.enter_url_dialog_save_success_state;
                                                CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_save_success_state);
                                                if (checkBox5 != null) {
                                                    i4 = R.id.enter_url_dialog_url;
                                                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_url);
                                                    if (appCompatEditText != null) {
                                                        i4 = R.id.enter_url_dialog_url_encode_checkbox;
                                                        CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_url_encode_checkbox);
                                                        if (checkBox6 != null) {
                                                            i4 = R.id.enter_url_dialog_variable_spinner;
                                                            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.enter_url_dialog_variable_spinner);
                                                            if (spinner2 != null) {
                                                                i4 = R.id.okButton;
                                                                Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                if (button5 != null) {
                                                                    return new EnterUrlDialogBinding((ScrollView) view, button, button2, checkBox, checkBox2, linearLayout, button3, spinner, checkBox3, button4, checkBox4, checkBox5, appCompatEditText, checkBox6, spinner2, button5);
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
    public static EnterUrlDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EnterUrlDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.enter_url_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11204a;
    }
}
