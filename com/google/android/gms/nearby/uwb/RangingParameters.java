package com.google.android.gms.nearby.uwb;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.nearby.uwb.UwbRangeDataNtfConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class RangingParameters {
    public static final int SESSION_ID_UNSET = 0;
    public static final int SUB_SESSION_ID_UNSET = 0;

    /* renamed from: j  reason: collision with root package name */
    private static final byte[] f22518j = {7, 8, 1, 2, 3, 4, 5, 6};
    @UwbConfigId

    /* renamed from: a  reason: collision with root package name */
    private final int f22519a;

    /* renamed from: b  reason: collision with root package name */
    private final int f22520b;

    /* renamed from: c  reason: collision with root package name */
    private final int f22521c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private final byte[] f22522d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private final byte[] f22523e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final UwbComplexChannel f22524f;

    /* renamed from: g  reason: collision with root package name */
    private final List f22525g;
    @RangingUpdateRate

    /* renamed from: h  reason: collision with root package name */
    private final int f22526h;
    @NonNull

    /* renamed from: i  reason: collision with root package name */
    private final UwbRangeDataNtfConfig f22527i;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public static class Builder {
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private byte[] f22532e;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        private UwbComplexChannel f22533f;
        @UwbConfigId

        /* renamed from: a  reason: collision with root package name */
        private int f22528a = 0;

        /* renamed from: b  reason: collision with root package name */
        private int f22529b = 0;

        /* renamed from: c  reason: collision with root package name */
        private int f22530c = 0;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private byte[] f22531d = RangingParameters.f22518j;

        /* renamed from: g  reason: collision with root package name */
        private final List f22534g = new ArrayList();
        @RangingUpdateRate

        /* renamed from: h  reason: collision with root package name */
        int f22535h = 3;

        /* renamed from: i  reason: collision with root package name */
        private UwbRangeDataNtfConfig f22536i = new UwbRangeDataNtfConfig.Builder().build();

        @NonNull
        public Builder addPeerDevice(@NonNull UwbDevice uwbDevice) {
            Preconditions.checkNotNull(uwbDevice, "peerDevice cannot be null.");
            this.f22534g.add(uwbDevice);
            return this;
        }

        @NonNull
        public RangingParameters build() {
            boolean z3;
            boolean z4;
            boolean z5;
            boolean z6;
            boolean z7;
            boolean z8;
            boolean z9;
            boolean z10;
            int length;
            boolean z11;
            boolean z12;
            int length2;
            int length3;
            boolean z13 = true;
            Preconditions.checkArgument(!this.f22534g.isEmpty(), "At least 1 peer device must be set.");
            if (this.f22528a != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3);
            if (this.f22535h != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            Preconditions.checkArgument(z4);
            int i4 = this.f22528a;
            if (i4 == 1 || i4 == 2 || i4 == 3 || i4 == 1000 || i4 == 1001) {
                byte[] bArr = this.f22531d;
                if (bArr != null && bArr.length == 8) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                Preconditions.checkArgument(z5);
                if (this.f22530c == 0) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                Preconditions.checkArgument(z6);
                if (this.f22532e == null) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                Preconditions.checkArgument(z7);
            }
            int i5 = this.f22528a;
            if (i5 == 4 || i5 == 5 || i5 == 6) {
                byte[] bArr2 = this.f22531d;
                if (bArr2 != null && ((length = bArr2.length) == 16 || length == 32)) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                Preconditions.checkArgument(z8);
                if (this.f22530c == 0) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                Preconditions.checkArgument(z9);
                if (this.f22532e == null) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                Preconditions.checkArgument(z10);
            }
            if (this.f22528a == 7) {
                if (this.f22530c != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Preconditions.checkArgument(z11);
                byte[] bArr3 = this.f22531d;
                if (bArr3 != null && ((length3 = bArr3.length) == 16 || length3 == 32)) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                Preconditions.checkArgument(z12);
                byte[] bArr4 = this.f22532e;
                if (bArr4 == null || ((length2 = bArr4.length) != 16 && length2 != 32)) {
                    z13 = false;
                }
                Preconditions.checkArgument(z13);
            }
            return new RangingParameters(this.f22528a, this.f22529b, this.f22530c, this.f22531d, this.f22532e, this.f22533f, this.f22535h, this.f22534g, this.f22536i, null);
        }

        @NonNull
        public Builder setComplexChannel(@Nullable UwbComplexChannel uwbComplexChannel) {
            this.f22533f = uwbComplexChannel;
            return this;
        }

        @NonNull
        public Builder setRangingUpdateRate(@RangingUpdateRate int i4) {
            this.f22535h = i4;
            return this;
        }

        @NonNull
        public Builder setSessionId(int i4) {
            this.f22529b = i4;
            return this;
        }

        @NonNull
        public Builder setSessionKeyInfo(@Nullable byte[] bArr) {
            this.f22531d = bArr;
            return this;
        }

        @NonNull
        public Builder setSubSessionId(int i4) {
            this.f22530c = i4;
            return this;
        }

        @NonNull
        public Builder setSubSessionKeyInfo(@Nullable byte[] bArr) {
            this.f22532e = bArr;
            return this;
        }

        @NonNull
        public Builder setUwbConfigId(@UwbConfigId int i4) {
            this.f22528a = i4;
            return this;
        }

        @NonNull
        public Builder setUwbRangeDataNtfConfig(@NonNull UwbRangeDataNtfConfig uwbRangeDataNtfConfig) {
            this.f22536i = uwbRangeDataNtfConfig;
            return this;
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public @interface RangingUpdateRate {
        public static final int AUTOMATIC = 1;
        public static final int FREQUENT = 3;
        public static final int INFREQUENT = 2;
        public static final int UNKNOWN = 0;
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    /* loaded from: classes4.dex */
    public @interface UwbConfigId {
        public static final int CONFIG_ID_1 = 1;
        public static final int CONFIG_ID_2 = 2;
        public static final int CONFIG_ID_3 = 3;
        public static final int CONFIG_ID_4 = 4;
        public static final int CONFIG_ID_5 = 5;
        public static final int CONFIG_ID_6 = 6;
        public static final int CONFIG_ID_7 = 7;
    }

    /* synthetic */ RangingParameters(int i4, int i5, int i6, byte[] bArr, byte[] bArr2, UwbComplexChannel uwbComplexChannel, int i7, List list, UwbRangeDataNtfConfig uwbRangeDataNtfConfig, zza zzaVar) {
        this.f22519a = i4;
        this.f22520b = i5;
        this.f22521c = i6;
        this.f22522d = bArr;
        this.f22523e = bArr2;
        this.f22524f = uwbComplexChannel;
        this.f22526h = i7;
        this.f22525g = list;
        this.f22527i = uwbRangeDataNtfConfig;
    }

    @Nullable
    public UwbComplexChannel getComplexChannel() {
        return this.f22524f;
    }

    @NonNull
    public List<UwbDevice> getPeerDevices() {
        return this.f22525g;
    }

    @RangingUpdateRate
    public int getRangingUpdateRate() {
        return this.f22526h;
    }

    public int getSessionId() {
        return this.f22520b;
    }

    @Nullable
    public byte[] getSessionKeyInfo() {
        return this.f22522d;
    }

    public int getSubSessionId() {
        return this.f22521c;
    }

    @Nullable
    public byte[] getSubSessionKeyInfo() {
        return this.f22523e;
    }

    @UwbConfigId
    public int getUwbConfigId() {
        return this.f22519a;
    }

    @NonNull
    public UwbRangeDataNtfConfig getUwbRangeDataNtfConfig() {
        return this.f22527i;
    }
}
