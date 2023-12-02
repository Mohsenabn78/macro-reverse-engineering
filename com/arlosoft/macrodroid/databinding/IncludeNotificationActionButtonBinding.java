package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputEditText;

/* loaded from: classes3.dex */
public final class IncludeNotificationActionButtonBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11260a;
    @NonNull
    public final TextInputEditText actionButtonLabel;
    @NonNull
    public final Button actionButtonLabelMagicTextButton;
    @NonNull
    public final CheckBox clearOnPress;
    @NonNull
    public final Button configInputOutputParams;
    @NonNull
    public final ImageView deleteButton;
    @NonNull
    public final Spinner macroSpinner;
    @NonNull
    public final TextView optionText;

    private IncludeNotificationActionButtonBinding(@NonNull FrameLayout frameLayout, @NonNull TextInputEditText textInputEditText, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull Button button2, @NonNull ImageView imageView, @NonNull Spinner spinner, @NonNull TextView textView) {
        this.f11260a = frameLayout;
        this.actionButtonLabel = textInputEditText;
        this.actionButtonLabelMagicTextButton = button;
        this.clearOnPress = checkBox;
        this.configInputOutputParams = button2;
        this.deleteButton = imageView;
        this.macroSpinner = spinner;
        this.optionText = textView;
    }

    @NonNull
    public static IncludeNotificationActionButtonBinding bind(@NonNull View view) {
        int i4 = R.id.actionButtonLabel;
        TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.actionButtonLabel);
        if (textInputEditText != null) {
            i4 = R.id.actionButtonLabelMagicTextButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.actionButtonLabelMagicTextButton);
            if (button != null) {
                i4 = R.id.clearOnPress;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.clearOnPress);
                if (checkBox != null) {
                    i4 = R.id.configInputOutputParams;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configInputOutputParams);
                    if (button2 != null) {
                        i4 = R.id.delete_button;
                        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.delete_button);
                        if (imageView != null) {
                            i4 = R.id.macroSpinner;
                            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.macroSpinner);
                            if (spinner != null) {
                                i4 = R.id.option_text;
                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.option_text);
                                if (textView != null) {
                                    return new IncludeNotificationActionButtonBinding((FrameLayout) view, textInputEditText, button, checkBox, button2, imageView, spinner, textView);
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
    public static IncludeNotificationActionButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeNotificationActionButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_notification_action_button, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11260a;
    }
}
