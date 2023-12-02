package com.koushikdutta.ion.loader;

import com.google.android.gms.stats.CodePackage;
import com.miguelbcr.ui.rx_paparazzo2.interactors.ImageUtils;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes6.dex */
public class MediaFile {
    public static final int FILE_TYPE_3GPA = 11;
    public static final int FILE_TYPE_3GPP = 23;
    public static final int FILE_TYPE_3GPP2 = 24;
    public static final int FILE_TYPE_AAC = 8;
    public static final int FILE_TYPE_AC3 = 12;
    public static final int FILE_TYPE_AMR = 4;
    public static final int FILE_TYPE_ASF = 26;
    public static final int FILE_TYPE_AVI = 29;
    public static final int FILE_TYPE_AWB = 5;
    public static final int FILE_TYPE_BMP = 35;
    public static final int FILE_TYPE_DIVX = 31;
    public static final int FILE_TYPE_DTS = 300;
    public static final int FILE_TYPE_EC3 = 16;
    public static final int FILE_TYPE_FL = 51;
    public static final int FILE_TYPE_FLAC = 10;
    public static final int FILE_TYPE_GIF = 33;
    public static final int FILE_TYPE_HTML = 101;
    public static final int FILE_TYPE_HTTPLIVE = 44;
    public static final int FILE_TYPE_IMY = 19;
    public static final int FILE_TYPE_JPEG = 32;
    public static final int FILE_TYPE_M3U = 41;
    public static final int FILE_TYPE_M4A = 2;
    public static final int FILE_TYPE_M4V = 22;
    public static final int FILE_TYPE_MID = 17;
    public static final int FILE_TYPE_MKA = 9;
    public static final int FILE_TYPE_MKV = 27;
    public static final int FILE_TYPE_MP2PS = 200;
    public static final int FILE_TYPE_MP2TS = 28;
    public static final int FILE_TYPE_MP3 = 1;
    public static final int FILE_TYPE_MP4 = 21;
    public static final int FILE_TYPE_MS_EXCEL = 105;
    public static final int FILE_TYPE_MS_POWERPOINT = 106;
    public static final int FILE_TYPE_MS_WORD = 104;
    public static final int FILE_TYPE_OGG = 7;
    public static final int FILE_TYPE_PCM = 15;
    public static final int FILE_TYPE_PDF = 102;
    public static final int FILE_TYPE_PLS = 42;
    public static final int FILE_TYPE_PNG = 34;
    public static final int FILE_TYPE_QCP = 13;
    public static final int FILE_TYPE_SMF = 18;
    public static final int FILE_TYPE_TEXT = 100;
    public static final int FILE_TYPE_WAV = 3;
    public static final int FILE_TYPE_WBMP = 36;
    public static final int FILE_TYPE_WEBM = 30;
    public static final int FILE_TYPE_WEBMA = 14;
    public static final int FILE_TYPE_WEBP = 37;
    public static final int FILE_TYPE_WMA = 6;
    public static final int FILE_TYPE_WMV = 25;
    public static final int FILE_TYPE_WPL = 43;
    public static final int FILE_TYPE_XML = 103;
    public static final int FILE_TYPE_ZIP = 107;

    /* renamed from: a  reason: collision with root package name */
    private static final HashMap<String, MediaFileType> f36040a = new HashMap<>();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, Integer> f36041b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final HashMap<String, Integer> f36042c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static final HashMap<String, Integer> f36043d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private static final HashMap<Integer, String> f36044e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private static final HashMap<String, String> f36045f = new HashMap<>();

    /* loaded from: classes6.dex */
    public static class MediaFileType {
        public final int fileType;
        public final String mimeType;

        MediaFileType(int i4, String str) {
            this.fileType = i4;
            this.mimeType = str;
        }
    }

