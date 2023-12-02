package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ConfigureLogMessageBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10999a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final CheckBox configureLogDateAndTime;
    @NonNull
    public final Button configureLogMessageMagicTextButton;
    @NonNull
    public final AppCompatEditText configureLogMessageText;
    @NonNull
    public final Button okButton;

    private ConfigureLogMessageBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull CheckBox checkBox, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull Button button3) {
        this.f10999a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.configureLogDateAndTime = checkBox;
        this.configureLogMessageMagicTextButton = button2;
        this.configureLogMessageText = appCompatEditText;
        this.okButton = button3;
    }

    @NonNull
    public static ConfigureLogMessageBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.configure_log_date_and_time;
                CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.configure_log_date_and_time);
                if (checkBox != null) {
                    i4 = R.id.configure_log_message_magic_text_button;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.configure_log_message_magic_text_button);
                    if (button2 != null) {
                        i4 = R.id.configure_log_message_text;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.configure_log_message_text);
                        if (appCompatEditText != null) {
                            i4 = R.id.okButton;
                            Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button3 != null) {
                                return new ConfigureLogMessageBinding((LinearLayout) view, linearLayout, button, checkBox, button2, appCompatEditText, button3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ConfigureLogMessageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ConfigureLogMessageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.configure_log_message, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10999a;
    }
}
