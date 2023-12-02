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
public final class ListItemPluginBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11304a;
    @NonNull
    public final TextView conditionEventLabel;
    @NonNull
    public final LinearLayout pluginContainer;
    @NonNull
    public final ImageView pluginIcon;
    @NonNull
    public final TextView pluginName;

    private ListItemPluginBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f11304a = linearLayout;
        this.conditionEventLabel = textView;
        this.pluginContainer = linearLayout2;
        this.pluginIcon = imageView;
        this.pluginName = textView2;
    }

    @NonNull
    public static ListItemPluginBinding bind(@NonNull View view) {
        int i4 = R.id.conditionEventLabel;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.conditionEventLabel);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            i4 = R.id.pluginIcon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.pluginIcon);
            if (imageView != null) {
                i4 = R.id.pluginName;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.pluginName);
                if (textView2 != null) {
                    return new ListItemPluginBinding(linearLayout, textView, linearLayout, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemPluginBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemPluginBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_plugin, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11304a;
    }
}
