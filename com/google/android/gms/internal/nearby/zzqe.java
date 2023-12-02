package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.nearby.uwb.RangingPosition;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzqe implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        zzpx zzpxVar = null;
        zzpx zzpxVar2 = null;
        zzpx zzpxVar3 = null;
        zzoa zzoaVar = null;
        long j4 = 0;
        int i4 = RangingPosition.RSSI_UNKNOWN;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    zzpxVar = (zzpx) SafeParcelReader.createParcelable(parcel, readHeader, zzpx.CREATOR);
                    break;
                case 2:
                    zzpxVar2 = (zzpx) SafeParcelReader.createParcelable(parcel, readHeader, zzpx.CREATOR);
                    break;
                case 3:
                    zzpxVar3 = (zzpx) SafeParcelReader.createParcelable(parcel, readHeader, zzpx.CREATOR);
                    break;
                case 4:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 5:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    zzoaVar = (zzoa) SafeParcelReader.createParcelable(parcel, readHeader, zzoa.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzqd(zzpxVar, zzpxVar2, zzpxVar3, j4, i4, zzoaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzqd[i4];
    }
}
