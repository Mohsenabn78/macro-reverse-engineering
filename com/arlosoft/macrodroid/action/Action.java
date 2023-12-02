package com.arlosoft.macrodroid.action;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Parcel;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.info.AccessibilityServiceActionInfo;
import com.arlosoft.macrodroid.action.info.ActionBlockActionInfo;
import com.arlosoft.macrodroid.action.info.AddCalendarEntryActionInfo;
import com.arlosoft.macrodroid.action.info.AllowLEDNotificationLightActionInfo;
import com.arlosoft.macrodroid.action.info.AmbientDisplayActionInfo;
import com.arlosoft.macrodroid.action.info.AndroidShortcutsActionInfo;
import com.arlosoft.macrodroid.action.info.AndroidWearActionInfo;
import com.arlosoft.macrodroid.action.info.AnswerCallActionInfo;
import com.arlosoft.macrodroid.action.info.AuthenticateUserActionInfo;
import com.arlosoft.macrodroid.action.info.BatterySaverActionInfo;
import com.arlosoft.macrodroid.action.info.BlockTouchesActionInfo;
import com.arlosoft.macrodroid.action.info.BluetoothTetheringActionInfo;
import com.arlosoft.macrodroid.action.info.BreakFromLoopActionInfo;
import com.arlosoft.macrodroid.action.info.CameraFlashLightActionInfo;
import com.arlosoft.macrodroid.action.info.CancelActiveMacroActionInfo;
import com.arlosoft.macrodroid.action.info.CarModeActionInfo;
import com.arlosoft.macrodroid.action.info.ChangeKeyboardActionInfo;
import com.arlosoft.macrodroid.action.info.CheckTextOnScreenActionInfo;
import com.arlosoft.macrodroid.action.info.ClearAppDataActionInfo;
import com.arlosoft.macrodroid.action.info.ClearCallLogActionInfo;
import com.arlosoft.macrodroid.action.info.ClearDictionaryArrayEntryActionInfo;
import com.arlosoft.macrodroid.action.info.ClearLogActionInfo;
import com.arlosoft.macrodroid.action.info.ClearNotificationsActionInfo;
import com.arlosoft.macrodroid.action.info.ClearVariablesActionInfo;
import com.arlosoft.macrodroid.action.info.ClipboardActionInfo;
import com.arlosoft.macrodroid.action.info.CloseApplicationActionInfo;
import com.arlosoft.macrodroid.action.info.ConfigureAppNotificationsActionInfo;
import com.arlosoft.macrodroid.action.info.ConfigureWidgetButtonActionInfo;
import com.arlosoft.macrodroid.action.info.ConfirmNextActionInfo;
import com.arlosoft.macrodroid.action.info.ConnectivityCheckActionInfo;
import com.arlosoft.macrodroid.action.info.ContactViaAppActionInfo;
import com.arlosoft.macrodroid.action.info.ContinueLoopActionInfo;
import com.arlosoft.macrodroid.action.info.ControlMediaActionInfo;
import com.arlosoft.macrodroid.action.info.DarkThemeActionInfo;
import com.arlosoft.macrodroid.action.info.DayDreamActionInfo;
import com.arlosoft.macrodroid.action.info.DeleteMacroActionInfo;
import com.arlosoft.macrodroid.action.info.DemoModeActionInfo;
import com.arlosoft.macrodroid.action.info.DimScreenActionInfo;
import com.arlosoft.macrodroid.action.info.DisableAppActionInfo;
import com.arlosoft.macrodroid.action.info.DisableCameraActionInfo;
import com.arlosoft.macrodroid.action.info.DisableCategoryActionInfo;
import com.arlosoft.macrodroid.action.info.DisableMacroActionInfo;
import com.arlosoft.macrodroid.action.info.DisableMacrodroidActionInfo;
import com.arlosoft.macrodroid.action.info.EmptyActionInfo;
import com.arlosoft.macrodroid.action.info.ExitActionBlockActionInfo;
import com.arlosoft.macrodroid.action.info.ExpandCollapseStatusBarActionInfo;
import com.arlosoft.macrodroid.action.info.ExportLogActionInfo;
import com.arlosoft.macrodroid.action.info.ExportMacrosActionInfo;
import com.arlosoft.macrodroid.action.info.FileOperationActionInfo;
import com.arlosoft.macrodroid.action.info.FileOperationV21ActionInfo;
import com.arlosoft.macrodroid.action.info.FloatingButtonConfigureActionInfo;
import com.arlosoft.macrodroid.action.info.FloatingTextActionInfo;
import com.arlosoft.macrodroid.action.info.FontScaleActionInfo;
import com.arlosoft.macrodroid.action.info.ForceLocationUpdateActionInfo;
import com.arlosoft.macrodroid.action.info.ForceMacroRunActionInfo;
import com.arlosoft.macrodroid.action.info.ForceScreenRotationActionInfo;
import com.arlosoft.macrodroid.action.info.ForwardSMSActionInfo;
import com.arlosoft.macrodroid.action.info.HeadsUpNotificationsActionInfo;
import com.arlosoft.macrodroid.action.info.HttpRequestActionInfo;
import com.arlosoft.macrodroid.action.info.IfConditionActionInfo;
import com.arlosoft.macrodroid.action.info.IfConfirmedThenActionInfo;
import com.arlosoft.macrodroid.action.info.ImmersiveModeActionInfo;
import com.arlosoft.macrodroid.action.info.InvertColoursActionInfo;
import com.arlosoft.macrodroid.action.info.IterateDictionaryActionInfo;
import com.arlosoft.macrodroid.action.info.JavaScriptActionInfo;
import com.arlosoft.macrodroid.action.info.JsonOutputActionInfo;
import com.arlosoft.macrodroid.action.info.JsonParseActionInfo;
import com.arlosoft.macrodroid.action.info.KeepAwakeActionInfo;
import com.arlosoft.macrodroid.action.info.KillBackgroundAppActionInfo;
import com.arlosoft.macrodroid.action.info.LaunchActivityActionInfo;
import com.arlosoft.macrodroid.action.info.LaunchAndPressActionInfo;
import com.arlosoft.macrodroid.action.info.LaunchHomeScreenActionInfo;
import com.arlosoft.macrodroid.action.info.LaunchShortcutActionInfo;
import com.arlosoft.macrodroid.action.info.LocalePluginActionInfo;
import com.arlosoft.macrodroid.action.info.LogActionInfo;
import com.arlosoft.macrodroid.action.info.LoopActionInfo;
import com.arlosoft.macrodroid.action.info.MacroDroidDrawerActionInfo;
import com.arlosoft.macrodroid.action.info.MacroDroidNotificationTextActionInfo;
import com.arlosoft.macrodroid.action.info.MacroDroidSettingActionInfo;
import com.arlosoft.macrodroid.action.info.MakeCallActionInfo;
import com.arlosoft.macrodroid.action.info.MessageDialogActionInfo;
import com.arlosoft.macrodroid.action.info.NotificationActionInfo;
import com.arlosoft.macrodroid.action.info.NotificationInteractionActionInfo;
import com.arlosoft.macrodroid.action.info.NotificationReplyActionInfo;
import com.arlosoft.macrodroid.action.info.OpenCallLogActionInfo;
import com.arlosoft.macrodroid.action.info.OpenFileActionInfo;
import com.arlosoft.macrodroid.action.info.OpenLastPhotoActionInfo;
import com.arlosoft.macrodroid.action.info.OpenMacroDroidLogActionInfo;
import com.arlosoft.macrodroid.action.info.OpenWebPageActionInfo;
import com.arlosoft.macrodroid.action.info.OptionDialogActionInfo;
import com.arlosoft.macrodroid.action.info.PauseActionInfo;
import com.arlosoft.macrodroid.action.info.PebbleActionInfo;
import com.arlosoft.macrodroid.action.info.PlaySoundActionInfo;
import com.arlosoft.macrodroid.action.info.PressBackActionInfo;
import com.arlosoft.macrodroid.action.info.ReadFileActionInfo;
import com.arlosoft.macrodroid.action.info.ReadScreenContentsActionInfo;
import com.arlosoft.macrodroid.action.info.RebootActionInfo;
import com.arlosoft.macrodroid.action.info.RecordMicrophoneActionInfo;
import com.arlosoft.macrodroid.action.info.RejectCallActionInfo;
import com.arlosoft.macrodroid.action.info.RestoreNotificationsActionInfo;
import com.arlosoft.macrodroid.action.info.SayTimeActionInfo;
import com.arlosoft.macrodroid.action.info.ScreenOnActionInfo;
import com.arlosoft.macrodroid.action.info.SecureSettingsActionInfo;
import com.arlosoft.macrodroid.action.info.SelectionDialogActionInfo;
import com.arlosoft.macrodroid.action.info.SendEmailActionInfo;
import com.arlosoft.macrodroid.action.info.SendIntentActionInfo;
import com.arlosoft.macrodroid.action.info.SendSMSActionInfo;
import com.arlosoft.macrodroid.action.info.SetAirplaneModeActionInfo;
import com.arlosoft.macrodroid.action.info.SetAlarmClockActionInfo;
import com.arlosoft.macrodroid.action.info.SetAutoRotateActionInfo;
import com.arlosoft.macrodroid.action.info.SetAutoSyncActionInfo;
import com.arlosoft.macrodroid.action.info.SetBluetoothActionInfo;
import com.arlosoft.macrodroid.action.info.SetBrightnessActionInfo;
import com.arlosoft.macrodroid.action.info.SetDataActionInfo;
import com.arlosoft.macrodroid.action.info.SetDigitalAssistantActionInfo;
import com.arlosoft.macrodroid.action.info.SetGPSActionInfo;
import com.arlosoft.macrodroid.action.info.SetHotspotActionInfo;
import com.arlosoft.macrodroid.action.info.SetKeyboardActionInfo;
import com.arlosoft.macrodroid.action.info.SetKeyguardActionInfo;
import com.arlosoft.macrodroid.action.info.SetLanguageActionInfo;
import com.arlosoft.macrodroid.action.info.SetLocationModeActionInfo;
import com.arlosoft.macrodroid.action.info.SetLocationUpdateRateActionInfo;
import com.arlosoft.macrodroid.action.info.SetMacroDroidIconActionInfo;
import com.arlosoft.macrodroid.action.info.SetModeActionInfo;
import com.arlosoft.macrodroid.action.info.SetNFCActionInfo;
import com.arlosoft.macrodroid.action.info.SetNotificationBarIconActionInfo;
import com.arlosoft.macrodroid.action.info.SetNotificationSoundActionInfo;
import com.arlosoft.macrodroid.action.info.SetPriorityModeInfo;
import com.arlosoft.macrodroid.action.info.SetQuickSettingsStateActionInfo;
import com.arlosoft.macrodroid.action.info.SetRingtoneActionInfo;
import com.arlosoft.macrodroid.action.info.SetScreenTimeoutActionInfo;
import com.arlosoft.macrodroid.action.info.SetVariableActionInfo;
import com.arlosoft.macrodroid.action.info.SetVibrateActionInfo;
import com.arlosoft.macrodroid.action.info.SetVolumeActionInfo;
import com.arlosoft.macrodroid.action.info.SetWallpaperActionInfo;
import com.arlosoft.macrodroid.action.info.SetWifiActionInfo;
import com.arlosoft.macrodroid.action.info.ShareLocationActionInfo;
import com.arlosoft.macrodroid.action.info.ShellScriptActionInfo;
import com.arlosoft.macrodroid.action.info.SilentModeVibrateOffActionInfo;
import com.arlosoft.macrodroid.action.info.SpeakTextActionInfo;
import com.arlosoft.macrodroid.action.info.SpeakerPhoneActionInfo;
import com.arlosoft.macrodroid.action.info.StopWatchActionInfo;
import com.arlosoft.macrodroid.action.info.SyncAccountActionInfo;
import com.arlosoft.macrodroid.action.info.SystemSettingActionInfo;
import com.arlosoft.macrodroid.action.info.TakePictureActionInfo;
import com.arlosoft.macrodroid.action.info.TakeScreenshotActionInfo;
import com.arlosoft.macrodroid.action.info.TextManipulationActionInfo;
import com.arlosoft.macrodroid.action.info.ToastActionInfo;
import com.arlosoft.macrodroid.action.info.TouchScreenActionInfo;
import com.arlosoft.macrodroid.action.info.TranslateTextActionInfo;
import com.arlosoft.macrodroid.action.info.UDPCommandActionInfo;
import com.arlosoft.macrodroid.action.info.UIInteractionActionInfo;
import com.arlosoft.macrodroid.action.info.USBTetheringActionInfo;
import com.arlosoft.macrodroid.action.info.UpdateClipboardActionInfo;
import com.arlosoft.macrodroid.action.info.UploadPhotoActionInfo;
import com.arlosoft.macrodroid.action.info.VibrateActionInfo;
import com.arlosoft.macrodroid.action.info.VoiceInputActionInfo;
import com.arlosoft.macrodroid.action.info.VoiceSearchActionInfo;
import com.arlosoft.macrodroid.action.info.VolumeIncrementDecrementActionInfo;
import com.arlosoft.macrodroid.action.info.WaitUntilTriggerActionInfo;
import com.arlosoft.macrodroid.action.info.WhatsAppActionInfo;
import com.arlosoft.macrodroid.action.info.WriteToFileActionInfo;
import com.arlosoft.macrodroid.actionblock.data.ActionBlock;
import com.arlosoft.macrodroid.categories.SelectableItemCategory;
import com.arlosoft.macrodroid.common.ApplicationChecker;
import com.arlosoft.macrodroid.common.SelectableItem;
import com.arlosoft.macrodroid.common.SelectableItemInfo;
import com.arlosoft.macrodroid.constraint.Constraint;
import com.arlosoft.macrodroid.data.IteratorType;
import com.arlosoft.macrodroid.editscreen.EditMacroActivity;
import com.arlosoft.macrodroid.interfaces.BlockingAction;
import com.arlosoft.macrodroid.logging.LogActivity;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.MacroListUtils;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes2.dex */
public abstract class Action extends SelectableItem {
    public static final int STATE_OFF = 1;
    public static final int STATE_ON = 0;
    public static final int STATE_TOGGLE = 2;
    public static final Object enabledStateLock = new Object();

