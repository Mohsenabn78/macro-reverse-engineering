package com.sun.activation.registries;

import com.google.firebase.sessions.settings.RemoteSettings;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes6.dex */
public class MailcapFile {

    /* renamed from: d  reason: collision with root package name */
    private static boolean f37554d = false;

    /* renamed from: a  reason: collision with root package name */
    private Map f37555a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    private Map f37556b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private Map f37557c = new HashMap();

    static {
        try {
            f37554d = Boolean.getBoolean("javax.activation.addreverse");
        } catch (Throwable unused) {
        }
    }

    public MailcapFile(String str) throws IOException {
        FileReader fileReader;
        if (LogSupport.isLoggable()) {
            LogSupport.log("new MailcapFile: file " + str);
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            b(new BufferedReader(fileReader));
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    private Map a(Map map, Map map2) {
        HashMap hashMap = new HashMap(map);
        for (String str : map2.keySet()) {
            List list = (List) hashMap.get(str);
            if (list == null) {
                hashMap.put(str, map2.get(str));
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.addAll((List) map2.get(str));
                hashMap.put(str, arrayList);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0061, code lost:
        c(r1 + r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void b(java.io.Reader r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r0.<init>(r7)
            r7 = 0
        L6:
            r1 = r7
        L7:
            java.lang.String r2 = r0.readLine()
            if (r2 == 0) goto L6d
            java.lang.String r2 = r2.trim()
            r3 = 0
            char r4 = r2.charAt(r3)     // Catch: java.lang.Throwable -> L6b
            r5 = 35
            if (r4 != r5) goto L1b
            goto L7
        L1b:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L6b
            int r4 = r4 + (-1)
            char r4 = r2.charAt(r4)     // Catch: java.lang.Throwable -> L6b
            r5 = 92
            if (r4 != r5) goto L50
            if (r1 == 0) goto L45
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r4.<init>()     // Catch: java.lang.Throwable -> L6b
            r4.append(r1)     // Catch: java.lang.Throwable -> L6b
            int r5 = r2.length()     // Catch: java.lang.Throwable -> L6b
            int r5 = r5 + (-1)
            java.lang.String r2 = r2.substring(r3, r5)     // Catch: java.lang.Throwable -> L6b
            r4.append(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L6b
            goto L7
        L45:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L6b
            int r4 = r4 + (-1)
            java.lang.String r1 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L6b
            goto L7
        L50:
            if (r1 == 0) goto L67
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L6b
            r3.<init>()     // Catch: java.lang.Throwable -> L6b
            r3.append(r1)     // Catch: java.lang.Throwable -> L6b
            r3.append(r2)     // Catch: java.lang.Throwable -> L6b
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L6b
            r6.c(r1)     // Catch: com.sun.activation.registries.MailcapParseException -> L65 java.lang.Throwable -> L6b
            goto L6
        L65:
            goto L6
        L67:
            r6.c(r2)     // Catch: java.lang.Throwable -> L6b
            goto L7
        L6b:
            goto L7
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.activation.registries.MailcapFile.b(java.io.Reader):void");
    }

    protected static void d(int i4, int i5, int i6, int i7, String str) throws MailcapParseException {
        if (LogSupport.isLoggable()) {
            LogSupport.log("PARSE ERROR: Encountered a " + MailcapTokenizer.nameForToken(i7) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i4) + ", a " + MailcapTokenizer.nameForToken(i5) + ", or a " + MailcapTokenizer.nameForToken(i6) + " token.");
        }
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.nameForToken(i7) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i4) + ", a " + MailcapTokenizer.nameForToken(i5) + ", or a " + MailcapTokenizer.nameForToken(i6) + " token.");
    }

    protected static void e(int i4, int i5, int i6, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.nameForToken(i6) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i4) + " or a " + MailcapTokenizer.nameForToken(i5) + " token.");
    }

    protected static void f(int i4, int i5, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.nameForToken(i5) + " token (" + str + ") while expecting a " + MailcapTokenizer.nameForToken(i4) + " token.");
    }

    public void appendToMailcap(String str) {
        if (LogSupport.isLoggable()) {
            LogSupport.log("appendToMailcap: " + str);
        }
        try {
            b(new StringReader(str));
        } catch (IOException unused) {
        }
    }

    protected void c(String str) throws MailcapParseException, IOException {
        String str2;
        int nextToken;
        Map map;
        MailcapTokenizer mailcapTokenizer = new MailcapTokenizer(str);
        mailcapTokenizer.setIsAutoquoting(false);
        if (LogSupport.isLoggable()) {
            LogSupport.log("parse: " + str);
        }
        int nextToken2 = mailcapTokenizer.nextToken();
        if (nextToken2 != 2) {
            f(2, nextToken2, mailcapTokenizer.getCurrentTokenValue());
        }
        String currentTokenValue = mailcapTokenizer.getCurrentTokenValue();
        Locale locale = Locale.ENGLISH;
        String lowerCase = currentTokenValue.toLowerCase(locale);
        int nextToken3 = mailcapTokenizer.nextToken();
        if (nextToken3 != 47 && nextToken3 != 59) {
            e(47, 59, nextToken3, mailcapTokenizer.getCurrentTokenValue());
        }
        if (nextToken3 == 47) {
            int nextToken4 = mailcapTokenizer.nextToken();
            if (nextToken4 != 2) {
                f(2, nextToken4, mailcapTokenizer.getCurrentTokenValue());
            }
            str2 = mailcapTokenizer.getCurrentTokenValue().toLowerCase(locale);
            nextToken3 = mailcapTokenizer.nextToken();
        } else {
            str2 = "*";
        }
        String str3 = lowerCase + RemoteSettings.FORWARD_SLASH_STRING + str2;
        if (LogSupport.isLoggable()) {
            LogSupport.log("  Type: " + str3);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (nextToken3 != 59) {
            f(59, nextToken3, mailcapTokenizer.getCurrentTokenValue());
        }
        mailcapTokenizer.setIsAutoquoting(true);
        int nextToken5 = mailcapTokenizer.nextToken();
        mailcapTokenizer.setIsAutoquoting(false);
        if (nextToken5 != 2 && nextToken5 != 59) {
            e(2, 59, nextToken5, mailcapTokenizer.getCurrentTokenValue());
        }
        if (nextToken5 == 2) {
            List list = (List) this.f37557c.get(str3);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.f37557c.put(str3, arrayList);
            } else {
                list.add(str);
            }
        }
        if (nextToken5 != 59) {
            nextToken5 = mailcapTokenizer.nextToken();
        }
        if (nextToken5 == 59) {
            boolean z3 = false;
            do {
                int nextToken6 = mailcapTokenizer.nextToken();
                if (nextToken6 != 2) {
                    f(2, nextToken6, mailcapTokenizer.getCurrentTokenValue());
                }
                String lowerCase2 = mailcapTokenizer.getCurrentTokenValue().toLowerCase(Locale.ENGLISH);
                nextToken = mailcapTokenizer.nextToken();
                if (nextToken != 61 && nextToken != 59 && nextToken != 5) {
                    d(61, 59, 5, nextToken, mailcapTokenizer.getCurrentTokenValue());
                }
                if (nextToken == 61) {
                    mailcapTokenizer.setIsAutoquoting(true);
                    int nextToken7 = mailcapTokenizer.nextToken();
                    mailcapTokenizer.setIsAutoquoting(false);
                    if (nextToken7 != 2) {
                        f(2, nextToken7, mailcapTokenizer.getCurrentTokenValue());
                    }
                    String currentTokenValue2 = mailcapTokenizer.getCurrentTokenValue();
                    if (lowerCase2.startsWith("x-java-")) {
                        String substring = lowerCase2.substring(7);
                        if (substring.equals("fallback-entry") && currentTokenValue2.equalsIgnoreCase("true")) {
                            z3 = true;
                        } else {
                            if (LogSupport.isLoggable()) {
                                LogSupport.log("    Command: " + substring + ", Class: " + currentTokenValue2);
                            }
                            List list2 = (List) linkedHashMap.get(substring);
                            if (list2 == null) {
                                list2 = new ArrayList();
                                linkedHashMap.put(substring, list2);
                            }
                            if (f37554d) {
                                list2.add(0, currentTokenValue2);
                            } else {
                                list2.add(currentTokenValue2);
                            }
                        }
                    }
                    nextToken = mailcapTokenizer.nextToken();
                    continue;
                }
            } while (nextToken == 59);
            if (z3) {
                map = this.f37556b;
            } else {
                map = this.f37555a;
            }
            Map map2 = (Map) map.get(str3);
            if (map2 == null) {
                map.put(str3, linkedHashMap);
                return;
            }
            if (LogSupport.isLoggable()) {
                LogSupport.log("Merging commands for type " + str3);
            }
            for (String str4 : map2.keySet()) {
                List list3 = (List) map2.get(str4);
                List<String> list4 = (List) linkedHashMap.get(str4);
                if (list4 != null) {
                    for (String str5 : list4) {
                        if (!list3.contains(str5)) {
                            if (f37554d) {
                                list3.add(0, str5);
                            } else {
                                list3.add(str5);
                            }
                        }
                    }
                }
            }
            for (String str6 : linkedHashMap.keySet()) {
                if (!map2.containsKey(str6)) {
                    map2.put(str6, (List) linkedHashMap.get(str6));
                }
            }
        } else if (nextToken5 != 5) {
            e(5, 59, nextToken5, mailcapTokenizer.getCurrentTokenValue());
        }
    }

    public Map getMailcapFallbackList(String str) {
        Map map = (Map) this.f37556b.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (!str.substring(indexOf).equals("*")) {
            Map map2 = (Map) this.f37556b.get(str.substring(0, indexOf) + "*");
            if (map2 != null) {
                if (map != null) {
                    return a(map, map2);
                }
                return map2;
            }
            return map;
        }
        return map;
    }

    public Map getMailcapList(String str) {
        Map map = (Map) this.f37555a.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (!str.substring(indexOf).equals("*")) {
            Map map2 = (Map) this.f37555a.get(str.substring(0, indexOf) + "*");
            if (map2 != null) {
                if (map != null) {
                    return a(map, map2);
                }
                return map2;
            }
            return map;
        }
        return map;
    }

    public String[] getMimeTypes() {
        HashSet hashSet = new HashSet(this.f37555a.keySet());
        hashSet.addAll(this.f37556b.keySet());
        hashSet.addAll(this.f37557c.keySet());
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    public String[] getNativeCommands(String str) {
        List list = (List) this.f37557c.get(str.toLowerCase(Locale.ENGLISH));
        if (list != null) {
            return (String[]) list.toArray(new String[list.size()]);
        }
        return null;
    }

    public MailcapFile(InputStream inputStream) throws IOException {
        if (LogSupport.isLoggable()) {
            LogSupport.log("new MailcapFile: InputStream");
        }
        b(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public MailcapFile() {
        if (LogSupport.isLoggable()) {
            LogSupport.log("new MailcapFile: default");
        }
    }
}
