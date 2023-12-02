package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class ConfigureSelectionDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11008a;
    @NonNull
    public final Button addItemButton;
    @NonNull
    public final Button addNumericalVariableButton;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final LinearLayout arrayItemsTopLevelContainer;
    @NonNull
    public final TextView backgroundColorLabel;
    @NonNull
    public final MaterialCardView bgColorButton;
    @NonNull
    public final LinearLayout customItemsContainer;
    @NonNull
    public final LinearLayout customItemsTopLevelContainer;
    @NonNull
    public final AppCompatEditText dialogMessage;
    @NonNull
    public final NDSpinner dialogOptionsSpinner;
    @NonNull
    public final NDSpinner dictionaryArraySpinner;
    @NonNull
    public final Button messageMagicTextButton;
    @NonNull
    public final CheckBox preventBackButtonCheckbox;
    @NonNull
    public final NDSpinner saveIndexSpinner;
    @NonNull
    public final NDSpinner saveValueSpinner;
    @NonNull
    public final ScrollView scrollView;
    @NonNull
    public final MaterialCardView textColorButton;
    @NonNull
    public final TextView textColorLabel;

    private ConfigureSelectionDialogBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull Button button3, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout3, @NonNull LinearLayout linearLayout4, @NonNull AppCompatEditText appCompatEditText, @NonNull NDSpinner nDSpinner, @NonNull NDSpinner nDSpinner2, @NonNull Button button4, @NonNull CheckBox checkBox, @NonNull NDSpinner nDSpinner3, @NonNull NDSpinner nDSpinner4, @NonNull ScrollView scrollView, @NonNull MaterialCardView materialCardView2, @NonNull TextView textView2) {
        this.f11008a = linearLayout;
        this.addItemButton = button;
        this.addNumericalVariableButton = button2;
        this.addStringVariableButton = button3;
        this.arrayItemsTopLevelContainer = linearLayout2;
        this.backgroundColorLabel = textView;
        this.bgColorButton = materialCardView;
        this.customItemsContainer = linearLayout3;
        this.customItemsTopLevelContainer = linearLayout4;
        this.dialogMessage = appCompatEditText;
        this.dialogOptionsSpinner = nDSpinner;
        this.dictionaryArraySpinner = nDSpinner2;
        this.messageMagicTextButton = button4;
        this.preventBackButtonCheckbox = checkBox;
        this.saveIndexSpinner = nDSpinner3;
        this.saveValueSpinner = nDSpinner4;
        this.scrollView = scrollView;
        this.textColorButton = materialCardView2;
        this.textColorLabel = textView2;
    }

    @NonNull
    public static ConfigureSelectionDialogBinding bind(@NonNull View view) {
        int i4 = R.id.add_item_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.add_item_button);
        if (button != null) {
            i4 = R.id.add_numerical_variable_button;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.add_numerical_variable_button);
            if (button2 != null) {
                i4 = R.id.add_string_variable_button;
                Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.add_string_variable_button);
                if (button3 != null) {
                    i4 = R.id.arrayItemsTopLevelContainer;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.arrayItemsTopLevelContainer);
                    if (linearLayout != null) {
                        i4 = R.id.background_color_label;
                        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.background_color_label);
                        if (textView != null) {
                            i4 = R.id.bg_color_button;
                            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.bg_color_button);
                            if (materialCardView != null) {
                                i4 = R.id.customItemsContainer;
                                LinearLayout linearLayout2 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.customItemsContainer);
                                if (linearLayout2 != null) {
                                    i4 = R.id.customItemsTopLevelContainer;
                                    LinearLayout linearLayout3 = (LinearLayout) ViewBindings.findChildViewById(view, R.id.customItemsTopLevelContainer);
                                    if (linearLayout3 != null) {
                                        i4 = R.id.dialog_message;
                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.dialog_message);
                                        if (appCompatEditText != null) {
                                            i4 = R.id.dialog_options_spinner;
                                            NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dialog_options_spinner);
                                            if (nDSpinner != null) {
                                                i4 = R.id.dictionary_array_spinner;
                                                NDSpinner nDSpinner2 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.dictionary_array_spinner);
                                                if (nDSpinner2 != null) {
                                                    i4 = R.id.message_magic_text_button;
                                                    Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.message_magic_text_button);
                                                    if (button4 != null) {
                                                        i4 = R.id.prevent_back_button_checkbox;
                                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.prevent_back_button_checkbox);
                                                        if (checkBox != null) {
                                                            i4 = R.id.save_index_spinner;
                                                            NDSpinner nDSpinner3 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.save_index_spinner);
                                                            if (nDSpinner3 != null) {
                                                                i4 = R.id.save_value_spinner;
                                                                NDSpinner nDSpinner4 = (NDSpinner) ViewBindings.findChildViewById(view, R.id.save_value_spinner);
                                                                if (nDSpinner4 != null) {
                                                                    i4 = R.id.scroll_view;
                                                                    ScrollView scrollView = (ScrollView) ViewBindings.findChildViewById(view, R.id.scroll_view);
                                                                    if (scrollView != null) {
                                                                        i4 = R.id.text_color_button;
                                                                        MaterialCardView materialCardView2 = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.text_color_button);
                                                                        if (materialCardView2 != null) {
                                                                            i4 = R.id.text_color_label;
                                                                            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.text_color_label);
                                                                            if (textView2 != null) {
                                                                                return new ConfigureSelectionDialogBinding((LinearLayout) view, button, button2, button3, linearLayout, textView, materialCardView, linearLayout2, linearLayout3, appCompatEditText, nDSpinner, nDSpinner2, button4, checkBox, nDSpinner3, nDSpinner4, scrollView, materialCardView2, textView2);
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
    public static ConfigureSelectionDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureSelectionDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_selection_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11008a;
    }
}
