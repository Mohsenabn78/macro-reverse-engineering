package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.internal.icing.zzak;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
final class zzq extends zzs {

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ zzc[] f28837e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzq(zzt zztVar, zzc[] zzcVarArr) {
        this.f28837e = zzcVarArr;
    }

    @Override // com.google.firebase.appindexing.internal.zzs
    protected final void b(com.google.android.gms.internal.icing.zzaa zzaaVar) throws RemoteException {
        zzaaVar.zze(new zzak(this), this.f28837e);
    }
}
