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
public final class DrawerItemLogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11178a;
    @NonNull
    public final ImageView dragHandle;
    @NonNull
    public final LinearLayout logContainer;
    @NonNull
    public final TextView logText;
    @NonNull
    public final TextView title;

    private DrawerItemLogBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11178a = linearLayout;
        this.dragHandle = imageView;
        this.logContainer = linearLayout2;
        this.logText = textView;
        this.title = textView2;
    }

    @NonNull
    public static DrawerItemLogBinding bind(@NonNull View view) {
        int i4 = R.id.drag_handle;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.drag_handle);
        if (imageView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i4 = R.id.log_text;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.log_text);
            if (textView != null) {
                i4 = R.id.title;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.title);
                if (textView2 != null) {
                    return new DrawerItemLogBinding(linearLayout, imageView, linearLayout, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DrawerItemLogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DrawerItemLogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.drawer_item_log, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11178a;
    }
}
