package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.firebase.messaging.Constants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzact  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzact implements zzabd {
    private static final String zza = "com.google.android.gms.internal.firebase-auth-api.zzact";
    private String zzb;

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabd
    public final /* bridge */ /* synthetic */ zzabd zza(@NonNull String str) throws zzyt {
        zzb(str);
        return this;
    }

    public final zzact zzb(@NonNull String str) throws zzyt {
        try {
            JSONObject jSONObject = new JSONObject(new JSONObject(str).getString(Constants.IPC_BUNDLE_KEY_SEND_ERROR));
            jSONObject.getInt("code");
            this.zzb = jSONObject.getString("message");
            return this;
        } catch (NullPointerException | JSONException e4) {
            String str2 = zza;
            String message = e4.getMessage();
            Log.e(str2, "Failed to parse error for string [" + str + "] with exception: " + message);
            throw new zzyt("Failed to parse error for string [" + str + "]", e4);
        }
    }

    public final String zzc() {
        return this.zzb;
    }

    public final boolean zzd() {
        if (!TextUtils.isEmpty(this.zzb)) {
            return true;
        }
        return false;
    }
}
