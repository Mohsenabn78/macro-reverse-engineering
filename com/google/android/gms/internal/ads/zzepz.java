package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzepz implements zzeqy {
    final String zza;
    private final zzfwn zzb;
    private final ScheduledExecutorService zzc;
    private final zzeii zzd;
    private final Context zze;
    private final zzfai zzf;
    private final zzeie zzg;
    private final zzdnv zzh;
    private final zzdse zzi;

    public zzepz(zzfwn zzfwnVar, ScheduledExecutorService scheduledExecutorService, String str, zzeii zzeiiVar, Context context, zzfai zzfaiVar, zzeie zzeieVar, zzdnv zzdnvVar, zzdse zzdseVar) {
        this.zzb = zzfwnVar;
        this.zzc = scheduledExecutorService;
        this.zza = str;
        this.zzd = zzeiiVar;
        this.zze = context;
        this.zzf = zzfaiVar;
        this.zzg = zzeieVar;
        this.zzh = zzdnvVar;
        this.zzi = zzdseVar;
    }

    public static /* synthetic */ zzfwm zzc(zzepz zzepzVar) {
        String str;
        final Bundle bundle;
        Bundle bundle2;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjv)).booleanValue()) {
            str = zzepzVar.zzf.zzf.toLowerCase(Locale.ROOT);
        } else {
            str = zzepzVar.zzf.zzf;
        }
        Map zza = zzepzVar.zzd.zza(zzepzVar.zza, str);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbz)).booleanValue()) {
            bundle = zzepzVar.zzi.zzg();
        } else {
            bundle = new Bundle();
        }
        final ArrayList arrayList = new ArrayList();
        Iterator it = ((zzfsf) zza).entrySet().iterator();
        while (true) {
            Bundle bundle3 = null;
            if (!it.hasNext()) {
                break;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str2 = (String) entry.getKey();
            List list = (List) entry.getValue();
            Bundle bundle4 = zzepzVar.zzf.zzd.zzm;
            if (bundle4 != null) {
                bundle3 = bundle4.getBundle(str2);
            }
            arrayList.add(zzepzVar.zzf(str2, list, bundle3, true, true));
        }
        for (Map.Entry entry2 : ((zzfsf) zzepzVar.zzd.zzb()).entrySet()) {
            zzeim zzeimVar = (zzeim) entry2.getValue();
            String str3 = zzeimVar.zza;
            Bundle bundle5 = zzepzVar.zzf.zzd.zzm;
            if (bundle5 != null) {
                bundle2 = bundle5.getBundle(str3);
            } else {
                bundle2 = null;
            }
            arrayList.add(zzepzVar.zzf(str3, Collections.singletonList(zzeimVar.zzd), bundle2, zzeimVar.zzb, zzeimVar.zzc));
        }
        return zzfwc.zzb(arrayList).zza(new Callable() { // from class: com.google.android.gms.internal.ads.zzepw
            @Override // java.util.concurrent.Callable
            public final Object call() {
                List<zzfwm> list2 = arrayList;
                Bundle bundle6 = bundle;
                JSONArray jSONArray = new JSONArray();
                for (zzfwm zzfwmVar : list2) {
                    if (((JSONObject) zzfwmVar.get()) != null) {
                        jSONArray.put(zzfwmVar.get());
                    }
                }
                if (jSONArray.length() == 0) {
                    return null;
                }
                return new zzeqa(jSONArray.toString(), bundle6);
            }
        }, zzepzVar.zzb);
    }

    private final zzfvt zzf(final String str, final List list, final Bundle bundle, final boolean z3, final boolean z4) {
        zzfvt zzv = zzfvt.zzv(zzfwc.zzk(new zzfvi() { // from class: com.google.android.gms.internal.ads.zzepx
            @Override // com.google.android.gms.internal.ads.zzfvi
            public final zzfwm zza() {
                return zzepz.this.zzd(str, list, bundle, z3, z4);
            }
        }, this.zzb));
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbv)).booleanValue()) {
            zzv = (zzfvt) zzfwc.zzn(zzv, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbo)).longValue(), TimeUnit.MILLISECONDS, this.zzc);
        }
        return (zzfvt) zzfwc.zze(zzv, Throwable.class, new zzfov() { // from class: com.google.android.gms.internal.ads.zzepy
            @Override // com.google.android.gms.internal.ads.zzfov
            public final Object apply(Object obj) {
                Throwable th = (Throwable) obj;
                zzbzr.zzg("Error calling adapter: ".concat(String.valueOf(str)));
                return null;
            }
        }, this.zzb);
    }

    private final void zzg(zzbpt zzbptVar, Bundle bundle, List list, zzeil zzeilVar) throws RemoteException {
        zzbptVar.zzh(ObjectWrapper.wrap(this.zze), this.zza, bundle, (Bundle) list.get(0), this.zzf.zze, zzeilVar);
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 32;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return zzfwc.zzk(new zzfvi() { // from class: com.google.android.gms.internal.ads.zzept
            @Override // com.google.android.gms.internal.ads.zzfvi
            public final zzfwm zza() {
                return zzepz.zzc(zzepz.this);
            }
        }, this.zzb);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzfwm zzd(String str, final List list, final Bundle bundle, boolean z3, boolean z4) throws Exception {
        zzbpt zzbptVar;
        final zzcaj zzcajVar = new zzcaj();
        if (z4) {
            this.zzg.zzb(str);
            zzbptVar = this.zzg.zza(str);
        } else {
            try {
                zzbptVar = this.zzh.zzb(str);
            } catch (RemoteException e4) {
                zzbzr.zzh("Couldn't create RTB adapter : ", e4);
                zzbptVar = null;
            }
        }
        if (zzbptVar == null) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbq)).booleanValue()) {
                zzeil.zzb(str, zzcajVar);
            } else {
                throw null;
            }
        } else {
            final zzeil zzeilVar = new zzeil(str, zzbptVar, zzcajVar, com.google.android.gms.ads.internal.zzt.zzB().elapsedRealtime());
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbv)).booleanValue()) {
                this.zzc.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepu
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzeil.this.zzc();
                    }
                }, ((Long) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbo)).longValue(), TimeUnit.MILLISECONDS);
            }
            if (z3) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbA)).booleanValue()) {
                    final zzbpt zzbptVar2 = zzbptVar;
                    this.zzb.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepv
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzepz.this.zze(zzbptVar2, bundle, list, zzeilVar, zzcajVar);
                        }
                    });
                } else {
                    zzg(zzbptVar, bundle, list, zzeilVar);
                }
            } else {
                zzeilVar.zzd();
            }
        }
        return zzcajVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbpt zzbptVar, Bundle bundle, List list, zzeil zzeilVar, zzcaj zzcajVar) {
        try {
            zzg(zzbptVar, bundle, list, zzeilVar);
        } catch (RemoteException e4) {
            zzcajVar.zze(e4);
        }
    }
}
