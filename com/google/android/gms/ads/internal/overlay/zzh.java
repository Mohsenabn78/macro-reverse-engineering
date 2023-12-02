package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.internal.ads.zzcez;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@VisibleForTesting
/* loaded from: classes4.dex */
public final class zzh {
    public final int zza;
    public final ViewGroup.LayoutParams zzb;
    public final ViewGroup zzc;
    public final Context zzd;

    public zzh(zzcez zzcezVar) throws zzf {
        this.zzb = zzcezVar.getLayoutParams();
        ViewParent parent = zzcezVar.getParent();
        this.zzd = zzcezVar.zzE();
        if (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            this.zzc = viewGroup;
            this.zza = viewGroup.indexOfChild(zzcezVar.zzF());
            viewGroup.removeView(zzcezVar.zzF());
            zzcezVar.zzan(true);
            return;
        }
        throw new zzf("Could not get the parent of the WebView for an overlay.");
    }
}
