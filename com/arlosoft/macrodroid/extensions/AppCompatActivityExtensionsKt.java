package com.arlosoft.macrodroid.extensions;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppCompatActivityExtensions.kt */
@SourceDebugExtension({"SMAP\nAppCompatActivityExtensions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 AppCompatActivityExtensions.kt\ncom/arlosoft/macrodroid/extensions/AppCompatActivityExtensionsKt\n+ 2 FragmentManagerExtensions.kt\ncom/arlosoft/macrodroid/extensions/FragmentManagerExtensionsKt\n*L\n1#1,13:1\n7#2,4:14\n7#2,4:18\n*S KotlinDebug\n*F\n+ 1 AppCompatActivityExtensions.kt\ncom/arlosoft/macrodroid/extensions/AppCompatActivityExtensionsKt\n*L\n7#1:14,4\n12#1:18,4\n*E\n"})
/* loaded from: classes3.dex */
public final class AppCompatActivityExtensionsKt {
    public static final void addFragment(@NotNull AppCompatActivity appCompatActivity, @NotNull Fragment fragment, int i4) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.add(i4, fragment);
        beginTransaction.commit();
    }

    public static final void replaceFragment(@NotNull AppCompatActivity appCompatActivity, @NotNull Fragment fragment, int i4) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        FragmentManager supportFragmentManager = appCompatActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "supportFragmentManager");
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
        beginTransaction.replace(i4, fragment);
        beginTransaction.commit();
    }
}
