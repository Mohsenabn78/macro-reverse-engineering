package com.google.android.gms.internal.nearby;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.UUID;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "NearbyDeviceFilterCreator")
/* loaded from: classes4.dex */
public final class zznk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zznk> CREATOR = new zznl();
    @SafeParcelable.VersionField(id = 1000)
    final int zza;
    @SafeParcelable.Field(id = 1)
    final int zzb;
    @Nullable
    @SafeParcelable.Field(id = 2)
    final byte[] zzc;
    @SafeParcelable.Field(id = 3)
    final boolean zzd;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zznk(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) int i5, @Nullable @SafeParcelable.Param(id = 2) byte[] bArr, @SafeParcelable.Param(id = 3) boolean z3) {
        this.zza = i4;
        this.zzb = i5;
        this.zzc = bArr;
        this.zzd = z3;
    }

    public static zznk zza(String str, @Nullable String str2) {
        if (str2 == null) {
            str2 = "";
        }
        return new zznk(2, new com.google.android.gms.nearby.messages.internal.zzg(com.google.android.gms.nearby.messages.internal.zzc.zzd(String.valueOf(str).concat(str2))).zzc());
    }

    public static zznk zzb(UUID uuid, @Nullable Short sh, @Nullable Short sh2) {
        return new zznk(3, new com.google.android.gms.nearby.messages.internal.zzl(uuid, sh, sh2).zzc());
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzb);
        SafeParcelWriter.writeByteArray(parcel, 2, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zza);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    private zznk(int i4, @Nullable byte[] bArr) {
        this(1, i4, bArr, false);
    }
}
