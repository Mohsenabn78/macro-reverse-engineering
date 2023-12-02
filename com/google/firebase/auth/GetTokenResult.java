package com.google.firebase.auth;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-auth-interop@@20.0.0 */
/* loaded from: classes5.dex */
public class GetTokenResult {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f28895a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, Object> f28896b;

    @KeepForSdk
    public GetTokenResult(@Nullable String str, @NonNull Map<String, Object> map) {
        this.f28895a = str;
        this.f28896b = map;
    }

    private final long a(String str) {
        Integer num = (Integer) this.f28896b.get(str);
        if (num == null) {
            return 0L;
        }
        return num.longValue();
    }

    public long getAuthTimestamp() {
        return a("auth_time");
    }

    @NonNull
    public Map<String, Object> getClaims() {
        return this.f28896b;
    }

    public long getExpirationTimestamp() {
        return a("exp");
    }

    public long getIssuedAtTimestamp() {
        return a("iat");
    }

    @Nullable
    public String getSignInProvider() {
        Map map = (Map) this.f28896b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_provider");
        }
        return null;
    }

    @Nullable
    @KeepForSdk
    public String getSignInSecondFactor() {
        Map map = (Map) this.f28896b.get("firebase");
        if (map != null) {
            return (String) map.get("sign_in_second_factor");
        }
        return null;
    }

    @Nullable
    public String getToken() {
        return this.f28895a;
    }
}
