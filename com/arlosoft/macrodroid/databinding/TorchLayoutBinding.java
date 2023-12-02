package com.arlosoft.macrodroid.databinding;

import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.arlosoft.macrodroid.R;

/* loaded from: classes3.dex */
public final class TorchLayoutBinding implements ViewBinding {
    @NonNull
    public final SurfaceView PREVIEW;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f11393a;
    @NonNull
    public final Button torchLayoutCancel;
    @NonNull
    public final ImageView torchLayoutIcon;

    private TorchLayoutBinding(@NonNull RelativeLayout relativeLayout, @NonNull SurfaceView surfaceView, @NonNull Button button, @NonNull ImageView imageView) {
        this.f11393a = relativeLayout;
        this.PREVIEW = surfaceView;
        this.torchLayoutCancel = button;
        this.torchLayoutIcon = imageView;
    }

    @NonNull
    public static TorchLayoutBinding bind(@NonNull View view) {
        int i4 = R.id.PREVIEW;
        SurfaceView surfaceView = (SurfaceView) ViewBindings.findChildViewById(view, R.id.PREVIEW);
        if (surfaceView != null) {
            i4 = R.id.torch_layout_cancel;
            Button button = (Button) ViewBindings.findChildViewById(view, R.id.torch_layout_cancel);
            if (button != null) {
                i4 = R.id.torch_layout_icon;
                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view, R.id.torch_layout_icon);
                if (imageView != null) {
                    return new TorchLayoutBinding((RelativeLayout) view, surfaceView, button, imageView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i4)));
    }

    @NonNull
    public static TorchLayoutBinding inflate(@NonNull LayoutInflater layoutInflater) {
        return inflate(layoutInflater, null, false);
    }

    @NonNull
    public static TorchLayoutBinding inflate(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, boolean z3) {
        View inflate = layoutInflater.inflate(R.layout.torch_layout, viewGroup, false);
        if (z3) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    @Override // androidx.viewbinding.ViewBinding
    @NonNull
    public RelativeLayout getRoot() {
        return this.f11393a;
    }
}
