package com.google.firebase.auth;

import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.HashMap;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* loaded from: classes5.dex */
public class ActionCodeUrl {

    /* renamed from: g  reason: collision with root package name */
    private static final com.google.android.gms.internal.p002firebaseauthapi.zzap f28858g;

    /* renamed from: a  reason: collision with root package name */
    private final String f28859a;

    /* renamed from: b  reason: collision with root package name */
    private final String f28860b;

    /* renamed from: c  reason: collision with root package name */
    private final String f28861c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final String f28862d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final String f28863e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final String f28864f;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("recoverEmail", 2);
        hashMap.put("resetPassword", 0);
        hashMap.put("signIn", 4);
        hashMap.put("verifyEmail", 1);
        hashMap.put("verifyBeforeChangeEmail", 5);
        hashMap.put("revertSecondFactorAddition", 6);
        f28858g = com.google.android.gms.internal.p002firebaseauthapi.zzap.zzc(hashMap.entrySet());
    }

    private ActionCodeUrl(String str) {
        String a4 = a(str, "apiKey");
        String a5 = a(str, "oobCode");
        String a6 = a(str, "mode");
        if (a4 != null && a5 != null && a6 != null) {
            this.f28859a = Preconditions.checkNotEmpty(a4);
            this.f28860b = Preconditions.checkNotEmpty(a5);
            this.f28861c = Preconditions.checkNotEmpty(a6);
            this.f28862d = a(str, "continueUrl");
            this.f28863e = a(str, RemoteConfigConstants.RequestFieldKey.LANGUAGE_CODE);
            this.f28864f = a(str, "tenantId");
            return;
        }
        throw new IllegalArgumentException(String.format("%s, %s and %s are required in a valid action code URL", "apiKey", "oobCode", "mode"));
    }

    @Nullable
    private static String a(String str, String str2) {
        Uri parse = Uri.parse(str);
        try {
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            if (queryParameterNames.contains(str2)) {
                return parse.getQueryParameter(str2);
            }
            if (queryParameterNames.contains("link")) {
                return Uri.parse(Preconditions.checkNotEmpty(parse.getQueryParameter("link"))).getQueryParameter(str2);
            }
            return null;
        } catch (NullPointerException | UnsupportedOperationException unused) {
            return null;
        }
    }

    @Nullable
    public static ActionCodeUrl parseLink(@Nullable String str) {
        Preconditions.checkNotEmpty(str);
        try {
            return new ActionCodeUrl(str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    @NonNull
    public String getApiKey() {
        return this.f28859a;
    }

    @Nullable
    public String getCode() {
        return this.f28860b;
    }

    @Nullable
    public String getContinueUrl() {
        return this.f28862d;
    }

    @Nullable
    public String getLanguageCode() {
        return this.f28863e;
    }

    public int getOperation() {
        com.google.android.gms.internal.p002firebaseauthapi.zzap zzapVar = f28858g;
        if (zzapVar.containsKey(this.f28861c)) {
            return ((Integer) zzapVar.get(this.f28861c)).intValue();
        }
        return 3;
    }

    @Nullable
    public final String zza() {
        return this.f28864f;
    }
}
