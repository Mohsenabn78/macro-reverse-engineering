package com.google.android.gms.auth;

import android.os.IBinder;
import android.os.RemoteException;
import java.io.IOException;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzg implements zzj<List<AccountChangeEvent>> {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ String f19888a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f19889b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzg(String str, int i4) {
        this.f19888a = str;
        this.f19889b = i4;
    }

    @Override // com.google.android.gms.auth.zzj
    public final /* synthetic */ List<AccountChangeEvent> a(IBinder iBinder) throws RemoteException, IOException, GoogleAuthException {
        Object d4;
        d4 = zzd.d(com.google.android.gms.internal.auth.zzf.zza(iBinder).zza(new AccountChangeEventsRequest().setAccountName(this.f19888a).setEventIndex(this.f19889b)));
        return ((AccountChangeEventsResponse) d4).getEvents();
    }
}
