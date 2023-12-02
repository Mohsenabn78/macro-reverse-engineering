package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzlk implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzmc zzmcVar = null;
        com.google.android.gms.nearby.presence.zzi zziVar = null;
        com.google.android.gms.nearby.connection.zzo zzoVar = null;
        boolean z3 = false;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    zzmcVar = (zzmc) SafeParcelReader.createParcelable(parcel, readHeader, zzmc.CREATOR);
                    break;
                case 3:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 4:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    zziVar = (com.google.android.gms.nearby.presence.zzi) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.nearby.presence.zzi.CREATOR);
                    break;
                case 6:
                    zzoVar = (com.google.android.gms.nearby.connection.zzo) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.nearby.connection.zzo.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzlj(str, zzmcVar, z3, i4, zziVar, zzoVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzlj[i4];
    }
}
