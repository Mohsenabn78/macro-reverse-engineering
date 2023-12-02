package com.google.android.gms.nearby.exposurenotification;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.io.File;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public interface ExposureNotificationClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    @NonNull
    public static final String ACTION_EXPOSURE_NOTIFICATION_SETTINGS = "com.google.android.gms.settings.EXPOSURE_NOTIFICATION_SETTINGS";
    @NonNull
    public static final String ACTION_EXPOSURE_NOT_FOUND = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_NOT_FOUND";
    @NonNull
    public static final String ACTION_EXPOSURE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_EXPOSURE_STATE_UPDATED";
    @NonNull
    public static final String ACTION_PRE_AUTHORIZE_RELEASE_PHONE_UNLOCKED = "com.google.android.gms.exposurenotification.ACTION_PRE_AUTHORIZE_RELEASE_PHONE_UNLOCKED";
    @NonNull
    public static final String ACTION_SERVICE_STATE_UPDATED = "com.google.android.gms.exposurenotification.ACTION_SERVICE_STATE_UPDATED";
    @NonNull
    @Deprecated
    public static final String EXTRA_EXPOSURE_SUMMARY = "com.google.android.gms.exposurenotification.EXTRA_EXPOSURE_SUMMARY";
    @NonNull
    public static final String EXTRA_IS_FROM_PRE_AUTHORIZATION = "com.google.android.gms.exposurenotification.EXTRA_IS_FROM_PRE_AUTHORIZATION";
    @NonNull
    public static final String EXTRA_SERVICE_STATE = "com.google.android.gms.exposurenotification.EXTRA_SERVICE_STATE";
    @NonNull
    public static final String EXTRA_TEMPORARY_EXPOSURE_KEY_LIST = "com.google.android.gms.exposurenotification.EXTRA_TEMPORARY_EXPOSURE_KEY_LIST";
    @NonNull
    @Deprecated
    public static final String EXTRA_TOKEN = "com.google.android.gms.exposurenotification.EXTRA_TOKEN";
    @NonNull
    @Deprecated
    public static final String TOKEN_A = "TYZWQ32170AXEUVCDW7A";

    @Deprecated
    boolean deviceSupportsLocationlessScanning();

    @NonNull
    Task<Integer> getCalibrationConfidence();

    @NonNull
    Task<List<DailySummary>> getDailySummaries(@NonNull DailySummariesConfig dailySummariesConfig);

    @NonNull
    Task<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping();

    @NonNull
    @Deprecated
    Task<List<ExposureInformation>> getExposureInformation(@NonNull String str);

    @NonNull
    @Deprecated
    Task<ExposureSummary> getExposureSummary(@NonNull String str);

    @NonNull
    Task<List<ExposureWindow>> getExposureWindows();

    @NonNull
    @Deprecated
    Task<List<ExposureWindow>> getExposureWindows(@NonNull String str);

    @NonNull
    Task<PackageConfiguration> getPackageConfiguration();

    @NonNull
    Task<Set<ExposureNotificationStatus>> getStatus();

    @NonNull
    Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory();

    @NonNull
    Task<Long> getVersion();

    @NonNull
    Task<Boolean> isEnabled();

    @NonNull
    Task<Void> provideDiagnosisKeys(@NonNull DiagnosisKeyFileProvider diagnosisKeyFileProvider);

    @NonNull
    Task<Void> provideDiagnosisKeys(@NonNull List<File> list);

    @NonNull
    @Deprecated
    Task<Void> provideDiagnosisKeys(@NonNull List<File> list, @NonNull ExposureConfiguration exposureConfiguration, @NonNull String str);

    @NonNull
    Task<Void> requestPreAuthorizedTemporaryExposureKeyHistory();

    @NonNull
    Task<Void> requestPreAuthorizedTemporaryExposureKeyHistoryForSelfReport();

    @NonNull
    Task<Void> requestPreAuthorizedTemporaryExposureKeyRelease();

    @NonNull
    Task<Void> setDiagnosisKeysDataMapping(@NonNull DiagnosisKeysDataMapping diagnosisKeysDataMapping);

    @NonNull
    Task<Void> start();

    @NonNull
    Task<Void> stop();
}
