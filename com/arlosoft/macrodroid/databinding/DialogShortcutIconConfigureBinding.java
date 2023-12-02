package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.card.MaterialCardView;

/* loaded from: classes3.dex */
public final class DialogShortcutIconConfigureBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11128a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final MaterialCardView iconTintColorCircle;
    @NonNull
    public final Button okButton;
    @NonNull
    public final Button shortcutIconConfigureChangeButton;
    @NonNull
    public final ImageView shortcutIconConfigureIcon;
    @NonNull
    public final CheckBox tintIconCheckbox;
    @NonNull
    public final TextView xiaomiWarning;

    private DialogShortcutIconConfigureBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull MaterialCardView materialCardView, @NonNull Button button2, @NonNull Button button3, @NonNull ImageView imageView, @NonNull CheckBox checkBox, @NonNull TextView textView) {
        this.f11128a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.iconTintColorCircle = materialCardView;
        this.okButton = button2;
        this.shortcutIconConfigureChangeButton = button3;
        this.shortcutIconConfigureIcon = imageView;
        this.tintIconCheckbox = checkBox;
        this.xiaomiWarning = textView;
    }

    @NonNull
    public static DialogShortcutIconConfigureBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.iconTintColorCircle;
                MaterialCardView materialCardView = (MaterialCardView) ViewBindings.findChildViewById(view, R.id.iconTintColorCircle);
                if (materialCardView != null) {
                    i4 = R.id.okButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                    if (button2 != null) {
                        i4 = R.id.shortcut_icon_configure_change_button;
                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.shortcut_icon_configure_change_button);
                        if (button3 != null) {
                            i4 = R.id.shortcut_icon_configure_icon;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.shortcut_icon_configure_icon);
                            if (imageView != null) {
                                i4 = R.id.tint_icon_checkbox;
                                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.tint_icon_checkbox);
                                if (checkBox != null) {
                                    i4 = R.id.xiaomi_warning;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.xiaomi_warning);
                                    if (textView != null) {
                                        return new DialogShortcutIconConfigureBinding((LinearLayout) view, linearLayout, button, materialCardView, button2, button3, imageView, checkBox, textView);
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
    public static DialogShortcutIconConfigureBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogShortcutIconConfigureBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_shortcut_icon_configure, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11128a;
    }
}
