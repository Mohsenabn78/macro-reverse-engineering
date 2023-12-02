package com.google.android.gms.internal.nearby;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "GetDailySummariesParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();
    @SafeParcelable.Field(getter = "getDailySummaryListCallbackAsBinder", id = 1, type = "android.os.IBinder")
    private zzcs zza;
    @SafeParcelable.Field(getter = "getDailySummariesConfig", id = 2)
    private DailySummariesConfig zzb;

    private zzbe() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzbe) {
            zzbe zzbeVar = (zzbe) obj;
            if (Objects.equal(this.zza, zzbeVar.zza) && Objects.equal(this.zzb, zzbeVar.zzb)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeIBinder(parcel, 1, this.zza.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbe(@SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) DailySummariesConfig dailySummariesConfig) {
        zzcs zzcqVar;
        if (iBinder == null) {
            zzcqVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IDailySummaryListCallback");
            zzcqVar = queryLocalInterface instanceof zzcs ? (zzcs) queryLocalInterface : new zzcq(iBinder);
        }
        this.zza = zzcqVar;
        this.zzb = dailySummariesConfig;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzbe(zzbd zzbdVar) {
    }
}
