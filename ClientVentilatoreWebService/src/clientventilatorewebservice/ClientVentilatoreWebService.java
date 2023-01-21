/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientventilatorewebservice;

import java.util.Scanner;

/**
 *
 * @author Eugenio
 */
public class ClientVentilatoreWebService {
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Inserire l'id del ventilatore :");
        int id = in.nextInt();
        System.out.println("Inserire giri del ventilatore :");
        int giri = in.nextInt();
        modificaGiri(id, giri);
    }

    private static void modificaGiri(int arg0, int arg1) {
        VentilatoreWebService_Service service = new ejb.VentilatoreWebService_Service();
        VentilatoreWebService port = service.getVentilatoreWebServicePort();
        port.modificaGiri(arg0, arg1);
    }
    
}   
