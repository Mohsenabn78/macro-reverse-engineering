package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogSystemSettingTriggerBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11140a;
    @NonNull
    public final CheckBox globalCheckbox;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final TextView notificationTextDialogWildcardsInfo;
    @NonNull
    public final AppCompatEditText patternText;
    @NonNull
    public final CheckBox regexCheckbox;
    @NonNull
    public final CheckBox secureCheckbox;
    @NonNull
    public final CheckBox systemCheckbox;

    private DialogSystemSettingTriggerBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull Button button, @NonNull TextView textView, @NonNull AppCompatEditText appCompatEditText, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4) {
        this.f11140a = scrollView;
        this.globalCheckbox = checkBox;
        this.magicTextButton = button;
        this.notificationTextDialogWildcardsInfo = textView;
        this.patternText = appCompatEditText;
        this.regexCheckbox = checkBox2;
        this.secureCheckbox = checkBox3;
        this.systemCheckbox = checkBox4;
    }

    @NonNull
    public static DialogSystemSettingTriggerBinding bind(@NonNull View view) {
        int i4 = R.id.globalCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.globalCheckbox);
        if (checkBox != null) {
            i4 = R.id.magicTextButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
            if (button != null) {
                i4 = R.id.notification_text_dialog_wildcards_info;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.notification_text_dialog_wildcards_info);
                if (textView != null) {
                    i4 = R.id.patternText;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.patternText);
                    if (appCompatEditText != null) {
                        i4 = R.id.regexCheckbox;
                        CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.regexCheckbox);
                        if (checkBox2 != null) {
                            i4 = R.id.secureCheckbox;
                            CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.secureCheckbox);
                            if (checkBox3 != null) {
                                i4 = R.id.systemCheckbox;
                                CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.systemCheckbox);
                                if (checkBox4 != null) {
                                    return new DialogSystemSettingTriggerBinding((ScrollView) view, checkBox, button, textView, appCompatEditText, checkBox2, checkBox3, checkBox4);
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
    public static DialogSystemSettingTriggerBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogSystemSettingTriggerBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_system_setting_trigger, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11140a;
    }
}
