package com.google.android.gms.measurement.internal;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzoy;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzu {

    /* renamed from: a  reason: collision with root package name */
    private String f22090a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f22091b;

    /* renamed from: c  reason: collision with root package name */
    private com.google.android.gms.internal.measurement.zzgi f22092c;

    /* renamed from: d  reason: collision with root package name */
    private BitSet f22093d;

    /* renamed from: e  reason: collision with root package name */
    private BitSet f22094e;

    /* renamed from: f  reason: collision with root package name */
    private Map f22095f;

    /* renamed from: g  reason: collision with root package name */
    private Map f22096g;

    /* renamed from: h  reason: collision with root package name */
    final /* synthetic */ zzaa f22097h;

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzu(zzaa zzaaVar, String str, zzt zztVar) {
        this.f22097h = zzaaVar;
        this.f22090a = str;
        this.f22091b = true;
        this.f22093d = new BitSet();
        this.f22094e = new BitSet();
        this.f22095f = new ArrayMap();
        this.f22096g = new ArrayMap();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ BitSet b(zzu zzuVar) {
        return zzuVar.f22093d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public final com.google.android.gms.internal.measurement.zzfp a(int i4) {
        ArrayList arrayList;
        List list;
        com.google.android.gms.internal.measurement.zzfo zzb = com.google.android.gms.internal.measurement.zzfp.zzb();
        zzb.zza(i4);
        zzb.zzc(this.f22091b);
        com.google.android.gms.internal.measurement.zzgi zzgiVar = this.f22092c;
        if (zzgiVar != null) {
            zzb.zzd(zzgiVar);
        }
        com.google.android.gms.internal.measurement.zzgh zze = com.google.android.gms.internal.measurement.zzgi.zze();
        zze.zzb(zzlj.A(this.f22093d));
        zze.zzd(zzlj.A(this.f22094e));
        Map map = this.f22095f;
        if (map == null) {
            arrayList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(map.size());
            for (Integer num : this.f22095f.keySet()) {
                int intValue = num.intValue();
                Long l4 = (Long) this.f22095f.get(Integer.valueOf(intValue));
                if (l4 != null) {
                    com.google.android.gms.internal.measurement.zzfq zzc = com.google.android.gms.internal.measurement.zzfr.zzc();
                    zzc.zzb(intValue);
                    zzc.zza(l4.longValue());
                    arrayList2.add((com.google.android.gms.internal.measurement.zzfr) zzc.zzaD());
                }
            }
            arrayList = arrayList2;
        }
        if (arrayList != null) {
            zze.zza(arrayList);
        }
        Map map2 = this.f22096g;
        if (map2 == null) {
            list = Collections.emptyList();
        } else {
            ArrayList arrayList3 = new ArrayList(map2.size());
            for (Integer num2 : this.f22096g.keySet()) {
                com.google.android.gms.internal.measurement.zzgj zzd = com.google.android.gms.internal.measurement.zzgk.zzd();
                zzd.zzb(num2.intValue());
                List list2 = (List) this.f22096g.get(num2);
                if (list2 != null) {
                    Collections.sort(list2);
                    zzd.zza(list2);
                }
                arrayList3.add((com.google.android.gms.internal.measurement.zzgk) zzd.zzaD());
            }
            list = arrayList3;
        }
        zze.zzc(list);
        zzb.zzb(zze);
        return (com.google.android.gms.internal.measurement.zzfp) zzb.zzaD();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(@NonNull zzy zzyVar) {
        int a4 = zzyVar.a();
        Boolean bool = zzyVar.f22106c;
        if (bool != null) {
            BitSet bitSet = this.f22094e;
            bool.booleanValue();
            bitSet.set(a4, true);
        }
        Boolean bool2 = zzyVar.f22107d;
        if (bool2 != null) {
            this.f22093d.set(a4, bool2.booleanValue());
        }
        if (zzyVar.f22108e != null) {
            Map map = this.f22095f;
            Integer valueOf = Integer.valueOf(a4);
            Long l4 = (Long) map.get(valueOf);
            long longValue = zzyVar.f22108e.longValue() / 1000;
            if (l4 == null || longValue > l4.longValue()) {
                this.f22095f.put(valueOf, Long.valueOf(longValue));
            }
        }
        if (zzyVar.f22109f != null) {
            Map map2 = this.f22096g;
            Integer valueOf2 = Integer.valueOf(a4);
            List list = (List) map2.get(valueOf2);
            if (list == null) {
                list = new ArrayList();
                this.f22096g.put(valueOf2, list);
            }
            if (zzyVar.c()) {
                list.clear();
            }
            zzoy.zzc();
            zzag zzf = this.f22097h.f21734a.zzf();
            String str = this.f22090a;
            zzef zzefVar = zzeg.zzY;
            if (zzf.zzs(str, zzefVar) && zzyVar.b()) {
                list.clear();
            }
            zzoy.zzc();
            if (this.f22097h.f21734a.zzf().zzs(this.f22090a, zzefVar)) {
                Long valueOf3 = Long.valueOf(zzyVar.f22109f.longValue() / 1000);
                if (!list.contains(valueOf3)) {
                    list.add(valueOf3);
                    return;
                }
                return;
            }
            list.add(Long.valueOf(zzyVar.f22109f.longValue() / 1000));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzu(zzaa zzaaVar, String str, com.google.android.gms.internal.measurement.zzgi zzgiVar, BitSet bitSet, BitSet bitSet2, Map map, Map map2, zzt zztVar) {
        this.f22097h = zzaaVar;
        this.f22090a = str;
        this.f22093d = bitSet;
        this.f22094e = bitSet2;
        this.f22095f = map;
        this.f22096g = new ArrayMap();
        for (Integer num : map2.keySet()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add((Long) map2.get(num));
            this.f22096g.put(num, arrayList);
        }
        this.f22091b = false;
        this.f22092c = zzgiVar;
    }
}
