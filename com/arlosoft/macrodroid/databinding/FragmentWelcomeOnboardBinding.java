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
public final class FragmentWelcomeOnboardBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11242a;
    @NonNull
    public final ImageView imageView;
    @NonNull
    public final TextView textView;
    @NonNull
    public final TextView titleText;

    private FragmentWelcomeOnboardBinding(@NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull TextView textView, @NonNull TextView textView2) {
        this.f11242a = linearLayout;
        this.imageView = imageView;
        this.textView = textView;
        this.titleText = textView2;
    }

    @NonNull
    public static FragmentWelcomeOnboardBinding bind(@NonNull View view) {
        int i4 = R.id.imageView;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.imageView);
        if (imageView != null) {
            i4 = R.id.textView;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.textView);
            if (textView != null) {
                i4 = R.id.titleText;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, R.id.titleText);
                if (textView2 != null) {
                    return new FragmentWelcomeOnboardBinding((LinearLayout) view, imageView, textView, textView2);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static FragmentWelcomeOnboardBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static FragmentWelcomeOnboardBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.fragment_welcome_onboard, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11242a;
    }
}
