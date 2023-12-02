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
public final class ListItemAccountBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11286a;
    @NonNull
    public final TextView accountName;
    @NonNull
    public final ImageView appIcon;
    @NonNull
    public final TextView appName;

    private ListItemAccountBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2) {
        this.f11286a = linearLayout;
        this.accountName = textView;
        this.appIcon = imageView;
        this.appName = textView2;
    }

    @NonNull
    public static ListItemAccountBinding bind(@NonNull View view) {
        int i4 = R.id.account_name;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.account_name);
        if (textView != null) {
            i4 = R.id.app_icon;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.app_icon);
            if (imageView != null) {
                i4 = R.id.app_name;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.app_name);
                if (textView2 != null) {
                    return new ListItemAccountBinding((LinearLayout) view, textView, imageView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListItemAccountBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListItemAccountBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.list_item_account, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11286a;
    }
}
