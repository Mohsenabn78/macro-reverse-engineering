package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class ActionBarSwitchBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f10930a;
    @NonNull
    public final SwitchCompat actionBarSwitch;

    private ActionBarSwitchBinding(@NonNull FrameLayout frameLayout, @NonNull SwitchCompat switchCompat) {
        this.f10930a = frameLayout;
        this.actionBarSwitch = switchCompat;
    }

    @NonNull
    public static ActionBarSwitchBinding bind(@NonNull View view) {
        SwitchCompat switchCompat = (SwitchCompat) ViewBindings.findChildViewById(view, R.id.action_bar_switch);
        if (switchCompat != null) {
            return new ActionBarSwitchBinding((FrameLayout) view, switchCompat);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.action_bar_switch)));
    }

    @NonNull
    public static ActionBarSwitchBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static ActionBarSwitchBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.action_bar_switch, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public FrameLayout getRoot() {
        return this.f10930a;
    }
}
