package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.firebase.FirebaseApp;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacq  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzacq {
    private static final Map zza = new ArrayMap();
    private static final Map zzb = new ArrayMap();

    @NonNull
    public static String zza(String str) {
        zzaco zzacoVar;
        Map map = zza;
        synchronized (map) {
            zzacoVar = (zzaco) map.get(str);
        }
        if (zzacoVar != null) {
            return zzh(zzacoVar.zzb(), zzacoVar.zza(), zzacoVar.zzb().contains(":")).concat("emulator/auth/handler");
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    @NonNull
    public static String zzb(String str) {
        zzaco zzacoVar;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzacoVar = (zzaco) map.get(str);
        }
        if (zzacoVar != null) {
            str2 = "".concat(zzh(zzacoVar.zzb(), zzacoVar.zza(), zzacoVar.zzb().contains(":")));
        } else {
            str2 = "https://";
        }
        return str2.concat("www.googleapis.com/identitytoolkit/v3/relyingparty");
    }

    @NonNull
    public static String zzc(String str) {
        zzaco zzacoVar;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzacoVar = (zzaco) map.get(str);
        }
        if (zzacoVar != null) {
            str2 = "".concat(zzh(zzacoVar.zzb(), zzacoVar.zza(), zzacoVar.zzb().contains(":")));
        } else {
            str2 = "https://";
        }
        return str2.concat("identitytoolkit.googleapis.com/v2");
    }

    @NonNull
    public static String zzd(String str) {
        zzaco zzacoVar;
        String str2;
        Map map = zza;
        synchronized (map) {
            zzacoVar = (zzaco) map.get(str);
        }
        if (zzacoVar != null) {
            str2 = "".concat(zzh(zzacoVar.zzb(), zzacoVar.zza(), zzacoVar.zzb().contains(":")));
        } else {
            str2 = "https://";
        }
        return str2.concat("securetoken.googleapis.com/v1");
    }

    public static void zze(String str, zzacp zzacpVar) {
        Map map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                ((List) map.get(str)).add(new WeakReference(zzacpVar));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzacpVar));
                map.put(str, arrayList);
            }
        }
    }

    public static void zzf(@NonNull FirebaseApp firebaseApp, @NonNull String str, int i4) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map map = zza;
        synchronized (map) {
            map.put(apiKey, new zzaco(str, i4));
        }
        Map map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                boolean z3 = false;
                for (WeakReference weakReference : (List) map2.get(apiKey)) {
                    zzacp zzacpVar = (zzacp) weakReference.get();
                    if (zzacpVar != null) {
                        zzacpVar.zzk();
                        z3 = true;
                    }
                }
                if (!z3) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zzg(@NonNull FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }

    private static String zzh(String str, int i4, boolean z3) {
        if (z3) {
            return "http://[" + str + "]:" + i4 + RemoteSettings.FORWARD_SLASH_STRING;
        }
        return "http://" + str + ":" + i4 + RemoteSettings.FORWARD_SLASH_STRING;
    }
}
