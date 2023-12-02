package com.google.android.gms.internal.mlkit_translate;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.mlkit:translate@@17.0.1 */
/* loaded from: classes4.dex */
public final class zzci extends AbstractMap implements Serializable {
    private static final Comparator zzf = new zzcb();
    final Comparator zza;
    zzch zzb;
    int zzc;
    int zzd;
    final zzch zze;
    private zzcd zzg;
    private zzcf zzh;

    public zzci() {
        Comparator comparator = zzf;
        this.zzc = 0;
        this.zzd = 0;
        this.zze = new zzch();
        this.zza = comparator;
    }

    private final void zzf(zzch zzchVar, boolean z3) {
        int i4;
        int i5;
        int i6;
        int i7;
        while (zzchVar != null) {
            zzch zzchVar2 = zzchVar.zzb;
            zzch zzchVar3 = zzchVar.zzc;
            int i8 = 0;
            if (zzchVar2 != null) {
                i4 = zzchVar2.zzh;
            } else {
                i4 = 0;
            }
            if (zzchVar3 != null) {
                i5 = zzchVar3.zzh;
            } else {
                i5 = 0;
            }
            int i9 = i4 - i5;
            if (i9 == -2) {
                zzch zzchVar4 = zzchVar3.zzb;
                zzch zzchVar5 = zzchVar3.zzc;
                if (zzchVar5 != null) {
                    i7 = zzchVar5.zzh;
                } else {
                    i7 = 0;
                }
                if (zzchVar4 != null) {
                    i8 = zzchVar4.zzh;
                }
                int i10 = i8 - i7;
                if (i10 != -1 && (i10 != 0 || z3)) {
                    zzi(zzchVar3);
                    zzh(zzchVar);
                } else {
                    zzh(zzchVar);
                }
                if (z3) {
                    return;
                }
            } else if (i9 == 2) {
                zzch zzchVar6 = zzchVar2.zzb;
                zzch zzchVar7 = zzchVar2.zzc;
                if (zzchVar7 != null) {
                    i6 = zzchVar7.zzh;
                } else {
                    i6 = 0;
                }
                if (zzchVar6 != null) {
                    i8 = zzchVar6.zzh;
                }
                int i11 = i8 - i6;
                if (i11 != 1 && (i11 != 0 || z3)) {
                    zzh(zzchVar2);
                    zzi(zzchVar);
                } else {
                    zzi(zzchVar);
                }
                if (z3) {
                    return;
                }
            } else if (i9 == 0) {
                zzchVar.zzh = i4 + 1;
                if (z3) {
                    return;
                }
            } else {
                zzchVar.zzh = Math.max(i4, i5) + 1;
                if (!z3) {
                    return;
                }
            }
            zzchVar = zzchVar.zza;
        }
    }

    private final void zzg(zzch zzchVar, zzch zzchVar2) {
        zzch zzchVar3 = zzchVar.zza;
        zzchVar.zza = null;
        if (zzchVar2 != null) {
            zzchVar2.zza = zzchVar3;
        }
        if (zzchVar3 != null) {
            if (zzchVar3.zzb == zzchVar) {
                zzchVar3.zzb = zzchVar2;
                return;
            } else {
                zzchVar3.zzc = zzchVar2;
                return;
            }
        }
        this.zzb = zzchVar2;
    }

