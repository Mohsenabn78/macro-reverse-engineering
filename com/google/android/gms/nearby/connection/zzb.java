package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzb implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Strategy strategy = null;
        byte[] bArr = null;
        ParcelUuid parcelUuid = null;
        byte[] bArr2 = null;
        zzab[] zzabVarArr = null;
        int[] iArr = null;
        int[] iArr2 = null;
        byte[] bArr3 = null;
        long j4 = 0;
        boolean z3 = true;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = false;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = false;
        boolean z13 = false;
        int i4 = 0;
        int i5 = 0;
        boolean z14 = false;
        boolean z15 = true;
        boolean z16 = false;
        boolean z17 = true;
        boolean z18 = true;
        int i6 = 0;
        boolean z19 = true;
        int i7 = 0;
        boolean z20 = false;
        boolean z21 = true;
        boolean z22 = true;
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
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 7:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    parcelUuid = (ParcelUuid) SafeParcelReader.createParcelable(parcel, readHeader, ParcelUuid.CREATOR);
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
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 14:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 15:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 16:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 17:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 18:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 19:
                    zzabVarArr = (zzab[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzab.CREATOR);
                    break;
                case 20:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 21:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 22:
                    z16 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 23:
                    z17 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 24:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 25:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 26:
                    z18 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 27:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 28:
                    bArr3 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 29:
                    z19 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 30:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 31:
                    z20 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 32:
                    z21 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 33:
                    z22 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new AdvertisingOptions(strategy, z3, z4, z5, z6, bArr, z7, parcelUuid, z8, z9, z10, z11, z12, z13, i4, i5, bArr2, j4, zzabVarArr, z14, z15, z16, z17, iArr, iArr2, z18, i6, bArr3, z19, i7, z20, z21, z22);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new AdvertisingOptions[i4];
    }
}
