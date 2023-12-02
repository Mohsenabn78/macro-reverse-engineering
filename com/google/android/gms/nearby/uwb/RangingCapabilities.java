package com.google.android.gms.nearby.uwb;

import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.nearby.zzse;
import com.google.android.gms.internal.nearby.zzst;
import java.util.Arrays;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public class RangingCapabilities {
    public static final float FIRA_DEFAULT_MIN_SLOT_DURATION_MS = 2.0f;
    public static final int FIRA_DEFAULT_RANGING_INTERVAL_MS = 200;
    public static final int FIRA_DEFAULT_SUPPORTED_CHANNEL = 9;
    public static final zzst<Integer> FIRA_DEFAULT_SUPPORTED_CONFIG_IDS = zzst.zzp(1, 2, 3, 1000, 1001);
    public static final int RANGE_DATA_NTF_ENABLE = 1;

    /* renamed from: a  reason: collision with root package name */
    private final boolean f22509a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f22510b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f22511c;

    /* renamed from: d  reason: collision with root package name */
    private final int f22512d;

    /* renamed from: e  reason: collision with root package name */
    private final List f22513e;

    /* renamed from: f  reason: collision with root package name */
    private final List f22514f;

    /* renamed from: g  reason: collision with root package name */
    private final List f22515g;

    /* renamed from: h  reason: collision with root package name */
    private final float f22516h;

    public RangingCapabilities(boolean z3, boolean z4, boolean z5, int i4, @NonNull List list, @NonNull List list2, @NonNull List list3, float f4) {
        this.f22509a = z3;
        this.f22510b = z4;
        this.f22511c = z5;
        this.f22512d = i4;
        this.f22513e = list;
        this.f22514f = list2;
        this.f22515g = list3;
        this.f22516h = f4;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RangingCapabilities)) {
            return false;
        }
        RangingCapabilities rangingCapabilities = (RangingCapabilities) obj;
        if (this.f22509a == rangingCapabilities.f22509a && this.f22510b == rangingCapabilities.f22510b && this.f22511c == rangingCapabilities.f22511c && getMinRangingInterval() == rangingCapabilities.getMinRangingInterval() && Float.compare(rangingCapabilities.f22516h, this.f22516h) == 0 && zzse.zza(getSupportedChannels(), rangingCapabilities.getSupportedChannels()) && zzse.zza(getSupportedNtfConfigs(), rangingCapabilities.getSupportedNtfConfigs()) && zzse.zza(getSupportedConfigIds(), rangingCapabilities.getSupportedConfigIds())) {
            return true;
        }
        return false;
    }

    @IntRange(from = 0)
    public int getMinRangingInterval() {
        return this.f22512d;
    }

    @NonNull
    public List<Integer> getSupportedChannels() {
        return this.f22513e;
    }

    @NonNull
    public List<Integer> getSupportedConfigIds() {
        return this.f22515g;
    }

    @NonNull
    public List<Integer> getSupportedNtfConfigs() {
        return this.f22514f;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Boolean.valueOf(this.f22509a), Boolean.valueOf(this.f22510b), Boolean.valueOf(this.f22511c), Integer.valueOf(getMinRangingInterval()), getSupportedChannels(), getSupportedNtfConfigs(), getSupportedConfigIds(), Float.valueOf(this.f22516h)});
    }

    public boolean supportsAzimuthalAngle() {
        return this.f22510b;
    }

    public boolean supportsDistance() {
        return this.f22509a;
    }

    public boolean supportsElevationAngle() {
        return this.f22511c;
    }

    @NonNull
    public String toString() {
        boolean z3 = this.f22509a;
        boolean z4 = this.f22510b;
        boolean z5 = this.f22511c;
        int i4 = this.f22512d;
        String valueOf = String.valueOf(this.f22513e);
        String valueOf2 = String.valueOf(this.f22514f);
        String valueOf3 = String.valueOf(this.f22515g);
        float f4 = this.f22516h;
        return "RangingCapabilities{supportsDistance=" + z3 + ", supportsAzimuthalAngle=" + z4 + ", supportsElevationAngle=" + z5 + ", minRangingInterval=" + i4 + ", supportedChannels=" + valueOf + ", supportedNtfConfigs=" + valueOf2 + ", supportedConfigIds=" + valueOf3 + ", minSlotDuration=" + f4 + "}";
    }
}