    /* renamed from: b  reason: collision with root package name */
    transient long f2063b;
    private transient boolean enabled;
    private transient long m_parentSIGUID;
    private transient long m_parentSIGUIDForInsert;

    public Action() {
    }

    private static void I(SelectableItemInfo selectableItemInfo, List<SelectableItemInfo> list) {
        if (selectableItemInfo.allowedOnDevice()) {
            list.add(selectableItemInfo);
        }
    }

    private static void J(SelectableItemInfo selectableItemInfo, List<SelectableItemInfo> list) {
        if (selectableItemInfo.allowedOnDevice()) {
            list.add(selectableItemInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int K(Collator collator, Context context, SelectableItemInfo selectableItemInfo, SelectableItemInfo selectableItemInfo2) {
        return collator.compare(context.getString(selectableItemInfo.getName()), context.getString(selectableItemInfo2.getName()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int L(Collator collator, SelectableItemCategory selectableItemCategory, SelectableItemCategory selectableItemCategory2) {
        return collator.compare(selectableItemCategory.getCategoryName(), selectableItemCategory2.getCategoryName());
    }

    public static int checkActionsFlowControl(List<Action> list) {
        Stack stack = new Stack();
        HashMap hashMap = new HashMap();
        Stack stack2 = new Stack();
        for (int i4 = 0; i4 < list.size(); i4++) {
            try {
                Action action = list.get(i4);
                if (action instanceof ParentAction) {
                    stack.push((ParentAction) action);
                    if (action instanceof IfConditionAction) {
                        hashMap.put((IfConditionAction) action, new ArrayList());
                        stack2.push((IfConditionAction) action);
                    }
                } else if (action instanceof EndLoopAction) {
                    if (!(stack.pop() instanceof LoopAction)) {
                        return i4;
                    }
                } else if (action instanceof EndIfAction) {
                    if (!(stack.pop() instanceof IfConditionAction)) {
                        return i4;
                    }
                    stack2.pop();
                } else if (!(action instanceof ElseParentAction)) {
                    continue;
                } else if (!(stack.peek() instanceof IfConditionAction)) {
                    return i4;
                } else {
                    List list2 = (List) hashMap.get(stack2.peek());
                    list2.add((ElseParentAction) action);
                    for (int i5 = 0; i5 < list2.size() - 1; i5++) {
                        if (list2.get(i5) instanceof ElseAction) {
                            return i4;
                        }
                    }
                    continue;
                }
            } catch (EmptyStackException unused) {
                return i4;
            }
        }
        if (stack.size() > 0) {
            return 0;
        }
        return -1;
    }

    public static List<SelectableItemInfo> getAllActionsInfo(final Context context, Macro macro, boolean z3) {
        ArrayList arrayList = new ArrayList();
        try {
            I(SetWallpaperActionInfo.getInstance(), arrayList);
            I(VibrateActionInfo.getInstance(), arrayList);
            I(SetWifiActionInfo.getInstance(), arrayList);
            if (BluetoothAdapter.getDefaultAdapter() != null) {
                I(SetBluetoothActionInfo.getInstance(), arrayList);
            }
            if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
                I(SendSMSActionInfo.getInstance(), arrayList);
                I(MakeCallActionInfo.getInstance(), arrayList);
                I(SpeakerPhoneActionInfo.getInstance(), arrayList);
                I(ClearCallLogActionInfo.getInstance(), arrayList);
                I(AnswerCallActionInfo.getInstance(), arrayList);
                if (z3 || macro.hasOnlyTrigger(IncomingSMSTrigger.class)) {
                    I(ForwardSMSActionInfo.getInstance(), arrayList);
                }
            }
            I(PlaySoundActionInfo.getInstance(), arrayList);
            I(LaunchActivityActionInfo.getInstance(), arrayList);
            I(SetVolumeActionInfo.getInstance(), arrayList);
            I(NotificationActionInfo.getInstance(), arrayList);
            I(SetRingtoneActionInfo.getInstance(), arrayList);
            J(ContactViaAppActionInfo.getInstance(), arrayList);
            J(WhatsAppActionInfo.getInstance(), arrayList);
            I(SetModeActionInfo.getInstance(), arrayList);
            I(SpeakTextActionInfo.getInstance(), arrayList);
            I(OpenWebPageActionInfo.getInstance(), arrayList);
            I(JavaScriptActionInfo.getInstance(), arrayList);
            I(HttpRequestActionInfo.getInstance(), arrayList);
            I(SetScreenTimeoutActionInfo.getInstance(), arrayList);
            I(ToastActionInfo.getInstance(), arrayList);
            I(ShareLocationActionInfo.getInstance(), arrayList);
            I(SetKeyguardActionInfo.getInstance(), arrayList);
            I(RecordMicrophoneActionInfo.getInstance(), arrayList);
            I(ControlMediaActionInfo.getInstance(), arrayList);
            I(UploadPhotoActionInfo.getInstance(), arrayList);
            J(OpenLastPhotoActionInfo.getInstance(), arrayList);
            J(DisableCameraActionInfo.getInstance(), arrayList);
            I(SetAutoSyncActionInfo.getInstance(), arrayList);
            I(FileOperationActionInfo.getInstance(), arrayList);
            I(PauseActionInfo.getInstance(), arrayList);
            I(DisableMacrodroidActionInfo.getInstance(), arrayList);
            I(EmptyActionInfo.getInstance(), arrayList);
            I(FloatingButtonConfigureActionInfo.getInstance(), arrayList);
            I(FloatingTextActionInfo.getInstance(), arrayList);
            I(ExportLogActionInfo.getInstance(), arrayList);
            if (!(macro instanceof ActionBlock)) {
                J(WaitUntilTriggerActionInfo.getInstance(), arrayList);
            }
            I(ActionBlockActionInfo.getInstance(), arrayList);
            if (macro instanceof ActionBlock) {
                I(ExitActionBlockActionInfo.getInstance(), arrayList);
            }
            J(ClearVariablesActionInfo.getInstance(), arrayList);
            J(ClearDictionaryArrayEntryActionInfo.getInstance(), arrayList);
            I(SetBrightnessActionInfo.getInstance(), arrayList);
            I(SetHotspotActionInfo.getInstance(), arrayList);
            I(SetVibrateActionInfo.getInstance(), arrayList);
            I(SilentModeVibrateOffActionInfo.getInstance(), arrayList);
            I(SayTimeActionInfo.getInstance(), arrayList);
            I(SetAutoRotateActionInfo.getInstance(), arrayList);
            I(ClipboardActionInfo.getInstance(), arrayList);
            J(UpdateClipboardActionInfo.getInstance(), arrayList);
            I(ScreenOnActionInfo.getInstance(), arrayList);
            I(LaunchHomeScreenActionInfo.getInstance(), arrayList);
            I(VoiceSearchActionInfo.getInstance(), arrayList);
            I(VoiceInputActionInfo.getInstance(), arrayList);
            I(SendEmailActionInfo.getInstance(), arrayList);
            I(KeepAwakeActionInfo.getInstance(), arrayList);
            I(OpenFileActionInfo.getInstance(), arrayList);
            I(LaunchShortcutActionInfo.getInstance(), arrayList);
            I(AllowLEDNotificationLightActionInfo.getInstance(), arrayList);
            I(MessageDialogActionInfo.getInstance(), arrayList);
            I(KillBackgroundAppActionInfo.getInstance(), arrayList);
            I(SetKeyboardActionInfo.getInstance(), arrayList);
            I(ChangeKeyboardActionInfo.getInstance(), arrayList);
            I(ForceMacroRunActionInfo.getInstance(), arrayList);
            I(ForceLocationUpdateActionInfo.getInstance(), arrayList);
            I(SetLocationUpdateRateActionInfo.getInstance(), arrayList);
            I(SecureSettingsActionInfo.getInstance(), arrayList);
            I(SetVariableActionInfo.getInstance(), arrayList);
            I(AddCalendarEntryActionInfo.getInstance(), arrayList);
            I(LogActionInfo.getInstance(), arrayList);
            I(ClearLogActionInfo.getInstance(), arrayList);
            I(DisableCategoryActionInfo.getInstance(), arrayList);
            I(VolumeIncrementDecrementActionInfo.getInstance(), arrayList);
            I(ForceScreenRotationActionInfo.getInstance(), arrayList);
            I(ReadScreenContentsActionInfo.getInstance(), arrayList);
            I(BlockTouchesActionInfo.getInstance(), arrayList);
            I(CheckTextOnScreenActionInfo.getInstance(), arrayList);
            I(MacroDroidSettingActionInfo.getInstance(), arrayList);
            I(SetMacroDroidIconActionInfo.getInstance(), arrayList);
            I(MacroDroidNotificationTextActionInfo.getInstance(), arrayList);
            I(ConfirmNextActionInfo.getInstance(), arrayList);
            I(AndroidWearActionInfo.getInstance(), arrayList);
            I(OpenCallLogActionInfo.getInstance(), arrayList);
            I(OpenMacroDroidLogActionInfo.getInstance(), arrayList);
            I(ExportMacrosActionInfo.getInstance(), arrayList);
            I(CancelActiveMacroActionInfo.getInstance(), arrayList);
            I(DimScreenActionInfo.getInstance(), arrayList);
            I(UDPCommandActionInfo.getInstance(), arrayList);
            I(OptionDialogActionInfo.getInstance(), arrayList);
            I(SelectionDialogActionInfo.getInstance(), arrayList);
            I(SetNotificationBarIconActionInfo.getInstance(), arrayList);
            I(LocalePluginActionInfo.getInstance(), arrayList);
            I(CarModeActionInfo.getInstance(), arrayList);
            I(SetAlarmClockActionInfo.getInstance(), arrayList);
            I(SetNotificationSoundActionInfo.getInstance(), arrayList);
            I(HeadsUpNotificationsActionInfo.getInstance(), arrayList);
            I(NotificationInteractionActionInfo.getInstance(), arrayList);
            I(NotificationReplyActionInfo.getInstance(), arrayList);
            I(SendIntentActionInfo.getInstance(), arrayList);
            I(FileOperationV21ActionInfo.getInstance(), arrayList);
            I(PressBackActionInfo.getInstance(), arrayList);
            I(RejectCallActionInfo.getInstance(), arrayList);
            I(SetPriorityModeInfo.getInstance(), arrayList);
            I(DayDreamActionInfo.getInstance(), arrayList);
            I(DemoModeActionInfo.getInstance(), arrayList);
            I(ClearNotificationsActionInfo.getInstance(), arrayList);
            J(RestoreNotificationsActionInfo.getInstance(), arrayList);
            I(ExpandCollapseStatusBarActionInfo.getInstance(), arrayList);
            I(DeleteMacroActionInfo.getInstance(), arrayList);
            I(AndroidShortcutsActionInfo.getInstance(), arrayList);
            I(ShellScriptActionInfo.getInstance(), arrayList);
            I(SetQuickSettingsStateActionInfo.getInstance(), arrayList);
            I(ConfigureWidgetButtonActionInfo.getInstance(), arrayList);
            I(WriteToFileActionInfo.getInstance(), arrayList);
            I(ReadFileActionInfo.getInstance(), arrayList);
            I(StopWatchActionInfo.getInstance(), arrayList);
            I(ImmersiveModeActionInfo.getInstance(), arrayList);
            I(ClearAppDataActionInfo.getInstance(), arrayList);
            I(DisableAppActionInfo.getInstance(), arrayList);
            I(MacroDroidDrawerActionInfo.getInstance(), arrayList);
            I(SetLanguageActionInfo.getInstance(), arrayList);
            I(SyncAccountActionInfo.getInstance(), arrayList);
            I(TextManipulationActionInfo.getInstance(), arrayList);
            I(TranslateTextActionInfo.getInstance(), arrayList);
            I(JsonOutputActionInfo.getInstance(), arrayList);
            I(JsonParseActionInfo.getInstance(), arrayList);
            I(ConnectivityCheckActionInfo.getInstance(), arrayList);
            I(UIInteractionActionInfo.getInstance(), arrayList);
            I(AuthenticateUserActionInfo.getInstance(), arrayList);
            I(AmbientDisplayActionInfo.getInstance(), arrayList);
            I(SystemSettingActionInfo.getInstance(), arrayList);
            I(DarkThemeActionInfo.getInstance(), arrayList);
            I(FontScaleActionInfo.getInstance(), arrayList);
            I(SetDigitalAssistantActionInfo.getInstance(), arrayList);
            I(BluetoothTetheringActionInfo.getInstance(), arrayList);
            try {
                Settings.Secure.getInt(context.getContentResolver(), "accessibility_display_inversion_enabled");
                I(InvertColoursActionInfo.getInstance(), arrayList);
            } catch (Settings.SettingNotFoundException unused) {
            }
            if (ApplicationChecker.isPebbleInstalled()) {
                I(PebbleActionInfo.getInstance(), arrayList);
            }
            if (context.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
                I(CameraFlashLightActionInfo.getInstance(), arrayList);
            }
            if (MacroStore.getInstance().getAllCompletedMacros().size() > 0) {
                I(DisableMacroActionInfo.getInstance(), arrayList);
            }
            I(AccessibilityServiceActionInfo.getInstance(), arrayList);
            I(BatterySaverActionInfo.getInstance(), arrayList);
            I(SetLocationModeActionInfo.getInstance(), arrayList);
            if (context.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
                I(SetNFCActionInfo.getInstance(), arrayList);
            }
            I(SetDataActionInfo.getInstance(), arrayList);
            I(RebootActionInfo.getInstance(), arrayList);
            I(CloseApplicationActionInfo.getInstance(), arrayList);
            I(SetGPSActionInfo.getInstance(), arrayList);
            I(ConfigureAppNotificationsActionInfo.getInstance(), arrayList);
            I(TakeScreenshotActionInfo.getInstance(), arrayList);
            if (com.arlosoft.macrodroid.settings.Settings.areExperimentalFeaturesEnabled(context)) {
                I(LaunchAndPressActionInfo.getInstance(), arrayList);
                I(TouchScreenActionInfo.getInstance(), arrayList);
            }
            I(USBTetheringActionInfo.getInstance(), arrayList);
            I(SetAirplaneModeActionInfo.getInstance(), arrayList);
            if (context.getPackageManager().hasSystemFeature("android.hardware.camera")) {
                I(TakePictureActionInfo.getInstance(), arrayList);
            }
            final Collator collator = Collator.getInstance(com.arlosoft.macrodroid.settings.Settings.getLocale(context));
            collator.setStrength(0);
            Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.action.c
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    int K;
                    K = Action.K(collator, context, (SelectableItemInfo) obj, (SelectableItemInfo) obj2);
                    return K;
                }
            });
        } catch (IllegalStateException unused2) {
        }
        return arrayList;
    }

    public static List<SelectableItemCategory> getCategories(Context context, Macro macro, boolean z3, boolean z4) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        ArrayList arrayList2 = new ArrayList();
        J(SetAirplaneModeActionInfo.getInstance(), arrayList2);
        J(AndroidWearActionInfo.getInstance(), arrayList2);
        J(SetAutoSyncActionInfo.getInstance(), arrayList2);
        if (BluetoothAdapter.getDefaultAdapter() != null) {
            J(SetBluetoothActionInfo.getInstance(), arrayList2);
        }
        J(SetHotspotActionInfo.getInstance(), arrayList2);
        J(SendIntentActionInfo.getInstance(), arrayList2);
        J(SetDataActionInfo.getInstance(), arrayList2);
        if (context.getPackageManager().hasSystemFeature("android.hardware.nfc")) {
            J(SetNFCActionInfo.getInstance(), arrayList2);
        }
        J(SyncAccountActionInfo.getInstance(), arrayList2);
        J(USBTetheringActionInfo.getInstance(), arrayList2);
        J(SetWifiActionInfo.getInstance(), arrayList2);
        if (ApplicationChecker.isPebbleInstalled()) {
            J(PebbleActionInfo.getInstance(), arrayList2);
        }
        J(ConnectivityCheckActionInfo.getInstance(), arrayList2);
        J(BluetoothTetheringActionInfo.getInstance(), arrayList2);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_connectivity), R.drawable.ic_router_wireless_white_24dp, arrayList2));
        ArrayList arrayList3 = new ArrayList();
        if (packageManager.hasSystemFeature("android.hardware.camera")) {
            J(TakePictureActionInfo.getInstance(), arrayList3);
        }
        J(TakeScreenshotActionInfo.getInstance(), arrayList3);
        J(UploadPhotoActionInfo.getInstance(), arrayList3);
        J(OpenLastPhotoActionInfo.getInstance(), arrayList3);
        J(DisableCameraActionInfo.getInstance(), arrayList3);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_camera_photo), R.drawable.ic_camera_white_24dp, arrayList3));
        if (((TelephonyManager) context.getSystemService("phone")).getPhoneType() != 0) {
            ArrayList arrayList4 = new ArrayList();
            J(MakeCallActionInfo.getInstance(), arrayList4);
            J(AnswerCallActionInfo.getInstance(), arrayList4);
            J(RejectCallActionInfo.getInstance(), arrayList4);
            J(ClearCallLogActionInfo.getInstance(), arrayList4);
            if (z3 || macro.hasOnlyTrigger(IncomingSMSTrigger.class)) {
                J(ForwardSMSActionInfo.getInstance(), arrayList4);
            }
            J(OpenCallLogActionInfo.getInstance(), arrayList4);
            J(SetRingtoneActionInfo.getInstance(), arrayList4);
            J(ContactViaAppActionInfo.getInstance(), arrayList4);
            arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_phone), R.drawable.ic_phone_classic_white_24dp, arrayList4));
        }
        ArrayList arrayList5 = new ArrayList();
        J(SendSMSActionInfo.getInstance(), arrayList5);
        J(SendEmailActionInfo.getInstance(), arrayList5);
        J(WhatsAppActionInfo.getInstance(), arrayList5);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_messaging), R.drawable.ic_at_white_24dp, arrayList5));
        ArrayList arrayList6 = new ArrayList();
        J(ScreenOnActionInfo.getInstance(), arrayList6);
        J(DimScreenActionInfo.getInstance(), arrayList6);
        J(SetScreenTimeoutActionInfo.getInstance(), arrayList6);
        J(SetBrightnessActionInfo.getInstance(), arrayList6);
        J(KeepAwakeActionInfo.getInstance(), arrayList6);
        J(ForceScreenRotationActionInfo.getInstance(), arrayList6);
        J(ReadScreenContentsActionInfo.getInstance(), arrayList6);
        J(BlockTouchesActionInfo.getInstance(), arrayList6);
        J(CheckTextOnScreenActionInfo.getInstance(), arrayList6);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_screen), R.drawable.ic_account_white_24dp, arrayList6));
        ArrayList arrayList7 = new ArrayList();
        J(SetNotificationSoundActionInfo.getInstance(), arrayList7);
        J(AllowLEDNotificationLightActionInfo.getInstance(), arrayList7);
        J(NotificationActionInfo.getInstance(), arrayList7);
        J(ClearNotificationsActionInfo.getInstance(), arrayList7);
        J(RestoreNotificationsActionInfo.getInstance(), arrayList7);
        J(ConfigureAppNotificationsActionInfo.getInstance(), arrayList7);
        J(ToastActionInfo.getInstance(), arrayList7);
        J(MessageDialogActionInfo.getInstance(), arrayList7);
        J(HeadsUpNotificationsActionInfo.getInstance(), arrayList7);
        J(NotificationInteractionActionInfo.getInstance(), arrayList7);
        J(NotificationReplyActionInfo.getInstance(), arrayList7);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_notification), R.drawable.ic_alert_box_white_24dp, arrayList7));
        ArrayList arrayList8 = new ArrayList();
        J(SetVolumeActionInfo.getInstance(), arrayList8);
        J(VolumeIncrementDecrementActionInfo.getInstance(), arrayList8);
        J(SpeakerPhoneActionInfo.getInstance(), arrayList8);
        J(SetPriorityModeInfo.getInstance(), arrayList8);
        I(SetVibrateActionInfo.getInstance(), arrayList8);
        I(SilentModeVibrateOffActionInfo.getInstance(), arrayList8);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_volume), R.drawable.ic_speaker_white_24dp, arrayList8));
        ArrayList arrayList9 = new ArrayList();
        J(StopWatchActionInfo.getInstance(), arrayList9);
        J(SetAlarmClockActionInfo.getInstance(), arrayList9);
        J(SayTimeActionInfo.getInstance(), arrayList9);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_date_time), R.drawable.ic_calendar_clock_white_24dp, arrayList9));
        ArrayList arrayList10 = new ArrayList();
        J(AccessibilityServiceActionInfo.getInstance(), arrayList10);
        J(BatterySaverActionInfo.getInstance(), arrayList10);
        J(CarModeActionInfo.getInstance(), arrayList10);
        J(DayDreamActionInfo.getInstance(), arrayList10);
        J(DemoModeActionInfo.getInstance(), arrayList10);
        J(ImmersiveModeActionInfo.getInstance(), arrayList10);
        J(SetWallpaperActionInfo.getInstance(), arrayList10);
        J(SetQuickSettingsStateActionInfo.getInstance(), arrayList10);
        J(SetLanguageActionInfo.getInstance(), arrayList10);
        J(SetKeyboardActionInfo.getInstance(), arrayList10);
        J(ChangeKeyboardActionInfo.getInstance(), arrayList10);
        J(SetKeyguardActionInfo.getInstance(), arrayList10);
        J(SetAutoRotateActionInfo.getInstance(), arrayList10);
        J(SecureSettingsActionInfo.getInstance(), arrayList10);
        J(AmbientDisplayActionInfo.getInstance(), arrayList10);
        I(SystemSettingActionInfo.getInstance(), arrayList10);
        I(DarkThemeActionInfo.getInstance(), arrayList10);
        I(FontScaleActionInfo.getInstance(), arrayList10);
        I(SetDigitalAssistantActionInfo.getInstance(), arrayList10);
        try {
            Settings.Secure.getInt(context.getContentResolver(), "accessibility_display_inversion_enabled");
            J(InvertColoursActionInfo.getInstance(), arrayList10);
        } catch (Settings.SettingNotFoundException unused) {
        }
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_device_settings), R.drawable.ic_settings_applications_white_24dp, arrayList10));
        ArrayList arrayList11 = new ArrayList();
        J(VibrateActionInfo.getInstance(), arrayList11);
        J(PressBackActionInfo.getInstance(), arrayList11);
        J(ExpandCollapseStatusBarActionInfo.getInstance(), arrayList11);
        J(LaunchHomeScreenActionInfo.getInstance(), arrayList11);
        J(RebootActionInfo.getInstance(), arrayList11);
        J(AndroidShortcutsActionInfo.getInstance(), arrayList11);
        if (com.arlosoft.macrodroid.settings.Settings.areExperimentalFeaturesEnabled(context)) {
            J(TouchScreenActionInfo.getInstance(), arrayList11);
        }
        if (context.getPackageManager().hasSystemFeature("android.hardware.camera.flash")) {
            J(CameraFlashLightActionInfo.getInstance(), arrayList11);
        }
        J(VoiceSearchActionInfo.getInstance(), arrayList11);
        J(VoiceInputActionInfo.getInstance(), arrayList11);
        J(ClipboardActionInfo.getInstance(), arrayList11);
        J(UpdateClipboardActionInfo.getInstance(), arrayList11);
        J(SpeakTextActionInfo.getInstance(), arrayList11);
        J(UIInteractionActionInfo.getInstance(), arrayList11);
        J(AuthenticateUserActionInfo.getInstance(), arrayList11);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_device_actions), R.drawable.ic_auto_fix_white_24dp, arrayList11));
        ArrayList arrayList12 = new ArrayList();
        J(FileOperationActionInfo.getInstance(), arrayList12);
        J(FileOperationV21ActionInfo.getInstance(), arrayList12);
        J(OpenFileActionInfo.getInstance(), arrayList12);
        J(WriteToFileActionInfo.getInstance(), arrayList12);
        J(ReadFileActionInfo.getInstance(), arrayList12);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_files), R.drawable.ic_file_white_24dp, arrayList12));
        ArrayList arrayList13 = new ArrayList();
        J(AddCalendarEntryActionInfo.getInstance(), arrayList13);
        J(ClearLogActionInfo.getInstance(), arrayList13);
        J(OpenMacroDroidLogActionInfo.getInstance(), arrayList13);
        J(LogActionInfo.getInstance(), arrayList13);
        J(ExportLogActionInfo.getInstance(), arrayList13);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_logging), R.drawable.ic_format_list_bulleted_white_24dp, arrayList13));
        ArrayList arrayList14 = new ArrayList();
        J(DisableCategoryActionInfo.getInstance(), arrayList14);
        J(ExportMacrosActionInfo.getInstance(), arrayList14);
        J(MacroDroidSettingActionInfo.getInstance(), arrayList14);
        J(MacroDroidDrawerActionInfo.getInstance(), arrayList14);
        J(SetMacroDroidIconActionInfo.getInstance(), arrayList14);
        J(MacroDroidNotificationTextActionInfo.getInstance(), arrayList14);
        J(OptionDialogActionInfo.getInstance(), arrayList14);
        J(SelectionDialogActionInfo.getInstance(), arrayList14);
        J(SetNotificationBarIconActionInfo.getInstance(), arrayList14);
        J(ConfigureWidgetButtonActionInfo.getInstance(), arrayList14);
        J(SetModeActionInfo.getInstance(), arrayList14);
        J(TextManipulationActionInfo.getInstance(), arrayList14);
        J(TranslateTextActionInfo.getInstance(), arrayList14);
        J(DisableMacrodroidActionInfo.getInstance(), arrayList14);
        J(EmptyActionInfo.getInstance(), arrayList14);
        J(FloatingButtonConfigureActionInfo.getInstance(), arrayList14);
        J(FloatingTextActionInfo.getInstance(), arrayList14);
        boolean z5 = macro instanceof ActionBlock;
        if (!z5) {
            J(WaitUntilTriggerActionInfo.getInstance(), arrayList14);
        }
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_macrodroid_specific), R.drawable.ic_category_macrodroid, arrayList14));
        ArrayList arrayList15 = new ArrayList();
        J(JsonOutputActionInfo.getInstance(), arrayList15);
        J(JsonParseActionInfo.getInstance(), arrayList15);
        J(HttpRequestActionInfo.getInstance(), arrayList15);
        J(UDPCommandActionInfo.getInstance(), arrayList15);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_web_interactions), R.drawable.ic_web_white_24dp, arrayList15));
        if (!z4) {
            ArrayList arrayList16 = new ArrayList();
            J(IfConditionActionInfo.getInstance(), arrayList16);
            J(IfConfirmedThenActionInfo.getInstance(), arrayList16);
            J(LoopActionInfo.getInstance(), arrayList16);
            J(IterateDictionaryActionInfo.getInstance(), arrayList16);
            J(BreakFromLoopActionInfo.getInstance(), arrayList16);
            J(ContinueLoopActionInfo.getInstance(), arrayList16);
            J(ConfirmNextActionInfo.getInstance(), arrayList16);
            arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_macrodroid_condition_loop), R.drawable.ic_repeat_white_24dp, arrayList16));
        }
        ArrayList arrayList17 = new ArrayList();
        J(DisableMacroActionInfo.getInstance(), arrayList17);
        J(ForceMacroRunActionInfo.getInstance(), arrayList17);
        J(DeleteMacroActionInfo.getInstance(), arrayList17);
        J(CancelActiveMacroActionInfo.getInstance(), arrayList17);
        J(PauseActionInfo.getInstance(), arrayList17);
        J(ActionBlockActionInfo.getInstance(), arrayList17);
        if (z5) {
            J(ExitActionBlockActionInfo.getInstance(), arrayList17);
        }
        arrayList.add(new SelectableItemCategory(context.getString(R.string.list_macros), R.drawable.active_icon_new, arrayList17));
        ArrayList arrayList18 = new ArrayList();
        J(SetVariableActionInfo.getInstance(), arrayList18);
        J(ClearVariablesActionInfo.getInstance(), arrayList18);
        J(ClearDictionaryArrayEntryActionInfo.getInstance(), arrayList18);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.variables), R.drawable.ic_help_box, arrayList18));
        ArrayList arrayList19 = new ArrayList();
        J(PlaySoundActionInfo.getInstance(), arrayList19);
        J(ControlMediaActionInfo.getInstance(), arrayList19);
        J(RecordMicrophoneActionInfo.getInstance(), arrayList19);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_media), R.drawable.ic_play_circle_white_24dp, arrayList19));
        ArrayList arrayList20 = new ArrayList();
        J(SetLocationModeActionInfo.getInstance(), arrayList20);
        J(ShareLocationActionInfo.getInstance(), arrayList20);
        J(SetGPSActionInfo.getInstance(), arrayList20);
        J(ForceLocationUpdateActionInfo.getInstance(), arrayList20);
        J(SetLocationUpdateRateActionInfo.getInstance(), arrayList20);
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_location), R.drawable.ic_google_maps_white_24dp, arrayList20));
        ArrayList arrayList21 = new ArrayList();
        J(DisableAppActionInfo.getInstance(), arrayList21);
        J(KillBackgroundAppActionInfo.getInstance(), arrayList21);
        J(LaunchActivityActionInfo.getInstance(), arrayList21);
        J(LaunchShortcutActionInfo.getInstance(), arrayList21);
        J(ClearAppDataActionInfo.getInstance(), arrayList21);
        J(CloseApplicationActionInfo.getInstance(), arrayList21);
        if (com.arlosoft.macrodroid.settings.Settings.areExperimentalFeaturesEnabled(context)) {
            J(LaunchAndPressActionInfo.getInstance(), arrayList21);
        }
        arrayList.add(new SelectableItemCategory(context.getString(R.string.item_category_applications), R.drawable.ic_apps_white_24dp, arrayList21));
        new ArrayList();
        J(LocalePluginActionInfo.getInstance(), arrayList21);
        J(ShellScriptActionInfo.getInstance(), arrayList21);
        J(OpenWebPageActionInfo.getInstance(), arrayList21);
        J(JavaScriptActionInfo.getInstance(), arrayList21);
        final Collator collator = Collator.getInstance(com.arlosoft.macrodroid.settings.Settings.getLocale(context));
        collator.setStrength(0);
        Collections.sort(arrayList, new Comparator() { // from class: com.arlosoft.macrodroid.action.d
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int L;
                L = Action.L(collator, (SelectableItemCategory) obj, (SelectableItemCategory) obj2);
                return L;
            }
        });
        return arrayList;
    }

    public final synchronized void disableActionThreadSafe() {
        synchronized (enabledStateLock) {
            if (this.enabled) {
                doDisable();
                this.enabled = false;
            }
        }
    }

    public final synchronized void enableActionThreadSafe() {
        synchronized (enabledStateLock) {
            if (!this.enabled) {
                doEnable();
                this.enabled = true;
            }
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int getDialogTheme() {
        return R.style.Theme_App_Dialog_Action;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String getLogEntryStart() {
        return LogActivity.ACTION_RUN_TEXT_NEW;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public String[] getRequiredPermissions() {
        if (getConstraints().size() == 0) {
            return getPermissions();
        }
        ArrayList arrayList = new ArrayList();
        String[] permissions = getPermissions();
        if (permissions.length > 0) {
            Collections.addAll(arrayList, permissions);
        }
        for (Constraint constraint : getConstraints()) {
            String[] requiredPermissions = constraint.getRequiredPermissions();
            if (requiredPermissions.length > 0) {
                Collections.addAll(arrayList, requiredPermissions);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void handleOptionsDialogCancelled() {
        Activity activity = getActivity();
        if (activity instanceof EditMacroActivity) {
            ((EditMacroActivity) activity).handleOptionsDialogCancel();
        }
    }

    public void invokeActionWithPermissionCheck(@Nullable TriggerContextInfo triggerContextInfo) {
        if (checkAllPermissions()) {
            invokeAction(triggerContextInfo);
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public IteratorType isChildOfIterateDictionary() {
        int indexOf = getMacro().getActions().indexOf(this);
        if (indexOf < 0) {
            int i4 = 0;
            if (this.m_parentSIGUIDForInsert != 0) {
                while (true) {
                    if (i4 >= this.m_macro.getActions().size()) {
                        break;
                    } else if (this.m_macro.getActions().get(i4).getSIGUID() == this.m_parentSIGUIDForInsert) {
                        indexOf = i4 + 1;
                        break;
                    } else {
                        i4++;
                    }
                }
            } else {
                while (true) {
                    if (i4 >= this.m_macro.getActions().size()) {
                        break;
                    } else if (this.m_macro.getActions().get(i4).getSIGUID() == this.m_parentSIGUID) {
                        indexOf = i4 + 1;
                        break;
                    } else {
                        i4++;
                    }
                }
            }
        }
        return MacroListUtils.isChildOfIterateDictionaryLoop(getMacro().getActions(), indexOf);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01fe  */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void itemComplete() {
        /*
            Method dump skipped, instructions count: 540
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.action.Action.itemComplete():void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public int m() {
        return R.style.Theme_App_Dialog_Action;
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void moveItem(boolean z3) {
        int i4;
        ArrayList<Action> actions = getMacro().getActions();
        if (actions.size() == 0) {
            return;
        }
        int i5 = 0;
        while (true) {
            if (i5 < actions.size()) {
                if (actions.get(i5) == this) {
                    break;
                }
                i5++;
            } else {
                i5 = 0;
                break;
            }
        }
        actions.remove(i5);
        if (z3) {
            i4 = i5 - 1;
        } else {
            i4 = i5 + 1;
        }
        actions.add(Math.max(Math.min(Math.max(i4, 0), actions.size()), 0), this);
    }

    public void onItemSelected(long j4, long j5) {
        this.m_parentSIGUID = j4;
        this.m_parentSIGUIDForInsert = j5;
        onItemSelected();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void secondaryItemConfirmed() {
        itemComplete();
    }

    public void setMacro(Macro macro, @Nullable Macro macro2, boolean z3) {
        setMacro(macro);
    }

    public void testActionWithPermissionCheck(@Nullable TriggerContextInfo triggerContextInfo) {
        SystemLog.logTestAction(getName(), getMacroGuid().longValue());
        if (this instanceof BlockingAction) {
            if (checkAllPermissions()) {
                ((BlockingAction) this).invokeAction(triggerContextInfo, 0, true, new Stack<>(), null, true);
                return;
            }
            return;
        }
        invokeActionWithPermissionCheck(triggerContextInfo);
    }

    public void testActionWithPermissionCheckAndConstraints(@Nullable TriggerContextInfo triggerContextInfo) {
        if (constraintsMet(triggerContextInfo)) {
            testActionWithPermissionCheck(triggerContextInfo);
        } else {
            ToastCompat.makeText(getContext().getApplicationContext(), (int) R.string.constraint_check_false_not_running, 1).show();
        }
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        super.writeToParcel(parcel, i4);
        parcel.writeLong(this.f2063b);
        parcel.writeLong(this.m_parentSIGUID);
        parcel.writeLong(this.m_parentSIGUIDForInsert);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Action(Parcel parcel) {
        super(parcel);
        this.f2063b = parcel.readLong();
        this.m_parentSIGUID = parcel.readLong();
        this.m_parentSIGUIDForInsert = parcel.readLong();
    }

    @Override // com.arlosoft.macrodroid.common.SelectableItem
    public void setMacro(Macro macro) {
        super.setMacro(macro);
        if (macro != null) {
            this.f2063b = macro.getGUID();
        }
    }

    protected void doDisable() {
    }

    protected void doEnable() {
    }

    public void enableForEditMacro() {
    }

    public void kill() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void invokeAction(@Nullable TriggerContextInfo triggerContextInfo) {
    }
}
