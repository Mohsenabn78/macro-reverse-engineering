package com.sun.activation.registries;

import androidx.core.os.EnvironmentCompat;
import net.bytebuddy.pool.TypePool;

/* loaded from: classes6.dex */
public class MailcapTokenizer {
    public static final int EOI_TOKEN = 5;
    public static final int EQUALS_TOKEN = 61;
    public static final int SEMICOLON_TOKEN = 59;
    public static final int SLASH_TOKEN = 47;
    public static final int START_TOKEN = 1;
    public static final int STRING_TOKEN = 2;
    public static final int UNKNOWN_TOKEN = 0;

    /* renamed from: a  reason: collision with root package name */
    private String f37558a;

    /* renamed from: c  reason: collision with root package name */
    private int f37560c;

    /* renamed from: b  reason: collision with root package name */
    private int f37559b = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f37561d = 1;

    /* renamed from: e  reason: collision with root package name */
    private String f37562e = "";

    /* renamed from: f  reason: collision with root package name */
    private boolean f37563f = false;

    /* renamed from: g  reason: collision with root package name */
    private char f37564g = TypePool.Default.LazyTypeDescription.GenericTypeToken.INDEXED_TYPE_DELIMITER;

    public MailcapTokenizer(String str) {
        this.f37558a = str;
        this.f37560c = str.length();
    }

    private static String a(String str) {
        int length = str.length();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.ensureCapacity(length);
        int i4 = 0;
        while (i4 < length) {
            char charAt = str.charAt(i4);
            if (charAt != '\\') {
                stringBuffer.append(charAt);
            } else if (i4 < length - 1) {
                i4++;
                stringBuffer.append(str.charAt(i4));
            } else {
                stringBuffer.append(charAt);
            }
            i4++;
        }
        return stringBuffer.toString();
    }

    private static boolean b(char c4) {
        return Character.isISOControl(c4);
    }

    private static boolean c(char c4) {
        if (c4 != '\"' && c4 != ',' && c4 != '/' && c4 != '(' && c4 != ')') {
            switch (c4) {
                case ':':
                case ';':
                case '<':
                case '=':
                case '>':
                case '?':
                case '@':
                    break;
                default:
                    switch (c4) {
                        case '[':
                        case '\\':
                        case ']':
                            break;
                        default:
                            return false;
                    }
            }
        }
        return true;
    }

    private static boolean d(char c4) {
        if (!c(c4) && !b(c4) && !e(c4)) {
            return true;
        }
        return false;
    }

    private static boolean e(char c4) {
        return Character.isWhitespace(c4);
    }

    private void f() {
        int i4;
        int i5 = this.f37559b;
        boolean z3 = false;
        while (true) {
            i4 = this.f37559b;
            if (i4 >= this.f37560c || z3) {
                break;
            } else if (this.f37558a.charAt(i4) != this.f37564g) {
                this.f37559b++;
            } else {
                z3 = true;
            }
        }
        this.f37561d = 2;
        this.f37562e = a(this.f37558a.substring(i5, i4));
    }

    private void g() {
        int i4 = this.f37559b;
        while (true) {
            int i5 = this.f37559b;
            if (i5 >= this.f37560c || !d(this.f37558a.charAt(i5))) {
                break;
            }
            this.f37559b++;
        }
        this.f37561d = 2;
        this.f37562e = this.f37558a.substring(i4, this.f37559b);
    }

    public static String nameForToken(int i4) {
        if (i4 != 0) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 5) {
                        if (i4 != 47) {
                            if (i4 != 59) {
                                if (i4 != 61) {
                                    return "really unknown";
                                }
                                return "'='";
                            }
                            return "';'";
                        }
                        return "'/'";
                    }
                    return "EOI";
                }
                return "string";
            }
            return "start";
        }
        return EnvironmentCompat.MEDIA_UNKNOWN;
    }

    public int getCurrentToken() {
        return this.f37561d;
    }

    public String getCurrentTokenValue() {
        return this.f37562e;
    }

    public int nextToken() {
        if (this.f37559b < this.f37560c) {
            while (true) {
                int i4 = this.f37559b;
                if (i4 >= this.f37560c || !e(this.f37558a.charAt(i4))) {
                    break;
                }
                this.f37559b++;
            }
            int i5 = this.f37559b;
            if (i5 < this.f37560c) {
                char charAt = this.f37558a.charAt(i5);
                if (this.f37563f) {
                    if (charAt != ';' && charAt != '=') {
                        f();
                    } else {
                        this.f37561d = charAt;
                        this.f37562e = new Character(charAt).toString();
                        this.f37559b++;
                    }
                } else if (d(charAt)) {
                    g();
                } else if (charAt != '/' && charAt != ';' && charAt != '=') {
                    this.f37561d = 0;
                    this.f37562e = new Character(charAt).toString();
                    this.f37559b++;
                } else {
                    this.f37561d = charAt;
                    this.f37562e = new Character(charAt).toString();
                    this.f37559b++;
                }
            } else {
                this.f37561d = 5;
                this.f37562e = null;
            }
        } else {
            this.f37561d = 5;
            this.f37562e = null;
        }
        return this.f37561d;
    }

    public void setIsAutoquoting(boolean z3) {
        this.f37563f = z3;
    }
}
