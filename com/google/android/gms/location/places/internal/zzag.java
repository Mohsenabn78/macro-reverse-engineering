package com.google.android.gms.location.places.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

/* loaded from: classes4.dex */
public final class zzag implements Parcelable.Creator<PlaceEntity> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        ArrayList<Integer> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        ArrayList<String> arrayList2 = null;
        LatLng latLng = null;
        LatLngBounds latLngBounds = null;
        String str5 = null;
        Uri uri = null;
        zzal zzalVar = null;
        zzai zzaiVar = null;
        String str6 = null;
        float f4 = 0.0f;
        boolean z3 = false;
        float f5 = 0.0f;
        int i4 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                case 3:
                case 12:
                case 13:
                case 16:
                case 18:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 5:
                    f4 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) SafeParcelReader.createParcelable(parcel, readHeader, LatLngBounds.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 8:
                    uri = (Uri) SafeParcelReader.createParcelable(parcel, readHeader, Uri.CREATOR);
                    break;
                case 9:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 10:
                    f5 = SafeParcelReader.readFloat(parcel, readHeader);
                    break;
                case 11:
                    i4 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 15:
                    str4 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 17:
                    arrayList2 = SafeParcelReader.createStringList(parcel, readHeader);
                    break;
                case 19:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 20:
                    arrayList = SafeParcelReader.createIntegerList(parcel, readHeader);
                    break;
                case 21:
                    zzalVar = (zzal) SafeParcelReader.createParcelable(parcel, readHeader, zzal.CREATOR);
                    break;
                case 22:
                    zzaiVar = (zzai) SafeParcelReader.createParcelable(parcel, readHeader, zzai.CREATOR);
                    break;
                case 23:
                    str6 = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new PlaceEntity(str, arrayList, str2, str3, str4, arrayList2, latLng, f4, latLngBounds, str5, uri, z3, f5, i4, zzalVar, zzaiVar, str6);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ PlaceEntity[] newArray(int i4) {
        return new PlaceEntity[i4];
    }
}
