package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzbr;
import com.google.android.gms.internal.icing.zzbs;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
public abstract class zzbs<MessageType extends zzbs<MessageType, BuilderType>, BuilderType extends zzbr<MessageType, BuilderType>> implements zzee {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void zzk(Iterable<T> iterable, List<? super T> list) {
        zzdh.zza(iterable);
        if (iterable instanceof zzdo) {
            List<?> zzh = ((zzdo) iterable).zzh();
            zzdo zzdoVar = (zzdo) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    int size2 = zzdoVar.size();
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2 - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    int size3 = zzdoVar.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            break;
                        }
                        zzdoVar.remove(size3);
                    }
                    throw new NullPointerException(sb2);
                } else if (obj instanceof zzcf) {
                    zzdoVar.zzf((zzcf) obj);
                } else {
                    zzdoVar.add((String) obj);
                }
            }
        } else if (!(iterable instanceof zzel)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
            }
            int size4 = list.size();
            for (T t3 : iterable) {
                if (t3 == 0) {
                    int size5 = list.size();
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(size5 - size4);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    int size6 = list.size();
                    while (true) {
                        size6--;
                        if (size6 < size4) {
                            break;
                        }
                        list.remove(size6);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(t3);
            }
        } else {
            list.addAll(iterable);
        }
    }

    @Override // com.google.android.gms.internal.icing.zzee
    public final zzcf zzg() {
        try {
            int zzo = zzo();
            zzcf zzcfVar = zzcf.zzb;
            byte[] bArr = new byte[zzo];
            zzcm zzt = zzcm.zzt(bArr);
            zzn(zzt);
            zzt.zzC();
            return new zzcd(bArr);
        } catch (IOException e4) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ByteString threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e4);
        }
    }

    public final byte[] zzh() {
        try {
            byte[] bArr = new byte[zzo()];
            zzcm zzt = zzcm.zzt(bArr);
            zzn(zzt);
            zzt.zzC();
            return bArr;
        } catch (IOException e4) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(name.length() + 72);
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a byte array threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzi() {
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzj(int i4) {
        throw null;
    }
}
