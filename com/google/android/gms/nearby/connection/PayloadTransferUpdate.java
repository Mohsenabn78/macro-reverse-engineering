package com.google.android.gms.nearby.connection;

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

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
@SafeParcelable.Class(creator = "PayloadTransferUpdateCreator")
@SafeParcelable.Reserved({1000})
/* loaded from: classes4.dex */
public final class PayloadTransferUpdate extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<PayloadTransferUpdate> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getPayloadId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private long f22217a;
    @SafeParcelable.Field(getter = "getStatus", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private int f22218b;
    @SafeParcelable.Field(getter = "getTotalBytes", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private long f22219c;
    @SafeParcelable.Field(getter = "getBytesTransferred", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private long f22220d;

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @SafeParcelable.Reserved({1000})
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private final PayloadTransferUpdate f22221a;

        public Builder() {
            this.f22221a = new PayloadTransferUpdate(null);
        }

        @NonNull
        public PayloadTransferUpdate build() {
            return this.f22221a;
        }

        @NonNull
        public Builder setBytesTransferred(long j4) {
            this.f22221a.f22220d = j4;
            return this;
        }

        @NonNull
        public Builder setPayloadId(long j4) {
            this.f22221a.f22217a = j4;
            return this;
        }

        @NonNull
        public Builder setStatus(int i4) {
            this.f22221a.f22218b = i4;
            return this;
        }

        @NonNull
        public Builder setTotalBytes(long j4) {
            this.f22221a.f22219c = j4;
            return this;
        }

        public Builder(@NonNull PayloadTransferUpdate payloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate2 = new PayloadTransferUpdate(null);
            this.f22221a = payloadTransferUpdate2;
            payloadTransferUpdate2.f22217a = payloadTransferUpdate.f22217a;
            payloadTransferUpdate2.f22218b = payloadTransferUpdate.f22218b;
            payloadTransferUpdate2.f22219c = payloadTransferUpdate.f22219c;
            payloadTransferUpdate2.f22220d = payloadTransferUpdate.f22220d;
        }
    }

    /* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface Status {
        public static final int CANCELED = 4;
        public static final int FAILURE = 2;
        public static final int IN_PROGRESS = 3;
        public static final int SUCCESS = 1;
    }

    private PayloadTransferUpdate() {
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PayloadTransferUpdate) {
            PayloadTransferUpdate payloadTransferUpdate = (PayloadTransferUpdate) obj;
            if (Objects.equal(Long.valueOf(this.f22217a), Long.valueOf(payloadTransferUpdate.f22217a)) && Objects.equal(Integer.valueOf(this.f22218b), Integer.valueOf(payloadTransferUpdate.f22218b)) && Objects.equal(Long.valueOf(this.f22219c), Long.valueOf(payloadTransferUpdate.f22219c)) && Objects.equal(Long.valueOf(this.f22220d), Long.valueOf(payloadTransferUpdate.f22220d))) {
                return true;
            }
        }
        return false;
    }

    public long getBytesTransferred() {
        return this.f22220d;
    }

    public long getPayloadId() {
        return this.f22217a;
    }

    public int getStatus() {
        return this.f22218b;
    }

    public long getTotalBytes() {
        return this.f22219c;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f22217a), Integer.valueOf(this.f22218b), Long.valueOf(this.f22219c), Long.valueOf(this.f22220d));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getPayloadId());
        SafeParcelWriter.writeInt(parcel, 2, getStatus());
        SafeParcelWriter.writeLong(parcel, 3, getTotalBytes());
        SafeParcelWriter.writeLong(parcel, 4, getBytesTransferred());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public PayloadTransferUpdate(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) long j5, @SafeParcelable.Param(id = 4) long j6) {
        this.f22217a = j4;
        this.f22218b = i4;
        this.f22219c = j5;
        this.f22220d = j6;
    }

    /* synthetic */ PayloadTransferUpdate(zzw zzwVar) {
    }
}
