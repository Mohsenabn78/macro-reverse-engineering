package com.google.android.gms.location.places.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.model.LatLngBounds;

@Deprecated
/* loaded from: classes4.dex */
public class PlaceAutocomplete extends zzb {
    public static final int MODE_FULLSCREEN = 1;
    public static final int MODE_OVERLAY = 2;
    public static final int RESULT_ERROR = 2;

    /* loaded from: classes4.dex */
    public static class IntentBuilder extends zzc {
        public IntentBuilder(int i4) {
            super("com.google.android.gms.location.places.ui.AUTOCOMPLETE");
            this.f21164a.putExtra("gmscore_client_jar_version", GoogleApiAvailability.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            this.f21164a.putExtra("mode", i4);
            this.f21164a.putExtra("origin", 2);
        }

        @Override // com.google.android.gms.location.places.ui.zzc
        public Intent build(Activity activity) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
            return super.build(activity);
        }

        public IntentBuilder setBoundsBias(@Nullable LatLngBounds latLngBounds) {
            if (latLngBounds != null) {
                this.f21164a.putExtra("bounds", latLngBounds);
            } else {
                this.f21164a.removeExtra("bounds");
            }
            return this;
        }

        public IntentBuilder setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
            if (autocompleteFilter != null) {
                this.f21164a.putExtra("filter", autocompleteFilter);
            } else {
                this.f21164a.removeExtra("filter");
            }
            return this;
        }

        public final IntentBuilder zzd(int i4) {
            this.f21164a.putExtra("origin", 1);
            return this;
        }

        public final IntentBuilder zzg(@Nullable String str) {
            if (str != null) {
                this.f21164a.putExtra("initial_query", str);
            } else {
                this.f21164a.removeExtra("initial_query");
            }
            return this;
        }
    }

    private PlaceAutocomplete() {
    }

    public static Place getPlace(Context context, Intent intent) {
        return zzb.getPlace(context, intent);
    }

    public static Status getStatus(Context context, Intent intent) {
        return zzb.getStatus(context, intent);
    }
}
