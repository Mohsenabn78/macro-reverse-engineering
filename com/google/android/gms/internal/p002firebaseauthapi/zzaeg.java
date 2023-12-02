package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaeg  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaeg implements zzabc {
    private String zza;
    private String zzb;
    private String zzc;
    private String zzd;
    private String zze;
    private String zzf;
    private final zzaes zzg = new zzaes(null);
    private final zzaes zzh = new zzaes(null);
    @Nullable
    private String zzi;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabc
    public final String zza() throws JSONException {
        char c4;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("returnSecureToken", true);
        if (!this.zzh.zza().isEmpty()) {
            List zza = this.zzh.zza();
            JSONArray jSONArray = new JSONArray();
            for (int i4 = 0; i4 < zza.size(); i4++) {
                jSONArray.put(zza.get(i4));
            }
            jSONObject.put("deleteProvider", jSONArray);
        }
        List zza2 = this.zzg.zza();
        int size = zza2.size();
        int[] iArr = new int[size];
        for (int i5 = 0; i5 < zza2.size(); i5++) {
            String str = (String) zza2.get(i5);
            int i6 = 2;
            switch (str.hashCode()) {
                case -333046776:
                    if (str.equals("DISPLAY_NAME")) {
                        c4 = 1;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 66081660:
                    if (str.equals("EMAIL")) {
                        c4 = 0;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1939891618:
                    if (str.equals("PHOTO_URL")) {
                        c4 = 3;
                        break;
                    }
                    c4 = 65535;
                    break;
                case 1999612571:
                    if (str.equals("PASSWORD")) {
                        c4 = 2;
                        break;
                    }
                    c4 = 65535;
                    break;
                default:
                    c4 = 65535;
                    break;
            }
            if (c4 != 0) {
                if (c4 != 1) {
                    if (c4 != 2) {
                        if (c4 != 3) {
                            i6 = 0;
                        } else {
                            i6 = 4;
                        }
                    } else {
                        i6 = 5;
                    }
                }
            } else {
                i6 = 1;
            }
            iArr[i5] = i6;
        }
        if (size > 0) {
            JSONArray jSONArray2 = new JSONArray();
            for (int i7 = 0; i7 < size; i7++) {
                jSONArray2.put(iArr[i7]);
            }
            jSONObject.put("deleteAttribute", jSONArray2);
        }
        String str2 = this.zza;
        if (str2 != null) {
            jSONObject.put("idToken", str2);
        }
        String str3 = this.zzc;
        if (str3 != null) {
            jSONObject.put("email", str3);
        }
        String str4 = this.zzd;
        if (str4 != null) {
            jSONObject.put("password", str4);
        }
        String str5 = this.zzb;
        if (str5 != null) {
            jSONObject.put("displayName", str5);
        }
        String str6 = this.zzf;
        if (str6 != null) {
            jSONObject.put("photoUrl", str6);
        }
        String str7 = this.zze;
        if (str7 != null) {
            jSONObject.put("oobCode", str7);
        }
        String str8 = this.zzi;
        if (str8 != null) {
            jSONObject.put("tenantId", str8);
        }
        return jSONObject.toString();
    }

    @NonNull
    public final zzaeg zzb(String str) {
        Preconditions.checkNotEmpty(str);
        this.zzh.zza().add(str);
        return this;
    }

    @NonNull
    public final zzaeg zzc(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("DISPLAY_NAME");
        } else {
            this.zzb = str;
        }
        return this;
    }

    @NonNull
    public final zzaeg zzd(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("EMAIL");
        } else {
            this.zzc = str;
        }
        return this;
    }

    @NonNull
    public final zzaeg zze(String str) {
        this.zza = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzaeg zzf(String str) {
        this.zze = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzaeg zzg(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("PASSWORD");
        } else {
            this.zzd = str;
        }
        return this;
    }

    @NonNull
    public final zzaeg zzh(@Nullable String str) {
        if (str == null) {
            this.zzg.zza().add("PHOTO_URL");
        } else {
            this.zzf = str;
        }
        return this;
    }

    @NonNull
    public final zzaeg zzi(@Nullable String str) {
        this.zzi = str;
        return this;
    }

    @Nullable
    public final String zzj() {
        return this.zzb;
    }

    @Nullable
    public final String zzk() {
        return this.zzc;
    }

    @Nullable
    public final String zzl() {
        return this.zzd;
    }

    @Nullable
    public final String zzm() {
        return this.zzf;
    }

    public final boolean zzn(String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzg.zza().contains(str);
    }
}
