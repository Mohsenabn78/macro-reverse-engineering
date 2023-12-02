package com.google.android.gms.auth.api.accounttransfer;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;

/* loaded from: classes4.dex */
public final class AccountTransfer {
    public static final String ACTION_ACCOUNT_EXPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_EXPORT_DATA_AVAILABLE";
    public static final String ACTION_ACCOUNT_IMPORT_DATA_AVAILABLE = "com.google.android.gms.auth.ACCOUNT_IMPORT_DATA_AVAILABLE";
    public static final String ACTION_START_ACCOUNT_EXPORT = "com.google.android.gms.auth.START_ACCOUNT_EXPORT";
    public static final String KEY_EXTRA_ACCOUNT_TYPE = "key_extra_account_type";

    /* renamed from: a  reason: collision with root package name */
    private static final Api.ClientKey<com.google.android.gms.internal.auth.zzu> f19634a;

    /* renamed from: b  reason: collision with root package name */
    private static final Api.AbstractClientBuilder<com.google.android.gms.internal.auth.zzu, zzn> f19635b;

    /* renamed from: c  reason: collision with root package name */
    private static final Api<zzn> f19636c;
    @Deprecated

    /* renamed from: d  reason: collision with root package name */
    private static final zzb f19637d;

    /* renamed from: e  reason: collision with root package name */
    private static final zzq f19638e;

    /* JADX WARN: Type inference failed for: r0v1, types: [com.google.android.gms.internal.auth.zzt, com.google.android.gms.auth.api.accounttransfer.zzb] */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.google.android.gms.internal.auth.zzt, com.google.android.gms.auth.api.accounttransfer.zzq] */
    static {
        Api.ClientKey<com.google.android.gms.internal.auth.zzu> clientKey = new Api.ClientKey<>();
        f19634a = clientKey;
        zza zzaVar = new zza();
        f19635b = zzaVar;
        f19636c = new Api<>("AccountTransfer.ACCOUNT_TRANSFER_API", zzaVar, clientKey);
        f19637d = new com.google.android.gms.internal.auth.zzt();
        f19638e = new com.google.android.gms.internal.auth.zzt();
    }

    private AccountTransfer() {
    }

    public static AccountTransferClient getAccountTransferClient(@NonNull Activity activity) {
        return new AccountTransferClient(activity);
    }

    public static AccountTransferClient getAccountTransferClient(@NonNull Context context) {
        return new AccountTransferClient(context);
    }
}
