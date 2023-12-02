package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.ads.admanager.AppEventListener;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzea;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbdd;
import com.google.android.gms.internal.ads.zzbsw;
import com.google.android.gms.internal.ads.zzbzg;
import com.google.android.gms.internal.ads.zzbzr;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class BaseAdView extends ViewGroup {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    protected final zzea f18975a;

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseAdView(@NonNull Context context, int i4) {
        super(context);
        this.f18975a = new zzea(this, i4);
    }

    public void destroy() {
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zze.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjG)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zze
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.f18975a.zzk();
                        } catch (IllegalStateException e4) {
                            zzbsw.zza(baseAdView.getContext()).zzf(e4, "BaseAdView.destroy");
                        }
                    }
                });
                return;
            }
        }
        this.f18975a.zzk();
    }

    @NonNull
    public AdListener getAdListener() {
        return this.f18975a.zza();
    }

    @Nullable
    public AdSize getAdSize() {
        return this.f18975a.zzb();
    }

    @NonNull
    public String getAdUnitId() {
        return this.f18975a.zzj();
    }

    @Nullable
    public OnPaidEventListener getOnPaidEventListener() {
        return this.f18975a.zzc();
    }

    @Nullable
    public ResponseInfo getResponseInfo() {
        return this.f18975a.zzd();
    }

    public boolean isLoading() {
        return this.f18975a.zzA();
    }

    @RequiresPermission("android.permission.INTERNET")
    public void loadAd(@NonNull final AdRequest adRequest) {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzf.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjJ)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzc
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.f18975a.zzm(adRequest.f18960a);
                        } catch (IllegalStateException e4) {
                            zzbsw.zza(baseAdView.getContext()).zzf(e4, "BaseAdView.loadAd");
                        }
                    }
                });
                return;
            }
        }
        this.f18975a.zzm(adRequest.f18960a);
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
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzg.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjH)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzd
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.f18975a.zzn();
                        } catch (IllegalStateException e4) {
                            zzbsw.zza(baseAdView.getContext()).zzf(e4, "BaseAdView.pause");
                        }
                    }
                });
                return;
            }
        }
        this.f18975a.zzn();
    }

    public void resume() {
        zzbbm.zza(getContext());
        if (((Boolean) zzbdd.zzh.zze()).booleanValue()) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjF)).booleanValue()) {
                zzbzg.zzb.execute(new Runnable() { // from class: com.google.android.gms.ads.zzf
                    @Override // java.lang.Runnable
                    public final void run() {
                        BaseAdView baseAdView = BaseAdView.this;
                        try {
                            baseAdView.f18975a.zzp();
                        } catch (IllegalStateException e4) {
                            zzbsw.zza(baseAdView.getContext()).zzf(e4, "BaseAdView.resume");
                        }
                    }
                });
                return;
            }
        }
        this.f18975a.zzp();
    }

    public void setAdListener(@NonNull AdListener adListener) {
        this.f18975a.zzr(adListener);
        if (adListener == null) {
            this.f18975a.zzq(null);
            return;
        }
        if (adListener instanceof com.google.android.gms.ads.internal.client.zza) {
            this.f18975a.zzq((com.google.android.gms.ads.internal.client.zza) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.f18975a.zzv((AppEventListener) adListener);
        }
    }

    public void setAdSize(@NonNull AdSize adSize) {
        this.f18975a.zzs(adSize);
    }

    public void setAdUnitId(@NonNull String str) {
        this.f18975a.zzu(str);
    }

    public void setOnPaidEventListener(@Nullable OnPaidEventListener onPaidEventListener) {
        this.f18975a.zzx(onPaidEventListener);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4) {
        super(context, attributeSet);
        this.f18975a = new zzea(this, attributeSet, false, i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4);
        this.f18975a = new zzea(this, attributeSet, false, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4, int i5, boolean z3) {
        super(context, attributeSet, i4);
        this.f18975a = new zzea(this, attributeSet, z3, i5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public BaseAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, boolean z3) {
        super(context, attributeSet);
        this.f18975a = new zzea(this, attributeSet, z3);
    }
}
