package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzqc implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        byte[] bArr = null;
        zzqy zzqyVar = null;
        zzry[] zzryVarArr = null;
        byte[] bArr2 = null;
        zzry zzryVar = null;
        zzpt zzptVar = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
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
                    bArr = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 4:
                    zzqyVar = (zzqy) SafeParcelReader.createParcelable(parcel, readHeader, zzqy.CREATOR);
                    break;
                case 5:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    zzryVarArr = (zzry[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzry.CREATOR);
                    break;
                case 7:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    bArr2 = SafeParcelReader.createByteArray(parcel, readHeader);
                    break;
                case 9:
                    zzryVar = (zzry) SafeParcelReader.createParcelable(parcel, readHeader, zzry.CREATOR);
                    break;
                case 10:
                    zzptVar = (zzpt) SafeParcelReader.createParcelable(parcel, readHeader, zzpt.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzqb(i4, i5, bArr, zzqyVar, i6, zzryVarArr, i7, bArr2, zzryVar, zzptVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzqb[i4];
    }
}
