package com.google.android.gms.nearby.presence.log;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "DtdiAttributionCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class DtdiAttribution extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<DtdiAttribution> CREATOR = new zzb();
    @Nullable
    @SafeParcelable.Field(getter = "getParentCorrelationId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private byte[] f22471a;
    @Nullable
    @SafeParcelable.Field(getter = "getCorrelationId", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private byte[] f22472b;
    @Nullable
    @SafeParcelable.Field(getter = "getEphemeralDeviceId", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private byte[] f22473c;
    @SafeParcelable.Field(getter = "getDtdiSource", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private int f22474d;
    @SafeParcelable.Field(getter = "getExpirationTimestampMillis", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private long f22475e;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Reserved({1000})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final DtdiAttribution f22476a;

        public Builder() {
            this.f22476a = new DtdiAttribution(null);
        }

        @NonNull
        public DtdiAttribution build() {
            return this.f22476a;
        }

        @NonNull
        public Builder setCorrelationId(@Nullable byte[] bArr) {
            this.f22476a.f22472b = bArr;
            return this;
        }

        @NonNull
        public Builder setDtdiSource(int i4) {
            this.f22476a.f22474d = i4;
            return this;
        }

        @NonNull
        public Builder setEphemeralDeviceId(@Nullable byte[] bArr) {
            this.f22476a.f22473c = bArr;
            return this;
        }

        @NonNull
        public Builder setExpirationTimestampMillis(long j4) {
            this.f22476a.f22475e = j4;
            return this;
        }

        @NonNull
        public Builder setParentCorrelationId(@Nullable byte[] bArr) {
            this.f22476a.f22471a = bArr;
            return this;
        }

        public Builder(@NonNull DtdiAttribution dtdiAttribution) {
            DtdiAttribution dtdiAttribution2 = new DtdiAttribution(null);
            this.f22476a = dtdiAttribution2;
            dtdiAttribution2.f22471a = dtdiAttribution.f22471a;
            dtdiAttribution2.f22472b = dtdiAttribution.f22472b;
            dtdiAttribution2.f22473c = dtdiAttribution.f22473c;
            dtdiAttribution2.f22474d = dtdiAttribution.f22474d;
            dtdiAttribution2.f22475e = dtdiAttribution.f22475e;
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface DtdiSource {
        public static final int DTDI_SOURCE_DISCOVERY = 1;
        public static final int DTDI_SOURCE_INVITATIONS = 3;
        public static final int DTDI_SOURCE_SESSIONS = 2;
        public static final int DTDI_SOURCE_UNKNOWN = 0;
    }

    private DtdiAttribution() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DtdiAttribution) {
            DtdiAttribution dtdiAttribution = (DtdiAttribution) obj;
            if (Arrays.equals(this.f22471a, dtdiAttribution.f22471a) && Arrays.equals(this.f22472b, dtdiAttribution.f22472b) && Arrays.equals(this.f22473c, dtdiAttribution.f22473c) && Objects.equal(Integer.valueOf(this.f22474d), Integer.valueOf(dtdiAttribution.f22474d)) && Objects.equal(Long.valueOf(this.f22475e), Long.valueOf(dtdiAttribution.f22475e))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public byte[] getCorrelationId() {
        return this.f22472b;
    }

    public int getDtdiSource() {
        return this.f22474d;
    }

    @Nullable
    public byte[] getEphemeralDeviceId() {
        return this.f22473c;
    }

    public long getExpirationTimestampMillis() {
        return this.f22475e;
    }

    @Nullable
    public byte[] getParentCorrelationId() {
        return this.f22471a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(Arrays.hashCode(this.f22471a)), Integer.valueOf(Arrays.hashCode(this.f22472b)), Integer.valueOf(Arrays.hashCode(this.f22473c)), Integer.valueOf(this.f22474d), Long.valueOf(this.f22475e));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeByteArray(parcel, 1, getParentCorrelationId(), false);
        SafeParcelWriter.writeByteArray(parcel, 2, getCorrelationId(), false);
        SafeParcelWriter.writeByteArray(parcel, 3, getEphemeralDeviceId(), false);
        SafeParcelWriter.writeInt(parcel, 4, getDtdiSource());
        SafeParcelWriter.writeLong(parcel, 5, getExpirationTimestampMillis());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* synthetic */ DtdiAttribution(zza zzaVar) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public DtdiAttribution(@Nullable @SafeParcelable.Param(id = 1) byte[] bArr, @Nullable @SafeParcelable.Param(id = 2) byte[] bArr2, @Nullable @SafeParcelable.Param(id = 3) byte[] bArr3, @SafeParcelable.Param(id = 4) int i4, @SafeParcelable.Param(id = 5) long j4) {
        this.f22471a = bArr;
        this.f22472b = bArr2;
        this.f22473c = bArr3;
        this.f22474d = i4;
        this.f22475e = j4;
    }
}
