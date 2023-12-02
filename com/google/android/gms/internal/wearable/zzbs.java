package com.google.android.gms.internal.wearable;

import com.google.android.gms.internal.wearable.zzbs;
import com.google.android.gms.internal.wearable.zzbv;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public class zzbs<MessageType extends zzbv<MessageType, BuilderType>, BuilderType extends zzbs<MessageType, BuilderType>> extends zzaf<MessageType, BuilderType> {
    protected zzbv zza;
    protected boolean zzb = false;
    private final zzbv zzc;

    /* JADX INFO: Access modifiers changed from: protected */
    public zzbs(MessageType messagetype) {
        this.zzc = messagetype;
        this.zza = (zzbv) messagetype.zzG(4, null, null);
    }

    private static final void zza(zzbv zzbvVar, zzbv zzbvVar2) {
        zzdk.zza().zzb(zzbvVar.getClass()).zzg(zzbvVar, zzbvVar2);
    }

    @Override // com.google.android.gms.internal.wearable.zzdd
    public final /* synthetic */ zzdc zzac() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.wearable.zzaf
    protected final /* synthetic */ zzaf zzp(zzag zzagVar) {
        zzs((zzbv) zzagVar);
        return this;
    }

    @Override // com.google.android.gms.internal.wearable.zzaf
    /* renamed from: zzr */
    public final zzbs zzo() {
        zzbs zzbsVar = (zzbs) this.zzc.zzG(5, null, null);
        zzbsVar.zzs(zzv());
        return zzbsVar;
    }

    public final zzbs zzs(zzbv zzbvVar) {
        if (this.zzb) {
            zzx();
            this.zzb = false;
        }
        zza(this.zza, zzbvVar);
        return this;
    }

    public final MessageType zzt() {
        MessageType zzv = zzv();
        if (zzv.zzab()) {
            return zzv;
        }
        throw new zzed(zzv);
    }

    @Override // com.google.android.gms.internal.wearable.zzdb
    /* renamed from: zzu */
    public MessageType zzv() {
        if (this.zzb) {
            return (MessageType) this.zza;
        }
        zzbv zzbvVar = this.zza;
        zzdk.zza().zzb(zzbvVar.getClass()).zzf(zzbvVar);
        this.zzb = true;
        return (MessageType) this.zza;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void zzx() {
        zzbv zzbvVar = (zzbv) this.zza.zzG(4, null, null);
        zza(zzbvVar, this.zza);
        this.zza = zzbvVar;
    }
}
