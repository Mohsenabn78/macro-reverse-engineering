package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@19.0.0 */
/* loaded from: classes4.dex */
final class zzk extends zzc {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ zzh f19871a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzk(zzh zzhVar) {
        this.f19871a = zzhVar;
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzc, com.google.android.gms.auth.api.signin.internal.zzr
    public final void zzc(GoogleSignInAccount googleSignInAccount, Status status) throws RemoteException {
        if (googleSignInAccount != null) {
            zzq.zzd(this.f19871a.f19868a).zzc(this.f19871a.f19869b, googleSignInAccount);
        }
        this.f19871a.setResult((zzh) new GoogleSignInResult(googleSignInAccount, status));
    }
}
