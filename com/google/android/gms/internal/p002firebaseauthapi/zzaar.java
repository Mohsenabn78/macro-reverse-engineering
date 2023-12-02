package com.google.android.gms.internal.p002firebaseauthapi;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneMultiFactorAssertion;
import com.google.firebase.auth.TotpMultiFactorAssertion;
import com.google.firebase.auth.TotpSecret;
import com.google.firebase.auth.UserProfileChangeRequest;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaar  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzaar {
    private static final Logger zza = new Logger("FirebaseAuth", "FirebaseAuthFallback:");
    private final zzys zzb;
    private final zzacm zzc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzaar(FirebaseApp firebaseApp, ScheduledExecutorService scheduledExecutorService) {
        Preconditions.checkNotNull(firebaseApp);
        Context applicationContext = firebaseApp.getApplicationContext();
        Preconditions.checkNotNull(applicationContext);
        this.zzb = new zzys(new zzabf(firebaseApp, zzabe.zza(), null, null, null));
        this.zzc = new zzacm(applicationContext, scheduledExecutorService);
    }

    private static boolean zzJ(long j4, boolean z3) {
        if (j4 > 0 && z3) {
            return true;
        }
        zza.w("App hash will not be appended to the request.", new Object[0]);
        return false;
    }

    public final void zzA(zzwu zzwuVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzaapVar);
        Preconditions.checkNotNull(zzwuVar);
        this.zzb.zzG(zzacc.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzwuVar.zza())), new zzaaq(zzaapVar, zza));
    }

    public final void zzB(String str, String str2, @Nullable String str3, long j4, boolean z3, boolean z4, @Nullable String str4, @Nullable String str5, boolean z5, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str, "idToken should not be empty.");
        Preconditions.checkNotNull(zzaapVar);
        zzaaq zzaaqVar = new zzaaq(zzaapVar, zza);
        if (this.zzc.zzk(str2)) {
            if (z3) {
                this.zzc.zzi(str2);
            } else {
                this.zzc.zzh(zzaaqVar, str2);
                return;
            }
        }
        zzaeo zzb = zzaeo.zzb(str, str2, str3, str4, str5, null);
        if (zzJ(j4, z5)) {
            zzb.zzd(new zzacr(this.zzc.zzb()));
        }
        this.zzc.zzj(str2, zzaaqVar, j4, z5);
        this.zzb.zzH(zzb, new zzacj(this.zzc, zzaaqVar, str2));
    }

    public final void zzC(zzwv zzwvVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwvVar);
        Preconditions.checkNotNull(zzaapVar);
        String phoneNumber = zzwvVar.zzb().getPhoneNumber();
        zzaaq zzaaqVar = new zzaaq(zzaapVar, zza);
        if (this.zzc.zzk(phoneNumber)) {
            if (zzwvVar.zzg()) {
                this.zzc.zzi(phoneNumber);
            } else {
                this.zzc.zzh(zzaaqVar, phoneNumber);
                return;
            }
        }
        long zza2 = zzwvVar.zza();
        boolean zzh = zzwvVar.zzh();
        zzaem zzb = zzaem.zzb(zzwvVar.zzd(), zzwvVar.zzb().getUid(), zzwvVar.zzb().getPhoneNumber(), zzwvVar.zzc(), zzwvVar.zzf(), zzwvVar.zze());
        if (zzJ(zza2, zzh)) {
            zzb.zzd(new zzacr(this.zzc.zzb()));
        }
        this.zzc.zzj(phoneNumber, zzaaqVar, zza2, zzh);
        this.zzb.zzI(zzb, new zzacj(this.zzc, zzaaqVar, phoneNumber));
    }

    public final void zzD(zzaeq zzaeqVar, zzaap zzaapVar) {
        this.zzb.zzH(zzaeqVar, new zzaaq((zzaap) Preconditions.checkNotNull(zzaapVar), zza));
    }

    public final void zzE(String str, String str2, @Nullable String str3, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotEmpty(str2, "uid should not be empty.");
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzJ(str, str2, str3, new zzaaq(zzaapVar, zza));
    }

    public final void zzF(String str, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzK(str, new zzaaq(zzaapVar, zza));
    }

    public final void zzG(String str, String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzL(str, str2, new zzaaq(zzaapVar, zza));
    }

    public final void zzH(String str, UserProfileChangeRequest userProfileChangeRequest, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzM(str, userProfileChangeRequest, new zzaaq(zzaapVar, zza));
    }

    public final void zzI(zzww zzwwVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwwVar);
        this.zzb.zzN(zzadn.zzc(zzwwVar.zza(), zzwwVar.zzb(), zzwwVar.zzc()), new zzaaq(zzaapVar, zza));
    }

    public final void zza(String str, @Nullable String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzg(str, str2, new zzaaq(zzaapVar, zza));
    }

    public final void zzb(String str, String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzh(str, str2, new zzaaq(zzaapVar, zza));
    }

    public final void zzc(String str, String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzi(str, str2, new zzaaq(zzaapVar, zza));
    }

    public final void zzd(String str, @Nullable String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzj(str, str2, new zzaaq(zzaapVar, zza));
    }

    public final void zze(zzwl zzwlVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwlVar);
        Preconditions.checkNotEmpty(zzwlVar.zza());
        Preconditions.checkNotEmpty(zzwlVar.zzb());
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzk(zzwlVar.zza(), zzwlVar.zzb(), zzwlVar.zzc(), new zzaaq(zzaapVar, zza));
    }

    public final void zzf(String str, String str2, @Nullable String str3, @Nullable String str4, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzl(str, str2, str3, str4, new zzaaq(zzaapVar, zza));
    }

    public final void zzg(String str, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzm(str, new zzaaq(zzaapVar, zza));
    }

    public final void zzh(MultiFactorAssertion multiFactorAssertion, String str, @Nullable String str2, @Nullable String str3, zzaap zzaapVar) {
        zzacz zzc;
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotEmpty(str, "cachedTokenState should not be empty.");
        Preconditions.checkNotNull(zzaapVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            zzc = zzadd.zzc(str, (String) Preconditions.checkNotNull(zza2.zzg()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2, str3);
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            zzc = zzadf.zzc(str, Preconditions.checkNotEmpty(str2), Preconditions.checkNotEmpty(((TotpSecret) Preconditions.checkNotNull(totpMultiFactorAssertion.zza())).getSessionInfo()), Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str3);
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
        this.zzb.zzn(zzc, str, new zzaaq(zzaapVar, zza));
    }

    public final void zzi(String str, MultiFactorAssertion multiFactorAssertion, @Nullable String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(multiFactorAssertion);
        Preconditions.checkNotNull(zzaapVar);
        if (multiFactorAssertion instanceof PhoneMultiFactorAssertion) {
            PhoneAuthCredential zza2 = ((PhoneMultiFactorAssertion) multiFactorAssertion).zza();
            this.zzb.zzo(zzade.zzb(str, (String) Preconditions.checkNotNull(zza2.zzg()), (String) Preconditions.checkNotNull(zza2.getSmsCode()), str2), new zzaaq(zzaapVar, zza));
        } else if (multiFactorAssertion instanceof TotpMultiFactorAssertion) {
            TotpMultiFactorAssertion totpMultiFactorAssertion = (TotpMultiFactorAssertion) multiFactorAssertion;
            this.zzb.zzo(zzadg.zzb(str, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzc()), str2, Preconditions.checkNotEmpty(totpMultiFactorAssertion.zzb())), new zzaaq(zzaapVar, zza));
        } else {
            throw new IllegalArgumentException("multiFactorAssertion must be either PhoneMultiFactorAssertion or TotpMultiFactorAssertion.");
        }
    }

    public final void zzj(String str, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzp(str, new zzaaq(zzaapVar, zza));
    }

    public final void zzk(zzwm zzwmVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwmVar);
        this.zzb.zzq(zzadp.zzb(), new zzaaq(zzaapVar, zza));
    }

    public final void zzl(String str, @Nullable String str2, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        this.zzb.zzr(str, str2, new zzaaq(zzaapVar, zza));
    }

    public final void zzm(zzwn zzwnVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwnVar);
        this.zzb.zzs(zzads.zzb(zzwnVar.zzb(), zzwnVar.zza()), new zzaaq(zzaapVar, zza));
    }

    public final void zzn(String str, String str2, String str3, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzt(str, str2, str3, new zzaaq(zzaapVar, zza));
    }

    public final void zzo(String str, zzaev zzaevVar, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaevVar);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzu(str, zzaevVar, new zzaaq(zzaapVar, zza));
    }

    public final void zzp(zzwo zzwoVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzaapVar);
        Preconditions.checkNotNull(zzwoVar);
        this.zzb.zzv(Preconditions.checkNotEmpty(zzwoVar.zzb()), zzacc.zza((PhoneAuthCredential) Preconditions.checkNotNull(zzwoVar.zza())), new zzaaq(zzaapVar, zza));
    }

    public final void zzq(String str, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzw(str, new zzaaq(zzaapVar, zza));
    }

    public final void zzr(@NonNull zzwp zzwpVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwpVar);
        Preconditions.checkNotEmpty(zzwpVar.zzb());
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzx(zzwpVar.zzb(), zzwpVar.zza(), new zzaaq(zzaapVar, zza));
    }

    public final void zzs(@NonNull zzwq zzwqVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwqVar);
        Preconditions.checkNotEmpty(zzwqVar.zzc());
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzy(zzwqVar.zzc(), zzwqVar.zza(), zzwqVar.zzd(), zzwqVar.zzb(), new zzaaq(zzaapVar, zza));
    }

    public final void zzt(zzwr zzwrVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzaapVar);
        Preconditions.checkNotNull(zzwrVar);
        zzaee zzaeeVar = (zzaee) Preconditions.checkNotNull(zzwrVar.zza());
        String zzd = zzaeeVar.zzd();
        zzaaq zzaaqVar = new zzaaq(zzaapVar, zza);
        if (this.zzc.zzk(zzd)) {
            if (zzaeeVar.zzf()) {
                this.zzc.zzi(zzd);
            } else {
                this.zzc.zzh(zzaaqVar, zzd);
                return;
            }
        }
        long zzb = zzaeeVar.zzb();
        boolean zzg = zzaeeVar.zzg();
        if (zzJ(zzb, zzg)) {
            zzaeeVar.zze(new zzacr(this.zzc.zzb()));
        }
        this.zzc.zzj(zzd, zzaaqVar, zzb, zzg);
        this.zzb.zzz(zzaeeVar, new zzacj(this.zzc, zzaaqVar, zzd));
    }

    public final void zzu(zzws zzwsVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwsVar);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzA(zzwsVar.zza(), new zzaaq(zzaapVar, zza));
    }

    public final void zzv(@Nullable String str, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzB(str, new zzaaq(zzaapVar, zza));
    }

    public final void zzw(zzaev zzaevVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzaevVar);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzC(zzaevVar, new zzaaq(zzaapVar, zza));
    }

    public final void zzx(zzaey zzaeyVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzaeyVar);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzD(zzaeyVar, new zzaaq(zzaapVar, zza));
    }

    public final void zzy(String str, String str2, @Nullable String str3, @Nullable String str4, zzaap zzaapVar) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzaapVar);
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzE(str, str2, str3, str4, new zzaaq(zzaapVar, zza));
    }

    public final void zzz(zzwt zzwtVar, zzaap zzaapVar) {
        Preconditions.checkNotNull(zzwtVar);
        Preconditions.checkNotNull(zzwtVar.zza());
        Preconditions.checkNotNull(zzaapVar);
        this.zzb.zzF(zzwtVar.zza(), zzwtVar.zzb(), new zzaaq(zzaapVar, zza));
    }
}
