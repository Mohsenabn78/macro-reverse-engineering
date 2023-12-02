package com.arlosoft.macrodroid.app.navigation;

import android.app.Activity;
import android.content.Intent;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.avatar.views.AvatarView;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.templatestore.model.MacroTemplate;
import com.arlosoft.macrodroid.templatestore.reportmacro.ReportMacroActivity;
import com.arlosoft.macrodroid.templatestore.reportmacro.ReportMacroRepository;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsDataRepository;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileActivity;
import com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadActivity;
import com.arlosoft.macrodroid.templatestore.ui.user.UserActivity;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import javax.inject.Inject;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ScreenLoader.kt */
@StabilityInferred(parameters = 0)
@ActivityScope
/* loaded from: classes3.dex */
public final class ScreenLoader {
    public static final int REQUEST_CODE_COMMENTS = 101;
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final Activity f9294a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final ReportMacroRepository f9295b;
    @Inject
    public TemplateCommentsDataRepository templateCommentsDataRepository;
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: ScreenLoader.kt */
    /* loaded from: classes3.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public ScreenLoader(@NotNull Activity currentActivity, @NotNull ReportMacroRepository reportMacroRepository) {
        Intrinsics.checkNotNullParameter(currentActivity, "currentActivity");
        Intrinsics.checkNotNullParameter(reportMacroRepository, "reportMacroRepository");
        this.f9294a = currentActivity;
        this.f9295b = reportMacroRepository;
    }

    public static /* synthetic */ void loadUserDetailsScreen$default(ScreenLoader screenLoader, String str, String str2, int i4, AvatarView avatarView, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            avatarView = null;
        }
        screenLoader.loadUserDetailsScreen(str, str2, i4, avatarView);
    }

    public final void closeCurrentScreen() {
        this.f9294a.finish();
    }

    @NotNull
    public final TemplateCommentsDataRepository getTemplateCommentsDataRepository() {
        TemplateCommentsDataRepository templateCommentsDataRepository = this.templateCommentsDataRepository;
        if (templateCommentsDataRepository != null) {
            return templateCommentsDataRepository;
        }
        Intrinsics.throwUninitializedPropertyAccessException("templateCommentsDataRepository");
        return null;
    }

    public final void loadEditMacroScreenFromTemplate(@NotNull Macro macro, boolean z3) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        macro.setCompleted(false);
        MacroStore.getInstance().addMacro(macro, false);
        macro.setTemplateSelected();
        Intent intent = new Intent(this.f9294a, EditMacroActivity.class);
        intent.putExtra("MacroId", macro.getId());
        intent.putExtra(EditMacroActivity.IS_TEMPLATE_EXTRA, true);
        intent.putExtra(EditMacroActivity.NEW_TEMPLATE_STORE, z3);
        this.f9294a.startActivity(intent);
    }

    public final void loadHomeScreen() {
        Intent intent = new Intent(this.f9294a, NewHomeScreenActivity.class);
        intent.setFlags(603979776);
        this.f9294a.startActivity(intent);
    }

    public final void loadProfileScreen(boolean z3, @NotNull String personalIdentifier, boolean z4) {
        Intrinsics.checkNotNullParameter(personalIdentifier, "personalIdentifier");
        this.f9294a.startActivity(ProfileActivity.Companion.createIntent(this.f9294a, z3, personalIdentifier, z4));
    }

    public final void loadReportMacroScreen(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        this.f9295b.setMacroTemplate(macroTemplate);
        ReportMacroActivity.Companion.showReportMacroScreen(this.f9294a);
    }

    public final void loadTemplateCommentsScreen(@NotNull MacroTemplate macroTemplate) {
        Intrinsics.checkNotNullParameter(macroTemplate, "macroTemplate");
        getTemplateCommentsDataRepository().setMacroTemplate(macroTemplate.clearJsonData());
        this.f9294a.startActivityForResult(TemplateCommentsActivity.Companion.createIntent(this.f9294a), 101);
        this.f9294a.overridePendingTransition(R.anim.up_from_bottom, 0);
    }

    public final void loadTemplateSearchScreen(int i4) {
        TemplateSearchActivity.Companion companion = TemplateSearchActivity.Companion;
        Activity activity = this.f9294a;
        this.f9294a.startActivity(TemplateSearchActivity.Companion.createIntent$default(companion, activity, "id=" + i4, 0, 4, null));
    }

    public final void loadTemplateUploadScreen(int i4, @NotNull Macro macro, @NotNull String description, @NotNull String category) {
        Intrinsics.checkNotNullParameter(macro, "macro");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(category, "category");
        this.f9294a.startActivity(TemplateUploadActivity.Companion.createIntent(this.f9294a, Integer.valueOf(i4), macro, description, category));
    }

    public final void loadUpgradeScreen() {
        this.f9294a.startActivity(new Intent(this.f9294a, UpgradeActivity2.class));
    }

    public final void loadUserDetailsScreen(@NotNull String username, @NotNull String userImage, int i4, @Nullable AvatarView avatarView) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(userImage, "userImage");
        Intent createIntent = UserActivity.Companion.createIntent(this.f9294a, username, userImage, i4);
        if (avatarView != null) {
            Pair create = Pair.create(avatarView, "avatarImage");
            Intrinsics.checkNotNullExpressionValue(create, "create<View, String>(avaterImage, \"avatarImage\")");
            ActivityOptionsCompat makeSceneTransitionAnimation = ActivityOptionsCompat.makeSceneTransitionAnimation(this.f9294a, create);
            Intrinsics.checkNotNullExpressionValue(makeSceneTransitionAnimation, "makeSceneTransitionAnima…urrentActivity, pairCard)");
            this.f9294a.startActivity(createIntent, makeSceneTransitionAnimation.toBundle());
            return;
        }
        this.f9294a.startActivity(createIntent);
    }

    public final void setTemplateCommentsDataRepository(@NotNull TemplateCommentsDataRepository templateCommentsDataRepository) {
        Intrinsics.checkNotNullParameter(templateCommentsDataRepository, "<set-?>");
        this.templateCommentsDataRepository = templateCommentsDataRepository;
    }

    public final void loadTemplateUploadScreen(int i4, @NotNull String macroName, @NotNull String description, @NotNull String category) {
        Intrinsics.checkNotNullParameter(macroName, "macroName");
        Intrinsics.checkNotNullParameter(description, "description");
        Intrinsics.checkNotNullParameter(category, "category");
        this.f9294a.startActivity(TemplateUploadActivity.Companion.createIntent(this.f9294a, Integer.valueOf(i4), macroName, description, category));
    }

    public final void loadTemplateCommentsScreen(long j4) {
        this.f9294a.startActivityForResult(TemplateCommentsActivity.Companion.createIntent(this.f9294a), 101);
        this.f9294a.overridePendingTransition(R.anim.up_from_bottom, 0);
    }
}
