package com.google.android.gms.auth;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzf implements zzj<Void> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f19886a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ Bundle f19887b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzf(String str, Bundle bundle) {
        this.f19886a = str;
        this.f19887b = bundle;
    }

    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Void a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object d4;
        d4 = zzd.d(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(this.f19886a, this.f19887b));
        Bundle bundle = (Bundle) d4;
        String string = bundle.getString("Error");
        if (bundle.getBoolean("booleanResult")) {
            return null;
        }
        throw new GoogleAuthException(string);
    }
}
