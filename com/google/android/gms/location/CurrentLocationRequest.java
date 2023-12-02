package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzdj;
import com.google.firebase.firestore.util.ExponentialBackoff;
import com.google.mlkit.nl.translate.TranslateLanguage;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "CurrentLocationRequestCreator")
/* loaded from: classes4.dex */
public final class CurrentLocationRequest extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<CurrentLocationRequest> CREATOR = new zzj();
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getMaxUpdateAgeMillis", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final long f20886a;
    @SafeParcelable.Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20887b;
    @SafeParcelable.Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final int f20888c;
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final long f20889d;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final boolean f20890e;
    @SafeParcelable.Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 7)

    /* renamed from: f  reason: collision with root package name */
    private final int f20891f;
    @Nullable
    @SafeParcelable.Field(getter = "getModuleId", id = 8)

    /* renamed from: g  reason: collision with root package name */
    private final String f20892g;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 6)

    /* renamed from: h  reason: collision with root package name */
    private final WorkSource f20893h;
    @Nullable
    @SafeParcelable.Field(getter = "getImpersonation", id = 9)

    /* renamed from: i  reason: collision with root package name */
    private final com.google.android.gms.internal.location.zzd f20894i;

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private long f20895a;

        /* renamed from: b  reason: collision with root package name */
        private int f20896b;

        /* renamed from: c  reason: collision with root package name */
        private int f20897c;

        /* renamed from: d  reason: collision with root package name */
        private long f20898d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f20899e;

        /* renamed from: f  reason: collision with root package name */
        private int f20900f;
        @Nullable

        /* renamed from: g  reason: collision with root package name */
        private String f20901g;
        @Nullable

        /* renamed from: h  reason: collision with root package name */
        private WorkSource f20902h;
        @Nullable

        /* renamed from: i  reason: collision with root package name */
        private com.google.android.gms.internal.location.zzd f20903i;

        public Builder() {
            this.f20895a = ExponentialBackoff.DEFAULT_BACKOFF_MAX_DELAY_MS;
            this.f20896b = 0;
            this.f20897c = 102;
            this.f20898d = Long.MAX_VALUE;
            this.f20899e = false;
            this.f20900f = 0;
            this.f20901g = null;
            this.f20902h = null;
            this.f20903i = null;
        }

        @NonNull
        public CurrentLocationRequest build() {
            return new CurrentLocationRequest(this.f20895a, this.f20896b, this.f20897c, this.f20898d, this.f20899e, this.f20900f, this.f20901g, new WorkSource(this.f20902h), this.f20903i);
        }

        @NonNull
        public Builder setDurationMillis(long j4) {
            boolean z3;
            if (j4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "durationMillis must be greater than 0");
            this.f20898d = j4;
            return this;
        }

        @NonNull
        public Builder setGranularity(int i4) {
            zzo.zza(i4);
            this.f20896b = i4;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateAgeMillis(long j4) {
            boolean z3;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than or equal to 0");
            this.f20895a = j4;
            return this;
        }

        @NonNull
        public Builder setPriority(int i4) {
            zzae.zza(i4);
            this.f20897c = i4;
            return this;
        }

        public Builder(@NonNull CurrentLocationRequest currentLocationRequest) {
            this.f20895a = currentLocationRequest.getMaxUpdateAgeMillis();
            this.f20896b = currentLocationRequest.getGranularity();
            this.f20897c = currentLocationRequest.getPriority();
            this.f20898d = currentLocationRequest.getDurationMillis();
            this.f20899e = currentLocationRequest.zze();
            this.f20900f = currentLocationRequest.zza();
            this.f20901g = currentLocationRequest.zzd();
            this.f20902h = new WorkSource(currentLocationRequest.zzb());
            this.f20903i = currentLocationRequest.zzc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public CurrentLocationRequest(@SafeParcelable.Param(id = 1) long j4, @SafeParcelable.Param(id = 2) int i4, @SafeParcelable.Param(id = 3) int i5, @SafeParcelable.Param(id = 4) long j5, @SafeParcelable.Param(id = 5) boolean z3, @SafeParcelable.Param(id = 7) int i6, @Nullable @SafeParcelable.Param(id = 8) String str, @SafeParcelable.Param(id = 6) WorkSource workSource, @Nullable @SafeParcelable.Param(id = 9) com.google.android.gms.internal.location.zzd zzdVar) {
        boolean z4 = true;
        if (Build.VERSION.SDK_INT >= 30 && str != null) {
            z4 = false;
        }
        Preconditions.checkArgument(z4);
        this.f20886a = j4;
        this.f20887b = i4;
        this.f20888c = i5;
        this.f20889d = j5;
        this.f20890e = z3;
        this.f20891f = i6;
        this.f20892g = str;
        this.f20893h = workSource;
        this.f20894i = zzdVar;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof CurrentLocationRequest)) {
            return false;
        }
        CurrentLocationRequest currentLocationRequest = (CurrentLocationRequest) obj;
        if (this.f20886a != currentLocationRequest.f20886a || this.f20887b != currentLocationRequest.f20887b || this.f20888c != currentLocationRequest.f20888c || this.f20889d != currentLocationRequest.f20889d || this.f20890e != currentLocationRequest.f20890e || this.f20891f != currentLocationRequest.f20891f || !Objects.equal(this.f20892g, currentLocationRequest.f20892g) || !Objects.equal(this.f20893h, currentLocationRequest.f20893h) || !Objects.equal(this.f20894i, currentLocationRequest.f20894i)) {
            return false;
        }
        return true;
    }

    @Pure
    public long getDurationMillis() {
        return this.f20889d;
    }

    @Pure
    public int getGranularity() {
        return this.f20887b;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.f20886a;
    }

    @Pure
    public int getPriority() {
        return this.f20888c;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f20886a), Integer.valueOf(this.f20887b), Integer.valueOf(this.f20888c), Long.valueOf(this.f20889d));
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CurrentLocationRequest[");
        sb.append(zzae.zzb(this.f20888c));
        if (this.f20886a != Long.MAX_VALUE) {
            sb.append(", maxAge=");
            zzdj.zzb(this.f20886a, sb);
        }
        if (this.f20889d != Long.MAX_VALUE) {
            sb.append(", duration=");
            sb.append(this.f20889d);
            sb.append(TranslateLanguage.MALAY);
        }
        if (this.f20887b != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.f20887b));
        }
        if (this.f20890e) {
            sb.append(", bypass");
        }
        if (this.f20891f != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.f20891f));
        }
        if (this.f20892g != null) {
            sb.append(", moduleId=");
            sb.append(this.f20892g);
        }
        if (!WorkSourceUtil.isEmpty(this.f20893h)) {
            sb.append(", workSource=");
            sb.append(this.f20893h);
        }
        if (this.f20894i != null) {
            sb.append(", impersonation=");
            sb.append(this.f20894i);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 2, getGranularity());
        SafeParcelWriter.writeInt(parcel, 3, getPriority());
        SafeParcelWriter.writeLong(parcel, 4, getDurationMillis());
        SafeParcelWriter.writeBoolean(parcel, 5, this.f20890e);
        SafeParcelWriter.writeParcelable(parcel, 6, this.f20893h, i4, false);
        SafeParcelWriter.writeInt(parcel, 7, this.f20891f);
        SafeParcelWriter.writeString(parcel, 8, this.f20892g, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.f20894i, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.f20891f;
    }

    @NonNull
    @Pure
    public final WorkSource zzb() {
        return this.f20893h;
    }

    @Nullable
    @Pure
    public final com.google.android.gms.internal.location.zzd zzc() {
        return this.f20894i;
    }

    @Nullable
    @Deprecated
    @Pure
    public final String zzd() {
        return this.f20892g;
    }

    @Pure
    public final boolean zze() {
        return this.f20890e;
    }
}
