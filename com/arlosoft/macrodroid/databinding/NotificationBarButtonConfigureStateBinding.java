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
public final class NotificationBarButtonConfigureStateBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f11335a;
    @NonNull
    public final RelativeLayout buttonBarBackground;
    @NonNull
    public final TextView currentMode;
    @NonNull
    public final LinearLayout logo;
    @NonNull
    public final ImageView logoImage;
    @NonNull
    public final ImageView notificationBarConfigureButton;

    private NotificationBarButtonConfigureStateBinding(@NonNull RelativeLayout relativeLayout, @NonNull RelativeLayout relativeLayout2, @NonNull TextView textView, @NonNull LinearLayout linearLayout, @NonNull ImageView imageView, @NonNull ImageView imageView2) {
        this.f11335a = relativeLayout;
        this.buttonBarBackground = relativeLayout2;
        this.currentMode = textView;
        this.logo = linearLayout;
        this.logoImage = imageView;
        this.notificationBarConfigureButton = imageView2;
    }

    @NonNull
    public static NotificationBarButtonConfigureStateBinding bind(@NonNull View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i4 = R.id.current_mode;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, R.id.current_mode);
        if (textView != null) {
            i4 = R.id.logo;
            LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(view, R.id.logo);
            if (linearLayout != null) {
                i4 = R.id.logoImage;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.logoImage);
                if (imageView != null) {
                    i4 = R.id.notification_bar_configure_button;
                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.notification_bar_configure_button);
                    if (imageView2 != null) {
                        return new NotificationBarButtonConfigureStateBinding(relativeLayout, relativeLayout, textView, linearLayout, imageView, imageView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static NotificationBarButtonConfigureStateBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static NotificationBarButtonConfigureStateBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.notification_bar_button_configure_state, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f11335a;
    }
}
