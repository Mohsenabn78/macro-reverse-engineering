package com.google.android.gms.ads.internal.client;

import android.os.Bundle;
import android.text.TextUtils;
import com.arlosoft.macrodroid.helper.HelperCommandsKt;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzem {

    /* renamed from: a  reason: collision with root package name */
    private final String f19180a;

    /* renamed from: b  reason: collision with root package name */
    private final Bundle f19181b;

    /* renamed from: c  reason: collision with root package name */
    private final String f19182c;

    public zzem(String str, Bundle bundle, String str2) {
        this.f19180a = str;
        this.f19181b = bundle;
        this.f19182c = str2;
    }

    public final Bundle zza() {
        return this.f19181b;
    }

    public final String zzb() {
        return this.f19180a;
    }

    public final String zzc() {
        if (TextUtils.isEmpty(this.f19182c)) {
            return "";
        }
        try {
            return new JSONObject(this.f19182c).optString(HelperCommandsKt.HELPER_COMMAND_REQUEST_ID, "");
        } catch (JSONException unused) {
            return "";
        }
    }
}
