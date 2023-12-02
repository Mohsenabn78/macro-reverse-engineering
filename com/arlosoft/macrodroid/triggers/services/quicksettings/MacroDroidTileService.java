package com.arlosoft.macrodroid.triggers.services.quicksettings;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.cache.Cache;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.QuickSettingSetToggleStateEvent;
import com.arlosoft.macrodroid.events.QuickSettingsTilesUpdatedEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import com.arlosoft.macrodroid.quicksettings.QuickSettingButton;
import com.arlosoft.macrodroid.quicksettings.QuickSettingsData;
import com.arlosoft.macrodroid.triggers.QuickSettingsTileTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.services.MacroDroidAccessibilityServiceJellyBean;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

@RequiresApi(api = 24)
/* loaded from: classes3.dex */
public abstract class MacroDroidTileService extends TileService {

    /* renamed from: a  reason: collision with root package name */
    private boolean f15578a;

    /* renamed from: b  reason: collision with root package name */
    private a f15579b;

    private void a() {
        QuickSettingsData quickSettingsData;
        Icon createWithResource;
        Tile qsTile = getQsTile();
        if (qsTile != null && (quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class)) != null) {
            int i4 = 1;
            QuickSettingButton quickSettingButton = quickSettingsData.getQSButtonList().get(tileNumber() - 1);
            this.f15578a = quickSettingButton.isToggle();
            qsTile.setLabel(quickSettingButton.getLabel());
            createWithResource = Icon.createWithResource(this, getImageResourceId(this, quickSettingButton));
            qsTile.setIcon(createWithResource);
            if (quickSettingButton.getToggleOn()) {
                i4 = 2;
            }
            qsTile.setState(i4);
            try {
                qsTile.updateTile();
            } catch (Exception e4) {
                FirebaseAnalyticsEventLogger.logHandledException(e4);
            }
        }
    }

    private boolean b(int i4, int i5) {
        if (i4 == 2) {
            return false;
        }
        if (!this.f15578a) {
            return true;
        }
        if (i4 == 0) {
            if (i5 != 2) {
                return false;
            }
            return true;
        } else if (i5 != 1) {
            return false;
        } else {
            return true;
        }
    }

    public static int getImageResourceId(@NonNull Context context, @NonNull QuickSettingButton quickSettingButton) {
        int image = quickSettingButton.getImage();
        if (quickSettingButton.getImageName() != null) {
            return Util.getResourceIdFromName(context, quickSettingButton.getImageName());
        }
        return image;
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        int state;
        int state2;
        int i4;
        super.onClick();
        Tile qsTile = getQsTile();
        if (qsTile == null) {
            SystemLog.logError("Quick setting tile was null");
        }
        FirebaseAnalyticsEventLogger.log("Quick Settings Tile click");
        Cache cache = MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE);
        QuickSettingsData quickSettingsData = (QuickSettingsData) cache.get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class);
        if (quickSettingsData != null) {
            QuickSettingButton quickSettingButton = quickSettingsData.getQSButtonList().get(tileNumber() - 1);
            boolean collapseOnPress = quickSettingButton.getCollapseOnPress();
            if (this.f15578a) {
                state2 = qsTile.getState();
                if (state2 == 2) {
                    i4 = 1;
                } else {
                    i4 = 2;
                }
                qsTile.setState(i4);
                qsTile.setLabel(quickSettingButton.getLabel());
                qsTile.updateTile();
                quickSettingsData.replaceButton(quickSettingButton, QuickSettingButton.create(quickSettingButton.getLabel(), getImageResourceId(this, quickSettingButton), quickSettingButton.getEnabled(), quickSettingButton.isToggle(), !quickSettingButton.getToggleOn(), quickSettingButton.getCollapseOnPress(), quickSettingButton.getImageName()));
                cache.put(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, quickSettingsData);
            }
            ArrayList arrayList = new ArrayList();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it.hasNext()) {
                        Trigger next = it.next();
                        if ((next instanceof QuickSettingsTileTrigger) && next.constraintsMet()) {
                            QuickSettingsTileTrigger quickSettingsTileTrigger = (QuickSettingsTileTrigger) next;
                            if (quickSettingsTileTrigger.getToggleOption() != 2 && quickSettingsTileTrigger.getTileNumber() == tileNumber()) {
                                int toggleOption = quickSettingsTileTrigger.getToggleOption();
                                state = qsTile.getState();
                                if (b(toggleOption, state)) {
                                    macro.setTriggerThatInvoked(next);
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Macro macro2 = (Macro) it2.next();
                macro2.invokeActions(macro2.getTriggerContextInfo());
            }
            if (collapseOnPress) {
                if (Build.VERSION.SDK_INT >= 31) {
                    if (!Util.isMacroDroidAccessibilityEnabled(this)) {
                        SystemLog.logError("Accessibility service is not enabled");
                        PermissionsHelper.showNeedsSpecialPermission(this, getString(R.string.collapse_status_bar), 4);
                        return;
                    }
                    Intent intent = new Intent(this, MacroDroidAccessibilityServiceJellyBean.class);
                    intent.putExtra(Constants.EXTRA_GLOBAL_CONTROL_TYPE, 15);
                    startService(intent);
                    return;
                }
                sendBroadcast(new Intent("android.intent.action.CLOSE_SYSTEM_DIALOGS"));
                return;
            }
            return;
        }
        SystemLog.logError("Quick button handling failed. Please try creconfiguring your quick buttons via the home screen tile.");
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        this.f15579b = new a(getApplicationContext());
        EventBusUtils.getEventBus().register(this.f15579b);
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        if (this.f15579b != null) {
            EventBusUtils.getEventBus().unregister(this.f15579b);
            this.f15579b = null;
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        super.onStartListening();
        a();
    }

    @Override // android.service.quicksettings.TileService
    public void onTileAdded() {
        super.onTileAdded();
        a();
    }

    public abstract int tileNumber();

    /* loaded from: classes3.dex */
    private class a {

        /* renamed from: a  reason: collision with root package name */
        private WeakReference<Context> f15580a;

        a(Context context) {
            this.f15580a = new WeakReference<>(context);
        }

        public void onEventMainThread(QuickSettingsTilesUpdatedEvent quickSettingsTilesUpdatedEvent) {
            Icon createWithResource;
            Tile qsTile = MacroDroidTileService.this.getQsTile();
            if (qsTile != null) {
                Context context = this.f15580a.get();
                QuickSettingsData quickSettingsData = quickSettingsTilesUpdatedEvent.data;
                if (quickSettingsData == null || context == null) {
                    return;
                }
                QuickSettingButton quickSettingButton = quickSettingsData.getQSButtonList().get(MacroDroidTileService.this.tileNumber() - 1);
                qsTile.setLabel(quickSettingButton.getLabel());
                createWithResource = Icon.createWithResource(context, MacroDroidTileService.getImageResourceId(context, quickSettingButton));
                qsTile.setIcon(createWithResource);
                qsTile.updateTile();
            }
        }

        public void onEventMainThread(QuickSettingSetToggleStateEvent quickSettingSetToggleStateEvent) {
            QuickSettingsData quickSettingsData;
            Icon createWithResource;
            if (quickSettingSetToggleStateEvent.tileNumber != MacroDroidTileService.this.tileNumber() || (quickSettingsData = (QuickSettingsData) MacroDroidApplication.getInstance().getCache(QuickSettingsData.QUICK_SETTINGS_CACHE).get(QuickSettingsData.QUICK_SETTINGS_DATA_KEY, QuickSettingsData.class)) == null) {
                return;
            }
            QuickSettingButton quickSettingButton = quickSettingsData.getQSButtonList().get(MacroDroidTileService.this.tileNumber() - 1);
            Tile qsTile = MacroDroidTileService.this.getQsTile();
            if (quickSettingButton.isToggle()) {
                qsTile.setState(quickSettingSetToggleStateEvent.on ? 2 : 1);
            }
            qsTile.setLabel(quickSettingButton.getLabel());
            MacroDroidTileService macroDroidTileService = MacroDroidTileService.this;
            createWithResource = Icon.createWithResource(macroDroidTileService, MacroDroidTileService.getImageResourceId(macroDroidTileService, quickSettingButton));
            qsTile.setIcon(createWithResource);
            qsTile.updateTile();
        }
    }
}
