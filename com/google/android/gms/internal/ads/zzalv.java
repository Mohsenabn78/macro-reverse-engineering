package com.google.android.gms.internal.ads;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzalv {
    public static final boolean zza = zzalw.zzb;
    private final List zzb = new ArrayList();
    private boolean zzc = false;

    protected final void finalize() throws Throwable {
        if (!this.zzc) {
            zzb("Request on the loose");
            zzalw.zzb("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
        }
    }

    public final synchronized void zza(String str, long j4) {
        if (!this.zzc) {
            this.zzb.add(new zzalu(str, j4, SystemClock.elapsedRealtime()));
        } else {
            throw new IllegalStateException("Marker added to finished log");
        }
    }

    public final synchronized void zzb(String str) {
        List list;
        long j4;
        this.zzc = true;
        if (this.zzb.size() == 0) {
            j4 = 0;
        } else {
            j4 = ((zzalu) this.zzb.get(list.size() - 1)).zzc - ((zzalu) this.zzb.get(0)).zzc;
        }
        if (j4 <= 0) {
            return;
        }
        long j5 = ((zzalu) this.zzb.get(0)).zzc;
        zzalw.zza("(%-4d ms) %s", Long.valueOf(j4), str);
        for (zzalu zzaluVar : this.zzb) {
            long j6 = zzaluVar.zzc;
            zzalw.zza("(+%-4d) [%2d] %s", Long.valueOf(j6 - j5), Long.valueOf(zzaluVar.zzb), zzaluVar.zza);
            j5 = j6;
        }
    }
}
