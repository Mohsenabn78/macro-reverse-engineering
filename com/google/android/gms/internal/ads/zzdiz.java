package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
@ParametersAreNonnullByDefault
/* loaded from: classes4.dex */
public final class zzdiz implements zzdhi {
    @Nullable
    private final zzbol zza;
    private final zzcvy zzb;
    private final zzcve zzc;
    private final zzdcs zzd;
    private final Context zze;
    private final zzezn zzf;
    private final zzbzx zzg;
    private final zzfai zzh;
    private boolean zzi = false;
    private boolean zzj = false;
    private boolean zzk = true;
    @Nullable
    private final zzboh zzl;
    @Nullable
    private final zzboi zzm;

    public zzdiz(@Nullable zzboh zzbohVar, @Nullable zzboi zzboiVar, @Nullable zzbol zzbolVar, zzcvy zzcvyVar, zzcve zzcveVar, zzdcs zzdcsVar, Context context, zzezn zzeznVar, zzbzx zzbzxVar, zzfai zzfaiVar) {
        this.zzl = zzbohVar;
        this.zzm = zzboiVar;
        this.zza = zzbolVar;
        this.zzb = zzcvyVar;
        this.zzc = zzcveVar;
        this.zzd = zzdcsVar;
        this.zze = context;
        this.zzf = zzeznVar;
        this.zzg = zzbzxVar;
        this.zzh = zzfaiVar;
    }

