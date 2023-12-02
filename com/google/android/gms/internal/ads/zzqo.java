package com.google.android.gms.internal.ads;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzqo {
    public final int zza;
    @Nullable
    public final zzto zzb;
    private final CopyOnWriteArrayList zzc;

    private zzqo(CopyOnWriteArrayList copyOnWriteArrayList, int i4, @Nullable zzto zztoVar) {
        this.zzc = copyOnWriteArrayList;
        this.zza = 0;
        this.zzb = zztoVar;
    }

    @CheckResult
    public final zzqo zza(int i4, @Nullable zzto zztoVar) {
        return new zzqo(this.zzc, 0, zztoVar);
    }

    public final void zzb(Handler handler, zzqp zzqpVar) {
        this.zzc.add(new zzqn(handler, zzqpVar));
    }

    public final void zzc(zzqp zzqpVar) {
        Iterator it = this.zzc.iterator();
        while (it.hasNext()) {
            zzqn zzqnVar = (zzqn) it.next();
            if (zzqnVar.zzb == zzqpVar) {
                this.zzc.remove(zzqnVar);
            }
        }
    }

    public zzqo() {
        this(new CopyOnWriteArrayList(), 0, null);
    }
}
