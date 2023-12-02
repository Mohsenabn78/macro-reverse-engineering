package com.google.android.gms.internal.consent_sdk;

import android.app.Activity;
import android.app.Application;
import com.google.android.ump.ConsentDebugSettings;
import com.google.android.ump.ConsentRequestParameters;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.ump:user-messaging-platform@@2.0.0 */
/* loaded from: classes4.dex */
public final class zzn {
    private final Application zza;
    private final zzb zzb;
    private final zzam zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzn(Application application, zzb zzbVar, zzam zzamVar) {
        this.zza = application;
        this.zzb = zzbVar;
        this.zzc = zzamVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbu zzd(Activity activity, ConsentRequestParameters consentRequestParameters) throws zzj {
        ConsentDebugSettings consentDebugSettings = consentRequestParameters.getConsentDebugSettings();
        if (consentDebugSettings == null) {
            consentDebugSettings = new ConsentDebugSettings.Builder(this.zza).build();
        }
        return zzo.zza(new zzo(this, activity, consentDebugSettings, consentRequestParameters, null));
    }
}
