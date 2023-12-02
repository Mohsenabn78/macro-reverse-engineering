package com.airbnb.lottie;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public interface ImageAssetDelegate {
    @Nullable
    Bitmap fetchBitmap(LottieImageAsset lottieImageAsset);
}
