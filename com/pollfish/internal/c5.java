package com.pollfish.internal;

import androidx.core.os.EnvironmentCompat;
import com.fasterxml.jackson.core.util.MinimalPrettyPrinter;
import com.pollfish.internal.f4;
import com.pollfish.internal.l4;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes6.dex */
public final class c5 implements i4 {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public final x4 f36746a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    public final l0 f36747b;
    @NotNull

    /* renamed from: c  reason: collision with root package name */
    public final i1 f36748c;
    @NotNull

    /* renamed from: d  reason: collision with root package name */
    public final d f36749d;
    @NotNull

    /* renamed from: e  reason: collision with root package name */
    public final f f36750e;
    @NotNull

    /* renamed from: f  reason: collision with root package name */
    public final y1 f36751f;

    public c5(@NotNull x4 x4Var, @NotNull l0 l0Var, @NotNull i1 i1Var, @NotNull d dVar, @NotNull f fVar) {
        this.f36746a = x4Var;
        this.f36747b = l0Var;
        this.f36748c = i1Var;
        this.f36749d = dVar;
        this.f36750e = fVar;
        this.f36751f = new y1(x4Var.i(), x4Var.l(), x4Var.g(), x4Var.e(), x4Var.d(), !x4Var.r(), x4Var.h());
    }

    @Override // com.pollfish.internal.i4
    public final void a(@NotNull f4.a aVar, @NotNull String str, @Nullable l4.a aVar2) {
        String str2;
        List listOf;
        String str3;
        if (aVar2 != null) {
            h1 b4 = this.f36748c.b();
            k0 a4 = this.f36747b.a();
            try {
                StackTraceElement stackTraceElement = aVar2.f37009a.getStackTrace()[3];
                str2 = stackTraceElement.getFileName() + ':' + stackTraceElement.getLineNumber() + ':' + stackTraceElement.getMethodName();
            } catch (Exception unused) {
                str2 = "";
            }
            String str4 = str2;
            String str5 = b4.f36891a;
            String str6 = b4.f36893c;
            String c4 = this.f36747b.c();
            String str7 = a4.f36948a;
            String str8 = a4.f36971x;
            String str9 = EnvironmentCompat.MEDIA_UNKNOWN;
            String str10 = str8 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str8;
            String str11 = a4.f36959l;
            String str12 = a4.D;
            g0 g0Var = new g0(str7, str10, str11, str12 == null ? EnvironmentCompat.MEDIA_UNKNOWN : str12, a4.B, a4.C);
            v1 v1Var = new v1(String.valueOf(a4.f36956i));
            String str13 = a4.E;
            if (str13 == null) {
                str13 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str14 = a4.f36954g;
            if (str14 == null) {
                str14 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str15 = a4.f36960m;
            if (str15 == null) {
                str15 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            String str16 = a4.F;
            if (str16 == null) {
                str16 = EnvironmentCompat.MEDIA_UNKNOWN;
            }
            i iVar = new i(str13, str14, str15, str16);
            y1 y1Var = this.f36751f;
            e1 e1Var = new e1(a(aVar2));
            j5 j5Var = new j5(this.f36746a.f37310a, String.valueOf(b4.f36892b), b4.f36894d);
            l4<String> c5 = this.f36749d.c();
            l4.b bVar = c5 instanceof l4.b ? (l4.b) c5 : null;
            if (bVar != null && (str3 = (String) bVar.f37068a) != null) {
                str9 = str3;
            }
            p5 p5Var = new p5(str9);
            listOf = kotlin.collections.e.listOf(new b1(aVar2.c(), aVar2.d()));
            this.f36750e.c(new h4(new f4(str4, str, aVar, str5, str6, c4, g0Var, v1Var, iVar, y1Var, e1Var, j5Var, p5Var, new z0(listOf))).a().toString());
            Unit unit = Unit.INSTANCE;
        }
    }

    public static String a(l4.a aVar) {
        String replace$default;
        StringBuilder sb = new StringBuilder();
        if (aVar instanceof l4.a.o) {
            for (l4.a aVar2 : ((l4.a.o) aVar).e()) {
                sb.append(a(aVar2));
            }
        } else {
            StringWriter stringWriter = new StringWriter();
            aVar.b().printStackTrace(new PrintWriter(stringWriter));
            replace$default = kotlin.text.m.replace$default(stringWriter.toString(), "\t", MinimalPrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR, false, 4, (Object) null);
            sb.append(replace$default);
            sb.append("\n");
        }
        return sb.toString();
    }
}
