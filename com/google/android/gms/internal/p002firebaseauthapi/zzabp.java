package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.internal.zzao;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabp  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzabp implements zzaap {
    final /* synthetic */ zzabs zza;

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzabp(zzabs zzabsVar) {
        this.zza = zzabsVar;
    }

    private final void zzs(zzabq zzabqVar) {
        this.zza.zzm.execute(new zzabo(this, zzabqVar));
    }

    private final void zzt(Status status, AuthCredential authCredential, @Nullable String str, @Nullable String str2) {
        zzabs.zzk(this.zza, status);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzt = authCredential;
        zzabsVar.zzu = str;
        zzabsVar.zzv = str2;
        zzao zzaoVar = zzabsVar.zzj;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
        this.zza.zzl(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zza(String str) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str2 = "Unexpected response type " + i4;
        if (i4 == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str2);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzs = str;
        zzabsVar.zza = true;
        zzs(new zzabm(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzb(String str) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str2 = "Unexpected response type " + i4;
        if (i4 == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str2);
        this.zza.zzs = str;
        zzs(new zzabk(this, str));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzc(zzacv zzacvVar) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 3) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzp = zzacvVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzd() throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 5) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs.zzj(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zze(zzwx zzwxVar) {
        zzt(zzwxVar.zza(), zzwxVar.zzb(), zzwxVar.zzc(), zzwxVar.zzd());
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzf(zzwy zzwyVar) {
        zzabs zzabsVar = this.zza;
        zzabsVar.zzw = zzwyVar;
        zzabsVar.zzl(zzai.zza("REQUIRES_SECOND_FACTOR_AUTH"));
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzt(status, phoneAuthCredential, null, null);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzh(Status status) throws RemoteException {
        String statusMessage = status.getStatusMessage();
        if (statusMessage != null) {
            if (statusMessage.contains("MISSING_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17081);
            } else if (statusMessage.contains("MISSING_MFA_ENROLLMENT_ID")) {
                status = new Status(17082);
            } else if (statusMessage.contains("INVALID_MFA_PENDING_CREDENTIAL")) {
                status = new Status(17083);
            } else if (statusMessage.contains("MFA_ENROLLMENT_NOT_FOUND")) {
                status = new Status(17084);
            } else if (statusMessage.contains("ADMIN_ONLY_OPERATION")) {
                status = new Status(17085);
            } else if (statusMessage.contains("UNVERIFIED_EMAIL")) {
                status = new Status(17086);
            } else if (statusMessage.contains("SECOND_FACTOR_EXISTS")) {
                status = new Status(17087);
            } else if (statusMessage.contains("SECOND_FACTOR_LIMIT_EXCEEDED")) {
                status = new Status(17088);
            } else if (statusMessage.contains("UNSUPPORTED_FIRST_FACTOR")) {
                status = new Status(17089);
            } else if (statusMessage.contains("EMAIL_CHANGE_NEEDS_VERIFICATION")) {
                status = new Status(17090);
            }
        }
        zzabs zzabsVar = this.zza;
        if (zzabsVar.zze == 8) {
            zzabsVar.zza = true;
            zzs(new zzabn(this, status));
            return;
        }
        zzabs.zzk(zzabsVar, status);
        this.zza.zzl(status);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzi(zzadq zzadqVar) throws RemoteException {
        zzabs zzabsVar = this.zza;
        zzabsVar.zzy = zzadqVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzj(zzadt zzadtVar) throws RemoteException {
        zzabs zzabsVar = this.zza;
        zzabsVar.zzx = zzadtVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzk(zzadu zzaduVar, zzadl zzadlVar) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type: " + i4;
        if (i4 == 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzn = zzaduVar;
        zzabsVar.zzo = zzadlVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzl(@Nullable zzaed zzaedVar) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 4) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzq = zzaedVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzm() throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 6) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs.zzj(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzn(String str) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str2 = "Unexpected response type " + i4;
        if (i4 == 7) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str2);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzr = str;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzo() throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 9) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs.zzj(this.zza);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzp(zzael zzaelVar) throws RemoteException {
        zzabs zzabsVar = this.zza;
        zzabsVar.zzz = zzaelVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzq(zzadu zzaduVar) throws RemoteException {
        int i4 = this.zza.zze;
        String str = "Unexpected response type: " + i4;
        boolean z3 = true;
        if (i4 != 1) {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        zzabs zzabsVar = this.zza;
        zzabsVar.zzn = zzaduVar;
        zzabs.zzj(zzabsVar);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaap
    public final void zzr(PhoneAuthCredential phoneAuthCredential) throws RemoteException {
        boolean z3;
        int i4 = this.zza.zze;
        String str = "Unexpected response type " + i4;
        if (i4 == 8) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkState(z3, str);
        this.zza.zza = true;
        zzs(new zzabl(this, phoneAuthCredential));
    }
}
