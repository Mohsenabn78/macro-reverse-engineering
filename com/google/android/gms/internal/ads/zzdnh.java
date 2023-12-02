package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdnh {
    private final zzcve zza;
    private final zzdcs zzb;
    private final zzcwn zzc;
    private final zzcxa zzd;
    private final zzcxm zze;
    private final zzdaa zzf;
    private final Executor zzg;
    private final zzdco zzh;
    private final zzcnx zzi;
    private final com.google.android.gms.ads.internal.zzb zzj;
    private final zzbws zzk;
    private final zzaqs zzl;
    private final zzczr zzm;
    private final zzeba zzn;
    private final zzfgr zzo;
    private final zzdqa zzp;
    private final zzfev zzq;

    public zzdnh(zzcve zzcveVar, zzcwn zzcwnVar, zzcxa zzcxaVar, zzcxm zzcxmVar, zzdaa zzdaaVar, Executor executor, zzdco zzdcoVar, zzcnx zzcnxVar, com.google.android.gms.ads.internal.zzb zzbVar, @Nullable zzbws zzbwsVar, zzaqs zzaqsVar, zzczr zzczrVar, zzeba zzebaVar, zzfgr zzfgrVar, zzdqa zzdqaVar, zzfev zzfevVar, zzdcs zzdcsVar) {
        this.zza = zzcveVar;
        this.zzc = zzcwnVar;
        this.zzd = zzcxaVar;
        this.zze = zzcxmVar;
        this.zzf = zzdaaVar;
        this.zzg = executor;
        this.zzh = zzdcoVar;
        this.zzi = zzcnxVar;
        this.zzj = zzbVar;
        this.zzk = zzbwsVar;
        this.zzl = zzaqsVar;
        this.zzm = zzczrVar;
        this.zzn = zzebaVar;
        this.zzo = zzfgrVar;
        this.zzp = zzdqaVar;
        this.zzq = zzfevVar;
        this.zzb = zzdcsVar;
    }

    public static final zzfwm zzj(zzcez zzcezVar, String str, String str2) {
        final zzcaj zzcajVar = new zzcaj();
        zzcezVar.zzN().zzA(new zzcgk() { // from class: com.google.android.gms.internal.ads.zzdnf
            @Override // com.google.android.gms.internal.ads.zzcgk
            public final void zza(boolean z3) {
                zzcaj zzcajVar2 = zzcaj.this;
                if (z3) {
                    zzcajVar2.zzd(null);
                } else {
                    zzcajVar2.zze(new Exception("Ad Web View failed to load."));
                }
            }
        });
        zzcezVar.zzab(str, str2, null);
        return zzcajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzc() {
        this.zza.onAdClicked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(String str, String str2) {
        this.zzf.zzbz(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze() {
        this.zzc.zzb();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzf(View view) {
        this.zzj.zza();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzg(zzcez zzcezVar, zzcez zzcezVar2, Map map) {
        this.zzi.zzh(zzcezVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ boolean zzh(View view, MotionEvent motionEvent) {
        this.zzj.zza();
        if (view != null) {
            view.performClick();
            return false;
        }
        return false;
    }

    public final void zzi(final zzcez zzcezVar, boolean z3, zzbil zzbilVar) {
        zzcezVar.zzN().zzM(new com.google.android.gms.ads.internal.client.zza() { // from class: com.google.android.gms.internal.ads.zzdmy
            @Override // com.google.android.gms.ads.internal.client.zza
            public final void onAdClicked() {
                zzdnh.this.zzc();
            }
        }, this.zzd, this.zze, new zzbhe() { // from class: com.google.android.gms.internal.ads.zzdmz
            @Override // com.google.android.gms.internal.ads.zzbhe
            public final void zzbz(String str, String str2) {
                zzdnh.this.zzd(str, str2);
            }
        }, new com.google.android.gms.ads.internal.overlay.zzz() { // from class: com.google.android.gms.internal.ads.zzdna
            @Override // com.google.android.gms.ads.internal.overlay.zzz
            public final void zzg() {
                zzdnh.this.zze();
            }
        }, z3, zzbilVar, this.zzj, new zzdng(this), this.zzk, this.zzn, this.zzo, this.zzp, this.zzq, null, this.zzb, null, null);
        zzcezVar.setOnTouchListener(new View.OnTouchListener() { // from class: com.google.android.gms.internal.ads.zzdnb
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                zzdnh.this.zzh(view, motionEvent);
                return false;
            }
        });
        zzcezVar.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.gms.internal.ads.zzdnc
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                zzdnh.this.zzf(view);
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcn)).booleanValue()) {
            this.zzl.zzc().zzo((View) zzcezVar);
        }
        this.zzh.zzm(zzcezVar, this.zzg);
        this.zzh.zzm(new zzaua() { // from class: com.google.android.gms.internal.ads.zzdnd
            @Override // com.google.android.gms.internal.ads.zzaua
            public final void zzc(zzatz zzatzVar) {
                zzcgm zzN = zzcez.this.zzN();
                Rect rect = zzatzVar.zzd;
                zzN.zzp(rect.left, rect.top, false);
            }
        }, this.zzg);
        this.zzh.zza((View) zzcezVar);
        zzcezVar.zzad("/trackActiveViewUnit", new zzbij() { // from class: com.google.android.gms.internal.ads.zzdne
            @Override // com.google.android.gms.internal.ads.zzbij
            public final void zza(Object obj, Map map) {
                zzdnh.this.zzg(zzcezVar, (zzcez) obj, map);
            }
        });
        this.zzi.zzi(zzcezVar);
    }
}
