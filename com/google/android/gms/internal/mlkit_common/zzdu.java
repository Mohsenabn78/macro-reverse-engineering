package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzdu implements ObjectEncoder {
    static final zzdu zza = new zzdu();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("cameraSource");
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("eventType");
        zzbh zzbhVar2 = new zzbh();
        zzbhVar2.zza(2);
        zzc = builder2.withProperty(zzbhVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("requestedPreviewHeight");
        zzbh zzbhVar3 = new zzbh();
        zzbhVar3.zza(3);
        zzd = builder3.withProperty(zzbhVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("requestedPreviewWidth");
        zzbh zzbhVar4 = new zzbh();
        zzbhVar4.zza(4);
        zze = builder4.withProperty(zzbhVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("actualPreviewHeight");
        zzbh zzbhVar5 = new zzbh();
        zzbhVar5.zza(5);
        zzf = builder5.withProperty(zzbhVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("actualPreviewWidth");
        zzbh zzbhVar6 = new zzbh();
        zzbhVar6.zza(6);
        zzg = builder6.withProperty(zzbhVar6.zzb()).build();
    }

    private zzdu() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzhm zzhmVar = (zzhm) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
