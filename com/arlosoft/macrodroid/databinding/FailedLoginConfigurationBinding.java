package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FailedLoginConfigurationBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11214a;
    @NonNull
    public final Spinner failedLoginConfigCountSpinner;
    @NonNull
    public final Spinner failedLoginConfigTimespanSpinner;

    private FailedLoginConfigurationBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull Spinner spinner2) {
        this.f11214a = linearLayout;
        this.failedLoginConfigCountSpinner = spinner;
        this.failedLoginConfigTimespanSpinner = spinner2;
    }

    @NonNull
    public static FailedLoginConfigurationBinding bind(@NonNull View view) {
        int i4 = R.id.failed_login_config_count_spinner;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.failed_login_config_count_spinner);
        if (spinner != null) {
            i4 = R.id.failed_login_config_timespan_spinner;
            Spinner spinner2 = (Spinner) ViewBindings.findChildViewById(view, R.id.failed_login_config_timespan_spinner);
            if (spinner2 != null) {
                return new FailedLoginConfigurationBinding((LinearLayout) view, spinner, spinner2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FailedLoginConfigurationBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FailedLoginConfigurationBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.failed_login_configuration, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11214a;
    }
}
