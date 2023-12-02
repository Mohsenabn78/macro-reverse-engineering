package com.google.android.gms.nearby.connection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "ConnectionOptionsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class ConnectionOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ConnectionOptions> CREATOR = new zzn();
    @SafeParcelable.Field(defaultValue = "false", getter = "getLowPower", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private boolean f22152a;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBluetooth", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private boolean f22153b;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBle", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private boolean f22154c;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiLan", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private boolean f22155d;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableNfc", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private boolean f22156e;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiAware", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private boolean f22157f;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiHotspot", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private boolean f22158g;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiDirect", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private boolean f22159h;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getRemoteBluetoothMacAddress", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private byte[] f22160i;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableWebRtc", id = 10)

    /* renamed from: j  reason: collision with root package name */
    private boolean f22161j;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnforceTopologyConstraints", id = 11)

    /* renamed from: k  reason: collision with root package name */
    private boolean f22162k;
    @SafeParcelable.Field(defaultValue = "true", getter = "getDisruptiveUpgrade", id = 12)
    @Deprecated

    /* renamed from: l  reason: collision with root package name */
    private boolean f22163l;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getKeepAliveIntervalMillis", id = 13)

    /* renamed from: m  reason: collision with root package name */
    private int f22164m;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getKeepAliveTimeoutMillis", id = 14)

    /* renamed from: n  reason: collision with root package name */
    private int f22165n;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getUpgradeMediums", id = 15)

    /* renamed from: o  reason: collision with root package name */
    private int[] f22166o;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getConnectionMediums", id = 16)

    /* renamed from: p  reason: collision with root package name */
    private int[] f22167p;
    @Nullable
    @SafeParcelable.Field(getter = "getDeviceInfo", id = 17)

    /* renamed from: q  reason: collision with root package name */
    private byte[] f22168q;
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getStrategy", id = 18)

    /* renamed from: r  reason: collision with root package name */
    private Strategy f22169r;
    @SafeParcelable.Field(defaultValue = "0", getter = "getConnectionType", id = 19)

    /* renamed from: s  reason: collision with root package name */
    private int f22170s;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getFlowId", id = 20)

    /* renamed from: t  reason: collision with root package name */
    private long f22171t;
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableV3Options", id = 21)

    /* renamed from: u  reason: collision with root package name */
    private boolean f22172u;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowBluetoothRadioToggling", id = 22)

    /* renamed from: v  reason: collision with root package name */
    private boolean f22173v;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowWifiRadioToggling", id = 23)

    /* renamed from: w  reason: collision with root package name */
    private boolean f22174w;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Reserved({1000})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final ConnectionOptions f22175a;

        public Builder() {
            this.f22175a = new ConnectionOptions(null);
        }

        @NonNull
        public ConnectionOptions build() {
            ConnectionOptions.d(this.f22175a);
            if (this.f22175a.f22170s == 0) {
                if (!this.f22175a.f22163l) {
                    this.f22175a.f22170s = 2;
                }
            } else {
                ConnectionOptions connectionOptions = this.f22175a;
                boolean z3 = true;
                if (connectionOptions.f22170s != 1) {
                    z3 = false;
                }
                connectionOptions.f22163l = z3;
            }
            return this.f22175a;
        }

        @NonNull
        public Builder setConnectionType(int i4) {
            this.f22175a.f22170s = i4;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setDisruptiveUpgrade(boolean z3) {
            this.f22175a.f22163l = z3;
            return this;
        }

        @NonNull
        public Builder setLowPower(boolean z3) {
            this.f22175a.f22152a = z3;
            return this;
        }

        public Builder(@NonNull ConnectionOptions connectionOptions) {
            ConnectionOptions connectionOptions2 = new ConnectionOptions(null);
            this.f22175a = connectionOptions2;
            connectionOptions2.f22152a = connectionOptions.f22152a;
            connectionOptions2.f22153b = connectionOptions.f22153b;
            connectionOptions2.f22154c = connectionOptions.f22154c;
            connectionOptions2.f22155d = connectionOptions.f22155d;
            connectionOptions2.f22156e = connectionOptions.f22156e;
            connectionOptions2.f22157f = connectionOptions.f22157f;
            connectionOptions2.f22158g = connectionOptions.f22158g;
            connectionOptions2.f22159h = connectionOptions.f22159h;
            connectionOptions2.f22160i = connectionOptions.f22160i;
            connectionOptions2.f22161j = connectionOptions.f22161j;
            connectionOptions2.f22162k = connectionOptions.f22162k;
            connectionOptions2.f22163l = connectionOptions.f22163l;
            connectionOptions2.f22164m = connectionOptions.f22164m;
            connectionOptions2.f22165n = connectionOptions.f22165n;
            connectionOptions2.f22166o = connectionOptions.f22166o;
            connectionOptions2.f22167p = connectionOptions.f22167p;
            connectionOptions2.f22168q = connectionOptions.f22168q;
            connectionOptions2.f22169r = connectionOptions.f22169r;
            connectionOptions2.f22170s = connectionOptions.f22170s;
            connectionOptions2.f22171t = connectionOptions.f22171t;
            connectionOptions2.f22172u = connectionOptions.f22172u;
            connectionOptions2.f22173v = connectionOptions.f22173v;
            connectionOptions2.f22174w = connectionOptions.f22174w;
        }
    }

    private ConnectionOptions() {
        this.f22152a = false;
        this.f22153b = true;
        this.f22154c = true;
        this.f22155d = true;
        this.f22156e = true;
        this.f22157f = true;
        this.f22158g = true;
        this.f22159h = true;
        this.f22161j = false;
        this.f22162k = true;
        this.f22163l = true;
        this.f22164m = 0;
        this.f22165n = 0;
        this.f22170s = 0;
        this.f22171t = 0L;
        this.f22172u = false;
        this.f22173v = true;
        this.f22174w = true;
    }

    static /* bridge */ /* synthetic */ void d(ConnectionOptions connectionOptions) {
        int[] iArr = connectionOptions.f22167p;
        int[] iArr2 = connectionOptions.f22166o;
        if (iArr != null && iArr.length > 0) {
            connectionOptions.f22154c = false;
            connectionOptions.f22153b = false;
            connectionOptions.f22156e = false;
            if (PlatformVersion.isAtLeastP()) {
                connectionOptions.f22155d = false;
            }
        }
        if (iArr2 != null) {
            connectionOptions.f22158g = false;
            connectionOptions.f22157f = false;
            connectionOptions.f22159h = false;
            if (!PlatformVersion.isAtLeastP()) {
                connectionOptions.f22155d = false;
            }
        }
        if (iArr != null) {
            for (int i4 : iArr) {
                w(i4, connectionOptions);
            }
        }
        if (iArr2 != null) {
            for (int i5 : iArr2) {
                w(i5, connectionOptions);
            }
        }
    }

    private static void w(int i4, ConnectionOptions connectionOptions) {
        switch (i4) {
            case 2:
                connectionOptions.f22153b = true;
                return;
            case 3:
                connectionOptions.f22158g = true;
                return;
            case 4:
                connectionOptions.f22154c = true;
                return;
            case 5:
                connectionOptions.f22155d = true;
                return;
            case 6:
                connectionOptions.f22157f = true;
                return;
            case 7:
                connectionOptions.f22156e = true;
                return;
            case 8:
                connectionOptions.f22159h = true;
                return;
            case 9:
                connectionOptions.f22161j = true;
                return;
            case 10:
            case 11:
                return;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append("Illegal connection medium ");
                sb.append(i4);
                return;
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ConnectionOptions) {
            ConnectionOptions connectionOptions = (ConnectionOptions) obj;
            if (Objects.equal(Boolean.valueOf(this.f22152a), Boolean.valueOf(connectionOptions.f22152a)) && Objects.equal(Boolean.valueOf(this.f22153b), Boolean.valueOf(connectionOptions.f22153b)) && Objects.equal(Boolean.valueOf(this.f22154c), Boolean.valueOf(connectionOptions.f22154c)) && Objects.equal(Boolean.valueOf(this.f22155d), Boolean.valueOf(connectionOptions.f22155d)) && Objects.equal(Boolean.valueOf(this.f22156e), Boolean.valueOf(connectionOptions.f22156e)) && Objects.equal(Boolean.valueOf(this.f22157f), Boolean.valueOf(connectionOptions.f22157f)) && Objects.equal(Boolean.valueOf(this.f22158g), Boolean.valueOf(connectionOptions.f22158g)) && Objects.equal(Boolean.valueOf(this.f22159h), Boolean.valueOf(connectionOptions.f22159h)) && Arrays.equals(this.f22160i, connectionOptions.f22160i) && Objects.equal(Boolean.valueOf(this.f22161j), Boolean.valueOf(connectionOptions.f22161j)) && Objects.equal(Boolean.valueOf(this.f22162k), Boolean.valueOf(connectionOptions.f22162k)) && Objects.equal(Boolean.valueOf(this.f22163l), Boolean.valueOf(connectionOptions.f22163l)) && Objects.equal(Integer.valueOf(this.f22164m), Integer.valueOf(connectionOptions.f22164m)) && Objects.equal(Integer.valueOf(this.f22165n), Integer.valueOf(connectionOptions.f22165n)) && Arrays.equals(this.f22166o, connectionOptions.f22166o) && Arrays.equals(this.f22167p, connectionOptions.f22167p) && Arrays.equals(this.f22168q, connectionOptions.f22168q) && Objects.equal(this.f22169r, connectionOptions.f22169r) && Objects.equal(Integer.valueOf(this.f22170s), Integer.valueOf(connectionOptions.f22170s)) && Objects.equal(Long.valueOf(this.f22171t), Long.valueOf(connectionOptions.f22171t)) && Objects.equal(Boolean.valueOf(this.f22172u), Boolean.valueOf(connectionOptions.f22172u)) && Objects.equal(Boolean.valueOf(this.f22173v), Boolean.valueOf(connectionOptions.f22173v)) && Objects.equal(Boolean.valueOf(this.f22174w), Boolean.valueOf(connectionOptions.f22174w))) {
                return true;
            }
        }
        return false;
    }

    public int getConnectionType() {
        return this.f22170s;
    }

    @Deprecated
    public boolean getDisruptiveUpgrade() {
        return this.f22163l;
    }

    public boolean getLowPower() {
        return this.f22152a;
    }

    public int hashCode() {
        return Objects.hashCode(Boolean.valueOf(this.f22152a), Boolean.valueOf(this.f22153b), Boolean.valueOf(this.f22154c), Boolean.valueOf(this.f22155d), Boolean.valueOf(this.f22156e), Boolean.valueOf(this.f22157f), Boolean.valueOf(this.f22158g), Boolean.valueOf(this.f22159h), Integer.valueOf(Arrays.hashCode(this.f22160i)), Boolean.valueOf(this.f22161j), Boolean.valueOf(this.f22162k), Boolean.valueOf(this.f22163l), Integer.valueOf(this.f22164m), Integer.valueOf(this.f22165n), Integer.valueOf(Arrays.hashCode(this.f22166o)), Integer.valueOf(Arrays.hashCode(this.f22167p)), Integer.valueOf(Arrays.hashCode(this.f22168q)), this.f22169r, Integer.valueOf(this.f22170s), Long.valueOf(this.f22171t), Boolean.valueOf(this.f22172u), Boolean.valueOf(this.f22173v), Boolean.valueOf(this.f22174w));
    }

    @NonNull
    public String toString() {
        String zzb;
        Locale locale = Locale.US;
        Object[] objArr = new Object[16];
        objArr[0] = Boolean.valueOf(this.f22152a);
        objArr[1] = Boolean.valueOf(this.f22153b);
        objArr[2] = Boolean.valueOf(this.f22154c);
        objArr[3] = Boolean.valueOf(this.f22155d);
        objArr[4] = Boolean.valueOf(this.f22156e);
        objArr[5] = Boolean.valueOf(this.f22157f);
        objArr[6] = Boolean.valueOf(this.f22158g);
        objArr[7] = Boolean.valueOf(this.f22159h);
        byte[] bArr = this.f22160i;
        String str = null;
        if (bArr == null) {
            zzb = null;
        } else {
            zzb = com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        }
        objArr[8] = zzb;
        objArr[9] = Boolean.valueOf(this.f22161j);
        objArr[10] = Boolean.valueOf(this.f22162k);
        objArr[11] = Boolean.valueOf(this.f22163l);
        byte[] bArr2 = this.f22168q;
        if (bArr2 != null) {
            str = com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr2);
        }
        objArr[12] = str;
        objArr[13] = this.f22169r;
        objArr[14] = Integer.valueOf(this.f22170s);
        objArr[15] = Long.valueOf(this.f22171t);
        return String.format(locale, "ConnectionOptions{lowPower: %s, enableBluetooth: %s, enableBle: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableWifiHotspot: %s, enableWifiDirect: %s, remoteBluetoothMacAddress: %s, enableWebRtc: %s, enforceTopologyConstraints: %s, disruptiveUpgrade: %s,deviceInfo: %s,strategy: %s,connectionType: %dflowId: %d, }", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, getLowPower());
        SafeParcelWriter.writeBoolean(parcel, 2, this.f22153b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f22154c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22155d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22156e);
        SafeParcelWriter.writeBoolean(parcel, 6, this.f22157f);
        SafeParcelWriter.writeBoolean(parcel, 7, this.f22158g);
        SafeParcelWriter.writeBoolean(parcel, 8, this.f22159h);
        SafeParcelWriter.writeByteArray(parcel, 9, this.f22160i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f22161j);
        SafeParcelWriter.writeBoolean(parcel, 11, this.f22162k);
        SafeParcelWriter.writeBoolean(parcel, 12, getDisruptiveUpgrade());
        SafeParcelWriter.writeInt(parcel, 13, this.f22164m);
        SafeParcelWriter.writeInt(parcel, 14, this.f22165n);
        SafeParcelWriter.writeIntArray(parcel, 15, this.f22166o, false);
        SafeParcelWriter.writeIntArray(parcel, 16, this.f22167p, false);
        SafeParcelWriter.writeByteArray(parcel, 17, this.f22168q, false);
        SafeParcelWriter.writeParcelable(parcel, 18, this.f22169r, i4, false);
        SafeParcelWriter.writeInt(parcel, 19, getConnectionType());
        SafeParcelWriter.writeLong(parcel, 20, this.f22171t);
        SafeParcelWriter.writeBoolean(parcel, 21, this.f22172u);
        SafeParcelWriter.writeBoolean(parcel, 22, this.f22173v);
        SafeParcelWriter.writeBoolean(parcel, 23, this.f22174w);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* synthetic */ ConnectionOptions(zzm zzmVar) {
        this.f22152a = false;
        this.f22153b = true;
        this.f22154c = true;
        this.f22155d = true;
        this.f22156e = true;
        this.f22157f = true;
        this.f22158g = true;
        this.f22159h = true;
        this.f22161j = false;
        this.f22162k = true;
        this.f22163l = true;
        this.f22164m = 0;
        this.f22165n = 0;
        this.f22170s = 0;
        this.f22171t = 0L;
        this.f22172u = false;
        this.f22173v = true;
        this.f22174w = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public ConnectionOptions(@SafeParcelable.Param(id = 1) boolean z3, @SafeParcelable.Param(id = 2) boolean z4, @SafeParcelable.Param(id = 3) boolean z5, @SafeParcelable.Param(id = 4) boolean z6, @SafeParcelable.Param(id = 5) boolean z7, @SafeParcelable.Param(id = 6) boolean z8, @SafeParcelable.Param(id = 7) boolean z9, @SafeParcelable.Param(id = 8) boolean z10, @Nullable @SafeParcelable.Param(id = 9) byte[] bArr, @SafeParcelable.Param(id = 10) boolean z11, @SafeParcelable.Param(id = 11) boolean z12, @SafeParcelable.Param(id = 12) boolean z13, @SafeParcelable.Param(id = 13) int i4, @SafeParcelable.Param(id = 14) int i5, @SafeParcelable.Param(id = 15) int[] iArr, @SafeParcelable.Param(id = 16) int[] iArr2, @Nullable @SafeParcelable.Param(id = 17) byte[] bArr2, @SafeParcelable.Param(id = 18) Strategy strategy, @SafeParcelable.Param(id = 19) int i6, @SafeParcelable.Param(id = 20) long j4, @SafeParcelable.Param(id = 21) boolean z14, @SafeParcelable.Param(id = 22) boolean z15, @SafeParcelable.Param(id = 23) boolean z16) {
        this.f22152a = z3;
        this.f22153b = z4;
        this.f22154c = z5;
        this.f22155d = z6;
        this.f22156e = z7;
        this.f22157f = z8;
        this.f22158g = z9;
        this.f22159h = z10;
        this.f22160i = bArr;
        this.f22161j = z11;
        this.f22162k = z12;
        this.f22163l = z13;
        this.f22164m = i4;
        this.f22165n = i5;
        this.f22166o = iArr;
        this.f22167p = iArr2;
        this.f22168q = bArr2;
        this.f22169r = strategy;
        this.f22170s = i6;
        this.f22171t = j4;
        this.f22172u = z14;
        this.f22173v = z15;
        this.f22174w = z16;
    }
}
