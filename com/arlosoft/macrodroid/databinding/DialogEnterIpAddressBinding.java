package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogEnterIpAddressBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11058a;
    @NonNull
    public final Button magicTextButton;
    @NonNull
    public final AppCompatEditText text;

    private DialogEnterIpAddressBinding(@NonNull LinearLayout linearLayout, @NonNull Button button, @NonNull AppCompatEditText appCompatEditText) {
        this.f11058a = linearLayout;
        this.magicTextButton = button;
        this.text = appCompatEditText;
    }

    @NonNull
    public static DialogEnterIpAddressBinding bind(@NonNull View view) {
        int i4 = R.id.magic_text_button;
        Button button = (Button) ViewBindings.findChildViewById(view, R.id.magic_text_button);
        if (button != null) {
            i4 = R.id.text;
            AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.text);
            if (appCompatEditText != null) {
                return new DialogEnterIpAddressBinding((LinearLayout) view, button, appCompatEditText);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogEnterIpAddressBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogEnterIpAddressBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_enter_ip_address, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11058a;
    }
}
