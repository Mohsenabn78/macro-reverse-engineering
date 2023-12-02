package com.arlosoft.macrodroid.triggers.services;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.arlosoft.macrodroid.app.MacroDroidApplication;
import com.arlosoft.macrodroid.common.Contact;
import com.arlosoft.macrodroid.common.IncomingSMS;
import com.arlosoft.macrodroid.common.MagicText;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.macro.MacroStore;
import com.arlosoft.macrodroid.triggers.IncomingSMSTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import com.arlosoft.macrodroid.utils.WildCardHelper;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class IncomingSMSUtil {
    private static boolean b(Context context, IncomingSMSTrigger incomingSMSTrigger, String str, boolean z3, boolean z4) {
        if (incomingSMSTrigger.getContent() == null) {
            return true;
        }
        String replaceMagicText = MagicText.replaceMagicText(context, incomingSMSTrigger.getContent(), null, incomingSMSTrigger.getMacro());
        String regexPattern = WildCardHelper.getRegexPattern(replaceMagicText, z3, z4);
        String regexContainsPattern = WildCardHelper.getRegexContainsPattern(replaceMagicText, z3, z4);
        if (incomingSMSTrigger.isExcludes()) {
            return !WildCardHelper.matches(str, regexContainsPattern, z3, z4);
        }
        if (incomingSMSTrigger.isExactMatch()) {
            return WildCardHelper.matches(str, regexPattern, z3, z4);
        }
        return WildCardHelper.matches(str, regexContainsPattern, z3, z4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00b3, code lost:
        if (b(r15, r17, r20, r17.isEnableRegex(), r17.isIgnoreCase()) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00b9, code lost:
        if (r17.constraintsMet() == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00bb, code lost:
        r18.setTriggerThatInvoked(r17);
        r18.setTriggerContextInfo(new com.arlosoft.macrodroid.triggers.TriggerContextInfo(r17, r21));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00d0, code lost:
        if (r18.canInvoke(r18.getTriggerContextInfo()) == false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00d2, code lost:
        r19.add(r18);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00d7, code lost:
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean c(android.content.Context r15, java.lang.String r16, com.arlosoft.macrodroid.triggers.IncomingSMSTrigger r17, com.arlosoft.macrodroid.macro.Macro r18, java.util.List<com.arlosoft.macrodroid.macro.Macro> r19, java.lang.String r20, com.arlosoft.macrodroid.common.IncomingSMS r21) {
        /*
            r0 = r15
            r1 = r17
            r2 = r18
            java.util.List r3 = r17.getGroupIds()
            int r4 = r3.size()
            r5 = 0
            if (r4 <= 0) goto Le8
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "("
            r4.<init>(r6)
            r6 = 0
        L18:
            int r7 = r3.size()
            r8 = 1
            if (r6 >= r7) goto L37
            java.lang.Object r7 = r3.get(r6)
            java.lang.String r7 = (java.lang.String) r7
            r4.append(r7)
            int r7 = r3.size()
            int r7 = r7 - r8
            if (r6 >= r7) goto L34
            java.lang.String r7 = ","
            r4.append(r7)
        L34:
            int r6 = r6 + 1
            goto L18
        L37:
            java.lang.String r3 = ")"
            r4.append(r3)
            android.net.Uri r10 = android.provider.ContactsContract.Data.CONTENT_URI
            java.lang.String r3 = "data1"
            java.lang.String r6 = "contact_id"
            java.lang.String[] r11 = new java.lang.String[]{r3, r6}
            android.content.ContentResolver r9 = r15.getContentResolver()     // Catch: java.lang.SecurityException -> Ldf
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> Ldf
            r3.<init>()     // Catch: java.lang.SecurityException -> Ldf
            java.lang.String r7 = "data1 IN "
            r3.append(r7)     // Catch: java.lang.SecurityException -> Ldf
            java.lang.String r4 = r4.toString()     // Catch: java.lang.SecurityException -> Ldf
            r3.append(r4)     // Catch: java.lang.SecurityException -> Ldf
            java.lang.String r12 = r3.toString()     // Catch: java.lang.SecurityException -> Ldf
            r13 = 0
            r14 = 0
            android.database.Cursor r3 = r9.query(r10, r11, r12, r13, r14)     // Catch: java.lang.SecurityException -> Ldf
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.SecurityException -> Ldf
            r4.<init>()     // Catch: java.lang.SecurityException -> Ldf
            if (r3 == 0) goto L81
        L6c:
            boolean r7 = r3.moveToNext()     // Catch: java.lang.SecurityException -> Ldf
            if (r7 == 0) goto L7e
            int r7 = r3.getColumnIndex(r6)     // Catch: java.lang.SecurityException -> Ldf
            java.lang.String r7 = r3.getString(r7)     // Catch: java.lang.SecurityException -> Ldf
            r4.add(r7)     // Catch: java.lang.SecurityException -> Ldf
            goto L6c
        L7e:
            r3.close()     // Catch: java.lang.SecurityException -> Ldf
        L81:
            java.util.List r3 = com.arlosoft.macrodroid.common.Util.getContactsWithIds(r15, r4)     // Catch: java.lang.SecurityException -> Ldf
            java.util.Iterator r3 = r3.iterator()     // Catch: java.lang.SecurityException -> Ldf
        L89:
            boolean r4 = r3.hasNext()     // Catch: java.lang.SecurityException -> Ldf
            if (r4 == 0) goto Le8
            java.lang.Object r4 = r3.next()     // Catch: java.lang.SecurityException -> Ldf
            com.arlosoft.macrodroid.common.Contact r4 = (com.arlosoft.macrodroid.common.Contact) r4     // Catch: java.lang.SecurityException -> Ldf
            com.arlosoft.macrodroid.app.MacroDroidApplication r6 = com.arlosoft.macrodroid.app.MacroDroidApplication.getInstance()     // Catch: java.lang.SecurityException -> Ldf
            java.util.List r4 = com.arlosoft.macrodroid.common.Util.getNumbersForContact(r6, r4)     // Catch: java.lang.SecurityException -> Ldf
            r6 = r16
            boolean r4 = com.arlosoft.macrodroid.common.Util.compareNumbers(r6, r4)     // Catch: java.lang.SecurityException -> Ldf
            if (r4 == 0) goto Ld8
            boolean r3 = r17.isEnableRegex()     // Catch: java.lang.SecurityException -> Ldf
            boolean r4 = r17.isIgnoreCase()     // Catch: java.lang.SecurityException -> Ldf
            r7 = r20
            boolean r3 = b(r15, r1, r7, r3, r4)     // Catch: java.lang.SecurityException -> Ldf
            if (r3 == 0) goto Le8
            boolean r3 = r17.constraintsMet()     // Catch: java.lang.SecurityException -> Ldf
            if (r3 == 0) goto Le8
            r2.setTriggerThatInvoked(r1)     // Catch: java.lang.SecurityException -> Ldf
            com.arlosoft.macrodroid.triggers.TriggerContextInfo r3 = new com.arlosoft.macrodroid.triggers.TriggerContextInfo     // Catch: java.lang.SecurityException -> Ldf
            r4 = r21
            r3.<init>(r1, r4)     // Catch: java.lang.SecurityException -> Ldf
            r2.setTriggerContextInfo(r3)     // Catch: java.lang.SecurityException -> Ldf
            com.arlosoft.macrodroid.triggers.TriggerContextInfo r1 = r18.getTriggerContextInfo()     // Catch: java.lang.SecurityException -> Ldf
            boolean r1 = r2.canInvoke(r1)     // Catch: java.lang.SecurityException -> Ldf
            if (r1 == 0) goto Le8
            r9 = r19
            r9.add(r2)     // Catch: java.lang.SecurityException -> Ldf
            return r8
        Ld8:
            r9 = r19
            r7 = r20
            r4 = r21
            goto L89
        Ldf:
            java.lang.String r1 = "android.permission.READ_CONTACTS"
            java.lang.String r2 = r18.getName()
            com.arlosoft.macrodroid.permissions.PermissionsHelper.showNeedsPermission(r15, r1, r2, r8, r5)
        Le8:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.IncomingSMSUtil.c(android.content.Context, java.lang.String, com.arlosoft.macrodroid.triggers.IncomingSMSTrigger, com.arlosoft.macrodroid.macro.Macro, java.util.List, java.lang.String, com.arlosoft.macrodroid.common.IncomingSMS):boolean");
    }

    public static synchronized void checkMessage(Context context, String str, String str2, String str3, int i4) {
        Iterator<Contact> it;
        boolean z3;
        synchronized (IncomingSMSUtil.class) {
            final ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            for (Macro macro : MacroStore.getInstance().getEnabledMacros()) {
                Iterator<Trigger> it2 = macro.getTriggerListWithAwaitingActions().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        Trigger next = it2.next();
                        if (next instanceof IncomingSMSTrigger) {
                            IncomingSMSTrigger incomingSMSTrigger = (IncomingSMSTrigger) next;
                            if (incomingSMSTrigger.getSubscriptionId() != -1 && incomingSMSTrigger.getSubscriptionId() != i4) {
                            }
                            IncomingSMS incomingSMS = new IncomingSMS(str3, str2, str);
                            String replaceMagicText = MagicText.replaceMagicText(context.getApplicationContext(), str2, null, macro);
                            if (incomingSMSTrigger.getOptionType() == 3) {
                                if (incomingSMSTrigger.constraintsMet() && b(context, incomingSMSTrigger, replaceMagicText, incomingSMSTrigger.isEnableRegex(), incomingSMSTrigger.isIgnoreCase())) {
                                    macro.setTriggerThatInvoked(incomingSMSTrigger);
                                    macro.setTriggerContextInfo(new TriggerContextInfo(incomingSMSTrigger, incomingSMS));
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                        break;
                                    }
                                }
                            } else if (incomingSMSTrigger.getOptionType() == 2) {
                                if (d(context, str, incomingSMSTrigger, macro, arrayList, replaceMagicText, incomingSMS)) {
                                    break;
                                }
                            } else if (incomingSMSTrigger.getOptionType() == 1) {
                                if (c(context, str, incomingSMSTrigger, macro, arrayList, replaceMagicText, incomingSMS)) {
                                    break;
                                }
                            } else {
                                List<Contact> contactList = incomingSMSTrigger.getContactList();
                                boolean isExcludeContact = ((IncomingSMSTrigger) next).isExcludeContact();
                                Iterator<Contact> it3 = contactList.iterator();
                                boolean z4 = isExcludeContact;
                                List<Contact> list = null;
                                while (it3.hasNext()) {
                                    Contact next2 = it3.next();
                                    if (next2 != null && next2.getId() != null) {
                                        it = it3;
                                        if (!next2.getId().equals(Util.ANY_NUMBER_ID)) {
                                            if (!next2.getId().equals(Util.ANY_CONTACT_ID) && !next2.getId().equals(Util.NON_CONTACT_ID)) {
                                                if (Util.compareNumbers(str, Util.getNumbersForContact(MacroDroidApplication.getInstance(), next2))) {
                                                    z4 = !isExcludeContact;
                                                    break;
                                                }
                                            }
                                            boolean equals = next2.getId().equals(Util.ANY_CONTACT_ID);
                                            if (list == null) {
                                                list = Util.getContacts(context);
                                            }
                                            if (list != null && list.size() > 0) {
                                                Iterator<Contact> it4 = list.iterator();
                                                while (true) {
                                                    if (!it4.hasNext()) {
                                                        z3 = false;
                                                        break;
                                                    }
                                                    Contact next3 = it4.next();
                                                    Iterator<Contact> it5 = it4;
                                                    List<String> list2 = (List) hashMap.get(next3.getId());
                                                    if (list2 == null) {
                                                        list2 = Util.getNumbersForContact(MacroDroidApplication.getInstance(), next3);
                                                        hashMap.put(next3.getId(), list2);
                                                    }
                                                    if (Util.compareNumbers(str, list2)) {
                                                        z3 = true;
                                                        break;
                                                    }
                                                    it4 = it5;
                                                }
                                                if (z3 == equals) {
                                                    z4 = !isExcludeContact;
                                                    break;
                                                }
                                            }
                                        } else {
                                            z4 = true;
                                        }
                                        it3 = it;
                                    }
                                    it = it3;
                                    it3 = it;
                                }
                                if (z4 && next.constraintsMet() && b(context, incomingSMSTrigger, replaceMagicText, incomingSMSTrigger.isEnableRegex(), incomingSMSTrigger.isIgnoreCase())) {
                                    macro.setTriggerThatInvoked(next);
                                    macro.setTriggerContextInfo(new TriggerContextInfo(next, incomingSMS));
                                    if (macro.canInvoke(macro.getTriggerContextInfo())) {
                                        arrayList.add(macro);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.arlosoft.macrodroid.triggers.services.e
                @Override // java.lang.Runnable
                public final void run() {
                    IncomingSMSUtil.e(arrayList);
                }
            });
        }
    }

    private static boolean d(Context context, String str, IncomingSMSTrigger incomingSMSTrigger, Macro macro, List<Macro> list, String str2, IncomingSMS incomingSMS) {
        boolean z3;
        if (str == null) {
            return false;
        }
        String number = incomingSMSTrigger.getNumber();
        String replaceMagicText = MagicText.replaceMagicText(context, number, null, macro);
        PhoneNumberUtil.MatchType isNumberMatch = PhoneNumberUtil.getInstance().isNumberMatch(replaceMagicText, str);
        if (isNumberMatch != PhoneNumberUtil.MatchType.EXACT_MATCH && isNumberMatch != PhoneNumberUtil.MatchType.NSN_MATCH && isNumberMatch != PhoneNumberUtil.MatchType.SHORT_NSN_MATCH) {
            z3 = false;
        } else {
            SystemLog.logVerbose("INCOMING SMS number (" + str + ") matches trigger number (" + number + ")");
            z3 = true;
        }
        if (!z3) {
            if (WildCardHelper.matches(str.toLowerCase(), WildCardHelper.getRegexPattern(replaceMagicText.toLowerCase(), false), false)) {
                SystemLog.logVerbose("INCOMING SMS number (" + str + ") matches trigger number pattern (" + replaceMagicText + ")");
                z3 = true;
            }
        }
        if (!z3) {
            SystemLog.logVerbose("INCOMING SMS number (" + str + ") DOES NOT MATCH NUMBER (" + number + ") or Pattern (" + replaceMagicText + ")");
        }
        if (z3 != incomingSMSTrigger.getExcludeNumber() && b(context, incomingSMSTrigger, str2, incomingSMSTrigger.isEnableRegex(), incomingSMSTrigger.isIgnoreCase()) && incomingSMSTrigger.constraintsMet()) {
            macro.setTriggerThatInvoked(incomingSMSTrigger);
            macro.setTriggerContextInfo(new TriggerContextInfo(incomingSMSTrigger, incomingSMS));
            if (macro.canInvoke(macro.getTriggerContextInfo())) {
                list.add(macro);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void e(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Macro macro = (Macro) it.next();
            macro.invokeActions(macro.getTriggerContextInfo());
        }
    }
}
