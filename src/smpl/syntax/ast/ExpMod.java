package smpl.syntax.ast;

import smpl.exceptions.SMPLException;

import smpl.syntax.ast.core.Exp;

import smpl.semantics.Visitor;

public class ExpMod extends Exp {

    Exp exp1, exp2;

    public ExpMod(Exp e1, Exp e2) {
        exp1 = e1;
        exp2 = e2;
    }
    public Exp getExpL() {
	    return exp1;
    }

    public Exp getExpR() {
	    return exp2;
    }

    public <S, T> T visit(Visitor<S,T> v, S arg) throws SMPLException {
	    return v.visitExpMod(this, arg);
    }

    public String toString() {
	    return exp1.toString() + " % " + exp2.toString();
    }
}

