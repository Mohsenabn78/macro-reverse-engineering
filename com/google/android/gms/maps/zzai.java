package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;
import com.google.android.gms.maps.model.StreetViewSource;

/* loaded from: classes4.dex */
public final class zzai implements Parcelable.Creator<StreetViewPanoramaOptions> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        StreetViewPanoramaCamera streetViewPanoramaCamera = null;
        String str = null;
        LatLng latLng = null;
        Integer num = null;
        StreetViewSource streetViewSource = null;
        byte b4 = 0;
        byte b5 = 0;
        byte b6 = 0;
        byte b7 = 0;
        byte b8 = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    streetViewPanoramaCamera = (StreetViewPanoramaCamera) SafeParcelReader.createParcelable(parcel, readHeader, StreetViewPanoramaCamera.CREATOR);
                    break;
                case 3:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 4:
                    latLng = (LatLng) SafeParcelReader.createParcelable(parcel, readHeader, LatLng.CREATOR);
                    break;
                case 5:
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                    break;
                case 6:
                    b4 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 7:
                    b5 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 8:
                    b6 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 9:
                    b7 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 10:
                    b8 = SafeParcelReader.readByte(parcel, readHeader);
                    break;
                case 11:
                    streetViewSource = (StreetViewSource) SafeParcelReader.createParcelable(parcel, readHeader, StreetViewSource.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new StreetViewPanoramaOptions(streetViewPanoramaCamera, str, latLng, num, b4, b5, b6, b7, b8, streetViewSource);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StreetViewPanoramaOptions[] newArray(int i4) {
        return new StreetViewPanoramaOptions[i4];
    }
}
