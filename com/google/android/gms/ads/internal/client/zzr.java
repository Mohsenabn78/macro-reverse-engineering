package com.google.android.gms.ads.internal.client;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzr implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        zzq[] zzqVarArr = null;
        int i4 = 0;
        int i5 = 0;
        boolean z3 = false;
        int i6 = 0;
        int i7 = 0;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        boolean z7 = false;
        boolean z8 = false;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 5:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 6:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 7:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 8:
                    zzqVarArr = (zzq[]) SafeParcelReader.createTypedArray(parcel, readHeader, zzq.CREATOR);
                    break;
                case 9:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 11:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 12:
                    z7 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    z8 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 14:
                    z9 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 15:
                    z10 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 16:
                    z11 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzq(str, i4, i5, z3, i6, i7, zzqVarArr, z4, z5, z6, z7, z8, z9, z10, z11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzq[i4];
    }
}
