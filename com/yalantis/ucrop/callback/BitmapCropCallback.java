package com.yalantis.ucrop.callback;

import android.net.Uri;
import androidx.annotation.NonNull;

/* loaded from: classes6.dex */
public interface BitmapCropCallback {
    void onBitmapCropped(@NonNull Uri uri, int i4, int i5, int i6, int i7);

    void onCropFailure(@NonNull Throwable th);
}
