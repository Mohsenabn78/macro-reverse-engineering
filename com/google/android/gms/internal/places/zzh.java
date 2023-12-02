package com.google.android.gms.internal.places;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataBufferSafeParcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.location.places.PlacesStatusCodes;

@ShowFirstParty
@Deprecated
/* loaded from: classes4.dex */
public final class zzh extends DataBufferSafeParcelable<zzi> implements Result {
    private final Status zzp;

    public zzh(DataHolder dataHolder) {
        this(dataHolder, PlacesStatusCodes.zzb(dataHolder.getStatusCode()));
    }

    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zzp;
    }

    private zzh(DataHolder dataHolder, Status status) {
        super(dataHolder, zzi.CREATOR);
        Preconditions.checkArgument(dataHolder == null || dataHolder.getStatusCode() == status.getStatusCode());
        this.zzp = status;
    }
}
