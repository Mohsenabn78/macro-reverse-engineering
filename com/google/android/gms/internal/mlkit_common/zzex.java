package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzex implements ObjectEncoder {
    static final zzex zza = new zzex();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("source");
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbh zzbhVar2 = new zzbh();
        zzbhVar2.zza(2);
        zzc = builder2.withProperty(zzbhVar2.zzb()).build();
    }

    private zzex() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzln zzlnVar = (zzln) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
