package com.google.api.client.http;

import com.google.api.client.repackaged.com.google.common.base.Splitter;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Types;
import com.google.api.client.util.escape.CharEscapers;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.ListIterator;
import java.util.Map;
import kotlin.text.Typography;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes5.dex */
public class UriTemplate {

    /* renamed from: a  reason: collision with root package name */
    static final Map<Character, CompositeOutput> f25846a = new HashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public enum CompositeOutput {
        PLUS(Character.valueOf(SignatureVisitor.EXTENDS), "", ",", false, true),
        HASH('#', "#", ",", false, true),
        DOT('.', ".", ".", false, false),
        FORWARD_SLASH('/', RemoteSettings.FORWARD_SLASH_STRING, RemoteSettings.FORWARD_SLASH_STRING, false, false),
        SEMI_COLON(Character.valueOf(TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER), ";", ";", true, false),
        QUERY('?', TypeDescription.Generic.OfWildcardType.SYMBOL, "&", true, false),
        AMP(Character.valueOf(Typography.amp), "&", "&", true, false),
        SIMPLE(null, "", ",", false, false);
        
        private final String explodeJoiner;
        private final String outputPrefix;
        private final Character propertyPrefix;
        private final boolean requiresVarAssignment;
        private final boolean reservedExpansion;

        CompositeOutput(Character ch, String str, String str2, boolean z3, boolean z4) {
            this.propertyPrefix = ch;
            this.outputPrefix = (String) Preconditions.checkNotNull(str);
            this.explodeJoiner = (String) Preconditions.checkNotNull(str2);
            this.requiresVarAssignment = z3;
            this.reservedExpansion = z4;
            if (ch != null) {
                UriTemplate.f25846a.put(ch, this);
            }
        }

        String a(String str) {
            if (this.reservedExpansion) {
                return CharEscapers.escapeUriPath(str);
            }
            return CharEscapers.escapeUri(str);
        }

        String b() {
            return this.explodeJoiner;
        }

        String c() {
            return this.outputPrefix;
        }

        boolean e() {
            return this.reservedExpansion;
        }

        int f() {
            if (this.propertyPrefix == null) {
                return 0;
            }
            return 1;
        }

        boolean g() {
            return this.requiresVarAssignment;
        }
    }

    static {
        CompositeOutput.values();
    }

    static CompositeOutput a(String str) {
        CompositeOutput compositeOutput = f25846a.get(Character.valueOf(str.charAt(0)));
        if (compositeOutput == null) {
            return CompositeOutput.SIMPLE;
        }
        return compositeOutput;
    }

    private static String b(String str, Iterator<?> it, boolean z3, CompositeOutput compositeOutput) {
        String str2;
        if (!it.hasNext()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (z3) {
            str2 = compositeOutput.b();
        } else {
            if (compositeOutput.g()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append("=");
            }
            str2 = ",";
        }
        while (it.hasNext()) {
            if (z3 && compositeOutput.g()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append("=");
            }
            sb.append(compositeOutput.a(it.next().toString()));
            if (it.hasNext()) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    private static Map<String, Object> c(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, Object> entry : Data.mapOf(obj).entrySet()) {
            Object value = entry.getValue();
            if (value != null && !Data.isNull(value)) {
                linkedHashMap.put(entry.getKey(), value);
            }
        }
        return linkedHashMap;
    }

    private static String d(String str, Map<String, Object> map, boolean z3, CompositeOutput compositeOutput) {
        String str2;
        if (map.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String str3 = "=";
        if (z3) {
            str2 = compositeOutput.b();
        } else {
            if (compositeOutput.g()) {
                sb.append(CharEscapers.escapeUriPath(str));
                sb.append("=");
            }
            str3 = ",";
            str2 = ",";
        }
        Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Object> next = it.next();
            String a4 = compositeOutput.a(next.getKey());
            String a5 = compositeOutput.a(next.getValue().toString());
            sb.append(a4);
            sb.append(str3);
            sb.append(a5);
            if (it.hasNext()) {
                sb.append(str2);
            }
        }
        return sb.toString();
    }

    public static String expand(String str, String str2, Object obj, boolean z3) {
        String concat;
        if (str2.startsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            GenericUrl genericUrl = new GenericUrl(str);
            genericUrl.setRawPath(null);
            String valueOf = String.valueOf(genericUrl.build());
            if (str2.length() != 0) {
                concat = valueOf.concat(str2);
                str2 = concat;
            } else {
                str2 = new String(valueOf);
            }
        } else if (!str2.startsWith("http://") && !str2.startsWith("https://")) {
            String valueOf2 = String.valueOf(str);
            if (str2.length() != 0) {
                concat = valueOf2.concat(str2);
                str2 = concat;
            } else {
                str2 = new String(valueOf2);
            }
        }
        return expand(str2, obj, z3);
    }

    public static String expand(String str, Object obj, boolean z3) {
        Object b4;
        Map<String, Object> c4 = c(obj);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i4 = 0;
        while (true) {
            if (i4 >= length) {
                break;
            }
            int indexOf = str.indexOf(123, i4);
            if (indexOf != -1) {
                sb.append(str.substring(i4, indexOf));
                int indexOf2 = str.indexOf(125, indexOf + 2);
                int i5 = indexOf2 + 1;
                String substring = str.substring(indexOf + 1, indexOf2);
                CompositeOutput a4 = a(substring);
                ListIterator<String> listIterator = Splitter.on(',').splitToList(substring).listIterator();
                boolean z4 = true;
                while (listIterator.hasNext()) {
                    String next = listIterator.next();
                    boolean endsWith = next.endsWith("*");
                    int f4 = listIterator.nextIndex() == 1 ? a4.f() : 0;
                    int length2 = next.length();
                    if (endsWith) {
                        length2--;
                    }
                    String substring2 = next.substring(f4, length2);
                    Object remove = c4.remove(substring2);
                    if (remove != null) {
                        if (!z4) {
                            sb.append(a4.b());
                        } else {
                            sb.append(a4.c());
                            z4 = false;
                        }
                        if (remove instanceof Iterator) {
                            b4 = b(substring2, (Iterator) remove, endsWith, a4);
                        } else if (!(remove instanceof Iterable) && !remove.getClass().isArray()) {
                            if (remove.getClass().isEnum()) {
                                if (FieldInfo.of((Enum) remove).getName() != null) {
                                    if (a4.g()) {
                                        remove = String.format("%s=%s", substring2, remove);
                                    }
                                    remove = CharEscapers.escapeUriPath(remove.toString());
                                }
                                b4 = remove;
                            } else if (!Data.isValueOfPrimitiveType(remove)) {
                                b4 = d(substring2, c(remove), endsWith, a4);
                            } else {
                                if (a4.g()) {
                                    remove = String.format("%s=%s", substring2, remove);
                                }
                                if (a4.e()) {
                                    b4 = CharEscapers.escapeUriPathWithoutReserved(remove.toString());
                                } else {
                                    b4 = CharEscapers.escapeUriPath(remove.toString());
                                }
                            }
                        } else {
                            b4 = b(substring2, Types.iterableOf(remove).iterator(), endsWith, a4);
                        }
                        sb.append(b4);
                    }
                }
                i4 = i5;
            } else if (i4 == 0 && !z3) {
                return str;
            } else {
                sb.append(str.substring(i4));
            }
        }
        if (z3) {
            GenericUrl.a(c4.entrySet(), sb);
        }
        return sb.toString();
    }
}
