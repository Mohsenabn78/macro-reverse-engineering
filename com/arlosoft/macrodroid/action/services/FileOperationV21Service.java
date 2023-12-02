package com.arlosoft.macrodroid.action.services;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.UriPermission;
import android.net.Uri;
import android.provider.DocumentsContract;
import androidx.documentfile.provider.DocumentFile;
import com.arlosoft.macrodroid.R;
import com.arlosoft.macrodroid.action.FileOperationV21Action;
import com.arlosoft.macrodroid.analytics.FirebaseAnalyticsEventLogger;
import com.arlosoft.macrodroid.common.Util;
import com.arlosoft.macrodroid.logging.systemlog.SystemLog;
import com.arlosoft.macrodroid.utils.NotificationUtils;
import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import timber.log.Timber;

/* loaded from: classes2.dex */
public class FileOperationV21Service extends IntentService {
    public static final String EXTRA_FILE_EXTENSIONS = "FileExtensions";
    public static final String EXTRA_FILE_PATTERN = "FilePattern";
    public static final String EXTRA_FOLDER_NAME = "folderName";
    public static final String EXTRA_FROM_PATH = "fromPath";
    public static final String EXTRA_FROM_URI = "FromUri";
    public static final String EXTRA_OPTION = "option";
    public static final String EXTRA_TO_URI = "ToUri";

    public FileOperationV21Service() {
        super("FileOperationV21Service");
        setIntentRedelivery(true);
    }

    private String a(DocumentFile documentFile, DocumentFile documentFile2, int i4) throws IOException {
        InputStream openInputStream = getContentResolver().openInputStream(documentFile.getUri());
        DocumentFile findFile = documentFile2.findFile(documentFile.getName());
        if (findFile != null && findFile.getUri().equals(documentFile.getUri())) {
            return null;
        }
        if (findFile != null) {
            findFile.delete();
        }
        DocumentFile createFile = documentFile2.createFile(documentFile.getType(), documentFile.getName());
        if (createFile != null) {
            OutputStream openOutputStream = getContentResolver().openOutputStream(createFile.getUri());
            IOUtils.copy(openInputStream, openOutputStream);
            openOutputStream.close();
            openInputStream.close();
            if (i4 == 1) {
                documentFile.delete();
            }
            return null;
        }
        return "Output file could not be written";
    }

    private static DocumentFile b(DocumentFile documentFile, Uri uri) {
        DocumentFile[] listFiles;
        for (DocumentFile documentFile2 : documentFile.listFiles()) {
            if (documentFile2.isDirectory()) {
                if (uri.toString().equals(documentFile2.getUri().toString())) {
                    return documentFile2;
                }
                if (uri.toString().startsWith(documentFile2.getUri().toString())) {
                    return b(documentFile2, uri);
                }
            }
        }
        return null;
    }

    private void c(DocumentFile documentFile, DocumentFile documentFile2, int i4, String str) throws IOException {
        DocumentFile[] listFiles;
        DocumentFile documentFile3;
        if (documentFile.isDirectory()) {
            for (DocumentFile documentFile4 : documentFile.listFiles()) {
                if (documentFile4.isDirectory()) {
                    documentFile3 = documentFile2.findFile(documentFile4.getName());
                    if (documentFile3 == null) {
                        documentFile3 = documentFile2.createDirectory(documentFile4.getName());
                    }
                } else {
                    documentFile3 = documentFile2;
                }
                if (!documentFile3.canWrite() && ((documentFile3 = getFileFromRootPermission(this, documentFile3.getUri())) == null || !documentFile3.canWrite())) {
                    NotificationUtils.displayFileAccessNotification(this, str);
                    return;
                }
                c(documentFile4, documentFile3, i4, str);
            }
            return;
        }
        a(documentFile, documentFile2, i4);
    }

