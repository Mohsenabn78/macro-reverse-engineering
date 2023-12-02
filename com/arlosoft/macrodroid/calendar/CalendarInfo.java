package com.arlosoft.macrodroid.calendar;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.core.util.Pair;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import dev.skomlach.biometric.compat.engine.internal.face.miui.impl.Miui3DFaceManagerImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes3.dex */
public class CalendarInfo implements Comparable<CalendarInfo> {
    public String id;
    public String name;
    public String ownerAccount;

    public CalendarInfo(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        this.id = str;
        this.name = str2;
        this.ownerAccount = str3;
    }

    public static Pair<String, List<CalendarInfo>> getAllCalendars(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        String str = null;
        try {
            Cursor query = contentResolver.query(Uri.parse("content://com.android.calendar/calendars"), new String[]{Miui3DFaceManagerImpl.TABLE_TEMPLATE_COLUMN_ID, "calendar_displayName", "account_name", "visible"}, null, null, null);
            ArrayList arrayList = new ArrayList();
            if (query != null) {
                while (query.moveToNext()) {
                    String string = query.getString(0);
                    CalendarInfo calendarInfo = new CalendarInfo(string, query.getString(1), query.getString(2));
                    if (!arrayList.contains(calendarInfo)) {
                        arrayList.add(calendarInfo);
                        if (str == null) {
                            str = string;
                        }
                    }
                }
                query.close();
            }
            Collections.sort(arrayList);
            return new Pair<>(str, arrayList);
        } catch (SecurityException unused) {
            SystemLog.logError("Failed to get calendars - missing ");
            return new Pair<>(null, new ArrayList());
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof CalendarInfo)) {
            return false;
        }
        CalendarInfo calendarInfo = (CalendarInfo) obj;
        if (!this.name.equals(calendarInfo.name) || !this.ownerAccount.equals(calendarInfo.ownerAccount)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Comparable
    public int compareTo(@NonNull CalendarInfo calendarInfo) {
        String str;
        String str2 = this.ownerAccount;
        if (str2 != null && (str = calendarInfo.ownerAccount) != null && !str2.equals(str)) {
            return this.ownerAccount.compareTo(calendarInfo.ownerAccount);
        }
        return this.name.compareTo(calendarInfo.name);
    }
}
