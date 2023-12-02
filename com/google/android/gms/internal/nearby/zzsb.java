package com.google.android.gms.internal.nearby;

import android.content.ContentResolver;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzsb {
    static HashMap zze;
    static boolean zzj;
    private static Object zzm;
    public static final Uri zza = Uri.parse("content://com.google.android.gsf.gservices");
    public static final Uri zzb = Uri.parse("content://com.google.android.gsf.gservices/prefix");
    public static final Pattern zzc = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
    public static final Pattern zzd = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    private static final AtomicBoolean zzl = new AtomicBoolean();
    static final HashMap zzf = new HashMap(16, 1.0f);
    static final HashMap zzg = new HashMap(16, 1.0f);
    static final HashMap zzh = new HashMap(16, 1.0f);
    static final HashMap zzi = new HashMap(16, 1.0f);
    static final String[] zzk = new String[0];

    /* JADX WARN: Removed duplicated region for block: B:91:0x00d1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean zzb(android.content.ContentResolver r16, java.lang.String r17, boolean r18) {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.nearby.zzsb.zzb(android.content.ContentResolver, java.lang.String, boolean):boolean");
    }

    private static void zzc(ContentResolver contentResolver) {
        if (zze == null) {
            zzl.set(false);
            zze = new HashMap(16, 1.0f);
            zzm = new Object();
            zzj = false;
            contentResolver.registerContentObserver(zza, true, new zzsa(null));
        } else if (zzl.getAndSet(false)) {
            zze.clear();
            zzf.clear();
            zzg.clear();
            zzh.clear();
            zzi.clear();
            zzm = new Object();
            zzj = false;
        }
    }

    private static void zzd(Object obj, String str, String str2) {
        synchronized (zzsb.class) {
            if (obj == zzm) {
                zze.put("gms:nearby:requires_gms_check", str2);
            }
        }
    }
}
