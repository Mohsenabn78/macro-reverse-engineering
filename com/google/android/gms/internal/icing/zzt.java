package com.google.android.gms.internal.icing;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public final class zzt implements Parcelable.Creator<zzs> {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        zzm[] zzmVarArr = null;
        String str4 = null;
        zzu zzuVar = null;
        boolean z3 = false;
        int i4 = 1;
        boolean z4 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId != 11) {
                if (fieldId != 12) {
                    switch (fieldId) {
                        case 1:
                            str = SafeParcelReader.createString(parcel, readHeader);
                            continue;
                        case 2:
                            str2 = SafeParcelReader.createString(parcel, readHeader);
                            continue;
                        case 3:
                            z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                            continue;
                        case 4:
                            i4 = SafeParcelReader.readInt(parcel, readHeader);
                            continue;
                        case 5:
                            z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                            continue;
                        case 6:
                            str3 = SafeParcelReader.createString(parcel, readHeader);
                            continue;
                        case 7:
                            zzmVarArr = (zzm[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzm.CREATOR);
                            continue;
                        default:
                            SafeParcelReader.skipUnknownField(parcel, readHeader);
                            continue;
                    }
                } else {
                    zzuVar = (zzu) SafeParcelReader.createParcelable(parcel, readHeader, zzu.CREATOR);
                }
            } else {
                str4 = SafeParcelReader.createString(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzs(str, str2, z3, i4, z4, str3, zzmVarArr, str4, zzuVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ zzs[] newArray(int i4) {
        return new zzs[i4];
    }
}
