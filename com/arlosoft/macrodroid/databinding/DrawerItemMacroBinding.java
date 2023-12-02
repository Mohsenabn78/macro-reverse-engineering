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
public final class DrawerItemMacroBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11179a;
    @NonNull
    public final ImageView dragHandle;
    @NonNull
    public final LinearLayout macroContainer;
    @NonNull
    public final TextView macroName;

    private DrawerItemMacroBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView) {
        this.f11179a = linearLayout;
        this.dragHandle = imageView;
        this.macroContainer = linearLayout2;
        this.macroName = textView;
    }

    @NonNull
    public static DrawerItemMacroBinding bind(@NonNull View view) {
        int i4 = R.id.drag_handle;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.drag_handle);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.macro_name);
            if (textView != null) {
                return new DrawerItemMacroBinding(linearLayout, imageView, linearLayout, textView);
            }
            i4 = R.id.macro_name;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DrawerItemMacroBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DrawerItemMacroBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.drawer_item_macro, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11179a;
    }
}
