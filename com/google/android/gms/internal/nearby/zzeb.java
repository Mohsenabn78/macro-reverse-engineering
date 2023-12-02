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
@SafeParcelable.Class(creator = "IsEnabledParamsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class zzeb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzeb> CREATOR = new zzec();
    @SafeParcelable.Field(getter = "getBooleanCallbackAsBinder", id = 2, type = "android.os.IBinder")
    private zzco zza;
    @Nullable
    @SafeParcelable.Field(getter = "getBooleanResultListenerAsBinder", id = 1, type = "android.os.IBinder")
    private zzcp zzb;

    private zzeb() {
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzeb) {
            zzeb zzebVar = (zzeb) obj;
            if (Objects.equal(this.zzb, zzebVar.zzb) && Objects.equal(this.zza, zzebVar.zza)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        zzcp zzcpVar = this.zzb;
        if (zzcpVar == null) {
            asBinder = null;
        } else {
            asBinder = zzcpVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 1, asBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zza.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzeb(@Nullable @SafeParcelable.Param(id = 1) IBinder iBinder, @SafeParcelable.Param(id = 2) IBinder iBinder2) {
        zzcp zzcpVar;
        zzco zzcoVar = null;
        if (iBinder == null) {
            zzcpVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanResultListener");
            zzcpVar = queryLocalInterface instanceof zzcp ? (zzcp) queryLocalInterface : new zzcp(iBinder);
        }
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.exposurenotification.internal.IBooleanCallback");
            zzcoVar = queryLocalInterface2 instanceof zzco ? (zzco) queryLocalInterface2 : new zzcm(iBinder2);
        }
        this.zzb = zzcpVar;
        this.zza = zzcoVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzeb(zzea zzeaVar) {
    }
}
