/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.logging.Level;
import java.util.logging.Logger;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextPackage.CannotProceed;
import org.omg.CosNaming.NamingContextPackage.NotFound;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;

/**
 *
 * @author Joamila
 * Criado em: 18/04/2016
 * Última atualização em: 18/04/2016
 */
public class PortaoServidor {
    public static void main(String args[]){
        ORB orb = ORB.init(args, null);
        try {
            org.omg.CORBA.Object objPOA = orb.resolve_initial_references("RootPOA");
            POA rootPOA = POAHelper.narrow(objPOA);
            
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            
            PortaoImpl portao = new PortaoImpl();
            org.omg.CORBA.Object objRef = rootPOA.servant_to_reference(portao);
            
            NameComponent[] name = {new NameComponent("Portao", "portaoMuseu")};
            naming.rebind(name, objRef);
            
            rootPOA.the_POAManager().activate();
            System.out.println("Portao servidor pronto...");
            orb.run();
            
        } catch (InvalidName | AdapterInactive | ServantNotActive | WrongPolicy | NotFound | CannotProceed | org.omg.CosNaming.NamingContextPackage.InvalidName ex) {
            Logger.getLogger(PortaoServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
}
