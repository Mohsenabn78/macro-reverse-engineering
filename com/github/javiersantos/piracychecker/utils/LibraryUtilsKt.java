package com.github.javiersantos.piracychecker.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Environment;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import com.android.dx.rop.code.RegisterSpec;
import com.arlosoft.macrodroid.cloudmessaging.CloudMessages;
import com.arlosoft.macrodroid.permissions.PermissionRequestActivity;
import com.github.javiersantos.piracychecker.R;
import com.github.javiersantos.piracychecker.enums.AppType;
import com.github.javiersantos.piracychecker.enums.InstallerID;
import com.github.javiersantos.piracychecker.enums.PirateApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.m;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: LibraryUtils.kt */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\u001a\u001e\u0010\u0005\u001a\u0004\u0018\u00010\u0004*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\b\u001a\u00020\u0007*\u00020\u00002\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0002\u001a!\u0010\u000b\u001a\u00020\u0007*\u00020\u00002\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0000¢\u0006\u0004\b\u000b\u0010\f\u001a\u001a\u0010\u0010\u001a\u00020\u0007*\u00020\u00002\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0000\u001a<\u0010\u0018\u001a\u0004\u0018\u00010\u0016*\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0001\u001a\u0012\u0010\u001a\u001a\u00020\u00072\b\b\u0002\u0010\u0019\u001a\u00020\u0007H\u0000\u001a\f\u0010\u001b\u001a\u00020\u0007*\u00020\u0000H\u0000\u001a\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0002\u001a\u0016\u0010\u001f\u001a\u00020\u0007*\u00020\u00002\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0002\u001a\f\u0010 \u001a\u00020\u0007*\u00020\u0000H\u0002\u001a\b\u0010!\u001a\u00020\u0007H\u0002\u001a\u0014\u0010#\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\"\u001a\u00020\u0001H\u0002\u001a\u0014\u0010%\u001a\u00020\u0007*\u00020\u00012\u0006\u0010$\u001a\u00020\u0001H\u0002\u001a\u0014\u0010&\u001a\u00020\u0007*\u00020\u00012\u0006\u0010$\u001a\u00020\u0001H\u0002\"$\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u00008FX\u0087\u0004¢\u0006\f\u0012\u0004\b)\u0010*\u001a\u0004\b'\u0010(\"\u001b\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u00008F¢\u0006\u0006\u001a\u0004\b,\u0010(\"$\u00100\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u00008BX\u0082\u0004¢\u0006\f\u0012\u0004\b/\u0010*\u001a\u0004\b.\u0010(¨\u00061"}, d2 = {"Landroid/content/Context;", "", "title", FirebaseAnalytics.Param.CONTENT, "Landroidx/appcompat/app/AlertDialog;", "buildUnlicensedDialog", "appSignature", "", "i", "", "appSignatures", "verifySigningCertificates", "(Landroid/content/Context;[Ljava/lang/String;)Z", "", "Lcom/github/javiersantos/piracychecker/enums/InstallerID;", "installerID", "verifyInstallerId", "lpf", "stores", "folders", "apks", "Ljava/util/ArrayList;", "Lcom/github/javiersantos/piracychecker/enums/PirateApp;", "extraApps", "getPirateApp", "deepCheck", "isInEmulator", "isDebug", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "Landroid/content/Intent;", "intent", "f", "e", "g", PermissionRequestActivity.EXTRA_PERMISSION, "h", "other", "b", "a", "getApkSignature", "(Landroid/content/Context;)[Ljava/lang/String;", "apkSignature$annotations", "(Landroid/content/Context;)V", "apkSignature", "getApkSignatures", "apkSignatures", "d", "currentSignatures$annotations", "currentSignatures", "library_release"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes3.dex */
public final class LibraryUtilsKt {
    private static final boolean a(@NotNull String str, String str2) {
        boolean contains;
        contains = StringsKt__StringsKt.contains((CharSequence) str, (CharSequence) str2, true);
        return contains;
    }

    private static final boolean b(@NotNull String str, String str2) {
        boolean equals;
        equals = m.equals(str, str2, true);
        return equals;
    }

