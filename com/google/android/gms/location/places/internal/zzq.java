package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AddPlaceRequest;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.PlacesOptions;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzq extends GmsClient<zzt> {

    /* renamed from: a  reason: collision with root package name */
    private final zzau f21149a;

    private zzq(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 65, clientSettings, connectionCallbacks, onConnectionFailedListener);
        this.f21149a = new zzau(str, Locale.getDefault(), clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlacesService");
        if (queryLocalInterface instanceof zzt) {
            return (zzt) queryLocalInterface;
        }
        return new zzw(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlacesService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.location.places.GeoDataApi";
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, String str, @Nullable LatLngBounds latLngBounds, int i4, @Nullable AutocompleteFilter autocompleteFilter) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        if (str == null) {
            str = "";
        }
        String str2 = str;
        if (autocompleteFilter == null) {
            autocompleteFilter = new AutocompleteFilter.Builder().build();
        }
        ((zzt) getService()).zzb(str2, latLngBounds, i4, autocompleteFilter, this.f21149a, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, List<String> list) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzt) getService()).zzb(list, this.f21149a, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, AddPlaceRequest addPlaceRequest) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzt) getService()).zzb(addPlaceRequest, this.f21149a, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzf zzfVar, String str) throws RemoteException {
        Preconditions.checkNotNull(zzfVar, "callback cannot be null");
        ((zzt) getService()).zzb(str, this.f21149a, zzfVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzf zzfVar, String str, int i4, int i5, int i6) throws RemoteException {
        Preconditions.checkNotNull(zzfVar, "callback cannot be null");
        ((zzt) getService()).zzb(str, i4, i5, i6, this.f21149a, zzfVar);
    }
}
