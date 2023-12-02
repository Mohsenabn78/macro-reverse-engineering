package com.google.android.gms.ads.formats;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
@Deprecated
/* loaded from: classes4.dex */
public final class NativeAdOptions {
    public static final int ADCHOICES_BOTTOM_LEFT = 3;
    public static final int ADCHOICES_BOTTOM_RIGHT = 2;
    public static final int ADCHOICES_TOP_LEFT = 0;
    public static final int ADCHOICES_TOP_RIGHT = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_ANY = 1;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_LANDSCAPE = 2;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_PORTRAIT = 3;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_SQUARE = 4;
    public static final int NATIVE_MEDIA_ASPECT_RATIO_UNKNOWN = 0;
    @Deprecated
    public static final int ORIENTATION_ANY = 0;
    @Deprecated
    public static final int ORIENTATION_LANDSCAPE = 2;
    @Deprecated
    public static final int ORIENTATION_PORTRAIT = 1;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f19007a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19008b;

    /* renamed from: c  reason: collision with root package name */
    private final int f19009c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19010d;

    /* renamed from: e  reason: collision with root package name */
    private final int f19011e;

    /* renamed from: f  reason: collision with root package name */
    private final VideoOptions f19012f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f19013g;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: e  reason: collision with root package name */
        private VideoOptions f19018e;

        /* renamed from: a  reason: collision with root package name */
        private boolean f19014a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f19015b = -1;

        /* renamed from: c  reason: collision with root package name */
        private int f19016c = 0;

        /* renamed from: d  reason: collision with root package name */
        private boolean f19017d = false;

        /* renamed from: f  reason: collision with root package name */
        private int f19019f = 1;

        /* renamed from: g  reason: collision with root package name */
        private boolean f19020g = false;

        @NonNull
        public NativeAdOptions build() {
            return new NativeAdOptions(this, null);
        }

        @NonNull
        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i4) {
            this.f19019f = i4;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setImageOrientation(int i4) {
            this.f19015b = i4;
            return this;
        }

        @NonNull
        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i4) {
            this.f19016c = i4;
            return this;
        }

        @NonNull
        public Builder setRequestCustomMuteThisAd(boolean z3) {
            this.f19020g = z3;
            return this;
        }

        @NonNull
        public Builder setRequestMultipleImages(boolean z3) {
            this.f19017d = z3;
            return this;
        }

        @NonNull
        public Builder setReturnUrlsForImageAssets(boolean z3) {
            this.f19014a = z3;
            return this;
        }

        @NonNull
        public Builder setVideoOptions(@NonNull VideoOptions videoOptions) {
            this.f19018e = videoOptions;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public @interface NativeMediaAspectRatio {
    }

    /* synthetic */ NativeAdOptions(Builder builder, zzd zzdVar) {
        this.f19007a = builder.f19014a;
        this.f19008b = builder.f19015b;
        this.f19009c = builder.f19016c;
        this.f19010d = builder.f19017d;
        this.f19011e = builder.f19019f;
        this.f19012f = builder.f19018e;
        this.f19013g = builder.f19020g;
    }

    public int getAdChoicesPlacement() {
        return this.f19011e;
    }

    @Deprecated
    public int getImageOrientation() {
        return this.f19008b;
    }

    public int getMediaAspectRatio() {
        return this.f19009c;
    }

    @Nullable
    public VideoOptions getVideoOptions() {
        return this.f19012f;
    }

    public boolean shouldRequestMultipleImages() {
        return this.f19010d;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.f19007a;
    }

    public final boolean zza() {
        return this.f19013g;
    }
}
