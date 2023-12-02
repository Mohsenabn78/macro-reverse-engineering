package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import androidx.annotation.GuardedBy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbyb {
    @GuardedBy("this")
    private final Map zza = new HashMap();
    @GuardedBy("this")
    private final List zzb = new ArrayList();
    private final Context zzc;
    private final zzbwy zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbyb(Context context, zzbwy zzbwyVar) {
        this.zzc = context;
        this.zzd = zzbwyVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, SharedPreferences sharedPreferences, String str, String str2) {
        if (!map.containsKey(str) || !((Set) map.get(str)).contains(str2)) {
            return;
        }
        this.zzd.zze();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzc(String str) {
        SharedPreferences sharedPreferences;
        if (this.zza.containsKey(str)) {
            return;
        }
        if ("__default__".equals(str)) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.zzc);
        } else {
            sharedPreferences = this.zzc.getSharedPreferences(str, 0);
        }
        zzbya zzbyaVar = new zzbya(this, str);
        this.zza.put(str, zzbyaVar);
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzbyaVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zzd(zzbxz zzbxzVar) {
        this.zzb.add(zzbxzVar);
    }
}
