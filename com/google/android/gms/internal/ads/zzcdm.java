package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzcdm implements zzbij {
    @Nullable
    private static final Integer zzb(Map map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt((String) map.get(str)));
        } catch (NumberFormatException unused) {
            zzbzr.zzj("Precache invalid numeric parameter '" + str + "': " + ((String) map.get(str)));
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbij
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcdl zzcdlVar;
        zzcdd zza;
        zzcca zzccaVar = (zzcca) obj;
        if (zzbzr.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            zzbzr.zze("Precache GMSG: ".concat(jSONObject.toString()));
        }
        zzcde zzy = com.google.android.gms.ads.internal.zzt.zzy();
        if (map.containsKey("abort")) {
            if (!zzy.zzd(zzccaVar)) {
                zzbzr.zzj("Precache abort but no precache task running.");
                return;
            }
            return;
        }
        String str = (String) map.get("src");
        Integer zzb = zzb(map, "periodicReportIntervalMs");
        Integer zzb2 = zzb(map, "exoPlayerRenderingIntervalMs");
        Integer zzb3 = zzb(map, "exoPlayerIdleIntervalMs");
        zzcbz zzcbzVar = new zzcbz((String) map.get("flags"));
        boolean z3 = zzcbzVar.zzl;
        if (str != null) {
            String[] strArr = {str};
            String str2 = (String) map.get("demuxed");
            if (str2 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str2);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                        strArr2[i4] = jSONArray.getString(i4);
                    }
                    strArr = strArr2;
                } catch (JSONException unused) {
                    zzbzr.zzj("Malformed demuxed URL list for precache: ".concat(str2));
                    strArr = null;
                }
            }
            if (strArr == null) {
                strArr = new String[]{str};
            }
            if (z3) {
                Iterator it = zzy.iterator();
                while (true) {
                    if (it.hasNext()) {
                        zzcdd zzcddVar = (zzcdd) it.next();
                        if (zzcddVar.zza == zzccaVar && str.equals(zzcddVar.zze())) {
                            zza = zzcddVar;
                            break;
                        }
                    } else {
                        zza = null;
                        break;
                    }
                }
            } else {
                zza = zzy.zza(zzccaVar);
            }
            if (zza != null) {
                zzbzr.zzj("Precache task is already running.");
                return;
            } else if (zzccaVar.zzj() == null) {
                zzbzr.zzj("Precache requires a dependency provider.");
                return;
            } else {
                Integer zzb4 = zzb(map, "player");
                if (zzb4 == null) {
                    zzb4 = 0;
                }
                if (zzb != null) {
                    zzccaVar.zzA(zzb.intValue());
                }
                if (zzb2 != null) {
                    zzccaVar.zzy(zzb2.intValue());
                }
                if (zzb3 != null) {
                    zzccaVar.zzx(zzb3.intValue());
                }
                int intValue = zzb4.intValue();
                zzccx zzccxVar = zzccaVar.zzj().zzb;
                if (intValue > 0) {
                    int zzu = zzcbr.zzu();
                    if (zzu < zzcbzVar.zzh) {
                        zzcdlVar = new zzcdu(zzccaVar, zzcbzVar);
                    } else if (zzu < zzcbzVar.zzb) {
                        zzcdlVar = new zzcdr(zzccaVar, zzcbzVar);
                    } else {
                        zzcdlVar = new zzcdp(zzccaVar);
                    }
                } else {
                    zzcdlVar = new zzcdo(zzccaVar);
                }
                new zzcdd(zzccaVar, zzcdlVar, str, strArr).zzb();
            }
        } else {
            zzcdd zza2 = zzy.zza(zzccaVar);
            if (zza2 != null) {
                zzcdlVar = zza2.zzb;
            } else {
                zzbzr.zzj("Precache must specify a source.");
                return;
            }
        }
        Integer zzb5 = zzb(map, "minBufferMs");
        if (zzb5 != null) {
            zzcdlVar.zzs(zzb5.intValue());
        }
        Integer zzb6 = zzb(map, "maxBufferMs");
        if (zzb6 != null) {
            zzcdlVar.zzr(zzb6.intValue());
        }
        Integer zzb7 = zzb(map, "bufferForPlaybackMs");
        if (zzb7 != null) {
            zzcdlVar.zzp(zzb7.intValue());
        }
        Integer zzb8 = zzb(map, "bufferForPlaybackAfterRebufferMs");
        if (zzb8 != null) {
            zzcdlVar.zzq(zzb8.intValue());
        }
    }
}
