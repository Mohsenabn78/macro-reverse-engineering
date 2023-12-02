package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class FragmentWarningOnboardBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11241a;
    @NonNull
    public final TextView badDeviceText;
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final TextView titleText;
    @NonNull
    public final TextView warningText;

    private FragmentWarningOnboardBinding(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull TextView textView2, @NonNull TextView textView3) {
        this.f11241a = linearLayout;
        this.badDeviceText = textView;
        this.imageView = imageView;
        this.titleText = textView2;
        this.warningText = textView3;
    }

    @NonNull
    public static FragmentWarningOnboardBinding bind(@NonNull View view) {
        int i4 = R.id.badDeviceText;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.badDeviceText);
        if (textView != null) {
            i4 = R.id.imageView;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
            if (imageView != null) {
                i4 = R.id.titleText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                if (textView2 != null) {
                    i4 = R.id.warningText;
                    TextView textView3 = (TextView) ViewBindings.findChildViewById(view, R.id.warningText);
                    if (textView3 != null) {
                        return new FragmentWarningOnboardBinding((LinearLayout) view, textView, imageView, textView2, textView3);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentWarningOnboardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentWarningOnboardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_warning_onboard, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11241a;
    }
}
