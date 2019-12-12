package smpl.syntax.ast;

import java.util.ArrayList;
import java.util.Iterator;

import smpl.exceptions.SMPLException;

import smpl.syntax.ast.core.Exp;

import smpl.semantics.Visitor;

public class StmtSequence extends Exp {

    ArrayList<Statement> seq;		// sequence of commands

    public StmtSequence() {
	    seq = new ArrayList<>();
    }

    public StmtSequence(Statement s) {
        this();
        seq.add(s);
    }

    public ArrayList<Statement> getSeq() {
	    return seq;
    }

    public StmtSequence add(Statement s) {
        seq.add(s);
        return this;
    }

    public <S, T> T visit(Visitor<S, T> v, S arg) throws SMPLException {
	    return v.visitStmtSequence(this, arg);
    }

    public String toString() {
        Iterator<Statement> iter = seq.iterator();

        String result = "";
        while (iter.hasNext()) {
            result = result + iter.next().toString() + "\n";
        }

        return result;
    }
}

