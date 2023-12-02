package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.nearby.zznh;
import com.google.android.gms.internal.nearby.zzni;
import com.google.android.gms.nearby.messages.Message;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "UpdateCreator")
/* loaded from: classes4.dex */
public class Update extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<Update> CREATOR = new zzci();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22416a;
    @SafeParcelable.Field(id = 2)

    /* renamed from: b  reason: collision with root package name */
    final int f22417b;
    @NonNull
    @SafeParcelable.Field(id = 3)
    public final Message zzc;
    @Nullable
    @SafeParcelable.Field(id = 4)
    public final zze zzd;
    @Nullable
    @SafeParcelable.Field(id = 5)
    public final zza zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final zzni zzf;
    @Nullable
    @SafeParcelable.Field(id = 7)
    public final byte[] zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Update(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) int i5, @SafeParcelable.Param(id = 3) Message message, @Nullable @SafeParcelable.Param(id = 4) zze zzeVar, @Nullable @SafeParcelable.Param(id = 5) zza zzaVar, @Nullable @SafeParcelable.Param(id = 6) zzni zzniVar, @Nullable @SafeParcelable.Param(id = 7) byte[] bArr) {
        this.f22416a = i4;
        boolean zzb = zzb(i5, 2);
        this.f22417b = true == zzb ? 2 : i5;
        this.zzc = message;
        this.zzd = true == zzb ? null : zzeVar;
        this.zze = true == zzb ? null : zzaVar;
        this.zzf = true == zzb ? null : zzniVar;
        this.zzg = true == zzb ? null : bArr;
    }

    public static boolean zzb(int i4, int i5) {
        if ((i4 & i5) != 0) {
            return true;
        }
        return false;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Update)) {
            return false;
        }
        Update update = (Update) obj;
        if (this.f22417b != update.f22417b || !Objects.equal(this.zzc, update.zzc) || !Objects.equal(this.zzd, update.zzd) || !Objects.equal(this.zze, update.zze) || !Objects.equal(this.zzf, update.zzf) || !Arrays.equals(this.zzg, update.zzg)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f22417b), this.zzc, this.zzd, this.zze, this.zzf, this.zzg);
    }

    @NonNull
    public final String toString() {
        ArraySet arraySet = new ArraySet();
        if (zzb(this.f22417b, 1)) {
            arraySet.add("FOUND");
        }
        if (zzb(this.f22417b, 2)) {
            arraySet.add("LOST");
        }
        if (zzb(this.f22417b, 4)) {
            arraySet.add("DISTANCE");
        }
        if (zzb(this.f22417b, 8)) {
            arraySet.add("BLE_SIGNAL");
        }
        if (zzb(this.f22417b, 16)) {
            arraySet.add("DEVICE");
        }
        if (zzb(this.f22417b, 32)) {
            arraySet.add("BLE_RECORD");
        }
        String obj = arraySet.toString();
        String valueOf = String.valueOf(this.zzc);
        String valueOf2 = String.valueOf(this.zzd);
        String valueOf3 = String.valueOf(this.zze);
        String valueOf4 = String.valueOf(this.zzf);
        String valueOf5 = String.valueOf(zznh.zza(this.zzg));
        return "Update{types=" + obj + ", message=" + valueOf + ", distance=" + valueOf2 + ", bleSignal=" + valueOf3 + ", device=" + valueOf4 + ", bleRecord=" + valueOf5 + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22416a);
        SafeParcelWriter.writeInt(parcel, 2, this.f22417b);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzc, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zze, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i4, false);
        SafeParcelWriter.writeByteArray(parcel, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final boolean zza(int i4) {
        return zzb(this.f22417b, i4);
    }
}
