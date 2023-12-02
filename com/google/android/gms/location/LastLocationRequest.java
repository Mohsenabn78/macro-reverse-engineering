package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzdj;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "LastLocationRequestCreator")
/* loaded from: classes4.dex */
public final class LastLocationRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<LastLocationRequest> CREATOR = new zzv();
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final long f20926a;
    @SafeParcelable.Field(defaultValueUnchecked = "com.google.android.gms.location.Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20927b;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final boolean f20928c;
    @Nullable
    @SafeParcelable.Field(getter = "getModuleId", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final String f20929d;
    @Nullable
    @SafeParcelable.Field(getter = "getImpersonation", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final com.google.android.gms.internal.location.zzd f20930e;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f20931a;

        /* renamed from: b  reason: collision with root package name */
        private int f20932b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f20933c;
        @Nullable

        /* renamed from: d  reason: collision with root package name */
        private String f20934d;
        @Nullable

        /* renamed from: e  reason: collision with root package name */
        private com.google.android.gms.internal.location.zzd f20935e;

        public Builder() {
            this.f20931a = Long.MAX_VALUE;
            this.f20932b = 0;
            this.f20933c = false;
            this.f20934d = null;
            this.f20935e = null;
        }

        @NonNull
        public LastLocationRequest build() {
            return new LastLocationRequest(this.f20931a, this.f20932b, this.f20933c, this.f20934d, this.f20935e);
        }

        @NonNull
        public Builder setGranularity(int i4) {
            zzo.zza(i4);
            this.f20932b = i4;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateAgeMillis(long j4) {
            boolean z3;
            if (j4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than 0");
            this.f20931a = j4;
            return this;
        }

        public Builder(@NonNull LastLocationRequest lastLocationRequest) {
            this.f20931a = lastLocationRequest.getMaxUpdateAgeMillis();
            this.f20932b = lastLocationRequest.getGranularity();
            this.f20933c = lastLocationRequest.zzc();
            this.f20934d = lastLocationRequest.zzb();
            this.f20935e = lastLocationRequest.zza();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LastLocationRequest(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) boolean z3, @Nullable @SafeParcelable.Param(id = 4) String str, @Nullable @SafeParcelable.Param(id = 5) com.google.android.gms.internal.location.zzd zzdVar) {
        this.f20926a = j4;
        this.f20927b = i4;
        this.f20928c = z3;
        this.f20929d = str;
        this.f20930e = zzdVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof LastLocationRequest)) {
            return false;
        }
        LastLocationRequest lastLocationRequest = (LastLocationRequest) obj;
        if (this.f20926a != lastLocationRequest.f20926a || this.f20927b != lastLocationRequest.f20927b || this.f20928c != lastLocationRequest.f20928c || !Objects.equal(this.f20929d, lastLocationRequest.f20929d) || !Objects.equal(this.f20930e, lastLocationRequest.f20930e)) {
            return false;
        }
        return true;
    }

    @Pure
    public int getGranularity() {
        return this.f20927b;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.f20926a;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f20926a), Integer.valueOf(this.f20927b), Boolean.valueOf(this.f20928c));
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LastLocationRequest[");
        if (this.f20926a != Long.MAX_VALUE) {
            sb.append("maxAge=");
            zzdj.zzb(this.f20926a, sb);
        }
        if (this.f20927b != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.f20927b));
        }
        if (this.f20928c) {
            sb.append(", bypass");
        }
        if (this.f20929d != null) {
            sb.append(", moduleId=");
            sb.append(this.f20929d);
        }
        if (this.f20930e != null) {
            sb.append(", impersonation=");
            sb.append(this.f20930e);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeBoolean(parcel, 3, this.f20928c);
        SafeParcelWriter.writeString(parcel, 4, this.f20929d, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.f20930e, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Nullable
    @Pure
    public final com.google.android.gms.internal.location.zzd zza() {
        return this.f20930e;
    }

    @Nullable
    @Deprecated
    @Pure
    public final String zzb() {
        return this.f20929d;
    }

    @Pure
    public final boolean zzc() {
        return this.f20928c;
    }
}
