package com.miguelbcr.ui.rx_paparazzo2.interactors;

import android.annotation.SuppressLint;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.sessions.settings.RemoteSettings;
import com.miguelbcr.ui.rx_paparazzo2.entities.Config;
import com.miguelbcr.ui.rx_paparazzo2.entities.FileData;
import com.miguelbcr.ui.rx_paparazzo2.entities.TargetUi;
import io.reactivex.Observable;
import java.io.File;

/* loaded from: classes6.dex */
public final class GetPath extends com.miguelbcr.ui.rx_paparazzo2.interactors.a<FileData> {

    /* renamed from: e  reason: collision with root package name */
    private static final String f36206e = "GetPath";

    /* renamed from: a  reason: collision with root package name */
    private final Config f36207a;

    /* renamed from: b  reason: collision with root package name */
    private final TargetUi f36208b;

    /* renamed from: c  reason: collision with root package name */
    private final DownloadFile f36209c;

    /* renamed from: d  reason: collision with root package name */
    private Uri f36210d;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        String f36211a;

        /* renamed from: b  reason: collision with root package name */
        String f36212b;

        private b() {
        }
    }

    public GetPath(Config config, TargetUi targetUi, DownloadFile downloadFile) {
        this.f36207a = config;
        this.f36208b = targetUi;
        this.f36209c = downloadFile;
    }

    private FileData a(Context context, Uri uri, String str, String[] strArr) {
        Cursor cursor;
        File file;
        Cursor cursor2 = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_data", "_display_name", "mime_type", "title"}, str, strArr, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        String string = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
                        String string2 = cursor.getString(cursor.getColumnIndexOrThrow("_display_name"));
                        String string3 = cursor.getString(cursor.getColumnIndexOrThrow("mime_type"));
                        String string4 = cursor.getString(cursor.getColumnIndexOrThrow("title"));
                        if (string != null) {
                            file = new File(string);
                        } else {
                            file = null;
                        }
                        FileData fileData = new FileData(file, false, string2, string3, string4);
                        cursor.close();
                        return fileData;
                    }
                } catch (Exception unused) {
                    if (cursor != null) {
                        cursor.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    cursor2 = cursor;
                    if (cursor2 != null) {
                        cursor2.close();
                    }
                    throw th;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return null;
        } catch (Exception unused2) {
            cursor = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @SuppressLint({"NewApi"})
    private b b(Uri uri) {
        b bVar = new b();
        String[] split = DocumentsContract.getDocumentId(uri).split(":");
        bVar.f36211a = split[0];
        bVar.f36212b = split[1];
        return bVar;
    }

    private FileData c(Context context) {
        Uri uri;
        try {
            uri = ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(this.f36210d)).longValue());
        } catch (NumberFormatException e4) {
            Log.e(f36206e, e4.getMessage());
            e4.printStackTrace();
            uri = this.f36210d;
        }
        return a(context, uri, null, null);
    }

    private FileData d(Context context) {
        return new FileData(new File(this.f36210d.getPath()), false, ImageUtils.getFileName(this.f36210d.getPath()), ImageUtils.getMimeType(context, this.f36210d));
    }

    @Nullable
    private FileData e(Context context) {
        if (DocumentsContract.isDocumentUri(context, this.f36210d)) {
            if (j(this.f36210d)) {
                b b4 = b(this.f36210d);
                if ("primary".equalsIgnoreCase(b4.f36211a)) {
                    return h(b4);
                }
            } else if (i(this.f36210d)) {
                return c(context);
            } else {
                if (l(this.f36210d)) {
                    return g(context);
                }
            }
        } else if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(this.f36210d.getScheme())) {
            if (!k(context)) {
                return a(context, this.f36210d, null, null);
            }
        } else if ("file".equalsIgnoreCase(this.f36210d.getScheme())) {
            return d(context);
        }
        return null;
    }

    @SuppressLint({"NewApi"})
    private Observable<FileData> f() {
        Context context = this.f36208b.getContext();
        if (this.f36210d != null && context != null) {
            FileData e4 = e(context);
            if (e4 != null && e4.getFile() != null) {
                return Observable.just(e4);
            }
            return this.f36209c.with(this.f36210d, e4).react();
        }
        return null;
    }

    private FileData g(Context context) {
        Uri uri;
        b b4 = b(this.f36210d);
        if ("image".equals(b4.f36211a)) {
            uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        } else if ("video".equals(b4.f36211a)) {
            uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        } else if ("audio".equals(b4.f36211a)) {
            uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        } else {
            uri = null;
        }
        return a(context, uri, "_id=?", new String[]{b4.f36212b});
    }

    private FileData h(b bVar) {
        String mimeType = ImageUtils.getMimeType(bVar.f36212b);
        String stripPathFromFilename = ImageUtils.stripPathFromFilename(bVar.f36212b);
        return new FileData(new File(Environment.getExternalStorageDirectory() + RemoteSettings.FORWARD_SLASH_STRING + bVar.f36212b), false, stripPathFromFilename, mimeType);
    }

    private boolean i(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    private boolean j(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    private boolean k(Context context) {
        return this.f36210d.getPath().startsWith(this.f36207a.getFileProviderAuthority(context));
    }

    private boolean l(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public Observable<FileData> react() {
        return f();
    }

    public GetPath with(Uri uri) {
        this.f36210d = uri;
        return this;
    }
}
