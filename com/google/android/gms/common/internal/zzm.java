package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
/* loaded from: classes4.dex */
public final class zzm implements Parcelable.Creator {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(GetServiceRequest getServiceRequest, Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getServiceRequest.f20448a);
        SafeParcelWriter.writeInt(parcel, 2, getServiceRequest.f20449b);
        SafeParcelWriter.writeInt(parcel, 3, getServiceRequest.f20450c);
        SafeParcelWriter.writeString(parcel, 4, getServiceRequest.f20451d, false);
        SafeParcelWriter.writeIBinder(parcel, 5, getServiceRequest.f20452e, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, getServiceRequest.f20453f, i4, false);
        SafeParcelWriter.writeBundle(parcel, 7, getServiceRequest.f20454g, false);
        SafeParcelWriter.writeParcelable(parcel, 8, getServiceRequest.f20455h, i4, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, getServiceRequest.f20456i, i4, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, getServiceRequest.f20457j, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 12, getServiceRequest.f20458k);
        SafeParcelWriter.writeInt(parcel, 13, getServiceRequest.f20459l);
        SafeParcelWriter.writeBoolean(parcel, 14, getServiceRequest.f20460m);
        SafeParcelWriter.writeString(parcel, 15, getServiceRequest.zza(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Scope[] scopeArr = GetServiceRequest.f20446o;
        Bundle bundle = new Bundle();
        Feature[] featureArr = GetServiceRequest.f20447p;
        Feature[] featureArr2 = featureArr;
        String str = null;
        IBinder iBinder = null;
        Account account = null;
        String str2 = null;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z3 = false;
        int i7 = 0;
        boolean z4 = false;
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
                    i6 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 4:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 5:
                    iBinder = SafeParcelReader.readIBinder(parcel, readHeader);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.createTypedArray(parcel, readHeader, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.createBundle(parcel, readHeader);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.createParcelable(parcel, readHeader, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.createTypedArray(parcel, readHeader, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.createTypedArray(parcel, readHeader, Feature.CREATOR);
                    break;
                case 12:
                    z3 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 13:
                    i7 = SafeParcelReader.readInt(parcel, readHeader);
                    break;
                case 14:
                    z4 = SafeParcelReader.readBoolean(parcel, readHeader);
                    break;
                case 15:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new GetServiceRequest(i4, i5, i6, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z3, i7, z4, str2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i4) {
        return new GetServiceRequest[i4];
    }
}
