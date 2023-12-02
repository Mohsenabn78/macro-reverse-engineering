package com.google.android.gms.common.moduleinstall;

import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.OptionalModuleApi;
import com.google.android.gms.tasks.Task;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
/* loaded from: classes4.dex */
public interface ModuleInstallClient extends HasApiKey<Api.ApiOptions.NoOptions> {
    @NonNull
    Task<ModuleAvailabilityResponse> areModulesAvailable(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    Task<Void> deferredInstall(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    Task<ModuleInstallIntentResponse> getInstallModulesIntent(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    @ResultIgnorabilityUnspecified
    Task<ModuleInstallResponse> installModules(@NonNull ModuleInstallRequest moduleInstallRequest);

    @NonNull
    Task<Void> releaseModules(@NonNull OptionalModuleApi... optionalModuleApiArr);

    @NonNull
    @ResultIgnorabilityUnspecified
    Task<Boolean> unregisterListener(@NonNull InstallStatusListener installStatusListener);
}
