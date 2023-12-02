package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ApplicationItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10986a;
    @NonNull
    public final ImageView applicationItemIcon;
    @NonNull
    public final TextView applicationItemName;
    @NonNull
    public final RadioButton applicationItemRadioButton;

    private ApplicationItemBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull RadioButton radioButton) {
        this.f10986a = linearLayout;
        this.applicationItemIcon = imageView;
        this.applicationItemName = textView;
        this.applicationItemRadioButton = radioButton;
    }

    @NonNull
    public static ApplicationItemBinding bind(@NonNull View view) {
        int i4 = R.id.application_item_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.application_item_icon);
        if (imageView != null) {
            i4 = R.id.application_item_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.application_item_name);
            if (textView != null) {
                i4 = R.id.application_item_radio_button;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.application_item_radio_button);
                if (radioButton != null) {
                    return new ApplicationItemBinding((LinearLayout) view, imageView, textView, radioButton);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ApplicationItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ApplicationItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.application_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10986a;
    }
}
