package com.google.android.gms.internal.mlkit_common;

import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.io.IOException;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzhc implements ObjectEncoder {
    static final zzhc zza = new zzhc();
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
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder(RemoteConfigConstants.RequestFieldKey.APP_VERSION);
        zzbh zzbhVar2 = new zzbh();
        zzbhVar2.zza(2);
        zzc = builder2.withProperty(zzbhVar2.zzb()).build();
        FieldDescriptor.Builder builder3 = FieldDescriptor.builder("firebaseProjectId");
        zzbh zzbhVar3 = new zzbh();
        zzbhVar3.zza(3);
        zzd = builder3.withProperty(zzbhVar3.zzb()).build();
        FieldDescriptor.Builder builder4 = FieldDescriptor.builder("mlSdkVersion");
        zzbh zzbhVar4 = new zzbh();
        zzbhVar4.zza(4);
        zze = builder4.withProperty(zzbhVar4.zzb()).build();
        FieldDescriptor.Builder builder5 = FieldDescriptor.builder("tfliteSchemaVersion");
        zzbh zzbhVar5 = new zzbh();
        zzbhVar5.zza(5);
        zzf = builder5.withProperty(zzbhVar5.zzb()).build();
        FieldDescriptor.Builder builder6 = FieldDescriptor.builder("gcmSenderId");
        zzbh zzbhVar6 = new zzbh();
        zzbhVar6.zza(6);
        zzg = builder6.withProperty(zzbhVar6.zzb()).build();
        FieldDescriptor.Builder builder7 = FieldDescriptor.builder("apiKey");
        zzbh zzbhVar7 = new zzbh();
        zzbhVar7.zza(7);
        zzh = builder7.withProperty(zzbhVar7.zzb()).build();
        FieldDescriptor.Builder builder8 = FieldDescriptor.builder("languages");
        zzbh zzbhVar8 = new zzbh();
        zzbhVar8.zza(8);
        zzi = builder8.withProperty(zzbhVar8.zzb()).build();
        FieldDescriptor.Builder builder9 = FieldDescriptor.builder("mlSdkInstanceId");
        zzbh zzbhVar9 = new zzbh();
        zzbhVar9.zza(9);
        zzj = builder9.withProperty(zzbhVar9.zzb()).build();
        FieldDescriptor.Builder builder10 = FieldDescriptor.builder("isClearcutClient");
        zzbh zzbhVar10 = new zzbh();
        zzbhVar10.zza(10);
        zzk = builder10.withProperty(zzbhVar10.zzb()).build();
        FieldDescriptor.Builder builder11 = FieldDescriptor.builder("isStandaloneMlkit");
        zzbh zzbhVar11 = new zzbh();
        zzbhVar11.zza(11);
        zzl = builder11.withProperty(zzbhVar11.zzb()).build();
        FieldDescriptor.Builder builder12 = FieldDescriptor.builder("isJsonLogging");
        zzbh zzbhVar12 = new zzbh();
        zzbhVar12.zza(12);
        zzm = builder12.withProperty(zzbhVar12.zzb()).build();
        FieldDescriptor.Builder builder13 = FieldDescriptor.builder("buildLevel");
        zzbh zzbhVar13 = new zzbh();
        zzbhVar13.zza(13);
        zzn = builder13.withProperty(zzbhVar13.zzb()).build();
        FieldDescriptor.Builder builder14 = FieldDescriptor.builder("optionalModuleVersion");
        zzbh zzbhVar14 = new zzbh();
        zzbhVar14.zza(14);
        zzo = builder14.withProperty(zzbhVar14.zzb()).build();
    }

    private zzhc() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzlg zzlgVar = (zzlg) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        objectEncoderContext.add(zzb, zzlgVar.zzg());
        objectEncoderContext.add(zzc, zzlgVar.zzh());
        objectEncoderContext.add(zzd, (Object) null);
        objectEncoderContext.add(zze, zzlgVar.zzj());
        objectEncoderContext.add(zzf, zzlgVar.zzk());
        objectEncoderContext.add(zzg, (Object) null);
        objectEncoderContext.add(zzh, (Object) null);
        objectEncoderContext.add(zzi, zzlgVar.zza());
        objectEncoderContext.add(zzj, zzlgVar.zzi());
        objectEncoderContext.add(zzk, zzlgVar.zzb());
        objectEncoderContext.add(zzl, zzlgVar.zzd());
        objectEncoderContext.add(zzm, zzlgVar.zzc());
        objectEncoderContext.add(zzn, zzlgVar.zze());
        objectEncoderContext.add(zzo, zzlgVar.zzf());
    }
}
