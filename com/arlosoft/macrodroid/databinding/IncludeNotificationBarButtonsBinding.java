package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class IncludeNotificationBarButtonsBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f11261a;
    @NonNull
    public final TextView currentMode;
    @NonNull
    public final LinearLayout logo;
    @NonNull
    public final ImageView logoImage;

    private IncludeNotificationBarButtonsBinding(@NonNull RelativeLayout relativeLayout, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView) {
        this.f11261a = relativeLayout;
        this.currentMode = textView;
        this.logo = linearLayout;
        this.logoImage = imageView;
    }

    @NonNull
    public static IncludeNotificationBarButtonsBinding bind(@NonNull View view) {
        int i4 = R.id.current_mode;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.current_mode);
        if (textView != null) {
            i4 = R.id.logo;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.logo);
            if (linearLayout != null) {
                i4 = R.id.logoImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.logoImage);
                if (imageView != null) {
                    return new IncludeNotificationBarButtonsBinding((RelativeLayout) view, textView, linearLayout, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static IncludeNotificationBarButtonsBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static IncludeNotificationBarButtonsBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.include_notification_bar_buttons, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f11261a;
    }
}
