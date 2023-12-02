package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.util.DefaultClock;
import com.google.firebase.auth.PhoneAuthProvider;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzacg  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzacg {
    private static final Map zza = new ArrayMap();

    public static PhoneAuthProvider.OnVerificationStateChangedCallbacks zza(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable zzabs zzabsVar) {
        zze(str, zzabsVar);
        return new zzace(onVerificationStateChangedCallbacks, str);
    }

    public static void zzc() {
        zza.clear();
    }

    public static boolean zzd(String str, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor) {
        Map map = zza;
        if (map.containsKey(str)) {
            zzacf zzacfVar = (zzacf) map.get(str);
            if (DefaultClock.getInstance().currentTimeMillis() - zzacfVar.zzb < 120000) {
                zzabs zzabsVar = zzacfVar.zza;
                if (zzabsVar != null) {
                    zzabsVar.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
                    return true;
                }
                return true;
            }
            zze(str, null);
            return false;
        }
        zze(str, null);
        return false;
    }

    private static void zze(String str, @Nullable zzabs zzabsVar) {
        zza.put(str, new zzacf(zzabsVar, DefaultClock.getInstance().currentTimeMillis()));
    }
}
