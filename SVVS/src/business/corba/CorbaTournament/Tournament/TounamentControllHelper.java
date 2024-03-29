package CorbaTournament.Tournament;


/**
* CorbaTournament/Tournament/TounamentControllHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Tournament.idl
* Dienstag, 20. November 2012 16:44 Uhr MEZ
*/

abstract public class TounamentControllHelper
{
  private static String  _id = "IDL:CorbaTournament/Tournament/TounamentControll:1.0";

  public static void insert (org.omg.CORBA.Any a, CorbaTournament.Tournament.TounamentControll that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static CorbaTournament.Tournament.TounamentControll extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (CorbaTournament.Tournament.TounamentControllHelper.id (), "TounamentControll");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static CorbaTournament.Tournament.TounamentControll read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_TounamentControllStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, CorbaTournament.Tournament.TounamentControll value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static CorbaTournament.Tournament.TounamentControll narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaTournament.Tournament.TounamentControll)
      return (CorbaTournament.Tournament.TounamentControll)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaTournament.Tournament._TounamentControllStub stub = new CorbaTournament.Tournament._TounamentControllStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static CorbaTournament.Tournament.TounamentControll unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof CorbaTournament.Tournament.TounamentControll)
      return (CorbaTournament.Tournament.TounamentControll)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      CorbaTournament.Tournament._TounamentControllStub stub = new CorbaTournament.Tournament._TounamentControllStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
