package com.arlosoft.macrodroid.app.di;

import android.content.Context;
import com.arlosoft.macrodroid.action.CheckTextOnScreenAction;
import com.arlosoft.macrodroid.action.ClearLogAction;
import com.arlosoft.macrodroid.action.ExportLogAction;
import com.arlosoft.macrodroid.action.JsonParseAction;
import com.arlosoft.macrodroid.action.MacroDroidSettingAction;
import com.arlosoft.macrodroid.action.NotificationAction;
import com.arlosoft.macrodroid.action.ProOnlyAction;
import com.arlosoft.macrodroid.action.ReadScreenContentsAction;
import com.arlosoft.macrodroid.action.SendEmailAction;
import com.arlosoft.macrodroid.action.SetVariableAction;
import com.arlosoft.macrodroid.action.ShellScriptAction;
import com.arlosoft.macrodroid.action.TextManipulationAction;
import com.arlosoft.macrodroid.action.TranslateTextAction;
import com.arlosoft.macrodroid.action.UIInteractionAction;
import com.arlosoft.macrodroid.action.services.SendEmailService;
import com.arlosoft.macrodroid.action.services.UIInteractionAccessibilityService;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.app.di.annotations.ApplicationContext;
import com.arlosoft.macrodroid.app.di.modules.ApplicationModule;
import com.arlosoft.macrodroid.app.di.modules.BillingModule;
import com.arlosoft.macrodroid.cloudmessaging.MacroDroidFirebaseMessagingService;
import com.arlosoft.macrodroid.constraint.GeofenceConstraint;
import com.arlosoft.macrodroid.drawer.MacroDroidDrawer;
import com.arlosoft.macrodroid.freeversion.FreeDaysAlarmReceiver;
import com.arlosoft.macrodroid.helper.receiver.HelperResultsReceiver;
import com.arlosoft.macrodroid.logcat.LogcatButtonService;
import com.arlosoft.macrodroid.triggers.GeofenceTrigger;
import com.arlosoft.macrodroid.triggers.MediaButtonV2Trigger;
import com.arlosoft.macrodroid.triggers.ScreenContentTrigger;
import com.arlosoft.macrodroid.triggers.WebHookTrigger;
import com.arlosoft.macrodroid.triggers.services.QueryUiService;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;
import org.jetbrains.annotations.NotNull;

/* compiled from: AppComponent.kt */
@Component(modules = {AndroidInjectionModule.class, AndroidSupportInjectionModule.class, AppActivityModule.class, ApplicationModule.class, NetworkingModule.class, BillingModule.class})
@Singleton
/* loaded from: classes3.dex */
public interface AppComponent {
    @ApplicationContext
    @NotNull
    Context context();

    void inject(@NotNull CheckTextOnScreenAction checkTextOnScreenAction);

    void inject(@NotNull ClearLogAction clearLogAction);

    void inject(@NotNull ExportLogAction exportLogAction);

    void inject(@NotNull JsonParseAction jsonParseAction);

    void inject(@NotNull MacroDroidSettingAction macroDroidSettingAction);

    void inject(@NotNull NotificationAction notificationAction);

    void inject(@NotNull ProOnlyAction proOnlyAction);

    void inject(@NotNull ReadScreenContentsAction readScreenContentsAction);

    void inject(@NotNull SendEmailAction sendEmailAction);

    void inject(@NotNull SetVariableAction setVariableAction);

    void inject(@NotNull ShellScriptAction shellScriptAction);

    void inject(@NotNull TextManipulationAction textManipulationAction);

    void inject(@NotNull TranslateTextAction translateTextAction);

    void inject(@NotNull UIInteractionAction uIInteractionAction);

    void inject(@NotNull SendEmailService sendEmailService);

    void inject(@NotNull UIInteractionAccessibilityService uIInteractionAccessibilityService);

    void inject(@NotNull MacroDroidApplication macroDroidApplication);

    void inject(@NotNull MacroDroidFirebaseMessagingService macroDroidFirebaseMessagingService);

    void inject(@NotNull GeofenceConstraint geofenceConstraint);

    void inject(@NotNull MacroDroidDrawer macroDroidDrawer);

    void inject(@NotNull FreeDaysAlarmReceiver freeDaysAlarmReceiver);

    void inject(@NotNull HelperResultsReceiver helperResultsReceiver);

    void inject(@NotNull LogcatButtonService logcatButtonService);

    void inject(@NotNull GeofenceTrigger geofenceTrigger);

    void inject(@NotNull MediaButtonV2Trigger mediaButtonV2Trigger);

    void inject(@NotNull ScreenContentTrigger screenContentTrigger);

    void inject(@NotNull WebHookTrigger webHookTrigger);

    void inject(@NotNull QueryUiService queryUiService);

    @NotNull
    ViewComponent viewComponent();
}
