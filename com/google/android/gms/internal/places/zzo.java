package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzm;
import com.google.android.gms.internal.places.zzo;

/* loaded from: classes4.dex */
public abstract class zzo<MessageType extends zzm<MessageType, BuilderType>, BuilderType extends zzo<MessageType, BuilderType>> implements zzcj {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.places.zzcj
    public final /* synthetic */ zzcj zzb(zzck zzckVar) {
        if (zzbg().getClass().isInstance(zzckVar)) {
            return zzb((zzo<MessageType, BuilderType>) ((zzm) zzckVar));
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    protected abstract BuilderType zzb(MessageType messagetype);

    @Override // 
    /* renamed from: zzx */
    public abstract BuilderType clone();
}
