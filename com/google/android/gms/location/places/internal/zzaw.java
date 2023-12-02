package com.google.android.gms.location.places.internal;

import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.places.zzbk;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes4.dex */
public class zzaw extends DataBufferRef {
    public zzaw(DataHolder dataHolder, int i4) {
        super(dataHolder, i4);
    }

    private final byte[] m(String str, byte[] bArr) {
        if (hasColumn(str) && !f(str)) {
            return b(str);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float h(String str, float f4) {
        if (hasColumn(str) && !f(str)) {
            return c(str);
        }
        return f4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <E extends SafeParcelable> E i(String str, Parcelable.Creator<E> creator) {
        byte[] m4 = m(str, null);
        if (m4 == null) {
            return null;
        }
        return (E) SafeParcelableSerializer.deserializeFromBytes(m4, creator);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String j(String str, String str2) {
        if (hasColumn(str) && !f(str)) {
            return e(str);
        }
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final <E extends SafeParcelable> List<E> k(String str, Parcelable.Creator<E> creator, List<E> list) {
        byte[] m4 = m(str, null);
        if (m4 == null) {
            return list;
        }
        try {
            com.google.android.gms.internal.places.zzl zzb = com.google.android.gms.internal.places.zzl.zzb(m4);
            if (zzb.zzt() == 0) {
                return list;
            }
            ArrayList arrayList = new ArrayList(zzb.zzt());
            for (com.google.android.gms.internal.places.zzw zzwVar : zzb.zzs()) {
                arrayList.add(SafeParcelableSerializer.deserializeFromBytes(zzwVar.toByteArray(), creator));
            }
            return arrayList;
        } catch (zzbk e4) {
            if (Log.isLoggable("SafeDataBufferRef", 6)) {
                Log.e("SafeDataBufferRef", "Cannot parse byte[]", e4);
            }
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<Integer> l(String str, List<Integer> list) {
        byte[] m4 = m(str, null);
        if (m4 == null) {
            return list;
        }
        try {
            com.google.android.gms.internal.places.zzl zzb = com.google.android.gms.internal.places.zzl.zzb(m4);
            if (zzb.zzr() == 0) {
                return list;
            }
            return zzb.zzq();
        } catch (zzbk e4) {
            if (Log.isLoggable("SafeDataBufferRef", 6)) {
                Log.e("SafeDataBufferRef", "Cannot parse byte[]", e4);
            }
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int n(String str, int i4) {
        if (hasColumn(str) && !f(str)) {
            return d(str);
        }
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<String> o(String str, List<String> list) {
        byte[] m4 = m(str, null);
        if (m4 == null) {
            return list;
        }
        try {
            com.google.android.gms.internal.places.zzl zzb = com.google.android.gms.internal.places.zzl.zzb(m4);
            if (zzb.zzp() == 0) {
                return list;
            }
            return zzb.zzo();
        } catch (zzbk e4) {
            if (Log.isLoggable("SafeDataBufferRef", 6)) {
                Log.e("SafeDataBufferRef", "Cannot parse byte[]", e4);
            }
            return list;
        }
    }
}
