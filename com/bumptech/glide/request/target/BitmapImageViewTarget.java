package com.bumptech.glide.request.target;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* loaded from: classes3.dex */
public class BitmapImageViewTarget extends ImageViewTarget<Bitmap> {
    public BitmapImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bumptech.glide.request.target.ImageViewTarget
    /* renamed from: j */
    public void h(Bitmap bitmap) {
        ((ImageView) this.f17522b).setImageBitmap(bitmap);
    }

    @Deprecated
    public BitmapImageViewTarget(ImageView imageView, boolean z3) {
        super(imageView, z3);
    }
}
