package com.sun.mail.imap;

import java.util.ArrayList;
import net.bytebuddy.asm.Advice;

/* loaded from: classes6.dex */
public class Rights implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private boolean[] f37807a;

    /* loaded from: classes6.dex */
    public static final class Right {

        /* renamed from: a  reason: collision with root package name */
        char f37809a;

        /* renamed from: b  reason: collision with root package name */
        private static Right[] f37808b = new Right[128];
        public static final Right LOOKUP = getInstance('l');
        public static final Right READ = getInstance(Advice.OffsetMapping.ForOrigin.Renderer.ForReturnTypeName.SYMBOL);
        public static final Right KEEP_SEEN = getInstance(Advice.OffsetMapping.ForOrigin.Renderer.ForJavaSignature.SYMBOL);
        public static final Right WRITE = getInstance('w');
        public static final Right INSERT = getInstance('i');
        public static final Right POST = getInstance('p');
        public static final Right CREATE = getInstance('c');
        public static final Right DELETE = getInstance(Advice.OffsetMapping.ForOrigin.Renderer.ForDescriptor.SYMBOL);
        public static final Right ADMINISTER = getInstance('a');

        private Right(char c4) {
            if (c4 < 128) {
                this.f37809a = c4;
                return;
            }
            throw new IllegalArgumentException("Right must be ASCII");
        }

        public static synchronized Right getInstance(char c4) {
            Right right;
            synchronized (Right.class) {
                if (c4 < 128) {
                    Right[] rightArr = f37808b;
                    if (rightArr[c4] == null) {
                        rightArr[c4] = new Right(c4);
                    }
                    right = f37808b[c4];
                } else {
                    throw new IllegalArgumentException("Right must be ASCII");
                }
            }
            return right;
        }

        public String toString() {
            return String.valueOf(this.f37809a);
        }
    }

    public Rights() {
        this.f37807a = new boolean[128];
    }

    public void add(Right right) {
        this.f37807a[right.f37809a] = true;
    }

    public Object clone() {
        Rights rights = null;
        try {
            Rights rights2 = (Rights) super.clone();
            try {
                boolean[] zArr = new boolean[128];
                rights2.f37807a = zArr;
                boolean[] zArr2 = this.f37807a;
                System.arraycopy(zArr2, 0, zArr, 0, zArr2.length);
                return rights2;
            } catch (CloneNotSupportedException unused) {
                rights = rights2;
                return rights;
            }
        } catch (CloneNotSupportedException unused2) {
        }
    }

    public boolean contains(Right right) {
        return this.f37807a[right.f37809a];
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Rights)) {
            return false;
        }
        Rights rights = (Rights) obj;
        int i4 = 0;
        while (true) {
            boolean[] zArr = rights.f37807a;
            if (i4 < zArr.length) {
                if (zArr[i4] != this.f37807a[i4]) {
                    return false;
                }
                i4++;
            } else {
                return true;
            }
        }
    }

    public Right[] getRights() {
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.f37807a;
            if (i4 < zArr.length) {
                if (zArr[i4]) {
                    arrayList.add(Right.getInstance((char) i4));
                }
                i4++;
            } else {
                return (Right[]) arrayList.toArray(new Right[arrayList.size()]);
            }
        }
    }

    public int hashCode() {
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean[] zArr = this.f37807a;
            if (i4 < zArr.length) {
                if (zArr[i4]) {
                    i5++;
                }
                i4++;
            } else {
                return i5;
            }
        }
    }

    public void remove(Right right) {
        this.f37807a[right.f37809a] = false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i4 = 0;
        while (true) {
            boolean[] zArr = this.f37807a;
            if (i4 < zArr.length) {
                if (zArr[i4]) {
                    sb.append((char) i4);
                }
                i4++;
            } else {
                return sb.toString();
            }
        }
    }

    public void add(Rights rights) {
        int i4 = 0;
        while (true) {
            boolean[] zArr = rights.f37807a;
            if (i4 >= zArr.length) {
                return;
            }
            if (zArr[i4]) {
                this.f37807a[i4] = true;
            }
            i4++;
        }
    }

    public boolean contains(Rights rights) {
        int i4 = 0;
        while (true) {
            boolean[] zArr = rights.f37807a;
            if (i4 >= zArr.length) {
                return true;
            }
            if (zArr[i4] && !this.f37807a[i4]) {
                return false;
            }
            i4++;
        }
    }

    public void remove(Rights rights) {
        int i4 = 0;
        while (true) {
            boolean[] zArr = rights.f37807a;
            if (i4 >= zArr.length) {
                return;
            }
            if (zArr[i4]) {
                this.f37807a[i4] = false;
            }
            i4++;
        }
    }

    public Rights(Rights rights) {
        boolean[] zArr = new boolean[128];
        this.f37807a = zArr;
        System.arraycopy(rights.f37807a, 0, zArr, 0, zArr.length);
    }

    public Rights(String str) {
        this.f37807a = new boolean[128];
        for (int i4 = 0; i4 < str.length(); i4++) {
            add(Right.getInstance(str.charAt(i4)));
        }
    }

    public Rights(Right right) {
        boolean[] zArr = new boolean[128];
        this.f37807a = zArr;
        zArr[right.f37809a] = true;
    }
}
