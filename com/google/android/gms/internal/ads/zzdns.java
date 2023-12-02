package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzdns {
    private final Map zza = new HashMap();

    @Nullable
    public final synchronized zzdnr zza(String str) {
        return (zzdnr) this.zza.get(str);
    }

    @Nullable
    public final zzdnr zzb(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdnr zza = zza((String) it.next());
            if (zza != null) {
                return zza;
            }
        }
        return null;
    }

    public final String zzc(String str) {
        zzbqh zzbqhVar;
        zzdnr zza = zza(str);
        if (zza != null && (zzbqhVar = zza.zzb) != null) {
            return zzbqhVar.toString();
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x001c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void zzd(java.lang.String r6, @javax.annotation.Nullable com.google.android.gms.internal.ads.zzfbd r7) {
        /*
            r5 = this;
            monitor-enter(r5)
            java.util.Map r0 = r5.zza     // Catch: java.lang.Throwable -> L46
            boolean r0 = r0.containsKey(r6)     // Catch: java.lang.Throwable -> L46
            if (r0 == 0) goto Lb
            monitor-exit(r5)
            return
        Lb:
            com.google.android.gms.internal.ads.zzdnr r0 = new com.google.android.gms.internal.ads.zzdnr     // Catch: java.lang.Throwable -> L46
            r1 = 0
            if (r7 != 0) goto L12
        L10:
            r2 = r1
            goto L19
        L12:
            com.google.android.gms.internal.ads.zzbqh r2 = r7.zze()     // Catch: com.google.android.gms.internal.ads.zzfan -> L17 java.lang.Throwable -> L46
            goto L19
        L17:
            goto L10
        L19:
            if (r7 != 0) goto L1c
            goto L20
        L1c:
            com.google.android.gms.internal.ads.zzbqh r1 = r7.zzf()     // Catch: com.google.android.gms.internal.ads.zzfan -> L20 java.lang.Throwable -> L46
        L20:
            com.google.android.gms.internal.ads.zzbbe r3 = com.google.android.gms.internal.ads.zzbbm.zziP     // Catch: java.lang.Throwable -> L46
            com.google.android.gms.internal.ads.zzbbk r4 = com.google.android.gms.ads.internal.client.zzba.zzc()     // Catch: java.lang.Throwable -> L46
            java.lang.Object r3 = r4.zzb(r3)     // Catch: java.lang.Throwable -> L46
            java.lang.Boolean r3 = (java.lang.Boolean) r3     // Catch: java.lang.Throwable -> L46
            boolean r3 = r3.booleanValue()     // Catch: java.lang.Throwable -> L46
            r4 = 1
            if (r3 != 0) goto L34
            goto L3c
        L34:
            r3 = 0
            if (r7 != 0) goto L39
        L37:
            r4 = 0
            goto L3c
        L39:
            r7.zzC()     // Catch: com.google.android.gms.internal.ads.zzfan -> L37 java.lang.Throwable -> L46
        L3c:
            r0.<init>(r6, r2, r1, r4)     // Catch: java.lang.Throwable -> L46
            java.util.Map r7 = r5.zza     // Catch: java.lang.Throwable -> L46
            r7.put(r6, r0)     // Catch: java.lang.Throwable -> L46
            monitor-exit(r5)
            return
        L46:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdns.zzd(java.lang.String, com.google.android.gms.internal.ads.zzfbd):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final synchronized void zze(String str, zzbpt zzbptVar) {
        if (this.zza.containsKey(str)) {
            return;
        }
        try {
            this.zza.put(str, new zzdnr(str, zzbptVar.zzf(), zzbptVar.zzg(), true));
        } catch (Throwable unused) {
        }
    }
}
