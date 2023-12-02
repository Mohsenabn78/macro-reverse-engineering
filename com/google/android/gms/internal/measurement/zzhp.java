package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhp {
    static volatile zzii zza = zzii.zzc();
    private static final Object zzb = new Object();

    /* JADX WARN: Can't wrap try/catch for region: R(11:18|(8:20|(1:22)(1:31)|23|(1:25)|27|28|29|30)|32|33|34|35|(1:37)|27|28|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        if ("com.google.android.gms".equals(r0.packageName) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zza(android.content.Context r5, android.net.Uri r6) {
        /*
            java.lang.String r0 = "com.google.android.gms.phenotype"
            java.lang.String r6 = r6.getAuthority()
            boolean r0 = r0.equals(r6)
            r1 = 0
            if (r0 != 0) goto L1d
            java.lang.String r5 = java.lang.String.valueOf(r6)
            java.lang.String r6 = " is an unsupported authority. Only com.google.android.gms.phenotype authority is supported."
            java.lang.String r0 = "PhenotypeClientHelper"
            java.lang.String r5 = r5.concat(r6)
            android.util.Log.e(r0, r5)
            return r1
        L1d:
            com.google.android.gms.internal.measurement.zzii r6 = com.google.android.gms.internal.measurement.zzhp.zza
            boolean r6 = r6.zzb()
            if (r6 == 0) goto L32
            com.google.android.gms.internal.measurement.zzii r5 = com.google.android.gms.internal.measurement.zzhp.zza
            java.lang.Object r5 = r5.zza()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L32:
            java.lang.Object r6 = com.google.android.gms.internal.measurement.zzhp.zzb
            monitor-enter(r6)
            com.google.android.gms.internal.measurement.zzii r0 = com.google.android.gms.internal.measurement.zzhp.zza     // Catch: java.lang.Throwable -> La0
            boolean r0 = r0.zzb()     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L4b
            com.google.android.gms.internal.measurement.zzii r5 = com.google.android.gms.internal.measurement.zzhp.zza     // Catch: java.lang.Throwable -> La0
            java.lang.Object r5 = r5.zza()     // Catch: java.lang.Throwable -> La0
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> La0
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> La0
            monitor-exit(r6)     // Catch: java.lang.Throwable -> La0
            return r5
        L4b:
            java.lang.String r0 = "com.google.android.gms"
            java.lang.String r2 = r5.getPackageName()     // Catch: java.lang.Throwable -> La0
            boolean r0 = r0.equals(r2)     // Catch: java.lang.Throwable -> La0
            if (r0 != 0) goto L77
            android.content.pm.PackageManager r0 = r5.getPackageManager()     // Catch: java.lang.Throwable -> La0
            java.lang.String r2 = "com.google.android.gms.phenotype"
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> La0
            r4 = 29
            if (r3 >= r4) goto L65
            r3 = 0
            goto L67
        L65:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
        L67:
            android.content.pm.ProviderInfo r0 = r0.resolveContentProvider(r2, r3)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L88
            java.lang.String r2 = "com.google.android.gms"
            java.lang.String r0 = r0.packageName     // Catch: java.lang.Throwable -> La0
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> La0
            if (r0 == 0) goto L88
        L77:
            android.content.pm.PackageManager r5 = r5.getPackageManager()     // Catch: java.lang.Throwable -> La0
            java.lang.String r0 = "com.google.android.gms"
            android.content.pm.ApplicationInfo r5 = r5.getApplicationInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L88 java.lang.Throwable -> La0
            int r5 = r5.flags     // Catch: java.lang.Throwable -> La0
            r5 = r5 & 129(0x81, float:1.81E-43)
            if (r5 == 0) goto L88
            r1 = 1
        L88:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r1)     // Catch: java.lang.Throwable -> La0
            com.google.android.gms.internal.measurement.zzii r5 = com.google.android.gms.internal.measurement.zzii.zzd(r5)     // Catch: java.lang.Throwable -> La0
            com.google.android.gms.internal.measurement.zzhp.zza = r5     // Catch: java.lang.Throwable -> La0
            monitor-exit(r6)     // Catch: java.lang.Throwable -> La0
            com.google.android.gms.internal.measurement.zzii r5 = com.google.android.gms.internal.measurement.zzhp.zza
            java.lang.Object r5 = r5.zza()
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        La0:
            r5 = move-exception
            monitor-exit(r6)     // Catch: java.lang.Throwable -> La0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.zzhp.zza(android.content.Context, android.net.Uri):boolean");
    }
}
