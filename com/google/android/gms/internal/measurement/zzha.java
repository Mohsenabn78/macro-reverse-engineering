package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzha {
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

    public static String zza(ContentResolver contentResolver, String str, String str2) {
        synchronized (zzha.class) {
            String str3 = null;
            if (zze == null) {
                zzl.set(false);
                zze = new HashMap(16, 1.0f);
                zzm = new Object();
                zzj = false;
                contentResolver.registerContentObserver(zza, true, new zzgz(null));
            } else if (zzl.getAndSet(false)) {
                zze.clear();
                zzf.clear();
                zzg.clear();
                zzh.clear();
                zzi.clear();
                zzm = new Object();
                zzj = false;
            }
            Object obj = zzm;
            if (zze.containsKey(str)) {
                String str4 = (String) zze.get(str);
                if (str4 != null) {
                    str3 = str4;
                }
                return str3;
            }
            int length = zzk.length;
            Cursor query = contentResolver.query(zza, null, null, new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (!query.moveToFirst()) {
                    zzc(obj, str, null);
                    return null;
                }
                String string = query.getString(1);
                if (string != null && string.equals(null)) {
                    string = null;
                }
                zzc(obj, str, string);
                if (string == null) {
                    return null;
                }
                return string;
            } finally {
                query.close();
            }
        }
    }

    private static void zzc(Object obj, String str, String str2) {
        synchronized (zzha.class) {
            if (obj == zzm) {
                zze.put(str, str2);
            }
        }
    }
}
