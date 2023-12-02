package com.google.android.gms.location.places.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.AutocompleteFilter;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.R;
import com.google.android.gms.location.places.ui.PlaceAutocomplete;
import com.google.android.gms.maps.model.LatLngBounds;

@Deprecated
/* loaded from: classes4.dex */
public class SupportPlaceAutocompleteFragment extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    private View f21157b;

    /* renamed from: c  reason: collision with root package name */
    private View f21158c;

    /* renamed from: d  reason: collision with root package name */
    private EditText f21159d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f21160e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private LatLngBounds f21161f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private AutocompleteFilter f21162g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private PlaceSelectionListener f21163h;

    private final void d() {
        int i4;
        boolean z3 = !this.f21159d.getText().toString().isEmpty();
        View view = this.f21158c;
        if (z3) {
            i4 = 0;
        } else {
            i4 = 8;
        }
        view.setVisibility(i4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e() {
        int connectionStatusCode;
        try {
            Intent build = new PlaceAutocomplete.IntentBuilder(2).setBoundsBias(this.f21161f).setFilter(this.f21162g).zzg(this.f21159d.getText().toString()).zzd(1).build(getActivity());
            this.f21160e = true;
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

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i4, int i5, Intent intent) {
        this.f21160e = false;
        if (i4 == 30421) {
            if (i5 == -1) {
                Place place = PlaceAutocomplete.getPlace(getActivity(), intent);
                PlaceSelectionListener placeSelectionListener = this.f21163h;
                if (placeSelectionListener != null) {
                    placeSelectionListener.onPlaceSelected(place);
                }
                setText(place.getName().toString());
            } else if (i5 == 2) {
                Status status = PlaceAutocomplete.getStatus(getActivity(), intent);
                PlaceSelectionListener placeSelectionListener2 = this.f21163h;
                if (placeSelectionListener2 != null) {
                    placeSelectionListener2.onError(status);
                }
            }
        }
        super.onActivityResult(i4, i5, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.place_autocomplete_fragment, viewGroup, false);
        this.f21157b = inflate.findViewById(R.id.place_autocomplete_search_button);
        this.f21158c = inflate.findViewById(R.id.place_autocomplete_clear_button);
        this.f21159d = (EditText) inflate.findViewById(R.id.place_autocomplete_search_input);
        zzg zzgVar = new zzg(this);
        this.f21157b.setOnClickListener(zzgVar);
        this.f21159d.setOnClickListener(zzgVar);
        this.f21158c.setOnClickListener(new zzf(this));
        d();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this.f21157b = null;
        this.f21158c = null;
        this.f21159d = null;
        super.onDestroyView();
    }

    public void setBoundsBias(@Nullable LatLngBounds latLngBounds) {
        this.f21161f = latLngBounds;
    }

    public void setFilter(@Nullable AutocompleteFilter autocompleteFilter) {
        this.f21162g = autocompleteFilter;
    }

    public void setHint(CharSequence charSequence) {
        this.f21159d.setHint(charSequence);
        this.f21157b.setContentDescription(charSequence);
    }

    public void setOnPlaceSelectedListener(PlaceSelectionListener placeSelectionListener) {
        this.f21163h = placeSelectionListener;
    }

    public void setText(CharSequence charSequence) {
        this.f21159d.setText(charSequence);
        d();
    }
}
