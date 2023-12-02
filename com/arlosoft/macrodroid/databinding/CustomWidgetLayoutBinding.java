package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class CustomWidgetLayoutBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11011a;
    @NonNull
    public final ImageButton customWidgetButton;
    @NonNull
    public final ImageButton customWidgetButtonFaded;
    @NonNull
    public final TextView customWidgetLabel;
    @Nullable
    public final LinearLayout linearLayout1;

    private CustomWidgetLayoutBinding(@NonNull FrameLayout frameLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull TextView textView, @Nullable LinearLayout linearLayout) {
        this.f11011a = frameLayout;
        this.customWidgetButton = imageButton;
        this.customWidgetButtonFaded = imageButton2;
        this.customWidgetLabel = textView;
        this.linearLayout1 = linearLayout;
    }

    @NonNull
    public static CustomWidgetLayoutBinding bind(@NonNull View view) {
        int i4 = R.id.custom_widget_button;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.custom_widget_button);
        if (imageButton != null) {
            i4 = R.id.custom_widget_button_faded;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.custom_widget_button_faded);
            if (imageButton2 != null) {
                i4 = R.id.custom_widget_label;
                TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.custom_widget_label);
                if (textView != null) {
                    return new CustomWidgetLayoutBinding((FrameLayout) view, imageButton, imageButton2, textView, (LinearLayout) ViewBindings.findChildViewById(view, R.id.linearLayout1));
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static CustomWidgetLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static CustomWidgetLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.custom_widget_layout, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11011a;
    }
}
