package com.google.android.gms.internal.mlkit_common;

import com.arlosoft.macrodroid.action.activities.SelectionDialogActivity;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzel implements ObjectEncoder {
    static final zzel zza = new zzel();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("inferenceCommonLogEvent");
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(SelectionDialogActivity.EXTRA_OPTIONS);
        zzbh zzbhVar2 = new zzbh();
        zzbhVar2.zza(2);
        zzc = builder2.withProperty(zzbhVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("inputsFormats");
        zzbh zzbhVar3 = new zzbh();
        zzbhVar3.zza(3);
        zzd = builder3.withProperty(zzbhVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("outputFormats");
        zzbh zzbhVar4 = new zzbh();
        zzbhVar4.zza(4);
        zze = builder4.withProperty(zzbhVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("modelInitializationMs");
        zzbh zzbhVar5 = new zzbh();
        zzbhVar5.zza(5);
        zzf = builder5.withProperty(zzbhVar5.zzb()).build();
    }

    private zzel() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzid zzidVar = (zzid) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}
