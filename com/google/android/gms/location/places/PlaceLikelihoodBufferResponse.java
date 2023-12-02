package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.DataBufferResponse;
import com.google.android.gms.common.internal.ShowFirstParty;

@Deprecated
/* loaded from: classes4.dex */
public class PlaceLikelihoodBufferResponse extends DataBufferResponse<PlaceLikelihood, PlaceLikelihoodBuffer> {
    @Nullable
    public CharSequence getAttributions() {
        return ((PlaceLikelihoodBuffer) b()).getAttributions();
    }

    @ShowFirstParty
    public String toString() {
        return ((PlaceLikelihoodBuffer) b()).toString();
    }
}
