package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzfbb {
    @GuardedBy("LiteSdkInfoRetriever.class")
    private static zzfbb zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    @VisibleForTesting
    zzfbb(Context context, com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        this.zzb = context;
        this.zzc = zzclVar;
    }

    @VisibleForTesting
    static com.google.android.gms.ads.internal.client.zzcl zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e4) {
            zzbzr.zzh("Failed to retrieve lite SDK info.", e4);
            return null;
        }
    }

    public static zzfbb zzd(Context context) {
        synchronized (zzfbb.class) {
            zzfbb zzfbbVar = zza;
            if (zzfbbVar != null) {
                return zzfbbVar;
            }
            Context applicationContext = context.getApplicationContext();
            long longValue = ((Long) zzbdh.zzb.zze()).longValue();
            com.google.android.gms.ads.internal.client.zzcl zzclVar = null;
            if (longValue > 0 && longValue <= 232400000) {
                zzclVar = zza(applicationContext);
            }
            zzfbb zzfbbVar2 = new zzfbb(applicationContext, zzclVar);
            zza = zzfbbVar2;
            return zzfbbVar2;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzen zzg() {
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar != null) {
            try {
                return zzclVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbnw zzb() {
        return (zzbnw) this.zzd.get();
    }

    public final zzbzx zzc(int i4, boolean z3, int i5) {
        com.google.android.gms.ads.internal.zzt.zzp();
        boolean zzA = com.google.android.gms.ads.internal.util.zzs.zzA(this.zzb);
        zzbzx zzbzxVar = new zzbzx(ModuleDescriptor.MODULE_VERSION, i5, true, zzA);
        if (!((Boolean) zzbdh.zzc.zze()).booleanValue()) {
            return zzbzxVar;
        }
        com.google.android.gms.ads.internal.client.zzen zzg = zzg();
        if (zzg == null) {
            return zzbzxVar;
        }
        return new zzbzx(ModuleDescriptor.MODULE_VERSION, zzg.zza(), true, zzA);
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzen zzg = zzg();
        if (zzg != null) {
            return zzg.zzb();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zzf(com.google.android.gms.internal.ads.zzbnw r4) {
        /*
            r3 = this;
            com.google.android.gms.internal.ads.zzbcr r0 = com.google.android.gms.internal.ads.zzbdh.zza
            java.lang.Object r0 = r0.zze()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            if (r0 == 0) goto L25
            com.google.android.gms.ads.internal.client.zzcl r0 = r3.zzc
            if (r0 != 0) goto L15
        L13:
            r0 = r1
            goto L1c
        L15:
            com.google.android.gms.internal.ads.zzbnw r0 = r0.getAdapterCreator()     // Catch: android.os.RemoteException -> L1a
            goto L1c
        L1a:
            goto L13
        L1c:
            java.util.concurrent.atomic.AtomicReference r2 = r3.zzd
            if (r0 == 0) goto L21
            r4 = r0
        L21:
            com.google.android.gms.internal.ads.zzfba.zza(r2, r1, r4)
            return
        L25:
            java.util.concurrent.atomic.AtomicReference r0 = r3.zzd
            com.google.android.gms.internal.ads.zzfba.zza(r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfbb.zzf(com.google.android.gms.internal.ads.zzbnw):void");
    }
}
