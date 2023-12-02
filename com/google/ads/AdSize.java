package com.google.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.jetbrains.anko.DimensionsKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes3.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;
    public static final int LANDSCAPE_AD_HEIGHT = 32;
    public static final int LARGE_AD_HEIGHT = 90;
    public static final int PORTRAIT_AD_HEIGHT = 50;
    private final com.google.android.gms.ads.AdSize zza;
    @NonNull
    public static final AdSize SMART_BANNER = new AdSize(-1, -2);
    @NonNull
    public static final AdSize BANNER = new AdSize(DimensionsKt.XHDPI, 50);
    @NonNull
    public static final AdSize IAB_MRECT = new AdSize(300, 250);
    @NonNull
    public static final AdSize IAB_BANNER = new AdSize(468, 60);
    @NonNull
    public static final AdSize IAB_LEADERBOARD = new AdSize(728, 90);
    @NonNull
    public static final AdSize IAB_WIDE_SKYSCRAPER = new AdSize(160, 600);

    public AdSize(@NonNull com.google.android.gms.ads.AdSize adSize) {
        this.zza = adSize;
    }

    public boolean equals(@NonNull Object obj) {
        if (!(obj instanceof AdSize)) {
            return false;
        }
        return this.zza.equals(((AdSize) obj).zza);
    }

    @Nullable
    public AdSize findBestSize(@NonNull AdSize... adSizeArr) {
        int width;
        int height;
        AdSize adSize = null;
        if (adSizeArr == null) {
            return null;
        }
        int width2 = getWidth();
        int height2 = getHeight();
        float f4 = 0.0f;
        for (AdSize adSize2 : adSizeArr) {
            if (isSizeAppropriate(adSize2.getWidth(), adSize2.getHeight())) {
                float f5 = (width * height) / (width2 * height2);
                if (f5 > 1.0f) {
                    f5 = 1.0f / f5;
                }
                if (f5 > f4) {
                    adSize = adSize2;
                    f4 = f5;
                }
            }
        }
        return adSize;
    }

    public int getHeight() {
        return this.zza.getHeight();
    }

    public int getHeightInPixels(@NonNull Context context) {
        return this.zza.getHeightInPixels(context);
    }

    public int getWidth() {
        return this.zza.getWidth();
    }

    public int getWidthInPixels(@NonNull Context context) {
        return this.zza.getWidthInPixels(context);
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    public boolean isAutoHeight() {
        return this.zza.isAutoHeight();
    }

    public boolean isCustomAdSize() {
        return false;
    }

    public boolean isFullWidth() {
        return this.zza.isFullWidth();
    }

    public boolean isSizeAppropriate(int i4, int i5) {
        float width = getWidth();
        float f4 = i4;
        int i6 = (f4 > (width * 1.25f) ? 1 : (f4 == (width * 1.25f) ? 0 : -1));
        int height = getHeight();
        if (i6 <= 0 && f4 >= width * 0.8f) {
            float f5 = i5;
            float f6 = height;
            if (f5 <= 1.25f * f6 && f5 >= f6 * 0.8f) {
                return true;
            }
            return false;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return this.zza.toString();
    }

    public AdSize(int i4, int i5) {
        this(new com.google.android.gms.ads.AdSize(i4, i5));
    }
}
