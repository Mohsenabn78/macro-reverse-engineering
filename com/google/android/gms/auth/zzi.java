package com.google.android.gms.auth;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.auth.zzay;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzi implements zzj<Boolean> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f19891a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzi(String str) {
        this.f19891a = str;
    }

    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Boolean a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object d4;
        Logger logger;
        d4 = zzd.d(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(this.f19891a));
        Bundle bundle = (Bundle) d4;
        String string = bundle.getString("Error");
        Intent intent = (Intent) bundle.getParcelable("userRecoveryIntent");
        zzay zzc = zzay.zzc(string);
        if (zzay.SUCCESS.equals(zzc)) {
            return Boolean.TRUE;
        }
        if (zzay.zza(zzc)) {
            logger = zzd.f19882c;
            String valueOf = String.valueOf(zzc);
            StringBuilder sb = new StringBuilder(valueOf.length() + 31);
            sb.append("isUserRecoverableError status: ");
            sb.append(valueOf);
            logger.w("GoogleAuthUtil", sb.toString());
            throw new UserRecoverableAuthException(string, intent);
        }
        throw new GoogleAuthException(string);
    }
}
