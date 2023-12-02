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
public final class ListitemDeviceBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11319a;
    @NonNull
    public final TextView deviceAddress;
    @NonNull
    public final TextView deviceName;

    private ListitemDeviceBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11319a = linearLayout;
        this.deviceAddress = textView;
        this.deviceName = textView2;
    }

    @NonNull
    public static ListitemDeviceBinding bind(@NonNull View view) {
        int i4 = R.id.device_address;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.device_address);
        if (textView != null) {
            i4 = R.id.device_name;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.device_name);
            if (textView2 != null) {
                return new ListitemDeviceBinding((LinearLayout) view, textView, textView2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static ListitemDeviceBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ListitemDeviceBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.listitem_device, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11319a;
    }
}
