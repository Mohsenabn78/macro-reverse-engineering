package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CheckReturnValue;

/* compiled from: com.google.android.gms:play-services-basement@@18.1.0 */
@SafeParcelable.Class(creator = "StatusCreator")
/* loaded from: classes4.dex */
public final class Status extends AbstractSafeParcelable implements Result, ReflectedParcelable {
    @SafeParcelable.VersionField(id = 1000)

    /* renamed from: a  reason: collision with root package name */
    final int f20032a;
    @SafeParcelable.Field(getter = "getStatusCode", id = 1)

    /* renamed from: b  reason: collision with root package name */
    private final int f20033b;
    @Nullable
    @SafeParcelable.Field(getter = "getStatusMessage", id = 2)

    /* renamed from: c  reason: collision with root package name */
    private final String f20034c;
    @Nullable
    @SafeParcelable.Field(getter = "getPendingIntent", id = 3)

    /* renamed from: d  reason: collision with root package name */
    private final PendingIntent f20035d;
    @Nullable
    @SafeParcelable.Field(getter = "getConnectionResult", id = 4)

    /* renamed from: e  reason: collision with root package name */
    private final ConnectionResult f20036e;
    @NonNull
    @VisibleForTesting
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_SUCCESS_CACHE = new Status(-1);
    @NonNull
    @VisibleForTesting
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_SUCCESS = new Status(0);
    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_TIMEOUT = new Status(15);
    @NonNull
    @ShowFirstParty
    @KeepForSdk
    public static final Status RESULT_CANCELED = new Status(16);
    @NonNull
    @ShowFirstParty
    public static final Status zza = new Status(17);
    @NonNull
    @KeepForSdk
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    @NonNull
    public static final Parcelable.Creator<Status> CREATOR = new zzb();

    /* JADX INFO: Access modifiers changed from: package-private */
    @SafeParcelable.Constructor
    public Status(@SafeParcelable.Param(id = 1000) int i4, @SafeParcelable.Param(id = 1) int i5, @Nullable @SafeParcelable.Param(id = 2) String str, @Nullable @SafeParcelable.Param(id = 3) PendingIntent pendingIntent, @Nullable @SafeParcelable.Param(id = 4) ConnectionResult connectionResult) {
        this.f20032a = i4;
        this.f20033b = i5;
        this.f20034c = str;
        this.f20035d = pendingIntent;
        this.f20036e = connectionResult;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        if (this.f20032a != status.f20032a || this.f20033b != status.f20033b || !Objects.equal(this.f20034c, status.f20034c) || !Objects.equal(this.f20035d, status.f20035d) || !Objects.equal(this.f20036e, status.f20036e)) {
            return false;
        }
        return true;
    }

    @Nullable
    public ConnectionResult getConnectionResult() {
        return this.f20036e;
    }

    @Nullable
    public PendingIntent getResolution() {
        return this.f20035d;
    }

    public int getStatusCode() {
        return this.f20033b;
    }

    @Nullable
    public String getStatusMessage() {
        return this.f20034c;
    }

    @VisibleForTesting
    public boolean hasResolution() {
        if (this.f20035d != null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.f20032a), Integer.valueOf(this.f20033b), this.f20034c, this.f20035d, this.f20036e);
    }

    public boolean isCanceled() {
        if (this.f20033b == 16) {
            return true;
        }
        return false;
    }

    public boolean isInterrupted() {
        if (this.f20033b == 14) {
            return true;
        }
        return false;
    }

    @CheckReturnValue
    public boolean isSuccess() {
        if (this.f20033b <= 0) {
            return true;
        }
        return false;
    }

    public void startResolutionForResult(@NonNull Activity activity, int i4) throws IntentSender.SendIntentException {
        if (!hasResolution()) {
            return;
        }
        PendingIntent pendingIntent = this.f20035d;
        Preconditions.checkNotNull(pendingIntent);
        activity.startIntentSenderForResult(pendingIntent.getIntentSender(), i4, null, 0, 0, 0);
    }

    @NonNull
    public String toString() {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(this);
        stringHelper.add("statusCode", zza());
        stringHelper.add("resolution", this.f20035d);
        return stringHelper.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getStatusCode());
        SafeParcelWriter.writeString(parcel, 2, getStatusMessage(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.f20035d, i4, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getConnectionResult(), i4, false);
        SafeParcelWriter.writeInt(parcel, 1000, this.f20032a);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @NonNull
    public final String zza() {
        String str = this.f20034c;
        if (str != null) {
            return str;
        }
        return CommonStatusCodes.getStatusCodeString(this.f20033b);
    }

    public Status(int i4) {
        this(i4, (String) null);
    }

    public Status(int i4, @Nullable String str) {
        this(1, i4, str, null, null);
    }

    public Status(int i4, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i4, str, pendingIntent, null);
    }

    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str) {
        this(connectionResult, str, 17);
    }

    @KeepForSdk
    @Deprecated
    public Status(@NonNull ConnectionResult connectionResult, @NonNull String str, int i4) {
        this(1, i4, str, connectionResult.getResolution(), connectionResult);
    }

    @Override // com.google.android.gms.common.api.Result
    @NonNull
    @CanIgnoreReturnValue
    public Status getStatus() {
        return this;
    }
}
