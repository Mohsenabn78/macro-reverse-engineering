package com.google.android.gms.internal.measurement;

import com.google.android.gms.ads.AdError;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzbk extends zzaw {
    /* JADX INFO: Access modifiers changed from: protected */
    public zzbk() {
        this.zza.add(zzbl.ASSIGN);
        this.zza.add(zzbl.CONST);
        this.zza.add(zzbl.CREATE_ARRAY);
        this.zza.add(zzbl.CREATE_OBJECT);
        this.zza.add(zzbl.EXPRESSION_LIST);
        this.zza.add(zzbl.GET);
        this.zza.add(zzbl.GET_INDEX);
        this.zza.add(zzbl.GET_PROPERTY);
        this.zza.add(zzbl.NULL);
        this.zza.add(zzbl.SET_PROPERTY);
        this.zza.add(zzbl.TYPEOF);
        this.zza.add(zzbl.UNDEFINED);
        this.zza.add(zzbl.VAR);
    }

    @Override // com.google.android.gms.internal.measurement.zzaw
    public final zzap zza(String str, zzg zzgVar, List list) {
        String str2;
        zzbl zzblVar = zzbl.ADD;
        int ordinal = zzh.zze(str).ordinal();
        int i4 = 0;
        if (ordinal != 3) {
            if (ordinal != 14) {
                if (ordinal != 24) {
                    if (ordinal != 33) {
                        if (ordinal != 49) {
                            if (ordinal != 58) {
                                if (ordinal != 17) {
                                    if (ordinal != 18) {
                                        if (ordinal != 35 && ordinal != 36) {
                                            switch (ordinal) {
                                                case 62:
                                                    zzh.zzh(zzbl.TYPEOF.name(), 1, list);
                                                    zzap zzb = zzgVar.zzb((zzap) list.get(0));
                                                    if (zzb instanceof zzau) {
                                                        str2 = AdError.UNDEFINED_DOMAIN;
                                                    } else if (zzb instanceof zzaf) {
                                                        str2 = "boolean";
                                                    } else if (zzb instanceof zzah) {
                                                        str2 = "number";
                                                    } else if (zzb instanceof zzat) {
                                                        str2 = "string";
                                                    } else if (zzb instanceof zzao) {
                                                        str2 = "function";
                                                    } else if (!(zzb instanceof zzaq) && !(zzb instanceof zzag)) {
                                                        str2 = "object";
                                                    } else {
                                                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", zzb));
                                                    }
                                                    return new zzat(str2);
                                                case 63:
                                                    zzh.zzh(zzbl.UNDEFINED.name(), 0, list);
                                                    return zzap.zzf;
                                                case 64:
                                                    zzh.zzi(zzbl.VAR.name(), 1, list);
                                                    Iterator it = list.iterator();
                                                    while (it.hasNext()) {
                                                        zzap zzb2 = zzgVar.zzb((zzap) it.next());
                                                        if (zzb2 instanceof zzat) {
                                                            zzgVar.zze(zzb2.zzi(), zzap.zzf);
                                                        } else {
                                                            throw new IllegalArgumentException(String.format("Expected string for var name. got %s", zzb2.getClass().getCanonicalName()));
                                                        }
                                                    }
                                                    return zzap.zzf;
                                                default:
                                                    return super.zzb(str);
                                            }
                                        }
                                        zzh.zzh(zzbl.GET_PROPERTY.name(), 2, list);
                                        zzap zzb3 = zzgVar.zzb((zzap) list.get(0));
                                        zzap zzb4 = zzgVar.zzb((zzap) list.get(1));
                                        if ((zzb3 instanceof zzae) && zzh.zzk(zzb4)) {
                                            return ((zzae) zzb3).zze(zzb4.zzh().intValue());
                                        }
                                        if (zzb3 instanceof zzal) {
                                            return ((zzal) zzb3).zzf(zzb4.zzi());
                                        }
                                        if (zzb3 instanceof zzat) {
                                            if ("length".equals(zzb4.zzi())) {
                                                return new zzah(Double.valueOf(zzb3.zzi().length()));
                                            }
                                            if (zzh.zzk(zzb4) && zzb4.zzh().doubleValue() < zzb3.zzi().length()) {
                                                return new zzat(String.valueOf(zzb3.zzi().charAt(zzb4.zzh().intValue())));
                                            }
                                        }
                                        return zzap.zzf;
                                    } else if (list.isEmpty()) {
                                        return new zzam();
                                    } else {
                                        if (list.size() % 2 == 0) {
                                            zzam zzamVar = new zzam();
                                            while (i4 < list.size() - 1) {
                                                zzap zzb5 = zzgVar.zzb((zzap) list.get(i4));
                                                zzap zzb6 = zzgVar.zzb((zzap) list.get(i4 + 1));
                                                if (!(zzb5 instanceof zzag) && !(zzb6 instanceof zzag)) {
                                                    zzamVar.zzr(zzb5.zzi(), zzb6);
                                                    i4 += 2;
                                                } else {
                                                    throw new IllegalStateException("Failed to evaluate map entry");
                                                }
                                            }
                                            return zzamVar;
                                        }
                                        throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                                    }
                                } else if (list.isEmpty()) {
                                    return new zzae();
                                } else {
                                    zzae zzaeVar = new zzae();
                                    Iterator it2 = list.iterator();
                                    while (it2.hasNext()) {
                                        zzap zzb7 = zzgVar.zzb((zzap) it2.next());
                                        if (!(zzb7 instanceof zzag)) {
                                            zzaeVar.zzq(i4, zzb7);
                                            i4++;
                                        } else {
                                            throw new IllegalStateException("Failed to evaluate array element");
                                        }
                                    }
                                    return zzaeVar;
                                }
                            }
                            zzh.zzh(zzbl.SET_PROPERTY.name(), 3, list);
                            zzap zzb8 = zzgVar.zzb((zzap) list.get(0));
                            zzap zzb9 = zzgVar.zzb((zzap) list.get(1));
                            zzap zzb10 = zzgVar.zzb((zzap) list.get(2));
                            if (zzb8 != zzap.zzf && zzb8 != zzap.zzg) {
                                if ((zzb8 instanceof zzae) && (zzb9 instanceof zzah)) {
                                    ((zzae) zzb8).zzq(zzb9.zzh().intValue(), zzb10);
                                } else if (zzb8 instanceof zzal) {
                                    ((zzal) zzb8).zzr(zzb9.zzi(), zzb10);
                                }
                                return zzb10;
                            }
                            throw new IllegalStateException(String.format("Can't set property %s of %s", zzb9.zzi(), zzb8.zzi()));
                        }
                        zzh.zzh(zzbl.NULL.name(), 0, list);
                        return zzap.zzg;
                    }
                    zzh.zzh(zzbl.GET.name(), 1, list);
                    zzap zzb11 = zzgVar.zzb((zzap) list.get(0));
                    if (zzb11 instanceof zzat) {
                        return zzgVar.zzd(zzb11.zzi());
                    }
                    throw new IllegalArgumentException(String.format("Expected string for get var. got %s", zzb11.getClass().getCanonicalName()));
                }
                zzh.zzi(zzbl.EXPRESSION_LIST.name(), 1, list);
                zzap zzapVar = zzap.zzf;
                while (i4 < list.size()) {
                    zzapVar = zzgVar.zzb((zzap) list.get(i4));
                    if (!(zzapVar instanceof zzag)) {
                        i4++;
                    } else {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                }
                return zzapVar;
            }
            zzh.zzi(zzbl.CONST.name(), 2, list);
            if (list.size() % 2 == 0) {
                for (int i5 = 0; i5 < list.size() - 1; i5 += 2) {
                    zzap zzb12 = zzgVar.zzb((zzap) list.get(i5));
                    if (zzb12 instanceof zzat) {
                        zzgVar.zzf(zzb12.zzi(), zzgVar.zzb((zzap) list.get(i5 + 1)));
                    } else {
                        throw new IllegalArgumentException(String.format("Expected string for const name. got %s", zzb12.getClass().getCanonicalName()));
                    }
                }
                return zzap.zzf;
            }
            throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
        }
        zzh.zzh(zzbl.ASSIGN.name(), 2, list);
        zzap zzb13 = zzgVar.zzb((zzap) list.get(0));
        if (zzb13 instanceof zzat) {
            if (zzgVar.zzh(zzb13.zzi())) {
                zzap zzb14 = zzgVar.zzb((zzap) list.get(1));
                zzgVar.zzg(zzb13.zzi(), zzb14);
                return zzb14;
            }
            throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", zzb13.zzi()));
        }
        throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", zzb13.getClass().getCanonicalName()));
    }
}
