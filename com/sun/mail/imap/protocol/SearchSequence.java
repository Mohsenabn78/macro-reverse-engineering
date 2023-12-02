package com.sun.mail.imap.protocol;

import com.sun.mail.iap.Argument;
import com.sun.mail.imap.ModifiedSinceTerm;
import com.sun.mail.imap.OlderTerm;
import com.sun.mail.imap.YoungerTerm;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.mail.Flags;
import javax.mail.Message;
import javax.mail.search.AddressTerm;
import javax.mail.search.AndTerm;
import javax.mail.search.BodyTerm;
import javax.mail.search.DateTerm;
import javax.mail.search.FlagTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.FromTerm;
import javax.mail.search.HeaderTerm;
import javax.mail.search.MessageIDTerm;
import javax.mail.search.NotTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.RecipientStringTerm;
import javax.mail.search.RecipientTerm;
import javax.mail.search.SearchException;
import javax.mail.search.SearchTerm;
import javax.mail.search.SentDateTerm;
import javax.mail.search.SizeTerm;
import javax.mail.search.StringTerm;
import javax.mail.search.SubjectTerm;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;

/* loaded from: classes6.dex */
public class SearchSequence {

    /* renamed from: c  reason: collision with root package name */
    private static String[] f37868c = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

    /* renamed from: a  reason: collision with root package name */
    private IMAPProtocol f37869a;

    /* renamed from: b  reason: collision with root package name */
    protected Calendar f37870b = new GregorianCalendar();

    public SearchSequence(IMAPProtocol iMAPProtocol) {
        this.f37869a = iMAPProtocol;
    }

    public static boolean isAscii(SearchTerm searchTerm) {
        if (searchTerm instanceof AndTerm) {
            return isAscii(((AndTerm) searchTerm).getTerms());
        }
        if (searchTerm instanceof OrTerm) {
            return isAscii(((OrTerm) searchTerm).getTerms());
        }
        if (searchTerm instanceof NotTerm) {
            return isAscii(((NotTerm) searchTerm).getTerm());
        }
        if (searchTerm instanceof StringTerm) {
            return isAscii(((StringTerm) searchTerm).getPattern());
        }
        if (searchTerm instanceof AddressTerm) {
            return isAscii(((AddressTerm) searchTerm).getAddress().toString());
        }
        return true;
    }

    protected Argument a(AndTerm andTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = andTerm.getTerms();
        Argument generateSequence = generateSequence(terms[0], str);
        for (int i4 = 1; i4 < terms.length; i4++) {
            generateSequence.append(generateSequence(terms[i4], str));
        }
        return generateSequence;
    }

    protected Argument b(BodyTerm bodyTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("BODY");
        argument.writeString(bodyTerm.getPattern(), str);
        return argument;
    }

    protected Argument c(FlagTerm flagTerm) throws SearchException {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        boolean testSet = flagTerm.getTestSet();
        Argument argument = new Argument();
        Flags flags = flagTerm.getFlags();
        Flags.Flag[] systemFlags = flags.getSystemFlags();
        String[] userFlags = flags.getUserFlags();
        if (systemFlags.length == 0 && userFlags.length == 0) {
            throw new SearchException("Invalid FlagTerm");
        }
        for (Flags.Flag flag : systemFlags) {
            if (flag == Flags.Flag.DELETED) {
                if (testSet) {
                    str7 = "DELETED";
                } else {
                    str7 = "UNDELETED";
                }
                argument.writeAtom(str7);
            } else if (flag == Flags.Flag.ANSWERED) {
                if (testSet) {
                    str6 = "ANSWERED";
                } else {
                    str6 = "UNANSWERED";
                }
                argument.writeAtom(str6);
            } else if (flag == Flags.Flag.DRAFT) {
                if (testSet) {
                    str5 = "DRAFT";
                } else {
                    str5 = "UNDRAFT";
                }
                argument.writeAtom(str5);
            } else if (flag == Flags.Flag.FLAGGED) {
                if (testSet) {
                    str4 = "FLAGGED";
                } else {
                    str4 = "UNFLAGGED";
                }
                argument.writeAtom(str4);
            } else if (flag == Flags.Flag.RECENT) {
                if (testSet) {
                    str3 = "RECENT";
                } else {
                    str3 = "OLD";
                }
                argument.writeAtom(str3);
            } else if (flag == Flags.Flag.SEEN) {
                if (testSet) {
                    str2 = "SEEN";
                } else {
                    str2 = "UNSEEN";
                }
                argument.writeAtom(str2);
            }
        }
        for (String str8 : userFlags) {
            if (testSet) {
                str = "KEYWORD";
            } else {
                str = "UNKEYWORD";
            }
            argument.writeAtom(str);
            argument.writeAtom(str8);
        }
        return argument;
    }

