package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.io.IOException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
final class zzfmg {
    private static zzfmg zza;
    private final String zzb;
    private final SharedPreferences zzc;

    private zzfmg(Context context) {
        this.zzb = context.getPackageName();
        this.zzc = context.getSharedPreferences("paid_storage_sp", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static zzfmg zzb(Context context) {
        if (zza == null) {
            zza = new zzfmg(context);
        }
        return zza;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final long zza(String str, long j4) {
        return this.zzc.getLong(str, -1L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public final String zzc(String str, String str2) {
        return this.zzc.getString(str, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zzd(String str, Object obj) throws IOException {
        boolean commit;
        if (obj instanceof String) {
            commit = this.zzc.edit().putString(str, (String) obj).commit();
        } else if (obj instanceof Long) {
            commit = this.zzc.edit().putLong(str, ((Long) obj).longValue()).commit();
        } else if (obj instanceof Boolean) {
            commit = this.zzc.edit().putBoolean(str, ((Boolean) obj).booleanValue()).commit();
        } else {
            String str2 = "Unexpected object class " + String.valueOf(obj.getClass()) + " for app " + this.zzb;
            Log.e("PaidLifecycleSPHandler", str2);
            throw new IllegalArgumentException(str2);
        }
        if (commit) {
            return;
        }
        String str3 = "Failed to store " + str + " for app " + this.zzb;
        Log.e("PaidLifecycleSPHandler", str3);
        throw new IOException(str3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(String str) throws IOException {
        if (this.zzc.edit().remove(str).commit()) {
            return;
        }
        String str2 = "Failed to remove " + str + " for app " + this.zzb;
        Log.e("PaidLifecycleSPHandler", str2);
        throw new IOException(str2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzf(String str, boolean z3) {
        return this.zzc.getBoolean(str, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final boolean zzg(String str) {
        return this.zzc.contains(str);
    }
}
