package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import androidx.compose.runtime.internal.StabilityInferred;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.CallActiveTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

/* compiled from: SignalOnOffTriggerService.kt */
@StabilityInferred(parameters = 0)
/* loaded from: classes3.dex */
public final class CallStateOffHookService extends IntentService {
    public static final int $stable = 0;

    public CallStateOffHookService() {
        super("CallStateOffHookService");
    }

    private final void a(String str, CallActiveTrigger callActiveTrigger, Macro macro, List<Macro> list) {
        if (str == null) {
            return;
        }
        List<String> groupIds = callActiveTrigger.getGroupIds();
        if (groupIds.size() > 0) {
            StringBuilder sb = new StringBuilder("(");
            int size = groupIds.size();
            for (int i4 = 0; i4 < size; i4++) {
                sb.append(groupIds.get(i4));
                if (i4 < groupIds.size() - 1) {
                    sb.append(",");
                }
            }
            sb.append(")");
            ContentResolver contentResolver = getContentResolver();
            Cursor query = contentResolver.query(ContactsContract.Data.CONTENT_URI, new String[]{"data1", "contact_id"}, "data1 IN " + ((Object) sb), null, null);
            ArrayList<String> arrayList = new ArrayList();
            while (true) {
                Intrinsics.checkNotNull(query);
                if (!query.moveToNext()) {
                    break;
                }
                String contactId = query.getString(query.getColumnIndex("contact_id"));
                if (!arrayList.contains(contactId)) {
                    Intrinsics.checkNotNullExpressionValue(contactId, "contactId");
                    arrayList.add(contactId);
                }
            }
            query.close();
            for (String str2 : arrayList) {
                if (Util.compareNumbers(str, Util.getNumbersForContactId(MacroDroidApplication.Companion.getInstance(), str2)) && callActiveTrigger.constraintsMet()) {
                    macro.setTriggerThatInvoked(callActiveTrigger);
                    macro.setTriggerContextInfo(new TriggerContextInfo(callActiveTrigger, str));
                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                        list.add(macro);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private final void b(String str, CallActiveTrigger callActiveTrigger, Macro macro, List<Macro> list) {
        if (str == null) {
            return;
        }
        String number = callActiveTrigger.getNumber();
        boolean compare = PhoneNumberUtils.compare(number, str);
        if (!compare && WildCardHelper.matches(str, WildCardHelper.getRegexPattern(MagicText.replaceMagicText(this, number, null, macro), false, false), false, false)) {
            compare = true;
        }
        if (compare != callActiveTrigger.getExcludeNumber() && callActiveTrigger.constraintsMet()) {
            macro.setTriggerThatInvoked(callActiveTrigger);
            macro.setTriggerContextInfo(new TriggerContextInfo(callActiveTrigger, str));
            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                list.add(macro);
            }
        }
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(@Nullable Intent intent) {
        String str;
        boolean isExclude;
        boolean z3;
        if (intent != null) {
            str = intent.getStringExtra(SignalOnOffTriggerServiceKt.EXTRA_LAST_CALL_NUMBER_KEY);
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList();
        for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
            Iterator<Trigger> it = macro.getTriggerListWithAwaitingActions().iterator();
            while (true) {
                if (it.hasNext()) {
                    Trigger next = it.next();
                    if (next instanceof CallActiveTrigger) {
                        CallActiveTrigger callActiveTrigger = (CallActiveTrigger) next;
                        if (callActiveTrigger.getOptionType() == 3) {
                            if (next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                macro.setTriggerContextInfo(new TriggerContextInfo(macro.getTriggerThatInvoked(), str));
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        } else if (callActiveTrigger.getOptionType() == 2) {
                            Intrinsics.checkNotNullExpressionValue(macro, "macro");
                            b(str, callActiveTrigger, macro, arrayList);
                        } else if (callActiveTrigger.getOptionType() == 1) {
                            Intrinsics.checkNotNullExpressionValue(macro, "macro");
                            a(str, callActiveTrigger, macro, arrayList);
                        } else {
                            boolean isExclude2 = callActiveTrigger.isExclude();
                            for (Contact contact : callActiveTrigger.getContactList()) {
                                if (contact != null && !Intrinsics.areEqual(contact.getId(), Util.ANY_NUMBER_ID)) {
                                    if (Intrinsics.areEqual(contact.getId(), Util.UNKNOWN_CALLER_ID)) {
                                        if (str == null) {
                                            isExclude = callActiveTrigger.isExclude();
                                        }
                                    } else if (!Intrinsics.areEqual(contact.getId(), Util.ANY_CONTACT_ID) && !Intrinsics.areEqual(contact.getId(), Util.NON_CONTACT_ID)) {
                                        if (Util.compareNumbers(str, Util.getNumbersForContact(MacroDroidApplication.Companion.getInstance(), contact))) {
                                            isExclude = callActiveTrigger.isExclude();
                                        }
                                    } else {
                                        boolean areEqual = Intrinsics.areEqual(contact.getId(), Util.ANY_CONTACT_ID);
                                        Iterator<Contact> it2 = Util.getContacts(MacroDroidApplication.Companion.getInstance()).iterator();
                                        while (true) {
                                            if (it2.hasNext()) {
                                                if (Util.compareNumbers(str, Util.getNumbersForContact(MacroDroidApplication.Companion.getInstance(), it2.next()))) {
                                                    z3 = true;
                                                    break;
                                                }
                                            } else {
                                                z3 = false;
                                                break;
                                            }
                                        }
                                        if (z3 == areEqual) {
                                            isExclude = callActiveTrigger.isExclude();
                                        }
                                    }
                                } else {
                                    isExclude = callActiveTrigger.isExclude();
                                }
                                isExclude2 = !isExclude;
                            }
                            if (isExclude2 && next.constraintsMet()) {
                                macro.setTriggerThatInvoked(next);
                                macro.setTriggerContextInfo(new TriggerContextInfo(macro.getTriggerThatInvoked(), str));
                                if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                    arrayList.add(macro);
                                }
                            }
                        }
                    }
                }
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            Macro macro2 = (Macro) it3.next();
            macro2.invokeActions(macro2.getTriggerContextInfo());
        }
    }
}
