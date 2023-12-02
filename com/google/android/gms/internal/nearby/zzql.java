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

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "StartRangingParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzql extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzql> CREATOR = new zzqm();
    @Nullable
    @SafeParcelable.Field(getter = "getResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzpa zza;
    @SafeParcelable.Field(getter = "getParams", id = 2)
    private zzqb zzb;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 3, type = "android.os.IBinder")
    private zzox zzc;

    private zzql() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzql) {
            zzql zzqlVar = (zzql) obj;
            if (Objects.equal(this.zza, zzqlVar.zza) && Objects.equal(this.zzb, zzqlVar.zzb) && Objects.equal(this.zzc, zzqlVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zza, this.zzb, this.zzc);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzpa zzpaVar = this.zza;
        if (zzpaVar == null) {
            asBinder = null;
        } else {
            asBinder = zzpaVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzql(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) zzqb zzqbVar, @SafeParcelable.Param(id = 3) IBinder iBinder2) {
        zzpa zzoyVar;
        zzox zzoxVar = null;
        if (iBinder == null) {
            zzoyVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IResultListener");
            zzoyVar = queryLocalInterface instanceof zzpa ? (zzpa) queryLocalInterface : new zzoy(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.uwb.internal.IRangingSessionCallback");
            zzoxVar = queryLocalInterface2 instanceof zzox ? (zzox) queryLocalInterface2 : new zzov(iBinder2);
        }
        this.zza = zzoyVar;
        this.zzb = zzqbVar;
        this.zzc = zzoxVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzql(zzqk zzqkVar) {
    }
}
