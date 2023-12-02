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
public final class DrawerItemAppShortcutBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11177a;
    @NonNull
    public final TextView appName;
    @NonNull
    public final ImageView dragHandle;
    @NonNull
    public final LinearLayout macroContainer;

    private DrawerItemAppShortcutBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2) {
        this.f11177a = linearLayout;
        this.appName = textView;
        this.dragHandle = imageView;
        this.macroContainer = linearLayout2;
    }

    @NonNull
    public static DrawerItemAppShortcutBinding bind(@NonNull View view) {
        int i4 = R.id.app_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.app_name);
        if (textView != null) {
            i4 = R.id.drag_handle;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.drag_handle);
            if (imageView != null) {
                LinearLayout linearLayout = (LinearLayout) view;
                return new DrawerItemAppShortcutBinding(linearLayout, textView, imageView, linearLayout);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DrawerItemAppShortcutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DrawerItemAppShortcutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.drawer_item_app_shortcut, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11177a;
    }
}
