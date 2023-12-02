package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogLockCategoryBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11088a;
    @NonNull
    public final LinearLayout buttonBar;
    @NonNull
    public final Button cancelButton;
    @NonNull
    public final TextView lockCategoryInfo;
    @NonNull
    public final Button lockCateogryButton;
    @NonNull
    public final AppCompatEditText passwordEntry;

    private DialogLockCategoryBinding(@NonNull LinearLayout linearLayout, @NonNull LinearLayout linearLayout2, @NonNull Button button, @NonNull TextView textView, @NonNull Button button2, @NonNull AppCompatEditText appCompatEditText) {
        this.f11088a = linearLayout;
        this.buttonBar = linearLayout2;
        this.cancelButton = button;
        this.lockCategoryInfo = textView;
        this.lockCateogryButton = button2;
        this.passwordEntry = appCompatEditText;
    }

    @NonNull
    public static DialogLockCategoryBinding bind(@NonNull View view) {
        int i4 = R.id.button_bar;
        LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.button_bar);
        if (linearLayout != null) {
            i4 = R.id.cancelButton;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.cancelButton);
            if (button != null) {
                i4 = R.id.lockCategoryInfo;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.lockCategoryInfo);
                if (textView != null) {
                    i4 = R.id.lockCateogryButton;
                    Button button2 = (Button) ViewBindings.findChildViewById(view, R.id.lockCateogryButton);
                    if (button2 != null) {
                        i4 = R.id.passwordEntry;
                        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.passwordEntry);
                        if (appCompatEditText != null) {
                            return new DialogLockCategoryBinding((LinearLayout) view, linearLayout, button, textView, button2, appCompatEditText);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogLockCategoryBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogLockCategoryBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_lock_category, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11088a;
    }
}
