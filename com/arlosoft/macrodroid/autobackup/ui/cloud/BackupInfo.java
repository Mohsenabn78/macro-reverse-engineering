package com.arlosoft.macrodroid.autobackup.ui.cloud;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: AutoBackupCloudViewModel.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class BackupInfo {
    public static final int $stable = 0;

    /* renamed from: a  reason: collision with root package name */
    private final long f9380a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final String f9381b;

    public BackupInfo(long j4, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.f9380a = j4;
        this.f9381b = name;
    }

    public static /* synthetic */ BackupInfo copy$default(BackupInfo backupInfo, long j4, String str, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            j4 = backupInfo.f9380a;
        }
        if ((i4 & 2) != 0) {
            str = backupInfo.f9381b;
        }
        return backupInfo.copy(j4, str);
    }

    public final long component1() {
        return this.f9380a;
    }

    @NotNull
    public final String component2() {
        return this.f9381b;
    }

    @NotNull
    public final BackupInfo copy(long j4, @NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new BackupInfo(j4, name);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackupInfo)) {
            return false;
        }
        BackupInfo backupInfo = (BackupInfo) obj;
        if (this.f9380a == backupInfo.f9380a && Intrinsics.areEqual(this.f9381b, backupInfo.f9381b)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getName() {
        return this.f9381b;
    }

    public final long getTimeStamp() {
        return this.f9380a;
    }

    public int hashCode() {
        return (androidx.compose.animation.a.a(this.f9380a) * 31) + this.f9381b.hashCode();
    }

    @NotNull
    public String toString() {
        long j4 = this.f9380a;
        String str = this.f9381b;
        return "BackupInfo(timeStamp=" + j4 + ", name=" + str + ")";
    }
}
