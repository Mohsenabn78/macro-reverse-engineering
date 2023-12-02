package com.google.android.gms.internal.nearby;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.provider.Settings;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.nearby.exposurenotification.DailySummariesConfig;
import com.google.android.gms.nearby.exposurenotification.DailySummary;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeyFileProvider;
import com.google.android.gms.nearby.exposurenotification.DiagnosisKeysDataMapping;
import com.google.android.gms.nearby.exposurenotification.ExposureConfiguration;
import com.google.android.gms.nearby.exposurenotification.ExposureInformation;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatus;
import com.google.android.gms.nearby.exposurenotification.ExposureNotificationStatusCodes;
import com.google.android.gms.nearby.exposurenotification.ExposureSummary;
import com.google.android.gms.nearby.exposurenotification.ExposureWindow;
import com.google.android.gms.nearby.exposurenotification.PackageConfiguration;
import com.google.android.gms.nearby.exposurenotification.TemporaryExposureKey;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-nearby@@18.7.0 */
/* loaded from: classes4.dex */
public final class zzax extends GoogleApi implements ExposureNotificationClient {
    public static final /* synthetic */ int zza = 0;
    private static final Api zzb = new Api("Nearby.EXPOSURE_NOTIFICATION_API", new zzap(), new Api.ClientKey());
    private static final long zzc;
    private static final long zzd;

    static {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        zzc = timeUnit.toMillis(2L);
        zzd = timeUnit.toMillis(60L);
    }

