package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: com.google.firebase:firebase-auth@@22.1.1 */
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahs  reason: invalid package */
/* loaded from: classes4.dex */
final class zzahs extends zzahw {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ zzahs(zzahr zzahrVar) {
        super(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static List zzf(Object obj, long j4, int i4) {
        zzahp zzahpVar;
        List arrayList;
        List list = (List) zzajy.zzf(obj, j4);
        if (list.isEmpty()) {
            if (list instanceof zzahq) {
                arrayList = new zzahp(i4);
            } else if ((list instanceof zzaip) && (list instanceof zzahi)) {
                arrayList = ((zzahi) list).zzd(i4);
            } else {
                arrayList = new ArrayList(i4);
            }
            zzajy.zzs(obj, j4, arrayList);
            return arrayList;
        }
        if (zza.isAssignableFrom(list.getClass())) {
            ArrayList arrayList2 = new ArrayList(list.size() + i4);
            arrayList2.addAll(list);
            zzajy.zzs(obj, j4, arrayList2);
            zzahpVar = arrayList2;
        } else if (list instanceof zzajt) {
            zzahp zzahpVar2 = new zzahp(list.size() + i4);
            zzahpVar2.addAll(zzahpVar2.size(), (zzajt) list);
            zzajy.zzs(obj, j4, zzahpVar2);
            zzahpVar = zzahpVar2;
        } else if ((list instanceof zzaip) && (list instanceof zzahi)) {
            zzahi zzahiVar = (zzahi) list;
            if (!zzahiVar.zzc()) {
                zzahi zzd = zzahiVar.zzd(list.size() + i4);
                zzajy.zzs(obj, j4, zzd);
                return zzd;
            }
            return list;
        } else {
            return list;
        }
        return zzahpVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final List zza(Object obj, long j4) {
        return zzf(obj, j4, 10);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final void zzb(Object obj, long j4) {
        Object unmodifiableList;
        List list = (List) zzajy.zzf(obj, j4);
        if (list instanceof zzahq) {
            unmodifiableList = ((zzahq) list).zze();
        } else if (zza.isAssignableFrom(list.getClass())) {
            return;
        } else {
            if ((list instanceof zzaip) && (list instanceof zzahi)) {
                zzahi zzahiVar = (zzahi) list;
                if (zzahiVar.zzc()) {
                    zzahiVar.zzb();
                    return;
                }
                return;
            }
            unmodifiableList = Collections.unmodifiableList(list);
        }
        zzajy.zzs(obj, j4, unmodifiableList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.p002firebaseauthapi.zzahw
    public final void zzc(Object obj, Object obj2, long j4) {
        List list = (List) zzajy.zzf(obj2, j4);
        List zzf = zzf(obj, j4, list.size());
        int size = zzf.size();
        int size2 = list.size();
        if (size > 0 && size2 > 0) {
            zzf.addAll(list);
        }
        if (size > 0) {
            list = zzf;
        }
        zzajy.zzs(obj, j4, list);
    }

    private zzahs() {
        super(null);
    }
}
