
import javax.swing.JOptionPane;
import livraria.Livro;



public class ProgamaBiblioteca {
      public static void main(String[] args)
    {
        Biblioteca biblio = new Biblioteca();
       
        biblio.setNome(JOptionPane.showInputDialog("Nome da Biblioteca:"));
        biblio.setLocal(JOptionPane.showInputDialog("Localização da Biblioteca:"));
        biblio.criaLivros(Integer.parseInt(
                JOptionPane.showInputDialog("Capacidade de Livros:")));
       
        Livro livro;
        int opcao = 0;
        String opcoes =
          "Biblioteca: "+biblio.getNome()+
          "\nLocalização: "+biblio.getLocal()+
          "\n\n***Opções*** "+
          "\n1. Cadastrar Livro"+
          "\n2. Pesquisar Livro (código)"+
          "\n3. Pesquisar Livro (título)"+
          "\n4. Listar Livros"+
          "\n5. Informações"+
          "\n6. Finalizar"+
          "\n\nSelecione a opção: ";

        while (opcao != 6)
        {
            opcao = Integer.parseInt(JOptionPane.showInputDialog(null,opcoes,
                    "Biblioteca "+biblio.getNome(),JOptionPane.QUESTION_MESSAGE));

            switch(opcao)
            {
              case 1 -> {
                  biblio.incluirLivro(digitarLivro());
                  JOptionPane.showMessageDialog(null, "Livro Cadastrado!\nTotal: "+
                          biblio.getQuantidade()+" livro(s)");
                }
              case 2 -> {
                  livro = biblio.obterLivro(Integer.parseInt(
                          JOptionPane.showInputDialog("Digite código para pesquisar:")));
                  if (livro != null)
                      mostrarLivro(livro,biblio.getNome());
                  else
                      JOptionPane.showMessageDialog(null, "Livro Não Localizado!");
                }
              case 3 -> {
                  livro = biblio.obterLivro(JOptionPane.showInputDialog("Digite Título do Livro para pesquisar:"));
                  if (livro != null)
                      mostrarLivro(livro,biblio.getNome());
                  else
                      JOptionPane.showMessageDialog(null, "Livro Não Localizado!");
                }
              case 4 ->               {
                  StringBuilder lista = new StringBuilder();
                  lista.append("Lista de Livros Cadastrados:\n");
                  for (int i=0;i<biblio.getQuantidade();i++)
                  {
                      livro = biblio.getLivro(i);
                      lista.append(livro.getCodigo()).append(" - ").append(livro.getTitulo()).append(" - ").append(livro.getAutor()).append(" - ").append(livro.getNumPaginas()).append(" pags.\n");
                  }
                  lista.append("Total: ").append(biblio.getQuantidade()).append(" livro(s)");
                  JOptionPane.showMessageDialog(null, lista.toString());
              }
              case 5 -> JOptionPane.showMessageDialog(null, """
                                                            Informa\u00e7\u00f5es da Biblioteca
                                                            Nome da Biblioteca: """+biblio.getNome()+"\n"+
                            "Localização: "+biblio.getLocal()+"\n"+
                            "Capacidade de Livros: "+biblio.getCapacidade()+"\n"+
                            "Existem até o momento\n"+biblio.getQuantidade()+
                            " livro(s) cadastrado(s)");
            }
        }
        System.out.println("Fim do progama");
        System.out.println("Encerrando ");
    }
   
    static Livro digitarLivro()
    {
   
       Livro liv = new Livro();
        liv.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Código do Livro:")));
        liv.setTitulo(JOptionPane.showInputDialog("Título do Livro:"));
        liv.setAutor(JOptionPane.showInputDialog("Autor do Livro:"));
        liv.setISBN(JOptionPane.showInputDialog("Número ISBN do Livro:"));
        liv.setNumPaginas(Integer.parseInt(JOptionPane.showInputDialog("Numero de Páginas do Livro:")));
        liv.setValorCompra(Float.parseFloat(JOptionPane.showInputDialog("Valor de Compra:")));
        return liv;
    }
       
    static void mostrarLivro(Livro x,String bib)
    {
        String texto = """
                       Livro:
                       
                       C\u00f3digo: """+x.getCodigo()+
        "\nTítulo: "+x.getTitulo()+
        "\nAutor: "+x.getAutor()+
        "\nISBN: "+x.getISBN()+
        "\nPáginas: "+x.getNumPaginas()+
        "\nValor: "+x.getValorCompra();
        JOptionPane.showMessageDialog(null, texto, "Biblioteca: "+bib,
                JOptionPane.WARNING_MESSAGE);
    }

}
    

