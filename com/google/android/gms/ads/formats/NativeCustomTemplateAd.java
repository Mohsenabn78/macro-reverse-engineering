package com.google.android.gms.ads.formats;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public interface NativeCustomTemplateAd {
    @NonNull
    public static final String ASSET_NAME_VIDEO = "_videoMediaView";

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public interface DisplayOpenMeasurement {
        void setView(@NonNull View view);

        boolean start();
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public interface OnCustomClickListener {
        void onCustomClick(@NonNull NativeCustomTemplateAd nativeCustomTemplateAd, @NonNull String str);
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public interface OnCustomTemplateAdLoadedListener {
        void onCustomTemplateAdLoaded(@NonNull NativeCustomTemplateAd nativeCustomTemplateAd);
    }

    void destroy();

    @NonNull
    List<String> getAvailableAssetNames();

    @NonNull
    String getCustomTemplateId();

    @NonNull
    DisplayOpenMeasurement getDisplayOpenMeasurement();

    @NonNull
    NativeAd.Image getImage(@NonNull String str);

    @NonNull
    CharSequence getText(@NonNull String str);

    @NonNull
    VideoController getVideoController();

    @NonNull
    MediaView getVideoMediaView();

    void performClick(@NonNull String str);

    void recordImpression();
}
