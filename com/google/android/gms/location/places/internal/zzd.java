package com.google.android.gms.location.places.internal;

import android.text.style.CharacterStyle;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.AutocompletePrediction;
import java.util.Collections;
import java.util.List;

/* loaded from: classes4.dex */
public final class zzd extends zzaw implements AutocompletePrediction {
    public zzd(DataHolder dataHolder, int i4) {
        super(dataHolder, i4);
    }

    private final String p() {
        return j("ap_description", "");
    }

    private final String q() {
        return j("ap_primary_text", "");
    }

    private final String r() {
        return j("ap_secondary_text", "");
    }

    private final List<zzb> s() {
        return k("ap_matched_subscriptions", zzb.CREATOR, Collections.emptyList());
    }

    private final List<zzb> t() {
        return k("ap_primary_text_matched", zzb.CREATOR, Collections.emptyList());
    }

    private final List<zzb> u() {
        return k("ap_secondary_text_matched", zzb.CREATOR, Collections.emptyList());
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ AutocompletePrediction freeze() {
        String placeId = getPlaceId();
        List<Integer> placeTypes = getPlaceTypes();
        int n4 = n("ap_personalization_type", 6);
        String p4 = p();
        return new zzc(placeId, placeTypes, n4, (String) Preconditions.checkNotNull(p4), s(), q(), t(), r(), u());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getFullText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(p(), s(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final String getPlaceId() {
        return j("ap_place_id", null);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final List<Integer> getPlaceTypes() {
        return l("ap_place_types", Collections.emptyList());
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getPrimaryText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(q(), t(), characterStyle);
    }

    @Override // com.google.android.gms.location.places.AutocompletePrediction
    public final CharSequence getSecondaryText(@Nullable CharacterStyle characterStyle) {
        return zzi.zzb(r(), u(), characterStyle);
    }
}
