package smpl.semantics;

import java.util.ArrayList;
import java.util.Iterator;

import smpl.exceptions.SMPLException;

import smpl.semantics.Environment;

import smpl.types.SMPLValue;
import smpl.types.SMPLProcedure;

import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.Statement;
import smpl.syntax.ast.StmtSequence;
import smpl.syntax.ast.StmtDefinition;
import smpl.syntax.ast.ExpProcedure;
import smpl.syntax.ast.ExpLit;
import smpl.syntax.ast.ExpId;
import smpl.syntax.ast.ExpLT;
import smpl.syntax.ast.ExpLTEQ;
import smpl.syntax.ast.ExpAdd;
import smpl.syntax.ast.ExpAnd;
import smpl.syntax.ast.ExpBAND;
import smpl.syntax.ast.ExpBNOT;
import smpl.syntax.ast.ExpBOR;
import smpl.syntax.ast.ExpSub;
import smpl.syntax.ast.ExpMul;
import smpl.syntax.ast.ExpNEQ;
import smpl.syntax.ast.ExpNot;
import smpl.syntax.ast.ExpOr;
import smpl.syntax.ast.ExpPow;
import smpl.syntax.ast.ExpDiv;
import smpl.syntax.ast.ExpEQ;
import smpl.syntax.ast.ExpGT;
import smpl.syntax.ast.ExpGTEQ;
import smpl.syntax.ast.ExpMod;
import smpl.syntax.ast.ExpUnary;

public class Evaluator implements Visitor<Environment<SMPLValue<?>>, SMPLValue<?>> {
    /* For this visitor, the argument passed to all visit
       methods will be the environment object that used to
       be passed to the eval method in the first style of
       implementation. */

    // allocate state here
    protected SMPLValue<?> result;	// result of evaluation

    public Evaluator() {
        // perform initialisations here
        result = SMPLValue.make(0);
    }

    public Environment getDefaultState() {
	    return Environment.makeGlobalEnv();
    }

    public SMPLValue<?> visitSMPLProgram(SMPLProgram p, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        result = p.getSeq().visit(this, env);
        return result;
    }

    public SMPLValue<?> visitStatement(Statement s, 
        Environment<SMPLValue<?>> env) throws SMPLException {
	    return s.getExp().visit(this, env);
    }

    public SMPLValue<?> visitStmtSequence(StmtSequence sseq, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        // remember that arg is the environment
        Statement s;
        ArrayList<Statement> seq = sseq.getSeq();
        Iterator<Statement> iter = seq.iterator();
        result = SMPLValue.make(0); // default result
        while(iter.hasNext()) {
            s = (Statement) iter.next();
            result = s.visit(this, env);
        }
        // return last value evaluated
        return result;
    }

    public SMPLValue<?> visitStmtDefinition(StmtDefinition sd, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        result = sd.getExp().visit(this, env);
        env.put(sd.getVar(), result);
        return result;
    }

    public SMPLValue<?> visitExpAdd(ExpAdd exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.add(val2);
    }

    public SMPLValue<?> visitExpSub(ExpSub exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.sub(val2);
    }

    public SMPLValue<?> visitExpMul(ExpMul exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
	    SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.mul(val2);
    }

    public SMPLValue<?> visitExpDiv(ExpDiv exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.div(val2);
    }

    public SMPLValue<?> visitExpMod(ExpMod exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.mod(val2);
    }

    public SMPLValue<?> visitExpPow(ExpPow exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.pow(val2);
    }

    public SMPLValue<?> visitExpOr(ExpOr exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.or(val2);
    }

    public SMPLValue<?> visitExpAnd(ExpAnd exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.and(val2);
    }

    public SMPLValue<?> visitExpNot(ExpNot exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1;

        val1 = exp.getExp().visit(this, env);
        return val1.not();
    }

    public SMPLValue<?> visitExpBAND(ExpBAND exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.band(val2);
    }

    public SMPLValue<?> visitExpBOR(ExpBOR exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.bor(val2);
    }

    public SMPLValue<?> visitExpBNOT(ExpBNOT exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1;

        val1 = exp.getExp().visit(this, env);
        return val1.bnot();
    }

    public SMPLValue<?> visitExpEQ(ExpEQ exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.eq(val2);
    }

    public SMPLValue<?> visitExpGT(ExpGT exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.gt(val2);
    }

    public SMPLValue<?> visitExpGTEQ(ExpGTEQ exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.gteq(val2);
    }

    public SMPLValue<?> visitExpLT(ExpLT exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.lt(val2);
    }

    public SMPLValue<?> visitExpLTEQ(ExpLTEQ exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.lteq(val2);
    }

    public SMPLValue<?> visitExpNEQ(ExpNEQ exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val1, val2;

        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.neq(val2);
    }

    public SMPLValue<?> visitExpUnary(ExpUnary exp,
        Environment<SMPLValue<?>> env) throws SMPLException {
        SMPLValue<?> val;
        String sign;

        val = exp.getExp().visit(this, env);
        sign = exp.getSign();
        return val.unary(sign);
    }

    public SMPLValue<?> visitExpLit(ExpLit exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
	    return exp.getVal();
    }

    public SMPLValue<?> visitExpId(ExpId exp, 
        Environment<SMPLValue<?>> env) throws SMPLException {
        return env.get(exp.getId());
    }

    @Override
    public SMPLValue<?> visitProcDefinition(ExpProcedure exp, Environment<SMPLValue<?>> env) throws SMPLException {
        return new SMPLProcedure(exp, env);
    }
}
