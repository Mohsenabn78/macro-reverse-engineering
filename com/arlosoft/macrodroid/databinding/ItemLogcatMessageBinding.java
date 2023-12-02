package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ItemLogcatMessageBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11278a;
    @NonNull
    public final TextView componentName;
    @NonNull
    public final LinearLayout container;
    @NonNull
    public final TextView message;

    private ItemLogcatMessageBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout2, @NonNull TextView textView2) {
        this.f11278a = linearLayout;
        this.componentName = textView;
        this.container = linearLayout2;
        this.message = textView2;
    }

    @NonNull
    public static ItemLogcatMessageBinding bind(@NonNull View view) {
        int i4 = R.id.componentName;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.componentName);
        if (textView != null) {
            LinearLayout linearLayout = (LinearLayout) view;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.message);
            if (textView2 != null) {
                return new ItemLogcatMessageBinding(linearLayout, textView, linearLayout, textView2);
            }
            i4 = R.id.message;
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ItemLogcatMessageBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ItemLogcatMessageBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.item_logcat_message, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11278a;
    }
}
