package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.Intent;
import android.nfc.NdefMessage;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.util.Log;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.NFCTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class NFCTriggeredService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private Handler f15501a;

    public NFCTriggeredService() {
        super("NFCTriggeredService");
        this.f15501a = new Handler(Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void b(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Macro macro = (Macro) it.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        String str;
        Parcelable[] parcelableArrayExtra = intent.getParcelableArrayExtra("android.nfc.extra.NDEF_MESSAGES");
        if (parcelableArrayExtra != null) {
            NdefMessage[] ndefMessageArr = new NdefMessage[parcelableArrayExtra.length];
            final ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < parcelableArrayExtra.length; i4++) {
                NdefMessage ndefMessage = (NdefMessage) parcelableArrayExtra[i4];
                ndefMessageArr[i4] = ndefMessage;
                try {
                    str = new String(ndefMessage.getRecords()[0].getType()).substring(17);
                } catch (Exception unused) {
                    Log.w("NFCTriggeredService", "Exeption while obtaining tag name");
                    str = "";
                }
                FirebaseAnalyticsEventLogger.log("NFC Trigger service");
                for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                    Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Trigger next = it.next();
                        if (next == null) {
                            FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("Null Trigger detected in NFCTriggeredService"));
                        } else if (next instanceof NFCTrigger) {
                            NFCTrigger nFCTrigger = (NFCTrigger) next;
                            if (nFCTrigger.getTagName() != null && nFCTrigger.getTagName().equals(str) && next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        } else {
                            continue;
                        }
                    }
                }
            }
            if (arrayList.size() > 0) {
                this.f15501a.post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.services.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        NFCTriggeredService.b(arrayList);
                    }
                });
            }
        }
    }

    public NFCTriggeredService(String str) {
        super(str);
        this.f15501a = new Handler(Looper.getMainLooper());
    }
}
