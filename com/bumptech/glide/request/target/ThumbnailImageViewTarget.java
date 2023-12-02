package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.Nullable;

/* loaded from: classes3.dex */
public abstract class ThumbnailImageViewTarget<T> extends ImageViewTarget<T> {
    public ThumbnailImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.target.ImageViewTarget
    protected void h(@Nullable T t3) {
        ViewGroup.LayoutParams layoutParams = ((ImageView) this.f17522b).getLayoutParams();
        Drawable j4 = j(t3);
        if (layoutParams != null && layoutParams.width > 0 && layoutParams.height > 0) {
            j4 = new FixedSizeDrawable(j4, layoutParams.width, layoutParams.height);
        }
        ((ImageView) this.f17522b).setImageDrawable(j4);
    }

    protected abstract Drawable j(T t3);

    @Deprecated
    public ThumbnailImageViewTarget(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
