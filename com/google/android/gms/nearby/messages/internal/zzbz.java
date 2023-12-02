package com.google.android.gms.nearby.messages.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "PublishRequestCreator")
/* loaded from: classes4.dex */
public final class zzbz extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbz> CREATOR = new zzca();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22463a;
    @SafeParcelable.Field(id = 2)
    public final zzae zzb;
    @SafeParcelable.Field(id = 3)
    public final Strategy zzc;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 4, type = "android.os.IBinder")
    public final zzr zzd;
    @Nullable
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public final String zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    @Deprecated
    public final String zzf;
    @SafeParcelable.Field(id = 7)
    @Deprecated
    public final boolean zzg;
    @Nullable
    @SafeParcelable.Field(getter = "getPublishCallbackAsBinder", id = 8, type = "android.os.IBinder")
    public final zzv zzh;
    @SafeParcelable.Field(id = 9)
    @Deprecated
    public final boolean zzi;
    @Nullable
    @SafeParcelable.Field(id = 10)
    @Deprecated
    public final ClientAppContext zzj;
    @SafeParcelable.Field(id = 11)
    public final int zzk;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzbz(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) zzae zzaeVar, @SafeParcelable.Param(id = 3) Strategy strategy, @SafeParcelable.Param(id = 4) IBinder iBinder, @Nullable @SafeParcelable.Param(id = 5) String str, @Nullable @SafeParcelable.Param(id = 6) String str2, @SafeParcelable.Param(id = 7) boolean z3, @Nullable @SafeParcelable.Param(id = 8) IBinder iBinder2, @SafeParcelable.Param(id = 9) boolean z4, @Nullable @SafeParcelable.Param(id = 10) ClientAppContext clientAppContext, @SafeParcelable.Param(id = 11) int i5) {
        zzr zzpVar;
        this.f22463a = i4;
        this.zzb = zzaeVar;
        this.zzc = strategy;
        zzv zzvVar = null;
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
        this.zzd = zzpVar;
        this.zze = str;
        this.zzf = str2;
        this.zzg = z3;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IPublishCallback");
            if (queryLocalInterface2 instanceof zzv) {
                zzvVar = (zzv) queryLocalInterface2;
            } else {
                zzvVar = new zzt(iBinder2);
            }
        }
        this.zzh = zzvVar;
        this.zzi = z4;
        this.zzj = ClientAppContext.b(clientAppContext, str2, str, z4);
        this.zzk = i5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22463a);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeIBinder(parcel, 4, this.zzd.asBinder(), false);
        SafeParcelWriter.writeString(parcel, 5, this.zze, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        zzv zzvVar = this.zzh;
        if (zzvVar == null) {
            asBinder = null;
        } else {
            asBinder = zzvVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 8, asBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzj, i4, false);
        SafeParcelWriter.writeInt(parcel, 11, this.zzk);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
