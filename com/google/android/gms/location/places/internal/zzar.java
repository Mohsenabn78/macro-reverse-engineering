package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.internal.PlaceEntity;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public final class zzar extends zzaw implements Place {

    /* renamed from: d  reason: collision with root package name */
    private final String f21113d;

    /* renamed from: e  reason: collision with root package name */
    private final zzai f21114e;

    public zzar(DataHolder dataHolder, int i4) {
        super(dataHolder, i4);
        boolean z3;
        this.f21113d = j("place_id", "");
        if (getPlaceTypes().size() <= 0 && ((getPhoneNumber() == null || getPhoneNumber().length() <= 0) && ((getWebsiteUri() == null || getWebsiteUri().equals(Uri.EMPTY)) && getRating() < 0.0f && getPriceLevel() < 0))) {
            z3 = false;
        } else {
            z3 = true;
        }
        zzai zzaiVar = null;
        if (z3) {
            zzaiVar = new zzai(getPlaceTypes(), getPhoneNumber() != null ? getPhoneNumber().toString() : null, getWebsiteUri(), getRating(), getPriceLevel());
        }
        this.f21114e = zzaiVar;
    }

    private final List<String> p() {
        return o("place_attributions", Collections.emptyList());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Place freeze() {
        boolean z3;
        PlaceEntity.zzb zzb = new PlaceEntity.zzb().zzd(getAddress().toString()).zzd(p()).zzb(getId());
        if (hasColumn("place_is_permanently_closed") && !f("place_is_permanently_closed")) {
            z3 = a("place_is_permanently_closed");
        } else {
            z3 = false;
        }
        PlaceEntity zzj = zzb.zzb(z3).zzb(getLatLng()).zzb(h("place_level_number", 0.0f)).zzc(getName().toString()).zze(getPhoneNumber().toString()).zzc(getPriceLevel()).zzc(getRating()).zzc(getPlaceTypes()).zzb(getViewport()).zzb(getWebsiteUri()).zzb((zzal) i("place_opening_hours", zzal.CREATOR)).zzb(this.f21114e).zzf(j("place_adr_address", "")).zzj();
        zzj.setLocale(getLocale());
        return zzj;
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getAddress() {
        return j("place_address", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getAttributions() {
        return zzi.zzc(p());
    }

    @Override // com.google.android.gms.location.places.Place
    public final String getId() {
        return this.f21113d;
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLng getLatLng() {
        return (LatLng) i("place_lat_lng", LatLng.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public final Locale getLocale() {
        String j4 = j("place_locale_language", "");
        if (!TextUtils.isEmpty(j4)) {
            return new Locale(j4, j("place_locale_country", ""));
        }
        String j5 = j("place_locale", "");
        if (!TextUtils.isEmpty(j5)) {
            return new Locale(j5);
        }
        return Locale.getDefault();
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getName() {
        return j("place_name", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public final CharSequence getPhoneNumber() {
        return j("place_phone_number", "");
    }

    @Override // com.google.android.gms.location.places.Place
    public final List<Integer> getPlaceTypes() {
        return l("place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.Place
    public final int getPriceLevel() {
        return n("place_price_level", -1);
    }

    @Override // com.google.android.gms.location.places.Place
    public final float getRating() {
        return h("place_rating", -1.0f);
    }

    @Override // com.google.android.gms.location.places.Place
    public final LatLngBounds getViewport() {
        return (LatLngBounds) i("place_viewport", LatLngBounds.CREATOR);
    }

    @Override // com.google.android.gms.location.places.Place
    public final Uri getWebsiteUri() {
        String j4 = j("place_website_uri", null);
        if (j4 == null) {
            return null;
        }
        return Uri.parse(j4);
    }
}
