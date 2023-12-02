package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzpw implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int[] iArr = null;
        int[] iArr2 = null;
        int[] iArr3 = null;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        int i4 = 0;
        int i5 = 0;
        float f4 = 0.0f;
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
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    iArr = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 7:
                    iArr2 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                case 8:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 9:
                    iArr3 = SafeParcelReader.createIntArray(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzpv(z3, z4, z5, i4, i5, iArr, iArr2, f4, iArr3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzpv[i4];
    }
}
