package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzys  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzys {
    private final zzaby zza;

    public zzys(zzaby zzabyVar) {
        this.zza = (zzaby) Preconditions.checkNotNull(zzabyVar);
    }

    private final void zzO(String str, zzabx zzabxVar) {
        Preconditions.checkNotNull(zzabxVar);
        Preconditions.checkNotEmpty(str);
        zzadu zzd = zzadu.zzd(str);
        if (zzd.zzj()) {
            zzabxVar.zzb(zzd);
            return;
        }
        this.zza.zzf(new zzadi(zzd.zzf()), new zzyr(this, zzabxVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzP(zzacx zzacxVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzacxVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzc(zzacxVar, new zzxc(this, zzaaqVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzQ(zzadu zzaduVar, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable zze zzeVar, zzaaq zzaaqVar, zzabw zzabwVar) {
        Preconditions.checkNotNull(zzaduVar);
        Preconditions.checkNotNull(zzabwVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzg(new zzadj(zzaduVar.zze()), new zzxf(this, zzabwVar, str2, str, bool, zzeVar, zzaaqVar, zzaduVar));
    }

    private final void zzR(zzadn zzadnVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzadnVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzh(zzadnVar, new zzyk(this, zzaaqVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzd(zzys zzysVar, zzaex zzaexVar, zzaaq zzaaqVar, zzabw zzabwVar) {
        Status zza;
        if (zzaexVar.zzp()) {
            zze zzc = zzaexVar.zzc();
            String zzd = zzaexVar.zzd();
            String zzk = zzaexVar.zzk();
            if (zzaexVar.zzn()) {
                zza = new Status(FirebaseError.ERROR_ACCOUNT_EXISTS_WITH_DIFFERENT_CREDENTIAL);
            } else {
                zza = zzai.zza(zzaexVar.zze());
            }
            zzaaqVar.zze(new zzwx(zza, zzc, zzd, zzk));
            return;
        }
        zzysVar.zzQ(new zzadu(zzaexVar.zzj(), zzaexVar.zzf(), Long.valueOf(zzaexVar.zzb()), "Bearer"), zzaexVar.zzi(), zzaexVar.zzh(), Boolean.valueOf(zzaexVar.zzo()), zzaexVar.zzc(), zzaaqVar, zzabwVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zze(zzys zzysVar, zzaaq zzaaqVar, zzadu zzaduVar, zzaeg zzaegVar, zzabw zzabwVar) {
        Preconditions.checkNotNull(zzaaqVar);
        Preconditions.checkNotNull(zzaduVar);
        Preconditions.checkNotNull(zzaegVar);
        Preconditions.checkNotNull(zzabwVar);
        zzysVar.zza.zzg(new zzadj(zzaduVar.zze()), new zzxd(zzysVar, zzabwVar, zzaaqVar, zzaduVar, zzaegVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzf(zzys zzysVar, zzaaq zzaaqVar, zzadu zzaduVar, zzadl zzadlVar, zzaeg zzaegVar, zzabw zzabwVar) {
        Preconditions.checkNotNull(zzaaqVar);
        Preconditions.checkNotNull(zzaduVar);
        Preconditions.checkNotNull(zzadlVar);
        Preconditions.checkNotNull(zzaegVar);
        Preconditions.checkNotNull(zzabwVar);
        zzysVar.zza.zzn(zzaegVar, new zzxe(zzysVar, zzaegVar, zzadlVar, zzaaqVar, zzaduVar, zzabwVar));
    }

    public final void zzA(@Nullable String str, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzo(str, new zzyj(this, zzaaqVar));
    }

    public final void zzB(@Nullable String str, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzp(new zzaei(str), new zzym(this, zzaaqVar));
    }

    public final void zzC(zzaev zzaevVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaevVar);
        Preconditions.checkNotNull(zzaaqVar);
        zzaevVar.zzd(true);
        this.zza.zzs(zzaevVar, new zzyl(this, zzaaqVar));
    }

    public final void zzD(zzaey zzaeyVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaeyVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzt(zzaeyVar, new zzxy(this, zzaaqVar));
    }

    public final void zzE(String str, String str2, @Nullable String str3, @Nullable String str4, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzu(new zzafa(str, str2, str3, str4), new zzxa(this, zzaaqVar));
    }

    public final void zzF(EmailAuthCredential emailAuthCredential, @Nullable String str, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzaaqVar);
        if (emailAuthCredential.zzh()) {
            zzO(emailAuthCredential.zzc(), new zzxb(this, emailAuthCredential, str, zzaaqVar));
        } else {
            zzP(new zzacx(emailAuthCredential, null, str), zzaaqVar);
        }
    }

    public final void zzG(zzafc zzafcVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzafcVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzv(zzafcVar, new zzxm(this, zzaaqVar));
    }

    public final void zzH(zzaek zzaekVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaekVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzq(zzaekVar, new zzxx(this, zzaekVar, zzaaqVar));
    }

    public final void zzI(zzaem zzaemVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaemVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzr(zzaemVar, new zzyc(this, zzaaqVar));
    }

    public final void zzJ(String str, String str2, @Nullable String str3, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzxw(this, str2, str3, zzaaqVar));
    }

    public final void zzK(String str, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzxs(this, zzaaqVar));
    }

    public final void zzL(String str, String str2, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str2, new zzxu(this, str, zzaaqVar));
    }

    public final void zzM(String str, UserProfileChangeRequest userProfileChangeRequest, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzyn(this, userProfileChangeRequest, zzaaqVar));
    }

    public final void zzN(zzadn zzadnVar, zzaaq zzaaqVar) {
        zzR(zzadnVar, zzaaqVar);
    }

    public final void zzg(String str, @Nullable String str2, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        zzaeg zzaegVar = new zzaeg();
        zzaegVar.zzf(str);
        zzaegVar.zzi(str2);
        this.zza.zzn(zzaegVar, new zzyq(this, zzaaqVar));
    }

    public final void zzh(String str, String str2, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzyo(this, str2, zzaaqVar));
    }

    public final void zzi(String str, String str2, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzyp(this, str2, zzaaqVar));
    }

    public final void zzj(String str, @Nullable String str2, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzl(new zzaec(str, null, str2), new zzxi(this, zzaaqVar));
    }

    public final void zzk(String str, String str2, @Nullable String str3, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzl(new zzaec(str, str2, str3), new zzxk(this, zzaaqVar));
    }

    public final void zzl(String str, String str2, @Nullable String str3, @Nullable String str4, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzp(new zzaei(str, str2, null, str3, str4), new zzwz(this, zzaaqVar));
    }

    public final void zzm(String str, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzyi(this, zzaaqVar));
    }

    public final void zzn(zzacz zzaczVar, String str, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzaczVar);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzya(this, zzaczVar, zzaaqVar));
    }

    public final void zzo(zzadb zzadbVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzadbVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zze(zzadbVar, new zzyb(this, zzaaqVar));
    }

    public final void zzp(String str, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzf(new zzadi(str), new zzxj(this, zzaaqVar));
    }

    public final void zzq(zzadp zzadpVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzadpVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzi(zzadpVar, new zzye(this, zzaaqVar));
    }

    public final void zzr(String str, @Nullable String str2, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zza(new zzacu(str, str2), new zzxg(this, zzaaqVar));
    }

    public final void zzs(zzads zzadsVar, zzaaq zzaaqVar) {
        Preconditions.checkNotNull(zzadsVar);
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzj(zzadsVar, new zzyd(this, zzaaqVar));
    }

    public final void zzt(String str, String str2, String str3, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str3, new zzxn(this, str, str2, zzaaqVar));
    }

    public final void zzu(String str, zzaev zzaevVar, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaevVar);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzxr(this, zzaevVar, zzaaqVar));
    }

    public final void zzv(String str, zzafc zzafcVar, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzafcVar);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzxp(this, zzafcVar, zzaaqVar));
    }

    public final void zzw(String str, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        zzO(str, new zzyg(this, zzaaqVar));
    }

    public final void zzx(String str, @Nullable ActionCodeSettings actionCodeSettings, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        zzadn zzadnVar = new zzadn(4);
        zzadnVar.zzh(str);
        if (actionCodeSettings != null) {
            zzadnVar.zzd(actionCodeSettings);
        }
        zzR(zzadnVar, zzaaqVar);
    }

    public final void zzy(String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaaqVar);
        zzadn zzadnVar = new zzadn(actionCodeSettings.zza());
        zzadnVar.zzf(str);
        zzadnVar.zzd(actionCodeSettings);
        zzadnVar.zzg(str2);
        zzadnVar.zze(str3);
        this.zza.zzh(zzadnVar, new zzxh(this, zzaaqVar));
    }

    public final void zzz(zzaee zzaeeVar, zzaaq zzaaqVar) {
        Preconditions.checkNotEmpty(zzaeeVar.zzd());
        Preconditions.checkNotNull(zzaaqVar);
        this.zza.zzm(zzaeeVar, new zzxl(this, zzaaqVar));
    }
}
