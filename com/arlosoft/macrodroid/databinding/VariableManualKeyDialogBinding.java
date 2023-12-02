package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class VariableManualKeyDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11400a;
    @NonNull
    public final TextView descriptionText;
    @NonNull
    public final TextView forceArrayText;
    @NonNull
    public final TextView fullVarTitle;
    @NonNull
    public final TextView fullVariableText;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final AppCompatEditText manualKeysEntry;
    @NonNull
    public final ImageView validIndicator;
    @NonNull
    public final Spinner valueTypeSpinner;
    @NonNull
    public final LinearLayout variableTypeContainer;

    private VariableManualKeyDialogBinding(@NonNull ScrollView scrollView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull TextView textView3, @NonNull TextView textView4, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText, @NonNull ImageView imageView, @NonNull Spinner spinner, @NonNull LinearLayout linearLayout) {
        this.f11400a = scrollView;
        this.descriptionText = textView;
        this.forceArrayText = textView2;
        this.fullVarTitle = textView3;
        this.fullVariableText = textView4;
        this.magicTextButton = button;
        this.manualKeysEntry = appCompatEditText;
        this.validIndicator = imageView;
        this.valueTypeSpinner = spinner;
        this.variableTypeContainer = linearLayout;
    }

    @NonNull
    public static VariableManualKeyDialogBinding bind(@NonNull View view) {
        int i4 = R.id.descriptionText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.descriptionText);
        if (textView != null) {
            i4 = R.id.forceArrayText;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.forceArrayText);
            if (textView2 != null) {
                i4 = R.id.fullVarTitle;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.fullVarTitle);
                if (textView3 != null) {
                    i4 = R.id.fullVariableText;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view, R.id.fullVariableText);
                    if (textView4 != null) {
                        i4 = R.id.magicTextButton;
                        Button button = (Button) ViewBindings.findChildViewById(view, R.id.magicTextButton);
                        if (button != null) {
                            i4 = R.id.manualKeysEntry;
                            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.manualKeysEntry);
                            if (appCompatEditText != null) {
                                i4 = R.id.validIndicator;
                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.validIndicator);
                                if (imageView != null) {
                                    i4 = R.id.valueTypeSpinner;
                                    Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.valueTypeSpinner);
                                    if (spinner != null) {
                                        i4 = R.id.variableTypeContainer;
                                        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.variableTypeContainer);
                                        if (linearLayout != null) {
                                            return new VariableManualKeyDialogBinding((ScrollView) view, textView, textView2, textView3, textView4, button, appCompatEditText, imageView, spinner, linearLayout);
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
    public static VariableManualKeyDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static VariableManualKeyDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.variable_manual_key_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11400a;
    }
}
