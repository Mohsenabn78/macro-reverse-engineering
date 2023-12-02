package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "UnsubscribeRequestCreator")
/* loaded from: classes4.dex */
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new zzch();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22468a;
    @Nullable
    @SafeParcelable.Field(getter = "getMessageListenerAsBinder", id = 2, type = "android.os.IBinder")
    public final zzo zzb;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 3, type = "android.os.IBinder")
    public final zzr zzc;
    @Nullable
    @SafeParcelable.Field(id = 4)
    public final PendingIntent zzd;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public final int zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    @Deprecated
    public final String zzf;
    @Nullable
    @SafeParcelable.Field(id = 7)
    @Deprecated
    public final String zzg;
    @SafeParcelable.Field(id = 8)
    @Deprecated
    public final boolean zzh;
    @Nullable
    @SafeParcelable.Field(id = 9)
    @Deprecated
    public final ClientAppContext zzi;

    @SafeParcelable.Constructor
    @VisibleForTesting(otherwise = 3)
    public zzcg(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @SafeParcelable.Param(id = 3) IBinder iBinder2, @Nullable @SafeParcelable.Param(id = 4) PendingIntent pendingIntent, @SafeParcelable.Param(id = 5) int i5, @Nullable @SafeParcelable.Param(id = 6) String str, @Nullable @SafeParcelable.Param(id = 7) String str2, @SafeParcelable.Param(id = 8) boolean z3, @Nullable @SafeParcelable.Param(id = 9) ClientAppContext clientAppContext) {
        zzo zzmVar;
        this.f22468a = i4;
        zzr zzrVar = null;
        if (iBinder == null) {
            zzmVar = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzmVar = queryLocalInterface instanceof zzo ? (zzo) queryLocalInterface : new zzm(iBinder);
        }
        this.zzb = zzmVar;
        if (iBinder2 != null) {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzrVar = queryLocalInterface2 instanceof zzr ? (zzr) queryLocalInterface2 : new zzp(iBinder2);
        }
        this.zzc = zzrVar;
        this.zzd = pendingIntent;
        this.zze = i5;
        this.zzf = str;
        this.zzg = str2;
        this.zzh = z3;
        this.zzi = ClientAppContext.b(clientAppContext, str2, str, z3);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        IBinder asBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22468a);
        zzo zzoVar = this.zzb;
        if (zzoVar == null) {
            asBinder = null;
        } else {
            asBinder = zzoVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.writeIBinder(parcel, 3, this.zzc.asBinder(), false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzg, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzi, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public zzcg(@Nullable IBinder iBinder, IBinder iBinder2, @Nullable PendingIntent pendingIntent) {
        this(1, iBinder, iBinder2, pendingIntent, 0, null, null, false, null);
    }
}
