package com.arlosoft.macrodroid.constraint.info;

import android.app.Activity;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.constraint.ConstraintInfo;
import com.arlosoft.macrodroid.constraint.FloatingTextConstraint;
import com.arlosoft.macrodroid.macro.Macro;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: FloatingTextConstraintInfo.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class FloatingTextConstraintInfo extends ConstraintInfo {
    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull

    /* renamed from: g  reason: collision with root package name */
    private static final FloatingTextConstraintInfo f10388g = new FloatingTextConstraintInfo();

    @NotNull
    public static final FloatingTextConstraintInfo getInstance() {
        return Companion.getInstance();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    @NotNull
    public SelectableItem constructItem(@Nullable Activity activity, @Nullable Macro macro) {
        return new FloatingTextConstraint(activity, macro);
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getHelpInfo() {
        return R.string.constraint_floating_text_help;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getIcon() {
        return R.drawable.ic_card_text;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItemInfo
    public int getName() {
        return R.string.constraint_floating_text;
    }

    /* compiled from: FloatingTextConstraintInfo.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FloatingTextConstraintInfo getInstance() {
            return FloatingTextConstraintInfo.f10388g;
        }

        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }
    }
}
