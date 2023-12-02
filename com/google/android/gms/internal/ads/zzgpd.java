package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzgpd {
    private static final zzgpd zzb = new zzgpd(true);
    final zzgsc zza = new zzgrs(16);
    private boolean zzc;
    private boolean zzd;

    private zzgpd() {
    }

    public static zzgpd zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.ads.zzgpc r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.ads.zzgsw r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.ads.zzgpw.zzd
            r5.getClass()
            com.google.android.gms.internal.ads.zzgsw r1 = com.google.android.gms.internal.ads.zzgsw.zza
            com.google.android.gms.internal.ads.zzgsx r1 = com.google.android.gms.internal.ads.zzgsx.INT
            com.google.android.gms.internal.ads.zzgsx r0 = r0.zza()
            int r0 = r0.ordinal()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                case 2: goto L3d;
                case 3: goto L3a;
                case 4: goto L37;
                case 5: goto L34;
                case 6: goto L2b;
                case 7: goto L22;
                case 8: goto L19;
                default: goto L18;
            }
        L18:
            goto L48
        L19:
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgqw
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgqb
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgpo
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.ads.zzgoe
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof byte[]
            if (r0 == 0) goto L48
            goto L47
        L34:
            boolean r0 = r5 instanceof java.lang.String
            goto L45
        L37:
            boolean r0 = r5 instanceof java.lang.Boolean
            goto L45
        L3a:
            boolean r0 = r5 instanceof java.lang.Double
            goto L45
        L3d:
            boolean r0 = r5 instanceof java.lang.Float
            goto L45
        L40:
            boolean r0 = r5 instanceof java.lang.Long
            goto L45
        L43:
            boolean r0 = r5 instanceof java.lang.Integer
        L45:
            if (r0 == 0) goto L48
        L47:
            return
        L48:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]
            int r2 = r4.zza()
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r3 = 0
            r1[r3] = r2
            com.google.android.gms.internal.ads.zzgsw r4 = r4.zzb()
            com.google.android.gms.internal.ads.zzgsx r4 = r4.zza()
            r2 = 1
            r1[r2] = r4
            java.lang.Class r4 = r5.getClass()
            java.lang.String r4 = r4.getName()
            r5 = 2
            r1[r5] = r4
            java.lang.String r4 = "Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n"
            java.lang.String r4 = java.lang.String.format(r4, r1)
            r0.<init>(r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgpd.zzd(com.google.android.gms.internal.ads.zzgpc, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgpd zzgpdVar = new zzgpd();
        for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
            Map.Entry zzg = this.zza.zzg(i4);
            zzgpdVar.zzc((zzgpc) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzgpdVar.zzc((zzgpc) entry.getKey(), entry.getValue());
        }
        zzgpdVar.zzd = this.zzd;
        return zzgpdVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgpd)) {
            return false;
        }
        return this.zza.equals(((zzgpd) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
                Map.Entry zzg = this.zza.zzg(i4);
                if (zzg.getValue() instanceof zzgpm) {
                    ((zzgpm) zzg.getValue()).zzaS();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzgpc zzgpcVar, Object obj) {
        if (zzgpcVar.zzc()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    zzd(zzgpcVar, arrayList.get(i4));
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzd(zzgpcVar, obj);
        }
        if (obj instanceof zzgqb) {
            this.zzd = true;
        }
        this.zza.put(zzgpcVar, obj);
    }

    private zzgpd(boolean z3) {
        zzb();
        zzb();
    }
}
