package com.google.android.recaptcha.internal;

import com.google.android.recaptcha.RecaptchaErrorCode;
import com.google.android.recaptcha.RecaptchaException;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.s;
import org.jetbrains.annotations.NotNull;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzh extends Exception {
    @NotNull
    public static final zzg zza = new zzg(null);
    @NotNull
    private static final Map zzb;
    @NotNull
    private final zzf zzc;
    @NotNull
    private final zzd zzd;
    @NotNull
    private final Map zze;

    static {
        Map mapOf;
        zzmf zzmfVar = zzmf.JS_INTERNAL_ERROR;
        zzf zzfVar = zzf.zzc;
        mapOf = s.mapOf(TuplesKt.to(zzmf.JS_NETWORK_ERROR, new zzh(zzf.zze, zzd.zzm)), TuplesKt.to(zzmfVar, new zzh(zzfVar, zzd.zzk)), TuplesKt.to(zzmf.JS_INVALID_SITE_KEY, new zzh(zzf.zzf, zzd.zzn)), TuplesKt.to(zzmf.JS_INVALID_SITE_KEY_TYPE, new zzh(zzf.zzg, zzd.zzo)), TuplesKt.to(zzmf.JS_THIRD_PARTY_APP_PACKAGE_NAME_NOT_ALLOWED, new zzh(zzf.zzh, zzd.zzp)), TuplesKt.to(zzmf.JS_INVALID_ACTION, new zzh(zzf.zzi, zzd.zzq)), TuplesKt.to(zzmf.JS_PROGRAM_ERROR, new zzh(zzfVar, zzd.zzv)));
        zzb = mapOf;
    }

    public zzh(@NotNull zzf zzfVar, @NotNull zzd zzdVar) {
        Map mapOf;
        this.zzc = zzfVar;
        this.zzd = zzdVar;
        mapOf = s.mapOf(TuplesKt.to(zzf.zze, new RecaptchaException(RecaptchaErrorCode.NETWORK_ERROR, null, 2, null)), TuplesKt.to(zzf.zzf, new RecaptchaException(RecaptchaErrorCode.INVALID_SITEKEY, null, 2, null)), TuplesKt.to(zzf.zzg, new RecaptchaException(RecaptchaErrorCode.INVALID_KEYTYPE, null, 2, null)), TuplesKt.to(zzf.zzh, new RecaptchaException(RecaptchaErrorCode.INVALID_PACKAGE_NAME, null, 2, null)), TuplesKt.to(zzf.zzi, new RecaptchaException(RecaptchaErrorCode.INVALID_ACTION, null, 2, null)), TuplesKt.to(zzf.zzc, new RecaptchaException(RecaptchaErrorCode.INTERNAL_ERROR, null, 2, null)));
        this.zze = mapOf;
    }

    @NotNull
    public final zzd zza() {
        return this.zzd;
    }

    @NotNull
    public final zzf zzb() {
        return this.zzc;
    }

    @NotNull
    public final RecaptchaException zzc() {
        RecaptchaException recaptchaException = (RecaptchaException) this.zze.get(this.zzc);
        if (recaptchaException == null) {
            return new RecaptchaException(RecaptchaErrorCode.UNKNOWN_ERROR, null, 2, null);
        }
        return recaptchaException;
    }
}
