package com.github.javiersantos.piracychecker.enums;

import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.description.method.MethodDescription;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: PirateApp.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u000e\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001aB#\b\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0019\u0010\u001cR(\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R(\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\t8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0016\u001a\u00020\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0018\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001d"}, d2 = {"Lcom/github/javiersantos/piracychecker/enums/PirateApp;", "", "", "<set-?>", "a", "Ljava/lang/String;", "getName", "()Ljava/lang/String;", "name", "Lcom/github/javiersantos/piracychecker/enums/AppType;", "b", "Lcom/github/javiersantos/piracychecker/enums/AppType;", "getType", "()Lcom/github/javiersantos/piracychecker/enums/AppType;", "type", "", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "[Ljava/lang/String;", "pack", "getPackage", "package$annotations", "()V", "package", "getPackageName", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, MethodDescription.CONSTRUCTOR_INTERNAL_NAME, "(Ljava/lang/String;[Ljava/lang/String;Lcom/github/javiersantos/piracychecker/enums/AppType;)V", "appPackage", "(Ljava/lang/String;Ljava/lang/String;Lcom/github/javiersantos/piracychecker/enums/AppType;)V", "library_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class PirateApp {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private String f18458a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private AppType f18459b;

    /* renamed from: c  reason: collision with root package name */
    private String[] f18460c;

    @JvmOverloads
    public PirateApp(@NotNull String str, @NotNull String str2) {
        this(str, str2, (AppType) null, 4, (DefaultConstructorMarker) null);
    }

    @Nullable
    public final String getName() {
        return this.f18458a;
    }

    @NotNull
    public final String getPackage() {
        return getPackageName();
    }

    @NotNull
    public final String getPackageName() {
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.f18460c;
        if (strArr != null) {
            for (String str : strArr) {
                sb.append(str);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb2, "sb.toString()");
        return sb2;
    }

    @Nullable
    public final AppType getType() {
        return this.f18459b;
    }

    public PirateApp(@NotNull String name, @NotNull String[] pack, @NotNull AppType type) {
        Intrinsics.checkParameterIsNotNull(name, "name");
        Intrinsics.checkParameterIsNotNull(pack, "pack");
        Intrinsics.checkParameterIsNotNull(type, "type");
        this.f18458a = name;
        this.f18460c = (String[]) pack.clone();
        this.f18459b = type;
    }

    public /* synthetic */ PirateApp(String str, String[] strArr, AppType appType, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, strArr, (i4 & 4) != 0 ? AppType.OTHER : appType);
    }

    public /* synthetic */ PirateApp(String str, String str2, AppType appType, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i4 & 4) != 0 ? AppType.OTHER : appType);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public PirateApp(@org.jetbrains.annotations.NotNull java.lang.String r2, @org.jetbrains.annotations.NotNull java.lang.String r3, @org.jetbrains.annotations.NotNull com.github.javiersantos.piracychecker.enums.AppType r4) {
        /*
            r1 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r2, r0)
            java.lang.String r0 = "appPackage"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r3, r0)
            java.lang.String r0 = "type"
            kotlin.jvm.internal.Intrinsics.checkParameterIsNotNull(r4, r0)
            java.lang.String r0 = ""
            java.lang.String[] r3 = android.text.TextUtils.split(r3, r0)
            java.lang.String r0 = "TextUtils.split(appPackage, \"\")"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r3, r0)
            r1.<init>(r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.enums.PirateApp.<init>(java.lang.String, java.lang.String, com.github.javiersantos.piracychecker.enums.AppType):void");
    }

    @Deprecated(message = "Deprecated in favor of packageName", replaceWith = @ReplaceWith(expression = RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, imports = {}))
    public static /* synthetic */ void package$annotations() {
    }
}
