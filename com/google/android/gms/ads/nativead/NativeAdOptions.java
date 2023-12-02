package com.google.android.gms.ads.nativead;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.VideoOptions;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
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
    public static final int SWIPE_GESTURE_DIRECTION_DOWN = 8;
    public static final int SWIPE_GESTURE_DIRECTION_LEFT = 2;
    public static final int SWIPE_GESTURE_DIRECTION_RIGHT = 1;
    public static final int SWIPE_GESTURE_DIRECTION_UP = 4;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f19476a;

    /* renamed from: b  reason: collision with root package name */
    private final int f19477b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19478c;

    /* renamed from: d  reason: collision with root package name */
    private final int f19479d;

    /* renamed from: e  reason: collision with root package name */
    private final VideoOptions f19480e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f19481f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f19482g;

    /* renamed from: h  reason: collision with root package name */
    private final int f19483h;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public @interface AdChoicesPlacement {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: d  reason: collision with root package name */
        private VideoOptions f19487d;

        /* renamed from: a  reason: collision with root package name */
        private boolean f19484a = false;

        /* renamed from: b  reason: collision with root package name */
        private int f19485b = 0;

        /* renamed from: c  reason: collision with root package name */
        private boolean f19486c = false;

        /* renamed from: e  reason: collision with root package name */
        private int f19488e = 1;

        /* renamed from: f  reason: collision with root package name */
        private boolean f19489f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f19490g = false;

        /* renamed from: h  reason: collision with root package name */
        private int f19491h = 0;

        @NonNull
        public NativeAdOptions build() {
            return new NativeAdOptions(this, null);
        }

        @NonNull
        public Builder enableCustomClickGestureDirection(@SwipeGestureDirection int i4, boolean z3) {
            this.f19490g = z3;
            this.f19491h = i4;
            return this;
        }

        @NonNull
        public Builder setAdChoicesPlacement(@AdChoicesPlacement int i4) {
            this.f19488e = i4;
            return this;
        }

        @NonNull
        public Builder setMediaAspectRatio(@NativeMediaAspectRatio int i4) {
            this.f19485b = i4;
            return this;
        }

        @NonNull
        public Builder setRequestCustomMuteThisAd(boolean z3) {
            this.f19489f = z3;
            return this;
        }

        @NonNull
        public Builder setRequestMultipleImages(boolean z3) {
            this.f19486c = z3;
            return this;
        }

        @NonNull
        public Builder setReturnUrlsForImageAssets(boolean z3) {
            this.f19484a = z3;
            return this;
        }

        @NonNull
        public Builder setVideoOptions(@NonNull VideoOptions videoOptions) {
            this.f19487d = videoOptions;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public @interface NativeMediaAspectRatio {
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
    /* loaded from: classes4.dex */
    public @interface SwipeGestureDirection {
    }

    /* synthetic */ NativeAdOptions(Builder builder, zza zzaVar) {
        this.f19476a = builder.f19484a;
        this.f19477b = builder.f19485b;
        this.f19478c = builder.f19486c;
        this.f19479d = builder.f19488e;
        this.f19480e = builder.f19487d;
        this.f19481f = builder.f19489f;
        this.f19482g = builder.f19490g;
        this.f19483h = builder.f19491h;
    }

    public int getAdChoicesPlacement() {
        return this.f19479d;
    }

    public int getMediaAspectRatio() {
        return this.f19477b;
    }

    @Nullable
    public VideoOptions getVideoOptions() {
        return this.f19480e;
    }

    public boolean shouldRequestMultipleImages() {
        return this.f19478c;
    }

    public boolean shouldReturnUrlsForImageAssets() {
        return this.f19476a;
    }

    public final int zza() {
        return this.f19483h;
    }

    public final boolean zzb() {
        return this.f19482g;
    }

    public final boolean zzc() {
        return this.f19481f;
    }
}
