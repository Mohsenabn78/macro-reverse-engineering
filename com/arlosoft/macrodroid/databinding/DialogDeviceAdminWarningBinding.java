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
public final class DialogDeviceAdminWarningBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ScrollView f11047a;
    @NonNull
    public final CheckBox confirmReadCheckbox;

    private DialogDeviceAdminWarningBinding(@NonNull ScrollView scrollView, @NonNull CheckBox checkBox) {
        this.f11047a = scrollView;
        this.confirmReadCheckbox = checkBox;
    }

    @NonNull
    public static DialogDeviceAdminWarningBinding bind(@NonNull View view) {
        CheckBox checkBox = (CheckBox) ViewBindings.findChildViewById(view, R.id.confirmReadCheckbox);
        if (checkBox != null) {
            return new DialogDeviceAdminWarningBinding((ScrollView) view, checkBox);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.confirmReadCheckbox)));
    }

    @NonNull
    public static DialogDeviceAdminWarningBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogDeviceAdminWarningBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_device_admin_warning, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public ScrollView getRoot() {
        return this.f11047a;
    }
}
