package com.google.android.gms.internal.mlkit_translate;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzjh implements ObjectEncoder {
    static final zzjh zza = new zzjh();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final FieldDescriptor zzd;
    private static final FieldDescriptor zze;
    private static final FieldDescriptor zzf;
    private static final FieldDescriptor zzg;
    private static final FieldDescriptor zzh;
    private static final FieldDescriptor zzi;
    private static final FieldDescriptor zzj;
    private static final FieldDescriptor zzk;
    private static final FieldDescriptor zzl;
    private static final FieldDescriptor zzm;
    private static final FieldDescriptor zzn;
    private static final FieldDescriptor zzo;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_ID);
        zzbc zzbcVar = new zzbc();
        zzbcVar.zza(1);
        zzb = builder.withProperty(zzbcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        zzbc zzbcVar2 = new zzbc();
        zzbcVar2.zza(2);
        zzc = builder2.withProperty(zzbcVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzbc zzbcVar3 = new zzbc();
        zzbcVar3.zza(3);
        zzd = builder3.withProperty(zzbcVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzbc zzbcVar4 = new zzbc();
        zzbcVar4.zza(4);
        zze = builder4.withProperty(zzbcVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzbc zzbcVar5 = new zzbc();
        zzbcVar5.zza(5);
        zzf = builder5.withProperty(zzbcVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzbc zzbcVar6 = new zzbc();
        zzbcVar6.zza(6);
        zzg = builder6.withProperty(zzbcVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzbc zzbcVar7 = new zzbc();
        zzbcVar7.zza(7);
        zzh = builder7.withProperty(zzbcVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzbc zzbcVar8 = new zzbc();
        zzbcVar8.zza(8);
        zzi = builder8.withProperty(zzbcVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzbc zzbcVar9 = new zzbc();
        zzbcVar9.zza(9);
        zzj = builder9.withProperty(zzbcVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzbc zzbcVar10 = new zzbc();
        zzbcVar10.zza(10);
        zzk = builder10.withProperty(zzbcVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzbc zzbcVar11 = new zzbc();
        zzbcVar11.zza(11);
        zzl = builder11.withProperty(zzbcVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzbc zzbcVar12 = new zzbc();
        zzbcVar12.zza(12);
        zzm = builder12.withProperty(zzbcVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzbc zzbcVar13 = new zzbc();
        zzbcVar13.zza(13);
        zzn = builder13.withProperty(zzbcVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzbc zzbcVar14 = new zzbc();
        zzbcVar14.zza(14);
        zzo = builder14.withProperty(zzbcVar14.zzb()).build();
    }

    private zzjh() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zznr zznrVar = (zznr) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zznrVar.zzg());
        objectEncoderContext.add(zzc, zznrVar.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, zznrVar.zzj());
        objectEncoderContext.add(zzf, zznrVar.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, zznrVar.zza());
        objectEncoderContext.add(zzj, zznrVar.zzi());
        objectEncoderContext.add(zzk, zznrVar.zzb());
        objectEncoderContext.add(zzl, zznrVar.zzd());
        objectEncoderContext.add(zzm, zznrVar.zzc());
        objectEncoderContext.add(zzn, zznrVar.zze());
        objectEncoderContext.add(zzo, zznrVar.zzf());
    }
}
