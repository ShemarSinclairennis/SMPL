package smpl.semantics;

import smpl.builtin.ExpCreateList;
import smpl.builtin.ExpCreatePair;
import smpl.builtin.ExpGetSize;
import smpl.builtin.ExpIsEqual;
import smpl.builtin.ExpIsEqv;
import smpl.builtin.ExpIsPair;
import smpl.builtin.ExpPairCAR;
import smpl.builtin.ExpPairCDR;
import smpl.builtin.ExpSubstring;
import smpl.exceptions.SMPLException;

import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.Statement;
import smpl.syntax.ast.StmtSequence;
import smpl.syntax.ast.StmtDefinition;
import smpl.syntax.ast.MultiExp;
import smpl.syntax.ast.ExpProcedure;
import smpl.syntax.ast.ExpRead;
import smpl.syntax.ast.ExpReadInt;
import smpl.syntax.ast.ExpLit;
import smpl.syntax.ast.ExpId;
import smpl.syntax.ast.ExpIndexVector;
import smpl.syntax.ast.ExpLT;
import smpl.syntax.ast.ExpLTEQ;
import smpl.syntax.ast.ExpList;
import smpl.syntax.ast.ExpAdd;
import smpl.syntax.ast.ExpAnd;
import smpl.syntax.ast.ExpBAND;
import smpl.syntax.ast.ExpBNOT;
import smpl.syntax.ast.ExpBOR;
import smpl.syntax.ast.ExpCall;
import smpl.syntax.ast.ExpSub;
import smpl.syntax.ast.ExpMul;
import smpl.syntax.ast.ExpNEQ;
import smpl.syntax.ast.ExpNot;
import smpl.syntax.ast.ExpOr;
import smpl.syntax.ast.ExpDiv;
import smpl.syntax.ast.ExpEQ;
import smpl.syntax.ast.ExpGT;
import smpl.syntax.ast.ExpGTEQ;
import smpl.syntax.ast.ExpMod;
import smpl.syntax.ast.ExpPow;
import smpl.syntax.ast.ExpPrint;
import smpl.syntax.ast.ExpPrintLn;
import smpl.syntax.ast.ExpUnary;
import smpl.syntax.ast.ExpVector;

/**
 * The generic Visitor interface for the Arithmetic parser
 * example.
 * @param <S> The type of the information needed by the visitor
 * @param <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T> {

    public S getDefaultState();

    // program
    public T visitSMPLProgram(SMPLProgram p, S arg) throws SMPLException;

    // statements
    public T visitStatement(Statement exp, S arg) throws SMPLException;
    public T visitStmtSequence(StmtSequence exp, S arg) throws SMPLException;
    public T visitStmtDefinition(StmtDefinition sd, S arg) throws SMPLException;
    public T visitProcDefinition(ExpProcedure exp, S arg) throws SMPLException;

    // multi expressions
    public T visitMultiExp(MultiExp exp, S arg) throws SMPLException;

    // proc calls
    public T visitProcCall(ExpCall exp, S arg) throws SMPLException;


    // builtins
    public T visitExpCreatePair(ExpCreatePair exp, S arg) throws SMPLException;
    public T visitExpPairCAR(ExpPairCAR exp, S arg) throws SMPLException;
    public T visitExpPairCDR(ExpPairCDR exp, S arg) throws SMPLException;
    public T visitExpIsPair(ExpIsPair exp, S arg) throws SMPLException;
    public T visitExpCreateList(ExpCreateList exp, S arg) throws SMPLException;
    public T visitExpGetSize(ExpGetSize exp, S arg) throws SMPLException;
    public T visitExpIsEqv(ExpIsEqv exp, S arg) throws SMPLException;
    public T visitExpIsEqual(ExpIsEqual exp, S arg) throws SMPLException;
    public T visitExpSubstring(ExpSubstring exp, S arg) throws SMPLException;

    // i/o expressions
    public T visitExpPrint(ExpPrint exp, S arg) throws SMPLException;
    public T visitExpPrintLn(ExpPrintLn exp, S arg) throws SMPLException;
    public T visitExpRead(ExpRead exp, S arg) throws SMPLException;
    public T visitExpReadInt(ExpReadInt exp, S arg) throws SMPLException;

    // arithmetic expressions
    public T visitExpAdd(ExpAdd exp, S arg) throws SMPLException;
    public T visitExpSub(ExpSub exp, S arg) throws SMPLException;
    public T visitExpMul(ExpMul exp, S arg) throws SMPLException;
    public T visitExpDiv(ExpDiv exp, S arg) throws SMPLException;
    public T visitExpMod(ExpMod exp, S arg) throws SMPLException;
    public T visitExpPow(ExpPow exp, S arg) throws SMPLException;
    public T visitExpUnary(ExpUnary exp, S arg) throws SMPLException;
    
    // logical expressions
    public T visitExpOr(ExpOr exp, S arg) throws SMPLException;
    public T visitExpAnd(ExpAnd exp, S arg) throws SMPLException;
    public T visitExpNot(ExpNot exp, S arg) throws SMPLException;

    // bitwise expressions
    public T visitExpBAND(ExpBAND exp, S arg) throws SMPLException;
    public T visitExpBOR(ExpBOR exp, S arg) throws SMPLException;
    public T visitExpBNOT(ExpBNOT exp, S arg) throws SMPLException;

    // relational expressions
    public T visitExpEQ(ExpEQ exp, S arg) throws SMPLException;
    public T visitExpGT(ExpGT exp, S arg) throws SMPLException;
    public T visitExpGTEQ(ExpGTEQ exp, S arg) throws SMPLException;
    public T visitExpLT(ExpLT exp, S arg) throws SMPLException;
    public T visitExpLTEQ(ExpLTEQ exp, S arg) throws SMPLException;
    public T visitExpNEQ(ExpNEQ exp, S arg) throws SMPLException;

    // data type expressions
    public T visitExpLit(ExpLit exp, S arg) throws SMPLException;
    public T visitExpId(ExpId exp, S arg) throws SMPLException;
    public T visitExpList(ExpList exp, S arg) throws SMPLException;
    public T visitExpVector(ExpVector exp, S arg) throws SMPLException;
    public T visitExpIndexVector(ExpIndexVector exp, S arg) throws SMPLException;
}
