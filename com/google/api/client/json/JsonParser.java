package com.google.api.client.json;

import com.google.api.client.json.JsonPolymorphicTypeMap;
import com.google.api.client.util.Beta;
import com.google.api.client.util.ClassInfo;
import com.google.api.client.util.Data;
import com.google.api.client.util.FieldInfo;
import com.google.api.client.util.GenericData;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sets;
import com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes5.dex */
public abstract class JsonParser {

    /* renamed from: a  reason: collision with root package name */
    private static WeakHashMap<Class<?>, Field> f25895a = new WeakHashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final Lock f25896b = new ReentrantLock();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.google.api.client.json.JsonParser$1  reason: invalid class name */
    /* loaded from: classes5.dex */
    public static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25897a;

        static {
            int[] iArr = new int[JsonToken.values().length];
            f25897a = iArr;
            try {
                iArr[JsonToken.START_OBJECT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25897a[JsonToken.START_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25897a[JsonToken.END_ARRAY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f25897a[JsonToken.FIELD_NAME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25897a[JsonToken.END_OBJECT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25897a[JsonToken.VALUE_TRUE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f25897a[JsonToken.VALUE_FALSE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f25897a[JsonToken.VALUE_NUMBER_FLOAT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f25897a[JsonToken.VALUE_NUMBER_INT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f25897a[JsonToken.VALUE_STRING.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f25897a[JsonToken.VALUE_NULL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    private static Field a(Class<?> cls) {
        boolean z3;
        boolean z4;
        Field field = null;
        if (cls == null) {
            return null;
        }
        Lock lock = f25896b;
        lock.lock();
        try {
            if (f25895a.containsKey(cls)) {
                Field field2 = f25895a.get(cls);
                lock.unlock();
                return field2;
            }
            for (FieldInfo fieldInfo : ClassInfo.of(cls).getFieldInfos()) {
                Field field3 = fieldInfo.getField();
                JsonPolymorphicTypeMap jsonPolymorphicTypeMap = (JsonPolymorphicTypeMap) field3.getAnnotation(JsonPolymorphicTypeMap.class);
                if (jsonPolymorphicTypeMap != null) {
                    if (field == null) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    Preconditions.checkArgument(z3, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", cls);
                    Preconditions.checkArgument(Data.isPrimitive(field3.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", cls, field3.getType());
                    JsonPolymorphicTypeMap.TypeDef[] typeDefinitions = jsonPolymorphicTypeMap.typeDefinitions();
                    HashSet newHashSet = Sets.newHashSet();
                    if (typeDefinitions.length > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    Preconditions.checkArgument(z4, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                    for (JsonPolymorphicTypeMap.TypeDef typeDef : typeDefinitions) {
                        Preconditions.checkArgument(newHashSet.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                    }
                    field = field3;
                }
            }
            f25895a.put(cls, field);
            return field;
        } finally {
            f25896b.unlock();
        }
    }

    private void b(ArrayList<Type> arrayList, Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        if (obj instanceof GenericJson) {
            ((GenericJson) obj).setFactory(getFactory());
        }
        JsonToken g4 = g();
        Class<?> cls = obj.getClass();
        ClassInfo of = ClassInfo.of(cls);
        boolean isAssignableFrom = GenericData.class.isAssignableFrom(cls);
        if (!isAssignableFrom && Map.class.isAssignableFrom(cls)) {
            d(null, (Map) obj, Types.getMapValueParameter(cls), arrayList, customizeJsonParser);
            return;
        }
        while (g4 == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (customizeJsonParser != null && customizeJsonParser.stopAt(obj, text)) {
                return;
            }
            FieldInfo fieldInfo = of.getFieldInfo(text);
            if (fieldInfo != null) {
                if (fieldInfo.isFinal() && !fieldInfo.isPrimitive()) {
                    throw new IllegalArgumentException("final array/object fields are not supported");
                }
                Field field = fieldInfo.getField();
                int size = arrayList.size();
                arrayList.add(field.getGenericType());
                Object e4 = e(field, fieldInfo.getGenericType(), arrayList, obj, customizeJsonParser, true);
                arrayList.remove(size);
                fieldInfo.setValue(obj, e4);
            } else if (isAssignableFrom) {
                ((GenericData) obj).set(text, e(null, null, arrayList, obj, customizeJsonParser, true));
            } else {
                if (customizeJsonParser != null) {
                    customizeJsonParser.handleUnrecognizedKey(obj, text);
                }
                skipChildren();
            }
            g4 = nextToken();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void c(Field field, Collection<T> collection, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken g4 = g();
        while (g4 != JsonToken.END_ARRAY) {
            collection.add(e(field, type, arrayList, collection, customizeJsonParser, true));
            g4 = nextToken();
        }
    }

    private void d(Field field, Map<String, Object> map, Type type, ArrayList<Type> arrayList, CustomizeJsonParser customizeJsonParser) throws IOException {
        JsonToken g4 = g();
        while (g4 == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (customizeJsonParser != null && customizeJsonParser.stopAt(map, text)) {
                return;
            }
            map.put(text, e(field, type, arrayList, map, customizeJsonParser, true));
            g4 = nextToken();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01bd A[Catch: IllegalArgumentException -> 0x0341, TryCatch #1 {IllegalArgumentException -> 0x0341, blocks: (B:14:0x002f, B:21:0x0052, B:24:0x0059, B:26:0x0060, B:28:0x0068, B:30:0x006e, B:32:0x007b, B:34:0x0081, B:36:0x008e, B:38:0x0097, B:41:0x00ab, B:51:0x00cb, B:54:0x00d5, B:57:0x00dc, B:58:0x00e1, B:44:0x00b1, B:46:0x00b9, B:48:0x00c1, B:61:0x00ec, B:64:0x00f3, B:66:0x00fa, B:71:0x0108, B:74:0x010f, B:79:0x0119, B:83:0x0120, B:88:0x0129, B:93:0x0132, B:98:0x013b, B:101:0x0140, B:102:0x0160, B:103:0x0161, B:105:0x016a, B:107:0x0173, B:109:0x017c, B:111:0x0185, B:113:0x018e, B:115:0x0197, B:118:0x019e, B:121:0x01a4, B:126:0x01b0, B:128:0x01bd, B:129:0x01c0, B:131:0x01c3, B:135:0x01cd, B:140:0x01d7, B:143:0x01e4, B:146:0x01ec, B:149:0x01f3, B:154:0x0206, B:156:0x0219, B:151:0x01fa, B:153:0x0202, B:159:0x0223, B:163:0x022c, B:165:0x0237, B:169:0x0241, B:172:0x0249, B:177:0x0254, B:184:0x026a, B:186:0x0271, B:188:0x0276, B:190:0x027e, B:192:0x0284, B:195:0x028d, B:182:0x0261, B:183:0x0266), top: B:238:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01c0 A[Catch: IllegalArgumentException -> 0x0341, TryCatch #1 {IllegalArgumentException -> 0x0341, blocks: (B:14:0x002f, B:21:0x0052, B:24:0x0059, B:26:0x0060, B:28:0x0068, B:30:0x006e, B:32:0x007b, B:34:0x0081, B:36:0x008e, B:38:0x0097, B:41:0x00ab, B:51:0x00cb, B:54:0x00d5, B:57:0x00dc, B:58:0x00e1, B:44:0x00b1, B:46:0x00b9, B:48:0x00c1, B:61:0x00ec, B:64:0x00f3, B:66:0x00fa, B:71:0x0108, B:74:0x010f, B:79:0x0119, B:83:0x0120, B:88:0x0129, B:93:0x0132, B:98:0x013b, B:101:0x0140, B:102:0x0160, B:103:0x0161, B:105:0x016a, B:107:0x0173, B:109:0x017c, B:111:0x0185, B:113:0x018e, B:115:0x0197, B:118:0x019e, B:121:0x01a4, B:126:0x01b0, B:128:0x01bd, B:129:0x01c0, B:131:0x01c3, B:135:0x01cd, B:140:0x01d7, B:143:0x01e4, B:146:0x01ec, B:149:0x01f3, B:154:0x0206, B:156:0x0219, B:151:0x01fa, B:153:0x0202, B:159:0x0223, B:163:0x022c, B:165:0x0237, B:169:0x0241, B:172:0x0249, B:177:0x0254, B:184:0x026a, B:186:0x0271, B:188:0x0276, B:190:0x027e, B:192:0x0284, B:195:0x028d, B:182:0x0261, B:183:0x0266), top: B:238:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ec A[Catch: IllegalArgumentException -> 0x0341, TryCatch #1 {IllegalArgumentException -> 0x0341, blocks: (B:14:0x002f, B:21:0x0052, B:24:0x0059, B:26:0x0060, B:28:0x0068, B:30:0x006e, B:32:0x007b, B:34:0x0081, B:36:0x008e, B:38:0x0097, B:41:0x00ab, B:51:0x00cb, B:54:0x00d5, B:57:0x00dc, B:58:0x00e1, B:44:0x00b1, B:46:0x00b9, B:48:0x00c1, B:61:0x00ec, B:64:0x00f3, B:66:0x00fa, B:71:0x0108, B:74:0x010f, B:79:0x0119, B:83:0x0120, B:88:0x0129, B:93:0x0132, B:98:0x013b, B:101:0x0140, B:102:0x0160, B:103:0x0161, B:105:0x016a, B:107:0x0173, B:109:0x017c, B:111:0x0185, B:113:0x018e, B:115:0x0197, B:118:0x019e, B:121:0x01a4, B:126:0x01b0, B:128:0x01bd, B:129:0x01c0, B:131:0x01c3, B:135:0x01cd, B:140:0x01d7, B:143:0x01e4, B:146:0x01ec, B:149:0x01f3, B:154:0x0206, B:156:0x0219, B:151:0x01fa, B:153:0x0202, B:159:0x0223, B:163:0x022c, B:165:0x0237, B:169:0x0241, B:172:0x0249, B:177:0x0254, B:184:0x026a, B:186:0x0271, B:188:0x0276, B:190:0x027e, B:192:0x0284, B:195:0x028d, B:182:0x0261, B:183:0x0266), top: B:238:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01f3 A[Catch: IllegalArgumentException -> 0x0341, TryCatch #1 {IllegalArgumentException -> 0x0341, blocks: (B:14:0x002f, B:21:0x0052, B:24:0x0059, B:26:0x0060, B:28:0x0068, B:30:0x006e, B:32:0x007b, B:34:0x0081, B:36:0x008e, B:38:0x0097, B:41:0x00ab, B:51:0x00cb, B:54:0x00d5, B:57:0x00dc, B:58:0x00e1, B:44:0x00b1, B:46:0x00b9, B:48:0x00c1, B:61:0x00ec, B:64:0x00f3, B:66:0x00fa, B:71:0x0108, B:74:0x010f, B:79:0x0119, B:83:0x0120, B:88:0x0129, B:93:0x0132, B:98:0x013b, B:101:0x0140, B:102:0x0160, B:103:0x0161, B:105:0x016a, B:107:0x0173, B:109:0x017c, B:111:0x0185, B:113:0x018e, B:115:0x0197, B:118:0x019e, B:121:0x01a4, B:126:0x01b0, B:128:0x01bd, B:129:0x01c0, B:131:0x01c3, B:135:0x01cd, B:140:0x01d7, B:143:0x01e4, B:146:0x01ec, B:149:0x01f3, B:154:0x0206, B:156:0x0219, B:151:0x01fa, B:153:0x0202, B:159:0x0223, B:163:0x022c, B:165:0x0237, B:169:0x0241, B:172:0x0249, B:177:0x0254, B:184:0x026a, B:186:0x0271, B:188:0x0276, B:190:0x027e, B:192:0x0284, B:195:0x028d, B:182:0x0261, B:183:0x0266), top: B:238:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0219 A[Catch: IllegalArgumentException -> 0x0341, TryCatch #1 {IllegalArgumentException -> 0x0341, blocks: (B:14:0x002f, B:21:0x0052, B:24:0x0059, B:26:0x0060, B:28:0x0068, B:30:0x006e, B:32:0x007b, B:34:0x0081, B:36:0x008e, B:38:0x0097, B:41:0x00ab, B:51:0x00cb, B:54:0x00d5, B:57:0x00dc, B:58:0x00e1, B:44:0x00b1, B:46:0x00b9, B:48:0x00c1, B:61:0x00ec, B:64:0x00f3, B:66:0x00fa, B:71:0x0108, B:74:0x010f, B:79:0x0119, B:83:0x0120, B:88:0x0129, B:93:0x0132, B:98:0x013b, B:101:0x0140, B:102:0x0160, B:103:0x0161, B:105:0x016a, B:107:0x0173, B:109:0x017c, B:111:0x0185, B:113:0x018e, B:115:0x0197, B:118:0x019e, B:121:0x01a4, B:126:0x01b0, B:128:0x01bd, B:129:0x01c0, B:131:0x01c3, B:135:0x01cd, B:140:0x01d7, B:143:0x01e4, B:146:0x01ec, B:149:0x01f3, B:154:0x0206, B:156:0x0219, B:151:0x01fa, B:153:0x0202, B:159:0x0223, B:163:0x022c, B:165:0x0237, B:169:0x0241, B:172:0x0249, B:177:0x0254, B:184:0x026a, B:186:0x0271, B:188:0x0276, B:190:0x027e, B:192:0x0284, B:195:0x028d, B:182:0x0261, B:183:0x0266), top: B:238:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0222 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object e(java.lang.reflect.Field r17, java.lang.reflect.Type r18, java.util.ArrayList<java.lang.reflect.Type> r19, java.lang.Object r20, com.google.api.client.json.CustomizeJsonParser r21, boolean r22) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 908
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.json.JsonParser.e(java.lang.reflect.Field, java.lang.reflect.Type, java.util.ArrayList, java.lang.Object, com.google.api.client.json.CustomizeJsonParser, boolean):java.lang.Object");
    }

    private JsonToken f() throws IOException {
        boolean z3;
        JsonToken currentToken = getCurrentToken();
        if (currentToken == null) {
            currentToken = nextToken();
        }
        if (currentToken != null) {
            z3 = true;
        } else {
            z3 = false;
        }
        Preconditions.checkArgument(z3, "no JSON input found");
        return currentToken;
    }

    private JsonToken g() throws IOException {
        JsonToken f4 = f();
        int i4 = AnonymousClass1.f25897a[f4.ordinal()];
        boolean z3 = true;
        if (i4 != 1) {
            if (i4 == 2) {
                return nextToken();
            }
            return f4;
        }
        JsonToken nextToken = nextToken();
        if (nextToken != JsonToken.FIELD_NAME && nextToken != JsonToken.END_OBJECT) {
            z3 = false;
        }
        Preconditions.checkArgument(z3, nextToken);
        return nextToken;
    }

    public abstract void close() throws IOException;

    public abstract BigInteger getBigIntegerValue() throws IOException;

    public abstract byte getByteValue() throws IOException;

    public abstract String getCurrentName() throws IOException;

    public abstract JsonToken getCurrentToken();

    public abstract BigDecimal getDecimalValue() throws IOException;

    public abstract double getDoubleValue() throws IOException;

    public abstract JsonFactory getFactory();

    public abstract float getFloatValue() throws IOException;

    public abstract int getIntValue() throws IOException;

    public abstract long getLongValue() throws IOException;

    public abstract short getShortValue() throws IOException;

    public abstract String getText() throws IOException;

    public abstract JsonToken nextToken() throws IOException;

    public final <T> T parse(Class<T> cls) throws IOException {
        return (T) parse((Class<Object>) cls, (CustomizeJsonParser) null);
    }

    public final <T> T parseAndClose(Class<T> cls) throws IOException {
        return (T) parseAndClose((Class<Object>) cls, (CustomizeJsonParser) null);
    }

    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2) throws IOException {
        return parseArray(cls, cls2, (CustomizeJsonParser) null);
    }

    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2) throws IOException {
        return parseArrayAndClose(cls, cls2, (CustomizeJsonParser) null);
    }

    public abstract JsonParser skipChildren() throws IOException;

    public final void skipToKey(String str) throws IOException {
        skipToKey(Collections.singleton(str));
    }

    @Beta
    public final <T> T parse(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        return (T) parse(cls, false, customizeJsonParser);
    }

    @Beta
    public final <T> T parseAndClose(Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return (T) parse((Class<Object>) cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    @Beta
    public final <T> Collection<T> parseArray(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        Collection<T> collection = (Collection<T>) Data.newCollectionInstance(cls);
        parseArray(collection, cls2, customizeJsonParser);
        return collection;
    }

    @Beta
    public final <T> Collection<T> parseArrayAndClose(Class<?> cls, Class<T> cls2, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            return parseArray(cls, cls2, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final String skipToKey(Set<String> set) throws IOException {
        JsonToken g4 = g();
        while (g4 == JsonToken.FIELD_NAME) {
            String text = getText();
            nextToken();
            if (set.contains(text)) {
                return text;
            }
            skipChildren();
            g4 = nextToken();
        }
        return null;
    }

    public Object parse(Type type, boolean z3) throws IOException {
        return parse(type, z3, null);
    }

    @Beta
    public Object parse(Type type, boolean z3, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            if (!Void.class.equals(type)) {
                f();
            }
            return e(null, type, new ArrayList<>(), null, customizeJsonParser, true);
        } finally {
            if (z3) {
                close();
            }
        }
    }

    public final void parseAndClose(Object obj) throws IOException {
        parseAndClose(obj, (CustomizeJsonParser) null);
    }

    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls) throws IOException {
        parseArray(collection, cls, (CustomizeJsonParser) null);
    }

    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls) throws IOException {
        parseArrayAndClose(collection, cls, (CustomizeJsonParser) null);
    }

    @Beta
    public final void parseAndClose(Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            parse(obj, customizeJsonParser);
        } finally {
            close();
        }
    }

    @Beta
    public final <T> void parseArray(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        c(null, collection, cls, new ArrayList<>(), customizeJsonParser);
    }

    @Beta
    public final <T> void parseArrayAndClose(Collection<? super T> collection, Class<T> cls, CustomizeJsonParser customizeJsonParser) throws IOException {
        try {
            parseArray(collection, cls, customizeJsonParser);
        } finally {
            close();
        }
    }

    public final void parse(Object obj) throws IOException {
        parse(obj, (CustomizeJsonParser) null);
    }

    @Beta
    public final void parse(Object obj, CustomizeJsonParser customizeJsonParser) throws IOException {
        ArrayList<Type> arrayList = new ArrayList<>();
        arrayList.add(obj.getClass());
        b(arrayList, obj, customizeJsonParser);
    }
}
