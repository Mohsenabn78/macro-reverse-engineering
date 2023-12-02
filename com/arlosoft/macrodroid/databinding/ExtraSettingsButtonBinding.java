package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import com.arlosoft.macrodroid.R;
import com.google.android.material.button.MaterialButton;

/* loaded from: classes3.dex */
public final class ExtraSettingsButtonBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final MaterialButton f11213a;
    @NonNull
    public final MaterialButton settingsButton;

    private ExtraSettingsButtonBinding(@NonNull MaterialButton materialButton, @NonNull MaterialButton materialButton2) {
        this.f11213a = materialButton;
        this.settingsButton = materialButton2;
    }

    @NonNull
    public static ExtraSettingsButtonBinding bind(@NonNull View view) {
        if (view != null) {
            MaterialButton materialButton = (MaterialButton) view;
            return new ExtraSettingsButtonBinding(materialButton, materialButton);
        }
        throw new NullPointerException("rootView");
    }

    @NonNull
    public static ExtraSettingsButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ExtraSettingsButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.extra_settings_button, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public MaterialButton getRoot() {
        return this.f11213a;
    }
}
