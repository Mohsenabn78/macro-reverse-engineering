package com.google.android.gms.location.places;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzar;

@Deprecated
/* loaded from: classes4.dex */
public class PlaceBuffer extends AbstractDataBuffer<Place> implements Result {

    /* renamed from: a  reason: collision with root package name */
    private final Status f21017a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21018b;

    public PlaceBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.f21017a = PlacesStatusCodes.zzb(dataHolder.getStatusCode());
        if (dataHolder.getMetadata() != null) {
            this.f21018b = dataHolder.getMetadata().getString("com.google.android.gms.location.places.PlaceBuffer.ATTRIBUTIONS_EXTRA_KEY");
        } else {
            this.f21018b = null;
        }
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Place get(int i4) {
        return new zzar(this.mDataHolder, i4);
    }

    @Nullable
    public CharSequence getAttributions() {
        return this.f21018b;
    }

    @Override // com.google.android.gms.common.api.Result
    public Status getStatus() {
        return this.f21017a;
    }
}
