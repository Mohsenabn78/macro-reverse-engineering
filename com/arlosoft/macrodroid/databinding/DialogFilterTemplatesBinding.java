package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogFilterTemplatesBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11065a;
    @NonNull
    public final Button buttonNeutral;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView dialogFilterTemplatesActionsList;
    @NonNull
    public final TextView dialogFilterTemplatesConstraintsList;
    @NonNull
    public final ImageButton dialogFilterTemplatesEditActionsButton;
    @NonNull
    public final ImageButton dialogFilterTemplatesEditConstraintsButton;
    @NonNull
    public final ImageButton dialogFilterTemplatesEditLanguageButton;
    @NonNull
    public final ImageButton dialogFilterTemplatesEditTriggersButton;
    @NonNull
    public final CheckBox dialogFilterTemplatesHideRootOnly;
    @NonNull
    public final TextView dialogFilterTemplatesLangaugeList;
    @NonNull
    public final TextView dialogFilterTemplatesTriggersList;
    @NonNull
    public final Button okButton;

    private DialogFilterTemplatesBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull Button button2, @NonNull TextView textView, @NonNull TextView textView2, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4, @NonNull CheckBox checkBox, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Button button3) {
        this.f11065a = linearLayout;
        this.buttonNeutral = button;
        this.cancelButton = button2;
        this.dialogFilterTemplatesActionsList = textView;
        this.dialogFilterTemplatesConstraintsList = textView2;
        this.dialogFilterTemplatesEditActionsButton = imageButton;
        this.dialogFilterTemplatesEditConstraintsButton = imageButton2;
        this.dialogFilterTemplatesEditLanguageButton = imageButton3;
        this.dialogFilterTemplatesEditTriggersButton = imageButton4;
        this.dialogFilterTemplatesHideRootOnly = checkBox;
        this.dialogFilterTemplatesLangaugeList = textView3;
        this.dialogFilterTemplatesTriggersList = textView4;
        this.okButton = button3;
    }

    @NonNull
    public static DialogFilterTemplatesBinding bind(@NonNull View view) {
        int i4 = R.id.button_neutral;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.button_neutral);
        if (button != null) {
            i4 = R.id.cancelButton;
            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button2 != null) {
                i4 = R.id.dialog_filter_templates_actions_list;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_actions_list);
                if (textView != null) {
                    i4 = R.id.dialog_filter_templates_constraints_list;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_constraints_list);
                    if (textView2 != null) {
                        i4 = R.id.dialog_filter_templates_edit_actions_button;
                        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_edit_actions_button);
                        if (imageButton != null) {
                            i4 = R.id.dialog_filter_templates_edit_constraints_button;
                            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_edit_constraints_button);
                            if (imageButton2 != null) {
                                i4 = R.id.dialog_filter_templates_edit_language_button;
                                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_edit_language_button);
                                if (imageButton3 != null) {
                                    i4 = R.id.dialog_filter_templates_edit_triggers_button;
                                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_edit_triggers_button);
                                    if (imageButton4 != null) {
                                        i4 = R.id.dialog_filter_templates_hide_root_only;
                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_hide_root_only);
                                        if (checkBox != null) {
                                            i4 = R.id.dialog_filter_templates_langauge_list;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_langauge_list);
                                            if (textView3 != null) {
                                                i4 = R.id.dialog_filter_templates_triggers_list;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.dialog_filter_templates_triggers_list);
                                                if (textView4 != null) {
                                                    i4 = R.id.okButton;
                                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                                                    if (button3 != null) {
                                                        return new DialogFilterTemplatesBinding((LinearLayout) view, button, button2, textView, textView2, imageButton, imageButton2, imageButton3, imageButton4, checkBox, textView3, textView4, button3);
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
    public static DialogFilterTemplatesBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogFilterTemplatesBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_filter_templates, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11065a;
    }
}
