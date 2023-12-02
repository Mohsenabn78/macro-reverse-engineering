package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.SetDigitalAssistantAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import java.util.List;
import kotlin.collections.e;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: SetDigitalAssistantActionInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class SetDigitalAssistantActionInfo extends ActionInfo {
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f3993g = R.string.action_set_digital_assistant;

    /* renamed from: h  reason: collision with root package name */
    private final int f3994h = R.drawable.ic_assistant;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f3995i = R.string.action_set_digital_assistant_help;

    /* renamed from: j  reason: collision with root package name */
    private final int f3996j = 1;
    @NotNull

    /* renamed from: k  reason: collision with root package name */
    private final List<String> f3997k;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;
    @NotNull

    /* renamed from: l  reason: collision with root package name */
    private static final SelectableItemInfo f3992l = new SetDigitalAssistantActionInfo();

    public SetDigitalAssistantActionInfo() {
        List<String> listOf;
        listOf = e.listOf("android.permission.WRITE_SECURE_SETTINGS");
        this.f3997k = listOf;
    }

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new SetDigitalAssistantAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public List<String> getAdbHackPermissionRequired() {
        return this.f3997k;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f3995i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f3994h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f3993g;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getRootLevel() {
        return this.f3996j;
    }

    /* compiled from: SetDigitalAssistantActionInfo.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return SetDigitalAssistantActionInfo.f3992l;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
