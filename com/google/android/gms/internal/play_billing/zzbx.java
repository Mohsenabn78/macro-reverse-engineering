package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzbx;
import com.google.android.gms.internal.play_billing.zzcb;

/* compiled from: com.android.billingclient:billing@@5.2.0 */
/* loaded from: classes4.dex */
public class zzbx<MessageType extends zzcb<MessageType, BuilderType>, BuilderType extends zzbx<MessageType, BuilderType>> extends zzaj<MessageType, BuilderType> {
    protected zzcb zza;
    private final zzcb zzb;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbx(MessageType messagetype) {
        this.zzb = messagetype;
        if (!messagetype.zzs()) {
            this.zza = messagetype.zzh();
            return;
        }
        throw new IllegalArgumentException("Default instance must be immutable.");
    }

    @Override // com.google.android.gms.internal.play_billing.zzaj
    /* renamed from: zzb */
    public final zzbx zza() {
        zzbx zzbxVar = (zzbx) this.zzb.zzt(5, null, null);
        zzbxVar.zza = zze();
        return zzbxVar;
    }

    public final MessageType zzc() {
        MessageType zze = zze();
        if (zze.zzr()) {
            return zze;
        }
        throw new zzef(zze);
    }

    @Override // com.google.android.gms.internal.play_billing.zzde
    /* renamed from: zzd */
    public MessageType zze() {
        if (!this.zza.zzs()) {
            return (MessageType) this.zza;
        }
        this.zza.zzm();
        return (MessageType) this.zza;
    }

    @Override // com.google.android.gms.internal.play_billing.zzdg
    public final /* bridge */ /* synthetic */ zzdf zzf() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zzg() {
        if (!this.zza.zzs()) {
            zzh();
        }
    }

    protected void zzh() {
        zzcb zzh = this.zzb.zzh();
        zzdn.zza().zzb(zzh.getClass()).zzg(zzh, this.zza);
        this.zza = zzh;
    }
}
