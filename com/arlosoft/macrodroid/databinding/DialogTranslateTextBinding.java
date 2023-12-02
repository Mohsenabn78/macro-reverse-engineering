package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.widget.NDSpinner;

/* loaded from: classes3.dex */
public final class DialogTranslateTextBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11147a;
    @NonNull
    public final Button addStringVariableButton;
    @NonNull
    public final TextView downloadOutputModel;
    @NonNull
    public final TextView downloadSourceModel;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final Spinner outputLanguageSpinner;
    @NonNull
    public final Spinner sourceLanguageSpinner;
    @NonNull
    public final NDSpinner stringVariableSpinner;
    @NonNull
    public final Button testButton;
    @NonNull
    public final AppCompatEditText textToTranslate;

    private DialogTranslateTextBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull TextView textView, @NonNull TextView textView2, @NonNull Button button2, @NonNull Spinner spinner, @NonNull Spinner spinner2, @NonNull NDSpinner nDSpinner, @NonNull Button button3, @NonNull AppCompatEditText appCompatEditText) {
        this.f11147a = linearLayout;
        this.addStringVariableButton = button;
        this.downloadOutputModel = textView;
        this.downloadSourceModel = textView2;
        this.magicTextButton = button2;
        this.outputLanguageSpinner = spinner;
        this.sourceLanguageSpinner = spinner2;
        this.stringVariableSpinner = nDSpinner;
        this.testButton = button3;
        this.textToTranslate = appCompatEditText;
    }

    @NonNull
    public static DialogTranslateTextBinding bind(@NonNull View view) {
        int i4 = R.id.addStringVariableButton;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.addStringVariableButton);
        if (button != null) {
            i4 = R.id.downloadOutputModel;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.downloadOutputModel);
            if (textView != null) {
                i4 = R.id.downloadSourceModel;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.downloadSourceModel);
                if (textView2 != null) {
                    i4 = R.id.magicTextButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                    if (button2 != null) {
                        i4 = R.id.outputLanguageSpinner;
                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.outputLanguageSpinner);
                        if (spinner != null) {
                            i4 = R.id.sourceLanguageSpinner;
                            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.sourceLanguageSpinner);
                            if (spinner2 != null) {
                                i4 = R.id.stringVariableSpinner;
                                NDSpinner nDSpinner = (NDSpinner) ViewBindings.findChildViewById(view, R.id.stringVariableSpinner);
                                if (nDSpinner != null) {
                                    i4 = R.id.testButton;
                                    Button button3 = (Button) ViewBindings.findChildViewById(view, R.id.testButton);
                                    if (button3 != null) {
                                        i4 = R.id.textToTranslate;
                                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.textToTranslate);
                                        if (appCompatEditText != null) {
                                            return new DialogTranslateTextBinding((LinearLayout) view, button, textView, textView2, button2, spinner, spinner2, nDSpinner, button3, appCompatEditText);
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
    public static DialogTranslateTextBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogTranslateTextBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_translate_text, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11147a;
    }
}
