package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class WidgetButtonBarBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f11427a;
    @NonNull
    public final ImageButton widgetButton1;
    @NonNull
    public final ImageButton widgetButton2;
    @NonNull
    public final ImageButton widgetButton3;
    @NonNull
    public final ImageButton widgetButton4;

    private WidgetButtonBarBinding(@NonNull FrameLayout frameLayout, @NonNull ImageButton imageButton, @NonNull ImageButton imageButton2, @NonNull ImageButton imageButton3, @NonNull ImageButton imageButton4) {
        this.f11427a = frameLayout;
        this.widgetButton1 = imageButton;
        this.widgetButton2 = imageButton2;
        this.widgetButton3 = imageButton3;
        this.widgetButton4 = imageButton4;
    }

    @NonNull
    public static WidgetButtonBarBinding bind(@NonNull View view) {
        int i4 = R.id.widget_button_1;
        ImageButton imageButton = (ImageButton) ViewBindings.findChildViewById(view, R.id.widget_button_1);
        if (imageButton != null) {
            i4 = R.id.widget_button_2;
            ImageButton imageButton2 = (ImageButton) ViewBindings.findChildViewById(view, R.id.widget_button_2);
            if (imageButton2 != null) {
                i4 = R.id.widget_button_3;
                ImageButton imageButton3 = (ImageButton) ViewBindings.findChildViewById(view, R.id.widget_button_3);
                if (imageButton3 != null) {
                    i4 = R.id.widget_button_4;
                    ImageButton imageButton4 = (ImageButton) ViewBindings.findChildViewById(view, R.id.widget_button_4);
                    if (imageButton4 != null) {
                        return new WidgetButtonBarBinding((FrameLayout) view, imageButton, imageButton2, imageButton3, imageButton4);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static WidgetButtonBarBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static WidgetButtonBarBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.widget_button_bar, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f11427a;
    }
}
