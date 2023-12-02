package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;
import de.mustafagercek.library.LoadingButton;

/* loaded from: classes3.dex */
public final class DialogPluginAppInfoBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11109a;
    @NonNull
    public final LoadingButton submitButton;

    private DialogPluginAppInfoBinding(@NonNull LinearLayout linearLayout, @NonNull LoadingButton loadingButton) {
        this.f11109a = linearLayout;
        this.submitButton = loadingButton;
    }

    @NonNull
    public static DialogPluginAppInfoBinding bind(@NonNull View view) {
        LoadingButton loadingButton = (LoadingButton) ViewBindings.findChildViewById(view, R.id.submitButton);
        if (loadingButton != null) {
            return new DialogPluginAppInfoBinding((LinearLayout) view, loadingButton);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.submitButton)));
    }

    @NonNull
    public static DialogPluginAppInfoBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogPluginAppInfoBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_plugin_app_info, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11109a;
    }
}
