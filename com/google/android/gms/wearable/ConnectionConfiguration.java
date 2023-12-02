package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
@ShowFirstParty
@SafeParcelable.Class(creator = "ConnectionConfigurationCreator")
@SafeParcelable.Reserved({1})
/* loaded from: classes4.dex */
public class ConnectionConfiguration extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<ConnectionConfiguration> CREATOR = new zzd();
    @Nullable
    @SafeParcelable.Field(getter = "getName", id = 2)

    /* renamed from: a  reason: collision with root package name */
    private final String f22618a;
    @Nullable
    @SafeParcelable.Field(getter = "getAddress", id = 3)

    /* renamed from: b  reason: collision with root package name */
    private final String f22619b;
    @SafeParcelable.Field(getter = "getType", id = 4)

    /* renamed from: c  reason: collision with root package name */
    private final int f22620c;
    @SafeParcelable.Field(getter = "getRole", id = 5)

    /* renamed from: d  reason: collision with root package name */
    private final int f22621d;
    @SafeParcelable.Field(getter = "isEnabled", id = 6)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f22622e;
    @SafeParcelable.Field(getter = "isConnected", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f22623f;
    @Nullable
    @SafeParcelable.Field(getter = "getPeerNodeId", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private volatile String f22624g;
    @SafeParcelable.Field(getter = "getBtlePriority", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f22625h;
    @Nullable
    @SafeParcelable.Field(getter = "getNodeId", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private String f22626i;
    @Nullable
    @SafeParcelable.Field(getter = "getPackageName", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private String f22627j;
    @SafeParcelable.Field(getter = "getConnectionRetryStrategy", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private int f22628k;
    @Nullable
    @SafeParcelable.Field(getter = "getAllowedConfigPackages", id = 13)

    /* renamed from: l  reason: collision with root package name */
    private List f22629l;

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ConnectionConfiguration(@Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) String str2, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) int i5, @SafeParcelable.Param(id = 6) boolean z3, @SafeParcelable.Param(id = 7) boolean z4, @Nullable @SafeParcelable.Param(id = 8) String str3, @SafeParcelable.Param(id = 9) boolean z5, @Nullable @SafeParcelable.Param(id = 10) String str4, @Nullable @SafeParcelable.Param(id = 11) String str5, @SafeParcelable.Param(id = 12) int i6, @Nullable @SafeParcelable.Param(id = 13) List list) {
        this.f22618a = str;
        this.f22619b = str2;
        this.f22620c = i4;
        this.f22621d = i5;
        this.f22622e = z3;
        this.f22623f = z4;
        this.f22624g = str3;
        this.f22625h = z5;
        this.f22626i = str4;
        this.f22627j = str5;
        this.f22628k = i6;
        this.f22629l = list;
    }

    public final boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        if (!Objects.equal(this.f22618a, connectionConfiguration.f22618a) || !Objects.equal(this.f22619b, connectionConfiguration.f22619b) || !Objects.equal(Integer.valueOf(this.f22620c), Integer.valueOf(connectionConfiguration.f22620c)) || !Objects.equal(Integer.valueOf(this.f22621d), Integer.valueOf(connectionConfiguration.f22621d)) || !Objects.equal(Boolean.valueOf(this.f22622e), Boolean.valueOf(connectionConfiguration.f22622e)) || !Objects.equal(Boolean.valueOf(this.f22625h), Boolean.valueOf(connectionConfiguration.f22625h))) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return Objects.hashCode(this.f22618a, this.f22619b, Integer.valueOf(this.f22620c), Integer.valueOf(this.f22621d), Boolean.valueOf(this.f22622e), Boolean.valueOf(this.f22625h));
    }

    @NonNull
    public final String toString() {
        return "ConnectionConfiguration[ Name=" + this.f22618a + ", Address=" + this.f22619b + ", Type=" + this.f22620c + ", Role=" + this.f22621d + ", Enabled=" + this.f22622e + ", IsConnected=" + this.f22623f + ", PeerNodeId=" + this.f22624g + ", BtlePriority=" + this.f22625h + ", NodeId=" + this.f22626i + ", PackageName=" + this.f22627j + ", ConnectionRetryStrategy=" + this.f22628k + ", allowedConfigPackages=" + this.f22629l + "]";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.f22618a, false);
        SafeParcelWriter.writeString(parcel, 3, this.f22619b, false);
        SafeParcelWriter.writeInt(parcel, 4, this.f22620c);
        SafeParcelWriter.writeInt(parcel, 5, this.f22621d);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f22622e);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f22623f);
        SafeParcelWriter.writeString(parcel, 8, this.f22624g, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f22625h);
        SafeParcelWriter.writeString(parcel, 10, this.f22626i, false);
        SafeParcelWriter.writeString(parcel, 11, this.f22627j, false);
        SafeParcelWriter.writeInt(parcel, 12, this.f22628k);
        SafeParcelWriter.writeStringList(parcel, 13, this.f22629l, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
