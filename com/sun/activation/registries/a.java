package com.sun.activation.registries;

import java.util.NoSuchElementException;
import java.util.Vector;

/* compiled from: MimeTypeFile.java */
/* loaded from: classes6.dex */
class a {

    /* renamed from: b  reason: collision with root package name */
    private int f37570b;

    /* renamed from: c  reason: collision with root package name */
    private String f37571c;

    /* renamed from: d  reason: collision with root package name */
    private Vector f37572d = new Vector();

    /* renamed from: a  reason: collision with root package name */
    private int f37569a = 0;

    public a(String str) {
        this.f37571c = str;
        this.f37570b = str.length();
    }

    private void c() {
        while (true) {
            int i4 = this.f37569a;
            if (i4 < this.f37570b && Character.isWhitespace(this.f37571c.charAt(i4))) {
                this.f37569a++;
            } else {
                return;
            }
        }
    }

    public boolean a() {
        if (this.f37572d.size() > 0) {
            return true;
        }
        c();
        if (this.f37569a < this.f37570b) {
            return true;
        }
        return false;
    }

    public String b() {
        int size = this.f37572d.size();
        if (size > 0) {
            int i4 = size - 1;
            String str = (String) this.f37572d.elementAt(i4);
            this.f37572d.removeElementAt(i4);
            return str;
        }
        c();
        int i5 = this.f37569a;
        if (i5 < this.f37570b) {
            char charAt = this.f37571c.charAt(i5);
            if (charAt == '\"') {
                this.f37569a++;
                boolean z3 = false;
                while (true) {
                    int i6 = this.f37569a;
                    if (i6 >= this.f37570b) {
                        break;
                    }
                    String str2 = this.f37571c;
                    this.f37569a = i6 + 1;
                    char charAt2 = str2.charAt(i6);
                    if (charAt2 == '\\') {
                        this.f37569a++;
                        z3 = true;
                    } else if (charAt2 == '\"') {
                        if (z3) {
                            StringBuffer stringBuffer = new StringBuffer();
                            for (int i7 = i5 + 1; i7 < this.f37569a - 1; i7++) {
                                char charAt3 = this.f37571c.charAt(i7);
                                if (charAt3 != '\\') {
                                    stringBuffer.append(charAt3);
                                }
                            }
                            return stringBuffer.toString();
                        }
                        return this.f37571c.substring(i5 + 1, this.f37569a - 1);
                    }
                }
            } else if ("=".indexOf(charAt) < 0) {
                while (true) {
                    int i8 = this.f37569a;
                    if (i8 >= this.f37570b || "=".indexOf(this.f37571c.charAt(i8)) >= 0 || Character.isWhitespace(this.f37571c.charAt(this.f37569a))) {
                        break;
                    }
                    this.f37569a++;
                }
            } else {
                this.f37569a++;
            }
            return this.f37571c.substring(i5, this.f37569a);
        }
        throw new NoSuchElementException();
    }
}
