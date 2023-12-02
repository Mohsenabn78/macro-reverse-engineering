package com.google.android.gms.internal.wearable;

import com.google.android.gms.internal.wearable.zzaf;
import com.google.android.gms.internal.wearable.zzag;

/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public abstract class zzaf<MessageType extends zzag<MessageType, BuilderType>, BuilderType extends zzaf<MessageType, BuilderType>> implements zzdb {
    @Override // 
    /* renamed from: zzo */
    public abstract zzaf clone();

    protected abstract zzaf zzp(zzag zzagVar);

    @Override // com.google.android.gms.internal.wearable.zzdb
    public final /* bridge */ /* synthetic */ zzdb zzq(zzdc zzdcVar) {
        if (zzac().getClass().isInstance(zzdcVar)) {
            return zzp((zzag) zzdcVar);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
