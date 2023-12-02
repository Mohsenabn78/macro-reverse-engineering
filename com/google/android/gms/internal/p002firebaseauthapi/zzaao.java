package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzan;
import com.google.firebase.auth.internal.zzbc;
import com.google.firebase.auth.internal.zzbx;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzt;
import com.google.firebase.auth.internal.zzx;
import com.google.firebase.auth.internal.zzz;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaao  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaao extends zzabv {
    public zzaao(FirebaseApp firebaseApp, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.zza = new zzaar(firebaseApp, scheduledExecutorService);
        this.zzb = executor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    @VisibleForTesting
    public static zzx zzS(FirebaseApp firebaseApp, zzadl zzadlVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzadlVar);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzt(zzadlVar, "firebase"));
        List zzr = zzadlVar.zzr();
        if (zzr != null && !zzr.isEmpty()) {
            for (int i4 = 0; i4 < zzr.size(); i4++) {
                arrayList.add(new zzt((zzadz) zzr.get(i4)));
            }
        }
        zzx zzxVar = new zzx(firebaseApp, arrayList);
        zzxVar.zzr(new zzz(zzadlVar.zzb(), zzadlVar.zza()));
        zzxVar.zzq(zzadlVar.zzt());
        zzxVar.zzp(zzadlVar.zzd());
        zzxVar.zzi(zzbc.zzb(zzadlVar.zzq()));
        return zzxVar;
    }

    @NonNull
    public final Task zzA(@Nullable String str) {
        return zzU(new zzzu(str));
    }

    public final Task zzB(FirebaseApp firebaseApp, zzg zzgVar, @Nullable String str) {
        zzzv zzzvVar = new zzzv(str);
        zzzvVar.zzf(firebaseApp);
        zzzvVar.zzd(zzgVar);
        return zzU(zzzvVar);
    }

    public final Task zzC(FirebaseApp firebaseApp, AuthCredential authCredential, @Nullable String str, zzg zzgVar) {
        zzzw zzzwVar = new zzzw(authCredential, str);
        zzzwVar.zzf(firebaseApp);
        zzzwVar.zzd(zzgVar);
        return zzU(zzzwVar);
    }

    public final Task zzD(FirebaseApp firebaseApp, String str, @Nullable String str2, zzg zzgVar) {
        zzzx zzzxVar = new zzzx(str, str2);
        zzzxVar.zzf(firebaseApp);
        zzzxVar.zzd(zzgVar);
        return zzU(zzzxVar);
    }

    public final Task zzE(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3, @Nullable String str4, zzg zzgVar) {
        zzzy zzzyVar = new zzzy(str, str2, str3, str4);
        zzzyVar.zzf(firebaseApp);
        zzzyVar.zzd(zzgVar);
        return zzU(zzzyVar);
    }

    public final Task zzF(FirebaseApp firebaseApp, EmailAuthCredential emailAuthCredential, @Nullable String str, zzg zzgVar) {
        zzzz zzzzVar = new zzzz(emailAuthCredential, str);
        zzzzVar.zzf(firebaseApp);
        zzzzVar.zzd(zzgVar);
        return zzU(zzzzVar);
    }

    public final Task zzG(FirebaseApp firebaseApp, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzg zzgVar) {
        zzacg.zzc();
        zzaaa zzaaaVar = new zzaaa(phoneAuthCredential, str);
        zzaaaVar.zzf(firebaseApp);
        zzaaaVar.zzd(zzgVar);
        return zzU(zzaaaVar);
    }

    public final Task zzH(zzag zzagVar, String str, @Nullable String str2, long j4, boolean z3, boolean z4, @Nullable String str3, @Nullable String str4, boolean z5, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, @Nullable Activity activity) {
        zzaab zzaabVar = new zzaab(zzagVar, str, str2, j4, z3, z4, str3, str4, z5);
        zzaabVar.zzh(onVerificationStateChangedCallbacks, activity, executor, str);
        return zzU(zzaabVar);
    }

    public final Task zzI(zzag zzagVar, @Nullable String str) {
        return zzU(new zzaac(zzagVar, str));
    }

    public final Task zzJ(zzag zzagVar, PhoneMultiFactorInfo phoneMultiFactorInfo, @Nullable String str, long j4, boolean z3, boolean z4, @Nullable String str2, @Nullable String str3, boolean z5, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Executor executor, @Nullable Activity activity) {
        zzaad zzaadVar = new zzaad(phoneMultiFactorInfo, Preconditions.checkNotEmpty(zzagVar.zze()), str, j4, z3, z4, str2, str3, z5);
        zzaadVar.zzh(onVerificationStateChangedCallbacks, activity, executor, phoneMultiFactorInfo.getUid());
        return zzU(zzaadVar);
    }

    public final Task zzK(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, @Nullable String str2, zzbx zzbxVar) {
        zzaae zzaaeVar = new zzaae(firebaseUser.zzf(), str, str2);
        zzaaeVar.zzf(firebaseApp);
        zzaaeVar.zzg(firebaseUser);
        zzaaeVar.zzd(zzbxVar);
        zzaaeVar.zze(zzbxVar);
        return zzU(zzaaeVar);
    }

    public final Task zzL(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbxVar) {
        char c4;
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbxVar);
        List zzg = firebaseUser.zzg();
        if ((zzg != null && !zzg.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzaas.zza(new Status((int) FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        if (str.hashCode() == 1216985755 && str.equals("password")) {
            c4 = 0;
        } else {
            c4 = 65535;
        }
        if (c4 != 0) {
            zzaag zzaagVar = new zzaag(str);
            zzaagVar.zzf(firebaseApp);
            zzaagVar.zzg(firebaseUser);
            zzaagVar.zzd(zzbxVar);
            zzaagVar.zze(zzbxVar);
            return zzU(zzaagVar);
        }
        zzaaf zzaafVar = new zzaaf();
        zzaafVar.zzf(firebaseApp);
        zzaafVar.zzg(firebaseUser);
        zzaafVar.zzd(zzbxVar);
        zzaafVar.zze(zzbxVar);
        return zzU(zzaafVar);
    }

    public final Task zzM(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbxVar) {
        zzaah zzaahVar = new zzaah(str);
        zzaahVar.zzf(firebaseApp);
        zzaahVar.zzg(firebaseUser);
        zzaahVar.zzd(zzbxVar);
        zzaahVar.zze(zzbxVar);
        return zzU(zzaahVar);
    }

    public final Task zzN(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbxVar) {
        zzaai zzaaiVar = new zzaai(str);
        zzaaiVar.zzf(firebaseApp);
        zzaaiVar.zzg(firebaseUser);
        zzaaiVar.zzd(zzbxVar);
        zzaaiVar.zze(zzbxVar);
        return zzU(zzaaiVar);
    }

    public final Task zzO(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, zzbx zzbxVar) {
        zzacg.zzc();
        zzaaj zzaajVar = new zzaaj(phoneAuthCredential);
        zzaajVar.zzf(firebaseApp);
        zzaajVar.zzg(firebaseUser);
        zzaajVar.zzd(zzbxVar);
        zzaajVar.zze(zzbxVar);
        return zzU(zzaajVar);
    }

    public final Task zzP(FirebaseApp firebaseApp, FirebaseUser firebaseUser, UserProfileChangeRequest userProfileChangeRequest, zzbx zzbxVar) {
        zzaak zzaakVar = new zzaak(userProfileChangeRequest);
        zzaakVar.zzf(firebaseApp);
        zzaakVar.zzg(firebaseUser);
        zzaakVar.zzd(zzbxVar);
        zzaakVar.zze(zzbxVar);
        return zzU(zzaakVar);
    }

    public final Task zzQ(String str, String str2, ActionCodeSettings actionCodeSettings) {
        actionCodeSettings.zzg(7);
        return zzU(new zzaal(str, str2, actionCodeSettings));
    }

    public final Task zzR(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzaam zzaamVar = new zzaam(str, str2);
        zzaamVar.zzf(firebaseApp);
        return zzU(zzaamVar);
    }

    public final void zzT(FirebaseApp firebaseApp, zzaee zzaeeVar, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor) {
        zzaan zzaanVar = new zzaan(zzaeeVar);
        zzaanVar.zzf(firebaseApp);
        zzaanVar.zzh(onVerificationStateChangedCallbacks, activity, executor, zzaeeVar.zzd());
        zzU(zzaanVar);
    }

    public final Task zza(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzyu zzyuVar = new zzyu(str, str2);
        zzyuVar.zzf(firebaseApp);
        return zzU(zzyuVar);
    }

    public final Task zzb(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzyv zzyvVar = new zzyv(str, str2);
        zzyvVar.zzf(firebaseApp);
        return zzU(zzyvVar);
    }

    public final Task zzc(FirebaseApp firebaseApp, String str, String str2, @Nullable String str3) {
        zzyw zzywVar = new zzyw(str, str2, str3);
        zzywVar.zzf(firebaseApp);
        return zzU(zzywVar);
    }

    public final Task zzd(FirebaseApp firebaseApp, String str, String str2, String str3, @Nullable String str4, zzg zzgVar) {
        zzyx zzyxVar = new zzyx(str, str2, str3, str4);
        zzyxVar.zzf(firebaseApp);
        zzyxVar.zzd(zzgVar);
        return zzU(zzyxVar);
    }

    @NonNull
    public final Task zze(FirebaseUser firebaseUser, zzan zzanVar) {
        zzyy zzyyVar = new zzyy();
        zzyyVar.zzg(firebaseUser);
        zzyyVar.zzd(zzanVar);
        zzyyVar.zze(zzanVar);
        return zzU(zzyyVar);
    }

    public final Task zzf(FirebaseApp firebaseApp, String str, @Nullable String str2) {
        zzyz zzyzVar = new zzyz(str, str2);
        zzyzVar.zzf(firebaseApp);
        return zzU(zzyzVar);
    }

    public final Task zzg(FirebaseApp firebaseApp, PhoneMultiFactorAssertion phoneMultiFactorAssertion, FirebaseUser firebaseUser, @Nullable String str, zzg zzgVar) {
        zzacg.zzc();
        zzza zzzaVar = new zzza(phoneMultiFactorAssertion, firebaseUser.zzf(), str, null);
        zzzaVar.zzf(firebaseApp);
        zzzaVar.zzd(zzgVar);
        return zzU(zzzaVar);
    }

    public final Task zzh(FirebaseApp firebaseApp, TotpMultiFactorAssertion totpMultiFactorAssertion, FirebaseUser firebaseUser, @Nullable String str, @Nullable String str2, zzg zzgVar) {
        zzza zzzaVar = new zzza(totpMultiFactorAssertion, firebaseUser.zzf(), str, str2);
        zzzaVar.zzf(firebaseApp);
        zzzaVar.zzd(zzgVar);
        return zzU(zzzaVar);
    }

    public final Task zzi(FirebaseApp firebaseApp, @Nullable FirebaseUser firebaseUser, PhoneMultiFactorAssertion phoneMultiFactorAssertion, String str, zzg zzgVar) {
        zzacg.zzc();
        zzzb zzzbVar = new zzzb(phoneMultiFactorAssertion, str, null);
        zzzbVar.zzf(firebaseApp);
        zzzbVar.zzd(zzgVar);
        if (firebaseUser != null) {
            zzzbVar.zzg(firebaseUser);
        }
        return zzU(zzzbVar);
    }

    public final Task zzj(FirebaseApp firebaseApp, @Nullable FirebaseUser firebaseUser, TotpMultiFactorAssertion totpMultiFactorAssertion, String str, @Nullable String str2, zzg zzgVar) {
        zzzb zzzbVar = new zzzb(totpMultiFactorAssertion, str, str2);
        zzzbVar.zzf(firebaseApp);
        zzzbVar.zzd(zzgVar);
        if (firebaseUser != null) {
            zzzbVar.zzg(firebaseUser);
        }
        return zzU(zzzbVar);
    }

    public final Task zzk(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, zzbx zzbxVar) {
        zzzc zzzcVar = new zzzc(str);
        zzzcVar.zzf(firebaseApp);
        zzzcVar.zzg(firebaseUser);
        zzzcVar.zzd(zzbxVar);
        zzzcVar.zze(zzbxVar);
        return zzU(zzzcVar);
    }

    public final Task zzl() {
        return zzU(new zzzd());
    }

    public final Task zzm(@Nullable String str, String str2) {
        return zzU(new zzze(str, "RECAPTCHA_ENTERPRISE"));
    }

    public final Task zzn(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, zzbx zzbxVar) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzbxVar);
        List zzg = firebaseUser.zzg();
        if (zzg != null && zzg.contains(authCredential.getProvider())) {
            return Tasks.forException(zzaas.zza(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzg()) {
                zzzf zzzfVar = new zzzf(emailAuthCredential);
                zzzfVar.zzf(firebaseApp);
                zzzfVar.zzg(firebaseUser);
                zzzfVar.zzd(zzbxVar);
                zzzfVar.zze(zzbxVar);
                return zzU(zzzfVar);
            }
            zzzi zzziVar = new zzzi(emailAuthCredential);
            zzziVar.zzf(firebaseApp);
            zzziVar.zzg(firebaseUser);
            zzziVar.zzd(zzbxVar);
            zzziVar.zze(zzbxVar);
            return zzU(zzziVar);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzacg.zzc();
            zzzh zzzhVar = new zzzh((PhoneAuthCredential) authCredential);
            zzzhVar.zzf(firebaseApp);
            zzzhVar.zzg(firebaseUser);
            zzzhVar.zzd(zzbxVar);
            zzzhVar.zze(zzbxVar);
            return zzU(zzzhVar);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzbxVar);
            zzzg zzzgVar = new zzzg(authCredential);
            zzzgVar.zzf(firebaseApp);
            zzzgVar.zzg(firebaseUser);
            zzzgVar.zzd(zzbxVar);
            zzzgVar.zze(zzbxVar);
            return zzU(zzzgVar);
        }
    }

    public final Task zzo(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzbx zzbxVar) {
        zzzj zzzjVar = new zzzj(authCredential, str);
        zzzjVar.zzf(firebaseApp);
        zzzjVar.zzg(firebaseUser);
        zzzjVar.zzd(zzbxVar);
        zzzjVar.zze(zzbxVar);
        return zzU(zzzjVar);
    }

    public final Task zzp(FirebaseApp firebaseApp, FirebaseUser firebaseUser, AuthCredential authCredential, @Nullable String str, zzbx zzbxVar) {
        zzzk zzzkVar = new zzzk(authCredential, str);
        zzzkVar.zzf(firebaseApp);
        zzzkVar.zzg(firebaseUser);
        zzzkVar.zzd(zzbxVar);
        zzzkVar.zze(zzbxVar);
        return zzU(zzzkVar);
    }

    public final Task zzq(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, @Nullable String str, zzbx zzbxVar) {
        zzzl zzzlVar = new zzzl(emailAuthCredential, str);
        zzzlVar.zzf(firebaseApp);
        zzzlVar.zzg(firebaseUser);
        zzzlVar.zzd(zzbxVar);
        zzzlVar.zze(zzbxVar);
        return zzU(zzzlVar);
    }

    public final Task zzr(FirebaseApp firebaseApp, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential, @Nullable String str, zzbx zzbxVar) {
        zzzm zzzmVar = new zzzm(emailAuthCredential, str);
        zzzmVar.zzf(firebaseApp);
        zzzmVar.zzg(firebaseUser);
        zzzmVar.zzd(zzbxVar);
        zzzmVar.zze(zzbxVar);
        return zzU(zzzmVar);
    }

    public final Task zzs(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, @Nullable String str4, zzbx zzbxVar) {
        zzzn zzznVar = new zzzn(str, str2, str3, str4);
        zzznVar.zzf(firebaseApp);
        zzznVar.zzg(firebaseUser);
        zzznVar.zzd(zzbxVar);
        zzznVar.zze(zzbxVar);
        return zzU(zzznVar);
    }

    public final Task zzt(FirebaseApp firebaseApp, FirebaseUser firebaseUser, String str, String str2, @Nullable String str3, @Nullable String str4, zzbx zzbxVar) {
        zzzo zzzoVar = new zzzo(str, str2, str3, str4);
        zzzoVar.zzf(firebaseApp);
        zzzoVar.zzg(firebaseUser);
        zzzoVar.zzd(zzbxVar);
        zzzoVar.zze(zzbxVar);
        return zzU(zzzoVar);
    }

    public final Task zzu(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzbx zzbxVar) {
        zzacg.zzc();
        zzzp zzzpVar = new zzzp(phoneAuthCredential, str);
        zzzpVar.zzf(firebaseApp);
        zzzpVar.zzg(firebaseUser);
        zzzpVar.zzd(zzbxVar);
        zzzpVar.zze(zzbxVar);
        return zzU(zzzpVar);
    }

    public final Task zzv(FirebaseApp firebaseApp, FirebaseUser firebaseUser, PhoneAuthCredential phoneAuthCredential, @Nullable String str, zzbx zzbxVar) {
        zzacg.zzc();
        zzzq zzzqVar = new zzzq(phoneAuthCredential, str);
        zzzqVar.zzf(firebaseApp);
        zzzqVar.zzg(firebaseUser);
        zzzqVar.zzd(zzbxVar);
        zzzqVar.zze(zzbxVar);
        return zzU(zzzqVar);
    }

    @NonNull
    public final Task zzw(FirebaseApp firebaseApp, FirebaseUser firebaseUser, zzbx zzbxVar) {
        zzzr zzzrVar = new zzzr();
        zzzrVar.zzf(firebaseApp);
        zzzrVar.zzg(firebaseUser);
        zzzrVar.zzd(zzbxVar);
        zzzrVar.zze(zzbxVar);
        return zzU(zzzrVar);
    }

    public final Task zzx(FirebaseApp firebaseApp, @Nullable ActionCodeSettings actionCodeSettings, String str) {
        zzzs zzzsVar = new zzzs(str, actionCodeSettings);
        zzzsVar.zzf(firebaseApp);
        return zzU(zzzsVar);
    }

    public final Task zzy(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3) {
        actionCodeSettings.zzg(1);
        zzzt zzztVar = new zzzt(str, actionCodeSettings, str2, str3, "sendPasswordResetEmail");
        zzztVar.zzf(firebaseApp);
        return zzU(zzztVar);
    }

    public final Task zzz(FirebaseApp firebaseApp, String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3) {
        actionCodeSettings.zzg(6);
        zzzt zzztVar = new zzzt(str, actionCodeSettings, str2, str3, "sendSignInLinkToEmail");
        zzztVar.zzf(firebaseApp);
        return zzU(zzztVar);
    }
}
