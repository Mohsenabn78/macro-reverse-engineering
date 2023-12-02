package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzv implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Strategy strategy = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr = null;
        int[] iArr = null;
        long j4 = 0;
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = false;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = false;
        int i4 = 0;
        int i5 = 0;
        boolean z11 = true;
        boolean z12 = false;
        boolean z13 = true;
        boolean z14 = true;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, readHeader, Strategy.CREATOR);
                    break;
                case 2:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
                    break;
                case 7:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 8:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 15:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 16:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 17:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 18:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 19:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 20:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new DiscoveryOptions(strategy, z3, z4, z5, z6, parcelUuid, z7, z8, z9, z10, i4, i5, bArr, j4, iArr, z11, z12, z13, z14);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new DiscoveryOptions[i4];
    }
}
