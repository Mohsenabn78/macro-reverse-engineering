package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfin implements zzfhs {
    private static final zzfin zza = new zzfin();
    private static final Handler zzb = new Handler(Looper.getMainLooper());
    private static Handler zzc = null;
    private static final Runnable zzd = new zzfij();
    private static final Runnable zze = new zzfik();
    private int zzg;
    private long zzm;
    private final List zzf = new ArrayList();
    private boolean zzh = false;
    private final List zzi = new ArrayList();
    private final zzfig zzk = new zzfig();
    private final zzfhu zzj = new zzfhu();
    private final zzfih zzl = new zzfih(new zzfiq());

    zzfin() {
    }

    public static zzfin zzd() {
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzg(zzfin zzfinVar) {
        zzfinVar.zzg = 0;
        zzfinVar.zzi.clear();
        zzfinVar.zzh = false;
        for (zzfha zzfhaVar : zzfhl.zza().zzb()) {
        }
        zzfinVar.zzm = System.nanoTime();
        zzfinVar.zzk.zzi();
        long nanoTime = System.nanoTime();
        zzfht zza2 = zzfinVar.zzj.zza();
        if (zzfinVar.zzk.zze().size() > 0) {
            Iterator it = zzfinVar.zzk.zze().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject zza3 = zzfib.zza(0, 0, 0, 0);
                View zza4 = zzfinVar.zzk.zza(str);
                zzfht zzb2 = zzfinVar.zzj.zzb();
                String zzc2 = zzfinVar.zzk.zzc(str);
                if (zzc2 != null) {
                    JSONObject zza5 = zzb2.zza(zza4);
                    zzfib.zzb(zza5, str);
                    try {
                        zza5.put("notVisibleReason", zzc2);
                    } catch (JSONException e4) {
                        zzfic.zza("Error with setting not visible reason", e4);
                    }
                    zzfib.zzc(zza3, zza5);
                }
                zzfib.zzf(zza3);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                zzfinVar.zzl.zzc(zza3, hashSet, nanoTime);
            }
        }
        if (zzfinVar.zzk.zzf().size() > 0) {
            JSONObject zza6 = zzfib.zza(0, 0, 0, 0);
            zzfinVar.zzk(null, zza2, zza6, 1, false);
            zzfib.zzf(zza6);
            zzfinVar.zzl.zzd(zza6, zzfinVar.zzk.zzf(), nanoTime);
        } else {
            zzfinVar.zzl.zzb();
        }
        zzfinVar.zzk.zzg();
        long nanoTime2 = System.nanoTime() - zzfinVar.zzm;
        if (zzfinVar.zzf.size() > 0) {
            for (zzfim zzfimVar : zzfinVar.zzf) {
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                zzfimVar.zzb();
                if (zzfimVar instanceof zzfil) {
                    ((zzfil) zzfimVar).zza();
                }
            }
        }
    }

    private final void zzk(View view, zzfht zzfhtVar, JSONObject jSONObject, int i4, boolean z3) {
        boolean z4;
        if (i4 == 1) {
            z4 = true;
        } else {
            z4 = false;
        }
        zzfhtVar.zzb(view, jSONObject, this, z4, z3);
    }

    private static final void zzl() {
        Handler handler = zzc;
        if (handler != null) {
            handler.removeCallbacks(zze);
            zzc = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfhs
    public final void zza(View view, zzfht zzfhtVar, JSONObject jSONObject, boolean z3) {
        int zzk;
        boolean z4;
        boolean z5;
        if (zzfie.zzb(view) != null || (zzk = this.zzk.zzk(view)) == 3) {
            return;
        }
        JSONObject zza2 = zzfhtVar.zza(view);
        zzfib.zzc(jSONObject, zza2);
        String zzd2 = this.zzk.zzd(view);
        if (zzd2 != null) {
            zzfib.zzb(zza2, zzd2);
            try {
                zza2.put("hasWindowFocus", Boolean.valueOf(this.zzk.zzj(view)));
            } catch (JSONException e4) {
                zzfic.zza("Error with setting not visible reason", e4);
            }
            this.zzk.zzh();
        } else {
            zzfif zzb2 = this.zzk.zzb(view);
            if (zzb2 != null) {
                zzfhn zza3 = zzb2.zza();
                JSONArray jSONArray = new JSONArray();
                ArrayList zzb3 = zzb2.zzb();
                int size = zzb3.size();
                for (int i4 = 0; i4 < size; i4++) {
                    jSONArray.put((String) zzb3.get(i4));
                }
                try {
                    zza2.put("isFriendlyObstructionFor", jSONArray);
                    zza2.put("friendlyObstructionClass", zza3.zzd());
                    zza2.put("friendlyObstructionPurpose", zza3.zza());
                    zza2.put("friendlyObstructionReason", zza3.zzc());
                } catch (JSONException e5) {
                    zzfic.zza("Error with setting friendly obstruction", e5);
                }
                z4 = true;
            } else {
                z4 = false;
            }
            if (!z3 && !z4) {
                z5 = false;
            } else {
                z5 = true;
            }
            zzk(view, zzfhtVar, zza2, zzk, z5);
        }
        this.zzg++;
    }

    public final void zzh() {
        zzl();
    }

    public final void zzi() {
        if (zzc == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            zzc = handler;
            handler.post(zzd);
            zzc.postDelayed(zze, 200L);
        }
    }

    public final void zzj() {
        zzl();
        this.zzf.clear();
        zzb.post(new zzfii(this));
    }
}
