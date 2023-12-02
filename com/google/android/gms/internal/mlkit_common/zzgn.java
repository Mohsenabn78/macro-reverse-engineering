package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzgn implements ObjectEncoder {
    static final zzgn zza = new zzgn();
    private static final FieldDescriptor zzb;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("isFaceMeshEnabled");
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
    }

    private zzgn() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzkt zzktVar = (zzkt) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