    @Nullable
    public static final AlertDialog buildUnlicensedDialog(@NotNull final Context buildUnlicensedDialog, @NotNull final String title, @NotNull final String content) {
        Context context;
        Intrinsics.checkParameterIsNotNull(buildUnlicensedDialog, "$this$buildUnlicensedDialog");
        Intrinsics.checkParameterIsNotNull(title, "title");
        Intrinsics.checkParameterIsNotNull(content, "content");
        if (!(buildUnlicensedDialog instanceof Activity)) {
            context = null;
        } else {
            context = buildUnlicensedDialog;
        }
        if (((Activity) context) == null || ((Activity) buildUnlicensedDialog).isFinishing()) {
            return null;
        }
        return new AlertDialog.Builder(buildUnlicensedDialog).setCancelable(false).setTitle(title).setMessage(content).setPositiveButton(buildUnlicensedDialog.getString(R.string.app_unlicensed_close), new DialogInterface.OnClickListener() { // from class: com.github.javiersantos.piracychecker.utils.LibraryUtilsKt$buildUnlicensedDialog$$inlined$let$lambda$1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i4) {
                if (((Activity) buildUnlicensedDialog).isFinishing()) {
                    return;
                }
                ((Activity) buildUnlicensedDialog).finish();
            }
        }).create();
    }

    private static final ArrayList<PirateApp> c(ArrayList<PirateApp> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        String[] strArr = {CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "h", "e", "l", "p", "u", "s", ".", "l", "a", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "k", "y", "p", "a", "t", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "h"};
        AppType appType = AppType.PIRATE;
        arrayList2.add(new PirateApp("LuckyPatcher", strArr, appType));
        arrayList2.add(new PirateApp("LuckyPatcher", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "d", "i", "m", "o", "n", RegisterSpec.PREFIX, "i", "d", "e", "o", ".", "l", "u", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "k", "y", "p", "a", "t", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "h", "e", "r"}, appType));
        arrayList2.add(new PirateApp("LuckyPatcher", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "f", "o", "r", "p", "d", "a", ".", "l", "p"}, appType));
        arrayList2.add(new PirateApp("LuckyPatcher", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "a", "n", "d", "r", "o", "i", "d", ".", RegisterSpec.PREFIX, "e", "n", "d", "i", "n", "g", ".", "b", "i", "l", "l", "i", "n", "g", ".", "I", "n", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "p", "B", "i", "l", "l", "i", "n", "g", ExifInterface.LATITUDE_SOUTH, "e", "r", RegisterSpec.PREFIX, "i", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "e"}, appType));
        arrayList2.add(new PirateApp("LuckyPatcher", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "a", "n", "d", "r", "o", "i", "d", ".", RegisterSpec.PREFIX, "e", "n", "d", "i", "n", "g", ".", "b", "i", "l", "l", "i", "n", "g", ".", "I", "n", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "p", "p", "B", "i", "l", "l", "i", "n", "g", ExifInterface.LATITUDE_SOUTH, "o", "r", RegisterSpec.PREFIX, "i", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "e"}, appType));
        arrayList2.add(new PirateApp("LuckyPatcher", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "a", "n", "d", "r", "o", "i", "d", ".", RegisterSpec.PREFIX, "e", "n", "d", "i", "n", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT}, appType));
        arrayList2.add(new PirateApp("UretPatcher", new String[]{"u", "r", "e", "t", ".", "j", "a", "s", "i", ExifInterface.GPS_MEASUREMENT_2D, "1", "6", "9", ".", "p", "a", "t", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "h", "e", "r"}, appType));
        arrayList2.add(new PirateApp("UretPatcher", new String[]{"z", "o", "n", "e", ".", "j", "a", "s", "i", ExifInterface.GPS_MEASUREMENT_2D, "1", "6", "9", ".", "u", "r", "e", "t", "p", "a", "t", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "h", "e", "r"}, appType));
        arrayList2.add(new PirateApp("ActionLauncherPatcher", new String[]{"p", ".", "j", "a", "s", "i", ExifInterface.GPS_MEASUREMENT_2D, "1", "6", "9", ".", "a", "l", ExifInterface.GPS_MEASUREMENT_3D}, appType));
        arrayList2.add(new PirateApp("Freedom", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, ".", "m", "a", "d", "k", "i", "t", "e", ".", "f", "r", "e", "e", "d", "o", "m"}, appType));
        arrayList2.add(new PirateApp("Freedom", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, ".", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "z", ".", "m", "a", "d", "k", "i", "t", "e", ".", "f", "r", "e", "e", "d", "o", "m"}, appType));
        arrayList2.add(new PirateApp("CreeHack", new String[]{"o", "r", "g", ".", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "r", "e", "e", "p", "l", "a", "y", "s", ".", "h", "a", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "k"}, appType));
        arrayList2.add(new PirateApp("HappyMod", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "h", "a", "p", "p", "y", "m", "o", "d", ".", "a", "p", "k"}, appType));
        arrayList2.add(new PirateApp("Game Hacker", new String[]{"o", "r", "g", ".", "s", "b", "t", "o", "o", "l", "s", ".", "g", "a", "m", "e", "h", "a", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "k"}, appType));
        arrayList2.add(new PirateApp("Game Killer Cheats", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "z", "u", "n", "e", ".", "g", "a", "m", "e", "k", "i", "l", "l", "e", "r"}, appType));
        arrayList2.add(new PirateApp("AGK - App Killer", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "a", "a", "g", ".", "k", "i", "l", "l", "e", "r"}, appType));
        arrayList2.add(new PirateApp("Game Killer", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "k", "i", "l", "l", "e", "r", "a", "p", "p", ".", "g", "a", "m", "e", "k", "i", "l", "l", "e", "r"}, appType));
        arrayList2.add(new PirateApp("Game Killer", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "n", ".", "l", "m", ".", "s", "q"}, appType));
        arrayList2.add(new PirateApp("Game CheatIng Hacker", new String[]{"n", "e", "t", ".", "s", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "h", "w", "a", "r", "z", "i", "s", ".", "g", "a", "m", "e", "_", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "i", "h"}, appType));
        arrayList2.add(new PirateApp("Game Hacker", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "b", "a", "s", "e", "a", "p", "p", "f", "u", "l", "l", ".", "f", "w", "d"}, appType));
        arrayList2.add(new PirateApp("Content Guard Disabler", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "g", "i", "t", "h", "u", "b", ".", "o", "n", "e", "m", "i", "n", "u", "s", "o", "n", "e", ".", "d", "i", "s", "a", "b", "l", "e", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "n", "t", "e", "n", "t", "g", "u", "a", "r", "d"}, appType));
        arrayList2.add(new PirateApp("Content Guard Disabler", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "o", "n", "e", "m", "i", "n", "u", "s", "o", "n", "e", ".", "d", "i", "s", "a", "b", "l", "e", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "n", "t", "e", "n", "t", "g", "u", "a", "r", "d"}, appType));
        String[] strArr2 = {CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "m", ".", "a", "p", "t", "o", "i", "d", "e", ".", "p", "t"};
        AppType appType2 = AppType.STORE;
        arrayList2.add(new PirateApp("Aptoide", strArr2, appType2));
        arrayList2.add(new PirateApp("BlackMart", new String[]{"o", "r", "g", ".", "b", "l", "a", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "k", "m", "a", "r", "t", ".", "m", "a", "r", "k", "e", "t"}, appType2));
        arrayList2.add(new PirateApp("BlackMart", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "b", "l", "a", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "k", "m", "a", "r", "t", "a", "l", "p", "h", "a"}, appType2));
        arrayList2.add(new PirateApp("Mobogenie", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "m", "o", "b", "o", "g", "e", "n", "i", "e"}, appType2));
        arrayList2.add(new PirateApp("1Mobile", new String[]{"m", "e", ".", "o", "n", "e", "m", "o", "b", "i", "l", "e", ".", "a", "n", "d", "r", "o", "i", "d"}, appType2));
        arrayList2.add(new PirateApp("GetApk", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "r", "e", "p", "o", "d", "r", "o", "i", "d", ".", "a", "p", "p"}, appType2));
        arrayList2.add(new PirateApp("GetJar", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "g", "e", "t", "j", "a", "r", ".", "r", "e", "w", "a", "r", "d", "s"}, appType2));
        arrayList2.add(new PirateApp("SlideMe", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "s", "l", "i", "d", "e", "m", "e", ".", "s", "a", "m", ".", "m", "a", "n", "a", "g", "e", "r"}, appType2));
        arrayList2.add(new PirateApp("ACMarket", new String[]{"n", "e", "t", ".", "a", "p", "p", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "a", "k", "e"}, appType2));
        arrayList2.add(new PirateApp("ACMarket", new String[]{"a", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, ".", "m", "a", "r", "k", "e", "t", ".", "s", "t", "o", "r", "e"}, appType2));
        arrayList2.add(new PirateApp("AppCake", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "a", "p", "p", CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "a", "k", "e"}, appType2));
        arrayList2.add(new PirateApp("Z Market", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "z", "m", "a", "p", "p"}, appType2));
        arrayList2.add(new PirateApp("Modded Play Store", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "d", RegisterSpec.PREFIX, ".", "m", "a", "r", "k", "e", "t", "m", "o", "d", ".", "i", "n", "s", "t", "a", "l", "l", "e", "r"}, appType2));
        arrayList2.add(new PirateApp("Mobilism Market", new String[]{"o", "r", "g", ".", "m", "o", "b", "i", "l", "i", "s", "m", ".", "a", "n", "d", "r", "o", "i", "d"}, appType2));
        arrayList2.add(new PirateApp("All-in-one Downloader", new String[]{CloudMessages.TEMPLATE_STORE_DATA_MACRO_COMMENT, "o", "m", ".", "a", "l", "l", "i", "n", "o", "n", "e", ".", "f", "r", "e", "e"}, appType2));
        arrayList2.addAll(arrayList);
        HashSet hashSet = new HashSet();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : arrayList2) {
            if (hashSet.add(((PirateApp) obj).getPackageName())) {
                arrayList3.add(obj);
            }
        }
        return new ArrayList<>(arrayList3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b2, code lost:
        if ((!r3) != false) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final java.lang.String[] d(@org.jetbrains.annotations.NotNull android.content.Context r6) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            android.content.pm.PackageManager r2 = r6.getPackageManager()     // Catch: java.lang.Exception -> L50
            java.lang.String r6 = r6.getPackageName()     // Catch: java.lang.Exception -> L50
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L50
            r4 = 28
            if (r3 < r4) goto L17
            r5 = 134217728(0x8000000, float:3.85186E-34)
            goto L19
        L17:
            r5 = 64
        L19:
            android.content.pm.PackageInfo r6 = r2.getPackageInfo(r6, r5)     // Catch: java.lang.Exception -> L50
            if (r3 < r4) goto L48
            android.content.pm.SigningInfo r2 = androidx.browser.trusted.h.a(r6)     // Catch: java.lang.Exception -> L50
            boolean r2 = androidx.browser.trusted.i.a(r2)     // Catch: java.lang.Exception -> L50
            java.lang.String r3 = "packageInfo.signingInfo"
            if (r2 == 0) goto L37
            android.content.pm.SigningInfo r6 = androidx.browser.trusted.h.a(r6)     // Catch: java.lang.Exception -> L50
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)     // Catch: java.lang.Exception -> L50
            android.content.pm.Signature[] r6 = androidx.browser.trusted.j.a(r6)     // Catch: java.lang.Exception -> L50
            goto L42
        L37:
            android.content.pm.SigningInfo r6 = androidx.browser.trusted.h.a(r6)     // Catch: java.lang.Exception -> L50
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r3)     // Catch: java.lang.Exception -> L50
            android.content.pm.Signature[] r6 = androidx.browser.trusted.k.a(r6)     // Catch: java.lang.Exception -> L50
        L42:
            java.lang.String r2 = "if (packageInfo.signingI…signingCertificateHistory"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)     // Catch: java.lang.Exception -> L50
            goto L52
        L48:
            android.content.pm.Signature[] r6 = r6.signatures     // Catch: java.lang.Exception -> L50
            java.lang.String r2 = "packageInfo.signatures"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r6, r2)     // Catch: java.lang.Exception -> L50
            goto L52
        L50:
            android.content.pm.Signature[] r6 = new android.content.pm.Signature[r1]
        L52:
            int r2 = r6.length
            r3 = 0
        L54:
            if (r3 >= r2) goto L8b
            r4 = r6[r3]
            java.lang.String r5 = "SHA"
            java.security.MessageDigest r5 = java.security.MessageDigest.getInstance(r5)
            byte[] r4 = r4.toByteArray()
            r5.update(r4)
            byte[] r4 = r5.digest()     // Catch: java.lang.Exception -> L88
            java.lang.String r4 = android.util.Base64.encodeToString(r4, r1)     // Catch: java.lang.Exception -> L88
            java.lang.String r5 = "Base64.encodeToString(me…digest(), Base64.DEFAULT)"
            kotlin.jvm.internal.Intrinsics.checkExpressionValueIsNotNull(r4, r5)     // Catch: java.lang.Exception -> L88
            if (r4 == 0) goto L80
            java.lang.CharSequence r4 = kotlin.text.StringsKt.trim(r4)     // Catch: java.lang.Exception -> L88
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Exception -> L88
            r0.add(r4)     // Catch: java.lang.Exception -> L88
            goto L88
        L80:
            kotlin.TypeCastException r4 = new kotlin.TypeCastException     // Catch: java.lang.Exception -> L88
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.CharSequence"
            r4.<init>(r5)     // Catch: java.lang.Exception -> L88
            throw r4     // Catch: java.lang.Exception -> L88
        L88:
            int r3 = r3 + 1
            goto L54
        L8b:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            java.util.Iterator r0 = r0.iterator()
        L94:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto Lbc
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            int r4 = r3.length()
            r5 = 1
            if (r4 <= 0) goto Laa
            r4 = 1
            goto Lab
        Laa:
            r4 = 0
        Lab:
            if (r4 == 0) goto Lb5
            boolean r3 = kotlin.text.StringsKt.isBlank(r3)
            r3 = r3 ^ r5
            if (r3 == 0) goto Lb5
            goto Lb6
        Lb5:
            r5 = 0
        Lb6:
            if (r5 == 0) goto L94
            r6.add(r2)
            goto L94
        Lbc:
            java.lang.String[] r0 = new java.lang.String[r1]
            java.lang.Object[] r6 = r6.toArray(r0)
            if (r6 == 0) goto Lc7
            java.lang.String[] r6 = (java.lang.String[]) r6
            return r6
        Lc7:
            kotlin.TypeCastException r6 = new kotlin.TypeCastException
            java.lang.String r0 = "null cannot be cast to non-null type kotlin.Array<T>"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.utils.LibraryUtilsKt.d(android.content.Context):java.lang.String[]");
    }

    private static final boolean e(@NotNull Context context) {
        try {
            if (h(context, "android.permission.READ_EXTERNAL_STORAGE")) {
                if (context != null) {
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, "android.permission.READ_EXTERNAL_STORAGE")) {
                        return false;
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static final boolean f(@NotNull Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            if (queryIntentActivities == null) {
                queryIntentActivities = CollectionsKt__CollectionsKt.emptyList();
            }
            return !queryIntentActivities.isEmpty();
        } catch (Exception unused) {
            return false;
        }
    }

    private static final boolean g() {
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        return false;
    }

    @NotNull
    public static final String[] getApkSignature(@NotNull Context apkSignature) {
        Intrinsics.checkParameterIsNotNull(apkSignature, "$this$apkSignature");
        return getApkSignatures(apkSignature);
    }

    @NotNull
    public static final String[] getApkSignatures(@NotNull Context apkSignatures) {
        Intrinsics.checkParameterIsNotNull(apkSignatures, "$this$apkSignatures");
        return d(apkSignatures);
    }

    @SuppressLint({"SdCardPath"})
    @Nullable
    public static final PirateApp getPirateApp(@NotNull Context getPirateApp, boolean z3, boolean z4, boolean z5, boolean z6, @NotNull ArrayList<PirateApp> extraApps) {
        PirateApp pirateApp;
        Object obj;
        boolean startsWith$default;
        List<ApplicationInfo> list;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean contains$default;
        Intrinsics.checkParameterIsNotNull(getPirateApp, "$this$getPirateApp");
        Intrinsics.checkParameterIsNotNull(extraApps, "extraApps");
        if (!z3 && !z4 && extraApps.isEmpty()) {
            return null;
        }
        ArrayList<PirateApp> c4 = c(extraApps);
        try {
            PackageManager packageManager = getPirateApp.getPackageManager();
            if (packageManager != null) {
                list = packageManager.getInstalledApplications(128);
            } else {
                list = null;
            }
            Iterator<PirateApp> it = c4.iterator();
            boolean z10 = false;
            while (it.hasNext()) {
                pirateApp = it.next();
                if (z3 && pirateApp.getType() == AppType.PIRATE) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (z4 && pirateApp.getType() == AppType.STORE) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (pirateApp.getType() == AppType.OTHER) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (z7 || z8 || z9) {
                    if (list != null) {
                        List<ApplicationInfo> list2 = list;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            for (ApplicationInfo applicationInfo : list2) {
                                String str = applicationInfo.packageName;
                                Intrinsics.checkExpressionValueIsNotNull(str, "it.packageName");
                                contains$default = StringsKt__StringsKt.contains$default((CharSequence) str, (CharSequence) pirateApp.getPackageName(), false, 2, (Object) null);
                                if (contains$default) {
                                    z10 = true;
                                    break;
                                }
                            }
                        }
                    }
                    z10 = false;
                    if (z10) {
                        continue;
                    } else {
                        z10 = f(getPirateApp, packageManager.getLaunchIntentForPackage(pirateApp.getPackageName()));
                        continue;
                    }
                }
                if (z10) {
                    break;
                }
            }
        } catch (Exception unused) {
        }
        pirateApp = null;
        if ((z5 || z6) && pirateApp == null && e(getPirateApp)) {
            Iterator<PirateApp> it2 = c4.iterator();
            boolean z11 = false;
            boolean z12 = false;
            boolean z13 = false;
            while (it2.hasNext()) {
                PirateApp next = it2.next();
                String packageName = next.getPackageName();
                if (z6) {
                    try {
                        File file = new File("/data/app/" + packageName + "-1/base.apk");
                        File file2 = new File("/data/app/" + packageName + "-2/base.apk");
                        File file3 = new File("/data/app/" + packageName + ".apk");
                        File file4 = new File("/data/data/" + packageName + ".apk");
                        if (!file.exists() && !file2.exists() && !file3.exists() && !file4.exists()) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                    } catch (Exception unused2) {
                    }
                }
                if (z5) {
                    try {
                        File file5 = new File("/data/data/" + packageName);
                        File file6 = new File(Environment.getExternalStorageDirectory() + "/Android/data/" + packageName);
                        if (!file5.exists() && !file6.exists()) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        File file7 = new File("/data/app/");
                        if (file7.exists()) {
                            File[] listFiles = file7.listFiles();
                            if (listFiles == null) {
                                listFiles = new File[0];
                            }
                            for (File f4 : listFiles) {
                                Intrinsics.checkExpressionValueIsNotNull(f4, "f");
                                String name = f4.getName();
                                Intrinsics.checkExpressionValueIsNotNull(name, "f.name");
                                obj = null;
                                try {
                                    startsWith$default = m.startsWith$default(name, packageName, false, 2, null);
                                    if (startsWith$default) {
                                        z13 = true;
                                    }
                                } catch (Exception unused3) {
                                    if (!z13) {
                                    }
                                    return next;
                                }
                            }
                        }
                    } catch (Exception unused4) {
                        obj = null;
                    }
                }
                obj = null;
                if (!z13 || z11 || z12) {
                    return next;
                }
            }
            return pirateApp;
        }
        return pirateApp;
    }

    private static final boolean h(@NotNull Context context, String str) {
        if (!g() || ContextCompat.checkSelfPermission(context, str) == 0) {
            return false;
        }
        return true;
    }

    private static final boolean i(@NotNull Context context, String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : d(context)) {
            if (Intrinsics.areEqual(str2, str)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isDebug(@NotNull Context isDebug) {
        Intrinsics.checkParameterIsNotNull(isDebug, "$this$isDebug");
        if ((isDebug.getApplicationInfo().flags & 2) != 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:134:0x01be, code lost:
        if (a(r0, "Translator") != false) goto L121;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean isInEmulator(boolean r16) {
        /*
            Method dump skipped, instructions count: 508
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.javiersantos.piracychecker.utils.LibraryUtilsKt.isInEmulator(boolean):boolean");
    }

    public static /* synthetic */ boolean isInEmulator$default(boolean z3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z3 = false;
        }
        return isInEmulator(z3);
    }

    public static final boolean verifyInstallerId(@NotNull Context verifyInstallerId, @NotNull List<? extends InstallerID> installerID) {
        Intrinsics.checkParameterIsNotNull(verifyInstallerId, "$this$verifyInstallerId");
        Intrinsics.checkParameterIsNotNull(installerID, "installerID");
        ArrayList arrayList = new ArrayList();
        String installerPackageName = verifyInstallerId.getPackageManager().getInstallerPackageName(verifyInstallerId.getPackageName());
        for (InstallerID installerID2 : installerID) {
            arrayList.addAll(installerID2.toIDs());
        }
        if (installerPackageName != null && arrayList.contains(installerPackageName)) {
            return true;
        }
        return false;
    }

    public static final boolean verifySigningCertificates(@NotNull Context verifySigningCertificates, @NotNull String[] appSignatures) {
        Intrinsics.checkParameterIsNotNull(verifySigningCertificates, "$this$verifySigningCertificates");
        Intrinsics.checkParameterIsNotNull(appSignatures, "appSignatures");
        int i4 = 0;
        for (String str : appSignatures) {
            if (i(verifySigningCertificates, str)) {
                i4++;
            }
        }
        if (i4 < appSignatures.length) {
            return false;
        }
        return true;
    }

    @Deprecated(message = "Deprecated in favor of apkSignatures, which returns all valid signing signatures", replaceWith = @ReplaceWith(expression = "apkSignatures", imports = {}))
    public static /* synthetic */ void apkSignature$annotations(Context context) {
    }
}
