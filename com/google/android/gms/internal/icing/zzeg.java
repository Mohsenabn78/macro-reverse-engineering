package com.google.android.gms.internal.icing;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* compiled from: com.google.firebase:firebase-appindexing@@20.0.0 */
/* loaded from: classes4.dex */
final class zzeg {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzee zzeeVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzc(zzeeVar, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i4, String str, Object obj) {
        if (obj instanceof List) {
            for (Object obj2 : (List) obj) {
                zzb(sb, i4, str, obj2);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry entry : ((Map) obj).entrySet()) {
                zzb(sb, i4, str, entry);
            }
        } else {
            sb.append('\n');
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzfb.zza(zzcf.zzj((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzcf) {
                sb.append(": \"");
                sb.append(zzfb.zza((zzcf) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzda) {
                sb.append(" {");
                zzc((zzda) obj, sb, i4 + 2);
                sb.append("\n");
                while (i5 < i4) {
                    sb.append(' ');
                    i5++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i7 = i4 + 2;
                zzb(sb, i7, "key", entry2.getKey());
                zzb(sb, i7, "value", entry2.getValue());
                sb.append("\n");
                while (i5 < i4) {
                    sb.append(' ');
                    i5++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static void zzc(zzee zzeeVar, StringBuilder sb, int i4) {
        Method[] declaredMethods;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        boolean equals;
        String str6;
        String str7;
        String str8;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzeeVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str9 : treeSet) {
            if (str9.startsWith("get")) {
                str = str9.substring(3);
            } else {
                str = str9;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String valueOf = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(str.substring(1, str.length() - 4));
                if (valueOf2.length() != 0) {
                    str8 = valueOf.concat(valueOf2);
                } else {
                    str8 = new String(valueOf);
                }
                Method method2 = (Method) hashMap.get(str9);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i4, zzd(str8), zzda.zzs(method2, zzeeVar, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String valueOf3 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(str.substring(1, str.length() - 3));
                if (valueOf4.length() != 0) {
                    str7 = valueOf3.concat(valueOf4);
                } else {
                    str7 = new String(valueOf3);
                }
                Method method3 = (Method) hashMap.get(str9);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i4, zzd(str7), zzda.zzs(method3, zzeeVar, new Object[0]));
                }
            }
            if (str.length() != 0) {
                str2 = "set".concat(str);
            } else {
                str2 = new String("set");
            }
            if (((Method) hashMap2.get(str2)) != null) {
                if (str.endsWith("Bytes")) {
                    String valueOf5 = String.valueOf(str.substring(0, str.length() - 5));
                    if (valueOf5.length() != 0) {
                        str6 = "get".concat(valueOf5);
                    } else {
                        str6 = new String("get");
                    }
                    if (!hashMap.containsKey(str6)) {
                    }
                }
                String valueOf6 = String.valueOf(str.substring(0, 1).toLowerCase());
                String valueOf7 = String.valueOf(str.substring(1));
                if (valueOf7.length() != 0) {
                    str3 = valueOf6.concat(valueOf7);
                } else {
                    str3 = new String(valueOf6);
                }
                if (str.length() != 0) {
                    str4 = "get".concat(str);
                } else {
                    str4 = new String("get");
                }
                Method method4 = (Method) hashMap.get(str4);
                if (str.length() != 0) {
                    str5 = "has".concat(str);
                } else {
                    str5 = new String("has");
                }
                Method method5 = (Method) hashMap.get(str5);
                if (method4 != null) {
                    Object zzs = zzda.zzs(method4, zzeeVar, new Object[0]);
                    if (method5 == null) {
                        if (zzs instanceof Boolean) {
                            if (((Boolean) zzs).booleanValue()) {
                                zzb(sb, i4, zzd(str3), zzs);
                            }
                        } else if (zzs instanceof Integer) {
                            if (((Integer) zzs).intValue() != 0) {
                                zzb(sb, i4, zzd(str3), zzs);
                            }
                        } else if (zzs instanceof Float) {
                            if (((Float) zzs).floatValue() != 0.0f) {
                                zzb(sb, i4, zzd(str3), zzs);
                            }
                        } else if (zzs instanceof Double) {
                            if (((Double) zzs).doubleValue() != FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE) {
                                zzb(sb, i4, zzd(str3), zzs);
                            }
                        } else {
                            if (zzs instanceof String) {
                                equals = zzs.equals("");
                            } else if (zzs instanceof zzcf) {
                                equals = zzs.equals(zzcf.zzb);
                            } else if (zzs instanceof zzee) {
                                if (zzs != ((zzee) zzs).zzm()) {
                                    zzb(sb, i4, zzd(str3), zzs);
                                }
                            } else {
                                if ((zzs instanceof Enum) && ((Enum) zzs).ordinal() == 0) {
                                }
                                zzb(sb, i4, zzd(str3), zzs);
                            }
                            if (!equals) {
                                zzb(sb, i4, zzd(str3), zzs);
                            }
                        }
                    } else if (((Boolean) zzda.zzs(method5, zzeeVar, new Object[0])).booleanValue()) {
                        zzb(sb, i4, zzd(str3), zzs);
                    }
                }
            }
        }
        if (!(zzeeVar instanceof zzcy)) {
            zzfe zzfeVar = ((zzda) zzeeVar).zzc;
            if (zzfeVar != null) {
                zzfeVar.zze(sb, i4);
                return;
            }
            return;
        }
        zzcy zzcyVar = (zzcy) zzeeVar;
        throw null;
    }

    private static final String zzd(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < str.length(); i4++) {
            char charAt = str.charAt(i4);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
