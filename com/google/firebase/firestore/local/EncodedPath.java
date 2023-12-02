package com.google.firebase.firestore.local;

import com.google.firebase.firestore.model.BasePath;
import com.google.firebase.firestore.model.ResourcePath;
import com.google.firebase.firestore.util.Assert;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class EncodedPath {
    EncodedPath() {
    }

    private static List<String> a(String str) {
        boolean z3;
        boolean z4;
        int length = str.length();
        if (length >= 2) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "Invalid path \"%s\"", str);
        if (length == 2) {
            if (str.charAt(0) == 1 && str.charAt(1) == 1) {
                z4 = true;
            } else {
                z4 = false;
            }
            Assert.hardAssert(z4, "Non-empty path \"%s\" had length 2", str);
            return Collections.emptyList();
        }
        int length2 = str.length() - 2;
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (i4 < length) {
            int indexOf = str.indexOf(1, i4);
            if (indexOf >= 0 && indexOf <= length2) {
                int i5 = indexOf + 1;
                char charAt = str.charAt(i5);
                if (charAt != 1) {
                    if (charAt != 16) {
                        if (charAt == 17) {
                            sb.append(str.substring(i4, i5));
                        } else {
                            throw new IllegalArgumentException("Invalid encoded resource path: \"" + str + "\"");
                        }
                    } else {
                        sb.append(str.substring(i4, indexOf));
                        sb.append((char) 0);
                    }
                } else {
                    String substring = str.substring(i4, indexOf);
                    if (sb.length() != 0) {
                        sb.append(substring);
                        substring = sb.toString();
                        sb.setLength(0);
                    }
                    arrayList.add(substring);
                }
                i4 = indexOf + 2;
            } else {
                throw new IllegalArgumentException("Invalid encoded resource path: \"" + str + "\"");
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ResourcePath b(String str) {
        return ResourcePath.fromSegments(a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <B extends BasePath<B>> String c(B b4) {
        StringBuilder sb = new StringBuilder();
        int length = b4.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (sb.length() > 0) {
                e(sb);
            }
            d(b4.getSegment(i4), sb);
        }
        e(sb);
        return sb.toString();
    }

    private static void d(String str, StringBuilder sb) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            char charAt = str.charAt(i4);
            if (charAt != 0) {
                if (charAt != 1) {
                    sb.append(charAt);
                } else {
                    sb.append((char) 1);
                    sb.append((char) 17);
                }
            } else {
                sb.append((char) 1);
                sb.append((char) 16);
            }
        }
    }

    private static void e(StringBuilder sb) {
        sb.append((char) 1);
        sb.append((char) 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(String str) {
        boolean z3;
        StringBuilder sb = new StringBuilder(str);
        int length = sb.length() - 1;
        char charAt = sb.charAt(length);
        if (charAt == 1) {
            z3 = true;
        } else {
            z3 = false;
        }
        Assert.hardAssert(z3, "successor may only operate on paths generated by encode", new Object[0]);
        sb.setCharAt(length, (char) (charAt + 1));
        return sb.toString();
    }
}