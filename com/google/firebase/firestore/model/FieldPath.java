package com.google.firebase.firestore.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes5.dex */
public final class FieldPath extends BasePath<FieldPath> {
    public static final FieldPath KEY_PATH = fromSingleSegment(DocumentKey.KEY_FIELD_NAME);
    public static final FieldPath EMPTY_PATH = new FieldPath(Collections.emptyList());

    private FieldPath(List<String> list) {
        super(list);
    }

    private static boolean c(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char charAt = str.charAt(0);
        if (charAt != '_' && ((charAt < 'a' || charAt > 'z') && (charAt < 'A' || charAt > 'Z'))) {
            return false;
        }
        for (int i4 = 1; i4 < str.length(); i4++) {
            char charAt2 = str.charAt(i4);
            if (charAt2 != '_' && ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && (charAt2 < '0' || charAt2 > '9')))) {
                return false;
            }
        }
        return true;
    }

    public static FieldPath fromSegments(List<String> list) {
        if (list.isEmpty()) {
            return EMPTY_PATH;
        }
        return new FieldPath(list);
    }

    public static FieldPath fromServerFormat(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        boolean z3 = false;
        while (i4 < str.length()) {
            char charAt = str.charAt(i4);
            if (charAt == '\\') {
                i4++;
                if (i4 != str.length()) {
                    sb.append(str.charAt(i4));
                } else {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
            } else if (charAt == '.') {
                if (!z3) {
                    String sb2 = sb.toString();
                    if (!sb2.isEmpty()) {
                        StringBuilder sb3 = new StringBuilder();
                        arrayList.add(sb2);
                        sb = sb3;
                    } else {
                        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                    }
                } else {
                    sb.append(charAt);
                }
            } else if (charAt == '`') {
                z3 = !z3;
            } else {
                sb.append(charAt);
            }
            i4++;
        }
        String sb4 = sb.toString();
        if (!sb4.isEmpty()) {
            arrayList.add(sb4);
            return new FieldPath(arrayList);
        }
        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    public static FieldPath fromSingleSegment(String str) {
        return new FieldPath(Collections.singletonList(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.firebase.firestore.model.BasePath
    /* renamed from: b */
    public FieldPath a(List<String> list) {
        return new FieldPath(list);
    }

    @Override // com.google.firebase.firestore.model.BasePath
    public String canonicalString() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.f30943a.size(); i4++) {
            if (i4 > 0) {
                sb.append(".");
            }
            String replace = this.f30943a.get(i4).replace("\\", "\\\\").replace("`", "\\`");
            if (!c(replace)) {
                replace = '`' + replace + '`';
            }
            sb.append(replace);
        }
        return sb.toString();
    }

    public boolean isKeyField() {
        return equals(KEY_PATH);
    }
}
