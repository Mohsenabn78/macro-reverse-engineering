package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import kotlin.text.Typography;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: com.google.android.recaptcha:recaptcha@@18.1.2 */
/* loaded from: classes5.dex */
public final class zzia {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String zza(zzhy zzhyVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzhyVar, sb, 0);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void zzb(StringBuilder sb, int i4, String str, Object obj) {
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
            zzc(i4, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i5 = 1; i5 < str.length(); i5++) {
                    char charAt = str.charAt(i5);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzja.zza(new zzew(((String) obj).getBytes(zzgw.zzb))));
                sb.append(Typography.quote);
            } else if (obj instanceof zzez) {
                sb.append(": \"");
                sb.append(zzja.zza((zzez) obj));
                sb.append(Typography.quote);
            } else if (obj instanceof zzgo) {
                sb.append(" {");
                zzd((zzgo) obj, sb, i4 + 2);
                sb.append("\n");
                zzc(i4, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry2 = (Map.Entry) obj;
                int i6 = i4 + 2;
                zzb(sb, i6, "key", entry2.getKey());
                zzb(sb, i6, "value", entry2.getValue());
                sb.append("\n");
                zzc(i4, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i4, StringBuilder sb) {
        while (i4 > 0) {
            int i5 = 80;
            if (i4 <= 80) {
                i5 = i4;
            }
            sb.append(zza, 0, i5);
            i4 -= i5;
        }
    }

    private static void zzd(zzhy zzhyVar, StringBuilder sb, int i4) {
        int i5;
        boolean equals;
        Method method;
        Method method2;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzhyVar.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i6 = 0;
        while (true) {
            i5 = 3;
            if (i6 >= length) {
                break;
            }
            Method method3 = declaredMethods[i6];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i6++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i5);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb, i4, substring.substring(0, substring.length() - 4), zzgo.zzy(method2, zzhyVar, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb, i4, substring.substring(0, substring.length() - 3), zzgo.zzy(method, zzhyVar, new Object[0]));
            } else if (hashSet.contains("set".concat(substring)) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(substring));
                if (method4 != null) {
                    Object zzy = zzgo.zzy(method4, zzhyVar, new Object[0]);
                    if (method5 == null) {
                        if (zzy instanceof Boolean) {
                            if (!((Boolean) zzy).booleanValue()) {
                            }
                            zzb(sb, i4, substring, zzy);
                        } else if (zzy instanceof Integer) {
                            if (((Integer) zzy).intValue() == 0) {
                            }
                            zzb(sb, i4, substring, zzy);
                        } else if (zzy instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzy).floatValue()) == 0) {
                            }
                            zzb(sb, i4, substring, zzy);
                        } else if (zzy instanceof Double) {
                            if (Double.doubleToRawLongBits(((Double) zzy).doubleValue()) == 0) {
                            }
                            zzb(sb, i4, substring, zzy);
                        } else {
                            if (zzy instanceof String) {
                                equals = zzy.equals("");
                            } else if (zzy instanceof zzez) {
                                equals = zzy.equals(zzez.zzb);
                            } else if (zzy instanceof zzhy) {
                                if (zzy == ((zzhy) zzy).zzX()) {
                                }
                                zzb(sb, i4, substring, zzy);
                            } else {
                                if ((zzy instanceof Enum) && ((Enum) zzy).ordinal() == 0) {
                                }
                                zzb(sb, i4, substring, zzy);
                            }
                            if (equals) {
                            }
                            zzb(sb, i4, substring, zzy);
                        }
                    } else {
                        if (!((Boolean) zzgo.zzy(method5, zzhyVar, new Object[0])).booleanValue()) {
                        }
                        zzb(sb, i4, substring, zzy);
                    }
                }
            }
            i5 = 3;
        }
        if (zzhyVar instanceof zzgk) {
            Iterator zzf = ((zzgk) zzhyVar).zzb.zzf();
            while (zzf.hasNext()) {
                Map.Entry entry2 = (Map.Entry) zzf.next();
                int i7 = ((zzgl) entry2.getKey()).zza;
                zzb(sb, i4, "[" + i7 + "]", entry2.getValue());
            }
        }
        zzjg zzjgVar = ((zzgo) zzhyVar).zzc;
        if (zzjgVar != null) {
            zzjgVar.zzi(sb, i4);
        }
    }
}
