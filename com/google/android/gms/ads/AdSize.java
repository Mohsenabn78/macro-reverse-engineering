package com.google.android.gms.ads;

import android.content.Context;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzq;
import com.google.android.gms.internal.ads.zzbzk;
import com.google.android.gms.internal.ads.zzbzr;
import org.jetbrains.anko.DimensionsKt;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class AdSize {
    public static final int AUTO_HEIGHT = -2;
    public static final int FULL_WIDTH = -1;

    /* renamed from: a  reason: collision with root package name */
    private final int f18962a;

    /* renamed from: b  reason: collision with root package name */
    private final int f18963b;

    /* renamed from: c  reason: collision with root package name */
    private final String f18964c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f18965d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18966e;

    /* renamed from: f  reason: collision with root package name */
    private int f18967f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f18968g;

    /* renamed from: h  reason: collision with root package name */
    private int f18969h;
    @NonNull
    public static final AdSize BANNER = new AdSize(DimensionsKt.XHDPI, 50, "320x50_mb");
    @NonNull
    public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
    @NonNull
    public static final AdSize LARGE_BANNER = new AdSize(DimensionsKt.XHDPI, 100, "320x100_as");
    @NonNull
    public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
    @NonNull
    public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
    @NonNull
    public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
    @NonNull
    @Deprecated
    public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
    @NonNull
    public static final AdSize FLUID = new AdSize(-3, -4, "fluid");
    @NonNull
    public static final AdSize INVALID = new AdSize(0, 0, "invalid");
    @NonNull
    public static final AdSize zza = new AdSize(50, 50, "50x50_mb");
    @NonNull
    public static final AdSize SEARCH = new AdSize(-3, 0, "search_v2");

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public AdSize(int r4, int r5) {
        /*
            r3 = this;
            r0 = -1
            if (r4 != r0) goto L6
            java.lang.String r0 = "FULL"
            goto La
        L6:
            java.lang.String r0 = java.lang.String.valueOf(r4)
        La:
            r1 = -2
            if (r5 != r1) goto L10
            java.lang.String r1 = "AUTO"
            goto L14
        L10:
            java.lang.String r1 = java.lang.String.valueOf(r5)
        L14:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "x"
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = "_as"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r3.<init>(r4, r5, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.AdSize.<init>(int, int):void");
    }

    @NonNull
    public static AdSize getCurrentOrientationAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i4) {
        AdSize zzc = zzbzk.zzc(context, i4, 50, 0);
        zzc.f18965d = true;
        return zzc;
    }

    @NonNull
    public static AdSize getCurrentOrientationInlineAdaptiveBannerAdSize(@NonNull Context context, int i4) {
        int zza2 = zzbzk.zza(context, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i4, 0);
        adSize.f18967f = zza2;
        adSize.f18966e = true;
        return adSize;
    }

    @NonNull
    public static AdSize getCurrentOrientationInterscrollerAdSize(@NonNull Context context, int i4) {
        return j(i4, zzbzk.zza(context, 0));
    }

    @NonNull
    public static AdSize getInlineAdaptiveBannerAdSize(int i4, int i5) {
        AdSize adSize = new AdSize(i4, 0);
        adSize.f18967f = i5;
        adSize.f18966e = true;
        if (i5 < 32) {
            zzbzr.zzj("The maximum height set for the inline adaptive ad size was " + i5 + " dp, which is below the minimum recommended value of 32 dp.");
        }
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i4) {
        AdSize zzc = zzbzk.zzc(context, i4, 50, 2);
        zzc.f18965d = true;
        return zzc;
    }

    @NonNull
    public static AdSize getLandscapeInlineAdaptiveBannerAdSize(@NonNull Context context, int i4) {
        int zza2 = zzbzk.zza(context, 2);
        AdSize adSize = new AdSize(i4, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        adSize.f18967f = zza2;
        adSize.f18966e = true;
        return adSize;
    }

    @NonNull
    public static AdSize getLandscapeInterscrollerAdSize(@NonNull Context context, int i4) {
        return j(i4, zzbzk.zza(context, 2));
    }

    @NonNull
    public static AdSize getPortraitAnchoredAdaptiveBannerAdSize(@NonNull Context context, int i4) {
        AdSize zzc = zzbzk.zzc(context, i4, 50, 1);
        zzc.f18965d = true;
        return zzc;
    }

    @NonNull
    public static AdSize getPortraitInlineAdaptiveBannerAdSize(@NonNull Context context, int i4) {
        int zza2 = zzbzk.zza(context, 1);
        AdSize adSize = new AdSize(i4, 0);
        if (zza2 == -1) {
            return INVALID;
        }
        adSize.f18967f = zza2;
        adSize.f18966e = true;
        return adSize;
    }

    @NonNull
    public static AdSize getPortraitInterscrollerAdSize(@NonNull Context context, int i4) {
        return j(i4, zzbzk.zza(context, 1));
    }

    private static AdSize j(int i4, int i5) {
        if (i5 == -1) {
            return INVALID;
        }
        AdSize adSize = new AdSize(i4, 0);
        adSize.f18969h = i5;
        adSize.f18968g = true;
        return adSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int a() {
        return this.f18969h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final int b() {
        return this.f18967f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(int i4) {
        this.f18967f = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(int i4) {
        this.f18969h = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void e(boolean z3) {
        this.f18966e = true;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AdSize)) {
            return false;
        }
        AdSize adSize = (AdSize) obj;
        if (this.f18962a != adSize.f18962a || this.f18963b != adSize.f18963b || !this.f18964c.equals(adSize.f18964c)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void f(boolean z3) {
        this.f18968g = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean g() {
        return this.f18965d;
    }

    public int getHeight() {
        return this.f18963b;
    }

    public int getHeightInPixels(@NonNull Context context) {
        int i4 = this.f18963b;
        if (i4 != -4 && i4 != -3) {
            if (i4 != -2) {
                zzay.zzb();
                return zzbzk.zzx(context, this.f18963b);
            }
            return zzq.zza(context.getResources().getDisplayMetrics());
        }
        return -1;
    }

    public int getWidth() {
        return this.f18962a;
    }

    public int getWidthInPixels(@NonNull Context context) {
        int i4 = this.f18962a;
        if (i4 == -3) {
            return -1;
        }
        if (i4 != -1) {
            zzay.zzb();
            return zzbzk.zzx(context, this.f18962a);
        }
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        Parcelable.Creator<zzq> creator = zzq.CREATOR;
        return displayMetrics.widthPixels;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean h() {
        return this.f18966e;
    }

    public int hashCode() {
        return this.f18964c.hashCode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean i() {
        return this.f18968g;
    }

    public boolean isAutoHeight() {
        if (this.f18963b == -2) {
            return true;
        }
        return false;
    }

    public boolean isFluid() {
        if (this.f18962a == -3 && this.f18963b == -4) {
            return true;
        }
        return false;
    }

    public boolean isFullWidth() {
        if (this.f18962a == -1) {
            return true;
        }
        return false;
    }

    @NonNull
    public String toString() {
        return this.f18964c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AdSize(int i4, int i5, String str) {
        if (i4 < 0 && i4 != -1 && i4 != -3) {
            throw new IllegalArgumentException("Invalid width for AdSize: " + i4);
        } else if (i5 < 0 && i5 != -2 && i5 != -4) {
            throw new IllegalArgumentException("Invalid height for AdSize: " + i5);
        } else {
            this.f18962a = i4;
            this.f18963b = i5;
            this.f18964c = str;
        }
    }
}