    private final void zzb(View view) {
        try {
            zzbol zzbolVar = this.zza;
            if (zzbolVar != null && !zzbolVar.zzA()) {
                this.zza.zzw(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
                    this.zzd.zzr();
                    return;
                }
                return;
            }
            zzboh zzbohVar = this.zzl;
            if (zzbohVar != null && !zzbohVar.zzx()) {
                this.zzl.zzs(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
                    this.zzd.zzr();
                    return;
                }
                return;
            }
            zzboi zzboiVar = this.zzm;
            if (zzboiVar != null && !zzboiVar.zzv()) {
                this.zzm.zzq(ObjectWrapper.wrap(view));
                this.zzc.onAdClicked();
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzjs)).booleanValue()) {
                    this.zzd.zzr();
                }
            }
        } catch (RemoteException e4) {
            zzbzr.zzk("Failed to call handleClick", e4);
        }
    }

    private static final HashMap zzc(Map map) {
        HashMap hashMap = new HashMap();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry entry : map.entrySet()) {
                View view = (View) ((WeakReference) entry.getValue()).get();
                if (view != null) {
                    hashMap.put((String) entry.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final boolean zzA() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final boolean zzB() {
        return this.zzf.zzM;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final boolean zzC(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final int zza() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    @Nullable
    public final JSONObject zze(View view, Map map, Map map2, @Nullable ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    @Nullable
    public final JSONObject zzf(View view, Map map, Map map2, @Nullable ImageView.ScaleType scaleType) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzg() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzj(@Nullable com.google.android.gms.ads.internal.client.zzcw zzcwVar) {
        zzbzr.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzk(View view, @Nullable View view2, @Nullable Map map, @Nullable Map map2, boolean z3, @Nullable ImageView.ScaleType scaleType) {
        if (this.zzj && this.zzf.zzM) {
            return;
        }
        zzb(view);
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzo(View view, View view2, Map map, Map map2, boolean z3, @Nullable ImageView.ScaleType scaleType, int i4) {
        if (!this.zzj) {
            zzbzr.zzj("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzf.zzM) {
            zzbzr.zzj("Custom click reporting for 3p ads failed. Ad unit id not in allow list.");
        } else {
            zzb(view2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzq(@Nullable View view, @Nullable Map map, @Nullable Map map2, @Nullable ImageView.ScaleType scaleType) {
        try {
            if (!this.zzi) {
                this.zzi = com.google.android.gms.ads.internal.zzt.zzs().zzn(this.zze, this.zzg.zza, this.zzf.zzD.toString(), this.zzh.zzf);
            }
            if (!this.zzk) {
                return;
            }
            zzbol zzbolVar = this.zza;
            if (zzbolVar != null && !zzbolVar.zzB()) {
                this.zza.zzx();
                this.zzb.zza();
                return;
            }
            zzboh zzbohVar = this.zzl;
            if (zzbohVar != null && !zzbohVar.zzy()) {
                this.zzl.zzt();
                this.zzb.zza();
                return;
            }
            zzboi zzboiVar = this.zzm;
            if (zzboiVar != null && !zzboiVar.zzw()) {
                this.zzm.zzr();
                this.zzb.zza();
            }
        } catch (RemoteException e4) {
            zzbzr.zzk("Failed to call recordImpression", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzv() {
        this.zzj = true;
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzw(com.google.android.gms.ads.internal.client.zzcs zzcsVar) {
        zzbzr.zzj("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzy(View view, @Nullable Map map, @Nullable Map map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        Map map3;
        Map map4;
        Object obj;
        IObjectWrapper zzn;
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            JSONObject jSONObject = this.zzf.zzak;
            boolean z3 = true;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbt)).booleanValue() && jSONObject.length() != 0) {
                if (map == null) {
                    map3 = new HashMap();
                } else {
                    map3 = map;
                }
                if (map2 == null) {
                    map4 = new HashMap();
                } else {
                    map4 = map2;
                }
                HashMap hashMap = new HashMap();
                hashMap.putAll(map3);
                hashMap.putAll(map4);
                Iterator<String> keys = jSONObject.keys();
                loop0: while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    if (optJSONArray != null) {
                        WeakReference weakReference = (WeakReference) hashMap.get(next);
                        if (weakReference != null && (obj = weakReference.get()) != null) {
                            Class<?> cls = obj.getClass();
                            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzbu)).booleanValue() && next.equals("3010")) {
                                zzbol zzbolVar = this.zza;
                                Object obj2 = null;
                                if (zzbolVar != null) {
                                    try {
                                        zzn = zzbolVar.zzn();
                                    } catch (RemoteException | IllegalArgumentException unused) {
                                    }
                                } else {
                                    zzboh zzbohVar = this.zzl;
                                    if (zzbohVar != null) {
                                        zzn = zzbohVar.zzk();
                                    } else {
                                        zzboi zzboiVar = this.zzm;
                                        if (zzboiVar != null) {
                                            zzn = zzboiVar.zzj();
                                        } else {
                                            zzn = null;
                                        }
                                    }
                                }
                                if (zzn != null) {
                                    obj2 = ObjectWrapper.unwrap(zzn);
                                }
                                if (obj2 != null) {
                                    cls = obj2.getClass();
                                }
                            }
                            try {
                                ArrayList<String> arrayList = new ArrayList();
                                com.google.android.gms.ads.internal.util.zzbu.zzc(optJSONArray, arrayList);
                                com.google.android.gms.ads.internal.zzt.zzp();
                                ClassLoader classLoader = this.zze.getClassLoader();
                                for (String str : arrayList) {
                                    if (Class.forName(str, false, classLoader).isAssignableFrom(cls)) {
                                        break;
                                    }
                                }
                            } catch (JSONException unused2) {
                                continue;
                            }
                        }
                        z3 = false;
                        break;
                    }
                }
            }
            this.zzk = z3;
            HashMap zzc = zzc(map);
            HashMap zzc2 = zzc(map2);
            zzbol zzbolVar2 = this.zza;
            if (zzbolVar2 != null) {
                zzbolVar2.zzy(wrap, ObjectWrapper.wrap(zzc), ObjectWrapper.wrap(zzc2));
                return;
            }
            zzboh zzbohVar2 = this.zzl;
            if (zzbohVar2 != null) {
                zzbohVar2.zzv(wrap, ObjectWrapper.wrap(zzc), ObjectWrapper.wrap(zzc2));
                this.zzl.zzu(wrap);
                return;
            }
            zzboi zzboiVar2 = this.zzm;
            if (zzboiVar2 != null) {
                zzboiVar2.zzt(wrap, ObjectWrapper.wrap(zzc), ObjectWrapper.wrap(zzc2));
                this.zzm.zzs(wrap);
            }
        } catch (RemoteException e4) {
            zzbzr.zzk("Failed to call trackView", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzz(View view, @Nullable Map map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            zzbol zzbolVar = this.zza;
            if (zzbolVar != null) {
                zzbolVar.zzz(wrap);
                return;
            }
            zzboh zzbohVar = this.zzl;
            if (zzbohVar != null) {
                zzbohVar.zzw(wrap);
                return;
            }
            zzboi zzboiVar = this.zzm;
            if (zzboiVar != null) {
                zzboiVar.zzu(wrap);
            }
        } catch (RemoteException e4) {
            zzbzr.zzk("Failed to call untrackView", e4);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzh() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzi() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzp() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzr() {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzl(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzm(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzt(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzu(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzx(zzbgl zzbglVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdhi
    public final void zzs(View view, MotionEvent motionEvent, @Nullable View view2) {
    }
}
