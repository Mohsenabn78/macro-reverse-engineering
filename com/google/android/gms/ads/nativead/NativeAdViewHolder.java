package com.google.android.gms.ads.nativead;

import android.os.RemoteException;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.client.zzay;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbzr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class NativeAdViewHolder {
    @NonNull
    public static final WeakHashMap zza = new WeakHashMap();
    @NotOnlyInitialized

    /* renamed from: a  reason: collision with root package name */
    private zzbfb f19494a;

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f19495b;

    public NativeAdViewHolder(@NonNull View view, @NonNull Map<String, View> map, @NonNull Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if (view instanceof NativeAdView) {
            zzbzr.zzg("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
            return;
        }
        WeakHashMap weakHashMap = zza;
        if (weakHashMap.get(view) != null) {
            zzbzr.zzg("The provided containerView is already in use with another NativeAdViewHolder.");
            return;
        }
        weakHashMap.put(view, this);
        this.f19495b = new WeakReference(view);
        this.f19494a = zzay.zza().zzi(view, a(map), a(map2));
    }

    private static final HashMap a(Map map) {
        if (map == null) {
            return new HashMap();
        }
        return new HashMap(map);
    }

    public final void setClickConfirmingView(@NonNull View view) {
        try {
            this.f19494a.zzb(ObjectWrapper.wrap(view));
        } catch (RemoteException e4) {
            zzbzr.zzh("Unable to call setClickConfirmingView on delegate", e4);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [com.google.android.gms.dynamic.IObjectWrapper, java.lang.Object] */
    public void setNativeAd(@NonNull NativeAd nativeAd) {
        View view;
        ?? zza2 = nativeAd.zza();
        WeakReference weakReference = this.f19495b;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view == null) {
            zzbzr.zzj("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        WeakHashMap weakHashMap = zza;
        if (!weakHashMap.containsKey(view)) {
            weakHashMap.put(view, this);
        }
        zzbfb zzbfbVar = this.f19494a;
        if (zzbfbVar != 0) {
            try {
                zzbfbVar.zzc(zza2);
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call setNativeAd on delegate", e4);
            }
        }
    }

    public void unregisterNativeAd() {
        View view;
        zzbfb zzbfbVar = this.f19494a;
        if (zzbfbVar != null) {
            try {
                zzbfbVar.zzd();
            } catch (RemoteException e4) {
                zzbzr.zzh("Unable to call unregisterNativeAd on delegate", e4);
            }
        }
        WeakReference weakReference = this.f19495b;
        if (weakReference != null) {
            view = (View) weakReference.get();
        } else {
            view = null;
        }
        if (view != null) {
            zza.remove(view);
        }
    }
}
