package com.arlosoft.macrodroid.common;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.provider.CalendarContract;
import androidx.core.content.ContextCompat;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.permissions.PermissionsHelper;
import java.util.TimeZone;
import me.drakeet.support.toast.ToastCompat;

/* loaded from: classes3.dex */
public class CalendarHelper {
    @SuppressLint({"NewApi", "InlinedApi"})
    public static void addToCalendar(Context context, String str, String str2, String str3, long j4, long j5, boolean z3, int i4) {
        long j6;
        long j7 = j4;
        TimeZone timeZone = TimeZone.getDefault();
        ContentValues contentValues = new ContentValues();
        if (z3) {
            long offset = j7 + timeZone.getOffset(j7);
            j7 = offset - (offset % 86400000);
            j6 = 86400000 + j7;
            contentValues.put("allDay", (Integer) 1);
        } else {
            j6 = j7 + j5;
        }
        if (str != null) {
            try {
                contentValues.put("calendar_id", Integer.valueOf(str));
            } catch (Exception unused) {
            }
        } else {
            contentValues.put("calendar_id", (Integer) 1);
        }
        contentValues.put("dtstart", Long.valueOf(j7));
        contentValues.put("dtend", Long.valueOf(j6));
        contentValues.put("title", str2);
        contentValues.put("description", str3);
        contentValues.put("eventTimezone", timeZone.getID());
        contentValues.put("availability", Integer.valueOf(i4));
        try {
            if (ContextCompat.checkSelfPermission(context, "android.permission.WRITE_CALENDAR") != 0) {
                PermissionsHelper.showNeedsPermission(context, "android.permission.WRITE_CALENDAR", context.getString(R.string.action_add_calendar_event), true, false);
            } else {
                context.getApplicationContext().getContentResolver().insert(CalendarContract.Events.CONTENT_URI, contentValues);
            }
        } catch (SQLiteException e4) {
            SystemLog.logError("Could not write to the calendar: " + e4.toString());
            ToastCompat.makeText(context.getApplicationContext(), (int) R.string.error, 0).show();
        } catch (IllegalArgumentException unused2) {
            SystemLog.logError("Could not resolve the calendar on this device");
            ToastCompat.makeText(context.getApplicationContext(), (int) R.string.error, 0).show();
        }
    }
}
