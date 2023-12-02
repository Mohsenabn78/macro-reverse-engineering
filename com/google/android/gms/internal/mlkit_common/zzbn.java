package com.google.android.gms.internal.mlkit_common;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.nearby.uwb.RangingPosition;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.ValueEncoder;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Map;

/* compiled from: com.google.mlkit:common@@18.5.0 */
/* loaded from: classes4.dex */
final class zzbn implements ObjectEncoderContext {
    private static final Charset zza = Charset.forName("UTF-8");
    private static final FieldDescriptor zzb;
    private static final FieldDescriptor zzc;
    private static final ObjectEncoder zzd;
    private OutputStream zze;
    private final Map zzf;
    private final Map zzg;
    private final ObjectEncoder zzh;
    private final zzbr zzi = new zzbr(this);

    static {
        FieldDescriptor.Builder builder = FieldDescriptor.builder("key");
        zzbh zzbhVar = new zzbh();
        zzbhVar.zza(1);
        zzb = builder.withProperty(zzbhVar.zzb()).build();
        FieldDescriptor.Builder builder2 = FieldDescriptor.builder("value");
        zzbh zzbhVar2 = new zzbh();
        zzbhVar2.zza(2);
        zzc = builder2.withProperty(zzbhVar2.zzb()).build();
        zzd = new ObjectEncoder() { // from class: com.google.android.gms.internal.mlkit_common.zzbm
            @Override // com.google.firebase.encoders.ObjectEncoder
            public final void encode(Object obj, Object obj2) {
                zzbn.zzg((Map.Entry) obj, (ObjectEncoderContext) obj2);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public zzbn(OutputStream outputStream, Map map, Map map2, ObjectEncoder objectEncoder) {
        this.zze = outputStream;
        this.zzf = map;
        this.zzg = map2;
        this.zzh = objectEncoder;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void zzg(Map.Entry entry, ObjectEncoderContext objectEncoderContext) throws IOException {
        objectEncoderContext.add(zzb, entry.getKey());
        objectEncoderContext.add(zzc, entry.getValue());
    }

    private static int zzh(FieldDescriptor fieldDescriptor) {
        zzbl zzblVar = (zzbl) fieldDescriptor.getProperty(zzbl.class);
        if (zzblVar != null) {
            return zzblVar.zza();
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final long zzi(ObjectEncoder objectEncoder, Object obj) throws IOException {
        zzbi zzbiVar = new zzbi();
        try {
            OutputStream outputStream = this.zze;
            this.zze = zzbiVar;
            objectEncoder.encode(obj, this);
            this.zze = outputStream;
            long zza2 = zzbiVar.zza();
            zzbiVar.close();
            return zza2;
        } catch (Throwable th) {
            try {
                zzbiVar.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }

    private static zzbl zzj(FieldDescriptor fieldDescriptor) {
        zzbl zzblVar = (zzbl) fieldDescriptor.getProperty(zzbl.class);
        if (zzblVar != null) {
            return zzblVar;
        }
        throw new EncodingException("Field has no @Protobuf config");
    }

    private final zzbn zzk(ObjectEncoder objectEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z3) throws IOException {
        long zzi = zzi(objectEncoder, obj);
        if (z3 && zzi == 0) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 2);
        zzo(zzi);
        objectEncoder.encode(obj, this);
        return this;
    }

    private final zzbn zzl(ValueEncoder valueEncoder, FieldDescriptor fieldDescriptor, Object obj, boolean z3) throws IOException {
        this.zzi.zza(fieldDescriptor, z3);
        valueEncoder.encode(obj, this.zzi);
        return this;
    }

    private static ByteBuffer zzm(int i4) {
        return ByteBuffer.allocate(i4).order(ByteOrder.LITTLE_ENDIAN);
    }

    private final void zzn(int i4) throws IOException {
        while (true) {
            int i5 = ((i4 & RangingPosition.RSSI_UNKNOWN) > 0L ? 1 : ((i4 & RangingPosition.RSSI_UNKNOWN) == 0L ? 0 : -1));
            OutputStream outputStream = this.zze;
            if (i5 != 0) {
                outputStream.write((i4 & 127) | 128);
                i4 >>>= 7;
            } else {
                outputStream.write(i4 & 127);
                return;
            }
        }
    }

    private final void zzo(long j4) throws IOException {
        while (true) {
            int i4 = (((-128) & j4) > 0L ? 1 : (((-128) & j4) == 0L ? 0 : -1));
            OutputStream outputStream = this.zze;
            if (i4 != 0) {
                outputStream.write((((int) j4) & 127) | 128);
                j4 >>>= 7;
            } else {
                outputStream.write(((int) j4) & 127);
                return;
            }
        }
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, double d4) throws IOException {
        zza(fieldDescriptor, d4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext inline(@Nullable Object obj) throws IOException {
        zzf(obj);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull FieldDescriptor fieldDescriptor) throws IOException {
        throw new EncodingException("nested() is not implemented for protobuf encoding.");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext zza(@NonNull FieldDescriptor fieldDescriptor, double d4, boolean z3) throws IOException {
        if (z3 && d4 == FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 1);
        this.zze.write(zzm(8).putDouble(d4).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext zzb(@NonNull FieldDescriptor fieldDescriptor, float f4, boolean z3) throws IOException {
        if (z3 && f4 == 0.0f) {
            return this;
        }
        zzn((zzh(fieldDescriptor) << 3) | 5);
        this.zze.write(zzm(4).putFloat(f4).array());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ObjectEncoderContext zzc(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj, boolean z3) throws IOException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z3 && charSequence.length() == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(zza);
            zzn(bytes.length);
            this.zze.write(bytes);
            return this;
        } else if (obj instanceof Collection) {
            for (Object obj2 : (Collection) obj) {
                zzc(fieldDescriptor, obj2, false);
            }
            return this;
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzk(zzd, fieldDescriptor, entry, false);
            }
            return this;
        } else if (obj instanceof Double) {
            zza(fieldDescriptor, ((Double) obj).doubleValue(), z3);
            return this;
        } else if (obj instanceof Float) {
            zzb(fieldDescriptor, ((Float) obj).floatValue(), z3);
            return this;
        } else if (obj instanceof Number) {
            zze(fieldDescriptor, ((Number) obj).longValue(), z3);
            return this;
        } else if (obj instanceof Boolean) {
            zzd(fieldDescriptor, ((Boolean) obj).booleanValue() ? 1 : 0, z3);
            return this;
        } else if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z3 && bArr.length == 0) {
                return this;
            }
            zzn((zzh(fieldDescriptor) << 3) | 2);
            zzn(bArr.length);
            this.zze.write(bArr);
            return this;
        } else {
            ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
            if (objectEncoder != null) {
                zzk(objectEncoder, fieldDescriptor, obj, z3);
                return this;
            }
            ValueEncoder valueEncoder = (ValueEncoder) this.zzg.get(obj.getClass());
            if (valueEncoder != null) {
                zzl(valueEncoder, fieldDescriptor, obj, z3);
                return this;
            } else if (obj instanceof zzbj) {
                zzd(fieldDescriptor, ((zzbj) obj).zza(), true);
                return this;
            } else if (obj instanceof Enum) {
                zzd(fieldDescriptor, ((Enum) obj).ordinal(), true);
                return this;
            } else {
                zzk(this.zzh, fieldDescriptor, obj, z3);
                return this;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbn zzd(@NonNull FieldDescriptor fieldDescriptor, int i4, boolean z3) throws IOException {
        if (z3 && i4 == 0) {
            return this;
        }
        zzbl zzj = zzj(fieldDescriptor);
        zzbk zzbkVar = zzbk.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    zzn((zzj.zza() << 3) | 5);
                    this.zze.write(zzm(4).putInt(i4).array());
                }
            } else {
                zzn(zzj.zza() << 3);
                zzn((i4 + i4) ^ (i4 >> 31));
            }
        } else {
            zzn(zzj.zza() << 3);
            zzn(i4);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbn zze(@NonNull FieldDescriptor fieldDescriptor, long j4, boolean z3) throws IOException {
        if (z3 && j4 == 0) {
            return this;
        }
        zzbl zzj = zzj(fieldDescriptor);
        zzbk zzbkVar = zzbk.DEFAULT;
        int ordinal = zzj.zzb().ordinal();
        if (ordinal != 0) {
            if (ordinal != 1) {
                if (ordinal == 2) {
                    zzn((zzj.zza() << 3) | 1);
                    this.zze.write(zzm(8).putLong(j4).array());
                }
            } else {
                zzn(zzj.zza() << 3);
                zzo((j4 >> 63) ^ (j4 + j4));
            }
        } else {
            zzn(zzj.zza() << 3);
            zzo(j4);
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzbn zzf(@Nullable Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        ObjectEncoder objectEncoder = (ObjectEncoder) this.zzf.get(obj.getClass());
        if (objectEncoder != null) {
            objectEncoder.encode(obj, this);
            return this;
        }
        throw new EncodingException("No encoder for ".concat(String.valueOf(obj.getClass())));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, float f4) throws IOException {
        zzb(fieldDescriptor, f4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext nested(@NonNull String str) throws IOException {
        return nested(FieldDescriptor.of(str));
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, int i4) throws IOException {
        zzd(fieldDescriptor, i4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, long j4) throws IOException {
        zze(fieldDescriptor, j4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, @Nullable Object obj) throws IOException {
        zzc(fieldDescriptor, obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final /* synthetic */ ObjectEncoderContext add(@NonNull FieldDescriptor fieldDescriptor, boolean z3) throws IOException {
        zzd(fieldDescriptor, z3 ? 1 : 0, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, double d4) throws IOException {
        zza(FieldDescriptor.of(str), d4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, int i4) throws IOException {
        zzd(FieldDescriptor.of(str), i4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, long j4) throws IOException {
        zze(FieldDescriptor.of(str), j4, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, @Nullable Object obj) throws IOException {
        zzc(FieldDescriptor.of(str), obj, true);
        return this;
    }

    @Override // com.google.firebase.encoders.ObjectEncoderContext
    @NonNull
    public final ObjectEncoderContext add(@NonNull String str, boolean z3) throws IOException {
        zzd(FieldDescriptor.of(str), z3 ? 1 : 0, true);
        return this;
    }
}
