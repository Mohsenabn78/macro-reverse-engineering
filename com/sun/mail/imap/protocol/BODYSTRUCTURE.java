package com.sun.mail.imap.protocol;

import com.google.firebase.sessions.settings.RemoteSettings;
import com.sun.mail.iap.ParsingException;
import com.sun.mail.iap.Response;
import com.sun.mail.util.PropUtil;
import java.io.PrintStream;
import java.util.ArrayList;
import javax.mail.internet.ParameterList;

/* loaded from: classes6.dex */
public class BODYSTRUCTURE implements Item {

    /* renamed from: b  reason: collision with root package name */
    static final char[] f37830b = {'B', 'O', 'D', 'Y', 'S', 'T', 'R', 'U', 'C', 'T', 'U', 'R', 'E'};

    /* renamed from: c  reason: collision with root package name */
    private static int f37831c = 1;

    /* renamed from: d  reason: collision with root package name */
    private static int f37832d = 2;

    /* renamed from: e  reason: collision with root package name */
    private static int f37833e = 3;

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f37834f = PropUtil.getBooleanSystemProperty("mail.imap.parse.debug", false);

    /* renamed from: a  reason: collision with root package name */
    private int f37835a;
    public String attachment;
    public BODYSTRUCTURE[] bodies;
    public ParameterList cParams;
    public ParameterList dParams;
    public String description;
    public String disposition;
    public String encoding;
    public ENVELOPE envelope;
    public String id;
    public String[] language;
    public int lines;
    public String md5;
    public int msgno;
    public int size;
    public String subtype;
    public String type;

