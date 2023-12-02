package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
final class zzm extends zzc {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzj f19872a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzm(zzj zzjVar) {
        this.f19872a = zzjVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzr
    public final void zze(Status status) throws RemoteException {
        this.f19872a.setResult((zzj) status);
    }
}
