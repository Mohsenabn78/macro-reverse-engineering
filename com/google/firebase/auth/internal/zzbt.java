package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.exifinterface.media.ExifInterface;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzadu;
import com.google.android.gms.internal.p002firebaseauthapi.zzwk;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public final class zzbt {

    /* renamed from: a  reason: collision with root package name */
    private final Context f29039a;

    /* renamed from: b  reason: collision with root package name */
    private final String f29040b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f29041c;

    /* renamed from: d  reason: collision with root package name */
    private final Logger f29042d;

    public zzbt(Context context, String str) {
        Preconditions.checkNotNull(context);
        String checkNotEmpty = Preconditions.checkNotEmpty(str);
        this.f29040b = checkNotEmpty;
        Context applicationContext = context.getApplicationContext();
        this.f29039a = applicationContext;
        this.f29041c = applicationContext.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", checkNotEmpty), 0);
        this.f29042d = new Logger("StorageHelpers", new String[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00c9 A[Catch: zzwk -> 0x0177, IllegalArgumentException -> 0x0179, ArrayIndexOutOfBoundsException -> 0x017b, JSONException -> 0x017d, TRY_ENTER, TryCatch #3 {JSONException -> 0x017d, blocks: (B:3:0x0007, B:6:0x0024, B:10:0x003a, B:12:0x0078, B:14:0x007f, B:15:0x0084, B:16:0x0085, B:18:0x0094, B:20:0x009d, B:21:0x00a0, B:23:0x00a9, B:30:0x00c9, B:31:0x00cc, B:33:0x00d2, B:35:0x00d8, B:36:0x00de, B:38:0x00e4, B:41:0x00ff, B:43:0x0107, B:58:0x015c, B:44:0x011e, B:45:0x0125, B:49:0x012c, B:53:0x0135, B:55:0x013d, B:57:0x0149, B:59:0x0163, B:60:0x016a, B:61:0x016b, B:62:0x0172, B:63:0x0173), top: B:76:0x0007 }] */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.firebase.auth.internal.zzx a(org.json.JSONObject r27) {
        /*
            Method dump skipped, instructions count: 390
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzbt.a(org.json.JSONObject):com.google.firebase.auth.internal.zzx");
    }

    @Nullable
    public final FirebaseUser zza() {
        String string = this.f29041c.getString("com.google.firebase.auth.FIREBASE_USER", null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return a(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Nullable
    public final zzadu zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.f29041c.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), null);
        if (string == null) {
            return null;
        }
        return zzadu.zzd(string);
    }

    public final void zzc(String str) {
        this.f29041c.edit().remove(str).apply();
    }

    public final void zzd(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        JSONObject jSONObject = new JSONObject();
        String str = null;
        if (zzx.class.isAssignableFrom(firebaseUser.getClass())) {
            zzx zzxVar = (zzx) firebaseUser;
            try {
                jSONObject.put("cachedTokenState", zzxVar.zzf());
                jSONObject.put("applicationName", zzxVar.zza().getName());
                jSONObject.put("type", "com.google.firebase.auth.internal.DefaultFirebaseUser");
                if (zzxVar.zzo() != null) {
                    JSONArray jSONArray = new JSONArray();
                    List zzo = zzxVar.zzo();
                    int size = zzo.size();
                    if (zzo.size() > 30) {
                        this.f29042d.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzo.size()));
                        size = 30;
                    }
                    boolean z3 = false;
                    for (int i4 = 0; i4 < size; i4++) {
                        zzt zztVar = (zzt) zzo.get(i4);
                        z3 |= zztVar.getProviderId().equals("firebase");
                        if (i4 == size - 1 && !z3) {
                            break;
                        }
                        jSONArray.put(zztVar.zzb());
                    }
                    if (!z3) {
                        for (int i5 = size - 1; i5 < zzo.size(); i5++) {
                            zzt zztVar2 = (zzt) zzo.get(i5);
                            if (zztVar2.getProviderId().equals("firebase")) {
                                jSONArray.put(zztVar2.zzb());
                            }
                        }
                        this.f29042d.w("Malformed user object! No Firebase Auth provider id found.", new Object[0]);
                    }
                    jSONObject.put("userInfos", jSONArray);
                }
                jSONObject.put(AuthUI.ANONYMOUS_PROVIDER, zzxVar.isAnonymous());
                jSONObject.put("version", ExifInterface.GPS_MEASUREMENT_2D);
                if (zzxVar.getMetadata() != null) {
                    jSONObject.put("userMetadata", ((zzz) zzxVar.getMetadata()).zza());
                }
                List<MultiFactorInfo> enrolledFactors = new zzac(zzxVar).getEnrolledFactors();
                if (!enrolledFactors.isEmpty()) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (int i6 = 0; i6 < enrolledFactors.size(); i6++) {
                        jSONArray2.put(enrolledFactors.get(i6).toJson());
                    }
                    jSONObject.put("userMultiFactorInfo", jSONArray2);
                }
                str = jSONObject.toString();
            } catch (Exception e4) {
                this.f29042d.wtf("Failed to turn object into JSON", e4, new Object[0]);
                throw new zzwk(e4);
            }
        }
        if (!TextUtils.isEmpty(str)) {
            this.f29041c.edit().putString("com.google.firebase.auth.FIREBASE_USER", str).apply();
        }
    }

    public final void zze(FirebaseUser firebaseUser, zzadu zzaduVar) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzaduVar);
        this.f29041c.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", firebaseUser.getUid()), zzaduVar.zzh()).apply();
    }
}
