package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgnm;
import com.google.android.gms.internal.ads.zzgnn;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public abstract class zzgnn<MessageType extends zzgnn<MessageType, BuilderType>, BuilderType extends zzgnm<MessageType, BuilderType>> implements zzgqw {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public static void zzav(Iterable iterable, List list) {
        byte[] bArr = zzgpw.zzd;
        iterable.getClass();
        if (iterable instanceof zzgqe) {
            List zzh = ((zzgqe) iterable).zzh();
            zzgqe zzgqeVar = (zzgqe) list;
            int size = list.size();
            for (Object obj : zzh) {
                if (obj == null) {
                    String str = "Element at index " + (zzgqeVar.size() - size) + " is null.";
                    int size2 = zzgqeVar.size();
                    while (true) {
                        size2--;
                        if (size2 < size) {
                            break;
                        }
                        zzgqeVar.remove(size2);
                    }
                    throw new NullPointerException(str);
                } else if (obj instanceof zzgoe) {
                    zzgqeVar.zzi((zzgoe) obj);
                } else {
                    zzgqeVar.add((String) obj);
                }
            }
        } else if (!(iterable instanceof zzgrd)) {
            if (list instanceof ArrayList) {
                ((ArrayList) list).ensureCapacity(list.size() + iterable.size());
            }
            int size3 = list.size();
            for (Object obj2 : iterable) {
                if (obj2 == null) {
                    String str2 = "Element at index " + (list.size() - size3) + " is null.";
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 < size3) {
                            break;
                        }
                        list.remove(size4);
                    }
                    throw new NullPointerException(str2);
                }
                list.add(obj2);
            }
        } else {
            list.addAll(iterable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzat(zzgrp zzgrpVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgqw
    public final zzgoe zzau() {
        try {
            int zzaz = zzaz();
            zzgoe zzgoeVar = zzgoe.zzb;
            byte[] bArr = new byte[zzaz];
            zzgot zzC = zzgot.zzC(bArr, 0, zzaz);
            zzaW(zzC);
            zzC.zzD();
            return new zzgoa(bArr);
        } catch (IOException e4) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e4);
        }
    }

    public final void zzaw(OutputStream outputStream) throws IOException {
        int zzaz = zzaz();
        int i4 = zzgot.zzf;
        if (zzaz > 4096) {
            zzaz = 4096;
        }
        zzgor zzgorVar = new zzgor(outputStream, zzaz);
        zzaW(zzgorVar);
        zzgorVar.zzI();
    }

    @Override // com.google.android.gms.internal.ads.zzgqw
    public final byte[] zzax() {
        try {
            int zzaz = zzaz();
            byte[] bArr = new byte[zzaz];
            zzgot zzC = zzgot.zzC(bArr, 0, zzaz);
            zzaW(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e4) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e4);
        }
    }
}
