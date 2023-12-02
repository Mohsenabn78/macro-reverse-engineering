package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.internal.ads.zzbzr;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class SearchAdView extends ViewGroup {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final zzea f19588a;

    public SearchAdView(@NonNull Context context) {
        super(context);
        this.f19588a = new zzea(this);
    }

    public void destroy() {
        this.f19588a.zzk();
    }

    @NonNull
    public AdListener getAdListener() {
        return this.f19588a.zza();
    }

    @Nullable
    public AdSize getAdSize() {
        return this.f19588a.zzb();
    }

    @NonNull
    public String getAdUnitId() {
        return this.f19588a.zzj();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull DynamicHeightSearchAdRequest dynamicHeightSearchAdRequest) {
        if (AdSize.SEARCH.equals(getAdSize())) {
            this.f19588a.zzm(dynamicHeightSearchAdRequest.a());
            return;
        }
        throw new IllegalStateException("You must use AdSize.SEARCH for a DynamicHeightSearchAdRequest");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i8 = ((i6 - i4) - measuredWidth) / 2;
            int i9 = ((i7 - i5) - measuredHeight) / 2;
            childAt.layout(i8, i9, measuredWidth + i8, measuredHeight + i9);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        AdSize adSize;
        int i6;
        int i7 = 0;
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            measureChild(childAt, i4, i5);
            i7 = childAt.getMeasuredWidth();
            i6 = childAt.getMeasuredHeight();
        } else {
            try {
                adSize = getAdSize();
            } catch (NullPointerException e4) {
                zzbzr.zzh("Unable to retrieve ad size.", e4);
                adSize = null;
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i6 = adSize.getHeightInPixels(context);
                i7 = widthInPixels;
            } else {
                i6 = 0;
            }
        }
        setMeasuredDimension(View.resolveSize(Math.max(i7, getSuggestedMinimumWidth()), i4), View.resolveSize(Math.max(i6, getSuggestedMinimumHeight()), i5));
    }

    public void pause() {
        this.f19588a.zzn();
    }

    public void resume() {
        this.f19588a.zzp();
    }

    public void setAdListener(@NonNull AdListener adListener) {
        this.f19588a.zzr(adListener);
    }

    public void setAdSize(@NonNull AdSize adSize) {
        this.f19588a.zzs(adSize);
    }

    public void setAdUnitId(@NonNull String str) {
        this.f19588a.zzu(str);
    }

    public SearchAdView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19588a = new zzea(this, attributeSet, false);
    }

    public SearchAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f19588a = new zzea(this, attributeSet, false);
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull SearchAdRequest searchAdRequest) {
        this.f19588a.zzm(searchAdRequest.a());
    }
}
