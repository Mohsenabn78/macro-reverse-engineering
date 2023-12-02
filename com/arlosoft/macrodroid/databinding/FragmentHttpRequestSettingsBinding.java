package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes3.dex */
public final class FragmentHttpRequestSettingsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11227a;
    @NonNull
    public final Button addIntegerVariableButton;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final CheckBox allowAnyCertificateCheckBox;
    @NonNull
    public final CheckBox basicAuthCheckbox;
    @NonNull
    public final EditText basicAuthPassword;
    @NonNull
    public final Button basicAuthPasswordMagicTextButton;
    @NonNull
    public final EditText basicAuthUsername;
    @NonNull
    public final Button basicAuthUsernameMagicTextButton;
    @NonNull
    public final CheckBox blockNextActionCheckBox;
    @NonNull
    public final RadioButton dontSaveResponseRadioButton;
    @NonNull
    public final CheckBox followRedirectsCheckbox;
    @NonNull
    public final NDSpinner httpResponseVariableSpinner;
    @NonNull
    public final Spinner requestTypeSpinner;
    @NonNull
    public final LinearLayout responseCodeSelectionLayout;
    @NonNull
    public final NDSpinner responseCodeVariableSpinner;
    @NonNull
    public final LinearLayout responseFileLayout;
    @NonNull
    public final LinearLayout responseVariableLayout;
    @NonNull
    public final CheckBox saveHttpResponseCodeCheckbox;
    @NonNull
    public final EditText saveResponseFilename;
    @NonNull
    public final Button saveResponseFilenameMagicTextButton;
    @NonNull
    public final RadioButton saveResponseInFileRadioButton;
    @NonNull
    public final RadioButton saveResponseInVariableRadioButton;
    @NonNull
    public final TextView saveResponsePath;
    @NonNull
    public final LinearLayout saveResponsePathLayout;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final ImageButton selectFolderButton;
    @NonNull
    public final EditText timeoutSecondsText;
    @NonNull
    public final TextInputEditText url;
    @NonNull
    public final Button urlMagicTextButton;

    private FragmentHttpRequestSettingsBinding(@NonNull ScrollView scrollView, @NonNull Button button, @NonNull Button button2, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull EditText editText, @NonNull Button button3, @NonNull EditText editText2, @NonNull Button button4, @NonNull CheckBox checkBox3, @NonNull RadioButton radioButton, @NonNull CheckBox checkBox4, @NonNull NDSpinner nDSpinner, @NonNull Spinner spinner, @NonNull LinearLayout linearLayout, @NonNull NDSpinner nDSpinner2, @NonNull LinearLayout linearLayout2, @NonNull LinearLayout linearLayout3, @NonNull CheckBox checkBox5, @NonNull EditText editText3, @NonNull Button button5, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull TextView textView, @NonNull LinearLayout linearLayout4, @NonNull ScrollView scrollView2, @NonNull ImageButton imageButton, @NonNull EditText editText4, @NonNull TextInputEditText textInputEditText, @NonNull Button button6) {
        this.f11227a = scrollView;
        this.addIntegerVariableButton = button;
        this.addStringVariableButton = button2;
        this.allowAnyCertificateCheckBox = checkBox;
        this.basicAuthCheckbox = checkBox2;
        this.basicAuthPassword = editText;
        this.basicAuthPasswordMagicTextButton = button3;
        this.basicAuthUsername = editText2;
        this.basicAuthUsernameMagicTextButton = button4;
        this.blockNextActionCheckBox = checkBox3;
        this.dontSaveResponseRadioButton = radioButton;
        this.followRedirectsCheckbox = checkBox4;
        this.httpResponseVariableSpinner = nDSpinner;
        this.requestTypeSpinner = spinner;
        this.responseCodeSelectionLayout = linearLayout;
        this.responseCodeVariableSpinner = nDSpinner2;
        this.responseFileLayout = linearLayout2;
        this.responseVariableLayout = linearLayout3;
        this.saveHttpResponseCodeCheckbox = checkBox5;
        this.saveResponseFilename = editText3;
        this.saveResponseFilenameMagicTextButton = button5;
        this.saveResponseInFileRadioButton = radioButton2;
        this.saveResponseInVariableRadioButton = radioButton3;
        this.saveResponsePath = textView;
        this.saveResponsePathLayout = linearLayout4;
        this.scrollView = scrollView2;
        this.selectFolderButton = imageButton;
        this.timeoutSecondsText = editText4;
        this.url = textInputEditText;
        this.urlMagicTextButton = button6;
    }

    @NonNull
    public static FragmentHttpRequestSettingsBinding bind(@NonNull View view) {
        int i4 = R.id.addIntegerVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addIntegerVariableButton);
        if (button != null) {
            i4 = R.id.addStringVariableButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
            if (button2 != null) {
                i4 = R.id.allowAnyCertificateCheckBox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.allowAnyCertificateCheckBox);
                if (checkBox != null) {
                    i4 = R.id.basicAuthCheckbox;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.basicAuthCheckbox);
                    if (checkBox2 != null) {
                        i4 = R.id.basicAuthPassword;
                        EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.basicAuthPassword);
                        if (editText != null) {
                            i4 = R.id.basicAuthPasswordMagicTextButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.basicAuthPasswordMagicTextButton);
                            if (button3 != null) {
                                i4 = R.id.basicAuthUsername;
                                EditText editText2 = (EditText) ViewBindings.findChildViewById(view, R.id.basicAuthUsername);
                                if (editText2 != null) {
                                    i4 = R.id.basicAuthUsernameMagicTextButton;
                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.basicAuthUsernameMagicTextButton);
                                    if (button4 != null) {
                                        i4 = R.id.blockNextActionCheckBox;
                                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.blockNextActionCheckBox);
                                        if (checkBox3 != null) {
                                            i4 = R.id.dontSaveResponseRadioButton;
                                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.dontSaveResponseRadioButton);
                                            if (radioButton != null) {
                                                i4 = R.id.followRedirectsCheckbox;
                                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.followRedirectsCheckbox);
                                                if (checkBox4 != null) {
                                                    i4 = R.id.httpResponseVariableSpinner;
                                                    NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.httpResponseVariableSpinner);
                                                    if (nDSpinner != null) {
                                                        i4 = R.id.requestTypeSpinner;
                                                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.requestTypeSpinner);
                                                        if (spinner != null) {
                                                            i4 = R.id.responseCodeSelectionLayout;
                                                            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.responseCodeSelectionLayout);
                                                            if (linearLayout != null) {
                                                                i4 = R.id.responseCodeVariableSpinner;
                                                                NDSpinner nDSpinner2 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.responseCodeVariableSpinner);
                                                                if (nDSpinner2 != null) {
                                                                    i4 = R.id.responseFileLayout;
                                                                    LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.responseFileLayout);
                                                                    if (linearLayout2 != null) {
                                                                        i4 = R.id.responseVariableLayout;
                                                                        LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.responseVariableLayout);
                                                                        if (linearLayout3 != null) {
                                                                            i4 = R.id.saveHttpResponseCodeCheckbox;
                                                                            CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.saveHttpResponseCodeCheckbox);
                                                                            if (checkBox5 != null) {
                                                                                i4 = R.id.saveResponseFilename;
                                                                                EditText editText3 = (EditText) ViewBindings.findChildViewById(view, R.id.saveResponseFilename);
                                                                                if (editText3 != null) {
                                                                                    i4 = R.id.saveResponseFilenameMagicTextButton;
                                                                                    Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.saveResponseFilenameMagicTextButton);
                                                                                    if (button5 != null) {
                                                                                        i4 = R.id.saveResponseInFileRadioButton;
                                                                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.saveResponseInFileRadioButton);
                                                                                        if (radioButton2 != null) {
                                                                                            i4 = R.id.saveResponseInVariableRadioButton;
                                                                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.saveResponseInVariableRadioButton);
                                                                                            if (radioButton3 != null) {
                                                                                                i4 = R.id.saveResponsePath;
                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.saveResponsePath);
                                                                                                if (textView != null) {
                                                                                                    i4 = R.id.saveResponsePathLayout;
                                                                                                    LinearLayout linearLayout4 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.saveResponsePathLayout);
                                                                                                    if (linearLayout4 != null) {
                                                                                                        ScrollView scrollView = (ScrollView) view;
                                                                                                        i4 = R.id.selectFolderButton;
                                                                                                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.selectFolderButton);
                                                                                                        if (imageButton != null) {
                                                                                                            i4 = R.id.timeoutSecondsText;
                                                                                                            EditText editText4 = (EditText) ViewBindings.findChildViewById(view, R.id.timeoutSecondsText);
                                                                                                            if (editText4 != null) {
                                                                                                                i4 = R.id.url;
                                                                                                                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.url);
                                                                                                                if (textInputEditText != null) {
                                                                                                                    i4 = R.id.urlMagicTextButton;
                                                                                                                    Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.urlMagicTextButton);
                                                                                                                    if (button6 != null) {
                                                                                                                        return new FragmentHttpRequestSettingsBinding(scrollView, button, button2, checkBox, checkBox2, editText, button3, editText2, button4, checkBox3, radioButton, checkBox4, nDSpinner, spinner, linearLayout, nDSpinner2, linearLayout2, linearLayout3, checkBox5, editText3, button5, radioButton2, radioButton3, textView, linearLayout4, scrollView, imageButton, editText4, textInputEditText, button6);
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
    public static FragmentHttpRequestSettingsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentHttpRequestSettingsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_http_request_settings, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11227a;
    }
}
