package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.3.0 */
/* loaded from: classes4.dex */
public final class zzhb {
    public static final zzhb zza = new zzhb(null, null, 100);

    /* renamed from: a  reason: collision with root package name */
    private final EnumMap f21763a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21764b;

    public zzhb(Boolean bool, Boolean bool2, int i4) {
        EnumMap enumMap = new EnumMap(zzha.class);
        this.f21763a = enumMap;
        enumMap.put((EnumMap) zzha.AD_STORAGE, (zzha) bool);
        enumMap.put((EnumMap) zzha.ANALYTICS_STORAGE, (zzha) bool2);
        this.f21764b = i4;
    }

    static final int a(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        if (bool.booleanValue()) {
            return 1;
        }
        return 2;
    }

    private static Boolean b(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("granted")) {
            return Boolean.TRUE;
        }
        if (!str.equals("denied")) {
            return null;
        }
        return Boolean.FALSE;
    }

    public static zzhb zzb(Bundle bundle, int i4) {
        zzha[] values;
        if (bundle == null) {
            return new zzhb(null, null, i4);
        }
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzhaVar : zzha.values()) {
            enumMap.put((EnumMap) zzhaVar, (zzha) b(bundle.getString(zzhaVar.zzd)));
        }
        return new zzhb(enumMap, i4);
    }

    public static zzhb zzc(String str, int i4) {
        EnumMap enumMap = new EnumMap(zzha.class);
        if (str != null) {
            int i5 = 0;
            while (true) {
                zzha[] zzhaVarArr = zzha.zzc;
                int length = zzhaVarArr.length;
                if (i5 >= 2) {
                    break;
                }
                zzha zzhaVar = zzhaVarArr[i5];
                int i6 = i5 + 2;
                if (i6 < str.length()) {
                    char charAt = str.charAt(i6);
                    Boolean bool = null;
                    if (charAt != '-') {
                        if (charAt != '0') {
                            if (charAt == '1') {
                                bool = Boolean.TRUE;
                            }
                        } else {
                            bool = Boolean.FALSE;
                        }
                    }
                    enumMap.put((EnumMap) zzhaVar, (zzha) bool);
                }
                i5++;
            }
        }
        return new zzhb(enumMap, i4);
    }

    public static String zzh(Bundle bundle) {
        zzha[] values;
        String string;
        for (zzha zzhaVar : zzha.values()) {
            if (bundle.containsKey(zzhaVar.zzd) && (string = bundle.getString(zzhaVar.zzd)) != null && b(string) == null) {
                return string;
            }
        }
        return null;
    }

    public static boolean zzk(int i4, int i5) {
        if (i4 <= i5) {
            return true;
        }
        return false;
    }

    public final boolean equals(Object obj) {
        zzha[] values;
        if (!(obj instanceof zzhb)) {
            return false;
        }
        zzhb zzhbVar = (zzhb) obj;
        for (zzha zzhaVar : zzha.values()) {
            if (a((Boolean) this.f21763a.get(zzhaVar)) != a((Boolean) zzhbVar.f21763a.get(zzhaVar))) {
                return false;
            }
        }
        if (this.f21764b != zzhbVar.f21764b) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i4 = this.f21764b * 17;
        for (Boolean bool : this.f21763a.values()) {
            i4 = (i4 * 31) + a(bool);
        }
        return i4;
    }

    public final String toString() {
        zzha[] values;
        String str;
        StringBuilder sb = new StringBuilder("settings: source=");
        sb.append(this.f21764b);
        for (zzha zzhaVar : zzha.values()) {
            sb.append(", ");
            sb.append(zzhaVar.name());
            sb.append("=");
            Boolean bool = (Boolean) this.f21763a.get(zzhaVar);
            if (bool == null) {
                sb.append("uninitialized");
            } else {
                if (true != bool.booleanValue()) {
                    str = "denied";
                } else {
                    str = "granted";
                }
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public final int zza() {
        return this.f21764b;
    }

    public final zzhb zzd(zzhb zzhbVar) {
        zzha[] values;
        boolean z3;
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzhaVar : zzha.values()) {
            Boolean bool = (Boolean) this.f21763a.get(zzhaVar);
            Boolean bool2 = (Boolean) zzhbVar.f21763a.get(zzhaVar);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                if (bool.booleanValue() && bool2.booleanValue()) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                bool = Boolean.valueOf(z3);
            }
            enumMap.put((EnumMap) zzhaVar, (zzha) bool);
        }
        return new zzhb(enumMap, 100);
    }

    public final zzhb zze(zzhb zzhbVar) {
        zzha[] values;
        EnumMap enumMap = new EnumMap(zzha.class);
        for (zzha zzhaVar : zzha.values()) {
            Boolean bool = (Boolean) this.f21763a.get(zzhaVar);
            if (bool == null) {
                bool = (Boolean) zzhbVar.f21763a.get(zzhaVar);
            }
            enumMap.put((EnumMap) zzhaVar, (zzha) bool);
        }
        return new zzhb(enumMap, this.f21764b);
    }

    public final Boolean zzf() {
        return (Boolean) this.f21763a.get(zzha.AD_STORAGE);
    }

    public final Boolean zzg() {
        return (Boolean) this.f21763a.get(zzha.ANALYTICS_STORAGE);
    }

    public final String zzi() {
        char c4;
        StringBuilder sb = new StringBuilder("G1");
        zzha[] zzhaVarArr = zzha.zzc;
        int length = zzhaVarArr.length;
        for (int i4 = 0; i4 < 2; i4++) {
            Boolean bool = (Boolean) this.f21763a.get(zzhaVarArr[i4]);
            if (bool == null) {
                c4 = SignatureVisitor.SUPER;
            } else if (bool.booleanValue()) {
                c4 = '1';
            } else {
                c4 = '0';
            }
            sb.append(c4);
        }
        return sb.toString();
    }

    public final boolean zzj(zzha zzhaVar) {
        Boolean bool = (Boolean) this.f21763a.get(zzhaVar);
        if (bool != null && !bool.booleanValue()) {
            return false;
        }
        return true;
    }

    public final boolean zzl() {
        for (Boolean bool : this.f21763a.values()) {
            if (bool != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzm(zzhb zzhbVar) {
        return zzn(zzhbVar, (zzha[]) this.f21763a.keySet().toArray(new zzha[0]));
    }

    public final boolean zzn(zzhb zzhbVar, zzha... zzhaVarArr) {
        for (zzha zzhaVar : zzhaVarArr) {
            Boolean bool = (Boolean) this.f21763a.get(zzhaVar);
            Boolean bool2 = (Boolean) zzhbVar.f21763a.get(zzhaVar);
            Boolean bool3 = Boolean.FALSE;
            if (bool == bool3 && bool2 != bool3) {
                return true;
            }
        }
        return false;
    }

    public zzhb(EnumMap enumMap, int i4) {
        EnumMap enumMap2 = new EnumMap(zzha.class);
        this.f21763a = enumMap2;
        enumMap2.putAll(enumMap);
        this.f21764b = i4;
    }
}
