package com.google.android.gms.internal.wearable;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-wearable@@18.0.0 */
/* loaded from: classes4.dex */
public final class zzde {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzdc zzdcVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzdcVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void zzb(StringBuilder sb, int i4, String str, Object obj) {
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
                sb.append(zzec.zza(zzaw.zzo((String) obj)));
                sb.append(Typography.quote);
            } else if (obj instanceof zzaw) {
                sb.append(": \"");
                sb.append(zzec.zza((zzaw) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzbv) {
                sb.append(" {");
                zzd((zzbv) obj, sb, i4 + 2);
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
                sb.append(obj);
            }
        }
    }

    private static final String zzc(String str) {
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

    private static void zzd(zzdc zzdcVar, StringBuilder sb, int i4) {
        Method[] declaredMethods;
        String str;
        boolean equals;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet();
        for (Method method : zzdcVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str2 : treeSet) {
            if (str2.startsWith("get")) {
                str = str2.substring(3);
            } else {
                str = str2;
            }
            if (str.endsWith("List") && !str.endsWith("OrBuilderList") && !str.equals("List")) {
                String concat = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 4)));
                Method method2 = (Method) hashMap.get(str2);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i4, zzc(concat), zzbv.zzX(method2, zzdcVar, new Object[0]));
                }
            }
            if (str.endsWith("Map") && !str.equals("Map")) {
                String concat2 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1, str.length() - 3)));
                Method method3 = (Method) hashMap.get(str2);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i4, zzc(concat2), zzbv.zzX(method3, zzdcVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set".concat(str))) != null && (!str.endsWith("Bytes") || !hashMap.containsKey("get".concat(String.valueOf(str.substring(0, str.length() - 5)))))) {
                String concat3 = String.valueOf(str.substring(0, 1).toLowerCase()).concat(String.valueOf(str.substring(1)));
                Method method4 = (Method) hashMap.get("get".concat(str));
                Method method5 = (Method) hashMap.get("has".concat(str));
                if (method4 != null) {
                    Object zzX = zzbv.zzX(method4, zzdcVar, new Object[0]);
                    if (method5 == null) {
                        if (zzX instanceof Boolean) {
                            if (((Boolean) zzX).booleanValue()) {
                                zzb(sb, i4, zzc(concat3), zzX);
                            }
                        } else if (zzX instanceof Integer) {
                            if (((Integer) zzX).intValue() != 0) {
                                zzb(sb, i4, zzc(concat3), zzX);
                            }
                        } else if (zzX instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzX).floatValue()) != 0) {
                                zzb(sb, i4, zzc(concat3), zzX);
                            }
                        } else if (zzX instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) zzX).doubleValue()) != 0) {
                                zzb(sb, i4, zzc(concat3), zzX);
                            }
                        } else {
                            if (zzX instanceof String) {
                                equals = zzX.equals("");
                            } else if (zzX instanceof zzaw) {
                                equals = zzX.equals(zzaw.zzb);
                            } else if (zzX instanceof zzdc) {
                                if (zzX != ((zzdc) zzX).zzac()) {
                                    zzb(sb, i4, zzc(concat3), zzX);
                                }
                            } else {
                                if ((zzX instanceof Enum) && ((Enum) zzX).ordinal() == 0) {
                                }
                                zzb(sb, i4, zzc(concat3), zzX);
                            }
                            if (!equals) {
                                zzb(sb, i4, zzc(concat3), zzX);
                            }
                        }
                    } else if (((Boolean) zzbv.zzX(method5, zzdcVar, new Object[0])).booleanValue()) {
                        zzb(sb, i4, zzc(concat3), zzX);
                    }
                }
            }
        }
        if (!(zzdcVar instanceof zzbt)) {
            zzef zzefVar = ((zzbv) zzdcVar).zzc;
            if (zzefVar != null) {
                zzefVar.zzg(sb, i4);
                return;
            }
            return;
        }
        zzbt zzbtVar = (zzbt) zzdcVar;
        throw null;
    }
}
