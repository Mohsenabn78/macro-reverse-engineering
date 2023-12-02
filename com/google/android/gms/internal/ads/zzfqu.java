package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-ads@@22.3.0 */
/* loaded from: classes4.dex */
public class zzfqu extends zzfqs implements List {
    final /* synthetic */ zzfqv zzf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public zzfqu(zzfqv zzfqvVar, Object obj, @CheckForNull List list, zzfqs zzfqsVar) {
        super(zzfqvVar, obj, list, zzfqsVar);
        this.zzf = zzfqvVar;
    }

    @Override // java.util.List
    public final void add(int i4, Object obj) {
        int i5;
        zzb();
        boolean isEmpty = this.zzb.isEmpty();
        ((List) this.zzb).add(i4, obj);
        zzfqv zzfqvVar = this.zzf;
        i5 = zzfqvVar.zzb;
        zzfqvVar.zzb = i5 + 1;
        if (isEmpty) {
            zza();
        }
    }

    @Override // java.util.List
    public final boolean addAll(int i4, Collection collection) {
        int i5;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = ((List) this.zzb).addAll(i4, collection);
        if (addAll) {
            int size2 = this.zzb.size();
            zzfqv zzfqvVar = this.zzf;
            i5 = zzfqvVar.zzb;
            zzfqvVar.zzb = i5 + (size2 - size);
            if (size == 0) {
                zza();
                return true;
            }
            return addAll;
        }
        return addAll;
    }

    @Override // java.util.List
    public final Object get(int i4) {
        zzb();
        return ((List) this.zzb).get(i4);
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        zzb();
        return ((List) this.zzb).lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        zzb();
        return new zzfqt(this);
    }

    @Override // java.util.List
    public final Object remove(int i4) {
        int i5;
        zzb();
        Object remove = ((List) this.zzb).remove(i4);
        zzfqv zzfqvVar = this.zzf;
        i5 = zzfqvVar.zzb;
        zzfqvVar.zzb = i5 - 1;
        zzc();
        return remove;
    }

    @Override // java.util.List
    public final Object set(int i4, Object obj) {
        zzb();
        return ((List) this.zzb).set(i4, obj);
    }

    @Override // java.util.List
    public final List subList(int i4, int i5) {
        zzb();
        zzfqv zzfqvVar = this.zzf;
        Object obj = this.zza;
        List subList = ((List) this.zzb).subList(i4, i5);
        zzfqs zzfqsVar = this.zzc;
        if (zzfqsVar == null) {
            zzfqsVar = this;
        }
        return zzfqvVar.zzh(obj, subList, zzfqsVar);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i4) {
        zzb();
        return new zzfqt(this, i4);
    }
}
