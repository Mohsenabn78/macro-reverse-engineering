package com.pollfish.internal;

import android.content.Context;
import android.net.Uri;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.pollfish.internal.l4;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.StringsKt___StringsKt;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes6.dex */
public final class f2 implements e2 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Context> f36814a;

    public f2(@NotNull Context context) {
        this.f36814a = new WeakReference<>(context);
    }

    @Override // com.pollfish.internal.e2
    @NotNull
    public final l4 a(@NotNull String str) {
        l4<Uri> a4 = a("index.html", str.getBytes(Charsets.UTF_8));
        if (a4 instanceof l4.b) {
            return new l4.b(Unit.INSTANCE);
        }
        if (a4 instanceof l4.a) {
            return new l4.a.g("index.html", ((l4.a) a4).b());
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.pollfish.internal.e2
    @NotNull
    public final l4<byte[]> b(@NotNull String str) {
        String substringAfterLast$default;
        String substringBeforeLast$default;
        byte[] readBytes;
        Context context = this.f36814a.get();
        if (context != null) {
            Context context2 = this.f36814a.get();
            if (context2 != null ? new File(a(context2, str)).exists() : false) {
                substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
                substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(a(context, str), '/', (String) null, 2, (Object) null);
                try {
                    readBytes = kotlin.io.c.readBytes(new File(new File(substringBeforeLast$default), substringAfterLast$default));
                    return new l4.b(readBytes);
                } catch (Exception e4) {
                    return new l4.a.f(str, e4);
                }
            }
            l4.a.d dVar = l4.a.d.f37018c;
            if (dVar != null) {
                return dVar;
            }
        }
        return l4.a.t.f37060c;
    }

    @Override // com.pollfish.internal.e2
    @NotNull
    public final l4<Unit> clear() {
        Context context = this.f36814a.get();
        if (context != null) {
            try {
                File[] listFiles = new File(a(context, "")).listFiles();
                if (listFiles != null) {
                    for (File file : listFiles) {
                        kotlin.io.e.deleteRecursively(file);
                    }
                }
                return new l4.b(Unit.INSTANCE);
            } catch (Exception e4) {
                return new l4.a.e(e4);
            }
        }
        return l4.a.t.f37060c;
    }

    public final void a(@NotNull Context context) {
        this.f36814a = new WeakReference<>(context);
    }

    @Override // com.pollfish.internal.e2
    @NotNull
    public final l4<Uri> a(@NotNull String str, @NotNull byte[] bArr) {
        String substringAfterLast$default;
        String substringBeforeLast$default;
        Context context = this.f36814a.get();
        if (context != null) {
            substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(str, '/', (String) null, 2, (Object) null);
            substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(a(context, str), '/', (String) null, 2, (Object) null);
            File file = new File(substringBeforeLast$default);
            file.mkdirs();
            File file2 = new File(file, substringAfterLast$default);
            try {
                kotlin.io.c.writeBytes(file2, bArr);
                return new l4.b(Uri.fromFile(file2));
            } catch (Exception e4) {
                return new l4.a.g(str, e4);
            }
        }
        return l4.a.t.f37060c;
    }

    public static ArrayList b(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    arrayList.addAll(b(file2));
                } else {
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00ca A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00a5 A[SYNTHETIC] */
    @Override // com.pollfish.internal.e2
    @org.jetbrains.annotations.NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.pollfish.internal.l4 a(@org.jetbrains.annotations.NotNull java.util.ArrayList r12) {
        /*
            r11 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = "/"
            java.lang.ref.WeakReference<android.content.Context> r2 = r11.f36814a
            java.lang.Object r2 = r2.get()
            android.content.Context r2 = (android.content.Context) r2
            if (r2 == 0) goto Lde
            java.io.File r3 = new java.io.File     // Catch: java.lang.Exception -> Ld6
            java.lang.String r4 = a(r2, r0)     // Catch: java.lang.Exception -> Ld6
            r3.<init>(r4)     // Catch: java.lang.Exception -> Ld6
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld6
            r5 = 10
            int r5 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r12, r5)     // Catch: java.lang.Exception -> Ld6
            r4.<init>(r5)     // Catch: java.lang.Exception -> Ld6
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Exception -> Ld6
        L26:
            boolean r5 = r12.hasNext()     // Catch: java.lang.Exception -> Ld6
            r6 = 0
            if (r5 == 0) goto L5f
            java.lang.Object r5 = r12.next()     // Catch: java.lang.Exception -> Ld6
            java.lang.String r5 = (java.lang.String) r5     // Catch: java.lang.Exception -> Ld6
            r7 = 0
            r8 = 2
            boolean r9 = kotlin.text.StringsKt.startsWith$default(r5, r1, r6, r8, r7)     // Catch: java.lang.Exception -> Ld6
            if (r9 == 0) goto L3e
            kotlin.text.StringsKt.removePrefix(r5, r1)     // Catch: java.lang.Exception -> Ld6
        L3e:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Ld6
            r9.<init>()     // Catch: java.lang.Exception -> Ld6
            java.lang.String r10 = a(r2, r0)     // Catch: java.lang.Exception -> Ld6
            r9.append(r10)     // Catch: java.lang.Exception -> Ld6
            boolean r6 = kotlin.text.StringsKt.startsWith$default(r5, r1, r6, r8, r7)     // Catch: java.lang.Exception -> Ld6
            if (r6 == 0) goto L54
            java.lang.String r5 = kotlin.text.StringsKt.removePrefix(r5, r1)     // Catch: java.lang.Exception -> Ld6
        L54:
            r9.append(r5)     // Catch: java.lang.Exception -> Ld6
            java.lang.String r5 = r9.toString()     // Catch: java.lang.Exception -> Ld6
            r4.add(r5)     // Catch: java.lang.Exception -> Ld6
            goto L26
        L5f:
            java.util.ArrayList r12 = b(r3)     // Catch: java.lang.Exception -> Ld6
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Exception -> Ld6
            r0.<init>()     // Catch: java.lang.Exception -> Ld6
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Exception -> Ld6
        L6c:
            boolean r1 = r12.hasNext()     // Catch: java.lang.Exception -> Ld6
            r2 = 1
            if (r1 == 0) goto L89
            java.lang.Object r1 = r12.next()     // Catch: java.lang.Exception -> Ld6
            r5 = r1
            java.io.File r5 = (java.io.File) r5     // Catch: java.lang.Exception -> Ld6
            java.lang.String r5 = r5.getPath()     // Catch: java.lang.Exception -> Ld6
            boolean r5 = r4.contains(r5)     // Catch: java.lang.Exception -> Ld6
            r2 = r2 ^ r5
            if (r2 == 0) goto L6c
            r0.add(r1)     // Catch: java.lang.Exception -> Ld6
            goto L6c
        L89:
            java.util.Iterator r12 = r0.iterator()     // Catch: java.lang.Exception -> Ld6
        L8d:
            boolean r0 = r12.hasNext()     // Catch: java.lang.Exception -> Ld6
            if (r0 == 0) goto L9d
            java.lang.Object r0 = r12.next()     // Catch: java.lang.Exception -> Ld6
            java.io.File r0 = (java.io.File) r0     // Catch: java.lang.Exception -> Ld6
            r0.delete()     // Catch: java.lang.Exception -> Ld6
            goto L8d
        L9d:
            java.util.ArrayList r12 = a(r3)     // Catch: java.lang.Exception -> Ld6
            java.util.Iterator r12 = r12.iterator()     // Catch: java.lang.Exception -> Ld6
        La5:
            boolean r0 = r12.hasNext()     // Catch: java.lang.Exception -> Ld6
            if (r0 == 0) goto Lce
            java.lang.Object r0 = r12.next()     // Catch: java.lang.Exception -> Ld6
            java.io.File r0 = (java.io.File) r0     // Catch: java.lang.Exception -> Ld6
            boolean r1 = r0.isDirectory()     // Catch: java.lang.Exception -> Ld6
            if (r1 == 0) goto La5
            java.io.File[] r1 = r0.listFiles()     // Catch: java.lang.Exception -> Ld6
            if (r1 == 0) goto Lc7
            int r1 = r1.length     // Catch: java.lang.Exception -> Ld6
            if (r1 != 0) goto Lc2
            r1 = 1
            goto Lc3
        Lc2:
            r1 = 0
        Lc3:
            if (r1 != r2) goto Lc7
            r1 = 1
            goto Lc8
        Lc7:
            r1 = 0
        Lc8:
            if (r1 == 0) goto La5
            r0.delete()     // Catch: java.lang.Exception -> Ld6
            goto La5
        Lce:
            com.pollfish.internal.l4$b r12 = new com.pollfish.internal.l4$b     // Catch: java.lang.Exception -> Ld6
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch: java.lang.Exception -> Ld6
            r12.<init>(r0)     // Catch: java.lang.Exception -> Ld6
            goto Le0
        Ld6:
            r12 = move-exception
            com.pollfish.internal.l4$a$e r0 = new com.pollfish.internal.l4$a$e
            r0.<init>(r12)
            r12 = r0
            goto Le0
        Lde:
            com.pollfish.internal.l4$a$t r12 = com.pollfish.internal.l4.a.t.f37060c
        Le0:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.pollfish.internal.f2.a(java.util.ArrayList):com.pollfish.internal.l4");
    }

    public static String a(Context context, String str) {
        char first;
        boolean startsWith$default;
        if (!(str.length() == 0)) {
            first = StringsKt___StringsKt.first(str);
            if (first == '.') {
                str = StringsKt__StringsKt.removePrefix(str, (CharSequence) ".");
            }
            startsWith$default = StringsKt__StringsKt.startsWith$default((CharSequence) str, '/', false, 2, (Object) null);
            String str2 = !startsWith$default ? RemoteSettings.FORWARD_SLASH_STRING : "";
            return context.getCacheDir().getPath() + "/pollfish" + str2 + str;
        }
        return context.getCacheDir().getPath() + "/pollfish/";
    }

    public static ArrayList a(File file) {
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isDirectory()) {
                    arrayList.addAll(a(file2));
                    arrayList.add(file2);
                }
            }
        }
        return arrayList;
    }
}
