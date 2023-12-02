package com.jaredrummler.android.device;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.jaredrummler.android.device.DeviceName;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes6.dex */
public class DeviceDatabase extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final File f34584a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f34585b;

    public DeviceDatabase(Context context) {
        super(context, "android-devices.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f34585b = context.getApplicationContext();
        File databasePath = context.getDatabasePath("android-devices.db");
        this.f34584a = databasePath;
        if (!databasePath.exists()) {
            c();
        }
    }

    private void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    private void c() throws SQLException {
        try {
            getReadableDatabase();
            close();
            d();
        } catch (IOException e4) {
            throw new SQLException("Error creating android-devices.db database", e4);
        }
    }

    private void d() throws IOException {
        InputStream open = this.f34585b.getAssets().open("android-devices.db");
        FileOutputStream fileOutputStream = new FileOutputStream(this.f34584a);
        byte[] bArr = new byte[2048];
        while (true) {
            int read = open.read(bArr);
            if (read > 0) {
                fileOutputStream.write(bArr, 0, read);
            } else {
                fileOutputStream.flush();
                b(fileOutputStream);
                b(open);
                return;
            }
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i4, int i5) {
        if (i5 > i4) {
            if (this.f34585b.deleteDatabase("android-devices.db") || this.f34584a.delete() || !this.f34584a.exists()) {
                c();
            }
        }
    }

    public String query(@Nullable String str, @Nullable String str2) {
        String[] strArr;
        String str3;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String[] strArr2 = {"name"};
        String str4 = null;
        if (str != null && str2 != null) {
            strArr = new String[]{str, str2};
            str3 = "codename LIKE ? OR model LIKE ?";
        } else if (str != null) {
            str3 = "codename LIKE ?";
            strArr = new String[]{str};
        } else {
            if (str2 != null) {
                strArr = new String[]{str2};
                str3 = "model LIKE ?";
            }
            return str4;
        }
        Cursor query = readableDatabase.query("devices", strArr2, str3, strArr, null, null, null);
        if (query.moveToFirst()) {
            str4 = query.getString(query.getColumnIndexOrThrow("name"));
        }
        b(query);
        b(readableDatabase);
        return str4;
    }

    public DeviceName.DeviceInfo queryToDevice(@Nullable String str, @Nullable String str2) {
        String[] strArr;
        String str3;
        SQLiteDatabase readableDatabase = getReadableDatabase();
        String[] strArr2 = {"name", "codename", "model"};
        DeviceName.DeviceInfo deviceInfo = null;
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            str3 = "codename LIKE ? OR model LIKE ?";
            strArr = new String[]{str, str2};
        } else if (!TextUtils.isEmpty(str)) {
            str3 = "codename LIKE ?";
            strArr = new String[]{str};
        } else {
            if (TextUtils.isEmpty(str2)) {
                strArr = new String[]{str2};
                str3 = "model LIKE ?";
            }
            return deviceInfo;
        }
        Cursor query = readableDatabase.query("devices", strArr2, str3, strArr, null, null, null);
        if (query.moveToFirst()) {
            deviceInfo = new DeviceName.DeviceInfo(query.getString(query.getColumnIndexOrThrow("name")), query.getString(query.getColumnIndexOrThrow("codename")), query.getString(query.getColumnIndexOrThrow("model")));
        }
        b(query);
        b(readableDatabase);
        return deviceInfo;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
    }
}
