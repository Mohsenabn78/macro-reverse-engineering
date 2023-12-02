package com.google.android.gms.ads.nativead;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzep;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbzr;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class NativeAdView extends FrameLayout {
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private final FrameLayout f19492a;
    @Nullable
    @NotOnlyInitialized

    /* renamed from: b  reason: collision with root package name */
    private final zzbev f19493b;

    public NativeAdView(@NonNull Context context) {
        super(context);
        this.f19492a = d(context);
        this.f19493b = e();
    }

    private final FrameLayout d(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    @Nullable
    @RequiresNonNull({"overlayFrame"})
    private final zzbev e() {
        if (isInEditMode()) {
            return null;
        }
        return zzay.zza().zzh(this.f19492a.getContext(), this, this.f19492a);
    }

    private final void f(String str, @Nullable View view) {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != null) {
            try {
                zzbevVar.zzbs(str, ObjectWrapper.wrap(view));
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call setAssetView on delegate", e4);
            }
        }
    }

    @Nullable
    protected final View a(@NonNull String str) {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != null) {
            try {
                IObjectWrapper zzb = zzbevVar.zzb(str);
                if (zzb != null) {
                    return (View) ObjectWrapper.unwrap(zzb);
                }
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call getAssetView on delegate", e4);
            }
        }
        return null;
    }

    @Override // android.view.ViewGroup
    public final void addView(@NonNull View view, int i4, @NonNull ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i4, layoutParams);
        super.bringChildToFront(this.f19492a);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void b(MediaContent mediaContent) {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar == null) {
            return;
        }
        try {
            if (mediaContent instanceof zzep) {
                zzbevVar.zzbu(((zzep) mediaContent).zzc());
            } else if (mediaContent == null) {
                zzbevVar.zzbu(null);
            } else {
                zzbzr.zze("Use MediaContent provided by NativeAd.getMediaContent");
            }
        } catch (RemoteException e4) {
            zzbzr.zzh("Unable to call setMediaContent on delegate", e4);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(@NonNull View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.f19492a;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(ImageView.ScaleType scaleType) {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != null && scaleType != null) {
            try {
                zzbevVar.zzbv(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call setMediaViewImageScaleType on delegate", e4);
            }
        }
    }

    public void destroy() {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != null) {
            try {
                zzbevVar.zzc();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to destroy native ad view", e4);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(@NonNull MotionEvent motionEvent) {
        if (this.f19493b != null) {
            if (((Boolean) zzba.zzc().zzb(zzbbm.zzjS)).booleanValue()) {
                try {
                    this.f19493b.zzd(ObjectWrapper.wrap(motionEvent));
                } catch (RemoteException e4) {
                    zzbzr.zzh("Unable to call handleTouchEvent on delegate", e4);
                }
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Nullable
    public AdChoicesView getAdChoicesView() {
        View a4 = a("3011");
        if (a4 instanceof AdChoicesView) {
            return (AdChoicesView) a4;
        }
        return null;
    }

    @Nullable
    public final View getAdvertiserView() {
        return a("3005");
    }

    @Nullable
    public final View getBodyView() {
        return a("3004");
    }

    @Nullable
    public final View getCallToActionView() {
        return a("3002");
    }

    @Nullable
    public final View getHeadlineView() {
        return a("3001");
    }

    @Nullable
    public final View getIconView() {
        return a("3003");
    }

    @Nullable
    public final View getImageView() {
        return a("3008");
    }

    @Nullable
    public final MediaView getMediaView() {
        View a4 = a("3010");
        if (a4 instanceof MediaView) {
            return (MediaView) a4;
        }
        if (a4 != null) {
            zzbzr.zze("View is not an instance of MediaView");
            return null;
        }
        return null;
    }

    @Nullable
    public final View getPriceView() {
        return a("3007");
    }

    @Nullable
    public final View getStarRatingView() {
        return a("3009");
    }

    @Nullable
    public final View getStoreView() {
        return a("3006");
    }

    @Override // android.view.View
    public final void onVisibilityChanged(@NonNull View view, int i4) {
        super.onVisibilityChanged(view, i4);
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != null) {
            try {
                zzbevVar.zze(ObjectWrapper.wrap(view), i4);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call onVisibilityChanged on delegate", e4);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.f19492a);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(@NonNull View view) {
        if (this.f19492a == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(@Nullable AdChoicesView adChoicesView) {
        f("3011", adChoicesView);
    }

    public final void setAdvertiserView(@Nullable View view) {
        f("3005", view);
    }

    public final void setBodyView(@Nullable View view) {
        f("3004", view);
    }

    public final void setCallToActionView(@Nullable View view) {
        f("3002", view);
    }

    public final void setClickConfirmingView(@Nullable View view) {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != null) {
            try {
                zzbevVar.zzbt(ObjectWrapper.wrap(view));
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call setClickConfirmingView on delegate", e4);
            }
        }
    }

    public final void setHeadlineView(@Nullable View view) {
        f("3001", view);
    }

    public final void setIconView(@Nullable View view) {
        f("3003", view);
    }

    public final void setImageView(@Nullable View view) {
        f("3008", view);
    }

    public final void setMediaView(@Nullable MediaView mediaView) {
        f("3010", mediaView);
        if (mediaView == null) {
            return;
        }
        mediaView.a(new zzb(this));
        mediaView.b(new zzc(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@NonNull NativeAd nativeAd) {
        zzbev zzbevVar = this.f19493b;
        if (zzbevVar != 0) {
            try {
                zzbevVar.zzbw(nativeAd.zza());
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call setNativeAd on delegate", e4);
            }
        }
    }

    public final void setPriceView(@Nullable View view) {
        f("3007", view);
    }

    public final void setStarRatingView(@Nullable View view) {
        f("3009", view);
    }

    public final void setStoreView(@Nullable View view) {
        f("3006", view);
    }

    public NativeAdView(@NonNull Context context, @NonNull AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f19492a = d(context);
        this.f19493b = e();
    }

    public NativeAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f19492a = d(context);
        this.f19493b = e();
    }

    @TargetApi(21)
    public NativeAdView(@NonNull Context context, @NonNull AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f19492a = d(context);
        this.f19493b = e();
    }
}
