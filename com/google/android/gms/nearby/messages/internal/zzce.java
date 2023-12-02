package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "UnpublishRequestCreator")
/* loaded from: classes4.dex */
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcf();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22467a;
    @SafeParcelable.Field(id = 2)
    public final zzae zzb;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 3, type = "android.os.IBinder")
    public final zzr zzc;
    @Nullable
    @SafeParcelable.Field(id = 4)
    @Deprecated
    public final String zzd;
    @Nullable
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public final String zze;
    @SafeParcelable.Field(id = 6)
    @Deprecated
    public final boolean zzf;
    @Nullable
    @SafeParcelable.Field(id = 7)
    @Deprecated
    public final ClientAppContext zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzce(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) zzae zzaeVar, @SafeParcelable.Param(id = 3) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 4) String str, @Nullable @SafeParcelable.Param(id = 5) String str2, @SafeParcelable.Param(id = 6) boolean z3, @Nullable @SafeParcelable.Param(id = 7) ClientAppContext clientAppContext) {
        zzr zzpVar;
        this.f22467a = i4;
        this.zzb = zzaeVar;
        if (iBinder == null) {
            zzpVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            if (queryLocalInterface instanceof zzr) {
                zzpVar = (zzr) queryLocalInterface;
            } else {
                zzpVar = new zzp(iBinder);
            }
        }
        this.zzc = zzpVar;
        this.zzd = str;
        this.zze = str2;
        this.zzf = z3;
        this.zzg = ClientAppContext.b(clientAppContext, str2, str, z3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22467a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 4, this.zzd, false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeBoolean(parcel, 6, this.zzf);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzg, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
