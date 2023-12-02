package com.google.android.gms.internal.consent_sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.Set;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzca {
    @Nullable
    public static zzby zza(Context context, String str) {
        String str2;
        String str3;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(RemoteSettings.FORWARD_SLASH_STRING, -1);
        int length = split.length;
        if (length == 1) {
            str2 = String.valueOf(context.getPackageName()).concat("_preferences");
            str3 = split[0];
        } else {
            if (length == 2) {
                str2 = split[0];
                str3 = split[1];
            }
            return null;
        }
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            return new zzby(str2, str3);
        }
        return null;
    }

    public static void zzb(Context context, Set<String> set) {
        SharedPreferences.Editor zzd;
        zzbz zzbzVar = new zzbz(context);
        for (String str : set) {
            zzby zza = zza(context, str);
            if (zza != null) {
                zzd = zzbzVar.zzd(zza.zza);
                zzd.remove(zza.zzb);
            } else {
                String valueOf = String.valueOf(str);
                if (valueOf.length() != 0) {
                    "clearKeys: unable to process key: ".concat(valueOf);
                }
            }
        }
        zzbzVar.zzb();
    }
}
