package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@SafeParcelable.Class(creator = "AppRecommendationsResponseCreator")
/* loaded from: classes4.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new zzr();
    @SafeParcelable.Field(id = 1)
    public final int zza;
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final List zzb;
    @Nullable
    @SafeParcelable.Field(id = 3)
    public final zziv zzc;

    @SafeParcelable.Constructor
    public zzq(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) @Nullable List list, @SafeParcelable.Param(id = 3) @Nullable zziv zzivVar) {
        this.zza = i4;
        this.zzb = list;
        this.zzc = zzivVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
