package examples.stmts;

import semantica.CheckState;
import semantica.State;
import semantica.VarInfo.Tipo;
import examples.Exp;
import examples.Stmt;

public class Length extends Stmt{
	
	private Exp expresion;
	
	public Length(Exp expresion) {
		this.expresion = expresion;
	}

	@Override
	public String unparse() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public State evaluate(State state) throws Exception{
		Object value = expresion.evaluate(state);
		
		if(value instanceof String)
			System.out.println(((String) value).length());
		else
			System.out.println("Wrong type.");
		
		return state;
	}

	@Override
	public CheckState check(CheckState s) throws Exception{
		//Obtenemos el tipo de la expresi�n.
		Tipo typeExpresion = expresion.check(s);
		
		if(typeExpresion == Tipo.Cadena)
			return s;
		else
			s.errores.add("El tipo del Lengh no es el esperado, este es " + typeExpresion);
			return s;//Asumo que es Cadena.
	}
}