package smpl.semantics;

import java.util.ArrayList;
import java.util.Iterator;

import smpl.exceptions.VisitException;

import smpl.semantics.Environment;

import smpl.types.SMPLValue;

import smpl.syntax.ast.core.SMPLProgram;
import smpl.syntax.ast.Statement;
import smpl.syntax.ast.StmtSequence;
import smpl.syntax.ast.StmtDefinition;
import smpl.syntax.ast.ExpLit;
import smpl.syntax.ast.ExpVar;
import smpl.syntax.ast.ExpAdd;
import smpl.syntax.ast.ExpSub;
import smpl.syntax.ast.ExpMul;
import smpl.syntax.ast.ExpDiv;
import smpl.syntax.ast.ExpMod;

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
        Environment<SMPLValue<?>> env) throws VisitException {
        result = p.getSeq().visit(this, env);
        return result;
    }

    public SMPLValue<?> visitStatement(Statement s, 
        Environment<SMPLValue<?>> env) throws VisitException {
	    return s.getExp().visit(this, env);
    }

    public SMPLValue<?> visitStmtSequence(StmtSequence sseq, 
        Environment<SMPLValue<?>> env) throws VisitException {
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
        Environment<SMPLValue<?>> env) throws VisitException {
        result = sd.getExp().visit(this, env);
        env.put(sd.getVar(), result);
        return result;
    }

    public SMPLValue<?> visitExpAdd(ExpAdd exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.add(val2);
    }

    public SMPLValue<?> visitExpSub(ExpSub exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.sub(val2);
    }

    public SMPLValue<?> visitExpMul(ExpMul exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
	    SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.mul(val2);
    }

    public SMPLValue<?> visitExpDiv(ExpDiv exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.div(val2);
    }

    public SMPLValue<?> visitExpMod(ExpMod exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
        SMPLValue<?> val1, val2;
        val1 = exp.getExpL().visit(this, env);
        val2 = exp.getExpR().visit(this, env);
        return val1.mod(val2);
    }

    public SMPLValue<?> visitExpLit(ExpLit exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
	    return exp.getVal();
    }

    public SMPLValue<?> visitExpVar(ExpVar exp, 
        Environment<SMPLValue<?>> env) throws VisitException {
        return env.get(exp.getVar());
    }
}
