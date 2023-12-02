package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjk;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.3.0 */
/* loaded from: classes4.dex */
public abstract class zzjj<MessageType extends zzjk<MessageType, BuilderType>, BuilderType extends zzjj<MessageType, BuilderType>> implements zzmh {
    @Override // 
    /* renamed from: zzav */
    public abstract zzjj clone();

    public zzjj zzaw(byte[] bArr, int i4, int i5) throws zzll {
        throw null;
    }

    public zzjj zzax(byte[] bArr, int i4, int i5, zzkn zzknVar) throws zzll {
        throw null;
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* synthetic */ zzmh zzay(byte[] bArr) throws zzll {
        return zzaw(bArr, 0, bArr.length);
    }

    @Override // com.google.android.gms.internal.measurement.zzmh
    public final /* synthetic */ zzmh zzaz(byte[] bArr, zzkn zzknVar) throws zzll {
        return zzax(bArr, 0, bArr.length, zzknVar);
    }
}
