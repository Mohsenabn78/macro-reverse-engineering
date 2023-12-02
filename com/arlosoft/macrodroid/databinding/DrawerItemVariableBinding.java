package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DrawerItemVariableBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11184a;
    @NonNull
    public final ImageView dragHandle;
    @NonNull
    public final TextView varName;
    @NonNull
    public final TextView varValue;
    @NonNull
    public final LinearLayout variableContainer;

    private DrawerItemVariableBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull LinearLayout linearLayout2) {
        this.f11184a = linearLayout;
        this.dragHandle = imageView;
        this.varName = textView;
        this.varValue = textView2;
        this.variableContainer = linearLayout2;
    }

    @NonNull
    public static DrawerItemVariableBinding bind(@NonNull View view) {
        int i4 = R.id.drag_handle;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.drag_handle);
        if (imageView != null) {
            i4 = R.id.var_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.var_name);
            if (textView != null) {
                i4 = R.id.var_value;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.var_value);
                if (textView2 != null) {
                    LinearLayout linearLayout = (LinearLayout) view;
                    return new DrawerItemVariableBinding(linearLayout, imageView, textView, textView2, linearLayout);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DrawerItemVariableBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DrawerItemVariableBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.drawer_item_variable, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11184a;
    }
}
