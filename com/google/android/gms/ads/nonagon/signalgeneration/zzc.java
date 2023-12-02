package com.google.android.gms.ads.nonagon.signalgeneration;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.ads.internal.client.zzba;
import com.google.android.gms.internal.ads.zzbbm;
import com.google.android.gms.internal.ads.zzcae;
import com.google.android.gms.internal.ads.zzdpv;
import com.google.android.gms.internal.ads.zzdqf;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzc {

    /* renamed from: h  reason: collision with root package name */
    private final zzdqf f19560h;

    /* renamed from: i  reason: collision with root package name */
    private Map f19561i;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayDeque f19558f = new ArrayDeque();

    /* renamed from: g  reason: collision with root package name */
    private final ArrayDeque f19559g = new ArrayDeque();

    /* renamed from: a  reason: collision with root package name */
    private final int f19553a = ((Integer) zzba.zzc().zzb(zzbbm.zzgL)).intValue();

    /* renamed from: b  reason: collision with root package name */
    private final long f19554b = ((Long) zzba.zzc().zzb(zzbbm.zzgM)).longValue();

    /* renamed from: c  reason: collision with root package name */
    private final boolean f19555c = ((Boolean) zzba.zzc().zzb(zzbbm.zzgR)).booleanValue();

    /* renamed from: d  reason: collision with root package name */
    private final boolean f19556d = ((Boolean) zzba.zzc().zzb(zzbbm.zzgP)).booleanValue();

    /* renamed from: e  reason: collision with root package name */
    private final Map f19557e = Collections.synchronizedMap(new zzb(this));

    public zzc(zzdqf zzdqfVar) {
        this.f19560h = zzdqfVar;
    }

    private final synchronized void d(final zzdpv zzdpvVar) {
        if (!this.f19555c) {
            return;
        }
        final ArrayDeque clone = this.f19559g.clone();
        this.f19559g.clear();
        final ArrayDeque clone2 = this.f19558f.clone();
        this.f19558f.clear();
        zzcae.zza.execute(new Runnable() { // from class: com.google.android.gms.ads.nonagon.signalgeneration.zza
            @Override // java.lang.Runnable
            public final void run() {
                zzc.this.c(zzdpvVar, clone, clone2);
            }
        });
    }

    private final void e(zzdpv zzdpvVar, ArrayDeque arrayDeque, String str) {
        Pair pair;
        while (!arrayDeque.isEmpty()) {
            Pair pair2 = (Pair) arrayDeque.poll();
            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(zzdpvVar.zza());
            this.f19561i = concurrentHashMap;
            concurrentHashMap.put("action", "ev");
            this.f19561i.put("e_r", str);
            this.f19561i.put("e_id", (String) pair2.first);
            if (this.f19556d) {
                try {
                    JSONObject jSONObject = new JSONObject((String) pair2.second);
                    pair = new Pair(zzf.zza(jSONObject.getJSONObject("extras").getString("query_info_type")), jSONObject.getString("request_agent"));
                } catch (JSONException unused) {
                    pair = new Pair("", "");
                }
                g(this.f19561i, "e_type", (String) pair.first);
                g(this.f19561i, "e_agent", (String) pair.second);
            }
            this.f19560h.zze(this.f19561i);
        }
    }

    private final synchronized void f() {
        long currentTimeMillis = com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis();
        try {
            Iterator it = this.f19557e.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                if (currentTimeMillis - ((Long) ((Pair) entry.getValue()).first).longValue() <= this.f19554b) {
                    break;
                }
                this.f19559g.add(new Pair((String) entry.getKey(), (String) ((Pair) entry.getValue()).second));
                it.remove();
            }
        } catch (ConcurrentModificationException e4) {
            com.google.android.gms.ads.internal.zzt.zzo().zzu(e4, "QueryJsonMap.removeExpiredEntries");
        }
    }

    private static final void g(Map map, String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            map.put(str, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ void c(zzdpv zzdpvVar, ArrayDeque arrayDeque, ArrayDeque arrayDeque2) {
        e(zzdpvVar, arrayDeque, TypedValues.TransitionType.S_TO);
        e(zzdpvVar, arrayDeque2, "of");
    }

    @Nullable
    public final synchronized String zzb(String str, zzdpv zzdpvVar) {
        Pair pair = (Pair) this.f19557e.get(str);
        zzdpvVar.zza().put("rid", str);
        if (pair != null) {
            String str2 = (String) pair.second;
            this.f19557e.remove(str);
            zzdpvVar.zza().put("mhit", "true");
            return str2;
        }
        zzdpvVar.zza().put("mhit", "false");
        return null;
    }

    public final synchronized void zzd(String str, String str2, zzdpv zzdpvVar) {
        this.f19557e.put(str, new Pair(Long.valueOf(com.google.android.gms.ads.internal.zzt.zzB().currentTimeMillis()), str2));
        f();
        d(zzdpvVar);
    }

    public final synchronized void zzf(String str) {
        this.f19557e.remove(str);
    }
}
