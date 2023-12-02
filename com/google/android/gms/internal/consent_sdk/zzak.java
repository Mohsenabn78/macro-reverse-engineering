package com.google.android.gms.internal.consent_sdk;

import android.app.Application;
import android.text.TextUtils;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzak implements zzg {
    private final Application zza;
    private final zzam zzb;
    private final Executor zzc;

    public zzak(Application application, zzam zzamVar, Executor executor) {
        this.zza = application;
        this.zzb = zzamVar;
        this.zzc = executor;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzg
    public final Executor zza() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzg
    public final boolean zzb(String str, JSONObject jSONObject) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode != 94746189) {
            if (hashCode == 113399775 && str.equals("write")) {
                c4 = 0;
            }
            c4 = 65535;
        } else {
            if (str.equals("clear")) {
                c4 = 1;
            }
            c4 = 65535;
        }
        if (c4 != 0) {
            if (c4 != 1) {
                return false;
            }
            JSONArray optJSONArray = jSONObject.optJSONArray(UserMetadata.KEYDATA_FILENAME);
            if (optJSONArray != null && optJSONArray.length() != 0) {
                HashSet hashSet = new HashSet();
                int length = optJSONArray.length();
                for (int i4 = 0; i4 < length; i4++) {
                    String optString = optJSONArray.optString(i4);
                    if (TextUtils.isEmpty(optString)) {
                        StringBuilder sb = new StringBuilder(46);
                        sb.append("Action[clear]: empty key at index: ");
                        sb.append(i4);
                    } else {
                        hashSet.add(optString);
                    }
                }
                zzca.zzb(this.zza, hashSet);
            } else {
                String valueOf = String.valueOf(jSONObject.toString());
                if (valueOf.length() != 0) {
                    "Action[clear]: wrong args.".concat(valueOf);
                }
            }
            return true;
        }
        zzbz zzbzVar = new zzbz(this.zza);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object opt = jSONObject.opt(next);
            String valueOf2 = String.valueOf(opt);
            StringBuilder sb2 = new StringBuilder(String.valueOf(next).length() + 23 + valueOf2.length());
            sb2.append("Writing to storage: [");
            sb2.append(next);
            sb2.append("] ");
            sb2.append(valueOf2);
            if (zzbzVar.zzc(next, opt)) {
                this.zzb.zzc().add(next);
            } else {
                String valueOf3 = String.valueOf(next);
                if (valueOf3.length() != 0) {
                    "Failed writing key: ".concat(valueOf3);
                }
            }
        }
        this.zzb.zze();
        zzbzVar.zzb();
        return true;
    }
}
