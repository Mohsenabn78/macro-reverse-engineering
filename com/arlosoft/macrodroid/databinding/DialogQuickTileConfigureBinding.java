package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class DialogQuickTileConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ConstraintLayout f11113a;
    @NonNull
    public final ImageView icon;
    @NonNull
    public final MaterialCardView iconContainer;
    @NonNull
    public final LinearLayout labelContainer;
    @NonNull
    public final EditText labelText;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final RadioButton offRadioButton;
    @NonNull
    public final RadioButton onRadioButton;
    @NonNull
    public final RadioGroup radioGroupOnOff;
    @NonNull
    public final CheckBox setIconCheckBox;
    @NonNull
    public final CheckBox setLabelCheckBox;
    @NonNull
    public final CheckBox setOnOffStateCheckBox;

    private DialogQuickTileConfigureBinding(@NonNull ConstraintLayout constraintLayout, @NonNull ImageView imageView, @NonNull MaterialCardView materialCardView, @NonNull LinearLayout linearLayout, @NonNull EditText editText, @NonNull Button button, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2, @NonNull RadioGroup radioGroup, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3) {
        this.f11113a = constraintLayout;
        this.icon = imageView;
        this.iconContainer = materialCardView;
        this.labelContainer = linearLayout;
        this.labelText = editText;
        this.magicTextButton = button;
        this.offRadioButton = radioButton;
        this.onRadioButton = radioButton2;
        this.radioGroupOnOff = radioGroup;
        this.setIconCheckBox = checkBox;
        this.setLabelCheckBox = checkBox2;
        this.setOnOffStateCheckBox = checkBox3;
    }

    @NonNull
    public static DialogQuickTileConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.icon);
        if (imageView != null) {
            i4 = R.id.icon_container;
            MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.icon_container);
            if (materialCardView != null) {
                i4 = R.id.labelContainer;
                LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.labelContainer);
                if (linearLayout != null) {
                    i4 = R.id.labelText;
                    EditText editText = (EditText) ViewBindings.findChildViewById(view, R.id.labelText);
                    if (editText != null) {
                        i4 = R.id.magicTextButton;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                        if (button != null) {
                            i4 = R.id.offRadioButton;
                            RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.offRadioButton);
                            if (radioButton != null) {
                                i4 = R.id.onRadioButton;
                                RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.onRadioButton);
                                if (radioButton2 != null) {
                                    i4 = R.id.radioGroupOnOff;
                                    RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(view, R.id.radioGroupOnOff);
                                    if (radioGroup != null) {
                                        i4 = R.id.setIconCheckBox;
                                        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.setIconCheckBox);
                                        if (checkBox != null) {
                                            i4 = R.id.setLabelCheckBox;
                                            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.setLabelCheckBox);
                                            if (checkBox2 != null) {
                                                i4 = R.id.setOnOffStateCheckBox;
                                                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.setOnOffStateCheckBox);
                                                if (checkBox3 != null) {
                                                    return new DialogQuickTileConfigureBinding((ConstraintLayout) view, imageView, materialCardView, linearLayout, editText, button, radioButton, radioButton2, radioGroup, checkBox, checkBox2, checkBox3);
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
    public static DialogQuickTileConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogQuickTileConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_quick_tile_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ConstraintLayout getRoot() {
        return this.f11113a;
    }
}
