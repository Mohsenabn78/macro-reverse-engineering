package com.google.android.gms.location.places.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceLikelihood;

/* loaded from: classes4.dex */
public final class zzam extends zzaw implements PlaceLikelihood {
    public zzam(DataHolder dataHolder, int i4) {
        super(dataHolder, i4);
    }

    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ PlaceLikelihood freeze() {
        return new zzak((PlaceEntity) Preconditions.checkNotNull((PlaceEntity) getPlace().freeze()), getLikelihood());
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final float getLikelihood() {
        return h("place_likelihood", -1.0f);
    }

    @Override // com.google.android.gms.location.places.PlaceLikelihood
    public final Place getPlace() {
        return new zzar(this.f20368a, this.f20369b);
    }
}
