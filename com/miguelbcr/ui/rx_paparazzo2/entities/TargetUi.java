package com.miguelbcr.ui.rx_paparazzo2.entities;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* loaded from: classes6.dex */
public class TargetUi {

    /* renamed from: a  reason: collision with root package name */
    private Object f36189a;

    public TargetUi(Object obj) {
        this.f36189a = obj;
    }

    public FragmentActivity activity() {
        if (fragment() != null) {
            return fragment().getActivity();
        }
        return (FragmentActivity) this.f36189a;
    }

    @Nullable
    public Fragment fragment() {
        Object obj = this.f36189a;
        if (obj instanceof Fragment) {
            return (Fragment) obj;
        }
        return null;
    }

    public Context getContext() {
        if (fragment() == null) {
            return activity();
        }
        return fragment().getContext();
    }

    public void setUi(Object obj) {
        this.f36189a = obj;
    }

    public Object ui() {
        return this.f36189a;
    }
}
