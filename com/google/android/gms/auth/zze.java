package com.google.android.gms.auth;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzay;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zze implements zzj<TokenData> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Account f19883a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ String f19884b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f19885c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zze(Account account, String str, Bundle bundle) {
        this.f19883a = account;
        this.f19884b = str;
        this.f19885c = bundle;
    }

    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ TokenData a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object d4;
        Logger logger;
        d4 = zzd.d(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(this.f19883a, this.f19884b, this.f19885c));
        Bundle bundle = (Bundle) d4;
        TokenData zza = TokenData.zza(bundle, "tokenDetails");
        if (zza != null) {
            return zza;
        }
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        boolean z3 = false;
        if (zzay.zza(zzc)) {
            logger = zzd.f19882c;
            String valueOf = String.valueOf(zzc);
            StringBuilder sb = new StringBuilder(valueOf.length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(valueOf);
            logger.w("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        }
        if ((zzay.NETWORK_ERROR.equals(zzc) || zzay.SERVICE_UNAVAILABLE.equals(zzc) || zzay.INTNERNAL_ERROR.equals(zzc)) ? true : true) {
            throw new IOException(string);
        }
        throw new GoogleAuthException(string);
    }
}
