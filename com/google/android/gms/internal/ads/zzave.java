package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzave {
    private final int zza;
    private final zzavb zzb = new zzavg();

    public zzave(int i4) {
        this.zza = i4;
    }

    public final String zza(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append(((String) arrayList.get(i4)).toLowerCase(Locale.US));
            sb.append('\n');
        }
        String[] split = sb.toString().split("\n");
        if (split.length == 0) {
            return "";
        }
        zzavd zzavdVar = new zzavd();
        PriorityQueue priorityQueue = new PriorityQueue(this.zza, new zzavc(this));
        for (String str : split) {
            String[] zzb = zzavf.zzb(str, false);
            if (zzb.length != 0) {
                zzavj.zzc(zzb, this.zza, 6, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzavdVar.zzb.write(this.zzb.zzb(((zzavi) it.next()).zzb));
            } catch (IOException e4) {
                zzbzr.zzh("Error while writing hash to byteStream", e4);
            }
        }
        return zzavdVar.toString();
    }
}
