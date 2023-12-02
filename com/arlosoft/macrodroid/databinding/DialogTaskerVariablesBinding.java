package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogTaskerVariablesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11142a;
    @NonNull
    public final TextView arrayHandlingLabel;
    @NonNull
    public final TextView arrayOptionsDescription;
    @NonNull
    public final CheckBox blockActionsCheckBox;
    @NonNull
    public final View borderImage;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final Button okButton;
    @NonNull
    public final RadioButton radioButtonCommaSeparated;
    @NonNull
    public final RadioButton radioButtonFirstElement;
    @NonNull
    public final RadioButton radioButtonNewLineSeparated;
    @NonNull
    public final RecyclerView variablesList;

    private DialogTaskerVariablesBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckBox checkBox, @NonNull View view, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull Button button2, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioButton radioButton3, @NonNull RecyclerView recyclerView) {
        this.f11142a = linearLayout;
        this.arrayHandlingLabel = textView;
        this.arrayOptionsDescription = textView2;
        this.blockActionsCheckBox = checkBox;
        this.borderImage = view;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.okButton = button2;
        this.radioButtonCommaSeparated = radioButton;
        this.radioButtonFirstElement = radioButton2;
        this.radioButtonNewLineSeparated = radioButton3;
        this.variablesList = recyclerView;
    }

    @NonNull
    public static DialogTaskerVariablesBinding bind(@NonNull View view) {
        int i4 = R.id.arrayHandlingLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.arrayHandlingLabel);
        if (textView != null) {
            i4 = R.id.arrayOptionsDescription;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.arrayOptionsDescription);
            if (textView2 != null) {
                i4 = R.id.blockActionsCheckBox;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.blockActionsCheckBox);
                if (checkBox != null) {
                    i4 = R.id.borderImage;
                    View findChildViewById = ViewBindings.findChildViewById(view, R.id.borderImage);
                    if (findChildViewById != null) {
                        i4 = R.id.button_bar;
                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
                        if (linearLayout != null) {
                            i4 = R.id.cancelButton;
                            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
                            if (button != null) {
                                i4 = R.id.okButton;
                                Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                if (button2 != null) {
                                    i4 = R.id.radioButtonCommaSeparated;
                                    RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonCommaSeparated);
                                    if (radioButton != null) {
                                        i4 = R.id.radioButtonFirstElement;
                                        RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonFirstElement);
                                        if (radioButton2 != null) {
                                            i4 = R.id.radioButtonNewLineSeparated;
                                            RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(view, R.id.radioButtonNewLineSeparated);
                                            if (radioButton3 != null) {
                                                i4 = R.id.variablesList;
                                                RecyclerView recyclerView = (RecyclerView) ViewBindings.findChildViewById(view, R.id.variablesList);
                                                if (recyclerView != null) {
                                                    return new DialogTaskerVariablesBinding((LinearLayout) view, textView, textView2, checkBox, findChildViewById, linearLayout, button, button2, radioButton, radioButton2, radioButton3, recyclerView);
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
    public static DialogTaskerVariablesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTaskerVariablesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_tasker_variables, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11142a;
    }
}
