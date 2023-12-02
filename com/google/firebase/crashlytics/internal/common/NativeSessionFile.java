package com.google.firebase.crashlytics.internal.common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import java.io.InputStream;

/* loaded from: classes5.dex */
interface NativeSessionFile {
    @NonNull
    String a();

    @Nullable
    InputStream b();

    @Nullable
    CrashlyticsReport.FilesPayload.File c();
}
