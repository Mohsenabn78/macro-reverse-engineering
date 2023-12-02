package com.arlosoft.macrodroid.macrolist;

import android.app.Activity;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: HeadingColorMapper.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
/* loaded from: classes3.dex */
public final class HeadingColorMapper {
    public static final int $stable = 8;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f12874a;

    @Inject
    public HeadingColorMapper(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.f12874a = activity;
    }

    private final int a(int i4) {
        return ContextCompat.getColor(this.f12874a, i4);
    }

    private final int b(int i4) {
        if (i4 == a(R.color.md_white)) {
            return a(R.color.md_black);
        }
        if (i4 == a(R.color.md_grey_50)) {
            return a(R.color.md_grey_700);
        }
        if (i4 == a(R.color.md_grey_100)) {
            return a(R.color.md_grey_750);
        }
        if (i4 == a(R.color.md_grey_150)) {
            return a(R.color.md_grey_750);
        }
        if (i4 == a(R.color.md_grey_200)) {
            return a(R.color.md_grey_800);
        }
        if (i4 == a(R.color.md_grey_300)) {
            return a(R.color.md_grey_900);
        }
        if (i4 == a(R.color.md_red_50)) {
            return a(R.color.md_red_700);
        }
        if (i4 == a(R.color.md_red_100)) {
            return a(R.color.md_red_800);
        }
        if (i4 == a(R.color.md_red_200)) {
            return a(R.color.md_red_900);
        }
        if (i4 == a(R.color.md_pink_50)) {
            return a(R.color.md_pink_700);
        }
        if (i4 == a(R.color.md_pink_100)) {
            return a(R.color.md_pink_800);
        }
        if (i4 == a(R.color.md_pink_200)) {
            return a(R.color.md_pink_900);
        }
        if (i4 == a(R.color.md_purple_50)) {
            return a(R.color.md_purple_700);
        }
        if (i4 == a(R.color.md_purple_100)) {
            return a(R.color.md_purple_800);
        }
        if (i4 == a(R.color.md_purple_200)) {
            return a(R.color.md_purple_900);
        }
        if (i4 == a(R.color.md_deep_purple_50)) {
            return a(R.color.md_deep_purple_700);
        }
        if (i4 == a(R.color.md_deep_purple_100)) {
            return a(R.color.md_deep_purple_800);
        }
        if (i4 == a(R.color.md_deep_purple_200)) {
            return a(R.color.md_deep_purple_900);
        }
        if (i4 == a(R.color.md_indigo_50)) {
            return a(R.color.md_indigo_700);
        }
        if (i4 == a(R.color.md_indigo_100)) {
            return a(R.color.md_indigo_800);
        }
        if (i4 == a(R.color.md_indigo_200)) {
            return a(R.color.md_indigo_900);
        }
        if (i4 == a(R.color.md_blue_50)) {
            return a(R.color.md_blue_700);
        }
        if (i4 == a(R.color.md_blue_100)) {
            return a(R.color.md_blue_800);
        }
        if (i4 == a(R.color.md_blue_200)) {
            return a(R.color.md_blue_900);
        }
        if (i4 == a(R.color.md_light_blue_50)) {
            return a(R.color.md_light_blue_700);
        }
        if (i4 == a(R.color.md_light_blue_100)) {
            return a(R.color.md_light_blue_800);
        }
        if (i4 == a(R.color.md_light_blue_200)) {
            return a(R.color.md_light_blue_900);
        }
        if (i4 == a(R.color.md_cyan_50)) {
            return a(R.color.md_cyan_700);
        }
        if (i4 == a(R.color.md_cyan_100)) {
            return a(R.color.md_cyan_800);
        }
        if (i4 == a(R.color.md_cyan_200)) {
            return a(R.color.md_cyan_900);
        }
        if (i4 == a(R.color.md_teal_50)) {
            return a(R.color.md_teal_700);
        }
        if (i4 == a(R.color.md_teal_100)) {
            return a(R.color.md_teal_800);
        }
        if (i4 == a(R.color.md_teal_200)) {
            return a(R.color.md_teal_900);
        }
        if (i4 == a(R.color.md_green_50)) {
            return a(R.color.md_green_800);
        }
        if (i4 == a(R.color.md_green_100)) {
            return a(R.color.md_green_900);
        }
        if (i4 == a(R.color.md_green_200)) {
            return a(R.color.md_green_1000);
        }
        if (i4 == a(R.color.md_light_green_50)) {
            return a(R.color.md_light_green_800);
        }
        if (i4 == a(R.color.md_light_green_100)) {
            return a(R.color.md_light_green_900);
        }
        if (i4 == a(R.color.md_light_green_200)) {
            return a(R.color.md_light_green_1000);
        }
        if (i4 == a(R.color.md_lime_50)) {
            return a(R.color.md_lime_800);
        }
        if (i4 == a(R.color.md_lime_100)) {
            return a(R.color.md_lime_900);
        }
        if (i4 == a(R.color.md_lime_200)) {
            return a(R.color.md_lime_1000);
        }
        if (i4 == a(R.color.md_yellow_50)) {
            return a(R.color.md_yellow_700);
        }
        if (i4 == a(R.color.md_yellow_100)) {
            return a(R.color.md_yellow_800);
        }
        if (i4 == a(R.color.md_yellow_200)) {
            return a(R.color.md_yellow_900);
        }
        if (i4 == a(R.color.md_amber_50)) {
            return a(R.color.md_amber_700);
        }
        if (i4 == a(R.color.md_amber_100)) {
            return a(R.color.md_amber_800);
        }
        if (i4 == a(R.color.md_amber_200)) {
            return a(R.color.md_amber_900);
        }
        if (i4 == a(R.color.md_orange_50)) {
            return a(R.color.md_orange_700);
        }
        if (i4 == a(R.color.md_orange_100)) {
            return a(R.color.md_orange_800);
        }
        if (i4 == a(R.color.md_orange_200)) {
            return a(R.color.md_orange_900);
        }
        if (i4 == a(R.color.md_deep_orange_50)) {
            return a(R.color.md_deep_orange_700);
        }
        if (i4 == a(R.color.md_deep_orange_100)) {
            return a(R.color.md_deep_orange_800);
        }
        if (i4 == a(R.color.md_deep_orange_200)) {
            return a(R.color.md_deep_orange_900);
        }
        if (i4 == a(R.color.md_brown_50)) {
            return a(R.color.md_brown_700);
        }
        if (i4 == a(R.color.md_brown_100)) {
            return a(R.color.md_brown_800);
        }
        if (i4 == a(R.color.md_brown_200)) {
            return a(R.color.md_brown_900);
        }
        if (i4 == a(R.color.md_blue_grey_50)) {
            return a(R.color.md_blue_grey_700);
        }
        if (i4 == a(R.color.md_blue_grey_100)) {
            return a(R.color.md_blue_grey_800);
        }
        if (i4 == a(R.color.md_blue_grey_200)) {
            return a(R.color.md_blue_grey_900);
        }
        return i4;
    }

