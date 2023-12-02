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
public final class DialogLogcatTextToMatchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11089a;
    @NonNull
    public final CheckBox bufferCrashCheckbox;
    @NonNull
    public final CheckBox bufferEventsCheckbox;
    @NonNull
    public final CheckBox bufferKernelCheckbox;
    @NonNull
    public final CheckBox bufferMainCheckbox;
    @NonNull
    public final CheckBox bufferRadioCheckbox;
    @NonNull
    public final CheckBox bufferSystemCheckbox;
    @NonNull
    public final IncludeOkCancelButtonsBinding buttonBar;
    @NonNull
    public final Button captureMessagesButton;
    @NonNull
    public final Button componentMagicTextButton;
    @NonNull
    public final AppCompatEditText componentName;
    @NonNull
    public final TextView enabledBuffers;
    @NonNull
    public final CheckBox ignoreCase;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final AppCompatEditText textToMatch;
    @NonNull
    public final TextView wildcardText;

    private DialogLogcatTextToMatchBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox, @NonNull CheckBox checkBox2, @NonNull CheckBox checkBox3, @NonNull CheckBox checkBox4, @NonNull CheckBox checkBox5, @NonNull CheckBox checkBox6, @NonNull IncludeOkCancelButtonsBinding includeOkCancelButtonsBinding, @NonNull Button button, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText, @NonNull TextView textView, @NonNull CheckBox checkBox7, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText2, @NonNull TextView textView2) {
        this.f11089a = scrollView;
        this.bufferCrashCheckbox = checkBox;
        this.bufferEventsCheckbox = checkBox2;
        this.bufferKernelCheckbox = checkBox3;
        this.bufferMainCheckbox = checkBox4;
        this.bufferRadioCheckbox = checkBox5;
        this.bufferSystemCheckbox = checkBox6;
        this.buttonBar = includeOkCancelButtonsBinding;
        this.captureMessagesButton = button;
        this.componentMagicTextButton = button2;
        this.componentName = appCompatEditText;
        this.enabledBuffers = textView;
        this.ignoreCase = checkBox7;
        this.magicTextButton = button3;
        this.textToMatch = appCompatEditText2;
        this.wildcardText = textView2;
    }

    @NonNull
    public static DialogLogcatTextToMatchBinding bind(@NonNull View view) {
        int i4 = R.id.bufferCrashCheckbox;
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.bufferCrashCheckbox);
        if (checkBox != null) {
            i4 = R.id.bufferEventsCheckbox;
            CheckBox checkBox2 = (CheckBox) ViewBindings.findChildViewById(view, R.id.bufferEventsCheckbox);
            if (checkBox2 != null) {
                i4 = R.id.bufferKernelCheckbox;
                CheckBox checkBox3 = (CheckBox) ViewBindings.findChildViewById(view, R.id.bufferKernelCheckbox);
                if (checkBox3 != null) {
                    i4 = R.id.bufferMainCheckbox;
                    CheckBox checkBox4 = (CheckBox) ViewBindings.findChildViewById(view, R.id.bufferMainCheckbox);
                    if (checkBox4 != null) {
                        i4 = R.id.bufferRadioCheckbox;
                        CheckBox checkBox5 = (CheckBox) ViewBindings.findChildViewById(view, R.id.bufferRadioCheckbox);
                        if (checkBox5 != null) {
                            i4 = R.id.bufferSystemCheckbox;
                            CheckBox checkBox6 = (CheckBox) ViewBindings.findChildViewById(view, R.id.bufferSystemCheckbox);
                            if (checkBox6 != null) {
                                i4 = R.id.buttonBar;
                                View findChildViewById = ViewBindings.findChildViewById(view, R.id.buttonBar);
                                if (findChildViewById != null) {
                                    IncludeOkCancelButtonsBinding bind = IncludeOkCancelButtonsBinding.bind(findChildViewById);
                                    i4 = R.id.captureMessagesButton;
                                    Button button = (Button) ViewBindings.findChildViewById(view, R.id.captureMessagesButton);
                                    if (button != null) {
                                        i4 = R.id.componentMagicTextButton;
                                        Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.componentMagicTextButton);
                                        if (button2 != null) {
                                            i4 = R.id.componentName;
                                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.componentName);
                                            if (appCompatEditText != null) {
                                                i4 = R.id.enabledBuffers;
                                                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.enabledBuffers);
                                                if (textView != null) {
                                                    i4 = R.id.ignore_case;
                                                    CheckBox checkBox7 = (CheckBox) ViewBindings.findChildViewById(view, R.id.ignore_case);
                                                    if (checkBox7 != null) {
                                                        i4 = R.id.magicTextButton;
                                                        Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                                                        if (button3 != null) {
                                                            i4 = R.id.textToMatch;
                                                            AppCompatEditText appCompatEditText2 = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.textToMatch);
                                                            if (appCompatEditText2 != null) {
                                                                i4 = R.id.wildcard_Text;
                                                                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.wildcard_Text);
                                                                if (textView2 != null) {
                                                                    return new DialogLogcatTextToMatchBinding((ScrollView) view, checkBox, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, bind, button, button2, appCompatEditText, textView, checkBox7, button3, appCompatEditText2, textView2);
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
    public static DialogLogcatTextToMatchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogLogcatTextToMatchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_logcat_text_to_match, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11089a;
    }
}
