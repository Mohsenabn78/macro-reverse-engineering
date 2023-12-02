package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
@SafeParcelable.Class(creator = "ModuleInstallStatusUpdateCreator")
/* loaded from: classes4.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    @NonNull
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new zae();
    @SafeParcelable.Field(getter = "getSessionId", id = 1)

    /* renamed from: a  reason: collision with root package name */
    private final int f20610a;
    @InstallState
    @SafeParcelable.Field(getter = "getInstallState", id = 2)

    /* renamed from: b  reason: collision with root package name */
    private final int f20611b;
    @Nullable
    @SafeParcelable.Field(getter = "getBytesDownloaded", id = 3)

    /* renamed from: c  reason: collision with root package name */
    private final Long f20612c;
    @Nullable
    @SafeParcelable.Field(getter = "getTotalBytesToDownload", id = 4)

    /* renamed from: d  reason: collision with root package name */
    private final Long f20613d;
    @SafeParcelable.Field(getter = "getErrorCode", id = 5)

    /* renamed from: e  reason: collision with root package name */
    private final int f20614e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private final ProgressInfo f20615f;

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    @Retention(RetentionPolicy.CLASS)
    /* loaded from: classes4.dex */
    public @interface InstallState {
        public static final int STATE_CANCELED = 3;
        public static final int STATE_COMPLETED = 4;
        public static final int STATE_DOWNLOADING = 2;
        public static final int STATE_DOWNLOAD_PAUSED = 7;
        public static final int STATE_FAILED = 5;
        public static final int STATE_INSTALLING = 6;
        public static final int STATE_PENDING = 1;
        public static final int STATE_UNKNOWN = 0;
    }

    /* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
    /* loaded from: classes4.dex */
    public static class ProgressInfo {

        /* renamed from: a  reason: collision with root package name */
        private final long f20616a;

        /* renamed from: b  reason: collision with root package name */
        private final long f20617b;

        ProgressInfo(long j4, long j5) {
            Preconditions.checkNotZero(j5);
            this.f20616a = j4;
            this.f20617b = j5;
        }

        public long getBytesDownloaded() {
            return this.f20616a;
        }

        public long getTotalBytesToDownload() {
            return this.f20617b;
        }
    }

    @SafeParcelable.Constructor
    @KeepForSdk
    public ModuleInstallStatusUpdate(@SafeParcelable.Param(id = 1) int i4, @SafeParcelable.Param(id = 2) @InstallState int i5, @Nullable @SafeParcelable.Param(id = 3) Long l4, @Nullable @SafeParcelable.Param(id = 4) Long l5, @SafeParcelable.Param(id = 5) int i6) {
        ProgressInfo progressInfo;
        this.f20610a = i4;
        this.f20611b = i5;
        this.f20612c = l4;
        this.f20613d = l5;
        this.f20614e = i6;
        if (l4 != null && l5 != null && l5.longValue() != 0) {
            progressInfo = new ProgressInfo(l4.longValue(), l5.longValue());
        } else {
            progressInfo = null;
        }
        this.f20615f = progressInfo;
    }

    public int getErrorCode() {
        return this.f20614e;
    }

    @InstallState
    public int getInstallState() {
        return this.f20611b;
    }

    @Nullable
    public ProgressInfo getProgressInfo() {
        return this.f20615f;
    }

    public int getSessionId() {
        return this.f20610a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i4) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getSessionId());
        SafeParcelWriter.writeInt(parcel, 2, getInstallState());
        SafeParcelWriter.writeLongObject(parcel, 3, this.f20612c, false);
        SafeParcelWriter.writeLongObject(parcel, 4, this.f20613d, false);
        SafeParcelWriter.writeInt(parcel, 5, getErrorCode());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
