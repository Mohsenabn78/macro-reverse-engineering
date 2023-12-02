package com.google.android.gms.internal.p002firebaseauthapi;

import android.os.Parcelable;
import android.util.Pair;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthMultiFactorException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorInfo;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzx;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr  reason: invalid package */
/* loaded from: classes4.dex */
public final class zzabr implements zzabi {
    private final zzabs zza;
    private final TaskCompletionSource zzb;

    public zzabr(zzabs zzabsVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzabsVar;
        this.zzb = taskCompletionSource;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzabi
    public final void zza(Object obj, Status status) {
        FirebaseUser firebaseUser;
        Preconditions.checkNotNull(this.zzb, "completion source cannot be null");
        if (status != null) {
            zzabs zzabsVar = this.zza;
            if (zzabsVar.zzw != null) {
                TaskCompletionSource taskCompletionSource = this.zzb;
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance(zzabsVar.zzg);
                zzabs zzabsVar2 = this.zza;
                zzwy zzwyVar = zzabsVar2.zzw;
                if (!"reauthenticateWithCredential".equals(zzabsVar2.zza()) && !"reauthenticateWithCredentialWithData".equals(this.zza.zza())) {
                    firebaseUser = null;
                } else {
                    firebaseUser = this.zza.zzh;
                }
                int i4 = zzaas.zzb;
                firebaseAuth.getClass();
                zzwyVar.getClass();
                Pair pair = (Pair) zzaas.zza.get(17078);
                String str = (String) pair.first;
                String str2 = (String) pair.second;
                Parcelable.Creator<zzae> creator = zzae.CREATOR;
                List<MultiFactorInfo> zzc = zzwyVar.zzc();
                ArrayList arrayList = new ArrayList();
                for (MultiFactorInfo multiFactorInfo : zzc) {
                    if (multiFactorInfo instanceof PhoneMultiFactorInfo) {
                        arrayList.add((PhoneMultiFactorInfo) multiFactorInfo);
                    }
                }
                List<MultiFactorInfo> zzc2 = zzwyVar.zzc();
                ArrayList arrayList2 = new ArrayList();
                for (MultiFactorInfo multiFactorInfo2 : zzc2) {
                    if (multiFactorInfo2 instanceof TotpMultiFactorInfo) {
                        arrayList2.add((TotpMultiFactorInfo) multiFactorInfo2);
                    }
                }
                taskCompletionSource.setException(new FirebaseAuthMultiFactorException(str, str2, new zzae(arrayList, zzag.zzc(zzwyVar.zzc(), zzwyVar.zzb()), firebaseAuth.getApp().getName(), zzwyVar.zza(), (zzx) firebaseUser, arrayList2)));
                return;
            }
            AuthCredential authCredential = zzabsVar.zzt;
            if (authCredential != null) {
                this.zzb.setException(zzaas.zzb(status, authCredential, zzabsVar.zzu, zzabsVar.zzv));
                return;
            } else {
                this.zzb.setException(zzaas.zza(status));
                return;
            }
        }
        this.zzb.setResult(obj);
    }
}
