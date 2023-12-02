package com.google.android.gms.internal.icing;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
abstract class zzai<T extends Result> extends BaseImplementation.ApiMethodImpl<T, zzae> {
    public zzai(GoogleApiClient googleApiClient) {
        super(zze.zzb, googleApiClient);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(zzae zzaeVar) throws RemoteException {
        zza((zzaa) zzaeVar.getService());
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzai<T>) ((Result) obj));
    }

    protected abstract void zza(zzaa zzaaVar) throws RemoteException;
}
