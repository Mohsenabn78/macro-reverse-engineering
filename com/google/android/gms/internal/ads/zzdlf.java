package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.collection.SimpleArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdlf extends zzbfk {
    private final Context zza;
    private final zzdha zzb;
    private zzdia zzc;
    private zzdgv zzd;

    public zzdlf(Context context, zzdha zzdhaVar, zzdia zzdiaVar, zzdgv zzdgvVar) {
        this.zza = context;
        this.zzb = zzdhaVar;
        this.zzc = zzdiaVar;
        this.zzd = zzdgvVar;
    }

    private final zzbee zzd(String str) {
        return new zzdle(this, "_videoMediaView");
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final com.google.android.gms.ads.internal.client.zzdq zze() {
        return this.zzb.zzj();
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final zzbeo zzf() throws RemoteException {
        return this.zzd.zzc().zza();
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final zzber zzg(String str) {
        return (zzber) this.zzb.zzh().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final IObjectWrapper zzh() {
        return ObjectWrapper.wrap(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final String zzi() {
        return this.zzb.zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final String zzj(String str) {
        return (String) this.zzb.zzi().get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final List zzk() {
        SimpleArrayMap zzh = this.zzb.zzh();
        SimpleArrayMap zzi = this.zzb.zzi();
        String[] strArr = new String[zzh.size() + zzi.size()];
        int i4 = 0;
        for (int i5 = 0; i5 < zzh.size(); i5++) {
            strArr[i4] = (String) zzh.keyAt(i5);
            i4++;
        }
        for (int i6 = 0; i6 < zzi.size(); i6++) {
            strArr[i4] = (String) zzi.keyAt(i6);
            i4++;
        }
        return Arrays.asList(strArr);
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzl() {
        zzdgv zzdgvVar = this.zzd;
        if (zzdgvVar != null) {
            zzdgvVar.zzb();
        }
        this.zzd = null;
        this.zzc = null;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzm() {
        String zzB = this.zzb.zzB();
        if ("Google".equals(zzB)) {
            zzbzr.zzj("Illegal argument specified for omid partner name.");
        } else if (TextUtils.isEmpty(zzB)) {
            zzbzr.zzj("Not starting OMID session. OM partner name has not been configured.");
        } else {
            zzdgv zzdgvVar = this.zzd;
            if (zzdgvVar != null) {
                zzdgvVar.zzt(zzB, false);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzn(String str) {
        zzdgv zzdgvVar = this.zzd;
        if (zzdgvVar != null) {
            zzdgvVar.zzE(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzo() {
        zzdgv zzdgvVar = this.zzd;
        if (zzdgvVar != null) {
            zzdgvVar.zzH();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final void zzp(IObjectWrapper iObjectWrapper) {
        zzdgv zzdgvVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if ((unwrap instanceof View) && this.zzb.zzt() != null && (zzdgvVar = this.zzd) != null) {
            zzdgvVar.zzI((View) unwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzq() {
        zzdgv zzdgvVar = this.zzd;
        if ((zzdgvVar != null && !zzdgvVar.zzV()) || this.zzb.zzq() == null || this.zzb.zzr() != null) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzr(IObjectWrapper iObjectWrapper) {
        zzdia zzdiaVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdiaVar = this.zzc) == null || !zzdiaVar.zzf((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzp().zzao(zzd("_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzs(IObjectWrapper iObjectWrapper) {
        zzdia zzdiaVar;
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof ViewGroup) || (zzdiaVar = this.zzc) == null || !zzdiaVar.zzg((ViewGroup) unwrap)) {
            return false;
        }
        this.zzb.zzr().zzao(zzd("_videoMediaView"));
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbfl
    public final boolean zzt() {
        zzfgw zzt = this.zzb.zzt();
        if (zzt != null) {
            com.google.android.gms.ads.internal.zzt.zzA().zzi(zzt);
            if (this.zzb.zzq() != null) {
                this.zzb.zzq().zzd("onSdkLoaded", new ArrayMap());
                return true;
            }
            return true;
        }
        zzbzr.zzj("Trying to start OMID session before creation.");
        return false;
    }
}
