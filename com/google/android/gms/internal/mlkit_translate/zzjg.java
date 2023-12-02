package com.google.android.gms.internal.mlkit_translate;

import com.arlosoft.macrodroid.action.activities.SelectionDialogActivity;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import java.io.IOException;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
final class zzjg implements ObjectEncoder {
    static final zzjg zza = new zzjg();
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder(SelectionDialogActivity.EXTRA_OPTIONS);
        zzbc zzbcVar = new zzbc();
        zzbcVar.zza(1);
        zzb = builder.withProperty(zzbcVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("errorCode");
        zzbc zzbcVar2 = new zzbc();
        zzbcVar2.zza(2);
        zzc = builder2.withProperty(zzbcVar2.zzb()).build();
    }

    private zzjg() {
    }

    @Override // com.google.firebase.encoders.ObjectEncoder
    public final /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) throws IOException {
        zzno zznoVar = (zzno) obj;
        ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
        throw null;
    }
}