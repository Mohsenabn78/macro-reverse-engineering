package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzxm {
    private final CopyOnWriteArrayList zza = new CopyOnWriteArrayList();

    public final void zza(Handler handler, zzxn zzxnVar) {
        zzc(zzxnVar);
        this.zza.add(new zzxl(handler, zzxnVar));
    }

    public final void zzb(final int i4, final long j4, final long j5) {
        boolean z3;
        Handler handler;
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            final zzxl zzxlVar = (zzxl) it.next();
            z3 = zzxlVar.zzc;
            if (!z3) {
                handler = zzxlVar.zza;
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzxk
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzxn zzxnVar;
                        zzxl zzxlVar2 = zzxl.this;
                        int i5 = i4;
                        long j6 = j4;
                        long j7 = j5;
                        zzxnVar = zzxlVar2.zzb;
                        zzxnVar.zzV(i5, j6, j7);
                    }
                });
            }
        }
    }

    public final void zzc(zzxn zzxnVar) {
        zzxn zzxnVar2;
        Iterator it = this.zza.iterator();
        while (it.hasNext()) {
            zzxl zzxlVar = (zzxl) it.next();
            zzxnVar2 = zzxlVar.zzb;
            if (zzxnVar2 == zzxnVar) {
                zzxlVar.zzc();
                this.zza.remove(zzxlVar);
            }
        }
    }
}
