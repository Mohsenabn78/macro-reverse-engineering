package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
final class zzo extends zzc {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzl f19873a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzo(zzl zzlVar) {
        this.f19873a = zzlVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzf(Status status) throws RemoteException {
        this.f19873a.setResult((zzl) status);
    }
}
