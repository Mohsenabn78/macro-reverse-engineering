package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

/* loaded from: classes3.dex */
public final class DialogConfigureDrawerItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11037a;
    @NonNull
    public final CheckBox closeOnPress;
    @NonNull
    public final Button configInputOutputParams;
    @NonNull
    public final FrameLayout drawerItemContent;
    @NonNull
    public final CheckBox hideName;
    @NonNull
    public final CheckBox ignoreConstraints;
    @NonNull
    public final TextInputEditText maxLines;
    @NonNull
    public final TextInputLayout maxLinesLayout;
    @NonNull
    public final Button setColorButton;
    @NonNull
    public final Button setIconButton;
    @NonNull
    public final Button setTextButton;
    @NonNull
    public final CheckBox showIcon;
    @NonNull
    public final FrameLayout textColorFrame;

    private DialogConfigureDrawerItemBinding(@NonNull LinearLayout linearLayout, @NonNull CheckBox checkBox, @NonNull Button button, @NonNull FrameLayout frameLayout, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull TextInputEditText textInputEditText, @NonNull TextInputLayout textInputLayout, @NonNull Button button2, @NonNull Button button3, @NonNull Button button4, @NonNull CheckBox checkBox4, @NonNull FrameLayout frameLayout2) {
        this.f11037a = linearLayout;
        this.closeOnPress = checkBox;
        this.configInputOutputParams = button;
        this.drawerItemContent = frameLayout;
        this.hideName = checkBox2;
        this.ignoreConstraints = checkBox3;
        this.maxLines = textInputEditText;
        this.maxLinesLayout = textInputLayout;
        this.setColorButton = button2;
        this.setIconButton = button3;
        this.setTextButton = button4;
        this.showIcon = checkBox4;
        this.textColorFrame = frameLayout2;
    }

    @NonNull
    public static DialogConfigureDrawerItemBinding bind(@NonNull View view) {
        int i4 = R.id.close_on_press;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.close_on_press);
        if (checkBox != null) {
            i4 = R.id.configInputOutputParams;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.configInputOutputParams);
            if (button != null) {
                i4 = R.id.drawer_item_content;
                FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.drawer_item_content);
                if (frameLayout != null) {
                    i4 = R.id.hide_name;
                    CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.hide_name);
                    if (checkBox2 != null) {
                        i4 = R.id.ignore_constraints;
                        CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_constraints);
                        if (checkBox3 != null) {
                            i4 = R.id.max_lines;
                            TextInputEditText textInputEditText = (TextInputEditText) ViewBindings.findChildViewById(view, R.id.max_lines);
                            if (textInputEditText != null) {
                                i4 = R.id.max_lines_layout;
                                TextInputLayout textInputLayout = (TextInputLayout) ViewBindings.findChildViewById(view, R.id.max_lines_layout);
                                if (textInputLayout != null) {
                                    i4 = R.id.set_color_button;
                                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.set_color_button);
                                    if (button2 != null) {
                                        i4 = R.id.set_icon_button;
                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.set_icon_button);
                                        if (button3 != null) {
                                            i4 = R.id.set_text_button;
                                            Button button4 = (Button) ViewBindings.findChildViewById(view, R.id.set_text_button);
                                            if (button4 != null) {
                                                i4 = R.id.show_icon;
                                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.show_icon);
                                                if (checkBox4 != null) {
                                                    i4 = R.id.textColorFrame;
                                                    FrameLayout frameLayout2 = (FrameLayout) ViewBindings.findChildViewById(view, R.id.textColorFrame);
                                                    if (frameLayout2 != null) {
                                                        return new DialogConfigureDrawerItemBinding((LinearLayout) view, checkBox, button, frameLayout, checkBox2, checkBox3, textInputEditText, textInputLayout, button2, button3, button4, checkBox4, frameLayout2);
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
    public static DialogConfigureDrawerItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogConfigureDrawerItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_configure_drawer_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11037a;
    }
}
