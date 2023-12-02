package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagv  reason: invalid package */
/* loaded from: classes4.dex */
final class zzagv {
    private static final zzagv zzb = new zzagv(true);
    final zzajh zza = new zzaix(16);
    private boolean zzc;
    private boolean zzd;

    private zzagv() {
    }

    public static zzagv zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final void zzd(com.google.android.gms.internal.p002firebaseauthapi.zzagu r4, java.lang.Object r5) {
        /*
            com.google.android.gms.internal.firebase-auth-api.zzake r0 = r4.zzb()
            byte[] r1 = com.google.android.gms.internal.p002firebaseauthapi.zzahj.zzd
            r5.getClass()
            com.google.android.gms.internal.firebase-auth-api.zzake r1 = com.google.android.gms.internal.p002firebaseauthapi.zzake.zza
            com.google.android.gms.internal.firebase-auth-api.zzakf r1 = com.google.android.gms.internal.p002firebaseauthapi.zzakf.INT
            com.google.android.gms.internal.firebase-auth-api.zzakf r0 = r0.zza()
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
            boolean r0 = r5 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzaii
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahn
            if (r0 == 0) goto L48
            goto L47
        L22:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 != 0) goto L47
            boolean r0 = r5 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzahf
            if (r0 == 0) goto L48
            goto L47
        L2b:
            boolean r0 = r5 instanceof com.google.android.gms.internal.p002firebaseauthapi.zzafy
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
            com.google.android.gms.internal.firebase-auth-api.zzake r4 = r4.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzakf r4 = r4.zza()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzagv.zzd(com.google.android.gms.internal.firebase-auth-api.zzagu, java.lang.Object):void");
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzagv zzagvVar = new zzagv();
        for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
            Map.Entry zzg = this.zza.zzg(i4);
            zzagvVar.zzc((zzagu) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzagvVar.zzc((zzagu) entry.getKey(), entry.getValue());
        }
        zzagvVar.zzd = this.zzd;
        return zzagvVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzagv)) {
            return false;
        }
        return this.zza.equals(((zzagv) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i4 = 0; i4 < this.zza.zzb(); i4++) {
                Map.Entry zzg = this.zza.zzg(i4);
                if (zzg.getValue() instanceof zzahd) {
                    ((zzahd) zzg.getValue()).zzF();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzagu zzaguVar, Object obj) {
        if (zzaguVar.zzc()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    zzd(zzaguVar, arrayList.get(i4));
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzd(zzaguVar, obj);
        }
        if (obj instanceof zzahn) {
            this.zzd = true;
        }
        this.zza.put(zzaguVar, obj);
    }

    private zzagv(boolean z3) {
        zzb();
        zzb();
    }
}
