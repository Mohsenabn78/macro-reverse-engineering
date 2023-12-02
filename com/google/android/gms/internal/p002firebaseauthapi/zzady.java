package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzady  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzady {
    @Nullable
    private final String zza;
    @NonNull
    private final String zzb;
    private final String zzc;
    private final long zzd;
    @Nullable
    private final zzaet zze;
    @Nullable
    private String zzf;

    public zzady(String str, String str2, String str3, long j4, zzaet zzaetVar) {
        if (!TextUtils.isEmpty(str) && zzaetVar != null) {
            Log.e("MfaInfo", "Cannot have both MFA phone_info and totp_info");
            throw new IllegalArgumentException("Cannot have both MFA phone_info and totp_info");
        }
        this.zza = str;
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
        this.zzd = j4;
        this.zze = zzaetVar;
    }

    public static zzady zzb(@NonNull JSONObject jSONObject) {
        zzaet zzaetVar;
        String optString = jSONObject.optString("phoneInfo", null);
        String optString2 = jSONObject.optString("mfaEnrollmentId", null);
        String optString3 = jSONObject.optString("displayName", null);
        long zzh = zzh(jSONObject.optString("enrolledAt", ""));
        if (jSONObject.opt("totpInfo") != null) {
            zzaetVar = new zzaet();
        } else {
            zzaetVar = null;
        }
        zzady zzadyVar = new zzady(optString, optString2, optString3, zzh, zzaetVar);
        zzadyVar.zzf = jSONObject.optString("unobfuscatedPhoneInfo");
        return zzadyVar;
    }

    public static List zzg(JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() != 0) {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < jSONArray.length(); i4++) {
                arrayList.add(zzb(jSONArray.getJSONObject(i4)));
            }
            return arrayList;
        }
        return new ArrayList();
    }

    private static long zzh(String str) {
        try {
            zzajm zzb = zzakh.zzb(str);
            zzakh.zza(zzb);
            return zzb.zzb();
        } catch (ParseException e4) {
            Log.w("MfaInfo", "Could not parse timestamp as ISOString. Invalid ISOString \"" + str + "\"", e4);
            return 0L;
        }
    }

    public final long zza() {
        return this.zzd;
    }

    @Nullable
    public final zzaet zzc() {
        return this.zze;
    }

    public final String zzd() {
        return this.zzc;
    }

    public final String zze() {
        return this.zzb;
    }

    @Nullable
    public final String zzf() {
        return this.zza;
    }
}
