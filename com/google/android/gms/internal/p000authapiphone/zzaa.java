package com.google.android.gms.internal.p000authapiphone;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-auth-api-phone@@17.4.0 */
/* renamed from: com.google.android.gms.internal.auth-api-phone.zzaa  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaa {
    public static final Feature zza;
    public static final Feature zzb;
    public static final Feature zzc;
    public static final Feature[] zzd;

    static {
        Feature feature = new Feature("sms_code_autofill", 2L);
        zza = feature;
        Feature feature2 = new Feature("sms_retrieve", 1L);
        zzb = feature2;
        Feature feature3 = new Feature("user_consent", 3L);
        zzc = feature3;
        zzd = new Feature[]{feature, feature2, feature3};
    }
}