    public BODYSTRUCTURE(FetchResponse fetchResponse) throws ParsingException {
        this.lines = -1;
        this.size = -1;
        boolean z3 = f37834f;
        if (z3) {
            System.out.println("DEBUG IMAP: parsing BODYSTRUCTURE");
        }
        this.msgno = fetchResponse.getNumber();
        if (z3) {
            PrintStream printStream = System.out;
            printStream.println("DEBUG IMAP: msgno " + this.msgno);
        }
        fetchResponse.skipSpaces();
        if (fetchResponse.readByte() == 40) {
            if (fetchResponse.peekByte() == 40) {
                if (z3) {
                    System.out.println("DEBUG IMAP: parsing multipart");
                }
                this.type = "multipart";
                this.f37835a = f37832d;
                ArrayList arrayList = new ArrayList(1);
                do {
                    arrayList.add(new BODYSTRUCTURE(fetchResponse));
                    fetchResponse.skipSpaces();
                } while (fetchResponse.peekByte() == 40);
                this.bodies = (BODYSTRUCTURE[]) arrayList.toArray(new BODYSTRUCTURE[arrayList.size()]);
                this.subtype = fetchResponse.readString();
                boolean z4 = f37834f;
                if (z4) {
                    PrintStream printStream2 = System.out;
                    printStream2.println("DEBUG IMAP: subtype " + this.subtype);
                }
                if (fetchResponse.isNextNonSpace(')')) {
                    if (z4) {
                        System.out.println("DEBUG IMAP: parse DONE");
                        return;
                    }
                    return;
                }
                if (z4) {
                    System.out.println("DEBUG IMAP: parsing extension data");
                }
                this.cParams = b(fetchResponse);
                if (fetchResponse.isNextNonSpace(')')) {
                    if (z4) {
                        System.out.println("DEBUG IMAP: body parameters DONE");
                        return;
                    }
                    return;
                }
                byte peekByte = fetchResponse.peekByte();
                if (peekByte == 40) {
                    if (z4) {
                        System.out.println("DEBUG IMAP: parse disposition");
                    }
                    fetchResponse.readByte();
                    this.disposition = fetchResponse.readString();
                    if (z4) {
                        PrintStream printStream3 = System.out;
                        printStream3.println("DEBUG IMAP: disposition " + this.disposition);
                    }
                    this.dParams = b(fetchResponse);
                    if (fetchResponse.isNextNonSpace(')')) {
                        if (z4) {
                            System.out.println("DEBUG IMAP: disposition DONE");
                        }
                    } else {
                        throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition in multipart");
                    }
                } else if (peekByte != 78 && peekByte != 110) {
                    if (z4) {
                        System.out.println("DEBUG IMAP: bad multipart disposition, applying Exchange bug workaround");
                    }
                    this.description = fetchResponse.readString();
                    if (z4) {
                        PrintStream printStream4 = System.out;
                        printStream4.println("DEBUG IMAP: multipart description " + this.description);
                    }
                    while (fetchResponse.readByte() == 32) {
                        a(fetchResponse);
                    }
                    return;
                } else {
                    if (z4) {
                        System.out.println("DEBUG IMAP: disposition NIL");
                    }
                    fetchResponse.skip(3);
                }
                if (fetchResponse.isNextNonSpace(')')) {
                    if (z4) {
                        System.out.println("DEBUG IMAP: no body-fld-lang");
                        return;
                    }
                    return;
                }
                if (fetchResponse.peekByte() == 40) {
                    this.language = fetchResponse.readStringList();
                    if (z4) {
                        PrintStream printStream5 = System.out;
                        printStream5.println("DEBUG IMAP: language len " + this.language.length);
                    }
                } else {
                    String readString = fetchResponse.readString();
                    if (readString != null) {
                        this.language = new String[]{readString};
                        if (z4) {
                            PrintStream printStream6 = System.out;
                            printStream6.println("DEBUG IMAP: language " + readString);
                        }
                    }
                }
                while (fetchResponse.readByte() == 32) {
                    a(fetchResponse);
                }
                return;
            } else if (fetchResponse.peekByte() != 41) {
                if (z3) {
                    System.out.println("DEBUG IMAP: single part");
                }
                this.type = fetchResponse.readString();
                if (z3) {
                    PrintStream printStream7 = System.out;
                    printStream7.println("DEBUG IMAP: type " + this.type);
                }
                this.f37835a = f37831c;
                this.subtype = fetchResponse.readString();
                if (z3) {
                    PrintStream printStream8 = System.out;
                    printStream8.println("DEBUG IMAP: subtype " + this.subtype);
                }
                if (this.type == null) {
                    this.type = "application";
                    this.subtype = "octet-stream";
                }
                this.cParams = b(fetchResponse);
                if (z3) {
                    PrintStream printStream9 = System.out;
                    printStream9.println("DEBUG IMAP: cParams " + this.cParams);
                }
                this.id = fetchResponse.readString();
                if (z3) {
                    PrintStream printStream10 = System.out;
                    printStream10.println("DEBUG IMAP: id " + this.id);
                }
                this.description = fetchResponse.readString();
                if (z3) {
                    PrintStream printStream11 = System.out;
                    printStream11.println("DEBUG IMAP: description " + this.description);
                }
                String readAtomString = fetchResponse.readAtomString();
                this.encoding = readAtomString;
                if (readAtomString != null && readAtomString.equalsIgnoreCase("NIL")) {
                    if (z3) {
                        System.out.println("DEBUG IMAP: NIL encoding, applying Exchange bug workaround");
                    }
                    this.encoding = null;
                }
                String str = this.encoding;
                if (str != null) {
                    this.encoding = str.trim();
                }
                if (z3) {
                    PrintStream printStream12 = System.out;
                    printStream12.println("DEBUG IMAP: encoding " + this.encoding);
                }
                this.size = fetchResponse.readNumber();
                if (z3) {
                    PrintStream printStream13 = System.out;
                    printStream13.println("DEBUG IMAP: size " + this.size);
                }
                if (this.size >= 0) {
                    if (this.type.equalsIgnoreCase("text")) {
                        this.lines = fetchResponse.readNumber();
                        if (z3) {
                            PrintStream printStream14 = System.out;
                            printStream14.println("DEBUG IMAP: lines " + this.lines);
                        }
                        if (this.lines < 0) {
                            throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                        }
                    } else if (this.type.equalsIgnoreCase("message") && this.subtype.equalsIgnoreCase("rfc822")) {
                        this.f37835a = f37833e;
                        fetchResponse.skipSpaces();
                        if (fetchResponse.peekByte() == 40) {
                            this.envelope = new ENVELOPE(fetchResponse);
                            if (z3) {
                                System.out.println("DEBUG IMAP: got envelope of nested message");
                            }
                            this.bodies = new BODYSTRUCTURE[]{new BODYSTRUCTURE(fetchResponse)};
                            this.lines = fetchResponse.readNumber();
                            if (z3) {
                                PrintStream printStream15 = System.out;
                                printStream15.println("DEBUG IMAP: lines " + this.lines);
                            }
                            if (this.lines < 0) {
                                throw new ParsingException("BODYSTRUCTURE parse error: bad ``lines'' element");
                            }
                        } else if (z3) {
                            System.out.println("DEBUG IMAP: missing envelope and body of nested message");
                        }
                    } else {
                        fetchResponse.skipSpaces();
                        if (Character.isDigit((char) fetchResponse.peekByte())) {
                            throw new ParsingException("BODYSTRUCTURE parse error: server erroneously included ``lines'' element with type " + this.type + RemoteSettings.FORWARD_SLASH_STRING + this.subtype);
                        }
                    }
                    if (fetchResponse.isNextNonSpace(')')) {
                        if (z3) {
                            System.out.println("DEBUG IMAP: parse DONE");
                            return;
                        }
                        return;
                    }
                    this.md5 = fetchResponse.readString();
                    if (fetchResponse.isNextNonSpace(')')) {
                        if (z3) {
                            System.out.println("DEBUG IMAP: no MD5 DONE");
                            return;
                        }
                        return;
                    }
                    byte readByte = fetchResponse.readByte();
                    if (readByte == 40) {
                        this.disposition = fetchResponse.readString();
                        if (z3) {
                            PrintStream printStream16 = System.out;
                            printStream16.println("DEBUG IMAP: disposition " + this.disposition);
                        }
                        this.dParams = b(fetchResponse);
                        if (z3) {
                            PrintStream printStream17 = System.out;
                            printStream17.println("DEBUG IMAP: dParams " + this.dParams);
                        }
                        if (!fetchResponse.isNextNonSpace(')')) {
                            throw new ParsingException("BODYSTRUCTURE parse error: missing ``)'' at end of disposition");
                        }
                    } else if (readByte != 78 && readByte != 110) {
                        throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + RemoteSettings.FORWARD_SLASH_STRING + this.subtype + ": bad single part disposition, b " + ((int) readByte));
                    } else {
                        if (z3) {
                            System.out.println("DEBUG IMAP: disposition NIL");
                        }
                        fetchResponse.skip(2);
                    }
                    if (fetchResponse.isNextNonSpace(')')) {
                        if (z3) {
                            System.out.println("DEBUG IMAP: disposition DONE");
                            return;
                        }
                        return;
                    }
                    if (fetchResponse.peekByte() == 40) {
                        this.language = fetchResponse.readStringList();
                        if (z3) {
                            PrintStream printStream18 = System.out;
                            printStream18.println("DEBUG IMAP: language len " + this.language.length);
                        }
                    } else {
                        String readString2 = fetchResponse.readString();
                        if (readString2 != null) {
                            this.language = new String[]{readString2};
                            if (z3) {
                                PrintStream printStream19 = System.out;
                                printStream19.println("DEBUG IMAP: language " + readString2);
                            }
                        }
                    }
                    while (fetchResponse.readByte() == 32) {
                        a(fetchResponse);
                    }
                    if (f37834f) {
                        System.out.println("DEBUG IMAP: all DONE");
                        return;
                    }
                    return;
                }
                throw new ParsingException("BODYSTRUCTURE parse error: bad ``size'' element");
            } else {
                throw new ParsingException("BODYSTRUCTURE parse error: missing body content");
            }
        }
        throw new ParsingException("BODYSTRUCTURE parse error: missing ``('' at start");
    }

    private void a(Response response) throws ParsingException {
        response.skipSpaces();
        byte peekByte = response.peekByte();
        if (peekByte == 40) {
            response.skip(1);
            do {
                a(response);
            } while (!response.isNextNonSpace(')'));
        } else if (Character.isDigit((char) peekByte)) {
            response.readNumber();
        } else {
            response.readString();
        }
    }

    private ParameterList b(Response response) throws ParsingException {
        response.skipSpaces();
        byte readByte = response.readByte();
        if (readByte == 40) {
            ParameterList parameterList = new ParameterList();
            do {
                String readString = response.readString();
                boolean z3 = f37834f;
                if (z3) {
                    PrintStream printStream = System.out;
                    printStream.println("DEBUG IMAP: parameter name " + readString);
                }
                if (readString != null) {
                    String readString2 = response.readString();
                    if (z3) {
                        PrintStream printStream2 = System.out;
                        printStream2.println("DEBUG IMAP: parameter value " + readString2);
                    }
                    if (readString2 == null) {
                        if (z3) {
                            System.out.println("DEBUG IMAP: NIL parameter value, applying Exchange bug workaround");
                        }
                        readString2 = "";
                    }
                    parameterList.set(readString, readString2);
                } else {
                    throw new ParsingException("BODYSTRUCTURE parse error: " + this.type + RemoteSettings.FORWARD_SLASH_STRING + this.subtype + ": null name in parameter list");
                }
            } while (!response.isNextNonSpace(')'));
            parameterList.combineSegments();
            return parameterList;
        } else if (readByte != 78 && readByte != 110) {
            throw new ParsingException("Parameter list parse error");
        } else {
            if (f37834f) {
                System.out.println("DEBUG IMAP: parameter list NIL");
            }
            response.skip(2);
            return null;
        }
    }

    public boolean isMulti() {
        if (this.f37835a == f37832d) {
            return true;
        }
        return false;
    }

    public boolean isNested() {
        if (this.f37835a == f37833e) {
            return true;
        }
        return false;
    }

    public boolean isSingle() {
        if (this.f37835a == f37831c) {
            return true;
        }
        return false;
    }
}
