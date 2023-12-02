package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabf  reason: invalid package */
/* loaded from: classes4.dex */
final class zzabf extends zzaby implements zzacp {
    @VisibleForTesting
    zzabg zza;
    private zzaaz zzb;
    private zzaba zzc;
    private zzacd zzd;
    private final zzabe zze;
    private final FirebaseApp zzf;
    private final String zzg;

    /* JADX INFO: Access modifiers changed from: package-private */
    @VisibleForTesting
    public zzabf(FirebaseApp firebaseApp, zzabe zzabeVar, zzacd zzacdVar, zzaaz zzaazVar, zzaba zzabaVar) {
        this.zzf = firebaseApp;
        String apiKey = firebaseApp.getOptions().getApiKey();
        this.zzg = apiKey;
        this.zze = (zzabe) Preconditions.checkNotNull(zzabeVar);
        zzy(null, null, null);
        zzacq.zze(apiKey, this);
    }

    @NonNull
    private final zzabg zzx() {
        if (this.zza == null) {
            FirebaseApp firebaseApp = this.zzf;
            this.zza = new zzabg(firebaseApp.getApplicationContext(), firebaseApp, this.zze.zzb());
        }
        return this.zza;
    }

    private final void zzy(zzacd zzacdVar, zzaaz zzaazVar, zzaba zzabaVar) {
        this.zzd = null;
        this.zzb = null;
        this.zzc = null;
        String zza = zzacn.zza("firebear.secureToken");
        if (TextUtils.isEmpty(zza)) {
            zza = zzacq.zzd(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for secureToken URL: ".concat(String.valueOf(zza)));
        }
        if (this.zzd == null) {
            this.zzd = new zzacd(zza, zzx());
        }
        String zza2 = zzacn.zza("firebear.identityToolkit");
        if (TextUtils.isEmpty(zza2)) {
            zza2 = zzacq.zzb(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkit URL: ".concat(String.valueOf(zza2)));
        }
        if (this.zzb == null) {
            this.zzb = new zzaaz(zza2, zzx());
        }
        String zza3 = zzacn.zza("firebear.identityToolkitV2");
        if (TextUtils.isEmpty(zza3)) {
            zza3 = zzacq.zzc(this.zzg);
        } else {
            Log.e("LocalClient", "Found hermetic configuration for identityToolkitV2 URL: ".concat(String.valueOf(zza3)));
        }
        if (this.zzc == null) {
            this.zzc = new zzaba(zza3, zzx());
        }
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zza(zzacu zzacuVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzacuVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/createAuthUri", this.zzg), zzacuVar, zzabxVar, zzacv.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzb(zzacw zzacwVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzacwVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/deleteAccount", this.zzg), zzacwVar, zzabxVar, Void.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzc(zzacx zzacxVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzacxVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/emailLinkSignin", this.zzg), zzacxVar, zzabxVar, zzacy.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzd(zzacz zzaczVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaczVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaba zzabaVar = this.zzc;
        zzaca.zzb(zzabaVar.zza("/accounts/mfaEnrollment:finalize", this.zzg), zzaczVar, zzabxVar, zzada.class, zzabaVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zze(zzadb zzadbVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzadbVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaba zzabaVar = this.zzc;
        zzaca.zzb(zzabaVar.zza("/accounts/mfaSignIn:finalize", this.zzg), zzadbVar, zzabxVar, zzadc.class, zzabaVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzf(zzadi zzadiVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzadiVar);
        Preconditions.checkNotNull(zzabxVar);
        zzacd zzacdVar = this.zzd;
        zzaca.zzb(zzacdVar.zza("/token", this.zzg), zzadiVar, zzabxVar, zzadu.class, zzacdVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzg(zzadj zzadjVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzadjVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/getAccountInfo", this.zzg), zzadjVar, zzabxVar, zzadk.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzh(zzadn zzadnVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzadnVar);
        Preconditions.checkNotNull(zzabxVar);
        if (zzadnVar.zzb() != null) {
            zzx().zzc(zzadnVar.zzb().zze());
        }
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/getOobConfirmationCode", this.zzg), zzadnVar, zzabxVar, zzado.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzi(zzadp zzadpVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzadpVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zza(zzaazVar.zza("/getRecaptchaParam", this.zzg), zzabxVar, zzadq.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzj(zzads zzadsVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzadsVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaba zzabaVar = this.zzc;
        String zza = zzabaVar.zza("/recaptchaConfig", this.zzg);
        String zzc = zzadsVar.zzc();
        String zzd = zzadsVar.zzd();
        zzaca.zza(zza + "&clientType=" + zzc + "&version=" + zzd, zzabxVar, zzadt.class, zzabaVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzacp
    public final void zzk() {
        zzy(null, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzl(zzaec zzaecVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaecVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/resetPassword", this.zzg), zzaecVar, zzabxVar, zzaed.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzm(zzaee zzaeeVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaeeVar);
        Preconditions.checkNotNull(zzabxVar);
        if (!TextUtils.isEmpty(zzaeeVar.zzc())) {
            zzx().zzc(zzaeeVar.zzc());
        }
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/sendVerificationCode", this.zzg), zzaeeVar, zzabxVar, zzaef.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzn(zzaeg zzaegVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaegVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/setAccountInfo", this.zzg), zzaegVar, zzabxVar, zzaeh.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzo(@Nullable String str, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzabxVar);
        zzx().zzb(str);
        ((zzyj) zzabxVar).zza.zzo();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzp(zzaei zzaeiVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaeiVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/signupNewUser", this.zzg), zzaeiVar, zzabxVar, zzaej.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzq(zzaek zzaekVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaekVar);
        Preconditions.checkNotNull(zzabxVar);
        if (zzaekVar instanceof zzaeo) {
            zzaeo zzaeoVar = (zzaeo) zzaekVar;
            if (!TextUtils.isEmpty(zzaeoVar.zzc())) {
                zzx().zzc(zzaeoVar.zzc());
            }
        }
        zzaba zzabaVar = this.zzc;
        zzaca.zzb(zzabaVar.zza("/accounts/mfaEnrollment:start", this.zzg), zzaekVar, zzabxVar, zzael.class, zzabaVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzr(zzaem zzaemVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaemVar);
        Preconditions.checkNotNull(zzabxVar);
        if (!TextUtils.isEmpty(zzaemVar.zzc())) {
            zzx().zzc(zzaemVar.zzc());
        }
        zzaba zzabaVar = this.zzc;
        zzaca.zzb(zzabaVar.zza("/accounts/mfaSignIn:start", this.zzg), zzaemVar, zzabxVar, zzaen.class, zzabaVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzs(zzaev zzaevVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaevVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/verifyAssertion", this.zzg), zzaevVar, zzabxVar, zzaex.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzt(zzaey zzaeyVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzaeyVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/verifyCustomToken", this.zzg), zzaeyVar, zzabxVar, zzaez.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzu(zzafa zzafaVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzafaVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/verifyPassword", this.zzg), zzafaVar, zzabxVar, zzafb.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzv(zzafc zzafcVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzafcVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaaz zzaazVar = this.zzb;
        zzaca.zzb(zzaazVar.zza("/verifyPhoneNumber", this.zzg), zzafcVar, zzabxVar, zzafd.class, zzaazVar.zzb);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaby
    public final void zzw(zzafe zzafeVar, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzafeVar);
        Preconditions.checkNotNull(zzabxVar);
        zzaba zzabaVar = this.zzc;
        zzaca.zzb(zzabaVar.zza("/accounts/mfaEnrollment:withdraw", this.zzg), zzafeVar, zzabxVar, zzaff.class, zzabaVar.zzb);
    }
}
