package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbqv extends zzbqw implements zzbij {
    DisplayMetrics zza;
    int zzb;
    int zzc;
    int zzd;
    int zze;
    int zzf;
    int zzg;
    private final zzcez zzh;
    private final Context zzi;
    private final WindowManager zzj;
    private final zzbaw zzk;
    private float zzl;
    private int zzm;

    public zzbqv(zzcez zzcezVar, Context context, zzbaw zzbawVar) {
        super(zzcezVar, "");
        this.zzb = -1;
        this.zzc = -1;
        this.zzd = -1;
        this.zze = -1;
        this.zzf = -1;
        this.zzg = -1;
        this.zzh = zzcezVar;
        this.zzi = context;
        this.zzk = zzbawVar;
        this.zzj = (WindowManager) context.getSystemService("window");
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* synthetic */ void zza(Object obj, Map map) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        JSONObject jSONObject;
        zzcez zzcezVar = (zzcez) obj;
        this.zza = new DisplayMetrics();
        Display defaultDisplay = this.zzj.getDefaultDisplay();
        defaultDisplay.getMetrics(this.zza);
        this.zzl = this.zza.density;
        this.zzm = defaultDisplay.getRotation();
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics = this.zza;
        this.zzb = zzbzk.zzv(displayMetrics, displayMetrics.widthPixels);
        com.google.android.gms.ads.internal.client.zzay.zzb();
        DisplayMetrics displayMetrics2 = this.zza;
        this.zzc = zzbzk.zzv(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzi = this.zzh.zzi();
        if (zzi != null && zzi.getWindow() != null) {
            com.google.android.gms.ads.internal.zzt.zzp();
            int[] zzM = com.google.android.gms.ads.internal.util.zzs.zzM(zzi);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            this.zzd = zzbzk.zzv(this.zza, zzM[0]);
            com.google.android.gms.ads.internal.client.zzay.zzb();
            this.zze = zzbzk.zzv(this.zza, zzM[1]);
        } else {
            this.zzd = this.zzb;
            this.zze = this.zzc;
        }
        if (this.zzh.zzO().zzi()) {
            this.zzf = this.zzb;
            this.zzg = this.zzc;
        } else {
            this.zzh.measure(0, 0);
        }
        zzi(this.zzb, this.zzc, this.zzd, this.zze, this.zzl, this.zzm);
        zzbqu zzbquVar = new zzbqu();
        zzbaw zzbawVar = this.zzk;
        Intent intent = new Intent("android.intent.action.DIAL");
        intent.setData(Uri.parse("tel:"));
        zzbquVar.zze(zzbawVar.zza(intent));
        zzbaw zzbawVar2 = this.zzk;
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.setData(Uri.parse("sms:"));
        zzbquVar.zzc(zzbawVar2.zza(intent2));
        zzbquVar.zza(this.zzk.zzb());
        zzbquVar.zzd(this.zzk.zzc());
        zzbquVar.zzb(true);
        z3 = zzbquVar.zza;
        z4 = zzbquVar.zzb;
        z5 = zzbquVar.zzc;
        z6 = zzbquVar.zzd;
        z7 = zzbquVar.zze;
        zzcez zzcezVar2 = this.zzh;
        try {
            jSONObject = new JSONObject().put("sms", z3).put("tel", z4).put("calendar", z5).put("storePicture", z6).put("inlineVideo", z7);
        } catch (JSONException e4) {
            zzbzr.zzh("Error occurred while obtaining the MRAID capabilities.", e4);
            jSONObject = null;
        }
        zzcezVar2.zze("onDeviceFeaturesReceived", jSONObject);
        int[] iArr = new int[2];
        this.zzh.getLocationOnScreen(iArr);
        zzb(com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, iArr[0]), com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, iArr[1]));
        if (zzbzr.zzm(2)) {
            zzbzr.zzi("Dispatching Ready Event.");
        }
        zzh(this.zzh.zzn().zza);
    }

    public final void zzb(int i4, int i5) {
        int i6;
        int i7 = 0;
        if (this.zzi instanceof Activity) {
            com.google.android.gms.ads.internal.zzt.zzp();
            i6 = com.google.android.gms.ads.internal.util.zzs.zzN((Activity) this.zzi)[0];
        } else {
            i6 = 0;
        }
        if (this.zzh.zzO() == null || !this.zzh.zzO().zzi()) {
            int width = this.zzh.getWidth();
            int height = this.zzh.getHeight();
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzS)).booleanValue()) {
                if (width == 0) {
                    if (this.zzh.zzO() != null) {
                        width = this.zzh.zzO().zzb;
                    } else {
                        width = 0;
                    }
                }
                if (height == 0) {
                    if (this.zzh.zzO() != null) {
                        i7 = this.zzh.zzO().zza;
                    }
                    this.zzf = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, width);
                    this.zzg = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, i7);
                }
            }
            i7 = height;
            this.zzf = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, width);
            this.zzg = com.google.android.gms.ads.internal.client.zzay.zzb().zzb(this.zzi, i7);
        }
        zzf(i4, i5 - i6, this.zzf, this.zzg);
        this.zzh.zzN().zzB(i4, i5);
    }
}
