package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.firebase.auth.PhoneAuthCredential;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaq  reason: invalid package */
/* loaded from: classes4.dex */
public class zzaaq {
    private final zzaap zza;
    private final Logger zzb;

    public zzaaq(zzaap zzaapVar, Logger logger) {
        this.zza = (zzaap) Preconditions.checkNotNull(zzaapVar);
        this.zzb = (Logger) Preconditions.checkNotNull(logger);
    }

    public final void zza(String str) {
        try {
            this.zza.zza(str);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending auto retrieval timeout response.", e4, new Object[0]);
        }
    }

    public void zzb(String str) {
        try {
            this.zza.zzb(str);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending send verification code response.", e4, new Object[0]);
        }
    }

    public final void zzc(zzacv zzacvVar) {
        try {
            this.zza.zzc(zzacvVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending create auth uri response.", e4, new Object[0]);
        }
    }

    public final void zzd() {
        try {
            this.zza.zzd();
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending delete account response.", e4, new Object[0]);
        }
    }

    public final void zze(zzwx zzwxVar) {
        try {
            this.zza.zze(zzwxVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result with credential", e4, new Object[0]);
        }
    }

    public final void zzf(zzwy zzwyVar) {
        try {
            this.zza.zzf(zzwyVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result for mfa", e4, new Object[0]);
        }
    }

    public final void zzg(Status status, PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzg(status, phoneAuthCredential);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result.", e4, new Object[0]);
        }
    }

    public void zzh(Status status) {
        try {
            this.zza.zzh(status);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending failure result.", e4, new Object[0]);
        }
    }

    public final void zzi(zzadq zzadqVar) {
        try {
            this.zza.zzi(zzadqVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending Play Integrity Producer project response.", e4, new Object[0]);
        }
    }

    public final void zzj(zzadt zzadtVar) {
        try {
            this.zza.zzj(zzadtVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending get recaptcha config response.", e4, new Object[0]);
        }
    }

    public final void zzk(zzadu zzaduVar, zzadl zzadlVar) {
        try {
            this.zza.zzk(zzaduVar, zzadlVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending get token and account info user response", e4, new Object[0]);
        }
    }

    public final void zzl(@Nullable zzaed zzaedVar) {
        try {
            this.zza.zzl(zzaedVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending password reset response.", e4, new Object[0]);
        }
    }

    public final void zzm() {
        try {
            this.zza.zzm();
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending email verification response.", e4, new Object[0]);
        }
    }

    public final void zzn(String str) {
        try {
            this.zza.zzn(str);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending set account info response.", e4, new Object[0]);
        }
    }

    public final void zzo() {
        try {
            this.zza.zzo();
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when setting FirebaseUI Version", e4, new Object[0]);
        }
    }

    public final void zzp(zzael zzaelVar) {
        try {
            this.zza.zzp(zzaelVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending start mfa enrollment response.", e4, new Object[0]);
        }
    }

    public final void zzq(zzadu zzaduVar) {
        try {
            this.zza.zzq(zzaduVar);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending token result.", e4, new Object[0]);
        }
    }

    public final void zzr(PhoneAuthCredential phoneAuthCredential) {
        try {
            this.zza.zzr(phoneAuthCredential);
        } catch (RemoteException e4) {
            this.zzb.e("RemoteException when sending verification completed response.", e4, new Object[0]);
        }
    }

    public zzaaq(zzaaq zzaaqVar) {
        this(zzaaqVar.zza, zzaaqVar.zzb);
    }
}
