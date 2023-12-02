package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdgv extends zzcrd {
    public static final zzfsc zzc = zzfsc.zzq("3010", "3008", "1005", "1009", "2011", "2007");
    private final zzauc zzA;
    private zzfwv zzB;
    private final Executor zzd;
    private final zzdha zze;
    private final zzdhi zzf;
    private final zzdia zzg;
    private final zzdhf zzh;
    private final zzdhl zzi;
    private final zzgvy zzj;
    private final zzgvy zzk;
    private final zzgvy zzl;
    private final zzgvy zzm;
    private final zzgvy zzn;
    private zzdiw zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private final zzbxe zzs;
    private final zzaqs zzt;
    private final zzbzx zzu;
    private final Context zzv;
    private final zzdgx zzw;
    private final zzejp zzx;
    private final Map zzy;
    private final List zzz;

    public zzdgv(zzcrc zzcrcVar, Executor executor, zzdha zzdhaVar, zzdhi zzdhiVar, zzdia zzdiaVar, zzdhf zzdhfVar, zzdhl zzdhlVar, zzgvy zzgvyVar, zzgvy zzgvyVar2, zzgvy zzgvyVar3, zzgvy zzgvyVar4, zzgvy zzgvyVar5, zzbxe zzbxeVar, zzaqs zzaqsVar, zzbzx zzbzxVar, Context context, zzdgx zzdgxVar, zzejp zzejpVar, zzauc zzaucVar) {
        super(zzcrcVar);
        this.zzd = executor;
        this.zze = zzdhaVar;
        this.zzf = zzdhiVar;
        this.zzg = zzdiaVar;
        this.zzh = zzdhfVar;
        this.zzi = zzdhlVar;
        this.zzj = zzgvyVar;
        this.zzk = zzgvyVar2;
        this.zzl = zzgvyVar3;
        this.zzm = zzgvyVar4;
        this.zzn = zzgvyVar5;
        this.zzs = zzbxeVar;
        this.zzt = zzaqsVar;
        this.zzu = zzbzxVar;
        this.zzv = context;
        this.zzw = zzdgxVar;
        this.zzx = zzejpVar;
        this.zzy = new HashMap();
        this.zzz = new ArrayList();
        this.zzA = zzaucVar;
    }

    public static boolean zzW(View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjk)).booleanValue()) {
            com.google.android.gms.ads.internal.zzt.zzp();
            long zzs = com.google.android.gms.ads.internal.util.zzs.zzs(view);
            if (view.isShown() && view.getGlobalVisibleRect(new Rect(), null)) {
                if (zzs >= ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjl)).intValue()) {
                    return true;
                }
            }
            return false;
        } else if (view.isShown() && view.getGlobalVisibleRect(new Rect(), null)) {
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    private final synchronized View zzY(Map map) {
        if (map == null) {
            return null;
        }
        zzfsc zzfscVar = zzc;
        int size = zzfscVar.size();
        int i4 = 0;
        while (i4 < size) {
            WeakReference weakReference = (WeakReference) map.get((String) zzfscVar.get(i4));
            i4++;
            if (weakReference != null) {
                return (View) weakReference.get();
            }
        }
        return null;
    }

    @Nullable
    private final synchronized ImageView.ScaleType zzZ() {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzhA)).booleanValue()) {
            return null;
        }
        zzdiw zzdiwVar = this.zzo;
        if (zzdiwVar == null) {
            zzbzr.zze("Ad should be associated with an ad view before calling getMediaviewScaleType()");
            return null;
        }
        IObjectWrapper zzj = zzdiwVar.zzj();
        if (zzj != null) {
            return (ImageView.ScaleType) ObjectWrapper.unwrap(zzj);
        }
        return zzdia.zza;
    }

    private final void zzaa(String str, boolean z3) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            zzfwm zzv = this.zze.zzv();
            if (zzv == null) {
                return;
            }
            this.zzB = zzfwv.zzf();
            zzfwc.zzq(zzv, new zzdgu(this, "Google", true), this.zzd);
            return;
        }
        zzt("Google", true);
    }

    private final synchronized void zzab(View view, Map map, Map map2) {
        this.zzg.zzd(this.zzo);
        this.zzf.zzq(view, map, map2, zzZ());
        this.zzq = true;
    }

    private final void zzac(View view, @Nullable zzfgw zzfgwVar) {
        zzcez zzq = this.zze.zzq();
        if (this.zzh.zzd() && zzfgwVar != null && zzq != null && view != null) {
            com.google.android.gms.ads.internal.zzt.zzA().zzh(zzfgwVar, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzad */
    public final synchronized void zzy(zzdiw zzdiwVar) {
        Iterator<String> keys;
        View view;
        if (this.zzp) {
            return;
        }
        this.zzo = zzdiwVar;
        this.zzg.zze(zzdiwVar);
        this.zzf.zzy(zzdiwVar.zzf(), zzdiwVar.zzm(), zzdiwVar.zzn(), zzdiwVar, zzdiwVar);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzcn)).booleanValue()) {
            this.zzt.zzc().zzo(zzdiwVar.zzf());
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbE)).booleanValue()) {
            zzezn zzeznVar = this.zzb;
            if (zzeznVar.zzal && (keys = zzeznVar.zzak.keys()) != null) {
                while (keys.hasNext()) {
                    String next = keys.next();
                    WeakReference weakReference = (WeakReference) this.zzo.zzl().get(next);
                    this.zzy.put(next, Boolean.FALSE);
                    if (weakReference != null && (view = (View) weakReference.get()) != null) {
                        zzaub zzaubVar = new zzaub(this.zzv, view);
                        this.zzz.add(zzaubVar);
                        zzaubVar.zzc(new zzdgt(this, next));
                    }
                }
            }
        }
        if (zzdiwVar.zzi() != null) {
            zzdiwVar.zzi().zzc(this.zzs);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: zzae */
    public final void zzz(zzdiw zzdiwVar) {
        this.zzf.zzz(zzdiwVar.zzf(), zzdiwVar.zzl());
        if (zzdiwVar.zzh() != null) {
            zzdiwVar.zzh().setClickable(false);
            zzdiwVar.zzh().removeAllViews();
        }
        if (zzdiwVar.zzi() != null) {
            zzdiwVar.zzi().zze(this.zzs);
        }
        this.zzo = null;
    }

    public static /* synthetic */ void zzq(zzdgv zzdgvVar) {
        try {
            zzdha zzdhaVar = zzdgvVar.zze;
            int zzc2 = zzdhaVar.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zzbzr.zzg("Wrong native template id!");
                                return;
                            }
                            zzdhl zzdhlVar = zzdgvVar.zzi;
                            if (zzdhlVar.zzg() != null) {
                                zzdhlVar.zzg().zzg((zzbku) zzdgvVar.zzm.zzb());
                            }
                        } else if (zzdgvVar.zzi.zzf() != null) {
                            zzdgvVar.zzaa("Google", true);
                            zzdgvVar.zzi.zzf().zze((zzbgo) zzdgvVar.zzl.zzb());
                        }
                    } else if (zzdgvVar.zzi.zzd(zzdhaVar.zzz()) != null) {
                        if (zzdgvVar.zze.zzr() != null) {
                            zzdgvVar.zzt("Google", true);
                        }
                        zzdgvVar.zzi.zzd(zzdgvVar.zze.zzz()).zze((zzbfl) zzdgvVar.zzn.zzb());
                    }
                } else if (zzdgvVar.zzi.zza() != null) {
                    zzdgvVar.zzaa("Google", true);
                    zzdgvVar.zzi.zza().zze((zzbfg) zzdgvVar.zzk.zzb());
                }
            } else if (zzdgvVar.zzi.zzb() != null) {
                zzdgvVar.zzaa("Google", true);
                zzdgvVar.zzi.zzb().zze((zzbfi) zzdgvVar.zzj.zzb());
            }
        } catch (RemoteException e4) {
            zzbzr.zzh("RemoteException when notifyAdLoad is called", e4);
        }
    }

    public final synchronized void zzA(View view, Map map, Map map2, boolean z3) {
        if (this.zzq) {
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbE)).booleanValue() && this.zzb.zzal) {
            for (String str : this.zzy.keySet()) {
                if (!((Boolean) this.zzy.get(str)).booleanValue()) {
                    return;
                }
            }
        }
        if (!z3) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdC)).booleanValue() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    View view2 = (View) ((WeakReference) entry.getValue()).get();
                    if (view2 != null && zzW(view2)) {
                        zzab(view, map, map2);
                        return;
                    }
                }
            }
            return;
        }
        View zzY = zzY(map);
        if (zzY == null) {
            zzab(view, map, map2);
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdD)).booleanValue()) {
            if (zzW(zzY)) {
                zzab(view, map, map2);
                return;
            }
            return;
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzdE)).booleanValue()) {
            Rect rect = new Rect();
            if (zzY.getGlobalVisibleRect(rect, null) && zzY.getHeight() == rect.height() && zzY.getWidth() == rect.width()) {
                zzab(view, map, map2);
                return;
            }
            return;
        }
        zzab(view, map, map2);
    }

    public final synchronized void zzB(@Nullable com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        this.zzf.zzj(zzcwVar);
    }

    public final synchronized void zzC(View view, View view2, Map map, Map map2, boolean z3) {
        this.zzg.zzc(this.zzo);
        this.zzf.zzk(view, view2, map, map2, z3, zzZ());
        if (this.zzr) {
            zzdha zzdhaVar = this.zze;
            if (zzdhaVar.zzr() != null) {
                zzdhaVar.zzr().zzd("onSdkAdUserInteractionClick", new ArrayMap());
            }
        }
    }

    public final synchronized void zzD(@Nullable final View view, final int i4) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjS)).booleanValue()) {
            return;
        }
        zzdiw zzdiwVar = this.zzo;
        if (zzdiwVar == null) {
            zzbzr.zze("Ad should be associated with an ad view before calling performClickForCustomGesture()");
            return;
        }
        final boolean z3 = zzdiwVar instanceof zzdhu;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgl
            @Override // java.lang.Runnable
            public final void run() {
                zzdgv.this.zzv(view, z3, i4);
            }
        });
    }

    public final synchronized void zzE(String str) {
        this.zzf.zzl(str);
    }

    public final synchronized void zzF(Bundle bundle) {
        this.zzf.zzm(bundle);
    }

    public final synchronized void zzG() {
        zzdiw zzdiwVar = this.zzo;
        if (zzdiwVar == null) {
            zzbzr.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
            return;
        }
        final boolean z3 = zzdiwVar instanceof zzdhu;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgq
            @Override // java.lang.Runnable
            public final void run() {
                zzdgv.this.zzw(z3);
            }
        });
    }

    public final synchronized void zzH() {
        if (this.zzq) {
            return;
        }
        this.zzf.zzr();
    }

    public final void zzI(final View view) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeS)).booleanValue()) {
            zzfwv zzfwvVar = this.zzB;
            if (zzfwvVar == null) {
                return;
            }
            zzfwvVar.zzc(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgm
                @Override // java.lang.Runnable
                public final void run() {
                    zzdgv.this.zzx(view);
                }
            }, this.zzd);
            return;
        }
        zzac(view, this.zze.zzt());
    }

    public final synchronized void zzJ(View view, MotionEvent motionEvent, View view2) {
        this.zzf.zzs(view, motionEvent, view2);
    }

    public final synchronized void zzK(Bundle bundle) {
        this.zzf.zzt(bundle);
    }

    public final synchronized void zzL(View view) {
        this.zzf.zzu(view);
    }

    public final synchronized void zzM() {
        this.zzf.zzv();
    }

    public final synchronized void zzN(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        this.zzf.zzw(zzcsVar);
    }

    public final synchronized void zzO(com.google.android.gms.ads.internal.client.zzdg zzdgVar) {
        this.zzx.zza(zzdgVar);
    }

    public final synchronized void zzP(zzbgl zzbglVar) {
        this.zzf.zzx(zzbglVar);
    }

    public final synchronized void zzQ(final zzdiw zzdiwVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbC)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgr
                @Override // java.lang.Runnable
                public final void run() {
                    zzdgv.this.zzy(zzdiwVar);
                }
            });
        } else {
            zzy(zzdiwVar);
        }
    }

    public final synchronized void zzR(final zzdiw zzdiwVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbC)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzs.zza.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgn
                @Override // java.lang.Runnable
                public final void run() {
                    zzdgv.this.zzz(zzdiwVar);
                }
            });
        } else {
            zzz(zzdiwVar);
        }
    }

    public final boolean zzS() {
        return this.zzh.zze();
    }

    public final synchronized boolean zzT() {
        return this.zzf.zzA();
    }

    public final synchronized boolean zzU() {
        return this.zzf.zzB();
    }

    public final boolean zzV() {
        return this.zzh.zzd();
    }

    public final synchronized boolean zzX(Bundle bundle) {
        if (this.zzq) {
            return true;
        }
        boolean zzC = this.zzf.zzC(bundle);
        this.zzq = zzC;
        return zzC;
    }

    public final synchronized int zza() {
        return this.zzf.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzcrd
    public final synchronized void zzb() {
        this.zzp = true;
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgs
            @Override // java.lang.Runnable
            public final void run() {
                zzdgv.this.zzu();
            }
        });
        super.zzb();
    }

    public final zzdgx zzc() {
        return this.zzw;
    }

    public final String zzg() {
        return this.zzh.zzb();
    }

    public final synchronized JSONObject zzi(View view, Map map, Map map2) {
        return this.zzf.zze(view, map, map2, zzZ());
    }

    @Override // com.google.android.gms.internal.ads.zzcrd
    @AnyThread
    public final void zzj() {
        this.zzd.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgo
            @Override // java.lang.Runnable
            public final void run() {
                zzdgv.zzq(zzdgv.this);
            }
        });
        if (this.zze.zzc() != 7) {
            Executor executor = this.zzd;
            final zzdhi zzdhiVar = this.zzf;
            zzdhiVar.getClass();
            executor.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzdgp
                @Override // java.lang.Runnable
                public final void run() {
                    zzdhi.this.zzp();
                }
            });
        }
        super.zzj();
    }

    public final synchronized JSONObject zzk(View view, Map map, Map map2) {
        return this.zzf.zzf(view, map, map2, zzZ());
    }

    public final void zzr(View view) {
        zzfgw zzt = this.zze.zzt();
        if (this.zzh.zzd() && zzt != null && view != null) {
            com.google.android.gms.ads.internal.zzt.zzA().zzf(zzt, view);
        }
    }

    public final synchronized void zzs() {
        this.zzf.zzh();
    }

    public final void zzt(String str, boolean z3) {
        boolean z4;
        boolean z5;
        String str2;
        zzeca zzecaVar;
        zzecb zzecbVar;
        String str3;
        if (this.zzh.zzd() && !TextUtils.isEmpty(str)) {
            zzdha zzdhaVar = this.zze;
            zzcez zzq = zzdhaVar.zzq();
            zzcez zzr = zzdhaVar.zzr();
            if (zzq == null && zzr == null) {
                zzbzr.zzj("Omid display and video webview are null. Skipping initialization.");
                return;
            }
            boolean z6 = false;
            if (zzq != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (zzr != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzeQ)).booleanValue()) {
                this.zzh.zza();
                int zzb = this.zzh.zza().zzb();
                int i4 = zzb - 1;
                if (i4 != 0) {
                    if (i4 != 1) {
                        if (zzb != 1) {
                            if (zzb != 2) {
                                str3 = "UNKNOWN";
                            } else {
                                str3 = "DISPLAY";
                            }
                        } else {
                            str3 = "VIDEO";
                        }
                        zzbzr.zzj("Unknown omid media type: " + str3 + ". Not initializing Omid.");
                        return;
                    } else if (zzq != null) {
                        z6 = true;
                        z5 = false;
                    } else {
                        zzbzr.zzj("Omid media type was display but there was no display webview.");
                        return;
                    }
                } else if (zzr != null) {
                    z5 = true;
                } else {
                    zzbzr.zzj("Omid media type was video but there was no video webview.");
                    return;
                }
            } else {
                z6 = z4;
            }
            if (z6) {
                str2 = null;
            } else {
                str2 = "javascript";
                zzq = zzr;
            }
            String str4 = str2;
            zzq.zzG();
            if (!com.google.android.gms.ads.internal.zzt.zzA().zzj(this.zzv)) {
                zzbzr.zzj("Failed to initialize omid in InternalNativeAd");
                return;
            }
            zzbzx zzbzxVar = this.zzu;
            String str5 = zzbzxVar.zzb + "." + zzbzxVar.zzc;
            if (z5) {
                zzecaVar = zzeca.VIDEO;
                zzecbVar = zzecb.DEFINED_BY_JAVASCRIPT;
            } else {
                zzecaVar = zzeca.NATIVE_DISPLAY;
                if (this.zze.zzc() == 3) {
                    zzecbVar = zzecb.UNSPECIFIED;
                } else {
                    zzecbVar = zzecb.ONE_PIXEL;
                }
            }
            zzfgw zzb2 = com.google.android.gms.ads.internal.zzt.zzA().zzb(str5, zzq.zzG(), "", "javascript", str4, str, zzecbVar, zzecaVar, this.zzb.zzam);
            if (zzb2 == null) {
                zzbzr.zzj("Failed to create omid session in InternalNativeAd");
                return;
            }
            this.zze.zzV(zzb2);
            zzq.zzap(zzb2);
            if (z5) {
                com.google.android.gms.ads.internal.zzt.zzA().zzh(zzb2, zzr.zzF());
                this.zzr = true;
            }
            if (z3) {
                com.google.android.gms.ads.internal.zzt.zzA().zzi(zzb2);
                zzq.zzd("onSdkLoaded", new ArrayMap());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzu() {
        this.zzf.zzi();
        this.zze.zzH();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzv(View view, boolean z3, int i4) {
        this.zzf.zzo(view, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z3, zzZ(), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzw(boolean z3) {
        this.zzf.zzo(null, this.zzo.zzf(), this.zzo.zzl(), this.zzo.zzm(), z3, zzZ(), 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzx(View view) {
        zzac(view, this.zze.zzt());
    }
}
