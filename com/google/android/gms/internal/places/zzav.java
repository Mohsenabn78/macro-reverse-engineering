package com.google.android.gms.internal.places;

import com.google.android.gms.internal.places.zzax;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class zzav<FieldDescriptorType extends zzax<FieldDescriptorType>> {
    private static final zzav zzfm = new zzav(true);
    private boolean zzfk;
    private boolean zzfl = false;
    final zzdb<FieldDescriptorType, Object> zzfj = zzdb.zzal(16);

    private zzav() {
    }

    public static <T extends zzax<T>> zzav<T> zzau() {
        return zzfm;
    }

    private final Object zzb(FieldDescriptorType fielddescriptortype) {
        Object obj = this.zzfj.get(fielddescriptortype);
        return obj instanceof zzbl ? zzbl.zzbv() : obj;
    }

    private static boolean zzc(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        if (key.zzay() == zzem.MESSAGE) {
            if (key.zzaz()) {
                for (zzck zzckVar : (List) entry.getValue()) {
                    if (!zzckVar.isInitialized()) {
                        return false;
                    }
                }
            } else {
                Object value = entry.getValue();
                if (value instanceof zzck) {
                    if (!((zzck) value).isInitialized()) {
                        return false;
                    }
                } else if (value instanceof zzbl) {
                    return true;
                } else {
                    throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
                }
            }
        }
        return true;
    }

    private final void zzd(Map.Entry<FieldDescriptorType, Object> entry) {
        zzck zzbf;
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (value instanceof zzbl) {
            value = zzbl.zzbv();
        }
        if (key.zzaz()) {
            Object zzb = zzb((zzav<FieldDescriptorType>) key);
            if (zzb == null) {
                zzb = new ArrayList();
            }
            for (Object obj : (List) value) {
                ((List) zzb).add(zze(obj));
            }
            this.zzfj.zzb((zzdb<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzb);
        } else if (key.zzay() == zzem.MESSAGE) {
            Object zzb2 = zzb((zzav<FieldDescriptorType>) key);
            if (zzb2 == null) {
                this.zzfj.zzb((zzdb<FieldDescriptorType, Object>) key, (FieldDescriptorType) zze(value));
                return;
            }
            if (zzb2 instanceof zzcp) {
                zzbf = key.zzb((zzcp) zzb2, (zzcp) value);
            } else {
                zzbf = key.zzb(((zzck) zzb2).zzbk(), (zzck) value).zzbf();
            }
            this.zzfj.zzb((zzdb<FieldDescriptorType, Object>) key, (FieldDescriptorType) zzbf);
        } else {
            this.zzfj.zzb((zzdb<FieldDescriptorType, Object>) key, (FieldDescriptorType) zze(value));
        }
    }

    private static Object zze(Object obj) {
        if (obj instanceof zzcp) {
            return ((zzcp) obj).zzcm();
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            byte[] bArr2 = new byte[bArr.length];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            return bArr2;
        }
        return obj;
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzav zzavVar = new zzav();
        for (int i4 = 0; i4 < this.zzfj.zzcu(); i4++) {
            Map.Entry<FieldDescriptorType, Object> zzam = this.zzfj.zzam(i4);
            zzavVar.zzb((zzav) zzam.getKey(), zzam.getValue());
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfj.zzcv()) {
            zzavVar.zzb((zzav) entry.getKey(), entry.getValue());
        }
        zzavVar.zzfl = this.zzfl;
        return zzavVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Iterator<Map.Entry<FieldDescriptorType, Object>> descendingIterator() {
        if (this.zzfl) {
            return new zzbq(this.zzfj.zzcw().iterator());
        }
        return this.zzfj.zzcw().iterator();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzav)) {
            return false;
        }
        return this.zzfj.equals(((zzav) obj).zzfj);
    }

    public final int hashCode() {
        return this.zzfj.hashCode();
    }

    public final boolean isImmutable() {
        return this.zzfk;
    }

    public final boolean isInitialized() {
        for (int i4 = 0; i4 < this.zzfj.zzcu(); i4++) {
            if (!zzc(this.zzfj.zzam(i4))) {
                return false;
            }
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfj.zzcv()) {
            if (!zzc(entry)) {
                return false;
            }
        }
        return true;
    }

    public final Iterator<Map.Entry<FieldDescriptorType, Object>> iterator() {
        if (this.zzfl) {
            return new zzbq(this.zzfj.entrySet().iterator());
        }
        return this.zzfj.entrySet().iterator();
    }

    public final void zzab() {
        if (this.zzfk) {
            return;
        }
        this.zzfj.zzab();
        this.zzfk = true;
    }

    public final int zzav() {
        int i4 = 0;
        for (int i5 = 0; i5 < this.zzfj.zzcu(); i5++) {
            i4 += zze((Map.Entry) this.zzfj.zzam(i5));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : this.zzfj.zzcv()) {
            i4 += zze((Map.Entry) entry);
        }
        return i4;
    }

    private zzav(boolean z3) {
        zzab();
    }

    private final void zzb(FieldDescriptorType fielddescriptortype, Object obj) {
        if (fielddescriptortype.zzaz()) {
            if (obj instanceof List) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll((List) obj);
                int size = arrayList.size();
                int i4 = 0;
                while (i4 < size) {
                    Object obj2 = arrayList.get(i4);
                    i4++;
                    zzb(fielddescriptortype.zzax(), obj2);
                }
                obj = arrayList;
            } else {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
        } else {
            zzb(fielddescriptortype.zzax(), obj);
        }
        if (obj instanceof zzbl) {
            this.zzfl = true;
        }
        this.zzfj.zzb((zzdb<FieldDescriptorType, Object>) fielddescriptortype, (FieldDescriptorType) obj);
    }

    private static int zze(Map.Entry<FieldDescriptorType, Object> entry) {
        FieldDescriptorType key = entry.getKey();
        Object value = entry.getValue();
        if (key.zzay() == zzem.MESSAGE && !key.zzaz() && !key.zzba()) {
            if (value instanceof zzbl) {
                return zzaj.zzc(entry.getKey().zzaw(), (zzbl) value);
            }
            return zzaj.zzc(entry.getKey().zzaw(), (zzck) value);
        }
        return zzc((zzax<?>) key, value);
    }

    private static int zzc(zzef zzefVar, Object obj) {
        switch (zzau.zzfi[zzefVar.ordinal()]) {
            case 1:
                return zzaj.zzc(((Double) obj).doubleValue());
            case 2:
                return zzaj.zze(((Float) obj).floatValue());
            case 3:
                return zzaj.zzf(((Long) obj).longValue());
            case 4:
                return zzaj.zzg(((Long) obj).longValue());
            case 5:
                return zzaj.zzs(((Integer) obj).intValue());
            case 6:
                return zzaj.zzi(((Long) obj).longValue());
            case 7:
                return zzaj.zzv(((Integer) obj).intValue());
            case 8:
                return zzaj.zzd(((Boolean) obj).booleanValue());
            case 9:
                return zzaj.zze((zzck) obj);
            case 10:
                if (obj instanceof zzbl) {
                    return zzaj.zzb((zzbl) obj);
                }
                return zzaj.zzd((zzck) obj);
            case 11:
                if (obj instanceof zzw) {
                    return zzaj.zzc((zzw) obj);
                }
                return zzaj.zzk((String) obj);
            case 12:
                if (obj instanceof zzw) {
                    return zzaj.zzc((zzw) obj);
                }
                return zzaj.zzd((byte[]) obj);
            case 13:
                return zzaj.zzt(((Integer) obj).intValue());
            case 14:
                return zzaj.zzw(((Integer) obj).intValue());
            case 15:
                return zzaj.zzj(((Long) obj).longValue());
            case 16:
                return zzaj.zzu(((Integer) obj).intValue());
            case 17:
                return zzaj.zzh(((Long) obj).longValue());
            case 18:
                if (obj instanceof zzbg) {
                    return zzaj.zzx(((zzbg) obj).zzaw());
                }
                return zzaj.zzx(((Integer) obj).intValue());
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001e, code lost:
        r0 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0026, code lost:
        if ((r3 instanceof com.google.android.gms.internal.places.zzbg) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x002f, code lost:
        if ((r3 instanceof byte[]) == false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x001b, code lost:
        if ((r3 instanceof com.google.android.gms.internal.places.zzbl) == false) goto L7;
     */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void zzb(com.google.android.gms.internal.places.zzef r2, java.lang.Object r3) {
        /*
            com.google.android.gms.internal.places.zzbd.checkNotNull(r3)
            int[] r0 = com.google.android.gms.internal.places.zzau.zzfh
            com.google.android.gms.internal.places.zzem r2 = r2.zzdr()
            int r2 = r2.ordinal()
            r2 = r0[r2]
            r0 = 1
            r1 = 0
            switch(r2) {
                case 1: goto L41;
                case 2: goto L3e;
                case 3: goto L3b;
                case 4: goto L38;
                case 5: goto L35;
                case 6: goto L32;
                case 7: goto L29;
                case 8: goto L20;
                case 9: goto L15;
                default: goto L14;
            }
        L14:
            goto L44
        L15:
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzck
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzbl
            if (r2 == 0) goto L1e
            goto L43
        L1e:
            r0 = 0
            goto L43
        L20:
            boolean r2 = r3 instanceof java.lang.Integer
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzbg
            if (r2 == 0) goto L1e
            goto L43
        L29:
            boolean r2 = r3 instanceof com.google.android.gms.internal.places.zzw
            if (r2 != 0) goto L43
            boolean r2 = r3 instanceof byte[]
            if (r2 == 0) goto L1e
            goto L43
        L32:
            boolean r0 = r3 instanceof java.lang.String
            goto L43
        L35:
            boolean r0 = r3 instanceof java.lang.Boolean
            goto L43
        L38:
            boolean r0 = r3 instanceof java.lang.Double
            goto L43
        L3b:
            boolean r0 = r3 instanceof java.lang.Float
            goto L43
        L3e:
            boolean r0 = r3 instanceof java.lang.Long
            goto L43
        L41:
            boolean r0 = r3 instanceof java.lang.Integer
        L43:
            r1 = r0
        L44:
            if (r1 == 0) goto L47
            return
        L47:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Wrong object type used with protocol message reflection."
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.places.zzav.zzb(com.google.android.gms.internal.places.zzef, java.lang.Object):void");
    }

    public final void zzb(zzav<FieldDescriptorType> zzavVar) {
        for (int i4 = 0; i4 < zzavVar.zzfj.zzcu(); i4++) {
            zzd(zzavVar.zzfj.zzam(i4));
        }
        for (Map.Entry<FieldDescriptorType, Object> entry : zzavVar.zzfj.zzcv()) {
            zzd(entry);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(zzaj zzajVar, zzef zzefVar, int i4, Object obj) throws IOException {
        if (zzefVar == zzef.zzns) {
            zzck zzckVar = (zzck) obj;
            zzbd.zzg(zzckVar);
            zzajVar.zzc(i4, 3);
            zzckVar.zzc(zzajVar);
            zzajVar.zzc(i4, 4);
            return;
        }
        zzajVar.zzc(i4, zzefVar.zzds());
        switch (zzau.zzfi[zzefVar.ordinal()]) {
            case 1:
                zzajVar.zzb(((Double) obj).doubleValue());
                return;
            case 2:
                zzajVar.zzd(((Float) obj).floatValue());
                return;
            case 3:
                zzajVar.zzc(((Long) obj).longValue());
                return;
            case 4:
                zzajVar.zzc(((Long) obj).longValue());
                return;
            case 5:
                zzajVar.zzn(((Integer) obj).intValue());
                return;
            case 6:
                zzajVar.zze(((Long) obj).longValue());
                return;
            case 7:
                zzajVar.zzq(((Integer) obj).intValue());
                return;
            case 8:
                zzajVar.zzc(((Boolean) obj).booleanValue());
                return;
            case 9:
                ((zzck) obj).zzc(zzajVar);
                return;
            case 10:
                zzajVar.zzc((zzck) obj);
                return;
            case 11:
                if (obj instanceof zzw) {
                    zzajVar.zzb((zzw) obj);
                    return;
                } else {
                    zzajVar.zzj((String) obj);
                    return;
                }
            case 12:
                if (obj instanceof zzw) {
                    zzajVar.zzb((zzw) obj);
                    return;
                }
                byte[] bArr = (byte[]) obj;
                zzajVar.zze(bArr, 0, bArr.length);
                return;
            case 13:
                zzajVar.zzo(((Integer) obj).intValue());
                return;
            case 14:
                zzajVar.zzq(((Integer) obj).intValue());
                return;
            case 15:
                zzajVar.zze(((Long) obj).longValue());
                return;
            case 16:
                zzajVar.zzp(((Integer) obj).intValue());
                return;
            case 17:
                zzajVar.zzd(((Long) obj).longValue());
                return;
            case 18:
                if (obj instanceof zzbg) {
                    zzajVar.zzn(((zzbg) obj).zzaw());
                    return;
                } else {
                    zzajVar.zzn(((Integer) obj).intValue());
                    return;
                }
            default:
                return;
        }
    }

    public static int zzc(zzax<?> zzaxVar, Object obj) {
        zzef zzax = zzaxVar.zzax();
        int zzaw = zzaxVar.zzaw();
        if (zzaxVar.zzaz()) {
            int i4 = 0;
            if (zzaxVar.zzba()) {
                for (Object obj2 : (List) obj) {
                    i4 += zzc(zzax, obj2);
                }
                return zzaj.zzr(zzaw) + i4 + zzaj.zzz(i4);
            }
            for (Object obj3 : (List) obj) {
                i4 += zzb(zzax, zzaw, obj3);
            }
            return i4;
        }
        return zzb(zzax, zzaw, obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int zzb(zzef zzefVar, int i4, Object obj) {
        int zzr = zzaj.zzr(i4);
        if (zzefVar == zzef.zzns) {
            zzbd.zzg((zzck) obj);
            zzr <<= 1;
        }
        return zzr + zzc(zzefVar, obj);
    }
}
