package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.IInterface;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfob extends zzfnx {
    final /* synthetic */ zzfoh zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzfob(zzfoh zzfohVar) {
        this.zza = zzfohVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfnx
    public final void zza() {
        Object obj;
        AtomicInteger atomicInteger;
        IInterface iInterface;
        zzfnw zzfnwVar;
        Context context;
        ServiceConnection serviceConnection;
        AtomicInteger atomicInteger2;
        zzfnw zzfnwVar2;
        obj = this.zza.zzg;
        synchronized (obj) {
            atomicInteger = this.zza.zzl;
            if (atomicInteger.get() > 0) {
                atomicInteger2 = this.zza.zzl;
                if (atomicInteger2.decrementAndGet() > 0) {
                    zzfnwVar2 = this.zza.zzc;
                    zzfnwVar2.zzc("Leaving the connection open for other ongoing calls.", new Object[0]);
                    return;
                }
            }
            zzfoh zzfohVar = this.zza;
            iInterface = zzfohVar.zzn;
            if (iInterface != null) {
                zzfnwVar = zzfohVar.zzc;
                zzfnwVar.zzc("Unbind from service.", new Object[0]);
                zzfoh zzfohVar2 = this.zza;
                context = zzfohVar2.zzb;
                serviceConnection = zzfohVar2.zzm;
                context.unbindService(serviceConnection);
                this.zza.zzh = false;
                this.zza.zzn = null;
                this.zza.zzm = null;
            }
            this.zza.zzw();
        }
    }
}
