package com.google.android.gms.nearby.messages.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ClientAppContextCreator")
/* loaded from: classes4.dex */
public final class ClientAppContext extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<ClientAppContext> CREATOR = new zzd();
    @SafeParcelable.VersionField(id = 1)

    /* renamed from: a  reason: collision with root package name */
    final int f22414a;
    @NonNull
    @SafeParcelable.Field(id = 2)
    public final String zzb;
    @Nullable
    @SafeParcelable.Field(id = 3)
    public final String zzc;
    @SafeParcelable.Field(id = 4)
    public final boolean zzd;
    @SafeParcelable.Field(id = 5)
    @Deprecated
    public final int zze;
    @Nullable
    @SafeParcelable.Field(id = 6)
    public final String zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ClientAppContext(@SafeParcelable.Param(id = 1) int i4, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) int i5, @Nullable @SafeParcelable.Param(id = 6) String str3) {
        this.f22414a = i4;
        this.zzb = (String) Preconditions.checkNotNull(str);
        if (str2 != null && !str2.isEmpty() && !str2.startsWith("0p:")) {
            Log.w("NearbyMessages", String.format(Locale.US, "ClientAppContext: 0P identifier(%s) without 0P prefix(%s)", str2, "0p:"));
            str2 = "0p:".concat(str2);
        }
        this.zzc = str2;
        this.zzd = z3;
        this.zze = i5;
        this.zzf = str3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static final ClientAppContext b(@Nullable ClientAppContext clientAppContext, @Nullable String str, @Nullable String str2, boolean z3) {
        if (clientAppContext != null) {
            return clientAppContext;
        }
        if (str == null && str2 == null) {
            return null;
        }
        return new ClientAppContext(1, str, str2, z3, 0, null);
    }

    private static boolean c(@Nullable String str, @Nullable String str2) {
        if (TextUtils.isEmpty(str)) {
            return TextUtils.isEmpty(str2);
        }
        return str.equals(str2);
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ClientAppContext)) {
            return false;
        }
        ClientAppContext clientAppContext = (ClientAppContext) obj;
        if (!c(this.zzb, clientAppContext.zzb) || !c(this.zzc, clientAppContext.zzc) || this.zzd != clientAppContext.zzd || !c(this.zzf, clientAppContext.zzf) || this.zze != clientAppContext.zze) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zzf, Integer.valueOf(this.zze));
    }

    @NonNull
    public final String toString() {
        return String.format(Locale.US, "{realClientPackageName: %s, zeroPartyIdentifier: %s, useRealClientApiKey: %b, apiKey: %s, callingContext: %d}", this.zzb, this.zzc, Boolean.valueOf(this.zzd), this.zzf, Integer.valueOf(this.zze));
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.f22414a);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeInt(parcel, 5, this.zze);
        SafeParcelWriter.writeString(parcel, 6, this.zzf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