    public zzax(@NonNull Context context) {
        super(context, zzb, (Api.ApiOptions) null, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    private final Task zzb(final DiagnosisKeyFileProvider diagnosisKeyFileProvider, final ExposureConfiguration exposureConfiguration, final String str) {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzaf
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzax zzaxVar = zzax.this;
                ExposureConfiguration exposureConfiguration2 = exposureConfiguration;
                DiagnosisKeyFileProvider diagnosisKeyFileProvider2 = diagnosisKeyFileProvider;
                String str2 = str;
                zzed zzedVar = new zzed();
                zzedVar.zzb(exposureConfiguration2);
                zzedVar.zza(new zzat(zzaxVar, diagnosisKeyFileProvider2));
                zzedVar.zzd(new zzao((TaskCompletionSource) obj2));
                zzedVar.zze(str2);
                ((zzdr) ((zzn) obj).getService()).zzo(zzedVar.zzf());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzp).build()), zzd);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    @TargetApi(21)
    public final boolean deviceSupportsLocationlessScanning() {
        if (Settings.Global.getInt(getApplicationContext().getContentResolver(), "bluetooth_sanitized_exposure_notification_supported", 0) != 1) {
            return false;
        }
        return true;
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Integer> getCalibrationConfidence() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzz
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzak zzakVar = new zzak(zzax.this, (TaskCompletionSource) obj2);
                zzay zzayVar = new zzay();
                zzayVar.zza(zzakVar);
                ((zzdr) ((zzn) obj).getService()).zzd(zzayVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzl).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<DailySummary>> getDailySummaries(final DailySummariesConfig dailySummariesConfig) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzs
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzax zzaxVar = zzax.this;
                DailySummariesConfig dailySummariesConfig2 = dailySummariesConfig;
                zzaj zzajVar = new zzaj(zzaxVar, (TaskCompletionSource) obj2);
                zzbc zzbcVar = new zzbc();
                zzbcVar.zzb(zzajVar);
                zzbcVar.zza(dailySummariesConfig2);
                ((zzdr) ((zzn) obj).getService()).zze(zzbcVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzm).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<DiagnosisKeysDataMapping> getDiagnosisKeysDataMapping() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzab
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzal zzalVar = new zzal(zzax.this, (TaskCompletionSource) obj2);
                zzbg zzbgVar = new zzbg();
                zzbgVar.zza(zzalVar);
                ((zzdr) ((zzn) obj).getService()).zzf(zzbgVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzo).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureInformation>> getExposureInformation(final String str) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzaa
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzax zzaxVar = zzax.this;
                String str2 = str;
                zzaw zzawVar = new zzaw(zzaxVar, (TaskCompletionSource) obj2);
                zzbk zzbkVar = new zzbk();
                zzbkVar.zza(zzawVar);
                zzbkVar.zzb(str2);
                ((zzdr) ((zzn) obj).getService()).zzg(zzbkVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<ExposureSummary> getExposureSummary(final String str) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzad
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzax zzaxVar = zzax.this;
                String str2 = str;
                zzav zzavVar = new zzav(zzaxVar, (TaskCompletionSource) obj2);
                zzbo zzboVar = new zzbo();
                zzboVar.zza(zzavVar);
                zzboVar.zzb(str2);
                ((zzdr) ((zzn) obj).getService()).zzh(zzboVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureWindow>> getExposureWindows() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new zzac(this, ExposureNotificationClient.TOKEN_A)).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<PackageConfiguration> getPackageConfiguration() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzag
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzan zzanVar = new zzan(zzax.this, (TaskCompletionSource) obj2);
                zzbw zzbwVar = new zzbw();
                zzbwVar.zza(zzanVar);
                ((zzdr) ((zzn) obj).getService()).zzj(zzbwVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzq).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Set<ExposureNotificationStatus>> getStatus() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzq
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzam zzamVar = new zzam(zzax.this, (TaskCompletionSource) obj2);
                zzca zzcaVar = new zzca();
                zzcaVar.zza(zzamVar);
                ((zzdr) ((zzn) obj).getService()).zzk(zzcaVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzn).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<TemporaryExposureKey>> getTemporaryExposureKeyHistory() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzae
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzar zzarVar = new zzar(zzax.this, (TaskCompletionSource) obj2);
                zzce zzceVar = new zzce();
                zzceVar.zza(zzarVar);
                ((zzdr) ((zzn) obj).getService()).zzl(zzceVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Long> getVersion() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new zzr(this)).setFeatures(com.google.android.gms.nearby.zza.zzk).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Boolean> isEnabled() {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzu
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzaq zzaqVar = new zzaq(zzax.this, (TaskCompletionSource) obj2);
                zzdz zzdzVar = new zzdz();
                zzdzVar.zza(zzaqVar);
                ((zzdr) ((zzn) obj).getService()).zzn(zzdzVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(DiagnosisKeyFileProvider diagnosisKeyFileProvider) {
        return zzb(diagnosisKeyFileProvider, new ExposureConfiguration.ExposureConfigurationBuilder().build(), ExposureNotificationClient.TOKEN_A);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> requestPreAuthorizedTemporaryExposureKeyHistory() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzy
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzax.zza;
                zzeh zzehVar = new zzeh();
                zzehVar.zza(false);
                zzehVar.zzb(new zzao((TaskCompletionSource) obj2));
                ((zzdr) ((zzn) obj).getService()).zzp(zzehVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzr).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> requestPreAuthorizedTemporaryExposureKeyHistoryForSelfReport() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzt
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzax.zza;
                zzeh zzehVar = new zzeh();
                zzehVar.zza(true);
                zzehVar.zzb(new zzao((TaskCompletionSource) obj2));
                ((zzdr) ((zzn) obj).getService()).zzp(zzehVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzs).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> requestPreAuthorizedTemporaryExposureKeyRelease() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzo
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzax.zza;
                zzel zzelVar = new zzel();
                zzelVar.zza(new zzao((TaskCompletionSource) obj2));
                ((zzdr) ((zzn) obj).getService()).zzq(zzelVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzr).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> setDiagnosisKeysDataMapping(final DiagnosisKeysDataMapping diagnosisKeysDataMapping) {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzx
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                DiagnosisKeysDataMapping diagnosisKeysDataMapping2 = DiagnosisKeysDataMapping.this;
                int i4 = zzax.zza;
                zzep zzepVar = new zzep();
                zzepVar.zzb(new zzao((TaskCompletionSource) obj2));
                zzepVar.zza(diagnosisKeysDataMapping2);
                ((zzdr) ((zzn) obj).getService()).zzr(zzepVar.zzc());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzo).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> start() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzw
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzax.zza;
                zzet zzetVar = new zzet();
                zzetVar.zza(new zzao((TaskCompletionSource) obj2));
                ((zzdr) ((zzn) obj).getService()).zzs(zzetVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> stop() {
        return zzfd.zza(doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzp
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                int i4 = zzax.zza;
                zzex zzexVar = new zzex();
                zzexVar.zza(new zzao((TaskCompletionSource) obj2));
                ((zzdr) ((zzn) obj).getService()).zzt(zzexVar.zzb());
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final /* synthetic */ Task zza(final List list, final ExposureConfiguration exposureConfiguration, final String str, Task task) throws Exception {
        if (((Long) task.getResult()).longValue() >= 17203704004L) {
            return zzb(new DiagnosisKeyFileProvider(list), exposureConfiguration, str);
        }
        return doWrite(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.nearby.zzah
            @Override // com.google.android.gms.common.api.internal.RemoteCall
            public final void accept(Object obj, Object obj2) {
                zzax zzaxVar = zzax.this;
                List<File> list2 = list;
                ExposureConfiguration exposureConfiguration2 = exposureConfiguration;
                String str2 = str;
                zzn zznVar = (zzn) obj;
                TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                ArrayList arrayList = new ArrayList(list2.size());
                try {
                    for (File file : list2) {
                        arrayList.add(ParcelFileDescriptor.open(file, 268435456));
                    }
                    zzed zzedVar = new zzed();
                    zzedVar.zzc(arrayList);
                    zzedVar.zzb(exposureConfiguration2);
                    zzedVar.zzd(new zzas(zzaxVar, arrayList, taskCompletionSource));
                    zzedVar.zze(str2);
                    ((zzdr) zznVar.getService()).zzo(zzedVar.zzf());
                } catch (FileNotFoundException e4) {
                    TaskUtil.setResultOrApiException(new Status((int) ExposureNotificationStatusCodes.FAILED_DISK_IO, e4.getMessage()), taskCompletionSource);
                }
            }
        }).setFeatures(com.google.android.gms.nearby.zza.zzi).build());
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(List<File> list) {
        return zzfd.zza(zzfd.zza(doRead(TaskApiCall.builder().run(new zzr(this)).setFeatures(com.google.android.gms.nearby.zza.zzk).build()), zzc).continueWithTask(new zzv(this, list, new ExposureConfiguration.ExposureConfigurationBuilder().build(), ExposureNotificationClient.TOKEN_A)), zzd);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<List<ExposureWindow>> getExposureWindows(String str) {
        return zzfd.zza(doRead(TaskApiCall.builder().run(new zzac(this, str)).setFeatures(com.google.android.gms.nearby.zza.zzi).build()), zzc);
    }

    @Override // com.google.android.gms.nearby.exposurenotification.ExposureNotificationClient
    public final Task<Void> provideDiagnosisKeys(List<File> list, ExposureConfiguration exposureConfiguration, String str) {
        return zzfd.zza(zzfd.zza(doRead(TaskApiCall.builder().run(new zzr(this)).setFeatures(com.google.android.gms.nearby.zza.zzk).build()), zzc).continueWithTask(new zzv(this, list, exposureConfiguration, str)), zzd);
    }
}
