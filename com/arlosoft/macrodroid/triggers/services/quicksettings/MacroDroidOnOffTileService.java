package com.arlosoft.macrodroid.triggers.services.quicksettings;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;
import androidx.annotation.RequiresApi;
import com.arlosoft.macrodroid.MacroDroidService;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.events.EventBusUtils;
import com.arlosoft.macrodroid.events.MacroDroidDisabledEvent;
import com.arlosoft.macrodroid.events.MacroDroidEnabledEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.settings.Settings;
import com.arlosoft.macrodroid.triggers.services.FloatingTextService;

@RequiresApi(api = 24)
/* loaded from: classes3.dex */
public class MacroDroidOnOffTileService extends TileService {
    private void a() {
        Tile qsTile = getQsTile();
        if (qsTile != null) {
            if (Settings.getMacroDroidEnabled(this)) {
                qsTile.setLabel(getString(R.string.enabled));
                qsTile.setState(2);
            } else {
                qsTile.setLabel(getString(R.string.disabled));
                qsTile.setState(1);
            }
            try {
                qsTile.updateTile();
            } catch (Exception e4) {
                SystemLog.logError("Could not update quick settings tile: " + e4.toString());
            }
        }
    }

    @Override // android.service.quicksettings.TileService
    public void onClick() {
        super.onClick();
        FirebaseAnalyticsEventLogger.log("MacroDroid On/Off Tile");
        if (Settings.getMacroDroidEnabled(this)) {
            FloatingTextService.stopService(this);
            MacroDroidService.stopService(this);
            Settings.setMacroDroidEnabled(this, false);
            Macro.setMacroDroidEnabledState(false);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
            EventBusUtils.getEventBus().post(new MacroDroidDisabledEvent());
        } else {
            MacroDroidService.startService(this);
            Macro.setMacroDroidEnabledState(true);
            MacroStore.getInstance().updateEnabledStateOfAllCompletedMacros();
            Settings.setMacroDroidEnabled(this, true);
            EventBusUtils.getEventBus().post(new MacroDroidEnabledEvent());
        }
        a();
    }

    @Override // android.service.quicksettings.TileService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.service.quicksettings.TileService
    public void onStartListening() {
        a();
    }

    @Override // android.service.quicksettings.TileService
    public void onTileAdded() {
        super.onTileAdded();
        a();
    }
}
