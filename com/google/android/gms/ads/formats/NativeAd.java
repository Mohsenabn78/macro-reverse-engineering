package com.google.android.gms.ads.formats;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public abstract class NativeAd {
    @NonNull
    public static final String ASSET_ADCHOICES_CONTAINER_VIEW = "1098";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static abstract class AdChoicesInfo {
        @NonNull
        public abstract List<Image> getImages();

        @NonNull
        public abstract CharSequence getText();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    @Deprecated
    /* loaded from: classes4.dex */
    public static abstract class Image {
        @NonNull
        public abstract Drawable getDrawable();

        public abstract double getScale();

        @NonNull
        public abstract Uri getUri();

        public int zza() {
            return -1;
        }

        public int zzb() {
            return -1;
        }
    }

    @Deprecated
    public abstract void performClick(@NonNull Bundle bundle);

    @Deprecated
    public abstract boolean recordImpression(@NonNull Bundle bundle);

    @Deprecated
    public abstract void reportTouchEvent(@NonNull Bundle bundle);
}
