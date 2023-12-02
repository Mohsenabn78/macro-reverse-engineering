package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class NotificationChannelDialogBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11337a;
    @NonNull
    public final AppCompatEditText noticationChannel;
    @NonNull
    public final Spinner prioritySpinner;

    private NotificationChannelDialogBinding(@NonNull LinearLayout linearLayout, @NonNull AppCompatEditText appCompatEditText, @NonNull Spinner spinner) {
        this.f11337a = linearLayout;
        this.noticationChannel = appCompatEditText;
        this.prioritySpinner = spinner;
    }

    @NonNull
    public static NotificationChannelDialogBinding bind(@NonNull View view) {
        int i4 = R.id.noticationChannel;
        AppCompatEditText appCompatEditText = (AppCompatEditText) ViewBindings.findChildViewById(view, R.id.noticationChannel);
        if (appCompatEditText != null) {
            i4 = R.id.prioritySpinner;
            Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.prioritySpinner);
            if (spinner != null) {
                return new NotificationChannelDialogBinding((LinearLayout) view, appCompatEditText, spinner);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static NotificationChannelDialogBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static NotificationChannelDialogBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.notification_channel_dialog, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11337a;
    }
}
