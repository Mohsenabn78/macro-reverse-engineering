package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;

@Deprecated
/* loaded from: classes4.dex */
public class PlacePicker extends zzb {
    public static final int RESULT_ERROR = 2;

    /* loaded from: classes4.dex */
    public static class IntentBuilder extends zzc {
        public IntentBuilder() {
            super("com.google.android.gms.location.places.ui.PICK_PLACE");
            this.f21164a.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
        }

        @Override // com.google.android.gms.location.places.ui.zzc
        public Intent build(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.build(activity);
        }

        public IntentBuilder setLatLngBounds(LatLngBounds latLngBounds) {
            Preconditions.checkNotNull(latLngBounds);
            SafeParcelableSerializer.serializeToIntentExtra(latLngBounds, this.f21164a, "latlng_bounds");
            return this;
        }
    }

    private PlacePicker() {
    }

    @Deprecated
    public static String getAttributions(Intent intent) {
        return intent.getStringExtra("third_party_attributions");
    }

    public static LatLngBounds getLatLngBounds(Intent intent) {
        return (LatLngBounds) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "final_latlng_bounds", LatLngBounds.CREATOR);
    }

    @Deprecated
    public static Place getPlace(Intent intent, Context context) {
        return zzb.getPlace(context, intent);
    }

    public static Place getPlace(Context context, Intent intent) {
        return zzb.getPlace(context, intent);
    }
}