    protected Argument d(String str, String str2) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("FROM");
        argument.writeString(str, str2);
        return argument;
    }

    protected Argument e(HeaderTerm headerTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("HEADER");
        argument.writeString(headerTerm.getHeaderName());
        argument.writeString(headerTerm.getPattern(), str);
        return argument;
    }

    protected Argument f(MessageIDTerm messageIDTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("HEADER");
        argument.writeString("Message-ID");
        argument.writeString(messageIDTerm.getPattern(), str);
        return argument;
    }

    protected Argument g(ModifiedSinceTerm modifiedSinceTerm) throws SearchException {
        IMAPProtocol iMAPProtocol = this.f37869a;
        if (iMAPProtocol != null && !iMAPProtocol.hasCapability("CONDSTORE")) {
            throw new SearchException("Server doesn't support MODSEQ searches");
        }
        Argument argument = new Argument();
        argument.writeAtom("MODSEQ");
        argument.writeNumber(modifiedSinceTerm.getModSeq());
        return argument;
    }

    public Argument generateSequence(SearchTerm searchTerm, String str) throws SearchException, IOException {
        if (searchTerm instanceof AndTerm) {
            return a((AndTerm) searchTerm, str);
        }
        if (searchTerm instanceof OrTerm) {
            return j((OrTerm) searchTerm, str);
        }
        if (searchTerm instanceof NotTerm) {
            return h((NotTerm) searchTerm, str);
        }
        if (searchTerm instanceof HeaderTerm) {
            return e((HeaderTerm) searchTerm, str);
        }
        if (searchTerm instanceof FlagTerm) {
            return c((FlagTerm) searchTerm);
        }
        if (searchTerm instanceof FromTerm) {
            return d(((FromTerm) searchTerm).getAddress().toString(), str);
        }
        if (searchTerm instanceof FromStringTerm) {
            return d(((FromStringTerm) searchTerm).getPattern(), str);
        }
        if (searchTerm instanceof RecipientTerm) {
            RecipientTerm recipientTerm = (RecipientTerm) searchTerm;
            return l(recipientTerm.getRecipientType(), recipientTerm.getAddress().toString(), str);
        } else if (searchTerm instanceof RecipientStringTerm) {
            RecipientStringTerm recipientStringTerm = (RecipientStringTerm) searchTerm;
            return l(recipientStringTerm.getRecipientType(), recipientStringTerm.getPattern(), str);
        } else if (searchTerm instanceof SubjectTerm) {
            return o((SubjectTerm) searchTerm, str);
        } else {
            if (searchTerm instanceof BodyTerm) {
                return b((BodyTerm) searchTerm, str);
            }
            if (searchTerm instanceof SizeTerm) {
                return n((SizeTerm) searchTerm);
            }
            if (searchTerm instanceof SentDateTerm) {
                return m((SentDateTerm) searchTerm);
            }
            if (searchTerm instanceof ReceivedDateTerm) {
                return k((ReceivedDateTerm) searchTerm);
            }
            if (searchTerm instanceof OlderTerm) {
                return i((OlderTerm) searchTerm);
            }
            if (searchTerm instanceof YoungerTerm) {
                return q((YoungerTerm) searchTerm);
            }
            if (searchTerm instanceof MessageIDTerm) {
                return f((MessageIDTerm) searchTerm, str);
            }
            if (searchTerm instanceof ModifiedSinceTerm) {
                return g((ModifiedSinceTerm) searchTerm);
            }
            throw new SearchException("Search too complex");
        }
    }

    protected Argument h(NotTerm notTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("NOT");
        SearchTerm term = notTerm.getTerm();
        if (!(term instanceof AndTerm) && !(term instanceof FlagTerm)) {
            argument.append(generateSequence(term, str));
        } else {
            argument.writeArgument(generateSequence(term, str));
        }
        return argument;
    }

    protected Argument i(OlderTerm olderTerm) throws SearchException {
        IMAPProtocol iMAPProtocol = this.f37869a;
        if (iMAPProtocol != null && !iMAPProtocol.hasCapability("WITHIN")) {
            throw new SearchException("Server doesn't support OLDER searches");
        }
        Argument argument = new Argument();
        argument.writeAtom("OLDER");
        argument.writeNumber(olderTerm.getInterval());
        return argument;
    }

    protected Argument j(OrTerm orTerm, String str) throws SearchException, IOException {
        SearchTerm[] terms = orTerm.getTerms();
        if (terms.length > 2) {
            OrTerm orTerm2 = terms[0];
            int i4 = 1;
            while (i4 < terms.length) {
                i4++;
                orTerm2 = new OrTerm(orTerm2, terms[i4]);
            }
            terms = ((OrTerm) orTerm2).getTerms();
        }
        Argument argument = new Argument();
        if (terms.length > 1) {
            argument.writeAtom("OR");
        }
        SearchTerm searchTerm = terms[0];
        if (!(searchTerm instanceof AndTerm) && !(searchTerm instanceof FlagTerm)) {
            argument.append(generateSequence(searchTerm, str));
        } else {
            argument.writeArgument(generateSequence(searchTerm, str));
        }
        if (terms.length > 1) {
            SearchTerm searchTerm2 = terms[1];
            if (!(searchTerm2 instanceof AndTerm) && !(searchTerm2 instanceof FlagTerm)) {
                argument.append(generateSequence(searchTerm2, str));
            } else {
                argument.writeArgument(generateSequence(searchTerm2, str));
            }
        }
        return argument;
    }

    protected Argument k(DateTerm dateTerm) throws SearchException {
        Argument argument = new Argument();
        String p4 = p(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                argument.writeAtom("OR BEFORE " + p4 + " ON " + p4);
                break;
            case 2:
                argument.writeAtom("BEFORE " + p4);
                break;
            case 3:
                argument.writeAtom("ON " + p4);
                break;
            case 4:
                argument.writeAtom("NOT ON " + p4);
                break;
            case 5:
                argument.writeAtom("NOT ON " + p4 + " SINCE " + p4);
                break;
            case 6:
                argument.writeAtom("SINCE " + p4);
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        return argument;
    }

    protected Argument l(Message.RecipientType recipientType, String str, String str2) throws SearchException, IOException {
        Argument argument = new Argument();
        if (recipientType == Message.RecipientType.TO) {
            argument.writeAtom("TO");
        } else if (recipientType == Message.RecipientType.CC) {
            argument.writeAtom("CC");
        } else if (recipientType == Message.RecipientType.BCC) {
            argument.writeAtom("BCC");
        } else {
            throw new SearchException("Illegal Recipient type");
        }
        argument.writeString(str, str2);
        return argument;
    }

    protected Argument m(DateTerm dateTerm) throws SearchException {
        Argument argument = new Argument();
        String p4 = p(dateTerm.getDate());
        switch (dateTerm.getComparison()) {
            case 1:
                argument.writeAtom("OR SENTBEFORE " + p4 + " SENTON " + p4);
                break;
            case 2:
                argument.writeAtom("SENTBEFORE " + p4);
                break;
            case 3:
                argument.writeAtom("SENTON " + p4);
                break;
            case 4:
                argument.writeAtom("NOT SENTON " + p4);
                break;
            case 5:
                argument.writeAtom("NOT SENTON " + p4 + " SENTSINCE " + p4);
                break;
            case 6:
                argument.writeAtom("SENTSINCE " + p4);
                break;
            default:
                throw new SearchException("Cannot handle Date Comparison");
        }
        return argument;
    }

    protected Argument n(SizeTerm sizeTerm) throws SearchException {
        Argument argument = new Argument();
        int comparison = sizeTerm.getComparison();
        if (comparison != 2) {
            if (comparison == 5) {
                argument.writeAtom("LARGER");
            } else {
                throw new SearchException("Cannot handle Comparison");
            }
        } else {
            argument.writeAtom("SMALLER");
        }
        argument.writeNumber(sizeTerm.getNumber());
        return argument;
    }

    protected Argument o(SubjectTerm subjectTerm, String str) throws SearchException, IOException {
        Argument argument = new Argument();
        argument.writeAtom("SUBJECT");
        argument.writeString(subjectTerm.getPattern(), str);
        return argument;
    }

    protected String p(Date date) {
        StringBuilder sb = new StringBuilder();
        this.f37870b.setTime(date);
        sb.append(this.f37870b.get(5));
        sb.append("-");
        sb.append(f37868c[this.f37870b.get(2)]);
        sb.append(SignatureVisitor.SUPER);
        sb.append(this.f37870b.get(1));
        return sb.toString();
    }

    protected Argument q(YoungerTerm youngerTerm) throws SearchException {
        IMAPProtocol iMAPProtocol = this.f37869a;
        if (iMAPProtocol != null && !iMAPProtocol.hasCapability("WITHIN")) {
            throw new SearchException("Server doesn't support YOUNGER searches");
        }
        Argument argument = new Argument();
        argument.writeAtom("YOUNGER");
        argument.writeNumber(youngerTerm.getInterval());
        return argument;
    }

    @Deprecated
    public SearchSequence() {
    }

    public static boolean isAscii(SearchTerm[] searchTermArr) {
        for (SearchTerm searchTerm : searchTermArr) {
            if (!isAscii(searchTerm)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAscii(String str) {
        int length = str.length();
        for (int i4 = 0; i4 < length; i4++) {
            if (str.charAt(i4) > 127) {
                return false;
            }
        }
        return true;
    }
}
