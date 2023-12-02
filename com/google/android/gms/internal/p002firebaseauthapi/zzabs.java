package com.google.android.gms.internal.p002firebaseauthapi;

import android.app.Activity;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.internal.zzao;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabs  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzabs implements zzabu {
    @VisibleForTesting
    Object zzA;
    @VisibleForTesting
    Status zzB;
    private boolean zza;
    protected final int zze;
    protected FirebaseApp zzg;
    protected FirebaseUser zzh;
    protected Object zzi;
    protected zzao zzj;
    protected zzabi zzk;
    protected Executor zzm;
    protected zzadu zzn;
    protected zzadl zzo;
    protected zzacv zzp;
    protected zzaed zzq;
    protected String zzr;
    protected String zzs;
    protected AuthCredential zzt;
    protected String zzu;
    protected String zzv;
    protected zzwy zzw;
    protected zzadt zzx;
    protected zzadq zzy;
    protected zzael zzz;
    protected final zzabp zzf = new zzabp(this);
    protected final List zzl = new ArrayList();

    public zzabs(int i4) {
        this.zze = i4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzj(zzabs zzabsVar) {
        zzabsVar.zzb();
        Preconditions.checkState(zzabsVar.zza, "no success or failure set on method implementation");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* bridge */ /* synthetic */ void zzk(zzabs zzabsVar, Status status) {
        zzao zzaoVar = zzabsVar.zzj;
        if (zzaoVar != null) {
            zzaoVar.zzb(status);
        }
    }

    public abstract void zzb();

    public final zzabs zzd(Object obj) {
        this.zzi = Preconditions.checkNotNull(obj, "external callback cannot be null");
        return this;
    }

    public final zzabs zze(zzao zzaoVar) {
        this.zzj = (zzao) Preconditions.checkNotNull(zzaoVar, "external failure callback cannot be null");
        return this;
    }

    public final zzabs zzf(FirebaseApp firebaseApp) {
        this.zzg = (FirebaseApp) Preconditions.checkNotNull(firebaseApp, "firebaseApp cannot be null");
        return this;
    }

    public final zzabs zzg(FirebaseUser firebaseUser) {
        this.zzh = (FirebaseUser) Preconditions.checkNotNull(firebaseUser, "firebaseUser cannot be null");
        return this;
    }

    public final zzabs zzh(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, Executor executor, String str) {
        PhoneAuthProvider.OnVerificationStateChangedCallbacks zza = zzacg.zza(str, onVerificationStateChangedCallbacks, this);
        synchronized (this.zzl) {
            this.zzl.add((PhoneAuthProvider.OnVerificationStateChangedCallbacks) Preconditions.checkNotNull(zza));
        }
        if (activity != null) {
            zzabj.zza(activity, this.zzl);
        }
        this.zzm = (Executor) Preconditions.checkNotNull(executor);
        return this;
    }

    public final void zzl(Status status) {
        this.zza = true;
        this.zzB = status;
        this.zzk.zza(null, status);
    }

    public final void zzm(Object obj) {
        this.zza = true;
        this.zzA = obj;
        this.zzk.zza(obj, null);
    }
}
