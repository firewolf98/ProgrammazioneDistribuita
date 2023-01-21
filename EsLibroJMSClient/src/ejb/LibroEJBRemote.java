/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Eugenio
 */
@Remote
public interface LibroEJBRemote {
    public Book createBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(Book book);
    public Book searchById(int id);
    public List<Book> searchAllBook();

}
