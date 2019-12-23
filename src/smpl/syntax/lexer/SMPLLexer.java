/* The following code was generated by JFlex 1.7.0 */

package smpl.syntax.lexer;

/* Specification for SMPL tokens */

// user customisations
import java_cup.runtime.*;

import smpl.exceptions.TokenException;

import smpl.syntax.parser.sym;

// Jlex directives
    

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>src/smpl/syntax/lexer/SMPLLexer</tt>
 */
public class SMPLLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int STRING = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1, 1
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\10\0\1\2\1\3\1\1\1\63\1\3\1\11\22\0\1\3\1\26"+
    "\1\62\1\7\1\0\1\16\1\20\1\10\1\41\1\42\1\13\1\14"+
    "\1\46\1\15\1\61\1\12\2\5\10\4\1\36\1\45\1\25\1\23"+
    "\1\24\1\0\1\35\32\6\1\37\1\64\1\40\1\17\1\0\1\0"+
    "\1\27\1\57\1\53\1\31\1\47\1\50\1\6\1\55\1\54\2\6"+
    "\1\51\1\6\1\30\1\32\1\52\1\6\1\33\1\56\1\34\1\65"+
    "\2\6\1\60\2\6\1\43\1\21\1\44\1\22\6\0\1\63\32\0"+
    "\1\63\u15df\0\1\63\u097f\0\13\63\35\0\2\63\5\0\1\63\57\0"+
    "\1\63\u0fa0\0\1\63\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\ud00f\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\1\2\2\3\1\4\2\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17"+
    "\1\20\1\21\7\1\1\22\1\23\1\24\1\25\1\26"+
    "\1\27\1\30\1\31\1\32\1\33\6\1\1\34\1\35"+
    "\1\36\1\37\1\40\1\41\1\42\4\0\2\1\1\43"+
    "\1\44\1\45\3\1\1\46\2\1\1\47\4\1\1\50"+
    "\1\51\1\52\1\53\2\54\1\55\1\56\1\0\3\57"+
    "\1\0\1\1\1\60\1\61\1\62\3\1\1\63\4\1"+
    "\1\64\1\65\1\66\2\0\1\67\1\70\1\71\1\72"+
    "\1\1\1\73\1\74\1\0\1\1\1\75\1\76\2\1"+
    "\1\77\1\100";

  private static int [] zzUnpackAction() {
    int [] result = new int[116];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\66\0\154\0\242\0\154\0\242\0\330\0\u010e"+
    "\0\242\0\u0144\0\154\0\154\0\154\0\154\0\154\0\154"+
    "\0\154\0\154\0\154\0\u017a\0\u01b0\0\u01e6\0\u021c\0\u0252"+
    "\0\u0288\0\u02be\0\u02f4\0\u032a\0\154\0\u0360\0\242\0\242"+
    "\0\242\0\242\0\242\0\242\0\242\0\242\0\u0396\0\u03cc"+
    "\0\u0402\0\u0438\0\u046e\0\u04a4\0\242\0\242\0\242\0\u04da"+
    "\0\u04a4\0\242\0\242\0\u0510\0\u0546\0\u057c\0\u05b2\0\u05e8"+
    "\0\u061e\0\154\0\154\0\154\0\u0654\0\u068a\0\u06c0\0\154"+
    "\0\u06f6\0\u072c\0\242\0\u0762\0\u0798\0\u07ce\0\u0804\0\154"+
    "\0\242\0\242\0\242\0\242\0\u083a\0\u0546\0\u057c\0\u0870"+
    "\0\242\0\u08a6\0\u08dc\0\u0912\0\u0948\0\154\0\154\0\154"+
    "\0\u097e\0\u09b4\0\u09ea\0\154\0\u0a20\0\u0a56\0\u0a8c\0\u0ac2"+
    "\0\242\0\242\0\242\0\u0af8\0\u0b2e\0\u0b64\0\154\0\154"+
    "\0\154\0\u0b9a\0\154\0\154\0\u0bd0\0\u0c06\0\u0c3c\0\242"+
    "\0\u0c72\0\u0ca8\0\154\0\154";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[116];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\1\4\1\5\1\6\2\7\1\3\1\10\1\11"+
    "\1\4\1\12\1\13\1\14\1\15\1\16\1\17\1\20"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\27\1\30"+
    "\1\31\1\32\1\33\1\34\1\35\1\36\1\37\1\40"+
    "\1\41\1\42\1\43\1\44\1\45\1\46\1\47\1\3"+
    "\1\50\1\51\1\52\1\53\4\3\1\54\1\55\1\11"+
    "\2\3\1\56\1\0\7\56\1\0\50\56\1\57\1\56"+
    "\1\60\1\56\1\3\1\0\1\3\1\0\4\3\2\0"+
    "\24\3\11\0\13\3\2\0\2\3\66\0\1\3\1\0"+
    "\1\3\1\0\2\7\2\3\2\0\24\3\11\0\12\3"+
    "\1\61\2\0\2\3\34\0\1\62\12\0\1\63\1\62"+
    "\2\0\1\64\3\0\1\65\1\66\4\0\1\67\1\3"+
    "\1\0\1\3\1\0\4\3\2\0\1\70\1\71\22\3"+
    "\11\0\13\3\2\0\3\3\1\0\1\3\1\0\4\3"+
    "\2\0\11\3\1\72\12\3\11\0\13\3\2\0\3\3"+
    "\1\0\1\3\1\0\4\3\2\0\11\3\1\73\12\3"+
    "\11\0\13\3\2\0\3\3\1\0\1\3\1\0\4\3"+
    "\2\0\11\3\1\74\12\3\11\0\13\3\2\0\3\3"+
    "\1\0\1\3\1\0\4\3\2\0\16\3\1\75\5\3"+
    "\11\0\13\3\2\0\3\3\1\0\1\3\1\0\4\3"+
    "\2\0\20\3\1\76\3\3\11\0\13\3\2\0\3\3"+
    "\1\0\1\3\1\0\4\3\2\0\24\3\11\0\1\77"+
    "\12\3\2\0\3\3\1\0\1\3\1\0\4\3\2\0"+
    "\21\3\1\100\2\3\11\0\13\3\2\0\3\3\1\0"+
    "\1\3\1\0\4\3\2\0\24\3\11\0\1\101\12\3"+
    "\2\0\3\3\1\0\1\3\1\0\4\3\2\0\24\3"+
    "\11\0\6\3\1\102\4\3\2\0\2\3\23\0\1\103"+
    "\42\0\1\3\1\0\1\3\1\0\4\3\2\0\24\3"+
    "\11\0\2\3\1\104\10\3\2\0\3\3\1\0\1\3"+
    "\1\0\4\3\2\0\24\3\11\0\1\105\12\3\2\0"+
    "\3\3\1\0\1\3\1\0\4\3\2\0\21\3\1\106"+
    "\2\3\11\0\13\3\2\0\3\3\1\0\1\3\1\0"+
    "\4\3\2\0\15\3\1\107\6\3\11\0\13\3\2\0"+
    "\3\3\1\0\1\3\1\0\4\3\2\0\24\3\11\0"+
    "\1\3\1\110\11\3\2\0\3\3\1\0\1\3\1\0"+
    "\2\61\2\3\2\0\24\3\11\0\13\3\2\0\2\3"+
    "\30\0\1\111\3\0\1\112\25\0\1\113\3\0\1\114"+
    "\1\0\1\114\1\0\5\114\1\0\51\114\1\0\1\115"+
    "\1\114\5\0\1\116\64\0\3\117\20\0\6\117\12\0"+
    "\12\117\4\0\1\117\4\0\3\120\20\0\6\120\12\0"+
    "\12\120\4\0\1\120\1\70\1\121\1\70\1\122\4\70"+
    "\1\122\1\123\24\70\11\122\13\70\2\122\2\70\1\71"+
    "\1\124\1\71\1\124\4\71\2\124\1\71\1\125\22\71"+
    "\11\124\13\71\2\124\2\71\1\3\1\0\1\3\1\0"+
    "\4\3\2\0\17\3\1\126\4\3\11\0\13\3\2\0"+
    "\3\3\1\0\1\3\1\0\4\3\2\0\22\3\1\127"+
    "\1\3\11\0\13\3\2\0\3\3\1\0\1\3\1\0"+
    "\4\3\2\0\24\3\11\0\1\3\1\130\11\3\2\0"+
    "\3\3\1\0\1\3\1\0\4\3\2\0\15\3\1\131"+
    "\6\3\11\0\13\3\2\0\3\3\1\0\1\3\1\0"+
    "\4\3\2\0\24\3\11\0\1\132\12\3\2\0\3\3"+
    "\1\0\1\3\1\0\4\3\2\0\24\3\11\0\7\3"+
    "\1\133\3\3\2\0\3\3\1\0\1\3\1\0\4\3"+
    "\2\0\22\3\1\134\1\3\11\0\13\3\2\0\3\3"+
    "\1\0\1\3\1\0\4\3\2\0\20\3\1\135\3\3"+
    "\11\0\5\3\1\136\5\3\2\0\3\3\1\0\1\3"+
    "\1\0\4\3\2\0\24\3\11\0\2\3\1\137\4\3"+
    "\1\140\3\3\2\0\2\3\30\0\1\141\3\0\1\142"+
    "\27\0\1\143\5\0\3\144\20\0\6\144\12\0\12\144"+
    "\4\0\1\144\1\122\1\121\7\122\1\123\54\122\1\0"+
    "\1\121\64\0\13\124\1\145\52\124\1\71\1\124\1\71"+
    "\1\124\4\71\2\124\1\3\1\125\22\71\11\124\13\71"+
    "\2\124\2\71\1\3\1\0\1\3\1\0\4\3\2\0"+
    "\17\3\1\146\4\3\11\0\13\3\2\0\3\3\1\0"+
    "\1\3\1\0\4\3\2\0\16\3\1\147\5\3\11\0"+
    "\13\3\2\0\3\3\1\0\1\3\1\0\4\3\2\0"+
    "\24\3\11\0\1\150\12\3\2\0\3\3\1\0\1\3"+
    "\1\0\4\3\2\0\24\3\11\0\4\3\1\151\6\3"+
    "\2\0\3\3\1\0\1\3\1\0\4\3\2\0\16\3"+
    "\1\152\5\3\11\0\13\3\2\0\3\3\1\0\1\3"+
    "\1\0\4\3\2\0\24\3\11\0\2\3\1\153\10\3"+
    "\2\0\3\3\1\0\1\3\1\0\4\3\2\0\24\3"+
    "\11\0\1\154\12\3\2\0\2\3\4\0\3\155\20\0"+
    "\6\155\12\0\12\155\4\0\1\155\12\124\1\121\1\145"+
    "\52\124\1\3\1\0\1\3\1\0\4\3\2\0\24\3"+
    "\11\0\5\3\1\156\5\3\2\0\3\3\1\0\1\3"+
    "\1\0\4\3\2\0\22\3\1\157\1\3\11\0\13\3"+
    "\2\0\2\3\4\0\3\160\20\0\6\160\12\0\12\160"+
    "\4\0\1\160\1\3\1\0\1\3\1\0\4\3\2\0"+
    "\16\3\1\161\5\3\11\0\13\3\2\0\3\3\1\0"+
    "\1\3\1\0\4\3\2\0\24\3\11\0\2\3\1\162"+
    "\10\3\2\0\3\3\1\0\1\3\1\0\4\3\2\0"+
    "\22\3\1\163\1\3\11\0\13\3\2\0\3\3\1\0"+
    "\1\3\1\0\4\3\2\0\16\3\1\164\5\3\11\0"+
    "\13\3\2\0\2\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[3294];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\1\1\1\11\1\1\1\11\2\1\1\11\25\1"+
    "\10\11\6\1\3\11\2\1\2\11\4\0\13\1\1\11"+
    "\5\1\4\11\3\1\1\0\1\11\2\1\1\0\14\1"+
    "\3\11\2\0\7\1\1\0\2\1\1\11\4\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[116];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
    StringBuffer string = new StringBuffer();

    public int getChar() {
	    return yychar + 1;
    }

    public int getColumn() {
    	return yycolumn + 1;
    }

    public int getLine() {
	    return yyline + 1;
    }

    public String getText() {
	    return yytext();
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public SMPLLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 200) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, TokenException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
          { 	return new Symbol(sym.EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { // IDENTIFIER
    return new Symbol(sym.ID, yytext());
            } 
            // fall through
          case 65: break;
          case 2: 
            { //skip newline, but reset char counter
    yychar = 0;
            } 
            // fall through
          case 66: break;
          case 3: 
            { /* skip whitespace */
            } 
            // fall through
          case 67: break;
          case 4: 
            { // INTEGER
    return new Symbol(sym.INT, 
            new Integer(yytext()));
            } 
            // fall through
          case 68: break;
          case 5: 
            { String msg = String.format("Unrecognised Token: %s", yytext());
    throw new TokenException(msg);
            } 
            // fall through
          case 69: break;
          case 6: 
            { return new Symbol(sym.DIV);
            } 
            // fall through
          case 70: break;
          case 7: 
            { return new Symbol(sym.MUL);
            } 
            // fall through
          case 71: break;
          case 8: 
            { return new Symbol(sym.PLUS);
            } 
            // fall through
          case 72: break;
          case 9: 
            { return new Symbol(sym.MINUS);
            } 
            // fall through
          case 73: break;
          case 10: 
            { return new Symbol(sym.MOD);
            } 
            // fall through
          case 74: break;
          case 11: 
            { return new Symbol(sym.POW);
            } 
            // fall through
          case 75: break;
          case 12: 
            { return new Symbol(sym.BAND);
            } 
            // fall through
          case 76: break;
          case 13: 
            { return new Symbol(sym.BOR);
            } 
            // fall through
          case 77: break;
          case 14: 
            { return new Symbol(sym.BNOT);
            } 
            // fall through
          case 78: break;
          case 15: 
            { return new Symbol(sym.EQ);
            } 
            // fall through
          case 79: break;
          case 16: 
            { return new Symbol(sym.GT);
            } 
            // fall through
          case 80: break;
          case 17: 
            { return new Symbol(sym.LT);
            } 
            // fall through
          case 81: break;
          case 18: 
            { return new Symbol(sym.CONCAT);
            } 
            // fall through
          case 82: break;
          case 19: 
            { return new Symbol(sym.COLON);
            } 
            // fall through
          case 83: break;
          case 20: 
            { return new Symbol(sym.LBRACKET);
            } 
            // fall through
          case 84: break;
          case 21: 
            { return new Symbol(sym.RBRACKET);
            } 
            // fall through
          case 85: break;
          case 22: 
            { return new Symbol(sym.LPAREN);
            } 
            // fall through
          case 86: break;
          case 23: 
            { return new Symbol(sym.RPAREN);
            } 
            // fall through
          case 87: break;
          case 24: 
            { return new Symbol(sym.LBRACE);
            } 
            // fall through
          case 88: break;
          case 25: 
            { return new Symbol(sym.RBRACE);
            } 
            // fall through
          case 89: break;
          case 26: 
            { return new Symbol(sym.SEMI);
            } 
            // fall through
          case 90: break;
          case 27: 
            { return new Symbol(sym.COMMA);
            } 
            // fall through
          case 91: break;
          case 28: 
            { // STRING
    string.setLength(0); yybegin(STRING);
            } 
            // fall through
          case 92: break;
          case 29: 
            { string.append(yytext());
            } 
            // fall through
          case 93: break;
          case 30: 
            { yybegin(YYINITIAL);
                        return new Symbol(sym.STRING,
                        string.toString());
            } 
            // fall through
          case 94: break;
          case 31: 
            { string.append('\\');
            } 
            // fall through
          case 95: break;
          case 32: 
            { // DOUBLE
    return new Symbol(sym.DOUBLE,
            new Double(yytext()));
            } 
            // fall through
          case 96: break;
          case 33: 
            { // BOOLEAN
    // get the letter after the # sign
    char val = yycharat(1);
    if (val == 't') {
        return new Symbol(sym.BOOLEAN,
            new Boolean(true));
    }
    return new Symbol(sym.BOOLEAN,
        new Boolean(false));
            } 
            // fall through
          case 97: break;
          case 34: 
            { return new Symbol(sym.NIL);
            } 
            // fall through
          case 98: break;
          case 35: 
            { return new Symbol(sym.GTEQ);
            } 
            // fall through
          case 99: break;
          case 36: 
            { return new Symbol(sym.LTEQ);
            } 
            // fall through
          case 100: break;
          case 37: 
            { return new Symbol(sym.NEQ);
            } 
            // fall through
          case 101: break;
          case 38: 
            { return new Symbol(sym.OR);
            } 
            // fall through
          case 102: break;
          case 39: 
            { return new Symbol(sym.ASSIGN);
            } 
            // fall through
          case 103: break;
          case 40: 
            { return new Symbol(sym.IF);
            } 
            // fall through
          case 104: break;
          case 41: 
            { string.append('\n');
            } 
            // fall through
          case 105: break;
          case 42: 
            { string.append('\t');
            } 
            // fall through
          case 106: break;
          case 43: 
            { string.append('\"');
            } 
            // fall through
          case 107: break;
          case 44: 
            { // CHARACTER
    char val = yycharat(2);
    return new Symbol(sym.CHARACTER, 
        new Character(val));
            } 
            // fall through
          case 108: break;
          case 45: 
            { // BINARY
    String val = yytext().substring(2);
    return new Symbol(sym.INT,
        Integer.parseInt(val, 2));
            } 
            // fall through
          case 109: break;
          case 46: 
            { // HEXADECIMAL
    String val = yytext().substring(2);
    return new Symbol(sym.INT,
        Integer.parseInt(val, 16));
            } 
            // fall through
          case 110: break;
          case 47: 
            { /* Ignore any comments */
            } 
            // fall through
          case 111: break;
          case 48: 
            { return new Symbol(sym.AND);
            } 
            // fall through
          case 112: break;
          case 49: 
            { return new Symbol(sym.NOT);
            } 
            // fall through
          case 113: break;
          case 50: 
            { return new Symbol(sym.DEF);
            } 
            // fall through
          case 114: break;
          case 51: 
            { return new Symbol(sym.LET);
            } 
            // fall through
          case 115: break;
          case 52: 
            { // ESCAPED CHARACTER \n
    return new Symbol(sym.CHARACTER, 
        new Character('\n'));
            } 
            // fall through
          case 116: break;
          case 53: 
            { // ESCAPED CHARACTER \t
    return new Symbol(sym.CHARACTER, 
        new Character('\t'));
            } 
            // fall through
          case 117: break;
          case 54: 
            { // ESCAPED CHARACTER \
    return new Symbol(sym.CHARACTER, 
        new Character('\\'));
            } 
            // fall through
          case 118: break;
          case 55: 
            { return new Symbol(sym.READ);
            } 
            // fall through
          case 119: break;
          case 56: 
            { return new Symbol(sym.THEN);
            } 
            // fall through
          case 120: break;
          case 57: 
            { return new Symbol(sym.ELSE);
            } 
            // fall through
          case 121: break;
          case 58: 
            { return new Symbol(sym.PROC);
            } 
            // fall through
          case 122: break;
          case 59: 
            { return new Symbol(sym.CALL);
            } 
            // fall through
          case 123: break;
          case 60: 
            { return new Symbol(sym.CASE);
            } 
            // fall through
          case 124: break;
          case 61: 
            { return new Symbol(sym.PRINT);
            } 
            // fall through
          case 125: break;
          case 62: 
            { // UNICODE CHARACTER
    String val = yytext().substring(2);
    int ch = Integer.parseInt(val, 16);
    return new Symbol(sym.CHARACTER,
        new Character((char) ch));
            } 
            // fall through
          case 126: break;
          case 63: 
            { return new Symbol(sym.READINT);
            } 
            // fall through
          case 127: break;
          case 64: 
            { return new Symbol(sym.PRINTLN);
            } 
            // fall through
          case 128: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
