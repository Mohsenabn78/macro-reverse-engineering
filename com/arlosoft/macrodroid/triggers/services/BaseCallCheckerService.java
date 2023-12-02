package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Constants;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.CallBasedTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BaseCallCheckerService extends IntentService {

    /* renamed from: a  reason: collision with root package name */
    private List<Contact> f15415a;

    public BaseCallCheckerService(String str) {
        super(str);
    }

    private void b(String str, CallBasedTrigger callBasedTrigger, Macro macro, List<Macro> list) {
        List<String> groupIds = callBasedTrigger.getGroupIds();
        if (groupIds.size() > 0) {
            StringBuilder sb = new StringBuilder("(");
            for (int i4 = 0; i4 < groupIds.size(); i4++) {
                sb.append(groupIds.get(i4));
                if (i4 < groupIds.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            ContentResolver contentResolver = getContentResolver();
            Cursor query = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"data1", "contact_id"}, "data1 IN " + sb.toString(), null, null);
            ArrayList<String> arrayList = new ArrayList();
            while (query.moveToNext()) {
                String string = query.getString(query.getColumnIndex("contact_id"));
                if (!arrayList.contains(string)) {
                    arrayList.add(string);
                }
            }
            query.close();
            for (String str2 : arrayList) {
                if (Util.compareNumbers(str, Util.getNumbersForContactId(MacroDroidApplication.getInstance(), str2)) && callBasedTrigger.constraintsMet()) {
                    macro.setTriggerThatInvoked(callBasedTrigger);
                    macro.setTriggerContextInfo(new TriggerContextInfo(callBasedTrigger, str));
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        list.add(macro);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void c(String str, CallBasedTrigger callBasedTrigger, Macro macro, List<Macro> list) {
        boolean z3;
        if (str == null) {
            return;
        }
        String number = callBasedTrigger.getNumber();
        String replaceMagicText = MagicText.replaceMagicText(this, number, null, macro);
        boolean z4 = true;
        if (PhoneNumberUtils.compare(replaceMagicText, str)) {
            SystemLog.logVerbose("Basic number compare match. Contact=" + number + ", Incoming=" + str);
            z3 = true;
        } else {
            z3 = false;
        }
        if (!z3) {
            String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, false, true);
            if (WildCardHelper.matches(str, regexPattern, false, true)) {
                SystemLog.logVerbose("Regex number compare match. Regex=" + regexPattern + ", Incoming=" + str);
                if (z4 == callBasedTrigger.getExcludeNumber() && callBasedTrigger.constraintsMet()) {
                    macro.setTriggerThatInvoked(callBasedTrigger);
                    macro.setTriggerContextInfo(new TriggerContextInfo(callBasedTrigger, str));
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        list.add(macro);
                        return;
                    }
                    return;
                }
            }
        }
        z4 = z3;
        if (z4 == callBasedTrigger.getExcludeNumber()) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void g(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Macro macro = (Macro) it.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }

    protected abstract boolean d(Trigger trigger);

    String f(Intent intent) {
        return intent.getStringExtra(Constants.EXTRA_PHONE_NUMBER);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x01ce A[ADDED_TO_REGION, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01d1 A[SYNTHETIC] */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onHandleIntent(android.content.Intent r19) {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.BaseCallCheckerService.onHandleIntent(android.content.Intent):void");
    }

    void e(Intent intent) {
    }
}
