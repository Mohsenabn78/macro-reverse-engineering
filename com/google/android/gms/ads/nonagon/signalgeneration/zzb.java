package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzb extends LinkedHashMap {
    final /* synthetic */ zzc zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzb(zzc zzcVar) {
        this.zza = zzcVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        int i4;
        ArrayDeque arrayDeque;
        int i5;
        synchronized (this.zza) {
            int size = size();
            zzc zzcVar = this.zza;
            i4 = zzcVar.f19553a;
            boolean z3 = false;
            if (size > i4) {
                arrayDeque = zzcVar.f19558f;
                arrayDeque.add(new Pair((String) entry.getKey(), (String) ((Pair) entry.getValue()).second));
                int size2 = size();
                i5 = this.zza.f19553a;
                if (size2 > i5) {
                    z3 = true;
                }
                return z3;
            }
            return false;
        }
    }
}
