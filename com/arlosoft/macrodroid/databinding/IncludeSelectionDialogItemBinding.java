package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes3.dex */
public final class IncludeSelectionDialogItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11266a;
    @NonNull
    public final Button actionButtonLabelMagicTextButton;
    @NonNull
    public final CheckBox boldCheckbox;
    @NonNull
    public final MaterialCardView colorButton;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final CheckBox italicCheckbox;
    @NonNull
    public final TextView itemLabel;
    @NonNull
    public final TextInputEditText itemText;

    private IncludeSelectionDialogItemBinding(@NonNull FrameLayout frameLayout, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull MaterialCardView materialCardView, @NonNull ImageView imageView, @NonNull CheckBox checkBox2, @NonNull TextView textView, @NonNull TextInputEditText textInputEditText) {
        this.f11266a = frameLayout;
        this.actionButtonLabelMagicTextButton = button;
        this.boldCheckbox = checkBox;
        this.colorButton = materialCardView;
        this.deleteButton = imageView;
        this.italicCheckbox = checkBox2;
        this.itemLabel = textView;
        this.itemText = textInputEditText;
    }

    @NonNull
    public static IncludeSelectionDialogItemBinding bind(@NonNull View view) {
        int i4 = R.id.actionButtonLabelMagicTextButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.actionButtonLabelMagicTextButton);
        if (button != null) {
            i4 = R.id.bold_checkbox;
            CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.bold_checkbox);
            if (checkBox != null) {
                i4 = R.id.color_button;
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.color_button);
                if (materialCardView != null) {
                    i4 = R.id.delete_button;
                    ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delete_button);
                    if (imageView != null) {
                        i4 = R.id.italic_checkbox;
                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.italic_checkbox);
                        if (checkBox2 != null) {
                            i4 = R.id.item_label;
                            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.item_label);
                            if (textView != null) {
                                i4 = R.id.item_text;
                                TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.item_text);
                                if (textInputEditText != null) {
                                    return new IncludeSelectionDialogItemBinding((FrameLayout) view, button, checkBox, materialCardView, imageView, checkBox2, textView, textInputEditText);
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
    public static IncludeSelectionDialogItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeSelectionDialogItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_selection_dialog_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11266a;
    }
}
