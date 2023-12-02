package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzn implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        long j4 = 0;
        byte[] bArr = null;
        int[] iArr = null;
        int[] iArr2 = null;
        byte[] bArr2 = null;
        Strategy strategy = null;
        boolean z3 = false;
        boolean z4 = true;
        boolean z5 = true;
        boolean z6 = true;
        boolean z7 = true;
        boolean z8 = true;
        boolean z9 = true;
        boolean z10 = true;
        boolean z11 = false;
        boolean z12 = true;
        boolean z13 = true;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z14 = false;
        boolean z15 = true;
        boolean z16 = true;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 2:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 7:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 9:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 10:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z12 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    z13 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 15:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 16:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 17:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 18:
                    strategy = (Strategy) SafeParcelReader.createParcelable(parcel, readHeader, Strategy.CREATOR);
                    break;
                case 19:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 20:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 21:
                    z14 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 22:
                    z15 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 23:
                    z16 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new ConnectionOptions(z3, z4, z5, z6, z7, z8, z9, z10, bArr, z11, z12, z13, i4, i5, iArr, iArr2, bArr2, strategy, i6, j4, z14, z15, z16);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new ConnectionOptions[i4];
    }
}
