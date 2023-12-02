package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class SelectNotificatonButtonBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11359a;
    @NonNull
    public final RadioButton selectNotificationButtonCollapse;
    @NonNull
    public final RadioButton selectNotificationButtonDontCollapse;

    private SelectNotificatonButtonBinding(@NonNull LinearLayout linearLayout, @NonNull RadioButton radioButton, @NonNull RadioButton radioButton2) {
        this.f11359a = linearLayout;
        this.selectNotificationButtonCollapse = radioButton;
        this.selectNotificationButtonDontCollapse = radioButton2;
    }

    @NonNull
    public static SelectNotificatonButtonBinding bind(@NonNull View view) {
        int i4 = R.id.select_notification_button_collapse;
        RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(view, R.id.select_notification_button_collapse);
        if (radioButton != null) {
            i4 = R.id.select_notification_button_dont_collapse;
            RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(view, R.id.select_notification_button_dont_collapse);
            if (radioButton2 != null) {
                return new SelectNotificatonButtonBinding((LinearLayout) view, radioButton, radioButton2);
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static SelectNotificatonButtonBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static SelectNotificatonButtonBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.select_notificaton_button, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11359a;
    }
}
