package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class EnterNameAndCategoryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11200a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final ImageView enterNameAndCategoryHelp;
    @NonNull
    public final AppCompatEditText enterNameAndCategoryName;
    @NonNull
    public final Spinner enterNameAndCategorySpinner;
    @NonNull
    public final Button okButton;

    private EnterNameAndCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull ImageView imageView, @NonNull AppCompatEditText appCompatEditText, @NonNull Spinner spinner, @NonNull Button button2) {
        this.f11200a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.enterNameAndCategoryHelp = imageView;
        this.enterNameAndCategoryName = appCompatEditText;
        this.enterNameAndCategorySpinner = spinner;
        this.okButton = button2;
    }

    @NonNull
    public static EnterNameAndCategoryBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.enter_name_and_category_help;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.enter_name_and_category_help);
                if (imageView != null) {
                    i4 = R.id.enter_name_and_category_name;
                    AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.enter_name_and_category_name);
                    if (appCompatEditText != null) {
                        i4 = R.id.enter_name_and_category_spinner;
                        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.enter_name_and_category_spinner);
                        if (spinner != null) {
                            i4 = R.id.okButton;
                            Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.okButton);
                            if (button2 != null) {
                                return new EnterNameAndCategoryBinding((LinearLayout) view, linearLayout, button, imageView, appCompatEditText, spinner, button2);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static EnterNameAndCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static EnterNameAndCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.enter_name_and_category, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11200a;
    }
}
