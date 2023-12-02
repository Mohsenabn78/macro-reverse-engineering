package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class AppListItemBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f10985a;
    @NonNull
    public final ImageView appIcon;
    @NonNull
    public final TextView appName;
    @NonNull
    public final TextView appPackage;
    @NonNull
    public final CheckBox checkbox;

    private AppListItemBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2, @NonNull CheckBox checkBox) {
        this.f10985a = linearLayout;
        this.appIcon = imageView;
        this.appName = textView;
        this.appPackage = textView2;
        this.checkbox = checkBox;
    }

    @NonNull
    public static AppListItemBinding bind(@NonNull View view) {
        int i4 = R.id.app_icon;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.app_icon);
        if (imageView != null) {
            i4 = R.id.app_name;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.app_name);
            if (textView != null) {
                i4 = R.id.app_package;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.app_package);
                if (textView2 != null) {
                    i4 = R.id.checkbox;
                    CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.checkbox);
                    if (checkBox != null) {
                        return new AppListItemBinding((LinearLayout) view, imageView, textView, textView2, checkBox);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static AppListItemBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static AppListItemBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.app_list_item, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f10985a;
    }
}
