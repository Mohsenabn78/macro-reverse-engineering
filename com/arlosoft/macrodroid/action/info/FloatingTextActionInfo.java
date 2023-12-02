package com.arlosoft.macrodroid.action.info;

import android.app.Activity;
import androidx.annotation.StringRes;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.ActionInfo;
import com.arlosoft.macrodroid.action.FloatingTextAction;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextActionInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
public final class FloatingTextActionInfo extends ActionInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: j  reason: collision with root package name */
    private static final SelectableItemInfo f3882j = new FloatingTextActionInfo();
    @StringRes

    /* renamed from: g  reason: collision with root package name */
    private final int f3883g = R.string.action_floating_text;

    /* renamed from: h  reason: collision with root package name */
    private final int f3884h = R.drawable.ic_card_text;
    @StringRes

    /* renamed from: i  reason: collision with root package name */
    private final int f3885i = R.string.action_floating_text_help;

    @NotNull
    public static final SelectableItemInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new FloatingTextAction(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return this.f3885i;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return this.f3884h;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return this.f3883g;
    }

    /* compiled from: FloatingTextActionInfo.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final SelectableItemInfo getInstance() {
            return FloatingTextActionInfo.f3882j;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
