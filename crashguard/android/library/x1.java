package crashguard.android.library;

import android.content.Context;
import java.util.LinkedList;
import java.util.List;
import javax.crypto.SecretKey;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public final class x1 {

    /* renamed from: a  reason: collision with root package name */
    private final x f39112a;

    /* renamed from: b  reason: collision with root package name */
    private final k2 f39113b;

    /* renamed from: c  reason: collision with root package name */
    private final SecretKey f39114c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(Context context, SecretKey secretKey) {
        this(context, new k2(), secretKey);
    }

    private h1 a(n1 n1Var) throws Throwable {
        if (n1Var == null) {
            return null;
        }
        List<String> a4 = n1Var.a();
        LinkedList linkedList = new LinkedList();
        for (String str : a4) {
            k2 k2Var = this.f39113b;
            SecretKey secretKey = this.f39114c;
            k2Var.getClass();
            linkedList.add(new String(k2.f(str, secretKey)));
        }
        List<String> k4 = n1Var.k();
        LinkedList linkedList2 = new LinkedList();
        for (String str2 : k4) {
            k2 k2Var2 = this.f39113b;
            SecretKey secretKey2 = this.f39114c;
            k2Var2.getClass();
            linkedList2.add(new String(k2.f(str2, secretKey2)));
        }
        String f4 = n1Var.f();
        String e4 = n1Var.e();
        k2 k2Var3 = this.f39113b;
        String h4 = n1Var.h();
        SecretKey secretKey3 = this.f39114c;
        k2Var3.getClass();
        String str3 = new String(k2.f(h4, secretKey3));
        k2 k2Var4 = this.f39113b;
        String g4 = n1Var.g();
        SecretKey secretKey4 = this.f39114c;
        k2Var4.getClass();
        String str4 = new String(k2.f(g4, secretKey4));
        k2 k2Var5 = this.f39113b;
        String j4 = n1Var.j();
        SecretKey secretKey5 = this.f39114c;
        k2Var5.getClass();
        String str5 = new String(k2.f(j4, secretKey5));
        k2 k2Var6 = this.f39113b;
        String c4 = n1Var.c();
        SecretKey secretKey6 = this.f39114c;
        k2Var6.getClass();
        String str6 = new String(k2.f(c4, secretKey6));
        k2 k2Var7 = this.f39113b;
        String l4 = n1Var.l();
        SecretKey secretKey7 = this.f39114c;
        k2Var7.getClass();
        String str7 = new String(k2.f(l4, secretKey7));
        k2 k2Var8 = this.f39113b;
        String d4 = n1Var.d();
        SecretKey secretKey8 = this.f39114c;
        k2Var8.getClass();
        String str8 = new String(k2.f(d4, secretKey8));
        k2 k2Var9 = this.f39113b;
        String i4 = n1Var.i();
        SecretKey secretKey9 = this.f39114c;
        k2Var9.getClass();
        return new h1(f4, e4, str3, str4, str5, str6, str7, linkedList, linkedList2, str8, Boolean.parseBoolean(new String(k2.f(i4, secretKey9))), n1Var.m());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final LinkedList b() {
        LinkedList linkedList = new LinkedList();
        for (n1 n1Var : this.f39112a.b()) {
            try {
                linkedList.add(a(n1Var));
            } catch (Throwable unused) {
            }
        }
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(h1 h1Var) throws Throwable {
        List<String> a4 = h1Var.a();
        LinkedList linkedList = new LinkedList();
        for (String str : a4) {
            k2 k2Var = this.f39113b;
            SecretKey secretKey = this.f39114c;
            k2Var.getClass();
            linkedList.add(k2.h(str, secretKey));
        }
        List<String> l4 = h1Var.l();
        LinkedList linkedList2 = new LinkedList();
        for (String str2 : l4) {
            k2 k2Var2 = this.f39113b;
            SecretKey secretKey2 = this.f39114c;
            k2Var2.getClass();
            linkedList2.add(k2.h(str2, secretKey2));
        }
        String g4 = h1Var.g();
        k2 k2Var3 = this.f39113b;
        String j4 = h1Var.j();
        SecretKey secretKey3 = this.f39114c;
        k2Var3.getClass();
        String h4 = k2.h(j4, secretKey3);
        k2 k2Var4 = this.f39113b;
        String i4 = h1Var.i();
        SecretKey secretKey4 = this.f39114c;
        k2Var4.getClass();
        String h5 = k2.h(i4, secretKey4);
        k2 k2Var5 = this.f39113b;
        String k4 = h1Var.k();
        SecretKey secretKey5 = this.f39114c;
        k2Var5.getClass();
        String h6 = k2.h(k4, secretKey5);
        k2 k2Var6 = this.f39113b;
        String d4 = h1Var.d();
        SecretKey secretKey6 = this.f39114c;
        k2Var6.getClass();
        String h7 = k2.h(d4, secretKey6);
        k2 k2Var7 = this.f39113b;
        String m4 = h1Var.m();
        SecretKey secretKey7 = this.f39114c;
        k2Var7.getClass();
        String h8 = k2.h(m4, secretKey7);
        k2 k2Var8 = this.f39113b;
        String f4 = h1Var.f();
        SecretKey secretKey8 = this.f39114c;
        k2Var8.getClass();
        String h9 = k2.h(f4, secretKey8);
        k2 k2Var9 = this.f39113b;
        String valueOf = String.valueOf(h1Var.o());
        SecretKey secretKey9 = this.f39114c;
        k2Var9.getClass();
        n1 n1Var = new n1(null, g4, h4, h5, h6, h7, h8, linkedList, linkedList2, h9, k2.h(valueOf, secretKey9), h1Var.n());
        this.f39112a.e(n1Var);
        h1Var.b(n1Var.f());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(String str) {
        this.f39112a.f(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final h1 e(String str) throws Throwable {
        return a(this.f39112a.g(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public x1(Context context, k2 k2Var, SecretKey secretKey) {
        this.f39112a = t4.f(context).j();
        this.f39113b = k2Var;
        this.f39114c = secretKey;
    }
}
