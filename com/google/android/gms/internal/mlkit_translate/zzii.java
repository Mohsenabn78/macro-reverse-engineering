package com.google.android.gms.internal.mlkit_translate;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzii implements ObjectEncoder {
    static final zzii zza = new zzii();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("detectorMode");
        zzbc zzbcVar = new zzbc();
        zzbcVar.zza(1);
        zzb = builder.withProperty(zzbcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("multipleObjectsEnabled");
        zzbc zzbcVar2 = new zzbc();
        zzbcVar2.zza(2);
        zzc = builder2.withProperty(zzbcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("classificationEnabled");
        zzbc zzbcVar3 = new zzbc();
        zzbcVar3.zza(3);
        zzd = builder3.withProperty(zzbcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("maxPerObjectLabelCount");
        zzbc zzbcVar4 = new zzbc();
        zzbcVar4.zza(4);
        zze = builder4.withProperty(zzbcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("classificationConfidenceThreshold");
        zzbc zzbcVar5 = new zzbc();
        zzbcVar5.zza(5);
        zzf = builder5.withProperty(zzbcVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("customLocalModelOptions");
        zzbc zzbcVar6 = new zzbc();
        zzbcVar6.zza(6);
        zzg = builder6.withProperty(zzbcVar6.zzb()).build();
    }

    private zzii() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzmo zzmoVar = (zzmo) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