    static {
        b("MP3", 1, "audio/mpeg", MtpConstants.FORMAT_MP3);
        b("MPGA", 1, "audio/mpeg", MtpConstants.FORMAT_MP3);
        b("M4A", 2, "audio/mp4", MtpConstants.FORMAT_MPEG);
        b("WAV", 3, "audio/x-wav", MtpConstants.FORMAT_WAV);
        a("WAV", 15, "audio/wav");
        a("AMR", 4, "audio/amr");
        a("AWB", 5, "audio/amr-wb");
        a("DIVX", 31, "video/divx");
        a("QCP", 13, "audio/qcelp");
        b("OGG", 7, "audio/ogg", MtpConstants.FORMAT_OGG);
        b("OGG", 7, "application/ogg", MtpConstants.FORMAT_OGG);
        b("OGA", 7, "audio/ogg", MtpConstants.FORMAT_OGG);
        b("OGA", 7, "application/ogg", MtpConstants.FORMAT_OGG);
        b("AAC", 8, "audio/aac", MtpConstants.FORMAT_AAC);
        b("AAC", 8, "audio/aac-adts", MtpConstants.FORMAT_AAC);
        a("MKA", 9, "audio/x-matroska");
        a("MID", 17, "audio/midi");
        a("MIDI", 17, "audio/midi");
        a("XMF", 17, "audio/midi");
        a("RTTTL", 17, "audio/midi");
        a("SMF", 18, "audio/sp-midi");
        a("IMY", 19, "audio/imelody");
        a("RTX", 17, "audio/midi");
        a(CodePackage.OTA, 17, "audio/midi");
        a("MXMF", 17, "audio/midi");
        b("MPEG", 21, "video/mpeg", MtpConstants.FORMAT_MPEG);
        b("MPG", 21, "video/mpeg", MtpConstants.FORMAT_MPEG);
        b("MP4", 21, "video/mp4", MtpConstants.FORMAT_MPEG);
        b("MPEG4", 21, "video/mpeg4", MtpConstants.FORMAT_MPEG);
        b("M4V", 22, "video/m4v", MtpConstants.FORMAT_MPEG);
        b("3GP", 23, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        b("3GPP", 23, "video/3gpp", MtpConstants.FORMAT_3GP_CONTAINER);
        b("3G2", 24, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        b("3GPP2", 24, "video/3gpp2", MtpConstants.FORMAT_3GP_CONTAINER);
        a("MKV", 27, "video/x-matroska");
        a("WEBM", 30, "video/webm");
        a("TS", 28, "video/mp2ts");
        a("MPG", 28, "video/mp2ts");
        a("AVI", 29, "video/avi");
        b("JPG", 32, ImageUtils.MIME_TYPE_JPEG, MtpConstants.FORMAT_EXIF_JPEG);
        b("JPEG", 32, ImageUtils.MIME_TYPE_JPEG, MtpConstants.FORMAT_EXIF_JPEG);
        b("GIF", 33, "image/gif", MtpConstants.FORMAT_GIF);
        b("PNG", 34, "image/png", MtpConstants.FORMAT_PNG);
        b("BMP", 35, "image/x-ms-bmp", MtpConstants.FORMAT_BMP);
        a("WBMP", 36, "image/vnd.wap.wbmp");
        a("WEBP", 37, "image/webp");
        b("M3U", 41, "audio/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        b("M3U", 41, "application/x-mpegurl", MtpConstants.FORMAT_M3U_PLAYLIST);
        b("PLS", 42, "audio/x-scpls", MtpConstants.FORMAT_PLS_PLAYLIST);
        b("WPL", 43, "application/vnd.ms-wpl", MtpConstants.FORMAT_WPL_PLAYLIST);
        a("M3U8", 44, "application/vnd.apple.mpegurl");
        a("M3U8", 44, "audio/mpegurl");
        a("M3U8", 44, "audio/x-mpegurl");
        a("FL", 51, "application/x-android-drm-fl");
        b("TXT", 100, "text/plain", MtpConstants.FORMAT_TEXT);
        b("HTM", 101, "text/html", MtpConstants.FORMAT_HTML);
        b("HTML", 101, "text/html", MtpConstants.FORMAT_HTML);
        a("PDF", 102, "application/pdf");
        b("DOC", 104, "application/msword", MtpConstants.FORMAT_MS_WORD_DOCUMENT);
        b("XLS", 105, "application/vnd.ms-excel", MtpConstants.FORMAT_MS_EXCEL_SPREADSHEET);
        b("PPT", 106, "application/mspowerpoint", MtpConstants.FORMAT_MS_POWERPOINT_PRESENTATION);
        b("FLAC", 10, "audio/flac", MtpConstants.FORMAT_FLAC);
        a("ZIP", 107, "application/zip");
        a("MPG", 200, "video/mp2p");
        a("MPEG", 200, "video/mp2p");
    }

    static void a(String str, int i4, String str2) {
        f36040a.put(str, new MediaFileType(i4, str2));
        f36041b.put(str2, Integer.valueOf(i4));
    }

    static void b(String str, int i4, String str2, int i5) {
        a(str, i4, str2);
        f36042c.put(str, Integer.valueOf(i5));
        f36043d.put(str2, Integer.valueOf(i5));
        f36044e.put(Integer.valueOf(i5), str2);
        f36045f.put(str2, str);
    }

    public static String getExtensionForMimeType(String str) {
        return f36045f.get(str).toLowerCase();
    }

    public static String getFileTitle(String str) {
        int i4;
        int lastIndexOf = str.lastIndexOf(47);
        if (lastIndexOf >= 0 && (i4 = lastIndexOf + 1) < str.length()) {
            str = str.substring(i4);
        }
        int lastIndexOf2 = str.lastIndexOf(46);
        if (lastIndexOf2 > 0) {
            return str.substring(0, lastIndexOf2);
        }
        return str;
    }

    public static MediaFileType getFileType(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return null;
        }
        return f36040a.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.ROOT));
    }