    private final int c(int i4) {
        if (i4 == a(R.color.md_black)) {
            return a(R.color.md_white);
        }
        if (i4 == a(R.color.md_grey_600)) {
            return a(R.color.md_grey_100);
        }
        if (i4 == a(R.color.md_grey_700)) {
            return a(R.color.md_grey_100);
        }
        if (i4 == a(R.color.md_grey_750)) {
            return a(R.color.md_grey_150);
        }
        if (i4 == a(R.color.md_grey_800)) {
            return a(R.color.md_grey_200);
        }
        if (i4 == a(R.color.md_grey_900)) {
            return a(R.color.md_grey_300);
        }
        if (i4 == a(R.color.md_red_700)) {
            return a(R.color.md_red_50);
        }
        if (i4 == a(R.color.md_red_800)) {
            return a(R.color.md_red_100);
        }
        if (i4 == a(R.color.md_red_900)) {
            return a(R.color.md_red_200);
        }
        if (i4 == a(R.color.md_pink_700)) {
            return a(R.color.md_pink_50);
        }
        if (i4 == a(R.color.md_pink_800)) {
            return a(R.color.md_pink_100);
        }
        if (i4 == a(R.color.md_pink_900)) {
            return a(R.color.md_pink_200);
        }
        if (i4 == a(R.color.md_purple_700)) {
            return a(R.color.md_purple_50);
        }
        if (i4 == a(R.color.md_purple_800)) {
            return a(R.color.md_purple_100);
        }
        if (i4 == a(R.color.md_purple_900)) {
            return a(R.color.md_purple_200);
        }
        if (i4 == a(R.color.md_deep_purple_700)) {
            return a(R.color.md_deep_purple_50);
        }
        if (i4 == a(R.color.md_deep_purple_800)) {
            return a(R.color.md_deep_purple_100);
        }
        if (i4 == a(R.color.md_deep_purple_900)) {
            return a(R.color.md_deep_purple_200);
        }
        if (i4 == a(R.color.md_indigo_700)) {
            return a(R.color.md_indigo_50);
        }
        if (i4 == a(R.color.md_indigo_800)) {
            return a(R.color.md_indigo_100);
        }
        if (i4 == a(R.color.md_indigo_900)) {
            return a(R.color.md_indigo_200);
        }
        if (i4 == a(R.color.md_blue_700)) {
            return a(R.color.md_blue_50);
        }
        if (i4 == a(R.color.md_blue_800)) {
            return a(R.color.md_blue_100);
        }
        if (i4 == a(R.color.md_blue_900)) {
            return a(R.color.md_blue_200);
        }
        if (i4 == a(R.color.md_light_blue_700)) {
            return a(R.color.md_light_blue_50);
        }
        if (i4 == a(R.color.md_light_blue_800)) {
            return a(R.color.md_light_blue_100);
        }
        if (i4 == a(R.color.md_light_blue_900)) {
            return a(R.color.md_light_blue_200);
        }
        if (i4 == a(R.color.md_cyan_700)) {
            return a(R.color.md_cyan_50);
        }
        if (i4 == a(R.color.md_cyan_800)) {
            return a(R.color.md_cyan_100);
        }
        if (i4 == a(R.color.md_cyan_900)) {
            return a(R.color.md_cyan_200);
        }
        if (i4 == a(R.color.md_teal_700)) {
            return a(R.color.md_teal_50);
        }
        if (i4 == a(R.color.md_teal_800)) {
            return a(R.color.md_teal_100);
        }
        if (i4 == a(R.color.md_teal_900)) {
            return a(R.color.md_teal_200);
        }
        if (i4 == a(R.color.md_green_800)) {
            return a(R.color.md_green_50);
        }
        if (i4 == a(R.color.md_green_900)) {
            return a(R.color.md_green_100);
        }
        if (i4 == a(R.color.md_green_1000)) {
            return a(R.color.md_green_200);
        }
        if (i4 == a(R.color.md_light_green_800)) {
            return a(R.color.md_light_green_50);
        }
        if (i4 == a(R.color.md_light_green_900)) {
            return a(R.color.md_light_green_100);
        }
        if (i4 == a(R.color.md_light_green_1000)) {
            return a(R.color.md_light_green_200);
        }
        if (i4 == a(R.color.md_lime_800)) {
            return a(R.color.md_lime_50);
        }
        if (i4 == a(R.color.md_lime_900)) {
            return a(R.color.md_lime_100);
        }
        if (i4 == a(R.color.md_lime_1000)) {
            return a(R.color.md_lime_200);
        }
        if (i4 == a(R.color.md_yellow_700)) {
            return a(R.color.md_yellow_50);
        }
        if (i4 == a(R.color.md_yellow_800)) {
            return a(R.color.md_yellow_100);
        }
        if (i4 == a(R.color.md_yellow_900)) {
            return a(R.color.md_yellow_200);
        }
        if (i4 == a(R.color.md_amber_700)) {
            return a(R.color.md_amber_50);
        }
        if (i4 == a(R.color.md_amber_800)) {
            return a(R.color.md_amber_100);
        }
        if (i4 == a(R.color.md_amber_900)) {
            return a(R.color.md_amber_200);
        }
        if (i4 == a(R.color.md_orange_700)) {
            return a(R.color.md_orange_50);
        }
        if (i4 == a(R.color.md_orange_800)) {
            return a(R.color.md_orange_100);
        }
        if (i4 == a(R.color.md_orange_900)) {
            return a(R.color.md_orange_200);
        }
        if (i4 == a(R.color.md_deep_orange_700)) {
            return a(R.color.md_deep_orange_50);
        }
        if (i4 == a(R.color.md_deep_orange_800)) {
            return a(R.color.md_deep_orange_100);
        }
        if (i4 == a(R.color.md_deep_orange_900)) {
            return a(R.color.md_deep_orange_200);
        }
        if (i4 == a(R.color.md_brown_700)) {
            return a(R.color.md_brown_50);
        }
        if (i4 == a(R.color.md_brown_800)) {
            return a(R.color.md_brown_100);
        }
        if (i4 == a(R.color.md_brown_900)) {
            return a(R.color.md_brown_200);
        }
        if (i4 == a(R.color.md_blue_grey_700)) {
            return a(R.color.md_blue_grey_50);
        }
        if (i4 == a(R.color.md_blue_grey_800)) {
            return a(R.color.md_blue_grey_100);
        }
        if (i4 == a(R.color.md_blue_grey_900)) {
            return a(R.color.md_blue_grey_200);
        }
        return i4;
    }

    public final int getHeadingColor(int i4) {
        boolean z3 = this.f12874a.getResources().getBoolean(R.bool.is_night_mode);
        if (z3) {
            return b(i4);
        }
        if (!z3) {
            return c(i4);
        }
        throw new NoWhenBranchMatchedException();
    }
}
