package com.google.android.gms.internal.consent_sdk;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
final class zzy {
    private final zzz zza;
    private final zzbw zzb;
    private int zzc = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzy(zzz zzzVar, zzbw zzbwVar) {
        this.zza = zzzVar;
        this.zzb = zzbwVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0082 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.consent_sdk.zzaa zza() throws com.google.android.gms.internal.consent_sdk.zzj {
        /*
            r11 = this;
            com.google.android.gms.internal.consent_sdk.zzbw r0 = r11.zzb
            int r1 = r0.zzf
            int r2 = r1 + (-1)
            r3 = 0
            if (r1 == 0) goto Lc4
            r1 = 2
            r4 = 3
            r5 = 1
            switch(r2) {
                case 1: goto L59;
                case 2: goto L59;
                case 3: goto L59;
                case 4: goto L56;
                case 5: goto L53;
                case 6: goto L35;
                case 7: goto L17;
                default: goto Lf;
            }
        Lf:
            com.google.android.gms.internal.consent_sdk.zzj r0 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r1 = "Invalid response from server."
            r0.<init>(r5, r1)
            throw r0
        L17:
            com.google.android.gms.internal.consent_sdk.zzj r1 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r0 = r0.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            java.lang.String r3 = "Publisher misconfiguration: "
            if (r2 == 0) goto L2c
            java.lang.String r0 = r3.concat(r0)
            goto L31
        L2c:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L31:
            r1.<init>(r4, r0)
            throw r1
        L35:
            com.google.android.gms.internal.consent_sdk.zzj r1 = new com.google.android.gms.internal.consent_sdk.zzj
            java.lang.String r0 = r0.zzc
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r2 = r0.length()
            java.lang.String r3 = "Invalid response from server: "
            if (r2 == 0) goto L4a
            java.lang.String r0 = r3.concat(r0)
            goto L4f
        L4a:
            java.lang.String r0 = new java.lang.String
            r0.<init>(r3)
        L4f:
            r1.<init>(r5, r0)
            throw r1
        L53:
            r11.zzc = r5
            goto L5b
        L56:
            r11.zzc = r1
            goto L5b
        L59:
            r11.zzc = r4
        L5b:
            java.lang.String r2 = r0.zza
            if (r2 != 0) goto L61
            r4 = r3
            goto L68
        L61:
            com.google.android.gms.internal.consent_sdk.zzbc r4 = new com.google.android.gms.internal.consent_sdk.zzbc
            java.lang.String r0 = r0.zzb
            r4.<init>(r0, r2)
        L68:
            com.google.android.gms.internal.consent_sdk.zzz r0 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzam r0 = com.google.android.gms.internal.consent_sdk.zzz.zzc(r0)
            java.util.HashSet r2 = new java.util.HashSet
            com.google.android.gms.internal.consent_sdk.zzbw r6 = r11.zzb
            java.util.List<java.lang.String> r6 = r6.zzd
            r2.<init>(r6)
            r0.zzg(r2)
            com.google.android.gms.internal.consent_sdk.zzbw r0 = r11.zzb
            java.util.List<com.google.android.gms.internal.consent_sdk.zzbv> r0 = r0.zze
            java.util.Iterator r0 = r0.iterator()
        L82:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lbc
            java.lang.Object r2 = r0.next()
            com.google.android.gms.internal.consent_sdk.zzbv r2 = (com.google.android.gms.internal.consent_sdk.zzbv) r2
            int r6 = r2.zzb
            int r7 = r6 + (-1)
            if (r6 == 0) goto Lbb
            if (r7 == 0) goto La1
            if (r7 == r5) goto L9e
            if (r7 == r1) goto L9b
            goto La1
        L9b:
            java.lang.String r6 = "clear"
            goto La2
        L9e:
            java.lang.String r6 = "write"
            goto La2
        La1:
            r6 = r3
        La2:
            if (r6 == 0) goto L82
            com.google.android.gms.internal.consent_sdk.zzz r7 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzh r7 = com.google.android.gms.internal.consent_sdk.zzz.zza(r7)
            java.lang.String r2 = r2.zza
            com.google.android.gms.internal.consent_sdk.zzg[] r8 = new com.google.android.gms.internal.consent_sdk.zzg[r5]
            com.google.android.gms.internal.consent_sdk.zzz r9 = r11.zza
            com.google.android.gms.internal.consent_sdk.zzak r9 = com.google.android.gms.internal.consent_sdk.zzz.zzb(r9)
            r10 = 0
            r8[r10] = r9
            r7.zzb(r6, r2, r8)
            goto L82
        Lbb:
            throw r3
        Lbc:
            com.google.android.gms.internal.consent_sdk.zzaa r0 = new com.google.android.gms.internal.consent_sdk.zzaa
            int r1 = r11.zzc
            r0.<init>(r1, r4, r3)
            return r0
        Lc4:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.consent_sdk.zzy.zza():com.google.android.gms.internal.consent_sdk.zzaa");
    }
}
