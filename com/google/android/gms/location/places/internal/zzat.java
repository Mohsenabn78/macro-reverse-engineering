package com.google.android.gms.location.places.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes4.dex */
public final class zzat implements Parcelable.Creator<zzau> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzau createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        int i4 = 0;
        int i5 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 1) {
                if (fieldId != 2) {
                    if (fieldId != 3) {
                        if (fieldId != 4) {
                            if (fieldId != 6) {
                                if (fieldId != 7) {
                                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                                } else {
                                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                                }
                            } else {
                                i4 = SafeParcelReader.readInt(parcel, readHeader);
                            }
                        } else {
                            str4 = SafeParcelReader.createString(parcel, readHeader);
                        }
                    } else {
                        str3 = SafeParcelReader.createString(parcel, readHeader);
                    }
                } else {
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                }
            } else {
                str = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzau(str, str2, str3, str4, i4, i5);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzau[] newArray(int i4) {
        return new zzau[i4];
    }
}
