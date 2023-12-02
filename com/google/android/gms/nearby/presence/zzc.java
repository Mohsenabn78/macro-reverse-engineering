package com.google.android.gms.nearby.presence;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@ShowFirstParty
@RequiresApi(26)
@SafeParcelable.Class(creator = "DataElementCollectionCreator")
/* loaded from: classes4.dex */
public final class zzc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzc> CREATOR = new zzd();
    @Nullable
    @SafeParcelable.Field(getter = "getSequenceNumber", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final zzk f22480a;
    @Nullable
    @SafeParcelable.Field(getter = "getCastIdentity", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final zza f22481b;
    @Nullable
    @SafeParcelable.Field(getter = "getDeduplicationHintBytes", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final byte[] f22482c;
    @SafeParcelable.Field(getter = "getDeduplicationHintEnabled", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final boolean f22483d;
    @SafeParcelable.Field(getter = "getBleGattConnectivityInfoList", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final List f22484e;
    @SafeParcelable.Field(getter = "getWifiLanConnectivityInfoList", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private final List f22485f;
    @SafeParcelable.Field(getter = "getBluetoothConnectivityInfoList", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private final List f22486g;
    @SafeParcelable.Field(getter = "getUwbConnectivityCapability", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private final zzm f22487h;
    @Nullable
    @SafeParcelable.Field(getter = "getDeviceType", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final zze f22488i;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public zzc(@SafeParcelable.Param(id = 1) zzk zzkVar, @SafeParcelable.Param(id = 2) zza zzaVar, @SafeParcelable.Param(id = 3) byte[] bArr, @SafeParcelable.Param(id = 4) boolean z3, @SafeParcelable.Param(id = 5) List list, @SafeParcelable.Param(id = 6) List list2, @SafeParcelable.Param(id = 7) List list3, @SafeParcelable.Param(id = 8) zzm zzmVar, @Nullable @SafeParcelable.Param(id = 9) zze zzeVar) {
        this.f22480a = zzkVar;
        this.f22481b = zzaVar;
        this.f22482c = bArr;
        this.f22483d = z3;
        this.f22484e = list;
        this.f22485f = list2;
        this.f22486g = list3;
        this.f22487h = zzmVar;
        this.f22488i = zzeVar;
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj instanceof zzc) {
            zzc zzcVar = (zzc) obj;
            if (Objects.equal(this.f22480a, zzcVar.f22480a) && Objects.equal(this.f22481b, zzcVar.f22481b) && Arrays.equals(this.f22482c, zzcVar.f22482c) && this.f22483d == zzcVar.f22483d && Objects.equal(this.f22484e, zzcVar.f22484e) && Objects.equal(this.f22485f, zzcVar.f22485f) && Objects.equal(this.f22486g, zzcVar.f22486g) && Objects.equal(this.f22487h, zzcVar.f22487h) && Objects.equal(this.f22488i, zzcVar.f22488i)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22480a, this.f22481b, Boolean.valueOf(this.f22483d), this.f22484e, this.f22485f, this.f22486g, this.f22487h, this.f22488i);
    }

    public final String toString() {
        return String.format(Locale.US, "<DataElementCollection: sequenceNumber=%s, castId=%s, deduplicationHint=%s, deduplicationHintEnabled=%s, bleGattConnectivityInfo = %s, wifiLanConnectivityInfoList = %s, bluetoothConnectivityInfoList = %s, connectivityCapability = %s, deviceType = %s>", this.f22480a, this.f22481b, Arrays.toString(this.f22482c), Boolean.valueOf(this.f22483d), this.f22484e, this.f22485f, this.f22486g, this.f22487h, this.f22488i);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.f22480a, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.f22481b, i4, false);
        SafeParcelWriter.writeByteArray(parcel, 3, this.f22482c, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22483d);
        SafeParcelWriter.writeTypedList(parcel, 5, this.f22484e, false);
        SafeParcelWriter.writeTypedList(parcel, 6, this.f22485f, false);
        SafeParcelWriter.writeTypedList(parcel, 7, this.f22486g, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.f22487h, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f22488i, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
