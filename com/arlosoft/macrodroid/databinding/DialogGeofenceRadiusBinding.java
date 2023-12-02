package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogGeofenceRadiusBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11074a;
    @NonNull
    public final AppCompatEditText radiusValue;

    private DialogGeofenceRadiusBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText) {
        this.f11074a = linearLayout;
        this.radiusValue = appCompatEditText;
    }

    @NonNull
    public static DialogGeofenceRadiusBinding bind(@NonNull View view) {
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.radius_value);
        if (appCompatEditText != null) {
            return new DialogGeofenceRadiusBinding((LinearLayout) view, appCompatEditText);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.radius_value)));
    }

    @NonNull
    public static DialogGeofenceRadiusBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogGeofenceRadiusBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_geofence_radius, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11074a;
    }
}
