package com.google.android.gms.internal.icing;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.search.SearchAuth;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzay extends BaseImplementation.ApiMethodImpl<Status, zzav> {
    private final String zza;
    private final String zzb;
    private final boolean zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzay(GoogleApiClient googleApiClient, String str) {
        super(SearchAuth.API, googleApiClient);
        this.zzc = Log.isLoggable("SearchAuth", 3);
        this.zzb = str;
        this.zza = googleApiClient.getContext().getPackageName();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        if (this.zzc) {
            String valueOf = String.valueOf(status.getStatusMessage());
            if (valueOf.length() != 0) {
                "ClearTokenImpl received failure: ".concat(valueOf);
            }
        }
        return status;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(zzav zzavVar) throws RemoteException {
        ((zzau) zzavVar.getService()).zze(new zzax(this), this.zza, this.zzb);
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl, com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((zzay) ((Result) obj));
    }
}
