package com.google.android.gms.internal.ads;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzalx implements zzalj {
    private final Map zza = new HashMap();
    @Nullable
    private final zzakw zzb;
    @Nullable
    private final BlockingQueue zzc;
    private final zzalb zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzalx(@NonNull zzakw zzakwVar, @NonNull BlockingQueue blockingQueue, zzalb zzalbVar) {
        this.zzd = zzalbVar;
        this.zzb = zzakwVar;
        this.zzc = blockingQueue;
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final synchronized void zza(zzalk zzalkVar) {
        String zzj = zzalkVar.zzj();
        List list = (List) this.zza.remove(zzj);
        if (list != null && !list.isEmpty()) {
            if (zzalw.zzb) {
                zzalw.zzd("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), zzj);
            }
            zzalk zzalkVar2 = (zzalk) list.remove(0);
            this.zza.put(zzj, list);
            zzalkVar2.zzu(this);
            try {
                this.zzc.put(zzalkVar2);
            } catch (InterruptedException e4) {
                zzalw.zzb("Couldn't add request to queue. %s", e4.toString());
                Thread.currentThread().interrupt();
                this.zzb.zzb();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzalj
    public final void zzb(zzalk zzalkVar, zzalq zzalqVar) {
        List<zzalk> list;
        zzakt zzaktVar = zzalqVar.zzb;
        if (zzaktVar != null && !zzaktVar.zza(System.currentTimeMillis())) {
            String zzj = zzalkVar.zzj();
            synchronized (this) {
                list = (List) this.zza.remove(zzj);
            }
            if (list != null) {
                if (zzalw.zzb) {
                    zzalw.zzd("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), zzj);
                }
                for (zzalk zzalkVar2 : list) {
                    this.zzd.zzb(zzalkVar2, zzalqVar, null);
                }
                return;
            }
            return;
        }
        zza(zzalkVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized boolean zzc(zzalk zzalkVar) {
        String zzj = zzalkVar.zzj();
        if (this.zza.containsKey(zzj)) {
            List list = (List) this.zza.get(zzj);
            if (list == null) {
                list = new ArrayList();
            }
            zzalkVar.zzm("waiting-for-response");
            list.add(zzalkVar);
            this.zza.put(zzj, list);
            if (zzalw.zzb) {
                zzalw.zza("Request for cacheKey=%s is in flight, putting on hold.", zzj);
            }
            return true;
        }
        this.zza.put(zzj, null);
        zzalkVar.zzu(this);
        if (zzalw.zzb) {
            zzalw.zza("new request, sending to network %s", zzj);
        }
        return false;
    }
}