    public static int getFileTypeForMimeType(String str) {
        Integer num = f36041b.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static int getFormatCode(String str, String str2) {
        Integer num;
        if (str2 != null && (num = f36043d.get(str2)) != null) {
            return num.intValue();
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf > 0) {
            Integer num2 = f36042c.get(str.substring(lastIndexOf + 1).toUpperCase(Locale.ROOT));
            if (num2 != null) {
                return num2.intValue();
            }
            return 12288;
        }
        return 12288;
    }

    public static String getMimeTypeForFile(String str) {
        MediaFileType fileType = getFileType(str);
        if (fileType == null) {
            return null;
        }
        return fileType.mimeType;
    }

    public static String getMimeTypeForFormatCode(int i4) {
        return f36044e.get(Integer.valueOf(i4));
    }

    public static boolean isAudioFileType(int i4) {
        if (i4 >= 1 && i4 <= 16) {
            return true;
        }
        if (i4 >= 17 && i4 <= 19) {
            return true;
        }
        if (i4 >= 300 && i4 <= 300) {
            return true;
        }
        return false;
    }

    public static boolean isDrmFileType(int i4) {
        if (i4 >= 51 && i4 <= 51) {
            return true;
        }
        return false;
    }

    public static boolean isImageFileType(int i4) {
        if (i4 >= 32 && i4 <= 37) {
            return true;
        }
        return false;
    }

    public static boolean isMimeTypeMedia(String str) {
        int fileTypeForMimeType = getFileTypeForMimeType(str);
        if (!isAudioFileType(fileTypeForMimeType) && !isVideoFileType(fileTypeForMimeType) && !isImageFileType(fileTypeForMimeType) && !isPlayListFileType(fileTypeForMimeType)) {
            return false;
        }
        return true;
    }

    public static boolean isPlayListFileType(int i4) {
        if (i4 >= 41 && i4 <= 44) {
            return true;
        }
        return false;
    }

    public static boolean isVideoFileType(int i4) {
        if ((i4 >= 21 && i4 <= 31) || (i4 >= 200 && i4 <= 200)) {
            return true;
        }
        return false;
    }
}
