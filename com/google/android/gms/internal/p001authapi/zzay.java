package com.google.android.gms.internal.p001authapi;

import com.google.android.gms.common.Feature;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* renamed from: com.google.android.gms.internal.auth-api.zzay  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzay {
    public static final Feature zzdc;
    public static final Feature zzdd;
    private static final Feature zzde;
    private static final Feature zzdf;
    public static final Feature zzdg;
    public static final Feature zzdh;
    private static final Feature zzdi;
    public static final Feature[] zzdj;

    static {
        Feature feature = new Feature("auth_api_credentials_begin_sign_in", 4L);
        zzdc = feature;
        Feature feature2 = new Feature("auth_api_credentials_sign_out", 2L);
        zzdd = feature2;
        Feature feature3 = new Feature("auth_api_credentials_authorize", 1L);
        zzde = feature3;
        Feature feature4 = new Feature("auth_api_credentials_revoke_access", 1L);
        zzdf = feature4;
        Feature feature5 = new Feature("auth_api_credentials_save_password", 3L);
        zzdg = feature5;
        Feature feature6 = new Feature("auth_api_credentials_get_sign_in_intent", 3L);
        zzdh = feature6;
        Feature feature7 = new Feature("auth_api_credentials_save_account_linking_token", 2L);
        zzdi = feature7;
        zzdj = new Feature[]{feature, feature2, feature3, feature4, feature5, feature6, feature7};
    }
}
