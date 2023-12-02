package com.google.android.gms.nearby.messages;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzf implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        boolean z3 = false;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1000) {
                switch (fieldId) {
                    case 1:
                        i5 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    case 2:
                        i6 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    case 3:
                        i7 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    case 4:
                        z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                        continue;
                    case 5:
                        i8 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    case 6:
                        i9 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    case 7:
                        i10 = SafeParcelReader.readInt(parcel, readHeader);
                        continue;
                    default:
                        SafeParcelReader.skipUnknownField(parcel, readHeader);
                        continue;
                }
            } else {
                i4 = SafeParcelReader.readInt(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new Strategy(i4, i5, i6, i7, z3, i8, i9, i10);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new Strategy[i4];
    }
}
