package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzfu implements ObjectEncoder {
    static final zzfu zza = new zzfu();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("detectorOptions");
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbh zzbhVar2 = new zzbh();
        zzbhVar2.zza(2);
        zzc = builder2.withProperty(zzbhVar2.zzb()).build();
    }

    private zzfu() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzka zzkaVar = (zzka) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
