package com.google.android.gms.internal.mlkit_translate;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzje implements ObjectEncoder {
    static final zzje zza = new zzje();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("durationMs");
        zzbc zzbcVar = new zzbc();
        zzbcVar.zza(1);
        zzb = builder.withProperty(zzbcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("handledErrors");
        zzbc zzbcVar2 = new zzbc();
        zzbcVar2.zza(2);
        zzc = builder2.withProperty(zzbcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("partiallyHandledErrors");
        zzbc zzbcVar3 = new zzbc();
        zzbcVar3.zza(3);
        zzd = builder3.withProperty(zzbcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("unhandledErrors");
        zzbc zzbcVar4 = new zzbc();
        zzbcVar4.zza(4);
        zze = builder4.withProperty(zzbcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("httpResponseCode");
        zzbc zzbcVar5 = new zzbc();
        zzbcVar5.zza(5);
        zzf = builder5.withProperty(zzbcVar5.zzb()).build();
    }

    private zzje() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznm zznmVar = (zznm) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zznmVar.zze());
        objectEncoderContext.add(zzc, zznmVar.zza());
        objectEncoderContext.add(zzd, zznmVar.zzb());
        objectEncoderContext.add(zze, zznmVar.zzc());
        objectEncoderContext.add(zzf, zznmVar.zzd());
    }
}
