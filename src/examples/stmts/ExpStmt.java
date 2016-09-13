package examples.stmts;

import semantica.CheckState;
import semantica.State;
import semantica.VarInfo;
import semantica.VarInfo.Tipo;
import examples.Exp;
import examples.Stmt;

public class ExpStmt extends Stmt {
	public final String id;
	public final Exp assigment;
	
	public ExpStmt(String id, Exp assigment) {
		this.id = id;
		this.assigment = assigment;
	}

	@Override
	public String unparse() {
		return id +" = "+ assigment.unparse() +"; ";
	}

	@Override
	public String toString() {
		return "Assignment("+ id +", "+ assigment +")";
	}

	@Override
	public int hashCode() {
		int result = 1;
		result = result * 31 + (this.id == null ? 0 : this.id.hashCode());
		result = result * 31 + (this.assigment == null ? 0 : this.assigment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {	
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		ExpStmt other = (ExpStmt)obj;
		return (this.id == null ? other.id == null : this.id.equals(other.id))
			&& (this.assigment == null ? other.assigment == null : this.assigment.equals(other.assigment));
	}
	
	@Override public State evaluate(State state) throws Exception{
		Object value = assigment.evaluate(state);
		state.create(id, value);
		return state;
	}
	
	@Override public CheckState check(CheckState s) throws Exception{
		//Obtenemos el tipo de la asignación
		Tipo assignType = assigment.check(s);
		s.create(id, assignType, true);
		return s;
	}
}
