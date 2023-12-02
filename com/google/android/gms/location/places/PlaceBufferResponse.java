package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.DataBufferResponse;

@Deprecated
/* loaded from: classes4.dex */
public class PlaceBufferResponse extends DataBufferResponse<Place, PlaceBuffer> {
    @Nullable
    public CharSequence getAttributions() {
        return ((PlaceBuffer) b()).getAttributions();
    }
}
