
package classes;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class MetodoTextos extends PlainDocument{
    

    public enum TipoEntrada {
        numerointeiro, numerodecimal, nome, titulo, data, endereco;
    };
    
    private int qtdCaractere;
    private TipoEntrada tpEntrada;

    public MetodoTextos(int qtdCaractere, TipoEntrada tpEntrada) {
        this.qtdCaractere = qtdCaractere;
        this.tpEntrada = tpEntrada;
    }
    

    public void insertString(int i, String string, AttributeSet a) throws BadLocationException {
    
        if (string == null || getLength() == qtdCaractere) {
        return;
        }
        int totalCarac = getLength() + string.length();
        
        String regex = "";
        switch (tpEntrada) {
            case numerointeiro: regex = "[^0-9]"; break;
            case numerodecimal: regex = "[^0-9,.]"; break;
            case nome: regex = "[^\\p{IsLatin} ]"; break;
            case titulo: regex = "[^\\p{IsLatin}@.\\-_][^0-9]"; break;
            case data: regex = "[^0-9/]"; break;
            case endereco: regex = "[^\\p{IsLatin} ][^0-9]"; break;
        }
        string = string.replaceAll(regex, "");
        
        if (totalCarac <= qtdCaractere) {
        super.insertString(i, string, a);
        }else {
            String nova = string.substring(0, qtdCaractere);
            super.insertString(i, nova, a);
        }
    }
     
}

	

