package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzh implements zzj<Bundle> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ Account f19890a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzh(Account account) {
        this.f19890a = account;
    }

    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ Bundle a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object d4;
        d4 = zzd.d(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(this.f19890a));
        return (Bundle) d4;
    }
}
