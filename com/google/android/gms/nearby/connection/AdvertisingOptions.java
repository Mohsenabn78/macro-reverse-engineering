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
@SafeParcelable.Class(creator = "AdvertisingOptionsCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class AdvertisingOptions extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<AdvertisingOptions> CREATOR = new zzb();
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getPowerLevel", id = 27)
    private int A;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getDeviceInfo", id = 28)
    private byte[] B;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowGattConnections", id = 29)
    private boolean C;
    @SafeParcelable.Field(defaultValue = "0", getter = "getConnectionType", id = 30)
    private int D;
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableV3Options", id = 31)
    private boolean E;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowBluetoothRadioToggling", id = 32)
    private boolean F;
    @SafeParcelable.Field(defaultValue = "true", getter = "getAllowWifiRadioToggling", id = 33)
    private boolean G;
    @SafeParcelable.Field(getter = "getStrategy", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private Strategy f22115a;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getAutoUpgradeBandwidth", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private boolean f22116b;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnforceTopologyConstraints", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private boolean f22117c;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBluetooth", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private boolean f22118d;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableBle", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private boolean f22119e;
    @Nullable
    @SafeParcelable.Field(getter = "getNearbyNotificationsBeaconData", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private byte[] f22120f;
    @SafeParcelable.Field(defaultValue = "false", getter = "getLowPower", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private boolean f22121g;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getFastAdvertisementServiceUuid", id = 8)

    /* renamed from: h  reason: collision with root package name */
    private ParcelUuid f22122h;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiLan", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private boolean f22123i;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableNfc", id = 10)

    /* renamed from: j  reason: collision with root package name */
    private boolean f22124j;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableWifiAware", id = 11)

    /* renamed from: k  reason: collision with root package name */
    private boolean f22125k;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableBluetoothListening", id = 12)

    /* renamed from: l  reason: collision with root package name */
    private boolean f22126l;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableWebRtcListening", id = 13)

    /* renamed from: m  reason: collision with root package name */
    private boolean f22127m;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableUwbRanging", id = 14)

    /* renamed from: n  reason: collision with root package name */
    private boolean f22128n;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getUwbChannel", id = 15)

    /* renamed from: o  reason: collision with root package name */
    private int f22129o;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getUwbPreambleIndex", id = 16)

    /* renamed from: p  reason: collision with root package name */
    private int f22130p;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getRemoteUwbAddress", id = 17)

    /* renamed from: q  reason: collision with root package name */
    private byte[] f22131q;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "0", getter = "getFlowId", id = 18)

    /* renamed from: r  reason: collision with root package name */
    private long f22132r;
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getUwbSenderInfo", id = 19)

    /* renamed from: s  reason: collision with root package name */
    private zzab[] f22133s;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableOutOfBandConnection", id = 20)

    /* renamed from: t  reason: collision with root package name */
    private boolean f22134t;
    @SafeParcelable.Field(defaultValue = "true", getter = "getDisruptiveUpgrade", id = 21)
    @Deprecated

    /* renamed from: u  reason: collision with root package name */
    private boolean f22135u;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "false", getter = "getEnableWebRtcUpgrade", id = 22)

    /* renamed from: v  reason: collision with root package name */
    private boolean f22136v;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getUseStableIdentifiers", id = 23)

    /* renamed from: w  reason: collision with root package name */
    private boolean f22137w;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getAdvertisingMediums", id = 24)

    /* renamed from: x  reason: collision with root package name */
    private int[] f22138x;
    @Nullable
    @ShowFirstParty
    @SafeParcelable.Field(getter = "getUpgradeMediums", id = 25)

    /* renamed from: y  reason: collision with root package name */
    private int[] f22139y;
    @ShowFirstParty
    @SafeParcelable.Field(defaultValue = "true", getter = "getEnableUpgradeMediumsRankingOptimization", id = 26)

    /* renamed from: z  reason: collision with root package name */
    private boolean f22140z;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Reserved({1000})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final AdvertisingOptions f22141a;

        public Builder() {
            this.f22141a = new AdvertisingOptions((zza) null);
        }

        @NonNull
        public AdvertisingOptions build() {
            boolean z3;
            int[] iArr = this.f22141a.f22138x;
            boolean z4 = false;
            if (iArr != null && iArr.length > 0) {
                this.f22141a.f22119e = false;
                this.f22141a.f22118d = false;
                this.f22141a.f22124j = false;
                this.f22141a.f22125k = false;
                this.f22141a.f22123i = false;
                this.f22141a.f22127m = false;
                for (int i4 : iArr) {
                    if (i4 == 2) {
                        this.f22141a.f22118d = true;
                    } else if (i4 == 9) {
                        this.f22141a.f22127m = true;
                    } else if (i4 != 11) {
                        if (i4 == 4) {
                            this.f22141a.f22119e = true;
                        } else if (i4 == 5) {
                            this.f22141a.f22123i = true;
                        } else if (i4 == 6) {
                            this.f22141a.f22125k = true;
                        } else if (i4 == 7) {
                            this.f22141a.f22124j = true;
                        } else {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Illegal advertising medium ");
                            sb.append(i4);
                        }
                    }
                }
            }
            if (this.f22141a.f22139y != null && this.f22141a.f22139y.length > 0) {
                this.f22141a.f22136v = false;
                int i5 = 0;
                while (true) {
                    if (i5 >= this.f22141a.f22139y.length) {
                        break;
                    } else if (this.f22141a.f22139y[i5] == 9) {
                        this.f22141a.f22136v = true;
                        break;
                    } else {
                        i5++;
                    }
                }
            }
            int i6 = 3;
            if (this.f22141a.A == 0) {
                AdvertisingOptions advertisingOptions = this.f22141a;
                if (true == advertisingOptions.f22121g) {
                    i6 = 1;
                }
                advertisingOptions.A = i6;
            } else {
                AdvertisingOptions advertisingOptions2 = this.f22141a;
                if (advertisingOptions2.A != 3) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                advertisingOptions2.f22121g = z3;
            }
            if (this.f22141a.D == 0) {
                if (!this.f22141a.f22135u) {
                    this.f22141a.D = 2;
                }
            } else {
                AdvertisingOptions advertisingOptions3 = this.f22141a;
                if (advertisingOptions3.D == 1) {
                    z4 = true;
                }
                advertisingOptions3.f22135u = z4;
            }
            return this.f22141a;
        }

        @NonNull
        public Builder setConnectionType(int i4) {
            this.f22141a.D = i4;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder setDisruptiveUpgrade(boolean z3) {
            this.f22141a.f22135u = z3;
            return this;
        }

        @NonNull
        public Builder setLowPower(boolean z3) {
            this.f22141a.f22121g = z3;
            return this;
        }

        @NonNull
        public Builder setStrategy(@NonNull Strategy strategy) {
            this.f22141a.f22115a = strategy;
            return this;
        }

        public Builder(@NonNull AdvertisingOptions advertisingOptions) {
            AdvertisingOptions advertisingOptions2 = new AdvertisingOptions((zza) null);
            this.f22141a = advertisingOptions2;
            advertisingOptions2.f22115a = advertisingOptions.f22115a;
            advertisingOptions2.f22116b = advertisingOptions.f22116b;
            advertisingOptions2.f22117c = advertisingOptions.f22117c;
            advertisingOptions2.f22118d = advertisingOptions.f22118d;
            advertisingOptions2.f22119e = advertisingOptions.f22119e;
            advertisingOptions2.f22120f = advertisingOptions.f22120f;
            advertisingOptions2.f22121g = advertisingOptions.f22121g;
            advertisingOptions2.f22122h = advertisingOptions.f22122h;
            advertisingOptions2.f22123i = advertisingOptions.f22123i;
            advertisingOptions2.f22124j = advertisingOptions.f22124j;
            advertisingOptions2.f22125k = advertisingOptions.f22125k;
            advertisingOptions2.f22126l = advertisingOptions.f22126l;
            advertisingOptions2.f22127m = advertisingOptions.f22127m;
            advertisingOptions2.f22128n = advertisingOptions.f22128n;
            advertisingOptions2.f22129o = advertisingOptions.f22129o;
            advertisingOptions2.f22130p = advertisingOptions.f22130p;
            advertisingOptions2.f22131q = advertisingOptions.f22131q;
            advertisingOptions2.f22132r = advertisingOptions.f22132r;
            advertisingOptions2.f22133s = advertisingOptions.f22133s;
            advertisingOptions2.f22134t = advertisingOptions.f22134t;
            advertisingOptions2.f22135u = advertisingOptions.f22135u;
            advertisingOptions2.f22136v = advertisingOptions.f22136v;
            advertisingOptions2.f22137w = advertisingOptions.f22137w;
            advertisingOptions2.f22138x = advertisingOptions.f22138x;
            advertisingOptions2.f22139y = advertisingOptions.f22139y;
            advertisingOptions2.f22140z = advertisingOptions.f22140z;
            advertisingOptions2.A = advertisingOptions.A;
            advertisingOptions2.B = advertisingOptions.B;
            advertisingOptions2.C = advertisingOptions.C;
            advertisingOptions2.D = advertisingOptions.D;
            AdvertisingOptions.C(advertisingOptions);
            advertisingOptions2.E = false;
            advertisingOptions2.F = advertisingOptions.F;
            advertisingOptions2.G = advertisingOptions.G;
        }
    }

    private AdvertisingOptions() {
        this.f22116b = true;
        this.f22117c = true;
        this.f22118d = true;
        this.f22119e = true;
        this.f22121g = false;
        this.f22123i = true;
        this.f22124j = true;
        this.f22125k = true;
        this.f22126l = false;
        this.f22127m = false;
        this.f22128n = false;
        this.f22129o = 0;
        this.f22130p = 0;
        this.f22132r = 0L;
        this.f22134t = false;
        this.f22135u = true;
        this.f22136v = false;
        this.f22137w = true;
        this.f22140z = true;
        this.A = 0;
        this.C = true;
        this.D = 0;
        this.E = false;
        this.F = true;
        this.G = true;
    }

    static /* bridge */ /* synthetic */ boolean C(AdvertisingOptions advertisingOptions) {
        boolean z3 = advertisingOptions.E;
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AdvertisingOptions) {
            AdvertisingOptions advertisingOptions = (AdvertisingOptions) obj;
            if (Objects.equal(this.f22115a, advertisingOptions.f22115a) && Objects.equal(Boolean.valueOf(this.f22116b), Boolean.valueOf(advertisingOptions.f22116b)) && Objects.equal(Boolean.valueOf(this.f22117c), Boolean.valueOf(advertisingOptions.f22117c)) && Objects.equal(Boolean.valueOf(this.f22118d), Boolean.valueOf(advertisingOptions.f22118d)) && Objects.equal(Boolean.valueOf(this.f22119e), Boolean.valueOf(advertisingOptions.f22119e)) && Arrays.equals(this.f22120f, advertisingOptions.f22120f) && Objects.equal(Boolean.valueOf(this.f22121g), Boolean.valueOf(advertisingOptions.f22121g)) && Objects.equal(this.f22122h, advertisingOptions.f22122h) && Objects.equal(Boolean.valueOf(this.f22123i), Boolean.valueOf(advertisingOptions.f22123i)) && Objects.equal(Boolean.valueOf(this.f22124j), Boolean.valueOf(advertisingOptions.f22124j)) && Objects.equal(Boolean.valueOf(this.f22125k), Boolean.valueOf(advertisingOptions.f22125k)) && Objects.equal(Boolean.valueOf(this.f22126l), Boolean.valueOf(advertisingOptions.f22126l)) && Objects.equal(Boolean.valueOf(this.f22127m), Boolean.valueOf(advertisingOptions.f22127m)) && Objects.equal(Boolean.valueOf(this.f22128n), Boolean.valueOf(advertisingOptions.f22128n)) && Objects.equal(Integer.valueOf(this.f22129o), Integer.valueOf(advertisingOptions.f22129o)) && Objects.equal(Integer.valueOf(this.f22130p), Integer.valueOf(advertisingOptions.f22130p)) && Arrays.equals(this.f22131q, advertisingOptions.f22131q) && Objects.equal(Long.valueOf(this.f22132r), Long.valueOf(advertisingOptions.f22132r)) && Arrays.equals(this.f22133s, advertisingOptions.f22133s) && Objects.equal(Boolean.valueOf(this.f22134t), Boolean.valueOf(advertisingOptions.f22134t)) && Objects.equal(Boolean.valueOf(this.f22135u), Boolean.valueOf(advertisingOptions.f22135u)) && Objects.equal(Boolean.valueOf(this.f22136v), Boolean.valueOf(advertisingOptions.f22136v)) && Objects.equal(Boolean.valueOf(this.f22137w), Boolean.valueOf(advertisingOptions.f22137w)) && Arrays.equals(this.f22138x, advertisingOptions.f22138x) && Arrays.equals(this.f22139y, advertisingOptions.f22139y) && Objects.equal(Boolean.valueOf(this.f22140z), Boolean.valueOf(advertisingOptions.f22140z)) && Objects.equal(Integer.valueOf(this.A), Integer.valueOf(advertisingOptions.A)) && Objects.equal(this.B, advertisingOptions.B) && Objects.equal(Boolean.valueOf(this.C), Boolean.valueOf(advertisingOptions.C)) && Objects.equal(Integer.valueOf(this.D), Integer.valueOf(advertisingOptions.D))) {
                Boolean bool = Boolean.FALSE;
                if (Objects.equal(bool, bool) && Objects.equal(Boolean.valueOf(this.F), Boolean.valueOf(advertisingOptions.F)) && Objects.equal(Boolean.valueOf(this.G), Boolean.valueOf(advertisingOptions.G))) {
                    return true;
                }
            }
        }
        return false;
    }

    public int getConnectionType() {
        return this.D;
    }

    @Deprecated
    public boolean getDisruptiveUpgrade() {
        return this.f22135u;
    }

    public boolean getLowPower() {
        return this.f22121g;
    }

    @NonNull
    public Strategy getStrategy() {
        return this.f22115a;
    }

    public int hashCode() {
        return Objects.hashCode(this.f22115a, Boolean.valueOf(this.f22116b), Boolean.valueOf(this.f22117c), Boolean.valueOf(this.f22118d), Boolean.valueOf(this.f22119e), Integer.valueOf(Arrays.hashCode(this.f22120f)), Boolean.valueOf(this.f22121g), this.f22122h, Boolean.valueOf(this.f22123i), Boolean.valueOf(this.f22124j), Boolean.valueOf(this.f22125k), Boolean.valueOf(this.f22126l), Boolean.valueOf(this.f22127m), Boolean.valueOf(this.f22128n), Integer.valueOf(this.f22129o), Integer.valueOf(this.f22130p), Integer.valueOf(Arrays.hashCode(this.f22131q)), Long.valueOf(this.f22132r), Integer.valueOf(Arrays.hashCode(this.f22133s)), Boolean.valueOf(this.f22134t), Boolean.valueOf(this.f22135u), Boolean.valueOf(this.f22136v), Boolean.valueOf(this.f22137w), Integer.valueOf(Arrays.hashCode(this.f22138x)), Integer.valueOf(Arrays.hashCode(this.f22139y)), Boolean.valueOf(this.f22140z), Integer.valueOf(this.A), this.B, Boolean.valueOf(this.C), Integer.valueOf(this.D), Boolean.FALSE, Boolean.valueOf(this.F), Boolean.valueOf(this.G));
    }

    @NonNull
    public String toString() {
        String zzb;
        String zzb2;
        Locale locale = Locale.US;
        Object[] objArr = new Object[25];
        objArr[0] = this.f22115a;
        objArr[1] = Boolean.valueOf(this.f22116b);
        objArr[2] = Boolean.valueOf(this.f22117c);
        objArr[3] = Boolean.valueOf(this.f22118d);
        objArr[4] = Boolean.valueOf(this.f22119e);
        byte[] bArr = this.f22120f;
        String str = null;
        if (bArr == null) {
            zzb = null;
        } else {
            zzb = com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr);
        }
        objArr[5] = zzb;
        objArr[6] = Boolean.valueOf(this.f22121g);
        objArr[7] = this.f22122h;
        objArr[8] = Boolean.valueOf(this.f22123i);
        objArr[9] = Boolean.valueOf(this.f22124j);
        objArr[10] = Boolean.valueOf(this.f22125k);
        objArr[11] = Boolean.valueOf(this.f22126l);
        objArr[12] = Boolean.valueOf(this.f22127m);
        objArr[13] = Boolean.valueOf(this.f22128n);
        objArr[14] = Integer.valueOf(this.f22129o);
        objArr[15] = Integer.valueOf(this.f22130p);
        byte[] bArr2 = this.f22131q;
        if (bArr2 == null) {
            zzb2 = "null";
        } else {
            zzb2 = com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr2);
        }
        objArr[16] = zzb2;
        objArr[17] = Long.valueOf(this.f22132r);
        objArr[18] = Arrays.toString(this.f22133s);
        objArr[19] = Boolean.valueOf(this.f22134t);
        objArr[20] = Boolean.valueOf(this.f22135u);
        objArr[21] = Boolean.valueOf(this.f22137w);
        byte[] bArr3 = this.B;
        if (bArr3 != null) {
            str = com.google.android.gms.nearby.messages.internal.zzc.zzb(bArr3);
        }
        objArr[22] = str;
        objArr[23] = Boolean.valueOf(this.C);
        objArr[24] = Integer.valueOf(this.D);
        return String.format(locale, "AdvertisingOptions{strategy: %s, autoUpgradeBandwidth: %s, enforceTopologyConstraints: %s, enableBluetooth: %s, enableBle: %s, nearbyNotificationsBeaconData: %s, lowPower: %s, fastAdvertisementServiceUuid: %s, enableWifiLan: %s, enableNfc: %s, enableWifiAware: %s, enableBluetoothListening: %s, enableWebRtcListening: %s, enableUwbRanging: %s, uwbChannel: %d, uwbPreambleIndex: %d, remoteUwbAddress: %s, flowId: %d, uwbSenderInfo: %s, enableOutOfBandConnection: %s, disruptiveUpgrade: %s,useStableIdentifiers: %s,deviceInfo: %s,allowGattConnections: %s,connectionType: %d}", objArr);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getStrategy(), i4, false);
        SafeParcelWriter.writeBoolean(parcel, 2, this.f22116b);
        SafeParcelWriter.writeBoolean(parcel, 3, this.f22117c);
        SafeParcelWriter.writeBoolean(parcel, 4, this.f22118d);
        SafeParcelWriter.writeBoolean(parcel, 5, this.f22119e);
        SafeParcelWriter.writeByteArray(parcel, 6, this.f22120f, false);
        SafeParcelWriter.writeBoolean(parcel, 7, getLowPower());
        SafeParcelWriter.writeParcelable(parcel, 8, this.f22122h, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 9, this.f22123i);
        SafeParcelWriter.writeBoolean(parcel, 10, this.f22124j);
        SafeParcelWriter.writeBoolean(parcel, 11, this.f22125k);
        SafeParcelWriter.writeBoolean(parcel, 12, this.f22126l);
        SafeParcelWriter.writeBoolean(parcel, 13, this.f22127m);
        SafeParcelWriter.writeBoolean(parcel, 14, this.f22128n);
        SafeParcelWriter.writeInt(parcel, 15, this.f22129o);
        SafeParcelWriter.writeInt(parcel, 16, this.f22130p);
        SafeParcelWriter.writeByteArray(parcel, 17, this.f22131q, false);
        SafeParcelWriter.writeLong(parcel, 18, this.f22132r);
        SafeParcelWriter.writeTypedArray(parcel, 19, this.f22133s, i4, false);
        SafeParcelWriter.writeBoolean(parcel, 20, this.f22134t);
        SafeParcelWriter.writeBoolean(parcel, 21, getDisruptiveUpgrade());
        SafeParcelWriter.writeBoolean(parcel, 22, this.f22136v);
        SafeParcelWriter.writeBoolean(parcel, 23, this.f22137w);
        SafeParcelWriter.writeIntArray(parcel, 24, this.f22138x, false);
        SafeParcelWriter.writeIntArray(parcel, 25, this.f22139y, false);
        SafeParcelWriter.writeBoolean(parcel, 26, this.f22140z);
        SafeParcelWriter.writeInt(parcel, 27, this.A);
        SafeParcelWriter.writeByteArray(parcel, 28, this.B, false);
        SafeParcelWriter.writeBoolean(parcel, 29, this.C);
        SafeParcelWriter.writeInt(parcel, 30, getConnectionType());
        SafeParcelWriter.writeBoolean(parcel, 31, false);
        SafeParcelWriter.writeBoolean(parcel, 32, this.F);
        SafeParcelWriter.writeBoolean(parcel, 33, this.G);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* synthetic */ AdvertisingOptions(zza zzaVar) {
        this.f22116b = true;
        this.f22117c = true;
        this.f22118d = true;
        this.f22119e = true;
        this.f22121g = false;
        this.f22123i = true;
        this.f22124j = true;
        this.f22125k = true;
        this.f22126l = false;
        this.f22127m = false;
        this.f22128n = false;
        this.f22129o = 0;
        this.f22130p = 0;
        this.f22132r = 0L;
        this.f22134t = false;
        this.f22135u = true;
        this.f22136v = false;
        this.f22137w = true;
        this.f22140z = true;
        this.A = 0;
        this.C = true;
        this.D = 0;
        this.E = false;
        this.F = true;
        this.G = true;
    }

    @Deprecated
    public AdvertisingOptions(@NonNull Strategy strategy) {
        this.f22116b = true;
        this.f22117c = true;
        this.f22118d = true;
        this.f22119e = true;
        this.f22121g = false;
        this.f22123i = true;
        this.f22124j = true;
        this.f22125k = true;
        this.f22126l = false;
        this.f22127m = false;
        this.f22128n = false;
        this.f22129o = 0;
        this.f22130p = 0;
        this.f22132r = 0L;
        this.f22134t = false;
        this.f22135u = true;
        this.f22136v = false;
        this.f22137w = true;
        this.f22140z = true;
        this.A = 0;
        this.C = true;
        this.D = 0;
        this.E = false;
        this.F = true;
        this.G = true;
        this.f22115a = strategy;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public AdvertisingOptions(@SafeParcelable.Param(id = 1) Strategy strategy, @SafeParcelable.Param(id = 2) boolean z3, @SafeParcelable.Param(id = 3) boolean z4, @SafeParcelable.Param(id = 4) boolean z5, @SafeParcelable.Param(id = 5) boolean z6, @Nullable @SafeParcelable.Param(id = 6) byte[] bArr, @SafeParcelable.Param(id = 7) boolean z7, @Nullable @SafeParcelable.Param(id = 8) ParcelUuid parcelUuid, @SafeParcelable.Param(id = 9) boolean z8, @SafeParcelable.Param(id = 10) boolean z9, @SafeParcelable.Param(id = 11) boolean z10, @SafeParcelable.Param(id = 12) boolean z11, @SafeParcelable.Param(id = 13) boolean z12, @SafeParcelable.Param(id = 14) boolean z13, @SafeParcelable.Param(id = 15) int i4, @SafeParcelable.Param(id = 16) int i5, @Nullable @SafeParcelable.Param(id = 17) byte[] bArr2, @SafeParcelable.Param(id = 18) long j4, @SafeParcelable.Param(id = 19) zzab[] zzabVarArr, @SafeParcelable.Param(id = 20) boolean z14, @SafeParcelable.Param(id = 21) boolean z15, @SafeParcelable.Param(id = 22) boolean z16, @SafeParcelable.Param(id = 23) boolean z17, @SafeParcelable.Param(id = 24) int[] iArr, @SafeParcelable.Param(id = 25) int[] iArr2, @SafeParcelable.Param(id = 26) boolean z18, @SafeParcelable.Param(id = 27) int i6, @Nullable @SafeParcelable.Param(id = 28) byte[] bArr3, @SafeParcelable.Param(id = 29) boolean z19, @SafeParcelable.Param(id = 30) int i7, @SafeParcelable.Param(id = 31) boolean z20, @SafeParcelable.Param(id = 32) boolean z21, @SafeParcelable.Param(id = 33) boolean z22) {
        this.E = false;
        this.F = true;
        this.G = true;
        this.f22115a = strategy;
        this.f22116b = z3;
        this.f22117c = z4;
        this.f22118d = z5;
        this.f22119e = z6;
        this.f22120f = bArr;
        this.f22121g = z7;
        this.f22122h = parcelUuid;
        this.f22123i = z8;
        this.f22124j = z9;
        this.f22125k = z10;
        this.f22126l = z11;
        this.f22127m = z12;
        this.f22128n = z13;
        this.f22129o = i4;
        this.f22130p = i5;
        this.f22131q = bArr2;
        this.f22132r = j4;
        this.f22133s = zzabVarArr;
        this.f22134t = z14;
        this.f22135u = z15;
        this.f22136v = z16;
        this.f22137w = z17;
        this.f22138x = iArr;
        this.f22139y = iArr2;
        this.f22140z = z18;
        this.A = i6;
        this.B = bArr3;
        this.C = z19;
        this.D = i7;
    }
}
