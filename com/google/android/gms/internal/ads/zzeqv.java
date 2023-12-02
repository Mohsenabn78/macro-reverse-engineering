package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.google.mlkit.nl.translate.TranslateLanguage;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzeqv implements zzeqy {
    private final zzfwn zza;
    private final Context zzb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzeqv(zzfwn zzfwnVar, Context context) {
        this.zza = zzfwnVar;
        this.zzb = context;
    }

    public static Bundle zzc(Context context, JSONArray jSONArray) {
        int i4;
        SharedPreferences sharedPreferences;
        String str;
        Bundle bundle = new Bundle();
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i5);
            String optString = optJSONObject.optString("bk");
            String optString2 = optJSONObject.optString(TranslateLanguage.SLOVAK);
            int optInt = optJSONObject.optInt("type", -1);
            if (optInt != 0) {
                if (optInt != 1) {
                    if (optInt != 2) {
                        i4 = 0;
                    } else {
                        i4 = 3;
                    }
                } else {
                    i4 = 2;
                }
            } else {
                i4 = 1;
            }
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2) && i4 != 0) {
                String[] split = optString2.split(RemoteSettings.FORWARD_SLASH_STRING);
                int length = split.length;
                Object obj = null;
                if (length <= 2 && length != 0) {
                    if (length == 1) {
                        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                        str = split[0];
                    } else {
                        sharedPreferences = context.getSharedPreferences(split[0], 0);
                        str = split[1];
                    }
                    obj = sharedPreferences.getAll().get(str);
                }
                if (obj != null) {
                    int i6 = i4 - 1;
                    if (i6 != 0) {
                        if (i6 != 1) {
                            if (obj instanceof Boolean) {
                                bundle.putBoolean(optString, ((Boolean) obj).booleanValue());
                            }
                        } else if (obj instanceof Integer) {
                            bundle.putInt(optString, ((Integer) obj).intValue());
                        } else if (obj instanceof Long) {
                            bundle.putLong(optString, ((Long) obj).longValue());
                        } else if (obj instanceof Float) {
                            bundle.putFloat(optString, ((Float) obj).floatValue());
                        }
                    } else if (obj instanceof String) {
                        bundle.putString(optString, (String) obj);
                    }
                }
            }
        }
        return bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final int zza() {
        return 37;
    }

    @Override // com.google.android.gms.internal.ads.zzeqy
    public final zzfwm zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzeqt
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzeqv.this.zzd();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ zzeqx zzd() throws Exception {
        String str = (String) com.google.android.gms.ads.internal.client.zzba.zzc().zzb(zzbbm.zzfS);
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Bundle zzc = zzc(this.zzb, new JSONArray(str));
            return new zzeqx() { // from class: com.google.android.gms.internal.ads.zzequ
                @Override // com.google.android.gms.internal.ads.zzeqx
                public final void zzh(Object obj) {
                    ((Bundle) obj).putBundle("shared_pref", zzc);
                }
            };
        } catch (JSONException e4) {
            zzbzr.zzf("JSON parsing error", e4);
            return null;
        }
    }
}
