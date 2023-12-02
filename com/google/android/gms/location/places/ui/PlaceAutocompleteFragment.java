package com.google.android.gms.location.places.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.R;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLngBounds;

@TargetApi(12)
@Deprecated
/* loaded from: classes4.dex */
public class PlaceAutocompleteFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private View f21150a;

    /* renamed from: b  reason: collision with root package name */
    private View f21151b;

    /* renamed from: c  reason: collision with root package name */
    private EditText f21152c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f21153d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private LatLngBounds f21154e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private AutocompleteFilter f21155f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private PlaceSelectionListener f21156g;

    private final void c() {
        int i4;
        boolean z3 = !this.f21152c.getText().toString().isEmpty();
        View view = this.f21151b;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        int connectionStatusCode;
        try {
            Intent build = new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.f21154e).setFilter(this.f21155f).zzg(this.f21152c.getText().toString()).zzd(1).build(getActivity());
            this.f21153d = true;
            startActivityForResult(build, 30421);
            connectionStatusCode = -1;
        } catch (GooglePlayServicesNotAvailableException e4) {
            connectionStatusCode = e4.errorCode;
            Log.e("Places", "Could not open autocomplete activity", e4);
        } catch (GooglePlayServicesRepairableException e5) {
            connectionStatusCode = e5.getConnectionStatusCode();
            Log.e("Places", "Could not open autocomplete activity", e5);
        }
        if (connectionStatusCode != -1) {
            GoogleApiAvailability.getInstance().showErrorDialogFragment(getActivity(), connectionStatusCode, 30422);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        this.f21153d = false;
        if (i4 == 30421) {
            if (i5 == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), intent);
                PlaceSelectionListener placeSelectionListener = this.f21156g;
                if (placeSelectionListener != null) {
                    placeSelectionListener.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (i5 == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), intent);
                PlaceSelectionListener placeSelectionListener2 = this.f21156g;
                if (placeSelectionListener2 != null) {
                    placeSelectionListener2.onError(status);
                }
            }
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.f21150a = inflate.findViewById(R.id.place_autocomplete_search_button);
        this.f21151b = inflate.findViewById(R.id.place_autocomplete_clear_button);
        this.f21152c = (EditText) inflate.findViewById(R.id.place_autocomplete_search_input);
        zze zzeVar = new zze(this);
        this.f21150a.setOnClickListener(zzeVar);
        this.f21152c.setOnClickListener(zzeVar);
        this.f21151b.setOnClickListener(new zzd(this));
        c();
        return inflate;
    }

    @Override // android.app.Fragment
    public void onDestroyView() {
        this.f21150a = null;
        this.f21151b = null;
        this.f21152c = null;
        super.onDestroyView();
    }

    public void setBoundsBias(@Nullable LatLngBounds latLngBounds) {
        this.f21154e = latLngBounds;
    }

    public void setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
        this.f21155f = autocompleteFilter;
    }

    public void setHint(CharSequence charSequence) {
        this.f21152c.setHint(charSequence);
        this.f21150a.setContentDescription(charSequence);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.f21156g = placeSelectionListener;
    }

    public void setText(CharSequence charSequence) {
        this.f21152c.setText(charSequence);
        c();
    }
}
