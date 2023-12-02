package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
final class zzlv extends zzlz {
    @Override // com.google.android.gms.internal.nearby.zzlz, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.internal.nearby.zzlz
    public final zzly zza(Parcel parcel) {
        ParcelFileDescriptor parcelFileDescriptor;
        ParcelFileDescriptor parcelFileDescriptor2;
        zzly createFromParcel = super.createFromParcel(parcel);
        parcelFileDescriptor = createFromParcel.zzb;
        if (parcelFileDescriptor != null) {
            parcelFileDescriptor2 = createFromParcel.zzb;
            createFromParcel.zza = zzly.zzd(parcelFileDescriptor2);
        }
        return createFromParcel;
    }
}
