package business.controller.CORBA;

/**
* ergebnissdaten/Ergebniss/ergebnissbereitstellungHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ergebnisse.idl
* Montag, 19. November 2012 17:06 Uhr MEZ
*/

public final class ergebnissbereitstellungHolder implements org.omg.CORBA.portable.Streamable
{
  public ergebnissbereitstellung value = null;

  public ergebnissbereitstellungHolder ()
  {
  }

  public ergebnissbereitstellungHolder (ergebnissbereitstellung initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ergebnissbereitstellungHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
      ergebnissbereitstellungHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return business.controller.CORBA.ergebnissbereitstellungHelper.type ();
  }

}
