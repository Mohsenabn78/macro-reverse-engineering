package com.google.android.gms.ads.internal.client;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.ads.h5.OnH5AdsEventListener;
import com.google.android.gms.internal.ads.zzbev;
import com.google.android.gms.internal.ads.zzbfb;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbjj;
import com.google.android.gms.internal.ads.zzbnw;
import com.google.android.gms.internal.ads.zzbrm;
import com.google.android.gms.internal.ads.zzbrq;
import com.google.android.gms.internal.ads.zzbrt;
import com.google.android.gms.internal.ads.zzbsy;
import com.google.android.gms.internal.ads.zzbvn;
import com.google.android.gms.internal.ads.zzbvz;
import com.google.android.gms.internal.ads.zzbyi;
import com.google.android.gms.internal.ads.zzbzr;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzaw {

    /* renamed from: a  reason: collision with root package name */
    private final zzk f19092a;

    /* renamed from: b  reason: collision with root package name */
    private final zzi f19093b;

    /* renamed from: c  reason: collision with root package name */
    private final zzeq f19094c;

    /* renamed from: d  reason: collision with root package name */
    private final zzbgq f19095d;

    /* renamed from: e  reason: collision with root package name */
    private final zzbvz f19096e;

    /* renamed from: f  reason: collision with root package name */
    private final zzbrq f19097f;

    /* renamed from: g  reason: collision with root package name */
    private final zzbgr f19098g;

    /* renamed from: h  reason: collision with root package name */
    private zzbsy f19099h;

    public zzaw(zzk zzkVar, zzi zziVar, zzeq zzeqVar, zzbgq zzbgqVar, zzbvz zzbvzVar, zzbrq zzbrqVar, zzbgr zzbgrVar) {
        this.f19092a = zzkVar;
        this.f19093b = zziVar;
        this.f19094c = zzeqVar;
        this.f19095d = zzbgqVar;
        this.f19096e = zzbvzVar;
        this.f19097f = zzbrqVar;
        this.f19098g = zzbgrVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void i(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzay.zzb().zzn(context, zzay.zzc().zza, "gmob-apps", bundle, true);
    }

    public final zzbq zzc(Context context, String str, zzbnw zzbnwVar) {
        return (zzbq) new zzao(this, context, str, zzbnwVar).d(context, false);
    }

    public final zzbu zzd(Context context, zzq zzqVar, String str, zzbnw zzbnwVar) {
        return (zzbu) new zzak(this, context, zzqVar, str, zzbnwVar).d(context, false);
    }

    public final zzbu zze(Context context, zzq zzqVar, String str, zzbnw zzbnwVar) {
        return (zzbu) new zzam(this, context, zzqVar, str, zzbnwVar).d(context, false);
    }

    @Nullable
    public final zzdj zzf(Context context, zzbnw zzbnwVar) {
        return (zzdj) new zzac(this, context, zzbnwVar).d(context, false);
    }

    public final zzbev zzh(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzbev) new zzas(this, frameLayout, frameLayout2, context).d(context, false);
    }

    public final zzbfb zzi(View view, HashMap hashMap, HashMap hashMap2) {
        return (zzbfb) new zzau(this, view, hashMap, hashMap2).d(view.getContext(), false);
    }

    @RequiresApi(api = 21)
    public final zzbjj zzl(Context context, zzbnw zzbnwVar, OnH5AdsEventListener onH5AdsEventListener) {
        return (zzbjj) new zzai(this, context, zzbnwVar, onH5AdsEventListener).d(context, false);
    }

    @Nullable
    public final zzbrm zzm(Context context, zzbnw zzbnwVar) {
        return (zzbrm) new zzag(this, context, zzbnwVar).d(context, false);
    }

    @Nullable
    public final zzbrt zzo(Activity activity) {
        zzaa zzaaVar = new zzaa(this, activity);
        Intent intent = activity.getIntent();
        boolean z3 = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzbzr.zzg("useClientJar flag not found in activity intent extras.");
        } else {
            z3 = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzbrt) zzaaVar.d(activity, z3);
    }

    public final zzbvn zzq(Context context, String str, zzbnw zzbnwVar) {
        return (zzbvn) new zzav(this, context, str, zzbnwVar).d(context, false);
    }

    @Nullable
    public final zzbyi zzr(Context context, zzbnw zzbnwVar) {
        return (zzbyi) new zzae(this, context, zzbnwVar).d(context, false);
    }
}
