package com.google.android.play.core.install;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.play.core.appupdate.internal.zzm;
import com.google.android.play.core.install.model.InstallErrorCode;
import com.google.android.play.core.install.model.InstallStatus;

/* compiled from: com.google.android.play:app-update@@2.0.1 */
/* loaded from: classes5.dex */
public abstract class InstallState {
    public static InstallState zza(@InstallStatus int i4, long j4, long j5, @InstallErrorCode int i5, @NonNull String str) {
        return new zza(i4, j4, j5, i5, str);
    }

    public static InstallState zzb(@NonNull Intent intent, @NonNull zzm zzmVar) {
        zzmVar.zza("List of extras in received intent needed by fromUpdateIntent:", new Object[0]);
        zzmVar.zza("Key: %s; value: %s", "install.status", Integer.valueOf(intent.getIntExtra("install.status", 0)));
        zzmVar.zza("Key: %s; value: %s", "error.code", Integer.valueOf(intent.getIntExtra("error.code", 0)));
        return new zza(intent.getIntExtra("install.status", 0), intent.getLongExtra("bytes.downloaded", 0L), intent.getLongExtra("total.bytes.to.download", 0L), intent.getIntExtra("error.code", 0), intent.getStringExtra("package.name"));
    }

    public abstract long bytesDownloaded();

    @InstallErrorCode
    public abstract int installErrorCode();

    @InstallStatus
    public abstract int installStatus();

    public abstract String packageName();

    public abstract long totalBytesToDownload();
}
