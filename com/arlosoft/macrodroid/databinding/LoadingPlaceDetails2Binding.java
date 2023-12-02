package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class LoadingPlaceDetails2Binding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11320a;
    @NonNull
    public final ProgressBar progressImageIV;

    private LoadingPlaceDetails2Binding(@NonNull LinearLayout linearLayout, @NonNull ProgressBar progressBar) {
        this.f11320a = linearLayout;
        this.progressImageIV = progressBar;
    }

    @NonNull
    public static LoadingPlaceDetails2Binding bind(@NonNull View view) {
        ProgressBar progressBar = (ProgressBar) ViewBindings.findChildViewById(view, R.id.progressImageIV);
        if (progressBar != null) {
            return new LoadingPlaceDetails2Binding((LinearLayout) view, progressBar);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.progressImageIV)));
    }

    @NonNull
    public static LoadingPlaceDetails2Binding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static LoadingPlaceDetails2Binding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.loading_place_details_2, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11320a;
    }
}
