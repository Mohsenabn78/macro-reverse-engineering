package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzob implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        byte[] bArr2 = null;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        int i9 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 3:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    j4 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 7:
                    j5 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 8:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 9:
                    f5 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 10:
                    j6 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 11:
                    j7 = SafeParcelReader.readLong(parcel, readHeader);
                    break;
                case 12:
                    i9 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 13:
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 14:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzoa(i4, i5, i6, i7, i8, j4, j5, f4, f5, j6, j7, i9, bArr, bArr2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzoa[i4];
    }
}
