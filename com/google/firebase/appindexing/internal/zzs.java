package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.PlacesStatusCodes;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes5.dex */
public abstract class zzs extends TaskApiCall<com.google.android.gms.internal.icing.zzae, Void> implements BaseImplementation.ResultHolder<Status> {

    /* renamed from: d  reason: collision with root package name */
    protected TaskCompletionSource<Void> f28838d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzs() {
        super(null, false, PlacesStatusCodes.INVALID_ARGUMENT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    public final /* bridge */ /* synthetic */ void a(com.google.android.gms.internal.icing.zzae zzaeVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        this.f28838d = taskCompletionSource;
        b((com.google.android.gms.internal.icing.zzaa) zzaeVar.getService());
    }

    protected abstract void b(com.google.android.gms.internal.icing.zzaa zzaaVar) throws RemoteException;

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final void setFailedResult(Status status) {
        Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success.");
        String statusMessage = status.getStatusMessage();
        if (statusMessage == null) {
            statusMessage = "";
        }
        this.f28838d.setException(zzaf.zza(status, statusMessage));
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ResultHolder
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        if (status.isSuccess()) {
            this.f28838d.setResult(null);
        } else {
            this.f28838d.setException(zzaf.zza(status, "User Action indexing error, please try again."));
        }
    }
}
