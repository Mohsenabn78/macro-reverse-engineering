package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogDeviceAdminWarning2Binding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11046a;
    @NonNull
    public final CheckBox confirmReadCheckbox;

    private DialogDeviceAdminWarning2Binding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox) {
        this.f11046a = scrollView;
        this.confirmReadCheckbox = checkBox;
    }

    @NonNull
    public static DialogDeviceAdminWarning2Binding bind(@NonNull View view) {
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.confirmReadCheckbox);
        if (checkBox != null) {
            return new DialogDeviceAdminWarning2Binding((ScrollView) view, checkBox);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.confirmReadCheckbox)));
    }

    @NonNull
    public static DialogDeviceAdminWarning2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDeviceAdminWarning2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_device_admin_warning_2, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11046a;
    }
}
