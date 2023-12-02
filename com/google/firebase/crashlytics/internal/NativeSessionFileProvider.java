package com.google.firebase.crashlytics.internal;

import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.File;

/* loaded from: classes5.dex */
public interface NativeSessionFileProvider {
    @Nullable
    File getAppFile();

    @Nullable
    CrashlyticsReport.ApplicationExitInfo getApplicationExitInto();

    @Nullable
    File getBinaryImagesFile();

    @Nullable
    File getDeviceFile();

    @Nullable
    File getMetadataFile();

    @Nullable
    File getMinidumpFile();

    @Nullable
    File getOsFile();

    @Nullable
    File getSessionFile();
}
