package com.google.android.gms.location;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.WorkSource;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresPermission;
import com.arlosoft.macrodroid.common.Util;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.WorkSourceUtil;
import com.google.android.gms.internal.location.zzdj;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.sessions.settings.RemoteSettings;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
@SafeParcelable.Class(creator = "LocationRequestCreator")
@SafeParcelable.Reserved({4, 5, 1000})
/* loaded from: classes4.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    @NonNull
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzx();
    @Deprecated
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    @Deprecated
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    @Deprecated
    public static final int PRIORITY_LOW_POWER = 104;
    @Deprecated
    public static final int PRIORITY_NO_POWER = 105;
    @SafeParcelable.Field(defaultValueUnchecked = "Priority.PRIORITY_BALANCED_POWER_ACCURACY", getter = "getPriority", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private int f20941a;
    @SafeParcelable.Field(defaultValue = "3600000", getter = "getIntervalMillis", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private long f20942b;
    @SafeParcelable.Field(defaultValue = "600000", getter = "getMinUpdateIntervalMillis", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private long f20943c;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMaxUpdateDelayMillis", id = 8)

    /* renamed from: d  reason: collision with root package name */
    private long f20944d;
    @SafeParcelable.Field(defaultValueUnchecked = "Long.MAX_VALUE", getter = "getDurationMillis", id = 10)

    /* renamed from: e  reason: collision with root package name */
    private long f20945e;
    @SafeParcelable.Field(defaultValueUnchecked = "Integer.MAX_VALUE", getter = "getMaxUpdates", id = 6)

    /* renamed from: f  reason: collision with root package name */
    private int f20946f;
    @SafeParcelable.Field(defaultValue = "0", getter = "getMinUpdateDistanceMeters", id = 7)

    /* renamed from: g  reason: collision with root package name */
    private float f20947g;
    @SafeParcelable.Field(defaultValue = "false", getter = "isWaitForAccurateLocation", id = 9)

    /* renamed from: h  reason: collision with root package name */
    private boolean f20948h;
    @SafeParcelable.Field(defaultValueUnchecked = Util.ANY_CONTACT_ID, getter = "getMaxUpdateAgeMillis", id = 11)

    /* renamed from: i  reason: collision with root package name */
    private long f20949i;
    @SafeParcelable.Field(defaultValueUnchecked = "Granularity.GRANULARITY_PERMISSION_LEVEL", getter = "getGranularity", id = 12)

    /* renamed from: j  reason: collision with root package name */
    private final int f20950j;
    @SafeParcelable.Field(defaultValueUnchecked = "ThrottleBehavior.THROTTLE_BACKGROUND", getter = "getThrottleBehavior", id = 13)

    /* renamed from: k  reason: collision with root package name */
    private final int f20951k;
    @Nullable
    @SafeParcelable.Field(getter = "getModuleId", id = 14)

    /* renamed from: l  reason: collision with root package name */
    private final String f20952l;
    @SafeParcelable.Field(defaultValue = "false", getter = "isBypass", id = 15)

    /* renamed from: m  reason: collision with root package name */
    private final boolean f20953m;
    @SafeParcelable.Field(defaultValueUnchecked = "new android.os.WorkSource()", getter = "getWorkSource", id = 16)

    /* renamed from: n  reason: collision with root package name */
    private final WorkSource f20954n;
    @Nullable
    @SafeParcelable.Field(getter = "getImpersonation", id = 17)

    /* renamed from: o  reason: collision with root package name */
    private final com.google.android.gms.internal.location.zzd f20955o;

    @Deprecated
    public LocationRequest() {
        this(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    private static String b(long j4) {
        if (j4 == Long.MAX_VALUE) {
            return "∞";
        }
        return zzdj.zza(j4);
    }

    @NonNull
    @Deprecated
    public static LocationRequest create() {
        return new LocationRequest(102, 3600000L, 600000L, 0L, Long.MAX_VALUE, Long.MAX_VALUE, Integer.MAX_VALUE, 0.0f, true, 3600000L, 0, 0, null, false, new WorkSource(), null);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.f20941a == locationRequest.f20941a && ((isPassive() || this.f20942b == locationRequest.f20942b) && this.f20943c == locationRequest.f20943c && isBatched() == locationRequest.isBatched() && ((!isBatched() || this.f20944d == locationRequest.f20944d) && this.f20945e == locationRequest.f20945e && this.f20946f == locationRequest.f20946f && this.f20947g == locationRequest.f20947g && this.f20948h == locationRequest.f20948h && this.f20950j == locationRequest.f20950j && this.f20951k == locationRequest.f20951k && this.f20953m == locationRequest.f20953m && this.f20954n.equals(locationRequest.f20954n) && Objects.equal(this.f20952l, locationRequest.f20952l) && Objects.equal(this.f20955o, locationRequest.f20955o)))) {
                return true;
            }
        }
        return false;
    }

    @Pure
    public long getDurationMillis() {
        return this.f20945e;
    }

    @Deprecated
    @Pure
    public long getExpirationTime() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j4 = this.f20945e;
        long j5 = elapsedRealtime + j4;
        if (((elapsedRealtime ^ j5) & (j4 ^ j5)) < 0) {
            return Long.MAX_VALUE;
        }
        return j5;
    }

    @Deprecated
    @Pure
    public long getFastestInterval() {
        return getMinUpdateIntervalMillis();
    }

    @Pure
    public int getGranularity() {
        return this.f20950j;
    }

    @Deprecated
    @Pure
    public long getInterval() {
        return getIntervalMillis();
    }

    @Pure
    public long getIntervalMillis() {
        return this.f20942b;
    }

    @Pure
    public long getMaxUpdateAgeMillis() {
        return this.f20949i;
    }

    @Pure
    public long getMaxUpdateDelayMillis() {
        return this.f20944d;
    }

    @Pure
    public int getMaxUpdates() {
        return this.f20946f;
    }

    @Deprecated
    @Pure
    public long getMaxWaitTime() {
        return Math.max(this.f20944d, this.f20942b);
    }

    @Pure
    public float getMinUpdateDistanceMeters() {
        return this.f20947g;
    }

    @Pure
    public long getMinUpdateIntervalMillis() {
        return this.f20943c;
    }

    @Deprecated
    @Pure
    public int getNumUpdates() {
        return getMaxUpdates();
    }

    @Pure
    public int getPriority() {
        return this.f20941a;
    }

    @Deprecated
    @Pure
    public float getSmallestDisplacement() {
        return getMinUpdateDistanceMeters();
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20941a), Long.valueOf(this.f20942b), Long.valueOf(this.f20943c), this.f20954n);
    }

    @Pure
    public boolean isBatched() {
        long j4 = this.f20944d;
        if (j4 > 0 && (j4 >> 1) >= this.f20942b) {
            return true;
        }
        return false;
    }

    @Deprecated
    @Pure
    public boolean isFastestIntervalExplicitlySet() {
        return true;
    }

    @Pure
    public boolean isPassive() {
        if (this.f20941a == 105) {
            return true;
        }
        return false;
    }

    public boolean isWaitForAccurateLocation() {
        return this.f20948h;
    }

    @NonNull
    @Deprecated
    public LocationRequest setExpirationDuration(long j4) {
        boolean z3;
        if (j4 > 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "durationMillis must be greater than 0");
        this.f20945e = j4;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setExpirationTime(long j4) {
        this.f20945e = Math.max(1L, j4 - SystemClock.elapsedRealtime());
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setFastestInterval(long j4) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "illegal fastest interval: %d", Long.valueOf(j4));
        this.f20943c = j4;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setInterval(long j4) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "intervalMillis must be greater than or equal to 0");
        long j5 = this.f20943c;
        long j6 = this.f20942b;
        if (j5 == j6 / 6) {
            this.f20943c = j4 / 6;
        }
        if (this.f20949i == j6) {
            this.f20949i = j4;
        }
        this.f20942b = j4;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setMaxWaitTime(long j4) {
        boolean z3;
        if (j4 >= 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "illegal max wait time: %d", Long.valueOf(j4));
        this.f20944d = j4;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setNumUpdates(int i4) {
        if (i4 > 0) {
            this.f20946f = i4;
            return this;
        }
        throw new IllegalArgumentException("invalid numUpdates: " + i4);
    }

    @NonNull
    @Deprecated
    public LocationRequest setPriority(int i4) {
        zzae.zza(i4);
        this.f20941a = i4;
        return this;
    }

    @NonNull
    @Deprecated
    public LocationRequest setSmallestDisplacement(float f4) {
        if (f4 >= 0.0f) {
            this.f20947g = f4;
            return this;
        }
        throw new IllegalArgumentException("invalid displacement: " + f4);
    }

    @NonNull
    @Deprecated
    public LocationRequest setWaitForAccurateLocation(boolean z3) {
        this.f20948h = z3;
        return this;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request[");
        if (isPassive()) {
            sb.append(zzae.zzb(this.f20941a));
        } else {
            sb.append("@");
            if (isBatched()) {
                zzdj.zzb(this.f20942b, sb);
                sb.append(RemoteSettings.FORWARD_SLASH_STRING);
                zzdj.zzb(this.f20944d, sb);
            } else {
                zzdj.zzb(this.f20942b, sb);
            }
            sb.append(MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);
            sb.append(zzae.zzb(this.f20941a));
        }
        if (isPassive() || this.f20943c != this.f20942b) {
            sb.append(", minUpdateInterval=");
            sb.append(b(this.f20943c));
        }
        if (this.f20947g > FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            sb.append(", minUpdateDistance=");
            sb.append(this.f20947g);
        }
        if (!isPassive() ? this.f20949i != this.f20942b : this.f20949i != Long.MAX_VALUE) {
            sb.append(", maxUpdateAge=");
            sb.append(b(this.f20949i));
        }
        if (this.f20945e != Long.MAX_VALUE) {
            sb.append(", duration=");
            zzdj.zzb(this.f20945e, sb);
        }
        if (this.f20946f != Integer.MAX_VALUE) {
            sb.append(", maxUpdates=");
            sb.append(this.f20946f);
        }
        if (this.f20951k != 0) {
            sb.append(", ");
            sb.append(zzai.zza(this.f20951k));
        }
        if (this.f20950j != 0) {
            sb.append(", ");
            sb.append(zzo.zzb(this.f20950j));
        }
        if (this.f20948h) {
            sb.append(", waitForAccurateLocation");
        }
        if (this.f20953m) {
            sb.append(", bypass");
        }
        if (this.f20952l != null) {
            sb.append(", moduleId=");
            sb.append(this.f20952l);
        }
        if (!WorkSourceUtil.isEmpty(this.f20954n)) {
            sb.append(", ");
            sb.append(this.f20954n);
        }
        if (this.f20955o != null) {
            sb.append(", impersonation=");
            sb.append(this.f20955o);
        }
        sb.append(']');
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getPriority());
        SafeParcelWriter.writeLong(parcel, 2, getIntervalMillis());
        SafeParcelWriter.writeLong(parcel, 3, getMinUpdateIntervalMillis());
        SafeParcelWriter.writeInt(parcel, 6, getMaxUpdates());
        SafeParcelWriter.writeFloat(parcel, 7, getMinUpdateDistanceMeters());
        SafeParcelWriter.writeLong(parcel, 8, getMaxUpdateDelayMillis());
        SafeParcelWriter.writeBoolean(parcel, 9, isWaitForAccurateLocation());
        SafeParcelWriter.writeLong(parcel, 10, getDurationMillis());
        SafeParcelWriter.writeLong(parcel, 11, getMaxUpdateAgeMillis());
        SafeParcelWriter.writeInt(parcel, 12, getGranularity());
        SafeParcelWriter.writeInt(parcel, 13, this.f20951k);
        SafeParcelWriter.writeString(parcel, 14, this.f20952l, false);
        SafeParcelWriter.writeBoolean(parcel, 15, this.f20953m);
        SafeParcelWriter.writeParcelable(parcel, 16, this.f20954n, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 17, this.f20955o, i4, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @Pure
    public final int zza() {
        return this.f20951k;
    }

    @NonNull
    @Pure
    public final WorkSource zzb() {
        return this.f20954n;
    }

    @Nullable
    @Pure
    public final com.google.android.gms.internal.location.zzd zzc() {
        return this.f20955o;
    }

    @Nullable
    @Deprecated
    @Pure
    public final String zzd() {
        return this.f20952l;
    }

    @Pure
    public final boolean zze() {
        return this.f20953m;
    }

    /* compiled from: com.google.android.gms:play-services-location@@21.0.1 */
    /* loaded from: classes4.dex */
    public static final class Builder {
        public static final long IMPLICIT_MAX_UPDATE_AGE = -1;
        public static final long IMPLICIT_MIN_UPDATE_INTERVAL = -1;

        /* renamed from: a  reason: collision with root package name */
        private int f20956a;

        /* renamed from: b  reason: collision with root package name */
        private long f20957b;

        /* renamed from: c  reason: collision with root package name */
        private long f20958c;

        /* renamed from: d  reason: collision with root package name */
        private long f20959d;

        /* renamed from: e  reason: collision with root package name */
        private long f20960e;

        /* renamed from: f  reason: collision with root package name */
        private int f20961f;

        /* renamed from: g  reason: collision with root package name */
        private float f20962g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f20963h;

        /* renamed from: i  reason: collision with root package name */
        private long f20964i;

        /* renamed from: j  reason: collision with root package name */
        private int f20965j;

        /* renamed from: k  reason: collision with root package name */
        private int f20966k;
        @Nullable

        /* renamed from: l  reason: collision with root package name */
        private String f20967l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f20968m;
        @Nullable

        /* renamed from: n  reason: collision with root package name */
        private WorkSource f20969n;
        @Nullable

        /* renamed from: o  reason: collision with root package name */
        private com.google.android.gms.internal.location.zzd f20970o;

        public Builder(int i4, long j4) {
            Preconditions.checkArgument(j4 >= 0, "intervalMillis must be greater than or equal to 0");
            zzae.zza(i4);
            this.f20956a = i4;
            this.f20957b = j4;
            this.f20958c = -1L;
            this.f20959d = 0L;
            this.f20960e = Long.MAX_VALUE;
            this.f20961f = Integer.MAX_VALUE;
            this.f20962g = 0.0f;
            this.f20963h = true;
            this.f20964i = -1L;
            this.f20965j = 0;
            this.f20966k = 0;
            this.f20967l = null;
            this.f20968m = false;
            this.f20969n = null;
            this.f20970o = null;
        }

        @NonNull
        public LocationRequest build() {
            long j4;
            int i4 = this.f20956a;
            long j5 = this.f20957b;
            long j6 = this.f20958c;
            if (j6 == -1) {
                j6 = j5;
            } else if (i4 != 105) {
                j6 = Math.min(j6, j5);
            }
            long max = Math.max(this.f20959d, this.f20957b);
            long j7 = this.f20960e;
            int i5 = this.f20961f;
            float f4 = this.f20962g;
            boolean z3 = this.f20963h;
            long j8 = this.f20964i;
            if (j8 == -1) {
                j4 = this.f20957b;
            } else {
                j4 = j8;
            }
            return new LocationRequest(i4, j5, j6, max, Long.MAX_VALUE, j7, i5, f4, z3, j4, this.f20965j, this.f20966k, this.f20967l, this.f20968m, new WorkSource(this.f20969n), this.f20970o);
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
            this.f20960e = j4;
            return this;
        }

        @NonNull
        public Builder setGranularity(int i4) {
            zzo.zza(i4);
            this.f20965j = i4;
            return this;
        }

        @NonNull
        public Builder setIntervalMillis(long j4) {
            boolean z3;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "intervalMillis must be greater than or equal to 0");
            this.f20957b = j4;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateAgeMillis(long j4) {
            boolean z3 = true;
            if (j4 != -1 && j4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateAgeMillis must be greater than or equal to 0, or IMPLICIT_MAX_UPDATE_AGE");
            this.f20964i = j4;
            return this;
        }

        @NonNull
        public Builder setMaxUpdateDelayMillis(long j4) {
            boolean z3;
            if (j4 >= 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdateDelayMillis must be greater than or equal to 0");
            this.f20959d = j4;
            return this;
        }

        @NonNull
        public Builder setMaxUpdates(int i4) {
            boolean z3;
            if (i4 > 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "maxUpdates must be greater than 0");
            this.f20961f = i4;
            return this;
        }

        @NonNull
        public Builder setMinUpdateDistanceMeters(float f4) {
            boolean z3;
            if (f4 >= 0.0f) {
                z3 = true;
            } else {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minUpdateDistanceMeters must be greater than or equal to 0");
            this.f20962g = f4;
            return this;
        }

        @NonNull
        public Builder setMinUpdateIntervalMillis(long j4) {
            boolean z3 = true;
            if (j4 != -1 && j4 < 0) {
                z3 = false;
            }
            Preconditions.checkArgument(z3, "minUpdateIntervalMillis must be greater than or equal to 0, or IMPLICIT_MIN_UPDATE_INTERVAL");
            this.f20958c = j4;
            return this;
        }

        @NonNull
        public Builder setPriority(int i4) {
            zzae.zza(i4);
            this.f20956a = i4;
            return this;
        }

        @NonNull
        public Builder setWaitForAccurateLocation(boolean z3) {
            this.f20963h = z3;
            return this;
        }

        @NonNull
        @RequiresPermission(anyOf = {"android.permission.WRITE_SECURE_SETTINGS", "android.permission.LOCATION_BYPASS"})
        public final Builder zza(boolean z3) {
            this.f20968m = z3;
            return this;
        }

        @NonNull
        @Deprecated
        public final Builder zzb(@Nullable String str) {
            if (Build.VERSION.SDK_INT < 30) {
                this.f20967l = str;
            }
            return this;
        }

        @NonNull
        public final Builder zzc(int i4) {
            int i5;
            boolean z3;
            if (i4 != 0 && i4 != 1) {
                i5 = 2;
                if (i4 == 2) {
                    i4 = 2;
                } else {
                    i5 = i4;
                    z3 = false;
                    Preconditions.checkArgument(z3, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i4));
                    this.f20966k = i5;
                    return this;
                }
            } else {
                i5 = i4;
            }
            z3 = true;
            Preconditions.checkArgument(z3, "throttle behavior %d must be a ThrottleBehavior.THROTTLE_* constant", Integer.valueOf(i4));
            this.f20966k = i5;
            return this;
        }

        @NonNull
        @RequiresPermission("android.permission.UPDATE_DEVICE_STATS")
        public final Builder zzd(@Nullable WorkSource workSource) {
            this.f20969n = workSource;
            return this;
        }

        public Builder(long j4) {
            Preconditions.checkArgument(j4 >= 0, "intervalMillis must be greater than or equal to 0");
            this.f20957b = j4;
            this.f20956a = 102;
            this.f20958c = -1L;
            this.f20959d = 0L;
            this.f20960e = Long.MAX_VALUE;
            this.f20961f = Integer.MAX_VALUE;
            this.f20962g = 0.0f;
            this.f20963h = true;
            this.f20964i = -1L;
            this.f20965j = 0;
            this.f20966k = 0;
            this.f20967l = null;
            this.f20968m = false;
            this.f20969n = null;
            this.f20970o = null;
        }

        public Builder(@NonNull LocationRequest locationRequest) {
            this.f20956a = locationRequest.getPriority();
            this.f20957b = locationRequest.getIntervalMillis();
            this.f20958c = locationRequest.getMinUpdateIntervalMillis();
            this.f20959d = locationRequest.getMaxUpdateDelayMillis();
            this.f20960e = locationRequest.getDurationMillis();
            this.f20961f = locationRequest.getMaxUpdates();
            this.f20962g = locationRequest.getMinUpdateDistanceMeters();
            this.f20963h = locationRequest.isWaitForAccurateLocation();
            this.f20964i = locationRequest.getMaxUpdateAgeMillis();
            this.f20965j = locationRequest.getGranularity();
            this.f20966k = locationRequest.zza();
            this.f20967l = locationRequest.zzd();
            this.f20968m = locationRequest.zze();
            this.f20969n = locationRequest.zzb();
            this.f20970o = locationRequest.zzc();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public LocationRequest(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) long j4, @SafeParcelable.Param(id = 3) long j5, @SafeParcelable.Param(id = 8) long j6, @SafeParcelable.RemovedParam(defaultValueUnchecked = "Long.MAX_VALUE", id = 5) long j7, @SafeParcelable.Param(id = 10) long j8, @SafeParcelable.Param(id = 6) int i5, @SafeParcelable.Param(id = 7) float f4, @SafeParcelable.Param(id = 9) boolean z3, @SafeParcelable.Param(id = 11) long j9, @SafeParcelable.Param(id = 12) int i6, @SafeParcelable.Param(id = 13) int i7, @Nullable @SafeParcelable.Param(id = 14) String str, @SafeParcelable.Param(id = 15) boolean z4, @SafeParcelable.Param(id = 16) WorkSource workSource, @Nullable @SafeParcelable.Param(id = 17) com.google.android.gms.internal.location.zzd zzdVar) {
        this.f20941a = i4;
        long j10 = j4;
        this.f20942b = j10;
        this.f20943c = j5;
        this.f20944d = j6;
        this.f20945e = j7 == Long.MAX_VALUE ? j8 : Math.min(Math.max(1L, j7 - SystemClock.elapsedRealtime()), j8);
        this.f20946f = i5;
        this.f20947g = f4;
        this.f20948h = z3;
        this.f20949i = j9 != -1 ? j9 : j10;
        this.f20950j = i6;
        this.f20951k = i7;
        this.f20952l = str;
        this.f20953m = z4;
        this.f20954n = workSource;
        this.f20955o = zzdVar;
    }
}
