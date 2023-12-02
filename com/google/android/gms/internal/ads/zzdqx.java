package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.admanager.AppEventListener;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdqx implements AppEventListener, zzcyb, com.google.android.gms.ads.internal.client.zza, zzcvg, zzcwa, zzcwb, zzcwu, zzcvj, zzfem {
    private final List zza;
    private final zzdql zzb;
    private long zzc;

    public zzdqx(zzdql zzdqlVar, zzcgu zzcguVar) {
        this.zzb = zzdqlVar;
        this.zza = Collections.singletonList(zzcguVar);
    }

    private final void zze(Class cls, String str, Object... objArr) {
        this.zzb.zza(this.zza, "Event-".concat(cls.getSimpleName()), str, objArr);
    }

    @Override // com.google.android.gms.ads.internal.client.zza
    public final void onAdClicked() {
        zze(com.google.android.gms.ads.internal.client.zza.class, "onAdClicked", new Object[0]);
    }

    @Override // com.google.android.gms.ads.admanager.AppEventListener
    public final void onAppEvent(String str, String str2) {
        zze(AppEventListener.class, "onAppEvent", str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcvj
    public final void zza(com.google.android.gms.ads.internal.client.zze zzeVar) {
        zze(zzcvj.class, "onAdFailedToLoad", Integer.valueOf(zzeVar.zza), zzeVar.zzb, zzeVar.zzc);
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzbA(zzbue zzbueVar) {
        this.zzc = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime();
        zze(zzcyb.class, "onAdRequest", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbB(zzfef zzfefVar, String str) {
        zze(zzfee.class, "onTaskCreated", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzbC(zzfef zzfefVar, String str, Throwable th) {
        zze(zzfee.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbn(Context context) {
        zze(zzcwb.class, "onDestroy", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbp(Context context) {
        zze(zzcwb.class, "onPause", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcwb
    public final void zzbq(Context context) {
        zze(zzcwb.class, "onResume", context);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzbr() {
        zze(zzcvg.class, "onRewardedVideoStarted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzc(zzfef zzfefVar, String str) {
        zze(zzfee.class, "onTaskStarted", str);
    }

    @Override // com.google.android.gms.internal.ads.zzfem
    public final void zzd(zzfef zzfefVar, String str) {
        zze(zzfee.class, "onTaskSucceeded", str);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzj() {
        zze(zzcvg.class, "onAdClosed", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwa
    public final void zzl() {
        zze(zzcwa.class, "onAdImpression", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzm() {
        zze(zzcvg.class, "onAdLeftApplication", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcwu
    public final void zzn() {
        long elapsedRealtime = com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime() - this.zzc;
        com.google.android.gms.ads.internal.util.zze.zza("Ad Request Latency : " + elapsedRealtime);
        zze(zzcwu.class, "onAdLoaded", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzo() {
        zze(zzcvg.class, "onAdOpened", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    @ParametersAreNonnullByDefault
    public final void zzp(zzbuu zzbuuVar, String str, String str2) {
        zze(zzcvg.class, "onRewarded", zzbuuVar, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzcvg
    public final void zzq() {
        zze(zzcvg.class, "onRewardedVideoCompleted", new Object[0]);
    }

    @Override // com.google.android.gms.internal.ads.zzcyb
    public final void zzb(zzezz zzezzVar) {
    }
}
