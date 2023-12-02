package com.google.android.gms.nearby.messages.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.nearby.messages.MessageFilter;
import com.google.android.gms.nearby.messages.Strategy;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "SubscribeRequestCreator")
/* loaded from: classes4.dex */
public final class SubscribeRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<SubscribeRequest> CREATOR = new zzcd();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22415a;
    @Nullable
    @SafeParcelable.Field(getter = "getMessageListenerAsBinder", id = 2, type = "android.os.IBinder")
    public final zzo zzb;
    @NonNull
    @SafeParcelable.Field(id = 3)
    public final Strategy zzc;
    @SafeParcelable.Field(getter = "getCallbackAsBinder", id = 4, type = "android.os.IBinder")
    public final zzr zzd;
    @NonNull
    @SafeParcelable.Field(id = 5)
    public final MessageFilter zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final PendingIntent zzf;
    @SafeParcelable.Field(id = 7)
    @Deprecated
    public final int zzg;
    @Nullable
    @SafeParcelable.Field(id = 8)
    @Deprecated
    public final String zzh;
    @Nullable
    @SafeParcelable.Field(id = 9)
    @Deprecated
    public final String zzi;
    @Nullable
    @SafeParcelable.Field(id = 10)
    public final byte[] zzj;
    @SafeParcelable.Field(id = 11)
    @Deprecated
    public final boolean zzk;
    @Nullable
    @SafeParcelable.Field(getter = "getSubscribeCallbackAsBinder", id = 12, type = "android.os.IBinder")
    public final zzab zzl;
    @SafeParcelable.Field(id = 13)
    @Deprecated
    public final boolean zzm;
    @Nullable
    @SafeParcelable.Field(id = 14)
    @Deprecated
    public final ClientAppContext zzn;
    @SafeParcelable.Field(id = 15)
    public final boolean zzo;
    @SafeParcelable.Field(id = 16)
    public final int zzp;
    @SafeParcelable.Field(id = 17)
    public final int zzq;

    @SafeParcelable.Constructor
    public SubscribeRequest(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) IBinder iBinder, @NonNull @SafeParcelable.Param(id = 3) Strategy strategy, @NonNull @SafeParcelable.Param(id = 4) IBinder iBinder2, @NonNull @SafeParcelable.Param(id = 5) MessageFilter messageFilter, @Nullable @SafeParcelable.Param(id = 6) PendingIntent pendingIntent, @SafeParcelable.Param(id = 7) int i5, @Nullable @SafeParcelable.Param(id = 8) String str, @Nullable @SafeParcelable.Param(id = 9) String str2, @Nullable @SafeParcelable.Param(id = 10) byte[] bArr, @SafeParcelable.Param(id = 11) boolean z3, @Nullable @SafeParcelable.Param(id = 12) IBinder iBinder3, @SafeParcelable.Param(id = 13) boolean z4, @Nullable @SafeParcelable.Param(id = 14) ClientAppContext clientAppContext, @SafeParcelable.Param(id = 15) boolean z5, @SafeParcelable.Param(id = 16) int i6, @SafeParcelable.Param(id = 17) int i7) {
        IBinder iBinder4;
        zzo zzmVar;
        zzr zzpVar;
        this.f22415a = i4;
        zzab zzabVar = null;
        if (iBinder == null || (iBinder4 = (IBinder) Preconditions.checkNotNull(iBinder)) == null) {
            zzmVar = null;
        } else {
            IInterface queryLocalInterface = iBinder4.queryLocalInterface("com.google.android.gms.nearby.messages.internal.IMessageListener");
            zzmVar = queryLocalInterface instanceof zzo ? (zzo) queryLocalInterface : new zzm(iBinder4);
        }
        this.zzb = zzmVar;
        this.zzc = strategy;
        if (iBinder2 == null) {
            zzpVar = null;
        } else {
            IInterface queryLocalInterface2 = iBinder2.queryLocalInterface("com.google.android.gms.nearby.messages.internal.INearbyMessagesCallback");
            zzpVar = queryLocalInterface2 instanceof zzr ? (zzr) queryLocalInterface2 : new zzp(iBinder2);
        }
        this.zzd = zzpVar;
        this.zze = messageFilter;
        this.zzf = pendingIntent;
        this.zzg = i5;
        this.zzh = str;
        this.zzi = str2;
        this.zzj = bArr;
        this.zzk = z3;
        if (iBinder3 != null) {
            IInterface queryLocalInterface3 = iBinder3.queryLocalInterface("com.google.android.gms.nearby.messages.internal.ISubscribeCallback");
            zzabVar = queryLocalInterface3 instanceof zzab ? (zzab) queryLocalInterface3 : new zzz(iBinder3);
        }
        this.zzl = zzabVar;
        this.zzm = z4;
        this.zzn = ClientAppContext.b(clientAppContext, str2, str, z4);
        this.zzo = z5;
        this.zzp = i6;
        this.zzq = i7;
    }

    @NonNull
    public final String toString() {
        byte[] bArr;
        String str;
        String valueOf = String.valueOf(this.zzb);
        String valueOf2 = String.valueOf(this.zzc);
        String valueOf3 = String.valueOf(this.zzd);
        String valueOf4 = String.valueOf(this.zze);
        String valueOf5 = String.valueOf(this.zzf);
        if (this.zzj == null) {
            str = null;
        } else {
            str = "<" + bArr.length + " bytes>";
        }
        return "SubscribeRequest{messageListener=" + valueOf + ", strategy=" + valueOf2 + ", callback=" + valueOf3 + ", filter=" + valueOf4 + ", pendingIntent=" + valueOf5 + ", hint=" + str + ", subscribeCallback=" + String.valueOf(this.zzl) + ", useRealClientApiKey=" + this.zzm + ", clientAppContext=" + String.valueOf(this.zzn) + ", isDiscardPendingIntent=" + this.zzo + ", zeroPartyPackageName=" + this.zzh + ", realClientPackageName=" + this.zzi + ", isIgnoreNearbyPermission=" + this.zzk + ", callingContext=" + this.zzq + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        IBinder asBinder;
        IBinder asBinder2;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22415a);
        zzo zzoVar = this.zzb;
        IBinder iBinder = null;
        if (zzoVar == null) {
            asBinder = null;
        } else {
            asBinder = zzoVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, asBinder, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        zzr zzrVar = this.zzd;
        if (zzrVar == null) {
            asBinder2 = null;
        } else {
            asBinder2 = zzrVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 4, asBinder2, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzg);
        SafeParcelWriter.writeString(parcel, 8, this.zzh, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzi, false);
        SafeParcelWriter.writeByteArray(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        zzab zzabVar = this.zzl;
        if (zzabVar != null) {
            iBinder = zzabVar.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 12, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 13, this.zzm);
        SafeParcelWriter.writeParcelable(parcel, 14, this.zzn, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.zzo);
        SafeParcelWriter.writeInt(parcel, 16, this.zzp);
        SafeParcelWriter.writeInt(parcel, 17, this.zzq);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public SubscribeRequest(@Nullable IBinder iBinder, @NonNull Strategy strategy, @NonNull IBinder iBinder2, @NonNull MessageFilter messageFilter, @Nullable PendingIntent pendingIntent, @Nullable byte[] bArr, @Nullable IBinder iBinder3, boolean z3, int i4, int i5) {
        this(3, iBinder, strategy, iBinder2, messageFilter, pendingIntent, 0, null, null, null, false, iBinder3, false, null, false, 0, i5);
    }
}
