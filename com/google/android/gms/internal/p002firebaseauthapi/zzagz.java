package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzagz;
import com.google.android.gms.internal.p002firebaseauthapi.zzahd;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzagz  reason: invalid package */
/* loaded from: classes4.dex */
public class zzagz<MessageType extends zzahd<MessageType, BuilderType>, BuilderType extends zzagz<MessageType, BuilderType>> extends zzafh<MessageType, BuilderType> {
    protected zzahd zza;
    private final zzahd zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzagz(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzL()) {
            this.zza = messagetype.zzw();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    private static void zza(Object obj, Object obj2) {
        zzaiq.zza().zzb(obj.getClass()).zzg(obj, obj2);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaij
    public final /* synthetic */ zzaii zzM() {
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzafh
    /* renamed from: zzg */
    public final zzagz zzf() {
        zzagz zzagzVar = (zzagz) this.zzb.zzj(5, null, null);
        zzagzVar.zza = zzk();
        return zzagzVar;
    }

    public final zzagz zzh(zzahd zzahdVar) {
        if (!this.zzb.equals(zzahdVar)) {
            if (!this.zza.zzL()) {
                zzn();
            }
            zza(this.zza, zzahdVar);
        }
        return this;
    }

    public final MessageType zzi() {
        MessageType zzk = zzk();
        if (zzk.zzK()) {
            return zzk;
        }
        throw new zzajn(zzk);
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaih
    /* renamed from: zzj */
    public MessageType zzk() {
        if (!this.zza.zzL()) {
            return (MessageType) this.zza;
        }
        this.zza.zzF();
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzm() {
        if (!this.zza.zzL()) {
            zzn();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzn() {
        zzahd zzw = this.zzb.zzw();
        zza(zzw, this.zza);
        this.zza = zzw;
    }
}
