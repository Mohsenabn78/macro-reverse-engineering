package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class DialogNotificationBarButtonIconBinding implements ViewBinding {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f11103a;
    @NonNull
    public final Spinner buttonNumberSpinner;
    @NonNull
    public final ImageView editImage;
    @NonNull
    public final ImageView existingImage;
    @NonNull
    public final ImageView newImage;
    @NonNull
    public final FrameLayout newImageFrame;

    private DialogNotificationBarButtonIconBinding(@NonNull LinearLayout linearLayout, @NonNull Spinner spinner, @NonNull ImageView imageView, @NonNull ImageView imageView2, @NonNull ImageView imageView3, @NonNull FrameLayout frameLayout) {
        this.f11103a = linearLayout;
        this.buttonNumberSpinner = spinner;
        this.editImage = imageView;
        this.existingImage = imageView2;
        this.newImage = imageView3;
        this.newImageFrame = frameLayout;
    }

    @NonNull
    public static DialogNotificationBarButtonIconBinding bind(@NonNull View view) {
        int i4 = R.id.buttonNumberSpinner;
        Spinner spinner = (Spinner) ViewBindings.findChildViewById(view, R.id.buttonNumberSpinner);
        if (spinner != null) {
            i4 = R.id.editImage;
            ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.editImage);
            if (imageView != null) {
                i4 = R.id.existingImage;
                ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view, R.id.existingImage);
                if (imageView2 != null) {
                    i4 = R.id.newImage;
                    ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view, R.id.newImage);
                    if (imageView3 != null) {
                        i4 = R.id.newImageFrame;
                        FrameLayout frameLayout = (FrameLayout) ViewBindings.findChildViewById(view, R.id.newImageFrame);
                        if (frameLayout != null) {
                            return new DialogNotificationBarButtonIconBinding((LinearLayout) view, spinner, imageView, imageView2, imageView3, frameLayout);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static DialogNotificationBarButtonIconBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static DialogNotificationBarButtonIconBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.dialog_notification_bar_button_icon, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public LinearLayout getRoot() {
        return this.f11103a;
    }
}
