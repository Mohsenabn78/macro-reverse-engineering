package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.internal.p002firebaseauthapi.zzafh;
import com.google.android.gms.internal.p002firebaseauthapi.zzafi;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafi  reason: invalid package */
/* loaded from: classes4.dex */
public abstract class zzafi<MessageType extends zzafi<MessageType, BuilderType>, BuilderType extends zzafh<MessageType, BuilderType>> implements zzaii {
    protected int zza = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int zzn(zzaiu zzaiuVar) {
        throw null;
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    public final zzafy zzo() {
        try {
            int zzs = zzs();
            zzafy zzafyVar = zzafy.zzb;
            byte[] bArr = new byte[zzs];
            zzagl zzC = zzagl.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return new zzafv(bArr);
        } catch (IOException e4) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e4);
        }
    }

    public final void zzp(OutputStream outputStream) throws IOException {
        int zzs = zzs();
        int i4 = zzagl.zzf;
        if (zzs > 4096) {
            zzs = 4096;
        }
        zzagj zzagjVar = new zzagj(outputStream, zzs);
        zzJ(zzagjVar);
        zzagjVar.zzI();
    }

    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzaii
    public final byte[] zzq() {
        try {
            int zzs = zzs();
            byte[] bArr = new byte[zzs];
            zzagl zzC = zzagl.zzC(bArr, 0, zzs);
            zzJ(zzC);
            zzC.zzD();
            return bArr;
        } catch (IOException e4) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e4);
        }
    }
}