    @SuppressLint({"NewApi"})
    public static DocumentFile getFileFromRootPermission(Context context, Uri uri) {
        DocumentFile b4;
        String treeDocumentId = DocumentsContract.getTreeDocumentId(uri);
        List<UriPermission> persistedUriPermissions = context.getContentResolver().getPersistedUriPermissions();
        SystemLog.logVerbose("Uri permission list length = " + persistedUriPermissions.size());
        for (UriPermission uriPermission : persistedUriPermissions) {
            SystemLog.logVerbose(uriPermission.toString());
            try {
                b4 = b(DocumentFile.fromTreeUri(context, uriPermission.getUri()), DocumentsContract.buildDocumentUriUsingTree(uriPermission.getUri(), treeDocumentId));
            } catch (IllegalArgumentException e4) {
                SystemLog.logVerbose("Failed to get file from root permission: " + e4.toString());
            }
            if (b4 != null) {
                SystemLog.logVerbose("Access available: " + b4.getName());
                return b4;
            }
            continue;
        }
        return null;
    }

    @Override // android.app.IntentService
    protected void onHandleIntent(Intent intent) {
        Uri uri;
        Uri uri2;
        DocumentFile[] documentFileArr;
        Uri uri3;
        Uri uri4;
        String stringExtra = intent.getStringExtra(EXTRA_FROM_URI);
        String stringExtra2 = intent.getStringExtra(EXTRA_TO_URI);
        String stringExtra3 = intent.getStringExtra("FilePattern");
        String[] stringArrayExtra = intent.getStringArrayExtra("FileExtensions");
        String stringExtra4 = intent.getStringExtra(EXTRA_FROM_PATH);
        String stringExtra5 = intent.getStringExtra(EXTRA_FOLDER_NAME);
        String stringExtra6 = intent.getStringExtra("com.arlosoft.macrodroid.MACRO_NAME");
        int intExtra = intent.getIntExtra(EXTRA_OPTION, 0);
        Uri parse = Uri.parse(stringExtra);
        DocumentFile fromTreeUri = DocumentFile.fromTreeUri(this, parse);
        if (fromTreeUri == null) {
            FirebaseAnalyticsEventLogger.logHandledException(new Exception("FileOperationV21 fromDir is null: " + stringExtra));
            SystemLog.logError("File operation failure fromDir is null: " + stringExtra);
            return;
        }
        if (!fromTreeUri.exists()) {
            fromTreeUri = getFileFromRootPermission(this, parse);
            if (fromTreeUri == null || !fromTreeUri.exists()) {
                SystemLog.logError("File operation failed - from dir does not exist or is not accessible: " + stringExtra4);
                NotificationUtils.displayFileAccessNotification(this, stringExtra6);
                return;
            }
        } else if (!fromTreeUri.canRead() && ((fromTreeUri = getFileFromRootPermission(this, parse)) == null || !fromTreeUri.canRead())) {
            SystemLog.logError("Cannot read 'FROM' directory: [" + stringExtra4 + ", " + stringExtra + "]");
            NotificationUtils.displayFileAccessNotification(this, stringExtra6);
            return;
        }
        if (stringExtra2 != null) {
            uri = Uri.parse(stringExtra2);
        } else {
            uri = null;
        }
        if (intExtra == 3) {
            if (fromTreeUri.findFile(stringExtra5) == null) {
                fromTreeUri.createDirectory(stringExtra5);
                return;
            }
            return;
        }
        ArrayList<DocumentFile> arrayList = new ArrayList();
        if (stringExtra3 != null) {
            WildcardFileFilter wildcardFileFilter = new WildcardFileFilter(stringExtra3);
            DocumentFile[] listFiles = fromTreeUri.listFiles();
            int length = listFiles.length;
            int i4 = 0;
            while (i4 < length) {
                DocumentFile documentFile = listFiles[i4];
                if (documentFile.getName() != null) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Found file ");
                    sb.append(documentFile.getName());
                    sb.append(" with size ");
                    uri4 = uri;
                    sb.append(documentFile.length());
                    try {
                        if (!documentFile.isDirectory() && wildcardFileFilter.accept(new File(documentFile.getName()))) {
                            arrayList.add(documentFile);
                        }
                    } catch (Exception unused) {
                    }
                } else {
                    uri4 = uri;
                }
                i4++;
                uri = uri4;
            }
            uri2 = uri;
        } else {
            uri2 = uri;
            if (stringArrayExtra != null) {
                if (stringExtra4 == null) {
                    SystemLog.logError("FileOperationService: fromPath is null");
                    return;
                } else if (stringExtra4.endsWith(RemoteSettings.FORWARD_SLASH_STRING)) {
                    arrayList.add(fromTreeUri);
                } else {
                    DocumentFile[] listFiles2 = fromTreeUri.listFiles();
                    int length2 = listFiles2.length;
                    int i5 = 0;
                    while (i5 < length2) {
                        DocumentFile documentFile2 = listFiles2[i5];
                        String name = documentFile2.getName();
                        if (name != null) {
                            Timber.d("Found file " + name + " with size " + documentFile2.length(), new Object[0]);
                            int length3 = stringArrayExtra.length;
                            int i6 = 0;
                            while (i6 < length3) {
                                String str = stringArrayExtra[i6];
                                String lowerCase = name.toLowerCase();
                                StringBuilder sb2 = new StringBuilder();
                                documentFileArr = listFiles2;
                                sb2.append(".");
                                sb2.append(str);
                                if (lowerCase.endsWith(sb2.toString())) {
                                    arrayList.add(documentFile2);
                                    break;
                                } else {
                                    i6++;
                                    listFiles2 = documentFileArr;
                                }
                            }
                        }
                        documentFileArr = listFiles2;
                        i5++;
                        listFiles2 = documentFileArr;
                    }
                }
            } else {
                SystemLog.logError("FileOperationService: FilePattern and FileExtensions are both null");
                FirebaseAnalyticsEventLogger.logHandledException(new RuntimeException("FileOperationService: FilePattern and FileExtensions are both null"));
                Util.displayNotification(this, getString(R.string.macrodroid_error), "File Operation Failed", false);
                return;
            }
        }
        if (arrayList.size() == 0) {
            return;
        }
        String str2 = null;
        for (DocumentFile documentFile3 : arrayList) {
            if (intExtra == 2) {
                documentFile3.delete();
                uri3 = uri2;
            } else if (uri2 == null) {
                SystemLog.logError("File Operation failed: Destination address is null");
                return;
            } else {
                uri3 = uri2;
                try {
                    try {
                        DocumentFile fromTreeUri2 = DocumentFile.fromTreeUri(this, uri3);
                        if (!fromTreeUri2.canWrite() && ((fromTreeUri2 = getFileFromRootPermission(this, uri3)) == null || !fromTreeUri2.canWrite())) {
                            NotificationUtils.displayFileAccessNotification(this, stringExtra6);
                            try {
                                try {
                                    throw null;
                                } catch (Exception unused2) {
                                    throw null;
                                }
                            } catch (Exception unused3) {
                                return;
                            }
                        }
                        if (documentFile3.isDirectory()) {
                            c(documentFile3, fromTreeUri2, intExtra, stringExtra6);
                        } else {
                            str2 = a(documentFile3, fromTreeUri2, intExtra);
                        }
                        try {
                            try {
                                throw null;
                                break;
                            } catch (Exception unused4) {
                                throw null;
                                break;
                            }
                        } catch (Exception unused5) {
                        }
                    } catch (Exception e4) {
                        if (str2 == null) {
                            str2 = e4.toString();
                        }
                        try {
                            try {
                                throw null;
                                break;
                            } catch (Exception unused6) {
                                throw null;
                                break;
                            }
                        } catch (Exception unused7) {
                        }
                    }
                } catch (Throwable th) {
                    try {
                        try {
                            throw null;
                        } catch (Exception unused8) {
                            throw null;
                        }
                    } catch (Exception unused9) {
                        throw th;
                    }
                }
            }
            uri2 = uri3;
        }
        if (str2 != null) {
            Util.displayNotification(this, getString(R.string.macrodroid_error) + ": " + FileOperationV21Action.getOptions()[intExtra], str2, false);
            SystemLog.logError(getString(R.string.macrodroid_error) + ": " + FileOperationV21Action.getOptions()[intExtra] + " - " + str2);
        }
    }
}
