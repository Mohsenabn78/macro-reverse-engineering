package com.arlosoft.macrodroid.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.common.Constants;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class FileUtils {
    public static final String MIME_TYPE_APP = "application/*";
    public static final String MIME_TYPE_AUDIO = "audio/*";
    public static final String MIME_TYPE_TEXT = "text/*";
    public static final String MIME_TYPE_VIDEO = "video/*";

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<File> f16024a = new Comparator() { // from class: com.arlosoft.macrodroid.utils.j
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int j4;
            j4 = FileUtils.j((File) obj, (File) obj2);
            return j4;
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private static final FileFilter f16025b = new FileFilter() { // from class: com.arlosoft.macrodroid.utils.k
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            boolean k4;
            k4 = FileUtils.k(file);
            return k4;
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private static final FileFilter f16026c = new FileFilter() { // from class: com.arlosoft.macrodroid.utils.l
        @Override // java.io.FileFilter
        public final boolean accept(File file) {
            boolean l4;
            l4 = FileUtils.l(file);
            return l4;
        }
    };

    public static void addFileStreamToIntent(Context context, Intent intent, File file) {
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, context.getPackageName() + ".provider", file));
    }

    public static void copyFile(File file, File file2) throws IOException {
        FileChannel fileChannel;
        if (!file2.exists()) {
            file2.createNewFile();
        }
        FileChannel fileChannel2 = 0;
        try {
            FileChannel channel = new FileInputStream(file).getChannel();
            try {
                fileChannel2 = new FileOutputStream(file2).getChannel();
                fileChannel2.transferFrom(channel, 0L, channel.size());
                channel.close();
                fileChannel2.close();
            } catch (Throwable th) {
                th = th;
                FileChannel fileChannel3 = fileChannel2;
                fileChannel2 = channel;
                fileChannel = fileChannel3;
                if (fileChannel2 != null) {
                    fileChannel2.close();
                }
                if (fileChannel != null) {
                    fileChannel.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            fileChannel = null;
        }
    }

    public static Intent createGetContentIntent() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        return intent;
    }

    private static File d(String str, String str2) {
        String str3 = RemoteSettings.FORWARD_SLASH_STRING;
        if (str.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
            str3 = "";
        }
        return new File(str + str3 + str2);
    }

    public static Bitmap decodeBitmapFromUserIconFile(String str) {
        if (str == null) {
            return null;
        }
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile == null) {
            return BitmapFactory.decodeFile(str.replace(Constants.USER_ICON_DIR, "MacroDroid/UserIcons"));
        }
        return decodeFile;
    }

    private static String e(Context context, File file) {
        MimeTypes f4 = f(context);
        if (file != null) {
            return f4.getMimeType(file.getName());
        }
        return null;
    }

    private static MimeTypes f(Context context) {
        try {
            return new r().b(context.getResources().getXml(R.xml.mimetypes));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x005a, code lost:
        if (r9 == null) goto L31;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static android.graphics.Bitmap g(android.content.Context r8, android.net.Uri r9, java.lang.String r10) {
        /*
            boolean r0 = i(r9)
            r1 = 0
            if (r0 == 0) goto Lf
            java.lang.String r8 = "FileUtils"
            java.lang.String r9 = "You can only retrieve thumbnails for images and videos."
            android.util.Log.e(r8, r9)
            return r1
        Lf:
            if (r9 == 0) goto L5d
            android.content.ContentResolver r8 = r8.getContentResolver()
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r8
            r3 = r9
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L58
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            if (r0 == 0) goto L48
            r0 = 0
            int r0 = r9.getInt(r0)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            java.lang.String r2 = "video"
            boolean r2 = r10.contains(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            r3 = 1
            if (r2 == 0) goto L3a
            long r4 = (long) r0     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            android.graphics.Bitmap r8 = android.provider.MediaStore.Video.Thumbnails.getThumbnail(r8, r4, r3, r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
        L38:
            r1 = r8
            goto L48
        L3a:
            java.lang.String r2 = "image/*"
            boolean r10 = r10.contains(r2)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            if (r10 == 0) goto L48
            long r4 = (long) r0     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            android.graphics.Bitmap r8 = android.provider.MediaStore.Images.Thumbnails.getThumbnail(r8, r4, r3, r1)     // Catch: java.lang.Throwable -> L4c java.lang.Exception -> L4f
            goto L38
        L48:
            r9.close()
            goto L5d
        L4c:
            r8 = move-exception
            r1 = r9
            goto L52
        L4f:
            goto L5a
        L51:
            r8 = move-exception
        L52:
            if (r1 == 0) goto L57
            r1.close()
        L57:
            throw r8
        L58:
            r9 = r1
        L5a:
            if (r9 == 0) goto L5d
            goto L48
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.utils.FileUtils.g(android.content.Context, android.net.Uri, java.lang.String):android.graphics.Bitmap");
    }

    public static String getExtension(String str) {
        if (str == null) {
            return null;
        }
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            return str.substring(lastIndexOf);
        }
        return "";
    }

    public static File getFile(Uri uri) {
        String path;
        if (uri == null || (path = uri.getPath()) == null) {
            return null;
        }
        return new File(path);
    }

    public static List<File> getFileList(String str) {
        ArrayList arrayList = new ArrayList();
        File file = new File(str);
        File[] listFiles = file.listFiles(f16026c);
        if (listFiles != null) {
            Arrays.sort(listFiles, f16024a);
            Collections.addAll(arrayList, listFiles);
        }
        File[] listFiles2 = file.listFiles(f16025b);
        if (listFiles2 != null) {
            Arrays.sort(listFiles2, f16024a);
            Collections.addAll(arrayList, listFiles2);
        }
        return arrayList;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (r8 == null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getPath(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = r9.getScheme()
            java.lang.String r1 = "content"
            boolean r0 = r1.equalsIgnoreCase(r0)
            r1 = 0
            if (r0 == 0) goto L45
            java.lang.String r0 = "_data"
            java.lang.String[] r4 = new java.lang.String[]{r0}
            android.content.ContentResolver r2 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r9
            android.database.Cursor r8 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L36 java.lang.Exception -> L3d
            int r9 = r8.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            boolean r0 = r8.moveToFirst()     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            if (r0 == 0) goto L41
            java.lang.String r9 = r8.getString(r9)     // Catch: java.lang.Throwable -> L31 java.lang.Exception -> L34
            r8.close()
            return r9
        L31:
            r9 = move-exception
            r1 = r8
            goto L37
        L34:
            goto L3f
        L36:
            r9 = move-exception
        L37:
            if (r1 == 0) goto L3c
            r1.close()
        L3c:
            throw r9
        L3d:
            r8 = r1
        L3f:
            if (r8 == 0) goto L56
        L41:
            r8.close()
            goto L56
        L45:
            java.lang.String r8 = "file"
            java.lang.String r0 = r9.getScheme()
            boolean r8 = r8.equalsIgnoreCase(r0)
            if (r8 == 0) goto L56
            java.lang.String r8 = r9.getPath()
            return r8
        L56:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.arlosoft.macrodroid.utils.FileUtils.getPath(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static File getPathWithoutFilename(File file) {
        if (file != null) {
            if (file.isDirectory()) {
                return file;
            }
            String name = file.getName();
            String absolutePath = file.getAbsolutePath();
            String substring = absolutePath.substring(0, absolutePath.length() - name.length());
            if (substring.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                substring = substring.substring(0, substring.length() - 1);
            }
            return new File(substring);
        }
        return null;
    }

    public static String getReadableFileSize(int i4) {
        float f4;
        DecimalFormat decimalFormat = new DecimalFormat("###.#");
        String str = " KB";
        if (i4 > 1024) {
            f4 = i4 / 1024;
            if (f4 > 1024.0f) {
                f4 /= 1024.0f;
                if (f4 > 1024.0f) {
                    f4 /= 1024.0f;
                    str = " GB";
                } else {
                    str = " MB";
                }
            }
        } else {
            f4 = 0.0f;
        }
        return String.valueOf(decimalFormat.format(f4) + str);
    }

    public static Bitmap getThumbnail(Context context, File file) {
        return g(context, h(file), e(context, file));
    }

    public static File getUserIconDir(Context context) {
        return new File(context.getExternalFilesDir(null), Constants.USER_ICON_DIR);
    }

    private static Uri h(File file) {
        if (file != null) {
            return Uri.fromFile(file);
        }
        return null;
    }

    private static boolean i(Uri uri) {
        String uri2 = uri.toString();
        if (!uri2.startsWith(MediaStore.Audio.Media.INTERNAL_CONTENT_URI.toString()) && !uri2.startsWith(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI.toString()) && !uri2.startsWith(MediaStore.Video.Media.INTERNAL_CONTENT_URI.toString()) && !uri2.startsWith(MediaStore.Video.Media.EXTERNAL_CONTENT_URI.toString())) {
            return false;
        }
        return true;
    }

    public static boolean isLocal(String str) {
        if (str != null && !str.startsWith("http://")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int j(File file, File file2) {
        return file.getName().toLowerCase().compareTo(file2.getName().toLowerCase());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean k(File file) {
        String name = file.getName();
        if (file.isFile() && !name.startsWith(".")) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean l(File file) {
        String name = file.getName();
        if (file.isDirectory() && !name.startsWith(".")) {
            return true;
        }
        return false;
    }

    public static File[] rootGetFilesInDir(File file) {
        int i4 = 0;
        File[] fileArr = new File[0];
        BufferedReader bufferedReader = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(runtime.exec(new String[]{"su", "-c", "ls -a \"" + file.getAbsolutePath() + "\""}).getInputStream()));
                try {
                    ArrayList arrayList = new ArrayList();
                    while (true) {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            break;
                        }
                        arrayList.add(readLine);
                    }
                    fileArr = new File[arrayList.size()];
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        int i5 = i4 + 1;
                        fileArr[i4] = new File(file.getAbsolutePath() + RemoteSettings.FORWARD_SLASH_STRING + ((String) it.next()));
                        i4 = i5;
                    }
                    bufferedReader2.close();
                } catch (IOException unused) {
                    bufferedReader = bufferedReader2;
                    bufferedReader.close();
                    return fileArr;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    try {
                        bufferedReader.close();
                    } catch (Exception unused2) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Exception unused4) {
        }
        return fileArr;
    }

    public static Bitmap getThumbnail(Context context, Uri uri) {
        return g(context, uri, e(context, getFile(uri)));
    }

    public static File getFile(File file, String str) {
        return d(file.getAbsolutePath(), str);
    }
}
