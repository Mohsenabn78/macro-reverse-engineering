package com.google.android.gms.location.places;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.internal.zzaa;

/* loaded from: classes4.dex */
public class zzm extends zzaa {

    /* renamed from: f  reason: collision with root package name */
    private static final String f21171f = "zzm";

    /* renamed from: a  reason: collision with root package name */
    private final zzd f21172a;

    /* renamed from: b  reason: collision with root package name */
    private final zzc f21173b;

    /* renamed from: c  reason: collision with root package name */
    private final zzg f21174c;

    /* renamed from: d  reason: collision with root package name */
    private final zzf f21175d;

    /* renamed from: e  reason: collision with root package name */
    private final zze f21176e;

    /* loaded from: classes4.dex */
    public static abstract class zzb<R extends Result, A extends Api.Client> extends BaseImplementation.ApiMethodImpl<R, A> {
        public zzb(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class zzc<A extends Api.Client> extends zzb<AutocompletePredictionBuffer, A> {
        public zzc(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new AutocompletePredictionBuffer(DataHolder.empty(status.getStatusCode()));
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class zzd<A extends Api.Client> extends zzb<PlaceLikelihoodBuffer, A> {
        public zzd(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new PlaceLikelihoodBuffer(DataHolder.empty(status.getStatusCode()), 100);
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class zze<A extends Api.Client> extends zzb<PlaceBuffer, A> {
        public zze(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return new PlaceBuffer(DataHolder.empty(status.getStatusCode()));
        }
    }

    @Deprecated
    /* loaded from: classes4.dex */
    public static abstract class zzg<A extends Api.Client> extends zzb<com.google.android.gms.internal.places.zzh, A> {
    }

    public zzm(zzd zzdVar) {
        this.f21172a = zzdVar;
        this.f21173b = null;
        this.f21174c = null;
        this.f21175d = null;
        this.f21176e = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzx
    public final void zzb(DataHolder dataHolder) throws RemoteException {
        Preconditions.checkState(this.f21172a != null, "placeEstimator cannot be null");
        if (dataHolder == null) {
            String str = f21171f;
            if (Log.isLoggable(str, 6)) {
                Log.e(str, "onPlaceEstimated received null DataHolder", new Throwable());
            }
            this.f21172a.setFailedResult(Status.RESULT_INTERNAL_ERROR);
            return;
        }
        Bundle metadata = dataHolder.getMetadata();
        this.f21172a.setResult((zzd) new PlaceLikelihoodBuffer(dataHolder, metadata == null ? 100 : PlaceLikelihoodBuffer.zzb(metadata)));
    }

    @Override // com.google.android.gms.location.places.internal.zzx
    public final void zzc(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            String str = f21171f;
            if (Log.isLoggable(str, 6)) {
                Log.e(str, "onAutocompletePrediction received null DataHolder", new Throwable());
            }
            this.f21173b.setFailedResult(Status.RESULT_INTERNAL_ERROR);
            return;
        }
        this.f21173b.setResult((zzc) new AutocompletePredictionBuffer(dataHolder));
    }

    @Override // com.google.android.gms.location.places.internal.zzx
    public final void zzd(DataHolder dataHolder) throws RemoteException {
        if (dataHolder == null) {
            String str = f21171f;
            if (Log.isLoggable(str, 6)) {
                Log.e(str, "onPlaceUserDataFetched received null DataHolder", new Throwable());
            }
            Status status = Status.RESULT_SUCCESS_CACHE;
            throw null;
        }
        new com.google.android.gms.internal.places.zzh(dataHolder);
        throw null;
    }

    @Override // com.google.android.gms.location.places.internal.zzx
    public final void zze(DataHolder dataHolder) throws RemoteException {
        this.f21176e.setResult((zze) new PlaceBuffer(dataHolder));
    }

    public zzm(zzc zzcVar) {
        this.f21172a = null;
        this.f21173b = zzcVar;
        this.f21174c = null;
        this.f21175d = null;
        this.f21176e = null;
    }

    @Override // com.google.android.gms.location.places.internal.zzx
    public final void zzb(Status status) throws RemoteException {
        this.f21175d.setResult((zzf) status);
    }

    public zzm(zzf zzfVar) {
        this.f21172a = null;
        this.f21173b = null;
        this.f21174c = null;
        this.f21175d = zzfVar;
        this.f21176e = null;
    }

    public zzm(zze zzeVar) {
        this.f21172a = null;
        this.f21173b = null;
        this.f21174c = null;
        this.f21175d = null;
        this.f21176e = zzeVar;
    }

    /* loaded from: classes4.dex */
    public static abstract class zzf<A extends Api.Client> extends zzb<Status, A> {
        public zzf(Api api, GoogleApiClient googleApiClient) {
            super(api, googleApiClient);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.gms.common.api.internal.BasePendingResult
        public /* synthetic */ Result createFailedResult(Status status) {
            return status;
        }
    }
}
