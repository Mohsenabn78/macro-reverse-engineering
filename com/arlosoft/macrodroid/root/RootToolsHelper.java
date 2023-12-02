package com.arlosoft.macrodroid.root;

import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.stericson.RootTools.RootTools;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: RootToolsHelper.kt */
@StabilityInferred(parameters = 0)
@SourceDebugExtension({"SMAP\nRootToolsHelper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 RootToolsHelper.kt\ncom/arlosoft/macrodroid/root/RootToolsHelper\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,34:1\n1#2:35\n*E\n"})
/* loaded from: classes3.dex */
public final class RootToolsHelper {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static Boolean f13295a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private static Boolean f13296b;
    @NotNull
    public static final RootToolsHelper INSTANCE = new RootToolsHelper();
    public static final int $stable = 8;

    private RootToolsHelper() {
    }

    @JvmStatic
    public static final boolean isAccessGiven() {
        Boolean bool = f13296b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (f13295a == null) {
            f13295a = Boolean.valueOf(RootTools.isRootAvailable());
        }
        try {
            boolean isAccessGiven = RootTools.isAccessGiven(1000, 1);
            if (!Intrinsics.areEqual(f13295a, Boolean.TRUE) || isAccessGiven) {
                f13296b = Boolean.valueOf(isAccessGiven);
                return isAccessGiven;
            }
            return isAccessGiven;
        } catch (Exception e4) {
            SystemLog.logError("Error checking RootTools.isAccessGiven(): " + e4);
            return false;
        }
    }

    @Nullable
    public final Boolean isAccessGranted() {
        return f13296b;
    }

    @Nullable
    public final Boolean isRootOnDevice() {
        return f13295a;
    }

    public final void setAccessGranted(@Nullable Boolean bool) {
        f13296b = bool;
    }

    public final void setRootOnDevice(@Nullable Boolean bool) {
        f13295a = bool;
    }
}
