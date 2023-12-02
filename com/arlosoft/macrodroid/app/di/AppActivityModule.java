package com.arlosoft.macrodroid.app.di;

import android.app.Activity;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.DonateActivity;
import com.arlosoft.macrodroid.ExportImportActivity;
import com.arlosoft.macrodroid.LauncherActivity;
import com.arlosoft.macrodroid.ShortcutActivity;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestConfigActivity;
import com.arlosoft.macrodroid.actionblock.edit.ActionBlockEditActivity;
import com.arlosoft.macrodroid.actionblock.list.ActionBlockListActivity;
import com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity;
import com.arlosoft.macrodroid.advert.MacroDroidProAdvertActivity2;
import com.arlosoft.macrodroid.app.di.annotations.ActivityScope;
import com.arlosoft.macrodroid.app.di.modules.ActivityModule;
import com.arlosoft.macrodroid.autobackup.ui.AutoBackupActivity;
import com.arlosoft.macrodroid.bugreporting.ReportBugActivity;
import com.arlosoft.macrodroid.confirmation.validation.ConfirmActionActivity;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.extras.stopclub.StopClubActivity;
import com.arlosoft.macrodroid.freeversion.AddDaysActivity;
import com.arlosoft.macrodroid.homescreen.NewHomeScreenActivity;
import com.arlosoft.macrodroid.homescreen.quickrun.QuickRunAddMacrosActivity;
import com.arlosoft.macrodroid.logcat.LogcatMessageSelectActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLogActivity;
import com.arlosoft.macrodroid.logging.systemlog.macrofilter.MacroLogFilterActivity;
import com.arlosoft.macrodroid.plugins.PluginsActivity;
import com.arlosoft.macrodroid.plugins.comments.PluginCommentsActivity;
import com.arlosoft.macrodroid.privacy.PrivacyActivity;
import com.arlosoft.macrodroid.settings.EditCategoriesActivity;
import com.arlosoft.macrodroid.settings.EditNotificationChannelsActivity;
import com.arlosoft.macrodroid.templatestore.reportmacro.ReportMacroActivity;
import com.arlosoft.macrodroid.templatestore.ui.comments.TemplateCommentsActivity;
import com.arlosoft.macrodroid.templatestore.ui.profile.ProfileActivity;
import com.arlosoft.macrodroid.templatestore.ui.search.TemplateSearchActivity;
import com.arlosoft.macrodroid.templatestore.ui.subscription.MySubscriptionsActivity;
import com.arlosoft.macrodroid.templatestore.ui.upload.TemplateUploadActivity;
import com.arlosoft.macrodroid.templatestore.ui.user.UserActivity;
import com.arlosoft.macrodroid.translations.TranslationsActivity;
import com.arlosoft.macrodroid.triggers.activities.NotificationButtonNotAssignedActivity;
import com.arlosoft.macrodroid.troubleshooting.TroubleShootingActivity;
import com.arlosoft.macrodroid.upgrade.UpgradeActivity2;
import com.arlosoft.macrodroid.upgrade.UpgradeSupportActivity2;
import com.arlosoft.macrodroid.variables.MacroDroidVariablesActivity;
import com.arlosoft.macrodroid.videos.VideosActivity;
import com.arlosoft.macrodroid.wizard.WizardActivity;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppActivityModule.kt */
@Module(subcomponents = {TemplateSearchActivityComponent.class, EditMacroActivityComponent.class, WizardActivityComponent.class, TemplateCommentsActivityComponent.class, UserActivityComponent.class, ProfileActivityComponent.class, TemplateUploadActivityComponent.class, AutoBackupActivityComponent.class, UpgradeSupportActivity2Component.class, NewHomeScreenActivityComponent.class, UpgradeActivity2Component.class, TroubleShootingActivityComponent.class, PluginsActivityComponent.class, PluginCommentsActivityComponent.class, QuickRunAddMacrosActivityComponent.class, NotificationButtonNotAssignedActivityComponent.class, MacroDroidProAdvertActivityComponent.class, MacroDroidProAdvertActivity2Component.class, EditNotificationChannelsActivityComponent.class, SystemLogActivityComponent.class, MacroLogFilterActivityBindingComponent.class, ReportBugActivityBindingComponent.class, DonateActivityBindingComponent.class, ValidatePurchaseActivityBindingComponent.class, ExportImportActivityBindingComponent.class, LogcatMessageSelectActivityBindingComponent.class, ActionBlockEditActivityBindingComponent.class, ActionBlockListActivityBindingComponent.class, LauncherActivityBindingComponent.class, TranslationsActivityBindingComponent.class, VideosActivityBindingComponent.class, HttpRequestConfigActivityBindingComponent.class, PrivacyActivityBindingComponent.class, MacroDroidVariablesActivityBindingComponent.class, ReportsActivityBindingComponent.class, EditCategoriesActivityBindingComponent.class, ShortcutActivityBindingComponent.class, MySubscriptionsActivityBindingComponent.class, StopClubActivityBindingComponent.class, AddDaysActivityBindingComponent.class})
/* loaded from: classes3.dex */
public abstract class AppActivityModule {

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ActionBlockEditActivityBindingComponent extends AndroidInjector<ActionBlockEditActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ActionBlockEditActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ActionBlockListActivityBindingComponent extends AndroidInjector<ActionBlockListActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ActionBlockListActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface AddDaysActivityBindingComponent extends AndroidInjector<AddDaysActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<AddDaysActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface AutoBackupActivityComponent extends AndroidInjector<AutoBackupActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<AutoBackupActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface DonateActivityBindingComponent extends AndroidInjector<DonateActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<DonateActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface EditCategoriesActivityBindingComponent extends AndroidInjector<EditCategoriesActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<EditCategoriesActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface EditMacroActivityComponent extends AndroidInjector<EditMacroActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<EditMacroActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface EditNotificationChannelsActivityComponent extends AndroidInjector<EditNotificationChannelsActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<EditNotificationChannelsActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ExportImportActivityBindingComponent extends AndroidInjector<ExportImportActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ExportImportActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface HttpRequestConfigActivityBindingComponent extends AndroidInjector<HttpRequestConfigActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<HttpRequestConfigActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface LauncherActivityBindingComponent extends AndroidInjector<LauncherActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<LauncherActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface LogcatMessageSelectActivityBindingComponent extends AndroidInjector<LogcatMessageSelectActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<LogcatMessageSelectActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface MacroDroidProAdvertActivity2Component extends AndroidInjector<MacroDroidProAdvertActivity2> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<MacroDroidProAdvertActivity2> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface MacroDroidProAdvertActivityComponent extends AndroidInjector<MacroDroidProAdvertActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<MacroDroidProAdvertActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface MacroDroidVariablesActivityBindingComponent extends AndroidInjector<MacroDroidVariablesActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<MacroDroidVariablesActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface MacroLogFilterActivityBindingComponent extends AndroidInjector<MacroLogFilterActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<MacroLogFilterActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface MySubscriptionsActivityBindingComponent extends AndroidInjector<MySubscriptionsActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<MySubscriptionsActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface NewHomeScreenActivityComponent extends AndroidInjector<NewHomeScreenActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<NewHomeScreenActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface NotificationButtonNotAssignedActivityComponent extends AndroidInjector<NotificationButtonNotAssignedActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<NotificationButtonNotAssignedActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface PluginCommentsActivityComponent extends AndroidInjector<PluginCommentsActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<PluginCommentsActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface PluginsActivityComponent extends AndroidInjector<PluginsActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<PluginsActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface PrivacyActivityBindingComponent extends AndroidInjector<PrivacyActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<PrivacyActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ProfileActivityComponent extends AndroidInjector<ProfileActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ProfileActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface QuickRunAddMacrosActivityComponent extends AndroidInjector<QuickRunAddMacrosActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<QuickRunAddMacrosActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ReportBugActivityBindingComponent extends AndroidInjector<ReportBugActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ReportBugActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ReportsActivityBindingComponent extends AndroidInjector<ReportMacroActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ReportMacroActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ShortcutActivityBindingComponent extends AndroidInjector<ShortcutActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ShortcutActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface StopClubActivityBindingComponent extends AndroidInjector<StopClubActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<StopClubActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface SystemLogActivityComponent extends AndroidInjector<SystemLogActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<SystemLogActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface TemplateCommentsActivityComponent extends AndroidInjector<TemplateCommentsActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<TemplateCommentsActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface TemplateSearchActivityComponent extends AndroidInjector<TemplateSearchActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<TemplateSearchActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface TemplateUploadActivityComponent extends AndroidInjector<TemplateUploadActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<TemplateUploadActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface TranslationsActivityBindingComponent extends AndroidInjector<TranslationsActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<TranslationsActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface TroubleShootingActivityComponent extends AndroidInjector<TroubleShootingActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<TroubleShootingActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface UpgradeActivity2Component extends AndroidInjector<UpgradeActivity2> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<UpgradeActivity2> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface UpgradeSupportActivity2Component extends AndroidInjector<UpgradeSupportActivity2> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<UpgradeSupportActivity2> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface UserActivityComponent extends AndroidInjector<UserActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<UserActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface ValidatePurchaseActivityBindingComponent extends AndroidInjector<ConfirmActionActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<ConfirmActionActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface VideosActivityBindingComponent extends AndroidInjector<VideosActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<VideosActivity> {
            public static final int $stable = 0;
        }
    }

    /* compiled from: AppActivityModule.kt */
    @ActivityScope
    @Subcomponent(modules = {ActivityModule.class})
    /* loaded from: classes3.dex */
    public interface WizardActivityComponent extends AndroidInjector<WizardActivity> {

        /* compiled from: AppActivityModule.kt */
        @StabilityInferred(parameters = 0)
        @Subcomponent.Builder
        /* loaded from: classes3.dex */
        public static abstract class Builder extends BaseActivityComponentBuilder<WizardActivity> {
            public static final int $stable = 0;
        }
    }

    @Binds
    @NotNull
    @ActivityKey(ActionBlockEditActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindActionBlockEditActivityInjectorFactory(@NotNull ActionBlockEditActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ActionBlockListActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindActionBlockListActivityInjectorFactory(@NotNull ActionBlockListActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(AddDaysActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindAddDaysActivityInjectorFactory(@NotNull AddDaysActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(AutoBackupActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindAutoBackupActivityInjectorFactory(@NotNull AutoBackupActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(DonateActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindDonateActivityInjectorFactory(@NotNull DonateActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(EditCategoriesActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindEditCategoriesActivityInjectorFactory(@NotNull EditCategoriesActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(EditMacroActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindEditMacroActivityInjectorFactory(@NotNull EditMacroActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(EditNotificationChannelsActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindEditNotificationChannelsActivityInjectorFactory(@NotNull EditNotificationChannelsActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ExportImportActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindExportImportActivityInjectorFactory(@NotNull ExportImportActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(HttpRequestConfigActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindHttpRequestConfigActivityInjectorFactory(@NotNull HttpRequestConfigActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(LauncherActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindLauncherActivityInjectorFactory(@NotNull LauncherActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(LogcatMessageSelectActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindLogcatMessageSelectActivityInjectorFactory(@NotNull LogcatMessageSelectActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(MacroDroidProAdvertActivity2.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindMacroDroidProAdvertActivity2InjectorFactory(@NotNull MacroDroidProAdvertActivity2Component.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(MacroDroidProAdvertActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindMacroDroidProAdvertActivityInjectorFactory(@NotNull MacroDroidProAdvertActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(MacroDroidVariablesActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindMacroDroidVariablesActivityInjectorFactory(@NotNull MacroDroidVariablesActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(MacroLogFilterActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindMacroLogFilterActivityInjectorFactory(@NotNull MacroLogFilterActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(MySubscriptionsActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindMySubscriptionsActivityInjectorFactory(@NotNull MySubscriptionsActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(NewHomeScreenActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindNewHomeScreenActivityInjectorFactory(@NotNull NewHomeScreenActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(NotificationButtonNotAssignedActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindNotificationButtonNotAssignedActivityInjectorFactory(@NotNull NotificationButtonNotAssignedActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(PluginCommentsActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindPluginCommentsActivityInjectorFactory(@NotNull PluginCommentsActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(PluginsActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindPluginsActivityInjectorFactory(@NotNull PluginsActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(PrivacyActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindPrivacyActivityInjectorFactory(@NotNull PrivacyActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ProfileActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindProfileActivityInjectorFactory(@NotNull ProfileActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(QuickRunAddMacrosActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindQuickRunAddMacrosActivityInjectorFactory(@NotNull QuickRunAddMacrosActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ReportBugActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindReportBugActivityInjectorFactory(@NotNull ReportBugActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ReportMacroActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindReportsActivityInjectorFactory(@NotNull ReportsActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ShortcutActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindShortcutActivityInjectorFactory(@NotNull ShortcutActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(StopClubActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindStopClubActivityInjectorFactory(@NotNull StopClubActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(SystemLogActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindSystemLogActivityInjectorFactory(@NotNull SystemLogActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(TemplateCommentsActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindTemplateCommentsActivityInjectorFactory(@NotNull TemplateCommentsActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(TemplateSearchActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindTemplateSearchActivityInjectorFactory(@NotNull TemplateSearchActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(TemplateUploadActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindTemplateUploadActivityActivityInjectorFactory(@NotNull TemplateUploadActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(TranslationsActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindTranslationsActivityInjectorFactory(@NotNull TranslationsActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(TroubleShootingActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindTroubleShootingActivityInjectorFactory(@NotNull TroubleShootingActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(UpgradeActivity2.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindUpgradeActivity2InjectorFactory(@NotNull UpgradeActivity2Component.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(UpgradeSupportActivity2.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindUpgradeSupportActivityActivity2InjectorFactory(@NotNull UpgradeSupportActivity2Component.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(UserActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindUserActivityInjectorFactory(@NotNull UserActivityComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(ConfirmActionActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindValidatePurchaseActivityInjectorFactory(@NotNull ValidatePurchaseActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(VideosActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindVideosActivityInjectorFactory(@NotNull VideosActivityBindingComponent.Builder builder);

    @Binds
    @NotNull
    @ActivityKey(WizardActivity.class)
    @IntoMap
    public abstract AndroidInjector.Factory<? extends Activity> bindWizardActivityInjectorFactory(@NotNull WizardActivityComponent.Builder builder);
}
