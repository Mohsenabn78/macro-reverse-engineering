package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdiu {
    private final zzdni zza;
    private final zzdlx zzb;
    private ViewTreeObserver.OnScrollChangedListener zzc = null;

    public zzdiu(zzdni zzdniVar, zzdlx zzdlxVar) {
        this.zza = zzdniVar;
        this.zzb = zzdlxVar;
    }

    private static final int zzf(Context context, String str, int i4) {
        try {
            i4 = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        com.google.android.gms.ads.internal.client.zzay.zzb();
        return zzbzk.zzx(context, i4);
    }

    public final View zza(@NonNull final View view, @NonNull final WindowManager windowManager) throws zzcfk {
        zzcez zza = this.zza.zza(com.google.android.gms.ads.internal.client.zzq.zzc(), null, null);
        View view2 = (View) zza;
        view2.setVisibility(4);
        view2.setContentDescription("policy_validator");
        zza.zzad("/sendMessageToSdk", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdiq
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdiu.this.zzb((zzcez) obj, map);
            }
        });
        zza.zzad("/hideValidatorOverlay", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdir
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdiu.this.zzc(windowManager, view, (zzcez) obj, map);
            }
        });
        zza.zzad("/open", new zzbit(null, null, null, null, null));
        this.zzb.zzj(new WeakReference(zza), "/loadNativeAdPolicyViolations", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdis
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdiu.this.zze(view, windowManager, (zzcez) obj, map);
            }
        });
        this.zzb.zzj(new WeakReference(zza), "/showValidatorOverlay", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdit
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzbzr.zze("Show native ad policy validator overlay.");
                ((zzcez) obj).zzF().setVisibility(0);
            }
        });
        return (View) zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzcez zzcezVar, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(WindowManager windowManager, View view, zzcez zzcezVar, Map map) {
        zzbzr.zze("Hide native ad policy validator overlay.");
        zzcezVar.zzF().setVisibility(8);
        if (zzcezVar.zzF().getWindowToken() != null) {
            windowManager.removeView(zzcezVar.zzF());
        }
        zzcezVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzc != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzc);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Map map, boolean z3) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(final View view, final WindowManager windowManager, final zzcez zzcezVar, final Map map) {
        int i4;
        zzcezVar.zzN().zzA(new zzcgk() { // from class: com.google.android.gms.internal.ads.zzdio
            @Override // com.google.android.gms.internal.ads.zzcgk
            public final void zza(boolean z3) {
                zzdiu.this.zzd(map, z3);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int zzf = zzf(context, (String) map.get("validator_width"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhF)).intValue());
        int zzf2 = zzf(context, (String) map.get("validator_height"), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhG)).intValue());
        int zzf3 = zzf(context, (String) map.get("validator_x"), 0);
        int zzf4 = zzf(context, (String) map.get("validator_y"), 0);
        zzcezVar.zzag(zzcgo.zzb(zzf, zzf2));
        try {
            zzcezVar.zzG().getSettings().setUseWideViewPort(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhH)).booleanValue());
            zzcezVar.zzG().getSettings().setLoadWithOverviewMode(((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhI)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams zzb = com.google.android.gms.ads.internal.util.zzbx.zzb();
        zzb.x = zzf3;
        zzb.y = zzf4;
        windowManager.updateViewLayout(zzcezVar.zzF(), zzb);
        final String str = (String) map.get("orientation");
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            if (!"1".equals(str) && !ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                i4 = rect.top;
            } else {
                i4 = rect.bottom;
            }
            final int i5 = i4 - zzf4;
            this.zzc = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.gms.internal.ads.zzdip
                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    View view2 = view;
                    zzcez zzcezVar2 = zzcezVar;
                    String str2 = str;
                    WindowManager.LayoutParams layoutParams = zzb;
                    int i6 = i5;
                    WindowManager windowManager2 = windowManager;
                    Rect rect2 = new Rect();
                    if (view2.getGlobalVisibleRect(rect2) && zzcezVar2.zzF().getWindowToken() != null) {
                        if (!"1".equals(str2) && !ExifInterface.GPS_MEASUREMENT_2D.equals(str2)) {
                            layoutParams.y = rect2.top - i6;
                        } else {
                            layoutParams.y = rect2.bottom - i6;
                        }
                        windowManager2.updateViewLayout(zzcezVar2.zzF(), layoutParams);
                    }
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (!TextUtils.isEmpty(str2)) {
            zzcezVar.loadUrl(str2);
        }
    }
}
