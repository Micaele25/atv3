import java.util.ArrayList;
import java.util.Iterator;

public class Biblical {
    ArrayList<Ebook> ebooks;
    ArrayList<Emprestimo> emprestimos;

    public Biblical() {
        this.ebooks = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarEbook(Ebook ebook) {
        ebooks.add(ebook);
    }

    public void mostrarEbooksDisponiveis() {
        System.out.println("Ebooks disponíveis:");
        for (Ebook ebook : ebooks) {
            if (!ebook.emprestado) {
                ebook.mostrarEbook();
            }
        }
    }

    public void emprestarEbook(int isbn, Usuario usuario) {
        for (Ebook ebook : ebooks) {
            if (ebook.isbn == isbn && !ebook.emprestado) {
                ebook.emprestado = true;
                emprestimos.add(new Emprestimo(ebook, usuario));
                System.out.println("Ebook emprestado com sucesso!");
                return;
            }
        }
        System.out.println("Ebook não encontrado ou já emprestado.");
    }

    public void devolverEbook(int isbn) {
        Iterator<Emprestimo> iterator = emprestimos.iterator();
        while (iterator.hasNext()) {
            Emprestimo emprestimo = iterator.next();
            if (emprestimo.ebook.isbn == isbn) {
                emprestimo.ebook.emprestado = false;
                iterator.remove();
                System.out.println("Ebook devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Ebook não encontrado nos empréstimos.");
    }
}