    private final void zzh(zzch zzchVar) {
        int i4;
        int i5;
        zzch zzchVar2 = zzchVar.zzb;
        zzch zzchVar3 = zzchVar.zzc;
        zzch zzchVar4 = zzchVar3.zzb;
        zzch zzchVar5 = zzchVar3.zzc;
        zzchVar.zzc = zzchVar4;
        if (zzchVar4 != null) {
            zzchVar4.zza = zzchVar;
        }
        zzg(zzchVar, zzchVar3);
        zzchVar3.zzb = zzchVar;
        zzchVar.zza = zzchVar3;
        int i6 = 0;
        if (zzchVar2 != null) {
            i4 = zzchVar2.zzh;
        } else {
            i4 = 0;
        }
        if (zzchVar4 != null) {
            i5 = zzchVar4.zzh;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        zzchVar.zzh = max;
        if (zzchVar5 != null) {
            i6 = zzchVar5.zzh;
        }
        zzchVar3.zzh = Math.max(max, i6) + 1;
    }

    private final void zzi(zzch zzchVar) {
        int i4;
        int i5;
        zzch zzchVar2 = zzchVar.zzb;
        zzch zzchVar3 = zzchVar.zzc;
        zzch zzchVar4 = zzchVar2.zzb;
        zzch zzchVar5 = zzchVar2.zzc;
        zzchVar.zzb = zzchVar5;
        if (zzchVar5 != null) {
            zzchVar5.zza = zzchVar;
        }
        zzg(zzchVar, zzchVar2);
        zzchVar2.zzc = zzchVar;
        zzchVar.zza = zzchVar2;
        int i6 = 0;
        if (zzchVar3 != null) {
            i4 = zzchVar3.zzh;
        } else {
            i4 = 0;
        }
        if (zzchVar5 != null) {
            i5 = zzchVar5.zzh;
        } else {
            i5 = 0;
        }
        int max = Math.max(i4, i5) + 1;
        zzchVar.zzh = max;
        if (zzchVar4 != null) {
            i6 = zzchVar4.zzh;
        }
        zzchVar2.zzh = Math.max(max, i6) + 1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.zzb = null;
        this.zzc = 0;
        this.zzd++;
        zzch zzchVar = this.zze;
        zzchVar.zze = zzchVar;
        zzchVar.zzd = zzchVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        if (zzc(obj) != null) {
            return true;
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        zzcd zzcdVar = this.zzg;
        if (zzcdVar != null) {
            return zzcdVar;
        }
        zzcd zzcdVar2 = new zzcd(this);
        this.zzg = zzcdVar2;
        return zzcdVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        zzch zzc = zzc(obj);
        if (zzc != null) {
            return zzc.zzg;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        zzcf zzcfVar = this.zzh;
        if (zzcfVar != null) {
            return zzcfVar;
        }
        zzcf zzcfVar2 = new zzcf(this);
        this.zzh = zzcfVar2;
        return zzcfVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj != null) {
            zzch zza = zza(obj, true);
            Object obj3 = zza.zzg;
            zza.zzg = obj2;
            return obj3;
        }
        throw new NullPointerException("key == null");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzch zzd = zzd(obj);
        if (zzd != null) {
            return zzd.zzg;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.zzc;
    }

    final zzch zza(Object obj, boolean z3) {
        int i4;
        zzch zzchVar;
        Comparable comparable;
        zzch zzchVar2;
        Comparator comparator = this.zza;
        zzch zzchVar3 = this.zzb;
        if (zzchVar3 != null) {
            if (comparator == zzf) {
                comparable = (Comparable) obj;
            } else {
                comparable = null;
            }
            while (true) {
                if (comparable != null) {
                    i4 = comparable.compareTo(zzchVar3.zzf);
                } else {
                    i4 = comparator.compare(obj, zzchVar3.zzf);
                }
                if (i4 == 0) {
                    return zzchVar3;
                }
                if (i4 < 0) {
                    zzchVar2 = zzchVar3.zzb;
                } else {
                    zzchVar2 = zzchVar3.zzc;
                }
                if (zzchVar2 == null) {
                    break;
                }
                zzchVar3 = zzchVar2;
            }
        } else {
            i4 = 0;
        }
        if (!z3) {
            return null;
        }
        zzch zzchVar4 = this.zze;
        if (zzchVar3 == null) {
            if (comparator == zzf && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            zzchVar = new zzch(null, obj, zzchVar4, zzchVar4.zze);
            this.zzb = zzchVar;
        } else {
            zzchVar = new zzch(zzchVar3, obj, zzchVar4, zzchVar4.zze);
            if (i4 < 0) {
                zzchVar3.zzb = zzchVar;
            } else {
                zzchVar3.zzc = zzchVar;
            }
            zzf(zzchVar3, true);
        }
        this.zzc++;
        this.zzd++;
        return zzchVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzch zzb(Map.Entry entry) {
        zzch zzc = zzc(entry.getKey());
        if (zzc != null) {
            Object obj = zzc.zzg;
            Object value = entry.getValue();
            if (obj == value || (obj != null && obj.equals(value))) {
                return zzc;
            }
            return null;
        }
        return null;
    }

    final zzch zzc(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            return zza(obj, false);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final zzch zzd(Object obj) {
        zzch zzc = zzc(obj);
        if (zzc != null) {
            zze(zzc, true);
        }
        return zzc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void zze(zzch zzchVar, boolean z3) {
        zzch zzchVar2;
        zzch zzchVar3;
        int i4;
        if (z3) {
            zzch zzchVar4 = zzchVar.zze;
            zzchVar4.zzd = zzchVar.zzd;
            zzchVar.zzd.zze = zzchVar4;
        }
        zzch zzchVar5 = zzchVar.zzb;
        zzch zzchVar6 = zzchVar.zzc;
        zzch zzchVar7 = zzchVar.zza;
        int i5 = 0;
        if (zzchVar5 != null && zzchVar6 != null) {
            if (zzchVar5.zzh > zzchVar6.zzh) {
                do {
                    zzchVar3 = zzchVar5;
                    zzchVar5 = zzchVar5.zzc;
                } while (zzchVar5 != null);
            } else {
                do {
                    zzchVar2 = zzchVar6;
                    zzchVar6 = zzchVar6.zzb;
                } while (zzchVar6 != null);
                zzchVar3 = zzchVar2;
            }
            zze(zzchVar3, false);
            zzch zzchVar8 = zzchVar.zzb;
            if (zzchVar8 != null) {
                i4 = zzchVar8.zzh;
                zzchVar3.zzb = zzchVar8;
                zzchVar8.zza = zzchVar3;
                zzchVar.zzb = null;
            } else {
                i4 = 0;
            }
            zzch zzchVar9 = zzchVar.zzc;
            if (zzchVar9 != null) {
                i5 = zzchVar9.zzh;
                zzchVar3.zzc = zzchVar9;
                zzchVar9.zza = zzchVar3;
                zzchVar.zzc = null;
            }
            zzchVar3.zzh = Math.max(i4, i5) + 1;
            zzg(zzchVar, zzchVar3);
            return;
        }
        if (zzchVar5 != null) {
            zzg(zzchVar, zzchVar5);
            zzchVar.zzb = null;
        } else if (zzchVar6 != null) {
            zzg(zzchVar, zzchVar6);
            zzchVar.zzc = null;
        } else {
            zzg(zzchVar, null);
        }
        zzf(zzchVar7, false);
        this.zzc--;
        this.zzd++;
    }
}
