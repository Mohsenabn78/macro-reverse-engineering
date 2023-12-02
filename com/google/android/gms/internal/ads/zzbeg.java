package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-ads-lite@@22.3.0 */
/* loaded from: classes4.dex */
public final class zzbeg implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        com.google.android.gms.ads.internal.client.zzfl zzflVar = null;
        int i4 = 0;
        boolean z3 = false;
        int i5 = 0;
        boolean z4 = false;
        int i6 = 0;
        boolean z5 = false;
        int i7 = 0;
        int i8 = 0;
        boolean z6 = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 2:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 3:
                    i5 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 5:
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 6:
                    zzflVar = (com.google.android.gms.ads.internal.client.zzfl) SafeParcelReader.createParcelable(parcel, readHeader, com.google.android.gms.ads.internal.client.zzfl.CREATOR);
                    break;
                case 7:
                    z5 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 8:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 9:
                    i8 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 10:
                    z6 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzbef(i4, z3, i5, z4, i6, zzflVar, z5, i7, i8, z6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new zzbef[i4];
    }
}
