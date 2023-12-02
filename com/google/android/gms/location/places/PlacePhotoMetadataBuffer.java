package com.google.android.gms.location.places;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.location.places.internal.zzas;

@Deprecated
/* loaded from: classes4.dex */
public class PlacePhotoMetadataBuffer extends AbstractDataBuffer<PlacePhotoMetadata> {
    public PlacePhotoMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public PlacePhotoMetadata get(int i4) {
        return new zzas(this.mDataHolder, i4);
    }
}
