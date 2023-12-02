package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.ads.internal.client.zzbq;
import com.google.android.gms.ads.internal.client.zzbu;
import com.google.android.gms.ads.internal.client.zzcd;
import com.google.android.gms.ads.internal.client.zzco;
import com.google.android.gms.ads.internal.client.zzdj;
import com.google.android.gms.ads.internal.client.zzew;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzac;
import com.google.android.gms.ads.internal.overlay.zzae;
import com.google.android.gms.ads.internal.overlay.zzaf;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbjg;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbux;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzbzx;
import com.google.android.gms.internal.ads.zzcgu;
import com.google.android.gms.internal.ads.zzdhu;
import com.google.android.gms.internal.ads.zzdhw;
import com.google.android.gms.internal.ads.zzdri;
import com.google.android.gms.internal.ads.zzeip;
import com.google.android.gms.internal.ads.zzeun;
import com.google.android.gms.internal.ads.zzeuo;
import com.google.android.gms.internal.ads.zzewb;
import com.google.android.gms.internal.ads.zzexs;
import com.google.android.gms.internal.ads.zzezg;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class ClientApi extends zzcd {
    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbq zzb(IObjectWrapper iObjectWrapper, String str, zzbnw zzbnwVar, int i4) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzeip(zzcgu.zza(context, zzbnwVar, i4), context, str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzc(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbnw zzbnwVar, int i4) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzeun zzr = zzcgu.zza(context, zzbnwVar, i4).zzr();
        zzr.zza(str);
        zzr.zzb(context);
        zzeuo zzc = zzr.zzc();
        if (i4 >= ((Integer) zzba.zzc().zzb(zzbbm.zzeX)).intValue()) {
            return zzc.zza();
        }
        return new zzew();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzd(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbnw zzbnwVar, int i4) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzewb zzs = zzcgu.zza(context, zzbnwVar, i4).zzs();
        zzs.zzc(context);
        zzs.zza(zzqVar);
        zzs.zzb(str);
        return zzs.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zze(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, zzbnw zzbnwVar, int i4) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzexs zzt = zzcgu.zza(context, zzbnwVar, i4).zzt();
        zzt.zzc(context);
        zzt.zza(zzqVar);
        zzt.zzb(str);
        return zzt.zzd().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbu zzf(IObjectWrapper iObjectWrapper, com.google.android.gms.ads.internal.client.zzq zzqVar, String str, int i4) {
        return new zzs((Context) ObjectWrapper.unwrap(iObjectWrapper), zzqVar, str, new zzbzx(ModuleDescriptor.MODULE_VERSION, i4, true, false));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzco zzg(IObjectWrapper iObjectWrapper, int i4) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), null, i4).zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzdj zzh(IObjectWrapper iObjectWrapper, zzbnw zzbnwVar, int i4) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbnwVar, i4).zzk();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbev zzi(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzdhw((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), ModuleDescriptor.MODULE_VERSION);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbfb zzj(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzdhu((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbjj zzk(IObjectWrapper iObjectWrapper, zzbnw zzbnwVar, int i4, zzbjg zzbjgVar) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdri zzi = zzcgu.zza(context, zzbnwVar, i4).zzi();
        zzi.zzb(context);
        zzi.zza(zzbjgVar);
        return zzi.zzc().zzd();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbrm zzl(IObjectWrapper iObjectWrapper, zzbnw zzbnwVar, int i4) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbnwVar, i4).zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbrt zzm(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel zza = AdOverlayInfoParcel.zza(activity.getIntent());
        if (zza == null) {
            return new com.google.android.gms.ads.internal.overlay.zzt(activity);
        }
        int i4 = zza.zzk;
        if (i4 != 1) {
            if (i4 != 2) {
                if (i4 != 3) {
                    if (i4 != 4) {
                        if (i4 != 5) {
                            return new com.google.android.gms.ads.internal.overlay.zzt(activity);
                        }
                        return new zzac(activity);
                    }
                    return new zzy(activity, zza);
                }
                return new zzaf(activity);
            }
            return new zzae(activity);
        }
        return new com.google.android.gms.ads.internal.overlay.zzs(activity);
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbux zzn(IObjectWrapper iObjectWrapper, zzbnw zzbnwVar, int i4) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezg zzu = zzcgu.zza(context, zzbnwVar, i4).zzu();
        zzu.zzb(context);
        return zzu.zzc().zzb();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbvn zzo(IObjectWrapper iObjectWrapper, String str, zzbnw zzbnwVar, int i4) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzezg zzu = zzcgu.zza(context, zzbnwVar, i4).zzu();
        zzu.zzb(context);
        zzu.zza(str);
        return zzu.zzc().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzce
    public final zzbyi zzp(IObjectWrapper iObjectWrapper, zzbnw zzbnwVar, int i4) {
        return zzcgu.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzbnwVar, i4).zzo();
    }
}
