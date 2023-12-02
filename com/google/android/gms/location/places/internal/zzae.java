package com.google.android.gms.location.places.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.PlaceFilter;
import com.google.android.gms.location.places.PlaceReport;
import com.google.android.gms.location.places.PlacesOptions;
import java.util.Locale;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public final class zzae extends GmsClient<zzr> {

    /* renamed from: a  reason: collision with root package name */
    private final zzau f21088a;

    /* renamed from: b  reason: collision with root package name */
    private final Locale f21089b;

    private zzae(Context context, Looper looper, ClientSettings clientSettings, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener, String str, PlacesOptions placesOptions) {
        super(context, looper, 67, clientSettings, connectionCallbacks, onConnectionFailedListener);
        Locale locale = Locale.getDefault();
        this.f21089b = locale;
        this.f21088a = new zzau(str, locale, clientSettings.getAccount() != null ? clientSettings.getAccount().name : null, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final /* synthetic */ IInterface createServiceInterface(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.places.internal.IGooglePlaceDetectionService");
        if (queryLocalInterface instanceof zzr) {
            return (zzr) queryLocalInterface;
        }
        return new zzu(iBinder);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api.Client
    public final int getMinApkVersion() {
        return GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.location.places.internal.IGooglePlaceDetectionService";
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient
    protected final String getStartServiceAction() {
        return "com.google.android.gms.location.places.PlaceDetectionApi";
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, @Nullable PlaceFilter placeFilter) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        if (placeFilter == null) {
            placeFilter = PlaceFilter.zzc();
        }
        ((zzr) getService()).zzb(placeFilter, this.f21088a, zzmVar);
    }

    public final void zzb(com.google.android.gms.location.places.zzm zzmVar, PlaceReport placeReport) throws RemoteException {
        Preconditions.checkNotNull(zzmVar, "callback == null");
        ((zzr) getService()).zzb(placeReport, this.f21088a, zzmVar);
    }
}
