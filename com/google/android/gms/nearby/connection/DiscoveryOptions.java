package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.ParcelUuid;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "DiscoveryOptionsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class DiscoveryOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<DiscoveryOptions> CREATOR = new zzv();
    @SafeParcelable.Field(getter = "getStrategy", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private Strategy f22182a;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getForwardUnrecognizedBluetoothDevices", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private boolean f22183b;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBluetooth", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private boolean f22184c;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBle", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private boolean f22185d;
    @SafeParcelable.Field(defaultValue = "false", getter = "getLowPower", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private boolean f22186e;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getFastAdvertisementServiceUuid", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private ParcelUuid f22187f;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiLan", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private boolean f22188g;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableNfc", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f22189h;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiAware", id = 10)

    /* renamed from: i  reason: collision with root package name */
    private boolean f22190i;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableUwbRanging", id = 11)

    /* renamed from: j  reason: collision with root package name */
    private boolean f22191j;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getUwbChannel", id = 12)

    /* renamed from: k  reason: collision with root package name */
    private int f22192k;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getUwbPreambleIndex", id = 13)

    /* renamed from: l  reason: collision with root package name */
    private int f22193l;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getUwbAddress", id = 14)

    /* renamed from: m  reason: collision with root package name */
    private byte[] f22194m;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getFlowId", id = 15)

    /* renamed from: n  reason: collision with root package name */
    private long f22195n;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getDiscoveryMediums", id = 16)

    /* renamed from: o  reason: collision with root package name */
    private int[] f22196o;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowGattConnections", id = 17)

    /* renamed from: p  reason: collision with root package name */
    private boolean f22197p;
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableV3Options", id = 18)

    /* renamed from: q  reason: collision with root package name */
    private boolean f22198q;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowBluetoothRadioToggling", id = 19)

    /* renamed from: r  reason: collision with root package name */
    private boolean f22199r;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowWifiRadioToggling", id = 20)

    /* renamed from: s  reason: collision with root package name */
    private boolean f22200s;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Reserved({1000})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final DiscoveryOptions f22201a;

        public Builder() {
            this.f22201a = new DiscoveryOptions((zzu) null);
        }

        @NonNull
        public DiscoveryOptions build() {
            int[] iArr = this.f22201a.f22196o;
            if (iArr != null && iArr.length > 0) {
                this.f22201a.f22185d = false;
                this.f22201a.f22184c = false;
                this.f22201a.f22189h = false;
                this.f22201a.f22190i = false;
                this.f22201a.f22188g = false;
                for (int i4 : iArr) {
                    if (i4 == 2) {
                        this.f22201a.f22184c = true;
                    } else if (i4 != 11) {
                        if (i4 == 4) {
                            this.f22201a.f22185d = true;
                        } else if (i4 == 5) {
                            this.f22201a.f22188g = true;
                        } else if (i4 == 6) {
                            this.f22201a.f22190i = true;
                        } else if (i4 == 7) {
                            this.f22201a.f22189h = true;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Illegal discovery medium ");
                            sb.append(i4);
                        }
                    }
                }
            }
            return this.f22201a;
        }

        @NonNull
        public Builder setLowPower(boolean z3) {
            this.f22201a.f22186e = z3;
            return this;
        }

        @NonNull
        public Builder setStrategy(@NonNull Strategy strategy) {
            this.f22201a.f22182a = strategy;
            return this;
        }

        public Builder(@NonNull DiscoveryOptions discoveryOptions) {
            DiscoveryOptions discoveryOptions2 = new DiscoveryOptions((zzu) null);
            this.f22201a = discoveryOptions2;
            discoveryOptions2.f22182a = discoveryOptions.f22182a;
            discoveryOptions2.f22183b = discoveryOptions.f22183b;
            discoveryOptions2.f22184c = discoveryOptions.f22184c;
            discoveryOptions2.f22185d = discoveryOptions.f22185d;
            discoveryOptions2.f22186e = discoveryOptions.f22186e;
            discoveryOptions2.f22187f = discoveryOptions.f22187f;
            discoveryOptions2.f22188g = discoveryOptions.f22188g;
            discoveryOptions2.f22189h = discoveryOptions.f22189h;
            discoveryOptions2.f22190i = discoveryOptions.f22190i;
            discoveryOptions2.f22191j = discoveryOptions.f22191j;
            discoveryOptions2.f22192k = discoveryOptions.f22192k;
            discoveryOptions2.f22193l = discoveryOptions.f22193l;
            discoveryOptions2.f22194m = discoveryOptions.f22194m;
            discoveryOptions2.f22195n = discoveryOptions.f22195n;
            discoveryOptions2.f22196o = discoveryOptions.f22196o;
            discoveryOptions2.f22197p = discoveryOptions.f22197p;
            discoveryOptions2.f22198q = discoveryOptions.f22198q;
            discoveryOptions2.f22199r = discoveryOptions.f22199r;
            discoveryOptions2.f22200s = discoveryOptions.f22200s;
        }
    }

    private DiscoveryOptions() {
        this.f22183b = false;
        this.f22184c = true;
        this.f22185d = true;
        this.f22186e = false;
        this.f22188g = true;
        this.f22189h = true;
        this.f22190i = true;
        this.f22191j = false;
        this.f22192k = 0;
        this.f22193l = 0;
        this.f22195n = 0L;
        this.f22197p = true;
        this.f22198q = false;
        this.f22199r = true;
        this.f22200s = true;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DiscoveryOptions) {
            DiscoveryOptions discoveryOptions = (DiscoveryOptions) obj;
            if (Objects.equal(this.f22182a, discoveryOptions.f22182a) && Objects.equal(Boolean.valueOf(this.f22183b), Boolean.valueOf(discoveryOptions.f22183b)) && Objects.equal(Boolean.valueOf(this.f22184c), Boolean.valueOf(discoveryOptions.f22184c)) && Objects.equal(Boolean.valueOf(this.f22185d), Boolean.valueOf(discoveryOptions.f22185d)) && Objects.equal(Boolean.valueOf(this.f22186e), Boolean.valueOf(discoveryOptions.f22186e)) && Objects.equal(this.f22187f, discoveryOptions.f22187f) && Objects.equal(Boolean.valueOf(this.f22188g), Boolean.valueOf(discoveryOptions.f22188g)) && Objects.equal(Boolean.valueOf(this.f22189h), Boolean.valueOf(discoveryOptions.f22189h)) && Objects.equal(Boolean.valueOf(this.f22190i), Boolean.valueOf(discoveryOptions.f22190i)) && Objects.equal(Boolean.valueOf(this.f22191j), Boolean.valueOf(discoveryOptions.f22191j)) && Objects.equal(Integer.valueOf(this.f22192k), Integer.valueOf(discoveryOptions.f22192k)) && Objects.equal(Integer.valueOf(this.f22193l), Integer.valueOf(discoveryOptions.f22193l)) && Arrays.equals(this.f22194m, discoveryOptions.f22194m) && Objects.equal(Long.valueOf(this.f22195n), Long.valueOf(discoveryOptions.f22195n)) && Arrays.equals(this.f22196o, discoveryOptions.f22196o) && Objects.equal(Boolean.valueOf(this.f22197p), Boolean.valueOf(discoveryOptions.f22197p)) && Objects.equal(Boolean.valueOf(this.f22198q), Boolean.valueOf(discoveryOptions.f22198q)) && Objects.equal(Boolean.valueOf(this.f22199r), Boolean.valueOf(discoveryOptions.f22199r)) && Objects.equal(Boolean.valueOf(this.f22200s), Boolean.valueOf(discoveryOptions.f22200s))) {
                return true;
            }
        }
        return false;
    }

    public boolean getLowPower() {
        return this.f22186e;
    }

    @NonNull
    public Strategy getStrategy() {
        return this.f22182a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22182a, Boolean.valueOf(this.f22183b), Boolean.valueOf(this.f22184c), Boolean.valueOf(this.f22185d), Boolean.valueOf(this.f22186e), this.f22187f, Boolean.valueOf(this.f22188g), Boolean.valueOf(this.f22189h), Boolean.valueOf(this.f22190i), Boolean.valueOf(this.f22191j), Integer.valueOf(this.f22192k), Integer.valueOf(this.f22193l), Integer.valueOf(Arrays.hashCode(this.f22194m)), Long.valueOf(this.f22195n), Integer.valueOf(Arrays.hashCode(this.f22196o)), Boolean.valueOf(this.f22197p), Boolean.valueOf(this.f22198q), Boolean.valueOf(this.f22199r), Boolean.valueOf(this.f22200s));
    }

    @NonNull
    public String toString() {
        String zzb;
        Locale locale = Locale.US;
        Object[] objArr = new Object[15];
        objArr[0] = this.f22182a;
        objArr[1] = Boolean.valueOf(this.f22183b);
        objArr[2] = Boolean.valueOf(this.f22184c);
        objArr[3] = Boolean.valueOf(this.f22185d);
        objArr[4] = Boolean.valueOf(this.f22186e);
        objArr[5] = this.f22187f;
        objArr[6] = Boolean.valueOf(this.f22188g);
        objArr[7] = Boolean.valueOf(this.f22189h);
        objArr[8] = Boolean.valueOf(this.f22190i);
        objArr[9] = Boolean.valueOf(this.f22191j);
        objArr[10] = Integer.valueOf(this.f22192k);
        objArr[11] = Integer.valueOf(this.f22193l);
        byte[] bArr = this.f22194m;
        if (bArr == null) {
            zzb = "null";
        } else {
            zzb = com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        }
        objArr[12] = zzb;
        objArr[13] = Long.valueOf(this.f22195n);
        objArr[14] = Boolean.valueOf(this.f22197p);
        return String.format(locale, "DiscoveryOptions{strategy: %s, forwardUnrecognizedBluetoothDevices: %s, enableBluetooth: %s, enableBle: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, uwbAddress: %s, flowId: %d, allowGattConnections: %s}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i4, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f22183b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f22184c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22185d);
        SafeParcelWriter.writeBoolean(parcel, 5, getLowPower());
        SafeParcelWriter.writeParcelable(parcel, 6, this.f22187f, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f22188g);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f22189h);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f22190i);
        SafeParcelWriter.writeBoolean(parcel, 11, this.f22191j);
        SafeParcelWriter.writeInt(parcel, 12, this.f22192k);
        SafeParcelWriter.writeInt(parcel, 13, this.f22193l);
        SafeParcelWriter.writeByteArray(parcel, 14, this.f22194m, false);
        SafeParcelWriter.writeLong(parcel, 15, this.f22195n);
        SafeParcelWriter.writeIntArray(parcel, 16, this.f22196o, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.f22197p);
        SafeParcelWriter.writeBoolean(parcel, 18, this.f22198q);
        SafeParcelWriter.writeBoolean(parcel, 19, this.f22199r);
        SafeParcelWriter.writeBoolean(parcel, 20, this.f22200s);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    public final boolean zzK() {
        return this.f22189h;
    }

    /* synthetic */ DiscoveryOptions(zzu zzuVar) {
        this.f22183b = false;
        this.f22184c = true;
        this.f22185d = true;
        this.f22186e = false;
        this.f22188g = true;
        this.f22189h = true;
        this.f22190i = true;
        this.f22191j = false;
        this.f22192k = 0;
        this.f22193l = 0;
        this.f22195n = 0L;
        this.f22197p = true;
        this.f22198q = false;
        this.f22199r = true;
        this.f22200s = true;
    }

    @Deprecated
    public DiscoveryOptions(@NonNull Strategy strategy) {
        this.f22183b = false;
        this.f22184c = true;
        this.f22185d = true;
        this.f22186e = false;
        this.f22188g = true;
        this.f22189h = true;
        this.f22190i = true;
        this.f22191j = false;
        this.f22192k = 0;
        this.f22193l = 0;
        this.f22195n = 0L;
        this.f22197p = true;
        this.f22198q = false;
        this.f22199r = true;
        this.f22200s = true;
        this.f22182a = strategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DiscoveryOptions(@SafeParcelable.Param(id = 1) Strategy strategy, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) boolean z4, @SafeParcelable.Param(id = 4) boolean z5, @SafeParcelable.Param(id = 5) boolean z6, @Nullable @SafeParcelable.Param(id = 6) ParcelUuid parcelUuid, @SafeParcelable.Param(id = 8) boolean z7, @SafeParcelable.Param(id = 9) boolean z8, @SafeParcelable.Param(id = 10) boolean z9, @SafeParcelable.Param(id = 11) boolean z10, @SafeParcelable.Param(id = 12) int i4, @SafeParcelable.Param(id = 13) int i5, @Nullable @SafeParcelable.Param(id = 14) byte[] bArr, @SafeParcelable.Param(id = 15) long j4, @SafeParcelable.Param(id = 16) int[] iArr, @SafeParcelable.Param(id = 17) boolean z11, @SafeParcelable.Param(id = 18) boolean z12, @SafeParcelable.Param(id = 19) boolean z13, @SafeParcelable.Param(id = 20) boolean z14) {
        this.f22182a = strategy;
        this.f22183b = z3;
        this.f22184c = z4;
        this.f22185d = z5;
        this.f22186e = z6;
        this.f22187f = parcelUuid;
        this.f22188g = z7;
        this.f22189h = z8;
        this.f22190i = z9;
        this.f22191j = z10;
        this.f22192k = i4;
        this.f22193l = i5;
        this.f22194m = bArr;
        this.f22195n = j4;
        this.f22196o = iArr;
        this.f22197p = z11;
        this.f22198q = z12;
        this.f22199r = z13;
        this.f22200s = z14;
    }
}
