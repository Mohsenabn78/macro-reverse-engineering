package com.arlosoft.macrodroid.app.di;

import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestContentBodyFragment;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestParamsFragment;
import com.arlosoft.macrodroid.action.activities.httprequest.HttpRequestSettingsFragment;
import com.arlosoft.macrodroid.autobackup.ui.cloud.AutoBackupCloudFragment;
import com.arlosoft.macrodroid.autobackup.ui.local.AutoBackupLocalFragment;
import com.arlosoft.macrodroid.bugreporting.SubmitBugFragment;
import com.arlosoft.macrodroid.homescreen.HomeFragment;
import com.arlosoft.macrodroid.macrolist.MacroListFragment;
import com.arlosoft.macrodroid.plugins.pluginlist.PluginListFragment;
import com.arlosoft.macrodroid.templatestore.ui.TemplateStoreFragment;
import com.arlosoft.macrodroid.templatestore.ui.subscription.TemplateUpdatesFragment;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.macros.MyMacroSubscriptionsFragment;
import com.arlosoft.macrodroid.templatestore.ui.subscription.mysubscriptions.users.MyUserSubscriptionsFragment;
import com.arlosoft.macrodroid.templatestore.ui.templateList.TemplateListFragment;
import com.arlosoft.macrodroid.templatestore.ui.userlist.UserListFragment;
import com.arlosoft.macrodroid.troubleshooting.help.TroubleShootingHelpFragment;
import com.arlosoft.macrodroid.troubleshooting.problem.ProblemListFragment;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppFragmentModule.kt */
@Module
/* loaded from: classes3.dex */
public abstract class AppFragmentModule {
    @ContributesAndroidInjector
    @NotNull
    public abstract ProblemListFragment contributeProblemListFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract TemplateListFragment contributeTemplateListFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract TemplateStoreFragment contributeTemplateStoreFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract TemplateUpdatesFragment contributeTemplateUpdatesFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract UserListFragment contributeUserListFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract AutoBackupCloudFragment contributesAutoBackupCloudFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract AutoBackupLocalFragment contributesAutoBackupLocalInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract HomeFragment contributesHomeFragmentInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract HttpRequestContentBodyFragment contributesHttpRequestContentBodyFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract HttpRequestParamsFragment contributesHttpRequestParamsFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract HttpRequestSettingsFragment contributesHttpRequestSettingsFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract MacroListFragment contributesMacroListFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract MyMacroSubscriptionsFragment contributesMyMacroSubscriptionsFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract MyUserSubscriptionsFragment contributesMyUserSubscriptionsFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract PluginListFragment contributesPluginListInjector();

    @ContributesAndroidInjector
    @NotNull
    public abstract SubmitBugFragment contributesSubmitBugFragment();

    @ContributesAndroidInjector
    @NotNull
    public abstract TroubleShootingHelpFragment contributesTroubleShootingHelpFragmentInjector();
}
