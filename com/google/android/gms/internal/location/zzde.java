package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
/* loaded from: classes4.dex */
public final class zzde implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        LocationRequest locationRequest = null;
        ArrayList arrayList = null;
        String str = null;
        String str2 = null;
        long j4 = Long.MAX_VALUE;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 5) {
                    switch (fieldId) {
                        case 8:
                            z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                            continue;
                        case 9:
                            z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                            continue;
                        case 10:
                            str = SafeParcelReader.createString(parcel, readHeader);
                            continue;
                        case 11:
                            z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                            continue;
                        case 12:
                            z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                            continue;
                        case 13:
                            str2 = SafeParcelReader.createString(parcel, readHeader);
                            continue;
                        case 14:
                            j4 = SafeParcelReader.readLong(parcel, readHeader);
                            continue;
                        default:
                            SafeParcelReader.skipUnknownField(parcel, readHeader);
                            continue;
                    }
                } else {
                    arrayList = SafeParcelReader.createTypedList(parcel, readHeader, ClientIdentity.CREATOR);
                }
            } else {
                locationRequest = (LocationRequest) SafeParcelReader.createParcelable(parcel, readHeader, LocationRequest.CREATOR);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzdd(locationRequest, arrayList, z3, z4, str, z5, z6, str2, j4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzdd[i4];
    }
}
