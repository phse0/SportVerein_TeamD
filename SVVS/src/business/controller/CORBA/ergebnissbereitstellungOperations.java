package business.controller.CORBA;


/**
* ergebnissdaten/Ergebniss/ergebnissbereitstellungOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ergebnisse.idl
* Montag, 19. November 2012 17:06 Uhr MEZ
*/

public interface ergebnissbereitstellungOperations 
{
  String getErgebnisse (String sportart, String liga, String datum);
  boolean sindVollstaendig (String sportart, String liga, String datum);
} // interface ergebnissbereitstellungOperations