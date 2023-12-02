package com.arlosoft.macrodroid.triggers.services;

import android.app.IntentService;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.arlosoft.macrodroid.common.CalendarEvent;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.macro.Macro;
import com.arlosoft.macrodroid.triggers.CalendarTrigger;
import com.arlosoft.macrodroid.triggers.Trigger;
import com.arlosoft.macrodroid.triggers.TriggerContextInfo;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

/* loaded from: classes3.dex */
public class CheckCalendarService extends IntentService {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a  reason: collision with root package name */
        public Macro f15416a;

        /* renamed from: b  reason: collision with root package name */
        public TriggerContextInfo f15417b;

        public a(Macro macro, TriggerContextInfo triggerContextInfo) {
            this.f15416a = macro;
            this.f15417b = triggerContextInfo;
        }
    }

    public CheckCalendarService() {
        super("CheckCalendarService");
    }

    @Nullable
    private String b(boolean z3, long j4, CalendarTrigger calendarTrigger, ContentResolver contentResolver, HashMap<String, List<CalendarEvent>> hashMap) {
        int i4;
        long j5;
        Cursor query;
        String str;
        Uri.Builder buildUpon = Uri.parse("content://com.android.calendar/instances/when").buildUpon();
        if (calendarTrigger.getCheckInAdvance()) {
            i4 = calendarTrigger.getTimeInAdvanceSeconds();
            j5 = j4 + (i4 * 1000);
        } else {
            i4 = 0;
            j5 = j4;
        }
        if (z3) {
            j5 += TimeZone.getDefault().getOffset(j5);
        }
        ContentUris.appendId(buildUpon, j5);
        ContentUris.appendId(buildUpon, j5);
        String calendarId = calendarTrigger.getCalendarId();
        String calendarName = calendarTrigger.getCalendarName();
        String simpleCalendarName = calendarTrigger.getSimpleCalendarName();
        String account = calendarTrigger.getAccount();
        if (TextUtils.isEmpty(calendarId)) {
            SystemLog.logError("Calendar Trigger - Calendar id is empty (ignoring)");
            return null;
        }
        String str2 = calendarId + "-" + i4;
        List<CalendarEvent> list = hashMap.get(str2);
        if (list == null) {
            list = new ArrayList<>();
        }
        try {
            if (account != null && simpleCalendarName != null) {
                str = "calendar_id=" + calendarId + " OR (calendar_displayName='" + URLEncoder.encode(simpleCalendarName, "UTF-8") + "' AND account_name='" + URLEncoder.encode(account, "UTF-8") + "')";
            } else {
                str = "calendar_id=" + calendarId + " OR calendar_displayName='" + URLEncoder.encode(calendarName.substring(calendarName.indexOf("(") + 1, calendarName.lastIndexOf(")")), "UTF-8") + "'";
            }
            query = contentResolver.query(buildUpon.build(), new String[]{"title", "description", "dtstart", "dtend", "allDay", "availability", "eventLocation", "event_id"}, str, null, null);
        } catch (Exception unused) {
            query = contentResolver.query(buildUpon.build(), new String[]{"title", "description", "dtstart", "dtend", "allDay", "availability", "eventLocation", "event_id"}, "calendar_id=" + calendarId, null, null);
        }
        if (query != null) {
            if (query.getCount() > 0) {
                query.moveToFirst();
                CalendarEvent e4 = e(query);
                if (e4 != null && e4.isAllDay() == z3) {
                    list.add(e4);
                }
                while (query.moveToNext()) {
                    CalendarEvent e5 = e(query);
                    if (e5 != null && e5.isAllDay() == z3) {
                        list.add(e5);
                        SystemLog.logVerbose("Found event in calendar: " + calendarTrigger.getCalendarName() + " (id=" + calendarTrigger.getCalendarId() + ") " + e5.getTitle() + " - " + e5.getDetail());
                    }
                }
            } else {
                SystemLog.logVerbose("No Events found currently in calendar: " + calendarTrigger.getCalendarName() + " (id=" + calendarTrigger.getCalendarId() + ")");
            }
            query.close();
        }
        hashMap.put(str2, list);
        return str2;
    }

    private TriggerContextInfo c(Trigger trigger, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        if (str == null) {
            str10 = "";
        } else {
            str10 = str;
        }
        if (str2 == null) {
            str11 = "";
        } else {
            str11 = str2;
        }
        if (str3 == null) {
            str12 = "";
        } else {
            str12 = str3;
        }
        if (str4 == null) {
            str13 = "";
        } else {
            str13 = str4;
        }
        if (str5 == null) {
            str14 = "";
        } else {
            str14 = str5;
        }
        if (str6 == null) {
            str15 = "";
        } else {
            str15 = str6;
        }
        if (str7 == null) {
            str16 = "";
        } else {
            str16 = str7;
        }
        if (str8 == null) {
            str17 = "";
        } else {
            str17 = str8;
        }
        if (str9 == null) {
            str18 = "";
        } else {
            str18 = str9;
        }
        return new TriggerContextInfo(trigger, str10, str11, str12, str13, str14, str15, str16, str17, str18);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            aVar.f15416a.invokeActions(aVar.f15417b);
        }
    }

    private static CalendarEvent e(Cursor cursor) {
        return new CalendarEvent(cursor.getString(0), cursor.getString(1), new Date(cursor.getLong(2)), new Date(cursor.getLong(3)), !cursor.getString(4).equals("0"), cursor.getInt(5), cursor.getString(6), cursor.getString(7));
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x036b A[Catch: SecurityException -> 0x04c4, TryCatch #0 {SecurityException -> 0x04c4, blocks: (B:3:0x0002, B:4:0x0032, B:6:0x0038, B:7:0x0047, B:9:0x004d, B:11:0x0058, B:13:0x0071, B:17:0x0088, B:19:0x00a3, B:20:0x00a8, B:21:0x00ad, B:23:0x00b3, B:27:0x00dd, B:28:0x00e1, B:30:0x00e7, B:33:0x00f1, B:35:0x00f7, B:69:0x0192, B:71:0x0198, B:73:0x021f, B:75:0x0245, B:76:0x024f, B:39:0x0102, B:41:0x0108, B:44:0x0114, B:46:0x011a, B:48:0x0120, B:50:0x0137, B:57:0x0153, B:59:0x0159, B:61:0x015f, B:63:0x0176, B:80:0x02b7, B:81:0x02ce, B:83:0x02d4, B:86:0x02de, B:88:0x02e4, B:118:0x0380, B:120:0x0386, B:122:0x038c, B:124:0x0392, B:126:0x0410, B:128:0x0436, B:129:0x0440, B:91:0x02f4, B:93:0x02fb, B:97:0x030a, B:99:0x0314, B:101:0x031a, B:103:0x0331, B:108:0x0347, B:110:0x034f, B:112:0x0355, B:114:0x036b, B:136:0x04aa), top: B:140:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0192 A[Catch: SecurityException -> 0x04c4, TryCatch #0 {SecurityException -> 0x04c4, blocks: (B:3:0x0002, B:4:0x0032, B:6:0x0038, B:7:0x0047, B:9:0x004d, B:11:0x0058, B:13:0x0071, B:17:0x0088, B:19:0x00a3, B:20:0x00a8, B:21:0x00ad, B:23:0x00b3, B:27:0x00dd, B:28:0x00e1, B:30:0x00e7, B:33:0x00f1, B:35:0x00f7, B:69:0x0192, B:71:0x0198, B:73:0x021f, B:75:0x0245, B:76:0x024f, B:39:0x0102, B:41:0x0108, B:44:0x0114, B:46:0x011a, B:48:0x0120, B:50:0x0137, B:57:0x0153, B:59:0x0159, B:61:0x015f, B:63:0x0176, B:80:0x02b7, B:81:0x02ce, B:83:0x02d4, B:86:0x02de, B:88:0x02e4, B:118:0x0380, B:120:0x0386, B:122:0x038c, B:124:0x0392, B:126:0x0410, B:128:0x0436, B:129:0x0440, B:91:0x02f4, B:93:0x02fb, B:97:0x030a, B:99:0x0314, B:101:0x031a, B:103:0x0331, B:108:0x0347, B:110:0x034f, B:112:0x0355, B:114:0x036b, B:136:0x04aa), top: B:140:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0282  */
    @Override // android.app.IntentService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void onHandleIntent(android.content.Intent r35) {
        /*
            Method dump skipped, instructions count: 1226
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.triggers.services.CheckCalendarService.onHandleIntent(android.content.Intent):void");
    }
}
