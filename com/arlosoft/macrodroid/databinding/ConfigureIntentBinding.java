package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ConfigureIntentBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10998a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final AppCompatEditText configureIntentAction;
    @NonNull
    public final AppCompatEditText configureIntentClassName;
    @NonNull
    public final AppCompatEditText configureIntentData;
    @NonNull
    public final Button configureIntentDataMagicTextButton;
    @NonNull
    public final AppCompatEditText configureIntentExtra1Name;
    @NonNull
    public final AppCompatEditText configureIntentExtra1Parameter;
    @NonNull
    public final AppCompatEditText configureIntentExtra2Name;
    @NonNull
    public final AppCompatEditText configureIntentExtra2Parameter;
    @NonNull
    public final AppCompatEditText configureIntentExtra3Name;
    @NonNull
    public final AppCompatEditText configureIntentExtra3Parameter;
    @NonNull
    public final AppCompatEditText configureIntentExtra4Name;
    @NonNull
    public final AppCompatEditText configureIntentExtra4Parameter;
    @NonNull
    public final AppCompatEditText configureIntentExtra5Name;
    @NonNull
    public final AppCompatEditText configureIntentExtra5Parameter;
    @NonNull
    public final AppCompatEditText configureIntentExtra6Name;
    @NonNull
    public final AppCompatEditText configureIntentExtra6Parameter;
    @NonNull
    public final ImageButton configureIntentFlagsButton;
    @NonNull
    public final AppCompatEditText configureIntentFlagsValue;
    @NonNull
    public final AppCompatEditText configureIntentMimeType;
    @NonNull
    public final Button configureIntentMimeTypeMagicTextButton;
    @NonNull
    public final AppCompatEditText configureIntentPackageName;
    @NonNull
    public final Button configureIntentParam1MagicTextButton;
    @NonNull
    public final Button configureIntentParam2MagicTextButton;
    @NonNull
    public final Button configureIntentParam3MagicTextButton;
    @NonNull
    public final Button configureIntentParam4MagicTextButton;
    @NonNull
    public final Button configureIntentParam5MagicTextButton;
    @NonNull
    public final Button configureIntentParam6MagicTextButton;
    @NonNull
    public final Spinner configureIntentTargetSpinner;
    @NonNull
    public final TextView extra1;
    @NonNull
    public final Spinner extra1TypeSpinner;
    @NonNull
    public final TextView extra2;
    @NonNull
    public final Spinner extra2TypeSpinner;
    @NonNull
    public final TextView extra3;
    @NonNull
    public final Spinner extra3TypeSpinner;
    @NonNull
    public final TextView extra4;
    @NonNull
    public final Spinner extra4TypeSpinner;
    @NonNull
    public final TextView extra5;
    @NonNull
    public final Spinner extra5TypeSpinner;
    @NonNull
    public final TextView extra6;
    @NonNull
    public final Spinner extra6TypeSpinner;
    @NonNull
    public final TextView flags;
    @NonNull
    public final Button okButton;

    private ConfigureIntentBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull AppCompatEditText appCompatEditText2, @NonNull AppCompatEditText appCompatEditText3, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText4, @NonNull AppCompatEditText appCompatEditText5, @NonNull AppCompatEditText appCompatEditText6, @NonNull AppCompatEditText appCompatEditText7, @NonNull AppCompatEditText appCompatEditText8, @NonNull AppCompatEditText appCompatEditText9, @NonNull AppCompatEditText appCompatEditText10, @NonNull AppCompatEditText appCompatEditText11, @NonNull AppCompatEditText appCompatEditText12, @NonNull AppCompatEditText appCompatEditText13, @NonNull AppCompatEditText appCompatEditText14, @NonNull AppCompatEditText appCompatEditText15, @NonNull ImageButton imageButton, @NonNull AppCompatEditText appCompatEditText16, @NonNull AppCompatEditText appCompatEditText17, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText18, @NonNull Button button4, @NonNull Button button5, @NonNull Button button6, @NonNull Button button7, @NonNull Button button8, @NonNull Button button9, @NonNull Spinner spinner, @NonNull TextView textView, @NonNull Spinner spinner2, @NonNull TextView textView2, @NonNull Spinner spinner3, @NonNull TextView textView3, @NonNull Spinner spinner4, @NonNull TextView textView4, @NonNull Spinner spinner5, @NonNull TextView textView5, @NonNull Spinner spinner6, @NonNull TextView textView6, @NonNull Spinner spinner7, @NonNull TextView textView7, @NonNull Button button10) {
        this.f10998a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configureIntentAction = appCompatEditText;
        this.configureIntentClassName = appCompatEditText2;
        this.configureIntentData = appCompatEditText3;
        this.configureIntentDataMagicTextButton = button2;
        this.configureIntentExtra1Name = appCompatEditText4;
        this.configureIntentExtra1Parameter = appCompatEditText5;
        this.configureIntentExtra2Name = appCompatEditText6;
        this.configureIntentExtra2Parameter = appCompatEditText7;
        this.configureIntentExtra3Name = appCompatEditText8;
        this.configureIntentExtra3Parameter = appCompatEditText9;
        this.configureIntentExtra4Name = appCompatEditText10;
        this.configureIntentExtra4Parameter = appCompatEditText11;
        this.configureIntentExtra5Name = appCompatEditText12;
        this.configureIntentExtra5Parameter = appCompatEditText13;
        this.configureIntentExtra6Name = appCompatEditText14;
        this.configureIntentExtra6Parameter = appCompatEditText15;
        this.configureIntentFlagsButton = imageButton;
        this.configureIntentFlagsValue = appCompatEditText16;
        this.configureIntentMimeType = appCompatEditText17;
        this.configureIntentMimeTypeMagicTextButton = button3;
        this.configureIntentPackageName = appCompatEditText18;
        this.configureIntentParam1MagicTextButton = button4;
        this.configureIntentParam2MagicTextButton = button5;
        this.configureIntentParam3MagicTextButton = button6;
        this.configureIntentParam4MagicTextButton = button7;
        this.configureIntentParam5MagicTextButton = button8;
        this.configureIntentParam6MagicTextButton = button9;
        this.configureIntentTargetSpinner = spinner;
        this.extra1 = textView;
        this.extra1TypeSpinner = spinner2;
        this.extra2 = textView2;
        this.extra2TypeSpinner = spinner3;
        this.extra3 = textView3;
        this.extra3TypeSpinner = spinner4;
        this.extra4 = textView4;
        this.extra4TypeSpinner = spinner5;
        this.extra5 = textView5;
        this.extra5TypeSpinner = spinner6;
        this.extra6 = textView6;
        this.extra6TypeSpinner = spinner7;
        this.flags = textView7;
        this.okButton = button10;
    }

    @NonNull
    public static ConfigureIntentBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.configure_intent_action;
                AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_action);
                if (appCompatEditText != null) {
                    i4 = R.id.configure_intent_class_name;
                    AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_class_name);
                    if (appCompatEditText2 != null) {
                        i4 = R.id.configure_intent_data;
                        AppCompatEditText appCompatEditText3 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_data);
                        if (appCompatEditText3 != null) {
                            i4 = R.id.configure_intent_data_magic_text_button;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_data_magic_text_button);
                            if (button2 != null) {
                                i4 = R.id.configure_intent_extra1_name;
                                AppCompatEditText appCompatEditText4 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra1_name);
                                if (appCompatEditText4 != null) {
                                    i4 = R.id.configure_intent_extra1_parameter;
                                    AppCompatEditText appCompatEditText5 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra1_parameter);
                                    if (appCompatEditText5 != null) {
                                        i4 = R.id.configure_intent_extra2_name;
                                        AppCompatEditText appCompatEditText6 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra2_name);
                                        if (appCompatEditText6 != null) {
                                            i4 = R.id.configure_intent_extra2_parameter;
                                            AppCompatEditText appCompatEditText7 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra2_parameter);
                                            if (appCompatEditText7 != null) {
                                                i4 = R.id.configure_intent_extra3_name;
                                                AppCompatEditText appCompatEditText8 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra3_name);
                                                if (appCompatEditText8 != null) {
                                                    i4 = R.id.configure_intent_extra3_parameter;
                                                    AppCompatEditText appCompatEditText9 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra3_parameter);
                                                    if (appCompatEditText9 != null) {
                                                        i4 = R.id.configure_intent_extra4_name;
                                                        AppCompatEditText appCompatEditText10 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra4_name);
                                                        if (appCompatEditText10 != null) {
                                                            i4 = R.id.configure_intent_extra4_parameter;
                                                            AppCompatEditText appCompatEditText11 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra4_parameter);
                                                            if (appCompatEditText11 != null) {
                                                                i4 = R.id.configure_intent_extra5_name;
                                                                AppCompatEditText appCompatEditText12 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra5_name);
                                                                if (appCompatEditText12 != null) {
                                                                    i4 = R.id.configure_intent_extra5_parameter;
                                                                    AppCompatEditText appCompatEditText13 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra5_parameter);
                                                                    if (appCompatEditText13 != null) {
                                                                        i4 = R.id.configure_intent_extra6_name;
                                                                        AppCompatEditText appCompatEditText14 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra6_name);
                                                                        if (appCompatEditText14 != null) {
                                                                            i4 = R.id.configure_intent_extra6_parameter;
                                                                            AppCompatEditText appCompatEditText15 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_extra6_parameter);
                                                                            if (appCompatEditText15 != null) {
                                                                                i4 = R.id.configure_intent_flags_button;
                                                                                ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.configure_intent_flags_button);
                                                                                if (imageButton != null) {
                                                                                    i4 = R.id.configure_intent_flags_value;
                                                                                    AppCompatEditText appCompatEditText16 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_flags_value);
                                                                                    if (appCompatEditText16 != null) {
                                                                                        i4 = R.id.configure_intent_mime_type;
                                                                                        AppCompatEditText appCompatEditText17 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_mime_type);
                                                                                        if (appCompatEditText17 != null) {
                                                                                            i4 = R.id.configure_intent_mime_type_magic_text_button;
                                                                                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_mime_type_magic_text_button);
                                                                                            if (button3 != null) {
                                                                                                i4 = R.id.configure_intent_package_name;
                                                                                                AppCompatEditText appCompatEditText18 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_intent_package_name);
                                                                                                if (appCompatEditText18 != null) {
                                                                                                    i4 = R.id.configure_intent_param1_magic_text_button;
                                                                                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_param1_magic_text_button);
                                                                                                    if (button4 != null) {
                                                                                                        i4 = R.id.configure_intent_param2_magic_text_button;
                                                                                                        Button button5 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_param2_magic_text_button);
                                                                                                        if (button5 != null) {
                                                                                                            i4 = R.id.configure_intent_param3_magic_text_button;
                                                                                                            Button button6 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_param3_magic_text_button);
                                                                                                            if (button6 != null) {
                                                                                                                i4 = R.id.configure_intent_param4_magic_text_button;
                                                                                                                Button button7 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_param4_magic_text_button);
                                                                                                                if (button7 != null) {
                                                                                                                    i4 = R.id.configure_intent_param5_magic_text_button;
                                                                                                                    Button button8 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_param5_magic_text_button);
                                                                                                                    if (button8 != null) {
                                                                                                                        i4 = R.id.configure_intent_param6_magic_text_button;
                                                                                                                        Button button9 = (Button) ViewBindings.findChildViewById(view, R.id.configure_intent_param6_magic_text_button);
                                                                                                                        if (button9 != null) {
                                                                                                                            i4 = R.id.configure_intent_target_spinner;
                                                                                                                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.configure_intent_target_spinner);
                                                                                                                            if (spinner != null) {
                                                                                                                                i4 = R.id.extra_1;
                                                                                                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.extra_1);
                                                                                                                                if (textView != null) {
                                                                                                                                    i4 = R.id.extra_1_type_spinner;
                                                                                                                                    Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.extra_1_type_spinner);
                                                                                                                                    if (spinner2 != null) {
                                                                                                                                        i4 = R.id.extra_2;
                                                                                                                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.extra_2);
                                                                                                                                        if (textView2 != null) {
                                                                                                                                            i4 = R.id.extra_2_type_spinner;
                                                                                                                                            Spinner spinner3 = (Spinner) ViewBindings.findChildViewById(view, R.id.extra_2_type_spinner);
                                                                                                                                            if (spinner3 != null) {
                                                                                                                                                i4 = R.id.extra_3;
                                                                                                                                                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.extra_3);
                                                                                                                                                if (textView3 != null) {
                                                                                                                                                    i4 = R.id.extra_3_type_spinner;
                                                                                                                                                    Spinner spinner4 = (Spinner) ViewBindings.findChildViewById(view, R.id.extra_3_type_spinner);
                                                                                                                                                    if (spinner4 != null) {
                                                                                                                                                        i4 = R.id.extra_4;
                                                                                                                                                        TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.extra_4);
                                                                                                                                                        if (textView4 != null) {
                                                                                                                                                            i4 = R.id.extra_4_type_spinner;
                                                                                                                                                            Spinner spinner5 = (Spinner) ViewBindings.findChildViewById(view, R.id.extra_4_type_spinner);
                                                                                                                                                            if (spinner5 != null) {
                                                                                                                                                                i4 = R.id.extra_5;
                                                                                                                                                                TextView textView5 = (TextView) ViewBindings.findChildViewById(view, R.id.extra_5);
                                                                                                                                                                if (textView5 != null) {
                                                                                                                                                                    i4 = R.id.extra_5_type_spinner;
                                                                                                                                                                    Spinner spinner6 = (Spinner) ViewBindings.findChildViewById(view, R.id.extra_5_type_spinner);
                                                                                                                                                                    if (spinner6 != null) {
                                                                                                                                                                        i4 = R.id.extra_6;
                                                                                                                                                                        TextView textView6 = (TextView) ViewBindings.findChildViewById(view, R.id.extra_6);
                                                                                                                                                                        if (textView6 != null) {
                                                                                                                                                                            i4 = R.id.extra_6_type_spinner;
                                                                                                                                                                            Spinner spinner7 = (Spinner) ViewBindings.findChildViewById(view, R.id.extra_6_type_spinner);
                                                                                                                                                                            if (spinner7 != null) {
                                                                                                                                                                                i4 = R.id.flags;
                                                                                                                                                                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view, R.id.flags);
                                                                                                                                                                                if (textView7 != null) {
                                                                                                                                                                                    i4 = R.id.okButton;
                                                                                                                                                                                    Button button10 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                                                                                                                                                    if (button10 != null) {
                                                                                                                                                                                        return new ConfigureIntentBinding((LinearLayout) view, linearLayout, button, appCompatEditText, appCompatEditText2, appCompatEditText3, button2, appCompatEditText4, appCompatEditText5, appCompatEditText6, appCompatEditText7, appCompatEditText8, appCompatEditText9, appCompatEditText10, appCompatEditText11, appCompatEditText12, appCompatEditText13, appCompatEditText14, appCompatEditText15, imageButton, appCompatEditText16, appCompatEditText17, button3, appCompatEditText18, button4, button5, button6, button7, button8, button9, spinner, textView, spinner2, textView2, spinner3, textView3, spinner4, textView4, spinner5, textView5, spinner6, textView6, spinner7, textView7, button10);
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
    public static ConfigureIntentBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureIntentBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_intent, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10998a;
    }
}
