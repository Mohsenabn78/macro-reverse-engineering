package com.firebase.ui.auth.util.data;

import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.gms.common.internal.Preconditions;
import java.util.HashMap;
import java.util.Map;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes3.dex */
public class EmailLinkParser {

    /* renamed from: b  reason: collision with root package name */
    private static String f18212b = "link";

    /* renamed from: a  reason: collision with root package name */
    private Map<String, String> f18213a;

    /* loaded from: classes3.dex */
    public static class LinkParameters {
        public static final String ANONYMOUS_USER_ID_IDENTIFIER = "ui_auid";
        public static final String FORCE_SAME_DEVICE_IDENTIFIER = "ui_sd";
        public static final String PROVIDER_ID_IDENTIFIER = "ui_pid";
        public static final String SESSION_IDENTIFIER = "ui_sid";
    }

    public EmailLinkParser(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        Map<String, String> a4 = a(Uri.parse(str));
        this.f18213a = a4;
        if (!a4.isEmpty()) {
            return;
        }
        throw new IllegalArgumentException("Invalid link: no parameters found");
    }

    private Map<String, String> a(Uri uri) {
        HashMap hashMap = new HashMap();
        try {
            for (String str : uri.getQueryParameterNames()) {
                if (!str.equalsIgnoreCase(f18212b) && !str.equalsIgnoreCase("continueUrl")) {
                    String queryParameter = uri.getQueryParameter(str);
                    if (queryParameter != null) {
                        hashMap.put(str, queryParameter);
                    }
                }
                Map<String, String> a4 = a(Uri.parse(uri.getQueryParameter(str)));
                if (a4 != null) {
                    hashMap.putAll(a4);
                }
            }
        } catch (Exception unused) {
        }
        return hashMap;
    }

    public String getAnonymousUserId() {
        return this.f18213a.get(LinkParameters.ANONYMOUS_USER_ID_IDENTIFIER);
    }

    public boolean getForceSameDeviceBit() {
        String str = this.f18213a.get(LinkParameters.FORCE_SAME_DEVICE_IDENTIFIER);
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.equals("1");
    }

    public String getOobCode() {
        return this.f18213a.get("oobCode");
    }

    public String getProviderId() {
        return this.f18213a.get(LinkParameters.PROVIDER_ID_IDENTIFIER);
    }

    public String getSessionId() {
        return this.f18213a.get(LinkParameters.SESSION_IDENTIFIER);
    }
}
